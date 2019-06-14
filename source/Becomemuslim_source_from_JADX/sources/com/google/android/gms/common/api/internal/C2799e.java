package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.C2875k.C2874a;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ac;
import com.google.android.gms.common.internal.be;

@Deprecated
/* renamed from: com.google.android.gms.common.api.internal.e */
public final class C2799e {
    /* renamed from: a */
    private static final Object f7195a = new Object();
    /* renamed from: b */
    private static C2799e f7196b;
    /* renamed from: c */
    private final String f7197c;
    /* renamed from: d */
    private final Status f7198d;
    /* renamed from: e */
    private final boolean f7199e;
    /* renamed from: f */
    private final boolean f7200f;

    C2799e(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C2874a.common_google_play_services_unknown_issue));
        boolean z = true;
        if (identifier != 0) {
            if (resources.getInteger(identifier) == 0) {
                z = false;
            }
            this.f7200f = z ^ 1;
        } else {
            this.f7200f = false;
        }
        this.f7199e = z;
        Object a = be.m8240a(context);
        if (a == null) {
            a = new ac(context).m8216a("google_app_id");
        }
        if (TextUtils.isEmpty(a) != null) {
            this.f7198d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f7197c = null;
            return;
        }
        this.f7197c = a;
        this.f7198d = Status.f13151a;
    }

    /* renamed from: a */
    public static Status m8067a(Context context) {
        C2872v.m8381a((Object) context, (Object) "Context must not be null.");
        synchronized (f7195a) {
            if (f7196b == null) {
                f7196b = new C2799e(context);
            }
            context = f7196b.f7198d;
        }
        return context;
    }

    /* renamed from: a */
    public static String m8069a() {
        return C2799e.m8068a("getGoogleAppId").f7197c;
    }

    /* renamed from: b */
    public static boolean m8070b() {
        return C2799e.m8068a("isMeasurementExplicitlyDisabled").f7200f;
    }

    /* renamed from: a */
    private static C2799e m8068a(String str) {
        synchronized (f7195a) {
            if (f7196b != null) {
                str = f7196b;
            } else {
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 34);
                stringBuilder.append("Initialize must be called before ");
                stringBuilder.append(str);
                stringBuilder.append(".");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        return str;
    }
}
