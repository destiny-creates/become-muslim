package com.facebook.ads.internal.p101p.p103b.p104a;

import com.facebook.ads.internal.p101p.p103b.C1461a;
import com.facebook.ads.internal.p101p.p103b.C1477l;
import java.io.File;
import java.io.RandomAccessFile;

/* renamed from: com.facebook.ads.internal.p.b.a.b */
public class C3601b implements C1461a {
    /* renamed from: a */
    public File f9606a;
    /* renamed from: b */
    private final C1455a f9607b;
    /* renamed from: c */
    private RandomAccessFile f9608c;

    public C3601b(File file, C1455a c1455a) {
        if (c1455a != null) {
            try {
                File file2;
                this.f9607b = c1455a;
                C1459d.m5161a(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    File parentFile = file.getParentFile();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(file.getName());
                    stringBuilder.append(".download");
                    file2 = new File(parentFile, stringBuilder.toString());
                }
                this.f9606a = file2;
                this.f9608c = new RandomAccessFile(this.f9606a, exists ? "r" : "rw");
                return;
            } catch (Throwable e) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Error using file ");
                stringBuilder2.append(file);
                stringBuilder2.append(" as disc cache");
                throw new C1477l(stringBuilder2.toString(), e);
            }
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    private boolean m11733a(File file) {
        return file.getName().endsWith(".download");
    }

    /* renamed from: a */
    public synchronized int mo982a() {
        try {
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error reading length of file ");
            stringBuilder.append(this.f9606a);
            throw new C1477l(stringBuilder.toString(), e);
        }
        return (int) this.f9608c.length();
    }

    /* renamed from: a */
    public synchronized int mo983a(byte[] bArr, long j, int i) {
        try {
            this.f9608c.seek(j);
        } catch (Throwable e) {
            throw new C1477l(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(mo982a()), Integer.valueOf(bArr.length)}), e);
        }
        return this.f9608c.read(bArr, 0, i);
    }

    /* renamed from: a */
    public synchronized void mo984a(byte[] bArr, int i) {
        try {
            if (mo987d()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error append cache: cache file ");
                stringBuilder.append(this.f9606a);
                stringBuilder.append(" is completed!");
                throw new C1477l(stringBuilder.toString());
            }
            this.f9608c.seek((long) mo982a());
            this.f9608c.write(bArr, 0, i);
        } catch (Throwable e) {
            throw new C1477l(String.format("Error writing %d bytes to %s from buffer with size %d", new Object[]{Integer.valueOf(i), this.f9608c, Integer.valueOf(bArr.length)}), e);
        }
    }

    /* renamed from: b */
    public synchronized void mo985b() {
        try {
            this.f9608c.close();
            this.f9607b.mo988a(this.f9606a);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error closing file ");
            stringBuilder.append(this.f9606a);
            throw new C1477l(stringBuilder.toString(), e);
        }
    }

    /* renamed from: c */
    public synchronized void mo986c() {
        if (!mo987d()) {
            mo985b();
            File file = new File(this.f9606a.getParentFile(), this.f9606a.getName().substring(0, this.f9606a.getName().length() - ".download".length()));
            StringBuilder stringBuilder;
            if (this.f9606a.renameTo(file)) {
                this.f9606a = file;
                try {
                    this.f9608c = new RandomAccessFile(this.f9606a, "r");
                    return;
                } catch (Throwable e) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Error opening ");
                    stringBuilder.append(this.f9606a);
                    stringBuilder.append(" as disc cache");
                    throw new C1477l(stringBuilder.toString(), e);
                }
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Error renaming file ");
            stringBuilder.append(this.f9606a);
            stringBuilder.append(" to ");
            stringBuilder.append(file);
            stringBuilder.append(" for completion!");
            throw new C1477l(stringBuilder.toString());
        }
    }

    /* renamed from: d */
    public synchronized boolean mo987d() {
        return m11733a(this.f9606a) ^ 1;
    }
}
