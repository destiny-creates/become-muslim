package com.google.android.exoplayer2.p149h.p153c;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p149h.C2430j.C2429a;
import com.google.android.exoplayer2.p149h.C2435m;
import com.google.android.exoplayer2.p149h.C2438p;
import com.google.android.exoplayer2.p149h.C2439q;
import com.google.android.exoplayer2.p149h.C4212d;
import com.google.android.exoplayer2.p149h.C4219h;
import com.google.android.exoplayer2.p149h.C4219h.C4218a;
import com.google.android.exoplayer2.p149h.p153c.C4201l.C4200a;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4190a;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4190a.C2394a;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4194e;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4194e.C2399b;
import com.google.android.exoplayer2.p162j.C2484f;
import com.google.android.exoplayer2.p163k.C2492b;
import com.google.android.exoplayer2.p164l.C2516a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

/* compiled from: HlsMediaPeriod */
/* renamed from: com.google.android.exoplayer2.h.c.i */
public final class C4718i implements C2399b, C4200a, C4219h {
    /* renamed from: a */
    private final C2406f f12767a;
    /* renamed from: b */
    private final C4194e f12768b;
    /* renamed from: c */
    private final C2405e f12769c;
    /* renamed from: d */
    private final int f12770d;
    /* renamed from: e */
    private final C2429a f12771e;
    /* renamed from: f */
    private final C2492b f12772f;
    /* renamed from: g */
    private final IdentityHashMap<C2435m, Integer> f12773g = new IdentityHashMap();
    /* renamed from: h */
    private final C2409m f12774h = new C2409m();
    /* renamed from: i */
    private final Handler f12775i = new Handler();
    /* renamed from: j */
    private C4218a f12776j;
    /* renamed from: k */
    private int f12777k;
    /* renamed from: l */
    private C2439q f12778l;
    /* renamed from: m */
    private C4201l[] f12779m = new C4201l[0];
    /* renamed from: n */
    private C4201l[] f12780n = new C4201l[0];
    /* renamed from: o */
    private C4212d f12781o;

    /* renamed from: c */
    public long mo3208c() {
        return -9223372036854775807L;
    }

    public C4718i(C2406f c2406f, C4194e c4194e, C2405e c2405e, int i, C2429a c2429a, C2492b c2492b) {
        this.f12767a = c2406f;
        this.f12768b = c4194e;
        this.f12769c = c2405e;
        this.f12770d = i;
        this.f12771e = c2429a;
        this.f12772f = c2492b;
    }

    /* renamed from: f */
    public void m16128f() {
        this.f12768b.m13503b((C2399b) this);
        this.f12775i.removeCallbacksAndMessages(null);
        for (C4201l h : this.f12779m) {
            h.m13570h();
        }
    }

    /* renamed from: a */
    public void mo3204a(C4218a c4218a, long j) {
        this.f12776j = c4218a;
        this.f12768b.m13497a((C2399b) this);
        m16113d(j);
    }

    public void e_() {
        for (C4201l c : this.f12779m) {
            c.m13564c();
        }
    }

    /* renamed from: b */
    public C2439q mo3207b() {
        return this.f12778l;
    }

