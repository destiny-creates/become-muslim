package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERTaggedObject;

public class KeyAgreeRecipientIdentifier extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private IssuerAndSerialNumber f30585a;
    /* renamed from: b */
    private RecipientKeyIdentifier f30586b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f30585a != null) {
            return this.f30585a.mo5709e();
        }
        return new DERTaggedObject(false, 0, this.f30586b);
    }
}
