package org.spongycastle.crypto.io;

import java.io.FilterInputStream;
import org.spongycastle.crypto.Signer;

public class SignerInputStream extends FilterInputStream {
    /* renamed from: a */
    protected Signer f22403a;

    public int read() {
        int read = this.in.read();
        if (read >= 0) {
            this.f22403a.mo5795a((byte) read);
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        i2 = this.in.read(bArr, i, i2);
        if (i2 > 0) {
            this.f22403a.mo5797a(bArr, i, i2);
        }
        return i2;
    }
}
