package com.google.android.exoplayer2.p137e.p141e;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2327l;
import com.google.android.exoplayer2.p137e.p141e.C2295h.C2294a;
import com.google.android.exoplayer2.p164l.C2521f;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: FlacReader */
/* renamed from: com.google.android.exoplayer2.e.e.b */
final class C4119b extends C2295h {
    /* renamed from: a */
    private C2521f f10556a;
    /* renamed from: b */
    private C4118a f10557b;

    /* compiled from: FlacReader */
    /* renamed from: com.google.android.exoplayer2.e.e.b$a */
    private class C4118a implements C2292f, C2327l {
        /* renamed from: a */
        final /* synthetic */ C4119b f10551a;
        /* renamed from: b */
        private long[] f10552b;
        /* renamed from: c */
        private long[] f10553c;
        /* renamed from: d */
        private long f10554d = -1;
        /* renamed from: e */
        private long f10555e = -1;

        /* renamed from: a */
        public boolean mo2167a() {
            return true;
        }

        /* renamed from: c */
        public C2327l mo2203c() {
            return this;
        }

        public C4118a(C4119b c4119b) {
            this.f10551a = c4119b;
        }

        /* renamed from: c */
        public void m13005c(long j) {
            this.f10554d = j;
        }

        /* renamed from: a */
        public void m13000a(C2529l c2529l) {
            c2529l.m7098d(1);
            int k = c2529l.m7107k() / 18;
            this.f10552b = new long[k];
            this.f10553c = new long[k];
            for (int i = 0; i < k; i++) {
                this.f10552b[i] = c2529l.m7113q();
                this.f10553c[i] = c2529l.m7113q();
                c2529l.m7098d(2);
            }
        }

        /* renamed from: a */
        public long mo2202a(C2304f c2304f) {
            if (this.f10555e < 0) {
                return -1;
            }
            long j = -(this.f10555e + 2);
            this.f10555e = -1;
            return j;
        }

        /* renamed from: a */
        public long mo2201a(long j) {
            j = this.f10551a.m6352b(j);
            this.f10555e = this.f10552b[C2541v.m7167a(this.f10552b, j, true, true)];
            return j;
        }

        /* renamed from: b */
        public long mo2169b(long j) {
            return this.f10554d + this.f10553c[C2541v.m7167a(this.f10552b, this.f10551a.m6352b(j), true, true)];
        }

        /* renamed from: b */
        public long mo2168b() {
            return this.f10551a.f10556a.m7042b();
        }
    }

    C4119b() {
    }

    /* renamed from: a */
    public static boolean m13007a(C2529l c2529l) {
        return (c2529l.m7093b() >= 5 && c2529l.m7103g() == 127 && c2529l.m7109m() == 1179402563) ? true : null;
    }

    /* renamed from: a */
    protected void mo2204a(boolean z) {
        super.mo2204a(z);
        if (z) {
            this.f10556a = null;
            this.f10557b = null;
        }
    }

    /* renamed from: a */
    private static boolean m13008a(byte[] bArr) {
        return bArr[0] == -1;
    }

    /* renamed from: b */
    protected long mo2206b(C2529l c2529l) {
        if (C4119b.m13008a(c2529l.f6441a)) {
            return (long) m13009c(c2529l);
        }
        return -1;
    }

    /* renamed from: a */
    protected boolean mo2205a(C2529l c2529l, long j, C2294a c2294a) {
        byte[] bArr = c2529l.f6441a;
        if (this.f10556a == null) {
            this.f10556a = new C2521f(bArr, 17);
            c2529l = Arrays.copyOfRange(bArr, 9, c2529l.m7095c());
            c2529l[4] = Byte.MIN_VALUE;
            c2294a.f5631a = C2515k.m6988a(null, "audio/flac", null, -1, this.f10556a.m7041a(), this.f10556a.f6415f, this.f10556a.f6414e, Collections.singletonList(c2529l), null, 0, null);
        } else if ((bArr[0] & 127) == 3) {
            this.f10557b = new C4118a(this);
            this.f10557b.m13000a(c2529l);
        } else if (C4119b.m13008a(bArr) != null) {
            if (this.f10557b != null) {
                this.f10557b.m13005c(j);
                c2294a.f5632b = this.f10557b;
            }
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private int m13009c(C2529l c2529l) {
        int i = (c2529l.f6441a[2] & JfifUtil.MARKER_FIRST_BYTE) >> 4;
        switch (i) {
            case 1:
                return JfifUtil.MARKER_SOFn;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
            case 7:
                c2529l.m7098d(4);
                c2529l.m7086A();
                i = i == 6 ? c2529l.m7103g() : c2529l.m7104h();
                c2529l.m7096c(0);
                return i + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }
}
