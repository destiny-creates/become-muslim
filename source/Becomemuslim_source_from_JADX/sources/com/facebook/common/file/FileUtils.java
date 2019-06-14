package com.facebook.common.file;

import com.facebook.common.internal.Preconditions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtils {

    public static class CreateDirectoryException extends IOException {
        public CreateDirectoryException(String str) {
            super(str);
        }

        public CreateDirectoryException(String str, Throwable th) {
            super(str);
            initCause(th);
        }
    }

    public static class FileDeleteException extends IOException {
        public FileDeleteException(String str) {
            super(str);
        }
    }

    public static class ParentDirNotFoundException extends FileNotFoundException {
        public ParentDirNotFoundException(String str) {
            super(str);
        }
    }

    public static class RenameException extends IOException {
        public RenameException(String str) {
            super(str);
        }

        public RenameException(String str, Throwable th) {
            super(str);
            initCause(th);
        }
    }

    public static void mkdirs(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.delete()) {
                    throw new CreateDirectoryException(file.getAbsolutePath(), new FileDeleteException(file.getAbsolutePath()));
                }
            } else {
                return;
            }
        }
        if (!file.mkdirs()) {
            if (!file.isDirectory()) {
                throw new CreateDirectoryException(file.getAbsolutePath());
            }
        }
    }

    public static void rename(File file, File file2) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        file2.delete();
        if (!file.renameTo(file2)) {
            Throwable th = null;
            if (file2.exists()) {
                th = new FileDeleteException(file2.getAbsolutePath());
            } else if (!file.getParentFile().exists()) {
                th = new ParentDirNotFoundException(file.getAbsolutePath());
            } else if (!file.exists()) {
                th = new FileNotFoundException(file.getAbsolutePath());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown error renaming ");
            stringBuilder.append(file.getAbsolutePath());
            stringBuilder.append(" to ");
            stringBuilder.append(file2.getAbsolutePath());
            throw new RenameException(stringBuilder.toString(), th);
        }
    }
}
