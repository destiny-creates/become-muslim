package org.spongycastle.crypto.params;

import org.spongycastle.math.ec.ECPoint;

public class ECPublicKeyParameters extends ECKeyParameters {
    /* renamed from: c */
    ECPoint f32635c;

    public ECPublicKeyParameters(ECPoint eCPoint, ECDomainParameters eCDomainParameters) {
        super(false, eCDomainParameters);
        this.f32635c = eCPoint.m28418p();
    }

    /* renamed from: c */
    public ECPoint m43370c() {
        return this.f32635c;
    }
}
