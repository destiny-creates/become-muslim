package org.spongycastle.jce.provider;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

/* compiled from: BrokenPBE */
class OldPKCS12ParametersGenerator extends PBEParametersGenerator {
    /* renamed from: d */
    private Digest f27591d;
    /* renamed from: e */
    private int f27592e;
    /* renamed from: f */
    private int f27593f;

    /* renamed from: a */
    private void m36210a(byte[] bArr, int i, byte[] bArr2) {
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
    private byte[] m36211b(int i, int i2) {
        int i3;
        Object obj;
        byte[] bArr = new byte[this.f27593f];
        Object obj2 = new byte[i2];
        for (int i4 = 0; i4 != bArr.length; i4++) {
            bArr[i4] = (byte) i;
        }
        if (this.b == 0 || this.b.length == 0) {
            i = new byte[0];
        } else {
            i = new byte[(this.f27593f * (((this.b.length + this.f27593f) - 1) / this.f27593f))];
            for (i3 = 0; i3 != i.length; i3++) {
                i[i3] = this.b[i3 % this.b.length];
            }
        }
        if (this.a == null || this.a.length == 0) {
            obj = new byte[0];
        } else {
            obj = new byte[(this.f27593f * (((this.a.length + this.f27593f) - 1) / this.f27593f))];
            for (int i5 = 0; i5 != obj.length; i5++) {
                obj[i5] = this.a[i5 % this.a.length];
            }
        }
        Object obj3 = new byte[(i.length + obj.length)];
        System.arraycopy(i, 0, obj3, 0, i.length);
        System.arraycopy(obj, 0, obj3, i.length, obj.length);
        i = new byte[this.f27593f];
        i2 = ((i2 + this.f27592e) - 1) / this.f27592e;
        for (i3 = 1; i3 <= i2; i3++) {
            int i6;
            Object obj4 = new byte[this.f27592e];
            this.f27591d.mo5731a(bArr, 0, bArr.length);
            this.f27591d.mo5731a(obj3, 0, obj3.length);
            this.f27591d.mo5728a(obj4, 0);
            for (i6 = 1; i6 != this.c; i6++) {
                this.f27591d.mo5731a(obj4, 0, obj4.length);
                this.f27591d.mo5728a(obj4, 0);
            }
            for (i6 = 0; i6 != i.length; i6++) {
                i[i3] = obj4[i6 % obj4.length];
            }
            for (i6 = 0; i6 != obj3.length / this.f27593f; i6++) {
                m36210a(obj3, this.f27593f * i6, i);
            }
            if (i3 == i2) {
                i6 = i3 - 1;
                System.arraycopy(obj4, 0, obj2, this.f27592e * i6, obj2.length - (i6 * this.f27592e));
            } else {
                System.arraycopy(obj4, 0, obj2, (i3 - 1) * this.f27592e, obj4.length);
            }
        }
        return obj2;
    }

    /* renamed from: a */
    public CipherParameters mo5758a(int i) {
        i /= 8;
        return new KeyParameter(m36211b(1, i), 0, i);
    }

    /* renamed from: a */
    public CipherParameters mo5759a(int i, int i2) {
        i /= 8;
        i2 /= 8;
        byte[] b = m36211b(1, i);
        return new ParametersWithIV(new KeyParameter(b, 0, i), m36211b(2, i2), 0, i2);
    }

    /* renamed from: b */
    public CipherParameters mo5760b(int i) {
        i /= 8;
        return new KeyParameter(m36211b(3, i), 0, i);
    }
}
