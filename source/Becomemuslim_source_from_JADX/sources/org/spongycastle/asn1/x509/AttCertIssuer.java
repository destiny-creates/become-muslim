package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;

public class AttCertIssuer extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    ASN1Encodable f31218a;
    /* renamed from: b */
    ASN1Primitive f31219b;

    /* renamed from: a */
    public static AttCertIssuer m40233a(Object obj) {
        if (obj != null) {
            if (!(obj instanceof AttCertIssuer)) {
                if (obj instanceof V2Form) {
                    return new AttCertIssuer(V2Form.m40462a(obj));
                }
                if (obj instanceof GeneralNames) {
                    return new AttCertIssuer((GeneralNames) obj);
                }
                if (obj instanceof ASN1TaggedObject) {
                    return new AttCertIssuer(V2Form.m40463a((ASN1TaggedObject) obj, false));
                }
                if (obj instanceof ASN1Sequence) {
                    return new AttCertIssuer(GeneralNames.m40346a(obj));
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown object in factory: ");
                stringBuilder.append(obj.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (AttCertIssuer) obj;
    }

    public AttCertIssuer(GeneralNames generalNames) {
        this.f31218a = generalNames;
        this.f31219b = this.f31218a.mo5709e();
    }

    public AttCertIssuer(V2Form v2Form) {
        this.f31218a = v2Form;
        this.f31219b = new DERTaggedObject(false, 0, this.f31218a);
    }

    /* renamed from: a */
    public ASN1Encodable m40234a() {
        return this.f31218a;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31219b;
    }
}
