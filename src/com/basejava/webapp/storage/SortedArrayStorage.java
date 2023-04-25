package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void insertItem(Resume r) {
        boolean isInserted = false;
        for (int i = 0; i < size; i++) {
            if (r.compareTo(storage[i]) < 0) {
                System.arraycopy(storage, i, storage, i + 1, size - i);
                storage[i] = r;
                isInserted = true;
                break;
            }
        }
        if (!isInserted) {
            storage[size] = r;
        }
    }

    @Override
    protected void removeItem(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index);
    }
}