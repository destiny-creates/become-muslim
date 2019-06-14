package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve.AbstractF2m;

class Tnaf {
    /* renamed from: a */
    public static final ZTauElement[] f23108a = new ZTauElement[]{null, new ZTauElement(ECConstants.f23076d, ECConstants.f23075c), null, new ZTauElement(f23114g, f23112e), null, new ZTauElement(f23112e, f23112e), null, new ZTauElement(ECConstants.f23076d, f23112e), null};
    /* renamed from: b */
    public static final byte[][] f23109b;
    /* renamed from: c */
    public static final ZTauElement[] f23110c = new ZTauElement[]{null, new ZTauElement(ECConstants.f23076d, ECConstants.f23075c), null, new ZTauElement(f23114g, ECConstants.f23076d), null, new ZTauElement(f23112e, ECConstants.f23076d), null, new ZTauElement(ECConstants.f23076d, ECConstants.f23076d), null};
    /* renamed from: d */
    public static final byte[][] f23111d;
    /* renamed from: e */
    private static final BigInteger f23112e = ECConstants.f23076d.negate();
    /* renamed from: f */
    private static final BigInteger f23113f = ECConstants.f23077e.negate();
    /* renamed from: g */
    private static final BigInteger f23114g = ECConstants.f23078f.negate();

    /* renamed from: a */
    public static byte m28479a(int i) {
        return (byte) (i == 0 ? -1 : 1);
    }

    Tnaf() {
    }

    static {
        r1 = new byte[8][];
        r1[1] = new byte[]{(byte) 1};
        r1[2] = null;
        r1[3] = new byte[]{(byte) -1, (byte) 0, (byte) 1};
        r1[4] = null;
        r1[5] = new byte[]{(byte) 1, (byte) 0, (byte) 1};
        r1[6] = null;
        r1[7] = new byte[]{(byte) -1, (byte) 0, (byte) 0, (byte) 1};
        f23109b = r1;
        r0 = new byte[8][];
        r0[1] = new byte[]{(byte) 1};
        r0[2] = null;
        r0[3] = new byte[]{(byte) -1, (byte) 0, (byte) 1};
        r0[4] = null;
        r0[5] = new byte[]{(byte) 1, (byte) 0, (byte) 1};
        r0[6] = null;
        r0[7] = new byte[]{(byte) -1, (byte) 0, (byte) 0, (byte) -1};
        f23111d = r0;
    }

    /* renamed from: a */
    public static BigInteger m28482a(byte b, ZTauElement zTauElement) {
        BigInteger multiply = zTauElement.f23119a.multiply(zTauElement.f23119a);
        BigInteger multiply2 = zTauElement.f23119a.multiply(zTauElement.f23120b);
        zTauElement = zTauElement.f23120b.multiply(zTauElement.f23120b).shiftLeft(1);
        if (b == (byte) 1) {
            return multiply.add(multiply2).add(zTauElement);
        }
        if (b == (byte) -1) {
            return multiply.subtract(multiply2).add(zTauElement);
        }
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    /* renamed from: a */
    public static ZTauElement m28486a(SimpleBigDecimal simpleBigDecimal, SimpleBigDecimal simpleBigDecimal2, byte b) {
        if (simpleBigDecimal2.m28478d() == simpleBigDecimal.m28478d()) {
            if (b != (byte) 1) {
                if (b != (byte) -1) {
                    throw new IllegalArgumentException("mu must be 1 or -1");
                }
            }
            BigInteger c = simpleBigDecimal.m28477c();
            BigInteger c2 = simpleBigDecimal2.m28477c();
            simpleBigDecimal = simpleBigDecimal.m28472a(c);
            simpleBigDecimal2 = simpleBigDecimal2.m28472a(c2);
            SimpleBigDecimal a = simpleBigDecimal.m28473a(simpleBigDecimal);
            if (b == (byte) 1) {
                a = a.m28473a(simpleBigDecimal2);
            } else {
                a = a.m28476b(simpleBigDecimal2);
            }
            SimpleBigDecimal a2 = simpleBigDecimal2.m28473a(simpleBigDecimal2).m28473a(simpleBigDecimal2);
            simpleBigDecimal2 = a2.m28473a(simpleBigDecimal2);
            if (b == (byte) 1) {
                a2 = simpleBigDecimal.m28476b(a2);
                simpleBigDecimal = simpleBigDecimal.m28473a(simpleBigDecimal2);
            } else {
                a2 = simpleBigDecimal.m28473a(a2);
                simpleBigDecimal = simpleBigDecimal.m28476b(simpleBigDecimal2);
            }
            int i = 0;
            if (a.m28474b(ECConstants.f23076d) >= null) {
                if (a2.m28474b(f23112e) >= null) {
                    simpleBigDecimal2 = null;
                    i = 1;
                    if (a.m28474b(f23112e) < 0) {
                        if (a2.m28474b(ECConstants.f23076d) >= null) {
                            simpleBigDecimal2 = (byte) (-b);
                        } else {
                            i = -1;
                        }
                    } else if (simpleBigDecimal.m28474b(f23113f) < null) {
                        simpleBigDecimal2 = (byte) (-b);
                    }
                    return new ZTauElement(c.add(BigInteger.valueOf((long) i)), c2.add(BigInteger.valueOf((long) simpleBigDecimal2)));
                }
            } else if (simpleBigDecimal.m28474b(ECConstants.f23077e) < null) {
                simpleBigDecimal2 = null;
                if (a.m28474b(f23112e) < 0) {
                    if (simpleBigDecimal.m28474b(f23113f) < null) {
                        simpleBigDecimal2 = (byte) (-b);
                    }
                } else if (a2.m28474b(ECConstants.f23076d) >= null) {
                    i = -1;
                } else {
                    simpleBigDecimal2 = (byte) (-b);
                }
                return new ZTauElement(c.add(BigInteger.valueOf((long) i)), c2.add(BigInteger.valueOf((long) simpleBigDecimal2)));
            }
            simpleBigDecimal2 = b;
            if (a.m28474b(f23112e) < 0) {
                if (a2.m28474b(ECConstants.f23076d) >= null) {
                    simpleBigDecimal2 = (byte) (-b);
                } else {
                    i = -1;
                }
            } else if (simpleBigDecimal.m28474b(f23113f) < null) {
                simpleBigDecimal2 = (byte) (-b);
            }
            return new ZTauElement(c.add(BigInteger.valueOf((long) i)), c2.add(BigInteger.valueOf((long) simpleBigDecimal2)));
        }
        throw new IllegalArgumentException("lambda0 and lambda1 do not have same scale");
    }

    /* renamed from: a */
    public static SimpleBigDecimal m28484a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte b, int i, int i2) {
        int i3 = ((i + 5) / 2) + i2;
        bigInteger = bigInteger2.multiply(bigInteger.shiftRight(((i - i3) - 2) + b));
        bigInteger = bigInteger.add(bigInteger3.multiply(bigInteger.shiftRight(i)));
        i3 -= i2;
        bigInteger2 = bigInteger.shiftRight(i3);
        if (bigInteger.testBit(i3 - 1) != null) {
            bigInteger2 = bigInteger2.add(ECConstants.f23076d);
        }
        return new SimpleBigDecimal(bigInteger2, i2);
    }

