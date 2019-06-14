package okhttp3.internal.io;

import java.io.File;
import java.io.IOException;
import p286d.C5870l;
import p286d.C5875s;
import p286d.C5876t;

public interface FileSystem {
    public static final FileSystem SYSTEM = new C76731();

    /* renamed from: okhttp3.internal.io.FileSystem$1 */
    class C76731 implements FileSystem {
        C76731() {
        }

        public C5876t source(File file) {
            return C5870l.m24725a(file);
        }

        public p286d.C5875s sink(java.io.File r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = p286d.C5870l.m24729b(r2);	 Catch:{ FileNotFoundException -> 0x0005 }
            return r0;
        L_0x0005:
            r0 = r2.getParentFile();
            r0.mkdirs();
            r2 = p286d.C5870l.m24729b(r2);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.io.FileSystem.1.sink(java.io.File):d.s");
        }

        public p286d.C5875s appendingSink(java.io.File r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = p286d.C5870l.m24732c(r2);	 Catch:{ FileNotFoundException -> 0x0005 }
            return r0;
        L_0x0005:
            r0 = r2.getParentFile();
            r0.mkdirs();
            r2 = p286d.C5870l.m24732c(r2);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.io.FileSystem.1.appendingSink(java.io.File):d.s");
        }

        public void delete(File file) {
            if (!file.delete()) {
                if (file.exists()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("failed to delete ");
                    stringBuilder.append(file);
                    throw new IOException(stringBuilder.toString());
                }
            }
        }

        public boolean exists(File file) {
            return file.exists();
        }

        public long size(File file) {
            return file.length();
        }

        public void rename(File file, File file2) {
            delete(file2);
            if (!file.renameTo(file2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("failed to rename ");
                stringBuilder.append(file);
                stringBuilder.append(" to ");
                stringBuilder.append(file2);
                throw new IOException(stringBuilder.toString());
            }
        }

        public void deleteContents(File file) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                file = listFiles.length;
                int i = 0;
                while (i < file) {
                    File file2 = listFiles[i];
                    if (file2.isDirectory()) {
                        deleteContents(file2);
                    }
                    if (file2.delete()) {
                        i++;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("failed to delete ");
                        stringBuilder.append(file2);
                        throw new IOException(stringBuilder.toString());
                    }
                }
                return;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("not a readable directory: ");
            stringBuilder2.append(file);
            throw new IOException(stringBuilder2.toString());
        }
    }

    C5875s appendingSink(File file);

    void delete(File file);

    void deleteContents(File file);

    boolean exists(File file);

    void rename(File file, File file2);

    C5875s sink(File file);

    long size(File file);

    C5876t source(File file);
}
