package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class yh implements ts {
    /* renamed from: a */
    private final SecretKey f24397a;

    public yh(byte[] bArr) {
        this.f24397a = new SecretKeySpec(bArr, "AES");
    }

    /* renamed from: a */
    public final byte[] mo4385a(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= 2147483619) {
            Object obj = new byte[((bArr.length + 12) + 16)];
            Object a = zk.m20197a(12);
            System.arraycopy(a, 0, obj, 0, 12);
            Cipher cipher = (Cipher) yw.f16111a.m20184a("AES/GCM/NoPadding");
            cipher.init(1, this.f24397a, new GCMParameterSpec(128, a));
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            cipher.updateAAD(bArr2);
            cipher.doFinal(bArr, 0, bArr.length, obj, 12);
            return obj;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
