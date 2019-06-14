package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.v4.view.C0517s;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.bv;
import com.google.android.gms.ads.internal.gmsg.C2651k;
import com.google.android.gms.ads.internal.gmsg.C2652m;
import com.google.android.gms.ads.internal.gmsg.C2653o;
import com.google.android.gms.ads.internal.gmsg.C4266a;
import com.google.android.gms.ads.internal.gmsg.C4268c;
import com.google.android.gms.ads.internal.gmsg.C4269d;
import com.google.android.gms.ads.internal.gmsg.C4270e;
import com.google.android.gms.ads.internal.gmsg.C4273l;
import com.google.android.gms.ads.internal.gmsg.ae;
import com.google.android.gms.ads.internal.gmsg.ah;
import com.google.android.gms.ads.internal.gmsg.ai;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.C2663l;
import com.google.android.gms.ads.internal.overlay.C2665n;
import com.google.android.gms.ads.internal.overlay.C2668t;
import com.google.android.gms.ads.internal.overlay.C4739c;
import com.google.android.gms.ads.internal.overlay.C4740d;
import java.io.File;

@cm
public final class sd extends baa<qo> implements rw, sr, st, sv, sw {
    /* renamed from: A */
    private OnAttachStateChangeListener f24286A;
    /* renamed from: a */
    private qo f24287a;
    /* renamed from: b */
    private final Object f24288b;
    /* renamed from: c */
    private aok f24289c;
    /* renamed from: d */
    private C2665n f24290d;
    /* renamed from: e */
    private rx f24291e;
    /* renamed from: f */
    private ry f24292f;
    /* renamed from: g */
    private C2651k f24293g;
    /* renamed from: h */
    private C2652m f24294h;
    /* renamed from: i */
    private rz f24295i;
    /* renamed from: j */
    private boolean f24296j;
    /* renamed from: k */
    private ai f24297k;
    /* renamed from: l */
    private boolean f24298l;
    /* renamed from: m */
    private boolean f24299m;
    /* renamed from: n */
    private OnGlobalLayoutListener f24300n;
    /* renamed from: o */
    private OnScrollChangedListener f24301o;
    /* renamed from: p */
    private boolean f24302p;
    /* renamed from: q */
    private C2668t f24303q;
    /* renamed from: r */
    private final C6765m f24304r;
    /* renamed from: s */
    private bv f24305s;
    /* renamed from: t */
    private C6763d f24306t;
    /* renamed from: u */
    private C4934o f24307u;
    /* renamed from: v */
    private sa f24308v;
    /* renamed from: w */
    private id f24309w;
    /* renamed from: x */
    private boolean f24310x;
    /* renamed from: y */
    private boolean f24311y;
    /* renamed from: z */
    private int f24312z;

    public sd(qo qoVar, boolean z) {
        this(qoVar, z, new C6765m(qoVar, qoVar.mo6708q(), new asa(qoVar.getContext())), null);
    }

    private sd(qo qoVar, boolean z, C6765m c6765m, C6763d c6763d) {
        this.f24288b = new Object();
        this.f24296j = false;
        this.f24287a = qoVar;
        this.f24298l = z;
        this.f24304r = c6765m;
        this.f24306t = null;
    }

    /* renamed from: a */
    private final void m31048a(View view, id idVar, int i) {
        if (idVar.mo4293b() && i > 0) {
            idVar.mo4289a(view);
            if (idVar.mo4293b()) {
                jw.f15691a.postDelayed(new sf(this, view, idVar, i), 100);
            }
        }
    }

