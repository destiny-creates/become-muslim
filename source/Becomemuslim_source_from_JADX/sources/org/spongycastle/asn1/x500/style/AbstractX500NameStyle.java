package org.spongycastle.asn1.x500.style;

import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.x500.AttributeTypeAndValue;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.X500NameStyle;

public abstract class AbstractX500NameStyle implements X500NameStyle {
    /* renamed from: a */
    public static Hashtable m34661a(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            hashtable2.put(nextElement, hashtable.get(nextElement));
        }
        return hashtable2;
    }

    /* renamed from: a */
    private int m34660a(ASN1Encodable aSN1Encodable) {
        return IETFUtils.m27235a(IETFUtils.m27236a(aSN1Encodable)).hashCode();
    }

    /* renamed from: a */
    public int mo5717a(X500Name x500Name) {
        x500Name = x500Name.m40215a();
        int i = 0;
        for (int i2 = 0; i2 != x500Name.length; i2++) {
            if (x500Name[i2].m40208a()) {
                AttributeTypeAndValue[] c = x500Name[i2].m40210c();
                int i3 = i;
                for (i = 0; i != c.length; i++) {
                    i3 = (i3 ^ c[i].m40202a().hashCode()) ^ m34660a(c[i].m40203b());
                }
                i = i3;
            } else {
                i = (i ^ x500Name[i2].m40209b().m40202a().hashCode()) ^ m34660a(x500Name[i2].m40209b().m40203b());
            }
        }
        return i;
    }

    /* renamed from: a */
    public org.spongycastle.asn1.ASN1Encodable mo5718a(org.spongycastle.asn1.ASN1ObjectIdentifier r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r6.length();
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x0030;
    L_0x0008:
        r0 = r6.charAt(r2);
        r3 = 35;
        if (r0 != r3) goto L_0x0030;
    L_0x0010:
        r6 = org.spongycastle.asn1.x500.style.IETFUtils.m27238a(r6, r1);	 Catch:{ IOException -> 0x0015 }
        return r6;
    L_0x0015:
        r6 = new org.spongycastle.asn1.ASN1ParsingException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "can't recode value for oid ";
        r0.append(r1);
        r5 = r5.m42986b();
        r0.append(r5);
        r5 = r0.toString();
        r6.<init>(r5);
        throw r6;
    L_0x0030:
        r0 = r6.length();
        if (r0 == 0) goto L_0x0042;
    L_0x0036:
        r0 = r6.charAt(r2);
        r2 = 92;
        if (r0 != r2) goto L_0x0042;
    L_0x003e:
        r6 = r6.substring(r1);
    L_0x0042:
        r5 = r4.mo6443b(r5, r6);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x500.style.AbstractX500NameStyle.a(org.spongycastle.asn1.ASN1ObjectIdentifier, java.lang.String):org.spongycastle.asn1.ASN1Encodable");
    }

    /* renamed from: b */
    protected ASN1Encodable mo6443b(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        return new DERUTF8String(str);
    }

    /* renamed from: a */
    public boolean mo5719a(X500Name x500Name, X500Name x500Name2) {
        x500Name = x500Name.m40215a();
        x500Name2 = x500Name2.m40215a();
        if (x500Name.length != x500Name2.length) {
            return false;
        }
        boolean equals = (x500Name[0].m40209b() == null || x500Name2[0].m40209b() == null) ? false : x500Name[0].m40209b().m40202a().equals(x500Name2[0].m40209b().m40202a()) ^ true;
        for (int i = 0; i != x500Name.length; i++) {
            if (!m34662a(equals, x500Name[i], x500Name2)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m34662a(boolean z, RDN rdn, RDN[] rdnArr) {
        if (z) {
            z = rdnArr.length - true;
            while (z < false) {
                if (rdnArr[z] == null || !m34665a(rdn, rdnArr[z])) {
                    z--;
                } else {
                    rdnArr[z] = null;
                    return true;
                }
            }
        }
        z = false;
        while (z != rdnArr.length) {
            if (rdnArr[z] == null || !m34665a(rdn, rdnArr[z])) {
                z++;
            } else {
                rdnArr[z] = null;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    protected boolean m34665a(RDN rdn, RDN rdn2) {
        return IETFUtils.m27244a(rdn, rdn2);
    }
}
