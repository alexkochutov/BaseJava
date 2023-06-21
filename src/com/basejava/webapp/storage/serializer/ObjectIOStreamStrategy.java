package com.basejava.webapp.storage.serializer;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.serializer.StorageStrategy;

import java.io.*;

public class ObjectIOStreamStrategy implements StorageStrategy {
    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error: Can't find Resume.class file", null, e);
        }
    }

    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(r);
        }
    }
}