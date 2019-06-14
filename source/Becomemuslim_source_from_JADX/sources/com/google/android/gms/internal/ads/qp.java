package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.view.C0517s;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
import com.google.android.gms.common.util.C2905p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@cm
public class qp extends WebViewClient implements rw {
    /* renamed from: b */
    private static final String[] f24247b = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    /* renamed from: c */
    private static final String[] f24248c = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    /* renamed from: A */
    private boolean f24249A;
    /* renamed from: B */
    private boolean f24250B;
    /* renamed from: C */
    private int f24251C;
    /* renamed from: D */
    private OnAttachStateChangeListener f24252D;
    /* renamed from: a */
    protected id f24253a;
    /* renamed from: d */
    private qo f24254d;
    /* renamed from: e */
    private final HashMap<String, List<ae<? super qo>>> f24255e;
    /* renamed from: f */
    private final Object f24256f;
    /* renamed from: g */
    private aok f24257g;
    /* renamed from: h */
    private C2665n f24258h;
    /* renamed from: i */
    private rx f24259i;
    /* renamed from: j */
    private ry f24260j;
    /* renamed from: k */
    private C2651k f24261k;
    /* renamed from: l */
    private C2652m f24262l;
    /* renamed from: m */
    private rz f24263m;
    /* renamed from: n */
    private boolean f24264n;
    /* renamed from: o */
    private ai f24265o;
    /* renamed from: p */
    private boolean f24266p;
    /* renamed from: q */
    private boolean f24267q;
    /* renamed from: r */
    private OnGlobalLayoutListener f24268r;
    /* renamed from: s */
    private OnScrollChangedListener f24269s;
    /* renamed from: t */
    private boolean f24270t;
    /* renamed from: u */
    private C2668t f24271u;
    /* renamed from: v */
    private final C6765m f24272v;
    /* renamed from: w */
    private bv f24273w;
    /* renamed from: x */
    private C6763d f24274x;
    /* renamed from: y */
    private C4934o f24275y;
    /* renamed from: z */
    private sa f24276z;

    public qp(qo qoVar, boolean z) {
        this(qoVar, z, new C6765m(qoVar, qoVar.mo6708q(), new asa(qoVar.getContext())), null);
    }

    private qp(qo qoVar, boolean z, C6765m c6765m, C6763d c6763d) {
        this.f24255e = new HashMap();
        this.f24256f = new Object();
        this.f24264n = false;
        this.f24254d = qoVar;
        this.f24266p = z;
        this.f24272v = c6765m;
        this.f24274x = null;
    }

    /* renamed from: a */
    private final void m31003a(Context context, String str, String str2, String str3) {
        if (((Boolean) aph.m18688f().m18889a(asp.bs)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            str = "host";
            if (!TextUtils.isEmpty(str3)) {
                Uri parse = Uri.parse(str3);
                if (parse.getHost() != null) {
                    str2 = parse.getHost();
                    bundle.putString(str, str2);
                    ax.e().m19739a(context, this.f24254d.mo6133k().f28709a, "gmob-apps", bundle, true);
                }
            }
            str2 = "";
            bundle.putString(str, str2);
            ax.e().m19739a(context, this.f24254d.mo6133k().f28709a, "gmob-apps", bundle, true);
        }
    }

    /* renamed from: a */
    private final void m31004a(Uri uri) {
        String path = uri.getPath();
        List<ae> list = (List) this.f24255e.get(path);
        if (list != null) {
            ax.e();
            Map a = jw.m19693a(uri);
            if (mt.m19917a(2)) {
                String str = "Received GMSG: ";
                path = String.valueOf(path);
                jn.m30864a(path.length() != 0 ? str.concat(path) : new String(str));
                for (String str2 : a.keySet()) {
                    String str3 = (String) a.get(str2);
                    StringBuilder stringBuilder = new StringBuilder((String.valueOf(str2).length() + 4) + String.valueOf(str3).length());
                    stringBuilder.append("  ");
                    stringBuilder.append(str2);
                    stringBuilder.append(": ");
                    stringBuilder.append(str3);
                    jn.m30864a(stringBuilder.toString());
                }
            }
            for (ae zza : list) {
                zza.zza(this.f24254d, a);
            }
            return;
        }
        String valueOf = String.valueOf(uri);
        StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(valueOf).length() + 32);
        stringBuilder2.append("No GMSG handler found for GMSG: ");
        stringBuilder2.append(valueOf);
        jn.m30864a(stringBuilder2.toString());
    }

