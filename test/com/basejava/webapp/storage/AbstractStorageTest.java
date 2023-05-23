package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;
import com.basejava.webapp.exception.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public abstract class AbstractStorageTest {
    protected final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final String NAME_1 = "name1";
    private static final String NAME_2 = "name2";
    private static final String NAME_3 = "name3";
    private static final String NAME_4 = "name4";

    private static final String UUID_NOT_EXIST = "dummy";

    protected static final Resume RESUME_1 = new Resume(UUID_1, NAME_1);
    protected static final Resume RESUME_2 = new Resume(UUID_2, NAME_2);
    protected static final Resume RESUME_3 = new Resume(UUID_3, NAME_3);
    protected static final Resume RESUME_4 = new Resume(UUID_4, NAME_4);

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @After
    public void tearDown() {
        storage.clear();
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertGet(RESUME_4);
        assertSize(4);
    }

    @Test (expected = ExistStorageException.class)
    public void saveExists() {
        storage.save(RESUME_1);
    }

    @Test
    public void update() {
        Resume resume = new Resume(UUID_1, NAME_1);
        storage.update(resume);
        assertGet(resume);
    }

    @Test (expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(RESUME_4);
    }

    @Test (expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        assertSize(2);
        assertGet(RESUME_1);
    }

    @Test (expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_NOT_EXIST);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test (expected = NotExistStorageException.class)
    public void getNotExist() {
        assertGet(RESUME_4);
    }

    @Test
    public void getAllSorted() {
        List<Resume> actual = new ArrayList<>();
        assertSize(3);
        assertEquals(storage.get(UUID_1), RESUME_1);
        assertEquals(storage.get(UUID_2), RESUME_2);
        assertEquals(storage.get(UUID_3), RESUME_3);
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}