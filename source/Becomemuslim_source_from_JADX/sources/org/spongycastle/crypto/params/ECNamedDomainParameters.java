package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;

public class ECNamedDomainParameters extends ECDomainParameters {
    /* renamed from: a */
    private ASN1ObjectIdentifier f31750a;

    public ECNamedDomainParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        super(eCCurve, eCPoint, bigInteger, bigInteger2, bArr);
        this.f31750a = aSN1ObjectIdentifier;
    }
}
