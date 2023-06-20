package com.basejava.webapp;

import java.io.File;

public class MainFile {
    private static void listFolder(File pathToFolder, String offset) {
        File[] files = pathToFolder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(offset + file.getName());
                }
                if (file.isDirectory()) {
                    System.out.println(offset + file.getAbsoluteFile());
                    listFolder(file, offset + "  ");
                }
            }
        }
    }

    public static void main(String[] args) {
        File root = new File("/Users/Alex/Desktop/TopJava/BaseJava");
        listFolder(root, "");
    }
}