    /* renamed from: a */
    private final void m31005a(View view, id idVar, int i) {
        if (idVar.mo4293b() && i > 0) {
            idVar.mo4289a(view);
            if (idVar.mo4293b()) {
                jw.f15691a.postDelayed(new qr(this, view, idVar, i), 100);
            }
        }
    }

    /* renamed from: a */
    private final void m31006a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean a = this.f24274x != null ? this.f24274x.m30693a() : false;
        ax.c();
        Context context = this.f24254d.getContext();
        if (!a) {
            z = true;
        }
        C2663l.a(context, adOverlayInfoParcel, z);
        if (this.f24253a != null) {
            String str = adOverlayInfoParcel.f13032l;
            if (str == null && adOverlayInfoParcel.f13021a != null) {
                str = adOverlayInfoParcel.f13021a.f13037a;
            }
            this.f24253a.mo4290a(str);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private final android.webkit.WebResourceResponse m31008b(java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
        r7 = this;
        r0 = new java.net.URL;
        r0.<init>(r8);
        r8 = 0;
        r1 = r0;
        r0 = 0;
    L_0x0008:
        r0 = r0 + 1;
        r2 = 20;
        if (r0 > r2) goto L_0x00ed;
    L_0x000e:
        r2 = r1.openConnection();
        r3 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r2.setConnectTimeout(r3);
        r2.setReadTimeout(r3);
        r3 = r9.entrySet();
        r3 = r3.iterator();
    L_0x0022:
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x003e;
    L_0x0028:
        r4 = r3.next();
        r4 = (java.util.Map.Entry) r4;
        r5 = r4.getKey();
        r5 = (java.lang.String) r5;
        r4 = r4.getValue();
        r4 = (java.lang.String) r4;
        r2.addRequestProperty(r5, r4);
        goto L_0x0022;
    L_0x003e:
        r3 = r2 instanceof java.net.HttpURLConnection;
        if (r3 == 0) goto L_0x00e5;
    L_0x0042:
        r2 = (java.net.HttpURLConnection) r2;
        r3 = com.google.android.gms.ads.internal.ax.e();
        r4 = r7.f24254d;
        r4 = r4.getContext();
        r5 = r7.f24254d;
        r5 = r5.mo6133k();
        r5 = r5.f28709a;
        r3.m19740a(r4, r5, r8, r2);
        r3 = new com.google.android.gms.internal.ads.mm;
        r3.<init>();
        r4 = 0;
        r3.m19909a(r2, r4);
        r5 = r2.getResponseCode();
        r3.m19908a(r2, r5);
        r3 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r5 < r3) goto L_0x00dd;
    L_0x006d:
        r3 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r5 >= r3) goto L_0x00dd;
    L_0x0071:
        r3 = "Location";
        r3 = r2.getHeaderField(r3);
        if (r3 == 0) goto L_0x00d5;
    L_0x0079:
        r5 = new java.net.URL;
        r5.<init>(r1, r3);
        r1 = r5.getProtocol();
        if (r1 != 0) goto L_0x008a;
    L_0x0084:
        r8 = "Protocol is null";
        com.google.android.gms.internal.ads.mt.m19924e(r8);
        return r4;
    L_0x008a:
        r6 = "http";
        r6 = r1.equals(r6);
        if (r6 != 0) goto L_0x00b5;
    L_0x0092:
        r6 = "https";
        r6 = r1.equals(r6);
        if (r6 != 0) goto L_0x00b5;
    L_0x009a:
        r8 = "Unsupported scheme: ";
        r9 = java.lang.String.valueOf(r1);
        r0 = r9.length();
        if (r0 == 0) goto L_0x00ab;
    L_0x00a6:
        r8 = r8.concat(r9);
        goto L_0x00b1;
    L_0x00ab:
        r9 = new java.lang.String;
        r9.<init>(r8);
        r8 = r9;
    L_0x00b1:
        com.google.android.gms.internal.ads.mt.m19924e(r8);
        return r4;
    L_0x00b5:
        r1 = "Redirecting to ";
        r3 = java.lang.String.valueOf(r3);
        r4 = r3.length();
        if (r4 == 0) goto L_0x00c6;
    L_0x00c1:
        r1 = r1.concat(r3);
        goto L_0x00cc;
    L_0x00c6:
        r3 = new java.lang.String;
        r3.<init>(r1);
        r1 = r3;
    L_0x00cc:
        com.google.android.gms.internal.ads.mt.m19918b(r1);
        r2.disconnect();
        r1 = r5;
        goto L_0x0008;
    L_0x00d5:
        r8 = new java.io.IOException;
        r9 = "Missing Location header in redirect";
        r8.<init>(r9);
        throw r8;
    L_0x00dd:
        com.google.android.gms.ads.internal.ax.e();
        r8 = com.google.android.gms.internal.ads.jw.m19685a(r2);
        return r8;
    L_0x00e5:
        r8 = new java.io.IOException;
        r9 = "Invalid protocol.";
        r8.<init>(r9);
        throw r8;
    L_0x00ed:
        r8 = new java.io.IOException;
        r9 = 32;
        r0 = new java.lang.StringBuilder;
        r0.<init>(r9);
        r9 = "Too many redirects (20)";
        r0.append(r9);
        r9 = r0.toString();
        r8.<init>(r9);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.qp.b(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    /* renamed from: p */
    private final void m31009p() {
        if (this.f24252D != null) {
            this.f24254d.getView().removeOnAttachStateChangeListener(this.f24252D);
        }
    }

    /* renamed from: q */
    private final void m31010q() {
        if (this.f24259i != null && ((this.f24249A && this.f24251C <= 0) || this.f24250B)) {
            this.f24259i.mo3817a(this.f24250B ^ 1);
            this.f24259i = null;
        }
        this.f24254d.mo6666G();
    }

    /* renamed from: a */
    protected final WebResourceResponse m31011a(String str, Map<String, String> map) {
        try {
            String a = im.m19559a(str, this.f24254d.getContext());
            if (!a.equals(str)) {
                return m31008b(a, (Map) map);
            }
            amq a2 = amq.m36802a(str);
            if (a2 != null) {
                amn a3 = ax.k().m18637a(a2);
                if (a3 != null && a3.m36799a()) {
                    return new WebResourceResponse("", "", a3.m36800b());
                }
            }
            if (mm.m19905c()) {
                if (((Boolean) aph.m18688f().m18889a(asp.bi)).booleanValue()) {
                    return m31008b(str, (Map) map);
                }
            }
            return null;
        } catch (Throwable e) {
            ax.i().m30834a(e, "AdWebViewClient.interceptRequest");
            return null;
        }
    }

    /* renamed from: a */
    public final bv mo4338a() {
        return this.f24273w;
    }

    /* renamed from: a */
    public final void mo4339a(int i, int i2) {
        if (this.f24274x != null) {
            this.f24274x.m30689a(i, i2);
        }
    }

    /* renamed from: a */
    public final void mo4340a(int i, int i2, boolean z) {
        this.f24272v.m30898a(i, i2);
        if (this.f24274x != null) {
            this.f24274x.m30690a(i, i2, z);
        }
    }

    /* renamed from: a */
    public final void mo4341a(OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.f24256f) {
            this.f24267q = true;
            this.f24254d.mo6665F();
            this.f24268r = onGlobalLayoutListener;
            this.f24269s = onScrollChangedListener;
        }
    }

