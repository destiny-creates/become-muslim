package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.math.ec.endo.GLVEndomorphism;

public class GLVMultiplier extends AbstractECMultiplier {
    /* renamed from: a */
    protected final ECCurve f32033a;
    /* renamed from: b */
    protected final GLVEndomorphism f32034b;

    public GLVMultiplier(ECCurve eCCurve, GLVEndomorphism gLVEndomorphism) {
        if (eCCurve == null || eCCurve.m28385i() == null) {
            throw new IllegalArgumentException("Need curve with known group order");
        }
        this.f32033a = eCCurve;
        this.f32034b = gLVEndomorphism;
    }

    /* renamed from: b */
    protected ECPoint mo6539b(ECPoint eCPoint, BigInteger bigInteger) {
        if (this.f32033a.m28374a(eCPoint.m28406d())) {
            bigInteger = this.f32034b.mo6579a(bigInteger.mod(eCPoint.m28406d().m28385i()));
            BigInteger bigInteger2 = bigInteger[0];
            bigInteger = bigInteger[1];
            ECPointMap a = this.f32034b.mo6578a();
            if (this.f32034b.mo6580b()) {
                return ECAlgorithms.m28344a(eCPoint, bigInteger2, a, bigInteger);
            }
            return ECAlgorithms.m28353b(eCPoint, bigInteger2, a.mo5908a(eCPoint), bigInteger);
        }
        throw new IllegalStateException();
    }
}
