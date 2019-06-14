package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.C3211a;
import com.google.android.gms.common.C2830f;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2781a.C2778c;
import com.google.android.gms.common.api.C2781a.C4337a;
import com.google.android.gms.common.api.C2781a.C4340f;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C2796c.C4770a;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.common.internal.C2853f.C2852b;
import com.google.android.gms.common.util.p183a.C2887a;
import com.google.android.gms.p175c.C4764e;
import com.google.android.gms.p175c.C4882a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class cv implements bk {
    /* renamed from: a */
    private final Map<C2778c<?>, cu<?>> f11521a = new HashMap();
    /* renamed from: b */
    private final Map<C2778c<?>, cu<?>> f11522b = new HashMap();
    /* renamed from: c */
    private final Map<C2781a<?>, Boolean> f11523c;
    /* renamed from: d */
    private final C2798d f11524d;
    /* renamed from: e */
    private final an f11525e;
    /* renamed from: f */
    private final Lock f11526f;
    /* renamed from: g */
    private final Looper f11527g;
    /* renamed from: h */
    private final C2830f f11528h;
    /* renamed from: i */
    private final Condition f11529i;
    /* renamed from: j */
    private final C2853f f11530j;
    /* renamed from: k */
    private final boolean f11531k;
    /* renamed from: l */
    private final boolean f11532l;
    /* renamed from: m */
    private final Queue<C4770a<?, ?>> f11533m = new LinkedList();
    /* renamed from: n */
    private boolean f11534n;
    /* renamed from: o */
    private Map<cg<?>, C4775b> f11535o;
    /* renamed from: p */
    private Map<cg<?>, C4775b> f11536p;
    /* renamed from: q */
    private C4351r f11537q;
    /* renamed from: r */
    private C4775b f11538r;

    public cv(Context context, Lock lock, Looper looper, C2830f c2830f, Map<C2778c<?>, C4340f> map, C2853f c2853f, Map<C2781a<?>, Boolean> map2, C4337a<? extends C4764e, C4882a> c4337a, ArrayList<co> arrayList, an anVar, boolean z) {
        this.f11526f = lock;
        this.f11527g = looper;
        this.f11529i = lock.newCondition();
        this.f11528h = c2830f;
        this.f11525e = anVar;
        this.f11523c = map2;
        this.f11530j = c2853f;
        this.f11531k = z;
        Map hashMap = new HashMap();
        for (C2781a c2781a : map2.keySet()) {
            hashMap.put(c2781a.m7933c(), c2781a);
        }
        Map hashMap2 = new HashMap();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            co coVar = (co) obj;
            hashMap2.put(coVar.f11498a, coVar);
        }
        boolean z2 = true;
        Object obj2 = null;
        Object obj3 = 1;
        Object obj4 = null;
        for (Entry entry : map.entrySet()) {
            Object obj5;
            Object obj6;
            Object obj7;
            C2781a c2781a2 = (C2781a) hashMap.get(entry.getKey());
            C4340f c4340f = (C4340f) entry.getValue();
            if (c4340f.m14049k()) {
                if (((Boolean) r0.f11523c.get(c2781a2)).booleanValue()) {
                    obj5 = obj3;
                    obj6 = obj4;
                } else {
                    obj5 = obj3;
                    obj6 = 1;
                }
                obj7 = 1;
            } else {
                obj7 = obj2;
                obj6 = obj4;
                obj5 = null;
            }
            cu cuVar = r1;
            cu cuVar2 = new cu(context, c2781a2, looper, c4340f, (co) hashMap2.get(c2781a2), c2853f, c4337a);
            r0.f11521a.put((C2778c) entry.getKey(), cuVar);
            if (c4340f.mo3457j()) {
                r0.f11522b.put((C2778c) entry.getKey(), cuVar);
            }
            obj4 = obj6;
            obj3 = obj5;
            obj2 = obj7;
        }
        if (obj2 == null || obj3 != null || obj4 != null) {
            z2 = false;
        }
        r0.f11532l = z2;
        r0.f11524d = C2798d.m8040a();
    }

    /* renamed from: a */
    public final void mo2438a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* renamed from: i */
    public final void mo2445i() {
    }

    /* renamed from: a */
    public final <A extends C2777b, R extends C2814k, T extends C4770a<R, A>> T mo2436a(T t) {
        if (this.f11531k && m14265c((C4770a) t)) {
            return t;
        }
        if (mo2443f()) {
            this.f11525e.f11437e.m8025a(t);
            return ((cu) this.f11521a.get(t.mo3282d())).m7945a((C4770a) t);
        }
        this.f11533m.add(t);
        return t;
    }

    /* renamed from: b */
    public final <A extends C2777b, T extends C4770a<? extends C2814k, A>> T mo2440b(T t) {
        C2778c d = t.mo3282d();
        if (this.f11531k && m14265c((C4770a) t)) {
            return t;
        }
        this.f11525e.f11437e.m8025a(t);
        return ((cu) this.f11521a.get(d)).m7947b((C4770a) t);
    }

    /* renamed from: c */
    private final <T extends C4770a<? extends C2814k, ? extends C2777b>> boolean m14265c(T t) {
        C2778c d = t.mo3282d();
        C4775b a = m14255a(d);
        if (a == null || a.m16827c() != 4) {
            return null;
        }
        t.m16741b(new Status(4, null, this.f11524d.m8055a(((cu) this.f11521a.get(d)).m7951g(), System.identityHashCode(this.f11525e))));
        return true;
    }

    /* renamed from: a */
    public final void mo2437a() {
        this.f11526f.lock();
        try {
            if (!this.f11534n) {
                this.f11534n = true;
                this.f11535o = null;
                this.f11536p = null;
                this.f11537q = null;
                this.f11538r = null;
                this.f11524d.m8065d();
                this.f11524d.m8056a(this.f11521a.values()).mo2583a(new C2887a(this.f11527g), new cx());
                this.f11526f.unlock();
            }
        } finally {
            this.f11526f.unlock();
        }
    }

    /* renamed from: b */
    public final com.google.android.gms.common.C4775b mo2441b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r3.mo2437a();
    L_0x0003:
        r0 = r3.m14288d();
        r1 = 0;
        if (r0 == 0) goto L_0x001f;
    L_0x000a:
        r0 = r3.f11529i;	 Catch:{ InterruptedException -> 0x0010 }
        r0.await();	 Catch:{ InterruptedException -> 0x0010 }
        goto L_0x0003;
    L_0x0010:
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
        r0 = new com.google.android.gms.common.b;
        r2 = 15;
        r0.<init>(r2, r1);
        return r0;
    L_0x001f:
        r0 = r3.mo2443f();
        if (r0 == 0) goto L_0x0028;
    L_0x0025:
        r0 = com.google.android.gms.common.C4775b.f13206a;
        return r0;
    L_0x0028:
        r0 = r3.f11538r;
        if (r0 == 0) goto L_0x002f;
    L_0x002c:
        r0 = r3.f11538r;
        return r0;
    L_0x002f:
        r0 = new com.google.android.gms.common.b;
        r2 = 13;
        r0.<init>(r2, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.cv.b():com.google.android.gms.common.b");
    }

    /* renamed from: c */
    public final void mo2442c() {
        this.f11526f.lock();
        try {
            this.f11534n = false;
            this.f11535o = null;
            this.f11536p = null;
            if (this.f11537q != null) {
                this.f11537q.m14306a();
                this.f11537q = null;
            }
            this.f11538r = null;
            while (!this.f11533m.isEmpty()) {
                C4770a c4770a = (C4770a) this.f11533m.remove();
                c4770a.m14066a(null);
                c4770a.mo2377a();
            }
            this.f11529i.signalAll();
        } finally {
            this.f11526f.unlock();
        }
    }

    /* renamed from: a */
    public final C4775b m14281a(C2781a<?> c2781a) {
        return m14255a(c2781a.m7933c());
    }

    /* renamed from: a */
    private final C4775b m14255a(C2778c<?> c2778c) {
        this.f11526f.lock();
        try {
            cu cuVar = (cu) this.f11521a.get(c2778c);
            if (this.f11535o == null || cuVar == null) {
                this.f11526f.unlock();
                return null;
            }
            C4775b c4775b = (C4775b) this.f11535o.get(cuVar.m7951g());
            return c4775b;
        } finally {
            this.f11526f.unlock();
        }
    }

    /* renamed from: f */
    public final boolean mo2443f() {
        this.f11526f.lock();
        try {
            boolean z = this.f11535o != null && this.f11538r == null;
            this.f11526f.unlock();
            return z;
        } catch (Throwable th) {
            this.f11526f.unlock();
        }
    }

    /* renamed from: d */
    public final boolean m14288d() {
        this.f11526f.lock();
        try {
            boolean z = this.f11535o == null && this.f11534n;
            this.f11526f.unlock();
            return z;
        } catch (Throwable th) {
            this.f11526f.unlock();
        }
    }

    /* renamed from: e */
    private final boolean m14267e() {
        this.f11526f.lock();
        try {
            if (this.f11534n) {
                if (this.f11531k) {
                    for (C2778c a : this.f11522b.keySet()) {
                        C4775b a2 = m14255a(a);
                        if (a2 != null) {
                            if (!a2.m16826b()) {
                            }
                        }
                        this.f11526f.unlock();
                        return false;
                    }
                    this.f11526f.unlock();
                    return true;
                }
            }
            this.f11526f.unlock();
            return false;
        } catch (Throwable th) {
            this.f11526f.unlock();
        }
    }

    /* renamed from: a */
    public final boolean mo2439a(C2807l c2807l) {
        this.f11526f.lock();
        try {
            if (!this.f11534n || m14267e()) {
                this.f11526f.unlock();
                return null;
            }
            this.f11524d.m8065d();
            this.f11537q = new C4351r(this, c2807l);
            this.f11524d.m8056a(this.f11522b.values()).mo2583a(new C2887a(this.f11527g), this.f11537q);
            return true;
        } finally {
            this.f11526f.unlock();
        }
    }

    /* renamed from: h */
    public final void mo2444h() {
        this.f11526f.lock();
        try {
            this.f11524d.m8066e();
            if (this.f11537q != null) {
                this.f11537q.m14306a();
                this.f11537q = null;
            }
            if (this.f11536p == null) {
                this.f11536p = new C3211a(this.f11522b.size());
            }
            C4775b c4775b = new C4775b(4);
            for (cu g : this.f11522b.values()) {
                this.f11536p.put(g.m7951g(), c4775b);
            }
            if (this.f11535o != null) {
                this.f11535o.putAll(this.f11536p);
            }
            this.f11526f.unlock();
        } catch (Throwable th) {
            this.f11526f.unlock();
        }
    }

    /* renamed from: g */
    private final void m14271g() {
        if (this.f11530j == null) {
            this.f11525e.f11435c = Collections.emptySet();
            return;
        }
        Set hashSet = new HashSet(this.f11530j.m8322d());
        Map f = this.f11530j.m8324f();
        for (C2781a c2781a : f.keySet()) {
            C4775b a = m14281a(c2781a);
            if (a != null && a.m16826b()) {
                hashSet.addAll(((C2852b) f.get(c2781a)).f7300a);
            }
        }
        this.f11525e.f11435c = hashSet;
    }

    /* renamed from: j */
    private final void m14274j() {
        while (!this.f11533m.isEmpty()) {
            mo2440b((C4770a) this.f11533m.remove());
        }
        this.f11525e.mo2402a(null);
    }

    /* renamed from: a */
    private final boolean m14259a(cu<?> cuVar, C4775b c4775b) {
        return (c4775b.m16826b() || c4775b.m16825a() || !((Boolean) this.f11523c.get(cuVar.m7949e())).booleanValue() || cuVar.m14252a().m14049k() == null || this.f11528h.mo2458a(c4775b.m16827c()) == null) ? null : true;
    }

    /* renamed from: k */
    private final C4775b m14277k() {
        C4775b c4775b = null;
        C4775b c4775b2 = null;
        int i = 0;
        int i2 = 0;
        for (cu cuVar : this.f11521a.values()) {
            C2781a e = cuVar.m7949e();
            C4775b c4775b3 = (C4775b) this.f11535o.get(cuVar.m7951g());
            if (!c4775b3.m16826b() && (!((Boolean) this.f11523c.get(e)).booleanValue() || c4775b3.m16825a() || this.f11528h.mo2458a(c4775b3.m16827c()))) {
                int a;
                if (c4775b3.m16827c() == 4 && this.f11531k) {
                    a = e.m7931a().m7929a();
                    if (c4775b2 == null || i2 > a) {
                        c4775b2 = c4775b3;
                        i2 = a;
                    }
                } else {
                    a = e.m7931a().m7929a();
                    if (c4775b == null || i > a) {
                        c4775b = c4775b3;
                        i = a;
                    }
                }
            }
        }
        return (c4775b == null || c4775b2 == null || i <= i2) ? c4775b : c4775b2;
    }
}
