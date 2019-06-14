package com.facebook.ads.internal.p089d;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.internal.p101p.p103b.C1471f;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* renamed from: com.facebook.ads.internal.d.d */
public class C1367d {
    /* renamed from: a */
    private static final String f3968a = "d";
    /* renamed from: b */
    private static C1367d f3969b;
    /* renamed from: c */
    private final Future<C1471f> f3970c;

    private C1367d(final Context context) {
        this.f3970c = Executors.newSingleThreadExecutor().submit(new Callable<C1471f>(this) {
            /* renamed from: b */
            final /* synthetic */ C1367d f3967b;

            /* renamed from: a */
            public C1471f m4670a() {
                return new C1471f(context);
            }

            public /* synthetic */ Object call() {
                return m4670a();
            }
        });
    }

    /* renamed from: a */
    public static C1367d m4671a(Context context) {
        if (f3969b == null) {
            context = context.getApplicationContext();
            synchronized (C1367d.class) {
                if (f3969b == null) {
                    f3969b = new C1367d(context);
                }
            }
        }
        return f3969b;
    }

    /* renamed from: a */
    private C1471f m4672a() {
        try {
            return (C1471f) this.f3970c.get(500, TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            Log.e(f3968a, "Timed out waiting for cache server.", e);
            return null;
        }
    }

    /* renamed from: a */
    public boolean m4673a(String str) {
        C1471f a = m4672a();
        return a != null && a.m5202a(str);
    }

    /* renamed from: b */
    public String m4674b(String str) {
        C1471f a = m4672a();
        return a == null ? null : a.m5203b(str);
    }
}
