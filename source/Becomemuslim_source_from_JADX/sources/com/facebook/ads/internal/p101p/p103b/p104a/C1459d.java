package com.facebook.ads.internal.p101p.p103b.p104a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.facebook.ads.internal.p.b.a.d */
class C1459d {

    /* renamed from: com.facebook.ads.internal.p.b.a.d$a */
    private static final class C1458a implements Comparator<File> {
        private C1458a() {
        }

        /* renamed from: a */
        private int m5159a(long j, long j2) {
            int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            return i < 0 ? -1 : i == 0 ? 0 : 1;
        }

        /* renamed from: a */
        public int m5160a(File file, File file2) {
            return m5159a(file.lastModified(), file2.lastModified());
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5160a((File) obj, (File) obj2);
        }
    }

    /* renamed from: a */
    static void m5161a(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("File ");
                stringBuilder.append(file);
                stringBuilder.append(" is not directory!");
                throw new IOException(stringBuilder.toString());
            }
        } else if (!file.mkdirs()) {
            throw new IOException(String.format("Directory %s can't be created", new Object[]{file.getAbsolutePath()}));
        }
    }

    /* renamed from: b */
    static List<File> m5162b(File file) {
        List linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new C1458a());
        return asList;
    }

    /* renamed from: c */
    static void m5163c(File file) {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                C1459d.m5164d(file);
                if (file.lastModified() < currentTimeMillis) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Error set last modified date to ");
                    stringBuilder.append(file);
                    throw new IOException(stringBuilder.toString());
                }
            }
        }
    }

    /* renamed from: d */
    static void m5164d(File file) {
        long length = file.length();
        if (length == 0) {
            C1459d.m5165e(file);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        length--;
        randomAccessFile.seek(length);
        byte readByte = randomAccessFile.readByte();
        randomAccessFile.seek(length);
        randomAccessFile.write(readByte);
        randomAccessFile.close();
    }

    /* renamed from: e */
    private static void m5165e(File file) {
        if (!file.delete() || !file.createNewFile()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error recreate zero-size file ");
            stringBuilder.append(file);
            throw new IOException(stringBuilder.toString());
        }
    }
}
