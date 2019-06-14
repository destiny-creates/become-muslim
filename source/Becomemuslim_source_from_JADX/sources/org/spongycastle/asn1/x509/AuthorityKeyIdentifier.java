package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class AuthorityKeyIdentifier extends ASN1Object {
    /* renamed from: a */
    ASN1OctetString f31237a = null;
    /* renamed from: b */
    GeneralNames f31238b = null;
    /* renamed from: c */
    ASN1Integer f31239c = null;

    /* renamed from: a */
    public static AuthorityKeyIdentifier m40255a(Object obj) {
        if (obj instanceof AuthorityKeyIdentifier) {
            return (AuthorityKeyIdentifier) obj;
        }
        return obj != null ? new AuthorityKeyIdentifier(ASN1Sequence.m43000a(obj)) : null;
    }

    protected AuthorityKeyIdentifier(ASN1Sequence aSN1Sequence) {
        aSN1Sequence = aSN1Sequence.mo6861c();
        while (aSN1Sequence.hasMoreElements()) {
            ASN1TaggedObject a = ASN1TaggedObject.m43026a(aSN1Sequence.nextElement());
            switch (a.m43030b()) {
                case 0:
                    this.f31237a = ASN1OctetString.m42991a(a, false);
                    break;
                case 1:
                    this.f31238b = GeneralNames.m40347a(a, false);
                    break;
                case 2:
                    this.f31239c = ASN1Integer.m42964a(a, false);
                    break;
                default:
                    throw new IllegalArgumentException("illegal tag");
            }
        }
    }

    /* renamed from: a */
    public byte[] m40256a() {
        return this.f31237a != null ? this.f31237a.mo6859c() : null;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31237a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f31237a));
        }
        if (this.f31238b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f31238b));
        }
        if (this.f31239c != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 2, this.f31239c));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AuthorityKeyIdentifier: KeyID(");
        stringBuilder.append(this.f31237a.mo6859c());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
