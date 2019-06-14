package org.spongycastle.crypto.prng;

import java.security.SecureRandom;

public class X931SecureRandom extends SecureRandom {
    /* renamed from: a */
    private final boolean f22450a;
    /* renamed from: b */
    private final SecureRandom f22451b;
    /* renamed from: c */
    private final X931RNG f22452c;

    public void setSeed(byte[] bArr) {
        synchronized (this) {
            if (this.f22451b != null) {
                this.f22451b.setSeed(bArr);
            }
        }
    }

    public void setSeed(long j) {
        synchronized (this) {
            if (this.f22451b != null) {
                this.f22451b.setSeed(j);
            }
        }
    }

    public void nextBytes(byte[] bArr) {
        synchronized (this) {
            if (this.f22452c.m27514a(bArr, this.f22450a) < 0) {
                this.f22452c.m27515a();
                this.f22452c.m27514a(bArr, this.f22450a);
            }
        }
    }

    public byte[] generateSeed(int i) {
        i = new byte[i];
        nextBytes(i);
        return i;
    }
}
