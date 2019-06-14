package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.DigestDerivationFunction;
import org.spongycastle.crypto.params.ISO18033KDFParameters;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.util.Pack;

public class BaseKDFBytesGenerator implements DigestDerivationFunction {
    /* renamed from: a */
    private int f31675a;
    /* renamed from: b */
    private Digest f31676b;
    /* renamed from: c */
    private byte[] f31677c;
    /* renamed from: d */
    private byte[] f31678d;

    protected BaseKDFBytesGenerator(int i, Digest digest) {
        this.f31675a = i;
        this.f31676b = digest;
    }

    /* renamed from: a */
    public void mo5727a(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters) derivationParameters;
            this.f31677c = kDFParameters.m35683a();
            this.f31678d = kDFParameters.m35684b();
        } else if (derivationParameters instanceof ISO18033KDFParameters) {
            this.f31677c = ((ISO18033KDFParameters) derivationParameters).m35669a();
            this.f31678d = null;
        } else {
            throw new IllegalArgumentException("KDF parameters required for KDF2Generator");
        }
    }

    /* renamed from: a */
    public int mo5726a(byte[] bArr, int i, int i2) {
        if (bArr.length - i2 >= i) {
            long j = (long) i2;
            int b = this.f31676b.mo5732b();
            if (j <= 8589934591L) {
                long j2 = (long) b;
                int i3 = (int) (((j + j2) - 1) / j2);
                Object obj = new byte[this.f31676b.mo5732b()];
                byte[] bArr2 = new byte[4];
                Pack.m29400a(this.f31675a, bArr2, 0);
                int i4 = this.f31675a & -256;
                int i5 = i;
                for (i = 0; i < i3; i++) {
                    this.f31676b.mo5731a(this.f31677c, 0, this.f31677c.length);
                    this.f31676b.mo5731a(bArr2, 0, bArr2.length);
                    if (this.f31678d != null) {
                        this.f31676b.mo5731a(this.f31678d, 0, this.f31678d.length);
                    }
                    this.f31676b.mo5728a(obj, 0);
                    if (i2 > b) {
                        System.arraycopy(obj, 0, bArr, i5, b);
                        i5 += b;
                        i2 -= b;
                    } else {
                        System.arraycopy(obj, 0, bArr, i5, i2);
                    }
                    byte b2 = (byte) (bArr2[3] + 1);
                    bArr2[3] = b2;
                    if (b2 == (byte) 0) {
                        i4 += 256;
                        Pack.m29400a(i4, bArr2, 0);
                    }
                }
                this.f31676b.mo5733c();
                return (int) j;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new DataLengthException("output buffer too small");
    }
}
