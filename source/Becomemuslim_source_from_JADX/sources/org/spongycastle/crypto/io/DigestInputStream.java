package org.spongycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.InputStream;
import org.spongycastle.crypto.Digest;

public class DigestInputStream extends FilterInputStream {
    /* renamed from: a */
    protected Digest f22399a;

    public DigestInputStream(InputStream inputStream, Digest digest) {
        super(inputStream);
        this.f22399a = digest;
    }

    public int read() {
        int read = this.in.read();
        if (read >= 0) {
            this.f22399a.mo5730a((byte) read);
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        i2 = this.in.read(bArr, i, i2);
        if (i2 > 0) {
            this.f22399a.mo5731a(bArr, i, i2);
        }
        return i2;
    }
}
