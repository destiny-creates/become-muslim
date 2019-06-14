package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.ads.internal.aq;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.bu;
import com.google.android.gms.ads.internal.gmsg.ae;
import com.google.android.gms.ads.internal.overlay.C4739c;
import com.google.android.gms.ads.internal.overlay.C4740d;
import com.google.android.gms.common.util.C2904o;
import com.google.android.gms.common.util.C2905p;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@cm
final class sk extends sp implements OnGlobalLayoutListener, DownloadListener, azw, qo {
    /* renamed from: A */
    private WeakReference<OnClickListener> f32260A;
    /* renamed from: B */
    private C4740d f32261B;
    /* renamed from: C */
    private mh f32262C;
    /* renamed from: D */
    private int f32263D = -1;
    /* renamed from: E */
    private int f32264E = -1;
    /* renamed from: F */
    private int f32265F = -1;
    /* renamed from: G */
    private int f32266G = -1;
    /* renamed from: H */
    private float f32267H;
    /* renamed from: I */
    private Map<String, pz> f32268I;
    /* renamed from: J */
    private final WindowManager f32269J;
    /* renamed from: b */
    private final ahi f32270b;
    /* renamed from: c */
    private final mv f32271c;
    /* renamed from: d */
    private final aq f32272d;
    /* renamed from: e */
    private final bu f32273e;
    /* renamed from: f */
    private sd f32274f;
    /* renamed from: g */
    private C4740d f32275g;
    /* renamed from: h */
    private sc f32276h;
    /* renamed from: i */
    private String f32277i;
    /* renamed from: j */
    private boolean f32278j;
    /* renamed from: k */
    private boolean f32279k;
    /* renamed from: l */
    private boolean f32280l;
    /* renamed from: m */
    private int f32281m;
    /* renamed from: n */
    private boolean f32282n = true;
    /* renamed from: o */
    private boolean f32283o = false;
    /* renamed from: p */
    private String f32284p = "";
    /* renamed from: q */
    private re f32285q;
    /* renamed from: r */
    private boolean f32286r;
    /* renamed from: s */
    private boolean f32287s;
    /* renamed from: t */
    private aud f32288t;
    /* renamed from: u */
    private int f32289u;
    /* renamed from: v */
    private int f32290v;
    /* renamed from: w */
    private ata f32291w;
    /* renamed from: x */
    private ata f32292x;
    /* renamed from: y */
    private ata f32293y;
    /* renamed from: z */
    private atb f32294z;

    private sk(sb sbVar, sc scVar, String str, boolean z, boolean z2, ahi ahi, mv mvVar, atc atc, aq aqVar, bu buVar, amx amx) {
        super(sbVar);
        this.f32276h = scVar;
        this.f32277i = str;
        this.f32279k = z;
        this.f32281m = -1;
        this.f32270b = ahi;
        this.f32271c = mvVar;
        this.f32272d = aqVar;
        this.f32273e = buVar;
        this.f32269J = (WindowManager) getContext().getSystemService("window");
        this.f32262C = new mh(m31089K().m20086a(), this, this, null);
        ax.e().m19738a((Context) sbVar, mvVar.f28709a, getSettings());
        setDownloadListener(this);
        this.f32267H = m31089K().getResources().getDisplayMetrics().density;
        m42382O();
        if (C2904o.e()) {
            addJavascriptInterface(rh.m20053a(this), "googleAdsJsInterface");
        }
        m42386S();
        this.f32294z = new atb(new atc(true, "make_wv", this.f32277i));
        this.f32294z.m18913a().m18918a(atc);
        this.f32292x = asv.m18907a(this.f32294z.m18913a());
        this.f32294z.m18914a("native:view_create", this.f32292x);
        this.f32293y = null;
        this.f32291w = null;
        ax.g().mo6869b((Context) sbVar);
    }

