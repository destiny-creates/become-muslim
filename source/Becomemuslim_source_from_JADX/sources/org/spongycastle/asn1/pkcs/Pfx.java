package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.BERSequence;

public class Pfx extends ASN1Object implements PKCSObjectIdentifiers {
    private ContentInfo bF;
    private MacData bG = null;

    private Pfx(ASN1Sequence aSN1Sequence) {
        if (((ASN1Integer) aSN1Sequence.mo6860a(0)).m42968b().intValue() == 3) {
            this.bF = ContentInfo.m40061a(aSN1Sequence.mo6860a(1));
            if (aSN1Sequence.mo6862g() == 3) {
                this.bG = MacData.m40087a(aSN1Sequence.mo6860a(2));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("wrong version for PFX PDU");
    }

    /* renamed from: a */
    public static Pfx m40107a(Object obj) {
        if (obj instanceof Pfx) {
            return (Pfx) obj;
        }
        return obj != null ? new Pfx(ASN1Sequence.m43000a(obj)) : null;
    }

    public Pfx(ContentInfo contentInfo, MacData macData) {
        this.bF = contentInfo;
        this.bG = macData;
    }

    /* renamed from: a */
    public ContentInfo m40108a() {
        return this.bF;
    }

    /* renamed from: b */
    public MacData m40109b() {
        return this.bG;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(new ASN1Integer(3));
        aSN1EncodableVector.m27141a(this.bF);
        if (this.bG != null) {
            aSN1EncodableVector.m27141a(this.bG);
        }
        return new BERSequence(aSN1EncodableVector);
    }
}
