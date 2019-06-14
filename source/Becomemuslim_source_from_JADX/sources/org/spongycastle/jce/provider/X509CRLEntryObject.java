package org.spongycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRLException;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.TBSCertList.CRLEntry;

public class X509CRLEntryObject extends X509CRLEntry {
    /* renamed from: a */
    private CRLEntry f23030a;
    /* renamed from: b */
    private X500Name f23031b;
    /* renamed from: c */
    private int f23032c;
    /* renamed from: d */
    private boolean f23033d;

    public X509CRLEntryObject(CRLEntry cRLEntry, boolean z, X500Name x500Name) {
        this.f23030a = cRLEntry;
        this.f23031b = m28293a(z, x500Name);
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        return (criticalExtensionOIDs == null || criticalExtensionOIDs.isEmpty()) ? false : true;
    }

    /* renamed from: a */
    private org.spongycastle.asn1.x500.X500Name m28293a(boolean r4, org.spongycastle.asn1.x500.X500Name r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r4 = org.spongycastle.asn1.x509.Extension.f31290n;
        r4 = r3.m28294a(r4);
        if (r4 != 0) goto L_0x000d;
    L_0x000c:
        return r5;
    L_0x000d:
        r4 = r4.m40328d();	 Catch:{ Exception -> 0x0035 }
        r4 = org.spongycastle.asn1.x509.GeneralNames.m40346a(r4);	 Catch:{ Exception -> 0x0035 }
        r4 = r4.m40348a();	 Catch:{ Exception -> 0x0035 }
        r5 = 0;	 Catch:{ Exception -> 0x0035 }
    L_0x001a:
        r1 = r4.length;	 Catch:{ Exception -> 0x0035 }
        if (r5 >= r1) goto L_0x0034;	 Catch:{ Exception -> 0x0035 }
    L_0x001d:
        r1 = r4[r5];	 Catch:{ Exception -> 0x0035 }
        r1 = r1.m40343a();	 Catch:{ Exception -> 0x0035 }
        r2 = 4;	 Catch:{ Exception -> 0x0035 }
        if (r1 != r2) goto L_0x0031;	 Catch:{ Exception -> 0x0035 }
    L_0x0026:
        r4 = r4[r5];	 Catch:{ Exception -> 0x0035 }
        r4 = r4.m40344b();	 Catch:{ Exception -> 0x0035 }
        r4 = org.spongycastle.asn1.x500.X500Name.m40212a(r4);	 Catch:{ Exception -> 0x0035 }
        return r4;
    L_0x0031:
        r5 = r5 + 1;
        goto L_0x001a;
    L_0x0034:
        return r0;
    L_0x0035:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.X509CRLEntryObject.a(boolean, org.spongycastle.asn1.x500.X500Name):org.spongycastle.asn1.x500.X500Name");
    }

