package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class yf implements zh {
    /* renamed from: a */
    private final SecretKeySpec f24390a;
    /* renamed from: b */
    private final int f24391b;
    /* renamed from: c */
    private final int f24392c = ((Cipher) yw.f16111a.m20184a("AES/CTR/NoPadding")).getBlockSize();

    public yf(byte[] bArr, int i) {
        this.f24390a = new SecretKeySpec(bArr, "AES");
        if (i < 12 || i > this.f24392c) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.f24391b = i;
    }

    /* renamed from: a */
    public final byte[] mo4391a(byte[] bArr) {
        if (bArr.length <= Integer.MAX_VALUE - this.f24391b) {
            Object obj = new byte[(this.f24391b + bArr.length)];
            Object a = zk.m20197a(this.f24391b);
            System.arraycopy(a, 0, obj, 0, this.f24391b);
            int length = bArr.length;
            int i = this.f24391b;
            Cipher cipher = (Cipher) yw.f16111a.m20184a("AES/CTR/NoPadding");
            Object obj2 = new byte[this.f24392c];
            System.arraycopy(a, 0, obj2, 0, this.f24391b);
            cipher.init(1, this.f24390a, new IvParameterSpec(obj2));
            if (cipher.doFinal(bArr, 0, length, obj, i) == length) {
                return obj;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        int i2 = Integer.MAX_VALUE - this.f24391b;
        StringBuilder stringBuilder = new StringBuilder(43);
        stringBuilder.append("plaintext length can not exceed ");
        stringBuilder.append(i2);
        throw new GeneralSecurityException(stringBuilder.toString());
    }
}
