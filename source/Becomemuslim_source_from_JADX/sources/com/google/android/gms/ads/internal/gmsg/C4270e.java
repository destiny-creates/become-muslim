package com.google.android.gms.ads.internal.gmsg;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.ads.internal.p088c.C1354a;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.bv;
import com.google.android.gms.ads.internal.overlay.C2665n;
import com.google.android.gms.ads.internal.overlay.C2668t;
import com.google.android.gms.ads.internal.overlay.C4739c;
import com.google.android.gms.internal.ads.C6763d;
import com.google.android.gms.internal.ads.ahi;
import com.google.android.gms.internal.ads.aok;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.im;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.mv;
import com.google.android.gms.internal.ads.qo;
import com.google.android.gms.internal.ads.rk;
import com.google.android.gms.internal.ads.rl;
import com.google.android.gms.internal.ads.rp;
import com.google.android.gms.internal.ads.rs;
import com.google.android.gms.internal.ads.rv;
import com.raizlabs.android.dbflow.config.C5679e;
import host.exp.exponent.p339f.C6352l;
import java.util.Map;

@cm
/* renamed from: com.google.android.gms.ads.internal.gmsg.e */
public final class C4270e<T extends rk & rl & rp & rs & rv> implements ae<T> {
    /* renamed from: a */
    private final Context f11289a;
    /* renamed from: b */
    private final ahi f11290b;
    /* renamed from: c */
    private final mv f11291c;
    /* renamed from: d */
    private final C2668t f11292d;
    /* renamed from: e */
    private final aok f11293e;
    /* renamed from: f */
    private final C2665n f11294f;
    /* renamed from: g */
    private final C2651k f11295g;
    /* renamed from: h */
    private final C2652m f11296h;
    /* renamed from: i */
    private final bv f11297i;
    /* renamed from: j */
    private final C6763d f11298j;
    /* renamed from: k */
    private final qo f11299k = null;

    public C4270e(Context context, mv mvVar, ahi ahi, C2668t c2668t, aok aok, C2651k c2651k, C2652m c2652m, C2665n c2665n, bv bvVar, C6763d c6763d) {
        this.f11289a = context;
        this.f11291c = mvVar;
        this.f11290b = ahi;
        this.f11292d = c2668t;
        this.f11293e = aok;
        this.f11295g = c2651k;
        this.f11296h = c2652m;
        this.f11297i = bvVar;
        this.f11298j = c6763d;
        this.f11294f = c2665n;
    }

    /* renamed from: a */
    static java.lang.String m13904a(android.content.Context r2, com.google.android.gms.internal.ads.ahi r3, java.lang.String r4, android.view.View r5, android.app.Activity r6) {
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
        if (r3 != 0) goto L_0x0003;
    L_0x0002:
        return r4;
    L_0x0003:
        r0 = android.net.Uri.parse(r4);	 Catch:{ ahj -> 0x0020, Exception -> 0x0016 }
        r1 = r3.b(r0);	 Catch:{ ahj -> 0x0020, Exception -> 0x0016 }
        if (r1 == 0) goto L_0x0011;	 Catch:{ ahj -> 0x0020, Exception -> 0x0016 }
    L_0x000d:
        r0 = r3.a(r0, r2, r5, r6);	 Catch:{ ahj -> 0x0020, Exception -> 0x0016 }
    L_0x0011:
        r2 = r0.toString();	 Catch:{ ahj -> 0x0020, Exception -> 0x0016 }
        return r2;
    L_0x0016:
        r2 = move-exception;
        r3 = com.google.android.gms.ads.internal.ax.m7468i();
        r5 = "OpenGmsgHandler.maybeAddClickSignalsToUrl";
        r3.a(r2, r5);
    L_0x0020:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.e.a(android.content.Context, com.google.android.gms.internal.ads.ahi, java.lang.String, android.view.View, android.app.Activity):java.lang.String");
    }

