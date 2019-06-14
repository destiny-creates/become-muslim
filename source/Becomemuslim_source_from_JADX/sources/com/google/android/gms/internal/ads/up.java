package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.xf.C6771b;
import java.security.GeneralSecurityException;

final class up implements ua<ts> {
    up() {
    }

    /* renamed from: d */
    private final com.google.android.gms.internal.ads.ts m31153d(com.google.android.gms.internal.ads.aai r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r3 = com.google.android.gms.internal.ads.wa.m43581a(r3);	 Catch:{ abw -> 0x0035 }
        r0 = r3 instanceof com.google.android.gms.internal.ads.wa;	 Catch:{ abw -> 0x0035 }
        if (r0 == 0) goto L_0x002d;	 Catch:{ abw -> 0x0035 }
    L_0x0008:
        r3 = (com.google.android.gms.internal.ads.wa) r3;	 Catch:{ abw -> 0x0035 }
        r0 = r3.m43588a();	 Catch:{ abw -> 0x0035 }
        r1 = 0;	 Catch:{ abw -> 0x0035 }
        com.google.android.gms.internal.ads.zp.m20201a(r0, r1);	 Catch:{ abw -> 0x0035 }
        r0 = r3.m43590b();	 Catch:{ abw -> 0x0035 }
        r0 = r0.mo6036a();	 Catch:{ abw -> 0x0035 }
        com.google.android.gms.internal.ads.zp.m20200a(r0);	 Catch:{ abw -> 0x0035 }
        r0 = new com.google.android.gms.internal.ads.yh;	 Catch:{ abw -> 0x0035 }
        r3 = r3.m43590b();	 Catch:{ abw -> 0x0035 }
        r3 = r3.m17843b();	 Catch:{ abw -> 0x0035 }
        r0.<init>(r3);	 Catch:{ abw -> 0x0035 }
        r0 = (com.google.android.gms.internal.ads.ts) r0;	 Catch:{ abw -> 0x0035 }
        return r0;	 Catch:{ abw -> 0x0035 }
    L_0x002d:
        r3 = new java.security.GeneralSecurityException;	 Catch:{ abw -> 0x0035 }
        r0 = "expected AesGcmKey proto";	 Catch:{ abw -> 0x0035 }
        r3.<init>(r0);	 Catch:{ abw -> 0x0035 }
        throw r3;	 Catch:{ abw -> 0x0035 }
    L_0x0035:
        r3 = new java.security.GeneralSecurityException;
        r0 = "expected AesGcmKey proto";
        r3.<init>(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.up.d(com.google.android.gms.internal.ads.aai):com.google.android.gms.internal.ads.ts");
    }

    /* renamed from: a */
    public final int mo4379a() {
        return 0;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4380a(aai aai) {
        return m31153d(aai);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4381a(acx acx) {
        if (acx instanceof wa) {
            wa waVar = (wa) acx;
            zp.m20201a(waVar.m43588a(), 0);
            zp.m20200a(waVar.m43590b().mo6036a());
            return new yh(waVar.m43590b().m17843b());
        }
        throw new GeneralSecurityException("expected AesGcmKey proto");
    }

    /* renamed from: b */
    public final acx mo4382b(aai aai) {
        try {
            return mo4383b(wc.m43591a(aai));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesGcmKeyFormat proto", e);
        }
    }

    /* renamed from: b */
    public final acx mo4383b(acx acx) {
        if (acx instanceof wc) {
            wc wcVar = (wc) acx;
            zp.m20200a(wcVar.m43593a());
            return wa.m43586c().m43580a(aai.m17831a(zk.m20197a(wcVar.m43593a()))).m43579a(0).m42162c();
        }
        throw new GeneralSecurityException("expected AesGcmKeyFormat proto");
    }

    /* renamed from: c */
    public final xf mo4384c(aai aai) {
        return (xf) xf.m43701d().m43694a("type.googleapis.com/google.crypto.tink.AesGcmKey").m43692a(((wa) mo4382b(aai)).mo6142h()).m43693a(C6771b.SYMMETRIC).m42162c();
    }
}
