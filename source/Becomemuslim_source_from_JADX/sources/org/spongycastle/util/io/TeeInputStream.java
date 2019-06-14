package org.spongycastle.util.io;

import java.io.InputStream;
import java.io.OutputStream;

public class TeeInputStream extends InputStream {
    /* renamed from: a */
    private final InputStream f23446a;
    /* renamed from: b */
    private final OutputStream f23447b;

    public TeeInputStream(InputStream inputStream, OutputStream outputStream) {
        this.f23446a = inputStream;
        this.f23447b = outputStream;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        i2 = this.f23446a.read(bArr, i, i2);
        if (i2 > 0) {
            this.f23447b.write(bArr, i, i2);
        }
        return i2;
    }

    public int read() {
        int read = this.f23446a.read();
        if (read >= 0) {
            this.f23447b.write(read);
        }
        return read;
    }

    public void close() {
        this.f23446a.close();
        this.f23447b.close();
    }
}