    /* renamed from: M */
    private final boolean m42380M() {
        boolean z = false;
        if (!this.f32274f.mo4347b() && !this.f32274f.m31071c()) {
            return false;
        }
        int b;
        int b2;
        ax.e();
        DisplayMetrics a = jw.m19684a(this.f32269J);
        aph.m18683a();
        int b3 = mi.m19875b(a, a.widthPixels);
        aph.m18683a();
        int b4 = mi.m19875b(a, a.heightPixels);
        Activity a2 = m31089K().m20086a();
        if (a2 != null) {
            if (a2.getWindow() != null) {
                ax.e();
                int[] a3 = jw.m19710a(a2);
                aph.m18683a();
                b = mi.m19875b(a, a3[0]);
                aph.m18683a();
                b2 = mi.m19875b(a, a3[1]);
                if (this.f32264E != b3 && this.f32263D == b4 && this.f32265F == b && this.f32266G == b2) {
                    return false;
                }
                if (!(this.f32264E == b3 && this.f32263D == b4)) {
                    z = true;
                }
                this.f32264E = b3;
                this.f32263D = b4;
                this.f32265F = b;
                this.f32266G = b2;
                new C4933n(this).m19929a(b3, b4, b, b2, a.density, this.f32269J.getDefaultDisplay().getRotation());
                return z;
            }
        }
        b = b3;
        b2 = b4;
        if (this.f32264E != b3) {
        }
        z = true;
        this.f32264E = b3;
        this.f32263D = b4;
        this.f32265F = b;
        this.f32266G = b2;
        new C4933n(this).m19929a(b3, b4, b, b2, a.density, this.f32269J.getDefaultDisplay().getRotation());
        return z;
    }

    /* renamed from: N */
    private final void m42381N() {
        asv.m18908a(this.f32294z.m18913a(), this.f32292x, "aeh2");
    }

    /* renamed from: O */
    private final synchronized void m42382O() {
        if (!this.f32279k) {
            if (!this.f32276h.m20093d()) {
                if (VERSION.SDK_INT < 18) {
                    mt.m19918b("Disabling hardware acceleration on an AdView.");
                    m42383P();
                    return;
                }
                mt.m19918b("Enabling hardware acceleration on an AdView.");
                m42384Q();
                return;
            }
        }
        mt.m19918b("Enabling hardware acceleration on an overlay.");
        m42384Q();
    }

    /* renamed from: P */
    private final synchronized void m42383P() {
        if (!this.f32280l) {
            ax.g().mo6106c((View) this);
        }
        this.f32280l = true;
    }

    /* renamed from: Q */
    private final synchronized void m42384Q() {
        if (this.f32280l) {
            ax.g().mo6105b((View) this);
        }
        this.f32280l = false;
    }

    /* renamed from: R */
    private final synchronized void m42385R() {
        this.f32268I = null;
    }

    /* renamed from: S */
    private final void m42386S() {
        if (this.f32294z != null) {
            atc a = this.f32294z.m18913a();
            if (!(a == null || ax.i().m30836b() == null)) {
                ax.i().m30836b().m18905a(a);
            }
        }
    }

    /* renamed from: a */
    static sk m42389a(Context context, sc scVar, String str, boolean z, boolean z2, ahi ahi, mv mvVar, atc atc, aq aqVar, bu buVar, amx amx) {
        Context context2 = context;
        return new sk(new sb(context), scVar, str, z, z2, ahi, mvVar, atc, aqVar, buVar, amx);
    }

    /* renamed from: g */
    private final void m42390g(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        azx.m19178a((azw) this, "onAdVisibilityChanged", hashMap);
    }

    /* renamed from: C */
    public final synchronized boolean mo6662C() {
        return this.f32282n;
    }

    /* renamed from: D */
    public final synchronized boolean mo6663D() {
        return this.f32283o;
    }

    /* renamed from: E */
    public final synchronized boolean mo6664E() {
        return this.f32289u > 0;
    }

