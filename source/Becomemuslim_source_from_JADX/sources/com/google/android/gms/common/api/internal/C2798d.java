package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.C0448b;
import android.support.v4.util.C3211a;
import android.util.Log;
import com.amplitude.api.Constants;
import com.google.android.gms.common.C4361e;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.C4776d;
import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2781a.C2779d;
import com.google.android.gms.common.api.C2781a.C4340f;
import com.google.android.gms.common.api.C2787e;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.C2818p;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C2796c.C4770a;
import com.google.android.gms.common.api.internal.C2804h.C2802a;
import com.google.android.gms.common.internal.C2850d.C2846c;
import com.google.android.gms.common.internal.C2861n;
import com.google.android.gms.common.internal.C2862o;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.util.C2892b;
import com.google.android.gms.common.util.C2904o;
import com.google.android.gms.internal.p205d.C4956e;
import com.google.android.gms.p175c.C4764e;
import com.google.android.gms.p186f.C2954g;
import com.google.android.gms.p186f.C2955h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.common.api.internal.d */
public class C2798d implements Callback {
    /* renamed from: a */
    public static final Status f7175a = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* renamed from: b */
    private static final Status f7176b = new Status(4, "The user must be signed in to make this API call.");
    /* renamed from: f */
    private static final Object f7177f = new Object();
    /* renamed from: g */
    private static C2798d f7178g;
    /* renamed from: c */
    private long f7179c = 5000;
    /* renamed from: d */
    private long f7180d = 120000;
    /* renamed from: e */
    private long f7181e = 10000;
    /* renamed from: h */
    private final Context f7182h;
    /* renamed from: i */
    private final C4361e f7183i;
    /* renamed from: j */
    private final C2861n f7184j;
    /* renamed from: k */
    private final AtomicInteger f7185k = new AtomicInteger(1);
    /* renamed from: l */
    private final AtomicInteger f7186l = new AtomicInteger(0);
    /* renamed from: m */
    private final Map<cg<?>, C4771a<?>> f7187m = new ConcurrentHashMap(5, 0.75f, 1);
    /* renamed from: n */
    private C4774v f7188n = null;
    /* renamed from: o */
    private final Set<cg<?>> f7189o = new C0448b();
    /* renamed from: p */
    private final Set<cg<?>> f7190p = new C0448b();
    /* renamed from: q */
    private final Handler f7191q;

    /* renamed from: com.google.android.gms.common.api.internal.d$b */
    private static class C2797b {
        /* renamed from: a */
        private final cg<?> f7173a;
        /* renamed from: b */
        private final C4776d f7174b;

