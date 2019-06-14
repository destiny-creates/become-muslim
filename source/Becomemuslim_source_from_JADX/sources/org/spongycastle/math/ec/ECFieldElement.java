package org.spongycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

public abstract class ECFieldElement implements ECConstants {

    public static class F2m extends ECFieldElement {
        /* renamed from: a */
        private int f32026a;
        /* renamed from: b */
        private int f32027b;
        /* renamed from: h */
        private int[] f32028h;
        /* renamed from: i */
        private LongArray f32029i;

        /* renamed from: d */
        public ECFieldElement mo6559d() {
            return this;
        }

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
                throw new IllegalArgumentException("x value invalid in F2m field element");
            }
            if (i3 == 0 && i4 == 0) {
                this.f32026a = 2;
                this.f32028h = new int[]{i2};
            } else if (i3 >= i4) {
                throw new IllegalArgumentException("k2 must be smaller than k3");
            } else if (i3 > 0) {
                this.f32026a = 3;
                this.f32028h = new int[]{i2, i3, i4};
            } else {
                throw new IllegalArgumentException("k2 must be larger than 0");
            }
            this.f32027b = i;
            this.f32029i = new LongArray(bigInteger);
        }

        private F2m(int i, int[] iArr, LongArray longArray) {
            this.f32027b = i;
            this.f32026a = iArr.length == 1 ? 2 : 3;
            this.f32028h = iArr;
            this.f32029i = longArray;
        }

        /* renamed from: h */
        public int mo6564h() {
            return this.f32029i.m28464d();
        }

        /* renamed from: i */
        public boolean mo6565i() {
            return this.f32029i.m28458a();
        }

        /* renamed from: j */
        public boolean mo6566j() {
            return this.f32029i.m28461b();
        }

        /* renamed from: k */
        public boolean mo6567k() {
            return this.f32029i.m28468g();
        }

        /* renamed from: a */
        public BigInteger mo6549a() {
            return this.f32029i.m28466e();
        }

        /* renamed from: b */
        public int mo6554b() {
            return this.f32027b;
        }

        /* renamed from: b */
        public static void m41156b(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            if ((eCFieldElement instanceof F2m) && (eCFieldElement2 instanceof F2m)) {
                F2m f2m = (F2m) eCFieldElement;
                F2m f2m2 = (F2m) eCFieldElement2;
                if (f2m.f32026a != f2m2.f32026a) {
                    throw new IllegalArgumentException("One of the F2m field elements has incorrect representation");
                } else if (f2m.f32027b != f2m2.f32027b || Arrays.m29356a(f2m.f32028h, f2m2.f32028h) == null) {
                    throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
        }

        /* renamed from: a */
        public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
            LongArray longArray = (LongArray) this.f32029i.clone();
            longArray.m28457a(((F2m) eCFieldElement).f32029i, 0);
            return new F2m(this.f32027b, this.f32028h, longArray);
        }

        /* renamed from: c */
        public ECFieldElement mo6557c() {
            return new F2m(this.f32027b, this.f32028h, this.f32029i.m28467f());
        }

        /* renamed from: b */
        public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
            return mo6551a(eCFieldElement);
        }

        /* renamed from: c */
        public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
            return new F2m(this.f32027b, this.f32028h, this.f32029i.m28455a(((F2m) eCFieldElement).f32029i, this.f32027b, this.f32028h));
        }

        /* renamed from: a */
        public ECFieldElement mo6553a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            return mo6556b(eCFieldElement, eCFieldElement2, eCFieldElement3);
        }

        /* renamed from: b */
        public ECFieldElement mo6556b(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            LongArray longArray = this.f32029i;
            LongArray longArray2 = ((F2m) eCFieldElement).f32029i;
            eCFieldElement2 = ((F2m) eCFieldElement2).f32029i;
            LongArray longArray3 = ((F2m) eCFieldElement3).f32029i;
            LongArray b = longArray.m28460b(longArray2, this.f32027b, this.f32028h);
            LongArray b2 = eCFieldElement2.m28460b(longArray3, this.f32027b, this.f32028h);
            if (b == longArray || b == longArray2) {
                b = (LongArray) b.clone();
            }
            b.m28457a(b2, (int) null);
            b.m28456a(this.f32027b, this.f32028h);
            return new F2m(this.f32027b, this.f32028h, b);
        }

        /* renamed from: d */
        public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
            return mo6558c(eCFieldElement.mo6562f());
        }

        /* renamed from: e */
        public ECFieldElement mo6561e() {
            return new F2m(this.f32027b, this.f32028h, this.f32029i.m28459b(this.f32027b, this.f32028h));
        }

        /* renamed from: a */
        public ECFieldElement mo6552a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            LongArray longArray = this.f32029i;
            eCFieldElement = ((F2m) eCFieldElement).f32029i;
            LongArray longArray2 = ((F2m) eCFieldElement2).f32029i;
            LongArray c = longArray.m28463c(this.f32027b, this.f32028h);
            LongArray b = eCFieldElement.m28460b(longArray2, this.f32027b, this.f32028h);
            if (c == longArray) {
                c = (LongArray) c.clone();
            }
            c.m28457a(b, (int) null);
            c.m28456a(this.f32027b, this.f32028h);
            return new F2m(this.f32027b, this.f32028h, c);
        }

        /* renamed from: a */
        public ECFieldElement mo6550a(int i) {
            return i < 1 ? this : new F2m(this.f32027b, this.f32028h, this.f32029i.m28454a(i, this.f32027b, this.f32028h));
        }

        /* renamed from: f */
        public ECFieldElement mo6562f() {
            return new F2m(this.f32027b, this.f32028h, this.f32029i.m28465d(this.f32027b, this.f32028h));
        }

        /* renamed from: g */
        public ECFieldElement mo6563g() {
            if (!this.f32029i.m28461b()) {
                if (!this.f32029i.m28458a()) {
                    return mo6550a(this.f32027b - 1);
                }
            }
            return this;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof F2m)) {
                return false;
            }
            F2m f2m = (F2m) obj;
            if (this.f32027b != f2m.f32027b || this.f32026a != f2m.f32026a || !Arrays.m29356a(this.f32028h, f2m.f32028h) || this.f32029i.equals(f2m.f32029i) == null) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return (this.f32029i.hashCode() ^ this.f32027b) ^ Arrays.m29344a(this.f32028h);
        }
    }

    public static class Fp extends ECFieldElement {
        /* renamed from: a */
        BigInteger f32030a;
        /* renamed from: b */
        BigInteger f32031b;
        /* renamed from: h */
        BigInteger f32032h;

        /* renamed from: a */
        static BigInteger m41176a(BigInteger bigInteger) {
            int bitLength = bigInteger.bitLength();
            return (bitLength < 96 || bigInteger.shiftRight(bitLength - 64).longValue() != -1) ? null : d.shiftLeft(bitLength).subtract(bigInteger);
        }

        public Fp(BigInteger bigInteger, BigInteger bigInteger2) {
            this(bigInteger, m41176a(bigInteger), bigInteger2);
        }

        Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 == null || bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.f32030a = bigInteger;
            this.f32031b = bigInteger2;
            this.f32032h = bigInteger3;
        }

        /* renamed from: a */
        public BigInteger mo6549a() {
            return this.f32032h;
        }

        /* renamed from: b */
        public int mo6554b() {
            return this.f32030a.bitLength();
        }

        /* renamed from: a */
        public ECFieldElement mo6551a(ECFieldElement eCFieldElement) {
            return new Fp(this.f32030a, this.f32031b, m41180a(this.f32032h, eCFieldElement.mo6549a()));
        }

        /* renamed from: c */
        public ECFieldElement mo6557c() {
            BigInteger add = this.f32032h.add(ECConstants.f23076d);
            if (add.compareTo(this.f32030a) == 0) {
                add = ECConstants.f23075c;
            }
            return new Fp(this.f32030a, this.f32031b, add);
        }

        /* renamed from: b */
        public ECFieldElement mo6555b(ECFieldElement eCFieldElement) {
            return new Fp(this.f32030a, this.f32031b, m41190c(this.f32032h, eCFieldElement.mo6549a()));
        }

        /* renamed from: c */
        public ECFieldElement mo6558c(ECFieldElement eCFieldElement) {
            return new Fp(this.f32030a, this.f32031b, m41186b(this.f32032h, eCFieldElement.mo6549a()));
        }

        /* renamed from: a */
        public ECFieldElement mo6553a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.f32032h;
            eCFieldElement = eCFieldElement.mo6549a();
            eCFieldElement2 = eCFieldElement2.mo6549a();
            eCFieldElement3 = eCFieldElement3.mo6549a();
            return new Fp(this.f32030a, this.f32031b, m41196e(bigInteger.multiply(eCFieldElement).subtract(eCFieldElement2.multiply(eCFieldElement3))));
        }

        /* renamed from: b */
        public ECFieldElement mo6556b(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.f32032h;
            eCFieldElement = eCFieldElement.mo6549a();
            eCFieldElement2 = eCFieldElement2.mo6549a();
            eCFieldElement3 = eCFieldElement3.mo6549a();
            return new Fp(this.f32030a, this.f32031b, m41196e(bigInteger.multiply(eCFieldElement).add(eCFieldElement2.multiply(eCFieldElement3))));
        }

        /* renamed from: d */
        public ECFieldElement mo6560d(ECFieldElement eCFieldElement) {
            return new Fp(this.f32030a, this.f32031b, m41186b(this.f32032h, m41193d(eCFieldElement.mo6549a())));
        }

        /* renamed from: d */
        public ECFieldElement mo6559d() {
            return this.f32032h.signum() == 0 ? this : new Fp(this.f32030a, this.f32031b, this.f32030a.subtract(this.f32032h));
        }

        /* renamed from: e */
        public ECFieldElement mo6561e() {
            return new Fp(this.f32030a, this.f32031b, m41186b(this.f32032h, this.f32032h));
        }

        /* renamed from: a */
        public ECFieldElement mo6552a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger bigInteger = this.f32032h;
            eCFieldElement = eCFieldElement.mo6549a();
            eCFieldElement2 = eCFieldElement2.mo6549a();
            return new Fp(this.f32030a, this.f32031b, m41196e(bigInteger.multiply(bigInteger).add(eCFieldElement.multiply(eCFieldElement2))));
        }

        /* renamed from: f */
        public ECFieldElement mo6562f() {
            return new Fp(this.f32030a, this.f32031b, m41193d(this.f32032h));
        }

        /* renamed from: g */
        public ECFieldElement mo6563g() {
            if (!mo6566j()) {
                if (!mo6565i()) {
                    if (!this.f32030a.testBit(0)) {
                        throw new RuntimeException("not done yet");
                    } else if (this.f32030a.testBit(1)) {
                        return m41178e(new Fp(this.f32030a, this.f32031b, this.f32032h.modPow(this.f32030a.shiftRight(2).add(ECConstants.f23076d), this.f32030a)));
                    } else if (this.f32030a.testBit(2)) {
                        r0 = this.f32032h.modPow(this.f32030a.shiftRight(3), this.f32030a);
                        BigInteger b = m41186b(r0, this.f32032h);
                        if (m41186b(b, r0).equals(ECConstants.f23076d)) {
                            return m41178e(new Fp(this.f32030a, this.f32031b, b));
                        }
                        return m41178e(new Fp(this.f32030a, this.f32031b, m41186b(b, ECConstants.f23077e.modPow(this.f32030a.shiftRight(2), this.f32030a))));
                    } else {
                        r0 = this.f32030a.shiftRight(1);
                        if (!this.f32032h.modPow(r0, this.f32030a).equals(ECConstants.f23076d)) {
                            return null;
                        }
                        BigInteger bigInteger = this.f32032h;
                        BigInteger b2 = m41185b(m41185b(bigInteger));
                        BigInteger add = r0.add(ECConstants.f23076d);
                        BigInteger subtract = this.f32030a.subtract(ECConstants.f23076d);
                        Random random = new Random();
                        while (true) {
                            BigInteger bigInteger2 = new BigInteger(this.f32030a.bitLength(), random);
                            if (bigInteger2.compareTo(this.f32030a) < 0 && m41196e(bigInteger2.multiply(bigInteger2).subtract(b2)).modPow(r0, this.f32030a).equals(subtract)) {
                                BigInteger[] a = m41177a(bigInteger2, bigInteger, add);
                                BigInteger bigInteger3 = a[0];
                                bigInteger2 = a[1];
                                if (m41186b(bigInteger2, bigInteger2).equals(b2)) {
                                    return new Fp(this.f32030a, this.f32031b, m41189c(bigInteger2));
                                }
                                if (!(bigInteger3.equals(ECConstants.f23076d) || bigInteger3.equals(subtract))) {
                                    return null;
                                }
                            }
                        }
                    }
                }
            }
            return this;
        }

        /* renamed from: e */
        private ECFieldElement m41178e(ECFieldElement eCFieldElement) {
            return eCFieldElement.mo6561e().equals(this) ? eCFieldElement : null;
        }

        /* renamed from: a */
        private BigInteger[] m41177a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            int bitLength = bigInteger3.bitLength();
            int lowestSetBit = bigInteger3.getLowestSetBit();
            BigInteger bigInteger4 = ECConstants.f23076d;
            BigInteger bigInteger5 = ECConstants.f23077e;
            BigInteger bigInteger6 = ECConstants.f23076d;
            BigInteger bigInteger7 = ECConstants.f23076d;
            BigInteger bigInteger8 = bigInteger;
            for (bitLength--; bitLength >= lowestSetBit + 1; bitLength--) {
                bigInteger6 = m41186b(bigInteger6, bigInteger7);
                if (bigInteger3.testBit(bitLength)) {
                    bigInteger7 = m41186b(bigInteger6, bigInteger2);
                    bigInteger4 = m41186b(bigInteger4, bigInteger8);
                    bigInteger5 = m41196e(bigInteger8.multiply(bigInteger5).subtract(bigInteger.multiply(bigInteger6)));
                    bigInteger8 = m41196e(bigInteger8.multiply(bigInteger8).subtract(bigInteger7.shiftLeft(1)));
                } else {
                    bigInteger4 = m41196e(bigInteger4.multiply(bigInteger5).subtract(bigInteger6));
                    bigInteger7 = m41196e(bigInteger8.multiply(bigInteger5).subtract(bigInteger.multiply(bigInteger6)));
                    bigInteger5 = m41196e(bigInteger5.multiply(bigInteger5).subtract(bigInteger6.shiftLeft(1)));
                    bigInteger8 = bigInteger7;
                    bigInteger7 = bigInteger6;
                }
            }
            bigInteger3 = m41186b(bigInteger6, bigInteger7);
            bigInteger2 = m41186b(bigInteger3, bigInteger2);
            BigInteger e = m41196e(bigInteger4.multiply(bigInteger5).subtract(bigInteger3));
            bigInteger = m41196e(bigInteger8.multiply(bigInteger5).subtract(bigInteger.multiply(bigInteger3)));
            bigInteger3 = m41186b(bigInteger3, bigInteger2);
            bigInteger2 = bigInteger;
            for (bigInteger = true; bigInteger <= lowestSetBit; bigInteger++) {
                e = m41186b(e, bigInteger2);
                bigInteger2 = m41196e(bigInteger2.multiply(bigInteger2).subtract(bigInteger3.shiftLeft(1)));
                bigInteger3 = m41186b(bigInteger3, bigInteger3);
            }
            return new BigInteger[]{e, bigInteger2};
        }

        /* renamed from: a */
        protected BigInteger m41180a(BigInteger bigInteger, BigInteger bigInteger2) {
            bigInteger = bigInteger.add(bigInteger2);
            return bigInteger.compareTo(this.f32030a) >= null ? bigInteger.subtract(this.f32030a) : bigInteger;
        }

        /* renamed from: b */
        protected BigInteger m41185b(BigInteger bigInteger) {
            bigInteger = bigInteger.shiftLeft(1);
            return bigInteger.compareTo(this.f32030a) >= 0 ? bigInteger.subtract(this.f32030a) : bigInteger;
        }

        /* renamed from: c */
        protected BigInteger m41189c(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.f32030a.subtract(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        /* renamed from: d */
        protected BigInteger m41193d(BigInteger bigInteger) {
            int b = mo6554b();
            int i = (b + 31) >> 5;
            int[] a = Nat.m29016a(b, this.f32030a);
            bigInteger = Nat.m29016a(b, bigInteger);
            int[] a2 = Nat.m29015a(i);
            Mod.m28835a(a, bigInteger, a2);
            return Nat.m29038f(i, a2);
        }

        /* renamed from: b */
        protected BigInteger m41186b(BigInteger bigInteger, BigInteger bigInteger2) {
            return m41196e(bigInteger.multiply(bigInteger2));
        }

        /* renamed from: e */
        protected BigInteger m41196e(BigInteger bigInteger) {
            if (this.f32031b == null) {
                return bigInteger.mod(this.f32030a);
            }
            Object obj = bigInteger.signum() < 0 ? 1 : null;
            if (obj != null) {
                bigInteger = bigInteger.abs();
            }
            int bitLength = this.f32030a.bitLength();
            boolean equals = this.f32031b.equals(ECConstants.f23076d);
            while (bigInteger.bitLength() > bitLength + 1) {
                BigInteger shiftRight = bigInteger.shiftRight(bitLength);
                bigInteger = bigInteger.subtract(shiftRight.shiftLeft(bitLength));
                if (!equals) {
                    shiftRight = shiftRight.multiply(this.f32031b);
                }
                bigInteger = shiftRight.add(bigInteger);
            }
            while (bigInteger.compareTo(this.f32030a) >= 0) {
                bigInteger = bigInteger.subtract(this.f32030a);
            }
            if (obj == null || bigInteger.signum() == 0) {
                return bigInteger;
            }
            return this.f32030a.subtract(bigInteger);
        }

        /* renamed from: c */
        protected BigInteger m41190c(BigInteger bigInteger, BigInteger bigInteger2) {
            bigInteger = bigInteger.subtract(bigInteger2);
            return bigInteger.signum() < null ? bigInteger.add(this.f32030a) : bigInteger;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Fp)) {
                return false;
            }
            Fp fp = (Fp) obj;
            if (!this.f32030a.equals(fp.f32030a) || this.f32032h.equals(fp.f32032h) == null) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return this.f32030a.hashCode() ^ this.f32032h.hashCode();
        }
    }

    /* renamed from: a */
    public abstract BigInteger mo6549a();

    /* renamed from: a */
    public abstract ECFieldElement mo6551a(ECFieldElement eCFieldElement);

    /* renamed from: b */
    public abstract int mo6554b();

    /* renamed from: b */
    public abstract ECFieldElement mo6555b(ECFieldElement eCFieldElement);

    /* renamed from: c */
    public abstract ECFieldElement mo6557c();

    /* renamed from: c */
    public abstract ECFieldElement mo6558c(ECFieldElement eCFieldElement);

    /* renamed from: d */
    public abstract ECFieldElement mo6559d();

    /* renamed from: d */
    public abstract ECFieldElement mo6560d(ECFieldElement eCFieldElement);

    /* renamed from: e */
    public abstract ECFieldElement mo6561e();

    /* renamed from: f */
    public abstract ECFieldElement mo6562f();

    /* renamed from: g */
    public abstract ECFieldElement mo6563g();

    /* renamed from: h */
    public int mo6564h() {
        return mo6549a().bitLength();
    }

    /* renamed from: i */
    public boolean mo6565i() {
        return mo6564h() == 1;
    }

    /* renamed from: j */
    public boolean mo6566j() {
        return mo6549a().signum() == 0;
    }

    /* renamed from: a */
    public ECFieldElement mo6553a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return mo6558c(eCFieldElement).mo6555b(eCFieldElement2.mo6558c(eCFieldElement3));
    }

    /* renamed from: b */
    public ECFieldElement mo6556b(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return mo6558c(eCFieldElement).mo6551a(eCFieldElement2.mo6558c(eCFieldElement3));
    }

    /* renamed from: a */
    public ECFieldElement mo6552a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return mo6561e().mo6551a(eCFieldElement.mo6558c(eCFieldElement2));
    }

    /* renamed from: a */
    public ECFieldElement mo6550a(int i) {
        ECFieldElement eCFieldElement = this;
        for (int i2 = 0; i2 < i; i2++) {
            eCFieldElement = eCFieldElement.mo6561e();
        }
        return eCFieldElement;
    }

    /* renamed from: k */
    public boolean mo6567k() {
        return mo6549a().testBit(0);
    }

    public String toString() {
        return mo6549a().toString(16);
    }

    /* renamed from: l */
    public byte[] m36293l() {
        return BigIntegers.m29388a((mo6554b() + 7) / 8, mo6549a());
    }
}
