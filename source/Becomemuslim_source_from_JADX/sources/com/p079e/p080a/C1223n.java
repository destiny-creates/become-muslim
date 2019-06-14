package com.p079e.p080a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkableInputStream */
/* renamed from: com.e.a.n */
final class C1223n extends InputStream {
    /* renamed from: a */
    private final InputStream f3450a;
    /* renamed from: b */
    private long f3451b;
    /* renamed from: c */
    private long f3452c;
    /* renamed from: d */
    private long f3453d;
    /* renamed from: e */
    private long f3454e;

    public C1223n(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public C1223n(InputStream inputStream, int i) {
        this.f3454e = -1;
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, i);
        }
        this.f3450a = inputStream;
    }

    public void mark(int i) {
        this.f3454e = m4293a(i);
    }

    /* renamed from: a */
    public long m4293a(int i) {
        long j = this.f3451b + ((long) i);
        if (this.f3453d < j) {
            m4292b(j);
        }
        return this.f3451b;
    }

    /* renamed from: b */
    private void m4292b(long j) {
        try {
            if (this.f3452c >= this.f3451b || this.f3451b > this.f3453d) {
                this.f3452c = this.f3451b;
                this.f3450a.mark((int) (j - this.f3451b));
            } else {
                this.f3450a.reset();
                this.f3450a.mark((int) (j - this.f3452c));
                m4291a(this.f3452c, this.f3451b);
            }
            this.f3453d = j;
        } catch (long j2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to mark: ");
            stringBuilder.append(j2);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public void reset() {
        m4294a(this.f3454e);
    }

    /* renamed from: a */
    public void m4294a(long j) {
        if (this.f3451b > this.f3453d || j < this.f3452c) {
            throw new IOException("Cannot reset");
        }
        this.f3450a.reset();
        m4291a(this.f3452c, j);
        this.f3451b = j;
    }

    /* renamed from: a */
    private void m4291a(long j, long j2) {
        while (j < j2) {
            long skip = this.f3450a.skip(j2 - j);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j += skip;
        }
    }

    public int read() {
        int read = this.f3450a.read();
        if (read != -1) {
            this.f3451b++;
        }
        return read;
    }

    public int read(byte[] bArr) {
        bArr = this.f3450a.read(bArr);
        if (bArr != -1) {
            this.f3451b += (long) bArr;
        }
        return bArr;
    }

    public int read(byte[] bArr, int i, int i2) {
        bArr = this.f3450a.read(bArr, i, i2);
        if (bArr != -1) {
            this.f3451b += (long) bArr;
        }
        return bArr;
    }

    public long skip(long j) {
        j = this.f3450a.skip(j);
        this.f3451b += j;
        return j;
    }

    public int available() {
        return this.f3450a.available();
    }

    public void close() {
        this.f3450a.close();
    }

    public boolean markSupported() {
        return this.f3450a.markSupported();
    }
}
