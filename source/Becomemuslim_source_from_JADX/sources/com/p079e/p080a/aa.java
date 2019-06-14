package com.p079e.p080a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: Stats */
/* renamed from: com.e.a.aa */
class aa {
    /* renamed from: a */
    final HandlerThread f3363a = new HandlerThread("Picasso-Stats", 10);
    /* renamed from: b */
    final C1211d f3364b;
    /* renamed from: c */
    final Handler f3365c;
    /* renamed from: d */
    long f3366d;
    /* renamed from: e */
    long f3367e;
    /* renamed from: f */
    long f3368f;
    /* renamed from: g */
    long f3369g;
    /* renamed from: h */
    long f3370h;
    /* renamed from: i */
    long f3371i;
    /* renamed from: j */
    long f3372j;
    /* renamed from: k */
    long f3373k;
    /* renamed from: l */
    int f3374l;
    /* renamed from: m */
    int f3375m;
    /* renamed from: n */
    int f3376n;

    /* compiled from: Stats */
    /* renamed from: com.e.a.aa$a */
    private static class C1196a extends Handler {
        /* renamed from: a */
        private final aa f3362a;

        public C1196a(Looper looper, aa aaVar) {
            super(looper);
            this.f3362a = aaVar;
        }

        public void handleMessage(final Message message) {
            switch (message.what) {
                case 0:
                    this.f3362a.m4194c();
                    return;
                case 1:
                    this.f3362a.m4196d();
                    return;
                case 2:
                    this.f3362a.m4192b((long) message.arg1);
                    return;
                case 3:
                    this.f3362a.m4195c((long) message.arg1);
                    return;
                case 4:
                    this.f3362a.m4190a((Long) message.obj);
                    return;
                default:
                    C1236t.f3495a.post(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ C1196a f3361b;

                        public void run() {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unhandled stats message.");
                            stringBuilder.append(message.what);
                            throw new AssertionError(stringBuilder.toString());
                        }
                    });
                    return;
            }
        }
    }

    aa(C1211d c1211d) {
        this.f3364b = c1211d;
        this.f3363a.start();
        ae.m4218a(this.f3363a.getLooper());
        this.f3365c = new C1196a(this.f3363a.getLooper(), this);
    }

    /* renamed from: a */
    void m4189a(Bitmap bitmap) {
        m4186a(bitmap, 2);
    }

    /* renamed from: b */
    void m4193b(Bitmap bitmap) {
        m4186a(bitmap, 3);
    }

    /* renamed from: a */
    void m4188a(long j) {
        this.f3365c.sendMessage(this.f3365c.obtainMessage(4, Long.valueOf(j)));
    }

    /* renamed from: a */
    void m4187a() {
        this.f3365c.sendEmptyMessage(0);
    }

    /* renamed from: b */
    void m4191b() {
        this.f3365c.sendEmptyMessage(1);
    }

    /* renamed from: c */
    void m4194c() {
        this.f3366d++;
    }

    /* renamed from: d */
    void m4196d() {
        this.f3367e++;
    }

    /* renamed from: a */
    void m4190a(Long l) {
        this.f3374l++;
        this.f3368f += l.longValue();
        this.f3371i = aa.m4185a(this.f3374l, this.f3368f);
    }

    /* renamed from: b */
    void m4192b(long j) {
        this.f3375m++;
        this.f3369g += j;
        this.f3372j = aa.m4185a(this.f3375m, this.f3369g);
    }

    /* renamed from: c */
    void m4195c(long j) {
        this.f3376n++;
        this.f3370h += j;
        this.f3373k = aa.m4185a(this.f3375m, this.f3370h);
    }

    /* renamed from: e */
    ab m4197e() {
        return new ab(this.f3364b.mo825b(), this.f3364b.mo822a(), this.f3366d, this.f3367e, this.f3368f, this.f3369g, this.f3370h, this.f3371i, this.f3372j, this.f3373k, this.f3374l, this.f3375m, this.f3376n, System.currentTimeMillis());
    }

    /* renamed from: a */
    private void m4186a(Bitmap bitmap, int i) {
        this.f3365c.sendMessage(this.f3365c.obtainMessage(i, ae.m4207a(bitmap), 0));
    }

    /* renamed from: a */
    private static long m4185a(int i, long j) {
        return j / ((long) i);
    }
}
