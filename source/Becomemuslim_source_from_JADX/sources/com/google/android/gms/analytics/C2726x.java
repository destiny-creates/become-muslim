package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p210i.C5007p;
import com.google.android.gms.internal.p210i.C5011t;
import com.google.android.gms.internal.p210i.C7812e;
import com.google.android.gms.internal.p210i.bg;
import com.google.android.gms.internal.p210i.bz;
import com.google.android.gms.internal.p210i.eg;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.x */
final class C2726x implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ Map f6992a;
    /* renamed from: b */
    private final /* synthetic */ boolean f6993b;
    /* renamed from: c */
    private final /* synthetic */ String f6994c;
    /* renamed from: d */
    private final /* synthetic */ long f6995d;
    /* renamed from: e */
    private final /* synthetic */ boolean f6996e;
    /* renamed from: f */
    private final /* synthetic */ boolean f6997f;
    /* renamed from: g */
    private final /* synthetic */ String f6998g;
    /* renamed from: h */
    private final /* synthetic */ C4748h f6999h;

    C2726x(C4748h c4748h, Map map, boolean z, String str, long j, boolean z2, boolean z3, String str2) {
        this.f6999h = c4748h;
        this.f6992a = map;
        this.f6993b = z;
        this.f6994c = str;
        this.f6995d = j;
        this.f6996e = z2;
        this.f6997f = z3;
        this.f6998g = str2;
    }

    public final void run() {
        Object obj;
        long b;
        long j;
        if (this.f6999h.f13105e.m16623b()) {
            r0.f6992a.put("sc", ViewProps.START);
        }
        C4308i o = r0.f6999h.o();
        C2872v.m8393c("getClientId can not be called from the main thread");
        bz.b(r0.f6992a, "cid", o.m13988g().o().b());
        String str = (String) r0.f6992a.get("sf");
        if (str != null) {
            double a = bz.a(str, 100.0d);
            if (bz.a(a, (String) r0.f6992a.get("cid"))) {
                r0.f6999h.b("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(a));
                return;
            }
        }
        C7812e b2 = r0.f6999h.u();
        if (r0.f6993b) {
            bz.a(r0.f6992a, "ate", b2.b());
            bz.a(r0.f6992a, "adid", b2.c());
        } else {
            r0.f6992a.remove("ate");
            r0.f6992a.remove("adid");
        }
        eg b3 = r0.f6999h.v().b();
        bz.a(r0.f6992a, "an", b3.a());
        bz.a(r0.f6992a, "av", b3.b());
        bz.a(r0.f6992a, "aid", b3.c());
        bz.a(r0.f6992a, "aiid", b3.d());
        r0.f6992a.put("v", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        r0.f6992a.put("_v", C5007p.f16814b);
        bz.a(r0.f6992a, "ul", r0.f6999h.w().b().a());
        bz.a(r0.f6992a, "sr", r0.f6999h.w().c());
        if (!r0.f6994c.equals("transaction")) {
            if (!r0.f6994c.equals("item")) {
                obj = null;
                if (obj == null || r0.f6999h.f13104d.a()) {
                    b = bz.b((String) r0.f6992a.get("ht"));
                    if (b == 0) {
                        b = r0.f6995d;
                    }
                    j = b;
                    if (r0.f6996e) {
                        String str2 = (String) r0.f6992a.get("cid");
                        Map hashMap = new HashMap();
                        bz.a(hashMap, "uid", r0.f6992a);
                        bz.a(hashMap, "an", r0.f6992a);
                        bz.a(hashMap, "aid", r0.f6992a);
                        bz.a(hashMap, "av", r0.f6992a);
                        bz.a(hashMap, "aiid", r0.f6992a);
                        r0.f6992a.put("_s", String.valueOf(r0.f6999h.p().a(new C5011t(0, str2, r0.f6998g, TextUtils.isEmpty((CharSequence) r0.f6992a.get("adid")) ^ 1, 0, hashMap))));
                        r0.f6999h.p().a(new bg(r0.f6999h, r0.f6992a, j, r0.f6997f));
                        return;
                    }
                    r0.f6999h.l().c("Dry run enabled. Would have sent hit", new bg(r0.f6999h, r0.f6992a, j, r0.f6997f));
                }
                r0.f6999h.l().a(r0.f6992a, "Too many hits sent too quickly, rate limiting invoked");
                return;
            }
        }
        obj = 1;
        if (obj == null) {
        }
        b = bz.b((String) r0.f6992a.get("ht"));
        if (b == 0) {
            b = r0.f6995d;
        }
        j = b;
        if (r0.f6996e) {
            String str22 = (String) r0.f6992a.get("cid");
            Map hashMap2 = new HashMap();
            bz.a(hashMap2, "uid", r0.f6992a);
            bz.a(hashMap2, "an", r0.f6992a);
            bz.a(hashMap2, "aid", r0.f6992a);
            bz.a(hashMap2, "av", r0.f6992a);
            bz.a(hashMap2, "aiid", r0.f6992a);
            r0.f6992a.put("_s", String.valueOf(r0.f6999h.p().a(new C5011t(0, str22, r0.f6998g, TextUtils.isEmpty((CharSequence) r0.f6992a.get("adid")) ^ 1, 0, hashMap2))));
            r0.f6999h.p().a(new bg(r0.f6999h, r0.f6992a, j, r0.f6997f));
            return;
        }
        r0.f6999h.l().c("Dry run enabled. Would have sent hit", new bg(r0.f6999h, r0.f6992a, j, r0.f6997f));
    }
}
