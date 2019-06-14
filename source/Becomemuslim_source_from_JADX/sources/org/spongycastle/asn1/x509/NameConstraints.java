package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class NameConstraints extends ASN1Object {
    /* renamed from: a */
    private GeneralSubtree[] f31355a;
    /* renamed from: b */
    private GeneralSubtree[] f31356b;

    /* renamed from: a */
    public static NameConstraints m40379a(Object obj) {
        if (obj instanceof NameConstraints) {
            return (NameConstraints) obj;
        }
        return obj != null ? new NameConstraints(ASN1Sequence.m43000a(obj)) : null;
    }

    private NameConstraints(ASN1Sequence aSN1Sequence) {
        aSN1Sequence = aSN1Sequence.mo6861c();
        while (aSN1Sequence.hasMoreElements()) {
            ASN1TaggedObject a = ASN1TaggedObject.m43026a(aSN1Sequence.nextElement());
            switch (a.m43030b()) {
                case 0:
                    this.f31355a = m40380a(ASN1Sequence.m43001a(a, false));
                    break;
                case 1:
                    this.f31356b = m40380a(ASN1Sequence.m43001a(a, false));
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: a */
    private GeneralSubtree[] m40380a(ASN1Sequence aSN1Sequence) {
        GeneralSubtree[] generalSubtreeArr = new GeneralSubtree[aSN1Sequence.mo6862g()];
        for (int i = 0; i != generalSubtreeArr.length; i++) {
            generalSubtreeArr[i] = GeneralSubtree.m40350a(aSN1Sequence.mo6860a(i));
        }
        return generalSubtreeArr;
    }

    /* renamed from: a */
    public GeneralSubtree[] m40381a() {
        return this.f31355a;
    }

    /* renamed from: b */
    public GeneralSubtree[] m40382b() {
        return this.f31356b;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31355a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, new DERSequence(this.f31355a)));
        }
        if (this.f31356b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, new DERSequence(this.f31356b)));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
