package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.util.Strings;

public class DistributionPoint extends ASN1Object {
    /* renamed from: a */
    DistributionPointName f31266a;
    /* renamed from: b */
    ReasonFlags f31267b;
    /* renamed from: c */
    GeneralNames f31268c;

    /* renamed from: a */
    public static DistributionPoint m40310a(Object obj) {
        if (obj != null) {
            if (!(obj instanceof DistributionPoint)) {
                if (obj instanceof ASN1Sequence) {
                    return new DistributionPoint((ASN1Sequence) obj);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid DistributionPoint: ");
                stringBuilder.append(obj.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (DistributionPoint) obj;
    }

    public DistributionPoint(ASN1Sequence aSN1Sequence) {
        for (int i = 0; i != aSN1Sequence.mo6862g(); i++) {
            ASN1TaggedObject a = ASN1TaggedObject.m43026a(aSN1Sequence.mo6860a(i));
            switch (a.m43030b()) {
                case 0:
                    this.f31266a = DistributionPointName.m40317a(a, true);
                    break;
                case 1:
                    this.f31267b = new ReasonFlags(DERBitString.m43052a(a, false));
                    break;
                case 2:
                    this.f31268c = GeneralNames.m40347a(a, false);
                    break;
                default:
                    break;
            }
        }
    }

    public DistributionPoint(DistributionPointName distributionPointName, ReasonFlags reasonFlags, GeneralNames generalNames) {
        this.f31266a = distributionPointName;
        this.f31267b = reasonFlags;
        this.f31268c = generalNames;
    }

    /* renamed from: a */
    public DistributionPointName m40312a() {
        return this.f31266a;
    }

    /* renamed from: b */
    public ReasonFlags m40313b() {
        return this.f31267b;
    }

    /* renamed from: c */
    public GeneralNames m40314c() {
        return this.f31268c;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31266a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(0, this.f31266a));
        }
        if (this.f31267b != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f31267b));
        }
        if (this.f31268c != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 2, this.f31268c));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        String a = Strings.m29418a();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DistributionPoint: [");
        stringBuffer.append(a);
        if (this.f31266a != null) {
            m40311a(stringBuffer, a, "distributionPoint", this.f31266a.toString());
        }
        if (this.f31267b != null) {
            m40311a(stringBuffer, a, "reasons", this.f31267b.toString());
        }
        if (this.f31268c != null) {
            m40311a(stringBuffer, a, "cRLIssuer", this.f31268c.toString());
        }
        stringBuffer.append("]");
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private void m40311a(StringBuffer stringBuffer, String str, String str2, String str3) {
        String str4 = "    ";
        stringBuffer.append(str4);
        stringBuffer.append(str2);
        stringBuffer.append(":");
        stringBuffer.append(str);
        stringBuffer.append(str4);
        stringBuffer.append(str4);
        stringBuffer.append(str3);
        stringBuffer.append(str);
    }
}
