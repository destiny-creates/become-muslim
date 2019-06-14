package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.regex.Pattern;

public final class zp {
    /* renamed from: a */
    private static final Pattern f16125a = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s$", new Object[]{"([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+"}), 2);
    /* renamed from: b */
    private static final Pattern f16126b = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/%s$", new Object[]{"([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+"}), 2);

    /* renamed from: a */
    public static void m20200a(int i) {
        if (i != 16 && i != 24) {
            if (i != 32) {
                throw new GeneralSecurityException("invalid AES key size");
            }
        }
    }

    /* renamed from: a */
    public static void m20201a(int i, int i2) {
        if (i < 0 || i > 0) {
            throw new GeneralSecurityException(String.format("key has version %d; only keys with version in range [0..%d] are supported", new Object[]{Integer.valueOf(i), Integer.valueOf(0)}));
        }
    }
}
