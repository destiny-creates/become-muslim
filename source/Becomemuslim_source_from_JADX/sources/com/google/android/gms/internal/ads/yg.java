package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class yg implements ts {
    /* renamed from: a */
    private final byte[] f24393a;
    /* renamed from: b */
    private final byte[] f24394b;
    /* renamed from: c */
    private final SecretKeySpec f24395c;
    /* renamed from: d */
    private final int f24396d;

    public yg(byte[] bArr, int i) {
        if (i != 12) {
            if (i != 16) {
                throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
            }
        }
        this.f24396d = i;
        this.f24395c = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/NOPADDING");
        instance.init(1, this.f24395c);
        this.f24393a = m31237a(instance.doFinal(new byte[16]));
        this.f24394b = m31237a(this.f24393a);
    }

    /* renamed from: a */
    private final byte[] m31236a(Cipher cipher, int i, byte[] bArr, int i2, int i3) {
        byte[] b;
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i;
        if (i3 == 0) {
            b = m31238b(bArr2, this.f24393a);
        } else {
            b = cipher.doFinal(bArr2);
            byte[] bArr3 = b;
            i = 0;
            while (i3 - i > 16) {
                for (int i4 = 0; i4 < 16; i4++) {
                    bArr3[i4] = (byte) (bArr3[i4] ^ bArr[(i2 + i) + i4]);
                }
                bArr3 = cipher.doFinal(bArr3);
                i += 16;
            }
            b = Arrays.copyOfRange(bArr, i + i2, i2 + i3);
            if (b.length == 16) {
                b = m31238b(b, this.f24393a);
            } else {
                bArr = Arrays.copyOf(this.f24394b, 16);
                for (int i5 = 0; i5 < b.length; i5++) {
                    bArr[i5] = (byte) (bArr[i5] ^ b[i5]);
                }
                bArr[b.length] = (byte) (bArr[b.length] ^ 128);
                b = bArr;
            }
            b = m31238b(bArr3, b);
        }
        return cipher.doFinal(b);
    }

    /* renamed from: a */
    private static byte[] m31237a(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) ((bArr[i2] << 1) ^ ((bArr[i3] & JfifUtil.MARKER_FIRST_BYTE) >>> 7));
            i2 = i3;
        }
        i2 = bArr[15] << 1;
        if ((bArr[0] & 128) != 0) {
            i = 135;
        }
        bArr2[15] = (byte) (i2 ^ i);
        return bArr2;
    }

    /* renamed from: b */
    private static byte[] m31238b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    /* renamed from: a */
    public final byte[] mo4385a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        if (bArr3.length <= (Integer.MAX_VALUE - this.f24396d) - 16) {
            Object obj = new byte[((r6.f24396d + bArr3.length) + 16)];
            Object a = zk.m20197a(r6.f24396d);
            int i = 0;
            System.arraycopy(a, 0, obj, 0, r6.f24396d);
            Cipher instance = Cipher.getInstance("AES/ECB/NOPADDING");
            instance.init(1, r6.f24395c);
            byte[] a2 = m31236a(instance, 0, a, 0, a.length);
            byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
            byte[] a3 = m31236a(instance, 1, bArr4, 0, bArr4.length);
            Cipher instance2 = Cipher.getInstance("AES/CTR/NOPADDING");
            instance2.init(1, r6.f24395c, new IvParameterSpec(a2));
            instance2.doFinal(bArr, 0, bArr3.length, obj, r6.f24396d);
            byte[] a4 = m31236a(instance, 2, obj, r6.f24396d, bArr3.length);
            int length = bArr3.length + r6.f24396d;
            while (i < 16) {
                obj[length + i] = (byte) ((a3[i] ^ a2[i]) ^ a4[i]);
                i++;
            }
            return obj;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
