package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class uk implements tu<ts> {
    /* renamed from: a */
    public final ua<ts> mo4378a(String str, String str2, int i) {
        Object obj;
        String toLowerCase = str2.toLowerCase();
        Object obj2 = -1;
        ua<ts> umVar;
        if (toLowerCase.hashCode() == 2989895) {
            if (toLowerCase.equals("aead")) {
                obj = null;
                if (obj != null) {
                    switch (str.hashCode()) {
                        case 360753376:
                            if (str.equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
                                obj2 = 3;
                                break;
                            }
                            break;
                        case 1215885937:
                            if (str.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
                                obj2 = null;
                                break;
                            }
                            break;
                        case 1469984853:
                            if (str.equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
                                obj2 = 4;
                                break;
                            }
                            break;
                        case 1797113348:
                            if (str.equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
                                obj2 = 1;
                                break;
                            }
                            break;
                        case 1855890991:
                            if (str.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                                obj2 = 2;
                                break;
                            }
                            break;
                        case 2079211877:
                            if (str.equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
                                obj2 = 5;
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                    switch (obj2) {
                        case null:
                            umVar = new um();
                            break;
                        case 1:
                            umVar = new uo();
                            break;
                        case 2:
                            umVar = new up();
                            break;
                        case 3:
                            umVar = new uq();
                            break;
                        case 4:
                            umVar = new ur();
                            break;
                        case 5:
                            umVar = new ut();
                            break;
                        default:
                            throw new GeneralSecurityException(String.format("No support for primitive 'Aead' with key type '%s'.", new Object[]{str}));
                    }
                    if (umVar.mo4379a() >= i) {
                        return umVar;
                    }
                    throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
                }
                throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
            }
        }
        obj = -1;
        if (obj != null) {
            throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
        }
        switch (str.hashCode()) {
            case 360753376:
                if (str.equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
                    obj2 = 3;
                    break;
                }
                break;
            case 1215885937:
                if (str.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
                    obj2 = null;
                    break;
                }
                break;
            case 1469984853:
                if (str.equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
                    obj2 = 4;
                    break;
                }
                break;
            case 1797113348:
                if (str.equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
                    obj2 = 1;
                    break;
                }
                break;
            case 1855890991:
                if (str.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                    obj2 = 2;
                    break;
                }
                break;
            case 2079211877:
                if (str.equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
                    obj2 = 5;
                    break;
                }
                break;
            default:
                break;
        }
        switch (obj2) {
            case null:
                umVar = new um();
                break;
            case 1:
                umVar = new uo();
                break;
            case 2:
                umVar = new up();
                break;
            case 3:
                umVar = new uq();
                break;
            case 4:
                umVar = new ur();
                break;
            case 5:
                umVar = new ut();
                break;
            default:
                throw new GeneralSecurityException(String.format("No support for primitive 'Aead' with key type '%s'.", new Object[]{str}));
        }
        if (umVar.mo4379a() >= i) {
            return umVar;
        }
        throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
    }
}
