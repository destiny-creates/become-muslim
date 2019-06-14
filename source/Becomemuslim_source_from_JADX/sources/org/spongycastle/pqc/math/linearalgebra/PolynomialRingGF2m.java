package org.spongycastle.pqc.math.linearalgebra;

public class PolynomialRingGF2m {
    /* renamed from: a */
    protected PolynomialGF2mSmallM[] f23394a;
    /* renamed from: b */
    protected PolynomialGF2mSmallM[] f23395b;
    /* renamed from: c */
    private GF2mField f23396c;
    /* renamed from: d */
    private PolynomialGF2mSmallM f23397d;

    public PolynomialRingGF2m(GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.f23396c = gF2mField;
        this.f23397d = polynomialGF2mSmallM;
        m29289b();
        m29290c();
    }

    /* renamed from: a */
    public PolynomialGF2mSmallM[] m29291a() {
        return this.f23395b;
    }

    /* renamed from: b */
    private void m29289b() {
        int a = this.f23397d.m29266a();
        this.f23394a = new PolynomialGF2mSmallM[a];
        int i = 0;
        while (true) {
            int i2 = a >> 1;
            if (i >= i2) {
                break;
            }
            i2 = i << 1;
            int[] iArr = new int[(i2 + 1)];
            iArr[i2] = 1;
            this.f23394a[i] = new PolynomialGF2mSmallM(this.f23396c, iArr);
            i++;
        }
        while (i2 < a) {
            i = i2 << 1;
            iArr = new int[(i + 1)];
            iArr[i] = 1;
            this.f23394a[i2] = new PolynomialGF2mSmallM(this.f23396c, iArr).m29277d(this.f23397d);
            i2++;
        }
    }

    /* renamed from: c */
    private void m29290c() {
        int i;
        int a = this.f23397d.m29266a();
        PolynomialGF2mSmallM[] polynomialGF2mSmallMArr = new PolynomialGF2mSmallM[a];
        int i2 = a - 1;
        for (i = i2; i >= 0; i--) {
            polynomialGF2mSmallMArr[i] = new PolynomialGF2mSmallM(this.f23394a[i]);
        }
        this.f23395b = new PolynomialGF2mSmallM[a];
        while (i2 >= 0) {
            this.f23395b[i2] = new PolynomialGF2mSmallM(this.f23396c, i2);
            i2--;
        }
        for (i = 0; i < a; i++) {
            int i3;
            if (polynomialGF2mSmallMArr[i].m29267a(i) == 0) {
                i3 = i + 1;
                Object obj = null;
                while (i3 < a) {
                    if (polynomialGF2mSmallMArr[i3].m29267a(i) != 0) {
                        m29288a(polynomialGF2mSmallMArr, i, i3);
                        m29288a(this.f23395b, i, i3);
                        i3 = a;
                        obj = 1;
                    }
                    i3++;
                }
                if (obj == null) {
                    throw new ArithmeticException("Squaring matrix is not invertible.");
                }
            }
            i3 = this.f23396c.m29213a(polynomialGF2mSmallMArr[i].m29267a(i));
            polynomialGF2mSmallMArr[i].m29279e(i3);
            this.f23395b[i].m29279e(i3);
            for (i3 = 0; i3 < a; i3++) {
                if (i3 != i) {
                    int a2 = polynomialGF2mSmallMArr[i3].m29267a(i);
                    if (a2 != 0) {
                        PolynomialGF2mSmallM d = polynomialGF2mSmallMArr[i].m29276d(a2);
                        PolynomialGF2mSmallM d2 = this.f23395b[i].m29276d(a2);
                        polynomialGF2mSmallMArr[i3].m29272b(d);
                        this.f23395b[i3].m29272b(d2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m29288a(PolynomialGF2mSmallM[] polynomialGF2mSmallMArr, int i, int i2) {
        PolynomialGF2mSmallM polynomialGF2mSmallM = polynomialGF2mSmallMArr[i];
        polynomialGF2mSmallMArr[i] = polynomialGF2mSmallMArr[i2];
        polynomialGF2mSmallMArr[i2] = polynomialGF2mSmallM;
    }
}
