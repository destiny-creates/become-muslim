package com.google.android.exoplayer2.p137e;

import com.google.android.exoplayer2.p137e.p138a.C4093b;
import com.google.android.exoplayer2.p137e.p139b.C4101d;
import com.google.android.exoplayer2.p137e.p140d.C4112e;
import com.google.android.exoplayer2.p137e.p140d.C4114g;
import com.google.android.exoplayer2.p137e.p141e.C4121c;
import com.google.android.exoplayer2.p137e.p142g.C4127a;
import com.google.android.exoplayer2.p137e.p142g.C4130c;
import com.google.android.exoplayer2.p137e.p142g.C4143q;
import com.google.android.exoplayer2.p137e.p142g.C4149v;
import com.google.android.exoplayer2.p137e.p143h.C4151a;
import com.google.android.exoplayer2.p137e.p196c.C4105b;
import java.lang.reflect.Constructor;

/* compiled from: DefaultExtractorsFactory */
/* renamed from: com.google.android.exoplayer2.e.c */
public final class C4106c implements C2323h {
    /* renamed from: a */
    private static final Constructor<? extends C2303e> f10469a;
    /* renamed from: b */
    private int f10470b;
    /* renamed from: c */
    private int f10471c;
    /* renamed from: d */
    private int f10472d;
    /* renamed from: e */
    private int f10473e;
    /* renamed from: f */
    private int f10474f = 1;
    /* renamed from: g */
    private int f10475g;

    static {
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
        r0 = "com.google.android.exoplayer2.ext.flac.FlacExtractor";	 Catch:{ ClassNotFoundException -> 0x0014, ClassNotFoundException -> 0x0014 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0014, ClassNotFoundException -> 0x0014 }
        r1 = com.google.android.exoplayer2.p137e.C2303e.class;	 Catch:{ ClassNotFoundException -> 0x0014, ClassNotFoundException -> 0x0014 }
        r0 = r0.asSubclass(r1);	 Catch:{ ClassNotFoundException -> 0x0014, ClassNotFoundException -> 0x0014 }
        r1 = 0;	 Catch:{ ClassNotFoundException -> 0x0014, ClassNotFoundException -> 0x0014 }
        r1 = new java.lang.Class[r1];	 Catch:{ ClassNotFoundException -> 0x0014, ClassNotFoundException -> 0x0014 }
        r0 = r0.getConstructor(r1);	 Catch:{ ClassNotFoundException -> 0x0014, ClassNotFoundException -> 0x0014 }
        goto L_0x0015;
    L_0x0014:
        r0 = 0;
    L_0x0015:
        f10469a = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.c.<clinit>():void");
    }

    /* renamed from: a */
    public synchronized C2303e[] mo2161a() {
        C2303e[] c2303eArr;
        c2303eArr = new C2303e[(f10469a == null ? 11 : 12)];
        c2303eArr[0] = new C4101d(this.f10470b);
        c2303eArr[1] = new C4112e(this.f10472d);
        c2303eArr[2] = new C4114g(this.f10471c);
        c2303eArr[3] = new C4105b(this.f10473e);
        c2303eArr[4] = new C4130c();
        c2303eArr[5] = new C4127a();
        c2303eArr[6] = new C4149v(this.f10474f, this.f10475g);
        c2303eArr[7] = new C4093b();
        c2303eArr[8] = new C4121c();
        c2303eArr[9] = new C4143q();
        c2303eArr[10] = new C4151a();
        if (f10469a != null) {
            try {
                c2303eArr[11] = (C2303e) f10469a.newInstance(new Object[0]);
            } catch (Throwable e) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e);
            }
        }
        return c2303eArr;
    }
}
