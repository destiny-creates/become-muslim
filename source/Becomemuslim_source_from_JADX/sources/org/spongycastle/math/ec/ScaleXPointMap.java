package org.spongycastle.math.ec;

public class ScaleXPointMap implements ECPointMap {
    /* renamed from: a */
    protected final ECFieldElement f27640a;

    public ScaleXPointMap(ECFieldElement eCFieldElement) {
        this.f27640a = eCFieldElement;
    }

    /* renamed from: a */
    public ECPoint mo5908a(ECPoint eCPoint) {
        return eCPoint.mo5904b(this.f27640a);
    }
}