    /* renamed from: a */
    private final void m31049a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean a = this.f24306t != null ? this.f24306t.m30693a() : false;
        ax.c();
        Context context = this.f24287a.getContext();
        if (!a) {
            z = true;
        }
        C2663l.a(context, adOverlayInfoParcel, z);
        if (this.f24309w != null) {
            String str = adOverlayInfoParcel.f13032l;
            if (str == null && adOverlayInfoParcel.f13021a != null) {
                str = adOverlayInfoParcel.f13021a.f13037a;
            }
            this.f24309w.mo4290a(str);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    private final android.webkit.WebResourceResponse m31051e(com.google.android.gms.internal.ads.so r9) {
        /*
        r8 = this;
        r0 = new java.net.URL;
        r1 = r9.f16017a;
        r0.<init>(r1);
        r1 = 0;
        r2 = r0;
        r0 = 0;
    L_0x000a:
        r0 = r0 + 1;
        r3 = 20;
        if (r0 > r3) goto L_0x00f1;
    L_0x0010:
        r3 = r2.openConnection();
        r4 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r3.setConnectTimeout(r4);
        r3.setReadTimeout(r4);
        r4 = r9.f16019c;
        r4 = r4.entrySet();
        r4 = r4.iterator();
    L_0x0026:
        r5 = r4.hasNext();
        if (r5 == 0) goto L_0x0042;
    L_0x002c:
        r5 = r4.next();
        r5 = (java.util.Map.Entry) r5;
        r6 = r5.getKey();
        r6 = (java.lang.String) r6;
        r5 = r5.getValue();
        r5 = (java.lang.String) r5;
        r3.addRequestProperty(r6, r5);
        goto L_0x0026;
    L_0x0042:
        r4 = r3 instanceof java.net.HttpURLConnection;
        if (r4 == 0) goto L_0x00e9;
    L_0x0046:
        r3 = (java.net.HttpURLConnection) r3;
        r4 = com.google.android.gms.ads.internal.ax.e();
        r5 = r8.f24287a;
        r5 = r5.getContext();
        r6 = r8.f24287a;
        r6 = r6.mo6133k();
        r6 = r6.f28709a;
        r4.m19740a(r5, r6, r1, r3);
        r4 = new com.google.android.gms.internal.ads.mm;
        r4.<init>();
        r5 = 0;
        r4.m19909a(r3, r5);
        r6 = r3.getResponseCode();
        r4.m19908a(r3, r6);
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r6 < r4) goto L_0x00e1;
    L_0x0071:
        r4 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r6 >= r4) goto L_0x00e1;
    L_0x0075:
        r4 = "Location";
        r4 = r3.getHeaderField(r4);
        if (r4 == 0) goto L_0x00d9;
    L_0x007d:
        r6 = new java.net.URL;
        r6.<init>(r2, r4);
        r2 = r6.getProtocol();
        if (r2 != 0) goto L_0x008e;
    L_0x0088:
        r9 = "Protocol is null";
        com.google.android.gms.internal.ads.mt.m19924e(r9);
        return r5;
    L_0x008e:
        r7 = "http";
        r7 = r2.equals(r7);
        if (r7 != 0) goto L_0x00b9;
    L_0x0096:
        r7 = "https";
        r7 = r2.equals(r7);
        if (r7 != 0) goto L_0x00b9;
    L_0x009e:
        r9 = "Unsupported scheme: ";
        r0 = java.lang.String.valueOf(r2);
        r1 = r0.length();
        if (r1 == 0) goto L_0x00af;
    L_0x00aa:
        r9 = r9.concat(r0);
        goto L_0x00b5;
    L_0x00af:
        r0 = new java.lang.String;
        r0.<init>(r9);
        r9 = r0;
    L_0x00b5:
        com.google.android.gms.internal.ads.mt.m19924e(r9);
        return r5;
    L_0x00b9:
        r2 = "Redirecting to ";
        r4 = java.lang.String.valueOf(r4);
        r5 = r4.length();
        if (r5 == 0) goto L_0x00ca;
    L_0x00c5:
        r2 = r2.concat(r4);
        goto L_0x00d0;
    L_0x00ca:
        r4 = new java.lang.String;
        r4.<init>(r2);
        r2 = r4;
    L_0x00d0:
        com.google.android.gms.internal.ads.mt.m19918b(r2);
        r3.disconnect();
        r2 = r6;
        goto L_0x000a;
    L_0x00d9:
        r9 = new java.io.IOException;
        r0 = "Missing Location header in redirect";
        r9.<init>(r0);
        throw r9;
    L_0x00e1:
        com.google.android.gms.ads.internal.ax.e();
        r9 = com.google.android.gms.internal.ads.jw.m19685a(r3);
        return r9;
    L_0x00e9:
        r9 = new java.io.IOException;
        r0 = "Invalid protocol.";
        r9.<init>(r0);
        throw r9;
    L_0x00f1:
        r9 = new java.io.IOException;
        r0 = 32;
        r1 = new java.lang.StringBuilder;
        r1.<init>(r0);
        r0 = "Too many redirects (20)";
        r1.append(r0);
        r0 = r1.toString();
        r9.<init>(r0);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.sd.e(com.google.android.gms.internal.ads.so):android.webkit.WebResourceResponse");
    }

    /* renamed from: q */
    private final void m31052q() {
        if (this.f24286A != null) {
            this.f24287a.getView().removeOnAttachStateChangeListener(this.f24286A);
        }
    }

    /* renamed from: r */
    private final void m31053r() {
        if (this.f24291e != null && ((this.f24310x && this.f24312z <= 0) || this.f24311y)) {
            this.f24291e.mo3817a(this.f24311y ^ 1);
            this.f24291e = null;
        }
        this.f24287a.mo6666G();
    }

    /* renamed from: a */
    public final bv mo4338a() {
        return this.f24305s;
    }

    /* renamed from: a */
    public final void mo4339a(int i, int i2) {
        if (this.f24306t != null) {
            this.f24306t.m30689a(i, i2);
        }
    }

    /* renamed from: a */
    public final void mo4340a(int i, int i2, boolean z) {
        this.f24304r.m30898a(i, i2);
        if (this.f24306t != null) {
            this.f24306t.m30690a(i, i2, z);
        }
    }

    /* renamed from: a */
    public final void mo4341a(OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.f24288b) {
            this.f24299m = true;
            this.f24287a.mo6665F();
            this.f24300n = onGlobalLayoutListener;
            this.f24301o = onScrollChangedListener;
        }
    }

    /* renamed from: a */
    public final void m31058a(C4739c c4739c) {
        boolean z = this.f24287a.mo6137z();
        aok aok = (!z || this.f24287a.mo6135t().m20093d()) ? this.f24289c : null;
        m31049a(new AdOverlayInfoParcel(c4739c, aok, z ? null : this.f24290d, this.f24303q, this.f24287a.mo6133k()));
    }

    /* renamed from: a */
    public final void mo4342a(aok aok, C2651k c2651k, C2665n c2665n, C2652m c2652m, C2668t c2668t, boolean z, ai aiVar, bv bvVar, C4934o c4934o, id idVar) {
        C2651k c2651k2 = c2651k;
        C2652m c2652m2 = c2652m;
        ai aiVar2 = aiVar;
        C4934o c4934o2 = c4934o;
        id idVar2 = idVar;
        bv bvVar2 = bvVar == null ? new bv(this.f24287a.getContext(), idVar2, null) : bvVar;
        r0.f24306t = new C6763d(r0.f24287a, c4934o2);
        r0.f24309w = idVar2;
        if (((Boolean) aph.m18688f().m18889a(asp.aF)).booleanValue()) {
            m19186a("/adMetadata", new C4266a(c2651k2));
        }
        m19186a("/appEvent", new C4273l(c2652m2));
        m19186a("/backButton", C2653o.f6886j);
        m19186a("/refresh", C2653o.f6887k);
        m19186a("/canOpenURLs", C2653o.f6877a);
        m19186a("/canOpenIntents", C2653o.f6878b);
        m19186a("/click", C2653o.f6879c);
        m19186a("/close", C2653o.f6880d);
        m19186a("/customClose", C2653o.f6881e);
        m19186a("/instrument", C2653o.f6890n);
        m19186a("/delayPageLoaded", C2653o.f6892p);
        m19186a("/delayPageClosed", C2653o.f6893q);
        m19186a("/getLocationInfo", C2653o.f6894r);
        m19186a("/httpTrack", C2653o.f6882f);
        m19186a("/log", C2653o.f6883g);
        m19186a("/mraid", new C4269d(bvVar2, r0.f24306t, c4934o2));
        m19186a("/mraidLoaded", r0.f24304r);
        ae aeVar = r1;
        bv bvVar3 = bvVar2;
        C4270e c4270e = new C4270e(r0.f24287a.getContext(), r0.f24287a.mo6133k(), r0.f24287a.mo6136y(), c2668t, aok, c2651k, c2652m, c2665n, bvVar2, r0.f24306t);
        m19186a("/open", aeVar);
        m19186a("/precache", new qd());
        m19186a("/touch", C2653o.f6885i);
        m19186a("/video", C2653o.f6888l);
        m19186a("/videoMeta", C2653o.f6889m);
        if (ax.B().m19541a(r0.f24287a.getContext())) {
            m19186a("/logScionEvent", new C4268c(r0.f24287a.getContext()));
        }
        if (aiVar2 != null) {
            m19186a("/setInterstitialProperties", new ah(aiVar2));
        }
        r0.f24289c = aok;
        r0.f24290d = c2665n;
        r0.f24293g = c2651k2;
        r0.f24294h = c2652m;
        r0.f24303q = c2668t;
        r0.f24305s = bvVar3;
        r0.f24307u = c4934o;
        r0.f24297k = aiVar2;
        r0.f24296j = z;
    }

    /* renamed from: a */
    public final void mo4343a(rx rxVar) {
        this.f24291e = rxVar;
    }

    /* renamed from: a */
    public final void mo4344a(ry ryVar) {
        this.f24292f = ryVar;
    }

    /* renamed from: a */
    public final void mo4345a(rz rzVar) {
        this.f24295i = rzVar;
    }

    /* renamed from: a */
    public final void mo4346a(sa saVar) {
        this.f24308v = saVar;
    }

    /* renamed from: a */
    public final void mo4088a(so soVar) {
        this.f24310x = true;
        if (this.f24292f != null) {
            this.f24292f.mo4091a();
            this.f24292f = null;
        }
        m31053r();
    }

    /* renamed from: a */
    public final void m31065a(boolean z) {
        this.f24296j = z;
    }

    /* renamed from: a */
    public final void m31066a(boolean z, int i) {
        aok aok = (!this.f24287a.mo6137z() || this.f24287a.mo6135t().m20093d()) ? this.f24289c : null;
        m31049a(new AdOverlayInfoParcel(aok, this.f24290d, this.f24303q, this.f24287a, z, i, this.f24287a.mo6133k()));
    }

    /* renamed from: a */
    public final void m31067a(boolean z, int i, String str) {
        boolean z2 = this.f24287a.mo6137z();
        aok aok = (!z2 || r0.f24287a.mo6135t().m20093d()) ? r0.f24289c : null;
        m31049a(new AdOverlayInfoParcel(aok, z2 ? null : new sh(r0.f24287a, r0.f24290d), r0.f24293g, r0.f24294h, r0.f24303q, r0.f24287a, z, i, str, r0.f24287a.mo6133k()));
    }

    /* renamed from: a */
    public final void m31068a(boolean z, int i, String str, String str2) {
        boolean z2 = this.f24287a.mo6137z();
        aok aok = (!z2 || r0.f24287a.mo6135t().m20093d()) ? r0.f24289c : null;
        m31049a(new AdOverlayInfoParcel(aok, z2 ? null : new sh(r0.f24287a, r0.f24290d), r0.f24293g, r0.f24294h, r0.f24303q, r0.f24287a, z, i, str, str2, r0.f24287a.mo6133k()));
    }

    /* renamed from: b */
    public final void mo4087b(so soVar) {
        m19188a(soVar.f16018b);
    }

    /* renamed from: b */
    public final boolean mo4347b() {
        boolean z;
        synchronized (this.f24288b) {
            z = this.f24298l;
        }
        return z;
    }

    /* renamed from: c */
    public final boolean m31071c() {
        boolean z;
        synchronized (this.f24288b) {
            z = this.f24299m;
        }
        return z;
    }

    /* renamed from: c */
    public final boolean mo4086c(com.google.android.gms.internal.ads.so r12) {
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
        r11 = this;
        r0 = "AdWebView shouldOverrideUrlLoading: ";
        r1 = r12.f16017a;
        r1 = java.lang.String.valueOf(r1);
        r2 = r1.length();
        if (r2 == 0) goto L_0x0013;
    L_0x000e:
        r0 = r0.concat(r1);
        goto L_0x0019;
    L_0x0013:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x0019:
        com.google.android.gms.internal.ads.jn.m30864a(r0);
        r0 = r12.f16018b;
        r1 = r11.m19188a(r0);
        r2 = 1;
        if (r1 == 0) goto L_0x0026;
    L_0x0025:
        return r2;
    L_0x0026:
        r1 = r11.f24296j;
        if (r1 == 0) goto L_0x006f;
    L_0x002a:
        r1 = r0.getScheme();
        r3 = "http";
        r3 = r3.equalsIgnoreCase(r1);
        r4 = 0;
        if (r3 != 0) goto L_0x0042;
    L_0x0037:
        r3 = "https";
        r1 = r3.equalsIgnoreCase(r1);
        if (r1 == 0) goto L_0x0040;
    L_0x003f:
        goto L_0x0042;
    L_0x0040:
        r1 = 0;
        goto L_0x0043;
    L_0x0042:
        r1 = 1;
    L_0x0043:
        if (r1 == 0) goto L_0x006f;
    L_0x0045:
        r0 = r11.f24289c;
        if (r0 == 0) goto L_0x006e;
    L_0x0049:
        r0 = com.google.android.gms.internal.ads.asp.aj;
        r1 = com.google.android.gms.internal.ads.aph.m18688f();
        r0 = r1.m18889a(r0);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x006e;
    L_0x005b:
        r0 = r11.f24289c;
        r0.onAdClicked();
        r0 = r11.f24309w;
        if (r0 == 0) goto L_0x006b;
    L_0x0064:
        r0 = r11.f24309w;
        r12 = r12.f16017a;
        r0.mo4290a(r12);
    L_0x006b:
        r12 = 0;
        r11.f24289c = r12;
    L_0x006e:
        return r4;
    L_0x006f:
        r1 = r11.f24287a;
        r1 = r1.getWebView();
        r1 = r1.willNotDraw();
        if (r1 != 0) goto L_0x00e8;
    L_0x007b:
        r1 = r11.f24287a;	 Catch:{ ahj -> 0x00a1 }
        r1 = r1.mo6136y();	 Catch:{ ahj -> 0x00a1 }
        if (r1 == 0) goto L_0x00be;	 Catch:{ ahj -> 0x00a1 }
    L_0x0083:
        r3 = r1.m18434a(r0);	 Catch:{ ahj -> 0x00a1 }
        if (r3 == 0) goto L_0x00be;	 Catch:{ ahj -> 0x00a1 }
    L_0x0089:
        r3 = r11.f24287a;	 Catch:{ ahj -> 0x00a1 }
        r3 = r3.getContext();	 Catch:{ ahj -> 0x00a1 }
        r4 = r11.f24287a;	 Catch:{ ahj -> 0x00a1 }
        r4 = r4.getView();	 Catch:{ ahj -> 0x00a1 }
        r5 = r11.f24287a;	 Catch:{ ahj -> 0x00a1 }
        r5 = r5.mo6128d();	 Catch:{ ahj -> 0x00a1 }
        r1 = r1.m18431a(r0, r3, r4, r5);	 Catch:{ ahj -> 0x00a1 }
        r0 = r1;
        goto L_0x00be;
        r1 = "Unable to append parameter to URL: ";
        r3 = r12.f16017a;
        r3 = java.lang.String.valueOf(r3);
        r4 = r3.length();
        if (r4 == 0) goto L_0x00b5;
    L_0x00b0:
        r1 = r1.concat(r3);
        goto L_0x00bb;
    L_0x00b5:
        r3 = new java.lang.String;
        r3.<init>(r1);
        r1 = r3;
    L_0x00bb:
        com.google.android.gms.internal.ads.mt.m19924e(r1);
    L_0x00be:
        r1 = r11.f24305s;
        if (r1 == 0) goto L_0x00d3;
    L_0x00c2:
        r1 = r11.f24305s;
        r1 = r1.b();
        if (r1 == 0) goto L_0x00cb;
    L_0x00ca:
        goto L_0x00d3;
    L_0x00cb:
        r0 = r11.f24305s;
        r12 = r12.f16017a;
        r0.a(r12);
        goto L_0x0103;
    L_0x00d3:
        r12 = new com.google.android.gms.ads.internal.overlay.c;
        r4 = "android.intent.action.VIEW";
        r5 = r0.toString();
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r3 = r12;
        r3.<init>(r4, r5, r6, r7, r8, r9, r10);
        r11.m31058a(r12);
        goto L_0x0103;
    L_0x00e8:
        r0 = "AdWebView unable to handle URL: ";
        r12 = r12.f16017a;
        r12 = java.lang.String.valueOf(r12);
        r1 = r12.length();
        if (r1 == 0) goto L_0x00fb;
    L_0x00f6:
        r12 = r0.concat(r12);
        goto L_0x0100;
    L_0x00fb:
        r12 = new java.lang.String;
        r12.<init>(r0);
    L_0x0100:
        com.google.android.gms.internal.ads.mt.m19924e(r12);
    L_0x0103:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.sd.c(com.google.android.gms.internal.ads.so):boolean");
    }

    /* renamed from: d */
    public final OnGlobalLayoutListener m31073d() {
        OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.f24288b) {
            onGlobalLayoutListener = this.f24300n;
        }
        return onGlobalLayoutListener;
    }

