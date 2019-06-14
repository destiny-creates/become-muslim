package p289e.p292c.p295e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import p289e.C5989l;
import p289e.p290a.C5903b;

/* compiled from: SubscriptionList */
/* renamed from: e.c.e.m */
public final class C7329m implements C5989l {
    /* renamed from: a */
    private List<C5989l> f25736a;
    /* renamed from: b */
    private volatile boolean f25737b;

    public C7329m(C5989l... c5989lArr) {
        this.f25736a = new LinkedList(Arrays.asList(c5989lArr));
    }

    public C7329m(C5989l c5989l) {
        this.f25736a = new LinkedList();
        this.f25736a.add(c5989l);
    }

    /* renamed from: b */
    public boolean mo5121b() {
        return this.f25737b;
    }

    /* renamed from: a */
    public void m33693a(C5989l c5989l) {
        if (!c5989l.mo5121b()) {
            if (!this.f25737b) {
                synchronized (this) {
                    if (!this.f25737b) {
                        List list = this.f25736a;
                        if (list == null) {
                            list = new LinkedList();
                            this.f25736a = list;
                        }
                        list.add(c5989l);
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
    public void m33694b(p289e.C5989l r3) {
        /*
        r2 = this;
        r0 = r2.f25737b;
        if (r0 != 0) goto L_0x001e;
    L_0x0004:
        monitor-enter(r2);
        r0 = r2.f25736a;	 Catch:{ all -> 0x001b }
        r1 = r2.f25737b;	 Catch:{ all -> 0x001b }
        if (r1 != 0) goto L_0x0019;
    L_0x000b:
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0019;
    L_0x000e:
        r0 = r0.remove(r3);	 Catch:{ all -> 0x001b }
        monitor-exit(r2);	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x001e;
    L_0x0015:
        r3.U_();
        goto L_0x001e;
    L_0x0019:
        monitor-exit(r2);	 Catch:{ all -> 0x001b }
        return;
    L_0x001b:
        r3 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001b }
        throw r3;
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.e.m.b(e.l):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void U_() {
        /*
        r2 = this;
        r0 = r2.f25737b;
        if (r0 != 0) goto L_0x001b;
    L_0x0004:
        monitor-enter(r2);
        r0 = r2.f25737b;	 Catch:{ all -> 0x0018 }
        if (r0 == 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        return;
    L_0x000b:
        r0 = 1;
        r2.f25737b = r0;	 Catch:{ all -> 0x0018 }
        r0 = r2.f25736a;	 Catch:{ all -> 0x0018 }
        r1 = 0;
        r2.f25736a = r1;	 Catch:{ all -> 0x0018 }
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        p289e.p292c.p295e.C7329m.m33692a(r0);
        goto L_0x001b;
    L_0x0018:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        throw r0;
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.e.m.U_():void");
    }

    /* renamed from: a */
    private static void m33692a(Collection<C5989l> collection) {
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
