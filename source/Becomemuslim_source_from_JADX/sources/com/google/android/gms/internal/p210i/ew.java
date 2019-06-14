package com.google.android.gms.internal.p210i;

import com.facebook.soloader.MinElf;
import com.google.android.gms.internal.p210i.fk.C6793d;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.ew */
public class ew {
    /* renamed from: a */
    static final ew f16528a = new ew(true);
    /* renamed from: b */
    private static volatile boolean f16529b = false;
    /* renamed from: c */
    private static final Class<?> f16530c = ew.m20508d();
    /* renamed from: d */
    private static volatile ew f16531d;
    /* renamed from: e */
    private final Map<C4995a, C6793d<?, ?>> f16532e;

    /* renamed from: com.google.android.gms.internal.i.ew$a */
    static final class C4995a {
        /* renamed from: a */
        private final Object f16526a;
        /* renamed from: b */
        private final int f16527b;

        C4995a(Object obj, int i) {
            this.f16526a = obj;
            this.f16527b = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f16526a) * MinElf.PN_XNUM) + this.f16527b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C4995a)) {
                return false;
            }
            C4995a c4995a = (C4995a) obj;
            if (this.f16526a == c4995a.f16526a && this.f16527b == c4995a.f16527b) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: d */
    private static java.lang.Class<?> m20508d() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.ew.d():java.lang.Class<?>");
    }

    /* renamed from: a */
    public static ew m20505a() {
        return ev.m20501a();
    }

    /* renamed from: b */
    public static ew m20506b() {
        ew ewVar = f16531d;
        if (ewVar == null) {
            synchronized (ew.class) {
                ewVar = f16531d;
                if (ewVar == null) {
                    ewVar = ev.m20503b();
                    f16531d = ewVar;
                }
            }
        }
        return ewVar;
    }

    /* renamed from: c */
    static ew m20507c() {
        return fi.m20550a(ew.class);
    }

    /* renamed from: a */
    public final <ContainingType extends gt> C6793d<ContainingType, ?> m20509a(ContainingType containingType, int i) {
        return (C6793d) this.f16532e.get(new C4995a(containingType, i));
    }

    ew() {
        this.f16532e = new HashMap();
    }

    private ew(boolean z) {
        this.f16532e = Collections.emptyMap();
    }
}
