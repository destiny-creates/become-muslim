package org.spongycastle.math.ec;

import com.facebook.soloader.MinElf;
import java.math.BigInteger;

public class MixedNafR2LMultiplier extends AbstractECMultiplier {
    /* renamed from: a */
    protected int f32035a;
    /* renamed from: b */
    protected int f32036b;

    public MixedNafR2LMultiplier() {
        this(2, 4);
    }

    public MixedNafR2LMultiplier(int i, int i2) {
        this.f32035a = i;
        this.f32036b = i2;
    }

    /* renamed from: b */
    protected ECPoint mo6539b(ECPoint eCPoint, BigInteger bigInteger) {
        ECCurve d = eCPoint.m28406d();
        ECCurve a = m41225a(d, this.f32035a);
        ECCurve a2 = m41225a(d, this.f32036b);
        bigInteger = WNafUtil.m28499a(bigInteger);
        ECPoint e = a.mo6547e();
        eCPoint = a2.mo6548a(eCPoint);
        int i = 0;
        ECPoint eCPoint2 = e;
        e = eCPoint;
        eCPoint = null;
        while (i < bigInteger.length) {
            int i2 = bigInteger[i];
            int i3 = i2 >> 16;
            e = e.mo6575b(eCPoint + (i2 & MinElf.PN_XNUM));
            eCPoint = a.mo6548a(e);
            if (i3 < 0) {
                eCPoint = eCPoint.mo6572t();
            }
            eCPoint2 = eCPoint2.mo6568b(eCPoint);
            i++;
            boolean z = true;
        }
        return d.mo6548a(eCPoint2);
    }

    /* renamed from: a */
    protected ECCurve m41225a(ECCurve eCCurve, int i) {
        if (eCCurve.m28387k() == i) {
            return eCCurve;
        }
        if (eCCurve.mo6544a(i)) {
            return eCCurve.m28375b().m28356a(i).m28358a();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Coordinate system ");
        stringBuilder.append(i);
        stringBuilder.append(" not supported by this curve");
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
