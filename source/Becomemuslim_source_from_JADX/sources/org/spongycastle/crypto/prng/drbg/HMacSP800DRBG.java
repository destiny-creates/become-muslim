package org.spongycastle.crypto.prng.drbg;

import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.util.Arrays;

public class HMacSP800DRBG implements SP80090DRBG {
    /* renamed from: a */
    private byte[] f27224a;
    /* renamed from: b */
    private byte[] f27225b;
    /* renamed from: c */
    private long f27226c;
    /* renamed from: d */
    private EntropySource f27227d;
    /* renamed from: e */
    private Mac f27228e;
    /* renamed from: f */
    private int f27229f;

    public HMacSP800DRBG(Mac mac, int i, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        if (i > Utils.m27525a(mac)) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        } else if (entropySource.mo5789b() >= i) {
            this.f27229f = i;
            this.f27227d = entropySource;
            this.f27228e = mac;
            i = Arrays.m29362a(m35758a(), bArr2, bArr);
            this.f27224a = new byte[mac.mo5766b()];
            this.f27225b = new byte[this.f27224a.length];
            Arrays.m29351a(this.f27225b, (byte) 1);
            m35759b(i);
            this.f27226c = 1;
        } else {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
    }

    /* renamed from: b */
    private void m35759b(byte[] bArr) {
        m35757a(bArr, (byte) 0);
        if (bArr != null) {
            m35757a(bArr, (byte) 1);
        }
    }

    /* renamed from: a */
    private void m35757a(byte[] bArr, byte b) {
        this.f27228e.mo5764a(new KeyParameter(this.f27224a));
        this.f27228e.mo5765a(this.f27225b, 0, this.f27225b.length);
        this.f27228e.mo5763a(b);
        if (bArr != null) {
            this.f27228e.mo5765a(bArr, 0, bArr.length);
        }
        this.f27228e.mo5761a(this.f27224a, 0);
        this.f27228e.mo5764a(new KeyParameter(this.f27224a));
        this.f27228e.mo5765a(this.f27225b, 0, this.f27225b.length);
        this.f27228e.mo5761a(this.f27225b, 0);
    }

    /* renamed from: a */
    public int mo5793a(byte[] bArr, byte[] bArr2, boolean z) {
        int length = bArr.length * 8;
        if (length > 262144) {
            throw new IllegalArgumentException("Number of bits per request limited to 262144");
        } else if (this.f27226c > 140737488355328L) {
            return -1;
        } else {
            if (z) {
                mo5794a(bArr2);
                bArr2 = null;
            }
            if (bArr2 != null) {
                m35759b(bArr2);
            }
            z = new byte[bArr.length];
            int length2 = bArr.length / this.f27225b.length;
            this.f27228e.mo5764a(new KeyParameter(this.f27224a));
            for (int i = 0; i < length2; i++) {
                this.f27228e.mo5765a(this.f27225b, 0, this.f27225b.length);
                this.f27228e.mo5761a(this.f27225b, 0);
                System.arraycopy(this.f27225b, 0, z, this.f27225b.length * i, this.f27225b.length);
            }
            if (this.f27225b.length * length2 < z.length) {
                this.f27228e.mo5765a(this.f27225b, 0, this.f27225b.length);
                this.f27228e.mo5761a(this.f27225b, 0);
                System.arraycopy(this.f27225b, 0, z, this.f27225b.length * length2, z.length - (length2 * this.f27225b.length));
            }
            m35759b(bArr2);
            this.f27226c++;
            System.arraycopy(z, 0, bArr, 0, bArr.length);
            return length;
        }
    }

    /* renamed from: a */
    public void mo5794a(byte[] bArr) {
        m35759b(Arrays.m29385d(m35758a(), bArr));
        this.f27226c = 1;
    }

    /* renamed from: a */
    private byte[] m35758a() {
        byte[] a = this.f27227d.mo5788a();
        if (a.length >= (this.f27229f + 7) / 8) {
            return a;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }
}
