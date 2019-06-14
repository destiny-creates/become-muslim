package com.p050a.p051a.p056c.p059c;

import com.p050a.p051a.C0954f;
import com.p050a.p051a.p056c.p057a.C0892k;
import com.p050a.p051a.p056c.p057a.C3369l;
import com.p050a.p051a.p056c.p057a.C4522b;
import com.p050a.p051a.p056c.p057a.C4528j;
import com.p050a.p051a.p056c.p058b.C0895b;
import com.p050a.p051a.p056c.p058b.C0899g;
import com.p050a.p051a.p062f.C0950a;
import java.util.List;
import java.util.Locale;

/* compiled from: Layer */
/* renamed from: com.a.a.c.c.d */
public class C0912d {
    /* renamed from: a */
    private final List<C0895b> f2578a;
    /* renamed from: b */
    private final C0954f f2579b;
    /* renamed from: c */
    private final String f2580c;
    /* renamed from: d */
    private final long f2581d;
    /* renamed from: e */
    private final C0910a f2582e;
    /* renamed from: f */
    private final long f2583f;
    /* renamed from: g */
    private final String f2584g;
    /* renamed from: h */
    private final List<C0899g> f2585h;
    /* renamed from: i */
    private final C3369l f2586i;
    /* renamed from: j */
    private final int f2587j;
    /* renamed from: k */
    private final int f2588k;
    /* renamed from: l */
    private final int f2589l;
    /* renamed from: m */
    private final float f2590m;
    /* renamed from: n */
    private final float f2591n;
    /* renamed from: o */
    private final int f2592o;
    /* renamed from: p */
    private final int f2593p;
    /* renamed from: q */
    private final C4528j f2594q;
    /* renamed from: r */
    private final C0892k f2595r;
    /* renamed from: s */
    private final C4522b f2596s;
    /* renamed from: t */
    private final List<C0950a<Float>> f2597t;
    /* renamed from: u */
    private final C0911b f2598u;

    /* compiled from: Layer */
    /* renamed from: com.a.a.c.c.d$a */
    public enum C0910a {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* compiled from: Layer */
    /* renamed from: com.a.a.c.c.d$b */
    public enum C0911b {
        None,
        Add,
        Invert,
        Unknown
    }

    public C0912d(List<C0895b> list, C0954f c0954f, String str, long j, C0910a c0910a, long j2, String str2, List<C0899g> list2, C3369l c3369l, int i, int i2, int i3, float f, float f2, int i4, int i5, C4528j c4528j, C0892k c0892k, List<C0950a<Float>> list3, C0911b c0911b, C4522b c4522b) {
        this.f2578a = list;
        this.f2579b = c0954f;
        this.f2580c = str;
        this.f2581d = j;
        this.f2582e = c0910a;
        this.f2583f = j2;
        this.f2584g = str2;
        this.f2585h = list2;
        this.f2586i = c3369l;
        this.f2587j = i;
        this.f2588k = i2;
        this.f2589l = i3;
        this.f2590m = f;
        this.f2591n = f2;
        this.f2592o = i4;
        this.f2593p = i5;
        this.f2594q = c4528j;
        this.f2595r = c0892k;
        this.f2597t = list3;
        this.f2598u = c0911b;
        this.f2596s = c4522b;
    }

    /* renamed from: a */
    C0954f m3189a() {
        return this.f2579b;
    }

    /* renamed from: b */
    float m3191b() {
        return this.f2590m;
    }

    /* renamed from: c */
    float m3192c() {
        return this.f2591n / this.f2579b.m3350k();
    }

    /* renamed from: d */
    List<C0950a<Float>> m3193d() {
        return this.f2597t;
    }

    /* renamed from: e */
    public long m3194e() {
        return this.f2581d;
    }

    /* renamed from: f */
    String m3195f() {
        return this.f2580c;
    }

    /* renamed from: g */
    String m3196g() {
        return this.f2584g;
    }

    /* renamed from: h */
    int m3197h() {
        return this.f2592o;
    }

    /* renamed from: i */
    int m3198i() {
        return this.f2593p;
    }

    /* renamed from: j */
    List<C0899g> m3199j() {
        return this.f2585h;
    }

    /* renamed from: k */
    public C0910a m3200k() {
        return this.f2582e;
    }

    /* renamed from: l */
    C0911b m3201l() {
        return this.f2598u;
    }

    /* renamed from: m */
    long m3202m() {
        return this.f2583f;
    }

    /* renamed from: n */
    List<C0895b> m3203n() {
        return this.f2578a;
    }

    /* renamed from: o */
    C3369l m3204o() {
        return this.f2586i;
    }

    /* renamed from: p */
    int m3205p() {
        return this.f2589l;
    }

    /* renamed from: q */
    int m3206q() {
        return this.f2588k;
    }

    /* renamed from: r */
    int m3207r() {
        return this.f2587j;
    }

    /* renamed from: s */
    C4528j m3208s() {
        return this.f2594q;
    }

    /* renamed from: t */
    C0892k m3209t() {
        return this.f2595r;
    }

    /* renamed from: u */
    C4522b m3210u() {
        return this.f2596s;
    }

    public String toString() {
        return m3190a("");
    }

    /* renamed from: a */
    public String m3190a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(m3195f());
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        C0912d a = this.f2579b.m3335a(m3202m());
        if (a != null) {
            stringBuilder.append("\t\tParents: ");
            stringBuilder.append(a.m3195f());
            a = this.f2579b.m3335a(a.m3202m());
            while (a != null) {
                stringBuilder.append("->");
                stringBuilder.append(a.m3195f());
                a = this.f2579b.m3335a(a.m3202m());
            }
            stringBuilder.append(str);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        }
        if (!m3199j().isEmpty()) {
            stringBuilder.append(str);
            stringBuilder.append("\tMasks: ");
            stringBuilder.append(m3199j().size());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        }
        if (!(m3207r() == 0 || m3206q() == 0)) {
            stringBuilder.append(str);
            stringBuilder.append("\tBackground: ");
            stringBuilder.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(m3207r()), Integer.valueOf(m3206q()), Integer.valueOf(m3205p())}));
        }
        if (!this.f2578a.isEmpty()) {
            stringBuilder.append(str);
            stringBuilder.append("\tShapes:\n");
            for (Object next : this.f2578a) {
                stringBuilder.append(str);
                stringBuilder.append("\t\t");
                stringBuilder.append(next);
                stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            }
        }
        return stringBuilder.toString();
    }
}
