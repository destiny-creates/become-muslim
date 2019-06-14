package org.spongycastle.pqc.math.linearalgebra;

public class GF2nPolynomialField extends GF2nField {
    /* renamed from: c */
    private boolean f27873c;
    /* renamed from: d */
    private boolean f27874d;
    /* renamed from: e */
    private int f27875e;
    /* renamed from: f */
    private int[] f27876f;

    /* renamed from: c */
    protected void mo5931c() {
        if (!m36534d() && !m36535e()) {
            m36536f();
        }
    }

    /* renamed from: d */
    private boolean m36534d() {
        this.b = new GF2Polynomial(this.a + 1);
        boolean z = false;
        this.b.m29195c(0);
        this.b.m29195c(this.a);
        for (int i = 1; i < this.a && !z; i++) {
            this.b.m29195c(i);
            z = this.b.m29207h();
            if (z) {
                this.f27873c = true;
                this.f27875e = i;
                return z;
            }
            this.b.m29199d(i);
            z = this.b.m29207h();
        }
        return z;
    }

    /* renamed from: e */
    private boolean m36535e() {
        this.b = new GF2Polynomial(this.a + 1);
        this.b.m29195c(0);
        this.b.m29195c(this.a);
        int i = 1;
        boolean z = false;
        while (i <= this.a - 3 && !z) {
            this.b.m29195c(i);
            int i2 = i + 1;
            boolean z2 = z;
            int i3 = i2;
            while (i3 <= this.a - 2 && !z2) {
                this.b.m29195c(i3);
                int i4 = i3 + 1;
                boolean z3 = z2;
                for (int i5 = i4; i5 <= this.a - 1 && !z3; i5++) {
                    this.b.m29195c(i5);
                    if ((((((this.a & 1) != 0 ? 1 : 0) | ((i & 1) != 0 ? 1 : 0)) | ((i3 & 1) != 0 ? 1 : 0)) | ((i5 & 1) != 0 ? 1 : 0)) != 0) {
                        z3 = this.b.m29207h();
                        if (z3) {
                            this.f27874d = true;
                            this.f27876f[0] = i;
                            this.f27876f[1] = i3;
                            this.f27876f[2] = i5;
                            return z3;
                        }
                    }
                    this.b.m29199d(i5);
                }
                this.b.m29199d(i3);
                i3 = i4;
                z2 = z3;
            }
            this.b.m29199d(i);
            i = i2;
            z = z2;
        }
        return z;
    }

    /* renamed from: f */
    private boolean m36536f() {
        this.b = new GF2Polynomial(this.a + 1);
        do {
            this.b.m29202e();
            this.b.m29195c(this.a);
            this.b.m29195c(0);
        } while (!this.b.m29207h());
        return true;
    }
}
