package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.xf.C6771b;
import java.security.GeneralSecurityException;
import java.util.logging.Logger;

class um implements ua<ts> {
    /* renamed from: a */
    private static final Logger f24327a = Logger.getLogger(um.class.getName());

    um() {
        ui.m20153a("type.googleapis.com/google.crypto.tink.AesCtrKey", new un());
    }

    /* renamed from: d */
    private final ts m31131d(aai aai) {
        try {
            vj a = vj.m43509a(aai);
            if (a instanceof vj) {
                a = a;
                zp.m20201a(a.m43518a(), 0);
                return new yv((zh) ui.m20157b("type.googleapis.com/google.crypto.tink.AesCtrKey", a.m43520b()), (ue) ui.m20157b("type.googleapis.com/google.crypto.tink.HmacKey", a.m43521c()), a.m43521c().m43679b().m43691b());
            }
            throw new GeneralSecurityException("expected AesCtrHmacAeadKey proto");
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKey proto", e);
        }
    }

    /* renamed from: a */
    public final int mo4379a() {
        return 0;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4380a(aai aai) {
        return m31131d(aai);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4381a(acx acx) {
        if (acx instanceof vj) {
            vj vjVar = (vj) acx;
            zp.m20201a(vjVar.m43518a(), 0);
            return new yv((zh) ui.m20157b("type.googleapis.com/google.crypto.tink.AesCtrKey", vjVar.m43520b()), (ue) ui.m20157b("type.googleapis.com/google.crypto.tink.HmacKey", vjVar.m43521c()), vjVar.m43521c().m43679b().m43691b());
        }
        throw new GeneralSecurityException("expected AesCtrHmacAeadKey proto");
    }

    /* renamed from: b */
    public final acx mo4382b(aai aai) {
        try {
            return mo4383b(vl.m43522a(aai));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKeyFormat proto", e);
        }
    }

    /* renamed from: b */
    public final acx mo4383b(acx acx) {
        if (acx instanceof vl) {
            vl vlVar = (vl) acx;
            vn vnVar = (vn) ui.m20146a("type.googleapis.com/google.crypto.tink.AesCtrKey", vlVar.m43524a());
            return vj.m43516d().m43507a(vnVar).m43508a((wz) ui.m20146a("type.googleapis.com/google.crypto.tink.HmacKey", vlVar.m43526b())).m43506a(0).m42162c();
        }
        throw new GeneralSecurityException("expected AesCtrHmacAeadKeyFormat proto");
    }

    /* renamed from: c */
    public final xf mo4384c(aai aai) {
        return (xf) xf.m43701d().m43694a("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey").m43692a(((vj) mo4382b(aai)).mo6142h()).m43693a(C6771b.SYMMETRIC).m42162c();
    }
}
