package org.spongycastle.pqc.math.ntru.polynomial;

import java.security.SecureRandom;
import org.spongycastle.pqc.math.ntru.util.Util;
import org.spongycastle.util.Arrays;

public class DenseTernaryPolynomial extends IntegerPolynomial implements TernaryPolynomial {
    public DenseTernaryPolynomial(IntegerPolynomial integerPolynomial) {
        this(integerPolynomial.f27879a);
    }

    public DenseTernaryPolynomial(int[] iArr) {
        super(iArr);
        m42135n();
    }

    /* renamed from: n */
    private void m42135n() {
        for (int i = 0; i != this.a.length; i++) {
            int i2 = this.a[i];
            if (i2 < -1 || i2 > 1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Illegal value: ");
                stringBuilder.append(i2);
                stringBuilder.append(", must be one of {-1, 0, 1}");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    /* renamed from: a */
    public static DenseTernaryPolynomial m42134a(int i, int i2, int i3, SecureRandom secureRandom) {
        return new DenseTernaryPolynomial(Util.m29340a(i, i2, i3, secureRandom));
    }

    /* renamed from: a */
    public IntegerPolynomial mo5934a(IntegerPolynomial integerPolynomial, int i) {
        if (i != 2048) {
            return super.mo5934a(integerPolynomial, i);
        }
        integerPolynomial = (IntegerPolynomial) integerPolynomial.clone();
        integerPolynomial.m36564g(2048);
        return new LongPolynomial5(integerPolynomial).m29326a(this).m29325a();
    }

    /* renamed from: a */
    public int[] mo6591a() {
        int length = this.a.length;
        int[] iArr = new int[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.a[i2] == 1) {
                int i3 = i + 1;
                iArr[i] = i2;
                i = i3;
            }
        }
        return Arrays.m29376b(iArr, i);
    }

    /* renamed from: b */
    public int[] mo6592b() {
        int length = this.a.length;
        int[] iArr = new int[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.a[i2] == -1) {
                int i3 = i + 1;
                iArr[i] = i2;
                i = i3;
            }
        }
        return Arrays.m29376b(iArr, i);
    }

    /* renamed from: c */
    public int mo6593c() {
        return this.a.length;
    }
}
