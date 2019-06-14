package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.C4361e;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2781a.C2778c;
import com.google.android.gms.common.api.C2781a.C4337a;
import com.google.android.gms.common.api.C2781a.C4340f;
import com.google.android.gms.common.api.C2789g;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.C2774a;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C2796c.C4770a;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.common.internal.C2857k;
import com.google.android.gms.common.internal.C2857k.C2856a;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p182b.C2838a;
import com.google.android.gms.common.util.C2894d;
import com.google.android.gms.p175c.C4764e;
import com.google.android.gms.p175c.C4882a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class an extends GoogleApiClient implements bl {
    /* renamed from: a */
    final Queue<C4770a<?, ?>> f11433a = new LinkedList();
    /* renamed from: b */
    final Map<C2778c<?>, C4340f> f11434b;
    /* renamed from: c */
    Set<Scope> f11435c;
    /* renamed from: d */
    Set<bv> f11436d;
    /* renamed from: e */
    final by f11437e;
    /* renamed from: f */
    private final Lock f11438f;
    /* renamed from: g */
    private boolean f11439g;
    /* renamed from: h */
    private final C2857k f11440h;
    /* renamed from: i */
    private bk f11441i = null;
    /* renamed from: j */
    private final int f11442j;
    /* renamed from: k */
    private final Context f11443k;
    /* renamed from: l */
    private final Looper f11444l;
    /* renamed from: m */
    private volatile boolean f11445m;
    /* renamed from: n */
    private long f11446n;
    /* renamed from: o */
    private long f11447o;
    /* renamed from: p */
    private final at f11448p;
    /* renamed from: q */
    private final C4361e f11449q;
    /* renamed from: r */
    private bi f11450r;
    /* renamed from: s */
    private final C2853f f11451s;
    /* renamed from: t */
    private final Map<C2781a<?>, Boolean> f11452t;
    /* renamed from: u */
    private final C4337a<? extends C4764e, C4882a> f11453u;
    /* renamed from: v */
    private final C2805i f11454v;
    /* renamed from: w */
    private final ArrayList<co> f11455w;
    /* renamed from: x */
    private Integer f11456x;
    /* renamed from: y */
    private final C2856a f11457y;

    public an(Context context, Lock lock, Looper looper, C2853f c2853f, C4361e c4361e, C4337a<? extends C4764e, C4882a> c4337a, Map<C2781a<?>, Boolean> map, List<C2775b> list, List<C2776c> list2, Map<C2778c<?>, C4340f> map2, int i, int i2, ArrayList<co> arrayList, boolean z) {
        Looper looper2 = looper;
        r0.f11446n = C2894d.m8424a() ? 10000 : 120000;
        r0.f11447o = 5000;
        r0.f11435c = new HashSet();
        r0.f11454v = new C2805i();
        r0.f11456x = null;
        r0.f11436d = null;
        r0.f11457y = new ao(this);
        r0.f11443k = context;
        r0.f11438f = lock;
        r0.f11439g = false;
        r0.f11440h = new C2857k(looper, r0.f11457y);
        r0.f11444l = looper2;
        r0.f11448p = new at(this, looper);
        r0.f11449q = c4361e;
        r0.f11442j = i;
        if (r0.f11442j >= 0) {
            r0.f11456x = Integer.valueOf(i2);
        }
        r0.f11452t = map;
        r0.f11434b = map2;
        r0.f11455w = arrayList;
        r0.f11437e = new by(r0.f11434b);
        for (C2775b a : list) {
            r0.f11440h.m8347a(a);
        }
        for (C2776c a2 : list2) {
            r0.f11440h.m8348a(a2);
        }
        r0.f11451s = c2853f;
        r0.f11453u = c4337a;
    }

    /* renamed from: c */
    private static String m14137c(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    /* renamed from: a */
    public final <A extends C2777b, R extends C2814k, T extends C4770a<R, A>> T mo2399a(T t) {
        C2872v.m8391b(t.mo3282d() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.f11434b.containsKey(t.mo3282d());
        String d = t.m16744e() != null ? t.m16744e().m7934d() : "the API";
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(d).length() + 65);
        stringBuilder.append("GoogleApiClient is not configured to use ");
        stringBuilder.append(d);
        stringBuilder.append(" required for this call.");
        C2872v.m8391b(containsKey, stringBuilder.toString());
        this.f11438f.lock();
        try {
            if (this.f11441i == null) {
                this.f11433a.add(t);
                return t;
            }
            t = this.f11441i.mo2436a((C4770a) t);
            this.f11438f.unlock();
            return t;
        } finally {
            this.f11438f.unlock();
        }
    }

    /* renamed from: b */
    public final <A extends C2777b, T extends C4770a<? extends C2814k, A>> T mo2409b(T t) {
        C2872v.m8391b(t.mo3282d() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.f11434b.containsKey(t.mo3282d());
        String d = t.m16744e() != null ? t.m16744e().m7934d() : "the API";
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(d).length() + 65);
        stringBuilder.append("GoogleApiClient is not configured to use ");
        stringBuilder.append(d);
        stringBuilder.append(" required for this call.");
        C2872v.m8391b(containsKey, stringBuilder.toString());
        this.f11438f.lock();
        try {
            if (this.f11441i == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            } else if (this.f11445m) {
                this.f11433a.add(t);
                while (!this.f11433a.isEmpty()) {
                    C4770a c4770a = (C4770a) this.f11433a.remove();
                    this.f11437e.m8025a(c4770a);
                    c4770a.m16741b(Status.f13153c);
                }
                return t;
            } else {
                t = this.f11441i.mo2440b(t);
                this.f11438f.unlock();
                return t;
            }
        } finally {
            this.f11438f.unlock();
        }
    }

    /* renamed from: a */
    public final <C extends C4340f> C mo2398a(C2778c<C> c2778c) {
        Object obj = (C4340f) this.f11434b.get(c2778c);
        C2872v.m8381a(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public final void connect() {
        this.f11438f.lock();
        try {
            boolean z = false;
            if (this.f11442j >= 0) {
                if (this.f11456x != null) {
                    z = true;
                }
                C2872v.m8387a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f11456x == null) {
                this.f11456x = Integer.valueOf(m14130a(this.f11434b.values(), false));
            } else if (this.f11456x.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            mo2400a(this.f11456x.intValue());
        } finally {
            this.f11438f.unlock();
        }
    }

    /* renamed from: a */
    public final void mo2400a(int i) {
        this.f11438f.lock();
        boolean z = true;
        if (!(i == 3 || i == 1)) {
            if (i != 2) {
                z = false;
            }
        }
        try {
            StringBuilder stringBuilder = new StringBuilder(33);
            stringBuilder.append("Illegal sign-in mode: ");
            stringBuilder.append(i);
            C2872v.m8391b(z, stringBuilder.toString());
            m14134b(i);
            m14138m();
        } finally {
            this.f11438f.unlock();
        }
    }

    /* renamed from: e */
    public final C4775b mo2416e() {
        boolean z = true;
        C2872v.m8387a(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.f11438f.lock();
        try {
            if (this.f11442j >= 0) {
                if (this.f11456x == null) {
                    z = false;
                }
                C2872v.m8387a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f11456x == null) {
                this.f11456x = Integer.valueOf(m14130a(this.f11434b.values(), false));
            } else if (this.f11456x.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m14134b(this.f11456x.intValue());
            this.f11440h.m8350b();
            C4775b b = this.f11441i.mo2441b();
            return b;
        } finally {
            this.f11438f.unlock();
        }
    }

    public final void disconnect() {
        this.f11438f.lock();
        try {
            this.f11437e.m8024a();
            if (this.f11441i != null) {
                this.f11441i.mo2442c();
            }
            this.f11454v.m8086a();
            for (C4770a c4770a : this.f11433a) {
                c4770a.m14066a(null);
                c4770a.mo2377a();
            }
            this.f11433a.clear();
            if (this.f11441i != null) {
                m14161j();
                this.f11440h.m8344a();
                this.f11438f.unlock();
            }
        } finally {
            this.f11438f.unlock();
        }
    }

    /* renamed from: f */
    public final void mo2417f() {
        disconnect();
        connect();
    }

    /* renamed from: g */
    public final C2789g<Status> mo2418g() {
        C2872v.m8387a(mo2419h(), (Object) "GoogleApiClient is not connected yet.");
        C2872v.m8387a(this.f11456x.intValue() != 2, (Object) "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        C2789g c4773n = new C4773n(this);
        if (this.f11434b.containsKey(C2838a.f7250a)) {
            m14131a(this, c4773n, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient b = new C2774a(this.f11443k).m7906a(C2838a.f7251b).m7903a(new ap(this, atomicReference, c4773n)).m7904a(new aq(this, c4773n)).m7901a(this.f11448p).m7909b();
            atomicReference.set(b);
            b.connect();
        }
        return c4773n;
    }

    /* renamed from: a */
    private final void m14131a(GoogleApiClient googleApiClient, C4773n c4773n, boolean z) {
        C2838a.f7252c.mo2471a(googleApiClient).mo2379a(new as(this, c4773n, z, googleApiClient));
    }

    /* renamed from: h */
    public final boolean mo2419h() {
        return this.f11441i != null && this.f11441i.mo2443f();
    }

    /* renamed from: b */
    private final void m14134b(int i) {
        if (this.f11456x == null) {
            this.f11456x = Integer.valueOf(i);
        } else if (this.f11456x.intValue() != i) {
            String c = m14137c(i);
            String c2 = m14137c(this.f11456x.intValue());
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(c).length() + 51) + String.valueOf(c2).length());
            stringBuilder.append("Cannot use sign-in mode: ");
            stringBuilder.append(c);
            stringBuilder.append(". Mode was already set to ");
            stringBuilder.append(c2);
            throw new IllegalStateException(stringBuilder.toString());
        }
        if (this.f11441i == null) {
            Object obj = null;
            Object obj2 = null;
            for (C4340f c4340f : this.f11434b.values()) {
                if (c4340f.mo3457j()) {
                    obj = 1;
                }
                if (c4340f.mo3450c()) {
                    obj2 = 1;
                }
            }
            switch (this.f11456x.intValue()) {
                case 1:
                    if (obj == null) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (obj2 == null) {
                        break;
                    } else {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                case 2:
                    if (obj != null) {
                        if (this.f11439g) {
                            this.f11441i = new cv(this.f11443k, this.f11438f, this.f11444l, this.f11449q, this.f11434b, this.f11451s, this.f11452t, this.f11453u, this.f11455w, this, true);
                            return;
                        } else {
                            this.f11441i = cq.m14214a(this.f11443k, this, this.f11438f, this.f11444l, this.f11449q, this.f11434b, this.f11451s, this.f11452t, this.f11453u, this.f11455w);
                            return;
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    break;
            }
            if (this.f11439g && obj2 == null) {
                this.f11441i = new cv(this.f11443k, this.f11438f, this.f11444l, this.f11449q, this.f11434b, this.f11451s, this.f11452t, this.f11453u, this.f11455w, this, false);
            } else {
                this.f11441i = new aw(this.f11443k, this, this.f11438f, this.f11444l, this.f11449q, this.f11434b, this.f11451s, this.f11452t, this.f11453u, this.f11455w, this);
            }
        }
    }

    /* renamed from: m */
    private final void m14138m() {
        this.f11440h.m8350b();
        this.f11441i.mo2437a();
    }

    /* renamed from: n */
    private final void m14139n() {
        this.f11438f.lock();
        try {
            if (this.f11445m) {
                m14138m();
            }
            this.f11438f.unlock();
        } catch (Throwable th) {
            this.f11438f.unlock();
        }
    }

    /* renamed from: o */
    private final void m14140o() {
        this.f11438f.lock();
        try {
            if (m14161j()) {
                m14138m();
            }
            this.f11438f.unlock();
        } catch (Throwable th) {
            this.f11438f.unlock();
        }
    }

    /* renamed from: j */
    final boolean m14161j() {
        if (!this.f11445m) {
            return false;
        }
        this.f11445m = false;
        this.f11448p.removeMessages(2);
        this.f11448p.removeMessages(1);
        if (this.f11450r != null) {
            this.f11450r.m8005a();
            this.f11450r = null;
        }
        return true;
    }

    /* renamed from: a */
    public final void mo2403a(C2776c c2776c) {
        this.f11440h.m8348a(c2776c);
    }

    /* renamed from: b */
    public final void mo2410b(C2776c c2776c) {
        this.f11440h.m8351b(c2776c);
    }

    /* renamed from: a */
    public final void mo2402a(Bundle bundle) {
        while (!this.f11433a.isEmpty()) {
            mo2409b((C4770a) this.f11433a.remove());
        }
        this.f11440h.m8346a(bundle);
    }

    /* renamed from: a */
    public final void mo2405a(C4775b c4775b) {
        if (!this.f11449q.m8145c(this.f11443k, c4775b.m16827c())) {
            m14161j();
        }
        if (!this.f11445m) {
            this.f11440h.m8349a(c4775b);
            this.f11440h.m8344a();
        }
    }

    /* renamed from: a */
    public final void mo2401a(int i, boolean z) {
        if (!(i != 1 || z || this.f11445m)) {
            this.f11445m = true;
            if (!(this.f11450r || C2894d.m8424a())) {
                this.f11450r = this.f11449q.m14342a(this.f11443k.getApplicationContext(), new au(this));
            }
            this.f11448p.sendMessageDelayed(this.f11448p.obtainMessage(1), this.f11446n);
            this.f11448p.sendMessageDelayed(this.f11448p.obtainMessage(2), this.f11447o);
        }
        this.f11437e.m8026b();
        this.f11440h.m8345a(i);
        this.f11440h.m8344a();
        if (i == 2) {
            m14138m();
        }
    }

    /* renamed from: b */
    public final Context mo2408b() {
        return this.f11443k;
    }

    /* renamed from: c */
    public final Looper mo2412c() {
        return this.f11444l;
    }

    /* renamed from: a */
    public final boolean mo2407a(C2807l c2807l) {
        return (this.f11441i == null || this.f11441i.mo2439a(c2807l) == null) ? null : true;
    }

    /* renamed from: d */
    public final void mo2414d() {
        if (this.f11441i != null) {
            this.f11441i.mo2444h();
        }
    }

    /* renamed from: a */
    public final void mo2404a(bv bvVar) {
        this.f11438f.lock();
        try {
            if (this.f11436d == null) {
                this.f11436d = new HashSet();
            }
            this.f11436d.add(bvVar);
        } finally {
            this.f11438f.unlock();
        }
    }

    /* renamed from: b */
    public final void mo2411b(bv bvVar) {
        this.f11438f.lock();
        try {
            if (this.f11436d == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (this.f11436d.remove(bvVar) == null) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (m14162k() == null) {
                this.f11441i.mo2445i();
            }
            this.f11438f.unlock();
        } catch (Throwable th) {
            this.f11438f.unlock();
        }
    }

    /* renamed from: k */
    final boolean m14162k() {
        this.f11438f.lock();
        try {
            if (this.f11436d == null) {
                return false;
            }
            boolean isEmpty = this.f11436d.isEmpty() ^ 1;
            this.f11438f.unlock();
            return isEmpty;
        } finally {
            this.f11438f.unlock();
        }
    }

    /* renamed from: l */
    final String m14163l() {
        Writer stringWriter = new StringWriter();
        mo2406a("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    /* renamed from: a */
    public final void mo2406a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f11443k);
        printWriter.append(str).append("mResuming=").print(this.f11445m);
        printWriter.append(" mWorkQueue.size()=").print(this.f11433a.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f11437e.f7153b.size());
        if (this.f11441i != null) {
            this.f11441i.mo2438a(str, fileDescriptor, printWriter, strArr);
        }
    }

    /* renamed from: a */
    public static int m14130a(Iterable<C4340f> iterable, boolean z) {
        Object obj = null;
        Object obj2 = null;
        for (C4340f c4340f : iterable) {
            if (c4340f.mo3457j()) {
                obj = 1;
            }
            if (c4340f.mo3450c()) {
                obj2 = 1;
            }
        }
        if (obj == null) {
            return 3;
        }
        if (obj2 == null || !z) {
            return 1;
        }
        return 2;
    }
}
