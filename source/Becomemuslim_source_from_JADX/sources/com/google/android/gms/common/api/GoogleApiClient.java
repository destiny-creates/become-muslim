package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.C4890j;
import android.support.v4.util.C3211a;
import android.view.View;
import com.google.android.gms.common.C4361e;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2781a.C2778c;
import com.google.android.gms.common.api.C2781a.C2779d;
import com.google.android.gms.common.api.C2781a.C2779d.C4338c;
import com.google.android.gms.common.api.C2781a.C2779d.C4339d;
import com.google.android.gms.common.api.C2781a.C2780e;
import com.google.android.gms.common.api.C2781a.C4337a;
import com.google.android.gms.common.api.C2781a.C4340f;
import com.google.android.gms.common.api.internal.C2796c.C4770a;
import com.google.android.gms.common.api.internal.C2800f;
import com.google.android.gms.common.api.internal.C2807l;
import com.google.android.gms.common.api.internal.an;
import com.google.android.gms.common.api.internal.bv;
import com.google.android.gms.common.api.internal.ch;
import com.google.android.gms.common.api.internal.co;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.common.internal.C2853f.C2852b;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.p175c.C2770b;
import com.google.android.gms.p175c.C4764e;
import com.google.android.gms.p175c.C4882a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient {
    /* renamed from: a */
    private static final Set<GoogleApiClient> f7097a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: com.google.android.gms.common.api.GoogleApiClient$a */
    public static final class C2774a {
        /* renamed from: a */
        private Account f7078a;
        /* renamed from: b */
        private final Set<Scope> f7079b = new HashSet();
        /* renamed from: c */
        private final Set<Scope> f7080c = new HashSet();
        /* renamed from: d */
        private int f7081d;
        /* renamed from: e */
        private View f7082e;
        /* renamed from: f */
        private String f7083f;
        /* renamed from: g */
        private String f7084g;
        /* renamed from: h */
        private final Map<C2781a<?>, C2852b> f7085h = new C3211a();
        /* renamed from: i */
        private final Context f7086i;
        /* renamed from: j */
        private final Map<C2781a<?>, C2779d> f7087j = new C3211a();
        /* renamed from: k */
        private C2800f f7088k;
        /* renamed from: l */
        private int f7089l = -1;
        /* renamed from: m */
        private C2776c f7090m;
        /* renamed from: n */
        private Looper f7091n;
        /* renamed from: o */
        private C4361e f7092o = C4361e.m14332a();
        /* renamed from: p */
        private C4337a<? extends C4764e, C4882a> f7093p = C2770b.f7057a;
        /* renamed from: q */
        private final ArrayList<C2775b> f7094q = new ArrayList();
        /* renamed from: r */
        private final ArrayList<C2776c> f7095r = new ArrayList();
        /* renamed from: s */
        private boolean f7096s = false;

        public C2774a(Context context) {
            this.f7086i = context;
            this.f7091n = context.getMainLooper();
            this.f7083f = context.getPackageName();
            this.f7084g = context.getClass().getName();
        }

        /* renamed from: a */
        public final C2774a m7901a(Handler handler) {
            C2872v.m8381a((Object) handler, (Object) "Handler must not be null");
            this.f7091n = handler.getLooper();
            return this;
        }

        /* renamed from: a */
        public final C2774a m7903a(C2775b c2775b) {
            C2872v.m8381a((Object) c2775b, (Object) "Listener must not be null");
            this.f7094q.add(c2775b);
            return this;
        }

        /* renamed from: a */
        public final C2774a m7904a(C2776c c2776c) {
            C2872v.m8381a((Object) c2776c, (Object) "Listener must not be null");
            this.f7095r.add(c2776c);
            return this;
        }

        /* renamed from: a */
        public final C2774a m7905a(Scope scope) {
            C2872v.m8381a((Object) scope, (Object) "Scope must not be null");
            this.f7079b.add(scope);
            return this;
        }

        /* renamed from: a */
        public final C2774a m7906a(C2781a<? extends C4339d> c2781a) {
            C2872v.m8381a((Object) c2781a, (Object) "Api must not be null");
            this.f7087j.put(c2781a, null);
            c2781a = c2781a.m7931a().mo3264a(null);
            this.f7080c.addAll(c2781a);
            this.f7079b.addAll(c2781a);
            return this;
        }

        /* renamed from: a */
        public final <O extends C4338c> C2774a m7907a(C2781a<O> c2781a, O o) {
            C2872v.m8381a((Object) c2781a, (Object) "Api must not be null");
            C2872v.m8381a((Object) o, (Object) "Null options are not permitted for this Api");
            this.f7087j.put(c2781a, o);
            c2781a = c2781a.m7931a().mo3264a(o);
            this.f7080c.addAll(c2781a);
            this.f7079b.addAll(c2781a);
            return this;
        }

        /* renamed from: a */
        public final C2774a m7902a(C4890j c4890j, int i, C2776c c2776c) {
            C2800f c2800f = new C2800f(c4890j);
            C2872v.m8391b(i >= 0 ? true : null, "clientId must be non-negative");
            this.f7089l = i;
            this.f7090m = c2776c;
            this.f7088k = c2800f;
            return this;
        }

        /* renamed from: a */
        public final C2853f m7908a() {
            C4882a c4882a = C4882a.f13966a;
            if (this.f7087j.containsKey(C2770b.f7058b)) {
                c4882a = (C4882a) this.f7087j.get(C2770b.f7058b);
            }
            return new C2853f(this.f7078a, this.f7079b, this.f7085h, this.f7081d, this.f7082e, this.f7083f, this.f7084g, c4882a);
        }

        /* renamed from: b */
        public final GoogleApiClient m7909b() {
            C2872v.m8391b(this.f7087j.isEmpty() ^ true, "must call addApi() to add at least one API");
            C2853f a = m7908a();
            C2781a c2781a = null;
            Map f = a.m8324f();
            Map c3211a = new C3211a();
            Map c3211a2 = new C3211a();
            ArrayList arrayList = new ArrayList();
            Object obj = null;
            for (C2781a c2781a2 : this.f7087j.keySet()) {
                Object obj2 = r1.f7087j.get(c2781a2);
                boolean z = f.get(c2781a2) != null;
                c3211a.put(c2781a2, Boolean.valueOf(z));
                C2775b coVar = new co(c2781a2, z);
                arrayList.add(coVar);
                C2780e b = c2781a2.m7932b();
                C2781a c2781a3 = c2781a2;
                C4340f a2 = b.mo3263a(r1.f7086i, r1.f7091n, a, obj2, coVar, coVar);
                c3211a2.put(c2781a3.m7933c(), a2);
                if (b.m7929a() == 1) {
                    obj = obj2 != null ? 1 : null;
                }
                if (a2.mo3450c()) {
                    if (c2781a == null) {
                        c2781a = c2781a3;
                    } else {
                        String d = c2781a3.m7934d();
                        String d2 = c2781a.m7934d();
                        StringBuilder stringBuilder = new StringBuilder((String.valueOf(d).length() + 21) + String.valueOf(d2).length());
                        stringBuilder.append(d);
                        stringBuilder.append(" cannot be used with ");
                        stringBuilder.append(d2);
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                }
            }
            if (c2781a != null) {
                if (obj == null) {
                    C2872v.m8388a(r1.f7078a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", c2781a.m7934d());
                    C2872v.m8388a(r1.f7079b.equals(r1.f7080c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", c2781a.m7934d());
                } else {
                    d = c2781a.m7934d();
                    StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(d).length() + 82);
                    stringBuilder2.append("With using ");
                    stringBuilder2.append(d);
                    stringBuilder2.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                    throw new IllegalStateException(stringBuilder2.toString());
                }
            }
            GoogleApiClient anVar = new an(r1.f7086i, new ReentrantLock(), r1.f7091n, a, r1.f7092o, r1.f7093p, c3211a, r1.f7094q, r1.f7095r, c3211a2, r1.f7089l, an.m14130a(c3211a2.values(), true), arrayList, false);
            synchronized (GoogleApiClient.f7097a) {
                GoogleApiClient.f7097a.add(anVar);
            }
            if (r1.f7089l >= 0) {
                ch.m16757b(r1.f7088k).m16759a(r1.f7089l, anVar, r1.f7090m);
            }
            return anVar;
        }
    }

    /* renamed from: com.google.android.gms.common.api.GoogleApiClient$b */
    public interface C2775b {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    /* renamed from: com.google.android.gms.common.api.GoogleApiClient$c */
    public interface C2776c {
        void onConnectionFailed(C4775b c4775b);
    }

    /* renamed from: a */
    public abstract void mo2403a(C2776c c2776c);

    /* renamed from: a */
    public abstract void mo2406a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* renamed from: b */
    public abstract void mo2410b(C2776c c2776c);

    public abstract void connect();

    public abstract void disconnect();

    /* renamed from: e */
    public abstract C4775b mo2416e();

    /* renamed from: f */
    public abstract void mo2417f();

    /* renamed from: g */
    public abstract C2789g<Status> mo2418g();

    /* renamed from: h */
    public abstract boolean mo2419h();

    /* renamed from: a */
    public static Set<GoogleApiClient> m7910a() {
        Set<GoogleApiClient> set;
        synchronized (f7097a) {
            set = f7097a;
        }
        return set;
    }

    /* renamed from: a */
    public <A extends C2777b, R extends C2814k, T extends C4770a<R, A>> T mo2399a(T t) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    public <A extends C2777b, T extends C4770a<? extends C2814k, A>> T mo2409b(T t) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public <C extends C4340f> C mo2398a(C2778c<C> c2778c) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    public Context mo2408b() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: c */
    public Looper mo2412c() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public boolean mo2407a(C2807l c2807l) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: d */
    public void mo2414d() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public void mo2400a(int i) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public void mo2404a(bv bvVar) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    public void mo2411b(bv bvVar) {
        throw new UnsupportedOperationException();
    }
}
