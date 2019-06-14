package org.spongycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

public class PolynomialGF2mSmallM {
    /* renamed from: a */
    private GF2mField f23391a;
    /* renamed from: b */
    private int f23392b;
    /* renamed from: c */
    private int[] f23393c;

    public PolynomialGF2mSmallM(GF2mField gF2mField, int i, char c, SecureRandom secureRandom) {
        this.f23391a = gF2mField;
        if (c == 'I') {
            this.f23393c = m29251a(i, secureRandom);
            m29261d();
            return;
        }
        i = new StringBuilder();
        i.append(" Error: type ");
        i.append(c);
        i.append(" is not defined for GF2smallmPolynomial");
        throw new IllegalArgumentException(i.toString());
    }

    /* renamed from: a */
    private int[] m29251a(int i, SecureRandom secureRandom) {
        int[] iArr = new int[(i + 1)];
        int i2 = 1;
        iArr[i] = 1;
        iArr[0] = this.f23391a.m29218b(secureRandom);
        while (i2 < i) {
            iArr[i2] = this.f23391a.m29215a(secureRandom);
            i2++;
        }
        while (!m29255b(iArr)) {
            i2 = RandUtils.m29292a(secureRandom, i);
            if (i2 == 0) {
                iArr[0] = this.f23391a.m29218b(secureRandom);
            } else {
                iArr[i2] = this.f23391a.m29215a(secureRandom);
            }
        }
        return iArr;
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int i) {
        this.f23391a = gF2mField;
        this.f23392b = i;
        this.f23393c = new int[(i + 1)];
        this.f23393c[i] = 1;
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int[] iArr) {
        this.f23391a = gF2mField;
        this.f23393c = m29262d(iArr);
        m29261d();
    }

    public PolynomialGF2mSmallM(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.f23391a = polynomialGF2mSmallM.f23391a;
        this.f23392b = polynomialGF2mSmallM.f23392b;
        this.f23393c = IntUtils.m29234a(polynomialGF2mSmallM.f23393c);
    }

    public PolynomialGF2mSmallM(GF2mVector gF2mVector) {
        this(gF2mVector.m36528a(), gF2mVector.m36530b());
    }

    /* renamed from: a */
    public int m29266a() {
        int length = this.f23393c.length - 1;
        return this.f23393c[length] == 0 ? -1 : length;
    }

    /* renamed from: b */
    public int m29270b() {
        if (this.f23392b == -1) {
            return 0;
        }
        return this.f23393c[this.f23392b];
    }

    /* renamed from: a */
    private static int m29250a(int[] iArr) {
        int c = m29259c(iArr);
        if (c == -1) {
            return null;
        }
        return iArr[c];
    }

    /* renamed from: a */
    public int m29267a(int i) {
        if (i >= 0) {
            if (i <= this.f23392b) {
                return this.f23393c[i];
            }
        }
        return 0;
    }

