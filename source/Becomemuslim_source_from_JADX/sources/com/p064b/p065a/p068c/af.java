package com.p064b.p065a.p068c;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: Utils */
/* renamed from: com.b.a.c.af */
final class af {
    /* renamed from: a */
    public static void m3492a(File file, FilenameFilter filenameFilter, int i, Comparator<File> comparator) {
        file = file.listFiles(filenameFilter);
        if (file != null && file.length > i) {
            Arrays.sort(file, comparator);
            filenameFilter = file.length;
            comparator = file.length;
            int i2 = 0;
            while (i2 < comparator) {
                File file2 = file[i2];
                if (filenameFilter > i) {
                    file2.delete();
                    filenameFilter--;
                    i2++;
                } else {
                    return;
                }
            }
        }
    }
}
