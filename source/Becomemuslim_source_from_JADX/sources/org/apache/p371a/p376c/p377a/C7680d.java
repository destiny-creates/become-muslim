package org.apache.p371a.p376c.p377a;

import java.io.OutputStream;

/* compiled from: TeeOutputStream */
/* renamed from: org.apache.a.c.a.d */
public class C7680d extends C6641b {
    /* renamed from: a */
    protected OutputStream f26424a;

    public C7680d(OutputStream outputStream, OutputStream outputStream2) {
        super(outputStream);
        this.f26424a = outputStream2;
    }

    public synchronized void write(byte[] bArr) {
        super.write(bArr);
        this.f26424a.write(bArr);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        super.write(bArr, i, i2);
        this.f26424a.write(bArr, i, i2);
    }

    public synchronized void write(int i) {
        super.write(i);
        this.f26424a.write(i);
    }

    public void flush() {
        super.flush();
        this.f26424a.flush();
    }

    public void close() {
        try {
            super.close();
        } finally {
            this.f26424a.close();
        }
    }
}