    /* renamed from: c */
    public byte[] m29275c() {
        int i = 8;
        int i2 = 1;
        while (this.f23391a.m29212a() > i) {
            i2++;
            i += 8;
        }
        byte[] bArr = new byte[(this.f23393c.length * i2)];
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.f23393c.length) {
            int i5 = i4;
            i4 = 0;
            while (i4 < i) {
                int i6 = i5 + 1;
                bArr[i5] = (byte) (this.f23393c[i3] >>> i4);
                i4 += 8;
                i5 = i6;
            }
            i3++;
            i4 = i5;
        }
        return bArr;
    }

    /* renamed from: b */
    public int m29271b(int i) {
        int i2 = this.f23393c[this.f23392b];
        for (int i3 = this.f23392b - 1; i3 >= 0; i3--) {
            i2 = this.f23391a.m29217b(i2, i) ^ this.f23393c[i3];
        }
        return i2;
    }

    /* renamed from: a */
    public PolynomialGF2mSmallM m29268a(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.f23391a, m29253a(this.f23393c, polynomialGF2mSmallM.f23393c));
    }

    /* renamed from: b */
    public void m29272b(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.f23393c = m29253a(this.f23393c, polynomialGF2mSmallM.f23393c);
        m29261d();
    }

    /* renamed from: a */
    private int[] m29253a(int[] iArr, int[] iArr2) {
        int[] iArr3;
        if (iArr.length < iArr2.length) {
            iArr3 = new int[iArr2.length];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        } else {
            iArr3 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            iArr = iArr2;
        }
        for (iArr2 = iArr.length - 1; iArr2 >= null; iArr2--) {
            iArr3[iArr2] = this.f23391a.m29214a(iArr3[iArr2], iArr[iArr2]);
        }
        return iArr3;
    }

    /* renamed from: c */
    public PolynomialGF2mSmallM m29273c(int i) {
        int[] iArr = new int[(i + 1)];
        iArr[i] = 1;
        return new PolynomialGF2mSmallM(this.f23391a, m29253a(this.f23393c, iArr));
    }

    /* renamed from: d */
    public PolynomialGF2mSmallM m29276d(int i) {
        if (this.f23391a.m29221c(i)) {
            return new PolynomialGF2mSmallM(this.f23391a, m29252a(this.f23393c, i));
        }
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    /* renamed from: e */
    public void m29279e(int i) {
        if (this.f23391a.m29221c(i)) {
            this.f23393c = m29252a(this.f23393c, i);
            m29261d();
            return;
        }
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    /* renamed from: a */
    private int[] m29252a(int[] iArr, int i) {
        int c = m29259c(iArr);
        if (c != -1) {
            if (i != 0) {
                if (i == 1) {
                    return IntUtils.m29234a(iArr);
                }
                int[] iArr2 = new int[(c + 1)];
                while (c >= 0) {
                    iArr2[c] = this.f23391a.m29217b(iArr[c], i);
                    c--;
                }
                return iArr2;
            }
        }
        return new int[1];
    }

    /* renamed from: f */
    public PolynomialGF2mSmallM m29280f(int i) {
        return new PolynomialGF2mSmallM(this.f23391a, m29256b(this.f23393c, i));
    }

    /* renamed from: b */
    private static int[] m29256b(int[] iArr, int i) {
        int c = m29259c(iArr);
        if (c == -1) {
            return new int[1];
        }
        Object obj = new int[((c + i) + 1)];
        System.arraycopy(iArr, 0, obj, i, c + 1);
        return obj;
    }

    /* renamed from: b */
    private int[][] m29258b(int[] iArr, int[] iArr2) {
        int c = m29259c(iArr2);
        int c2 = m29259c(iArr) + 1;
        if (c != -1) {
            int[][] iArr3 = new int[][]{new int[1], new int[c2]};
            c2 = this.f23391a.m29213a(m29250a(iArr2));
            iArr3[0][0] = 0;
            System.arraycopy(iArr, 0, iArr3[1], 0, iArr3[1].length);
            while (c <= m29259c(iArr3[1])) {
                iArr = new int[]{this.f23391a.m29217b(m29250a(iArr3[1]), c2)};
                int c3 = m29259c(iArr3[1]) - c;
                int[] b = m29256b(m29252a(iArr2, iArr[0]), c3);
                iArr3[0] = m29253a(m29256b(iArr, c3), iArr3[0]);
                iArr3[1] = m29253a(b, iArr3[1]);
            }
            return iArr3;
        }
        throw new ArithmeticException("Division by zero.");
    }

    /* renamed from: c */
    private int[] m29260c(int[] iArr, int[] iArr2) {
        if (m29259c(iArr) == -1) {
            return iArr2;
        }
        while (m29259c(iArr2) != -1) {
            iArr = m29264e(iArr, iArr2);
            Object obj = new int[iArr2.length];
            System.arraycopy(iArr2, 0, obj, 0, obj.length);
            iArr2 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
            Object obj2 = obj;
        }
        return m29252a(iArr, this.f23391a.m29213a(m29250a(iArr)));
    }

    /* renamed from: c */
    public PolynomialGF2mSmallM m29274c(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.f23391a, m29263d(this.f23393c, polynomialGF2mSmallM.f23393c));
    }

    /* renamed from: d */
    private int[] m29263d(int[] iArr, int[] iArr2) {
        if (m29259c(iArr) < m29259c(iArr2)) {
            int[] iArr3 = iArr2;
            iArr2 = iArr;
            iArr = iArr3;
        }
        iArr = m29262d(iArr);
        iArr2 = m29262d(iArr2);
        if (iArr2.length == 1) {
            return m29252a(iArr, iArr2[0]);
        }
        int length = iArr.length;
        int length2 = iArr2.length;
        int[] iArr4 = new int[((length + length2) - 1)];
        if (length2 != length) {
            Object obj = new int[length2];
            Object obj2 = new int[(length - length2)];
            System.arraycopy(iArr, 0, obj, 0, obj.length);
            System.arraycopy(iArr, length2, obj2, 0, obj2.length);
            iArr = m29253a(m29263d(obj, iArr2), m29256b(m29263d(obj2, iArr2), length2));
        } else {
            int i = (length + 1) >>> 1;
            length -= i;
            int[] iArr5 = new int[i];
            iArr4 = new int[i];
            int[] iArr6 = new int[length];
            int[] iArr7 = new int[length];
            System.arraycopy(iArr, 0, iArr5, 0, iArr5.length);
            System.arraycopy(iArr, i, iArr6, 0, iArr6.length);
            System.arraycopy(iArr2, 0, iArr4, 0, iArr4.length);
            System.arraycopy(iArr2, i, iArr7, 0, iArr7.length);
            iArr = m29253a(iArr5, iArr6);
            iArr2 = m29253a(iArr4, iArr7);
            int[] d = m29263d(iArr5, iArr4);
            iArr = m29263d(iArr, iArr2);
            iArr2 = m29263d(iArr6, iArr7);
            iArr = m29253a(m29256b(m29253a(m29253a(m29253a(iArr, d), iArr2), m29256b(iArr2, i)), i), d);
        }
        return iArr;
    }

    /* renamed from: b */
    private boolean m29255b(int[] iArr) {
        if (iArr[0] == 0) {
            return false;
        }
        int c = m29259c(iArr) >> 1;
        int[] iArr2 = new int[]{0, 1};
        int[] iArr3 = new int[]{0, 1};
        int a = this.f23391a.m29212a();
        int[] iArr4 = iArr2;
        for (int i = 0; i < c; i++) {
            for (int i2 = a - 1; i2 >= 0; i2--) {
                iArr4 = m29254a(iArr4, iArr4, iArr);
            }
            iArr4 = m29262d(iArr4);
            if (m29259c(m29260c(m29253a(iArr4, iArr3), iArr)) != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public PolynomialGF2mSmallM m29277d(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.f23391a, m29264e(this.f23393c, polynomialGF2mSmallM.f23393c));
    }

    /* renamed from: e */
    private int[] m29264e(int[] iArr, int[] iArr2) {
        int c = m29259c(iArr2);
        if (c != -1) {
            int[] iArr3 = new int[iArr.length];
            int a = this.f23391a.m29213a(m29250a(iArr2));
            System.arraycopy(iArr, 0, iArr3, 0, iArr3.length);
            while (c <= m29259c(iArr3)) {
                iArr3 = m29253a(m29252a(m29256b(iArr2, m29259c(iArr3) - c), this.f23391a.m29217b(m29250a(iArr3), a)), iArr3);
            }
            return iArr3;
        }
        throw new ArithmeticException("Division by zero");
    }

    /* renamed from: a */
    private int[] m29254a(int[] iArr, int[] iArr2, int[] iArr3) {
        return m29264e(m29263d(iArr, iArr2), iArr3);
    }

    /* renamed from: a */
    public PolynomialGF2mSmallM m29269a(PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        int length = polynomialGF2mSmallMArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < length; i2++) {
                if (i < polynomialGF2mSmallMArr[i2].f23393c.length) {
                    if (i2 < this.f23393c.length) {
                        iArr[i] = this.f23391a.m29214a(iArr[i], this.f23391a.m29217b(polynomialGF2mSmallMArr[i2].f23393c[i], this.f23393c[i2]));
                    }
                }
            }
        }
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f23391a.m29216b(iArr[i3]);
        }
        return new PolynomialGF2mSmallM(this.f23391a, iArr);
    }

    /* renamed from: b */
    private int[] m29257b(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] d = m29262d(iArr3);
        iArr2 = m29264e(iArr2, iArr3);
        int[] iArr4 = new int[]{0};
        iArr = m29264e(iArr, iArr3);
        while (m29259c(iArr2) != -1) {
            int[][] b = m29258b(d, iArr2);
            iArr2 = m29262d(iArr2);
            int[] d2 = m29262d(b[1]);
            d = m29253a(iArr4, m29254a(b[0], iArr, iArr3));
            iArr4 = m29262d(iArr);
            iArr = m29262d(d);
            d = iArr2;
            iArr2 = d2;
        }
        return m29252a(iArr4, this.f23391a.m29213a(m29250a(d)));
    }

    /* renamed from: e */
    public PolynomialGF2mSmallM m29278e(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.f23391a, m29257b(new int[]{1}, this.f23393c, polynomialGF2mSmallM.f23393c));
    }

    /* renamed from: f */
    public PolynomialGF2mSmallM[] m29281f(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int i = polynomialGF2mSmallM.f23392b >> 1;
        int[] d = m29262d(polynomialGF2mSmallM.f23393c);
        int[] iArr = new int[]{0};
        int[] iArr2 = new int[]{1};
        int[] e = m29264e(this.f23393c, polynomialGF2mSmallM.f23393c);
        int[] iArr3 = d;
        d = e;
        while (m29259c(d) > i) {
            int[][] b = m29258b(iArr3, d);
            int[] iArr4 = b[1];
            iArr3 = m29253a(iArr, m29254a(b[0], iArr2, polynomialGF2mSmallM.f23393c));
            iArr = iArr2;
            iArr2 = iArr3;
            iArr3 = d;
            d = iArr4;
        }
        return new PolynomialGF2mSmallM[]{new PolynomialGF2mSmallM(this.f23391a, d), new PolynomialGF2mSmallM(this.f23391a, iArr2)};
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof PolynomialGF2mSmallM) {
                PolynomialGF2mSmallM polynomialGF2mSmallM = (PolynomialGF2mSmallM) obj;
                if (this.f23391a.equals(polynomialGF2mSmallM.f23391a) && this.f23392b == polynomialGF2mSmallM.f23392b && m29265f(this.f23393c, polynomialGF2mSmallM.f23393c) != null) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: f */
    private static boolean m29265f(int[] iArr, int[] iArr2) {
        int c = m29259c(iArr);
        if (c != m29259c(iArr2)) {
            return false;
        }
        for (int i = 0; i <= c; i++) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return 1;
    }

    public int hashCode() {
        int hashCode = this.f23391a.hashCode();
        for (int i : this.f23393c) {
            hashCode = (hashCode * 31) + i;
        }
        return hashCode;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" Polynomial over ");
        stringBuilder.append(this.f23391a.toString());
        stringBuilder.append(": \n");
        String stringBuilder2 = stringBuilder.toString();
        for (int i = 0; i < this.f23393c.length; i++) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder2);
            stringBuilder3.append(this.f23391a.m29222d(this.f23393c[i]));
            stringBuilder3.append("Y^");
            stringBuilder3.append(i);
            stringBuilder3.append("+");
            stringBuilder2 = stringBuilder3.toString();
        }
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(stringBuilder2);
        stringBuilder4.append(";");
        return stringBuilder4.toString();
    }

    /* renamed from: d */
    private void m29261d() {
        this.f23392b = this.f23393c.length - 1;
        while (this.f23392b >= 0 && this.f23393c[this.f23392b] == 0) {
            this.f23392b--;
        }
    }

    /* renamed from: c */
    private static int m29259c(int[] iArr) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        return length;
    }

    /* renamed from: d */
    private static int[] m29262d(int[] iArr) {
        int c = m29259c(iArr);
        if (c == -1) {
            return new int[1];
        }
        c++;
        if (iArr.length == c) {
            return IntUtils.m29234a(iArr);
        }
        Object obj = new int[c];
        System.arraycopy(iArr, 0, obj, 0, c);
        return obj;
    }
}
