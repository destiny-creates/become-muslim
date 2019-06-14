package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class PKIStatus extends ASN1Object {
    /* renamed from: a */
    public static final PKIStatus f30497a = new PKIStatus(0);
    /* renamed from: b */
    public static final PKIStatus f30498b = new PKIStatus(1);
    /* renamed from: c */
    public static final PKIStatus f30499c = new PKIStatus(2);
    /* renamed from: d */
    public static final PKIStatus f30500d = new PKIStatus(3);
    /* renamed from: e */
    public static final PKIStatus f30501e = new PKIStatus(4);
    /* renamed from: f */
    public static final PKIStatus f30502f = new PKIStatus(5);
    /* renamed from: g */
    public static final PKIStatus f30503g = new PKIStatus(6);
    /* renamed from: h */
    private ASN1Integer f30504h;

    private PKIStatus(int i) {
        this(new ASN1Integer((long) i));
    }

    private PKIStatus(ASN1Integer aSN1Integer) {
        this.f30504h = aSN1Integer;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f30504h;
    }
}
