package com.facebook.common.file;

import java.io.File;

public class FileTree {
    public static void walkFileTree(File file, FileTreeVisitor fileTreeVisitor) {
        fileTreeVisitor.preVisitDirectory(file);
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    walkFileTree(file2, fileTreeVisitor);
                } else {
                    fileTreeVisitor.visitFile(file2);
                }
            }
        }
        fileTreeVisitor.postVisitDirectory(file);
    }

    public static boolean deleteContents(File file) {
        file = file.listFiles();
        boolean z = true;
        if (file != null) {
            for (File deleteRecursively : file) {
                z &= deleteRecursively(deleteRecursively);
            }
        }
        return z;
    }

    public static boolean deleteRecursively(File file) {
        if (file.isDirectory()) {
            deleteContents(file);
        }
        return file.delete();
    }
}
