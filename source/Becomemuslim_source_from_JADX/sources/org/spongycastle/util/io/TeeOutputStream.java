package org.spongycastle.util.io;

import java.io.OutputStream;

public class TeeOutputStream extends OutputStream {
    /* renamed from: a */
    private OutputStream f23448a;
    /* renamed from: b */
    private OutputStream f23449b;

    public TeeOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        this.f23448a = outputStream;
        this.f23449b = outputStream2;
    }

    public void write(byte[] bArr) {
        this.f23448a.write(bArr);
        this.f23449b.write(bArr);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.f23448a.write(bArr, i, i2);
        this.f23449b.write(bArr, i, i2);
    }

    public void write(int i) {
        this.f23448a.write(i);
        this.f23449b.write(i);
    }

    public void flush() {
        this.f23448a.flush();
        this.f23449b.flush();
    }

    public void close() {
        this.f23448a.close();
        this.f23449b.close();
    }
}
