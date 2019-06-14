package org.spongycastle.crypto.io;

import java.io.OutputStream;
import org.spongycastle.crypto.Signer;

public class SignerOutputStream extends OutputStream {
    /* renamed from: a */
    protected Signer f22404a;

    public void write(int i) {
        this.f22404a.mo5795a((byte) i);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.f22404a.mo5797a(bArr, i, i2);
    }
}
