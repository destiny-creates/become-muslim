package com.google.android.exoplayer2.p149h.p151b;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.amplitude.api.Constants;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.C2251b;
import com.google.android.exoplayer2.C2489j;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.C2589y;
import com.google.android.exoplayer2.C2589y.C2587a;
import com.google.android.exoplayer2.C2589y.C2588b;
import com.google.android.exoplayer2.C4159f;
import com.google.android.exoplayer2.p149h.C2423i;
import com.google.android.exoplayer2.p149h.C2423i.C2421a;
import com.google.android.exoplayer2.p149h.C2423i.C2422b;
import com.google.android.exoplayer2.p149h.C2430j;
import com.google.android.exoplayer2.p149h.C2430j.C2429a;
import com.google.android.exoplayer2.p149h.C4219h;
import com.google.android.exoplayer2.p149h.p151b.C4180a.C2374a;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2375a;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2376b;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2379e;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2382g;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2386k;
import com.google.android.exoplayer2.p149h.p151b.p152a.C4174c;
import com.google.android.exoplayer2.p163k.C2492b;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2498g.C2497a;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p163k.C2512t;
import com.google.android.exoplayer2.p163k.C2512t.C4252a;
import com.google.android.exoplayer2.p163k.C4251s;
import com.google.android.exoplayer2.p163k.C4251s.C2506a;
import com.google.android.exoplayer2.p163k.C4253u;
import com.google.android.exoplayer2.p163k.C4253u.C2513a;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2541v;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* compiled from: DashMediaSource */
/* renamed from: com.google.android.exoplayer2.h.b.c */
public final class C4186c implements C2423i {
    /* renamed from: a */
    private final boolean f10874a;
    /* renamed from: b */
    private final C2497a f10875b;
    /* renamed from: c */
    private final C2374a f10876c;
    /* renamed from: d */
    private final int f10877d;
    /* renamed from: e */
    private final long f10878e;
    /* renamed from: f */
    private final C2429a f10879f;
    /* renamed from: g */
    private final C2513a<? extends C2376b> f10880g;
    /* renamed from: h */
    private final C4183c f10881h;
    /* renamed from: i */
    private final Object f10882i;
    /* renamed from: j */
    private final SparseArray<C4715b> f10883j;
    /* renamed from: k */
    private final Runnable f10884k;
    /* renamed from: l */
    private final Runnable f10885l;
    /* renamed from: m */
    private C2421a f10886m;
    /* renamed from: n */
    private C2498g f10887n;
    /* renamed from: o */
    private C4251s f10888o;
    /* renamed from: p */
    private C2512t f10889p;
    /* renamed from: q */
    private Uri f10890q;
    /* renamed from: r */
    private long f10891r;
    /* renamed from: s */
    private long f10892s;
    /* renamed from: t */
    private C2376b f10893t;
    /* renamed from: u */
    private Handler f10894u;
    /* renamed from: v */
    private long f10895v;
    /* renamed from: w */
    private int f10896w;

    /* compiled from: DashMediaSource */
    /* renamed from: com.google.android.exoplayer2.h.b.c$1 */
    class C23881 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C4186c f5887a;

        C23881(C4186c c4186c) {
            this.f5887a = c4186c;
        }

