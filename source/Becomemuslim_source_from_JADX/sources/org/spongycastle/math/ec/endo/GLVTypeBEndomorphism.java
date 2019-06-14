package org.spongycastle.math.ec.endo;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPointMap;
import org.spongycastle.math.ec.ScaleXPointMap;

public class GLVTypeBEndomorphism implements GLVEndomorphism {
    /* renamed from: a */
    protected final ECCurve f32118a;
    /* renamed from: b */
    protected final GLVTypeBParameters f32119b;
    /* renamed from: c */
    protected final ECPointMap f32120c;

    /* renamed from: b */
    public boolean mo6580b() {
        return true;
    }

    public GLVTypeBEndomorphism(ECCurve eCCurve, GLVTypeBParameters gLVTypeBParameters) {
        this.f32118a = eCCurve;
        this.f32119b = gLVTypeBParameters;
        this.f32120c = new ScaleXPointMap(eCCurve.mo6541a(gLVTypeBParameters.m28814a()));
    }

    /* renamed from: a */
    public BigInteger[] mo6579a(BigInteger bigInteger) {
        int h = this.f32119b.m28821h();
        BigInteger a = m42067a(bigInteger, this.f32119b.m28819f(), h);
        BigInteger a2 = m42067a(bigInteger, this.f32119b.m28820g(), h);
        GLVTypeBParameters gLVTypeBParameters = this.f32119b;
        bigInteger = bigInteger.subtract(a.multiply(gLVTypeBParameters.m28815b()).add(a2.multiply(gLVTypeBParameters.m28817d())));
        a2 = a.multiply(gLVTypeBParameters.m28816c()).add(a2.multiply(gLVTypeBParameters.m28818e())).negate();
        return new BigInteger[]{bigInteger, a2};
    }

    /* renamed from: a */
    public ECPointMap mo6578a() {
        return this.f32120c;
    }

    /* renamed from: a */
    protected BigInteger m42067a(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        Object obj = bigInteger2.signum() < 0 ? 1 : null;
        bigInteger = bigInteger.multiply(bigInteger2.abs());
        bigInteger2 = bigInteger.testBit(i - 1);
        bigInteger = bigInteger.shiftRight(i);
        if (bigInteger2 != null) {
            bigInteger = bigInteger.add(ECConstants.f23076d);
        }
        return obj != null ? bigInteger.negate() : bigInteger;
    }
}
