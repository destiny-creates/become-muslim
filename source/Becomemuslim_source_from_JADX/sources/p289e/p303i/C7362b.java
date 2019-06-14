package p289e.p303i;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p289e.C5989l;
import p289e.p290a.C5903b;

/* compiled from: CompositeSubscription */
/* renamed from: e.i.b */
public final class C7362b implements C5989l {
    /* renamed from: a */
    private Set<C5989l> f25763a;
    /* renamed from: b */
    private volatile boolean f25764b;

    /* renamed from: b */
    public boolean mo5121b() {
        return this.f25764b;
    }

    /* renamed from: a */
    public void m33765a(C5989l c5989l) {
        if (!c5989l.mo5121b()) {
            if (!this.f25764b) {
                synchronized (this) {
                    if (!this.f25764b) {
                        if (this.f25763a == null) {
                            this.f25763a = new HashSet(4);
                        }
                        this.f25763a.add(c5989l);
                        return;
                    }
                }
            }
            c5989l.U_();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public void m33766b(p289e.C5989l r2) {
        /*
        r1 = this;
        r0 = r1.f25764b;
        if (r0 != 0) goto L_0x0020;
    L_0x0004:
        monitor-enter(r1);
        r0 = r1.f25764b;	 Catch:{ all -> 0x001d }
        if (r0 != 0) goto L_0x001b;
    L_0x0009:
        r0 = r1.f25763a;	 Catch:{ all -> 0x001d }
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        goto L_0x001b;
    L_0x000e:
        r0 = r1.f25763a;	 Catch:{ all -> 0x001d }
        r0 = r0.remove(r2);	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0020;
    L_0x0017:
        r2.U_();
        goto L_0x0020;
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        return;
    L_0x001d:
        r2 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r2;
    L_0x0020:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i.b.b(e.l):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void U_() {
        /*
        r2 = this;
        r0 = r2.f25764b;
        if (r0 != 0) goto L_0x001b;
    L_0x0004:
        monitor-enter(r2);
        r0 = r2.f25764b;	 Catch:{ all -> 0x0018 }
        if (r0 == 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        return;
    L_0x000b:
        r0 = 1;
        r2.f25764b = r0;	 Catch:{ all -> 0x0018 }
        r0 = r2.f25763a;	 Catch:{ all -> 0x0018 }
        r1 = 0;
        r2.f25763a = r1;	 Catch:{ all -> 0x0018 }
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        p289e.p303i.C7362b.m33764a(r0);
        goto L_0x001b;
    L_0x0018:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        throw r0;
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i.b.U_():void");
    }

    /* renamed from: a */
    private static void m33764a(Collection<C5989l> collection) {
        if (collection != null) {
            List list = null;
            for (C5989l U_ : collection) {
                try {
                    U_.U_();
                } catch (Throwable th) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(th);
                }
            }
            C5903b.m24793a(list);
        }
    }
}
