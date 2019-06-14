package com.google.android.exoplayer2.p149h.p153c.p154a;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.amplitude.api.Constants;
import com.google.android.exoplayer2.C2251b;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p149h.C2430j.C2429a;
import com.google.android.exoplayer2.p149h.p150a.C2373h;
import com.google.android.exoplayer2.p149h.p153c.C2405e;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4190a.C2394a;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4191b.C2395a;
import com.google.android.exoplayer2.p163k.C4251s;
import com.google.android.exoplayer2.p163k.C4251s.C2506a;
import com.google.android.exoplayer2.p163k.C4253u;
import com.google.android.exoplayer2.p163k.C4253u.C2513a;
import com.google.android.exoplayer2.p164l.C2539u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

/* compiled from: HlsPlaylistTracker */
/* renamed from: com.google.android.exoplayer2.h.c.a.e */
public final class C4194e implements C2506a<C4253u<C2396c>> {
    /* renamed from: a */
    private final Uri f10961a;
    /* renamed from: b */
    private final C2405e f10962b;
    /* renamed from: c */
    private final C2513a<C2396c> f10963c;
    /* renamed from: d */
    private final int f10964d;
    /* renamed from: e */
    private final IdentityHashMap<C2394a, C4193a> f10965e = new IdentityHashMap();
    /* renamed from: f */
    private final Handler f10966f = new Handler();
    /* renamed from: g */
    private final C2402e f10967g;
    /* renamed from: h */
    private final List<C2399b> f10968h = new ArrayList();
    /* renamed from: i */
    private final C4251s f10969i = new C4251s("HlsPlaylistTracker:MasterPlaylist");
    /* renamed from: j */
    private final C2429a f10970j;
    /* renamed from: k */
    private C4190a f10971k;
    /* renamed from: l */
    private C2394a f10972l;
    /* renamed from: m */
    private C4191b f10973m;
    /* renamed from: n */
    private boolean f10974n;

    /* compiled from: HlsPlaylistTracker */
    /* renamed from: com.google.android.exoplayer2.h.c.a.e$b */
    public interface C2399b {
        /* renamed from: a */
        void mo3220a(C2394a c2394a, long j);

        /* renamed from: h */
        void mo3222h();
    }

    /* compiled from: HlsPlaylistTracker */
    /* renamed from: com.google.android.exoplayer2.h.c.a.e$c */
    public static final class C2400c extends IOException {
        /* renamed from: a */
        public final String f5912a;

        private C2400c(String str) {
            this.f5912a = str;
        }
    }

    /* compiled from: HlsPlaylistTracker */
    /* renamed from: com.google.android.exoplayer2.h.c.a.e$d */
    public static final class C2401d extends IOException {
        /* renamed from: a */
        public final String f5913a;

        private C2401d(String str) {
            this.f5913a = str;
        }
    }

    /* compiled from: HlsPlaylistTracker */
    /* renamed from: com.google.android.exoplayer2.h.c.a.e$e */
    public interface C2402e {
        /* renamed from: a */
        void mo2273a(C4191b c4191b);
    }

    /* compiled from: HlsPlaylistTracker */
    /* renamed from: com.google.android.exoplayer2.h.c.a.e$a */
    private final class C4193a implements C2506a<C4253u<C2396c>>, Runnable {
        /* renamed from: a */
        final /* synthetic */ C4194e f10950a;
        /* renamed from: b */
        private final C2394a f10951b;
        /* renamed from: c */
        private final C4251s f10952c = new C4251s("HlsPlaylistTracker:MediaPlaylist");
        /* renamed from: d */
        private final C4253u<C2396c> f10953d;
        /* renamed from: e */
        private C4191b f10954e;
        /* renamed from: f */
        private long f10955f;
        /* renamed from: g */
        private long f10956g;
        /* renamed from: h */
        private long f10957h;
        /* renamed from: i */
        private long f10958i;
        /* renamed from: j */
        private boolean f10959j;
        /* renamed from: k */
        private IOException f10960k;

