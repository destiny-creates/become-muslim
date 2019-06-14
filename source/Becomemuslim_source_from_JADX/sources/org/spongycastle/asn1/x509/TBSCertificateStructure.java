package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x500.X500Name;

public class TBSCertificateStructure extends ASN1Object implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    ASN1Sequence bF;
    ASN1Integer bG;
    ASN1Integer bH;
    AlgorithmIdentifier bI;
    X500Name bJ;
    Time bK;
    Time bL;
    X500Name bM;
    SubjectPublicKeyInfo bN;
    DERBitString bO;
    DERBitString bP;
    X509Extensions bQ;

    /* renamed from: a */
    public static TBSCertificateStructure m40443a(Object obj) {
        if (obj instanceof TBSCertificateStructure) {
            return (TBSCertificateStructure) obj;
        }
        return obj != null ? new TBSCertificateStructure(ASN1Sequence.m43000a(obj)) : null;
    }

    public TBSCertificateStructure(ASN1Sequence aSN1Sequence) {
        int i;
        this.bF = aSN1Sequence;
        if (aSN1Sequence.mo6860a(0) instanceof DERTaggedObject) {
            this.bG = ASN1Integer.m42964a((ASN1TaggedObject) aSN1Sequence.mo6860a(0), true);
            i = 0;
        } else {
            this.bG = new ASN1Integer(0);
            i = -1;
        }
        this.bH = ASN1Integer.m42963a(aSN1Sequence.mo6860a(i + 1));
        this.bI = AlgorithmIdentifier.m40228a(aSN1Sequence.mo6860a(i + 2));
        this.bJ = X500Name.m40212a(aSN1Sequence.mo6860a(i + 3));
        ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.mo6860a(i + 4);
        this.bK = Time.m40457a(aSN1Sequence2.mo6860a(0));
        this.bL = Time.m40457a(aSN1Sequence2.mo6860a(1));
        this.bM = X500Name.m40212a(aSN1Sequence.mo6860a(i + 5));
        i += 6;
        this.bN = SubjectPublicKeyInfo.m40409a(aSN1Sequence.mo6860a(i));
        for (int g = (aSN1Sequence.mo6862g() - i) - 1; g > 0; g--) {
            ASN1TaggedObject aSN1TaggedObject = (DERTaggedObject) aSN1Sequence.mo6860a(i + g);
            switch (aSN1TaggedObject.m43030b()) {
                case 1:
                    this.bO = DERBitString.m43052a(aSN1TaggedObject, false);
                    break;
                case 2:
                    this.bP = DERBitString.m43052a(aSN1TaggedObject, false);
                    break;
                case 3:
                    this.bQ = X509Extensions.m40468a(aSN1TaggedObject);
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: a */
    public X500Name m40444a() {
        return this.bJ;
    }

    /* renamed from: b */
    public X500Name m40445b() {
        return this.bM;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.bF;
    }
}
