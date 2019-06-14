package org.spongycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.IssuingDistributionPoint;
import org.spongycastle.asn1.x509.TBSCertList.CRLEntry;
import org.spongycastle.jce.X509Principal;

public class X509CRLObject extends X509CRL {
    /* renamed from: a */
    private CertificateList f23034a;
    /* renamed from: b */
    private String f23035b;
    /* renamed from: c */
    private byte[] f23036c;
    /* renamed from: d */
    private boolean f23037d;
    /* renamed from: e */
    private boolean f23038e = false;
    /* renamed from: f */
    private int f23039f;

    /* renamed from: a */
    public static boolean m28298a(X509CRL x509crl) {
        try {
            Object extensionValue = x509crl.getExtensionValue(Extension.f31289m.m42986b());
            return (extensionValue == null || IssuingDistributionPoint.m40365a(ASN1OctetString.m42990a(extensionValue).mo6859c()).m40369c() == null) ? null : true;
        } catch (X509CRL x509crl2) {
            throw new ExtCRLException("Exception reading IssuingDistributionPoint", x509crl2);
        }
    }

    public X509CRLObject(CertificateList certificateList) {
        this.f23034a = certificateList;
        try {
            this.f23035b = X509SignatureUtil.m28307a(certificateList.m40288c());
            if (certificateList.m40288c().m40231b() != null) {
                this.f23036c = certificateList.m40288c().m40231b().mo5709e().m34596a("DER");
            } else {
                this.f23036c = null;
            }
            this.f23037d = m28298a((X509CRL) this);
        } catch (CertificateList certificateList2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CRL contents invalid: ");
            stringBuilder.append(certificateList2);
            throw new CRLException(stringBuilder.toString());
        }
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        if (criticalExtensionOIDs == null) {
            return false;
        }
        criticalExtensionOIDs.remove(RFC3280CertPathUtilities.f23011d);
        criticalExtensionOIDs.remove(RFC3280CertPathUtilities.f23013f);
        return criticalExtensionOIDs.isEmpty() ^ 1;
    }

