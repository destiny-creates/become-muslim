package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class RoleSyntax extends ASN1Object {
    /* renamed from: a */
    private GeneralNames f31374a;
    /* renamed from: b */
    private GeneralName f31375b;

    /* renamed from: a */
    public String m40403a() {
        return ((ASN1String) this.f31375b.m40344b()).mo6440b();
    }

    /* renamed from: b */
    public String[] m40404b() {
        int i = 0;
        if (this.f31374a == null) {
            return new String[0];
        }
        GeneralName[] a = this.f31374a.m40348a();
        String[] strArr = new String[a.length];
        while (i < a.length) {
            ASN1Encodable b = a[i].m40344b();
            if (b instanceof ASN1String) {
                strArr[i] = ((ASN1String) b).mo6440b();
            } else {
                strArr[i] = b.toString();
            }
            i++;
        }
        return strArr;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31374a != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f31374a));
        }
        aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, this.f31375b));
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ");
        stringBuilder.append(m40403a());
        stringBuilder.append(" - Auth: ");
        StringBuffer stringBuffer = new StringBuffer(stringBuilder.toString());
        if (this.f31374a != null) {
            if (this.f31374a.m40348a().length != 0) {
                String[] b = m40404b();
                stringBuffer.append('[');
                stringBuffer.append(b[0]);
                for (int i = 1; i < b.length; i++) {
                    stringBuffer.append(", ");
                    stringBuffer.append(b[i]);
                }
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
        }
        stringBuffer.append("N/A");
        return stringBuffer.toString();
    }
}
