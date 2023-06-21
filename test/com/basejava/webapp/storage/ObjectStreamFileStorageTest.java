package com.basejava.webapp.storage;

import com.basejava.webapp.storage.serializer.ObjectIOStreamStrategy;

public class ObjectStreamFileStorageTest extends AbstractStorageTest {
    public ObjectStreamFileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectIOStreamStrategy()));
    }
}