package org.spongycastle.math.ec;

import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Random;
import org.spongycastle.math.ec.endo.ECEndomorphism;
import org.spongycastle.math.ec.endo.GLVEndomorphism;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.FiniteFields;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.Integers;

public abstract class ECCurve {
    /* renamed from: a */
    protected FiniteField f23084a;
    /* renamed from: b */
    protected ECFieldElement f23085b;
    /* renamed from: c */
    protected ECFieldElement f23086c;
    /* renamed from: d */
    protected BigInteger f23087d;
    /* renamed from: e */
    protected BigInteger f23088e;
    /* renamed from: f */
    protected int f23089f = 0;
    /* renamed from: g */
    protected ECEndomorphism f23090g = null;
    /* renamed from: h */
    protected ECMultiplier f23091h = null;

    public class Config {
        /* renamed from: a */
        protected int f23080a;
        /* renamed from: b */
        protected ECEndomorphism f23081b;
        /* renamed from: c */
        protected ECMultiplier f23082c;
        /* renamed from: d */
        final /* synthetic */ ECCurve f23083d;

        Config(ECCurve eCCurve, int i, ECEndomorphism eCEndomorphism, ECMultiplier eCMultiplier) {
            this.f23083d = eCCurve;
            this.f23080a = i;
            this.f23081b = eCEndomorphism;
            this.f23082c = eCMultiplier;
        }

        /* renamed from: a */
        public Config m28356a(int i) {
            this.f23080a = i;
            return this;
        }

        /* renamed from: a */
        public Config m28357a(ECEndomorphism eCEndomorphism) {
            this.f23081b = eCEndomorphism;
            return this;
        }

        /* renamed from: a */
        public ECCurve m28358a() {
            if (this.f23083d.mo6544a(this.f23080a)) {
                ECCurve c = this.f23083d.mo6545c();
                if (c != this.f23083d) {
                    synchronized (c) {
                        c.f23089f = this.f23080a;
                        c.f23090g = this.f23081b;
                        c.f23091h = this.f23082c;
                    }
                    return c;
                }
                throw new IllegalStateException("implementation returned current curve");
            }
            throw new IllegalStateException("unsupported coordinate system");
        }
    }

    public static abstract class AbstractF2m extends ECCurve {
        /* renamed from: i */
        private BigInteger[] f27637i = 0;

        /* renamed from: a */
        private static FiniteField m36269a(int i, int i2, int i3, int i4) {
            if (i2 == 0) {
                throw new IllegalArgumentException("k1 must be > 0");
            } else if (i3 == 0) {
                if (i4 == 0) {
                    return FiniteFields.m28825a(new int[]{0, i2, i});
                }
                throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
            } else if (i3 <= i2) {
                throw new IllegalArgumentException("k2 must be > k1");
            } else if (i4 > i3) {
                return FiniteFields.m28825a(new int[]{0, i2, i3, i4, i});
            } else {
                throw new IllegalArgumentException("k3 must be > k2");
            }
        }

        protected AbstractF2m(int i, int i2, int i3, int i4) {
            super(m36269a(i, i2, i3, i4));
        }

        /* renamed from: b */
        public ECPoint mo5902b(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
            ECFieldElement a = mo6541a(bigInteger);
            bigInteger2 = mo6541a(bigInteger2);
            switch (m28387k()) {
                case 5:
                case 6:
                    if (!a.mo6566j()) {
                        bigInteger2 = bigInteger2.mo6560d(a).mo6551a(a);
                        break;
                    } else if (bigInteger2.mo6561e().equals(m28384h())) {
                        break;
                    } else {
                        throw new IllegalArgumentException();
                    }
                default:
                    break;
            }
            return mo6542a(a, (ECFieldElement) bigInteger2, z);
        }

        /* renamed from: n */
        synchronized BigInteger[] m36271n() {
            if (this.f27637i == null) {
                this.f27637i = Tnaf.m28489a(this);
            }
            return this.f27637i;
        }

        /* renamed from: o */
        public boolean mo6577o() {
            return this.d != null && this.e != null && this.c.mo6565i() && (this.b.mo6566j() || this.b.mo6565i());
        }
    }

    public static abstract class AbstractFp extends ECCurve {
        protected AbstractFp(BigInteger bigInteger) {
            super(FiniteFields.m28824a(bigInteger));
        }

