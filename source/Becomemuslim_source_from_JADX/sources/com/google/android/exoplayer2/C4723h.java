package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer2.C2575s.C2574a;
import com.google.android.exoplayer2.C2589y.C2587a;
import com.google.android.exoplayer2.C2589y.C2588b;
import com.google.android.exoplayer2.C4159f.C2332c;
import com.google.android.exoplayer2.p149h.C2423i;
import com.google.android.exoplayer2.p149h.C2423i.C2422b;
import com.google.android.exoplayer2.p149h.C2439q;
import com.google.android.exoplayer2.p162j.C2484f;
import com.google.android.exoplayer2.p162j.C2485g;
import com.google.android.exoplayer2.p162j.C2487h;
import com.google.android.exoplayer2.p162j.C2488i;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: ExoPlayerImpl */
/* renamed from: com.google.android.exoplayer2.h */
final class C4723h implements C4159f {
    /* renamed from: a */
    private final C4256t[] f12842a;
    /* renamed from: b */
    private final C2487h f12843b;
    /* renamed from: c */
    private final C2485g f12844c;
    /* renamed from: d */
    private final Handler f12845d;
    /* renamed from: e */
    private final C4728i f12846e;
    /* renamed from: f */
    private final CopyOnWriteArraySet<C2574a> f12847f;
    /* renamed from: g */
    private final C2588b f12848g;
    /* renamed from: h */
    private final C2587a f12849h;
    /* renamed from: i */
    private boolean f12850i;
    /* renamed from: j */
    private boolean f12851j;
    /* renamed from: k */
    private int f12852k;
    /* renamed from: l */
    private boolean f12853l;
    /* renamed from: m */
    private int f12854m;
    /* renamed from: n */
    private int f12855n;
    /* renamed from: o */
    private int f12856o;
    /* renamed from: p */
    private boolean f12857p;
    /* renamed from: q */
    private C2439q f12858q;
    /* renamed from: r */
    private C2485g f12859r;
    /* renamed from: s */
    private C2573r f12860s;
    /* renamed from: t */
    private C2572q f12861t;
    /* renamed from: u */
    private int f12862u;
    /* renamed from: v */
    private int f12863v;
    /* renamed from: w */
    private long f12864w;

