package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.xf.C6771b;
import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

final class vf implements ua<ue> {
    vf() {
    }

    /* renamed from: a */
    private static void m31207a(xd xdVar) {
        if (xdVar.m43691b() >= 10) {
            switch (vg.f16065a[xdVar.m43689a().ordinal()]) {
                case 1:
                    if (xdVar.m43691b() > 20) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                    return;
                case 2:
                    if (xdVar.m43691b() > 32) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                    return;
                case 3:
                    if (xdVar.m43691b() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                    return;
                default:
                    throw new GeneralSecurityException("unknown hash type");
            }
        }
        throw new GeneralSecurityException("tag size too small");
    }

    /* renamed from: d */
    private final ue m31208d(aai aai) {
        try {
            wz a = wz.m43667a(aai);
            if (a instanceof wz) {
                a = a;
                zp.m20201a(a.m43677a(), 0);
                if (a.m43680c().mo6036a() >= 16) {
                    zi ziVar;
                    m31207a(a.m43679b());
                    wx a2 = a.m43679b().m43689a();
                    Key secretKeySpec = new SecretKeySpec(a.m43680c().m17843b(), "HMAC");
                    int b = a.m43679b().m43691b();
                    switch (vg.f16065a[a2.ordinal()]) {
                        case 1:
                            ziVar = new zi("HMACSHA1", secretKeySpec, b);
                            break;
                        case 2:
                            ziVar = new zi("HMACSHA256", secretKeySpec, b);
                            break;
                        case 3:
                            ziVar = new zi("HMACSHA512", secretKeySpec, b);
                            break;
                        default:
                            throw new GeneralSecurityException("unknown hash");
                    }
                    return ziVar;
                }
                throw new GeneralSecurityException("key too short");
            }
            throw new GeneralSecurityException("expected HmacKey proto");
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized HmacKey proto", e);
        }
    }

    /* renamed from: a */
    public final int mo4379a() {
        return 0;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4380a(aai aai) {
        return m31208d(aai);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4381a(acx acx) {
        if (acx instanceof wz) {
            wz wzVar = (wz) acx;
            zp.m20201a(wzVar.m43677a(), 0);
            if (wzVar.m43680c().mo6036a() >= 16) {
                m31207a(wzVar.m43679b());
                wx a = wzVar.m43679b().m43689a();
                Key secretKeySpec = new SecretKeySpec(wzVar.m43680c().m17843b(), "HMAC");
                int b = wzVar.m43679b().m43691b();
                switch (vg.f16065a[a.ordinal()]) {
                    case 1:
                        return new zi("HMACSHA1", secretKeySpec, b);
                    case 2:
                        return new zi("HMACSHA256", secretKeySpec, b);
                    case 3:
                        return new zi("HMACSHA512", secretKeySpec, b);
                    default:
                        throw new GeneralSecurityException("unknown hash");
                }
            }
            throw new GeneralSecurityException("key too short");
        }
        throw new GeneralSecurityException("expected HmacKey proto");
    }

    /* renamed from: b */
    public final acx mo4382b(aai aai) {
        try {
            return mo4383b(xb.m43681a(aai));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized HmacKeyFormat proto", e);
        }
    }

    /* renamed from: b */
    public final acx mo4383b(acx acx) {
        if (acx instanceof xb) {
            xb xbVar = (xb) acx;
            if (xbVar.m43686b() >= 16) {
                m31207a(xbVar.m43684a());
                return wz.m43674d().m43664a(0).m43666a(xbVar.m43684a()).m43665a(aai.m17831a(zk.m20197a(xbVar.m43686b()))).m42162c();
            }
            throw new GeneralSecurityException("key too short");
        }
        throw new GeneralSecurityException("expected HmacKeyFormat proto");
    }

    /* renamed from: c */
    public final xf mo4384c(aai aai) {
        return (xf) xf.m43701d().m43694a("type.googleapis.com/google.crypto.tink.HmacKey").m43692a(((wz) mo4382b(aai)).mo6142h()).m43693a(C6771b.SYMMETRIC).m42162c();
    }
}
