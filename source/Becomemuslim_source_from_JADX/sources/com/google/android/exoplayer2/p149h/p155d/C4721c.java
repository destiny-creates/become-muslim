package com.google.android.exoplayer2.p149h.p155d;

import android.util.Base64;
import com.google.android.exoplayer2.p137e.p140d.C2286k;
import com.google.android.exoplayer2.p149h.C2430j.C2429a;
import com.google.android.exoplayer2.p149h.C2435m;
import com.google.android.exoplayer2.p149h.C2437n.C2436a;
import com.google.android.exoplayer2.p149h.C2438p;
import com.google.android.exoplayer2.p149h.C2439q;
import com.google.android.exoplayer2.p149h.C4212d;
import com.google.android.exoplayer2.p149h.C4219h;
import com.google.android.exoplayer2.p149h.C4219h.C4218a;
import com.google.android.exoplayer2.p149h.p150a.C4172f;
import com.google.android.exoplayer2.p149h.p155d.C4210b.C2414a;
import com.google.android.exoplayer2.p149h.p155d.p156a.C2412a;
import com.google.android.exoplayer2.p162j.C2484f;
import com.google.android.exoplayer2.p163k.C2492b;
import com.google.android.exoplayer2.p163k.C2512t;
import java.util.ArrayList;

/* compiled from: SsMediaPeriod */
/* renamed from: com.google.android.exoplayer2.h.d.c */
final class C4721c implements C4219h, C2436a<C4172f<C4210b>> {
    /* renamed from: a */
    private final C2414a f12796a;
    /* renamed from: b */
    private final C2512t f12797b;
    /* renamed from: c */
    private final int f12798c;
    /* renamed from: d */
    private final C2429a f12799d;
    /* renamed from: e */
    private final C2492b f12800e;
    /* renamed from: f */
    private final C2439q f12801f;
    /* renamed from: g */
    private final C2286k[] f12802g;
    /* renamed from: h */
    private C4218a f12803h;
    /* renamed from: i */
    private C2412a f12804i;
    /* renamed from: j */
    private C4172f<C4210b>[] f12805j;
    /* renamed from: k */
    private C4212d f12806k;

    /* renamed from: a */
    public void mo3203a(long j) {
    }

    /* renamed from: c */
    public long mo3208c() {
        return -9223372036854775807L;
    }

    public C4721c(C2412a c2412a, C2414a c2414a, int i, C2429a c2429a, C2512t c2512t, C2492b c2492b) {
        this.f12796a = c2414a;
        this.f12797b = c2512t;
        this.f12798c = i;
        this.f12799d = c2429a;
        this.f12800e = c2492b;
        this.f12801f = C4721c.m16156b(c2412a);
        c2414a = c2412a.f5963e;
        if (c2414a != null) {
            byte[] a = C4721c.m16154a(c2414a.f5942b);
            this.f12802g = new C2286k[]{new C2286k(true, null, 8, a, 0, 0, null)};
        } else {
            this.f12802g = null;
        }
        this.f12804i = c2412a;
        this.f12805j = C4721c.m16155a(0);
        this.f12806k = new C4212d(this.f12805j);
    }

    /* renamed from: a */
    public void m16160a(C2412a c2412a) {
        this.f12804i = c2412a;
        for (C4172f a : this.f12805j) {
            ((C4210b) a.m13287a()).mo3224a(c2412a);
        }
        this.f12803h.mo3205a(this);
    }

    /* renamed from: f */
    public void m16169f() {
        for (C4172f b : this.f12805j) {
            b.m13292b();
        }
    }

    /* renamed from: a */
    public void mo3204a(C4218a c4218a, long j) {
        this.f12803h = c4218a;
        c4218a.mo3223a(this);
    }

    public void e_() {
        this.f12797b.mo2322d();
    }

    /* renamed from: b */
    public C2439q mo3207b() {
        return this.f12801f;
    }

    /* renamed from: a */
    public long mo3202a(C2484f[] c2484fArr, boolean[] zArr, C2435m[] c2435mArr, boolean[] zArr2, long j) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < c2484fArr.length) {
            C4172f c4172f;
            if (c2435mArr[i] != null) {
                c4172f = (C4172f) c2435mArr[i];
                if (c2484fArr[i] != null) {
                    if (zArr[i]) {
                        arrayList.add(c4172f);
                    }
                }
                c4172f.m13292b();
                c2435mArr[i] = null;
            }
            if (c2435mArr[i] == null && c2484fArr[i] != null) {
                c4172f = m16152a(c2484fArr[i], j);
                arrayList.add(c4172f);
                c2435mArr[i] = c4172f;
                zArr2[i] = true;
            }
            i++;
        }
        this.f12805j = C4721c.m16155a(arrayList.size());
        arrayList.toArray(this.f12805j);
        this.f12806k = new C4212d(this.f12805j);
        return j;
    }

    /* renamed from: c */
    public boolean mo2241c(long j) {
        return this.f12806k.mo2241c(j);
    }

    /* renamed from: e */
    public long mo2243e() {
        return this.f12806k.mo2243e();
    }

    /* renamed from: d */
    public long mo2242d() {
        return this.f12806k.mo2242d();
    }

    /* renamed from: b */
    public long mo3206b(long j) {
        for (C4172f d : this.f12805j) {
            d.m13297d(j);
        }
        return j;
    }

    /* renamed from: a */
    public void m16159a(C4172f<C4210b> c4172f) {
        this.f12803h.mo3205a(this);
    }

    /* renamed from: a */
    private C4172f<C4210b> m16152a(C2484f c2484f, long j) {
        int a = this.f12801f.m6713a(c2484f.mo2305f());
        return new C4172f(this.f12804i.f5964f[a].f5943a, null, this.f12796a.mo2275a(this.f12797b, this.f12804i, a, c2484f, this.f12802g), this, this.f12800e, j, this.f12798c, this.f12799d);
    }

    /* renamed from: b */
    private static C2439q m16156b(C2412a c2412a) {
        C2438p[] c2438pArr = new C2438p[c2412a.f5964f.length];
        for (int i = 0; i < c2412a.f5964f.length; i++) {
            c2438pArr[i] = new C2438p(c2412a.f5964f[i].f5952j);
        }
        return new C2439q(c2438pArr);
    }

    /* renamed from: a */
    private static C4172f<C4210b>[] m16155a(int i) {
        return new C4172f[i];
    }

    /* renamed from: a */
    private static byte[] m16154a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bArr.length; i += 2) {
            stringBuilder.append((char) bArr[i]);
        }
        bArr = stringBuilder.toString();
        bArr = Base64.decode(bArr.substring(bArr.indexOf("<KID>") + 5, bArr.indexOf("</KID>")), 0);
        C4721c.m16153a(bArr, 0, 3);
        C4721c.m16153a(bArr, 1, 2);
        C4721c.m16153a(bArr, 4, 5);
        C4721c.m16153a(bArr, 6, 7);
        return bArr;
    }

    /* renamed from: a */
    private static void m16153a(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }
}
