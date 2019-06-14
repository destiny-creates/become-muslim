package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.xf.C6771b;
import java.security.GeneralSecurityException;

final class un implements ua<zh> {
    un() {
    }

    /* renamed from: a */
    private static void m31138a(vr vrVar) {
        if (vrVar.m43552a() < 12 || vrVar.m43552a() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    /* renamed from: d */
    private final yf m31139d(aai aai) {
        try {
            vn a = vn.m43530a(aai);
            if (a instanceof vn) {
                a = a;
                zp.m20201a(a.m43540a(), 0);
                zp.m20200a(a.m43543c().mo6036a());
                m31138a(a.m43542b());
                return new yf(a.m43543c().m17843b(), a.m43542b().m43552a());
            }
            throw new GeneralSecurityException("expected AesCtrKey proto");
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesCtrKey proto", e);
        }
    }

    /* renamed from: a */
    public final int mo4379a() {
        return 0;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4380a(aai aai) {
        return m31139d(aai);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4381a(acx acx) {
        if (acx instanceof vn) {
            vn vnVar = (vn) acx;
            zp.m20201a(vnVar.m43540a(), 0);
            zp.m20200a(vnVar.m43543c().mo6036a());
            m31138a(vnVar.m43542b());
            return new yf(vnVar.m43543c().m17843b(), vnVar.m43542b().m43552a());
        }
        throw new GeneralSecurityException("expected AesCtrKey proto");
    }

    /* renamed from: b */
    public final acx mo4382b(aai aai) {
        try {
            return mo4383b(vp.m43544a(aai));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesCtrKeyFormat proto", e);
        }
    }

    /* renamed from: b */
    public final acx mo4383b(acx acx) {
        if (acx instanceof vp) {
            vp vpVar = (vp) acx;
            zp.m20200a(vpVar.m43549b());
            m31138a(vpVar.m43547a());
            return vn.m43537d().m43529a(vpVar.m43547a()).m43528a(aai.m17831a(zk.m20197a(vpVar.m43549b()))).m43527a(0).m42162c();
        }
        throw new GeneralSecurityException("expected AesCtrKeyFormat proto");
    }

    /* renamed from: c */
    public final xf mo4384c(aai aai) {
        return (xf) xf.m43701d().m43694a("type.googleapis.com/google.crypto.tink.AesCtrKey").m43692a(((vn) mo4382b(aai)).mo6142h()).m43693a(C6771b.SYMMETRIC).m42162c();
    }
}
