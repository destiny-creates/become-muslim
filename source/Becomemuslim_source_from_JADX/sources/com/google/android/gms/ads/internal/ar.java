package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.ads.C4939y;
import com.google.android.gms.internal.ads.af;
import com.google.android.gms.internal.ads.ahi;
import com.google.android.gms.internal.ads.aoq;
import com.google.android.gms.internal.ads.aou;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.apk;
import com.google.android.gms.internal.ads.apn;
import com.google.android.gms.internal.ads.apz;
import com.google.android.gms.internal.ads.aqd;
import com.google.android.gms.internal.ads.aqh;
import com.google.android.gms.internal.ads.aqn;
import com.google.android.gms.internal.ads.aqv;
import com.google.android.gms.internal.ads.arb;
import com.google.android.gms.internal.ads.ary;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.atj;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.gn;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.ju;
import com.google.android.gms.internal.ads.mv;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.Map;
import java.util.concurrent.Future;

@cm
public final class ar extends apz {
    /* renamed from: a */
    private final mv f12977a;
    /* renamed from: b */
    private final aou f12978b;
    /* renamed from: c */
    private final Future<ahi> f12979c = ju.a(new au(this));
    /* renamed from: d */
    private final Context f12980d;
    /* renamed from: e */
    private final aw f12981e;
    /* renamed from: f */
    private WebView f12982f = new WebView(this.f12980d);
    /* renamed from: g */
    private apn f12983g;
    /* renamed from: h */
    private ahi f12984h;
    /* renamed from: i */
    private AsyncTask<Void, Void, String> f12985i;

    public ar(Context context, aou aou, String str, mv mvVar) {
        this.f12980d = context;
        this.f12977a = mvVar;
        this.f12978b = aou;
        this.f12981e = new aw(str);
        m16496a(0);
        this.f12982f.setVerticalScrollBarEnabled(false);
        this.f12982f.getSettings().setJavaScriptEnabled(true);
        this.f12982f.setWebViewClient(new as(this));
        this.f12982f.setOnTouchListener(new at(this));
    }

    /* renamed from: c */
    private final String m16486c(String str) {
        if (this.f12984h == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.f12984h.a(parse, this.f12980d, null, null);
        } catch (Throwable e) {
            jn.c("Unable to process ad data", e);
        }
        return parse.toString();
    }

    /* renamed from: d */
    private final void m16488d(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.f12980d.startActivity(intent);
    }

    /* renamed from: C */
    public final String m16491C() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    /* renamed from: D */
    public final aqh m16492D() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    /* renamed from: E */
    public final apn m16493E() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    /* renamed from: H */
    public final void m16494H() {
        throw new IllegalStateException("Unused method");
    }

    /* renamed from: a */
    public final String m16495a() {
        return null;
    }

    /* renamed from: a */
    final void m16496a(int i) {
        if (this.f12982f != null) {
            this.f12982f.setLayoutParams(new LayoutParams(-1, i));
        }
    }

    /* renamed from: a */
    public final void m16497a(af afVar, String str) {
        throw new IllegalStateException("Unused method");
    }

    /* renamed from: a */
    public final void m16498a(aou aou) {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    /* renamed from: a */
    public final void m16499a(apk apk) {
        throw new IllegalStateException("Unused method");
    }

    /* renamed from: a */
    public final void m16500a(apn apn) {
        this.f12983g = apn;
    }

    /* renamed from: a */
    public final void m16501a(aqd aqd) {
        throw new IllegalStateException("Unused method");
    }

    /* renamed from: a */
    public final void m16502a(aqh aqh) {
        throw new IllegalStateException("Unused method");
    }

    /* renamed from: a */
    public final void m16503a(aqn aqn) {
        throw new IllegalStateException("Unused method");
    }

    /* renamed from: a */
    public final void m16504a(arb arb) {
        throw new IllegalStateException("Unused method");
    }

    /* renamed from: a */
    public final void m16505a(ary ary) {
        throw new IllegalStateException("Unused method");
    }

    /* renamed from: a */
    public final void m16506a(atj atj) {
        throw new IllegalStateException("Unused method");
    }

    /* renamed from: a */
    public final void m16507a(gn gnVar) {
        throw new IllegalStateException("Unused method");
    }

    /* renamed from: a */
    public final void m16508a(C4939y c4939y) {
        throw new IllegalStateException("Unused method");
    }

    /* renamed from: a */
    public final void m16509a(String str) {
        throw new IllegalStateException("Unused method");
    }

    /* renamed from: b */
    final int m16510b(java.lang.String r3) {
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
        r3 = android.net.Uri.parse(r3);
        r0 = "height";
        r3 = r3.getQueryParameter(r0);
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        com.google.android.gms.internal.ads.aph.a();	 Catch:{ NumberFormatException -> 0x0020 }
        r0 = r2.f12980d;	 Catch:{ NumberFormatException -> 0x0020 }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x0020 }
        r3 = com.google.android.gms.internal.ads.mi.a(r0, r3);	 Catch:{ NumberFormatException -> 0x0020 }
        return r3;
    L_0x0020:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.ar.b(java.lang.String):int");
    }

