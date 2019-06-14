package org.spongycastle.asn1.isismtt.ocsp;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Certificate;

public class RequestedCertificate extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private Certificate f30862a;
    /* renamed from: b */
    private byte[] f30863b;
    /* renamed from: c */
    private byte[] f30864c;

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f30863b != null) {
            return new DERTaggedObject(0, new DEROctetString(this.f30863b));
        }
        if (this.f30864c != null) {
            return new DERTaggedObject(1, new DEROctetString(this.f30864c));
        }
        return this.f30862a.mo5709e();
    }
}
