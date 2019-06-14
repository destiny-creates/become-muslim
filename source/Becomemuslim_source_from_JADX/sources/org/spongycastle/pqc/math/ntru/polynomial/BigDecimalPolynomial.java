package org.spongycastle.pqc.math.ntru.polynomial;

import com.facebook.appevents.AppEventsConstants;
import java.math.BigDecimal;

public class BigDecimalPolynomial {
    /* renamed from: b */
    private static final BigDecimal f23405b = new BigDecimal(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    /* renamed from: c */
    private static final BigDecimal f23406c = new BigDecimal("0.5");
    /* renamed from: a */
    BigDecimal[] f23407a;

    BigDecimalPolynomial(int i) {
        this.f23407a = new BigDecimal[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.f23407a[i2] = f23405b;
        }
    }

    BigDecimalPolynomial(BigDecimal[] bigDecimalArr) {
        this.f23407a = bigDecimalArr;
    }

    public BigDecimalPolynomial(BigIntPolynomial bigIntPolynomial) {
        int length = bigIntPolynomial.f23409a.length;
        this.f23407a = new BigDecimal[length];
        for (int i = 0; i < length; i++) {
            this.f23407a[i] = new BigDecimal(bigIntPolynomial.f23409a[i]);
        }
    }

    /* renamed from: a */
    public void m29302a() {
        for (int i = 0; i < this.f23407a.length; i++) {
            this.f23407a[i] = this.f23407a[i].multiply(f23406c);
        }
    }

    /* renamed from: a */
    public BigDecimalPolynomial m29301a(BigIntPolynomial bigIntPolynomial) {
        return m29300a(new BigDecimalPolynomial(bigIntPolynomial));
    }

    /* renamed from: a */
    public BigDecimalPolynomial m29300a(BigDecimalPolynomial bigDecimalPolynomial) {
        int length = this.f23407a.length;
        if (bigDecimalPolynomial.f23407a.length == length) {
            bigDecimalPolynomial = m29299d(bigDecimalPolynomial);
            if (bigDecimalPolynomial.f23407a.length > length) {
                for (int i = length; i < bigDecimalPolynomial.f23407a.length; i++) {
                    int i2 = i - length;
                    bigDecimalPolynomial.f23407a[i2] = bigDecimalPolynomial.f23407a[i2].add(bigDecimalPolynomial.f23407a[i]);
                }
                bigDecimalPolynomial.f23407a = m29297a(bigDecimalPolynomial.f23407a, length);
            }
            return bigDecimalPolynomial;
        }
        throw new IllegalArgumentException("Number of coefficients must be the same");
    }

    /* renamed from: d */
    private BigDecimalPolynomial m29299d(BigDecimalPolynomial bigDecimalPolynomial) {
        BigDecimal[] bigDecimalArr = this.f23407a;
        BigDecimal[] bigDecimalArr2 = bigDecimalPolynomial.f23407a;
        int length = bigDecimalPolynomial.f23407a.length;
        int i = 0;
        int i2;
        if (length <= 1) {
            bigDecimalArr = (BigDecimal[]) this.f23407a.clone();
            for (i2 = 0; i2 < this.f23407a.length; i2++) {
                bigDecimalArr[i2] = bigDecimalArr[i2].multiply(bigDecimalPolynomial.f23407a[0]);
            }
            return new BigDecimalPolynomial(bigDecimalArr);
        }
        bigDecimalPolynomial = length / 2;
        BigDecimalPolynomial bigDecimalPolynomial2 = new BigDecimalPolynomial(m29297a(bigDecimalArr, bigDecimalPolynomial));
        BigDecimalPolynomial bigDecimalPolynomial3 = new BigDecimalPolynomial(m29298a(bigDecimalArr, bigDecimalPolynomial, length));
        BigDecimalPolynomial bigDecimalPolynomial4 = new BigDecimalPolynomial(m29297a(bigDecimalArr2, bigDecimalPolynomial));
        BigDecimalPolynomial bigDecimalPolynomial5 = new BigDecimalPolynomial(m29298a(bigDecimalArr2, bigDecimalPolynomial, length));
        BigDecimalPolynomial bigDecimalPolynomial6 = (BigDecimalPolynomial) bigDecimalPolynomial2.clone();
        bigDecimalPolynomial6.m29304b(bigDecimalPolynomial3);
        BigDecimalPolynomial bigDecimalPolynomial7 = (BigDecimalPolynomial) bigDecimalPolynomial4.clone();
        bigDecimalPolynomial7.m29304b(bigDecimalPolynomial5);
        bigDecimalPolynomial4 = bigDecimalPolynomial2.m29299d(bigDecimalPolynomial4);
        bigDecimalPolynomial2 = bigDecimalPolynomial3.m29299d(bigDecimalPolynomial5);
        bigDecimalPolynomial6 = bigDecimalPolynomial6.m29299d(bigDecimalPolynomial7);
        bigDecimalPolynomial6.m29305c(bigDecimalPolynomial4);
        bigDecimalPolynomial6.m29305c(bigDecimalPolynomial2);
        bigDecimalPolynomial3 = new BigDecimalPolynomial((length * 2) - 1);
        for (length = 0; length < bigDecimalPolynomial4.f23407a.length; length++) {
            bigDecimalPolynomial3.f23407a[length] = bigDecimalPolynomial4.f23407a[length];
        }
        for (int i3 = 0; i3 < bigDecimalPolynomial6.f23407a.length; i3++) {
            int i4 = bigDecimalPolynomial + i3;
            bigDecimalPolynomial3.f23407a[i4] = bigDecimalPolynomial3.f23407a[i4].add(bigDecimalPolynomial6.f23407a[i3]);
        }
        while (i < bigDecimalPolynomial2.f23407a.length) {
            i2 = (bigDecimalPolynomial * 2) + i;
            bigDecimalPolynomial3.f23407a[i2] = bigDecimalPolynomial3.f23407a[i2].add(bigDecimalPolynomial2.f23407a[i]);
            i++;
        }
        return bigDecimalPolynomial3;
    }

    /* renamed from: b */
    public void m29304b(BigDecimalPolynomial bigDecimalPolynomial) {
        int length;
        if (bigDecimalPolynomial.f23407a.length > this.f23407a.length) {
            this.f23407a = m29297a(this.f23407a, bigDecimalPolynomial.f23407a.length);
            for (length = this.f23407a.length; length < this.f23407a.length; length++) {
                this.f23407a[length] = f23405b;
            }
        }
        for (length = 0; length < bigDecimalPolynomial.f23407a.length; length++) {
            this.f23407a[length] = this.f23407a[length].add(bigDecimalPolynomial.f23407a[length]);
        }
    }

    /* renamed from: c */
    void m29305c(BigDecimalPolynomial bigDecimalPolynomial) {
        int length;
        if (bigDecimalPolynomial.f23407a.length > this.f23407a.length) {
            this.f23407a = m29297a(this.f23407a, bigDecimalPolynomial.f23407a.length);
            for (length = this.f23407a.length; length < this.f23407a.length; length++) {
                this.f23407a[length] = f23405b;
            }
        }
        for (length = 0; length < bigDecimalPolynomial.f23407a.length; length++) {
            this.f23407a[length] = this.f23407a[length].subtract(bigDecimalPolynomial.f23407a[length]);
        }
    }

    /* renamed from: b */
    public BigIntPolynomial m29303b() {
        int length = this.f23407a.length;
        BigIntPolynomial bigIntPolynomial = new BigIntPolynomial(length);
        for (int i = 0; i < length; i++) {
            bigIntPolynomial.f23409a[i] = this.f23407a[i].setScale(0, 6).toBigInteger();
        }
        return bigIntPolynomial;
    }

    public Object clone() {
        return new BigDecimalPolynomial((BigDecimal[]) this.f23407a.clone());
    }

    /* renamed from: a */
    private BigDecimal[] m29297a(BigDecimal[] bigDecimalArr, int i) {
        Object obj = new BigDecimal[i];
        if (bigDecimalArr.length < i) {
            i = bigDecimalArr.length;
        }
        System.arraycopy(bigDecimalArr, 0, obj, 0, i);
        return obj;
    }

    /* renamed from: a */
    private BigDecimal[] m29298a(BigDecimal[] bigDecimalArr, int i, int i2) {
        i2 -= i;
        Object obj = new BigDecimal[i2];
        if (bigDecimalArr.length - i < i2) {
            i2 = bigDecimalArr.length - i;
        }
        System.arraycopy(bigDecimalArr, i, obj, 0, i2);
        return obj;
    }
}