        public C4193a(C4194e c4194e, C2394a c2394a) {
            this.f10950a = c4194e;
            this.f10951b = c2394a;
            this.f10953d = new C4253u(c4194e.f10962b.mo2271a(4), C2539u.m7158a(c4194e.f10971k.p, c2394a.f5897a), 4, c4194e.f10963c);
        }

        /* renamed from: a */
        public C4191b m13464a() {
            return this.f10954e;
        }

        /* renamed from: b */
        public boolean m13469b() {
            boolean z = false;
            if (this.f10954e == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(Constants.EVENT_UPLOAD_PERIOD_MILLIS, C2251b.m6221a(this.f10954e.f10925o));
            if (this.f10954e.f10920j || this.f10954e.f10911a == 2 || this.f10954e.f10911a == 1 || this.f10955f + max > elapsedRealtime) {
                z = true;
            }
            return z;
        }

        /* renamed from: c */
        public void m13470c() {
            this.f10952c.m13802c();
        }

        /* renamed from: d */
        public void m13471d() {
            this.f10958i = 0;
            if (!this.f10959j) {
                if (!this.f10952c.m13799a()) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (elapsedRealtime < this.f10957h) {
                        this.f10959j = true;
                        this.f10950a.f10966f.postDelayed(this, this.f10957h - elapsedRealtime);
                    } else {
                        m13460f();
                    }
                }
            }
        }

        /* renamed from: e */
        public void m13472e() {
            this.f10952c.mo2322d();
            if (this.f10960k != null) {
                throw this.f10960k;
            }
        }

        /* renamed from: a */
        public void m13467a(C4253u<C2396c> c4253u, long j, long j2) {
            C2396c c2396c = (C2396c) c4253u.m13808d();
            if (c2396c instanceof C4191b) {
                m13457a((C4191b) c2396c);
                this.f10950a.f10970j.m6672a(c4253u.f11218a, 4, j, j2, c4253u.m13809e());
                return;
            }
            this.f10960k = new C2571p("Loaded playlist has unexpected type.");
        }

        /* renamed from: a */
        public void m13468a(C4253u<C2396c> c4253u, long j, long j2, boolean z) {
            this.f10950a.f10970j.m6675b(c4253u.f11218a, 4, j, j2, c4253u.m13809e());
        }

        /* renamed from: a */
        public int m13463a(C4253u<C2396c> c4253u, long j, long j2, IOException iOException) {
            boolean z = iOException instanceof C2571p;
            this.f10950a.f10970j.m6673a(c4253u.f11218a, 4, j, j2, c4253u.m13809e(), iOException, z);
            if (z) {
                return 3;
            }
            boolean z2 = true;
            if (C2373h.m6566a(iOException)) {
                z2 = m13461g();
            }
            return z2 ? 0 : 2;
        }

        public void run() {
            this.f10959j = false;
            m13460f();
        }

        /* renamed from: f */
        private void m13460f() {
            this.f10952c.m13797a(this.f10953d, this, this.f10950a.f10964d);
        }

        /* renamed from: a */
        private void m13457a(C4191b c4191b) {
            C4191b c4191b2 = this.f10954e;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f10955f = elapsedRealtime;
            this.f10954e = this.f10950a.m13473a(c4191b2, c4191b);
            if (this.f10954e != c4191b2) {
                this.f10960k = null;
                this.f10956g = elapsedRealtime;
                this.f10950a.m13477a(this.f10951b, this.f10954e);
            } else if (!this.f10954e.f10920j) {
                if (c4191b.f10916f + c4191b.f10924n.size() < this.f10954e.f10916f) {
                    this.f10960k = new C2400c(this.f10951b.f5897a);
                } else if (((double) (elapsedRealtime - this.f10956g)) > ((double) C2251b.m6221a(this.f10954e.f10918h)) * 3.5d) {
                    this.f10960k = new C2401d(this.f10951b.f5897a);
                    m13461g();
                }
            }
            this.f10957h = elapsedRealtime + C2251b.m6221a(this.f10954e != c4191b2 ? this.f10954e.f10918h : this.f10954e.f10918h / 2);
            if (this.f10951b == this.f10950a.f10972l && this.f10954e.f10920j == null) {
                m13471d();
            }
        }

