package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;

public class TargetInformation extends ASN1Object {
    /* renamed from: a */
    private ASN1Sequence f31403a;

    /* renamed from: a */
    public static TargetInformation m40451a(Object obj) {
        if (obj instanceof TargetInformation) {
            return (TargetInformation) obj;
        }
        return obj != null ? new TargetInformation(ASN1Sequence.m43000a(obj)) : null;
    }

    private TargetInformation(ASN1Sequence aSN1Sequence) {
        this.f31403a = aSN1Sequence;
    }

    /* renamed from: a */
    public Targets[] m40452a() {
        Targets[] targetsArr = new Targets[this.f31403a.mo6862g()];
        Enumeration c = this.f31403a.mo6861c();
        int i = 0;
        while (c.hasMoreElements()) {
            int i2 = i + 1;
            targetsArr[i] = Targets.m40454a(c.nextElement());
            i = i2;
        }
        return targetsArr;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31403a;
    }
}
