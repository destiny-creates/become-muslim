package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class PKCS5S2ParametersGenerator extends PBEParametersGenerator {
    /* renamed from: d */
    private Mac f26857d;
    /* renamed from: e */
    private byte[] f26858e;

    public PKCS5S2ParametersGenerator() {
        this(new SHA1Digest());
    }

    public PKCS5S2ParametersGenerator(Digest digest) {
        this.f26857d = new HMac(digest);
        this.f26858e = new byte[this.f26857d.mo5766b()];
    }

    /* renamed from: a */
    private void m35364a(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2) {
        if (i != 0) {
            if (bArr != null) {
                this.f26857d.mo5765a(bArr, 0, bArr.length);
            }
            this.f26857d.mo5765a(bArr2, 0, bArr2.length);
            this.f26857d.mo5761a(this.f26858e, 0);
            System.arraycopy(this.f26858e, 0, bArr3, i2, this.f26858e.length);
            for (bArr = 1; bArr < i; bArr++) {
                this.f26857d.mo5765a(this.f26858e, 0, this.f26858e.length);
                this.f26857d.mo5761a(this.f26858e, 0);
                for (bArr2 = null; bArr2 != this.f26858e.length; bArr2++) {
                    int i3 = i2 + bArr2;
                    bArr3[i3] = (byte) (bArr3[i3] ^ this.f26858e[bArr2]);
                }
            }
            return;
        }
        throw new IllegalArgumentException("iteration count must be at least 1.");
    }

    /* renamed from: c */
    private byte[] m35365c(int i) {
        int b = this.f26857d.mo5766b();
        i = ((i + b) - 1) / b;
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[(i * b)];
        this.f26857d.mo5764a(new KeyParameter(this.a));
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            int i4 = 3;
            while (true) {
                byte b2 = (byte) (bArr[i4] + 1);
                bArr[i4] = b2;
                if (b2 != (byte) 0) {
                    break;
                }
                i4--;
            }
            m35364a(this.b, this.c, bArr, bArr2, i2);
            i2 += b;
        }
        return bArr2;
    }

    /* renamed from: a */
    public CipherParameters mo5758a(int i) {
        i /= 8;
        return new KeyParameter(Arrays.m29361a(m35365c(i), 0, i), 0, i);
    }

    /* renamed from: a */
    public CipherParameters mo5759a(int i, int i2) {
        i /= 8;
        i2 /= 8;
        byte[] c = m35365c(i + i2);
        return new ParametersWithIV(new KeyParameter(c, 0, i), c, i, i2);
    }

    /* renamed from: b */
    public CipherParameters mo5760b(int i) {
        return mo5758a(i);
    }
}
