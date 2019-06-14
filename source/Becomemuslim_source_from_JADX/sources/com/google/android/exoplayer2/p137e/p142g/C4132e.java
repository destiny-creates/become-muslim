package com.google.android.exoplayer2.p137e.p142g;

import android.util.SparseArray;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2316b;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2317c;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: DefaultTsPayloadReaderFactory */
/* renamed from: com.google.android.exoplayer2.e.g.e */
public final class C4132e implements C2317c {
    /* renamed from: a */
    private final int f10621a;
    /* renamed from: b */
    private final List<C2515k> f10622b;

    public C4132e() {
        this(0);
    }

    public C4132e(int i) {
        this(i, Collections.emptyList());
    }

    public C4132e(int i, List<C2515k> list) {
        this.f10621a = i;
        if (m13082a(32) == 0 && list.isEmpty() != 0) {
            list = Collections.singletonList(C2515k.m6981a(null, "application/cea-608", null, null));
        }
        this.f10622b = list;
    }

    /* renamed from: a */
    public SparseArray<C2319w> mo2213a() {
        return new SparseArray();
    }

    /* renamed from: a */
    public C2319w mo2214a(int i, C2316b c2316b) {
        C2319w c2319w = null;
        switch (i) {
            case 2:
                return new C4141p(new C4135i());
            case 3:
            case 4:
                return new C4141p(new C4140n(c2316b.f5748b));
            case 15:
                if (m13082a(2) == 0) {
                    c2319w = new C4141p(new C4131d(false, c2316b.f5748b));
                }
                return c2319w;
            case 17:
                if (m13082a(2) == 0) {
                    c2319w = new C4141p(new C4139m(c2316b.f5748b));
                }
                return c2319w;
            case 21:
                return new C4141p(new C4138l());
            case 27:
                if (m13082a(4) == 0) {
                    c2319w = new C4141p(new C4136j(m13081a(c2316b), m13082a(1), m13082a(8)));
                }
                return c2319w;
            case 36:
                return new C4141p(new C4137k(m13081a(c2316b)));
            case 89:
                return new C4141p(new C4134g(c2316b.f5749c));
            case 129:
            case 135:
                return new C4141p(new C4128b(c2316b.f5748b));
            case 130:
            case 138:
                return new C4141p(new C4133f(c2316b.f5748b));
            case 134:
                if (m13082a(16) == 0) {
                    c2319w = new C4144s(new C4145u());
                }
                return c2319w;
            default:
                return null;
        }
    }

    /* renamed from: a */
    private C2314t m13081a(C2316b c2316b) {
        if (m13082a(32)) {
            return new C2314t(this.f10622b);
        }
        C2529l c2529l = new C2529l(c2316b.f5750d);
        c2316b = this.f10622b;
        while (c2529l.m7093b() > 0) {
            int d = c2529l.m7097d() + c2529l.m7103g();
            if (c2529l.m7103g() == 134) {
                c2316b = new ArrayList();
                int g = c2529l.m7103g() & 31;
                for (int i = 0; i < g; i++) {
                    int i2;
                    String str;
                    String e = c2529l.m7100e(3);
                    int g2 = c2529l.m7103g();
                    if (((g2 & 128) != 0 ? 1 : null) != null) {
                        i2 = g2 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i2 = 1;
                    }
                    c2316b.add(C2515k.m6989a(null, str, null, -1, 0, e, i2, null));
                    c2529l.m7098d(2);
                }
            }
            c2529l.m7096c(d);
        }
        return new C2314t(c2316b);
    }

    /* renamed from: a */
    private boolean m13082a(int i) {
        return (i & this.f10621a) != 0;
    }
}
