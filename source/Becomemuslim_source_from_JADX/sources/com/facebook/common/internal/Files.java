package com.facebook.common.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Files {
    private Files() {
    }

    static byte[] readFile(InputStream inputStream, long j) {
        if (j > 2147483647L) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("file is too large to fit in a byte array: ");
            stringBuilder.append(j);
            stringBuilder.append(" bytes");
            throw new OutOfMemoryError(stringBuilder.toString());
        } else if (j == 0) {
            return ByteStreams.toByteArray(inputStream);
        } else {
            return ByteStreams.toByteArray(inputStream, (int) j);
        }
    }

    public static byte[] toByteArray(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                file = readFile(fileInputStream, fileInputStream.getChannel().size());
                fileInputStream.close();
                return file;
            } catch (Throwable th) {
                file = th;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw file;
            }
        } catch (Throwable th2) {
            file = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw file;
        }
    }
}
