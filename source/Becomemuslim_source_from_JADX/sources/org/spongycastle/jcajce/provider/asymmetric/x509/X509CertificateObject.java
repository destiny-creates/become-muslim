package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.BasicConstraints;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

class X509CertificateObject extends X509Certificate implements PKCS12BagAttributeCarrier {
    /* renamed from: a */
    private JcaJceHelper f27439a;
    /* renamed from: b */
    private Certificate f27440b;
    /* renamed from: c */
    private BasicConstraints f27441c;
    /* renamed from: d */
    private boolean[] f27442d;
    /* renamed from: e */
    private boolean f27443e;
    /* renamed from: f */
    private int f27444f;
    /* renamed from: g */
    private PKCS12BagAttributeCarrier f27445g = new PKCS12BagAttributeCarrierImpl();

    public X509CertificateObject(JcaJceHelper jcaJceHelper, Certificate certificate) {
        StringBuilder stringBuilder;
        this.f27439a = jcaJceHelper;
        this.f27440b = certificate;
        try {
            jcaJceHelper = m36027a("2.5.29.19");
            if (jcaJceHelper != null) {
                this.f27441c = BasicConstraints.m40258a(ASN1Primitive.m39798b(jcaJceHelper));
            }
            try {
                jcaJceHelper = m36027a("2.5.29.15");
                if (jcaJceHelper != null) {
                    jcaJceHelper = DERBitString.m43051a(ASN1Primitive.m39798b(jcaJceHelper));
                    certificate = jcaJceHelper.m43059c();
                    int length = (certificate.length * 8) - jcaJceHelper.m43061g();
                    jcaJceHelper = 9;
                    if (length >= 9) {
                        jcaJceHelper = length;
                    }
                    this.f27442d = new boolean[jcaJceHelper];
                    for (int i = 0; i != length; i++) {
                        this.f27442d[i] = (certificate[i / 8] & (128 >>> (i % 8))) != 0;
                    }
                    return;
                }
                this.f27442d = null;
            } catch (JcaJceHelper jcaJceHelper2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("cannot construct KeyUsage: ");
                stringBuilder.append(jcaJceHelper2);
                throw new CertificateParsingException(stringBuilder.toString());
            }
        } catch (JcaJceHelper jcaJceHelper22) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("cannot construct BasicConstraints: ");
            stringBuilder.append(jcaJceHelper22);
            throw new CertificateParsingException(stringBuilder.toString());
        }
    }

    public void checkValidity() {
        checkValidity(new Date());
    }

    public void checkValidity(Date date) {
        StringBuilder stringBuilder;
        if (date.getTime() > getNotAfter().getTime()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("certificate expired on ");
            stringBuilder.append(this.f27440b.m40280h().m40458a());
            throw new CertificateExpiredException(stringBuilder.toString());
        } else if (date.getTime() < getNotBefore().getTime()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("certificate not valid till ");
            stringBuilder.append(this.f27440b.m40279g().m40458a());
            throw new CertificateNotYetValidException(stringBuilder.toString());
        }
    }

    public int getVersion() {
        return this.f27440b.m40275b();
    }

    public BigInteger getSerialNumber() {
        return this.f27440b.m40276c().m42968b();
    }

    public java.security.Principal getIssuerDN() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new org.spongycastle.jce.X509Principal;	 Catch:{ IOException -> 0x0014 }
        r1 = r2.f27440b;	 Catch:{ IOException -> 0x0014 }
        r1 = r1.m40277d();	 Catch:{ IOException -> 0x0014 }
        r1 = r1.mo6822f();	 Catch:{ IOException -> 0x0014 }
        r1 = org.spongycastle.asn1.x500.X500Name.m40212a(r1);	 Catch:{ IOException -> 0x0014 }
        r0.<init>(r1);	 Catch:{ IOException -> 0x0014 }
        return r0;
    L_0x0014:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.getIssuerDN():java.security.Principal");
    }

    public javax.security.auth.x500.X500Principal getIssuerX500Principal() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x001d }
        r0.<init>();	 Catch:{ IOException -> 0x001d }
        r1 = new org.spongycastle.asn1.ASN1OutputStream;	 Catch:{ IOException -> 0x001d }
        r1.<init>(r0);	 Catch:{ IOException -> 0x001d }
        r2 = r3.f27440b;	 Catch:{ IOException -> 0x001d }
        r2 = r2.m40277d();	 Catch:{ IOException -> 0x001d }
        r1.mo5713a(r2);	 Catch:{ IOException -> 0x001d }
        r1 = new javax.security.auth.x500.X500Principal;	 Catch:{ IOException -> 0x001d }
        r0 = r0.toByteArray();	 Catch:{ IOException -> 0x001d }
        r1.<init>(r0);	 Catch:{ IOException -> 0x001d }
        return r1;
    L_0x001d:
        r0 = new java.lang.IllegalStateException;
        r1 = "can't encode issuer DN";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.getIssuerX500Principal():javax.security.auth.x500.X500Principal");
    }

    public Principal getSubjectDN() {
        return new X509Principal(X500Name.m40212a(this.f27440b.m40281i().mo5709e()));
    }

    public javax.security.auth.x500.X500Principal getSubjectX500Principal() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x001d }
        r0.<init>();	 Catch:{ IOException -> 0x001d }
        r1 = new org.spongycastle.asn1.ASN1OutputStream;	 Catch:{ IOException -> 0x001d }
        r1.<init>(r0);	 Catch:{ IOException -> 0x001d }
        r2 = r3.f27440b;	 Catch:{ IOException -> 0x001d }
        r2 = r2.m40281i();	 Catch:{ IOException -> 0x001d }
        r1.mo5713a(r2);	 Catch:{ IOException -> 0x001d }
        r1 = new javax.security.auth.x500.X500Principal;	 Catch:{ IOException -> 0x001d }
        r0 = r0.toByteArray();	 Catch:{ IOException -> 0x001d }
        r1.<init>(r0);	 Catch:{ IOException -> 0x001d }
        return r1;
    L_0x001d:
        r0 = new java.lang.IllegalStateException;
        r1 = "can't encode issuer DN";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.getSubjectX500Principal():javax.security.auth.x500.X500Principal");
    }

    public Date getNotBefore() {
        return this.f27440b.m40279g().m40459b();
    }

    public Date getNotAfter() {
        return this.f27440b.m40280h().m40459b();
    }

    public byte[] getTBSCertificate() {
        try {
            return this.f27440b.m40274a().m34596a("DER");
        } catch (IOException e) {
            throw new CertificateEncodingException(e.toString());
        }
    }

    public byte[] getSignature() {
        return this.f27440b.m40284l().m43059c();
    }

    public String getSigAlgName() {
        return X509SignatureUtil.m28041a(this.f27440b.m40283k());
    }

    public String getSigAlgOID() {
        return this.f27440b.m40283k().m40230a().m42986b();
    }

    public byte[] getSigAlgParams() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.f27440b;
        r0 = r0.m40283k();
        r0 = r0.m40231b();
        r1 = 0;
        if (r0 == 0) goto L_0x0023;
    L_0x000d:
        r0 = r3.f27440b;	 Catch:{ IOException -> 0x0022 }
        r0 = r0.m40283k();	 Catch:{ IOException -> 0x0022 }
        r0 = r0.m40231b();	 Catch:{ IOException -> 0x0022 }
        r0 = r0.mo5709e();	 Catch:{ IOException -> 0x0022 }
        r2 = "DER";	 Catch:{ IOException -> 0x0022 }
        r0 = r0.m34596a(r2);	 Catch:{ IOException -> 0x0022 }
        return r0;
    L_0x0022:
        return r1;
    L_0x0023:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.getSigAlgParams():byte[]");
    }

    public boolean[] getIssuerUniqueID() {
        DERBitString k = this.f27440b.m40274a().m40440k();
        if (k == null) {
            return null;
        }
        byte[] c = k.m43059c();
        boolean[] zArr = new boolean[((c.length * 8) - k.m43061g())];
        for (int i = 0; i != zArr.length; i++) {
            zArr[i] = (c[i / 8] & (128 >>> (i % 8))) != 0;
        }
        return zArr;
    }

    public boolean[] getSubjectUniqueID() {
        DERBitString l = this.f27440b.m40274a().m40441l();
        if (l == null) {
            return null;
        }
        byte[] c = l.m43059c();
        boolean[] zArr = new boolean[((c.length * 8) - l.m43061g())];
        for (int i = 0; i != zArr.length; i++) {
            zArr[i] = (c[i / 8] & (128 >>> (i % 8))) != 0;
        }
        return zArr;
    }

    public boolean[] getKeyUsage() {
        return this.f27442d;
    }

    public java.util.List getExtendedKeyUsage() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = "2.5.29.37";
        r0 = r4.m36027a(r0);
        if (r0 == 0) goto L_0x003c;
    L_0x0008:
        r1 = new org.spongycastle.asn1.ASN1InputStream;	 Catch:{ Exception -> 0x0034 }
        r1.<init>(r0);	 Catch:{ Exception -> 0x0034 }
        r0 = r1.m34595d();	 Catch:{ Exception -> 0x0034 }
        r0 = (org.spongycastle.asn1.ASN1Sequence) r0;	 Catch:{ Exception -> 0x0034 }
        r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0034 }
        r1.<init>();	 Catch:{ Exception -> 0x0034 }
        r2 = 0;	 Catch:{ Exception -> 0x0034 }
    L_0x0019:
        r3 = r0.mo6862g();	 Catch:{ Exception -> 0x0034 }
        if (r2 == r3) goto L_0x002f;	 Catch:{ Exception -> 0x0034 }
    L_0x001f:
        r3 = r0.mo6860a(r2);	 Catch:{ Exception -> 0x0034 }
        r3 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r3;	 Catch:{ Exception -> 0x0034 }
        r3 = r3.m42986b();	 Catch:{ Exception -> 0x0034 }
        r1.add(r3);	 Catch:{ Exception -> 0x0034 }
        r2 = r2 + 1;	 Catch:{ Exception -> 0x0034 }
        goto L_0x0019;	 Catch:{ Exception -> 0x0034 }
    L_0x002f:
        r0 = java.util.Collections.unmodifiableList(r1);	 Catch:{ Exception -> 0x0034 }
        return r0;
    L_0x0034:
        r0 = new java.security.cert.CertificateParsingException;
        r1 = "error processing extended key usage extension";
        r0.<init>(r1);
        throw r0;
    L_0x003c:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.getExtendedKeyUsage():java.util.List");
    }

    public int getBasicConstraints() {
        if (this.f27441c == null || !this.f27441c.m40259a()) {
            return -1;
        }
        if (this.f27441c.m40260b() == null) {
            return Integer.MAX_VALUE;
        }
        return this.f27441c.m40260b().intValue();
    }

    public Collection getSubjectAlternativeNames() {
        return m36024a(m36027a(Extension.f31281e.m42986b()));
    }

    public Collection getIssuerAlternativeNames() {
        return m36024a(m36027a(Extension.f31282f.m42986b()));
    }

    public Set getCriticalExtensionOIDs() {
        if (getVersion() == 3) {
            Set hashSet = new HashSet();
            Extensions m = this.f27440b.m40274a().m40442m();
            if (m != null) {
                Enumeration a = m.m40331a();
                while (a.hasMoreElements()) {
                    ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) a.nextElement();
                    if (m.m40332a(aSN1ObjectIdentifier).m40326b()) {
                        hashSet.add(aSN1ObjectIdentifier.m42986b());
                    }
                }
                return hashSet;
            }
        }
        return null;
    }

    /* renamed from: a */
    private byte[] m36027a(String str) {
        Extensions m = this.f27440b.m40274a().m40442m();
        if (m != null) {
            str = m.m40332a(new ASN1ObjectIdentifier(str));
            if (str != null) {
                return str.m40327c().mo6859c();
            }
        }
        return null;
    }

    public byte[] getExtensionValue(String str) {
        Extensions m = this.f27440b.m40274a().m40442m();
        if (m != null) {
            str = m.m40332a(new ASN1ObjectIdentifier(str));
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

    public Set getNonCriticalExtensionOIDs() {
        if (getVersion() == 3) {
            Set hashSet = new HashSet();
            Extensions m = this.f27440b.m40274a().m40442m();
            if (m != null) {
                Enumeration a = m.m40331a();
                while (a.hasMoreElements()) {
                    ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) a.nextElement();
                    if (!m.m40332a(aSN1ObjectIdentifier).m40326b()) {
                        hashSet.add(aSN1ObjectIdentifier.m42986b());
                    }
                }
                return hashSet;
            }
        }
        return null;
    }

    public boolean hasUnsupportedCriticalExtension() {
        if (getVersion() == 3) {
            Extensions m = this.f27440b.m40274a().m40442m();
            if (m != null) {
                Enumeration a = m.m40331a();
                while (a.hasMoreElements()) {
                    ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) a.nextElement();
                    if (!(aSN1ObjectIdentifier.equals(Extension.f31279c) || aSN1ObjectIdentifier.equals(Extension.f31293q) || aSN1ObjectIdentifier.equals(Extension.f31294r) || aSN1ObjectIdentifier.equals(Extension.f31299w) || aSN1ObjectIdentifier.equals(Extension.f31292p) || aSN1ObjectIdentifier.equals(Extension.f31289m) || aSN1ObjectIdentifier.equals(Extension.f31288l) || aSN1ObjectIdentifier.equals(Extension.f31296t) || aSN1ObjectIdentifier.equals(Extension.f31283g) || aSN1ObjectIdentifier.equals(Extension.f31281e))) {
                        if (!aSN1ObjectIdentifier.equals(Extension.f31291o)) {
                            if (m.m40332a(aSN1ObjectIdentifier).m40326b()) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public java.security.PublicKey getPublicKey() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.f27440b;	 Catch:{ IOException -> 0x000b }
        r0 = r0.m40282j();	 Catch:{ IOException -> 0x000b }
        r0 = org.spongycastle.jce.provider.BouncyCastleProvider.m36189a(r0);	 Catch:{ IOException -> 0x000b }
        return r0;
    L_0x000b:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.getPublicKey():java.security.PublicKey");
    }

    public byte[] getEncoded() {
        try {
            return this.f27440b.m34596a("DER");
        } catch (IOException e) {
            throw new CertificateEncodingException(e.toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509CertificateObject)) {
            return super.equals(obj);
        }
        X509CertificateObject x509CertificateObject = (X509CertificateObject) obj;
        if (this.f27443e && x509CertificateObject.f27443e && this.f27444f != x509CertificateObject.f27444f) {
            return null;
        }
        return this.f27440b.equals(x509CertificateObject.f27440b);
    }

    public synchronized int hashCode() {
        if (!this.f27443e) {
            this.f27444f = super.hashCode();
            this.f27443e = true;
        }
        return this.f27444f;
    }

    /* renamed from: a */
    public void mo5851a(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f27445g.mo5851a(aSN1ObjectIdentifier, aSN1Encodable);
    }

    /* renamed from: a */
    public ASN1Encodable mo5850a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.f27445g.mo5850a(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public Enumeration mo5849a() {
        return this.f27445g.mo5849a();
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
        r2 = "  [0]         Version: ";
        r0.append(r2);
        r2 = r8.getVersion();
        r0.append(r2);
        r0.append(r1);
        r2 = "         SerialNumber: ";
        r0.append(r2);
        r2 = r8.getSerialNumber();
        r0.append(r2);
        r0.append(r1);
        r2 = "             IssuerDN: ";
        r0.append(r2);
        r2 = r8.getIssuerDN();
        r0.append(r2);
        r0.append(r1);
        r2 = "           Start Date: ";
        r0.append(r2);
        r2 = r8.getNotBefore();
        r0.append(r2);
        r0.append(r1);
        r2 = "           Final Date: ";
        r0.append(r2);
        r2 = r8.getNotAfter();
        r0.append(r2);
        r0.append(r1);
        r2 = "            SubjectDN: ";
        r0.append(r2);
        r2 = r8.getSubjectDN();
        r0.append(r2);
        r0.append(r1);
        r2 = "           Public Key: ";
        r0.append(r2);
        r2 = r8.getPublicKey();
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
    L_0x009e:
        r5 = r2.length;
        if (r3 >= r5) goto L_0x00d3;
    L_0x00a1:
        r5 = r2.length;
        r5 = r5 - r4;
        if (r3 >= r5) goto L_0x00ba;
    L_0x00a5:
        r5 = "                       ";
        r0.append(r5);
        r5 = new java.lang.String;
        r6 = org.spongycastle.util.encoders.Hex.m29438a(r2, r3, r4);
        r5.<init>(r6);
        r0.append(r5);
        r0.append(r1);
        goto L_0x00d0;
    L_0x00ba:
        r5 = "                       ";
        r0.append(r5);
        r5 = new java.lang.String;
        r6 = r2.length;
        r6 = r6 - r3;
        r6 = org.spongycastle.util.encoders.Hex.m29438a(r2, r3, r6);
        r5.<init>(r6);
        r0.append(r5);
        r0.append(r1);
    L_0x00d0:
        r3 = r3 + 20;
        goto L_0x009e;
    L_0x00d3:
        r2 = r8.f27440b;
        r2 = r2.m40274a();
        r2 = r2.m40442m();
        if (r2 == 0) goto L_0x01d7;
    L_0x00df:
        r3 = r2.m40331a();
        r4 = r3.hasMoreElements();
        if (r4 == 0) goto L_0x00ee;
    L_0x00e9:
        r4 = "       Extensions: \n";
        r0.append(r4);
    L_0x00ee:
        r4 = r3.hasMoreElements();
        if (r4 == 0) goto L_0x01d7;
    L_0x00f4:
        r4 = r3.nextElement();
        r4 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r4;
        r5 = r2.m40332a(r4);
        r6 = r5.m40327c();
        if (r6 == 0) goto L_0x01d2;
    L_0x0104:
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
        r5 = org.spongycastle.asn1.x509.Extension.f31283g;	 Catch:{ Exception -> 0x01bc }
        r5 = r4.equals(r5);	 Catch:{ Exception -> 0x01bc }
        if (r5 == 0) goto L_0x0139;	 Catch:{ Exception -> 0x01bc }
    L_0x012a:
        r5 = r7.m34595d();	 Catch:{ Exception -> 0x01bc }
        r5 = org.spongycastle.asn1.x509.BasicConstraints.m40258a(r5);	 Catch:{ Exception -> 0x01bc }
        r0.append(r5);	 Catch:{ Exception -> 0x01bc }
        r0.append(r1);	 Catch:{ Exception -> 0x01bc }
        goto L_0x00ee;	 Catch:{ Exception -> 0x01bc }
    L_0x0139:
        r5 = org.spongycastle.asn1.x509.Extension.f31279c;	 Catch:{ Exception -> 0x01bc }
        r5 = r4.equals(r5);	 Catch:{ Exception -> 0x01bc }
        if (r5 == 0) goto L_0x0150;	 Catch:{ Exception -> 0x01bc }
    L_0x0141:
        r5 = r7.m34595d();	 Catch:{ Exception -> 0x01bc }
        r5 = org.spongycastle.asn1.x509.KeyUsage.m40375a(r5);	 Catch:{ Exception -> 0x01bc }
        r0.append(r5);	 Catch:{ Exception -> 0x01bc }
        r0.append(r1);	 Catch:{ Exception -> 0x01bc }
        goto L_0x00ee;	 Catch:{ Exception -> 0x01bc }
    L_0x0150:
        r5 = org.spongycastle.asn1.misc.MiscObjectIdentifiers.f21738b;	 Catch:{ Exception -> 0x01bc }
        r5 = r4.equals(r5);	 Catch:{ Exception -> 0x01bc }
        if (r5 == 0) goto L_0x016a;	 Catch:{ Exception -> 0x01bc }
    L_0x0158:
        r5 = new org.spongycastle.asn1.misc.NetscapeCertType;	 Catch:{ Exception -> 0x01bc }
        r6 = r7.m34595d();	 Catch:{ Exception -> 0x01bc }
        r6 = (org.spongycastle.asn1.DERBitString) r6;	 Catch:{ Exception -> 0x01bc }
        r5.<init>(r6);	 Catch:{ Exception -> 0x01bc }
        r0.append(r5);	 Catch:{ Exception -> 0x01bc }
        r0.append(r1);	 Catch:{ Exception -> 0x01bc }
        goto L_0x00ee;	 Catch:{ Exception -> 0x01bc }
    L_0x016a:
        r5 = org.spongycastle.asn1.misc.MiscObjectIdentifiers.f21740d;	 Catch:{ Exception -> 0x01bc }
        r5 = r4.equals(r5);	 Catch:{ Exception -> 0x01bc }
        if (r5 == 0) goto L_0x0185;	 Catch:{ Exception -> 0x01bc }
    L_0x0172:
        r5 = new org.spongycastle.asn1.misc.NetscapeRevocationURL;	 Catch:{ Exception -> 0x01bc }
        r6 = r7.m34595d();	 Catch:{ Exception -> 0x01bc }
        r6 = (org.spongycastle.asn1.DERIA5String) r6;	 Catch:{ Exception -> 0x01bc }
        r5.<init>(r6);	 Catch:{ Exception -> 0x01bc }
        r0.append(r5);	 Catch:{ Exception -> 0x01bc }
        r0.append(r1);	 Catch:{ Exception -> 0x01bc }
        goto L_0x00ee;	 Catch:{ Exception -> 0x01bc }
    L_0x0185:
        r5 = org.spongycastle.asn1.misc.MiscObjectIdentifiers.f21747k;	 Catch:{ Exception -> 0x01bc }
        r5 = r4.equals(r5);	 Catch:{ Exception -> 0x01bc }
        if (r5 == 0) goto L_0x01a0;	 Catch:{ Exception -> 0x01bc }
    L_0x018d:
        r5 = new org.spongycastle.asn1.misc.VerisignCzagExtension;	 Catch:{ Exception -> 0x01bc }
        r6 = r7.m34595d();	 Catch:{ Exception -> 0x01bc }
        r6 = (org.spongycastle.asn1.DERIA5String) r6;	 Catch:{ Exception -> 0x01bc }
        r5.<init>(r6);	 Catch:{ Exception -> 0x01bc }
        r0.append(r5);	 Catch:{ Exception -> 0x01bc }
        r0.append(r1);	 Catch:{ Exception -> 0x01bc }
        goto L_0x00ee;	 Catch:{ Exception -> 0x01bc }
    L_0x01a0:
        r5 = r4.m42986b();	 Catch:{ Exception -> 0x01bc }
        r0.append(r5);	 Catch:{ Exception -> 0x01bc }
        r5 = " value = ";	 Catch:{ Exception -> 0x01bc }
        r0.append(r5);	 Catch:{ Exception -> 0x01bc }
        r5 = r7.m34595d();	 Catch:{ Exception -> 0x01bc }
        r5 = org.spongycastle.asn1.util.ASN1Dump.m27217a(r5);	 Catch:{ Exception -> 0x01bc }
        r0.append(r5);	 Catch:{ Exception -> 0x01bc }
        r0.append(r1);	 Catch:{ Exception -> 0x01bc }
        goto L_0x00ee;
    L_0x01bc:
        r4 = r4.m42986b();
        r0.append(r4);
        r4 = " value = ";
        r0.append(r4);
        r4 = "*****";
        r0.append(r4);
        r0.append(r1);
        goto L_0x00ee;
    L_0x01d2:
        r0.append(r1);
        goto L_0x00ee;
    L_0x01d7:
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.toString():java.lang.String");
    }

    public final void verify(java.security.PublicKey r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.f27440b;
        r0 = r0.m40283k();
        r0 = org.spongycastle.jcajce.provider.asymmetric.x509.X509SignatureUtil.m28041a(r0);
        r1 = r2.f27439a;	 Catch:{ Exception -> 0x0011 }
        r1 = r1.mo5881f(r0);	 Catch:{ Exception -> 0x0011 }
        goto L_0x0015;
    L_0x0011:
        r1 = java.security.Signature.getInstance(r0);
    L_0x0015:
        r2.m36025a(r3, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.verify(java.security.PublicKey):void");
    }

    public final void verify(PublicKey publicKey, String str) {
        Signature instance;
        String a = X509SignatureUtil.m28041a(this.f27440b.m40283k());
        if (str != null) {
            instance = Signature.getInstance(a, str);
        } else {
            instance = Signature.getInstance(a);
        }
        m36025a(publicKey, instance);
    }

    public final void verify(PublicKey publicKey, Provider provider) {
        Signature instance;
        String a = X509SignatureUtil.m28041a(this.f27440b.m40283k());
        if (provider != null) {
            instance = Signature.getInstance(a, provider);
        } else {
            instance = Signature.getInstance(a);
        }
        m36025a(publicKey, instance);
    }

    /* renamed from: a */
    private void m36025a(PublicKey publicKey, Signature signature) {
        if (m36026a(this.f27440b.m40283k(), this.f27440b.m40274a().m40433c())) {
            X509SignatureUtil.m28042a(signature, this.f27440b.m40283k().m40231b());
            signature.initVerify(publicKey);
            signature.update(getTBSCertificate());
            if (signature.verify(getSignature()) == null) {
                throw new SignatureException("certificate does not verify with supplied key");
            }
            return;
        }
        throw new CertificateException("signature algorithm in TBS cert not same as outer cert");
    }

    /* renamed from: a */
    private boolean m36026a(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        if (!algorithmIdentifier.m40230a().equals(algorithmIdentifier2.m40230a())) {
            return false;
        }
        if (algorithmIdentifier.m40231b() == null) {
            if (algorithmIdentifier2.m40231b() == null || algorithmIdentifier2.m40231b().equals(DERNull.f32850a) != null) {
                return true;
            }
            return false;
        } else if (algorithmIdentifier2.m40231b() != null) {
            return algorithmIdentifier.m40231b().equals(algorithmIdentifier2.m40231b());
        } else {
            if (algorithmIdentifier.m40231b() == null || algorithmIdentifier.m40231b().equals(DERNull.f32850a) != null) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: a */
    private static java.util.Collection m36024a(byte[] r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00b5 }
        r1.<init>();	 Catch:{ Exception -> 0x00b5 }
        r5 = org.spongycastle.asn1.ASN1Sequence.m43000a(r5);	 Catch:{ Exception -> 0x00b5 }
        r5 = r5.mo6861c();	 Catch:{ Exception -> 0x00b5 }
    L_0x0011:
        r2 = r5.hasMoreElements();	 Catch:{ Exception -> 0x00b5 }
        if (r2 == 0) goto L_0x00a9;	 Catch:{ Exception -> 0x00b5 }
    L_0x0017:
        r2 = r5.nextElement();	 Catch:{ Exception -> 0x00b5 }
        r2 = org.spongycastle.asn1.x509.GeneralName.m40335a(r2);	 Catch:{ Exception -> 0x00b5 }
        r3 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00b5 }
        r3.<init>();	 Catch:{ Exception -> 0x00b5 }
        r4 = r2.m40343a();	 Catch:{ Exception -> 0x00b5 }
        r4 = org.spongycastle.util.Integers.m29396a(r4);	 Catch:{ Exception -> 0x00b5 }
        r3.add(r4);	 Catch:{ Exception -> 0x00b5 }
        r4 = r2.m40343a();	 Catch:{ Exception -> 0x00b5 }
        switch(r4) {
            case 0: goto L_0x0081;
            case 1: goto L_0x0073;
            case 2: goto L_0x0073;
            case 3: goto L_0x0081;
            case 4: goto L_0x0061;
            case 5: goto L_0x0081;
            case 6: goto L_0x0073;
            case 7: goto L_0x0049;
            case 8: goto L_0x0039;
            default: goto L_0x0036;
        };	 Catch:{ Exception -> 0x00b5 }
    L_0x0036:
        r5 = new java.io.IOException;	 Catch:{ Exception -> 0x00b5 }
        goto L_0x0090;	 Catch:{ Exception -> 0x00b5 }
    L_0x0039:
        r2 = r2.m40344b();	 Catch:{ Exception -> 0x00b5 }
        r2 = org.spongycastle.asn1.ASN1ObjectIdentifier.m42973a(r2);	 Catch:{ Exception -> 0x00b5 }
        r2 = r2.m42986b();	 Catch:{ Exception -> 0x00b5 }
        r3.add(r2);	 Catch:{ Exception -> 0x00b5 }
        goto L_0x0088;	 Catch:{ Exception -> 0x00b5 }
    L_0x0049:
        r2 = r2.m40344b();	 Catch:{ Exception -> 0x00b5 }
        r2 = org.spongycastle.asn1.ASN1OctetString.m42990a(r2);	 Catch:{ Exception -> 0x00b5 }
        r2 = r2.mo6859c();	 Catch:{ Exception -> 0x00b5 }
        r2 = java.net.InetAddress.getByAddress(r2);	 Catch:{ UnknownHostException -> 0x0011 }
        r2 = r2.getHostAddress();	 Catch:{ UnknownHostException -> 0x0011 }
        r3.add(r2);	 Catch:{ Exception -> 0x00b5 }
        goto L_0x0088;	 Catch:{ Exception -> 0x00b5 }
    L_0x0061:
        r4 = org.spongycastle.asn1.x500.style.RFC4519Style.f31181R;	 Catch:{ Exception -> 0x00b5 }
        r2 = r2.m40344b();	 Catch:{ Exception -> 0x00b5 }
        r2 = org.spongycastle.asn1.x500.X500Name.m40214a(r4, r2);	 Catch:{ Exception -> 0x00b5 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00b5 }
        r3.add(r2);	 Catch:{ Exception -> 0x00b5 }
        goto L_0x0088;	 Catch:{ Exception -> 0x00b5 }
    L_0x0073:
        r2 = r2.m40344b();	 Catch:{ Exception -> 0x00b5 }
        r2 = (org.spongycastle.asn1.ASN1String) r2;	 Catch:{ Exception -> 0x00b5 }
        r2 = r2.mo6440b();	 Catch:{ Exception -> 0x00b5 }
        r3.add(r2);	 Catch:{ Exception -> 0x00b5 }
        goto L_0x0088;	 Catch:{ Exception -> 0x00b5 }
    L_0x0081:
        r2 = r2.mo6822f();	 Catch:{ Exception -> 0x00b5 }
        r3.add(r2);	 Catch:{ Exception -> 0x00b5 }
    L_0x0088:
        r2 = java.util.Collections.unmodifiableList(r3);	 Catch:{ Exception -> 0x00b5 }
        r1.add(r2);	 Catch:{ Exception -> 0x00b5 }
        goto L_0x0011;	 Catch:{ Exception -> 0x00b5 }
    L_0x0090:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b5 }
        r0.<init>();	 Catch:{ Exception -> 0x00b5 }
        r1 = "Bad tag number: ";	 Catch:{ Exception -> 0x00b5 }
        r0.append(r1);	 Catch:{ Exception -> 0x00b5 }
        r1 = r2.m40343a();	 Catch:{ Exception -> 0x00b5 }
        r0.append(r1);	 Catch:{ Exception -> 0x00b5 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00b5 }
        r5.<init>(r0);	 Catch:{ Exception -> 0x00b5 }
        throw r5;	 Catch:{ Exception -> 0x00b5 }
    L_0x00a9:
        r5 = r1.size();	 Catch:{ Exception -> 0x00b5 }
        if (r5 != 0) goto L_0x00b0;	 Catch:{ Exception -> 0x00b5 }
    L_0x00af:
        return r0;	 Catch:{ Exception -> 0x00b5 }
    L_0x00b0:
        r5 = java.util.Collections.unmodifiableCollection(r1);	 Catch:{ Exception -> 0x00b5 }
        return r5;
    L_0x00b5:
        r5 = move-exception;
        r0 = new java.security.cert.CertificateParsingException;
        r5 = r5.getMessage();
        r0.<init>(r5);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.a(byte[]):java.util.Collection");
    }
}