        /* renamed from: a */
        protected ECPoint mo5903a(int i, BigInteger bigInteger) {
            bigInteger = mo6541a(bigInteger);
            ECFieldElement g = bigInteger.mo6561e().mo6551a(this.b).mo6558c(bigInteger).mo6551a(this.c).mo6563g();
            if (g != null) {
                if (g.mo6567k() != (i == 1)) {
                    g = g.mo6559d();
                }
                return mo6542a((ECFieldElement) bigInteger, g, true);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }
    }

    public static class F2m extends AbstractF2m {
        /* renamed from: i */
        private int f32018i;
        /* renamed from: j */
        private int f32019j;
        /* renamed from: k */
        private int f32020k;
        /* renamed from: l */
        private int f32021l;
        /* renamed from: m */
        private org.spongycastle.math.ec.ECPoint.F2m f32022m;

        /* renamed from: a */
        public boolean mo6544a(int i) {
            if (i != 6) {
                switch (i) {
                    case 0:
                    case 1:
                        break;
                    default:
                        return false;
                }
            }
            return true;
        }

        public F2m(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(i, i2, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i, i2, i3, i4, bigInteger, bigInteger2, null, null);
        }

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(i, i2, i3, i4);
            this.f32018i = i;
            this.f32019j = i2;
            this.f32020k = i3;
            this.f32021l = i4;
            this.d = bigInteger3;
            this.e = bigInteger4;
            this.f32022m = new org.spongycastle.math.ec.ECPoint.F2m(this, null, null);
            this.b = mo6541a(bigInteger);
            this.c = mo6541a(bigInteger2);
            this.f = 6;
        }

        protected F2m(int i, int i2, int i3, int i4, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, BigInteger bigInteger, BigInteger bigInteger2) {
            super(i, i2, i3, i4);
            this.f32018i = i;
            this.f32019j = i2;
            this.f32020k = i3;
            this.f32021l = i4;
            this.d = bigInteger;
            this.e = bigInteger2;
            this.f32022m = new org.spongycastle.math.ec.ECPoint.F2m(this, null, null);
            this.b = eCFieldElement;
            this.c = eCFieldElement2;
            this.f = 6;
        }

        /* renamed from: c */
        protected ECCurve mo6545c() {
            return new F2m(this.f32018i, this.f32019j, this.f32020k, this.f32021l, this.b, this.c, this.d, this.e);
        }

        /* renamed from: d */
        protected ECMultiplier mo6546d() {
            if (mo6577o()) {
                return new WTauNafMultiplier();
            }
            return super.mo6546d();
        }

        /* renamed from: a */
        public int mo6540a() {
            return this.f32018i;
        }

        /* renamed from: a */
        public ECFieldElement mo6541a(BigInteger bigInteger) {
            return new org.spongycastle.math.ec.ECFieldElement.F2m(this.f32018i, this.f32019j, this.f32020k, this.f32021l, bigInteger);
        }

        /* renamed from: a */
        protected ECPoint mo6542a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            return new org.spongycastle.math.ec.ECPoint.F2m(this, eCFieldElement, eCFieldElement2, z);
        }

        /* renamed from: a */
        protected ECPoint mo6543a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            return new org.spongycastle.math.ec.ECPoint.F2m(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
        }

        /* renamed from: e */
        public ECPoint mo6547e() {
            return this.f32022m;
        }

