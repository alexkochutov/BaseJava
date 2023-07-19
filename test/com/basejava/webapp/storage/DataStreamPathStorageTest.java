package com.basejava.webapp.storage;

import com.basejava.webapp.storage.serializer.DataStreamStrategy;

public class DataStreamPathStorageTest extends AbstractStorageTest {

    public DataStreamPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new DataStreamStrategy()));
    }
}