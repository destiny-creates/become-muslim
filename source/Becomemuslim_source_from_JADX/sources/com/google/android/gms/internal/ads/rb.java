package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
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
final class rb extends WebView implements OnGlobalLayoutListener, DownloadListener, qo {
    /* renamed from: A */
    private int f32217A;
    /* renamed from: B */
    private int f32218B;
    /* renamed from: C */
    private ata f32219C;
    /* renamed from: D */
    private ata f32220D;
    /* renamed from: E */
    private ata f32221E;
    /* renamed from: F */
    private atb f32222F;
    /* renamed from: G */
    private WeakReference<OnClickListener> f32223G;
    /* renamed from: H */
    private C4740d f32224H;
    /* renamed from: I */
    private boolean f32225I;
    /* renamed from: J */
    private mh f32226J;
    /* renamed from: K */
    private int f32227K = -1;
    /* renamed from: L */
    private int f32228L = -1;
    /* renamed from: M */
    private int f32229M = -1;
    /* renamed from: N */
    private int f32230N = -1;
    /* renamed from: O */
    private Map<String, pz> f32231O;
    /* renamed from: P */
    private final WindowManager f32232P;
    /* renamed from: Q */
    private final amx f32233Q;
    /* renamed from: a */
    private final sb f32234a;
    /* renamed from: b */
    private final ahi f32235b;
    /* renamed from: c */
    private final mv f32236c;
    /* renamed from: d */
    private final aq f32237d;
    /* renamed from: e */
    private final bu f32238e;
    /* renamed from: f */
    private final DisplayMetrics f32239f;
    /* renamed from: g */
    private final float f32240g;
    /* renamed from: h */
    private boolean f32241h = false;
    /* renamed from: i */
    private boolean f32242i = false;
    /* renamed from: j */
    private qp f32243j;
    /* renamed from: k */
    private C4740d f32244k;
    /* renamed from: l */
    private sc f32245l;
    /* renamed from: m */
    private String f32246m;
    /* renamed from: n */
    private boolean f32247n;
    /* renamed from: o */
    private boolean f32248o;
    /* renamed from: p */
    private boolean f32249p;
    /* renamed from: q */
    private boolean f32250q;
    /* renamed from: r */
    private Boolean f32251r;
    /* renamed from: s */
    private int f32252s;
    /* renamed from: t */
    private boolean f32253t = true;
    /* renamed from: u */
    private boolean f32254u = false;
    /* renamed from: v */
    private String f32255v = "";
    /* renamed from: w */
    private re f32256w;
    /* renamed from: x */
    private boolean f32257x;
    /* renamed from: y */
    private boolean f32258y;
    /* renamed from: z */
    private aud f32259z;

    private rb(sb sbVar, sc scVar, String str, boolean z, boolean z2, ahi ahi, mv mvVar, atc atc, aq aqVar, bu buVar, amx amx) {
        super(sbVar);
        this.f32234a = sbVar;
        this.f32245l = scVar;
        this.f32246m = str;
        this.f32249p = z;
        this.f32252s = -1;
        this.f32235b = ahi;
        this.f32236c = mvVar;
        this.f32237d = aqVar;
        this.f32238e = buVar;
        this.f32232P = (WindowManager) getContext().getSystemService("window");
        ax.e();
        this.f32239f = jw.m19684a(this.f32232P);
        this.f32240g = this.f32239f.density;
        this.f32233Q = amx;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Throwable e) {
            mt.m19919b("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        ax.e().m19738a((Context) sbVar, mvVar.f28709a, settings);
        ax.g().mo6103a(getContext(), settings);
        setDownloadListener(this);
        m42304O();
        if (C2904o.e()) {
            addJavascriptInterface(rh.m20053a(this), "googleAdsJsInterface");
        }
        if (C2904o.a()) {
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        this.f32226J = new mh(this.f32234a.m20086a(), this, this, null);
        m42309T();
        this.f32222F = new atb(new atc(true, "make_wv", this.f32246m));
        this.f32222F.m18913a().m18918a(atc);
        this.f32220D = asv.m18907a(this.f32222F.m18913a());
        this.f32222F.m18914a("native:view_create", this.f32220D);
        this.f32221E = null;
        this.f32219C = null;
        ax.g().mo6869b((Context) sbVar);
        ax.i().m30844i();
    }

    /* renamed from: K */
    private final boolean m42300K() {
        boolean z = false;
        if (!this.f32243j.mo4347b() && !this.f32243j.m31030c()) {
            return false;
        }
        int b;
        int i;
        aph.m18683a();
        int b2 = mi.m19875b(this.f32239f, this.f32239f.widthPixels);
        aph.m18683a();
        int b3 = mi.m19875b(this.f32239f, this.f32239f.heightPixels);
        Activity a = this.f32234a.m20086a();
        if (a != null) {
            if (a.getWindow() != null) {
                ax.e();
                int[] a2 = jw.m19710a(a);
                aph.m18683a();
                int b4 = mi.m19875b(this.f32239f, a2[0]);
                aph.m18683a();
                b = mi.m19875b(this.f32239f, a2[1]);
                i = b4;
                if (this.f32228L != b2 && this.f32227K == b3 && this.f32229M == i && this.f32230N == b) {
                    return false;
                }
                if (!(this.f32228L == b2 && this.f32227K == b3)) {
                    z = true;
                }
                this.f32228L = b2;
                this.f32227K = b3;
                this.f32229M = i;
                this.f32230N = b;
                new C4933n(this).m19929a(b2, b3, i, b, this.f32239f.density, this.f32232P.getDefaultDisplay().getRotation());
                return z;
            }
        }
        i = b2;
        b = b3;
        if (this.f32228L != b2) {
        }
        z = true;
        this.f32228L = b2;
        this.f32227K = b3;
        this.f32229M = i;
        this.f32230N = b;
        new C4933n(this).m19929a(b2, b3, i, b, this.f32239f.density, this.f32232P.getDefaultDisplay().getRotation());
        return z;
    }

    /* renamed from: L */
    private final synchronized void m42301L() {
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
        r2 = this;
        monitor-enter(r2);
        r0 = com.google.android.gms.ads.internal.ax.i();	 Catch:{ all -> 0x0029 }
        r0 = r0.m30838c();	 Catch:{ all -> 0x0029 }
        r2.f32251r = r0;	 Catch:{ all -> 0x0029 }
        r0 = r2.f32251r;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x0027;
    L_0x000f:
        r0 = "(function(){})()";	 Catch:{ IllegalStateException -> 0x001f }
        r1 = 0;	 Catch:{ IllegalStateException -> 0x001f }
        r2.evaluateJavascript(r0, r1);	 Catch:{ IllegalStateException -> 0x001f }
        r0 = 1;	 Catch:{ IllegalStateException -> 0x001f }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ IllegalStateException -> 0x001f }
        r2.m42313a(r0);	 Catch:{ IllegalStateException -> 0x001f }
        monitor-exit(r2);
        return;
    L_0x001f:
        r0 = 0;
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x0029 }
        r2.m42313a(r0);	 Catch:{ all -> 0x0029 }
    L_0x0027:
        monitor-exit(r2);
        return;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.rb.L():void");
    }