        /* renamed from: a */
        protected ECPoint mo5903a(int i, BigInteger bigInteger) {
            ECFieldElement a = mo6541a(bigInteger);
            if (a.mo6566j()) {
                i = this.c.mo6563g();
            } else {
                ECFieldElement a2 = m41138a(a.mo6561e().mo6562f().mo6558c(this.c).mo6551a(this.b).mo6551a(a));
                if (a2 != null) {
                    if (a2.mo6567k() != (i == 1)) {
                        a2 = a2.mo6557c();
                    }
                    switch (m28387k()) {
                        case 5:
                        case 6:
                            i = a2.mo6551a(a);
                            break;
                        default:
                            i = a2.mo6558c(a);
                            break;
                    }
                }
                i = 0;
            }
            if (i != 0) {
                return mo6542a(a, i, true);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }

        /* renamed from: a */
        private ECFieldElement m41138a(ECFieldElement eCFieldElement) {
            if (eCFieldElement.mo6566j()) {
                return eCFieldElement;
            }
            ECFieldElement eCFieldElement2;
            ECFieldElement a = mo6541a(ECConstants.f23075c);
            Random random = new Random();
            do {
                ECFieldElement a2 = mo6541a(new BigInteger(this.f32018i, random));
                ECFieldElement eCFieldElement3 = eCFieldElement;
                eCFieldElement2 = a;
                for (int i = 1; i < this.f32018i; i++) {
                    eCFieldElement3 = eCFieldElement3.mo6561e();
                    eCFieldElement2 = eCFieldElement2.mo6561e().mo6551a(eCFieldElement3.mo6558c(a2));
                    eCFieldElement3 = eCFieldElement3.mo6551a(eCFieldElement);
                }
                if (!eCFieldElement3.mo6566j()) {
                    return null;
                }
            } while (eCFieldElement2.mo6561e().mo6551a(eCFieldElement2).mo6566j());
            return eCFieldElement2;
        }
    }

    public static class Fp extends AbstractFp {
        /* renamed from: i */
        BigInteger f32023i;
        /* renamed from: j */
        BigInteger f32024j;
        /* renamed from: k */
        org.spongycastle.math.ec.ECPoint.Fp f32025k;

