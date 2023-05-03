package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    List<Resume> storage = new ArrayList<>();

    @Override
    protected boolean isExist(Resume r) {
        return storage.contains(r);
    }

    @Override
    protected void doSave(Resume r) {
        storage.add(r);
    }

    @Override
    protected void doUpdate(Resume r) {
        storage.set(storage.indexOf(r), r);
    }

    @Override
    protected void doDelete(String uuid) {
        storage.remove(new Resume(uuid));
    }

    @Override
    public void clear() {
        storage.clear();
    }

    public int size() {
        return storage.size();
    }

    @Override
    protected Resume doGet(String uuid) {
        return storage.get(storage.indexOf(new Resume(uuid)));
    }

    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }
}