    /* renamed from: a */
    public final void m31016a(C4739c c4739c) {
        boolean z = this.f24254d.mo6137z();
        aok aok = (!z || this.f24254d.mo6135t().m20093d()) ? this.f24257g : null;
        m31006a(new AdOverlayInfoParcel(c4739c, aok, z ? null : this.f24258h, this.f24271u, this.f24254d.mo6133k()));
    }

    /* renamed from: a */
    public final void mo4342a(aok aok, C2651k c2651k, C2665n c2665n, C2652m c2652m, C2668t c2668t, boolean z, ai aiVar, bv bvVar, C4934o c4934o, id idVar) {
        C2651k c2651k2 = c2651k;
        C2652m c2652m2 = c2652m;
        ai aiVar2 = aiVar;
        C4934o c4934o2 = c4934o;
        id idVar2 = idVar;
        bv bvVar2 = bvVar == null ? new bv(this.f24254d.getContext(), idVar2, null) : bvVar;
        r0.f24274x = new C6763d(r0.f24254d, c4934o2);
        r0.f24253a = idVar2;
        if (((Boolean) aph.m18688f().m18889a(asp.aF)).booleanValue()) {
            m31022a("/adMetadata", new C4266a(c2651k2));
        }
        m31022a("/appEvent", new C4273l(c2652m2));
        m31022a("/backButton", C2653o.f6886j);
        m31022a("/refresh", C2653o.f6887k);
        m31022a("/canOpenURLs", C2653o.f6877a);
        m31022a("/canOpenIntents", C2653o.f6878b);
        m31022a("/click", C2653o.f6879c);
        m31022a("/close", C2653o.f6880d);
        m31022a("/customClose", C2653o.f6881e);
        m31022a("/instrument", C2653o.f6890n);
        m31022a("/delayPageLoaded", C2653o.f6892p);
        m31022a("/delayPageClosed", C2653o.f6893q);
        m31022a("/getLocationInfo", C2653o.f6894r);
        m31022a("/httpTrack", C2653o.f6882f);
        m31022a("/log", C2653o.f6883g);
        m31022a("/mraid", new C4269d(bvVar2, r0.f24274x, c4934o2));
        m31022a("/mraidLoaded", r0.f24272v);
        ae aeVar = r1;
        bv bvVar3 = bvVar2;
        C4270e c4270e = new C4270e(r0.f24254d.getContext(), r0.f24254d.mo6133k(), r0.f24254d.mo6136y(), c2668t, aok, c2651k, c2652m, c2665n, bvVar2, r0.f24274x);
        m31022a("/open", aeVar);
        m31022a("/precache", new qd());
        m31022a("/touch", C2653o.f6885i);
        m31022a("/video", C2653o.f6888l);
        m31022a("/videoMeta", C2653o.f6889m);
        if (ax.B().m19541a(r0.f24254d.getContext())) {
            m31022a("/logScionEvent", new C4268c(r0.f24254d.getContext()));
        }
        if (aiVar2 != null) {
            m31022a("/setInterstitialProperties", new ah(aiVar2));
        }
        r0.f24257g = aok;
        r0.f24258h = c2665n;
        r0.f24261k = c2651k2;
        r0.f24262l = c2652m;
        r0.f24271u = c2668t;
        r0.f24273w = bvVar3;
        r0.f24275y = c4934o;
        r0.f24265o = aiVar2;
        r0.f24264n = z;
    }

