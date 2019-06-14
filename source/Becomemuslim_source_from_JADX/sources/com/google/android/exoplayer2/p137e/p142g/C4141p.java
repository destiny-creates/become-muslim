package com.google.android.exoplayer2.p137e.p142g;

import android.util.Log;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2528k;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2537s;

/* compiled from: PesReader */
/* renamed from: com.google.android.exoplayer2.e.g.p */
public final class C4141p implements C2319w {
    /* renamed from: a */
    private final C2305h f10721a;
    /* renamed from: b */
    private final C2528k f10722b = new C2528k(new byte[10]);
    /* renamed from: c */
    private int f10723c = null;
    /* renamed from: d */
    private int f10724d;
    /* renamed from: e */
    private C2537s f10725e;
    /* renamed from: f */
    private boolean f10726f;
    /* renamed from: g */
    private boolean f10727g;
    /* renamed from: h */
    private boolean f10728h;
    /* renamed from: i */
    private int f10729i;
    /* renamed from: j */
    private int f10730j;
    /* renamed from: k */
    private boolean f10731k;
    /* renamed from: l */
    private long f10732l;

    public C4141p(C2305h c2305h) {
        this.f10721a = c2305h;
    }

    /* renamed from: a */
    public void mo2217a(C2537s c2537s, C2320g c2320g, C2318d c2318d) {
        this.f10725e = c2537s;
        this.f10721a.mo2210a(c2320g, c2318d);
    }

    /* renamed from: a */
    public final void mo2215a() {
        this.f10723c = 0;
        this.f10724d = 0;
        this.f10728h = false;
        this.f10721a.mo2208a();
    }

    /* renamed from: a */
    public final void mo2216a(C2529l c2529l, boolean z) {
        if (z) {
            switch (this.f10723c) {
                case false:
                case true:
                    break;
                case true:
                    Log.w("PesReader", "Unexpected start indicator reading extended header");
                    break;
                case true:
                    if (!this.f10730j) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unexpected start indicator: expected ");
                        stringBuilder.append(this.f10730j);
                        stringBuilder.append(" more bytes");
                        Log.w("PesReader", stringBuilder.toString());
                    }
                    this.f10721a.mo2212b();
                    break;
                default:
                    break;
            }
            m13150a(1);
        }
        while (c2529l.m7093b() <= false) {
            int i = 0;
            switch (this.f10723c) {
                case false:
                    c2529l.m7098d(c2529l.m7093b());
                    break;
                case true:
                    if (!m13151a(c2529l, this.f10722b.f6437a, 9)) {
                        break;
                    }
                    if (m13152b()) {
                        i = 2;
                    }
                    m13150a(i);
                    break;
                case true:
                    if (m13151a(c2529l, this.f10722b.f6437a, Math.min(true, this.f10729i)) && m13151a(c2529l, (byte[]) false, this.f10729i)) {
                        m13153c();
                        this.f10721a.mo2209a(this.f10732l, this.f10731k);
                        m13150a(true);
                        break;
                    }
                case true:
                    z = c2529l.m7093b();
                    if (this.f10730j != -1) {
                        i = z - this.f10730j;
                    }
                    if (i > 0) {
                        z -= i;
                        c2529l.m7094b(c2529l.m7097d() + z);
                    }
                    this.f10721a.mo2211a(c2529l);
                    if (this.f10730j == -1) {
                        break;
                    }
                    this.f10730j -= z;
                    if (!this.f10730j) {
                        this.f10721a.mo2212b();
                        m13150a(1);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: a */
    private void m13150a(int i) {
        this.f10723c = i;
        this.f10724d = 0;
    }

    /* renamed from: a */
    private boolean m13151a(C2529l c2529l, byte[] bArr, int i) {
        int min = Math.min(c2529l.m7093b(), i - this.f10724d);
        boolean z = true;
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            c2529l.m7098d(min);
        } else {
            c2529l.m7092a(bArr, this.f10724d, min);
        }
        this.f10724d += min;
        if (this.f10724d != i) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    private boolean m13152b() {
        this.f10722b.m7073a(0);
        int c = this.f10722b.m7081c(24);
        if (c != 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected start code prefix: ");
            stringBuilder.append(c);
            Log.w("PesReader", stringBuilder.toString());
            this.f10730j = -1;
            return false;
        }
        this.f10722b.m7078b(8);
        c = this.f10722b.m7081c(16);
        this.f10722b.m7078b(5);
        this.f10731k = this.f10722b.m7084e();
        this.f10722b.m7078b(2);
        this.f10726f = this.f10722b.m7084e();
        this.f10727g = this.f10722b.m7084e();
        this.f10722b.m7078b(6);
        this.f10729i = this.f10722b.m7081c(8);
        if (c == 0) {
            this.f10730j = -1;
        } else {
            this.f10730j = ((c + 6) - 9) - this.f10729i;
        }
        return true;
    }

    /* renamed from: c */
    private void m13153c() {
        this.f10722b.m7073a(0);
        this.f10732l = -9223372036854775807L;
        if (this.f10726f) {
            this.f10722b.m7078b(4);
            long c = ((long) this.f10722b.m7081c(3)) << 30;
            this.f10722b.m7078b(1);
            c |= (long) (this.f10722b.m7081c(15) << 15);
            this.f10722b.m7078b(1);
            c |= (long) this.f10722b.m7081c(15);
            this.f10722b.m7078b(1);
            if (!this.f10728h && this.f10727g) {
                this.f10722b.m7078b(4);
                long c2 = ((long) this.f10722b.m7081c(3)) << 30;
                this.f10722b.m7078b(1);
                c2 |= (long) (this.f10722b.m7081c(15) << 15);
                this.f10722b.m7078b(1);
                c2 |= (long) this.f10722b.m7081c(15);
                this.f10722b.m7078b(1);
                this.f10725e.m7149b(c2);
                this.f10728h = true;
            }
            this.f10732l = this.f10725e.m7149b(c);
        }
    }
}