    /* renamed from: a */
    private final void m13905a(boolean z) {
        if (this.f11298j != null) {
            this.f11298j.a(z);
        }
    }

    /* renamed from: a */
    private static boolean m13906a(Map<String, String> map) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("custom_close"));
    }

    /* renamed from: b */
    private static int m13907b(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return ax.m7466g().b();
            }
            if (C6352l.f20613a.equalsIgnoreCase(str)) {
                return ax.m7466g().a();
            }
            if ("c".equalsIgnoreCase(str)) {
                return ax.m7466g().c();
            }
        }
        return -1;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        rk rkVar = (rk) obj;
        String a = im.a((String) map.get("u"), rkVar.getContext());
        String str = (String) map.get(C1354a.f3934a);
        if (str == null) {
            jn.e("Action missing from an open GMSG.");
        } else if (this.f11297i != null && !this.f11297i.m7508b()) {
            this.f11297i.m7507a(a);
        } else if ("expand".equalsIgnoreCase(str)) {
            if (((rl) rkVar).z()) {
                jn.e("Cannot expand WebView that is already expanded.");
                return;
            }
            m13905a(false);
            ((rp) rkVar).a(C4270e.m13906a(map), C4270e.m13907b(map));
        } else if ("webapp".equalsIgnoreCase(str)) {
            m13905a(false);
            if (a != null) {
                ((rp) rkVar).a(C4270e.m13906a(map), C4270e.m13907b(map), a);
            } else {
                ((rp) rkVar).a(C4270e.m13906a(map), C4270e.m13907b(map), (String) map.get("html"), (String) map.get("baseurl"));
            }
        } else if ("app".equalsIgnoreCase(str) && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase((String) map.get("system_browser"))) {
            m13905a(true);
            rkVar.getContext();
            if (TextUtils.isEmpty(a)) {
                jn.e("Destination url cannot be empty.");
                return;
            }
            try {
                ((rp) rkVar).a(new C4739c(new C2648f(rkVar.getContext(), ((rs) rkVar).y(), ((rv) rkVar).getView()).m7530a(map)));
            } catch (ActivityNotFoundException e) {
                jn.e(e.getMessage());
            }
        } else {
            m13905a(true);
            str = (String) map.get("intent_url");
            Intent intent = null;
            if (!TextUtils.isEmpty(str)) {
                try {
                    intent = Intent.parseUri(str, 0);
                } catch (Throwable e2) {
                    String str2 = "Error parsing the url: ";
                    str = String.valueOf(str);
                    jn.b(str.length() != 0 ? str2.concat(str) : new String(str2), e2);
                }
            }
            if (!(intent == null || intent.getData() == null)) {
                Uri data = intent.getData();
                String uri = data.toString();
                if (!TextUtils.isEmpty(uri)) {
                    try {
                        uri = C4270e.m13904a(rkVar.getContext(), ((rs) rkVar).y(), uri, ((rv) rkVar).getView(), rkVar.d());
                    } catch (Throwable e3) {
                        jn.b("Error occurred while adding signals.", e3);
                        ax.m7468i().a(e3, "OpenGmsgHandler.onGmsg");
                    }
                    try {
                        data = Uri.parse(uri);
                    } catch (Throwable e32) {
                        String str3 = "Error parsing the uri: ";
                        uri = String.valueOf(uri);
                        jn.b(uri.length() != 0 ? str3.concat(uri) : new String(str3), e32);
                        ax.m7468i().a(e32, "OpenGmsgHandler.onGmsg");
                    }
                }
                intent.setData(data);
            }
            if (intent != null) {
                ((rp) rkVar).a(new C4739c(intent));
                return;
            }
            if (!TextUtils.isEmpty(a)) {
                a = C4270e.m13904a(rkVar.getContext(), ((rs) rkVar).y(), a, ((rv) rkVar).getView(), rkVar.d());
            }
            ((rp) rkVar).a(new C4739c((String) map.get("i"), a, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get(C5679e.f18978a)));
        }
    }
}
