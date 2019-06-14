package org.spongycastle.asn1.dvcs;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERTaggedObject;

public class DVCSResponse extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private DVCSCertInfo f30745a;
    /* renamed from: b */
    private DVCSErrorNotice f30746b;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f30745a != null) {
            return this.f30745a.mo5709e();
        }
        return new DERTaggedObject(false, 0, this.f30746b);
    }

    public String toString() {
        if (this.f30745a != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DVCSResponse {\ndvCertInfo: ");
            stringBuilder.append(this.f30745a.toString());
            stringBuilder.append("}\n");
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("DVCSResponse {\ndvErrorNote: ");
        stringBuilder.append(this.f30746b.toString());
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}
