package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.modes.AEADBlockCipher;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;

public class TlsAEADCipher implements TlsCipher {
    /* renamed from: a */
    protected TlsContext f27319a;
    /* renamed from: b */
    protected int f27320b;
    /* renamed from: c */
    protected int f27321c;
    /* renamed from: d */
    protected AEADBlockCipher f27322d;
    /* renamed from: e */
    protected AEADBlockCipher f27323e;
    /* renamed from: f */
    protected byte[] f27324f;
    /* renamed from: g */
    protected byte[] f27325g;

    public TlsAEADCipher(TlsContext tlsContext, AEADBlockCipher aEADBlockCipher, AEADBlockCipher aEADBlockCipher2, int i, int i2) {
        if (TlsUtils.m27860c(tlsContext)) {
            this.f27319a = tlsContext;
            this.f27320b = i2;
            this.f27321c = 8;
            int i3 = (i * 2) + 8;
            byte[] a = TlsUtils.m27828a(tlsContext, i3);
            KeyParameter keyParameter = new KeyParameter(a, 0, i);
            int i4 = i + 0;
            KeyParameter keyParameter2 = new KeyParameter(a, i4, i);
            i4 += i;
            i = i4 + 4;
            byte[] a2 = Arrays.m29361a(a, i4, i);
            int i5 = i + 4;
            i = Arrays.m29361a(a, i, i5);
            if (i5 == i3) {
                if (tlsContext.mo6487f() != null) {
                    this.f27322d = aEADBlockCipher2;
                    this.f27323e = aEADBlockCipher;
                    this.f27324f = i;
                    this.f27325g = a2;
                    KeyParameter keyParameter3 = keyParameter2;
                    keyParameter2 = keyParameter;
                    keyParameter = keyParameter3;
                } else {
                    this.f27322d = aEADBlockCipher;
                    this.f27323e = aEADBlockCipher2;
                    this.f27324f = a2;
                    this.f27325g = i;
                }
                tlsContext = new byte[(this.f27321c + 4)];
                i2 *= 8;
                this.f27322d.mo5772a(true, new AEADParameters(keyParameter, i2, tlsContext));
                this.f27323e.mo5772a(false, new AEADParameters(keyParameter2, i2, tlsContext));
                return;
            }
            throw new TlsFatalAlert((short) 80);
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: a */
    public int m35891a(int i) {
        return (i - this.f27320b) - this.f27321c;
    }

    /* renamed from: a */
    public byte[] mo5831a(long j, short s, byte[] bArr, int i, int i2) {
        long j2 = j;
        int i3 = i2;
        byte[] bArr2 = new byte[(this.f27324f.length + this.f27321c)];
        System.arraycopy(this.f27324f, 0, bArr2, 0, this.f27324f.length);
        TlsUtils.m27809a(j, bArr2, this.f27324f.length);
        byte[] bArr3 = new byte[(this.f27321c + this.f27322d.mo5774b(i3))];
        System.arraycopy(bArr2, this.f27324f.length, bArr3, 0, this.f27321c);
        int i4 = this.f27321c;
        short s2 = s;
        try {
            r1.f27322d.mo5772a(true, new AEADParameters(null, this.f27320b * 8, bArr2, m35892a(j, s, i3)));
            i4 += r1.f27322d.mo5770a(bArr, i, i2, bArr3, i4);
            if (i4 + r1.f27322d.mo5769a(bArr3, i4) == bArr3.length) {
                return bArr3;
            }
            throw new TlsFatalAlert((short) 80);
        } catch (Throwable e) {
            throw new TlsFatalAlert((short) 80, e);
        }
    }

    /* renamed from: b */
    public byte[] mo5832b(long j, short s, byte[] bArr, int i, int i2) {
        TlsAEADCipher tlsAEADCipher = this;
        int i3 = i;
        int i4 = i2;
        if (m35891a(i4) >= 0) {
            Object obj = new byte[(tlsAEADCipher.f27325g.length + tlsAEADCipher.f27321c)];
            System.arraycopy(tlsAEADCipher.f27325g, 0, obj, 0, tlsAEADCipher.f27325g.length);
            System.arraycopy(bArr, i3, obj, tlsAEADCipher.f27325g.length, tlsAEADCipher.f27321c);
            int i5 = i3 + tlsAEADCipher.f27321c;
            int i6 = i4 - tlsAEADCipher.f27321c;
            i3 = tlsAEADCipher.f27323e.mo5774b(i6);
            byte[] bArr2 = new byte[i3];
            long j2 = j;
            try {
                tlsAEADCipher.f27323e.mo5772a(false, new AEADParameters(null, tlsAEADCipher.f27320b * 8, obj, m35892a(j, s, i3)));
                i3 = tlsAEADCipher.f27323e.mo5770a(bArr, i5, i6, bArr2, 0) + 0;
                if (i3 + tlsAEADCipher.f27323e.mo5769a(bArr2, i3) == bArr2.length) {
                    return bArr2;
                }
                throw new TlsFatalAlert((short) 80);
            } catch (Throwable e) {
                throw new TlsFatalAlert((short) 20, e);
            }
        }
        throw new TlsFatalAlert((short) 50);
    }

    /* renamed from: a */
    protected byte[] m35892a(long j, short s, int i) {
        byte[] bArr = new byte[13];
        TlsUtils.m27809a(j, bArr, 0);
        TlsUtils.m27818a(s, bArr, (int) 8);
        TlsUtils.m27814a(this.f27319a.mo5812e(), bArr, 9);
        TlsUtils.m27843b(i, bArr, (int) 11);
        return bArr;
    }
}
