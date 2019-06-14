package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.C2830f;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2781a.C2778c;
import com.google.android.gms.common.api.C2781a.C4337a;
import com.google.android.gms.common.api.C2781a.C4340f;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.C2796c.C4770a;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.common.internal.C2853f.C2852b;
import com.google.android.gms.common.internal.C2862o;
import com.google.android.gms.p175c.C4764e;
import com.google.android.gms.p175c.C4882a;
import com.google.android.gms.p175c.p176a.C4761k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class ab implements av {
    /* renamed from: a */
    private final aw f11398a;
    /* renamed from: b */
    private final Lock f11399b;
    /* renamed from: c */
    private final Context f11400c;
    /* renamed from: d */
    private final C2830f f11401d;
    /* renamed from: e */
    private C4775b f11402e;
    /* renamed from: f */
    private int f11403f;
    /* renamed from: g */
    private int f11404g = 0;
    /* renamed from: h */
    private int f11405h;
    /* renamed from: i */
    private final Bundle f11406i = new Bundle();
    /* renamed from: j */
    private final Set<C2778c> f11407j = new HashSet();
    /* renamed from: k */
    private C4764e f11408k;
    /* renamed from: l */
    private boolean f11409l;
    /* renamed from: m */
    private boolean f11410m;
    /* renamed from: n */
    private boolean f11411n;
    /* renamed from: o */
    private C2862o f11412o;
    /* renamed from: p */
    private boolean f11413p;
    /* renamed from: q */
    private boolean f11414q;
    /* renamed from: r */
    private final C2853f f11415r;
    /* renamed from: s */
    private final Map<C2781a<?>, Boolean> f11416s;
    /* renamed from: t */
    private final C4337a<? extends C4764e, C4882a> f11417t;
    /* renamed from: u */
    private ArrayList<Future<?>> f11418u = new ArrayList();

    public ab(aw awVar, C2853f c2853f, Map<C2781a<?>, Boolean> map, C2830f c2830f, C4337a<? extends C4764e, C4882a> c4337a, Lock lock, Context context) {
        this.f11398a = awVar;
        this.f11415r = c2853f;
        this.f11416s = map;
        this.f11401d = c2830f;
        this.f11417t = c4337a;
        this.f11399b = lock;
        this.f11400c = context;
    }

    /* renamed from: c */
    private static String m14091c(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    /* renamed from: c */
    public final void mo2392c() {
    }

    /* renamed from: a */
    public final void mo2386a() {
        this.f11398a.f13164b.clear();
        this.f11410m = false;
        this.f11402e = null;
        this.f11404g = 0;
        this.f11409l = true;
        this.f11411n = false;
        this.f11413p = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (C2781a c2781a : this.f11416s.keySet()) {
            C4340f c4340f = (C4340f) this.f11398a.f13163a.get(c2781a.m7933c());
            i |= c2781a.m7931a().m7929a() == 1 ? 1 : 0;
            boolean booleanValue = ((Boolean) this.f11416s.get(c2781a)).booleanValue();
            if (c4340f.mo3457j()) {
                this.f11410m = true;
                if (booleanValue) {
                    this.f11407j.add(c2781a.m7933c());
                } else {
                    this.f11409l = false;
                }
            }
            hashMap.put(c4340f, new ad(this, c2781a, booleanValue));
        }
        if (i != 0) {
            this.f11410m = false;
        }
        if (this.f11410m) {
            this.f11415r.m8319a(Integer.valueOf(System.identityHashCode(this.f11398a.f13166d)));
            C2776c akVar = new ak();
            this.f11408k = (C4764e) this.f11417t.mo3263a(this.f11400c, this.f11398a.f13166d.mo2412c(), this.f11415r, this.f11415r.m8327i(), akVar, akVar);
        }
        this.f11405h = this.f11398a.f13163a.size();
        this.f11418u.add(az.m7997a().submit(new ae(this, hashMap)));
    }

    /* renamed from: d */
    private final boolean m14094d() {
        this.f11405h--;
        if (this.f11405h > 0) {
            return false;
        }
        if (this.f11405h < 0) {
            Log.w("GoogleApiClientConnecting", this.f11398a.f13166d.m14163l());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m14087b(new C4775b(8, null));
            return false;
        } else if (this.f11402e == null) {
            return true;
        } else {
            this.f11398a.f13165c = this.f11403f;
            m14087b(this.f11402e);
            return false;
        }
    }

    /* renamed from: a */
    private final void m14079a(C4761k c4761k) {
        if (m14089b(0)) {
            C4775b a = c4761k.m16692a();
            if (a.m16826b()) {
                c4761k = c4761k.m16693b();
                a = c4761k.m16855b();
                if (a.m16826b()) {
                    this.f11411n = true;
                    this.f11412o = c4761k.m16854a();
                    this.f11413p = c4761k.m16856c();
                    this.f11414q = c4761k.m16857d();
                    m14095e();
                    return;
                }
                String valueOf = String.valueOf(a);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 48);
                stringBuilder.append("Sign-in succeeded with resolve account failure: ");
                stringBuilder.append(valueOf);
                Log.wtf("GoogleApiClientConnecting", stringBuilder.toString(), new Exception());
                m14087b(a);
            } else if (m14085a(a) != null) {
                m14100g();
                m14095e();
            } else {
                m14087b(a);
            }
        }
    }

    /* renamed from: e */
    private final void m14095e() {
        if (this.f11405h == 0) {
            if (!this.f11410m || this.f11411n) {
                ArrayList arrayList = new ArrayList();
                this.f11404g = 1;
                this.f11405h = this.f11398a.f13163a.size();
                for (C2778c c2778c : this.f11398a.f13163a.keySet()) {
                    if (!this.f11398a.f13164b.containsKey(c2778c)) {
                        arrayList.add((C4340f) this.f11398a.f13163a.get(c2778c));
                    } else if (m14094d()) {
                        m14098f();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.f11418u.add(az.m7997a().submit(new ah(this, arrayList)));
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo2388a(Bundle bundle) {
        if (m14089b(1)) {
            if (bundle != null) {
                this.f11406i.putAll(bundle);
            }
            if (m14094d() != null) {
                m14098f();
            }
        }
    }

    /* renamed from: a */
    public final void mo2389a(C4775b c4775b, C2781a<?> c2781a, boolean z) {
        if (m14089b(1)) {
            m14088b(c4775b, c2781a, z);
            if (m14094d() != null) {
                m14098f();
            }
        }
    }

    /* renamed from: f */
    private final void m14098f() {
        this.f11398a.m16726e();
        az.m7997a().execute(new ac(this));
        if (this.f11408k != null) {
            if (this.f11413p) {
                this.f11408k.mo3456a(this.f11412o, this.f11414q);
            }
            m14083a(false);
        }
        for (C2778c c2778c : this.f11398a.f13164b.keySet()) {
            ((C4340f) this.f11398a.f13163a.get(c2778c)).m14045g();
        }
        this.f11398a.f13167e.mo2402a(this.f11406i.isEmpty() ? null : this.f11406i);
    }

    /* renamed from: a */
    public final <A extends C2777b, R extends C2814k, T extends C4770a<R, A>> T mo2385a(T t) {
        this.f11398a.f13166d.f11433a.add(t);
        return t;
    }

    /* renamed from: b */
    public final <A extends C2777b, T extends C4770a<? extends C2814k, A>> T mo2390b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    /* renamed from: b */
    public final boolean mo2391b() {
        m14102h();
        m14083a(true);
        this.f11398a.m16717a(null);
        return true;
    }

    /* renamed from: a */
    public final void mo2387a(int i) {
        m14087b(new C4775b(8, null));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private final void m14088b(com.google.android.gms.common.C4775b r5, com.google.android.gms.common.api.C2781a<?> r6, boolean r7) {
        /*
        r4 = this;
        r0 = r6.m7931a();
        r0 = r0.m7929a();
        r1 = 0;
        r2 = 1;
        if (r7 == 0) goto L_0x0024;
    L_0x000c:
        r7 = r5.m16825a();
        if (r7 == 0) goto L_0x0014;
    L_0x0012:
        r7 = 1;
        goto L_0x0022;
    L_0x0014:
        r7 = r4.f11401d;
        r3 = r5.m16827c();
        r7 = r7.m8143c(r3);
        if (r7 == 0) goto L_0x0021;
    L_0x0020:
        goto L_0x0012;
    L_0x0021:
        r7 = 0;
    L_0x0022:
        if (r7 == 0) goto L_0x002d;
    L_0x0024:
        r7 = r4.f11402e;
        if (r7 == 0) goto L_0x002c;
    L_0x0028:
        r7 = r4.f11403f;
        if (r0 >= r7) goto L_0x002d;
    L_0x002c:
        r1 = 1;
    L_0x002d:
        if (r1 == 0) goto L_0x0033;
    L_0x002f:
        r4.f11402e = r5;
        r4.f11403f = r0;
    L_0x0033:
        r7 = r4.f11398a;
        r7 = r7.f13164b;
        r6 = r6.m7933c();
        r7.put(r6, r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.ab.b(com.google.android.gms.common.b, com.google.android.gms.common.api.a, boolean):void");
    }

    /* renamed from: g */
    private final void m14100g() {
        this.f11410m = false;
        this.f11398a.f13166d.f11435c = Collections.emptySet();
        for (C2778c c2778c : this.f11407j) {
            if (!this.f11398a.f13164b.containsKey(c2778c)) {
                this.f11398a.f13164b.put(c2778c, new C4775b(17, null));
            }
        }
    }

    /* renamed from: a */
    private final boolean m14085a(C4775b c4775b) {
        return (this.f11409l && c4775b.m16825a() == null) ? true : null;
    }

    /* renamed from: b */
    private final void m14087b(C4775b c4775b) {
        m14102h();
        m14083a(c4775b.m16825a() ^ 1);
        this.f11398a.m16717a(c4775b);
        this.f11398a.f13167e.mo2405a(c4775b);
    }

    /* renamed from: a */
    private final void m14083a(boolean z) {
        if (this.f11408k != null) {
            if (this.f11408k.m14046h() && z) {
                this.f11408k.mo3452e();
            }
            this.f11408k.m14045g();
            this.f11412o = false;
        }
    }

    /* renamed from: h */
    private final void m14102h() {
        ArrayList arrayList = this.f11418u;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Future) obj).cancel(true);
        }
        this.f11418u.clear();
    }

    /* renamed from: i */
    private final Set<Scope> m14103i() {
        if (this.f11415r == null) {
            return Collections.emptySet();
        }
        Set<Scope> hashSet = new HashSet(this.f11415r.m8322d());
        Map f = this.f11415r.m8324f();
        for (C2781a c2781a : f.keySet()) {
            if (!this.f11398a.f13164b.containsKey(c2781a.m7933c())) {
                hashSet.addAll(((C2852b) f.get(c2781a)).f7300a);
            }
        }
        return hashSet;
    }

    /* renamed from: b */
    private final boolean m14089b(int i) {
        if (this.f11404g == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.f11398a.f13166d.m14163l());
        String valueOf = String.valueOf(this);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 23);
        stringBuilder.append("Unexpected callback in ");
        stringBuilder.append(valueOf);
        Log.w("GoogleApiClientConnecting", stringBuilder.toString());
        int i2 = this.f11405h;
        stringBuilder = new StringBuilder(33);
        stringBuilder.append("mRemainingConnections=");
        stringBuilder.append(i2);
        Log.w("GoogleApiClientConnecting", stringBuilder.toString());
        valueOf = m14091c(this.f11404g);
        i = m14091c(i);
        stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(i).length());
        stringBuilder.append("GoogleApiClient connecting is in step ");
        stringBuilder.append(valueOf);
        stringBuilder.append(" but received callback for step ");
        stringBuilder.append(i);
        Log.wtf("GoogleApiClientConnecting", stringBuilder.toString(), new Exception());
        m14087b(new C4775b(8, null));
        return false;
    }
}
