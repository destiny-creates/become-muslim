package com.google.android.exoplayer2.p149h;

import android.os.Handler;
import com.google.android.exoplayer2.C2251b;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p164l.C2516a;
import java.io.IOException;

/* compiled from: MediaSourceEventListener */
/* renamed from: com.google.android.exoplayer2.h.j */
public interface C2430j {

    /* compiled from: MediaSourceEventListener */
    /* renamed from: com.google.android.exoplayer2.h.j$a */
    public static final class C2429a {
        /* renamed from: a */
        private final Handler f6035a;
        /* renamed from: b */
        private final C2430j f6036b;
        /* renamed from: c */
        private final long f6037c;

        public C2429a(Handler handler, C2430j c2430j) {
            this(handler, c2430j, 0);
        }

        public C2429a(Handler handler, C2430j c2430j, long j) {
            this.f6035a = c2430j != null ? (Handler) C2516a.m7015a((Object) handler) : null;
            this.f6036b = c2430j;
            this.f6037c = j;
        }

        /* renamed from: a */
        public C2429a m6666a(long j) {
            return new C2429a(this.f6035a, this.f6036b, j);
        }

        /* renamed from: a */
        public void m6671a(C2501j c2501j, int i, long j) {
            m6668a(c2501j, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j);
        }

        /* renamed from: a */
        public void m6668a(C2501j c2501j, int i, int i2, C2515k c2515k, int i3, Object obj, long j, long j2, long j3) {
            if (this.f6036b != null && r14.f6035a != null) {
                Handler handler = r14.f6035a;
                final C2501j c2501j2 = c2501j;
                final int i4 = i;
                final int i5 = i2;
                final C2515k c2515k2 = c2515k;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j4 = j;
                final long j5 = j2;
                C24241 c24241 = r0;
                final long j6 = j3;
                C24241 c242412 = new Runnable(this) {
                    /* renamed from: j */
                    final /* synthetic */ C2429a f5990j;

                    public void run() {
                        this.f5990j.f6036b.onLoadStarted(c2501j2, i4, i5, c2515k2, i6, obj2, this.f5990j.m6665b(j4), this.f5990j.m6665b(j5), j6);
                    }
                };
                handler.post(c24241);
            }
        }

        /* renamed from: a */
        public void m6672a(C2501j c2501j, int i, long j, long j2, long j3) {
            m6669a(c2501j, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        /* renamed from: a */
        public void m6669a(C2501j c2501j, int i, int i2, C2515k c2515k, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            if (this.f6036b != null && r14.f6035a != null) {
                final C2501j c2501j2 = c2501j;
                final int i4 = i;
                final int i5 = i2;
                final C2515k c2515k2 = c2515k;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                C24252 c24252 = r0;
                final long j8 = j3;
                Handler handler = r14.f6035a;
                final long j9 = j4;
                final long j10 = j5;
                C24252 c242522 = new Runnable(this) {
                    /* renamed from: l */
                    final /* synthetic */ C2429a f6002l;

                    public void run() {
                        this.f6002l.f6036b.onLoadCompleted(c2501j2, i4, i5, c2515k2, i6, obj2, this.f6002l.m6665b(j6), this.f6002l.m6665b(j7), j8, j9, j10);
                    }
                };
                handler.post(c24252);
            }
        }

        /* renamed from: b */
        public void m6675b(C2501j c2501j, int i, long j, long j2, long j3) {
            m6674b(c2501j, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        /* renamed from: b */
        public void m6674b(C2501j c2501j, int i, int i2, C2515k c2515k, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            if (this.f6036b != null && r14.f6035a != null) {
                final C2501j c2501j2 = c2501j;
                final int i4 = i;
                final int i5 = i2;
                final C2515k c2515k2 = c2515k;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                C24263 c24263 = r0;
                final long j8 = j3;
                Handler handler = r14.f6035a;
                final long j9 = j4;
                final long j10 = j5;
                C24263 c242632 = new Runnable(this) {
                    /* renamed from: l */
                    final /* synthetic */ C2429a f6014l;

                    public void run() {
                        this.f6014l.f6036b.onLoadCanceled(c2501j2, i4, i5, c2515k2, i6, obj2, this.f6014l.m6665b(j6), this.f6014l.m6665b(j7), j8, j9, j10);
                    }
                };
                handler.post(c24263);
            }
        }

        /* renamed from: a */
        public void m6673a(C2501j c2501j, int i, long j, long j2, long j3, IOException iOException, boolean z) {
            m6670a(c2501j, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
        }

        /* renamed from: a */
        public void m6670a(C2501j c2501j, int i, int i2, C2515k c2515k, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            if (this.f6036b != null && r14.f6035a != null) {
                final C2501j c2501j2 = c2501j;
                final int i4 = i;
                final int i5 = i2;
                final C2515k c2515k2 = c2515k;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                C24274 c24274 = r0;
                final long j8 = j3;
                Handler handler = r14.f6035a;
                final long j9 = j4;
                final long j10 = j5;
                final IOException iOException2 = iOException;
                final boolean z2 = z;
                C24274 c242742 = new Runnable(this) {
                    /* renamed from: n */
                    final /* synthetic */ C2429a f6028n;

                    public void run() {
                        this.f6028n.f6036b.onLoadError(c2501j2, i4, i5, c2515k2, i6, obj2, this.f6028n.m6665b(j6), this.f6028n.m6665b(j7), j8, j9, j10, iOException2, z2);
                    }
                };
                handler.post(c24274);
            }
        }

        /* renamed from: a */
        public void m6667a(int i, C2515k c2515k, int i2, Object obj, long j) {
            if (this.f6036b != null && r8.f6035a != null) {
                final int i3 = i;
                final C2515k c2515k2 = c2515k;
                final int i4 = i2;
                final Object obj2 = obj;
                final long j2 = j;
                r8.f6035a.post(new Runnable(this) {
                    /* renamed from: f */
                    final /* synthetic */ C2429a f6034f;

                    public void run() {
                        this.f6034f.f6036b.onDownstreamFormatChanged(i3, c2515k2, i4, obj2, this.f6034f.m6665b(j2));
                    }
                });
            }
        }

        /* renamed from: b */
        private long m6665b(long j) {
            j = C2251b.m6221a(j);
            if (j == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f6037c + j;
        }
    }

    void onDownstreamFormatChanged(int i, C2515k c2515k, int i2, Object obj, long j);

    void onLoadCanceled(C2501j c2501j, int i, int i2, C2515k c2515k, int i3, Object obj, long j, long j2, long j3, long j4, long j5);

    void onLoadCompleted(C2501j c2501j, int i, int i2, C2515k c2515k, int i3, Object obj, long j, long j2, long j3, long j4, long j5);

    void onLoadError(C2501j c2501j, int i, int i2, C2515k c2515k, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z);

    void onLoadStarted(C2501j c2501j, int i, int i2, C2515k c2515k, int i3, Object obj, long j, long j2, long j3);
}
