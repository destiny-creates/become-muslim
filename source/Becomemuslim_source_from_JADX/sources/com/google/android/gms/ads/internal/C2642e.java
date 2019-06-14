package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.bbp;
import com.google.android.gms.internal.ads.bbu;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.iw;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.mv;
import com.google.android.gms.internal.ads.nb;
import com.google.android.gms.internal.ads.nd;
import com.google.android.gms.internal.ads.no;
import com.google.android.gms.internal.ads.nu;
import org.json.JSONObject;

@cm
/* renamed from: com.google.android.gms.ads.internal.e */
public final class C2642e {
    /* renamed from: a */
    private final Object f6853a = new Object();
    /* renamed from: b */
    private Context f6854b;
    /* renamed from: c */
    private long f6855c = 0;

    /* renamed from: a */
    public final void m7509a(Context context, mv mvVar, String str, Runnable runnable) {
        m7510a(context, mvVar, true, null, str, null, runnable);
    }

    /* renamed from: a */
    final void m7510a(Context context, mv mvVar, boolean z, iw iwVar, String str, String str2, Runnable runnable) {
        if (ax.m7471l().mo2483b() - this.f6855c < 5000) {
            jn.e("Not retrying to fetch app settings");
            return;
        }
        this.f6855c = ax.m7471l().mo2483b();
        Object obj = 1;
        if (iwVar != null) {
            if ((ax.m7471l().mo2482a() - iwVar.a() > ((Long) aph.f().a(asp.ct)).longValue() ? 1 : null) == null) {
                if (iwVar.b()) {
                    obj = null;
                }
            }
        }
        if (obj != null) {
            if (context == null) {
                jn.e("Context not provided to fetch application settings");
            } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                jn.e("App settings could not be fetched. Required parameters missing");
            } else {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                this.f6854b = applicationContext;
                bbp a = ax.m7478s().a(this.f6854b, mvVar).a("google.afma.config.fetchAppSettings", bbu.f15167a, bbu.f15167a);
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("app_id", str);
                    } else if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("ad_unit_id", str2);
                    }
                    jSONObject.put("is_init", z);
                    jSONObject.put("pn", context.getPackageName());
                    no b = a.b(jSONObject);
                    no a2 = nd.a(b, C4265f.f11280a, nu.f15847b);
                    if (runnable != null) {
                        b.a(runnable, nu.f15847b);
                    }
                    nb.a(a2, "ConfigLoader.maybeFetchNewAppSettings");
                } catch (Throwable e) {
                    jn.b("Error requesting application settings", e);
                }
            }
        }
    }
}
