package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class uw implements ua<tz> {
    uw() {
    }

    /* renamed from: d */
    private final tz m31194d(aai aai) {
        try {
            wq a = wq.m43641a(aai);
            if (a instanceof wq) {
                a = a;
                zp.m20201a(a.m43653a(), 0);
                vc.m20165a(a.m43655b());
                wm b = a.m43655b();
                ws a2 = b.m43617a();
                return new yn(yr.m20177a(vc.m20162a(a2.m43660a()), a.m43656c().m17843b(), a.m43657d().m17843b()), a2.m43663c().m17843b(), vc.m20164a(a2.m43662b()), vc.m20163a(b.m43620c()), new ve(b.m43619b().m43609a()));
            }
            throw new GeneralSecurityException("expected EciesAeadHkdfPublicKey proto");
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPublicKey proto", e);
        }
    }

    /* renamed from: a */
    public final int mo4379a() {
        return 0;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4380a(aai aai) {
        return m31194d(aai);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4381a(acx acx) {
        if (acx instanceof wq) {
            wq wqVar = (wq) acx;
            zp.m20201a(wqVar.m43653a(), 0);
            vc.m20165a(wqVar.m43655b());
            wm b = wqVar.m43655b();
            ws a = b.m43617a();
            return new yn(yr.m20177a(vc.m20162a(a.m43660a()), wqVar.m43656c().m17843b(), wqVar.m43657d().m17843b()), a.m43663c().m17843b(), vc.m20164a(a.m43662b()), vc.m20163a(b.m43620c()), new ve(b.m43619b().m43609a()));
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfPublicKey proto");
    }

    /* renamed from: b */
    public final acx mo4382b(aai aai) {
        throw new GeneralSecurityException("Not implemented.");
    }

    /* renamed from: b */
    public final acx mo4383b(acx acx) {
        throw new GeneralSecurityException("Not implemented.");
    }

    /* renamed from: c */
    public final xf mo4384c(aai aai) {
        throw new GeneralSecurityException("Not implemented.");
    }
}