        private C2797b(cg<?> cgVar, C4776d c4776d) {
            this.f7173a = cgVar;
            this.f7174b = c4776d;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof C2797b)) {
                return false;
            }
            C2797b c2797b = (C2797b) obj;
            if (!C2868t.m8374a(this.f7173a, c2797b.f7173a) || C2868t.m8374a(this.f7174b, c2797b.f7174b) == null) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return C2868t.m8372a(this.f7173a, this.f7174b);
        }

        public final String toString() {
            return C2868t.m8373a((Object) this).m8371a("key", this.f7173a).m8371a("feature", this.f7174b).toString();
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.d$c */
    private class C4349c implements bu, C2846c {
        /* renamed from: a */
        final /* synthetic */ C2798d f11544a;
        /* renamed from: b */
        private final C4340f f11545b;
        /* renamed from: c */
        private final cg<?> f11546c;
        /* renamed from: d */
        private C2862o f11547d = null;
        /* renamed from: e */
        private Set<Scope> f11548e = null;
        /* renamed from: f */
        private boolean f11549f = null;

        public C4349c(C2798d c2798d, C4340f c4340f, cg<?> cgVar) {
            this.f11544a = c2798d;
            this.f11545b = c4340f;
            this.f11546c = cgVar;
        }

        /* renamed from: a */
        public final void mo2393a(C4775b c4775b) {
            this.f11544a.f7191q.post(new bg(this, c4775b));
        }

        /* renamed from: b */
        public final void mo2452b(C4775b c4775b) {
            ((C4771a) this.f11544a.f7187m.get(this.f11546c)).m16788a(c4775b);
        }

        /* renamed from: a */
        public final void mo2451a(C2862o c2862o, Set<Scope> set) {
            if (c2862o != null) {
                if (set != null) {
                    this.f11547d = c2862o;
                    this.f11548e = set;
                    m14299a();
                    return;
                }
            }
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            mo2452b(new C4775b(4));
        }

        /* renamed from: a */
        private final void m14299a() {
            if (this.f11549f && this.f11547d != null) {
                this.f11545b.m14040a(this.f11547d, this.f11548e);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.d$a */
    public class C4771a<O extends C2779d> implements C2775b, C2776c, cp {
        /* renamed from: a */
        final /* synthetic */ C2798d f13186a;
        /* renamed from: b */
        private final Queue<ar> f13187b = new LinkedList();
        /* renamed from: c */
        private final C4340f f13188c;
        /* renamed from: d */
        private final C2777b f13189d;
        /* renamed from: e */
        private final cg<O> f13190e;
        /* renamed from: f */
        private final C2812s f13191f;
        /* renamed from: g */
        private final Set<ci> f13192g = new HashSet();
        /* renamed from: h */
        private final Map<C2802a<?>, bn> f13193h = new HashMap();
        /* renamed from: i */
        private final int f13194i;
        /* renamed from: j */
        private final br f13195j;
        /* renamed from: k */
        private boolean f13196k;
        /* renamed from: l */
        private final List<C2797b> f13197l = new ArrayList();
        /* renamed from: m */
        private C4775b f13198m = null;

        public C4771a(C2798d c2798d, C2787e<O> c2787e) {
            this.f13186a = c2798d;
            this.f13188c = c2787e.mo2446a(c2798d.f7191q.getLooper(), this);
            if (this.f13188c instanceof ab) {
                this.f13189d = ((ab) this.f13188c).mo3452e();
            } else {
                this.f13189d = this.f13188c;
            }
            this.f13190e = c2787e.m7951g();
            this.f13191f = new C2812s();
            this.f13194i = c2787e.m7952h();
            if (this.f13188c.mo3457j()) {
                this.f13195j = c2787e.mo2447a(c2798d.f7182h, c2798d.f7191q);
            } else {
                this.f13195j = null;
            }
        }

        public final void onConnected(Bundle bundle) {
            if (Looper.myLooper() == this.f13186a.f7191q.getLooper()) {
                m16779n();
            } else {
                this.f13186a.f7191q.post(new bb(this));
            }
        }

        /* renamed from: n */
        private final void m16779n() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r4 = this;
            r4.m16792d();
            r0 = com.google.android.gms.common.C4775b.f13206a;
            r4.m16778c(r0);
            r4.m16782q();
            r0 = r4.f13193h;
            r0 = r0.values();
            r0 = r0.iterator();
        L_0x0015:
            r1 = r0.hasNext();
            if (r1 == 0) goto L_0x004b;
        L_0x001b:
            r1 = r0.next();
            r1 = (com.google.android.gms.common.api.internal.bn) r1;
            r2 = r1.f7143a;
            r2 = r2.m8089b();
            r2 = r4.m16765a(r2);
            if (r2 == 0) goto L_0x0031;
        L_0x002d:
            r0.remove();
            goto L_0x0015;
        L_0x0031:
            r1 = r1.f7143a;	 Catch:{ DeadObjectException -> 0x0042, RemoteException -> 0x003e }
            r2 = r4.f13189d;	 Catch:{ DeadObjectException -> 0x0042, RemoteException -> 0x003e }
            r3 = new com.google.android.gms.f.h;	 Catch:{ DeadObjectException -> 0x0042, RemoteException -> 0x003e }
            r3.<init>();	 Catch:{ DeadObjectException -> 0x0042, RemoteException -> 0x003e }
            r1.m8088a(r2, r3);	 Catch:{ DeadObjectException -> 0x0042, RemoteException -> 0x003e }
            goto L_0x0015;
        L_0x003e:
            r0.remove();
            goto L_0x0015;
        L_0x0042:
            r0 = 1;
            r4.onConnectionSuspended(r0);
            r0 = r4.f13188c;
            r0.m14045g();
        L_0x004b:
            r4.m16781p();
            r4.m16783r();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.d.a.n():void");
        }

        public final void onConnectionSuspended(int i) {
            if (Looper.myLooper() == this.f13186a.f7191q.getLooper()) {
                m16780o();
            } else {
                this.f13186a.f7191q.post(new bc(this));
            }
        }

        /* renamed from: o */
        private final void m16780o() {
            m16792d();
            this.f13196k = true;
            this.f13191f.m8105c();
            this.f13186a.f7191q.sendMessageDelayed(Message.obtain(this.f13186a.f7191q, 9, this.f13190e), this.f13186a.f7179c);
            this.f13186a.f7191q.sendMessageDelayed(Message.obtain(this.f13186a.f7191q, 11, this.f13190e), this.f13186a.f7180d);
            this.f13186a.f7184j.m8363a();
        }

        /* renamed from: a */
        public final void m16788a(C4775b c4775b) {
            C2872v.m8385a(this.f13186a.f7191q);
            this.f13188c.m14045g();
            onConnectionFailed(c4775b);
        }

        /* renamed from: b */
        private final boolean m16775b(C4775b c4775b) {
            synchronized (C2798d.f7177f) {
                if (this.f13186a.f7188n == null || !this.f13186a.f7189o.contains(this.f13190e)) {
                    return null;
                }
                this.f13186a.f7188n.m14206b(c4775b, this.f13194i);
                return true;
            }
        }

        /* renamed from: a */
        public final void mo3279a(C4775b c4775b, C2781a<?> c2781a, boolean z) {
            if (Looper.myLooper() == this.f13186a.f7191q.getLooper()) {
                onConnectionFailed(c4775b);
            } else {
                this.f13186a.f7191q.post(new bd(this, c4775b));
            }
        }

        public final void onConnectionFailed(C4775b c4775b) {
            C2872v.m8385a(this.f13186a.f7191q);
            if (this.f13195j != null) {
                this.f13195j.m17497b();
            }
            m16792d();
            this.f13186a.f7184j.m8363a();
            m16778c(c4775b);
            if (c4775b.m16827c() == 4) {
                m16785a(C2798d.f7176b);
            } else if (this.f13187b.isEmpty()) {
                this.f13198m = c4775b;
            } else {
                if (!(m16775b(c4775b) || this.f13186a.m8061a(c4775b, this.f13194i))) {
                    if (c4775b.m16827c() == 18) {
                        this.f13196k = true;
                    }
                    if (this.f13196k != null) {
                        this.f13186a.f7191q.sendMessageDelayed(Message.obtain(this.f13186a.f7191q, 9, this.f13190e), this.f13186a.f7179c);
                        return;
                    }
                    String a = this.f13190e.m8031a();
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(a).length() + 38);
                    stringBuilder.append("API: ");
                    stringBuilder.append(a);
                    stringBuilder.append(" is not available on this device.");
                    m16785a(new Status(17, stringBuilder.toString()));
                }
            }
        }

        /* renamed from: p */
        private final void m16781p() {
            ArrayList arrayList = new ArrayList(this.f13187b);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ar arVar = (ar) obj;
                if (!this.f13188c.m14046h()) {
                    return;
                }
                if (m16774b(arVar)) {
                    this.f13187b.remove(arVar);
                }
            }
        }

        /* renamed from: a */
        public final void m16786a(ar arVar) {
            C2872v.m8385a(this.f13186a.f7191q);
            if (!this.f13188c.m14046h()) {
                this.f13187b.add(arVar);
                if (this.f13198m == null || this.f13198m.m16825a() == null) {
                    m16797i();
                } else {
                    onConnectionFailed(this.f13198m);
                }
            } else if (m16774b(arVar)) {
                m16783r();
            } else {
                this.f13187b.add(arVar);
            }
        }

        /* renamed from: a */
        public final void m16784a() {
            C2872v.m8385a(this.f13186a.f7191q);
            m16785a(C2798d.f7175a);
            this.f13191f.m8104b();
            for (C2802a cfVar : (C2802a[]) this.f13193h.keySet().toArray(new C2802a[this.f13193h.size()])) {
                m16786a(new cf(cfVar, new C2955h()));
            }
            m16778c(new C4775b(4));
            if (this.f13188c.m14046h()) {
                this.f13188c.m14039a(new be(this));
            }
        }

        /* renamed from: b */
        public final C4340f m16790b() {
            return this.f13188c;
        }

        /* renamed from: c */
        public final Map<C2802a<?>, bn> m16791c() {
            return this.f13193h;
        }

        /* renamed from: d */
        public final void m16792d() {
            C2872v.m8385a(this.f13186a.f7191q);
            this.f13198m = null;
        }

        /* renamed from: e */
        public final C4775b m16793e() {
            C2872v.m8385a(this.f13186a.f7191q);
            return this.f13198m;
        }

        /* renamed from: b */
        private final boolean m16774b(ar arVar) {
            if (arVar instanceof bo) {
                bo boVar = (bo) arVar;
                C4776d a = m16765a(boVar.mo3283b(this));
                if (a == null) {
                    m16777c(arVar);
                    return true;
                }
                if (boVar.mo3284c(this) != null) {
                    arVar = new C2797b(this.f13190e, a);
                    int indexOf = this.f13197l.indexOf(arVar);
                    if (indexOf >= 0) {
                        C2797b c2797b = (C2797b) this.f13197l.get(indexOf);
                        this.f13186a.f7191q.removeMessages(15, c2797b);
                        this.f13186a.f7191q.sendMessageDelayed(Message.obtain(this.f13186a.f7191q, 15, c2797b), this.f13186a.f7179c);
                    } else {
                        this.f13197l.add(arVar);
                        this.f13186a.f7191q.sendMessageDelayed(Message.obtain(this.f13186a.f7191q, 15, arVar), this.f13186a.f7179c);
                        this.f13186a.f7191q.sendMessageDelayed(Message.obtain(this.f13186a.f7191q, 16, arVar), this.f13186a.f7180d);
                        C4775b c4775b = new C4775b(2, null);
                        if (!m16775b(c4775b)) {
                            this.f13186a.m8061a(c4775b, this.f13194i);
                        }
                    }
                } else {
                    boVar.mo2430a(new C2818p(a));
                }
                return null;
            }
            m16777c(arVar);
            return true;
        }

        /* renamed from: c */
        private final void m16777c(com.google.android.gms.common.api.internal.ar r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.f13191f;
            r1 = r2.m16799k();
            r3.mo2429a(r0, r1);
            r3.mo2428a(r2);	 Catch:{ DeadObjectException -> 0x000d }
            return;
        L_0x000d:
            r3 = 1;
            r2.onConnectionSuspended(r3);
            r3 = r2.f13188c;
            r3.m14045g();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.d.a.c(com.google.android.gms.common.api.internal.ar):void");
        }

        /* renamed from: a */
        public final void m16785a(Status status) {
            C2872v.m8385a(this.f13186a.f7191q);
            for (ar a : this.f13187b) {
                a.mo2427a(status);
            }
            this.f13187b.clear();
        }

        /* renamed from: f */
        public final void m16794f() {
            C2872v.m8385a(this.f13186a.f7191q);
            if (this.f13196k) {
                m16797i();
            }
        }

        /* renamed from: q */
        private final void m16782q() {
            if (this.f13196k) {
                this.f13186a.f7191q.removeMessages(11, this.f13190e);
                this.f13186a.f7191q.removeMessages(9, this.f13190e);
                this.f13196k = false;
            }
        }

        /* renamed from: g */
        public final void m16795g() {
            C2872v.m8385a(this.f13186a.f7191q);
            if (this.f13196k) {
                Status status;
                m16782q();
                if (this.f13186a.f7183i.mo2455a(this.f13186a.f7182h) == 18) {
                    status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                } else {
                    status = new Status(8, "API failed to connect while resuming due to an unknown error.");
                }
                m16785a(status);
                this.f13188c.m14045g();
            }
        }

        /* renamed from: r */
        private final void m16783r() {
            this.f13186a.f7191q.removeMessages(12, this.f13190e);
            this.f13186a.f7191q.sendMessageDelayed(this.f13186a.f7191q.obtainMessage(12, this.f13190e), this.f13186a.f7181e);
        }

        /* renamed from: h */
        public final boolean m16796h() {
            return m16770a(true);
        }

        /* renamed from: a */
        private final boolean m16770a(boolean z) {
            C2872v.m8385a(this.f13186a.f7191q);
            if (!this.f13188c.m14046h() || this.f13193h.size() != 0) {
                return false;
            }
            if (this.f13191f.m8103a()) {
                if (z) {
                    m16783r();
                }
                return false;
            }
            this.f13188c.m14045g();
            return true;
        }

        /* renamed from: i */
        public final void m16797i() {
            C2872v.m8385a(this.f13186a.f7191q);
            if (!this.f13188c.m14046h()) {
                if (!this.f13188c.m14047i()) {
                    int a = this.f13186a.f7184j.m8362a(this.f13186a.f7182h, this.f13188c);
                    if (a != 0) {
                        onConnectionFailed(new C4775b(a, null));
                        return;
                    }
                    C2846c c4349c = new C4349c(this.f13186a, this.f13188c, this.f13190e);
                    if (this.f13188c.mo3457j()) {
                        this.f13195j.m17496a((bu) c4349c);
                    }
                    this.f13188c.m14038a(c4349c);
                }
            }
        }

        /* renamed from: a */
        public final void m16787a(ci ciVar) {
            C2872v.m8385a(this.f13186a.f7191q);
            this.f13192g.add(ciVar);
        }

        /* renamed from: c */
        private final void m16778c(C4775b c4775b) {
            for (ci ciVar : this.f13192g) {
                String str = null;
                if (C2868t.m8374a(c4775b, C4775b.f13206a)) {
                    str = this.f13188c.m14051m();
                }
                ciVar.m8033a(this.f13190e, c4775b, str);
            }
            this.f13192g.clear();
        }

        /* renamed from: j */
        final boolean m16798j() {
            return this.f13188c.m14046h();
        }

        /* renamed from: k */
        public final boolean m16799k() {
            return this.f13188c.mo3457j();
        }

        /* renamed from: l */
        public final int m16800l() {
            return this.f13194i;
        }

        /* renamed from: m */
        final C4764e m16801m() {
            return this.f13195j == null ? null : this.f13195j.m17494a();
        }

        /* renamed from: a */
        private final C4776d m16765a(C4776d[] c4776dArr) {
            if (c4776dArr != null) {
                if (c4776dArr.length != 0) {
                    C4776d[] n = this.f13188c.m14052n();
                    int i = 0;
                    if (n == null) {
                        n = new C4776d[0];
                    }
                    Map c3211a = new C3211a(n.length);
                    for (C4776d c4776d : n) {
                        c3211a.put(c4776d.m16830a(), Long.valueOf(c4776d.m16831b()));
                    }
                    int length = c4776dArr.length;
                    while (i < length) {
                        C4776d c4776d2 = c4776dArr[i];
                        if (c3211a.containsKey(c4776d2.m16830a())) {
                            if (((Long) c3211a.get(c4776d2.m16830a())).longValue() >= c4776d2.m16831b()) {
                                i++;
                            }
                        }
                        return c4776d2;
                    }
                    return null;
                }
            }
            return null;
        }

        /* renamed from: a */
        private final void m16768a(C2797b c2797b) {
            if (this.f13197l.contains(c2797b) != null && this.f13196k == null) {
                if (this.f13188c.m14046h() == null) {
                    m16797i();
                    return;
                }
                m16781p();
            }
        }

        /* renamed from: b */
        private final void m16773b(C2797b c2797b) {
            if (this.f13197l.remove(c2797b)) {
                this.f13186a.f7191q.removeMessages(15, c2797b);
                this.f13186a.f7191q.removeMessages(16, c2797b);
                Object b = c2797b.f7174b;
                ArrayList arrayList = new ArrayList(this.f13187b.size());
                for (ar arVar : this.f13187b) {
                    if (arVar instanceof bo) {
                        Object[] b2 = ((bo) arVar).mo3283b(this);
                        if (b2 != null && C2892b.m8418a(b2, b)) {
                            arrayList.add(arVar);
                        }
                    }
                }
                arrayList = arrayList;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ar arVar2 = (ar) obj;
                    this.f13187b.remove(arVar2);
                    arVar2.mo2430a(new C2818p(b));
                }
            }
        }
    }

    /* renamed from: a */
    public static C2798d m8041a(Context context) {
        synchronized (f7177f) {
            if (f7178g == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                f7178g = new C2798d(context.getApplicationContext(), handlerThread.getLooper(), C4361e.m14332a());
            }
            context = f7178g;
        }
        return context;
    }

    /* renamed from: a */
    public static C2798d m8040a() {
        C2798d c2798d;
        synchronized (f7177f) {
            C2872v.m8381a(f7178g, (Object) "Must guarantee manager is non-null before using getInstance");
            c2798d = f7178g;
        }
        return c2798d;
    }

    /* renamed from: b */
    public static void m8043b() {
        synchronized (f7177f) {
            if (f7178g != null) {
                C2798d c2798d = f7178g;
                c2798d.f7186l.incrementAndGet();
                c2798d.f7191q.sendMessageAtFrontOfQueue(c2798d.f7191q.obtainMessage(10));
            }
        }
    }

    private C2798d(Context context, Looper looper, C4361e c4361e) {
        this.f7182h = context;
        this.f7191q = new C4956e(looper, this);
        this.f7183i = c4361e;
        this.f7184j = new C2861n(c4361e);
        this.f7191q.sendMessage(this.f7191q.obtainMessage(6));
    }

    /* renamed from: c */
    public final int m8064c() {
        return this.f7185k.getAndIncrement();
    }

    /* renamed from: a */
    public final void m8057a(C2787e<?> c2787e) {
        this.f7191q.sendMessage(this.f7191q.obtainMessage(7, c2787e));
    }

    /* renamed from: b */
    private final void m8044b(C2787e<?> c2787e) {
        cg g = c2787e.m7951g();
        C4771a c4771a = (C4771a) this.f7187m.get(g);
        if (c4771a == null) {
            c4771a = new C4771a(this, c2787e);
            this.f7187m.put(g, c4771a);
        }
        if (c4771a.m16799k() != null) {
            this.f7190p.add(g);
        }
        c4771a.m16797i();
    }

    /* renamed from: a */
    public final void m8060a(C4774v c4774v) {
        synchronized (f7177f) {
            if (this.f7188n != c4774v) {
                this.f7188n = c4774v;
                this.f7189o.clear();
            }
            this.f7189o.addAll(c4774v.m16823g());
        }
    }

    /* renamed from: b */
    final void m8062b(C4774v c4774v) {
        synchronized (f7177f) {
            if (this.f7188n == c4774v) {
                this.f7188n = null;
                this.f7189o.clear();
            }
        }
    }

    /* renamed from: a */
    public final C2954g<Map<cg<?>, String>> m8056a(Iterable<? extends C2787e<?>> iterable) {
        ci ciVar = new ci(iterable);
        this.f7191q.sendMessage(this.f7191q.obtainMessage(2, ciVar));
        return ciVar.m8034b();
    }

    /* renamed from: d */
    public final void m8065d() {
        this.f7191q.sendMessage(this.f7191q.obtainMessage(3));
    }

    /* renamed from: e */
    final void m8066e() {
        this.f7186l.incrementAndGet();
        this.f7191q.sendMessage(this.f7191q.obtainMessage(10));
    }

    /* renamed from: a */
    public final <O extends C2779d> void m8058a(C2787e<O> c2787e, int i, C4770a<? extends C2814k, C2777b> c4770a) {
        this.f7191q.sendMessage(this.f7191q.obtainMessage(4, new bm(new cd(i, c4770a), this.f7186l.get(), c2787e)));
    }

    /* renamed from: a */
    public final <O extends C2779d, ResultT> void m8059a(C2787e<O> c2787e, int i, C2809o<C2777b, ResultT> c2809o, C2955h<ResultT> c2955h, C2808m c2808m) {
        this.f7191q.sendMessage(this.f7191q.obtainMessage(4, new bm(new ce(i, c2809o, c2955h, c2808m), this.f7186l.get(), c2787e)));
    }

    public boolean handleMessage(Message message) {
        int i = message.what;
        long j = Constants.MIN_TIME_BETWEEN_SESSIONS_MILLIS;
        C4771a c4771a;
        C4771a c4771a2;
        cg a;
        C2797b c2797b;
        switch (i) {
            case 1:
                if (((Boolean) message.obj).booleanValue() != null) {
                    j = 10000;
                }
                this.f7181e = j;
                this.f7191q.removeMessages(12);
                for (cg obtainMessage : this.f7187m.keySet()) {
                    this.f7191q.sendMessageDelayed(this.f7191q.obtainMessage(12, obtainMessage), this.f7181e);
                }
                break;
            case 2:
                ci ciVar = (ci) message.obj;
                for (cg obtainMessage2 : ciVar.m8032a()) {
                    c4771a = (C4771a) this.f7187m.get(obtainMessage2);
                    if (c4771a == null) {
                        ciVar.m8033a(obtainMessage2, new C4775b(13), null);
                        break;
                    } else if (c4771a.m16798j()) {
                        ciVar.m8033a(obtainMessage2, C4775b.f13206a, c4771a.m16790b().m14051m());
                    } else if (c4771a.m16793e() != null) {
                        ciVar.m8033a(obtainMessage2, c4771a.m16793e(), null);
                    } else {
                        c4771a.m16787a(ciVar);
                        c4771a.m16797i();
                    }
                }
                break;
            case 3:
                for (C4771a c4771a22 : this.f7187m.values()) {
                    c4771a22.m16792d();
                    c4771a22.m16797i();
                }
                break;
            case 4:
            case 8:
            case 13:
                bm bmVar = (bm) message.obj;
                c4771a22 = (C4771a) this.f7187m.get(bmVar.f7142c.m7951g());
                if (c4771a22 == null) {
                    m8044b(bmVar.f7142c);
                    c4771a22 = (C4771a) this.f7187m.get(bmVar.f7142c.m7951g());
                }
                if (c4771a22.m16799k() && this.f7186l.get() != bmVar.f7141b) {
                    bmVar.f7140a.mo2427a(f7175a);
                    c4771a22.m16784a();
                    break;
                }
                c4771a22.m16786a(bmVar.f7140a);
                break;
                break;
            case 5:
                StringBuilder stringBuilder;
                String b;
                StringBuilder stringBuilder2;
                i = message.arg1;
                C4775b c4775b = (C4775b) message.obj;
                for (C4771a c4771a3 : this.f7187m.values()) {
                    if (c4771a3.m16800l() == i) {
                        if (c4771a3 != null) {
                            stringBuilder = new StringBuilder(76);
                            stringBuilder.append("Could not find API instance ");
                            stringBuilder.append(i);
                            stringBuilder.append(" while trying to fail enqueued calls.");
                            Log.wtf("GoogleApiManager", stringBuilder.toString(), new Exception());
                            break;
                        }
                        b = this.f7183i.mo2460b(c4775b.m16827c());
                        message = c4775b.m16829e();
                        stringBuilder2 = new StringBuilder((String.valueOf(b).length() + 69) + String.valueOf(message).length());
                        stringBuilder2.append("Error resolution was canceled by the user, original error message: ");
                        stringBuilder2.append(b);
                        stringBuilder2.append(": ");
                        stringBuilder2.append(message);
                        c4771a3.m16785a(new Status(17, stringBuilder2.toString()));
                        break;
                    }
                }
                c4771a3 = null;
                if (c4771a3 != null) {
                    stringBuilder = new StringBuilder(76);
                    stringBuilder.append("Could not find API instance ");
                    stringBuilder.append(i);
                    stringBuilder.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", stringBuilder.toString(), new Exception());
                } else {
                    b = this.f7183i.mo2460b(c4775b.m16827c());
                    message = c4775b.m16829e();
                    stringBuilder2 = new StringBuilder((String.valueOf(b).length() + 69) + String.valueOf(message).length());
                    stringBuilder2.append("Error resolution was canceled by the user, original error message: ");
                    stringBuilder2.append(b);
                    stringBuilder2.append(": ");
                    stringBuilder2.append(message);
                    c4771a3.m16785a(new Status(17, stringBuilder2.toString()));
                }
            case 6:
                if (!(C2904o.m8456b() == null || (this.f7182h.getApplicationContext() instanceof Application) == null)) {
                    C2794b.m8000a((Application) this.f7182h.getApplicationContext());
                    C2794b.m7999a().m8002a(new ba(this));
                    if (C2794b.m7999a().m8003a(true) == null) {
                        this.f7181e = Constants.MIN_TIME_BETWEEN_SESSIONS_MILLIS;
                        break;
                    }
                }
                break;
            case 7:
                m8044b((C2787e) message.obj);
                break;
            case 9:
                if (this.f7187m.containsKey(message.obj)) {
                    ((C4771a) this.f7187m.get(message.obj)).m16794f();
                    break;
                }
                break;
            case 10:
                for (cg a2 : this.f7190p) {
                    ((C4771a) this.f7187m.remove(a2)).m16784a();
                }
                this.f7190p.clear();
                break;
            case 11:
                if (this.f7187m.containsKey(message.obj)) {
                    ((C4771a) this.f7187m.get(message.obj)).m16795g();
                    break;
                }
                break;
            case 12:
                if (this.f7187m.containsKey(message.obj)) {
                    ((C4771a) this.f7187m.get(message.obj)).m16796h();
                    break;
                }
                break;
            case 14:
                C2813w c2813w = (C2813w) message.obj;
                a2 = c2813w.m8106a();
                if (!this.f7187m.containsKey(a2)) {
                    c2813w.m8107b().m8785a(Boolean.valueOf(false));
                    break;
                }
                c2813w.m8107b().m8785a(Boolean.valueOf(((C4771a) this.f7187m.get(a2)).m16770a(false)));
                break;
            case 15:
                c2797b = (C2797b) message.obj;
                if (this.f7187m.containsKey(c2797b.f7173a)) {
                    ((C4771a) this.f7187m.get(c2797b.f7173a)).m16768a(c2797b);
                    break;
                }
                break;
            case 16:
                c2797b = (C2797b) message.obj;
                if (this.f7187m.containsKey(c2797b.f7173a)) {
                    ((C4771a) this.f7187m.get(c2797b.f7173a)).m16773b(c2797b);
                    break;
                }
                break;
            default:
                message = message.what;
                StringBuilder stringBuilder3 = new StringBuilder(31);
                stringBuilder3.append("Unknown message id: ");
                stringBuilder3.append(message);
                Log.w("GoogleApiManager", stringBuilder3.toString());
                return false;
        }
        return true;
    }

    /* renamed from: a */
    final PendingIntent m8055a(cg<?> cgVar, int i) {
        C4771a c4771a = (C4771a) this.f7187m.get(cgVar);
        if (c4771a == null) {
            return null;
        }
        cgVar = c4771a.m16801m();
        if (cgVar == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f7182h, i, cgVar.mo3451d(), 134217728);
    }

    /* renamed from: a */
    final boolean m8061a(C4775b c4775b, int i) {
        return this.f7183i.m14346a(this.f7182h, c4775b, i);
    }

    /* renamed from: b */
    public final void m8063b(C4775b c4775b, int i) {
        if (!m8061a(c4775b, i)) {
            this.f7191q.sendMessage(this.f7191q.obtainMessage(5, i, 0, c4775b));
        }
    }
}
