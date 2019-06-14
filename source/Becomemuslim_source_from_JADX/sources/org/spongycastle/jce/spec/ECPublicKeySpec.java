package org.spongycastle.jce.spec;

import org.spongycastle.math.ec.ECPoint;

public class ECPublicKeySpec extends ECKeySpec {
    /* renamed from: a */
    private ECPoint f27623a;

    public ECPublicKeySpec(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        if (eCPoint.m28406d() != null) {
            this.f27623a = eCPoint.m28418p();
        } else {
            this.f27623a = eCPoint;
        }
    }

    /* renamed from: b */
    public ECPoint m36252b() {
        return this.f27623a;
    }
}
