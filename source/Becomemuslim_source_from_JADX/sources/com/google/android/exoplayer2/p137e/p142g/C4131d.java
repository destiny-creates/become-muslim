package com.google.android.exoplayer2.p137e.p142g;

import android.util.Log;
import android.util.Pair;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.C4115d;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2518c;
import com.google.android.exoplayer2.p164l.C2528k;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: AdtsReader */
/* renamed from: com.google.android.exoplayer2.e.g.d */
public final class C4131d implements C2305h {
    /* renamed from: a */
    private static final byte[] f10603a = new byte[]{(byte) 73, (byte) 68, (byte) 51};
    /* renamed from: b */
    private final boolean f10604b;
    /* renamed from: c */
    private final C2528k f10605c;
    /* renamed from: d */
    private final C2529l f10606d;
    /* renamed from: e */
    private final String f10607e;
    /* renamed from: f */
    private String f10608f;
    /* renamed from: g */
    private C2329m f10609g;
    /* renamed from: h */
    private C2329m f10610h;
    /* renamed from: i */
    private int f10611i;
    /* renamed from: j */
    private int f10612j;
    /* renamed from: k */
    private int f10613k;
    /* renamed from: l */
    private boolean f10614l;
    /* renamed from: m */
    private boolean f10615m;
    /* renamed from: n */
    private long f10616n;
    /* renamed from: o */
    private int f10617o;
    /* renamed from: p */
    private long f10618p;
    /* renamed from: q */
    private C2329m f10619q;
    /* renamed from: r */
    private long f10620r;

    /* renamed from: b */
    public void mo2212b() {
    }

    public C4131d(boolean z) {
        this(z, null);
    }

    public C4131d(boolean z, String str) {
        this.f10605c = new C2528k(new byte[7]);
        this.f10606d = new C2529l(Arrays.copyOf(f10603a, 10));
        m13070c();
        this.f10604b = z;
        this.f10607e = str;
    }

    /* renamed from: a */
    public void mo2208a() {
        m13070c();
    }

    /* renamed from: a */
    public void mo2210a(C2320g c2320g, C2318d c2318d) {
        c2318d.m6431a();
        this.f10608f = c2318d.m6433c();
        this.f10609g = c2320g.mo2231a(c2318d.m6432b(), 1);
        if (this.f10604b) {
            c2318d.m6431a();
            this.f10610h = c2320g.mo2231a(c2318d.m6432b(), 4);
            this.f10610h.mo2199a(C2515k.m6992a(c2318d.m6433c(), "application/id3", null, -1, null));
            return;
        }
        this.f10610h = new C4115d();
    }

    /* renamed from: a */
    public void mo2209a(long j, boolean z) {
        this.f10618p = j;
    }

    /* renamed from: a */
    public void mo2211a(C2529l c2529l) {
        while (c2529l.m7093b() > 0) {
            switch (this.f10611i) {
                case 0:
                    m13069b(c2529l);
                    break;
                case 1:
                    if (!m13068a(c2529l, this.f10606d.f6441a, 10)) {
                        break;
                    }
                    m13074f();
                    break;
                case 2:
                    if (!m13068a(c2529l, this.f10605c.f6437a, this.f10614l ? 7 : 5)) {
                        break;
                    }
                    m13075g();
                    break;
                case 3:
                    m13071c(c2529l);
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: a */
    private boolean m13068a(C2529l c2529l, byte[] bArr, int i) {
        int min = Math.min(c2529l.m7093b(), i - this.f10612j);
        c2529l.m7092a(bArr, this.f10612j, min);
        this.f10612j += min;
        return this.f10612j == i ? true : null;
    }

    /* renamed from: c */
    private void m13070c() {
        this.f10611i = 0;
        this.f10612j = 0;
        this.f10613k = 256;
    }

    /* renamed from: d */
    private void m13072d() {
        this.f10611i = 1;
        this.f10612j = f10603a.length;
        this.f10617o = 0;
        this.f10606d.m7096c(0);
    }

    /* renamed from: a */
    private void m13067a(C2329m c2329m, long j, int i, int i2) {
        this.f10611i = 3;
        this.f10612j = i;
        this.f10619q = c2329m;
        this.f10620r = j;
        this.f10617o = i2;
    }

    /* renamed from: e */
    private void m13073e() {
        this.f10611i = 2;
        this.f10612j = 0;
    }

    /* renamed from: b */
    private void m13069b(C2529l c2529l) {
        byte[] bArr = c2529l.f6441a;
        int d = c2529l.m7097d();
        int c = c2529l.m7095c();
        while (d < c) {
            int i = d + 1;
            d = bArr[d] & JfifUtil.MARKER_FIRST_BYTE;
            if (this.f10613k != 512 || d < 240 || d == JfifUtil.MARKER_FIRST_BYTE) {
                d |= this.f10613k;
                if (d == 329) {
                    this.f10613k = 768;
                } else if (d == 511) {
                    this.f10613k = 512;
                } else if (d == 836) {
                    this.f10613k = 1024;
                } else if (d == 1075) {
                    m13072d();
                    c2529l.m7096c(i);
                    return;
                } else if (this.f10613k != 256) {
                    this.f10613k = 256;
                    i--;
                }
                d = i;
            } else {
                boolean z = true;
                if ((d & 1) != 0) {
                    z = false;
                }
                this.f10614l = z;
                m13073e();
                c2529l.m7096c(i);
                return;
            }
        }
        c2529l.m7096c(d);
    }

    /* renamed from: f */
    private void m13074f() {
        this.f10610h.mo2200a(this.f10606d, 10);
        this.f10606d.m7096c(6);
        m13067a(this.f10610h, 0, 10, this.f10606d.m7116t() + 10);
    }

    /* renamed from: g */
    private void m13075g() {
        int c;
        this.f10605c.m7073a(0);
        if (this.f10615m) {
            r6.f10605c.m7078b(10);
        } else {
            c = r6.f10605c.m7081c(2) + 1;
            if (c != 2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Detected audio object type: ");
                stringBuilder.append(c);
                stringBuilder.append(", but assuming AAC LC.");
                Log.w("AdtsReader", stringBuilder.toString());
                c = 2;
            }
            int c2 = r6.f10605c.m7081c(4);
            r6.f10605c.m7078b(1);
            byte[] a = C2518c.m7028a(c, c2, r6.f10605c.m7081c(3));
            Pair a2 = C2518c.m7025a(a);
            C2515k a3 = C2515k.m6988a(r6.f10608f, "audio/mp4a-latm", null, -1, -1, ((Integer) a2.second).intValue(), ((Integer) a2.first).intValue(), Collections.singletonList(a), null, 0, r6.f10607e);
            r6.f10616n = 1024000000 / ((long) a3.f6393s);
            r6.f10609g.mo2199a(a3);
            r6.f10615m = true;
        }
        r6.f10605c.m7078b(4);
        c = (r6.f10605c.m7081c(13) - 2) - 5;
        if (r6.f10614l) {
            c -= 2;
        }
        m13067a(r6.f10609g, r6.f10616n, 0, c);
    }

    /* renamed from: c */
    private void m13071c(C2529l c2529l) {
        int min = Math.min(c2529l.m7093b(), this.f10617o - this.f10612j);
        this.f10619q.mo2200a(c2529l, min);
        this.f10612j += min;
        if (this.f10612j == this.f10617o) {
            this.f10619q.mo2198a(this.f10618p, 1, this.f10617o, 0, null);
            this.f10618p += this.f10620r;
            m13070c();
        }
    }
}