    /* renamed from: b */
    public final void m16511b(boolean z) {
    }

    /* renamed from: b */
    public final boolean m16512b(aoq aoq) {
        C2872v.m8381a(this.f12982f, (Object) "This Search Ad has already been torn down");
        this.f12981e.m7450a(aoq, this.f12977a);
        this.f12985i = new av().execute(new Void[0]);
        return true;
    }

    /* renamed from: c */
    final String m16513c() {
        Builder builder = new Builder();
        builder.scheme("https://").appendEncodedPath((String) aph.f().a(asp.cx));
        builder.appendQueryParameter("query", this.f12981e.m7451b());
        builder.appendQueryParameter("pubId", this.f12981e.m7452c());
        Map d = this.f12981e.m7453d();
        for (String str : d.keySet()) {
            builder.appendQueryParameter(str, (String) d.get(str));
        }
        Uri build = builder.build();
        if (this.f12984h != null) {
            try {
                build = this.f12984h.a(build, this.f12980d);
            } catch (Throwable e) {
                jn.c("Unable to process ad data", e);
            }
        }
        String d2 = m16515d();
        String encodedQuery = build.getEncodedQuery();
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(d2).length() + 1) + String.valueOf(encodedQuery).length());
        stringBuilder.append(d2);
        stringBuilder.append("#");
        stringBuilder.append(encodedQuery);
        return stringBuilder.toString();
    }

    /* renamed from: c */
    public final void m16514c(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    /* renamed from: d */
    final String m16515d() {
        String a = this.f12981e.m7449a();
        if (TextUtils.isEmpty(a)) {
            a = "www.google.com";
        }
        String str = (String) aph.f().a(asp.cx);
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(a).length() + 8) + String.valueOf(str).length());
        stringBuilder.append("https://");
        stringBuilder.append(a);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    /* renamed from: i */
    public final void m16516i() {
        C2872v.m8389b("destroy must be called on the main UI thread.");
        this.f12985i.cancel(true);
        this.f12979c.cancel(true);
        this.f12982f.destroy();
        this.f12982f = null;
    }

    /* renamed from: j */
    public final C2758b m16517j() {
        C2872v.m8389b("getAdFrame must be called on the main UI thread.");
        return C4757d.m16684a(this.f12982f);
    }

    /* renamed from: k */
    public final aou m16518k() {
        return this.f12978b;
    }

    /* renamed from: l */
    public final boolean m16519l() {
        return false;
    }

    /* renamed from: m */
    public final void m16520m() {
        throw new IllegalStateException("Unused method");
    }

    /* renamed from: n */
    public final void m16521n() {
        C2872v.m8389b("pause must be called on the main UI thread.");
    }

    /* renamed from: o */
    public final void m16522o() {
        C2872v.m8389b("resume must be called on the main UI thread.");
    }

    /* renamed from: p */
    public final Bundle m16523p() {
        throw new IllegalStateException("Unused method");
    }

    /* renamed from: q */
    public final void m16524q() {
    }

    /* renamed from: r */
    public final boolean m16525r() {
        return false;
    }

    /* renamed from: s */
    public final aqv m16526s() {
        return null;
    }

    public final String w_() {
        return null;
    }
}
