package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;

public class Targets extends ASN1Object {
    /* renamed from: a */
    private ASN1Sequence f31404a;

    /* renamed from: a */
    public static Targets m40454a(Object obj) {
        if (obj instanceof Targets) {
            return (Targets) obj;
        }
        return obj != null ? new Targets(ASN1Sequence.m43000a(obj)) : null;
    }

    private Targets(ASN1Sequence aSN1Sequence) {
        this.f31404a = aSN1Sequence;
    }

    /* renamed from: a */
    public Target[] m40455a() {
        Target[] targetArr = new Target[this.f31404a.mo6862g()];
        Enumeration c = this.f31404a.mo6861c();
        int i = 0;
        while (c.hasMoreElements()) {
            int i2 = i + 1;
            targetArr[i] = Target.m40447a(c.nextElement());
            i = i2;
        }
        return targetArr;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31404a;
    }
}
