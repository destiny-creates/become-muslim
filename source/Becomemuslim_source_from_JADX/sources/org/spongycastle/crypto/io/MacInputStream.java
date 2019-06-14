package org.spongycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.InputStream;
import org.spongycastle.crypto.Mac;

public class MacInputStream extends FilterInputStream {
    /* renamed from: a */
    protected Mac f22401a;

    public MacInputStream(InputStream inputStream, Mac mac) {
        super(inputStream);
        this.f22401a = mac;
    }

    public int read() {
        int read = this.in.read();
        if (read >= 0) {
            this.f22401a.mo5763a((byte) read);
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        i2 = this.in.read(bArr, i, i2);
        if (i2 >= 0) {
            this.f22401a.mo5765a(bArr, i, i2);
        }
        return i2;
    }
}
