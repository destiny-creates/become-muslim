package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class V2Form extends ASN1Object {
    /* renamed from: a */
    GeneralNames f31408a;
    /* renamed from: b */
    IssuerSerial f31409b;
    /* renamed from: c */
    ObjectDigestInfo f31410c;

    /* renamed from: a */
    public static V2Form m40463a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return m40462a(ASN1Sequence.m43001a(aSN1TaggedObject, z));
    }

    /* renamed from: a */
    public static V2Form m40462a(Object obj) {
        if (obj instanceof V2Form) {
            return (V2Form) obj;
        }
        return obj != null ? new V2Form(ASN1Sequence.m43000a(obj)) : null;
    }

    public V2Form(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() <= 3) {
            int i;
            if (aSN1Sequence.mo6860a(0) instanceof ASN1TaggedObject) {
                i = 0;
            } else {
                this.f31408a = GeneralNames.m40346a(aSN1Sequence.mo6860a(0));
                i = 1;
            }
            while (i != aSN1Sequence.mo6862g()) {
                ASN1TaggedObject a = ASN1TaggedObject.m43026a(aSN1Sequence.mo6860a(i));
                if (a.m43030b() == 0) {
                    this.f31409b = IssuerSerial.m40360a(a, false);
                } else if (a.m43030b() == 1) {
                    this.f31410c = ObjectDigestInfo.m40386a(a, false);
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Bad tag number: ");
                    stringBuilder.append(a.m43030b());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                i++;
            }
            return;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Bad sequence size: ");
        stringBuilder2.append(aSN1Sequence.mo6862g());
        throw new IllegalArgumentException(stringBuilder2.toString());
    }

    /* renamed from: a */
    public GeneralNames m40464a() {
        return this.f31408a;
    }

    /* renamed from: b */
    public IssuerSerial m40465b() {
        return this.f31409b;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31408a != null) {
            aSN1EncodableVector.m27141a(this.f31408a);
        }
        if (this.f31409b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f31409b));
        }
        if (this.f31410c != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f31410c));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
