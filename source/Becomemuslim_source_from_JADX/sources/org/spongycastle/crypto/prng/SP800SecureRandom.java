package org.spongycastle.crypto.prng;

import java.security.SecureRandom;
import org.spongycastle.crypto.prng.drbg.SP80090DRBG;

public class SP800SecureRandom extends SecureRandom {
    /* renamed from: a */
    private final DRBGProvider f22432a;
    /* renamed from: b */
    private final boolean f22433b;
    /* renamed from: c */
    private final SecureRandom f22434c;
    /* renamed from: d */
    private final EntropySource f22435d;
    /* renamed from: e */
    private SP80090DRBG f22436e;

    public void setSeed(byte[] bArr) {
        synchronized (this) {
            if (this.f22434c != null) {
                this.f22434c.setSeed(bArr);
            }
        }
    }

    public void setSeed(long j) {
        synchronized (this) {
            if (this.f22434c != null) {
                this.f22434c.setSeed(j);
            }
        }
    }

    public void nextBytes(byte[] bArr) {
        synchronized (this) {
            if (this.f22436e == null) {
                this.f22436e = this.f22432a.mo5792a(this.f22435d);
            }
            if (this.f22436e.mo5793a(bArr, null, this.f22433b) < 0) {
                this.f22436e.mo5794a(null);
                this.f22436e.mo5793a(bArr, null, this.f22433b);
            }
        }
    }

    public byte[] generateSeed(int i) {
        i = new byte[i];
        nextBytes(i);
        return i;
    }
}
