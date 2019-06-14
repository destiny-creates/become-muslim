package org.spongycastle.pqc.math.ntru.polynomial;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.pqc.math.ntru.util.Util;
import org.spongycastle.util.Arrays;

public class SparseTernaryPolynomial implements TernaryPolynomial {
    /* renamed from: a */
    private int f32187a;
    /* renamed from: b */
    private int[] f32188b = new int[this.f32187a];
    /* renamed from: c */
    private int[] f32189c = new int[this.f32187a];

    public SparseTernaryPolynomial(int[] iArr) {
        this.f32187a = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f32187a; i3++) {
            int i4 = iArr[i3];
            int i5;
            switch (i4) {
                case -1:
                    i5 = i2 + 1;
                    this.f32189c[i2] = i3;
                    i2 = i5;
                    break;
                case 0:
                    break;
                case 1:
                    i5 = i + 1;
                    this.f32188b[i] = i3;
                    i = i5;
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Illegal value: ");
                    stringBuilder.append(i4);
                    stringBuilder.append(", must be one of {-1, 0, 1}");
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        this.f32188b = Arrays.m29376b(this.f32188b, i);
        this.f32189c = Arrays.m29376b(this.f32189c, i2);
    }

    /* renamed from: a */
    public static SparseTernaryPolynomial m42140a(int i, int i2, int i3, SecureRandom secureRandom) {
        return new SparseTernaryPolynomial(Util.m29340a(i, i2, i3, secureRandom));
    }

    /* renamed from: a */
    public IntegerPolynomial mo5933a(IntegerPolynomial integerPolynomial) {
        integerPolynomial = integerPolynomial.f27879a;
        if (integerPolynomial.length == this.f32187a) {
            int i;
            int i2;
            int[] iArr = new int[this.f32187a];
            for (i = 0; i != this.f32188b.length; i++) {
                int i3 = (this.f32187a - 1) - this.f32188b[i];
                for (i2 = this.f32187a - 1; i2 >= 0; i2--) {
                    iArr[i2] = iArr[i2] + integerPolynomial[i3];
                    i3--;
                    if (i3 < 0) {
                        i3 = this.f32187a - 1;
                    }
                }
            }
            for (int i4 = 0; i4 != this.f32189c.length; i4++) {
                i2 = (this.f32187a - 1) - this.f32189c[i4];
                for (i = this.f32187a - 1; i >= 0; i--) {
                    iArr[i] = iArr[i] - integerPolynomial[i2];
                    i2--;
                    if (i2 < 0) {
                        i2 = this.f32187a - 1;
                    }
                }
            }
            return new IntegerPolynomial(iArr);
        }
        throw new IllegalArgumentException("Number of coefficients must be the same");
    }

    /* renamed from: a */
    public IntegerPolynomial mo5934a(IntegerPolynomial integerPolynomial, int i) {
        integerPolynomial = mo5933a(integerPolynomial);
        integerPolynomial.m36568i(i);
        return integerPolynomial;
    }

    /* renamed from: a */
    public BigIntPolynomial mo5932a(BigIntPolynomial bigIntPolynomial) {
        bigIntPolynomial = bigIntPolynomial.f23409a;
        if (bigIntPolynomial.length == this.f32187a) {
            int i;
            int i2;
            BigInteger[] bigIntegerArr = new BigInteger[this.f32187a];
            for (i = 0; i < this.f32187a; i++) {
                bigIntegerArr[i] = BigInteger.ZERO;
            }
            for (i = 0; i != this.f32188b.length; i++) {
                int i3 = (this.f32187a - 1) - this.f32188b[i];
                for (i2 = this.f32187a - 1; i2 >= 0; i2--) {
                    bigIntegerArr[i2] = bigIntegerArr[i2].add(bigIntPolynomial[i3]);
                    i3--;
                    if (i3 < 0) {
                        i3 = this.f32187a - 1;
                    }
                }
            }
            for (int i4 = 0; i4 != this.f32189c.length; i4++) {
                i2 = (this.f32187a - 1) - this.f32189c[i4];
                for (i = this.f32187a - 1; i >= 0; i--) {
                    bigIntegerArr[i] = bigIntegerArr[i].subtract(bigIntPolynomial[i2]);
                    i2--;
                    if (i2 < 0) {
                        i2 = this.f32187a - 1;
                    }
                }
            }
            return new BigIntPolynomial(bigIntegerArr);
        }
        throw new IllegalArgumentException("Number of coefficients must be the same");
    }

    /* renamed from: a */
    public int[] mo6591a() {
        return this.f32188b;
    }

    /* renamed from: b */
    public int[] mo6592b() {
        return this.f32189c;
    }

    /* renamed from: m */
    public IntegerPolynomial mo5935m() {
        int[] iArr = new int[this.f32187a];
        for (int i = 0; i != this.f32188b.length; i++) {
            iArr[this.f32188b[i]] = 1;
        }
        for (int i2 = 0; i2 != this.f32189c.length; i2++) {
            iArr[this.f32189c[i2]] = -1;
        }
        return new IntegerPolynomial(iArr);
    }

    /* renamed from: c */
    public int mo6593c() {
        return this.f32187a;
    }

    public int hashCode() {
        return ((((this.f32187a + 31) * 31) + Arrays.m29344a(this.f32189c)) * 31) + Arrays.m29344a(this.f32188b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SparseTernaryPolynomial sparseTernaryPolynomial = (SparseTernaryPolynomial) obj;
        return this.f32187a == sparseTernaryPolynomial.f32187a && Arrays.m29356a(this.f32189c, sparseTernaryPolynomial.f32189c) && Arrays.m29356a(this.f32188b, sparseTernaryPolynomial.f32188b) != null;
    }
}
