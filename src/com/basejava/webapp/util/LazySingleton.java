package com.basejava.webapp.util;

public class LazySingleton {
    private static LazySingleton INSTANCE = new LazySingleton();

    private LazySingleton() {}

    // Double check locking
//    public static LazySingleton getInstance() {
//        if (INSTANCE == null) {
//            synchronized (LazySingleton.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = new LazySingleton();
//                }
//            }
//        }
//        return INSTANCE;
//    }

    // Initialization-on-demand holder
    private static class LazySingletonHolder {
        private static final LazySingleton INSTANCE = new LazySingleton();
    }

    public static LazySingleton getInstance() {
        return LazySingletonHolder.INSTANCE;
    }
}