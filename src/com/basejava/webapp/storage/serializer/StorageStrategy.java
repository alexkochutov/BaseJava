package com.basejava.webapp.storage.serializer;

import com.basejava.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface StorageStrategy {
    Resume doRead(InputStream is) throws IOException;
    void doWrite(Resume r, OutputStream os) throws IOException;
}