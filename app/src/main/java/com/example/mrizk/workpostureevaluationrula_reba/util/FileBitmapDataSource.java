package com.example.mrizk.workpostureevaluationrula_reba.util;

import android.content.Context;
import android.graphics.Bitmap;

import com.snatik.storage.Storage;

public class FileBitmapDataSource {

    private final String directoryName;
    private final Storage storage;

    public FileBitmapDataSource(String directoryName, Context context) {
        this.directoryName = directoryName;
        this.storage = new Storage(context);

        createDirectory();
    }

    public void createDirectory() {
        try {
            storage.createDirectory(directoryName);
        } catch (StorageException e) {

        }
    }

    public void writeBitmapToDisk(Bitmap bitmap, String fileName) {
        storage.createFile(directoryName, fileName, bitmap);
    }

    public byte[] getFileFromDisk(String fileName) {
        try {
            return storage.readFile(directoryName, fileName);
        } catch (RuntimeException e) {
            return null;
        }
    }


    public void deleteDirectory() {
        storage.deleteDirectory(directoryName);
    }

    public void deleteFile(String fileName) {
        storage.deleteFile(directoryName, fileName);
    }

}