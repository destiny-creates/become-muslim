package expolib_v1.p321a.p322a.p328f;

import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C6257r;
import expolib_v1.p332b.C6258s;
import java.io.File;
import java.io.IOException;

/* compiled from: FileSystem */
/* renamed from: expolib_v1.a.a.f.a */
public interface C6188a {
    /* renamed from: a */
    public static final C6188a f20033a = new C74661();

    /* compiled from: FileSystem */
    /* renamed from: expolib_v1.a.a.f.a$1 */
    static class C74661 implements C6188a {
        C74661() {
        }

        /* renamed from: a */
        public C6258s mo5283a(File file) {
            return C6252l.m25864a(file);
        }

        /* renamed from: b */
        public expolib_v1.p332b.C6257r mo5285b(java.io.File r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = expolib_v1.p332b.C6252l.m25868b(r2);	 Catch:{ FileNotFoundException -> 0x0005 }
            return r0;
        L_0x0005:
            r0 = r2.getParentFile();
            r0.mkdirs();
            r2 = expolib_v1.p332b.C6252l.m25868b(r2);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.f.a.1.b(java.io.File):expolib_v1.b.r");
        }

        /* renamed from: c */
        public expolib_v1.p332b.C6257r mo5286c(java.io.File r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = expolib_v1.p332b.C6252l.m25871c(r2);	 Catch:{ FileNotFoundException -> 0x0005 }
            return r0;
        L_0x0005:
            r0 = r2.getParentFile();
            r0.mkdirs();
            r2 = expolib_v1.p332b.C6252l.m25871c(r2);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.f.a.1.c(java.io.File):expolib_v1.b.r");
        }

        /* renamed from: d */
        public void mo5287d(File file) {
            if (!file.delete()) {
                if (file.exists()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("failed to delete ");
                    stringBuilder.append(file);
                    throw new IOException(stringBuilder.toString());
                }
            }
        }

        /* renamed from: e */
        public boolean mo5288e(File file) {
            return file.exists();
        }

        /* renamed from: f */
        public long mo5289f(File file) {
            return file.length();
        }

        /* renamed from: a */
        public void mo5284a(File file, File file2) {
            mo5287d(file2);
            if (!file.renameTo(file2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("failed to rename ");
                stringBuilder.append(file);
                stringBuilder.append(" to ");
                stringBuilder.append(file2);
                throw new IOException(stringBuilder.toString());
            }
        }

        /* renamed from: g */
        public void mo5290g(File file) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                file = listFiles.length;
                int i = 0;
                while (i < file) {
                    File file2 = listFiles[i];
                    if (file2.isDirectory()) {
                        mo5290g(file2);
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

    /* renamed from: a */
    C6258s mo5283a(File file);

    /* renamed from: a */
    void mo5284a(File file, File file2);

    /* renamed from: b */
    C6257r mo5285b(File file);

    /* renamed from: c */
    C6257r mo5286c(File file);

    /* renamed from: d */
    void mo5287d(File file);

    /* renamed from: e */
    boolean mo5288e(File file);

    /* renamed from: f */
    long mo5289f(File file);

    /* renamed from: g */
    void mo5290g(File file);
}