    /* renamed from: a */
    public static BigInteger[] m28488a(byte b, int i, boolean z) {
        BigInteger valueOf;
        if (b != (byte) 1) {
            if (b != (byte) -1) {
                throw new IllegalArgumentException("mu must be 1 or -1");
            }
        }
        if (z) {
            z = ECConstants.f23077e;
            valueOf = BigInteger.valueOf((long) b);
        } else {
            z = ECConstants.f23075c;
            valueOf = ECConstants.f23076d;
        }
        BigInteger bigInteger = valueOf;
        valueOf = z;
        z = true;
        while (z < i) {
            z++;
            BigInteger bigInteger2 = bigInteger;
            bigInteger = (b == (byte) 1 ? bigInteger : bigInteger.negate()).subtract(valueOf.shiftLeft(1));
            valueOf = bigInteger2;
        }
        return new BigInteger[]{valueOf, bigInteger};
    }

    /* renamed from: a */
    public static BigInteger m28481a(byte b, int i) {
        if (i != 4) {
            b = m28488a(b, i, false);
            i = ECConstants.f23075c.setBit(i);
            return ECConstants.f23077e.multiply(b[0]).multiply(b[1].modInverse(i)).mod(i);
        } else if (b == (byte) 1) {
            return BigInteger.valueOf((byte) 6);
        } else {
            return BigInteger.valueOf((byte) 10);
        }
    }

    /* renamed from: a */
    public static BigInteger[] m28489a(AbstractF2m abstractF2m) {
        if (abstractF2m.mo6577o()) {
            int a = abstractF2m.mo6540a();
            int intValue = abstractF2m.m28383g().mo6549a().intValue();
            byte a2 = m28479a(intValue);
            abstractF2m = m28480a(abstractF2m.m28386j());
            BigInteger[] a3 = m28488a(a2, (a + 3) - intValue, false);
            if (a2 == (byte) 1) {
                a3[0] = a3[0].negate();
                a3[1] = a3[1].negate();
            }
            BigInteger shiftRight = ECConstants.f23076d.add(a3[1]).shiftRight(abstractF2m);
            abstractF2m = ECConstants.f23076d.add(a3[0]).shiftRight(abstractF2m).negate();
            return new BigInteger[]{shiftRight, abstractF2m};
        }
        throw new IllegalArgumentException("si is defined for Koblitz curves only");
    }

    /* renamed from: a */
    protected static int m28480a(BigInteger bigInteger) {
        if (bigInteger != null) {
            if (bigInteger.equals(ECConstants.f23077e)) {
                return 1;
            }
            if (bigInteger.equals(ECConstants.f23079g) != null) {
                return 2;
            }
        }
        throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
    }