    /* renamed from: d */
    public final WebResourceResponse mo4355d(so soVar) {
        WebResourceResponse c;
        if (this.f24309w != null) {
            this.f24309w.mo4291a(soVar.f16017a, soVar.f16019c, 1);
        }
        if ("mraid.js".equalsIgnoreCase(new File(soVar.f16017a).getName())) {
            mo4354n();
            asf asf = this.f24287a.mo6135t().m20093d() ? asp.f14920K : this.f24287a.mo6137z() ? asp.f14919J : asp.f14918I;
            String str = (String) aph.m18688f().m18889a(asf);
            ax.e();
            c = jw.m19717c(this.f24287a.getContext(), this.f24287a.mo6133k().f28709a, str);
        } else {
            c = null;
        }
        if (c != null) {
            return c;
        }
        try {
            if (!im.m19559a(soVar.f16017a, this.f24287a.getContext()).equals(soVar.f16017a)) {
                return m31051e(soVar);
            }
            amq a = amq.m36802a(soVar.f16017a);
            if (a != null) {
                amn a2 = ax.k().m18637a(a);
                if (a2 != null && a2.m36799a()) {
                    return new WebResourceResponse("", "", a2.m36800b());
                }
            }
            if (mm.m19905c()) {
                if (((Boolean) aph.m18688f().m18889a(asp.bi)).booleanValue()) {
                    return m31051e(soVar);
                }
            }
            return null;
        } catch (Throwable e) {
            ax.i().m30834a(e, "AdWebViewClient.interceptRequest");
            return null;
        }
    }

