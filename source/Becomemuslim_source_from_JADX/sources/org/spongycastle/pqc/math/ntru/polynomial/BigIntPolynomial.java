package org.spongycastle.pqc.math.ntru.polynomial;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;

public class BigIntPolynomial {
    /* renamed from: b */
    private static final double f23408b = Math.log10(2.0d);
    /* renamed from: a */
    BigInteger[] f23409a;

    BigIntPolynomial(int i) {
        this.f23409a = new BigInteger[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.f23409a[i2] = Constants.f23410a;
        }
    }

    BigIntPolynomial(BigInteger[] bigIntegerArr) {
        this.f23409a = bigIntegerArr;
    }

    public BigIntPolynomial(IntegerPolynomial integerPolynomial) {
        this.f23409a = new BigInteger[integerPolynomial.f27879a.length];
        for (int i = 0; i < this.f23409a.length; i++) {
            this.f23409a[i] = BigInteger.valueOf((long) integerPolynomial.f27879a[i]);
        }
    }

    /* renamed from: a */
    public BigIntPolynomial m29310a(BigIntPolynomial bigIntPolynomial) {
        int length = this.f23409a.length;
        if (bigIntPolynomial.f23409a.length == length) {
            bigIntPolynomial = m29307d(bigIntPolynomial);
            if (bigIntPolynomial.f23409a.length > length) {
                for (int i = length; i < bigIntPolynomial.f23409a.length; i++) {
                    int i2 = i - length;
                    bigIntPolynomial.f23409a[i2] = bigIntPolynomial.f23409a[i2].add(bigIntPolynomial.f23409a[i]);
                }
                bigIntPolynomial.f23409a = Arrays.m29367a(bigIntPolynomial.f23409a, length);
            }
            return bigIntPolynomial;
        }
        throw new IllegalArgumentException("Number of coefficients must be the same");
    }

    /* renamed from: d */
    private BigIntPolynomial m29307d(BigIntPolynomial bigIntPolynomial) {
        BigInteger[] bigIntegerArr = this.f23409a;
        BigInteger[] bigIntegerArr2 = bigIntPolynomial.f23409a;
        int length = bigIntPolynomial.f23409a.length;
        int i = 0;
        int i2;
        if (length <= 1) {
            bigIntegerArr = Arrays.m29366a(this.f23409a);
            for (i2 = 0; i2 < this.f23409a.length; i2++) {
                bigIntegerArr[i2] = bigIntegerArr[i2].multiply(bigIntPolynomial.f23409a[0]);
            }
            return new BigIntPolynomial(bigIntegerArr);
        }
        int i3 = length / 2;
        BigIntPolynomial bigIntPolynomial2 = new BigIntPolynomial(Arrays.m29367a(bigIntegerArr, i3));
        BigIntPolynomial bigIntPolynomial3 = new BigIntPolynomial(Arrays.m29368a(bigIntegerArr, i3, length));
        BigIntPolynomial bigIntPolynomial4 = new BigIntPolynomial(Arrays.m29367a(bigIntegerArr2, i3));
        BigIntPolynomial bigIntPolynomial5 = new BigIntPolynomial(Arrays.m29368a(bigIntegerArr2, i3, length));
        BigIntPolynomial bigIntPolynomial6 = (BigIntPolynomial) bigIntPolynomial2.clone();
        bigIntPolynomial6.m29313b(bigIntPolynomial3);
        BigIntPolynomial bigIntPolynomial7 = (BigIntPolynomial) bigIntPolynomial4.clone();
        bigIntPolynomial7.m29313b(bigIntPolynomial5);
        bigIntPolynomial4 = bigIntPolynomial2.m29307d(bigIntPolynomial4);
        bigIntPolynomial2 = bigIntPolynomial3.m29307d(bigIntPolynomial5);
        bigIntPolynomial6 = bigIntPolynomial6.m29307d(bigIntPolynomial7);
        bigIntPolynomial6.m29315c(bigIntPolynomial4);
        bigIntPolynomial6.m29315c(bigIntPolynomial2);
        bigIntPolynomial3 = new BigIntPolynomial((length * 2) - 1);
        for (length = 0; length < bigIntPolynomial4.f23409a.length; length++) {
            bigIntPolynomial3.f23409a[length] = bigIntPolynomial4.f23409a[length];
        }
        for (int i4 = 0; i4 < bigIntPolynomial6.f23409a.length; i4++) {
            int i5 = i3 + i4;
            bigIntPolynomial3.f23409a[i5] = bigIntPolynomial3.f23409a[i5].add(bigIntPolynomial6.f23409a[i4]);
        }
        while (i < bigIntPolynomial2.f23409a.length) {
            i2 = (i3 * 2) + i;
            bigIntPolynomial3.f23409a[i2] = bigIntPolynomial3.f23409a[i2].add(bigIntPolynomial2.f23409a[i]);
            i++;
        }
        return bigIntPolynomial3;
    }

