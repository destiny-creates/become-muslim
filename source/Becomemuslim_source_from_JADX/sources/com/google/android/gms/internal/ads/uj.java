package com.google.android.gms.internal.ads;

import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.internal.ads.abq.C8211a;
import com.google.android.gms.internal.ads.xf.C6771b;
import com.google.android.gms.internal.ads.xo.C8309b;
import com.google.android.gms.internal.ads.xq.C8312b;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

final class uj {
    /* renamed from: a */
    private static final Charset f16056a = Charset.forName(Utf8Charset.NAME);

    /* renamed from: a */
    public static xq m20158a(xo xoVar) {
        C8211a a = xq.m43766a().m43749a(xoVar.m43745a());
        for (C8309b c8309b : xoVar.m43747b()) {
            a.m43750a((C8312b) C8312b.m43755a().m43754a(c8309b.m43739b().m43705a()).m43752a(c8309b.m43740c()).m43753a(c8309b.m43742e()).m43751a(c8309b.m43741d()).m42162c());
        }
        return (xq) a.m42162c();
    }

    /* renamed from: b */
    public static void m20159b(xo xoVar) {
        if (xoVar.m43748c() != 0) {
            int a = xoVar.m43745a();
            Object obj = null;
            Object obj2 = 1;
            for (C8309b c8309b : xoVar.m43747b()) {
                if (!c8309b.m43738a()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(c8309b.m43741d())}));
                } else if (c8309b.m43742e() == yb.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(c8309b.m43741d())}));
                } else if (c8309b.m43740c() != xi.UNKNOWN_STATUS) {
                    if (c8309b.m43740c() == xi.ENABLED && c8309b.m43741d() == a) {
                        if (obj == null) {
                            obj = 1;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    if (c8309b.m43739b().m43707c() != C6771b.ASYMMETRIC_PUBLIC) {
                        obj2 = null;
                    }
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(c8309b.m43741d())}));
                }
            }
            if (obj != null) {
                return;
            }
            if (obj2 == null) {
                throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
            }
            return;
        }
        throw new GeneralSecurityException("empty keyset");
    }
}