    /* renamed from: a */
    public long mo3202a(C2484f[] c2484fArr, boolean[] zArr, C2435m[] c2435mArr, boolean[] zArr2, long j) {
        int i;
        int i2;
        C4201l[] c4201lArr;
        C4718i c4718i = this;
        C2484f[] c2484fArr2 = c2484fArr;
        C2435m[] c2435mArr2 = c2435mArr;
        int[] iArr = new int[c2484fArr2.length];
        int[] iArr2 = new int[c2484fArr2.length];
        for (int i3 = 0; i3 < c2484fArr2.length; i3++) {
            int i4;
            if (c2435mArr2[i3] == null) {
                i4 = -1;
            } else {
                i4 = ((Integer) c4718i.f12773g.get(c2435mArr2[i3])).intValue();
            }
            iArr[i3] = i4;
            iArr2[i3] = -1;
            if (c2484fArr2[i3] != null) {
                C2438p f = c2484fArr2[i3].mo2305f();
                for (i = 0; i < c4718i.f12779m.length; i++) {
                    if (c4718i.f12779m[i].m13568f().m6713a(f) != -1) {
                        iArr2[i3] = i;
                        break;
                    }
                }
            }
        }
        c4718i.f12773g.clear();
        Object obj = new C2435m[c2484fArr2.length];
        C2435m[] c2435mArr3 = new C2435m[c2484fArr2.length];
        C2484f[] c2484fArr3 = new C2484f[c2484fArr2.length];
        C4201l[] c4201lArr2 = new C4201l[c4718i.f12779m.length];
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        while (i6 < c4718i.f12779m.length) {
            int i7 = 0;
            while (i7 < c2484fArr2.length) {
                C2484f c2484f = null;
                c2435mArr3[i7] = iArr[i7] == i6 ? c2435mArr2[i7] : null;
                if (iArr2[i7] == i6) {
                    c2484f = c2484fArr2[i7];
                }
                c2484fArr3[i7] = c2484f;
                i7++;
            }
            C4201l c4201l = c4718i.f12779m[i6];
            C4201l c4201l2 = c4201l;
            i2 = i5;
            c4201lArr = c4201lArr2;
            int i8 = i6;
            C2484f[] c2484fArr4 = c2484fArr3;
            boolean a = c4201l.m13559a(c2484fArr3, zArr, c2435mArr3, zArr2, j, z);
            i = 0;
            Object obj2 = null;
            while (true) {
                boolean z2 = true;
                if (i >= c2484fArr2.length) {
                    break;
                }
                if (iArr2[i] == i8) {
                    C2516a.m7019b(c2435mArr3[i] != null);
                    obj[i] = c2435mArr3[i];
                    c4718i.f12773g.put(c2435mArr3[i], Integer.valueOf(i8));
                    obj2 = 1;
                } else if (iArr[i] == i8) {
                    if (c2435mArr3[i] != null) {
                        z2 = false;
                    }
                    C2516a.m7019b(z2);
                }
                i++;
            }
            if (obj2 != null) {
                c4201lArr[i2] = c4201l2;
                i = i2 + 1;
                if (i2 == 0) {
                    c4201l2.m13556a(true);
                    if (!a && c4718i.f12780n.length != 0) {
                        if (c4201l2 != c4718i.f12780n[0]) {
                        }
                    }
                    c4718i.f12774h.m6630a();
                    i5 = i;
                    z = true;
                } else {
                    c4201l2.m13556a(false);
                }
                i5 = i;
            } else {
                i5 = i2;
            }
            i6 = i8 + 1;
            c4201lArr2 = c4201lArr;
            c2484fArr3 = c2484fArr4;
            c2435mArr2 = c2435mArr;
        }
        i2 = i5;
        c4201lArr = c4201lArr2;
        System.arraycopy(obj, 0, c2435mArr, 0, obj.length);
        c4718i.f12780n = (C4201l[]) Arrays.copyOf(c4201lArr, i5);
        c4718i.f12781o = new C4212d(c4718i.f12780n);
        return j;
    }

    /* renamed from: a */
    public void mo3203a(long j) {
        for (C4201l a : this.f12780n) {
            a.m13548a(j);
        }
    }

    /* renamed from: c */
    public boolean mo2241c(long j) {
        return this.f12781o.mo2241c(j);
    }

    /* renamed from: e */
    public long mo2243e() {
        return this.f12781o.mo2243e();
    }

    /* renamed from: d */
    public long mo2242d() {
        return this.f12781o.mo2242d();
    }

    /* renamed from: b */
    public long mo3206b(long j) {
        if (this.f12780n.length > 0) {
            boolean a = this.f12780n[0].m13558a(j, false);
            for (int i = 1; i < this.f12780n.length; i++) {
                this.f12780n[i].m13558a(j, a);
            }
            if (a) {
                this.f12774h.m6630a();
            }
        }
        return j;
    }

