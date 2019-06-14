package com.google.android.exoplayer2.p163k;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: DefaultDataSource */
/* renamed from: com.google.android.exoplayer2.k.m */
public final class C4243m implements C2498g {
    /* renamed from: a */
    private final Context f11194a;
    /* renamed from: b */
    private final C2514v<? super C2498g> f11195b;
    /* renamed from: c */
    private final C2498g f11196c;
    /* renamed from: d */
    private C2498g f11197d;
    /* renamed from: e */
    private C2498g f11198e;
    /* renamed from: f */
    private C2498g f11199f;
    /* renamed from: g */
    private C2498g f11200g;
    /* renamed from: h */
    private C2498g f11201h;
    /* renamed from: i */
    private C2498g f11202i;

    public C4243m(Context context, C2514v<? super C2498g> c2514v, C2498g c2498g) {
        this.f11194a = context.getApplicationContext();
        this.f11195b = c2514v;
        this.f11196c = (C2498g) C2516a.m7015a((Object) c2498g);
    }

    /* renamed from: a */
    public long mo2268a(C2501j c2501j) {
        C2516a.m7019b(this.f11202i == null);
        String scheme = c2501j.f6349a.getScheme();
        if (C2541v.m7178a(c2501j.f6349a)) {
            if (c2501j.f6349a.getPath().startsWith("/android_asset/")) {
                this.f11202i = m13778d();
            } else {
                this.f11202i = m13777c();
            }
        } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
            this.f11202i = m13778d();
        } else if (UriUtil.LOCAL_CONTENT_SCHEME.equals(scheme)) {
            this.f11202i = m13779e();
        } else if ("rtmp".equals(scheme)) {
            this.f11202i = m13780f();
        } else if ("data".equals(scheme)) {
            this.f11202i = m13781g();
        } else {
            this.f11202i = this.f11196c;
        }
        return this.f11202i.mo2268a(c2501j);
    }

    /* renamed from: a */
    public int mo2267a(byte[] bArr, int i, int i2) {
        return this.f11202i.mo2267a(bArr, i, i2);
    }

    /* renamed from: a */
    public Uri mo2269a() {
        return this.f11202i == null ? null : this.f11202i.mo2269a();
    }

    /* renamed from: b */
    public void mo2270b() {
        if (this.f11202i != null) {
            try {
                this.f11202i.mo2270b();
            } finally {
                this.f11202i = null;
            }
        }
    }

    /* renamed from: c */
    private C2498g m13777c() {
        if (this.f11197d == null) {
            this.f11197d = new C4245q(this.f11195b);
        }
        return this.f11197d;
    }

    /* renamed from: d */
    private C2498g m13778d() {
        if (this.f11198e == null) {
            this.f11198e = new C4238c(this.f11194a, this.f11195b);
        }
        return this.f11198e;
    }

    /* renamed from: e */
    private C2498g m13779e() {
        if (this.f11199f == null) {
            this.f11199f = new C4239e(this.f11194a, this.f11195b);
        }
        return this.f11199f;
    }

    /* renamed from: f */
    private com.google.android.exoplayer2.p163k.C2498g m13780f() {
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
        r3 = this;
        r0 = r3.f11200g;
        if (r0 != 0) goto L_0x004f;
    L_0x0004:
        r0 = "com.google.android.exoplayer2.ext.rtmp.RtmpDataSource";	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        r1 = 0;	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        r2 = new java.lang.Class[r1];	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        r0 = r0.getDeclaredConstructor(r2);	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        r1 = new java.lang.Object[r1];	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        r0 = r0.newInstance(r1);	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        r0 = (com.google.android.exoplayer2.p163k.C2498g) r0;	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        r3.f11200g = r0;	 Catch:{ ClassNotFoundException -> 0x0040, InstantiationException -> 0x0037, IllegalAccessException -> 0x002e, NoSuchMethodException -> 0x0025, InvocationTargetException -> 0x001c }
        goto L_0x0047;
    L_0x001c:
        r0 = move-exception;
        r1 = "DefaultDataSource";
        r2 = "Error instantiating RtmpDataSource";
        android.util.Log.e(r1, r2, r0);
        goto L_0x0047;
    L_0x0025:
        r0 = move-exception;
        r1 = "DefaultDataSource";
        r2 = "Error instantiating RtmpDataSource";
        android.util.Log.e(r1, r2, r0);
        goto L_0x0047;
    L_0x002e:
        r0 = move-exception;
        r1 = "DefaultDataSource";
        r2 = "Error instantiating RtmpDataSource";
        android.util.Log.e(r1, r2, r0);
        goto L_0x0047;
    L_0x0037:
        r0 = move-exception;
        r1 = "DefaultDataSource";
        r2 = "Error instantiating RtmpDataSource";
        android.util.Log.e(r1, r2, r0);
        goto L_0x0047;
    L_0x0040:
        r0 = "DefaultDataSource";
        r1 = "Attempting to play RTMP stream without depending on the RTMP extension";
        android.util.Log.w(r0, r1);
    L_0x0047:
        r0 = r3.f11200g;
        if (r0 != 0) goto L_0x004f;
    L_0x004b:
        r0 = r3.f11196c;
        r3.f11200g = r0;
    L_0x004f:
        r0 = r3.f11200g;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.k.m.f():com.google.android.exoplayer2.k.g");
    }

    /* renamed from: g */
    private C2498g m13781g() {
        if (this.f11201h == null) {
            this.f11201h = new C4240f();
        }
        return this.f11201h;
    }
}
