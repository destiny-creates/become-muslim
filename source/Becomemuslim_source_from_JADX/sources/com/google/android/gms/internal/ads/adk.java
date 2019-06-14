package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class adk {
    /* renamed from: a */
    private static final adk f14275a = new adk();
    /* renamed from: b */
    private final adr f14276b;
    /* renamed from: c */
    private final ConcurrentMap<Class<?>, adq<?>> f14277c = new ConcurrentHashMap();

    private adk() {
        String[] strArr = new String[]{"com.google.protobuf.AndroidProto3SchemaFactory"};
        adr adr = null;
        for (int i = 0; i <= 0; i++) {
            adr = m18008a(strArr[0]);
            if (adr != null) {
                break;
            }
        }
        if (adr == null) {
            adr = new acm();
        }
        this.f14276b = adr;
    }

    /* renamed from: a */
    public static adk m18007a() {
        return f14275a;
    }

    /* renamed from: a */
    private static com.google.android.gms.internal.ads.adr m18008a(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x0014 }
        r0 = 0;	 Catch:{ Throwable -> 0x0014 }
        r1 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x0014 }
        r2 = r2.getConstructor(r1);	 Catch:{ Throwable -> 0x0014 }
        r0 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0014 }
        r2 = r2.newInstance(r0);	 Catch:{ Throwable -> 0x0014 }
        r2 = (com.google.android.gms.internal.ads.adr) r2;	 Catch:{ Throwable -> 0x0014 }
        return r2;
    L_0x0014:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adk.a(java.lang.String):com.google.android.gms.internal.ads.adr");
    }

    /* renamed from: a */
    public final <T> adq<T> m18009a(Class<T> cls) {
        abs.m17935a((Object) cls, "messageType");
        adq<T> adq = (adq) this.f14277c.get(cls);
        if (adq != null) {
            return adq;
        }
        Object a = this.f14276b.mo3744a(cls);
        abs.m17935a((Object) cls, "messageType");
        abs.m17935a(a, "schema");
        adq<T> adq2 = (adq) this.f14277c.putIfAbsent(cls, a);
        return adq2 != null ? adq2 : a;
    }

    /* renamed from: a */
    public final <T> adq<T> m18010a(T t) {
        return m18009a(t.getClass());
    }
}
