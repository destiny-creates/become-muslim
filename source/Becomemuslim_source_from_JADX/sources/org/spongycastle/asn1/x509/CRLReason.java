package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.util.Integers;

public class CRLReason extends ASN1Object {
    /* renamed from: a */
    private static final String[] f31244a = new String[]{"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};
    /* renamed from: b */
    private static final Hashtable f31245b = new Hashtable();
    /* renamed from: c */
    private ASN1Enumerated f31246c;

    /* renamed from: a */
    public static CRLReason m40268a(Object obj) {
        if (obj instanceof CRLReason) {
            return (CRLReason) obj;
        }
        return obj != null ? m40267a(ASN1Enumerated.m42946a(obj).m42951b().intValue()) : null;
    }

    private CRLReason(int i) {
        this.f31246c = new ASN1Enumerated(i);
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder;
        int intValue = m40269a().intValue();
        if (intValue >= 0) {
            if (intValue <= 10) {
                str = f31244a[intValue];
                stringBuilder = new StringBuilder();
                stringBuilder.append("CRLReason: ");
                stringBuilder.append(str);
                return stringBuilder.toString();
            }
        }
        str = "invalid";
        stringBuilder = new StringBuilder();
        stringBuilder.append("CRLReason: ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public BigInteger m40269a() {
        return this.f31246c.m42951b();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31246c;
    }

    /* renamed from: a */
    public static CRLReason m40267a(int i) {
        Integer a = Integers.m29396a(i);
        if (!f31245b.containsKey(a)) {
            f31245b.put(a, new CRLReason(i));
        }
        return (CRLReason) f31245b.get(a);
    }
}
