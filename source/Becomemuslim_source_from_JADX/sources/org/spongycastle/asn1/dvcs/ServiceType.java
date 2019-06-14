package org.spongycastle.asn1.dvcs;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class ServiceType extends ASN1Object {
    /* renamed from: a */
    public static final ServiceType f30756a = new ServiceType(1);
    /* renamed from: b */
    public static final ServiceType f30757b = new ServiceType(2);
    /* renamed from: c */
    public static final ServiceType f30758c = new ServiceType(3);
    /* renamed from: d */
    public static final ServiceType f30759d = new ServiceType(4);
    /* renamed from: e */
    private ASN1Enumerated f30760e;

    public ServiceType(int i) {
        this.f30760e = new ASN1Enumerated(i);
    }

    /* renamed from: a */
    public BigInteger m39962a() {
        return this.f30760e.m42951b();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f30760e;
    }

    public String toString() {
        int intValue = this.f30760e.m42951b().intValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(intValue);
        String str = intValue == f30756a.m39962a().intValue() ? "(CPD)" : intValue == f30757b.m39962a().intValue() ? "(VSD)" : intValue == f30758c.m39962a().intValue() ? "(VPKC)" : intValue == f30759d.m39962a().intValue() ? "(CCPD)" : "?";
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
