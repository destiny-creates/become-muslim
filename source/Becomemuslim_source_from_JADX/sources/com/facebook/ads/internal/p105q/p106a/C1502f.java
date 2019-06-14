package com.facebook.ads.internal.p105q.p106a;

import android.os.Handler;

/* renamed from: com.facebook.ads.internal.q.a.f */
public class C1502f {
    /* renamed from: a */
    private final Handler f4438a;
    /* renamed from: b */
    private final C1501a f4439b;
    /* renamed from: c */
    private int f4440c;
    /* renamed from: d */
    private boolean f4441d;

    /* renamed from: com.facebook.ads.internal.q.a.f$1 */
    class C15001 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1502f f4437a;

        C15001(C1502f c1502f) {
            this.f4437a = c1502f;
        }

        public void run() {
            if (this.f4437a.m5288c()) {
                this.f4437a.m5285e();
                this.f4437a.f4438a.postDelayed(this, 1000);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.q.a.f$a */
    public interface C1501a {
        /* renamed from: a */
        void mo1063a();

        /* renamed from: a */
        void mo1064a(int i);
    }

    public C1502f(int i, C1501a c1501a) {
        this(i, c1501a, new Handler());
    }

    C1502f(int i, C1501a c1501a, Handler handler) {
        this.f4441d = false;
        this.f4440c = i;
        this.f4439b = c1501a;
        this.f4438a = handler;
    }

    /* renamed from: e */
    private void m5285e() {
        this.f4440c--;
        this.f4439b.mo1064a(this.f4440c);
        if (this.f4440c == 0) {
            this.f4439b.mo1063a();
            this.f4441d = false;
        }
    }

    /* renamed from: a */
    public boolean m5286a() {
        if (this.f4440c > 0) {
            if (!m5288c()) {
                this.f4441d = true;
                this.f4439b.mo1064a(this.f4440c);
                this.f4438a.postDelayed(new C15001(this), 1000);
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean m5287b() {
        if (!m5288c()) {
            return false;
        }
        this.f4441d = false;
        return true;
    }

    /* renamed from: c */
    public boolean m5288c() {
        return this.f4441d;
    }

    /* renamed from: d */
    public boolean m5289d() {
        return this.f4440c <= 0;
    }
}
