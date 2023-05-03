package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public final void save(Resume r) {
        if (isExist(r)) {
            throw new ExistStorageException(r.getUuid());
        }
        doSave(r);
    }

    public final void update(Resume r) {
        checkExist(r);
        doUpdate(r);
    }

    public final void delete(String uuid) {
        Resume r = new Resume(uuid);
        checkExist(r);
        doDelete(uuid);
    }

    public final Resume get(String uuid) {
        checkExist(new Resume(uuid));
        return doGet(uuid);
    }

    protected abstract boolean isExist(Resume r);
    protected abstract void doSave(Resume r);
    protected abstract void doUpdate(Resume r);
    protected abstract void doDelete(String uuid);
    protected abstract Resume doGet(String uuid);

    public abstract void clear();
    public abstract int size();
    public abstract Resume[] getAll();

    private void checkExist(Resume r) {
        if (!isExist(r)) {
            throw new NotExistStorageException(r.getUuid());
        }
    }
}