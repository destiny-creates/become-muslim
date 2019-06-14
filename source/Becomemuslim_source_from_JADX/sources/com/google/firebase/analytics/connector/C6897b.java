package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.internal.C5329b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.firebase.analytics.connector.b */
public class C6897b implements C5328a {
    /* renamed from: c */
    private static volatile C5328a f24714c;
    /* renamed from: a */
    final Map<String, Object> f24715a = new ConcurrentHashMap();
    /* renamed from: b */
    private final AppMeasurement f24716b;

    private C6897b(AppMeasurement appMeasurement) {
        C2872v.a(appMeasurement);
        this.f24716b = appMeasurement;
    }

    /* renamed from: a */
    public static C5328a m32355a(Context context) {
        C2872v.a(context);
        C2872v.a(context.getApplicationContext());
        if (f24714c == null) {
            synchronized (C5328a.class) {
                if (f24714c == null) {
                    f24714c = new C6897b(AppMeasurement.getInstance(context));
                }
            }
        }
        return f24714c;
    }

    /* renamed from: a */
    public void mo4874a(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (C5329b.m22591a(str) && C5329b.m22592a(str2, bundle) && C5329b.m22594a(str, str2, bundle)) {
            this.f24716b.logEventInternal(str, str2, bundle);
        }
    }

    /* renamed from: a */
    public void mo4875a(String str, String str2, Object obj) {
        if (C5329b.m22591a(str) && C5329b.m22593a(str, str2)) {
            this.f24716b.setUserPropertyInternal(str, str2, obj);
        }
    }
}
