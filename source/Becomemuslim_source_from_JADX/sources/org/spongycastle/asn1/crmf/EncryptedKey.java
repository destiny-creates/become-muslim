package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.cms.EnvelopedData;

public class EncryptedKey extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private EnvelopedData f30675a;
    /* renamed from: b */
    private EncryptedValue f30676b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f30676b != null) {
            return this.f30676b.mo5709e();
        }
        return new DERTaggedObject(false, 0, this.f30675a);
    }
}