    /* renamed from: a */
    private Set m28296a(boolean z) {
        if (getVersion() == 2) {
            Extensions i = this.f23034a.m40286a().m40429i();
            if (i != null) {
                Set hashSet = new HashSet();
                Enumeration a = i.m40331a();
                while (a.hasMoreElements()) {
                    ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) a.nextElement();
                    if (z == i.m40332a(aSN1ObjectIdentifier).m40326b()) {
                        hashSet.add(aSN1ObjectIdentifier.m42986b());
                    }
                }
                return hashSet;
            }
        }
        return false;
    }

    public Set getCriticalExtensionOIDs() {
        return m28296a(true);
    }

    public Set getNonCriticalExtensionOIDs() {
        return m28296a(false);
    }

    public byte[] getExtensionValue(String str) {
        Extensions i = this.f23034a.m40286a().m40429i();
        if (i != null) {
            str = i.m40332a(new ASN1ObjectIdentifier(str));
            if (str != null) {
                try {
                    return str.m40327c().mo6822f();
                } catch (String str2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("error parsing ");
                    stringBuilder.append(str2.toString());
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
        }
        return null;
    }

    public byte[] getEncoded() {
        try {
            return this.f23034a.m34596a("DER");
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    public void verify(java.security.PublicKey r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.getSigAlgName();	 Catch:{ Exception -> 0x000b }
        r1 = "SC";	 Catch:{ Exception -> 0x000b }
        r0 = java.security.Signature.getInstance(r0, r1);	 Catch:{ Exception -> 0x000b }
        goto L_0x0013;
    L_0x000b:
        r0 = r2.getSigAlgName();
        r0 = java.security.Signature.getInstance(r0);
    L_0x0013:
        r2.m28297a(r3, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.X509CRLObject.verify(java.security.PublicKey):void");
    }

    public void verify(PublicKey publicKey, String str) {
        if (str != null) {
            str = Signature.getInstance(getSigAlgName(), str);
        } else {
            str = Signature.getInstance(getSigAlgName());
        }
        m28297a(publicKey, str);
    }

    public void verify(PublicKey publicKey, Provider provider) {
        if (provider != null) {
            provider = Signature.getInstance(getSigAlgName(), provider);
        } else {
            provider = Signature.getInstance(getSigAlgName());
        }
        m28297a(publicKey, provider);
    }

    /* renamed from: a */
    private void m28297a(PublicKey publicKey, Signature signature) {
        if (this.f23034a.m40288c().equals(this.f23034a.m40286a().m40423b())) {
            signature.initVerify(publicKey);
            signature.update(getTBSCertList());
            if (signature.verify(getSignature()) == null) {
                throw new SignatureException("CRL does not verify with supplied public key.");
            }
            return;
        }
        throw new CRLException("Signature algorithm on CertificateList does not match TBSCertList.");
    }

    public int getVersion() {
        return this.f23034a.m40291g();
    }

    public Principal getIssuerDN() {
        return new X509Principal(X500Name.m40212a(this.f23034a.m40292h().mo5709e()));
    }

    public javax.security.auth.x500.X500Principal getIssuerX500Principal() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new javax.security.auth.x500.X500Principal;	 Catch:{ IOException -> 0x0010 }
        r1 = r2.f23034a;	 Catch:{ IOException -> 0x0010 }
        r1 = r1.m40292h();	 Catch:{ IOException -> 0x0010 }
        r1 = r1.mo6822f();	 Catch:{ IOException -> 0x0010 }
        r0.<init>(r1);	 Catch:{ IOException -> 0x0010 }
        return r0;
    L_0x0010:
        r0 = new java.lang.IllegalStateException;
        r1 = "can't encode issuer DN";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.X509CRLObject.getIssuerX500Principal():javax.security.auth.x500.X500Principal");
    }

    public Date getThisUpdate() {
        return this.f23034a.m40293i().m40459b();
    }

    public Date getNextUpdate() {
        return this.f23034a.m40294j() != null ? this.f23034a.m40294j().m40459b() : null;
    }

    /* renamed from: a */
    private Set m28295a() {
        Set hashSet = new HashSet();
        Enumeration b = this.f23034a.m40287b();
        X500Name x500Name = null;
        while (b.hasMoreElements()) {
            CRLEntry cRLEntry = (CRLEntry) b.nextElement();
            hashSet.add(new X509CRLEntryObject(cRLEntry, this.f23037d, x500Name));
            if (this.f23037d && cRLEntry.m40419d()) {
                Extension a = cRLEntry.m40418c().m40332a(Extension.f31290n);
                if (a != null) {
                    x500Name = X500Name.m40212a(GeneralNames.m40346a(a.m40328d()).m40348a()[0].m40344b());
                }
            }
        }
        return hashSet;
    }

    public X509CRLEntry getRevokedCertificate(BigInteger bigInteger) {
        Enumeration b = this.f23034a.m40287b();
        X500Name x500Name = null;
        while (b.hasMoreElements()) {
            CRLEntry cRLEntry = (CRLEntry) b.nextElement();
            if (bigInteger.equals(cRLEntry.m40416a().m42968b())) {
                return new X509CRLEntryObject(cRLEntry, this.f23037d, x500Name);
            }
            if (this.f23037d && cRLEntry.m40419d()) {
                Extension a = cRLEntry.m40418c().m40332a(Extension.f31290n);
                if (a != null) {
                    x500Name = X500Name.m40212a(GeneralNames.m40346a(a.m40328d()).m40348a()[0].m40344b());
                }
            }
        }
        return null;
    }

    public Set getRevokedCertificates() {
        Set a = m28295a();
        return !a.isEmpty() ? Collections.unmodifiableSet(a) : null;
    }

    public byte[] getTBSCertList() {
        try {
            return this.f23034a.m40286a().m34596a("DER");
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    public byte[] getSignature() {
        return this.f23034a.m40289d().m43059c();
    }

    public String getSigAlgName() {
        return this.f23035b;
    }

    public String getSigAlgOID() {
        return this.f23034a.m40288c().m40230a().m42986b();
    }

    public byte[] getSigAlgParams() {
        if (this.f23036c == null) {
            return null;
        }
        Object obj = new byte[this.f23036c.length];
        System.arraycopy(this.f23036c, 0, obj, 0, obj.length);
        return obj;
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
        r2 = "              Version: ";
        r0.append(r2);
        r2 = r8.getVersion();
        r0.append(r2);
        r0.append(r1);
        r2 = "             IssuerDN: ";
        r0.append(r2);
        r2 = r8.getIssuerDN();
        r0.append(r2);
        r0.append(r1);
        r2 = "          This update: ";
        r0.append(r2);
        r2 = r8.getThisUpdate();
        r0.append(r2);
        r0.append(r1);
        r2 = "          Next update: ";
        r0.append(r2);
        r2 = r8.getNextUpdate();
        r0.append(r2);
        r0.append(r1);
        r2 = "  Signature Algorithm: ";
        r0.append(r2);
        r2 = r8.getSigAlgName();
        r0.append(r2);
        r0.append(r1);
        r2 = r8.getSignature();
        r3 = "            Signature: ";
        r0.append(r3);
        r3 = new java.lang.String;
        r4 = 20;
        r5 = 0;
        r5 = org.spongycastle.util.encoders.Hex.m29438a(r2, r5, r4);
        r3.<init>(r5);
        r0.append(r3);
        r0.append(r1);
        r3 = 20;
    L_0x0071:
        r5 = r2.length;
        if (r3 >= r5) goto L_0x00a6;
    L_0x0074:
        r5 = r2.length;
        r5 = r5 - r4;
        if (r3 >= r5) goto L_0x008d;
    L_0x0078:
        r5 = "                       ";
        r0.append(r5);
        r5 = new java.lang.String;
        r6 = org.spongycastle.util.encoders.Hex.m29438a(r2, r3, r4);
        r5.<init>(r6);
        r0.append(r5);
        r0.append(r1);
        goto L_0x00a3;
    L_0x008d:
        r5 = "                       ";
        r0.append(r5);
        r5 = new java.lang.String;
        r6 = r2.length;
        r6 = r6 - r3;
        r6 = org.spongycastle.util.encoders.Hex.m29438a(r2, r3, r6);
        r5.<init>(r6);
        r0.append(r5);
        r0.append(r1);
    L_0x00a3:
        r3 = r3 + 20;
        goto L_0x0071;
    L_0x00a6:
        r2 = r8.f23034a;
        r2 = r2.m40286a();
        r2 = r2.m40429i();
        if (r2 == 0) goto L_0x01c9;
    L_0x00b2:
        r3 = r2.m40331a();
        r4 = r3.hasMoreElements();
        if (r4 == 0) goto L_0x00c4;
    L_0x00bc:
        r4 = "           Extensions: ";
        r0.append(r4);
        r0.append(r1);
    L_0x00c4:
        r4 = r3.hasMoreElements();
        if (r4 == 0) goto L_0x01c9;
    L_0x00ca:
        r4 = r3.nextElement();
        r4 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r4;
        r5 = r2.m40332a(r4);
        r6 = r5.m40327c();
        if (r6 == 0) goto L_0x01c4;
    L_0x00da:
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
        r5 = org.spongycastle.asn1.x509.Extension.f31284h;	 Catch:{ Exception -> 0x01ae }
        r5 = r4.equals(r5);	 Catch:{ Exception -> 0x01ae }
        if (r5 == 0) goto L_0x0118;	 Catch:{ Exception -> 0x01ae }
    L_0x0100:
        r5 = new org.spongycastle.asn1.x509.CRLNumber;	 Catch:{ Exception -> 0x01ae }
        r6 = r7.m34595d();	 Catch:{ Exception -> 0x01ae }
        r6 = org.spongycastle.asn1.ASN1Integer.m42963a(r6);	 Catch:{ Exception -> 0x01ae }
        r6 = r6.m42969c();	 Catch:{ Exception -> 0x01ae }
        r5.<init>(r6);	 Catch:{ Exception -> 0x01ae }
        r0.append(r5);	 Catch:{ Exception -> 0x01ae }
        r0.append(r1);	 Catch:{ Exception -> 0x01ae }
        goto L_0x00c4;	 Catch:{ Exception -> 0x01ae }
    L_0x0118:
        r5 = org.spongycastle.asn1.x509.Extension.f31288l;	 Catch:{ Exception -> 0x01ae }
        r5 = r4.equals(r5);	 Catch:{ Exception -> 0x01ae }
        if (r5 == 0) goto L_0x014a;	 Catch:{ Exception -> 0x01ae }
    L_0x0120:
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01ae }
        r5.<init>();	 Catch:{ Exception -> 0x01ae }
        r6 = "Base CRL: ";	 Catch:{ Exception -> 0x01ae }
        r5.append(r6);	 Catch:{ Exception -> 0x01ae }
        r6 = new org.spongycastle.asn1.x509.CRLNumber;	 Catch:{ Exception -> 0x01ae }
        r7 = r7.m34595d();	 Catch:{ Exception -> 0x01ae }
        r7 = org.spongycastle.asn1.ASN1Integer.m42963a(r7);	 Catch:{ Exception -> 0x01ae }
        r7 = r7.m42969c();	 Catch:{ Exception -> 0x01ae }
        r6.<init>(r7);	 Catch:{ Exception -> 0x01ae }
        r5.append(r6);	 Catch:{ Exception -> 0x01ae }
        r5 = r5.toString();	 Catch:{ Exception -> 0x01ae }
        r0.append(r5);	 Catch:{ Exception -> 0x01ae }
        r0.append(r1);	 Catch:{ Exception -> 0x01ae }
        goto L_0x00c4;	 Catch:{ Exception -> 0x01ae }
    L_0x014a:
        r5 = org.spongycastle.asn1.x509.Extension.f31289m;	 Catch:{ Exception -> 0x01ae }
        r5 = r4.equals(r5);	 Catch:{ Exception -> 0x01ae }
        if (r5 == 0) goto L_0x0162;	 Catch:{ Exception -> 0x01ae }
    L_0x0152:
        r5 = r7.m34595d();	 Catch:{ Exception -> 0x01ae }
        r5 = org.spongycastle.asn1.x509.IssuingDistributionPoint.m40365a(r5);	 Catch:{ Exception -> 0x01ae }
        r0.append(r5);	 Catch:{ Exception -> 0x01ae }
        r0.append(r1);	 Catch:{ Exception -> 0x01ae }
        goto L_0x00c4;	 Catch:{ Exception -> 0x01ae }
    L_0x0162:
        r5 = org.spongycastle.asn1.x509.Extension.f31292p;	 Catch:{ Exception -> 0x01ae }
        r5 = r4.equals(r5);	 Catch:{ Exception -> 0x01ae }
        if (r5 == 0) goto L_0x017a;	 Catch:{ Exception -> 0x01ae }
    L_0x016a:
        r5 = r7.m34595d();	 Catch:{ Exception -> 0x01ae }
        r5 = org.spongycastle.asn1.x509.CRLDistPoint.m40262a(r5);	 Catch:{ Exception -> 0x01ae }
        r0.append(r5);	 Catch:{ Exception -> 0x01ae }
        r0.append(r1);	 Catch:{ Exception -> 0x01ae }
        goto L_0x00c4;	 Catch:{ Exception -> 0x01ae }
    L_0x017a:
        r5 = org.spongycastle.asn1.x509.Extension.f31298v;	 Catch:{ Exception -> 0x01ae }
        r5 = r4.equals(r5);	 Catch:{ Exception -> 0x01ae }
        if (r5 == 0) goto L_0x0192;	 Catch:{ Exception -> 0x01ae }
    L_0x0182:
        r5 = r7.m34595d();	 Catch:{ Exception -> 0x01ae }
        r5 = org.spongycastle.asn1.x509.CRLDistPoint.m40262a(r5);	 Catch:{ Exception -> 0x01ae }
        r0.append(r5);	 Catch:{ Exception -> 0x01ae }
        r0.append(r1);	 Catch:{ Exception -> 0x01ae }
        goto L_0x00c4;	 Catch:{ Exception -> 0x01ae }
    L_0x0192:
        r5 = r4.m42986b();	 Catch:{ Exception -> 0x01ae }
        r0.append(r5);	 Catch:{ Exception -> 0x01ae }
        r5 = " value = ";	 Catch:{ Exception -> 0x01ae }
        r0.append(r5);	 Catch:{ Exception -> 0x01ae }
        r5 = r7.m34595d();	 Catch:{ Exception -> 0x01ae }
        r5 = org.spongycastle.asn1.util.ASN1Dump.m27217a(r5);	 Catch:{ Exception -> 0x01ae }
        r0.append(r5);	 Catch:{ Exception -> 0x01ae }
        r0.append(r1);	 Catch:{ Exception -> 0x01ae }
        goto L_0x00c4;
    L_0x01ae:
        r4 = r4.m42986b();
        r0.append(r4);
        r4 = " value = ";
        r0.append(r4);
        r4 = "*****";
        r0.append(r4);
        r0.append(r1);
        goto L_0x00c4;
    L_0x01c4:
        r0.append(r1);
        goto L_0x00c4;
    L_0x01c9:
        r2 = r8.getRevokedCertificates();
        if (r2 == 0) goto L_0x01e4;
    L_0x01cf:
        r2 = r2.iterator();
    L_0x01d3:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x01e4;
    L_0x01d9:
        r3 = r2.next();
        r0.append(r3);
        r0.append(r1);
        goto L_0x01d3;
    L_0x01e4:
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.X509CRLObject.toString():java.lang.String");
    }

    public boolean isRevoked(java.security.cert.Certificate r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r9.getType();
        r1 = "X.509";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0099;
    L_0x000c:
        r0 = r8.f23034a;
        r0 = r0.m40287b();
        r1 = r8.f23034a;
        r1 = r1.m40292h();
        r2 = 0;
        if (r0 == 0) goto L_0x0098;
    L_0x001b:
        r3 = r9;
        r3 = (java.security.cert.X509Certificate) r3;
        r4 = r3.getSerialNumber();
    L_0x0022:
        r5 = r0.hasMoreElements();
        if (r5 == 0) goto L_0x0098;
    L_0x0028:
        r5 = r0.nextElement();
        r5 = org.spongycastle.asn1.x509.TBSCertList.CRLEntry.m40415a(r5);
        r6 = r8.f23037d;
        if (r6 == 0) goto L_0x005c;
    L_0x0034:
        r6 = r5.m40419d();
        if (r6 == 0) goto L_0x005c;
    L_0x003a:
        r6 = r5.m40418c();
        r7 = org.spongycastle.asn1.x509.Extension.f31290n;
        r6 = r6.m40332a(r7);
        if (r6 == 0) goto L_0x005c;
    L_0x0046:
        r1 = r6.m40328d();
        r1 = org.spongycastle.asn1.x509.GeneralNames.m40346a(r1);
        r1 = r1.m40348a();
        r1 = r1[r2];
        r1 = r1.m40344b();
        r1 = org.spongycastle.asn1.x500.X500Name.m40212a(r1);
    L_0x005c:
        r5 = r5.m40416a();
        r5 = r5.m42968b();
        r5 = r5.equals(r4);
        if (r5 == 0) goto L_0x0022;
    L_0x006a:
        r0 = r9 instanceof java.security.cert.X509Certificate;
        if (r0 == 0) goto L_0x007b;
    L_0x006e:
        r9 = r3.getIssuerX500Principal();
        r9 = r9.getEncoded();
        r9 = org.spongycastle.asn1.x500.X500Name.m40212a(r9);
        goto L_0x0087;
    L_0x007b:
        r9 = r9.getEncoded();	 Catch:{ CertificateEncodingException -> 0x0090 }
        r9 = org.spongycastle.asn1.x509.Certificate.m40272a(r9);	 Catch:{ CertificateEncodingException -> 0x0090 }
        r9 = r9.m40277d();	 Catch:{ CertificateEncodingException -> 0x0090 }
    L_0x0087:
        r9 = r1.equals(r9);
        if (r9 != 0) goto L_0x008e;
    L_0x008d:
        return r2;
    L_0x008e:
        r9 = 1;
        return r9;
    L_0x0090:
        r9 = new java.lang.RuntimeException;
        r0 = "Cannot process certificate";
        r9.<init>(r0);
        throw r9;
    L_0x0098:
        return r2;
    L_0x0099:
        r9 = new java.lang.RuntimeException;
        r0 = "X.509 CRL used with non X.509 Cert";
        r9.<init>(r0);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.X509CRLObject.isRevoked(java.security.cert.Certificate):boolean");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X509CRL)) {
            return false;
        }
        if (!(obj instanceof X509CRLObject)) {
            return super.equals(obj);
        }
        X509CRLObject x509CRLObject = (X509CRLObject) obj;
        if (this.f23038e && x509CRLObject.f23038e && x509CRLObject.f23039f != this.f23039f) {
            return false;
        }
        return this.f23034a.equals(x509CRLObject.f23034a);
    }

    public int hashCode() {
        if (!this.f23038e) {
            this.f23038e = true;
            this.f23039f = super.hashCode();
        }
        return this.f23039f;
    }
}
