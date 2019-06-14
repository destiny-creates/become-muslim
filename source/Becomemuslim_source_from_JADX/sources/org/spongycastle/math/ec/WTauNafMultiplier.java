package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECPoint.AbstractF2m;

public class WTauNafMultiplier extends AbstractECMultiplier {
    /* renamed from: b */
    protected ECPoint mo6539b(ECPoint eCPoint, BigInteger bigInteger) {
        if (eCPoint instanceof AbstractF2m) {
            AbstractF2m abstractF2m = (AbstractF2m) eCPoint;
            ECCurve.AbstractF2m abstractF2m2 = (ECCurve.AbstractF2m) abstractF2m.m28406d();
            int a = abstractF2m2.mo6540a();
            byte byteValue = abstractF2m2.m28383g().mo6549a().byteValue();
            byte a2 = Tnaf.m28479a((int) byteValue);
            byte b = byteValue;
            return m41233a(abstractF2m, Tnaf.m28485a(bigInteger, a, b, abstractF2m2.m36271n(), a2, (byte) 10), abstractF2m2.m28368a((ECPoint) abstractF2m, "bc_wtnaf"), b, a2);
        }
        throw new IllegalArgumentException("Only ECPoint.AbstractF2m can be used in WTauNafMultiplier");
    }

    /* renamed from: a */
    private AbstractF2m m41233a(AbstractF2m abstractF2m, ZTauElement zTauElement, PreCompInfo preCompInfo, byte b, byte b2) {
        return m41234a(abstractF2m, Tnaf.m28487a(b2, zTauElement, (byte) 4, BigInteger.valueOf(16), Tnaf.m28481a(b2, (int) (byte) 4), b == (byte) 0 ? Tnaf.f23108a : Tnaf.f23110c), preCompInfo);
    }

    /* renamed from: a */
    private static AbstractF2m m41234a(AbstractF2m abstractF2m, byte[] bArr, PreCompInfo preCompInfo) {
        AbstractF2m[] abstractF2mArr;
        int i;
        AbstractF2m abstractF2m2;
        int i2;
        byte b;
        ECCurve.AbstractF2m abstractF2m3 = (ECCurve.AbstractF2m) abstractF2m.m28406d();
        byte byteValue = abstractF2m3.m28383g().mo6549a().byteValue();
        if (preCompInfo != null) {
            if (preCompInfo instanceof WTauNafPreCompInfo) {
                preCompInfo = ((WTauNafPreCompInfo) preCompInfo).m36313a();
                abstractF2mArr = new AbstractF2m[preCompInfo.length];
                for (i = 0; i < preCompInfo.length; i++) {
                    abstractF2mArr[i] = (AbstractF2m) preCompInfo[i].mo6572t();
                }
                abstractF2m2 = (AbstractF2m) abstractF2m.m28406d().mo6547e();
                i2 = null;
                for (i = bArr.length - 1; i >= 0; i--) {
                    i2++;
                    b = bArr[i];
                    if (b != (byte) 0) {
                        abstractF2m2 = (AbstractF2m) abstractF2m2.m36296c(i2).mo6568b(b <= (byte) 0 ? preCompInfo[b >>> 1] : abstractF2mArr[(-b) >>> 1]);
                        i2 = null;
                    }
                }
                return i2 <= null ? abstractF2m2.m36296c(i2) : abstractF2m2;
            }
        }
        preCompInfo = Tnaf.m28490a(abstractF2m, byteValue);
        PreCompInfo wTauNafPreCompInfo = new WTauNafPreCompInfo();
        wTauNafPreCompInfo.m36312a(preCompInfo);
        abstractF2m3.m28369a((ECPoint) abstractF2m, "bc_wtnaf", wTauNafPreCompInfo);
        abstractF2mArr = new AbstractF2m[preCompInfo.length];
        for (i = 0; i < preCompInfo.length; i++) {
            abstractF2mArr[i] = (AbstractF2m) preCompInfo[i].mo6572t();
        }
        abstractF2m2 = (AbstractF2m) abstractF2m.m28406d().mo6547e();
        i2 = null;
        for (i = bArr.length - 1; i >= 0; i--) {
            i2++;
            b = bArr[i];
            if (b != (byte) 0) {
                if (b <= (byte) 0) {
                }
                abstractF2m2 = (AbstractF2m) abstractF2m2.m36296c(i2).mo6568b(b <= (byte) 0 ? preCompInfo[b >>> 1] : abstractF2mArr[(-b) >>> 1]);
                i2 = null;
            }
        }
        if (i2 <= null) {
        }
    }
}
