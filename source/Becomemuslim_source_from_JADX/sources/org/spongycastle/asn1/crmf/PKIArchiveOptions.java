package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERTaggedObject;

public class PKIArchiveOptions extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private ASN1Encodable f30685a;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f30685a instanceof EncryptedKey) {
            return new DERTaggedObject(true, 0, this.f30685a);
        }
        if (this.f30685a instanceof ASN1OctetString) {
            return new DERTaggedObject(false, 1, this.f30685a);
        }
        return new DERTaggedObject(false, 2, this.f30685a);
    }
}
