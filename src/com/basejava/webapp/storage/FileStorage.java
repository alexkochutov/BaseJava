package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.serializer.StorageStrategy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File> {
    protected File directory;
    protected StorageStrategy storageStrategy;

    public FileStorage(File directory, StorageStrategy storageStrategy) {
        Objects.requireNonNull(directory, "directory MUST NOT be null");
        Objects.requireNonNull(storageStrategy, "StorageStrategy MUST NOT be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Error: " + directory.getAbsolutePath() + " is not a directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException("Error: " + directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
        this.storageStrategy = storageStrategy;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("Error: Can't create new file " + file.getAbsolutePath(), file.getName(), e);
        }
        doUpdate(r, file);
    }

    @Override
    protected void doUpdate(Resume r, File file) {
        try (BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(file))) {
            storageStrategy.doWrite(r, bs);
        } catch (IOException e) {
            throw new StorageException("Error: Can't update file " + file.getAbsolutePath(), file.getName(), e);
        }
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new StorageException("Error: Can't delete file " + file.getAbsolutePath(), file.getName());
        }
    }

    @Override
    protected Resume doGet(File file) {
        try (BufferedInputStream bs = new BufferedInputStream(new FileInputStream(file))) {
           return storageStrategy.doRead(bs);
        } catch (IOException e) {
            throw new StorageException("Error: Can't get resume from file" + file.getAbsolutePath(), file.getName(), e);
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        List<Resume> result = new ArrayList<>(size());
        for (File file : getFilesList()) {
            result.add(doGet(file));
        }
        return result;
    }

    @Override
    public void clear() {
        for (File file : getFilesList()) {
            doDelete(file);
        }
    }

    @Override
    public int size() {
        return getFilesList().length;
    }

    private File[] getFilesList() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Error: Can't get list of files in folder ", directory.getAbsolutePath());
        }
        return files;
    }
}