    /* renamed from: a */
    public static ZTauElement m28485a(BigInteger bigInteger, int i, byte b, BigInteger[] bigIntegerArr, byte b2, byte b3) {
        BigInteger add;
        byte b4 = b2;
        if (b4 == (byte) 1) {
            add = bigIntegerArr[0].add(bigIntegerArr[1]);
        } else {
            add = bigIntegerArr[0].subtract(bigIntegerArr[1]);
        }
        BigInteger bigInteger2 = add;
        int i2 = i;
        BigInteger bigInteger3 = bigInteger;
        BigInteger bigInteger4 = m28488a(b4, i, true)[1];
        byte b5 = b;
        int i3 = i;
        int i4 = b3;
        ZTauElement a = m28486a(m28484a(bigInteger3, bigIntegerArr[0], bigInteger4, b5, i3, i4), m28484a(bigInteger3, bigIntegerArr[1], bigInteger4, b5, i3, i4), b4);
        return new ZTauElement(bigInteger.subtract(bigInteger2.multiply(a.f23119a)).subtract(BigInteger.valueOf(2).multiply(bigIntegerArr[1]).multiply(a.f23120b)), bigIntegerArr[1].multiply(a.f23119a).subtract(bigIntegerArr[0].multiply(a.f23120b)));
    }

    /* renamed from: a */
    public static ECPoint.AbstractF2m m28483a(ECPoint.AbstractF2m abstractF2m, byte[] bArr) {
        ECPoint eCPoint = (ECPoint.AbstractF2m) abstractF2m.mo6572t();
        ECPoint.AbstractF2m abstractF2m2 = (ECPoint.AbstractF2m) abstractF2m.m28406d().mo6547e();
        int i = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            i++;
            byte b = bArr[length];
            if (b != (byte) 0) {
                abstractF2m2 = (ECPoint.AbstractF2m) abstractF2m2.m36296c(i).mo6568b(b > (byte) 0 ? abstractF2m : eCPoint);
                i = 0;
            }
        }
        return i > 0 ? abstractF2m2.m36296c(i) : abstractF2m2;
    }

    /* renamed from: a */
    public static byte[] m28487a(byte b, ZTauElement zTauElement, byte b2, BigInteger bigInteger, BigInteger bigInteger2, ZTauElement[] zTauElementArr) {
        if (b != (byte) 1) {
            if (b != (byte) -1) {
                throw new IllegalArgumentException("mu must be 1 or -1");
            }
        }
        int bitLength = m28482a(b, zTauElement).bitLength();
        b2 = new byte[(bitLength > 30 ? (bitLength + 4) + b2 : b2 + 34)];
        BigInteger shiftRight = bigInteger.shiftRight(1);
        BigInteger bigInteger3 = zTauElement.f23119a;
        zTauElement = zTauElement.f23120b;
        int i = 0;
        while (true) {
            if (bigInteger3.equals(ECConstants.f23075c)) {
                if (zTauElement.equals(ECConstants.f23075c)) {
                    return b2;
                }
            }
            if (bigInteger3.testBit(0)) {
                byte intValue;
                int i2;
                Object obj;
                BigInteger mod = bigInteger3.add(zTauElement.multiply(bigInteger2)).mod(bigInteger);
                if (mod.compareTo(shiftRight) >= 0) {
                    intValue = (byte) mod.subtract(bigInteger).intValue();
                } else {
                    intValue = (byte) mod.intValue();
                }
                b2[i] = intValue;
                if (intValue < (byte) 0) {
                    i2 = (byte) (-intValue);
                    obj = null;
                } else {
                    i2 = intValue;
                    obj = 1;
                }
                if (obj != null) {
                    bigInteger3 = bigInteger3.subtract(zTauElementArr[i2].f23119a);
                    zTauElement = zTauElement.subtract(zTauElementArr[i2].f23120b);
                } else {
                    bigInteger3 = bigInteger3.add(zTauElementArr[i2].f23119a);
                    zTauElement = zTauElement.add(zTauElementArr[i2].f23120b);
                }
            } else {
                b2[i] = null;
            }
            if (b == (byte) 1) {
                zTauElement = zTauElement.add(bigInteger3.shiftRight(1));
            } else {
                zTauElement = zTauElement.subtract(bigInteger3.shiftRight(1));
            }
            i++;
            BigInteger negate = bigInteger3.shiftRight(1).negate();
            Object obj2 = zTauElement;
            Object obj3 = negate;
        }
    }

    /* renamed from: a */
    public static ECPoint.AbstractF2m[] m28490a(ECPoint.AbstractF2m abstractF2m, byte b) {
        b = b == (byte) 0 ? f23109b : f23111d;
        ECPoint[] eCPointArr = new ECPoint.AbstractF2m[((b.length + 1) >>> 1)];
        eCPointArr[0] = abstractF2m;
        int length = b.length;
        for (int i = 3; i < length; i += 2) {
            eCPointArr[i >>> 1] = m28483a(abstractF2m, b[i]);
        }
        abstractF2m.m28406d().m28370a(eCPointArr);
        return eCPointArr;
    }
}
