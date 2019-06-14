package org.spongycastle.math.ec;

import java.math.BigInteger;

class SimpleBigDecimal {
    /* renamed from: a */
    private final BigInteger f23106a;
    /* renamed from: b */
    private final int f23107b;

    public SimpleBigDecimal(BigInteger bigInteger, int i) {
        if (i >= 0) {
            this.f23106a = bigInteger;
            this.f23107b = i;
            return;
        }
        throw new IllegalArgumentException("scale may not be negative");
    }

    /* renamed from: c */
    private void m28469c(SimpleBigDecimal simpleBigDecimal) {
        if (this.f23107b != simpleBigDecimal.f23107b) {
            throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
        }
    }

    /* renamed from: a */
    public SimpleBigDecimal m28471a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("scale may not be negative");
        } else if (i == this.f23107b) {
            return this;
        } else {
            return new SimpleBigDecimal(this.f23106a.shiftLeft(i - this.f23107b), i);
        }
    }

    /* renamed from: a */
    public SimpleBigDecimal m28473a(SimpleBigDecimal simpleBigDecimal) {
        m28469c(simpleBigDecimal);
        return new SimpleBigDecimal(this.f23106a.add(simpleBigDecimal.f23106a), this.f23107b);
    }

    /* renamed from: a */
    public SimpleBigDecimal m28470a() {
        return new SimpleBigDecimal(this.f23106a.negate(), this.f23107b);
    }

    /* renamed from: b */
    public SimpleBigDecimal m28476b(SimpleBigDecimal simpleBigDecimal) {
        return m28473a(simpleBigDecimal.m28470a());
    }

    /* renamed from: a */
    public SimpleBigDecimal m28472a(BigInteger bigInteger) {
        return new SimpleBigDecimal(this.f23106a.subtract(bigInteger.shiftLeft(this.f23107b)), this.f23107b);
    }

    /* renamed from: b */
    public int m28474b(BigInteger bigInteger) {
        return this.f23106a.compareTo(bigInteger.shiftLeft(this.f23107b));
    }

    /* renamed from: b */
    public BigInteger m28475b() {
        return this.f23106a.shiftRight(this.f23107b);
    }

    /* renamed from: c */
    public BigInteger m28477c() {
        return m28473a(new SimpleBigDecimal(ECConstants.f23076d, 1).m28471a(this.f23107b)).m28475b();
    }

    /* renamed from: d */
    public int m28478d() {
        return this.f23107b;
    }

    public String toString() {
        if (this.f23107b == 0) {
            return this.f23106a.toString();
        }
        BigInteger b = m28475b();
        BigInteger subtract = this.f23106a.subtract(b.shiftLeft(this.f23107b));
        if (this.f23106a.signum() == -1) {
            subtract = ECConstants.f23076d.shiftLeft(this.f23107b).subtract(subtract);
        }
        if (b.signum() == -1 && !subtract.equals(ECConstants.f23075c)) {
            b = b.add(ECConstants.f23076d);
        }
        String bigInteger = b.toString();
        char[] cArr = new char[this.f23107b];
        String bigInteger2 = subtract.toString(2);
        int length = bigInteger2.length();
        int i = this.f23107b - length;
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = '0';
        }
        for (int i3 = 0; i3 < length; i3++) {
            cArr[i + i3] = bigInteger2.charAt(i3);
        }
        bigInteger2 = new String(cArr);
        StringBuffer stringBuffer = new StringBuffer(bigInteger);
        stringBuffer.append(".");
        stringBuffer.append(bigInteger2);
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleBigDecimal)) {
            return false;
        }
        SimpleBigDecimal simpleBigDecimal = (SimpleBigDecimal) obj;
        if (!this.f23106a.equals(simpleBigDecimal.f23106a) || this.f23107b != simpleBigDecimal.f23107b) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.f23106a.hashCode() ^ this.f23107b;
    }
}
