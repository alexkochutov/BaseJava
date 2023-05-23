package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.List;

public interface Storage {
    void save(Resume r);

    void update(Resume r);

    void delete(String uuid);

    void clear();

    int size();

    Resume get(String uuid);

    List<Resume> getAllSorted();
}