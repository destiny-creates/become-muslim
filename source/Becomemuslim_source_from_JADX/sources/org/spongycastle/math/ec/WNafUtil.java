package org.spongycastle.math.ec;

import com.facebook.internal.NativeProtocol;
import java.math.BigInteger;

public abstract class WNafUtil {
    /* renamed from: a */
    private static final int[] f23115a = new int[]{13, 41, 121, 337, 897, 2305};
    /* renamed from: b */
    private static final byte[] f23116b = new byte[0];
    /* renamed from: c */
    private static final int[] f23117c = new int[0];
    /* renamed from: d */
    private static final ECPoint[] f23118d = new ECPoint[0];

    /* renamed from: a */
    public static int[] m28499a(BigInteger bigInteger) {
        if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        } else if (bigInteger.signum() == 0) {
            return f23117c;
        } else {
            BigInteger add = bigInteger.shiftLeft(1).add(bigInteger);
            int bitLength = add.bitLength();
            int[] iArr = new int[(bitLength >> 1)];
            add = add.xor(bigInteger);
            bitLength--;
            int i = 1;
            int i2 = 0;
            int i3 = 0;
            while (i < bitLength) {
                if (add.testBit(i)) {
                    int i4 = i2 + 1;
                    iArr[i2] = i3 | ((bigInteger.testBit(i) ? -1 : 1) << 16);
                    i++;
                    i2 = i4;
                    i3 = 1;
                } else {
                    i3++;
                }
                i++;
            }
            int i5 = i2 + 1;
            iArr[i2] = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST | i3;
            if (iArr.length > i5) {
                iArr = m28500a(iArr, i5);
            }
            return iArr;
        }
    }

    /* renamed from: a */
    public static int[] m28498a(int i, BigInteger bigInteger) {
        if (i == 2) {
            return m28499a(bigInteger);
        }
        if (i < 2 || i > 16) {
            throw new IllegalArgumentException("'width' must be in the range [2, 16]");
        } else if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        } else if (bigInteger.signum() == 0) {
            return f23117c;
        } else {
            int[] iArr = new int[((bigInteger.bitLength() / i) + 1)];
            int i2 = 1 << i;
            int i3 = i2 - 1;
            int i4 = i2 >>> 1;
            BigInteger bigInteger2 = bigInteger;
            bigInteger = null;
            boolean z = false;
            int i5 = 0;
            while (bigInteger <= bigInteger2.bitLength()) {
                if (bigInteger2.testBit(bigInteger) == z) {
                    bigInteger++;
                } else {
                    bigInteger2 = bigInteger2.shiftRight(bigInteger);
                    int intValue = bigInteger2.intValue() & i3;
                    if (z) {
                        intValue++;
                    }
                    z = (intValue & i4) != 0;
                    if (z) {
                        intValue -= i2;
                    }
                    if (i5 > 0) {
                        bigInteger--;
                    }
                    int i6 = i5 + 1;
                    iArr[i5] = bigInteger | (intValue << 16);
                    bigInteger = i;
                    i5 = i6;
                }
            }
            if (iArr.length > i5) {
                iArr = m28500a(iArr, i5);
            }
            return iArr;
        }
    }

    /* renamed from: b */
    public static byte[] m28503b(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return f23116b;
        }
        BigInteger add = bigInteger.shiftLeft(1).add(bigInteger);
        int bitLength = add.bitLength() - 1;
        byte[] bArr = new byte[bitLength];
        add = add.xor(bigInteger);
        int i = 1;
        while (i < bitLength) {
            if (add.testBit(i)) {
                bArr[i - 1] = (byte) (bigInteger.testBit(i) ? -1 : 1);
                i++;
            }
            i++;
        }
        bArr[bitLength - 1] = (byte) 1;
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m28502b(int i, BigInteger bigInteger) {
        if (i == 2) {
            return m28503b(bigInteger);
        }
        if (i < 2 || i > 8) {
            throw new IllegalArgumentException("'width' must be in the range [2, 8]");
        } else if (bigInteger.signum() == 0) {
            return f23116b;
        } else {
            byte[] bArr = new byte[(bigInteger.bitLength() + 1)];
            int i2 = 1 << i;
            int i3 = i2 - 1;
            int i4 = i2 >>> 1;
            BigInteger bigInteger2 = bigInteger;
            bigInteger = null;
            boolean z = false;
            int i5 = 0;
            while (bigInteger <= bigInteger2.bitLength()) {
                if (bigInteger2.testBit(bigInteger) == z) {
                    bigInteger++;
                } else {
                    bigInteger2 = bigInteger2.shiftRight(bigInteger);
                    int intValue = bigInteger2.intValue() & i3;
                    if (z) {
                        intValue++;
                    }
                    z = (intValue & i4) != 0;
                    if (z) {
                        intValue -= i2;
                    }
                    if (i5 > 0) {
                        bigInteger--;
                    }
                    i5 += bigInteger;
                    bigInteger = i5 + 1;
                    bArr[i5] = (byte) intValue;
                    i5 = bigInteger;
                    bigInteger = i;
                }
            }
            if (bArr.length > i5) {
                bArr = m28497a(bArr, i5);
            }
            return bArr;
        }
    }

    /* renamed from: c */
    public static int m28504c(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return null;
        }
        return bigInteger.shiftLeft(1).add(bigInteger).xor(bigInteger).bitCount();
    }

    /* renamed from: a */
    public static WNafPreCompInfo m28494a(ECPoint eCPoint) {
        return m28496a(eCPoint.m28406d().m28368a(eCPoint, "bc_wnaf"));
    }

    /* renamed from: a */
    public static WNafPreCompInfo m28496a(PreCompInfo preCompInfo) {
        if (preCompInfo == null || !(preCompInfo instanceof WNafPreCompInfo)) {
            return new WNafPreCompInfo();
        }
        return (WNafPreCompInfo) preCompInfo;
    }

    /* renamed from: a */
    public static int m28491a(int i) {
        return m28492a(i, f23115a);
    }

    /* renamed from: a */
    public static int m28492a(int i, int[] iArr) {
        int i2 = 0;
        while (i2 < iArr.length) {
            if (i < iArr[i2]) {
                break;
            }
            i2++;
        }
        return i2 + 2;
    }

    /* renamed from: a */
    public static ECPoint m28493a(ECPoint eCPoint, int i, boolean z, ECPointMap eCPointMap) {
        ECCurve d = eCPoint.m28406d();
        i = m28495a(eCPoint, i, z);
        eCPoint = eCPointMap.mo5908a(eCPoint);
        PreCompInfo a = m28496a(d.m28368a(eCPoint, "bc_wnaf"));
        ECPoint c = i.m36311c();
        if (c != null) {
            a.m36306a(eCPointMap.mo5908a(c));
        }
        i = i.m36308a();
        ECPoint[] eCPointArr = new ECPoint[i.length];
        for (int i2 = 0; i2 < i.length; i2++) {
            eCPointArr[i2] = eCPointMap.mo5908a(i[i2]);
        }
        a.m36307a(eCPointArr);
        if (z) {
            i = new ECPoint[eCPointArr.length];
            for (boolean z2 = false; z2 < i.length; z2++) {
                i[z2] = eCPointArr[z2].mo6572t();
            }
            a.m36309b(i);
        }
        d.m28369a(eCPoint, "bc_wnaf", a);
        return eCPoint;
    }

    /* renamed from: a */
    public static WNafPreCompInfo m28495a(ECPoint eCPoint, int i, boolean z) {
        int i2;
        ECCurve d = eCPoint.m28406d();
        PreCompInfo a = m28496a(d.m28368a(eCPoint, "bc_wnaf"));
        int i3 = 0;
        i = 1 << Math.max(0, i - 2);
        ECPoint[] a2 = a.m36308a();
        if (a2 == null) {
            a2 = f23118d;
            i2 = 0;
        } else {
            i2 = a2.length;
        }
        if (i2 < i) {
            a2 = m28501a(a2, i);
            if (i == 1) {
                a2[0] = eCPoint.m28418p();
            } else {
                int i4;
                if (i2 == 0) {
                    a2[0] = eCPoint;
                    i4 = 1;
                } else {
                    i4 = i2;
                }
                ECFieldElement eCFieldElement = null;
                if (i == 2) {
                    a2[1] = eCPoint.mo6576v();
                } else {
                    ECPoint c = a.m36311c();
                    ECPoint eCPoint2 = a2[i4 - 1];
                    if (c == null) {
                        c = a2[0].mo6573u();
                        a.m36306a(c);
                        if (ECAlgorithms.m28354b(d) && d.mo6540a() >= 64) {
                            switch (d.m28387k()) {
                                case 2:
                                case 3:
                                case 4:
                                    eCFieldElement = c.mo6574a(0);
                                    c = d.m28376b(c.m28411i().mo6549a(), c.mo6571j().mo6549a());
                                    ECFieldElement e = eCFieldElement.mo6561e();
                                    eCPoint2 = eCPoint2.mo5904b(e).mo5906c(e.mo6558c(eCFieldElement));
                                    if (i2 == 0) {
                                        a2[0] = eCPoint2;
                                        break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    while (i4 < i) {
                        int i5 = i4 + 1;
                        eCPoint2 = eCPoint2.mo6568b(c);
                        a2[i4] = eCPoint2;
                        i4 = i5;
                    }
                }
                d.m28372a(a2, i2, i - i2, eCFieldElement);
            }
        }
        a.m36307a(a2);
        if (z) {
            z = a.m36310b();
            if (z) {
                i3 = z.length;
                if (i3 < i) {
                    z = m28501a((ECPoint[]) z, i);
                }
            } else {
                z = new ECPoint[i];
            }
            while (i3 < i) {
                z[i3] = a2[i3].mo6572t();
                i3++;
            }
            a.m36309b(z);
        }
        d.m28369a(eCPoint, "bc_wnaf", a);
        return a;
    }

    /* renamed from: a */
    private static byte[] m28497a(byte[] bArr, int i) {
        i = new byte[i];
        System.arraycopy(bArr, 0, i, 0, i.length);
        return i;
    }

    /* renamed from: a */
    private static int[] m28500a(int[] iArr, int i) {
        i = new int[i];
        System.arraycopy(iArr, 0, i, 0, i.length);
        return i;
    }

    /* renamed from: a */
    private static ECPoint[] m28501a(ECPoint[] eCPointArr, int i) {
        i = new ECPoint[i];
        System.arraycopy(eCPointArr, 0, i, 0, eCPointArr.length);
        return i;
    }
}
