package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERTaggedObject;

public class PKIBody extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private int f30475a;
    /* renamed from: b */
    private ASN1Encodable f30476b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return new DERTaggedObject(true, this.f30475a, this.f30476b);
    }
}
