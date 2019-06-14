package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C6758d;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class abd {
    /* renamed from: a */
    static final abd f14148a = new abd(true);
    /* renamed from: b */
    private static volatile boolean f14149b = false;
    /* renamed from: c */
    private static final Class<?> f14150c = m17884b();
    /* renamed from: d */
    private final Map<abe, C6758d<?, ?>> f14151d;

    abd() {
        this.f14151d = new HashMap();
    }

    private abd(boolean z) {
        this.f14151d = Collections.emptyMap();
    }

    /* renamed from: a */
    public static abd m17883a() {
        return abc.m17881a();
    }

    /* renamed from: b */
    private static java.lang.Class<?> m17884b() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = "com.google.protobuf.Extension";	 Catch:{ ClassNotFoundException -> 0x0007 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.abd.b():java.lang.Class<?>");
    }

    /* renamed from: a */
    public final <ContainingType extends acx> C6758d<ContainingType, ?> m17885a(ContainingType containingType, int i) {
        return (C6758d) this.f14151d.get(new abe(containingType, i));
    }
}
