package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

public final class zk {
    /* renamed from: a */
    private static final ThreadLocal<SecureRandom> f16124a = new zl();

    /* renamed from: a */
    public static byte[] m20197a(int i) {
        byte[] bArr = new byte[i];
        ((SecureRandom) f16124a.get()).nextBytes(bArr);
        return bArr;
    }

    /* renamed from: b */
    private static SecureRandom m20198b() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }
}
