package org.spongycastle.asn1;

import java.io.EOFException;
import java.io.InputStream;

class IndefiniteLengthInputStream extends LimitedInputStream {
    /* renamed from: b */
    private int f26456b;
    /* renamed from: c */
    private int f26457c;
    /* renamed from: d */
    private boolean f26458d = false;
    /* renamed from: e */
    private boolean f26459e = true;

    IndefiniteLengthInputStream(InputStream inputStream, int i) {
        super(inputStream, i);
        this.f26456b = inputStream.read();
        this.f26457c = inputStream.read();
        if (this.f26457c >= null) {
            m34610b();
            return;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    void m34611a(boolean z) {
        this.f26459e = z;
        m34610b();
    }

    /* renamed from: b */
    private boolean m34610b() {
        if (!this.f26458d && this.f26459e && this.f26456b == 0 && this.f26457c == 0) {
            this.f26458d = true;
            m27165b(true);
        }
        return this.f26458d;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (!this.f26459e) {
            if (i2 >= 3) {
                if (this.f26458d) {
                    return -1;
                }
                i2 = this.a.read(bArr, i + 2, i2 - 2);
                if (i2 >= 0) {
                    bArr[i] = (byte) this.f26456b;
                    bArr[i + 1] = (byte) this.f26457c;
                    this.f26456b = this.a.read();
                    this.f26457c = this.a.read();
                    if (this.f26457c >= null) {
                        return i2 + 2;
                    }
                    throw new EOFException();
                }
                throw new EOFException();
            }
        }
        return super.read(bArr, i, i2);
    }

    public int read() {
        if (m34610b()) {
            return -1;
        }
        int read = this.a.read();
        if (read >= 0) {
            int i = this.f26456b;
            this.f26456b = this.f26457c;
            this.f26457c = read;
            return i;
        }
        throw new EOFException();
    }
}
