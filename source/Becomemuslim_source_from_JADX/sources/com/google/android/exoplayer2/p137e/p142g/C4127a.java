package com.google.android.exoplayer2.p137e.p142g;

import com.facebook.internal.Utility;
import com.google.android.exoplayer2.p134a.C2216a;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2323h;
import com.google.android.exoplayer2.p137e.C2326k;
import com.google.android.exoplayer2.p137e.C2327l.C4154a;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: Ac3Extractor */
/* renamed from: com.google.android.exoplayer2.e.g.a */
public final class C4127a implements C2303e {
    /* renamed from: a */
    public static final C2323h f10579a = new C41261();
    /* renamed from: b */
    private static final int f10580b = C2541v.m7193g("ID3");
    /* renamed from: c */
    private final long f10581c;
    /* renamed from: d */
    private final C4128b f10582d;
    /* renamed from: e */
    private final C2529l f10583e;
    /* renamed from: f */
    private boolean f10584f;

    /* compiled from: Ac3Extractor */
    /* renamed from: com.google.android.exoplayer2.e.g.a$1 */
    static class C41261 implements C2323h {
        C41261() {
        }

        /* renamed from: a */
        public C2303e[] mo2161a() {
            return new C2303e[]{new C4127a()};
        }
    }

    /* renamed from: c */
    public void mo2166c() {
    }

    public C4127a() {
        this(0);
    }

    public C4127a(long j) {
        this.f10581c = j;
        this.f10582d = new C4128b();
        this.f10583e = new C2529l(2786);
    }

    /* renamed from: a */
    public boolean mo2165a(C2304f c2304f) {
        C2529l c2529l = new C2529l(10);
        int i = 0;
        while (true) {
            c2304f.mo2191c(c2529l.f6441a, 0, 10);
            c2529l.m7096c(0);
            if (c2529l.m7107k() != f10580b) {
                break;
            }
            c2529l.m7098d(3);
            int t = c2529l.m7116t();
            i += t + 10;
            c2304f.mo2190c(t);
        }
        c2304f.mo2183a();
        c2304f.mo2190c(i);
        int i2 = i;
        while (true) {
            t = 0;
            while (true) {
                c2304f.mo2191c(c2529l.f6441a, 0, 5);
                c2529l.m7096c(0);
                if (c2529l.m7104h() != 2935) {
                    break;
                }
                t++;
                if (t >= 4) {
                    return true;
                }
                int a = C2216a.m6110a(c2529l.f6441a);
                if (a == -1) {
                    return false;
                }
                c2304f.mo2190c(a - 5);
            }
            c2304f.mo2183a();
            i2++;
            if (i2 - i >= Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                return false;
            }
            c2304f.mo2190c(i2);
        }
    }

    /* renamed from: a */
    public void mo2164a(C2320g c2320g) {
        this.f10582d.mo2210a(c2320g, new C2318d(0, 1));
        c2320g.mo2232a();
        c2320g.mo2233a(new C4154a(-9223372036854775807L));
    }

    /* renamed from: a */
    public void mo2163a(long j, long j2) {
        this.f10584f = 0;
        this.f10582d.mo2208a();
    }

    /* renamed from: a */
    public int mo2162a(C2304f c2304f, C2326k c2326k) {
        c2304f = c2304f.mo2182a(this.f10583e.f6441a, 0, 2786);
        if (c2304f == -1) {
            return -1;
        }
        this.f10583e.m7096c(0);
        this.f10583e.m7094b(c2304f);
        if (this.f10584f == null) {
            this.f10582d.mo2209a(this.f10581c, true);
            this.f10584f = true;
        }
        this.f10582d.mo2211a(this.f10583e);
        return 0;
    }
}
