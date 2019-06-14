package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERTaggedObject;

public class Evidence extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private TimeStampTokenEvidence f30571a;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f30571a != null ? new DERTaggedObject(false, 0, this.f30571a) : null;
    }
}
