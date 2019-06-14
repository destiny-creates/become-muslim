package org.spongycastle.asn1.dvcs;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Extension;

public class CertEtcToken extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private static final boolean[] f30717a = new boolean[]{false, true, false, true, false, true, false, false, true};
    /* renamed from: b */
    private int f30718b;
    /* renamed from: c */
    private ASN1Encodable f30719c;
    /* renamed from: d */
    private Extension f30720d;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f30720d == null) {
            return new DERTaggedObject(f30717a[this.f30718b], this.f30718b, this.f30719c);
        }
        return this.f30720d.mo5709e();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CertEtcToken {\n");
        stringBuilder.append(this.f30719c);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}
