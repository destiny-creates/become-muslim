package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.xf.C6771b;
import java.security.GeneralSecurityException;

final class uo implements ua<ts> {
    uo() {
    }

    /* renamed from: d */
    private final ts m31146d(aai aai) {
        try {
            vt a = vt.m43557a(aai);
            if (a instanceof vt) {
                a = a;
                zp.m20201a(a.m43566a(), 0);
                zp.m20200a(a.m43569c().mo6036a());
                if (a.m43568b().m43577a() != 12) {
                    if (a.m43568b().m43577a() != 16) {
                        throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                    }
                }
                return new yg(a.m43569c().m17843b(), a.m43568b().m43577a());
            }
            throw new GeneralSecurityException("expected AesEaxKey proto");
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesEaxKey proto", e);
        }
    }

    /* renamed from: a */
    public final int mo4379a() {
        return 0;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4380a(aai aai) {
        return m31146d(aai);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4381a(acx acx) {
        if (acx instanceof vt) {
            vt vtVar = (vt) acx;
            zp.m20201a(vtVar.m43566a(), 0);
            zp.m20200a(vtVar.m43569c().mo6036a());
            if (vtVar.m43568b().m43577a() != 12) {
                if (vtVar.m43568b().m43577a() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
            }
            return new yg(vtVar.m43569c().m17843b(), vtVar.m43568b().m43577a());
        }
        throw new GeneralSecurityException("expected AesEaxKey proto");
    }

    /* renamed from: b */
    public final acx mo4382b(aai aai) {
        try {
            return mo4383b(vw.m43570a(aai));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesEaxKeyFormat proto", e);
        }
    }

    /* renamed from: b */
    public final acx mo4383b(acx acx) {
        if (acx instanceof vw) {
            vw vwVar = (vw) acx;
            zp.m20200a(vwVar.m43574b());
            if (vwVar.m43572a().m43577a() != 12) {
                if (vwVar.m43572a().m43577a() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
            }
            return vt.m43564d().m43555a(aai.m17831a(zk.m20197a(vwVar.m43574b()))).m43556a(vwVar.m43572a()).m43554a(0).m42162c();
        }
        throw new GeneralSecurityException("expected AesEaxKeyFormat proto");
    }

    /* renamed from: c */
    public final xf mo4384c(aai aai) {
        return (xf) xf.m43701d().m43694a("type.googleapis.com/google.crypto.tink.AesEaxKey").m43692a(((vt) mo4382b(aai)).mo6142h()).m43693a(C6771b.SYMMETRIC).m42162c();
    }
}
