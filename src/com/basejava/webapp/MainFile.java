package com.basejava.webapp;

import java.io.File;

public class MainFile {
    private static void listFolder(File pathToFolder) {
        File[] files = pathToFolder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("    - " + file.getName());
                }
                if (file.isDirectory()) {
                    System.out.println(file.getAbsoluteFile());
                    listFolder(file);
                }
            }
        }
    }

    public static void main(String[] args) {
        File root = new File(".");
        listFolder(root);
    }
}