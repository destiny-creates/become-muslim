package android.support.v4.p030f;

import android.os.Build.VERSION;
import android.os.CancellationSignal;

/* compiled from: CancellationSignal */
/* renamed from: android.support.v4.f.b */
public final class C0388b {
    /* renamed from: a */
    private boolean f1010a;
    /* renamed from: b */
    private C0387a f1011b;
    /* renamed from: c */
    private Object f1012c;
    /* renamed from: d */
    private boolean f1013d;

    /* compiled from: CancellationSignal */
    /* renamed from: android.support.v4.f.b$a */
    public interface C0387a {
        /* renamed from: a */
        void m1166a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m1167a() {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.f1010a;	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        return;
    L_0x0007:
        r0 = 1;
        r4.f1010a = r0;	 Catch:{ all -> 0x003e }
        r4.f1013d = r0;	 Catch:{ all -> 0x003e }
        r0 = r4.f1011b;	 Catch:{ all -> 0x003e }
        r1 = r4.f1012c;	 Catch:{ all -> 0x003e }
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        r2 = 0;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0.m1166a();	 Catch:{ all -> 0x0018 }
        goto L_0x001a;
    L_0x0018:
        r0 = move-exception;
        goto L_0x0028;
    L_0x001a:
        if (r1 == 0) goto L_0x0033;
    L_0x001c:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0018 }
        r3 = 16;
        if (r0 < r3) goto L_0x0033;
    L_0x0022:
        r1 = (android.os.CancellationSignal) r1;	 Catch:{ all -> 0x0018 }
        r1.cancel();	 Catch:{ all -> 0x0018 }
        goto L_0x0033;
    L_0x0028:
        monitor-enter(r4);
        r4.f1013d = r2;	 Catch:{ all -> 0x0030 }
        r4.notifyAll();	 Catch:{ all -> 0x0030 }
        monitor-exit(r4);	 Catch:{ all -> 0x0030 }
        throw r0;
    L_0x0030:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0030 }
        throw r0;
    L_0x0033:
        monitor-enter(r4);
        r4.f1013d = r2;	 Catch:{ all -> 0x003b }
        r4.notifyAll();	 Catch:{ all -> 0x003b }
        monitor-exit(r4);	 Catch:{ all -> 0x003b }
        return;
    L_0x003b:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003b }
        throw r0;
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.f.b.a():void");
    }

    /* renamed from: b */
    public Object m1168b() {
        if (VERSION.SDK_INT < 16) {
            return null;
        }
        Object obj;
        synchronized (this) {
            if (this.f1012c == null) {
                this.f1012c = new CancellationSignal();
                if (this.f1010a) {
                    ((CancellationSignal) this.f1012c).cancel();
                }
            }
            obj = this.f1012c;
        }
        return obj;
    }
}
