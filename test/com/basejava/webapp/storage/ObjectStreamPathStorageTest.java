package com.basejava.webapp.storage;

import com.basejava.webapp.storage.serializer.ObjectIOStreamStrategy;

public class ObjectStreamPathStorageTest extends AbstractStorageTest {
    public ObjectStreamPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getPath(), new ObjectIOStreamStrategy()));
    }
}