        /* renamed from: g */
        private boolean m13461g() {
            this.f10958i = SystemClock.elapsedRealtime() + 60000;
            this.f10950a.m13476a(this.f10951b, 60000);
            return this.f10950a.f10972l == this.f10951b && !this.f10950a.m13490f();
        }
    }

    public C4194e(Uri uri, C2405e c2405e, C2429a c2429a, int i, C2402e c2402e, C2513a<C2396c> c2513a) {
        this.f10961a = uri;
        this.f10962b = c2405e;
        this.f10970j = c2429a;
        this.f10964d = i;
        this.f10967g = c2402e;
        this.f10963c = c2513a;
    }

    /* renamed from: a */
    public void m13497a(C2399b c2399b) {
        this.f10968h.add(c2399b);
    }

    /* renamed from: b */
    public void m13503b(C2399b c2399b) {
        this.f10968h.remove(c2399b);
    }

    /* renamed from: a */
    public void m13496a() {
        this.f10969i.m13797a(new C4253u(this.f10962b.mo2271a(4), this.f10961a, 4, this.f10963c), this, this.f10964d);
    }

    /* renamed from: b */
    public C4190a m13502b() {
        return this.f10971k;
    }

    /* renamed from: a */
    public C4191b m13495a(C2394a c2394a) {
        C4191b a = ((C4193a) this.f10965e.get(c2394a)).m13464a();
        if (a != null) {
            m13488e(c2394a);
        }
        return a;
    }

    /* renamed from: b */
    public boolean m13504b(C2394a c2394a) {
        return ((C4193a) this.f10965e.get(c2394a)).m13469b();
    }

    /* renamed from: c */
    public void m13505c() {
        this.f10969i.m13802c();
        for (C4193a c : this.f10965e.values()) {
            c.m13470c();
        }
        this.f10966f.removeCallbacksAndMessages(null);
        this.f10965e.clear();
    }

    /* renamed from: d */
    public void m13507d() {
        this.f10969i.mo2322d();
        if (this.f10972l != null) {
            m13506c(this.f10972l);
        }
    }

    /* renamed from: c */
    public void m13506c(C2394a c2394a) {
        ((C4193a) this.f10965e.get(c2394a)).m13472e();
    }

    /* renamed from: d */
    public void m13508d(C2394a c2394a) {
        ((C4193a) this.f10965e.get(c2394a)).m13471d();
    }

    /* renamed from: e */
    public boolean m13509e() {
        return this.f10974n;
    }

    /* renamed from: a */
    public void m13500a(C4253u<C2396c> c4253u, long j, long j2) {
        C4190a a;
        C4194e c4194e = this;
        C2396c c2396c = (C2396c) c4253u.m13808d();
        boolean z = c2396c instanceof C4191b;
        if (z) {
            a = C4190a.m13437a(c2396c.f5907p);
        } else {
            a = (C4190a) c2396c;
        }
        c4194e.f10971k = a;
        c4194e.f10972l = (C2394a) a.f10906a.get(0);
        List arrayList = new ArrayList();
        arrayList.addAll(a.f10906a);
        arrayList.addAll(a.f10907b);
        arrayList.addAll(a.f10908c);
        m13480a(arrayList);
        C4193a c4193a = (C4193a) c4194e.f10965e.get(c4194e.f10972l);
        if (z) {
            c4193a.m13457a((C4191b) c2396c);
        } else {
            c4193a.m13471d();
        }
        c4194e.f10970j.m6672a(c4253u.f11218a, 4, j, j2, c4253u.m13809e());
    }

    /* renamed from: a */
    public void m13501a(C4253u<C2396c> c4253u, long j, long j2, boolean z) {
        this.f10970j.m6675b(c4253u.f11218a, 4, j, j2, c4253u.m13809e());
    }

