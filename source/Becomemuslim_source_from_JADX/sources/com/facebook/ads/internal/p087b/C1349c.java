package com.facebook.ads.internal.p087b;

import java.io.Serializable;

/* renamed from: com.facebook.ads.internal.b.c */
public class C1349c implements Serializable {
    /* renamed from: a */
    private C1348a f3923a;
    /* renamed from: b */
    private C1348a f3924b;

    /* renamed from: com.facebook.ads.internal.b.c$a */
    public static class C1348a implements Serializable {
        /* renamed from: a */
        private double f3912a;
        /* renamed from: b */
        private double f3913b;
        /* renamed from: c */
        private double f3914c;
        /* renamed from: d */
        private double f3915d;
        /* renamed from: e */
        private double f3916e;
        /* renamed from: f */
        private double f3917f;
        /* renamed from: g */
        private double f3918g;
        /* renamed from: h */
        private int f3919h;
        /* renamed from: i */
        private double f3920i;
        /* renamed from: j */
        private double f3921j;
        /* renamed from: k */
        private double f3922k;

        public C1348a(double d) {
            this.f3916e = d;
        }

        /* renamed from: a */
        public void m4618a() {
            this.f3912a = 0.0d;
            this.f3914c = 0.0d;
            this.f3915d = 0.0d;
            this.f3917f = 0.0d;
            this.f3919h = 0;
            this.f3920i = 0.0d;
            this.f3921j = 1.0d;
            this.f3922k = 0.0d;
        }

        /* renamed from: a */
        public void m4619a(double d, double d2) {
            this.f3919h++;
            this.f3920i += d;
            this.f3914c = d2;
            this.f3922k += d2 * d;
            this.f3912a = this.f3922k / this.f3920i;
            this.f3921j = Math.min(this.f3921j, d2);
            this.f3917f = Math.max(this.f3917f, d2);
            if (d2 >= this.f3916e) {
                this.f3915d += d;
                this.f3913b += d;
                this.f3918g = Math.max(this.f3918g, this.f3913b);
                return;
            }
            this.f3913b = 0.0d;
        }

        /* renamed from: b */
        public void m4620b() {
            this.f3913b = 0.0d;
        }

        /* renamed from: c */
        public double m4621c() {
            return this.f3919h == 0 ? 0.0d : this.f3921j;
        }

        /* renamed from: d */
        public double m4622d() {
            return this.f3912a;
        }

        /* renamed from: e */
        public double m4623e() {
            return this.f3917f;
        }

        /* renamed from: f */
        public double m4624f() {
            return this.f3920i;
        }

        /* renamed from: g */
        public double m4625g() {
            return this.f3915d;
        }

        /* renamed from: h */
        public double m4626h() {
            return this.f3918g;
        }
    }

    public C1349c() {
        this(0.5d, 0.5d);
    }

    public C1349c(double d) {
        this(d, 0.5d);
    }

    public C1349c(double d, double d2) {
        this.f3923a = new C1348a(d);
        this.f3924b = new C1348a(d2);
        m4627a();
    }

    /* renamed from: a */
    void m4627a() {
        this.f3923a.m4618a();
        this.f3924b.m4618a();
    }

    /* renamed from: a */
    void m4628a(double d, double d2) {
        this.f3923a.m4619a(d, d2);
    }

    /* renamed from: b */
    void m4629b() {
        this.f3923a.m4620b();
        this.f3924b.m4620b();
    }

    /* renamed from: b */
    void m4630b(double d, double d2) {
        this.f3924b.m4619a(d, d2);
    }

    /* renamed from: c */
    public C1348a m4631c() {
        return this.f3923a;
    }

    /* renamed from: d */
    public C1348a m4632d() {
        return this.f3924b;
    }
}
