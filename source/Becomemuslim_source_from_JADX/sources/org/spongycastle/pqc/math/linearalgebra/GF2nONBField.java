package org.spongycastle.pqc.math.linearalgebra;

public class GF2nONBField extends GF2nField {
    /* renamed from: c */
    private int f27870c;
    /* renamed from: d */
    private int f27871d;
    /* renamed from: e */
    private int f27872e;

    /* renamed from: d */
    int m36532d() {
        return this.f27870c;
    }

    /* renamed from: e */
    int m36533e() {
        return this.f27871d;
    }

    /* renamed from: c */
    protected void mo5931c() {
        int i = 1;
        if (this.f27872e == 1) {
            this.b = new GF2Polynomial(this.a + 1, "ALL");
        } else if (this.f27872e == 2) {
            GF2Polynomial gF2Polynomial = new GF2Polynomial(this.a + 1, "ONE");
            GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.a + 1, "X");
            gF2Polynomial2.m29190a(gF2Polynomial);
            while (i < this.a) {
                GF2Polynomial k = gF2Polynomial2.m29210k();
                k.m29190a(gF2Polynomial);
                i++;
                gF2Polynomial = gF2Polynomial2;
                gF2Polynomial2 = k;
            }
            this.b = gF2Polynomial2;
        }
    }
}
