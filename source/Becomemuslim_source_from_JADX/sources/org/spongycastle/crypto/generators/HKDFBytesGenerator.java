package org.spongycastle.crypto.generators;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.HKDFParameters;
import org.spongycastle.crypto.params.KeyParameter;

public class HKDFBytesGenerator implements DerivationFunction {
    /* renamed from: a */
    private HMac f26841a;
    /* renamed from: b */
    private int f26842b;
    /* renamed from: c */
    private byte[] f26843c;
    /* renamed from: d */
    private byte[] f26844d;
    /* renamed from: e */
    private int f26845e;

    /* renamed from: a */
    public void mo5727a(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof HKDFParameters) {
            HKDFParameters hKDFParameters = (HKDFParameters) derivationParameters;
            if (hKDFParameters.m35663b()) {
                this.f26841a.mo5764a(new KeyParameter(hKDFParameters.m35662a()));
            } else {
                this.f26841a.mo5764a(m35338a(hKDFParameters.m35664c(), hKDFParameters.m35662a()));
            }
            this.f26843c = hKDFParameters.m35665d();
            this.f26845e = null;
            this.f26844d = new byte[this.f26842b];
            return;
        }
        throw new IllegalArgumentException("HKDF parameters required for HKDFBytesGenerator");
    }

    /* renamed from: a */
    private KeyParameter m35338a(byte[] bArr, byte[] bArr2) {
        this.f26841a.mo5764a(new KeyParameter(bArr2));
        if (bArr == null) {
            this.f26841a.mo5764a(new KeyParameter(new byte[this.f26842b]));
        } else {
            this.f26841a.mo5764a(new KeyParameter(bArr));
        }
        this.f26841a.mo5765a(bArr2, 0, bArr2.length);
        bArr = new byte[this.f26842b];
        this.f26841a.mo5761a(bArr, 0);
        return new KeyParameter(bArr);
    }

    /* renamed from: a */
    private void m35339a() {
        int i = (this.f26845e / this.f26842b) + 1;
        if (i < 256) {
            if (this.f26845e != 0) {
                this.f26841a.mo5765a(this.f26844d, 0, this.f26842b);
            }
            this.f26841a.mo5765a(this.f26843c, 0, this.f26843c.length);
            this.f26841a.mo5763a((byte) i);
            this.f26841a.mo5761a(this.f26844d, 0);
            return;
        }
        throw new DataLengthException("HKDF cannot generate more than 255 blocks of HashLen size");
    }

    /* renamed from: a */
    public int mo5726a(byte[] bArr, int i, int i2) {
        if (this.f26845e + i2 <= this.f26842b * JfifUtil.MARKER_FIRST_BYTE) {
            if (this.f26845e % this.f26842b == 0) {
                m35339a();
            }
            int i3 = this.f26845e % this.f26842b;
            int min = Math.min(this.f26842b - (this.f26845e % this.f26842b), i2);
            System.arraycopy(this.f26844d, i3, bArr, i, min);
            this.f26845e += min;
            i3 = i2 - min;
            i += min;
            while (i3 > 0) {
                m35339a();
                min = Math.min(this.f26842b, i3);
                System.arraycopy(this.f26844d, 0, bArr, i, min);
                this.f26845e += min;
                i3 -= min;
                i += min;
            }
            return i2;
        }
        throw new DataLengthException("HKDF may only be used for 255 * HashLen bytes of output");
    }
}
