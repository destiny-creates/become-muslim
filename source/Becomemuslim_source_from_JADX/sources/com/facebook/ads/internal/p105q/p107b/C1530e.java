package com.facebook.ads.internal.p105q.p107b;

import android.graphics.Bitmap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.facebook.ads.internal.q.b.e */
public class C1530e {
    /* renamed from: a */
    static final int f4529a = Runtime.getRuntime().availableProcessors();
    /* renamed from: b */
    static final ExecutorService f4530b = Executors.newFixedThreadPool(f4529a);
    /* renamed from: c */
    private static volatile boolean f4531c = true;
    /* renamed from: d */
    private final Bitmap f4532d;
    /* renamed from: e */
    private Bitmap f4533e;
    /* renamed from: f */
    private final C1526a f4534f = new C3608d();

    public C1530e(Bitmap bitmap) {
        this.f4532d = bitmap;
    }

    /* renamed from: a */
    public Bitmap m5359a() {
        return this.f4533e;
    }

    /* renamed from: a */
    public Bitmap m5360a(int i) {
        this.f4533e = this.f4534f.mo996a(this.f4532d, (float) i);
        return this.f4533e;
    }
}