    /* renamed from: a */
    public final void mo4343a(rx rxVar) {
        this.f24259i = rxVar;
    }

    /* renamed from: a */
    public final void mo4344a(ry ryVar) {
        this.f24260j = ryVar;
    }

    /* renamed from: a */
    public final void mo4345a(rz rzVar) {
        this.f24263m = rzVar;
    }

    /* renamed from: a */
    public final void mo4346a(sa saVar) {
        this.f24276z = saVar;
    }

    /* renamed from: a */
    public final void m31022a(String str, ae<? super qo> aeVar) {
        synchronized (this.f24256f) {
            List list = (List) this.f24255e.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.f24255e.put(str, list);
            }
            list.add(aeVar);
        }
    }

    /* renamed from: a */
    public final void m31023a(String str, C2905p<ae<? super qo>> c2905p) {
        synchronized (this.f24256f) {
            List<ae> list = (List) this.f24255e.get(str);
            if (list == null) {
                return;
            }
            Collection arrayList = new ArrayList();
            for (ae aeVar : list) {
                if (c2905p.a(aeVar)) {
                    arrayList.add(aeVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    /* renamed from: a */
    public final void m31024a(boolean z) {
        this.f24264n = z;
    }

    /* renamed from: a */
    public final void m31025a(boolean z, int i) {
        aok aok = (!this.f24254d.mo6137z() || this.f24254d.mo6135t().m20093d()) ? this.f24257g : null;
        m31006a(new AdOverlayInfoParcel(aok, this.f24258h, this.f24271u, this.f24254d, z, i, this.f24254d.mo6133k()));
    }

    /* renamed from: a */
    public final void m31026a(boolean z, int i, String str) {
        boolean z2 = this.f24254d.mo6137z();
        aok aok = (!z2 || r0.f24254d.mo6135t().m20093d()) ? r0.f24257g : null;
        m31006a(new AdOverlayInfoParcel(aok, z2 ? null : new qu(r0.f24254d, r0.f24258h), r0.f24261k, r0.f24262l, r0.f24271u, r0.f24254d, z, i, str, r0.f24254d.mo6133k()));
    }

    /* renamed from: a */
    public final void m31027a(boolean z, int i, String str, String str2) {
        boolean z2 = this.f24254d.mo6137z();
        aok aok = (!z2 || r0.f24254d.mo6135t().m20093d()) ? r0.f24257g : null;
        m31006a(new AdOverlayInfoParcel(aok, z2 ? null : new qu(r0.f24254d, r0.f24258h), r0.f24261k, r0.f24262l, r0.f24271u, r0.f24254d, z, i, str, str2, r0.f24254d.mo6133k()));
    }

    /* renamed from: b */
    public final void m31028b(String str, ae<? super qo> aeVar) {
        synchronized (this.f24256f) {
            List list = (List) this.f24255e.get(str);
            if (list == null) {
                return;
            }
            list.remove(aeVar);
        }
    }

    /* renamed from: b */
    public final boolean mo4347b() {
        boolean z;
        synchronized (this.f24256f) {
            z = this.f24266p;
        }
        return z;
    }

    /* renamed from: c */
    public final boolean m31030c() {
        boolean z;
        synchronized (this.f24256f) {
            z = this.f24267q;
        }
        return z;
    }

    /* renamed from: d */
    public final OnGlobalLayoutListener m31031d() {
        OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.f24256f) {
            onGlobalLayoutListener = this.f24268r;
        }
        return onGlobalLayoutListener;
    }

    /* renamed from: e */
    public final OnScrollChangedListener m31032e() {
        OnScrollChangedListener onScrollChangedListener;
        synchronized (this.f24256f) {
            onScrollChangedListener = this.f24269s;
        }
        return onScrollChangedListener;
    }

    /* renamed from: f */
    public final boolean mo4348f() {
        boolean z;
        synchronized (this.f24256f) {
            z = this.f24270t;
        }
        return z;
    }

    /* renamed from: g */
    public final void mo4349g() {
        id idVar = this.f24253a;
        if (idVar != null) {
            View webView = this.f24254d.getWebView();
            if (C0517s.A(webView)) {
                m31005a(webView, idVar, 10);
                return;
            }
            m31009p();
            this.f24252D = new qt(this, idVar);
            this.f24254d.getView().addOnAttachStateChangeListener(this.f24252D);
        }
    }

    /* renamed from: h */
    public final void mo4350h() {
        synchronized (this.f24256f) {
            this.f24270t = true;
        }
        this.f24251C++;
        m31010q();
    }

    /* renamed from: i */
    public final void mo4351i() {
        this.f24251C--;
        m31010q();
    }

    /* renamed from: j */
    public final void mo4352j() {
        this.f24250B = true;
        m31010q();
    }

    /* renamed from: k */
    public final void m31038k() {
        if (this.f24253a != null) {
            this.f24253a.mo4295d();
            this.f24253a = null;
        }
        m31009p();
        synchronized (this.f24256f) {
            this.f24255e.clear();
            this.f24257g = null;
            this.f24258h = null;
            this.f24259i = null;
            this.f24260j = null;
            this.f24261k = null;
            this.f24262l = null;
            this.f24264n = false;
            this.f24266p = false;
            this.f24267q = false;
            this.f24270t = false;
            this.f24271u = null;
            this.f24263m = null;
            if (this.f24274x != null) {
                this.f24274x.m30692a(true);
                this.f24274x = null;
            }
        }
    }

    /* renamed from: l */
    public final sa m31039l() {
        return this.f24276z;
    }

    /* renamed from: m */
    public final id mo4353m() {
        return this.f24253a;
    }

    /* renamed from: n */
    public final void mo4354n() {
        synchronized (this.f24256f) {
            this.f24264n = false;
            this.f24266p = true;
            nu.f15846a.execute(new qq(this));
        }
    }

    /* renamed from: o */
    final /* synthetic */ void m31042o() {
        this.f24254d.mo6665F();
        C4740d r = this.f24254d.mo6709r();
        if (r != null) {
            r.m();
        }
        if (this.f24263m != null) {
            this.f24263m.m20084a();
            this.f24263m = null;
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        String str2 = "Loading resource: ";
        String valueOf = String.valueOf(str);
        jn.m30864a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m31004a(parse);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
        /*
        r0 = this;
        r1 = r0.f24256f;
        monitor-enter(r1);
        r2 = r0.f24254d;	 Catch:{ all -> 0x002b }
        r2 = r2.mo6660A();	 Catch:{ all -> 0x002b }
        if (r2 == 0) goto L_0x0017;
    L_0x000b:
        r2 = "Blank page loaded, 1...";
        com.google.android.gms.internal.ads.jn.m30864a(r2);	 Catch:{ all -> 0x002b }
        r2 = r0.f24254d;	 Catch:{ all -> 0x002b }
        r2.mo6661B();	 Catch:{ all -> 0x002b }
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        return;
    L_0x0017:
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        r1 = 1;
        r0.f24249A = r1;
        r1 = r0.f24260j;
        if (r1 == 0) goto L_0x0027;
    L_0x001f:
        r1 = r0.f24260j;
        r1.mo4091a();
        r1 = 0;
        r0.f24260j = r1;
    L_0x0027:
        r0.m31010q();
        return;
    L_0x002b:
        r2 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.qp.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String str3;
        if (i < 0) {
            int i2 = (-i) - 1;
            if (i2 < f24247b.length) {
                str3 = f24247b[i2];
                m31003a(this.f24254d.getContext(), "http_err", str3, str2);
                super.onReceivedError(webView, i, str, str2);
            }
        }
        str3 = String.valueOf(i);
        m31003a(this.f24254d.getContext(), "http_err", str3, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            String valueOf = (primaryError < 0 || primaryError >= f24248c.length) ? String.valueOf(primaryError) : f24248c[primaryError];
            m31003a(this.f24254d.getContext(), "ssl_err", valueOf, ax.g().mo6658a(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return m31011a(str, Collections.emptyMap());
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (!(keyCode == 79 || keyCode == 222)) {
            switch (keyCode) {
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                    break;
                default:
                    switch (keyCode) {
                        case 126:
                        case 127:
                        case 128:
                        case 129:
                        case 130:
                            break;
                        default:
                            return false;
                    }
            }
        }
        return true;
    }

    public final boolean shouldOverrideUrlLoading(android.webkit.WebView r12, java.lang.String r13) {
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
        r1 = java.lang.String.valueOf(r13);
        r2 = r1.length();
        if (r2 == 0) goto L_0x0011;
    L_0x000c:
        r0 = r0.concat(r1);
        goto L_0x0017;
    L_0x0011:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x0017:
        com.google.android.gms.internal.ads.jn.m30864a(r0);
        r0 = android.net.Uri.parse(r13);
        r1 = "gmsg";
        r2 = r0.getScheme();
        r1 = r1.equalsIgnoreCase(r2);
        r2 = 1;
        if (r1 == 0) goto L_0x003c;
    L_0x002b:
        r1 = "mobileads.google.com";
        r3 = r0.getHost();
        r1 = r1.equalsIgnoreCase(r3);
        if (r1 == 0) goto L_0x003c;
    L_0x0037:
        r11.m31004a(r0);
        goto L_0x011d;
    L_0x003c:
        r1 = r11.f24264n;
        if (r1 == 0) goto L_0x008e;
    L_0x0040:
        r1 = r11.f24254d;
        r1 = r1.getWebView();
        if (r12 != r1) goto L_0x008e;
    L_0x0048:
        r1 = r0.getScheme();
        r3 = "http";
        r3 = r3.equalsIgnoreCase(r1);
        if (r3 != 0) goto L_0x005f;
    L_0x0054:
        r3 = "https";
        r1 = r3.equalsIgnoreCase(r1);
        if (r1 == 0) goto L_0x005d;
    L_0x005c:
        goto L_0x005f;
    L_0x005d:
        r1 = 0;
        goto L_0x0060;
    L_0x005f:
        r1 = 1;
    L_0x0060:
        if (r1 == 0) goto L_0x008e;
    L_0x0062:
        r0 = r11.f24257g;
        if (r0 == 0) goto L_0x0089;
    L_0x0066:
        r0 = com.google.android.gms.internal.ads.asp.aj;
        r1 = com.google.android.gms.internal.ads.aph.m18688f();
        r0 = r1.m18889a(r0);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0089;
    L_0x0078:
        r0 = r11.f24257g;
        r0.onAdClicked();
        r0 = r11.f24253a;
        if (r0 == 0) goto L_0x0086;
    L_0x0081:
        r0 = r11.f24253a;
        r0.mo4290a(r13);
    L_0x0086:
        r0 = 0;
        r11.f24257g = r0;
    L_0x0089:
        r12 = super.shouldOverrideUrlLoading(r12, r13);
        return r12;
    L_0x008e:
        r12 = r11.f24254d;
        r12 = r12.getWebView();
        r12 = r12.willNotDraw();
        if (r12 != 0) goto L_0x0103;
    L_0x009a:
        r12 = r11.f24254d;	 Catch:{ ahj -> 0x00c0 }
        r12 = r12.mo6136y();	 Catch:{ ahj -> 0x00c0 }
        if (r12 == 0) goto L_0x00db;	 Catch:{ ahj -> 0x00c0 }
    L_0x00a2:
        r1 = r12.m18434a(r0);	 Catch:{ ahj -> 0x00c0 }
        if (r1 == 0) goto L_0x00db;	 Catch:{ ahj -> 0x00c0 }
    L_0x00a8:
        r1 = r11.f24254d;	 Catch:{ ahj -> 0x00c0 }
        r1 = r1.getContext();	 Catch:{ ahj -> 0x00c0 }
        r3 = r11.f24254d;	 Catch:{ ahj -> 0x00c0 }
        r3 = r3.getView();	 Catch:{ ahj -> 0x00c0 }
        r4 = r11.f24254d;	 Catch:{ ahj -> 0x00c0 }
        r4 = r4.mo6128d();	 Catch:{ ahj -> 0x00c0 }
        r12 = r12.m18431a(r0, r1, r3, r4);	 Catch:{ ahj -> 0x00c0 }
        r0 = r12;
        goto L_0x00db;
        r12 = "Unable to append parameter to URL: ";
        r1 = java.lang.String.valueOf(r13);
        r3 = r1.length();
        if (r3 == 0) goto L_0x00d2;
    L_0x00cd:
        r12 = r12.concat(r1);
        goto L_0x00d8;
    L_0x00d2:
        r1 = new java.lang.String;
        r1.<init>(r12);
        r12 = r1;
    L_0x00d8:
        com.google.android.gms.internal.ads.mt.m19924e(r12);
    L_0x00db:
        r12 = r11.f24273w;
        if (r12 == 0) goto L_0x00ee;
    L_0x00df:
        r12 = r11.f24273w;
        r12 = r12.b();
        if (r12 == 0) goto L_0x00e8;
    L_0x00e7:
        goto L_0x00ee;
    L_0x00e8:
        r12 = r11.f24273w;
        r12.a(r13);
        goto L_0x011d;
    L_0x00ee:
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
        r11.m31016a(r12);
        goto L_0x011d;
    L_0x0103:
        r12 = "AdWebView unable to handle URL: ";
        r13 = java.lang.String.valueOf(r13);
        r0 = r13.length();
        if (r0 == 0) goto L_0x0114;
    L_0x010f:
        r12 = r12.concat(r13);
        goto L_0x011a;
    L_0x0114:
        r13 = new java.lang.String;
        r13.<init>(r12);
        r12 = r13;
    L_0x011a:
        com.google.android.gms.internal.ads.mt.m19924e(r12);
    L_0x011d:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.qp.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }
}
