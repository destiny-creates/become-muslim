package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.xf.C6771b;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;

final class uv implements ua<ty> {
    uv() {
    }

    /* renamed from: d */
    private final ty m31187d(aai aai) {
        try {
            wo a = wo.m43624a(aai);
            if (a instanceof wo) {
                a = a;
                zp.m20201a(a.m43633a(), 0);
                vc.m20165a(a.m43635b().m43655b());
                wm b = a.m43635b().m43655b();
                ws a2 = b.m43617a();
                yt a3 = vc.m20162a(a2.m43660a());
                byte[] b2 = a.m43636c().m17843b();
                return new ym((ECPrivateKey) ((KeyFactory) yw.f16115e.m20184a("EC")).generatePrivate(new ECPrivateKeySpec(new BigInteger(1, b2), yr.m20178a(a3))), a2.m43663c().m17843b(), vc.m20164a(a2.m43662b()), vc.m20163a(b.m43620c()), new ve(b.m43619b().m43609a()));
            }
            throw new GeneralSecurityException("expected EciesAeadHkdfPrivateKey proto");
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPrivateKey proto", e);
        }
    }

    /* renamed from: a */
    public final int mo4379a() {
        return 0;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4380a(aai aai) {
        return m31187d(aai);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4381a(acx acx) {
        if (acx instanceof wo) {
            wo woVar = (wo) acx;
            zp.m20201a(woVar.m43633a(), 0);
            vc.m20165a(woVar.m43635b().m43655b());
            wm b = woVar.m43635b().m43655b();
            ws a = b.m43617a();
            yt a2 = vc.m20162a(a.m43660a());
            byte[] b2 = woVar.m43636c().m17843b();
            return new ym((ECPrivateKey) ((KeyFactory) yw.f16115e.m20184a("EC")).generatePrivate(new ECPrivateKeySpec(new BigInteger(1, b2), yr.m20178a(a2))), a.m43663c().m17843b(), vc.m20164a(a.m43662b()), vc.m20163a(b.m43620c()), new ve(b.m43619b().m43609a()));
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfPrivateKey proto");
    }

    /* renamed from: b */
    public final acx mo4382b(aai aai) {
        try {
            return mo4383b(wk.m43611a(aai));
        } catch (Throwable e) {
            throw new GeneralSecurityException("invalid EciesAeadHkdf key format", e);
        }
    }

    /* renamed from: b */
    public final acx mo4383b(acx acx) {
        if (acx instanceof wk) {
            wk wkVar = (wk) acx;
            vc.m20165a(wkVar.m43613a());
            KeyPair a = yr.m20176a(yr.m20178a(vc.m20162a(wkVar.m43613a().m43617a().m43660a())));
            ECPublicKey eCPublicKey = (ECPublicKey) a.getPublic();
            ECPrivateKey eCPrivateKey = (ECPrivateKey) a.getPrivate();
            ECPoint w = eCPublicKey.getW();
            return wo.m43631d().m43621a(0).m43623a((wq) wq.m43650e().m43637a(0).m43639a(wkVar.m43613a()).m43638a(aai.m17831a(w.getAffineX().toByteArray())).m43640b(aai.m17831a(w.getAffineY().toByteArray())).m42162c()).m43622a(aai.m17831a(eCPrivateKey.getS().toByteArray())).m42162c();
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfKeyFormat proto");
    }

    /* renamed from: c */
    public final xf mo4384c(aai aai) {
        return (xf) xf.m43701d().m43694a("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").m43692a(((wo) mo4382b(aai)).mo6142h()).m43693a(C6771b.ASYMMETRIC_PRIVATE).m42162c();
    }
}
