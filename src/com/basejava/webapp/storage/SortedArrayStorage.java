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
    protected void insertItem(Resume r, int index) {
        int targetIndex = -index - 1;
        System.arraycopy(storage, targetIndex, storage, targetIndex, size - targetIndex);
        storage[targetIndex] = r;
    }

    @Override
    protected void removeItem(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index);
    }
}