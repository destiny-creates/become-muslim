package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.C3211a;
import android.util.Log;
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
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p205d.C4956e;
import com.google.android.gms.p175c.C4764e;
import com.google.android.gms.p175c.C4882a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

final class cq implements bk {
    /* renamed from: a */
    private final Context f11501a;
    /* renamed from: b */
    private final an f11502b;
    /* renamed from: c */
    private final Looper f11503c;
    /* renamed from: d */
    private final aw f11504d;
    /* renamed from: e */
    private final aw f11505e;
    /* renamed from: f */
    private final Map<C2778c<?>, aw> f11506f;
    /* renamed from: g */
    private final Set<C2807l> f11507g = Collections.newSetFromMap(new WeakHashMap());
    /* renamed from: h */
    private final C4340f f11508h;
    /* renamed from: i */
    private Bundle f11509i;
    /* renamed from: j */
    private C4775b f11510j = null;
    /* renamed from: k */
    private C4775b f11511k = null;
    /* renamed from: l */
    private boolean f11512l = false;
    /* renamed from: m */
    private final Lock f11513m;
    /* renamed from: n */
    private int f11514n = 0;

    /* renamed from: a */
    public static cq m14214a(Context context, an anVar, Lock lock, Looper looper, C2830f c2830f, Map<C2778c<?>, C4340f> map, C2853f c2853f, Map<C2781a<?>, Boolean> map2, C4337a<? extends C4764e, C4882a> c4337a, ArrayList<co> arrayList) {
        Map<C2781a<?>, Boolean> map3 = map2;
        Map c3211a = new C3211a();
        Map c3211a2 = new C3211a();
        C4340f c4340f = null;
        for (Entry entry : map.entrySet()) {
            C4340f c4340f2 = (C4340f) entry.getValue();
            if (c4340f2.mo3450c()) {
                c4340f = c4340f2;
            }
            if (c4340f2.mo3457j()) {
                c3211a.put((C2778c) entry.getKey(), c4340f2);
            } else {
                c3211a2.put((C2778c) entry.getKey(), c4340f2);
            }
        }
        C2872v.m8387a(c3211a.isEmpty() ^ 1, (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        Map c3211a3 = new C3211a();
        Map c3211a4 = new C3211a();
        for (C2781a c2781a : map2.keySet()) {
            C2778c c = c2781a.m7933c();
            if (c3211a.containsKey(c)) {
                c3211a3.put(c2781a, (Boolean) map3.get(c2781a));
            } else if (c3211a2.containsKey(c)) {
                c3211a4.put(c2781a, (Boolean) map3.get(c2781a));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList;
        int size = arrayList4.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList4.get(i);
            i++;
            co coVar = (co) obj;
            if (c3211a3.containsKey(coVar.f11498a)) {
                arrayList2.add(coVar);
            } else if (c3211a4.containsKey(coVar.f11498a)) {
                arrayList3.add(coVar);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new cq(context, anVar, lock, looper, c2830f, c3211a, c3211a2, c2853f, c4337a, c4340f, arrayList2, arrayList3, c3211a3, c3211a4);
    }

    private cq(Context context, an anVar, Lock lock, Looper looper, C2830f c2830f, Map<C2778c<?>, C4340f> map, Map<C2778c<?>, C4340f> map2, C2853f c2853f, C4337a<? extends C4764e, C4882a> c4337a, C4340f c4340f, ArrayList<co> arrayList, ArrayList<co> arrayList2, Map<C2781a<?>, Boolean> map3, Map<C2781a<?>, Boolean> map4) {
        this.f11501a = context;
        this.f11502b = anVar;
        this.f11513m = lock;
        this.f11503c = looper;
        this.f11508h = c4340f;
        Context context2 = context;
        Lock lock2 = lock;
        Looper looper2 = looper;
        C2830f c2830f2 = c2830f;
        aw awVar = r3;
        aw awVar2 = new aw(context2, this.f11502b, lock2, looper2, c2830f2, map2, null, map4, null, arrayList2, new cs());
        this.f11504d = awVar;
        this.f11505e = new aw(context2, this.f11502b, lock2, looper2, c2830f2, map, c2853f, map3, c4337a, arrayList, new ct());
        Map c3211a = new C3211a();
        for (C2778c put : map2.keySet()) {
            c3211a.put(put, r0.f11504d);
        }
        for (C2778c put2 : map.keySet()) {
            c3211a.put(put2, r0.f11505e);
        }
        r0.f11506f = Collections.unmodifiableMap(c3211a);
    }

    /* renamed from: a */
    public final <A extends C2777b, R extends C2814k, T extends C4770a<R, A>> T mo2436a(T t) {
        if (!m14226c((C4770a) t)) {
            return this.f11504d.mo2436a((C4770a) t);
        }
        if (!m14233j()) {
            return this.f11505e.mo2436a((C4770a) t);
        }
        t.m16741b(new Status(4, null, m14234k()));
        return t;
    }

    /* renamed from: b */
    public final <A extends C2777b, T extends C4770a<? extends C2814k, A>> T mo2440b(T t) {
        if (!m14226c((C4770a) t)) {
            return this.f11504d.mo2440b((C4770a) t);
        }
        if (!m14233j()) {
            return this.f11505e.mo2440b((C4770a) t);
        }
        t.m16741b(new Status(4, null, m14234k()));
        return t;
    }

    /* renamed from: a */
    public final void mo2437a() {
        this.f11514n = 2;
        this.f11512l = false;
        this.f11511k = null;
        this.f11510j = null;
        this.f11504d.mo2437a();
        this.f11505e.mo2437a();
    }

    /* renamed from: b */
    public final C4775b mo2441b() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: c */
    public final void mo2442c() {
        this.f11511k = null;
        this.f11510j = null;
        this.f11514n = 0;
        this.f11504d.mo2442c();
        this.f11505e.mo2442c();
        m14232g();
    }

    /* renamed from: f */
    public final boolean mo2443f() {
        this.f11513m.lock();
        try {
            boolean z = true;
            if (this.f11504d.mo2443f()) {
                if (!(this.f11505e.mo2443f() || m14233j())) {
                    if (this.f11514n == 1) {
                    }
                }
                this.f11513m.unlock();
                return z;
            }
            z = false;
            this.f11513m.unlock();
            return z;
        } catch (Throwable th) {
            this.f11513m.unlock();
        }
    }

    /* renamed from: d */
    public final boolean m14242d() {
        this.f11513m.lock();
        try {
            boolean z = this.f11514n == 2;
            this.f11513m.unlock();
            return z;
        } catch (Throwable th) {
            this.f11513m.unlock();
        }
    }

    /* renamed from: a */
    public final boolean mo2439a(C2807l c2807l) {
        this.f11513m.lock();
        boolean z;
        try {
            if ((m14242d() || mo2443f()) && !this.f11505e.mo2443f()) {
                this.f11507g.add(c2807l);
                z = true;
                if (this.f11514n == null) {
                    this.f11514n = 1;
                }
                this.f11511k = null;
                this.f11505e.mo2437a();
                return z;
            }
            this.f11513m.unlock();
            return null;
        } finally {
            z = this.f11513m;
            z.unlock();
        }
    }

    /* renamed from: i */
    public final void mo2445i() {
        this.f11504d.mo2445i();
        this.f11505e.mo2445i();
    }

    /* renamed from: h */
    public final void mo2444h() {
        this.f11513m.lock();
        try {
            boolean d = m14242d();
            this.f11505e.mo2442c();
            this.f11511k = new C4775b(4);
            if (d) {
                new C4956e(this.f11503c).post(new cr(this));
            } else {
                m14232g();
            }
            this.f11513m.unlock();
        } catch (Throwable th) {
            this.f11513m.unlock();
        }
    }

    /* renamed from: e */
    private final void m14230e() {
        if (m14225b(this.f11510j)) {
            if (!m14225b(this.f11511k)) {
                if (!m14233j()) {
                    if (this.f11511k != null) {
                        if (this.f11514n == 1) {
                            m14232g();
                            return;
                        }
                        m14221a(this.f11511k);
                        this.f11504d.mo2442c();
                        return;
                    }
                }
            }
            switch (this.f11514n) {
                case 1:
                    break;
                case 2:
                    this.f11502b.mo2402a(this.f11509i);
                    break;
                default:
                    Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                    break;
            }
            m14232g();
            this.f11514n = 0;
        } else if (this.f11510j != null && m14225b(this.f11511k)) {
            this.f11505e.mo2442c();
            m14221a(this.f11510j);
        } else if (!(this.f11510j == null || this.f11511k == null)) {
            C4775b c4775b = this.f11510j;
            if (this.f11505e.f13165c < this.f11504d.f13165c) {
                c4775b = this.f11511k;
            }
            m14221a(c4775b);
        }
    }

    /* renamed from: a */
    private final void m14221a(C4775b c4775b) {
        switch (this.f11514n) {
            case 1:
                break;
            case 2:
                this.f11502b.mo2405a(c4775b);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m14232g();
        this.f11514n = null;
    }

    /* renamed from: g */
    private final void m14232g() {
        for (C2807l v : this.f11507g) {
            v.mo3270v();
        }
        this.f11507g.clear();
    }

    /* renamed from: a */
    private final void m14217a(int i, boolean z) {
        this.f11502b.mo2401a(i, z);
        this.f11511k = null;
        this.f11510j = null;
    }

    /* renamed from: j */
    private final boolean m14233j() {
        return this.f11511k != null && this.f11511k.m16827c() == 4;
    }

    /* renamed from: c */
    private final boolean m14226c(C4770a<? extends C2814k, ? extends C2777b> c4770a) {
        c4770a = c4770a.mo3282d();
        C2872v.m8391b(this.f11506f.containsKey(c4770a), "GoogleApiClient is not configured to use the API required for this call.");
        return ((aw) this.f11506f.get(c4770a)).equals(this.f11505e);
    }

    /* renamed from: k */
    private final PendingIntent m14234k() {
        if (this.f11508h == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f11501a, System.identityHashCode(this.f11502b), this.f11508h.mo3451d(), 134217728);
    }

    /* renamed from: a */
    private final void m14218a(Bundle bundle) {
        if (this.f11509i == null) {
            this.f11509i = bundle;
            return;
        }
        if (bundle != null) {
            this.f11509i.putAll(bundle);
        }
    }

    /* renamed from: b */
    private static boolean m14225b(C4775b c4775b) {
        return (c4775b == null || c4775b.m16826b() == null) ? null : true;
    }

    /* renamed from: a */
    public final void mo2438a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.f11505e.mo2438a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.f11504d.mo2438a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }
}