        /* renamed from: a */
        public boolean mo6544a(int i) {
            if (i != 4) {
                switch (i) {
                    case 0:
                    case 1:
                    case 2:
                        break;
                    default:
                        return false;
                }
            }
            return true;
        }

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this(bigInteger, bigInteger2, bigInteger3, null, null);
        }

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
            super(bigInteger);
            this.f32023i = bigInteger;
            this.f32024j = org.spongycastle.math.ec.ECFieldElement.Fp.m41176a(bigInteger);
            this.f32025k = new org.spongycastle.math.ec.ECPoint.Fp(this, null, null);
            this.b = mo6541a(bigInteger2);
            this.c = mo6541a(bigInteger3);
            this.d = bigInteger4;
            this.e = bigInteger5;
            this.f = 4;
        }

        protected Fp(BigInteger bigInteger, BigInteger bigInteger2, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(bigInteger);
            this.f32023i = bigInteger;
            this.f32024j = bigInteger2;
            this.f32025k = new org.spongycastle.math.ec.ECPoint.Fp(this, null, null);
            this.b = eCFieldElement;
            this.c = eCFieldElement2;
            this.d = bigInteger3;
            this.e = bigInteger4;
            this.f = 4;
        }

        /* renamed from: c */
        protected ECCurve mo6545c() {
            return new Fp(this.f32023i, this.f32024j, this.b, this.c, this.d, this.e);
        }

        /* renamed from: a */
        public int mo6540a() {
            return this.f32023i.bitLength();
        }

        /* renamed from: a */
        public ECFieldElement mo6541a(BigInteger bigInteger) {
            return new org.spongycastle.math.ec.ECFieldElement.Fp(this.f32023i, this.f32024j, bigInteger);
        }

        /* renamed from: a */
        protected ECPoint mo6542a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            return new org.spongycastle.math.ec.ECPoint.Fp(this, eCFieldElement, eCFieldElement2, z);
        }

        /* renamed from: a */
        protected ECPoint mo6543a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            return new org.spongycastle.math.ec.ECPoint.Fp(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
        }

        /* renamed from: a */
        public ECPoint mo6548a(ECPoint eCPoint) {
            if (!(this == eCPoint.m28406d() || m28387k() != 2 || eCPoint.m28419q())) {
                switch (eCPoint.m28406d().m28387k()) {
                    case 2:
                    case 3:
                    case 4:
                        return new org.spongycastle.math.ec.ECPoint.Fp(this, mo6541a(eCPoint.f23094c.mo6549a()), mo6541a(eCPoint.f23095d.mo6549a()), new ECFieldElement[]{mo6541a(eCPoint.f23096e[0].mo6549a())}, eCPoint.f23097f);
                    default:
                        break;
                }
            }
            return super.mo6548a(eCPoint);
        }

        /* renamed from: e */
        public ECPoint mo6547e() {
            return this.f32025k;
        }
    }

    /* renamed from: a */
    public abstract int mo6540a();

    /* renamed from: a */
    public abstract ECFieldElement mo6541a(BigInteger bigInteger);

    /* renamed from: a */
    protected abstract ECPoint mo5903a(int i, BigInteger bigInteger);

    /* renamed from: a */
    protected abstract ECPoint mo6542a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z);

    /* renamed from: a */
    protected abstract ECPoint mo6543a(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z);

    /* renamed from: a */
    public boolean mo6544a(int i) {
        return i == 0;
    }

    /* renamed from: c */
    protected abstract ECCurve mo6545c();

    /* renamed from: e */
    public abstract ECPoint mo6547e();

    protected ECCurve(FiniteField finiteField) {
        this.f23084a = finiteField;
    }

    /* renamed from: b */
    public synchronized Config m28375b() {
        return new Config(this, this.f23089f, this.f23090g, this.f23091h);
    }

    /* renamed from: a */
    public ECPoint m28362a(BigInteger bigInteger, BigInteger bigInteger2) {
        bigInteger = m28376b(bigInteger, bigInteger2);
        if (bigInteger.m28420r() != null) {
            return bigInteger;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }

    /* renamed from: a */
    public ECPoint m28363a(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
        bigInteger = mo5902b(bigInteger, bigInteger2, z);
        if (bigInteger.m28420r() != null) {
            return bigInteger;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }

    /* renamed from: b */
    public ECPoint m28376b(BigInteger bigInteger, BigInteger bigInteger2) {
        return mo5902b(bigInteger, bigInteger2, false);
    }

    /* renamed from: b */
    public ECPoint mo5902b(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
        return mo6542a(mo6541a(bigInteger), mo6541a(bigInteger2), z);
    }

    /* renamed from: d */
    protected ECMultiplier mo6546d() {
        if (this.f23090g instanceof GLVEndomorphism) {
            return new GLVMultiplier(this, (GLVEndomorphism) this.f23090g);
        }
        return new WNafL2RMultiplier();
    }

    /* renamed from: a */
    public PreCompInfo m28368a(ECPoint eCPoint, String str) {
        m28378b(eCPoint);
        synchronized (eCPoint) {
            Hashtable hashtable = eCPoint.f23098g;
            if (hashtable == null) {
                str = null;
            } else {
                str = (PreCompInfo) hashtable.get(str);
            }
        }
        return str;
    }

    /* renamed from: a */
    public void m28369a(ECPoint eCPoint, String str, PreCompInfo preCompInfo) {
        m28378b(eCPoint);
        synchronized (eCPoint) {
            Hashtable hashtable = eCPoint.f23098g;
            if (hashtable == null) {
                hashtable = new Hashtable(4);
                eCPoint.f23098g = hashtable;
            }
            hashtable.put(str, preCompInfo);
        }
    }

    /* renamed from: a */
    public ECPoint mo6548a(ECPoint eCPoint) {
        if (this == eCPoint.m28406d()) {
            return eCPoint;
        }
        if (eCPoint.m28419q()) {
            return mo6547e();
        }
        eCPoint = eCPoint.m28418p();
        return m28363a(eCPoint.m28411i().mo6549a(), eCPoint.mo6571j().mo6549a(), eCPoint.f23097f);
    }

    /* renamed from: a */
    public void m28370a(ECPoint[] eCPointArr) {
        m28372a(eCPointArr, 0, eCPointArr.length, null);
    }

    /* renamed from: a */
    public void m28372a(ECPoint[] eCPointArr, int i, int i2, ECFieldElement eCFieldElement) {
        m28371a(eCPointArr, i, i2);
        int k = m28387k();
        if (k != 0 && k != 5) {
            ECFieldElement[] eCFieldElementArr = new ECFieldElement[i2];
            int[] iArr = new int[i2];
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i + i5;
                ECPoint eCPoint = eCPointArr[i6];
                if (!(eCPoint == null || (eCFieldElement == null && eCPoint.m28417o()))) {
                    eCFieldElementArr[i4] = eCPoint.mo6574a(0);
                    int i7 = i4 + 1;
                    iArr[i4] = i6;
                    i4 = i7;
                }
            }
            if (i4 != 0) {
                ECAlgorithms.m28350a(eCFieldElementArr, 0, i4, eCFieldElement);
                while (i3 < i4) {
                    i = iArr[i3];
                    eCPointArr[i] = eCPointArr[i].m28394a(eCFieldElementArr[i3]);
                    i3++;
                }
            }
        } else if (eCFieldElement != null) {
            throw new IllegalArgumentException("'iso' not valid for affine coordinates");
        }
    }

    /* renamed from: f */
    public FiniteField m28382f() {
        return this.f23084a;
    }

    /* renamed from: g */
    public ECFieldElement m28383g() {
        return this.f23085b;
    }

    /* renamed from: h */
    public ECFieldElement m28384h() {
        return this.f23086c;
    }

    /* renamed from: i */
    public BigInteger m28385i() {
        return this.f23087d;
    }

    /* renamed from: j */
    public BigInteger m28386j() {
        return this.f23088e;
    }

    /* renamed from: k */
    public int m28387k() {
        return this.f23089f;
    }

    /* renamed from: l */
    public ECEndomorphism m28388l() {
        return this.f23090g;
    }

    /* renamed from: m */
    public synchronized ECMultiplier m28389m() {
        if (this.f23091h == null) {
            this.f23091h = mo6546d();
        }
        return this.f23091h;
    }

    /* renamed from: a */
    public ECPoint m28367a(byte[] bArr) {
        int a = (mo6540a() + 7) / 8;
        boolean z = false;
        byte b = bArr[0];
        switch (b) {
            case (byte) 0:
                if (bArr.length == 1) {
                    bArr = mo6547e();
                    break;
                }
                throw new IllegalArgumentException("Incorrect length for infinity encoding");
            case (byte) 2:
            case (byte) 3:
                if (bArr.length == a + 1) {
                    bArr = mo5903a(b & 1, BigIntegers.m29387a(bArr, 1, a));
                    if (bArr.m28396a()) {
                        break;
                    }
                    throw new IllegalArgumentException("Invalid point");
                }
                throw new IllegalArgumentException("Incorrect length for compressed encoding");
            case (byte) 4:
                if (bArr.length == (a * 2) + 1) {
                    bArr = m28362a(BigIntegers.m29387a(bArr, 1, a), BigIntegers.m29387a(bArr, a + 1, a));
                    break;
                }
                throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
            case (byte) 6:
            case (byte) 7:
                if (bArr.length == (a * 2) + 1) {
                    BigInteger a2 = BigIntegers.m29387a(bArr, 1, a);
                    BigInteger a3 = BigIntegers.m29387a(bArr, a + 1, a);
                    boolean testBit = a3.testBit(0);
                    if (b == (byte) 7) {
                        z = true;
                    }
                    if (testBit == z) {
                        bArr = m28362a(a2, a3);
                        break;
                    }
                    throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                }
                throw new IllegalArgumentException("Incorrect length for hybrid encoding");
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid point encoding 0x");
                stringBuilder.append(Integer.toString(b, 16));
                throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (b != (byte) 0) {
            if (bArr.m28419q()) {
                throw new IllegalArgumentException("Invalid infinity encoding");
            }
        }
        return bArr;
    }

    /* renamed from: b */
    protected void m28378b(ECPoint eCPoint) {
        if (eCPoint == null || this != eCPoint.m28406d()) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
    }

    /* renamed from: a */
    protected void m28371a(ECPoint[] eCPointArr, int i, int i2) {
        if (eCPointArr == null) {
            throw new IllegalArgumentException("'points' cannot be null");
        } else if (i < 0 || i2 < 0 || i > eCPointArr.length - i2) {
            throw new IllegalArgumentException("invalid range specified for 'points'");
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                ECPoint eCPoint = eCPointArr[i + i3];
                if (eCPoint != null) {
                    if (this != eCPoint.m28406d()) {
                        throw new IllegalArgumentException("'points' entries must be null or on this curve");
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean m28374a(ECCurve eCCurve) {
        if (this != eCCurve) {
            if (eCCurve == null || !m28382f().equals(eCCurve.m28382f()) || !m28383g().mo6549a().equals(eCCurve.m28383g().mo6549a()) || m28384h().mo6549a().equals(eCCurve.m28384h().mo6549a()) == null) {
                return null;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof ECCurve) || m28374a((ECCurve) obj) == null) {
                return null;
            }
        }
        return true;
    }

    public int hashCode() {
        return (m28382f().hashCode() ^ Integers.m29395a(m28383g().mo6549a().hashCode(), 8)) ^ Integers.m29395a(m28384h().mo6549a().hashCode(), 16);
    }
}