    /* renamed from: F */
    public final void mo6665F() {
        this.f32262C.m19859a();
    }

    /* renamed from: G */
    public final void mo6666G() {
        if (this.f32293y == null) {
            this.f32293y = asv.m18907a(this.f32294z.m18913a());
            this.f32294z.m18914a("native:view_load", this.f32293y);
        }
    }

    /* renamed from: H */
    public final synchronized aud mo6667H() {
        return this.f32288t;
    }

    /* renamed from: I */
    public final void mo6668I() {
        setBackgroundColor(0);
    }

    /* renamed from: J */
    public final void mo6669J() {
        jn.m30864a("Cannot add text view to inner AdWebView");
    }

    /* renamed from: a */
    public final pe mo6670a() {
        return null;
    }

    /* renamed from: a */
    public final void mo6671a(int i) {
        if (i == 0) {
            asv.m18908a(this.f32294z.m18913a(), this.f32292x, "aebb2");
        }
        m42381N();
        if (this.f32294z.m18913a() != null) {
            this.f32294z.m18913a().m18920a("close_type", String.valueOf(i));
        }
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.f32271c.f28709a);
        azx.m19178a((azw) this, "onhide", hashMap);
    }

    /* renamed from: a */
    public final void mo6672a(Context context) {
        m31089K().setBaseContext(context);
        this.f32262C.m19860a(m31089K().m20086a());
    }

    /* renamed from: a */
    public final void mo6673a(C4739c c4739c) {
        this.f32274f.m31058a(c4739c);
    }

    /* renamed from: a */
    public final synchronized void mo6674a(C4740d c4740d) {
        this.f32275g = c4740d;
    }

    /* renamed from: a */
    public final void mo4298a(akv akv) {
        synchronized (this) {
            this.f32286r = akv.f14657a;
        }
        m42390g(akv.f14657a);
    }

    /* renamed from: a */
    public final synchronized void mo6675a(aud aud) {
        this.f32288t = aud;
    }

    /* renamed from: a */
    public final synchronized void mo6126a(re reVar) {
        if (this.f32285q != null) {
            mt.m19920c("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.f32285q = reVar;
        }
    }

    /* renamed from: a */
    public final synchronized void mo6676a(sc scVar) {
        this.f32276h = scVar;
        requestLayout();
    }

    /* renamed from: a */
    public final void m42408a(sd sdVar) {
        this.f32274f = sdVar;
    }

    /* renamed from: a */
    public final synchronized void mo6677a(String str) {
        if (str == null) {
            str = "";
        }
        this.f32284p = str;
    }

    /* renamed from: a */
    public final void mo6678a(String str, ae<? super qo> aeVar) {
        if (this.f32274f != null) {
            this.f32274f.m19186a(str, (ae) aeVar);
        }
    }

    /* renamed from: a */
    public final void mo6679a(String str, C2905p<ae<? super qo>> c2905p) {
        if (this.f32274f != null) {
            this.f32274f.m19187a(str, (C2905p) c2905p);
        }
    }

    /* renamed from: a */
    public final void mo6649a(String str, String str2) {
        azx.m19177a((azw) this, str, str2);
    }

    /* renamed from: a */
    public final synchronized void mo6680a(String str, String str2, String str3) {
        if (((Boolean) aph.m18688f().m18889a(asp.aB)).booleanValue()) {
            str2 = rq.m20061a(str2, rq.m20060a());
        }
        super.loadDataWithBaseURL(str, str2, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, Utf8Charset.NAME, str3);
    }

    /* renamed from: a */
    public final void mo6650a(String str, Map map) {
        azx.m19178a((azw) this, str, map);
    }

    /* renamed from: a */
    public final void mo4089a(String str, JSONObject jSONObject) {
        azx.m19180b(this, str, jSONObject);
    }

    /* renamed from: a */
    public final void mo6681a(boolean z) {
        this.f32274f.m31065a(z);
    }

    /* renamed from: a */
    public final void mo6682a(boolean z, int i) {
        this.f32274f.m31066a(z, i);
    }

    /* renamed from: a */
    public final void mo6683a(boolean z, int i, String str) {
        this.f32274f.m31067a(z, i, str);
    }

    /* renamed from: a */
    public final void mo6684a(boolean z, int i, String str, String str2) {
        this.f32274f.m31068a(z, i, str, str2);
    }

    /* renamed from: b */
    public final synchronized re mo6127b() {
        return this.f32285q;
    }

    /* renamed from: b */
    public final synchronized void mo6685b(C4740d c4740d) {
        this.f32261B = c4740d;
    }

    /* renamed from: b */
    public final synchronized void mo4090b(String str) {
        if (m37656A()) {
            mt.m19924e("The webview is destroyed. Ignoring action.");
        } else {
            super.mo4090b(str);
        }
    }

    /* renamed from: b */
    public final void mo6686b(String str, ae<? super qo> aeVar) {
        if (this.f32274f != null) {
            this.f32274f.m19189b(str, aeVar);
        }
    }

    /* renamed from: b */
    public final void mo6652b(String str, JSONObject jSONObject) {
        azx.m19179a((azw) this, str, jSONObject);
    }

    /* renamed from: b */
    public final synchronized void mo6687b(boolean z) {
        Object obj = z != this.f32279k ? 1 : null;
        this.f32279k = z;
        m42382O();
        if (obj != null) {
            new C4933n(this).m19933c(z ? "expanded" : "default");
        }
    }

    /* renamed from: c */
    public final ata mo6688c() {
        return this.f32292x;
    }

    /* renamed from: c */
    public final synchronized void mo6689c(boolean z) {
        if (this.f32275g != null) {
            this.f32275g.a(this.f32274f.mo4347b(), z);
        } else {
            this.f32278j = z;
        }
    }

    /* renamed from: d */
    public final Activity mo6128d() {
        return m31089K().m20086a();
    }

    /* renamed from: d */
    public final synchronized void mo6690d(boolean z) {
        this.f32282n = z;
    }

    /* renamed from: e */
    public final bu mo6129e() {
        return this.f32273e;
    }

    /* renamed from: e */
    public final synchronized void mo6692e(boolean z) {
        this.f32289u += z ? 1 : -1;
        if (this.f32289u <= 0 && this.f32275g != null) {
            this.f32275g.q();
        }
    }

    /* renamed from: f */
    public final void mo6693f() {
        C4740d r = mo6709r();
        if (r != null) {
            r.p();
        }
    }

    /* renamed from: f */
    protected final synchronized void mo6722f(boolean z) {
        if (!z) {
            m42386S();
            this.f32262C.m19861b();
            if (this.f32275g != null) {
                this.f32275g.a();
                this.f32275g.k();
                this.f32275g = null;
            }
        }
        this.f32274f.mo4356k();
        ax.z();
        py.m20029a((pn) this);
        m42385R();
    }

    public final OnClickListener getOnClickListener() {
        return (OnClickListener) this.f32260A.get();
    }

    public final synchronized int getRequestedOrientation() {
        return this.f32281m;
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this;
    }

    /* renamed from: i */
    public final synchronized String mo6697i() {
        return this.f32284p;
    }

    /* renamed from: j */
    public final atb mo6132j() {
        return this.f32294z;
    }

    /* renamed from: k */
    public final mv mo6133k() {
        return this.f32271c;
    }

    /* renamed from: l */
    public final int mo6698l() {
        return getMeasuredHeight();
    }

    /* renamed from: m */
    public final int mo6702m() {
        return getMeasuredWidth();
    }

    public final synchronized void m_() {
        this.f32283o = true;
        if (this.f32272d != null) {
            this.f32272d.m_();
        }
    }

    /* renamed from: n */
    public final void mo6703n() {
        m42381N();
        Map hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.f32271c.f28709a);
        azx.m19178a((azw) this, "onhide", hashMap);
    }

    public final synchronized void n_() {
        this.f32283o = false;
        if (this.f32272d != null) {
            this.f32272d.n_();
        }
    }

    /* renamed from: o */
    public final void mo6704o() {
        if (this.f32291w == null) {
            asv.m18908a(this.f32294z.m18913a(), this.f32292x, "aes2");
            this.f32291w = asv.m18907a(this.f32294z.m18913a());
            this.f32294z.m18914a("native:view_show", this.f32291w);
        }
        Map hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.f32271c.f28709a);
        azx.m19178a((azw) this, "onshow", hashMap);
    }

    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!m37656A()) {
            this.f32262C.m19862c();
        }
        boolean z = this.f32286r;
        if (this.f32274f != null && this.f32274f.m31071c()) {
            if (!this.f32287s) {
                OnGlobalLayoutListener d = this.f32274f.m31073d();
                if (d != null) {
                    ax.A();
                    oh.m19964a((View) this, d);
                }
                OnScrollChangedListener e = this.f32274f.m31075e();
                if (e != null) {
                    ax.A();
                    oh.m19965a((View) this, e);
                }
                this.f32287s = true;
            }
            m42380M();
            z = true;
        }
        m42390g(z);
    }

    protected final void onDetachedFromWindow() {
        synchronized (this) {
            if (!m37656A()) {
                this.f32262C.m19863d();
            }
            super.onDetachedFromWindow();
            if (this.f32287s && this.f32274f != null && this.f32274f.m31071c() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                OnGlobalLayoutListener d = this.f32274f.m31073d();
                if (d != null) {
                    ax.g().mo6844a(getViewTreeObserver(), d);
                }
                OnScrollChangedListener e = this.f32274f.m31075e();
                if (e != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(e);
                }
                this.f32287s = false;
            }
        }
        m42390g(false);
    }

    public final void onDownloadStart(java.lang.String r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, long r5) {
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
        r2 = new android.content.Intent;	 Catch:{ ActivityNotFoundException -> 0x0019 }
        r3 = "android.intent.action.VIEW";	 Catch:{ ActivityNotFoundException -> 0x0019 }
        r2.<init>(r3);	 Catch:{ ActivityNotFoundException -> 0x0019 }
        r3 = android.net.Uri.parse(r1);	 Catch:{ ActivityNotFoundException -> 0x0019 }
        r2.setDataAndType(r3, r4);	 Catch:{ ActivityNotFoundException -> 0x0019 }
        com.google.android.gms.ads.internal.ax.e();	 Catch:{ ActivityNotFoundException -> 0x0019 }
        r3 = r0.getContext();	 Catch:{ ActivityNotFoundException -> 0x0019 }
        com.google.android.gms.internal.ads.jw.m19696a(r3, r2);	 Catch:{ ActivityNotFoundException -> 0x0019 }
        return;
    L_0x0019:
        r2 = java.lang.String.valueOf(r1);
        r2 = r2.length();
        r2 = r2 + 51;
        r3 = java.lang.String.valueOf(r4);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Couldn't find an Activity to view url/mimetype: ";
        r3.append(r2);
        r3.append(r1);
        r1 = " / ";
        r3.append(r1);
        r3.append(r4);
        r1 = r3.toString();
        com.google.android.gms.internal.ads.mt.m19918b(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.sk.onDownloadStart(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long):void");
    }

    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
            super.onDraw(canvas);
            if (!(this.f32274f == null || this.f32274f.m31082l() == null)) {
                this.f32274f.m31082l().m20085a();
            }
        }
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (((Boolean) aph.m18688f().m18889a(asp.ay)).booleanValue()) {
            float axisValue = motionEvent.getAxisValue(9);
            float axisValue2 = motionEvent.getAxisValue(10);
            if (motionEvent.getActionMasked() == 8 && ((axisValue > 0.0f && !canScrollVertically(-1)) || ((axisValue < 0.0f && !canScrollVertically(1)) || ((axisValue2 > 0.0f && !canScrollHorizontally(-1)) || (axisValue2 < 0.0f && !canScrollHorizontally(1)))))) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public final void onGlobalLayout() {
        boolean M = m42380M();
        C4740d r = mo6709r();
        if (r != null && M) {
            r.o();
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected final synchronized void onMeasure(int i, int i2) {
        if (m37656A()) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (!(isInEditMode() || this.f32279k)) {
            if (!this.f32276h.m20094e()) {
                int i3;
                if (this.f32276h.m20095f()) {
                    re b = mo6127b();
                    float e = b != null ? b.mo3943e() : 0.0f;
                    if (e == 0.0f) {
                        super.onMeasure(i, i2);
                        return;
                    }
                    i = MeasureSpec.getSize(i);
                    i2 = MeasureSpec.getSize(i2);
                    int i4 = (int) (((float) i2) * e);
                    i3 = (int) (((float) i) / e);
                    if (i2 == 0 && i3 != 0) {
                        i4 = (int) (((float) i3) * e);
                        i2 = i3;
                    } else if (i == 0 && i4 != 0) {
                        i3 = (int) (((float) i4) / e);
                        i = i4;
                    }
                    setMeasuredDimension(Math.min(i4, i), Math.min(i3, i2));
                    return;
                } else if (this.f32276h.m20092c()) {
                    if (!((Boolean) aph.m18688f().m18889a(asp.cm)).booleanValue()) {
                        if (C2904o.e()) {
                            mo6678a("/contentHeight", new sl(this));
                            mo4090b("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
                            setMeasuredDimension(MeasureSpec.getSize(i), this.f32290v != -1 ? (int) (((float) this.f32290v) * this.f32267H) : MeasureSpec.getSize(i2));
                            return;
                        }
                    }
                    super.onMeasure(i, i2);
                    return;
                } else if (this.f32276h.m20093d()) {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    this.f32269J.getDefaultDisplay().getMetrics(displayMetrics);
                    setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
                    return;
                } else {
                    Object obj;
                    Object obj2;
                    int i5;
                    StringBuilder stringBuilder;
                    int mode = MeasureSpec.getMode(i);
                    i = MeasureSpec.getSize(i);
                    i3 = MeasureSpec.getMode(i2);
                    i2 = MeasureSpec.getSize(i2);
                    int i6 = Integer.MAX_VALUE;
                    if (mode != LinearLayoutManager.INVALID_OFFSET) {
                        if (mode != 1073741824) {
                            mode = Integer.MAX_VALUE;
                            if (i3 == LinearLayoutManager.INVALID_OFFSET || i3 == 1073741824) {
                                i6 = i2;
                            }
                            obj = 1;
                            if (this.f32276h.f15992b <= mode) {
                                if (this.f32276h.f15991a > i6) {
                                    obj2 = null;
                                    if (((Boolean) aph.m18688f().m18889a(asp.dh)).booleanValue()) {
                                        if (((float) this.f32276h.f15992b) / this.f32267H <= ((float) mode) / this.f32267H || ((float) this.f32276h.f15991a) / this.f32267H > ((float) i6) / this.f32267H) {
                                            obj = null;
                                        }
                                        if (obj2 != null) {
                                            obj2 = obj;
                                        }
                                    }
                                    if (obj2 == null) {
                                        i3 = (int) (((float) this.f32276h.f15992b) / this.f32267H);
                                        i5 = (int) (((float) this.f32276h.f15991a) / this.f32267H);
                                        i = (int) (((float) i) / this.f32267H);
                                        i2 = (int) (((float) i2) / this.f32267H);
                                        stringBuilder = new StringBuilder(103);
                                        stringBuilder.append("Not enough space to show ad. Needs ");
                                        stringBuilder.append(i3);
                                        stringBuilder.append("x");
                                        stringBuilder.append(i5);
                                        stringBuilder.append(" dp, but only has ");
                                        stringBuilder.append(i);
                                        stringBuilder.append("x");
                                        stringBuilder.append(i2);
                                        stringBuilder.append(" dp.");
                                        mt.m19924e(stringBuilder.toString());
                                        if (getVisibility() != 8) {
                                            setVisibility(4);
                                        }
                                        setMeasuredDimension(0, 0);
                                        return;
                                    }
                                    if (getVisibility() != 8) {
                                        setVisibility(0);
                                    }
                                    setMeasuredDimension(this.f32276h.f15992b, this.f32276h.f15991a);
                                    return;
                                }
                            }
                            obj2 = 1;
                            if (((Boolean) aph.m18688f().m18889a(asp.dh)).booleanValue()) {
                                if (((float) this.f32276h.f15992b) / this.f32267H <= ((float) mode) / this.f32267H) {
                                }
                                obj = null;
                                if (obj2 != null) {
                                    obj2 = obj;
                                }
                            }
                            if (obj2 == null) {
                                if (getVisibility() != 8) {
                                    setVisibility(0);
                                }
                                setMeasuredDimension(this.f32276h.f15992b, this.f32276h.f15991a);
                                return;
                            }
                            i3 = (int) (((float) this.f32276h.f15992b) / this.f32267H);
                            i5 = (int) (((float) this.f32276h.f15991a) / this.f32267H);
                            i = (int) (((float) i) / this.f32267H);
                            i2 = (int) (((float) i2) / this.f32267H);
                            stringBuilder = new StringBuilder(103);
                            stringBuilder.append("Not enough space to show ad. Needs ");
                            stringBuilder.append(i3);
                            stringBuilder.append("x");
                            stringBuilder.append(i5);
                            stringBuilder.append(" dp, but only has ");
                            stringBuilder.append(i);
                            stringBuilder.append("x");
                            stringBuilder.append(i2);
                            stringBuilder.append(" dp.");
                            mt.m19924e(stringBuilder.toString());
                            if (getVisibility() != 8) {
                                setVisibility(4);
                            }
                            setMeasuredDimension(0, 0);
                            return;
                        }
                    }
                    mode = i;
                    i6 = i2;
                    obj = 1;
                    if (this.f32276h.f15992b <= mode) {
                        if (this.f32276h.f15991a > i6) {
                            obj2 = null;
                            if (((Boolean) aph.m18688f().m18889a(asp.dh)).booleanValue()) {
                                if (((float) this.f32276h.f15992b) / this.f32267H <= ((float) mode) / this.f32267H) {
                                }
                                obj = null;
                                if (obj2 != null) {
                                    obj2 = obj;
                                }
                            }
                            if (obj2 == null) {
                                i3 = (int) (((float) this.f32276h.f15992b) / this.f32267H);
                                i5 = (int) (((float) this.f32276h.f15991a) / this.f32267H);
                                i = (int) (((float) i) / this.f32267H);
                                i2 = (int) (((float) i2) / this.f32267H);
                                stringBuilder = new StringBuilder(103);
                                stringBuilder.append("Not enough space to show ad. Needs ");
                                stringBuilder.append(i3);
                                stringBuilder.append("x");
                                stringBuilder.append(i5);
                                stringBuilder.append(" dp, but only has ");
                                stringBuilder.append(i);
                                stringBuilder.append("x");
                                stringBuilder.append(i2);
                                stringBuilder.append(" dp.");
                                mt.m19924e(stringBuilder.toString());
                                if (getVisibility() != 8) {
                                    setVisibility(4);
                                }
                                setMeasuredDimension(0, 0);
                                return;
                            }
                            if (getVisibility() != 8) {
                                setVisibility(0);
                            }
                            setMeasuredDimension(this.f32276h.f15992b, this.f32276h.f15991a);
                            return;
                        }
                    }
                    obj2 = 1;
                    if (((Boolean) aph.m18688f().m18889a(asp.dh)).booleanValue()) {
                        if (((float) this.f32276h.f15992b) / this.f32267H <= ((float) mode) / this.f32267H) {
                        }
                        obj = null;
                        if (obj2 != null) {
                            obj2 = obj;
                        }
                    }
                    if (obj2 == null) {
                        if (getVisibility() != 8) {
                            setVisibility(0);
                        }
                        setMeasuredDimension(this.f32276h.f15992b, this.f32276h.f15991a);
                        return;
                    }
                    i3 = (int) (((float) this.f32276h.f15992b) / this.f32267H);
                    i5 = (int) (((float) this.f32276h.f15991a) / this.f32267H);
                    i = (int) (((float) i) / this.f32267H);
                    i2 = (int) (((float) i2) / this.f32267H);
                    stringBuilder = new StringBuilder(103);
                    stringBuilder.append("Not enough space to show ad. Needs ");
                    stringBuilder.append(i3);
                    stringBuilder.append("x");
                    stringBuilder.append(i5);
                    stringBuilder.append(" dp, but only has ");
                    stringBuilder.append(i);
                    stringBuilder.append("x");
                    stringBuilder.append(i2);
                    stringBuilder.append(" dp.");
                    mt.m19924e(stringBuilder.toString());
                    if (getVisibility() != 8) {
                        setVisibility(4);
                    }
                    setMeasuredDimension(0, 0);
                    return;
                }
            }
        }
        super.onMeasure(i, i2);
    }

    public final void onPause() {
        try {
            if (C2904o.a()) {
                super.onPause();
            }
        } catch (Throwable e) {
            mt.m19919b("Could not pause webview.", e);
        }
    }

    public final void onResume() {
        try {
            if (C2904o.a()) {
                super.onResume();
            }
        } catch (Throwable e) {
            mt.m19919b("Could not resume webview.", e);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f32274f.m31071c()) {
            synchronized (this) {
                if (this.f32288t != null) {
                    this.f32288t.mo3968a(motionEvent);
                }
            }
        } else if (this.f32270b != null) {
            this.f32270b.m18433a(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: p */
    public final void mo6707p() {
        Map hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(ax.D().m19781b()));
        hashMap.put("app_volume", String.valueOf(ax.D().m19778a()));
        hashMap.put("device_volume", String.valueOf(ko.m19776a(getContext())));
        azx.m19178a((azw) this, "volume", hashMap);
    }

    /* renamed from: q */
    public final Context mo6708q() {
        return m31089K().m20087b();
    }

    /* renamed from: r */
    public final synchronized C4740d mo6709r() {
        return this.f32275g;
    }

    /* renamed from: s */
    public final synchronized C4740d mo6710s() {
        return this.f32261B;
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.f32260A = new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public final synchronized void setRequestedOrientation(int i) {
        this.f32281m = i;
        if (this.f32275g != null) {
            this.f32275g.a(this.f32281m);
        }
    }

    public final void stopLoading() {
        try {
            super.stopLoading();
        } catch (Throwable e) {
            mt.m19919b("Could not stop loading webview.", e);
        }
    }

    /* renamed from: t */
    public final synchronized sc mo6135t() {
        return this.f32276h;
    }

    /* renamed from: u */
    public final synchronized String mo6717u() {
        return this.f32277i;
    }

    /* renamed from: v */
    public final /* synthetic */ rw mo6718v() {
        return this.f32274f;
    }

    /* renamed from: w */
    public final WebViewClient mo6719w() {
        return this.a;
    }

    /* renamed from: x */
    public final synchronized boolean mo6720x() {
        return this.f32278j;
    }

    /* renamed from: y */
    public final ahi mo6136y() {
        return this.f32270b;
    }

    /* renamed from: z */
    public final synchronized boolean mo6137z() {
        return this.f32279k;
    }
}
