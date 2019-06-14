package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.xf.C6771b;
import java.security.GeneralSecurityException;

final class uq implements ua<ts> {
    uq() {
    }

    /* renamed from: b */
    private static we m31160b() {
        return (we) we.m43602c().m43595a(0).m43596a(aai.m17831a(zk.m20197a(32))).m42162c();
    }

    /* renamed from: d */
    private final ts m31161d(aai aai) {
        try {
            we a = we.m43597a(aai);
            if (a instanceof we) {
                a = a;
                zp.m20201a(a.m43604a(), 0);
                if (a.m43606b().mo6036a() == 32) {
                    return new yk(a.m43606b().m17843b());
                }
                throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
            }
            throw new GeneralSecurityException("expected ChaCha20Poly1305Key proto");
        } catch (Throwable e) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305 key", e);
        }
    }

    /* renamed from: a */
    public final int mo4379a() {
        return 0;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4380a(aai aai) {
        return m31161d(aai);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4381a(acx acx) {
        if (acx instanceof we) {
            we weVar = (we) acx;
            zp.m20201a(weVar.m43604a(), 0);
            if (weVar.m43606b().mo6036a() == 32) {
                return new yk(weVar.m43606b().m17843b());
            }
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
        throw new GeneralSecurityException("expected ChaCha20Poly1305Key proto");
    }

    /* renamed from: b */
    public final acx mo4382b(aai aai) {
        return m31160b();
    }

    /* renamed from: b */
    public final acx mo4383b(acx acx) {
        return m31160b();
    }

    /* renamed from: c */
    public final xf mo4384c(aai aai) {
        return (xf) xf.m43701d().m43694a("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key").m43692a(m31160b().mo6142h()).m43693a(C6771b.SYMMETRIC).m42162c();
    }
}
