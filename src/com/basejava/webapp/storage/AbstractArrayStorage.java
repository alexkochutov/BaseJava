package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    @Override
    protected boolean isExist(Resume r) {
        return getIndex(r.getUuid()) >= 0;
    }

    @Override
    protected void doSave(Resume r) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage is filled!", r.getUuid());
        }
        insertItem(r, getIndex(r.getUuid()));
        size++;
    }

    @Override
    protected void doUpdate(Resume r) {
        int index = getIndex(r.getUuid());
        storage[index] = r;
    }

    @Override
    protected void doDelete(String uuid) {
        int index = getIndex(uuid);
        removeItem(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    protected Resume doGet(String uuid) {
        int index = getIndex(uuid);
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract int getIndex(String uuid);
    protected abstract void insertItem(Resume r, int index);
    protected abstract void removeItem(int index);
}