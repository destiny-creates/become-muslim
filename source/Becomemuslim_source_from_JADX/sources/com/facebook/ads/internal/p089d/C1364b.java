package com.facebook.ads.internal.p089d;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.internal.d.b */
public class C1364b {
    /* renamed from: a */
    private static final String f3956a = "b";
    /* renamed from: b */
    private static final ExecutorService f3957b = Executors.newSingleThreadExecutor();
    /* renamed from: c */
    private static final ExecutorService f3958c = Executors.newFixedThreadPool(5);
    /* renamed from: d */
    private final Handler f3959d = new Handler();
    /* renamed from: e */
    private final C1365c f3960e;
    /* renamed from: f */
    private final C1367d f3961f;
    /* renamed from: g */
    private final List<Callable<Boolean>> f3962g;

    /* renamed from: com.facebook.ads.internal.d.b$a */
    private class C1362a implements Callable<Boolean> {
        /* renamed from: a */
        final /* synthetic */ C1364b f3950a;
        /* renamed from: b */
        private final String f3951b;
        /* renamed from: c */
        private final int f3952c;
        /* renamed from: d */
        private final int f3953d;

        public C1362a(C1364b c1364b, String str, int i, int i2) {
            this.f3950a = c1364b;
            this.f3951b = str;
            this.f3952c = i;
            this.f3953d = i2;
        }

        /* renamed from: a */
        public Boolean m4650a() {
            return Boolean.valueOf(this.f3950a.f3960e.m4669a(this.f3951b, this.f3952c, this.f3953d) != null);
        }

        public /* synthetic */ Object call() {
            return m4650a();
        }
    }

    /* renamed from: com.facebook.ads.internal.d.b$b */
    private class C1363b implements Callable<Boolean> {
        /* renamed from: a */
        final /* synthetic */ C1364b f3954a;
        /* renamed from: b */
        private final String f3955b;

        public C1363b(C1364b c1364b, String str) {
            this.f3954a = c1364b;
            this.f3955b = str;
        }

        /* renamed from: a */
        public Boolean m4651a() {
            return Boolean.valueOf(this.f3954a.f3961f.m4673a(this.f3955b));
        }

        public /* synthetic */ Object call() {
            return m4651a();
        }
    }

    public C1364b(Context context) {
        this.f3960e = C1365c.m4662a(context);
        this.f3961f = C1367d.m4671a(context);
        this.f3962g = new ArrayList();
    }

    /* renamed from: a */
    public void m4657a(final C1359a c1359a) {
        final ArrayList arrayList = new ArrayList(this.f3962g);
        f3957b.execute(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C1364b f3949c;

            public void run() {
                List<Future> arrayList = new ArrayList(arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList.add(C1364b.f3958c.submit((Callable) it.next()));
                }
                final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                try {
                    for (Future future : arrayList) {
                        atomicBoolean.set(((Boolean) future.get()).booleanValue() & atomicBoolean.get());
                    }
                } catch (Throwable e) {
                    Log.e(C1364b.f3956a, "Exception while executing cache downloads.", e);
                    atomicBoolean.set(false);
                }
                this.f3949c.f3959d.post(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C13611 f3946b;

                    public void run() {
                        if (c1359a == null) {
                            return;
                        }
                        if (atomicBoolean.get()) {
                            c1359a.mo882a();
                        } else {
                            c1359a.mo883b();
                        }
                    }
                });
            }
        });
        this.f3962g.clear();
    }

    /* renamed from: a */
    public void m4658a(String str) {
        this.f3962g.add(new C1363b(this, str));
    }

    /* renamed from: a */
    public void m4659a(String str, int i, int i2) {
        this.f3962g.add(new C1362a(this, str, i, i2));
    }

    /* renamed from: b */
    public String m4660b(String str) {
        return this.f3961f.m4674b(str);
    }
}