    /* renamed from: b */
    public void m29313b(BigIntPolynomial bigIntPolynomial) {
        int length;
        if (bigIntPolynomial.f23409a.length > this.f23409a.length) {
            this.f23409a = Arrays.m29367a(this.f23409a, bigIntPolynomial.f23409a.length);
            for (length = this.f23409a.length; length < this.f23409a.length; length++) {
                this.f23409a[length] = Constants.f23410a;
            }
        }
        for (length = 0; length < bigIntPolynomial.f23409a.length; length++) {
            this.f23409a[length] = this.f23409a[length].add(bigIntPolynomial.f23409a[length]);
        }
    }

    /* renamed from: c */
    public void m29315c(BigIntPolynomial bigIntPolynomial) {
        int length;
        if (bigIntPolynomial.f23409a.length > this.f23409a.length) {
            this.f23409a = Arrays.m29367a(this.f23409a, bigIntPolynomial.f23409a.length);
            for (length = this.f23409a.length; length < this.f23409a.length; length++) {
                this.f23409a[length] = Constants.f23410a;
            }
        }
        for (length = 0; length < bigIntPolynomial.f23409a.length; length++) {
            this.f23409a[length] = this.f23409a[length].subtract(bigIntPolynomial.f23409a[length]);
        }
    }

    /* renamed from: a */
    public void m29311a(BigInteger bigInteger) {
        for (int i = 0; i < this.f23409a.length; i++) {
            this.f23409a[i] = this.f23409a[i].multiply(bigInteger);
        }
    }

    /* renamed from: b */
    public void m29312b(BigInteger bigInteger) {
        BigInteger divide = bigInteger.add(Constants.f23411b).divide(BigInteger.valueOf(2));
        for (int i = 0; i < this.f23409a.length; i++) {
            this.f23409a[i] = this.f23409a[i].compareTo(Constants.f23410a) > 0 ? this.f23409a[i].add(divide) : this.f23409a[i].add(divide.negate());
            this.f23409a[i] = this.f23409a[i].divide(bigInteger);
        }
    }

    /* renamed from: a */
    public BigDecimalPolynomial m29309a(BigDecimal bigDecimal, int i) {
        bigDecimal = Constants.f23412c.divide(bigDecimal, ((((int) (((double) m29306b().bitLength()) * f23408b)) + 1) + i) + 1, 6);
        BigDecimalPolynomial bigDecimalPolynomial = new BigDecimalPolynomial(this.f23409a.length);
        for (int i2 = 0; i2 < this.f23409a.length; i2++) {
            bigDecimalPolynomial.f23407a[i2] = new BigDecimal(this.f23409a[i2]).multiply(bigDecimal).setScale(i, 6);
        }
        return bigDecimalPolynomial;
    }

    /* renamed from: a */
    public int m29308a() {
        return ((int) (((double) m29306b().bitLength()) * f23408b)) + 1;
    }

    /* renamed from: b */
    private BigInteger m29306b() {
        BigInteger abs = this.f23409a[0].abs();
        for (int i = 1; i < this.f23409a.length; i++) {
            BigInteger abs2 = this.f23409a[i].abs();
            if (abs2.compareTo(abs) > 0) {
                abs = abs2;
            }
        }
        return abs;
    }

    /* renamed from: c */
    public void m29314c(BigInteger bigInteger) {
        for (int i = 0; i < this.f23409a.length; i++) {
            this.f23409a[i] = this.f23409a[i].mod(bigInteger);
        }
    }

    public Object clone() {
        return new BigIntPolynomial((BigInteger[]) this.f23409a.clone());
    }

    public int hashCode() {
        return 31 + Arrays.m29347a(this.f23409a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.m29358a(this.f23409a, ((BigIntPolynomial) obj).f23409a) != null;
    }
}
