package com.p050a.p051a.p056c.p058b;

import android.graphics.PointF;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.p052a.p053a.C0880b;
import com.p050a.p051a.p052a.p053a.C4509m;
import com.p050a.p051a.p056c.p057a.C0893m;
import com.p050a.p051a.p056c.p057a.C4522b;
import com.p050a.p051a.p056c.p059c.C4529a;

/* compiled from: PolystarShape */
/* renamed from: com.a.a.c.b.i */
public class C3375i implements C0895b {
    /* renamed from: a */
    private final String f8972a;
    /* renamed from: b */
    private final C0901a f8973b;
    /* renamed from: c */
    private final C4522b f8974c;
    /* renamed from: d */
    private final C0893m<PointF, PointF> f8975d;
    /* renamed from: e */
    private final C4522b f8976e;
    /* renamed from: f */
    private final C4522b f8977f;
    /* renamed from: g */
    private final C4522b f8978g;
    /* renamed from: h */
    private final C4522b f8979h;
    /* renamed from: i */
    private final C4522b f8980i;

    /* compiled from: PolystarShape */
    /* renamed from: com.a.a.c.b.i$a */
    public enum C0901a {
        Star(1),
        Polygon(2);
        
        /* renamed from: c */
        private final int f2534c;

        private C0901a(int i) {
            this.f2534c = i;
        }

        /* renamed from: a */
        public static C0901a m3180a(int i) {
            for (C0901a c0901a : C0901a.values()) {
                if (c0901a.f2534c == i) {
                    return c0901a;
                }
            }
            return 0;
        }
    }

    public C3375i(String str, C0901a c0901a, C4522b c4522b, C0893m<PointF, PointF> c0893m, C4522b c4522b2, C4522b c4522b3, C4522b c4522b4, C4522b c4522b5, C4522b c4522b6) {
        this.f8972a = str;
        this.f8973b = c0901a;
        this.f8974c = c4522b;
        this.f8975d = c0893m;
        this.f8976e = c4522b2;
        this.f8977f = c4522b3;
        this.f8978g = c4522b4;
        this.f8979h = c4522b5;
        this.f8980i = c4522b6;
    }

    /* renamed from: a */
    public String m10725a() {
        return this.f8972a;
    }

    /* renamed from: b */
    public C0901a m10726b() {
        return this.f8973b;
    }

    /* renamed from: c */
    public C4522b m10727c() {
        return this.f8974c;
    }

    /* renamed from: d */
    public C0893m<PointF, PointF> m10728d() {
        return this.f8975d;
    }

    /* renamed from: e */
    public C4522b m10729e() {
        return this.f8976e;
    }

    /* renamed from: f */
    public C4522b m10730f() {
        return this.f8977f;
    }

    /* renamed from: g */
    public C4522b m10731g() {
        return this.f8978g;
    }

    /* renamed from: h */
    public C4522b m10732h() {
        return this.f8979h;
    }

    /* renamed from: i */
    public C4522b m10733i() {
        return this.f8980i;
    }

    /* renamed from: a */
    public C0880b mo738a(C0957g c0957g, C4529a c4529a) {
        return new C4509m(c0957g, c4529a, this);
    }
}
