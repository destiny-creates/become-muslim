package org.spongycastle.crypto.prng;

import org.spongycastle.crypto.Digest;

public class DigestRandomGenerator implements RandomGenerator {
    /* renamed from: a */
    private static long f27156a = 10;
    /* renamed from: b */
    private long f27157b;
    /* renamed from: c */
    private long f27158c = 1;
    /* renamed from: d */
    private Digest f27159d;
    /* renamed from: e */
    private byte[] f27160e;
    /* renamed from: f */
    private byte[] f27161f;

    public DigestRandomGenerator(Digest digest) {
        this.f27159d = digest;
        this.f27161f = new byte[digest.mo5732b()];
        this.f27160e = new byte[digest.mo5732b()];
        this.f27157b = 1;
    }

    /* renamed from: a */
    public void m35723a(byte[] bArr) {
        synchronized (this) {
            m35721c(bArr);
            m35721c(this.f27161f);
            m35722d(this.f27161f);
        }
    }

    /* renamed from: b */
    public void mo5791b(byte[] bArr) {
        mo5790a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void mo5790a(byte[] bArr, int i, int i2) {
        synchronized (this) {
            m35720b();
            i2 += i;
            int i3 = 0;
            while (i != i2) {
                if (i3 == this.f27160e.length) {
                    m35720b();
                    i3 = 0;
                }
                int i4 = i3 + 1;
                bArr[i] = this.f27160e[i3];
                i++;
                i3 = i4;
            }
        }
    }

    /* renamed from: a */
    private void m35718a() {
        m35721c(this.f27161f);
        long j = this.f27158c;
        this.f27158c = 1 + j;
        m35719a(j);
        m35722d(this.f27161f);
    }

    /* renamed from: b */
    private void m35720b() {
        long j = this.f27157b;
        this.f27157b = 1 + j;
        m35719a(j);
        m35721c(this.f27160e);
        m35721c(this.f27161f);
        m35722d(this.f27160e);
        if (this.f27157b % f27156a == 0) {
            m35718a();
        }
    }

    /* renamed from: a */
    private void m35719a(long j) {
        for (int i = 0; i != 8; i++) {
            this.f27159d.mo5730a((byte) ((int) j));
            j >>>= 8;
        }
    }

    /* renamed from: c */
    private void m35721c(byte[] bArr) {
        this.f27159d.mo5731a(bArr, 0, bArr.length);
    }

    /* renamed from: d */
    private void m35722d(byte[] bArr) {
        this.f27159d.mo5728a(bArr, 0);
    }
}
