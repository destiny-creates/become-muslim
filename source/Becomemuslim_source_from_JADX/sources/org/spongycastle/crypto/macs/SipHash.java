package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;

public class SipHash implements Mac {
    /* renamed from: a */
    protected final int f26942a;
    /* renamed from: b */
    protected final int f26943b;
    /* renamed from: c */
    protected long f26944c;
    /* renamed from: d */
    protected long f26945d;
    /* renamed from: e */
    protected long f26946e;
    /* renamed from: f */
    protected long f26947f;
    /* renamed from: g */
    protected long f26948g;
    /* renamed from: h */
    protected long f26949h;
    /* renamed from: i */
    protected long f26950i;
    /* renamed from: j */
    protected int f26951j;
    /* renamed from: k */
    protected int f26952k;

    /* renamed from: a */
    protected static long m35462a(long j, int i) {
        return (j >>> (-i)) | (j << i);
    }

    /* renamed from: b */
    public int mo5766b() {
        return 8;
    }

    public SipHash() {
        this.f26950i = 0;
        this.f26951j = 0;
        this.f26952k = 0;
        this.f26942a = 2;
        this.f26943b = 4;
    }

    public SipHash(int i, int i2) {
        this.f26950i = 0;
        this.f26951j = 0;
        this.f26952k = 0;
        this.f26942a = i;
        this.f26943b = i2;
    }

    /* renamed from: a */
    public String mo5762a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SipHash-");
        stringBuilder.append(this.f26942a);
        stringBuilder.append("-");
        stringBuilder.append(this.f26943b);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public void mo5764a(CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            cipherParameters = ((KeyParameter) cipherParameters).m35685a();
            if (cipherParameters.length == 16) {
                this.f26944c = Pack.m29412d(cipherParameters, 0);
                this.f26945d = Pack.m29412d(cipherParameters, 8);
                mo5767c();
                return;
            }
            throw new IllegalArgumentException("'params' must be a 128-bit key");
        }
        throw new IllegalArgumentException("'params' must be an instance of KeyParameter");
    }

    /* renamed from: a */
    public void mo5763a(byte b) {
        this.f26950i >>>= 8;
        this.f26950i |= (((long) b) & 255) << (byte) 56;
        b = this.f26951j + 1;
        this.f26951j = b;
        if (b == (byte) 8) {
            m35472e();
            this.f26951j = (byte) 0;
        }
    }

    /* renamed from: a */
    public void mo5765a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        int i3 = i2;
        int i4 = i3 & -8;
        int i5 = 0;
        if (this.f26951j == 0) {
            while (i5 < i4) {
                r0.f26950i = Pack.m29412d(bArr2, i + i5);
                m35472e();
                i5 += 8;
            }
            while (i5 < i3) {
                r0.f26950i >>>= 8;
                r0.f26950i |= (((long) bArr2[i + i5]) & 255) << 56;
                i5++;
            }
            r0.f26951j = i3 - i4;
            return;
        }
        int i6 = r0.f26951j << 3;
        int i7 = 0;
        while (i7 < i4) {
            long d = Pack.m29412d(bArr2, i + i7);
            r0.f26950i = (r0.f26950i >>> (-i6)) | (d << i6);
            m35472e();
            r0.f26950i = d;
            i7 += 8;
        }
        while (i7 < i3) {
            r0.f26950i >>>= 8;
            r0.f26950i |= (((long) bArr2[i + i7]) & 255) << 56;
            i4 = r0.f26951j + 1;
            r0.f26951j = i4;
            if (i4 == 8) {
                m35472e();
                r0.f26951j = 0;
            }
            i7++;
        }
    }

    /* renamed from: d */
    public long m35471d() {
        this.f26950i >>>= (7 - this.f26951j) << 3;
        this.f26950i >>>= 8;
        this.f26950i |= (((long) ((this.f26952k << 3) + this.f26951j)) & 255) << 56;
        m35472e();
        this.f26948g ^= 255;
        m35466a(this.f26943b);
        long j = ((this.f26946e ^ this.f26947f) ^ this.f26948g) ^ this.f26949h;
        mo5767c();
        return j;
    }

    /* renamed from: a */
    public int mo5761a(byte[] bArr, int i) {
        Pack.m29409b(m35471d(), bArr, i);
        return 8;
    }

    /* renamed from: c */
    public void mo5767c() {
        this.f26946e = this.f26944c ^ 8317987319222330741L;
        this.f26947f = this.f26945d ^ 7237128888997146477L;
        this.f26948g = this.f26944c ^ 7816392313619706465L;
        this.f26949h = this.f26945d ^ 8387220255154660723L;
        this.f26950i = 0;
        this.f26951j = 0;
        this.f26952k = 0;
    }

    /* renamed from: e */
    protected void m35472e() {
        this.f26952k++;
        this.f26949h ^= this.f26950i;
        m35466a(this.f26942a);
        this.f26946e ^= this.f26950i;
    }

    /* renamed from: a */
    protected void m35466a(int i) {
        long j = this.f26946e;
        long j2 = this.f26947f;
        long j3 = this.f26948g;
        long j4 = this.f26949h;
        for (int i2 = 0; i2 < i; i2++) {
            j += j2;
            j3 += j4;
            j2 = m35462a(j2, 13) ^ j;
            j4 = m35462a(j4, 16) ^ j3;
            j3 += j2;
            j = m35462a(j, 32) + j4;
            j2 = m35462a(j2, 17) ^ j3;
            j4 = m35462a(j4, 21) ^ j;
            j3 = m35462a(j3, 32);
        }
        this.f26946e = j;
        this.f26947f = j2;
        this.f26948g = j3;
        this.f26949h = j4;
    }
}