    @SuppressLint({"HandlerLeak"})
    public C4723h(C4256t[] c4256tArr, C2487h c2487h, C2567n c2567n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Init ");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" [");
        stringBuilder.append("ExoPlayerLib/2.6.1");
        stringBuilder.append("] [");
        stringBuilder.append(C2541v.f6471e);
        stringBuilder.append("]");
        Log.i("ExoPlayerImpl", stringBuilder.toString());
        C2516a.m7019b(c4256tArr.length > 0);
        this.f12842a = (C4256t[]) C2516a.m7015a((Object) c4256tArr);
        this.f12843b = (C2487h) C2516a.m7015a((Object) c2487h);
        this.f12851j = false;
        this.f12852k = 0;
        this.f12853l = false;
        this.f12854m = 1;
        this.f12847f = new CopyOnWriteArraySet();
        this.f12844c = new C2485g(new C2484f[c4256tArr.length]);
        this.f12848g = new C2588b();
        this.f12849h = new C2587a();
        this.f12858q = C2439q.f6067a;
        this.f12859r = this.f12844c;
        this.f12860s = C2573r.f6571a;
        this.f12845d = new Handler(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) {
            /* renamed from: a */
            final /* synthetic */ C4723h f5827a;

            public void handleMessage(Message message) {
                this.f5827a.m16219a(message);
            }
        };
        this.f12861t = new C2572q(C2589y.f6638a, null, 0, 0);
        this.f12846e = new C4728i(c4256tArr, c2487h, c2567n, this.f12851j, this.f12852k, this.f12853l, this.f12845d, this);
    }

    /* renamed from: a */
    public void mo3230a(C2574a c2574a) {
        this.f12847f.add(c2574a);
    }

    /* renamed from: a */
    public int mo3225a() {
        return this.f12854m;
    }

    /* renamed from: a */
    public void mo3228a(C2423i c2423i) {
        m16221a(c2423i, true, true);
    }

    /* renamed from: a */
    public void m16221a(C2423i c2423i, boolean z, boolean z2) {
        if (z) {
            this.f12862u = 0;
            this.f12863v = 0;
            this.f12864w = 0;
        } else {
            this.f12862u = m16233g();
            this.f12863v = m16232f();
            this.f12864w = mo3239i();
        }
        if (z2) {
            if (!this.f12861t.f6564a.m7331a() || this.f12861t.f6565b) {
                this.f12861t = this.f12861t.m7272a(C2589y.f6638a, null);
                z2 = this.f12847f.iterator();
                while (z2.hasNext()) {
                    ((C2574a) z2.next()).onTimelineChanged(this.f12861t.f6564a, this.f12861t.f6565b);
                }
            }
            if (this.f12850i) {
                this.f12850i = false;
                this.f12858q = C2439q.f6067a;
                this.f12859r = this.f12844c;
                this.f12843b.mo2310a(null);
                z2 = this.f12847f.iterator();
                while (z2.hasNext()) {
                    ((C2574a) z2.next()).onTracksChanged(this.f12858q, this.f12859r);
                }
            }
        }
        this.f12856o++;
        this.f12846e.m16322a(c2423i, z);
    }

    /* renamed from: a */
    public void mo3231a(boolean z) {
        if (this.f12851j != z) {
            this.f12851j = z;
            this.f12846e.m16326a(z);
            Iterator it = this.f12847f.iterator();
            while (it.hasNext()) {
                ((C2574a) it.next()).onPlayerStateChanged(z, this.f12854m);
            }
        }
    }

    /* renamed from: b */
    public boolean mo3234b() {
        return this.f12851j;
    }

    /* renamed from: a */
    public void mo3226a(int i) {
        if (this.f12852k != i) {
            this.f12852k = i;
            this.f12846e.m16319a(i);
            Iterator it = this.f12847f.iterator();
            while (it.hasNext()) {
                ((C2574a) it.next()).onRepeatModeChanged(i);
            }
        }
    }

    /* renamed from: c */
    public void mo3235c() {
        m16226b(m16233g());
    }

    /* renamed from: b */
    public void m16226b(int i) {
        m16217a(i, -9223372036854775807L);
    }

    /* renamed from: a */
    public void mo3227a(long j) {
        m16217a(m16233g(), j);
    }

    /* renamed from: a */
    public void m16217a(int i, long j) {
        C2589y c2589y = this.f12861t.f6564a;
        if (i < 0 || (!c2589y.m7331a() && i >= c2589y.mo2259b())) {
            throw new C2566m(c2589y, i, j);
        } else if (m16238l()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            if (this.f12855n == 0) {
                i = this.f12847f.iterator();
                while (i.hasNext() != null) {
                    ((C2574a) i.next()).onSeekProcessed();
                }
            }
        } else {
            this.f12855n++;
            this.f12862u = i;
            if (c2589y.m7331a()) {
                this.f12864w = j == -9223372036854775807L ? 0 : j;
                this.f12863v = 0;
            } else {
                long a;
                c2589y.m7328a(i, this.f12848g);
                if (j == -9223372036854775807L) {
                    a = this.f12848g.m7316a();
                } else {
                    a = C2251b.m6222b(j);
                }
                int i2 = this.f12848g.f6633f;
                long c = this.f12848g.m7319c() + a;
                long a2 = c2589y.m7326a(i2, this.f12849h).m7303a();
                while (a2 != -9223372036854775807L && c >= a2 && i2 < this.f12848g.f6634g) {
                    c -= a2;
                    i2++;
                    a2 = c2589y.m7326a(i2, this.f12849h).m7303a();
                }
                this.f12864w = C2251b.m6221a(a);
                this.f12863v = i2;
            }
            this.f12846e.m16325a(c2589y, i, C2251b.m6222b(j));
            i = this.f12847f.iterator();
            while (i.hasNext() != null) {
                ((C2574a) i.next()).onPositionDiscontinuity(1);
            }
        }
    }

    /* renamed from: a */
    public void mo3229a(C2573r c2573r) {
        if (c2573r == null) {
            c2573r = C2573r.f6571a;
        }
        this.f12846e.m16324a(c2573r);
    }

    /* renamed from: d */
    public void mo3236d() {
        this.f12846e.m16318a();
    }

    /* renamed from: e */
    public void mo3237e() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Release ");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" [");
        stringBuilder.append("ExoPlayerLib/2.6.1");
        stringBuilder.append("] [");
        stringBuilder.append(C2541v.f6471e);
        stringBuilder.append("] [");
        stringBuilder.append(C2489j.m6938a());
        stringBuilder.append("]");
        Log.i("ExoPlayerImpl", stringBuilder.toString());
        this.f12846e.m16328b();
        this.f12845d.removeCallbacksAndMessages(null);
    }

    /* renamed from: a */
    public void mo3232a(C2332c... c2332cArr) {
        this.f12846e.m16327a(c2332cArr);
    }

    /* renamed from: b */
    public void mo3233b(C2332c... c2332cArr) {
        this.f12846e.m16330b(c2332cArr);
    }

    /* renamed from: f */
    public int m16232f() {
        if (m16214m()) {
            return this.f12863v;
        }
        return this.f12861t.f6566c.f5978b;
    }

    /* renamed from: g */
    public int m16233g() {
        if (m16214m()) {
            return this.f12862u;
        }
        return this.f12861t.f6564a.m7326a(this.f12861t.f6566c.f5978b, this.f12849h).f6619c;
    }

    /* renamed from: h */
    public long mo3238h() {
        C2589y c2589y = this.f12861t.f6564a;
        if (c2589y.m7331a()) {
            return -9223372036854775807L;
        }
        if (!m16238l()) {
            return c2589y.m7328a(m16233g(), this.f12848g).m7318b();
        }
        C2422b c2422b = this.f12861t.f6566c;
        c2589y.m7326a(c2422b.f5978b, this.f12849h);
        return C2251b.m6221a(this.f12849h.m7311b(c2422b.f5979c, c2422b.f5980d));
    }

    /* renamed from: i */
    public long mo3239i() {
        if (m16214m()) {
            return this.f12864w;
        }
        return m16213b(this.f12861t.f6569f);
    }

    /* renamed from: j */
    public long mo3240j() {
        if (m16214m()) {
            return this.f12864w;
        }
        return m16213b(this.f12861t.f6570g);
    }

    /* renamed from: k */
    public int mo3241k() {
        long j = mo3240j();
        long h = mo3238h();
        if (j != -9223372036854775807L) {
            if (h != -9223372036854775807L) {
                if (h == 0) {
                    return 100;
                }
                return C2541v.m7164a((int) ((j * 100) / h), 0, 100);
            }
        }
        return 0;
    }

    /* renamed from: l */
    public boolean m16238l() {
        return !m16214m() && this.f12861t.f6566c.m6657a();
    }

    /* renamed from: a */
    void m16219a(Message message) {
        boolean z = false;
        Iterator it;
        switch (message.what) {
            case 0:
                this.f12854m = message.arg1;
                message = this.f12847f.iterator();
                while (message.hasNext()) {
                    ((C2574a) message.next()).onPlayerStateChanged(this.f12851j, this.f12854m);
                }
                return;
            case 1:
                if (message.arg1 != null) {
                    z = true;
                }
                this.f12857p = z;
                message = this.f12847f.iterator();
                while (message.hasNext()) {
                    ((C2574a) message.next()).onLoadingChanged(this.f12857p);
                }
                return;
            case 2:
                if (this.f12856o == 0) {
                    C2488i c2488i = (C2488i) message.obj;
                    this.f12850i = true;
                    this.f12858q = c2488i.f6333a;
                    this.f12859r = c2488i.f6335c;
                    this.f12843b.mo2310a(c2488i.f6336d);
                    message = this.f12847f.iterator();
                    while (message.hasNext()) {
                        ((C2574a) message.next()).onTracksChanged(this.f12858q, this.f12859r);
                    }
                    return;
                }
                return;
            case 3:
                m16212a((C2572q) message.obj, 0, 1, message.arg1 != 0, 2);
                return;
            case 4:
                m16212a((C2572q) message.obj, 0, 0, true, message.arg1);
                return;
            case 5:
                m16212a((C2572q) message.obj, message.arg1, message.arg2, false, 3);
                return;
            case 6:
                C2573r c2573r = (C2573r) message.obj;
                if (!this.f12860s.equals(c2573r)) {
                    this.f12860s = c2573r;
                    it = this.f12847f.iterator();
                    while (it.hasNext()) {
                        ((C2574a) it.next()).onPlaybackParametersChanged(c2573r);
                    }
                    return;
                }
                return;
            case 7:
                C2330e c2330e = (C2330e) message.obj;
                it = this.f12847f.iterator();
                while (it.hasNext()) {
                    ((C2574a) it.next()).onPlayerError(c2330e);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    private void m16212a(C2572q c2572q, int i, int i2, boolean z, int i3) {
        C2516a.m7015a(c2572q.f6564a);
        this.f12856o -= i;
        this.f12855n -= i2;
        if (this.f12856o == 0 && this.f12855n == 0) {
            if (this.f12861t.f6564a == c2572q.f6564a) {
                if (this.f12861t.f6565b == c2572q.f6565b) {
                    i = 0;
                    this.f12861t = c2572q;
                    if (c2572q.f6564a.m7331a()) {
                        this.f12863v = 0;
                        this.f12862u = 0;
                        this.f12864w = 0;
                    }
                    if (i != 0) {
                        i = this.f12847f.iterator();
                        while (i.hasNext()) {
                            ((C2574a) i.next()).onTimelineChanged(c2572q.f6564a, c2572q.f6565b);
                        }
                    }
                    if (z) {
                        c2572q = this.f12847f.iterator();
                        while (c2572q.hasNext() != 0) {
                            ((C2574a) c2572q.next()).onPositionDiscontinuity(i3);
                        }
                    }
                }
            }
            i = 1;
            this.f12861t = c2572q;
            if (c2572q.f6564a.m7331a()) {
                this.f12863v = 0;
                this.f12862u = 0;
                this.f12864w = 0;
            }
            if (i != 0) {
                i = this.f12847f.iterator();
                while (i.hasNext()) {
                    ((C2574a) i.next()).onTimelineChanged(c2572q.f6564a, c2572q.f6565b);
                }
            }
            if (z) {
                c2572q = this.f12847f.iterator();
                while (c2572q.hasNext() != 0) {
                    ((C2574a) c2572q.next()).onPositionDiscontinuity(i3);
                }
            }
        }
        if (this.f12855n == null && i2 > 0) {
            c2572q = this.f12847f.iterator();
            while (c2572q.hasNext() != 0) {
                ((C2574a) c2572q.next()).onSeekProcessed();
            }
        }
    }

    /* renamed from: b */
    private long m16213b(long j) {
        j = C2251b.m6221a(j);
        if (this.f12861t.f6566c.m6657a()) {
            return j;
        }
        this.f12861t.f6564a.m7326a(this.f12861t.f6566c.f5978b, this.f12849h);
        return j + this.f12849h.m7310b();
    }

    /* renamed from: m */
    private boolean m16214m() {
        if (!this.f12861t.f6564a.m7331a() && this.f12855n <= 0) {
            if (this.f12856o <= 0) {
                return false;
            }
        }
        return true;
    }
}
