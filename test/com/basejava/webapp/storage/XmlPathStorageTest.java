package com.basejava.webapp.storage;

import com.basejava.webapp.storage.serializer.XmlStreamStrategy;

public class XmlPathStorageTest extends AbstractStorageTest {
    public XmlPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlStreamStrategy()));
    }
}