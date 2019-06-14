package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class CertificatePair extends ASN1Object {
    /* renamed from: a */
    private Certificate f31257a;
    /* renamed from: b */
    private Certificate f31258b;

    /* renamed from: a */
    public static CertificatePair m40295a(Object obj) {
        if (obj != null) {
            if (!(obj instanceof CertificatePair)) {
                if (obj instanceof ASN1Sequence) {
                    return new CertificatePair((ASN1Sequence) obj);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("illegal object in getInstance: ");
                stringBuilder.append(obj.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (CertificatePair) obj;
    }

    private CertificatePair(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() != 1) {
            if (aSN1Sequence.mo6862g() != 2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Bad sequence size: ");
                stringBuilder.append(aSN1Sequence.mo6862g());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        aSN1Sequence = aSN1Sequence.mo6861c();
        while (aSN1Sequence.hasMoreElements()) {
            ASN1TaggedObject a = ASN1TaggedObject.m43026a(aSN1Sequence.nextElement());
            if (a.m43030b() == 0) {
                this.f31257a = Certificate.m40273a(a, true);
            } else if (a.m43030b() == 1) {
                this.f31258b = Certificate.m40273a(a, true);
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Bad tag number: ");
                stringBuilder.append(a.m43030b());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    public CertificatePair(Certificate certificate, Certificate certificate2) {
        this.f31257a = certificate;
        this.f31258b = certificate2;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31257a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(0, this.f31257a));
        }
        if (this.f31258b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(1, this.f31258b));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    /* renamed from: a */
    public Certificate m40296a() {
        return this.f31257a;
    }

    /* renamed from: b */
    public Certificate m40297b() {
        return this.f31258b;
    }
}
