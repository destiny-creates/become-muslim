package org.spongycastle.crypto.encodings;

import com.facebook.imageutils.JfifUtil;
import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;

public class ISO9796d1Encoding implements AsymmetricBlockCipher {
    /* renamed from: a */
    private static final BigInteger f26500a = BigInteger.valueOf(16);
    /* renamed from: b */
    private static final BigInteger f26501b = BigInteger.valueOf(6);
    /* renamed from: c */
    private static byte[] f26502c = new byte[]{(byte) 14, (byte) 3, (byte) 5, (byte) 8, (byte) 9, (byte) 4, (byte) 2, (byte) 15, (byte) 0, (byte) 13, (byte) 11, (byte) 6, (byte) 7, (byte) 10, (byte) 12, (byte) 1};
    /* renamed from: d */
    private static byte[] f26503d = new byte[]{(byte) 8, (byte) 15, (byte) 6, (byte) 1, (byte) 5, (byte) 2, (byte) 11, (byte) 12, (byte) 3, (byte) 4, (byte) 13, (byte) 10, (byte) 14, (byte) 9, (byte) 0, (byte) 7};
    /* renamed from: e */
    private AsymmetricBlockCipher f26504e;
    /* renamed from: f */
    private boolean f26505f;
    /* renamed from: g */
    private int f26506g;
    /* renamed from: h */
    private int f26507h = 0;
    /* renamed from: i */
    private BigInteger f26508i;

    public ISO9796d1Encoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f26504e = asymmetricBlockCipher;
    }

    /* renamed from: a */
    public void mo5737a(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters;
        if (cipherParameters instanceof ParametersWithRandom) {
            rSAKeyParameters = (RSAKeyParameters) ((ParametersWithRandom) cipherParameters).m35698b();
        } else {
            rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        }
        this.f26504e.mo5737a(z, cipherParameters);
        this.f26508i = rSAKeyParameters.m40800b();
        this.f26506g = this.f26508i.bitLength();
        this.f26505f = z;
    }

    /* renamed from: a */
    public int mo5736a() {
        int a = this.f26504e.mo5736a();
        return this.f26505f ? (a + 1) / 2 : a;
    }

    /* renamed from: b */
    public int mo5739b() {
        int b = this.f26504e.mo5739b();
        if (this.f26505f) {
            return b;
        }
        return (b + 1) / 2;
    }

    /* renamed from: a */
    public byte[] mo5738a(byte[] bArr, int i, int i2) {
        if (this.f26505f) {
            return m34783b(bArr, i, i2);
        }
        return m34784c(bArr, i, i2);
    }

    /* renamed from: b */
    private byte[] m34783b(byte[] bArr, int i, int i2) {
        Object obj = new byte[((this.f26506g + 7) / 8)];
        int i3 = 1;
        int i4 = this.f26507h + 1;
        int i5 = (this.f26506g + 13) / 16;
        int i6 = 0;
        while (i6 < i5) {
            if (i6 > i5 - i2) {
                int i7 = i5 - i6;
                System.arraycopy(bArr, (i + i2) - i7, obj, obj.length - i5, i7);
            } else {
                System.arraycopy(bArr, i, obj, obj.length - (i6 + i2), i2);
            }
            i6 += i2;
        }
        for (bArr = obj.length - (i5 * 2); bArr != obj.length; bArr += 2) {
            i = obj[(obj.length - i5) + (bArr / 2)];
            obj[bArr] = (byte) ((f26502c[(i & JfifUtil.MARKER_FIRST_BYTE) >>> 4] << 4) | f26502c[i & 15]);
            obj[bArr + 1] = i;
        }
        bArr = obj.length - (i2 * 2);
        obj[bArr] = (byte) (obj[bArr] ^ i4);
        obj[obj.length - 1] = (byte) ((obj[obj.length - 1] << 4) | 6);
        bArr = 8 - ((this.f26506g - 1) % 8);
        if (bArr != 8) {
            obj[0] = (byte) (obj[0] & (JfifUtil.MARKER_FIRST_BYTE >>> bArr));
            obj[0] = (byte) ((128 >>> bArr) | obj[0]);
            i3 = 0;
        } else {
            obj[0] = null;
            obj[1] = (byte) (obj[1] | 128);
        }
        return this.f26504e.mo5738a(obj, i3, obj.length - i3);
    }

    /* renamed from: c */
    private byte[] m34784c(byte[] bArr, int i, int i2) {
        bArr = this.f26504e.mo5738a(bArr, i, i2);
        i = (this.f26506g + 13) / 16;
        i2 = new BigInteger(1, bArr);
        if (i2.mod(f26500a).equals(f26501b) == null) {
            if (this.f26508i.subtract(i2).mod(f26500a).equals(f26501b) != null) {
                i2 = this.f26508i.subtract(i2);
            } else {
                throw new InvalidCipherTextException("resulting integer iS or (modulus - iS) is not congruent to 6 mod 16");
            }
        }
        bArr = m34782a(i2);
        if ((bArr[bArr.length - 1] & 15) == 6) {
            bArr[bArr.length - 1] = (byte) (((bArr[bArr.length - 1] & JfifUtil.MARKER_FIRST_BYTE) >>> 4) | (f26503d[(bArr[bArr.length - 2] & JfifUtil.MARKER_FIRST_BYTE) >> 4] << 4));
            int i3 = 0;
            bArr[0] = (byte) ((f26502c[(bArr[1] & JfifUtil.MARKER_FIRST_BYTE) >>> 4] << 4) | f26502c[bArr[1] & 15]);
            int i4 = 0;
            Object obj = null;
            int i5 = 1;
            for (i2 = bArr.length - 1; i2 >= bArr.length - (i * 2); i2 -= 2) {
                int i6 = (f26502c[(bArr[i2] & JfifUtil.MARKER_FIRST_BYTE) >>> 4] << 4) | f26502c[bArr[i2] & 15];
                int i7 = i2 - 1;
                if (((bArr[i7] ^ i6) & JfifUtil.MARKER_FIRST_BYTE) != 0) {
                    if (obj == null) {
                        i5 = (bArr[i7] ^ i6) & JfifUtil.MARKER_FIRST_BYTE;
                        i4 = i7;
                        obj = 1;
                    } else {
                        throw new InvalidCipherTextException("invalid tsums in block");
                    }
                }
            }
            bArr[i4] = (byte) 0;
            i = new byte[((bArr.length - i4) / 2)];
            while (i3 < i.length) {
                i[i3] = bArr[((i3 * 2) + i4) + 1];
                i3++;
            }
            this.f26507h = i5 - 1;
            return i;
        }
        throw new InvalidCipherTextException("invalid forcing byte in block");
    }

    /* renamed from: a */
    private static byte[] m34782a(BigInteger bigInteger) {
        bigInteger = bigInteger.toByteArray();
        if (bigInteger[0] != (byte) 0) {
            return bigInteger;
        }
        Object obj = new byte[(bigInteger.length - 1)];
        System.arraycopy(bigInteger, 1, obj, 0, obj.length);
        return obj;
    }
}
