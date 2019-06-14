package org.spongycastle.crypto.generators;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class PKCS12ParametersGenerator extends PBEParametersGenerator {
    /* renamed from: d */
    private Digest f26853d;
    /* renamed from: e */
    private int f26854e;
    /* renamed from: f */
    private int f26855f;

    public PKCS12ParametersGenerator(Digest digest) {
        this.f26853d = digest;
        if (digest instanceof ExtendedDigest) {
            this.f26854e = digest.mo5732b();
            this.f26855f = ((ExtendedDigest) digest).mo6445d();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Digest ");
        stringBuilder.append(digest.mo5729a());
        stringBuilder.append(" unsupported");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    private void m35355a(byte[] bArr, int i, byte[] bArr2) {
        int i2 = ((bArr2[bArr2.length - 1] & JfifUtil.MARKER_FIRST_BYTE) + (bArr[(bArr2.length + i) - 1] & JfifUtil.MARKER_FIRST_BYTE)) + 1;
        bArr[(bArr2.length + i) - 1] = (byte) i2;
        i2 >>>= 8;
        for (int length = bArr2.length - 2; length >= 0; length--) {
            int i3 = i + length;
            i2 += (bArr2[length] & JfifUtil.MARKER_FIRST_BYTE) + (bArr[i3] & JfifUtil.MARKER_FIRST_BYTE);
            bArr[i3] = (byte) i2;
            i2 >>>= 8;
        }
    }

    /* renamed from: b */
    private byte[] m35356b(int i, int i2) {
        Object obj;
        byte[] bArr = new byte[this.f26855f];
        Object obj2 = new byte[i2];
        for (int i3 = 0; i3 != bArr.length; i3++) {
            bArr[i3] = (byte) i;
        }
        if (this.b == 0 || this.b.length == 0) {
            i = new byte[0];
        } else {
            i = new byte[(this.f26855f * (((this.b.length + this.f26855f) - 1) / this.f26855f))];
            for (int i4 = 0; i4 != i.length; i4++) {
                i[i4] = this.b[i4 % this.b.length];
            }
        }
        if (this.a == null || this.a.length == 0) {
            obj = new byte[0];
        } else {
            obj = new byte[(this.f26855f * (((this.a.length + this.f26855f) - 1) / this.f26855f))];
            for (int i5 = 0; i5 != obj.length; i5++) {
                obj[i5] = this.a[i5 % this.a.length];
            }
        }
        Object obj3 = new byte[(i.length + obj.length)];
        System.arraycopy(i, 0, obj3, 0, i.length);
        System.arraycopy(obj, 0, obj3, i.length, obj.length);
        i = new byte[this.f26855f];
        i2 = ((i2 + this.f26854e) - 1) / this.f26854e;
        obj = new byte[this.f26854e];
        for (int i6 = 1; i6 <= i2; i6++) {
            int i7;
            this.f26853d.mo5731a(bArr, 0, bArr.length);
            this.f26853d.mo5731a(obj3, 0, obj3.length);
            this.f26853d.mo5728a(obj, 0);
            for (i7 = 1; i7 < this.c; i7++) {
                this.f26853d.mo5731a(obj, 0, obj.length);
                this.f26853d.mo5728a(obj, 0);
            }
            for (i7 = 0; i7 != i.length; i7++) {
                i[i7] = obj[i7 % obj.length];
            }
            for (i7 = 0; i7 != obj3.length / this.f26855f; i7++) {
                m35355a(obj3, this.f26855f * i7, i);
            }
            if (i6 == i2) {
                i7 = i6 - 1;
                System.arraycopy(obj, 0, obj2, this.f26854e * i7, obj2.length - (i7 * this.f26854e));
            } else {
                System.arraycopy(obj, 0, obj2, (i6 - 1) * this.f26854e, obj.length);
            }
        }
        return obj2;
    }

    /* renamed from: a */
    public CipherParameters mo5758a(int i) {
        i /= 8;
        return new KeyParameter(m35356b(1, i), 0, i);
    }

    /* renamed from: a */
    public CipherParameters mo5759a(int i, int i2) {
        i /= 8;
        i2 /= 8;
        byte[] b = m35356b(1, i);
        return new ParametersWithIV(new KeyParameter(b, 0, i), m35356b(2, i2), 0, i2);
    }

    /* renamed from: b */
    public CipherParameters mo5760b(int i) {
        i /= 8;
        return new KeyParameter(m35356b(3, i), 0, i);
    }
}
