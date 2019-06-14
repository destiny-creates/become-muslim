package org.spongycastle.crypto.io;

import java.io.OutputStream;
import org.spongycastle.crypto.Mac;

public class MacOutputStream extends OutputStream {
    /* renamed from: a */
    protected Mac f22402a;

    public MacOutputStream(Mac mac) {
        this.f22402a = mac;
    }

    public void write(int i) {
        this.f22402a.mo5763a((byte) i);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.f22402a.mo5765a(bArr, i, i2);
    }
}
