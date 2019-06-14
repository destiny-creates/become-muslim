package com.google.android.exoplayer2.p137e.p142g;

import com.facebook.internal.Utility;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2323h;
import com.google.android.exoplayer2.p137e.C2326k;
import com.google.android.exoplayer2.p137e.C2327l.C4154a;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2528k;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: AdtsExtractor */
/* renamed from: com.google.android.exoplayer2.e.g.c */
public final class C4130c implements C2303e {
    /* renamed from: a */
    public static final C2323h f10597a = new C41291();
    /* renamed from: b */
    private static final int f10598b = C2541v.m7193g("ID3");
    /* renamed from: c */
    private final long f10599c;
    /* renamed from: d */
    private final C4131d f10600d;
    /* renamed from: e */
    private final C2529l f10601e;
    /* renamed from: f */
    private boolean f10602f;

    /* compiled from: AdtsExtractor */
    /* renamed from: com.google.android.exoplayer2.e.g.c$1 */
    static class C41291 implements C2323h {
        C41291() {
        }

        /* renamed from: a */
        public C2303e[] mo2161a() {
            return new C2303e[]{new C4130c()};
        }
    }

    /* renamed from: c */
    public void mo2166c() {
    }

    public C4130c() {
        this(0);
    }

    public C4130c(long j) {
        this.f10599c = j;
        this.f10600d = new C4131d(true);
        this.f10601e = new C2529l((int) HttpStatus.HTTP_OK);
    }

    /* renamed from: a */
    public boolean mo2165a(C2304f c2304f) {
        C2529l c2529l = new C2529l(10);
        C2528k c2528k = new C2528k(c2529l.f6441a);
        int i = 0;
        while (true) {
            c2304f.mo2191c(c2529l.f6441a, 0, 10);
            c2529l.m7096c(0);
            if (c2529l.m7107k() != f10598b) {
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
            int i3 = 0;
            while (true) {
                c2304f.mo2191c(c2529l.f6441a, 0, 2);
                c2529l.m7096c(0);
                if ((c2529l.m7104h() & 65526) != 65520) {
                    break;
                }
                t++;
                if (t >= 4 && i3 > 188) {
                    return true;
                }
                c2304f.mo2191c(c2529l.f6441a, 0, 4);
                c2528k.m7073a(14);
                int c = c2528k.m7081c(13);
                if (c <= 6) {
                    return false;
                }
                c2304f.mo2190c(c - 6);
                i3 += c;
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
        this.f10600d.mo2210a(c2320g, new C2318d(0, 1));
        c2320g.mo2232a();
        c2320g.mo2233a(new C4154a(-9223372036854775807L));
    }

    /* renamed from: a */
    public void mo2163a(long j, long j2) {
        this.f10602f = 0;
        this.f10600d.mo2208a();
    }

    /* renamed from: a */
    public int mo2162a(C2304f c2304f, C2326k c2326k) {
        c2304f = c2304f.mo2182a(this.f10601e.f6441a, 0, HttpStatus.HTTP_OK);
        if (c2304f == -1) {
            return -1;
        }
        this.f10601e.m7096c(0);
        this.f10601e.m7094b(c2304f);
        if (this.f10602f == null) {
            this.f10600d.mo2209a(this.f10599c, true);
            this.f10602f = true;
        }
        this.f10600d.mo2211a(this.f10601e);
        return 0;
    }
}
