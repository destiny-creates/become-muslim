package org.spongycastle.crypto.agreement.kdf;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.KDFParameters;

public class ConcatenationKDFGenerator implements DerivationFunction {
    /* renamed from: a */
    private Digest f26476a;
    /* renamed from: b */
    private byte[] f26477b;
    /* renamed from: c */
    private byte[] f26478c;
    /* renamed from: d */
    private int f26479d;

    public ConcatenationKDFGenerator(Digest digest) {
        this.f26476a = digest;
        this.f26479d = digest.mo5732b();
    }

    /* renamed from: a */
    public void mo5727a(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters) derivationParameters;
            this.f26477b = kDFParameters.m35683a();
            this.f26478c = kDFParameters.m35684b();
            return;
        }
        throw new IllegalArgumentException("KDF parameters required for KDF2Generator");
    }

    /* renamed from: a */
    private void m34715a(int i, byte[] bArr) {
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) (i >>> 0);
    }

    /* renamed from: a */
    public int mo5726a(byte[] bArr, int i, int i2) {
        if (bArr.length - i2 >= i) {
            int i3;
            Object obj = new byte[this.f26479d];
            byte[] bArr2 = new byte[4];
            this.f26476a.mo5733c();
            int i4 = 1;
            if (i2 > this.f26479d) {
                int i5;
                i3 = 0;
                while (true) {
                    m34715a(i4, bArr2);
                    this.f26476a.mo5731a(bArr2, 0, bArr2.length);
                    this.f26476a.mo5731a(this.f26477b, 0, this.f26477b.length);
                    this.f26476a.mo5731a(this.f26478c, 0, this.f26478c.length);
                    this.f26476a.mo5728a(obj, 0);
                    System.arraycopy(obj, 0, bArr, i + i3, this.f26479d);
                    i3 += this.f26479d;
                    i5 = i4 + 1;
                    if (i4 >= i2 / this.f26479d) {
                        break;
                    }
                    i4 = i5;
                }
                i4 = i5;
            } else {
                i3 = 0;
            }
            if (i3 < i2) {
                m34715a(i4, bArr2);
                this.f26476a.mo5731a(bArr2, 0, bArr2.length);
                this.f26476a.mo5731a(this.f26477b, 0, this.f26477b.length);
                this.f26476a.mo5731a(this.f26478c, 0, this.f26478c.length);
                this.f26476a.mo5728a(obj, 0);
                System.arraycopy(obj, 0, bArr, i + i3, i2 - i3);
            }
            return i2;
        }
        throw new DataLengthException("output buffer too small");
    }
}
