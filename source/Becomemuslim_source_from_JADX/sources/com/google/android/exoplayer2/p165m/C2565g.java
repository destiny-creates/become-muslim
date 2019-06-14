package com.google.android.exoplayer2.p165m;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p135b.C2249d;
import com.google.android.exoplayer2.p164l.C2516a;

/* compiled from: VideoRendererEventListener */
/* renamed from: com.google.android.exoplayer2.m.g */
public interface C2565g {

    /* compiled from: VideoRendererEventListener */
    /* renamed from: com.google.android.exoplayer2.m.g$a */
    public static final class C2564a {
        /* renamed from: a */
        private final Handler f6547a;
        /* renamed from: b */
        private final C2565g f6548b;

        public C2564a(Handler handler, C2565g c2565g) {
            this.f6547a = c2565g != null ? (Handler) C2516a.m7015a((Object) handler) : null;
            this.f6548b = c2565g;
        }

        /* renamed from: a */
        public void m7234a(final C2249d c2249d) {
            if (this.f6548b != null) {
                this.f6547a.post(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C2564a f6528b;

                    public void run() {
                        this.f6528b.f6548b.mo2333a(c2249d);
                    }
                });
            }
        }

        /* renamed from: a */
        public void m7236a(String str, long j, long j2) {
            if (this.f6548b != null) {
                final String str2 = str;
                final long j3 = j;
                final long j4 = j2;
                this.f6547a.post(new Runnable(this) {
                    /* renamed from: d */
                    final /* synthetic */ C2564a f6532d;

                    public void run() {
                        this.f6532d.f6548b.mo2336a(str2, j3, j4);
                    }
                });
            }
        }

        /* renamed from: a */
        public void m7235a(final C2515k c2515k) {
            if (this.f6548b != null) {
                this.f6547a.post(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C2564a f6534b;

                    public void run() {
                        this.f6534b.f6548b.mo2335a(c2515k);
                    }
                });
            }
        }

        /* renamed from: a */
        public void m7232a(final int i, final long j) {
            if (this.f6548b != null) {
                this.f6547a.post(new Runnable(this) {
                    /* renamed from: c */
                    final /* synthetic */ C2564a f6537c;

                    public void run() {
                        this.f6537c.f6548b.mo2330a(i, j);
                    }
                });
            }
        }

        /* renamed from: a */
        public void m7231a(int i, int i2, int i3, float f) {
            if (this.f6548b != null) {
                final int i4 = i;
                final int i5 = i2;
                final int i6 = i3;
                final float f2 = f;
                this.f6547a.post(new Runnable(this) {
                    /* renamed from: e */
                    final /* synthetic */ C2564a f6542e;

                    public void run() {
                        this.f6542e.f6548b.mo2329a(i4, i5, i6, f2);
                    }
                });
            }
        }

        /* renamed from: a */
        public void m7233a(final Surface surface) {
            if (this.f6548b != null) {
                this.f6547a.post(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C2564a f6544b;

                    public void run() {
                        this.f6544b.f6548b.mo2332a(surface);
                    }
                });
            }
        }

        /* renamed from: b */
        public void m7237b(final C2249d c2249d) {
            if (this.f6548b != null) {
                this.f6547a.post(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C2564a f6546b;

                    public void run() {
                        c2249d.m6220a();
                        this.f6546b.f6548b.mo2337b(c2249d);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    void mo2329a(int i, int i2, int i3, float f);

    /* renamed from: a */
    void mo2330a(int i, long j);

    /* renamed from: a */
    void mo2332a(Surface surface);

    /* renamed from: a */
    void mo2333a(C2249d c2249d);

    /* renamed from: a */
    void mo2335a(C2515k c2515k);

    /* renamed from: a */
    void mo2336a(String str, long j, long j2);

    /* renamed from: b */
    void mo2337b(C2249d c2249d);
}
