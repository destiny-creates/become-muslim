package com.google.android.gms.internal.p210i;

import com.google.android.gms.internal.p210i.fk.C4996e;

/* renamed from: com.google.android.gms.internal.i.gh */
final class gh implements hk {
    /* renamed from: b */
    private static final gs f24501b = new gj();
    /* renamed from: a */
    private final gs f24502a;

    public gh() {
        this(new gk(fj.m31595a(), gh.m31608a()));
    }

    private gh(gs gsVar) {
        this.f24502a = (gs) fm.m20558a((Object) gsVar, "messageInfoFactory");
    }

    /* renamed from: a */
    public final <T> hi<T> mo4559a(Class<T> cls) {
        hl.m20698a((Class) cls);
        gr b = this.f24502a.mo4553b(cls);
        if (b.mo4579b()) {
            if (fk.class.isAssignableFrom(cls) != null) {
                return gy.m31673a(hl.m20710c(), ez.m20520a(), b.mo4580c());
            }
            return gy.m31673a(hl.m20688a(), ez.m20521b(), b.mo4580c());
        } else if (fk.class.isAssignableFrom(cls)) {
            if (gh.m31609a(b)) {
                return gx.m31634a(cls, b, hc.m20625b(), gc.m20588b(), hl.m20710c(), ez.m20520a(), gq.m20610b());
            }
            return gx.m31634a(cls, b, hc.m20625b(), gc.m20588b(), hl.m20710c(), null, gq.m20610b());
        } else if (gh.m31609a(b)) {
            return gx.m31634a(cls, b, hc.m20624a(), gc.m20587a(), hl.m20688a(), ez.m20521b(), gq.m20609a());
        } else {
            return gx.m31634a(cls, b, hc.m20624a(), gc.m20587a(), hl.m20704b(), null, gq.m20609a());
        }
    }

    /* renamed from: a */
    private static boolean m31609a(gr grVar) {
        return grVar.mo4578a() == C4996e.f16610h ? true : null;
    }

    /* renamed from: a */
    private static com.google.android.gms.internal.p210i.gs m31608a() {
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
        r0 = (com.google.android.gms.internal.p210i.gs) r0;	 Catch:{ Exception -> 0x0019 }
        return r0;
    L_0x0019:
        r0 = f24501b;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.gh.a():com.google.android.gms.internal.i.gs");
    }
}
