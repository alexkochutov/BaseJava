package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class PathStorage extends AbstractStorage<Path> {
    protected Path directory;
    protected StorageStrategy storageStrategy;

    public PathStorage(String storage, StorageStrategy storageStrategy) {
        Objects.requireNonNull(storage, "directory MUST NOT be null");
        Objects.requireNonNull(storageStrategy, "StorageStrategy MUST NOT be null");
        this.directory = Paths.get(storage);
        this.storageStrategy = storageStrategy;
        if (!Files.isDirectory(directory)) {
            throw new IllegalArgumentException("Error: " + directory + " is not a directory");
        }
        if (!Files.isReadable(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException("Error: " + directory + " is not readable/writable");
        }
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected boolean isExist(Path path) {
        return Files.exists(path);
    }

    @Override
    protected void doSave(Resume r, Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("Error: Can't create new file ", path.getFileName().toString(), e);
        }
        doUpdate(r, path);
    }

    @Override
    protected void doUpdate(Resume r, Path path) {
        try (BufferedOutputStream bs = new BufferedOutputStream(Files.newOutputStream(path))) {
            storageStrategy.doWrite(r, bs);
        } catch (IOException e) {
            throw new StorageException("Error: Can't update file ", path.getFileName().toString(), e);
        }
    }

    @Override
    protected void doDelete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("Error: Can't delete file ", path.getFileName().toString(), e);
        }
    }

    @Override
    protected Resume doGet(Path path) {
        try (BufferedInputStream bs = new BufferedInputStream(Files.newInputStream(path))) {
            return storageStrategy.doRead(bs);
        } catch (IOException e) {
            throw new StorageException("Error: Can't get resume from file", path.getFileName().toString(), e);
        }
    }

    @Override
    protected Resume[] doCopyAll() {
        try (Stream<Path> paths = Files.list(directory)) {
            return paths.map(this::doGet).toArray(Resume[]::new);
        } catch (IOException e) {
            throw new StorageException("Error: Can't get list of files in folder ", directory.toString(), e);
        }
    }

    @Override
    public void clear() {
        try (Stream<Path> paths = Files.list(directory)) {
            paths.forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Error: Can't clear folder ", directory.toString(), e);
        }
    }

    @Override
    public int size() {
        try (Stream<Path> paths = Files.list(directory)) {
            return (int) paths.count();
        } catch (IOException e) {
            throw new StorageException("Error: Can't get count of files in folder ", directory.toString(), e);
        }
    }
}