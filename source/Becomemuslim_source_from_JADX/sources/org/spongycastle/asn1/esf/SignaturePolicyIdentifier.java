package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;

public class SignaturePolicyIdentifier extends ASN1Object {
    /* renamed from: a */
    private SignaturePolicyId f30827a;
    /* renamed from: b */
    private boolean f30828b = true;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f30828b) {
            return DERNull.f32850a;
        }
        return this.f30827a.mo5709e();
    }
}