    /* renamed from: M */
    private final synchronized Boolean m42302M() {
        return this.f32251r;
    }

    /* renamed from: N */
    private final void m42303N() {
        asv.m18908a(this.f32222F.m18913a(), this.f32220D, "aeh2");
    }

    /* renamed from: O */
    private final synchronized void m42304O() {
        if (!this.f32249p) {
            if (!this.f32245l.m20093d()) {
                if (VERSION.SDK_INT < 18) {
                    mt.m19918b("Disabling hardware acceleration on an AdView.");
                    m42305P();
                    return;
                }
                mt.m19918b("Enabling hardware acceleration on an AdView.");
                m42306Q();
                return;
            }
        }
        mt.m19918b("Enabling hardware acceleration on an overlay.");
        m42306Q();
    }

    /* renamed from: P */
    private final synchronized void m42305P() {
        if (!this.f32250q) {
            ax.g().mo6106c((View) this);
        }
        this.f32250q = true;
    }

    /* renamed from: Q */
    private final synchronized void m42306Q() {
        if (this.f32250q) {
            ax.g().mo6105b((View) this);
        }
        this.f32250q = false;
    }

    /* renamed from: R */
    private final synchronized void m42307R() {
        if (!this.f32225I) {
            this.f32225I = true;
            ax.i().m30845j();
        }
    }

    /* renamed from: S */
    private final synchronized void m42308S() {
        this.f32231O = null;
    }

    /* renamed from: T */
    private final void m42309T() {
        if (this.f32222F != null) {
            atc a = this.f32222F.m18913a();
            if (!(a == null || ax.i().m30836b() == null)) {
                ax.i().m30836b().m18905a(a);
            }
        }
    }

    /* renamed from: a */
    static rb m42312a(Context context, sc scVar, String str, boolean z, boolean z2, ahi ahi, mv mvVar, atc atc, aq aqVar, bu buVar, amx amx) {
        Context context2 = context;
        return new rb(new sb(context), scVar, str, z, z2, ahi, mvVar, atc, aqVar, buVar, amx);
    }

    /* renamed from: a */
    private final void m42313a(Boolean bool) {
        synchronized (this) {
            this.f32251r = bool;
        }
        ax.i().m30833a(bool);
    }

    @TargetApi(19)
    /* renamed from: a */
    private final synchronized void m42314a(String str, ValueCallback<String> valueCallback) {
        if (mo6660A()) {
            mt.m19924e("#004 The webview is destroyed. Ignoring action.");
        } else {
            evaluateJavascript(str, null);
        }
    }

    /* renamed from: c */
    private final synchronized void m42316c(String str) {
        if (mo6660A()) {
            mt.m19924e("#004 The webview is destroyed. Ignoring action.");
        } else {
            loadUrl(str);
        }
    }

    /* renamed from: d */
    private final synchronized void m42317d(String str) {
        try {
            super.loadUrl(str);
        } catch (Throwable e) {
            ax.i().m30834a(e, "AdWebViewImpl.loadUrlUnsafe");
            mt.m19921c("Could not call loadUrl. ", e);
        }
    }

