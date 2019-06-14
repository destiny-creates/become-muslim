package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Strings;

public class GeneralNames extends ASN1Object {
    /* renamed from: a */
    private final GeneralName[] f31310a;

    /* renamed from: a */
    public static GeneralNames m40346a(Object obj) {
        if (obj instanceof GeneralNames) {
            return (GeneralNames) obj;
        }
        return obj != null ? new GeneralNames(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: a */
    public static GeneralNames m40347a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return m40346a(ASN1Sequence.m43001a(aSN1TaggedObject, z));
    }

    public GeneralNames(GeneralName generalName) {
        this.f31310a = new GeneralName[]{generalName};
    }

    private GeneralNames(ASN1Sequence aSN1Sequence) {
        this.f31310a = new GeneralName[aSN1Sequence.mo6862g()];
        for (int i = 0; i != aSN1Sequence.mo6862g(); i++) {
            this.f31310a[i] = GeneralName.m40335a(aSN1Sequence.mo6860a(i));
        }
    }

    /* renamed from: a */
    public GeneralName[] m40348a() {
        Object obj = new GeneralName[this.f31310a.length];
        System.arraycopy(this.f31310a, 0, obj, 0, this.f31310a.length);
        return obj;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return new DERSequence(this.f31310a);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String a = Strings.m29418a();
        stringBuffer.append("GeneralNames:");
        stringBuffer.append(a);
        for (int i = 0; i != this.f31310a.length; i++) {
            stringBuffer.append("    ");
            stringBuffer.append(this.f31310a[i]);
            stringBuffer.append(a);
        }
        return stringBuffer.toString();
    }
}
