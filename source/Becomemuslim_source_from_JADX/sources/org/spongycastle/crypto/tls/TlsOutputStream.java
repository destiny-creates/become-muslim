package org.spongycastle.crypto.tls;

import java.io.OutputStream;

class TlsOutputStream extends OutputStream {
    /* renamed from: a */
    private byte[] f22601a;
    /* renamed from: b */
    private TlsProtocol f22602b;

    public void write(byte[] bArr, int i, int i2) {
        this.f22602b.m27759b(bArr, i, i2);
    }

    public void write(int i) {
        this.f22601a[0] = (byte) i;
        write(this.f22601a, 0, 1);
    }

    public void close() {
        this.f22602b.m27772l();
    }

    public void flush() {
        this.f22602b.m27773m();
    }
}
