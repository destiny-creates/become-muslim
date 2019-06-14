package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.xf.C6771b;
import java.security.GeneralSecurityException;

final class ut implements ua<ts> {
    ut() {
    }

    /* renamed from: d */
    private final ts m31177d(aai aai) {
        try {
            xw a = xw.m43792a(aai);
            if (a instanceof xw) {
                a = a;
                zp.m20201a(a.m43799a(), 0);
                String a2 = a.m43801b().m43806a();
                return new us(a.m43801b().m43807b(), ud.m20138a(a2).m20137b(a2));
            }
            throw new GeneralSecurityException("expected KmsEnvelopeAeadKey proto");
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized KmSEnvelopeAeadKey proto", e);
        }
    }

    /* renamed from: a */
    public final int mo4379a() {
        return 0;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4380a(aai aai) {
        return m31177d(aai);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4381a(acx acx) {
        if (acx instanceof xw) {
            xw xwVar = (xw) acx;
            zp.m20201a(xwVar.m43799a(), 0);
            String a = xwVar.m43801b().m43806a();
            return new us(xwVar.m43801b().m43807b(), ud.m20138a(a).m20137b(a));
        }
        throw new GeneralSecurityException("expected KmsEnvelopeAeadKey proto");
    }

    /* renamed from: b */
    public final acx mo4382b(aai aai) {
        try {
            return mo4383b(xz.m43802a(aai));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized KmsEnvelopeAeadKeyFormat proto", e);
        }
    }

    /* renamed from: b */
    public final acx mo4383b(acx acx) {
        if (acx instanceof xz) {
            return xw.m43797c().m43791a((xz) acx).m43790a(0).m42162c();
        }
        throw new GeneralSecurityException("expected KmsEnvelopeAeadKeyFormat proto");
    }

    /* renamed from: c */
    public final xf mo4384c(aai aai) {
        return (xf) xf.m43701d().m43694a("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey").m43692a(((xw) mo4382b(aai)).mo6142h()).m43693a(C6771b.REMOTE).m42162c();
    }
}
