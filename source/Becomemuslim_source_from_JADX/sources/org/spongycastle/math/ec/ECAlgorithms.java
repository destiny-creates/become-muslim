package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve.AbstractF2m;
import org.spongycastle.math.ec.endo.ECEndomorphism;
import org.spongycastle.math.ec.endo.GLVEndomorphism;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.PolynomialExtensionField;

public class ECAlgorithms {
    /* renamed from: a */
    public static boolean m28351a(ECCurve eCCurve) {
        return m28352a(eCCurve.m28382f());
    }

    /* renamed from: a */
    public static boolean m28352a(FiniteField finiteField) {
        return finiteField.mo5912b() > 1 && finiteField.mo5911a().equals(ECConstants.f23077e) && (finiteField instanceof PolynomialExtensionField) != null;
    }

    /* renamed from: b */
    public static boolean m28354b(ECCurve eCCurve) {
        return m28355b(eCCurve.m28382f());
    }

    /* renamed from: b */
    public static boolean m28355b(FiniteField finiteField) {
        return finiteField.mo5912b() == 1;
    }

    /* renamed from: a */
    public static ECPoint m28343a(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        ECCurve d = eCPoint.m28406d();
        eCPoint2 = m28340a(d, eCPoint2);
        if ((d instanceof AbstractF2m) && ((AbstractF2m) d).mo6577o()) {
            return m28341a(eCPoint.m28393a(bigInteger).mo6568b(eCPoint2.m28393a(bigInteger2)));
        }
        ECEndomorphism l = d.m28388l();
        if (!(l instanceof GLVEndomorphism)) {
            return m28341a(m28353b(eCPoint, bigInteger, eCPoint2, bigInteger2));
        }
        return m28341a(m28347a(new ECPoint[]{eCPoint, eCPoint2}, new BigInteger[]{bigInteger, bigInteger2}, (GLVEndomorphism) l));
    }

