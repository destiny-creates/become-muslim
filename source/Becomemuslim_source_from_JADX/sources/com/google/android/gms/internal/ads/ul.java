package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.yd.C8317a;

public final class ul {
    /* renamed from: a */
    public static final yd f16057a = ((yd) ((C8317a) yd.m43814b().m42158a(vi.f16066a)).m43808a(tv.m20125a("TinkAead", "Aead", "AesCtrHmacAeadKey", 0, true)).m43808a(tv.m20125a("TinkAead", "Aead", "AesEaxKey", 0, true)).m43808a(tv.m20125a("TinkAead", "Aead", "AesGcmKey", 0, true)).m43808a(tv.m20125a("TinkAead", "Aead", "ChaCha20Poly1305Key", 0, true)).m43808a(tv.m20125a("TinkAead", "Aead", "KmsAeadKey", 0, true)).m43808a(tv.m20125a("TinkAead", "Aead", "KmsEnvelopeAeadKey", 0, true)).m43809a("TINK_AEAD_1_0_0").m42162c());
    /* renamed from: b */
    private static final yd f16058b = ((yd) ((C8317a) yd.m43814b().m42158a(f16057a)).m43809a("TINK_AEAD_1_1_0").m42162c());

    static {
        try {
            m20160a();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /* renamed from: a */
    public static void m20160a() {
        ui.m20152a("TinkAead", new uk());
        vi.m20166a();
    }
}