    /* renamed from: e */
    public final OnScrollChangedListener m31075e() {
        OnScrollChangedListener onScrollChangedListener;
        synchronized (this.f24288b) {
            onScrollChangedListener = this.f24301o;
        }
        return onScrollChangedListener;
    }

    /* renamed from: f */
    public final boolean mo4348f() {
        boolean z;
        synchronized (this.f24288b) {
            z = this.f24302p;
        }
        return z;
    }

    /* renamed from: g */
    public final void mo4349g() {
        id idVar = this.f24309w;
        if (idVar != null) {
            View webView = this.f24287a.getWebView();
            if (C0517s.A(webView)) {
                m31048a(webView, idVar, 10);
                return;
            }
            m31052q();
            this.f24286A = new sg(this, idVar);
            this.f24287a.getView().addOnAttachStateChangeListener(this.f24286A);
        }
    }

    /* renamed from: h */
    public final void mo4350h() {
        synchronized (this.f24288b) {
            this.f24302p = true;
        }
        this.f24312z++;
        m31053r();
    }

    /* renamed from: i */
    public final void mo4351i() {
        this.f24312z--;
        m31053r();
    }

    /* renamed from: j */
    public final void mo4352j() {
        this.f24311y = true;
        m31053r();
    }

    /* renamed from: k */
    public final void mo4356k() {
        if (this.f24309w != null) {
            this.f24309w.mo4295d();
            this.f24309w = null;
        }
        m31052q();
        super.mo4356k();
        synchronized (this.f24288b) {
            this.f24289c = null;
            this.f24290d = null;
            this.f24291e = null;
            this.f24292f = null;
            this.f24293g = null;
            this.f24294h = null;
            this.f24296j = false;
            this.f24298l = false;
            this.f24299m = false;
            this.f24302p = false;
            this.f24303q = null;
            this.f24295i = null;
            if (this.f24306t != null) {
                this.f24306t.m30692a(true);
                this.f24306t = null;
            }
        }
    }

    /* renamed from: l */
    public final sa m31082l() {
        return this.f24308v;
    }

    /* renamed from: m */
    public final id mo4353m() {
        return this.f24309w;
    }

    /* renamed from: n */
    public final void mo4354n() {
        synchronized (this.f24288b) {
            this.f24296j = false;
            this.f24298l = true;
            nu.f15846a.execute(new se(this));
        }
    }

    /* renamed from: o */
    public final /* synthetic */ Object mo4357o() {
        return this.f24287a;
    }

    /* renamed from: p */
    final /* synthetic */ void m31086p() {
        this.f24287a.mo6665F();
        C4740d r = this.f24287a.mo6709r();
        if (r != null) {
            r.m();
        }
        if (this.f24295i != null) {
            this.f24295i.m20084a();
            this.f24295i = null;
        }
    }
}
