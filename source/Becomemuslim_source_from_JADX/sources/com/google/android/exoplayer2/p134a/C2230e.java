package com.google.android.exoplayer2.p134a;

import android.os.Handler;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p135b.C2249d;
import com.google.android.exoplayer2.p164l.C2516a;

/* compiled from: AudioRendererEventListener */
/* renamed from: com.google.android.exoplayer2.a.e */
public interface C2230e {

    /* compiled from: AudioRendererEventListener */
    /* renamed from: com.google.android.exoplayer2.a.e$a */
    public static final class C2229a {
        /* renamed from: a */
        private final Handler f5303a;
        /* renamed from: b */
        private final C2230e f5304b;

        public C2229a(Handler handler, C2230e c2230e) {
            this.f5303a = c2230e != null ? (Handler) C2516a.m7015a((Object) handler) : null;
            this.f5304b = c2230e;
        }

        /* renamed from: a */
        public void m6133a(final C2249d c2249d) {
            if (this.f5304b != null) {
                this.f5303a.post(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C2229a f5288b;

                    public void run() {
                        this.f5288b.f5304b.mo2340c(c2249d);
                    }
                });
            }
        }

        /* renamed from: a */
        public void m6135a(String str, long j, long j2) {
            if (this.f5304b != null) {
                final String str2 = str;
                final long j3 = j;
                final long j4 = j2;
                this.f5303a.post(new Runnable(this) {
                    /* renamed from: d */
                    final /* synthetic */ C2229a f5292d;

                    public void run() {
                        this.f5292d.f5304b.mo2339b(str2, j3, j4);
                    }
                });
            }
        }

        /* renamed from: a */
        public void m6134a(final C2515k c2515k) {
            if (this.f5304b != null) {
                this.f5303a.post(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C2229a f5294b;

                    public void run() {
                        this.f5294b.f5304b.mo2338b(c2515k);
                    }
                });
            }
        }

        /* renamed from: a */
        public void m6132a(int i, long j, long j2) {
            if (this.f5304b != null) {
                final int i2 = i;
                final long j3 = j;
                final long j4 = j2;
                this.f5303a.post(new Runnable(this) {
                    /* renamed from: d */
                    final /* synthetic */ C2229a f5298d;

                    public void run() {
                        this.f5298d.f5304b.mo2331a(i2, j3, j4);
                    }
                });
            }
        }

        /* renamed from: b */
        public void m6136b(final C2249d c2249d) {
            if (this.f5304b != null) {
                this.f5303a.post(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C2229a f5300b;

                    public void run() {
                        c2249d.m6220a();
                        this.f5300b.f5304b.mo2341d(c2249d);
                    }
                });
            }
        }

        /* renamed from: a */
        public void m6131a(final int i) {
            if (this.f5304b != null) {
                this.f5303a.post(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C2229a f5302b;

                    public void run() {
                        this.f5302b.f5304b.mo2328a(i);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    void mo2328a(int i);

    /* renamed from: a */
    void mo2331a(int i, long j, long j2);

    /* renamed from: b */
    void mo2338b(C2515k c2515k);

    /* renamed from: b */
    void mo2339b(String str, long j, long j2);

    /* renamed from: c */
    void mo2340c(C2249d c2249d);

    /* renamed from: d */
    void mo2341d(C2249d c2249d);
}
