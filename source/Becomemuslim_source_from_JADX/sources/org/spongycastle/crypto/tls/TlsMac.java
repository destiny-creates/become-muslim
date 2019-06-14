package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.LongDigest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;

public class TlsMac {
    /* renamed from: a */
    protected TlsContext f22595a;
    /* renamed from: b */
    protected byte[] f22596b;
    /* renamed from: c */
    protected Mac f22597c;
    /* renamed from: d */
    protected int f22598d;
    /* renamed from: e */
    protected int f22599e;
    /* renamed from: f */
    protected int f22600f;

    public TlsMac(TlsContext tlsContext, Digest digest, byte[] bArr, int i, int i2) {
        this.f22595a = tlsContext;
        CipherParameters keyParameter = new KeyParameter(bArr, i, i2);
        this.f22596b = Arrays.m29373b(keyParameter.m35685a());
        if ((digest instanceof LongDigest) != null) {
            this.f22598d = 128;
            this.f22599e = 16;
        } else {
            this.f22598d = 64;
            this.f22599e = 8;
        }
        if (TlsUtils.m27825a(tlsContext) != null) {
            this.f22597c = new SSL3Mac(digest);
            if (digest.mo5732b() == 20) {
                this.f22599e = 4;
            }
        } else {
            this.f22597c = new HMac(digest);
        }
        this.f22597c.mo5764a(keyParameter);
        this.f22600f = this.f22597c.mo5766b();
        if (tlsContext.mo5810c().f22551m != null) {
            this.f22600f = Math.min(this.f22600f, 10);
        }
    }

    /* renamed from: a */
    public int m27715a() {
        return this.f22600f;
    }

    /* renamed from: a */
    public byte[] m27717a(long j, short s, byte[] bArr, int i, int i2) {
        ProtocolVersion e = this.f22595a.mo5812e();
        boolean d = e.m27573d();
        byte[] bArr2 = new byte[(d ? 11 : 13)];
        TlsUtils.m27809a(j, bArr2, 0);
        TlsUtils.m27818a(s, bArr2, (int) 8);
        if (!d) {
            TlsUtils.m27814a(e, bArr2, (int) 9);
        }
        TlsUtils.m27843b(i2, bArr2, bArr2.length - 2);
        this.f22597c.mo5765a(bArr2, 0, bArr2.length);
        this.f22597c.mo5765a(bArr, i, i2);
        byte[] bArr3 = new byte[this.f22597c.mo5766b()];
        this.f22597c.mo5761a(bArr3, 0);
        return m27719a(bArr3);
    }

    /* renamed from: a */
    public byte[] m27718a(long j, short s, byte[] bArr, int i, int i2, int i3, byte[] bArr2) {
        j = m27717a(j, s, bArr, i, i2);
        int i4 = TlsUtils.m27825a(this.f22595a) ? 11 : 13;
        s = m27716a(i3 + i4) - m27716a(i4 + i2);
        while (true) {
            s--;
            if (s >= (short) 0) {
                this.f22597c.mo5765a(bArr2, 0, this.f22598d);
            } else {
                this.f22597c.mo5763a(bArr2[0]);
                this.f22597c.mo5767c();
                return j;
            }
        }
    }

    /* renamed from: a */
    protected int m27716a(int i) {
        return (i + this.f22599e) / this.f22598d;
    }

    /* renamed from: a */
    protected byte[] m27719a(byte[] bArr) {
        if (bArr.length <= this.f22600f) {
            return bArr;
        }
        return Arrays.m29360a(bArr, this.f22600f);
    }
}
