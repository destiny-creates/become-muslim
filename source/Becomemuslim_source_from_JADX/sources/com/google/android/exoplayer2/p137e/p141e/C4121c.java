package com.google.android.exoplayer2.p137e.p141e;

import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2323h;
import com.google.android.exoplayer2.p137e.C2326k;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p164l.C2529l;

/* compiled from: OggExtractor */
/* renamed from: com.google.android.exoplayer2.e.e.c */
public class C4121c implements C2303e {
    /* renamed from: a */
    public static final C2323h f10558a = new C41201();
    /* renamed from: b */
    private C2320g f10559b;
    /* renamed from: c */
    private C2295h f10560c;
    /* renamed from: d */
    private boolean f10561d;

    /* compiled from: OggExtractor */
    /* renamed from: com.google.android.exoplayer2.e.e.c$1 */
    static class C41201 implements C2323h {
        C41201() {
        }

        /* renamed from: a */
        public C2303e[] mo2161a() {
            return new C2303e[]{new C4121c()};
        }
    }

    /* renamed from: c */
    public void mo2166c() {
    }

    /* renamed from: a */
    public boolean mo2165a(com.google.android.exoplayer2.p137e.C2304f r1) {
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
        r0 = this;
        r1 = r0.m13015b(r1);	 Catch:{ p -> 0x0005 }
        return r1;
    L_0x0005:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.e.c.a(com.google.android.exoplayer2.e.f):boolean");
    }

    /* renamed from: a */
    public void mo2164a(C2320g c2320g) {
        this.f10559b = c2320g;
    }

    /* renamed from: a */
    public void mo2163a(long j, long j2) {
        if (this.f10560c != null) {
            this.f10560c.m6348a(j, j2);
        }
    }

    /* renamed from: a */
    public int mo2162a(C2304f c2304f, C2326k c2326k) {
        if (this.f10560c == null) {
            if (m13015b(c2304f)) {
                c2304f.mo2183a();
            } else {
                throw new C2571p("Failed to determine bitstream type");
            }
        }
        if (!this.f10561d) {
            C2329m a = this.f10559b.mo2231a(0, 1);
            this.f10559b.mo2232a();
            this.f10560c.m6349a(this.f10559b, a);
            this.f10561d = true;
        }
        return this.f10560c.m6346a(c2304f, c2326k);
    }

    /* renamed from: b */
    private boolean m13015b(C2304f c2304f) {
        C2291e c2291e = new C2291e();
        if (c2291e.m6340a(c2304f, true)) {
            if ((c2291e.f5621b & 2) == 2) {
                int min = Math.min(c2291e.f5628i, 8);
                C2529l c2529l = new C2529l(min);
                c2304f.mo2191c(c2529l.f6441a, 0, min);
                if (C4119b.m13007a(C4121c.m13014a(c2529l)) != null) {
                    this.f10560c = new C4119b();
                } else if (C4124j.m13033a(C4121c.m13014a(c2529l)) != null) {
                    this.f10560c = new C4124j();
                } else if (C4122g.m13023a(C4121c.m13014a(c2529l)) == null) {
                    return false;
                } else {
                    this.f10560c = new C4122g();
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static C2529l m13014a(C2529l c2529l) {
        c2529l.m7096c(0);
        return c2529l;
    }
}
