package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class SignedData extends ASN1Object implements PKCSObjectIdentifiers {
    private ASN1Integer bF;
    private ASN1Set bG;
    private ContentInfo bH;
    private ASN1Set bI;
    private ASN1Set bJ;
    private ASN1Set bK;

    /* renamed from: a */
    public static SignedData m40159a(Object obj) {
        if (obj instanceof SignedData) {
            return (SignedData) obj;
        }
        return obj != null ? new SignedData(ASN1Sequence.m43000a(obj)) : null;
    }

    public SignedData(ASN1Integer aSN1Integer, ASN1Set aSN1Set, ContentInfo contentInfo, ASN1Set aSN1Set2, ASN1Set aSN1Set3, ASN1Set aSN1Set4) {
        this.bF = aSN1Integer;
        this.bG = aSN1Set;
        this.bH = contentInfo;
        this.bI = aSN1Set2;
        this.bJ = aSN1Set3;
        this.bK = aSN1Set4;
    }

    public SignedData(ASN1Sequence aSN1Sequence) {
        aSN1Sequence = aSN1Sequence.mo6861c();
        this.bF = (ASN1Integer) aSN1Sequence.nextElement();
        this.bG = (ASN1Set) aSN1Sequence.nextElement();
        this.bH = ContentInfo.m40061a(aSN1Sequence.nextElement());
        while (aSN1Sequence.hasMoreElements()) {
            ASN1Primitive aSN1Primitive = (ASN1Primitive) aSN1Sequence.nextElement();
            if (aSN1Primitive instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
                switch (aSN1TaggedObject.m43030b()) {
                    case 0:
                        this.bI = ASN1Set.m43013a(aSN1TaggedObject, false);
                        break;
                    case 1:
                        this.bJ = ASN1Set.m43013a(aSN1TaggedObject, false);
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("unknown tag value ");
                        stringBuilder.append(aSN1TaggedObject.m43030b());
                        throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            this.bK = (ASN1Set) aSN1Primitive;
        }
    }

    /* renamed from: a */
    public ASN1Set m40160a() {
        return this.bI;
    }

    /* renamed from: b */
    public ASN1Set m40161b() {
        return this.bJ;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.bF);
        aSN1EncodableVector.m27141a(this.bG);
        aSN1EncodableVector.m27141a(this.bH);
        if (this.bI != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.bI));
        }
        if (this.bJ != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.bJ));
        }
        aSN1EncodableVector.m27141a(this.bK);
        return new BERSequence(aSN1EncodableVector);
    }
}
