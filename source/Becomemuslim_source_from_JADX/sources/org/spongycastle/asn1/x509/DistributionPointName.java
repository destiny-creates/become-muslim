package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.util.Strings;

public class DistributionPointName extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    ASN1Encodable f31269a;
    /* renamed from: b */
    int f31270b;

    /* renamed from: a */
    public static DistributionPointName m40317a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return m40316a(ASN1TaggedObject.m43027a(aSN1TaggedObject, true));
    }

    /* renamed from: a */
    public static DistributionPointName m40316a(Object obj) {
        if (obj != null) {
            if (!(obj instanceof DistributionPointName)) {
                if (obj instanceof ASN1TaggedObject) {
                    return new DistributionPointName((ASN1TaggedObject) obj);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown object in factory: ");
                stringBuilder.append(obj.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (DistributionPointName) obj;
    }

    public DistributionPointName(int i, ASN1Encodable aSN1Encodable) {
        this.f31270b = i;
        this.f31269a = aSN1Encodable;
    }

    /* renamed from: a */
    public int m40319a() {
        return this.f31270b;
    }

    /* renamed from: b */
    public ASN1Encodable m40320b() {
        return this.f31269a;
    }

    public DistributionPointName(ASN1TaggedObject aSN1TaggedObject) {
        this.f31270b = aSN1TaggedObject.m43030b();
        if (this.f31270b == 0) {
            this.f31269a = GeneralNames.m40347a(aSN1TaggedObject, false);
        } else {
            this.f31269a = ASN1Set.m43013a(aSN1TaggedObject, false);
        }
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return new DERTaggedObject(false, this.f31270b, this.f31269a);
    }

    public String toString() {
        String a = Strings.m29418a();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DistributionPointName: [");
        stringBuffer.append(a);
        if (this.f31270b == 0) {
            m40318a(stringBuffer, a, "fullName", this.f31269a.toString());
        } else {
            m40318a(stringBuffer, a, "nameRelativeToCRLIssuer", this.f31269a.toString());
        }
        stringBuffer.append("]");
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private void m40318a(StringBuffer stringBuffer, String str, String str2, String str3) {
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
