package android.support.v4.p020a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v4.content.p027b.C0360a.C0359c;
import android.support.v4.content.p027b.C0360a.C3193b;
import android.support.v4.p020a.C0269c.C0268a;
import android.support.v4.p031g.C0404b.C0402b;

/* compiled from: TypefaceCompatBaseImpl */
/* renamed from: android.support.v4.a.g */
class C3164g implements C0268a {

    /* compiled from: TypefaceCompatBaseImpl */
    /* renamed from: android.support.v4.a.g$a */
    private interface C0270a<T> {
        /* renamed from: a */
        boolean mo167a(T t);

        /* renamed from: b */
        int mo168b(T t);
    }

    /* compiled from: TypefaceCompatBaseImpl */
    /* renamed from: android.support.v4.a.g$1 */
    class C31621 implements C0270a<C0402b> {
        /* renamed from: a */
        final /* synthetic */ C3164g f8114a;

        C31621(C3164g c3164g) {
            this.f8114a = c3164g;
        }

        /* renamed from: a */
        public /* synthetic */ boolean mo167a(Object obj) {
            return m9396b((C0402b) obj);
        }

        /* renamed from: b */
        public /* synthetic */ int mo168b(Object obj) {
            return m9393a((C0402b) obj);
        }

        /* renamed from: a */
        public int m9393a(C0402b c0402b) {
            return c0402b.m1190c();
        }

        /* renamed from: b */
        public boolean m9396b(C0402b c0402b) {
            return c0402b.m1191d();
        }
    }

    /* compiled from: TypefaceCompatBaseImpl */
    /* renamed from: android.support.v4.a.g$2 */
    class C31632 implements C0270a<C0359c> {
        /* renamed from: a */
        final /* synthetic */ C3164g f8115a;

        C31632(C3164g c3164g) {
            this.f8115a = c3164g;
        }

        /* renamed from: a */
        public /* synthetic */ boolean mo167a(Object obj) {
            return m9400b((C0359c) obj);
        }

        /* renamed from: b */
        public /* synthetic */ int mo168b(Object obj) {
            return m9397a((C0359c) obj);
        }

        /* renamed from: a */
        public int m9397a(C0359c c0359c) {
            return c0359c.m1076b();
        }

        /* renamed from: b */
        public boolean m9400b(C0359c c0359c) {
            return c0359c.m1077c();
        }
    }

    C3164g() {
    }

    /* renamed from: a */
    private static <T> T m9402a(T[] tArr, int i, C0270a<T> c0270a) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(c0270a.mo168b(t2) - i2) * 2) + (c0270a.mo167a(t2) == z ? 0 : 1);
            if (t == null || r6 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    /* renamed from: a */
    protected C0402b m9407a(C0402b[] c0402bArr, int i) {
        return (C0402b) C3164g.m9402a(c0402bArr, i, new C31621(this));
    }

    /* renamed from: a */
    protected android.graphics.Typeface m9406a(android.content.Context r2, java.io.InputStream r3) {
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
        r2 = android.support.v4.p020a.C0271h.m744a(r2);
        r0 = 0;
        if (r2 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r3 = android.support.v4.p020a.C0271h.m750a(r2, r3);	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        if (r3 != 0) goto L_0x0012;
    L_0x000e:
        r2.delete();
        return r0;
    L_0x0012:
        r3 = r2.getPath();	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        r3 = android.graphics.Typeface.createFromFile(r3);	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        r2.delete();
        return r3;
    L_0x001e:
        r3 = move-exception;
        r2.delete();
        throw r3;
    L_0x0023:
        r2.delete();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.g.a(android.content.Context, java.io.InputStream):android.graphics.Typeface");
    }

    /* renamed from: a */
    public android.graphics.Typeface mo170a(android.content.Context r3, android.os.CancellationSignal r4, android.support.v4.p031g.C0404b.C0402b[] r5, int r6) {
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
        r2 = this;
        r4 = r5.length;
        r0 = 0;
        r1 = 1;
        if (r4 >= r1) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r4 = r2.m9407a(r5, r6);
        r5 = r3.getContentResolver();	 Catch:{ IOException -> 0x0026, all -> 0x0021 }
        r4 = r4.m1188a();	 Catch:{ IOException -> 0x0026, all -> 0x0021 }
        r4 = r5.openInputStream(r4);	 Catch:{ IOException -> 0x0026, all -> 0x0021 }
        r3 = r2.m9406a(r3, r4);	 Catch:{ IOException -> 0x0027, all -> 0x001e }
        android.support.v4.p020a.C0271h.m748a(r4);
        return r3;
    L_0x001e:
        r3 = move-exception;
        r0 = r4;
        goto L_0x0022;
    L_0x0021:
        r3 = move-exception;
    L_0x0022:
        android.support.v4.p020a.C0271h.m748a(r0);
        throw r3;
    L_0x0026:
        r4 = r0;
    L_0x0027:
        android.support.v4.p020a.C0271h.m748a(r4);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.g.a(android.content.Context, android.os.CancellationSignal, android.support.v4.g.b$b[], int):android.graphics.Typeface");
    }

    /* renamed from: a */
    private C0359c m9401a(C3193b c3193b, int i) {
        return (C0359c) C3164g.m9402a(c3193b.m9665a(), i, new C31632(this));
    }

    /* renamed from: a */
    public Typeface mo171a(Context context, C3193b c3193b, Resources resources, int i) {
        c3193b = m9401a(c3193b, i);
        if (c3193b == null) {
            return null;
        }
        return C0269c.m737a(context, resources, c3193b.m1078d(), c3193b.m1075a(), i);
    }

    /* renamed from: a */
    public android.graphics.Typeface mo169a(android.content.Context r1, android.content.res.Resources r2, int r3, java.lang.String r4, int r5) {
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
        r0 = this;
        r1 = android.support.v4.p020a.C0271h.m744a(r1);
        r4 = 0;
        if (r1 != 0) goto L_0x0008;
    L_0x0007:
        return r4;
    L_0x0008:
        r2 = android.support.v4.p020a.C0271h.m749a(r1, r2, r3);	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        if (r2 != 0) goto L_0x0012;
    L_0x000e:
        r1.delete();
        return r4;
    L_0x0012:
        r2 = r1.getPath();	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        r2 = android.graphics.Typeface.createFromFile(r2);	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        r1.delete();
        return r2;
    L_0x001e:
        r2 = move-exception;
        r1.delete();
        throw r2;
    L_0x0023:
        r1.delete();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.g.a(android.content.Context, android.content.res.Resources, int, java.lang.String, int):android.graphics.Typeface");
    }
}
