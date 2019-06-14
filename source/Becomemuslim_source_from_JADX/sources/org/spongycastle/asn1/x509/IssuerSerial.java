package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class IssuerSerial extends ASN1Object {
    /* renamed from: a */
    GeneralNames f31321a;
    /* renamed from: b */
    ASN1Integer f31322b;
    /* renamed from: c */
    DERBitString f31323c;

    /* renamed from: a */
    public static IssuerSerial m40359a(Object obj) {
        if (obj instanceof IssuerSerial) {
            return (IssuerSerial) obj;
        }
        return obj != null ? new IssuerSerial(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: a */
    public static IssuerSerial m40360a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return m40359a(ASN1Sequence.m43001a(aSN1TaggedObject, z));
    }

    private IssuerSerial(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() != 2) {
            if (aSN1Sequence.mo6862g() != 3) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Bad sequence size: ");
                stringBuilder.append(aSN1Sequence.mo6862g());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        this.f31321a = GeneralNames.m40346a(aSN1Sequence.mo6860a(0));
        this.f31322b = ASN1Integer.m42963a(aSN1Sequence.mo6860a(1));
        if (aSN1Sequence.mo6862g() == 3) {
            this.f31323c = DERBitString.m43051a(aSN1Sequence.mo6860a(2));
        }
    }

    /* renamed from: a */
    public GeneralNames m40361a() {
        return this.f31321a;
    }

    /* renamed from: b */
    public ASN1Integer m40362b() {
        return this.f31322b;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31321a);
        aSN1EncodableVector.m27141a(this.f31322b);
        if (this.f31323c != null) {
            aSN1EncodableVector.m27141a(this.f31323c);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
