package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.ax;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

@cm
public final class asr {
    /* renamed from: a */
    private String f14964a;
    /* renamed from: b */
    private Map<String, String> f14965b;
    /* renamed from: c */
    private Context f14966c = null;
    /* renamed from: d */
    private String f14967d = null;

    public asr(Context context, String str) {
        this.f14966c = context;
        this.f14967d = str;
        this.f14964a = (String) aph.m18688f().m18889a(asp.f14924O);
        this.f14965b = new LinkedHashMap();
        this.f14965b.put("s", "gmob_sdk");
        this.f14965b.put("v", "3");
        this.f14965b.put("os", VERSION.RELEASE);
        this.f14965b.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, VERSION.SDK);
        ax.e();
        this.f14965b.put("device", jw.m19713b());
        this.f14965b.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        Map map = this.f14965b;
        String str2 = "is_lite_sdk";
        ax.e();
        map.put(str2, jw.m19733k(context) ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Future a = ax.p().m19437a(this.f14966c);
        try {
            a.get();
            this.f14965b.put("network_coarse", Integer.toString(((fi) a.get()).f15452n));
            this.f14965b.put("network_fine", Integer.toString(((fi) a.get()).f15453o));
        } catch (Throwable e) {
            ax.i().m30834a(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* renamed from: a */
    final String m18895a() {
        return this.f14964a;
    }

    /* renamed from: b */
    final Context m18896b() {
        return this.f14966c;
    }

    /* renamed from: c */
    final String m18897c() {
        return this.f14967d;
    }

    /* renamed from: d */
    final Map<String, String> m18898d() {
        return this.f14965b;
    }
}