    /* renamed from: e */
    private final void m42318e(String str) {
        if (C2904o.g()) {
            if (m42302M() == null) {
                m42301L();
            }
            if (m42302M().booleanValue()) {
                m42314a(str, null);
                return;
            }
            String str2 = "javascript:";
            str = String.valueOf(str);
            m42316c(str.length() != 0 ? str2.concat(str) : new String(str2));
            return;
        }
        str2 = "javascript:";
        str = String.valueOf(str);
        m42316c(str.length() != 0 ? str2.concat(str) : new String(str2));
    }

    /* renamed from: f */
    private final void m42319f(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        mo6650a("onAdVisibilityChanged", hashMap);
    }

    /* renamed from: A */
    public final synchronized boolean mo6660A() {
        return this.f32248o;
    }

    /* renamed from: B */
    public final synchronized void mo6661B() {
        jn.m30864a("Destroying WebView!");
        m42307R();
        jw.f15691a.post(new rd(this));
    }

    /* renamed from: C */
    public final synchronized boolean mo6662C() {
        return this.f32253t;
    }

    /* renamed from: D */
    public final synchronized boolean mo6663D() {
        return this.f32254u;
    }

    /* renamed from: E */
    public final synchronized boolean mo6664E() {
        return this.f32217A > 0;
    }

    /* renamed from: F */
    public final void mo6665F() {
        this.f32226J.m19859a();
    }

    /* renamed from: G */
    public final void mo6666G() {
        if (this.f32221E == null) {
            this.f32221E = asv.m18907a(this.f32222F.m18913a());
            this.f32222F.m18914a("native:view_load", this.f32221E);
        }
    }

