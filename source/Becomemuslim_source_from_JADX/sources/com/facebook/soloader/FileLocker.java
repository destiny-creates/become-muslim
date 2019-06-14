package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

public final class FileLocker implements Closeable {
    private final FileLock mLock;
    private final FileOutputStream mLockFileOutputStream;

    public static FileLocker lock(File file) {
        return new FileLocker(file);
    }

    private FileLocker(File file) {
        this.mLockFileOutputStream = new FileOutputStream(file);
        try {
            file = this.mLockFileOutputStream.getChannel().lock();
            if (file == null) {
            }
            this.mLock = file;
        } finally {
            this.mLockFileOutputStream.close();
        }
    }

    public void close() {
        try {
            if (this.mLock != null) {
                this.mLock.release();
            }
            this.mLockFileOutputStream.close();
        } catch (Throwable th) {
            this.mLockFileOutputStream.close();
        }
    }
}
