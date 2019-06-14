package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class uy implements tu<ty> {
    /* renamed from: a */
    public final ua<ty> mo4378a(String str, String str2, int i) {
        Object obj;
        ua uvVar;
        String toLowerCase = str2.toLowerCase();
        Object obj2 = -1;
        if (toLowerCase.hashCode() == 275448849) {
            if (toLowerCase.equals("hybriddecrypt")) {
                obj = null;
                if (obj != null) {
                    if (str.hashCode() != -80133005) {
                        if (str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
                            obj2 = null;
                        }
                    }
                    if (obj2 != null) {
                        uvVar = new uv();
                        if (i <= 0) {
                            return uvVar;
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
        if (str.hashCode() != -80133005) {
            if (str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
                obj2 = null;
            }
        }
        if (obj2 != null) {
            throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", new Object[]{str}));
        }
        uvVar = new uv();
        if (i <= 0) {
            return uvVar;
        }
        throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
    }
}