    /* renamed from: H */
    public final synchronized aud mo6667H() {
        return this.f32259z;
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
            asv.m18908a(this.f32222F.m18913a(), this.f32220D, "aebb2");
        }
        m42303N();
        if (this.f32222F.m18913a() != null) {
            this.f32222F.m18913a().m18920a("close_type", String.valueOf(i));
        }
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.f32236c.f28709a);
        mo6650a("onhide", hashMap);
    }

    /* renamed from: a */
    public final void mo6672a(Context context) {
        this.f32234a.setBaseContext(context);
        this.f32226J.m19860a(this.f32234a.m20086a());
    }

    /* renamed from: a */
    public final void mo6673a(C4739c c4739c) {
        this.f32243j.m31016a(c4739c);
    }

    /* renamed from: a */
    public final synchronized void mo6674a(C4740d c4740d) {
        this.f32244k = c4740d;
    }

    /* renamed from: a */
    public final void mo4298a(akv akv) {
        synchronized (this) {
            this.f32257x = akv.f14657a;
        }
        m42319f(akv.f14657a);
    }

    /* renamed from: a */
    public final synchronized void mo6675a(aud aud) {
        this.f32259z = aud;
    }

    /* renamed from: a */
    public final synchronized void mo6126a(re reVar) {
        if (this.f32256w != null) {
            mt.m19920c("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.f32256w = reVar;
        }
    }

    /* renamed from: a */
    public final synchronized void mo6676a(sc scVar) {
        this.f32245l = scVar;
        requestLayout();
    }

    /* renamed from: a */
    public final synchronized void mo6677a(String str) {
        if (str == null) {
            str = "";
        }
        this.f32255v = str;
    }

    /* renamed from: a */
    public final void mo6678a(String str, ae<? super qo> aeVar) {
        if (this.f32243j != null) {
            this.f32243j.m31022a(str, (ae) aeVar);
        }
    }

    /* renamed from: a */
    public final void mo6679a(String str, C2905p<ae<? super qo>> c2905p) {
        if (this.f32243j != null) {
            this.f32243j.m31023a(str, (C2905p) c2905p);
        }
    }

    /* renamed from: a */
    public final synchronized void mo6680a(String str, String str2, String str3) {
        if (mo6660A()) {
            mt.m19924e("#004 The webview is destroyed. Ignoring action.");
            return;
        }
        if (((Boolean) aph.m18688f().m18889a(asp.aB)).booleanValue()) {
            str2 = rq.m20061a(str2, rq.m20060a());
        }
        super.loadDataWithBaseURL(str, str2, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, Utf8Charset.NAME, str3);
    }

    /* renamed from: a */
    public final void mo6650a(java.lang.String r2, java.util.Map<java.lang.String, ?> r3) {
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
        r1 = this;
        r0 = com.google.android.gms.ads.internal.ax.e();	 Catch:{ JSONException -> 0x000c }
        r3 = r0.m19737a(r3);	 Catch:{ JSONException -> 0x000c }
        r1.mo4089a(r2, r3);
        return;
    L_0x000c:
        r2 = "Could not convert parameters to JSON.";
        com.google.android.gms.internal.ads.mt.m19924e(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.rb.a(java.lang.String, java.util.Map):void");
    }

    /* renamed from: a */
    public final void mo4089a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(window.AFMA_ReceiveMessage || function() {})('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        str = "Dispatching AFMA event: ";
        jSONObject2 = String.valueOf(stringBuilder.toString());
        mt.m19918b(jSONObject2.length() != 0 ? str.concat(jSONObject2) : new String(str));
        m42318e(stringBuilder.toString());
    }

    /* renamed from: a */
    public final void mo6681a(boolean z) {
        this.f32243j.m31024a(z);
    }

    /* renamed from: a */
    public final void mo6682a(boolean z, int i) {
        this.f32243j.m31025a(z, i);
    }

    /* renamed from: a */
    public final void mo6683a(boolean z, int i, String str) {
        this.f32243j.m31026a(z, i, str);
    }

    /* renamed from: a */
    public final void mo6684a(boolean z, int i, String str, String str2) {
        this.f32243j.m31027a(z, i, str, str2);
    }

    /* renamed from: b */
    public final synchronized re mo6127b() {
        return this.f32256w;
    }

    /* renamed from: b */
    public final synchronized void mo6685b(C4740d c4740d) {
        this.f32224H = c4740d;
    }

    /* renamed from: b */
    public final void mo4090b(String str) {
        m42318e(str);
    }

    /* renamed from: b */
    public final void mo6686b(String str, ae<? super qo> aeVar) {
        if (this.f32243j != null) {
            this.f32243j.m31028b(str, (ae) aeVar);
        }
    }

    /* renamed from: b */
    public final void mo6652b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(jSONObject2).length());
        stringBuilder.append(str);
        stringBuilder.append("(");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        m42318e(stringBuilder.toString());
    }

    /* renamed from: b */
    public final synchronized void mo6687b(boolean z) {
        Object obj = z != this.f32249p ? 1 : null;
        this.f32249p = z;
        m42304O();
        if (obj != null) {
            new C4933n(this).m19933c(z ? "expanded" : "default");
        }
    }

    /* renamed from: c */
    public final ata mo6688c() {
        return this.f32220D;
    }

    /* renamed from: c */
    public final synchronized void mo6689c(boolean z) {
        if (this.f32244k != null) {
            this.f32244k.a(this.f32243j.mo4347b(), z);
        } else {
            this.f32247n = z;
        }
    }

    /* renamed from: d */
    public final Activity mo6128d() {
        return this.f32234a.m20086a();
    }

    /* renamed from: d */
    public final synchronized void mo6690d(boolean z) {
        this.f32253t = z;
    }

    public final synchronized void destroy() {
        m42309T();
        this.f32226J.m19861b();
        if (this.f32244k != null) {
            this.f32244k.a();
            this.f32244k.k();
            this.f32244k = null;
        }
        this.f32243j.m31038k();
        if (!this.f32248o) {
            ax.z();
            py.m20029a((pn) this);
            m42308S();
            this.f32248o = true;
            jn.m30864a("Initiating WebView self destruct sequence in 3...");
            jn.m30864a("Loading blank page in WebView, 2...");
            m42317d("about:blank");
        }
    }

    /* renamed from: e */
    public final bu mo6129e() {
        return this.f32238e;
    }

    /* renamed from: e */
    public final synchronized void mo6692e(boolean z) {
        this.f32217A += z ? 1 : -1;
        if (this.f32217A <= 0 && this.f32244k != null) {
            this.f32244k.q();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(19)
    public final synchronized void evaluateJavascript(java.lang.String r2, android.webkit.ValueCallback<java.lang.String> r3) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.mo6660A();	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x0014;
    L_0x0007:
        r2 = "#004 The webview is destroyed. Ignoring action.";
        com.google.android.gms.internal.ads.mt.m19925f(r2);	 Catch:{ all -> 0x0019 }
        if (r3 == 0) goto L_0x0012;
    L_0x000e:
        r2 = 0;
        r3.onReceiveValue(r2);	 Catch:{ all -> 0x0019 }
    L_0x0012:
        monitor-exit(r1);
        return;
    L_0x0014:
        super.evaluateJavascript(r2, r3);	 Catch:{ all -> 0x0019 }
        monitor-exit(r1);
        return;
    L_0x0019:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.rb.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    /* renamed from: f */
    public final void mo6693f() {
        C4740d r = mo6709r();
        if (r != null) {
            r.p();
        }
    }

    protected final void finalize() {
        try {
            synchronized (this) {
                if (!this.f32248o) {
                    this.f32243j.m31038k();
                    ax.z();
                    py.m20029a((pn) this);
                    m42308S();
                    m42307R();
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final OnClickListener getOnClickListener() {
        return (OnClickListener) this.f32223G.get();
    }

    public final synchronized int getRequestedOrientation() {
        return this.f32252s;
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this;
    }

    /* renamed from: i */
    public final synchronized String mo6697i() {
        return this.f32255v;
    }

    /* renamed from: j */
    public final atb mo6132j() {
        return this.f32222F;
    }

    /* renamed from: k */
    public final mv mo6133k() {
        return this.f32236c;
    }

    /* renamed from: l */
    public final int mo6698l() {
        return getMeasuredHeight();
    }

    public final synchronized void loadData(String str, String str2, String str3) {
        if (mo6660A()) {
            mt.m19924e("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadData(str, str2, str3);
        }
    }

    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (mo6660A()) {
            mt.m19924e("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public final synchronized void loadUrl(String str) {
        if (mo6660A()) {
            mt.m19924e("#004 The webview is destroyed. Ignoring action.");
            return;
        }
        try {
            super.loadUrl(str);
        } catch (Throwable e) {
            ax.i().m30834a(e, "AdWebViewImpl.loadUrl");
            mt.m19921c("Could not call loadUrl. ", e);
        }
    }

    /* renamed from: m */
    public final int mo6702m() {
        return getMeasuredWidth();
    }

    public final synchronized void m_() {
        this.f32254u = true;
        if (this.f32237d != null) {
            this.f32237d.m_();
        }
    }

    /* renamed from: n */
    public final void mo6703n() {
        m42303N();
        Map hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.f32236c.f28709a);
        mo6650a("onhide", hashMap);
    }

    public final synchronized void n_() {
        this.f32254u = false;
        if (this.f32237d != null) {
            this.f32237d.n_();
        }
    }

    /* renamed from: o */
    public final void mo6704o() {
        if (this.f32219C == null) {
            asv.m18908a(this.f32222F.m18913a(), this.f32220D, "aes2");
            this.f32219C = asv.m18907a(this.f32222F.m18913a());
            this.f32222F.m18914a("native:view_show", this.f32219C);
        }
        Map hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.f32236c.f28709a);
        mo6650a("onshow", hashMap);
    }

    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!mo6660A()) {
            this.f32226J.m19862c();
        }
        boolean z = this.f32257x;
        if (this.f32243j != null && this.f32243j.m31030c()) {
            if (!this.f32258y) {
                OnGlobalLayoutListener d = this.f32243j.m31031d();
                if (d != null) {
                    ax.A();
                    oh.m19964a((View) this, d);
                }
                OnScrollChangedListener e = this.f32243j.m31032e();
                if (e != null) {
                    ax.A();
                    oh.m19965a((View) this, e);
                }
                this.f32258y = true;
            }
            m42300K();
            z = true;
        }
        m42319f(z);
    }

    protected final void onDetachedFromWindow() {
        synchronized (this) {
            if (!mo6660A()) {
                this.f32226J.m19863d();
            }
            super.onDetachedFromWindow();
            if (this.f32258y && this.f32243j != null && this.f32243j.m31030c() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                OnGlobalLayoutListener d = this.f32243j.m31031d();
                if (d != null) {
                    ax.g().mo6844a(getViewTreeObserver(), d);
                }
                OnScrollChangedListener e = this.f32243j.m31032e();
                if (e != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(e);
                }
                this.f32258y = false;
            }
        }
        m42319f(false);
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.rb.onDownloadStart(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long):void");
    }

    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (!mo6660A()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
                if (!(this.f32243j == null || this.f32243j.m31039l() == null)) {
                    this.f32243j.m31039l().m20085a();
                }
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
        boolean K = m42300K();
        C4740d r = mo6709r();
        if (r != null && K) {
            r.o();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"DrawAllocation"})
    protected final synchronized void onMeasure(int r8, int r9) {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = r7.mo6660A();	 Catch:{ all -> 0x01db }
        r1 = 0;
        if (r0 == 0) goto L_0x000d;
    L_0x0008:
        r7.setMeasuredDimension(r1, r1);	 Catch:{ all -> 0x01db }
        monitor-exit(r7);
        return;
    L_0x000d:
        r0 = r7.isInEditMode();	 Catch:{ all -> 0x01db }
        if (r0 != 0) goto L_0x01d6;
    L_0x0013:
        r0 = r7.f32249p;	 Catch:{ all -> 0x01db }
        if (r0 != 0) goto L_0x01d6;
    L_0x0017:
        r0 = r7.f32245l;	 Catch:{ all -> 0x01db }
        r0 = r0.m20094e();	 Catch:{ all -> 0x01db }
        if (r0 == 0) goto L_0x0021;
    L_0x001f:
        goto L_0x01d6;
    L_0x0021:
        r0 = r7.f32245l;	 Catch:{ all -> 0x01db }
        r0 = r0.m20095f();	 Catch:{ all -> 0x01db }
        if (r0 == 0) goto L_0x006d;
    L_0x0029:
        r0 = r7.mo6127b();	 Catch:{ all -> 0x01db }
        r1 = 0;
        if (r0 == 0) goto L_0x0035;
    L_0x0030:
        r0 = r0.mo3943e();	 Catch:{ all -> 0x01db }
        goto L_0x0036;
    L_0x0035:
        r0 = 0;
    L_0x0036:
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 != 0) goto L_0x003f;
    L_0x003a:
        super.onMeasure(r8, r9);	 Catch:{ all -> 0x01db }
        monitor-exit(r7);
        return;
    L_0x003f:
        r8 = android.view.View.MeasureSpec.getSize(r8);	 Catch:{ all -> 0x01db }
        r9 = android.view.View.MeasureSpec.getSize(r9);	 Catch:{ all -> 0x01db }
        r1 = (float) r9;	 Catch:{ all -> 0x01db }
        r1 = r1 * r0;
        r1 = (int) r1;	 Catch:{ all -> 0x01db }
        r2 = (float) r8;	 Catch:{ all -> 0x01db }
        r2 = r2 / r0;
        r2 = (int) r2;	 Catch:{ all -> 0x01db }
        if (r9 != 0) goto L_0x0058;
    L_0x0050:
        if (r2 == 0) goto L_0x0058;
    L_0x0052:
        r9 = (float) r2;	 Catch:{ all -> 0x01db }
        r9 = r9 * r0;
        r1 = (int) r9;	 Catch:{ all -> 0x01db }
        r9 = r2;
        goto L_0x0060;
    L_0x0058:
        if (r8 != 0) goto L_0x0060;
    L_0x005a:
        if (r1 == 0) goto L_0x0060;
    L_0x005c:
        r8 = (float) r1;	 Catch:{ all -> 0x01db }
        r8 = r8 / r0;
        r2 = (int) r8;	 Catch:{ all -> 0x01db }
        r8 = r1;
    L_0x0060:
        r8 = java.lang.Math.min(r1, r8);	 Catch:{ all -> 0x01db }
        r9 = java.lang.Math.min(r2, r9);	 Catch:{ all -> 0x01db }
        r7.setMeasuredDimension(r8, r9);	 Catch:{ all -> 0x01db }
        monitor-exit(r7);
        return;
    L_0x006d:
        r0 = r7.f32245l;	 Catch:{ all -> 0x01db }
        r0 = r0.m20092c();	 Catch:{ all -> 0x01db }
        if (r0 == 0) goto L_0x00bf;
    L_0x0075:
        r0 = com.google.android.gms.internal.ads.asp.cm;	 Catch:{ all -> 0x01db }
        r1 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ all -> 0x01db }
        r0 = r1.m18889a(r0);	 Catch:{ all -> 0x01db }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x01db }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x01db }
        if (r0 != 0) goto L_0x00ba;
    L_0x0087:
        r0 = com.google.android.gms.common.util.C2904o.e();	 Catch:{ all -> 0x01db }
        if (r0 != 0) goto L_0x008e;
    L_0x008d:
        goto L_0x00ba;
    L_0x008e:
        r0 = "/contentHeight";
        r1 = new com.google.android.gms.internal.ads.rc;	 Catch:{ all -> 0x01db }
        r1.<init>(r7);	 Catch:{ all -> 0x01db }
        r7.mo6678a(r0, r1);	 Catch:{ all -> 0x01db }
        r0 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();";
        r7.m42318e(r0);	 Catch:{ all -> 0x01db }
        r0 = r7.f32239f;	 Catch:{ all -> 0x01db }
        r0 = r0.density;	 Catch:{ all -> 0x01db }
        r8 = android.view.View.MeasureSpec.getSize(r8);	 Catch:{ all -> 0x01db }
        r1 = r7.f32218B;	 Catch:{ all -> 0x01db }
        r2 = -1;
        if (r1 == r2) goto L_0x00b1;
    L_0x00aa:
        r9 = r7.f32218B;	 Catch:{ all -> 0x01db }
        r9 = (float) r9;	 Catch:{ all -> 0x01db }
        r9 = r9 * r0;
        r9 = (int) r9;	 Catch:{ all -> 0x01db }
        goto L_0x00b5;
    L_0x00b1:
        r9 = android.view.View.MeasureSpec.getSize(r9);	 Catch:{ all -> 0x01db }
    L_0x00b5:
        r7.setMeasuredDimension(r8, r9);	 Catch:{ all -> 0x01db }
        monitor-exit(r7);
        return;
    L_0x00ba:
        super.onMeasure(r8, r9);	 Catch:{ all -> 0x01db }
        monitor-exit(r7);
        return;
    L_0x00bf:
        r0 = r7.f32245l;	 Catch:{ all -> 0x01db }
        r0 = r0.m20093d();	 Catch:{ all -> 0x01db }
        if (r0 == 0) goto L_0x00d4;
    L_0x00c7:
        r8 = r7.f32239f;	 Catch:{ all -> 0x01db }
        r8 = r8.widthPixels;	 Catch:{ all -> 0x01db }
        r9 = r7.f32239f;	 Catch:{ all -> 0x01db }
        r9 = r9.heightPixels;	 Catch:{ all -> 0x01db }
        r7.setMeasuredDimension(r8, r9);	 Catch:{ all -> 0x01db }
        monitor-exit(r7);
        return;
    L_0x00d4:
        r0 = android.view.View.MeasureSpec.getMode(r8);	 Catch:{ all -> 0x01db }
        r8 = android.view.View.MeasureSpec.getSize(r8);	 Catch:{ all -> 0x01db }
        r2 = android.view.View.MeasureSpec.getMode(r9);	 Catch:{ all -> 0x01db }
        r9 = android.view.View.MeasureSpec.getSize(r9);	 Catch:{ all -> 0x01db }
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r5 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r0 == r4) goto L_0x00f4;
    L_0x00ed:
        if (r0 != r3) goto L_0x00f0;
    L_0x00ef:
        goto L_0x00f4;
    L_0x00f0:
        r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        goto L_0x00f5;
    L_0x00f4:
        r0 = r8;
    L_0x00f5:
        if (r2 == r4) goto L_0x00f9;
    L_0x00f7:
        if (r2 != r3) goto L_0x00fa;
    L_0x00f9:
        r5 = r9;
    L_0x00fa:
        r2 = r7.f32245l;	 Catch:{ all -> 0x01db }
        r2 = r2.f15992b;	 Catch:{ all -> 0x01db }
        r3 = 1;
        if (r2 > r0) goto L_0x010a;
    L_0x0101:
        r2 = r7.f32245l;	 Catch:{ all -> 0x01db }
        r2 = r2.f15991a;	 Catch:{ all -> 0x01db }
        if (r2 <= r5) goto L_0x0108;
    L_0x0107:
        goto L_0x010a;
    L_0x0108:
        r2 = 0;
        goto L_0x010b;
    L_0x010a:
        r2 = 1;
    L_0x010b:
        r4 = com.google.android.gms.internal.ads.asp.dh;	 Catch:{ all -> 0x01db }
        r6 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ all -> 0x01db }
        r4 = r6.m18889a(r4);	 Catch:{ all -> 0x01db }
        r4 = (java.lang.Boolean) r4;	 Catch:{ all -> 0x01db }
        r4 = r4.booleanValue();	 Catch:{ all -> 0x01db }
        if (r4 == 0) goto L_0x0143;
    L_0x011d:
        r4 = r7.f32245l;	 Catch:{ all -> 0x01db }
        r4 = r4.f15992b;	 Catch:{ all -> 0x01db }
        r4 = (float) r4;	 Catch:{ all -> 0x01db }
        r6 = r7.f32240g;	 Catch:{ all -> 0x01db }
        r4 = r4 / r6;
        r0 = (float) r0;	 Catch:{ all -> 0x01db }
        r6 = r7.f32240g;	 Catch:{ all -> 0x01db }
        r0 = r0 / r6;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 > 0) goto L_0x013f;
    L_0x012d:
        r0 = r7.f32245l;	 Catch:{ all -> 0x01db }
        r0 = r0.f15991a;	 Catch:{ all -> 0x01db }
        r0 = (float) r0;	 Catch:{ all -> 0x01db }
        r4 = r7.f32240g;	 Catch:{ all -> 0x01db }
        r0 = r0 / r4;
        r4 = (float) r5;	 Catch:{ all -> 0x01db }
        r5 = r7.f32240g;	 Catch:{ all -> 0x01db }
        r4 = r4 / r5;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 > 0) goto L_0x013f;
    L_0x013d:
        r0 = 1;
        goto L_0x0140;
    L_0x013f:
        r0 = 0;
    L_0x0140:
        if (r2 == 0) goto L_0x0143;
    L_0x0142:
        goto L_0x0144;
    L_0x0143:
        r0 = r2;
    L_0x0144:
        r2 = 8;
        if (r0 == 0) goto L_0x01b3;
    L_0x0148:
        r0 = r7.f32245l;	 Catch:{ all -> 0x01db }
        r0 = r0.f15992b;	 Catch:{ all -> 0x01db }
        r0 = (float) r0;	 Catch:{ all -> 0x01db }
        r4 = r7.f32240g;	 Catch:{ all -> 0x01db }
        r0 = r0 / r4;
        r0 = (int) r0;	 Catch:{ all -> 0x01db }
        r4 = r7.f32245l;	 Catch:{ all -> 0x01db }
        r4 = r4.f15991a;	 Catch:{ all -> 0x01db }
        r4 = (float) r4;	 Catch:{ all -> 0x01db }
        r5 = r7.f32240g;	 Catch:{ all -> 0x01db }
        r4 = r4 / r5;
        r4 = (int) r4;	 Catch:{ all -> 0x01db }
        r8 = (float) r8;	 Catch:{ all -> 0x01db }
        r5 = r7.f32240g;	 Catch:{ all -> 0x01db }
        r8 = r8 / r5;
        r8 = (int) r8;	 Catch:{ all -> 0x01db }
        r9 = (float) r9;	 Catch:{ all -> 0x01db }
        r5 = r7.f32240g;	 Catch:{ all -> 0x01db }
        r9 = r9 / r5;
        r9 = (int) r9;	 Catch:{ all -> 0x01db }
        r5 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01db }
        r6.<init>(r5);	 Catch:{ all -> 0x01db }
        r5 = "Not enough space to show ad. Needs ";
        r6.append(r5);	 Catch:{ all -> 0x01db }
        r6.append(r0);	 Catch:{ all -> 0x01db }
        r0 = "x";
        r6.append(r0);	 Catch:{ all -> 0x01db }
        r6.append(r4);	 Catch:{ all -> 0x01db }
        r0 = " dp, but only has ";
        r6.append(r0);	 Catch:{ all -> 0x01db }
        r6.append(r8);	 Catch:{ all -> 0x01db }
        r8 = "x";
        r6.append(r8);	 Catch:{ all -> 0x01db }
        r6.append(r9);	 Catch:{ all -> 0x01db }
        r8 = " dp.";
        r6.append(r8);	 Catch:{ all -> 0x01db }
        r8 = r6.toString();	 Catch:{ all -> 0x01db }
        com.google.android.gms.internal.ads.mt.m19924e(r8);	 Catch:{ all -> 0x01db }
        r8 = r7.getVisibility();	 Catch:{ all -> 0x01db }
        if (r8 == r2) goto L_0x01a1;
    L_0x019d:
        r8 = 4;
        r7.setVisibility(r8);	 Catch:{ all -> 0x01db }
    L_0x01a1:
        r7.setMeasuredDimension(r1, r1);	 Catch:{ all -> 0x01db }
        r8 = r7.f32241h;	 Catch:{ all -> 0x01db }
        if (r8 != 0) goto L_0x01d4;
    L_0x01a8:
        r8 = r7.f32233Q;	 Catch:{ all -> 0x01db }
        r9 = com.google.android.gms.internal.ads.amz.C8283a.C6762b.BANNER_SIZE_INVALID;	 Catch:{ all -> 0x01db }
        r8.m18649a(r9);	 Catch:{ all -> 0x01db }
        r7.f32241h = r3;	 Catch:{ all -> 0x01db }
        monitor-exit(r7);
        return;
    L_0x01b3:
        r8 = r7.getVisibility();	 Catch:{ all -> 0x01db }
        if (r8 == r2) goto L_0x01bc;
    L_0x01b9:
        r7.setVisibility(r1);	 Catch:{ all -> 0x01db }
    L_0x01bc:
        r8 = r7.f32242i;	 Catch:{ all -> 0x01db }
        if (r8 != 0) goto L_0x01c9;
    L_0x01c0:
        r8 = r7.f32233Q;	 Catch:{ all -> 0x01db }
        r9 = com.google.android.gms.internal.ads.amz.C8283a.C6762b.BANNER_SIZE_VALID;	 Catch:{ all -> 0x01db }
        r8.m18649a(r9);	 Catch:{ all -> 0x01db }
        r7.f32242i = r3;	 Catch:{ all -> 0x01db }
    L_0x01c9:
        r8 = r7.f32245l;	 Catch:{ all -> 0x01db }
        r8 = r8.f15992b;	 Catch:{ all -> 0x01db }
        r9 = r7.f32245l;	 Catch:{ all -> 0x01db }
        r9 = r9.f15991a;	 Catch:{ all -> 0x01db }
        r7.setMeasuredDimension(r8, r9);	 Catch:{ all -> 0x01db }
    L_0x01d4:
        monitor-exit(r7);
        return;
    L_0x01d6:
        super.onMeasure(r8, r9);	 Catch:{ all -> 0x01db }
        monitor-exit(r7);
        return;
    L_0x01db:
        r8 = move-exception;
        monitor-exit(r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.rb.onMeasure(int, int):void");
    }

    public final void onPause() {
        if (!mo6660A()) {
            try {
                if (C2904o.a()) {
                    super.onPause();
                }
            } catch (Throwable e) {
                mt.m19919b("Could not pause webview.", e);
            }
        }
    }

    public final void onResume() {
        if (!mo6660A()) {
            try {
                if (C2904o.a()) {
                    super.onResume();
                }
            } catch (Throwable e) {
                mt.m19919b("Could not resume webview.", e);
            }
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f32243j.m31030c()) {
            synchronized (this) {
                if (this.f32259z != null) {
                    this.f32259z.mo3968a(motionEvent);
                }
            }
        } else if (this.f32235b != null) {
            this.f32235b.m18433a(motionEvent);
        }
        return mo6660A() ? false : super.onTouchEvent(motionEvent);
    }

    /* renamed from: p */
    public final void mo6707p() {
        Map hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(ax.D().m19781b()));
        hashMap.put("app_volume", String.valueOf(ax.D().m19778a()));
        hashMap.put("device_volume", String.valueOf(ko.m19776a(getContext())));
        mo6650a("volume", hashMap);
    }

    /* renamed from: q */
    public final Context mo6708q() {
        return this.f32234a.m20087b();
    }

    /* renamed from: r */
    public final synchronized C4740d mo6709r() {
        return this.f32244k;
    }

    /* renamed from: s */
    public final synchronized C4740d mo6710s() {
        return this.f32224H;
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.f32223G = new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public final synchronized void setRequestedOrientation(int i) {
        this.f32252s = i;
        if (this.f32244k != null) {
            this.f32244k.a(this.f32252s);
        }
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof qp) {
            this.f32243j = (qp) webViewClient;
        }
    }

    public final void stopLoading() {
        if (!mo6660A()) {
            try {
                super.stopLoading();
            } catch (Throwable e) {
                mt.m19919b("Could not stop loading webview.", e);
            }
        }
    }

    /* renamed from: t */
    public final synchronized sc mo6135t() {
        return this.f32245l;
    }

    /* renamed from: u */
    public final synchronized String mo6717u() {
        return this.f32246m;
    }

    /* renamed from: v */
    public final /* synthetic */ rw mo6718v() {
        return this.f32243j;
    }

    /* renamed from: w */
    public final WebViewClient mo6719w() {
        return this.f32243j;
    }

    /* renamed from: x */
    public final synchronized boolean mo6720x() {
        return this.f32247n;
    }

    /* renamed from: y */
    public final ahi mo6136y() {
        return this.f32235b;
    }

    /* renamed from: z */
    public final synchronized boolean mo6137z() {
        return this.f32249p;
    }
}
