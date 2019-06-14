package org.spongycastle.asn1.pkcs;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERTaggedObject;
import org.spongycastle.asn1.DLSequence;

public class ContentInfo extends ASN1Object implements PKCSObjectIdentifiers {
    private ASN1ObjectIdentifier bF;
    private ASN1Encodable bG;
    private boolean bH = true;

    /* renamed from: a */
    public static ContentInfo m40061a(Object obj) {
        if (obj instanceof ContentInfo) {
            return (ContentInfo) obj;
        }
        return obj != null ? new ContentInfo(ASN1Sequence.m43000a(obj)) : null;
    }

    private ContentInfo(ASN1Sequence aSN1Sequence) {
        Enumeration c = aSN1Sequence.mo6861c();
        this.bF = (ASN1ObjectIdentifier) c.nextElement();
        if (c.hasMoreElements()) {
            this.bG = ((ASN1TaggedObject) c.nextElement()).m43036k();
        }
        this.bH = aSN1Sequence instanceof BERSequence;
    }

    public ContentInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.bF = aSN1ObjectIdentifier;
        this.bG = aSN1Encodable;
    }

    /* renamed from: a */
    public ASN1ObjectIdentifier m40062a() {
        return this.bF;
    }

    /* renamed from: b */
    public ASN1Encodable m40063b() {
        return this.bG;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.bF);
        if (this.bG != null) {
            aSN1EncodableVector.m27141a(new BERTaggedObject(true, 0, this.bG));
        }
        if (this.bH) {
            return new BERSequence(aSN1EncodableVector);
        }
        return new DLSequence(aSN1EncodableVector);
    }
}
