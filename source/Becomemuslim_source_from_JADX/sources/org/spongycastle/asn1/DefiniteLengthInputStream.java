package org.spongycastle.asn1;

import java.io.EOFException;
import java.io.InputStream;
import org.spongycastle.util.io.Streams;

class DefiniteLengthInputStream extends LimitedInputStream {
    /* renamed from: b */
    private static final byte[] f26453b = new byte[0];
    /* renamed from: c */
    private final int f26454c;
    /* renamed from: d */
    private int f26455d;

    DefiniteLengthInputStream(InputStream inputStream, int i) {
        super(inputStream, i);
        if (i >= 0) {
            this.f26454c = i;
            this.f26455d = i;
            if (i == 0) {
                m27165b(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("negative lengths not allowed");
    }

    /* renamed from: a */
    int mo5715a() {
        return this.f26455d;
    }

    public int read() {
        if (this.f26455d == 0) {
            return -1;
        }
        int read = this.a.read();
        if (read >= 0) {
            int i = this.f26455d - 1;
            this.f26455d = i;
            if (i == 0) {
                m27165b(true);
            }
            return read;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DEF length ");
        stringBuilder.append(this.f26454c);
        stringBuilder.append(" object truncated by ");
        stringBuilder.append(this.f26455d);
        throw new EOFException(stringBuilder.toString());
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.f26455d == 0) {
            return -1;
        }
        bArr = this.a.read(bArr, i, Math.min(i2, this.f26455d));
        if (bArr >= null) {
            i = this.f26455d - bArr;
            this.f26455d = i;
            if (i == 0) {
                m27165b(1);
            }
            return bArr;
        }
        i = new StringBuilder();
        i.append("DEF length ");
        i.append(this.f26454c);
        i.append(" object truncated by ");
        i.append(this.f26455d);
        throw new EOFException(i.toString());
    }

    /* renamed from: b */
    byte[] m34609b() {
        if (this.f26455d == 0) {
            return f26453b;
        }
        byte[] bArr = new byte[this.f26455d];
        int a = this.f26455d - Streams.m29439a(this.a, bArr);
        this.f26455d = a;
        if (a == 0) {
            m27165b(true);
            return bArr;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DEF length ");
        stringBuilder.append(this.f26454c);
        stringBuilder.append(" object truncated by ");
        stringBuilder.append(this.f26455d);
        throw new EOFException(stringBuilder.toString());
    }
}
