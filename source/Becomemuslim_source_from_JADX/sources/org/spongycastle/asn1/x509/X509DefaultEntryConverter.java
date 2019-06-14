package org.spongycastle.asn1.x509;

public class X509DefaultEntryConverter extends X509NameEntryConverter {
    /* renamed from: a */
    public org.spongycastle.asn1.ASN1Primitive mo5720a(org.spongycastle.asn1.ASN1ObjectIdentifier r5, java.lang.String r6) {
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
        r6 = r4.m27258a(r6, r1);	 Catch:{ IOException -> 0x0015 }
        return r6;
    L_0x0015:
        r6 = new java.lang.RuntimeException;
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
        r0 = org.spongycastle.asn1.x509.X509Name.f31447D;
        r0 = r5.equals(r0);
        if (r0 != 0) goto L_0x008e;
    L_0x004a:
        r0 = org.spongycastle.asn1.x509.X509Name.f31451H;
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0053;
    L_0x0052:
        goto L_0x008e;
    L_0x0053:
        r0 = org.spongycastle.asn1.x509.X509Name.f31481t;
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0061;
    L_0x005b:
        r5 = new org.spongycastle.asn1.DERGeneralizedTime;
        r5.<init>(r6);
        return r5;
    L_0x0061:
        r0 = org.spongycastle.asn1.x509.X509Name.f31462a;
        r0 = r5.equals(r0);
        if (r0 != 0) goto L_0x0088;
    L_0x0069:
        r0 = org.spongycastle.asn1.x509.X509Name.f31467f;
        r0 = r5.equals(r0);
        if (r0 != 0) goto L_0x0088;
    L_0x0071:
        r0 = org.spongycastle.asn1.x509.X509Name.f31479r;
        r0 = r5.equals(r0);
        if (r0 != 0) goto L_0x0088;
    L_0x0079:
        r0 = org.spongycastle.asn1.x509.X509Name.f31445B;
        r5 = r5.equals(r0);
        if (r5 == 0) goto L_0x0082;
    L_0x0081:
        goto L_0x0088;
    L_0x0082:
        r5 = new org.spongycastle.asn1.DERUTF8String;
        r5.<init>(r6);
        return r5;
    L_0x0088:
        r5 = new org.spongycastle.asn1.DERPrintableString;
        r5.<init>(r6);
        return r5;
    L_0x008e:
        r5 = new org.spongycastle.asn1.DERIA5String;
        r5.<init>(r6);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x509.X509DefaultEntryConverter.a(org.spongycastle.asn1.ASN1ObjectIdentifier, java.lang.String):org.spongycastle.asn1.ASN1Primitive");
    }
}
