package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MapStorageTest extends AbstractStorageTest {
    public MapStorageTest() {
        super(new MapStorage());
    }

    @Test
    public void getAll() {
        Resume[] actual = new Resume[] {RESUME_2, RESUME_1, RESUME_3};
        assertArrayEquals(actual, storage.getAll());
    }
}