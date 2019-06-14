package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class RFC5649WrapEngine implements Wrapper {
    /* renamed from: a */
    private BlockCipher f26732a;
    /* renamed from: b */
    private KeyParameter f26733b;
    /* renamed from: c */
    private boolean f26734c;
    /* renamed from: d */
    private byte[] f26735d = new byte[]{(byte) -90, (byte) 89, (byte) 89, (byte) -90};
    /* renamed from: e */
    private byte[] f26736e = this.f26735d;
    /* renamed from: f */
    private byte[] f26737f = null;

    public RFC5649WrapEngine(BlockCipher blockCipher) {
        this.f26732a = blockCipher;
    }

    /* renamed from: a */
    public void mo5746a(boolean z, CipherParameters cipherParameters) {
        this.f26734c = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).m35698b();
        }
        if (cipherParameters instanceof KeyParameter) {
            this.f26733b = (KeyParameter) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f26736e = parametersWithIV.m35695a();
            this.f26733b = (KeyParameter) parametersWithIV.m35696b();
            if (!this.f26736e.length) {
                throw new IllegalArgumentException("IV length not equal to 4");
            }
        }
    }

    /* renamed from: a */
    public String mo5745a() {
        return this.f26732a.mo5741a();
    }

    /* renamed from: a */
    private byte[] m35119a(byte[] bArr) {
        int length = bArr.length;
        int i = (8 - (length % 8)) % 8;
        Object obj = new byte[(length + i)];
        System.arraycopy(bArr, 0, obj, 0, length);
        if (i != 0) {
            System.arraycopy(new byte[i], 0, obj, length, i);
        }
        return obj;
    }

    /* renamed from: a */
    public byte[] mo5747a(byte[] bArr, int i, int i2) {
        if (this.f26734c) {
            Object obj = new byte[8];
            Object a = Pack.m29404a(i2);
            int i3 = 0;
            System.arraycopy(this.f26736e, 0, obj, 0, this.f26736e.length);
            System.arraycopy(a, 0, obj, this.f26736e.length, a.length);
            a = new byte[i2];
            System.arraycopy(bArr, i, a, 0, i2);
            bArr = m35119a(a);
            if (bArr.length == 8) {
                i = new byte[(bArr.length + obj.length)];
                System.arraycopy(obj, 0, i, 0, obj.length);
                System.arraycopy(bArr, 0, i, obj.length, bArr.length);
                this.f26732a.mo5742a(true, this.f26733b);
                while (i3 < i.length) {
                    this.f26732a.mo5740a(i, i3, i, i3);
                    i3 += this.f26732a.mo5743b();
                }
                return i;
            }
            i = new RFC3394WrapEngine(this.f26732a);
            i.mo5746a(true, new ParametersWithIV(this.f26733b, obj));
            return i.mo5747a(bArr, 0, bArr.length);
        }
        throw new IllegalStateException("not set for wrapping");
    }

    /* renamed from: b */
    public byte[] mo5748b(byte[] bArr, int i, int i2) {
        if (this.f26734c) {
            throw new IllegalStateException("not set for unwrapping");
        }
        int i3 = i2 / 8;
        if (i3 * 8 != i2) {
            throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
        } else if (i3 != 1) {
            Object obj = new byte[i2];
            System.arraycopy(bArr, i, obj, 0, i2);
            Object obj2 = new byte[i2];
            if (i3 == 2) {
                this.f26732a.mo5742a(false, this.f26733b);
                bArr = null;
                while (bArr < obj.length) {
                    this.f26732a.mo5740a(obj, bArr, obj2, bArr);
                    bArr += this.f26732a.mo5743b();
                }
                this.f26737f = new byte[8];
                System.arraycopy(obj2, 0, this.f26737f, 0, this.f26737f.length);
                bArr = new byte[(obj2.length - this.f26737f.length)];
                System.arraycopy(obj2, this.f26737f.length, bArr, 0, bArr.length);
            } else {
                bArr = m35120c(bArr, i, i2);
            }
            byte[] bArr2 = new byte[4];
            i = new byte[4];
            System.arraycopy(this.f26737f, 0, bArr2, 0, bArr2.length);
            System.arraycopy(this.f26737f, bArr2.length, i, 0, i.length);
            i = Pack.m29399a(i, 0);
            i2 = Arrays.m29372b(bArr2, this.f26736e);
            i3 = bArr.length;
            if (i <= i3 - 8) {
                i2 = 0;
            }
            if (i > i3) {
                i2 = 0;
            }
            i3 -= i;
            if (i3 >= bArr.length) {
                i3 = bArr.length;
                i2 = 0;
            }
            byte[] bArr3 = new byte[i3];
            byte[] bArr4 = new byte[i3];
            System.arraycopy(bArr, bArr.length - i3, bArr4, 0, i3);
            if (!Arrays.m29372b(bArr4, bArr3)) {
                i2 = 0;
            }
            if (i2 != 0) {
                i = new byte[i];
                System.arraycopy(bArr, 0, i, 0, i.length);
                return i;
            }
            throw new InvalidCipherTextException("checksum failed");
        } else {
            throw new InvalidCipherTextException("unwrap data must be at least 16 bytes");
        }
    }

    /* renamed from: c */
    private byte[] m35120c(byte[] bArr, int i, int i2) {
        Object obj = bArr;
        int i3 = i;
        byte[] bArr2 = new byte[8];
        Object obj2 = new byte[(i2 - bArr2.length)];
        Object obj3 = new byte[bArr2.length];
        Object obj4 = new byte[(bArr2.length + 8)];
        System.arraycopy(obj, i3, obj3, 0, bArr2.length);
        System.arraycopy(obj, i3 + bArr2.length, obj2, 0, i2 - bArr2.length);
        this.f26732a.mo5742a(false, this.f26733b);
        int i4 = (i2 / 8) - 1;
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = i4; i6 >= 1; i6--) {
                System.arraycopy(obj3, 0, obj4, 0, bArr2.length);
                int i7 = (i6 - 1) * 8;
                System.arraycopy(obj2, i7, obj4, bArr2.length, 8);
                int i8 = (i4 * i5) + i6;
                int i9 = 1;
                while (i8 != 0) {
                    int length = bArr2.length - i9;
                    obj4[length] = (byte) (obj4[length] ^ ((byte) i8));
                    i8 >>>= 8;
                    i9++;
                }
                r0.f26732a.mo5740a(obj4, 0, obj4, 0);
                System.arraycopy(obj4, 0, obj3, 0, 8);
                System.arraycopy(obj4, 8, obj2, i7, 8);
            }
        }
        r0.f26737f = obj3;
        return obj2;
    }
}
