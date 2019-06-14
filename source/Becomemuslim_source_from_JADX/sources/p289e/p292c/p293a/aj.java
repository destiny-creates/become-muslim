package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import java.util.concurrent.TimeUnit;
import p289e.C5974e.C7336b;
import p289e.C5986h;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p291b.C5913a;
import p289e.p299e.C8146d;
import p289e.p303i.C7364d;

/* compiled from: OperatorDebounceWithTime */
/* renamed from: e.c.a.aj */
public final class aj<T> implements C7336b<T, T> {
    /* renamed from: a */
    final long f29937a;
    /* renamed from: b */
    final TimeUnit f29938b;
    /* renamed from: c */
    final C5986h f29939c;

    /* compiled from: OperatorDebounceWithTime */
    /* renamed from: e.c.a.aj$a */
    static final class C5924a<T> {
        /* renamed from: a */
        int f19641a;
        /* renamed from: b */
        T f19642b;
        /* renamed from: c */
        boolean f19643c;
        /* renamed from: d */
        boolean f19644d;
        /* renamed from: e */
        boolean f19645e;

        C5924a() {
        }

        /* renamed from: a */
        public synchronized int m24839a(T t) {
            int i;
            this.f19642b = t;
            this.f19643c = true;
            i = this.f19641a + 1;
            this.f19641a = i;
            return i;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public void m24841a(int r3, p289e.C7367k<T> r4, p289e.C7367k<?> r5) {
            /*
            r2 = this;
            monitor-enter(r2);
            r0 = r2.f19645e;	 Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0033;
        L_0x0005:
            r0 = r2.f19643c;	 Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0033;
        L_0x0009:
            r0 = r2.f19641a;	 Catch:{ all -> 0x0035 }
            if (r3 == r0) goto L_0x000e;
        L_0x000d:
            goto L_0x0033;
        L_0x000e:
            r3 = r2.f19642b;	 Catch:{ all -> 0x0035 }
            r0 = 0;
            r2.f19642b = r0;	 Catch:{ all -> 0x0035 }
            r0 = 0;
            r2.f19643c = r0;	 Catch:{ all -> 0x0035 }
            r1 = 1;
            r2.f19645e = r1;	 Catch:{ all -> 0x0035 }
            monitor-exit(r2);	 Catch:{ all -> 0x0035 }
            r4.mo5000a(r3);	 Catch:{ Throwable -> 0x002e }
            monitor-enter(r2);
            r3 = r2.f19644d;	 Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x0026;
        L_0x0022:
            r2.f19645e = r0;	 Catch:{ all -> 0x002b }
            monitor-exit(r2);	 Catch:{ all -> 0x002b }
            return;
        L_0x0026:
            monitor-exit(r2);	 Catch:{ all -> 0x002b }
            r4.L_();
            return;
        L_0x002b:
            r3 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x002b }
            throw r3;
        L_0x002e:
            r4 = move-exception;
            p289e.p290a.C5903b.m24790a(r4, r5, r3);
            return;
        L_0x0033:
            monitor-exit(r2);	 Catch:{ all -> 0x0035 }
            return;
        L_0x0035:
            r3 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0035 }
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.aj.a.a(int, e.k, e.k):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public void m24842a(p289e.C7367k<T> r5, p289e.C7367k<?> r6) {
            /*
            r4 = this;
            monitor-enter(r4);
            r0 = r4.f19645e;	 Catch:{ all -> 0x0026 }
            r1 = 1;
            if (r0 == 0) goto L_0x000a;
        L_0x0006:
            r4.f19644d = r1;	 Catch:{ all -> 0x0026 }
            monitor-exit(r4);	 Catch:{ all -> 0x0026 }
            return;
        L_0x000a:
            r0 = r4.f19642b;	 Catch:{ all -> 0x0026 }
            r2 = r4.f19643c;	 Catch:{ all -> 0x0026 }
            r3 = 0;
            r4.f19642b = r3;	 Catch:{ all -> 0x0026 }
            r3 = 0;
            r4.f19643c = r3;	 Catch:{ all -> 0x0026 }
            r4.f19645e = r1;	 Catch:{ all -> 0x0026 }
            monitor-exit(r4);	 Catch:{ all -> 0x0026 }
            if (r2 == 0) goto L_0x0022;
        L_0x0019:
            r5.mo5000a(r0);	 Catch:{ Throwable -> 0x001d }
            goto L_0x0022;
        L_0x001d:
            r5 = move-exception;
            p289e.p290a.C5903b.m24790a(r5, r6, r0);
            return;
        L_0x0022:
            r5.L_();
            return;
        L_0x0026:
            r5 = move-exception;
            monitor-exit(r4);	 Catch:{ all -> 0x0026 }
            throw r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.aj.a.a(e.k, e.k):void");
        }

        /* renamed from: a */
        public synchronized void m24840a() {
            this.f19641a++;
            this.f19642b = null;
            this.f19643c = false;
        }
    }

    public aj(long j, TimeUnit timeUnit, C5986h c5986h) {
        this.f29937a = j;
        this.f29938b = timeUnit;
        this.f29939c = c5986h;
    }

    /* renamed from: a */
    public C7367k<? super T> m39141a(C7367k<? super T> c7367k) {
        final Object a = this.f29939c.mo5127a();
        final C8146d c8146d = new C8146d(c7367k);
        final Object c7364d = new C7364d();
        c8146d.m33781a((C5989l) a);
        c8146d.m33781a((C5989l) c7364d);
        return new C7367k<T>(this, c7367k) {
            /* renamed from: a */
            final C5924a<T> f29931a = new C5924a();
            /* renamed from: b */
            final C7367k<?> f29932b = this;
            /* renamed from: f */
            final /* synthetic */ aj f29936f;

            /* renamed from: c */
            public void mo6323c() {
                m33779a((long) Clock.MAX_TIME);
            }

            /* renamed from: a */
            public void mo5000a(T t) {
                t = this.f29931a.m24839a(t);
                c7364d.m33770a(a.mo6333a(new C5913a(this) {
                    /* renamed from: b */
                    final /* synthetic */ C80581 f25526b;

                    /* renamed from: a */
                    public void mo4985a() {
                        this.f25526b.f29931a.m24841a(t, c8146d, this.f25526b.f29932b);
                    }
                }, this.f29936f.f29937a, this.f29936f.f29938b));
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                c8146d.mo5001a(th);
                U_();
                this.f29931a.m24840a();
            }

            public void L_() {
                this.f29931a.m24842a(c8146d, this);
            }
        };
    }
}
