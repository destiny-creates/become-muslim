package com.google.p217b;

import com.google.p217b.p222b.C5196a;
import com.google.p217b.p222b.C5202b;

/* compiled from: BinaryBitmap */
/* renamed from: com.google.b.c */
public final class C5232c {
    /* renamed from: a */
    private final C5210b f17668a;
    /* renamed from: b */
    private C5202b f17669b;

    public C5232c(C5210b c5210b) {
        if (c5210b != null) {
            this.f17668a = c5210b;
            return;
        }
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    /* renamed from: a */
    public int m22161a() {
        return this.f17668a.m22050c();
    }

    /* renamed from: b */
    public int m22163b() {
        return this.f17668a.m22051d();
    }

    /* renamed from: a */
    public C5196a m22162a(int i, C5196a c5196a) {
        return this.f17668a.mo4863a(i, c5196a);
    }

    /* renamed from: c */
    public C5202b m22164c() {
        if (this.f17669b == null) {
            this.f17669b = this.f17668a.mo4865b();
        }
        return this.f17669b;
    }

    /* renamed from: d */
    public boolean m22165d() {
        return this.f17668a.m22048a().m22568d();
    }

    /* renamed from: e */
    public C5232c m22166e() {
        return new C5232c(this.f17668a.mo4864a(this.f17668a.m22048a().m22569e()));
    }

    public java.lang.String toString() {
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
        r1 = this;
        r0 = r1.m22164c();	 Catch:{ l -> 0x0009 }
        r0 = r0.toString();	 Catch:{ l -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.c.toString():java.lang.String");
    }
}