    /* renamed from: g */
    public void mo3221g() {
        int i = this.f12777k - 1;
        this.f12777k = i;
        if (i <= 0) {
            int i2 = 0;
            for (C4201l f : this.f12779m) {
                i2 += f.m13568f().f6068b;
            }
            C2438p[] c2438pArr = new C2438p[i2];
            C4201l[] c4201lArr = this.f12779m;
            int length = c4201lArr.length;
            i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                C4201l c4201l = c4201lArr[i2];
                int i4 = c4201l.m13568f().f6068b;
                int i5 = i3;
                i3 = 0;
                while (i3 < i4) {
                    int i6 = i5 + 1;
                    c2438pArr[i5] = c4201l.m13568f().m6714a(i3);
                    i3++;
                    i5 = i6;
                }
                i2++;
                i3 = i5;
            }
            this.f12778l = new C2439q(c2438pArr);
            this.f12776j.mo3223a(this);
        }
    }

    /* renamed from: a */
    public void mo3219a(C2394a c2394a) {
        this.f12768b.m13508d(c2394a);
    }

    /* renamed from: a */
    public void m16119a(C4201l c4201l) {
        if (this.f12778l != null) {
            this.f12776j.mo3205a(this);
        }
    }

    /* renamed from: h */
    public void mo3222h() {
        m16114i();
    }

    /* renamed from: a */
    public void mo3220a(C2394a c2394a, long j) {
        for (C4201l a : this.f12779m) {
            a.m13552a(c2394a, j);
        }
        m16114i();
    }

    /* renamed from: d */
    private void m16113d(long j) {
        C4190a b = this.f12768b.m13502b();
        List arrayList = new ArrayList(b.f10906a);
        ArrayList arrayList2 = new ArrayList();
        Collection arrayList3 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            C2394a c2394a = (C2394a) arrayList.get(i);
            if (c2394a.f5898b.f6385k <= 0) {
                if (!C4718i.m16112a(c2394a, "avc")) {
                    if (C4718i.m16112a(c2394a, "mp4a")) {
                        arrayList3.add(c2394a);
                    }
                }
            }
            arrayList2.add(c2394a);
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        } else if (arrayList3.size() < arrayList.size()) {
            arrayList.removeAll(arrayList3);
        }
        List list = b.f10907b;
        List list2 = b.f10908c;
        r7.f12779m = new C4201l[((list.size() + 1) + list2.size())];
        r7.f12777k = r7.f12779m.length;
        C2516a.m7017a(arrayList.isEmpty() ^ true);
        C2394a[] c2394aArr = new C2394a[arrayList.size()];
        arrayList.toArray(c2394aArr);
        C4201l a = m16111a(0, c2394aArr, b.f10909d, b.f10910e, j);
        r7.f12779m[0] = a;
        a.m13556a(true);
        a.m13561b();
        int i2 = 0;
        int i3 = 1;
        while (i2 < list.size()) {
            a = m16111a(1, new C2394a[]{(C2394a) list.get(i2)}, null, Collections.emptyList(), j);
            int i4 = i3 + 1;
            r7.f12779m[i3] = a;
            a.m13561b();
            i2++;
            i3 = i4;
        }
        int i5 = 0;
        while (i5 < list2.size()) {
            a = m16111a(3, new C2394a[]{(C2394a) list2.get(i5)}, null, Collections.emptyList(), j);
            a.m13563b(r12.f5898b);
            i4 = i3 + 1;
            r7.f12779m[i3] = a;
            i5++;
            i3 = i4;
        }
        r7.f12780n = r7.f12779m;
    }

    /* renamed from: a */
    private C4201l m16111a(int i, C2394a[] c2394aArr, C2515k c2515k, List<C2515k> list, long j) {
        return new C4201l(i, this, new C2404d(this.f12767a, this.f12768b, c2394aArr, this.f12769c, this.f12774h, list), this.f12772f, j, c2515k, this.f12770d, this.f12771e);
    }

    /* renamed from: i */
    private void m16114i() {
        if (this.f12778l != null) {
            this.f12776j.mo3205a(this);
            return;
        }
        for (C4201l b : this.f12779m) {
            b.m13561b();
        }
    }

    /* renamed from: a */
    private static boolean m16112a(C2394a c2394a, String str) {
        c2394a = c2394a.f5898b.f6377c;
        if (TextUtils.isEmpty(c2394a)) {
            return false;
        }
        for (String startsWith : c2394a.split("(\\s*,\\s*)|(\\s*$)")) {
            if (startsWith.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}
