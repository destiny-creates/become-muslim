package org.spongycastle.jcajce.io;

import java.io.OutputStream;
import javax.crypto.Mac;

public final class MacOutputStream extends OutputStream {
    /* renamed from: a */
    private Mac f22708a;

    public void write(int i) {
        this.f22708a.update((byte) i);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.f22708a.update(bArr, i, i2);
    }
}
