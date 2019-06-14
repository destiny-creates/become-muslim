package com.google.android.exoplayer2;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.p135b.C4085e;
import com.google.android.exoplayer2.p136c.C2255a;
import com.google.android.exoplayer2.p136c.C2258c;
import com.google.android.exoplayer2.p149h.C2435m;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2523h;

/* compiled from: BaseRenderer */
/* renamed from: com.google.android.exoplayer2.a */
public abstract class C4690a implements C4256t, C2576u {
    /* renamed from: a */
    private final int f12643a;
    /* renamed from: b */
    private C2583v f12644b;
    /* renamed from: c */
    private int f12645c;
    /* renamed from: d */
    private int f12646d;
    /* renamed from: e */
    private C2435m f12647e;
    /* renamed from: f */
    private long f12648f;
    /* renamed from: g */
    private boolean f12649g = true;
    /* renamed from: h */
    private boolean f12650h;

    /* renamed from: a */
    public void mo3179a(int i, Object obj) {
    }

    /* renamed from: a */
    protected void mo3413a(long j, boolean z) {
    }

    /* renamed from: a */
    protected void mo3414a(boolean z) {
    }

    /* renamed from: a */
    protected void mo3420a(C2515k[] c2515kArr, long j) {
    }

    /* renamed from: b */
    public final C2576u mo3183b() {
        return this;
    }

    /* renamed from: c */
    public C2523h mo3184c() {
        return null;
    }

    /* renamed from: m */
    public int mo3194m() {
        return 0;
    }

    /* renamed from: n */
    protected void mo3415n() {
    }

    /* renamed from: o */
    protected void mo3416o() {
    }

    /* renamed from: p */
    protected void mo3417p() {
    }

    public C4690a(int i) {
        this.f12643a = i;
    }

    /* renamed from: a */
    public final int mo3177a() {
        return this.f12643a;
    }

    /* renamed from: a */
    public final void mo3178a(int i) {
        this.f12645c = i;
    }

    /* renamed from: d */
    public final int mo3185d() {
        return this.f12646d;
    }

    /* renamed from: a */
    public final void mo3181a(C2583v c2583v, C2515k[] c2515kArr, C2435m c2435m, long j, boolean z, long j2) {
        C2516a.m7019b(this.f12646d == 0);
        this.f12644b = c2583v;
        this.f12646d = 1;
        mo3414a(z);
        mo3182a(c2515kArr, c2435m, j2);
        mo3413a(j, z);
    }

    /* renamed from: e */
    public final void mo3186e() {
        boolean z = true;
        if (this.f12646d != 1) {
            z = false;
        }
        C2516a.m7019b(z);
        this.f12646d = 2;
        mo3415n();
    }

    /* renamed from: a */
    public final void mo3182a(C2515k[] c2515kArr, C2435m c2435m, long j) {
        C2516a.m7019b(this.f12650h ^ 1);
        this.f12647e = c2435m;
        this.f12649g = null;
        this.f12648f = j;
        mo3420a(c2515kArr, j);
    }

    /* renamed from: f */
    public final C2435m mo3187f() {
        return this.f12647e;
    }

    /* renamed from: g */
    public final boolean mo3188g() {
        return this.f12649g;
    }

    /* renamed from: h */
    public final void mo3189h() {
        this.f12650h = true;
    }

    /* renamed from: i */
    public final boolean mo3190i() {
        return this.f12650h;
    }

    /* renamed from: j */
    public final void mo3191j() {
        this.f12647e.f_();
    }

    /* renamed from: a */
    public final void mo3180a(long j) {
        this.f12650h = false;
        this.f12649g = false;
        mo3413a(j, false);
    }

    /* renamed from: k */
    public final void mo3192k() {
        C2516a.m7019b(this.f12646d == 2);
        this.f12646d = 1;
        mo3416o();
    }

    /* renamed from: l */
    public final void mo3193l() {
        boolean z = true;
        if (this.f12646d != 1) {
            z = false;
        }
        C2516a.m7019b(z);
        this.f12646d = 0;
        this.f12647e = null;
        this.f12650h = false;
        mo3417p();
    }

    /* renamed from: q */
    protected final C2583v m16025q() {
        return this.f12644b;
    }

    /* renamed from: r */
    protected final int m16026r() {
        return this.f12645c;
    }

    /* renamed from: a */
    protected final int m16000a(C2543l c2543l, C4085e c4085e, boolean z) {
        z = this.f12647e.mo2235a(c2543l, c4085e, z);
        int i = -4;
        if (z) {
            if (c4085e.m6206c() != null) {
                this.f12649g = true;
                if (this.f12650h == null) {
                    i = -3;
                }
                return i;
            }
            c4085e.f10319c += this.f12648f;
        } else if (z) {
            c4085e = c2543l.f6476a;
            if (c4085e.f6397w != Clock.MAX_TIME) {
                c2543l.f6476a = c4085e.m7008a(c4085e.f6397w + this.f12648f);
            }
        }
        return z;
    }

    /* renamed from: b */
    protected int m16009b(long j) {
        return this.f12647e.mo2234a(j - this.f12648f);
    }

    /* renamed from: s */
    protected final boolean m16027s() {
        return this.f12649g ? this.f12650h : this.f12647e.mo2236c();
    }

    /* renamed from: a */
    protected static boolean m15998a(C2258c<?> c2258c, C2255a c2255a) {
        if (c2255a == null) {
            return true;
        }
        return c2258c == null ? null : c2258c.m6239a(c2255a);
    }
}
