package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected final static int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public final void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (size >= STORAGE_LIMIT) {
            System.out.println("ERROR: Storage is filled!");
        } else if (index >= 0) {
            System.out.println("ERROR: Resume with UUID \"" + r.getUuid() + "\" already exists!");
        } else {
            insertItem(r, index);
            size++;
        }
    }

    public final void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            System.out.println("ERROR: Resume with UUID \"" + r.getUuid() + "\" does not exist!");
        } else {
            storage[index] = r;
        }
    }

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("ERROR: Resume with UUID \"" + uuid + "\" is not found!");
        } else {
            removeItem(index);
            storage[size - 1] = null;
            size--;
            System.out.println("Resume with UUID \"" + uuid + "\" is deleted.");
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("ERROR: Resume with UUID \"" + uuid + "\" is not found!");
            return null;
        } else {
            return storage[index];
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertItem(Resume r, int index);

    protected abstract void removeItem(int index);
}