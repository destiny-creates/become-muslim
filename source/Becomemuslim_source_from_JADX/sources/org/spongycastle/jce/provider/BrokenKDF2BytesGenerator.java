package org.spongycastle.jce.provider;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.KDFParameters;

public class BrokenKDF2BytesGenerator implements DerivationFunction {
    /* renamed from: a */
    private Digest f27577a;
    /* renamed from: b */
    private byte[] f27578b;
    /* renamed from: c */
    private byte[] f27579c;

    /* renamed from: a */
    public void mo5727a(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters) derivationParameters;
            this.f27578b = kDFParameters.m35683a();
            this.f27579c = kDFParameters.m35684b();
            return;
        }
        throw new IllegalArgumentException("KDF parameters required for KDF2Generator");
    }

    /* renamed from: a */
    public int mo5726a(byte[] bArr, int i, int i2) {
        if (bArr.length - i2 >= i) {
            long j = (long) (i2 * 8);
            if (j > ((long) (this.f27577a.mo5732b() * 8)) * 29) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Output length to large");
            }
            int b = (int) (j / ((long) this.f27577a.mo5732b()));
            Object obj = new byte[this.f27577a.mo5732b()];
            for (int i3 = 1; i3 <= b; i3++) {
                this.f27577a.mo5731a(this.f27578b, 0, this.f27578b.length);
                this.f27577a.mo5730a((byte) (i3 & JfifUtil.MARKER_FIRST_BYTE));
                this.f27577a.mo5730a((byte) ((i3 >> 8) & JfifUtil.MARKER_FIRST_BYTE));
                this.f27577a.mo5730a((byte) ((i3 >> 16) & JfifUtil.MARKER_FIRST_BYTE));
                this.f27577a.mo5730a((byte) ((i3 >> 24) & JfifUtil.MARKER_FIRST_BYTE));
                this.f27577a.mo5731a(this.f27579c, 0, this.f27579c.length);
                this.f27577a.mo5728a(obj, 0);
                int i4 = i2 - i;
                if (i4 > obj.length) {
                    System.arraycopy(obj, 0, bArr, i, obj.length);
                    i += obj.length;
                } else {
                    System.arraycopy(obj, 0, bArr, i, i4);
                }
            }
            this.f27577a.mo5733c();
            return i2;
        }
        throw new DataLengthException("output buffer too small");
    }
}
