package org.spongycastle.crypto.io;

import java.io.OutputStream;
import org.spongycastle.crypto.Digest;

public class DigestOutputStream extends OutputStream {
    /* renamed from: a */
    protected Digest f22400a;

    public DigestOutputStream(Digest digest) {
        this.f22400a = digest;
    }

    public void write(int i) {
        this.f22400a.mo5730a((byte) i);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.f22400a.mo5731a(bArr, i, i2);
    }

    /* renamed from: a */
    public byte[] m27459a() {
        byte[] bArr = new byte[this.f22400a.mo5732b()];
        this.f22400a.mo5728a(bArr, 0);
        return bArr;
    }
}
