package com.basejava.webapp.storage.serializer;

import com.basejava.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataStreamStrategy implements StorageStrategy {

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            Resume resume = new Resume(dis.readUTF(), dis.readUTF());
            readCollection(dis, () -> resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF()));
            readCollection(dis, () -> {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                resume.addSection(sectionType, readSection(dis, sectionType));
            });
            return resume;
        }
    }

    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            writeCollection(dos, resume.getContacts().entrySet(), entry -> {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            });
            writeCollection(dos, resume.getSections().entrySet(), entry -> {
                SectionType sectionType = entry.getKey();
                Section section = entry.getValue();
                dos.writeUTF(sectionType.name());
                switch (sectionType) {
                    case PERSONAL:
                    case OBJECTIVE: {
                        dos.writeUTF(section.toString());
                        break;
                    }
                    case ACHIEVEMENTS:
                    case QUALIFICATIONS: {
                        writeCollection(dos, ((ListSection) section).getContent(), dos::writeUTF);
                        break;
                    }
                    case EXPERIENCE:
                    case EDUCATION: {
                        writeCollection(dos, ((OrganizationSection) section).getContent(), organization -> {
                            dos.writeUTF(organization.getName());
                            dos.writeUTF(organization.getWebsite());
                            writeCollection(dos, organization.getList(), period -> {
                                dos.writeUTF(period.getStartDate().toString());
                                dos.writeUTF(period.getEndDate().toString());
                                dos.writeUTF(period.getTitle());
                                dos.writeUTF(period.getDescription());
                            });
                        });
                        break;
                    }
                }
            });
        }
    }

    @FunctionalInterface
    private interface MethodRunner {
        void run() throws  IOException;
    }

    @FunctionalInterface
    private interface EntryReader<E> {
        E read() throws IOException;
    }

    @FunctionalInterface
    private interface EntryWriter<E> {
        void write(E e) throws IOException;
    }

    private void readCollection(DataInputStream dis, MethodRunner runner) throws IOException{
        int size = dis.readInt();
        for (int i = 0; i < size; i++) {
            runner.run();
        }
    }

    private Section readSection(DataInputStream dis, SectionType sectionType) throws IOException {
        switch(sectionType) {
            case PERSONAL:
            case OBJECTIVE: {
                return new StringSection(dis.readUTF());
            }
            case ACHIEVEMENTS:
            case QUALIFICATIONS: {
                return new ListSection(readList(dis, dis::readUTF));
            }
            case EXPERIENCE:
            case EDUCATION: {
                return new OrganizationSection(
                        readList(dis, () -> new Organization(
                                dis.readUTF(), dis.readUTF(), readList(dis, () -> new Period(
                                LocalDate.parse(dis.readUTF()), LocalDate.parse(dis.readUTF()), dis.readUTF(), dis.readUTF()
                        ))))
                );
            }
            default: throw new IllegalStateException();
        }
    }

    private <E> List<E> readList(DataInputStream dis, EntryReader<E> reader) throws IOException {
        int size = dis.readInt();
        List<E> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(reader.read());
        }
        return list;
    }

    private <E> void writeCollection(DataOutputStream dos, Collection<E> collection, EntryWriter<E> writer) throws IOException {
        dos.writeInt(collection.size());
        for (E entry : collection) {
            writer.write(entry);
        }
    }
}