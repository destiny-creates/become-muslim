package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;

final class acm implements adr {
    /* renamed from: b */
    private static final acw f23537b = new acn();
    /* renamed from: a */
    private final acw f23538a;

    public acm() {
        this(new aco(abp.m29729a(), m29742a()));
    }

    private acm(acw acw) {
        this.f23538a = (acw) abs.m17935a((Object) acw, "messageInfoFactory");
    }

    /* renamed from: a */
    private static com.google.android.gms.internal.ads.acw m29742a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "com.google.protobuf.DescriptorMessageInfoFactory";	 Catch:{ Exception -> 0x0019 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0019 }
        r1 = "getInstance";	 Catch:{ Exception -> 0x0019 }
        r2 = 0;	 Catch:{ Exception -> 0x0019 }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0019 }
        r0 = r0.getDeclaredMethod(r1, r3);	 Catch:{ Exception -> 0x0019 }
        r1 = 0;	 Catch:{ Exception -> 0x0019 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0019 }
        r0 = r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0019 }
        r0 = (com.google.android.gms.internal.ads.acw) r0;	 Catch:{ Exception -> 0x0019 }
        return r0;
    L_0x0019:
        r0 = f23537b;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.acm.a():com.google.android.gms.internal.ads.acw");
    }

    /* renamed from: a */
    private static boolean m29743a(acv acv) {
        return acv.mo3764a() == C4918e.f14229h;
    }

    /* renamed from: a */
    public final <T> adq<T> mo3744a(Class<T> cls) {
        ads.m18108a((Class) cls);
        acv b = this.f23538a.mo3738b(cls);
        if (b.mo3765b()) {
            return abq.class.isAssignableFrom(cls) ? ade.m29818a(ads.m18121c(), abh.m17897a(), b.mo3766c()) : ade.m29818a(ads.m18098a(), abh.m17898b(), b.mo3766c());
        } else {
            if (abq.class.isAssignableFrom(cls)) {
                if (m29743a(b)) {
                    return adb.m29777a((Class) cls, b, adi.m18005b(), ach.m17968b(), ads.m18121c(), abh.m17897a(), acu.m17990b());
                }
                return adb.m29777a((Class) cls, b, adi.m18005b(), ach.m17968b(), ads.m18121c(), null, acu.m17990b());
            } else if (m29743a(b)) {
                return adb.m29777a((Class) cls, b, adi.m18004a(), ach.m17967a(), ads.m18098a(), abh.m17898b(), acu.m17989a());
            } else {
                return adb.m29777a((Class) cls, b, adi.m18004a(), ach.m17967a(), ads.m18115b(), null, acu.m17989a());
            }
        }
    }
}
