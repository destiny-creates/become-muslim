package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.xf.C6771b;
import java.security.GeneralSecurityException;

final class ur implements ua<ts> {
    ur() {
    }

    /* renamed from: c */
    private static ts m31168c(acx acx) {
        if (acx instanceof xs) {
            xs xsVar = (xs) acx;
            zp.m20201a(xsVar.m43782a(), 0);
            String a = xsVar.m43784b().m43789a();
            return ud.m20138a(a).m20137b(a);
        }
        throw new GeneralSecurityException("expected KmsAeadKey proto");
    }

    /* renamed from: d */
    private static ts m31169d(aai aai) {
        try {
            return m31168c(xs.m43775a(aai));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected KmsAeadKey proto", e);
        }
    }

    /* renamed from: a */
    public final int mo4379a() {
        return 0;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4380a(aai aai) {
        return m31169d(aai);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4381a(acx acx) {
        return m31168c(acx);
    }

    /* renamed from: b */
    public final acx mo4382b(aai aai) {
        try {
            return mo4383b(xu.m43785a(aai));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized KmsAeadKeyFormat proto", e);
        }
    }

    /* renamed from: b */
    public final acx mo4383b(acx acx) {
        if (acx instanceof xu) {
            return xs.m43780c().m43774a((xu) acx).m43773a(0).m42162c();
        }
        throw new GeneralSecurityException("expected KmsAeadKeyFormat proto");
    }

    /* renamed from: c */
    public final xf mo4384c(aai aai) {
        return (xf) xf.m43701d().m43694a("type.googleapis.com/google.crypto.tink.KmsAeadKey").m43692a(((xs) mo4382b(aai)).mo6142h()).m43693a(C6771b.REMOTE).m42162c();
    }
}
