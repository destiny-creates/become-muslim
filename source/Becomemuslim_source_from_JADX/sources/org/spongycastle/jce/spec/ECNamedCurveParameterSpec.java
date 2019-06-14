package org.spongycastle.jce.spec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;

public class ECNamedCurveParameterSpec extends ECParameterSpec {
    /* renamed from: a */
    private String f27621a;

    public ECNamedCurveParameterSpec(String str, ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        super(eCCurve, eCPoint, bigInteger, bigInteger2, bArr);
        this.f27621a = str;
    }

    /* renamed from: a */
    public String m36250a() {
        return this.f27621a;
    }
}
