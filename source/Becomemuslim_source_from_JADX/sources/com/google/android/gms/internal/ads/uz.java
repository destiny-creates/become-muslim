package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class uz implements tu<tz> {
    /* renamed from: a */
    public final ua<tz> mo4378a(String str, String str2, int i) {
        Object obj;
        ua uwVar;
        String toLowerCase = str2.toLowerCase();
        Object obj2 = -1;
        if (toLowerCase.hashCode() == 1420614889) {
            if (toLowerCase.equals("hybridencrypt")) {
                obj = null;
                if (obj != null) {
                    if (str.hashCode() != 396454335) {
                        if (str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
                            obj2 = null;
                        }
                    }
                    if (obj2 != null) {
                        uwVar = new uw();
                        if (i <= 0) {
                            return uwVar;
                        }
                        throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
                    }
                    throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", new Object[]{str}));
                }
                throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
            }
        }
        obj = -1;
        if (obj != null) {
            throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
        }
        if (str.hashCode() != 396454335) {
            if (str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
                obj2 = null;
            }
        }
        if (obj2 != null) {
            throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", new Object[]{str}));
        }
        uwVar = new uw();
        if (i <= 0) {
            return uwVar;
        }
        throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
    }
}