    /* renamed from: a */
    public int m13494a(C4253u<C2396c> c4253u, long j, long j2, IOException iOException) {
        IOException iOException2 = iOException;
        boolean z = iOException2 instanceof C2571p;
        this.f10970j.m6673a(c4253u.f11218a, 4, j, j2, c4253u.m13809e(), iOException2, z);
        return z ? 3 : 0;
    }

    /* renamed from: f */
    private boolean m13490f() {
        List list = this.f10971k.f10906a;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            C4193a c4193a = (C4193a) this.f10965e.get(list.get(i));
            if (elapsedRealtime > c4193a.f10958i) {
                this.f10972l = c4193a.f10951b;
                c4193a.m13471d();
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    private void m13488e(C2394a c2394a) {
        if (c2394a != this.f10972l && this.f10971k.f10906a.contains(c2394a)) {
            if (this.f10973m == null || !this.f10973m.f10920j) {
                this.f10972l = c2394a;
                ((C4193a) this.f10965e.get(this.f10972l)).m13471d();
            }
        }
    }

    /* renamed from: a */
    private void m13480a(List<C2394a> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C2394a c2394a = (C2394a) list.get(i);
            this.f10965e.put(c2394a, new C4193a(this, c2394a));
        }
    }

    /* renamed from: a */
    private void m13477a(C2394a c2394a, C4191b c4191b) {
        if (c2394a == this.f10972l) {
            if (this.f10973m == null) {
                this.f10974n = c4191b.f10920j ^ 1;
            }
            this.f10973m = c4191b;
            this.f10967g.mo2273a(c4191b);
        }
        C4191b size = this.f10968h.size();
        for (c4191b = null; c4191b < size; c4191b++) {
            ((C2399b) this.f10968h.get(c4191b)).mo3222h();
        }
    }

    /* renamed from: a */
    private void m13476a(C2394a c2394a, long j) {
        int size = this.f10968h.size();
        for (int i = 0; i < size; i++) {
            ((C2399b) this.f10968h.get(i)).mo3220a(c2394a, j);
        }
    }

    /* renamed from: a */
    private C4191b m13473a(C4191b c4191b, C4191b c4191b2) {
        if (c4191b2.m13440a(c4191b)) {
            return c4191b2.m13439a(m13481b(c4191b, c4191b2), m13483c(c4191b, c4191b2));
        }
        return c4191b2.f10920j != null ? c4191b.m13441b() : c4191b;
    }

    /* renamed from: b */
    private long m13481b(C4191b c4191b, C4191b c4191b2) {
        if (c4191b2.f10921k) {
            return c4191b2.f10913c;
        }
        long j = this.f10973m != null ? this.f10973m.f10913c : 0;
        if (c4191b == null) {
            return j;
        }
        int size = c4191b.f10924n.size();
        C2395a d = C4194e.m13486d(c4191b, c4191b2);
        if (d != null) {
            return c4191b.f10913c + d.f5902d;
        }
        return size == c4191b2.f10916f - c4191b.f10916f ? c4191b.m13438a() : j;
    }

    /* renamed from: c */
    private int m13483c(C4191b c4191b, C4191b c4191b2) {
        if (c4191b2.f10914d) {
            return c4191b2.f10915e;
        }
        int i = this.f10973m != null ? this.f10973m.f10915e : 0;
        if (c4191b == null) {
            return i;
        }
        C2395a d = C4194e.m13486d(c4191b, c4191b2);
        return d != null ? (c4191b.f10915e + d.f5901c) - ((C2395a) c4191b2.f10924n.get(0)).f5901c : i;
    }

    /* renamed from: d */
    private static C2395a m13486d(C4191b c4191b, C4191b c4191b2) {
        c4191b2 = c4191b2.f10916f - c4191b.f10916f;
        c4191b = c4191b.f10924n;
        return c4191b2 < c4191b.size() ? (C2395a) c4191b.get(c4191b2) : null;
    }
}
