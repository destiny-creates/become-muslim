package p289e.p299e;

import p289e.C5982f;
import p289e.p290a.C5903b;
import p289e.p292c.p293a.C5937h;

/* compiled from: SerializedObserver */
/* renamed from: e.e.c */
public class C7339c<T> implements C5982f<T> {
    /* renamed from: a */
    private final C5982f<? super T> f25743a;
    /* renamed from: b */
    private boolean f25744b;
    /* renamed from: c */
    private volatile boolean f25745c;
    /* renamed from: d */
    private C5972a f25746d;

    /* compiled from: SerializedObserver */
    /* renamed from: e.e.c$a */
    static final class C5972a {
        /* renamed from: a */
        Object[] f19747a;
        /* renamed from: b */
        int f19748b;

        C5972a() {
        }

        /* renamed from: a */
        public void m24963a(Object obj) {
            int i = this.f19748b;
            Object[] objArr = this.f19747a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f19747a = objArr;
            } else if (i == objArr.length) {
                Object obj2 = new Object[((i >> 2) + i)];
                System.arraycopy(objArr, 0, obj2, 0, i);
                this.f19747a = obj2;
                objArr = obj2;
            }
            objArr[i] = obj;
            this.f19748b = i + 1;
        }
    }

    public C7339c(C5982f<? super T> c5982f) {
        this.f25743a = c5982f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo5000a(T r7) {
        /*
        r6 = this;
        r0 = r6.f25745c;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        monitor-enter(r6);
        r0 = r6.f25745c;	 Catch:{ all -> 0x006f }
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r6);	 Catch:{ all -> 0x006f }
        return;
    L_0x000c:
        r0 = r6.f25744b;	 Catch:{ all -> 0x006f }
        if (r0 == 0) goto L_0x0024;
    L_0x0010:
        r0 = r6.f25746d;	 Catch:{ all -> 0x006f }
        if (r0 != 0) goto L_0x001b;
    L_0x0014:
        r0 = new e.e.c$a;	 Catch:{ all -> 0x006f }
        r0.<init>();	 Catch:{ all -> 0x006f }
        r6.f25746d = r0;	 Catch:{ all -> 0x006f }
    L_0x001b:
        r7 = p289e.p292c.p293a.C5937h.m24848a(r7);	 Catch:{ all -> 0x006f }
        r0.m24963a(r7);	 Catch:{ all -> 0x006f }
        monitor-exit(r6);	 Catch:{ all -> 0x006f }
        return;
    L_0x0024:
        r0 = 1;
        r6.f25744b = r0;	 Catch:{ all -> 0x006f }
        monitor-exit(r6);	 Catch:{ all -> 0x006f }
        r1 = r6.f25743a;	 Catch:{ Throwable -> 0x0066 }
        r1.mo5000a(r7);	 Catch:{ Throwable -> 0x0066 }
    L_0x002d:
        monitor-enter(r6);
        r1 = r6.f25746d;	 Catch:{ all -> 0x0063 }
        r2 = 0;
        if (r1 != 0) goto L_0x0037;
    L_0x0033:
        r6.f25744b = r2;	 Catch:{ all -> 0x0063 }
        monitor-exit(r6);	 Catch:{ all -> 0x0063 }
        return;
    L_0x0037:
        r3 = 0;
        r6.f25746d = r3;	 Catch:{ all -> 0x0063 }
        monitor-exit(r6);	 Catch:{ all -> 0x0063 }
        r1 = r1.f19747a;
        r3 = r1.length;
    L_0x003e:
        if (r2 >= r3) goto L_0x002d;
    L_0x0040:
        r4 = r1[r2];
        if (r4 != 0) goto L_0x0045;
    L_0x0044:
        goto L_0x002d;
    L_0x0045:
        r5 = r6.f25743a;	 Catch:{ Throwable -> 0x0053 }
        r4 = p289e.p292c.p293a.C5937h.m24850a(r5, r4);	 Catch:{ Throwable -> 0x0053 }
        if (r4 == 0) goto L_0x0050;
    L_0x004d:
        r6.f25745c = r0;	 Catch:{ Throwable -> 0x0053 }
        return;
    L_0x0050:
        r2 = r2 + 1;
        goto L_0x003e;
    L_0x0053:
        r1 = move-exception;
        r6.f25745c = r0;
        p289e.p290a.C5903b.m24794b(r1);
        r0 = r6.f25743a;
        r7 = p289e.p290a.C5910g.m24799a(r1, r7);
        r0.mo5001a(r7);
        return;
    L_0x0063:
        r7 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0063 }
        throw r7;
    L_0x0066:
        r1 = move-exception;
        r6.f25745c = r0;
        r0 = r6.f25743a;
        p289e.p290a.C5903b.m24790a(r1, r0, r7);
        return;
    L_0x006f:
        r7 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x006f }
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.e.c.a(java.lang.Object):void");
    }

    /* renamed from: a */
    public void mo5001a(Throwable th) {
        C5903b.m24794b(th);
        if (!this.f25745c) {
            synchronized (this) {
                if (this.f25745c) {
                    return;
                }
                this.f25745c = true;
                if (this.f25744b) {
                    C5972a c5972a = this.f25746d;
                    if (c5972a == null) {
                        c5972a = new C5972a();
                        this.f25746d = c5972a;
                    }
                    c5972a.m24963a(C5937h.m24849a(th));
                    return;
                }
                this.f25744b = true;
                this.f25743a.mo5001a(th);
            }
        }
    }

    public void L_() {
        if (!this.f25745c) {
            synchronized (this) {
                if (this.f25745c) {
                    return;
                }
                this.f25745c = true;
                if (this.f25744b) {
                    C5972a c5972a = this.f25746d;
                    if (c5972a == null) {
                        c5972a = new C5972a();
                        this.f25746d = c5972a;
                    }
                    c5972a.m24963a(C5937h.m24847a());
                    return;
                }
                this.f25744b = true;
                this.f25743a.L_();
            }
        }
    }
}