    public javax.security.auth.x500.X500Principal getCertificateIssuer() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.f23031b;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = new javax.security.auth.x500.X500Principal;	 Catch:{ IOException -> 0x0012 }
        r2 = r3.f23031b;	 Catch:{ IOException -> 0x0012 }
        r2 = r2.mo6822f();	 Catch:{ IOException -> 0x0012 }
        r0.<init>(r2);	 Catch:{ IOException -> 0x0012 }
        return r0;
    L_0x0012:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.X509CRLEntryObject.getCertificateIssuer():javax.security.auth.x500.X500Principal");
    }

    /* renamed from: a */
    private Set m28292a(boolean z) {
        Extensions c = this.f23030a.m40418c();
        if (c == null) {
            return false;
        }
        Set hashSet = new HashSet();
        Enumeration a = c.m40331a();
        while (a.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) a.nextElement();
            if (z == c.m40332a(aSN1ObjectIdentifier).m40326b()) {
                hashSet.add(aSN1ObjectIdentifier.m42986b());
            }
        }
        return hashSet;
    }

    public Set getCriticalExtensionOIDs() {
        return m28292a(true);
    }

    public Set getNonCriticalExtensionOIDs() {
        return m28292a(false);
    }

    /* renamed from: a */
    private Extension m28294a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Extensions c = this.f23030a.m40418c();
        return c != null ? c.m40332a(aSN1ObjectIdentifier) : null;
    }

    public byte[] getExtensionValue(String str) {
        str = m28294a(new ASN1ObjectIdentifier(str));
        if (str == null) {
            return null;
        }
        try {
            return str.m40327c().mo6822f();
        } catch (String str2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("error encoding ");
            stringBuilder.append(str2.toString());
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    public int hashCode() {
        if (!this.f23033d) {
            this.f23032c = super.hashCode();
            this.f23033d = true;
        }
        return this.f23032c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509CRLEntryObject)) {
            return super.equals(this);
        }
        return this.f23030a.equals(((X509CRLEntryObject) obj).f23030a);
    }

    public byte[] getEncoded() {
        try {
            return this.f23030a.m34596a("DER");
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    public BigInteger getSerialNumber() {
        return this.f23030a.m40416a().m42968b();
    }

    public Date getRevocationDate() {
        return this.f23030a.m40417b().m40459b();
    }

    public boolean hasExtensions() {
        return this.f23030a.m40418c() != null;
    }

    public java.lang.String toString() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r1 = org.spongycastle.util.Strings.m29418a();
        r2 = "      userCertificate: ";
        r0.append(r2);
        r2 = r8.getSerialNumber();
        r0.append(r2);
        r0.append(r1);
        r2 = "       revocationDate: ";
        r0.append(r2);
        r2 = r8.getRevocationDate();
        r0.append(r2);
        r0.append(r1);
        r2 = "       certificateIssuer: ";
        r0.append(r2);
        r2 = r8.getCertificateIssuer();
        r0.append(r2);
        r0.append(r1);
        r2 = r8.f23030a;
        r2 = r2.m40418c();
        if (r2 == 0) goto L_0x00f2;
    L_0x003e:
        r3 = r2.m40331a();
        r4 = r3.hasMoreElements();
        if (r4 == 0) goto L_0x00f2;
    L_0x0048:
        r4 = "   crlEntryExtensions:";
        r0.append(r4);
        r0.append(r1);
    L_0x0050:
        r4 = r3.hasMoreElements();
        if (r4 == 0) goto L_0x00f2;
    L_0x0056:
        r4 = r3.nextElement();
        r4 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r4;
        r5 = r2.m40332a(r4);
        r6 = r5.m40327c();
        if (r6 == 0) goto L_0x00ed;
    L_0x0066:
        r6 = r5.m40327c();
        r6 = r6.mo6859c();
        r7 = new org.spongycastle.asn1.ASN1InputStream;
        r7.<init>(r6);
        r6 = "                       critical(";
        r0.append(r6);
        r5 = r5.m40326b();
        r0.append(r5);
        r5 = ") ";
        r0.append(r5);
        r5 = org.spongycastle.asn1.x509.X509Extension.f22062i;	 Catch:{ Exception -> 0x00d7 }
        r5 = r4.equals(r5);	 Catch:{ Exception -> 0x00d7 }
        if (r5 == 0) goto L_0x009f;	 Catch:{ Exception -> 0x00d7 }
    L_0x008c:
        r5 = r7.m34595d();	 Catch:{ Exception -> 0x00d7 }
        r5 = org.spongycastle.asn1.ASN1Enumerated.m42946a(r5);	 Catch:{ Exception -> 0x00d7 }
        r5 = org.spongycastle.asn1.x509.CRLReason.m40268a(r5);	 Catch:{ Exception -> 0x00d7 }
        r0.append(r5);	 Catch:{ Exception -> 0x00d7 }
        r0.append(r1);	 Catch:{ Exception -> 0x00d7 }
        goto L_0x0050;	 Catch:{ Exception -> 0x00d7 }
    L_0x009f:
        r5 = org.spongycastle.asn1.x509.X509Extension.f22067n;	 Catch:{ Exception -> 0x00d7 }
        r5 = r4.equals(r5);	 Catch:{ Exception -> 0x00d7 }
        if (r5 == 0) goto L_0x00bb;	 Catch:{ Exception -> 0x00d7 }
    L_0x00a7:
        r5 = "Certificate issuer: ";	 Catch:{ Exception -> 0x00d7 }
        r0.append(r5);	 Catch:{ Exception -> 0x00d7 }
        r5 = r7.m34595d();	 Catch:{ Exception -> 0x00d7 }
        r5 = org.spongycastle.asn1.x509.GeneralNames.m40346a(r5);	 Catch:{ Exception -> 0x00d7 }
        r0.append(r5);	 Catch:{ Exception -> 0x00d7 }
        r0.append(r1);	 Catch:{ Exception -> 0x00d7 }
        goto L_0x0050;	 Catch:{ Exception -> 0x00d7 }
    L_0x00bb:
        r5 = r4.m42986b();	 Catch:{ Exception -> 0x00d7 }
        r0.append(r5);	 Catch:{ Exception -> 0x00d7 }
        r5 = " value = ";	 Catch:{ Exception -> 0x00d7 }
        r0.append(r5);	 Catch:{ Exception -> 0x00d7 }
        r5 = r7.m34595d();	 Catch:{ Exception -> 0x00d7 }
        r5 = org.spongycastle.asn1.util.ASN1Dump.m27217a(r5);	 Catch:{ Exception -> 0x00d7 }
        r0.append(r5);	 Catch:{ Exception -> 0x00d7 }
        r0.append(r1);	 Catch:{ Exception -> 0x00d7 }
        goto L_0x0050;
    L_0x00d7:
        r4 = r4.m42986b();
        r0.append(r4);
        r4 = " value = ";
        r0.append(r4);
        r4 = "*****";
        r0.append(r4);
        r0.append(r1);
        goto L_0x0050;
    L_0x00ed:
        r0.append(r1);
        goto L_0x0050;
    L_0x00f2:
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.X509CRLEntryObject.toString():java.lang.String");
    }
}
