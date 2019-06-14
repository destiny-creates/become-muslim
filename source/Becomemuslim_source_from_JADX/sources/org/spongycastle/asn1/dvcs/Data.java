package org.spongycastle.asn1.dvcs;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.DigestInfo;

public class Data extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private ASN1OctetString f30749a;
    /* renamed from: b */
    private DigestInfo f30750b;
    /* renamed from: c */
    private ASN1Sequence f30751c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f30749a != null) {
            return this.f30749a.mo5709e();
        }
        if (this.f30750b != null) {
            return this.f30750b.mo5709e();
        }
        return new DERTaggedObject(false, 0, this.f30751c);
    }

    public String toString() {
        StringBuilder stringBuilder;
        if (this.f30749a != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Data {\n");
            stringBuilder.append(this.f30749a);
            stringBuilder.append("}\n");
            return stringBuilder.toString();
        } else if (this.f30750b != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Data {\n");
            stringBuilder.append(this.f30750b);
            stringBuilder.append("}\n");
            return stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Data {\n");
            stringBuilder.append(this.f30751c);
            stringBuilder.append("}\n");
            return stringBuilder.toString();
        }
    }
}
