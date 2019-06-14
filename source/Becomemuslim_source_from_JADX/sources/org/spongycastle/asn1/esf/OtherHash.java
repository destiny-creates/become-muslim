package org.spongycastle.asn1.esf;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;

public class OtherHash extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private ASN1OctetString f30808a;
    /* renamed from: b */
    private OtherHashAlgAndValue f30809b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f30809b == null) {
            return this.f30808a;
        }
        return this.f30809b.mo5709e();
    }
}
