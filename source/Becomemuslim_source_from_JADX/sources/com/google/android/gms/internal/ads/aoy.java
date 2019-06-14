package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.FrameLayout;
import com.facebook.internal.NativeProtocol;

@cm
public class aoy {
    /* renamed from: a */
    private aqk f14799a;
    /* renamed from: b */
    private final Object f14800b = new Object();
    /* renamed from: c */
    private final aoo f14801c;
    /* renamed from: d */
    private final aon f14802d;
    /* renamed from: e */
    private final ark f14803e;
    /* renamed from: f */
    private final axd f14804f;
    /* renamed from: g */
    private final gr f14805g;
    /* renamed from: h */
    private final C6766q f14806h;
    /* renamed from: i */
    private final axe f14807i;

    /* renamed from: com.google.android.gms.internal.ads.aoy$a */
    abstract class C4921a<T> {
        /* renamed from: a */
        private final /* synthetic */ aoy f14798a;

        C4921a(aoy aoy) {
            this.f14798a = aoy;
        }

        /* renamed from: a */
        protected abstract T mo3854a();

        /* renamed from: a */
        protected abstract T mo3855a(aqk aqk);

        /* renamed from: b */
        protected final T m18666b() {
            aqk a = this.f14798a.m18674b();
            if (a == null) {
                mt.m19924e("ClientApi class cannot be loaded.");
                return null;
            }
            try {
                return mo3855a(a);
            } catch (Throwable e) {
                mt.m19921c("Cannot invoke local loader using ClientApi class", e);
                return null;
            }
        }

        /* renamed from: c */
        protected final T m18667c() {
            try {
                return mo3854a();
            } catch (Throwable e) {
                mt.m19921c("Cannot invoke remote loader", e);
                return null;
            }
        }
    }

    public aoy(aoo aoo, aon aon, ark ark, axd axd, gr grVar, C6766q c6766q, axe axe) {
        this.f14801c = aoo;
        this.f14802d = aon;
        this.f14803e = ark;
        this.f14804f = axd;
        this.f14805g = grVar;
        this.f14806h = c6766q;
        this.f14807i = axe;
    }

    /* renamed from: a */
    private static aqk m18668a() {
        try {
            Object newInstance = aoy.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                return aql.asInterface((IBinder) newInstance);
            }
            mt.m19924e("ClientApi class is not an instance of IBinder");
            return null;
        } catch (Throwable e) {
            mt.m19921c("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    /* renamed from: a */
    static <T> T m18670a(Context context, boolean z, C4921a<T> c4921a) {
        if (!z) {
            aph.m18683a();
            if (!mi.m19880c(context)) {
                mt.m19918b("Google Play Services is not available");
                z = true;
            }
        }
        aph.m18683a();
        int e = mi.m19882e(context);
        aph.m18683a();
        if (e > mi.m19881d(context)) {
            z = true;
        }
        asp.m18892a(context);
        if (((Boolean) aph.m18688f().m18889a(asp.de)).booleanValue()) {
            z = false;
        }
        T b;
        if (z) {
            b = c4921a.m18666b();
            return b == null ? c4921a.m18667c() : b;
        } else {
            b = c4921a.m18667c();
            return b == null ? c4921a.m18666b() : b;
        }
    }

    /* renamed from: a */
    private static void m18671a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "no_ads_fallback");
        bundle.putString("flow", str);
        aph.m18683a().m19887a(context, null, "gmob-apps", bundle, true);
    }

    /* renamed from: b */
    private final aqk m18674b() {
        aqk aqk;
        synchronized (this.f14800b) {
            if (this.f14799a == null) {
                this.f14799a = m18668a();
            }
            aqk = this.f14799a;
        }
        return aqk;
    }

    /* renamed from: a */
    public final apt m18679a(Context context, String str, bcy bcy) {
        return (apt) m18670a(context, false, new apc(this, context, str, bcy));
    }

    /* renamed from: a */
    public final avi m18680a(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (avi) m18670a(context, false, new apd(this, frameLayout, frameLayout2, context));
    }

    /* renamed from: a */
    public final C4936r m18681a(Activity activity) {
        String str = "com.google.android.gms.ads.internal.overlay.useClientJar";
        Intent intent = activity.getIntent();
        boolean z = false;
        if (intent.hasExtra(str)) {
            z = intent.getBooleanExtra(str, false);
        } else {
            mt.m19920c("useClientJar flag not found in activity intent extras.");
        }
        return (C4936r) m18670a((Context) activity, z, new apg(this, activity));
    }
}