    /* renamed from: a */
    public static ECPoint m28340a(ECCurve eCCurve, ECPoint eCPoint) {
        if (eCCurve.m28374a(eCPoint.m28406d())) {
            return eCCurve.mo6548a(eCPoint);
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    /* renamed from: a */
    public static void m28350a(ECFieldElement[] eCFieldElementArr, int i, int i2, ECFieldElement eCFieldElement) {
        ECFieldElement[] eCFieldElementArr2 = new ECFieldElement[i2];
        int i3 = 0;
        eCFieldElementArr2[0] = eCFieldElementArr[i];
        while (true) {
            i3++;
            if (i3 >= i2) {
                break;
            }
            eCFieldElementArr2[i3] = eCFieldElementArr2[i3 - 1].mo6558c(eCFieldElementArr[i + i3]);
        }
        i3--;
        if (eCFieldElement != null) {
            eCFieldElementArr2[i3] = eCFieldElementArr2[i3].mo6558c(eCFieldElement);
        }
        i2 = eCFieldElementArr2[i3].mo6562f();
        while (i3 > 0) {
            eCFieldElement = i3 - 1;
            i3 += i;
            ECFieldElement eCFieldElement2 = eCFieldElementArr[i3];
            eCFieldElementArr[i3] = eCFieldElementArr2[eCFieldElement].mo6558c(i2);
            i2 = i2.mo6558c(eCFieldElement2);
            i3 = eCFieldElement;
        }
        eCFieldElementArr[i] = i2;
    }

    /* renamed from: a */
    public static ECPoint m28342a(ECPoint eCPoint, BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        ECPoint e = eCPoint.m28406d().mo6547e();
        int bitLength = abs.bitLength();
        if (bitLength > 0) {
            if (abs.testBit(0)) {
                e = eCPoint;
            }
            for (int i = 1; i < bitLength; i++) {
                eCPoint = eCPoint.mo6573u();
                if (abs.testBit(i)) {
                    e = e.mo6568b(eCPoint);
                }
            }
        }
        return bigInteger.signum() < null ? e.mo6572t() : e;
    }

    /* renamed from: a */
    public static ECPoint m28341a(ECPoint eCPoint) {
        if (eCPoint.m28420r()) {
            return eCPoint;
        }
        throw new IllegalArgumentException("Invalid point");
    }

    /* renamed from: b */
    static ECPoint m28353b(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        Object obj = null;
        Object obj2 = bigInteger.signum() < 0 ? 1 : null;
        if (bigInteger2.signum() < 0) {
            obj = 1;
        }
        bigInteger = bigInteger.abs();
        bigInteger2 = bigInteger2.abs();
        int max = Math.max(2, Math.min(16, WNafUtil.m28491a(bigInteger.bitLength())));
        int max2 = Math.max(2, Math.min(16, WNafUtil.m28491a(bigInteger2.bitLength())));
        eCPoint = WNafUtil.m28495a(eCPoint, max, true);
        eCPoint2 = WNafUtil.m28495a(eCPoint2, max2, true);
        return m28348a(obj2 != null ? eCPoint.m36310b() : eCPoint.m36308a(), obj2 != null ? eCPoint.m36308a() : eCPoint.m36310b(), WNafUtil.m28502b(max, bigInteger), obj != null ? eCPoint2.m36310b() : eCPoint2.m36308a(), obj != null ? eCPoint2.m36308a() : eCPoint2.m36310b(), WNafUtil.m28502b(max2, bigInteger2));
    }

    /* renamed from: a */
    static ECPoint m28344a(ECPoint eCPoint, BigInteger bigInteger, ECPointMap eCPointMap, BigInteger bigInteger2) {
        Object obj = null;
        Object obj2 = bigInteger.signum() < 0 ? 1 : null;
        if (bigInteger2.signum() < 0) {
            obj = 1;
        }
        bigInteger = bigInteger.abs();
        bigInteger2 = bigInteger2.abs();
        int max = Math.max(2, Math.min(16, WNafUtil.m28491a(Math.max(bigInteger.bitLength(), bigInteger2.bitLength()))));
        ECPoint a = WNafUtil.m28493a(eCPoint, max, true, eCPointMap);
        eCPoint = WNafUtil.m28494a(eCPoint);
        eCPointMap = WNafUtil.m28494a(a);
        return m28348a(obj2 != null ? eCPoint.m36310b() : eCPoint.m36308a(), obj2 != null ? eCPoint.m36308a() : eCPoint.m36310b(), WNafUtil.m28502b(max, bigInteger), obj != null ? eCPointMap.m36310b() : eCPointMap.m36308a(), obj != null ? eCPointMap.m36308a() : eCPointMap.m36310b(), WNafUtil.m28502b(max, bigInteger2));
    }

    /* renamed from: a */
    private static ECPoint m28348a(ECPoint[] eCPointArr, ECPoint[] eCPointArr2, byte[] bArr, ECPoint[] eCPointArr3, ECPoint[] eCPointArr4, byte[] bArr2) {
        int max = Math.max(bArr.length, bArr2.length);
        ECPoint e = eCPointArr[0].m28406d().mo6547e();
        max--;
        ECPoint eCPoint = e;
        int i = 0;
        while (max >= 0) {
            int i2 = max < bArr.length ? bArr[max] : 0;
            int i3 = max < bArr2.length ? bArr2[max] : 0;
            if ((i2 | i3) == 0) {
                i++;
            } else {
                ECPoint b;
                if (i2 != 0) {
                    b = e.mo6568b((i2 < 0 ? eCPointArr2 : eCPointArr)[Math.abs(i2) >>> 1]);
                } else {
                    b = e;
                }
                if (i3 != 0) {
                    b = b.mo6568b((i3 < 0 ? eCPointArr4 : eCPointArr3)[Math.abs(i3) >>> 1]);
                }
                if (i > 0) {
                    eCPoint = eCPoint.mo6575b(i);
                    i = 0;
                }
                eCPoint = eCPoint.mo6569c(b);
            }
            max--;
        }
        return i > 0 ? eCPoint.mo6575b(i) : eCPoint;
    }

    /* renamed from: a */
    static ECPoint m28346a(ECPoint[] eCPointArr, BigInteger[] bigIntegerArr) {
        int length = eCPointArr.length;
        boolean[] zArr = new boolean[length];
        WNafPreCompInfo[] wNafPreCompInfoArr = new WNafPreCompInfo[length];
        byte[][] bArr = new byte[length][];
        for (int i = 0; i < length; i++) {
            BigInteger bigInteger = bigIntegerArr[i];
            zArr[i] = bigInteger.signum() < 0;
            bigInteger = bigInteger.abs();
            int max = Math.max(2, Math.min(16, WNafUtil.m28491a(bigInteger.bitLength())));
            wNafPreCompInfoArr[i] = WNafUtil.m28495a(eCPointArr[i], max, true);
            bArr[i] = WNafUtil.m28502b(max, bigInteger);
        }
        return m28349a(zArr, wNafPreCompInfoArr, bArr);
    }

    /* renamed from: a */
    static ECPoint m28347a(ECPoint[] eCPointArr, BigInteger[] bigIntegerArr, GLVEndomorphism gLVEndomorphism) {
        int i = 0;
        BigInteger i2 = eCPointArr[0].m28406d().m28385i();
        int length = eCPointArr.length;
        int i3 = length << 1;
        BigInteger[] bigIntegerArr2 = new BigInteger[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            BigInteger[] a = gLVEndomorphism.mo6579a(bigIntegerArr[i5].mod(i2));
            int i6 = i4 + 1;
            bigIntegerArr2[i4] = a[0];
            i4 = i6 + 1;
            bigIntegerArr2[i6] = a[1];
        }
        ECPointMap a2 = gLVEndomorphism.mo6578a();
        if (gLVEndomorphism.mo6580b() != null) {
            return m28345a(eCPointArr, a2, bigIntegerArr2);
        }
        ECPoint[] eCPointArr2 = new ECPoint[i3];
        int i7 = 0;
        while (i < length) {
            ECPoint eCPoint = eCPointArr[i];
            ECPoint a3 = a2.mo5908a(eCPoint);
            i4 = i7 + 1;
            eCPointArr2[i7] = eCPoint;
            i7 = i4 + 1;
            eCPointArr2[i4] = a3;
            i++;
        }
        return m28346a(eCPointArr2, bigIntegerArr2);
    }

    /* renamed from: a */
    static ECPoint m28345a(ECPoint[] eCPointArr, ECPointMap eCPointMap, BigInteger[] bigIntegerArr) {
        ECPoint[] eCPointArr2 = eCPointArr;
        int length = eCPointArr2.length;
        int i = length << 1;
        boolean[] zArr = new boolean[i];
        WNafPreCompInfo[] wNafPreCompInfoArr = new WNafPreCompInfo[i];
        byte[][] bArr = new byte[i][];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 << 1;
            int i4 = i3 + 1;
            BigInteger bigInteger = bigIntegerArr[i3];
            zArr[i3] = bigInteger.signum() < 0;
            bigInteger = bigInteger.abs();
            BigInteger bigInteger2 = bigIntegerArr[i4];
            zArr[i4] = bigInteger2.signum() < 0;
            bigInteger2 = bigInteger2.abs();
            int max = Math.max(2, Math.min(16, WNafUtil.m28491a(Math.max(bigInteger.bitLength(), bigInteger2.bitLength()))));
            ECPoint eCPoint = eCPointArr2[i2];
            ECPoint a = WNafUtil.m28493a(eCPoint, max, true, eCPointMap);
            wNafPreCompInfoArr[i3] = WNafUtil.m28494a(eCPoint);
            wNafPreCompInfoArr[i4] = WNafUtil.m28494a(a);
            bArr[i3] = WNafUtil.m28502b(max, bigInteger);
            bArr[i4] = WNafUtil.m28502b(max, bigInteger2);
        }
        return m28349a(zArr, wNafPreCompInfoArr, bArr);
    }

    /* renamed from: a */
    private static ECPoint m28349a(boolean[] zArr, WNafPreCompInfo[] wNafPreCompInfoArr, byte[][] bArr) {
        int i = 0;
        for (byte[] length : bArr) {
            i = Math.max(i, length.length);
        }
        ECPoint e = wNafPreCompInfoArr[0].m36308a()[0].m28406d().mo6547e();
        i--;
        ECPoint eCPoint = e;
        int i2 = 0;
        while (i >= 0) {
            ECPoint eCPoint2 = e;
            for (int i3 = 0; i3 < r0; i3++) {
                byte[] bArr2 = bArr[i3];
                int i4 = i < bArr2.length ? bArr2[i] : 0;
                if (i4 != 0) {
                    int abs = Math.abs(i4);
                    WNafPreCompInfo wNafPreCompInfo = wNafPreCompInfoArr[i3];
                    eCPoint2 = eCPoint2.mo6568b(((i4 < 0) == zArr[i3] ? wNafPreCompInfo.m36308a() : wNafPreCompInfo.m36310b())[abs >>> 1]);
                }
            }
            if (eCPoint2 == e) {
                i2++;
            } else {
                if (i2 > 0) {
                    eCPoint = eCPoint.mo6575b(i2);
                    i2 = 0;
                }
                eCPoint = eCPoint.mo6569c(eCPoint2);
            }
            i--;
        }
        return i2 > 0 ? eCPoint.mo6575b(i2) : eCPoint;
    }
}
