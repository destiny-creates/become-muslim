package com.p064b.p065a.p068c;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/* compiled from: ClsFileOutputStream */
/* renamed from: com.b.a.c.d */
class C1020d extends FileOutputStream {
    /* renamed from: a */
    public static final FilenameFilter f2871a = new C10191();
    /* renamed from: b */
    private final String f2872b;
    /* renamed from: c */
    private File f2873c;
    /* renamed from: d */
    private File f2874d;
    /* renamed from: e */
    private boolean f2875e = false;

    /* compiled from: ClsFileOutputStream */
    /* renamed from: com.b.a.c.d$1 */
    static class C10191 implements FilenameFilter {
        C10191() {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    }

    public C1020d(File file, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".cls_temp");
        super(new File(file, stringBuilder.toString()));
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(file);
        stringBuilder2.append(File.separator);
        stringBuilder2.append(str);
        this.f2872b = stringBuilder2.toString();
        str = new StringBuilder();
        str.append(this.f2872b);
        str.append(".cls_temp");
        this.f2873c = new File(str.toString());
    }

    public synchronized void close() {
        if (!this.f2875e) {
            this.f2875e = true;
            super.flush();
            super.close();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f2872b);
            stringBuilder.append(".cls");
            File file = new File(stringBuilder.toString());
            if (this.f2873c.renameTo(file)) {
                this.f2873c = null;
                this.f2874d = file;
                return;
            }
            String str = "";
            if (file.exists()) {
                str = " (target already exists)";
            } else if (!this.f2873c.exists()) {
                str = " (source does not exist)";
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Could not rename temp file: ");
            stringBuilder2.append(this.f2873c);
            stringBuilder2.append(" -> ");
            stringBuilder2.append(file);
            stringBuilder2.append(str);
            throw new IOException(stringBuilder2.toString());
        }
    }

    /* renamed from: a */
    public void m3504a() {
        if (!this.f2875e) {
            this.f2875e = true;
            super.flush();
            super.close();
        }
    }
}
