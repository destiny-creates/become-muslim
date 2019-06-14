package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.yd.C8317a;

public final class ux {
    /* renamed from: a */
    public static final yd f16059a = ((yd) ((C8317a) yd.m43814b().m42158a(ul.f16057a)).m43808a(tv.m20125a("TinkHybridDecrypt", "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).m43808a(tv.m20125a("TinkHybridEncrypt", "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).m43809a("TINK_HYBRID_1_0_0").m42162c());
    /* renamed from: b */
    private static final yd f16060b = ((yd) ((C8317a) yd.m43814b().m42158a(f16059a)).m43809a("TINK_HYBRID_1_1_0").m42162c());

    static {
        try {
            ui.m20152a("TinkHybridEncrypt", new uz());
            ui.m20152a("TinkHybridDecrypt", new uy());
            ul.m20160a();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
