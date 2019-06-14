package com.p073d.p074a;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings.Secure;
import android.util.Pair;
import com.p073d.p074a.C3466b.C3465a;
import com.p073d.p074a.p075a.C1132f;
import java.util.concurrent.CountDownLatch;

/* compiled from: GetAdvertisingIdTask */
/* renamed from: com.d.a.h */
class C1149h extends AsyncTask<Context, Void, Pair<String, Boolean>> {
    /* renamed from: a */
    private final C3466b f3253a;
    /* renamed from: b */
    private final CountDownLatch f3254b;
    /* renamed from: c */
    private final C1132f f3255c;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m4064a((Context[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m4065a((Pair) obj);
    }

    C1149h(C3466b c3466b, CountDownLatch countDownLatch, C1132f c1132f) {
        this.f3253a = c3466b;
        this.f3254b = countDownLatch;
        this.f3255c = c1132f;
    }

    /* renamed from: a */
    private Pair<String, Boolean> m4062a(Context context) {
        Object invoke = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{context});
        if (!((Boolean) invoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, new Object[0])).booleanValue()) {
            return Pair.create((String) invoke.getClass().getMethod("getId", new Class[0]).invoke(invoke, new Object[0]), Boolean.valueOf(true));
        }
        this.f3255c.m3973c("Not collecting advertising ID because isLimitAdTrackingEnabled (Google Play Services) is true.", new Object[0]);
        return Pair.create(null, Boolean.valueOf(false));
    }

    /* renamed from: b */
    private Pair<String, Boolean> m4063b(Context context) {
        context = context.getContentResolver();
        if ((Secure.getInt(context, "limit_ad_tracking") != 0 ? 1 : null) == null) {
            return Pair.create(Secure.getString(context, "advertising_id"), Boolean.valueOf(true));
        }
        this.f3255c.m3973c("Not collecting advertising ID because limit_ad_tracking (Amazon Fire OS) is true.", new Object[0]);
        return Pair.create(null, Boolean.valueOf(false));
    }

    /* renamed from: a */
    protected Pair<String, Boolean> m4064a(Context... contextArr) {
        Context context = contextArr[0];
        try {
            return m4062a(context);
        } catch (Throwable e) {
            this.f3255c.m3971a(e, "Unable to collect advertising ID from Google Play Services.", new Object[0]);
            try {
                return m4063b(context);
            } catch (Context[] contextArr2) {
                this.f3255c.m3971a(contextArr2, "Unable to collect advertising ID from Amazon Fire OS.", new Object[0]);
                this.f3255c.m3973c("Unable to collect advertising ID from Amazon Fire OS and Google Play Services.", new Object[0]);
                return null;
            }
        }
    }

    /* renamed from: a */
    protected void m4065a(Pair<String, Boolean> pair) {
        super.onPostExecute(pair);
        if (pair == null) {
            this.f3254b.countDown();
            return;
        }
        try {
            C3465a c = this.f3253a.m11159c();
            if (c == null) {
                this.f3255c.m3973c("Not collecting advertising ID because context.device is null.", new Object[0]);
                return;
            }
            c.m11146a((String) pair.first, ((Boolean) pair.second).booleanValue());
            this.f3254b.countDown();
        } finally {
            this.f3254b.countDown();
        }
    }
}