        public void run() {
            this.f5887a.m13410c();
        }
    }

    /* compiled from: DashMediaSource */
    /* renamed from: com.google.android.exoplayer2.h.b.c$2 */
    class C23892 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C4186c f5888a;

        C23892(C4186c c4186c) {
            this.f5888a = c4186c;
        }

        public void run() {
            this.f5888a.m13408a(false);
        }
    }

    /* compiled from: DashMediaSource */
    /* renamed from: com.google.android.exoplayer2.h.b.c$d */
    private static final class C2390d {
        /* renamed from: a */
        public final boolean f5889a;
        /* renamed from: b */
        public final long f5890b;
        /* renamed from: c */
        public final long f5891c;

        /* renamed from: a */
        public static C2390d m6587a(C2379e c2379e, long j) {
            C2379e c2379e2 = c2379e;
            long j2 = j;
            int size = c2379e2.f5858c.size();
            int i = 0;
            long j3 = Clock.MAX_TIME;
            int i2 = 0;
            Object obj = null;
            boolean z = false;
            long j4 = 0;
            while (i2 < size) {
                C2391d e = ((C2382g) ((C2375a) c2379e2.f5858c.get(i2)).f5832c.get(i)).mo2254e();
                if (e == null) {
                    return new C2390d(true, 0, j);
                }
                int i3;
                z |= e.mo2252b();
                int a = e.mo2247a(j2);
                if (a == 0) {
                    i3 = i2;
                    obj = 1;
                    j4 = 0;
                    j3 = 0;
                } else if (obj == null) {
                    int a2 = e.mo2246a();
                    i3 = i2;
                    long max = Math.max(j4, e.mo2249a(a2));
                    if (a != -1) {
                        a2 = (a2 + a) - 1;
                        j3 = Math.min(j3, e.mo2249a(a2) + e.mo2250a(a2, j2));
                    }
                    j4 = max;
                } else {
                    i3 = i2;
                }
                i2 = i3 + 1;
                i = 0;
            }
            return new C2390d(z, j4, j3);
        }

        private C2390d(boolean z, long j, long j2) {
            this.f5889a = z;
            this.f5890b = j;
            this.f5891c = j2;
        }
    }

    /* compiled from: DashMediaSource */
    /* renamed from: com.google.android.exoplayer2.h.b.c$a */
    private static final class C4181a extends C2589y {
        /* renamed from: b */
        private final long f10864b;
        /* renamed from: c */
        private final long f10865c;
        /* renamed from: d */
        private final int f10866d;
        /* renamed from: e */
        private final long f10867e;
        /* renamed from: f */
        private final long f10868f;
        /* renamed from: g */
        private final long f10869g;
        /* renamed from: h */
        private final C2376b f10870h;

        /* renamed from: b */
        public int mo2259b() {
            return 1;
        }

        public C4181a(long j, long j2, int i, long j3, long j4, long j5, C2376b c2376b) {
            this.f10864b = j;
            this.f10865c = j2;
            this.f10866d = i;
            this.f10867e = j3;
            this.f10868f = j4;
            this.f10869g = j5;
            this.f10870h = c2376b;
        }

        /* renamed from: c */
        public int mo2260c() {
            return this.f10870h.m6568a();
        }

        /* renamed from: a */
        public C2587a mo2257a(int i, C2587a c2587a, boolean z) {
            C2516a.m7014a(i, 0, this.f10870h.m6568a());
            Integer num = null;
            Object obj = z ? this.f10870h.m6569a(i).f5856a : null;
            if (z) {
                num = Integer.valueOf(this.f10866d + C2516a.m7014a(i, 0, this.f10870h.m6568a()));
            }
            return c2587a.m7305a(obj, num, 0, this.f10870h.m6571c(i), C2251b.m6222b(this.f10870h.m6569a(i).f5857b - this.f10870h.m6569a(0).f5857b) - this.f10867e);
        }

        /* renamed from: a */
        public C2588b mo2258a(int i, C2588b c2588b, boolean z, long j) {
            C2516a.m7014a(i, 0, 1);
            return c2588b.m7317a(null, this.f10864b, this.f10865c, true, this.f10870h.f5838d, m13379a(j), this.f10868f, 0, this.f10870h.m6568a() - 1, this.f10867e);
        }

        /* renamed from: a */
        public int mo2256a(Object obj) {
            int i = -1;
            if (!(obj instanceof Integer)) {
                return -1;
            }
            obj = ((Integer) obj).intValue();
            if (obj >= this.f10866d) {
                if (obj < this.f10866d + mo2260c()) {
                    i = obj - this.f10866d;
                }
            }
            return i;
        }

        /* renamed from: a */
        private long m13379a(long j) {
            long j2 = this.f10869g;
            if (!this.f10870h.f5838d) {
                return j2;
            }
            if (j > 0) {
                j2 += j;
                if (j2 > this.f10868f) {
                    return -9223372036854775807L;
                }
            }
            j = this.f10867e + j2;
            long c = this.f10870h.m6571c(0);
            long j3 = j;
            j = null;
            while (j < this.f10870h.m6568a() - 1 && j3 >= c) {
                j3 -= c;
                j++;
                c = this.f10870h.m6571c(j);
            }
            j = this.f10870h.m6569a(j);
            int a = j.m6572a(2);
            if (a == -1) {
                return j2;
            }
            j = ((C2382g) ((C2375a) j.f5858c.get(a)).f5832c.get(0)).mo2254e();
            if (j != null) {
                if (j.mo2247a(c) != 0) {
                    return (j2 + j.mo2249a(j.mo2248a(j3, c))) - j3;
                }
            }
            return j2;
        }
    }

    /* compiled from: DashMediaSource */
    /* renamed from: com.google.android.exoplayer2.h.b.c$b */
    static final class C4182b implements C2513a<Long> {
        /* renamed from: a */
        private static final Pattern f10871a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        C4182b() {
        }

        /* renamed from: b */
        public /* synthetic */ Object mo2245b(Uri uri, InputStream inputStream) {
            return m13385a(uri, inputStream);
        }

        /* renamed from: a */
        public Long m13385a(Uri uri, InputStream inputStream) {
            uri = new BufferedReader(new InputStreamReader(inputStream)).readLine();
            try {
                inputStream = f10871a.matcher(uri);
                if (inputStream.matches()) {
                    uri = inputStream.group(1);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    long time = simpleDateFormat.parse(uri).getTime();
                    if ("Z".equals(inputStream.group(2)) == null) {
                        long j = "+".equals(inputStream.group(4)) != null ? 1 : -1;
                        long parseLong = Long.parseLong(inputStream.group(5));
                        uri = inputStream.group(7);
                        time -= j * ((((parseLong * 60) + (TextUtils.isEmpty(uri) != null ? 0 : Long.parseLong(uri))) * 60) * 1000);
                    }
                    return Long.valueOf(time);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Couldn't parse timestamp: ");
                stringBuilder.append(uri);
                throw new C2571p(stringBuilder.toString());
            } catch (Throwable e) {
                throw new C2571p(e);
            }
        }
    }

    /* compiled from: DashMediaSource */
    /* renamed from: com.google.android.exoplayer2.h.b.c$c */
    private final class C4183c implements C2506a<C4253u<C2376b>> {
        /* renamed from: a */
        final /* synthetic */ C4186c f10872a;

        private C4183c(C4186c c4186c) {
            this.f10872a = c4186c;
        }

        /* renamed from: a */
        public void m13391a(C4253u<C2376b> c4253u, long j, long j2) {
            this.f10872a.m13418a((C4253u) c4253u, j, j2);
        }

        /* renamed from: a */
        public void m13392a(C4253u<C2376b> c4253u, long j, long j2, boolean z) {
            this.f10872a.m13422c(c4253u, j, j2);
        }

        /* renamed from: a */
        public int m13388a(C4253u<C2376b> c4253u, long j, long j2, IOException iOException) {
            return this.f10872a.m13413a(c4253u, j, j2, iOException);
        }
    }

    /* compiled from: DashMediaSource */
    /* renamed from: com.google.android.exoplayer2.h.b.c$e */
    private final class C4184e implements C2506a<C4253u<Long>> {
        /* renamed from: a */
        final /* synthetic */ C4186c f10873a;

        private C4184e(C4186c c4186c) {
            this.f10873a = c4186c;
        }

        /* renamed from: a */
        public void m13397a(C4253u<Long> c4253u, long j, long j2) {
            this.f10873a.m13421b(c4253u, j, j2);
        }

        /* renamed from: a */
        public void m13398a(C4253u<Long> c4253u, long j, long j2, boolean z) {
            this.f10873a.m13422c(c4253u, j, j2);
        }

        /* renamed from: a */
        public int m13394a(C4253u<Long> c4253u, long j, long j2, IOException iOException) {
            return this.f10873a.m13419b(c4253u, j, j2, iOException);
        }
    }

    /* compiled from: DashMediaSource */
    /* renamed from: com.google.android.exoplayer2.h.b.c$f */
    private static final class C4185f implements C2513a<Long> {
        private C4185f() {
        }

        /* renamed from: b */
        public /* synthetic */ Object mo2245b(Uri uri, InputStream inputStream) {
            return m13399a(uri, inputStream);
        }

        /* renamed from: a */
        public Long m13399a(Uri uri, InputStream inputStream) {
            return Long.valueOf(C2541v.m7192f(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        C2489j.m6939a("goog.exo.dash");
    }

    @Deprecated
    public C4186c(Uri uri, C2497a c2497a, C2374a c2374a, Handler handler, C2430j c2430j) {
        this(uri, c2497a, c2374a, 3, -1, handler, c2430j);
    }

    @Deprecated
    public C4186c(Uri uri, C2497a c2497a, C2374a c2374a, int i, long j, Handler handler, C2430j c2430j) {
        this(uri, c2497a, new C4174c(), c2374a, i, j, handler, c2430j);
    }

    @Deprecated
    public C4186c(Uri uri, C2497a c2497a, C2513a<? extends C2376b> c2513a, C2374a c2374a, int i, long j, Handler handler, C2430j c2430j) {
        this(null, uri, c2497a, c2513a, c2374a, i, j, handler, c2430j);
    }

    private C4186c(C2376b c2376b, Uri uri, C2497a c2497a, C2513a<? extends C2376b> c2513a, C2374a c2374a, int i, long j, Handler handler, C2430j c2430j) {
        this.f10893t = c2376b;
        this.f10890q = uri;
        this.f10875b = c2497a;
        this.f10880g = c2513a;
        this.f10876c = c2374a;
        this.f10877d = i;
        this.f10878e = j;
        this.f10874a = c2376b != null ? true : null;
        this.f10879f = new C2429a(handler, c2430j);
        this.f10882i = new Object();
        this.f10883j = new SparseArray();
        if (this.f10874a != null) {
            C2516a.m7019b(c2376b.f5838d ^ 1);
            this.f10881h = null;
            this.f10884k = null;
            this.f10885l = null;
            return;
        }
        this.f10881h = new C4183c();
        this.f10884k = new C23881(this);
        this.f10885l = new C23892(this);
    }

    /* renamed from: a */
    public void mo2263a(C4159f c4159f, boolean z, C2421a c2421a) {
        this.f10886m = c2421a;
        if (this.f10874a != null) {
            this.f10889p = new C4252a();
            m13408a((boolean) null);
            return;
        }
        this.f10887n = this.f10875b.createDataSource();
        this.f10888o = new C4251s("Loader:DashMediaSource");
        this.f10889p = this.f10888o;
        this.f10894u = new Handler();
        m13410c();
    }

    /* renamed from: a */
    public void mo2262a() {
        this.f10889p.mo2322d();
    }

    /* renamed from: a */
    public C4219h mo2261a(C2422b c2422b, C2492b c2492b) {
        int i = c2422b.f5978b;
        C2422b c4715b = new C4715b(this.f10896w + i, this.f10893t, i, this.f10876c, this.f10877d, this.f10879f.m6666a(this.f10893t.m6569a(i).f5857b), this.f10895v, this.f10889p, c2492b);
        this.f10883j.put(c4715b.f12739a, c4715b);
        return c4715b;
    }

    /* renamed from: a */
    public void mo2264a(C4219h c4219h) {
        C4715b c4715b = (C4715b) c4219h;
        c4715b.m16095f();
        this.f10883j.remove(c4715b.f12739a);
    }

    /* renamed from: b */
    public void mo2265b() {
        this.f10887n = null;
        this.f10889p = null;
        if (this.f10888o != null) {
            this.f10888o.m13802c();
            this.f10888o = null;
        }
        this.f10891r = 0;
        this.f10892s = 0;
        this.f10893t = null;
        if (this.f10894u != null) {
            this.f10894u.removeCallbacksAndMessages(null);
            this.f10894u = null;
        }
        this.f10895v = 0;
        this.f10883j.clear();
    }

    /* renamed from: a */
    void m13418a(C4253u<C2376b> c4253u, long j, long j2) {
        this.f10879f.m6672a(c4253u.f11218a, c4253u.f11219b, j, j2, c4253u.m13809e());
        C2376b c2376b = (C2376b) c4253u.m13808d();
        int i = 0;
        int a = this.f10893t == null ? 0 : this.f10893t.m6568a();
        long j3 = c2376b.m6569a(0).f5857b;
        while (i < a && this.f10893t.m6569a(i).f5857b < j3) {
            i++;
        }
        if (a - i > c2376b.m6568a()) {
            Log.w("DashMediaSource", "Out of sync manifest");
            m13411d();
            return;
        }
        this.f10893t = c2376b;
        this.f10891r = j - j2;
        this.f10892s = j;
        if (this.f10893t.f5844j != null) {
            synchronized (this.f10882i) {
                if (c4253u.f11218a.f6349a == this.f10890q) {
                    this.f10890q = this.f10893t.f5844j;
                }
            }
        }
        if (a != 0) {
            this.f10896w += i;
            m13408a(true);
        } else if (this.f10893t.f5843i != null) {
            m13402a(this.f10893t.f5843i);
        } else {
            m13408a(true);
        }
    }

    /* renamed from: a */
    int m13413a(C4253u<C2376b> c4253u, long j, long j2, IOException iOException) {
        C4253u<C2376b> c4253u2 = c4253u;
        IOException iOException2 = iOException;
        boolean z = iOException2 instanceof C2571p;
        this.f10879f.m6673a(c4253u2.f11218a, c4253u2.f11219b, j, j2, c4253u.m13809e(), iOException2, z);
        return z ? 3 : 0;
    }

    /* renamed from: b */
    void m13421b(C4253u<Long> c4253u, long j, long j2) {
        this.f10879f.m6672a(c4253u.f11218a, c4253u.f11219b, j, j2, c4253u.m13809e());
        m13401a(((Long) c4253u.m13808d()).longValue() - j);
    }

    /* renamed from: b */
    int m13419b(C4253u<Long> c4253u, long j, long j2, IOException iOException) {
        C4253u<Long> c4253u2 = c4253u;
        C2429a c2429a = this.f10879f;
        C2501j c2501j = c4253u2.f11218a;
        int i = c4253u2.f11219b;
        c2429a.m6673a(c2501j, i, j, j2, c4253u.m13809e(), iOException, true);
        m13407a(iOException);
        return 2;
    }

    /* renamed from: c */
    void m13422c(C4253u<?> c4253u, long j, long j2) {
        this.f10879f.m6675b(c4253u.f11218a, c4253u.f11219b, j, j2, c4253u.m13809e());
    }

    /* renamed from: c */
    private void m13410c() {
        Uri uri;
        synchronized (this.f10882i) {
            uri = this.f10890q;
        }
        m13406a(new C4253u(this.f10887n, uri, 4, this.f10880g), this.f10881h, this.f10877d);
    }

    /* renamed from: a */
    private void m13402a(C2386k c2386k) {
        Object obj = c2386k.f5879a;
        if (!C2541v.m7179a(obj, (Object) "urn:mpeg:dash:utc:direct:2014")) {
            if (!C2541v.m7179a(obj, (Object) "urn:mpeg:dash:utc:direct:2012")) {
                if (!C2541v.m7179a(obj, (Object) "urn:mpeg:dash:utc:http-iso:2014")) {
                    if (!C2541v.m7179a(obj, (Object) "urn:mpeg:dash:utc:http-iso:2012")) {
                        if (!C2541v.m7179a(obj, (Object) "urn:mpeg:dash:utc:http-xsdate:2014")) {
                            if (!C2541v.m7179a(obj, (Object) "urn:mpeg:dash:utc:http-xsdate:2012")) {
                                m13407a(new IOException("Unsupported UTC timing scheme"));
                                return;
                            }
                        }
                        m13403a(c2386k, new C4185f());
                        return;
                    }
                }
                m13403a(c2386k, new C4182b());
                return;
            }
        }
        m13409b(c2386k);
    }

    /* renamed from: b */
    private void m13409b(C2386k c2386k) {
        try {
            m13401a(C2541v.m7192f(c2386k.f5880b) - this.f10892s);
        } catch (IOException e) {
            m13407a(e);
        }
    }

    /* renamed from: a */
    private void m13403a(C2386k c2386k, C2513a<Long> c2513a) {
        m13406a(new C4253u(this.f10887n, Uri.parse(c2386k.f5880b), 5, (C2513a) c2513a), new C4184e(), 1);
    }

    /* renamed from: a */
    private void m13401a(long j) {
        this.f10895v = j;
        m13408a((boolean) 1);
    }

    /* renamed from: a */
    private void m13407a(IOException iOException) {
        Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", iOException);
        m13408a(true);
    }

    /* renamed from: a */
    private void m13408a(boolean z) {
        int i;
        long j;
        Object obj;
        C4186c c4186c = this;
        for (i = 0; i < c4186c.f10883j.size(); i++) {
            int keyAt = c4186c.f10883j.keyAt(i);
            if (keyAt >= c4186c.f10896w) {
                ((C4715b) c4186c.f10883j.valueAt(i)).m16086a(c4186c.f10893t, keyAt - c4186c.f10896w);
            }
        }
        i = c4186c.f10893t.m6568a() - 1;
        C2390d a = C2390d.m6587a(c4186c.f10893t.m6569a(0), c4186c.f10893t.m6571c(0));
        C2390d a2 = C2390d.m6587a(c4186c.f10893t.m6569a(i), c4186c.f10893t.m6571c(i));
        long j2 = a.f5890b;
        long j3 = a2.f5891c;
        long j4 = 0;
        if (!c4186c.f10893t.f5838d || a2.f5889a) {
            j = j2;
            obj = null;
        } else {
            j3 = Math.min((m13412e() - C2251b.m6222b(c4186c.f10893t.f5835a)) - C2251b.m6222b(c4186c.f10893t.m6569a(i).f5857b), j3);
            if (c4186c.f10893t.f5840f != -9223372036854775807L) {
                long b = j3 - C2251b.m6222b(c4186c.f10893t.f5840f);
                while (b < 0 && i > 0) {
                    i--;
                    b += c4186c.f10893t.m6571c(i);
                }
                if (i == 0) {
                    b = Math.max(j2, b);
                } else {
                    b = c4186c.f10893t.m6571c(0);
                }
                j2 = b;
            }
            j = j2;
            obj = 1;
        }
        long j5 = j3 - j;
        for (int i2 = 0; i2 < c4186c.f10893t.m6568a() - 1; i2++) {
            j5 += c4186c.f10893t.m6571c(i2);
        }
        if (c4186c.f10893t.f5838d) {
            long j6 = c4186c.f10878e;
            if (j6 == -1) {
                j6 = c4186c.f10893t.f5841g != -9223372036854775807L ? c4186c.f10893t.f5841g : Constants.EVENT_UPLOAD_PERIOD_MILLIS;
            }
            j4 = j5 - C2251b.m6222b(j6);
            if (j4 < 5000000) {
                j4 = Math.min(5000000, j5 / 2);
            }
        }
        long a3 = (c4186c.f10893t.f5835a + c4186c.f10893t.m6569a(0).f5857b) + C2251b.m6221a(j);
        c4186c.f10886m.mo3249a(c4186c, new C4181a(c4186c.f10893t.f5835a, a3, c4186c.f10896w, j, j5, j4, c4186c.f10893t), c4186c.f10893t);
        if (!c4186c.f10874a) {
            c4186c.f10894u.removeCallbacks(c4186c.f10885l);
            if (obj != null) {
                c4186c.f10894u.postDelayed(c4186c.f10885l, 5000);
            }
            if (z) {
                m13411d();
            }
        }
    }

    /* renamed from: d */
    private void m13411d() {
        if (this.f10893t.f5838d) {
            long j = this.f10893t.f5839e;
            if (j == 0) {
                j = 5000;
            }
            this.f10894u.postDelayed(this.f10884k, Math.max(0, (this.f10891r + j) - SystemClock.elapsedRealtime()));
        }
    }

    /* renamed from: a */
    private <T> void m13406a(C4253u<T> c4253u, C2506a<C4253u<T>> c2506a, int i) {
        this.f10879f.m6671a(c4253u.f11218a, c4253u.f11219b, this.f10888o.m13797a(c4253u, c2506a, i));
    }

    /* renamed from: e */
    private long m13412e() {
        if (this.f10895v != 0) {
            return C2251b.m6222b(SystemClock.elapsedRealtime() + this.f10895v);
        }
        return C2251b.m6222b(System.currentTimeMillis());
    }
}
