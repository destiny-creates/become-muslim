package org.spongycastle.jce.provider;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.cert.CRLSelector;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.style.RFC4519Style;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.PKIXCRLStore;
import org.spongycastle.jcajce.PKIXCRLStoreSelector.Builder;
import org.spongycastle.jcajce.PKIXCertStore;
import org.spongycastle.jcajce.PKIXCertStoreSelector;
import org.spongycastle.jcajce.PKIXExtendedParameters;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.util.Store;
import org.spongycastle.x509.X509AttributeCertificate;

class CertPathValidatorUtilities {
    /* renamed from: a */
    protected static final PKIXCRLUtil f22952a = new PKIXCRLUtil();
    /* renamed from: b */
    protected static final String f22953b = Extension.f31293q.m42986b();
    /* renamed from: c */
    protected static final String f22954c = Extension.f31283g.m42986b();
    /* renamed from: d */
    protected static final String f22955d = Extension.f31294r.m42986b();
    /* renamed from: e */
    protected static final String f22956e = Extension.f31281e.m42986b();
    /* renamed from: f */
    protected static final String f22957f = Extension.f31291o.m42986b();
    /* renamed from: g */
    protected static final String f22958g = Extension.f31279c.m42986b();
    /* renamed from: h */
    protected static final String f22959h = Extension.f31299w.m42986b();
    /* renamed from: i */
    protected static final String f22960i = Extension.f31289m.m42986b();
    /* renamed from: j */
    protected static final String f22961j = Extension.f31288l.m42986b();
    /* renamed from: k */
    protected static final String f22962k = Extension.f31296t.m42986b();
    /* renamed from: l */
    protected static final String f22963l = Extension.f31298v.m42986b();
    /* renamed from: m */
    protected static final String f22964m = Extension.f31292p.m42986b();
    /* renamed from: n */
    protected static final String f22965n = Extension.f31295s.m42986b();
    /* renamed from: o */
    protected static final String f22966o = Extension.f31284h.m42986b();
    /* renamed from: p */
    protected static final String[] f22967p = new String[]{"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    CertPathValidatorUtilities() {
    }

    /* renamed from: a */
    protected static java.security.cert.TrustAnchor m28144a(java.security.cert.X509Certificate r7, java.util.Set r8, java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.security.cert.X509CertSelector;
        r0.<init>();
        r1 = org.spongycastle.jce.provider.PrincipalUtils.m28239a(r7);
        r2 = r1.mo6822f();	 Catch:{ IOException -> 0x0074 }
        r0.setSubject(r2);	 Catch:{ IOException -> 0x0074 }
        r8 = r8.iterator();
        r2 = 0;
        r3 = r2;
        r4 = r3;
        r5 = r4;
    L_0x0018:
        r6 = r8.hasNext();
        if (r6 == 0) goto L_0x0066;
    L_0x001e:
        if (r3 != 0) goto L_0x0066;
    L_0x0020:
        r3 = r8.next();
        r3 = (java.security.cert.TrustAnchor) r3;
        r6 = r3.getTrustedCert();
        if (r6 == 0) goto L_0x0041;
    L_0x002c:
        r6 = r3.getTrustedCert();
        r6 = r0.match(r6);
        if (r6 == 0) goto L_0x003f;
    L_0x0036:
        r5 = r3.getTrustedCert();
        r5 = r5.getPublicKey();
        goto L_0x005c;
    L_0x003f:
        r3 = r2;
        goto L_0x005c;
    L_0x0041:
        r6 = r3.getCAName();
        if (r6 == 0) goto L_0x003f;
    L_0x0047:
        r6 = r3.getCAPublicKey();
        if (r6 == 0) goto L_0x003f;
    L_0x004d:
        r6 = org.spongycastle.jce.provider.PrincipalUtils.m28240a(r3);	 Catch:{ IllegalArgumentException -> 0x003f }
        r6 = r1.equals(r6);	 Catch:{ IllegalArgumentException -> 0x003f }
        if (r6 == 0) goto L_0x003f;	 Catch:{ IllegalArgumentException -> 0x003f }
    L_0x0057:
        r6 = r3.getCAPublicKey();	 Catch:{ IllegalArgumentException -> 0x003f }
        r5 = r6;
    L_0x005c:
        if (r5 == 0) goto L_0x0018;
    L_0x005e:
        m28158a(r7, r5, r9);	 Catch:{ Exception -> 0x0062 }
        goto L_0x0018;
    L_0x0062:
        r4 = move-exception;
        r3 = r2;
        r5 = r3;
        goto L_0x0018;
    L_0x0066:
        if (r3 != 0) goto L_0x0073;
    L_0x0068:
        if (r4 != 0) goto L_0x006b;
    L_0x006a:
        goto L_0x0073;
    L_0x006b:
        r7 = new org.spongycastle.jce.provider.AnnotatedException;
        r8 = "TrustAnchor found but certificate validation failed.";
        r7.<init>(r8, r4);
        throw r7;
    L_0x0073:
        return r3;
    L_0x0074:
        r7 = move-exception;
        r8 = new org.spongycastle.jce.provider.AnnotatedException;
        r9 = "Cannot set subject search criteria for trust anchor.";
        r8.<init>(r9, r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.CertPathValidatorUtilities.a(java.security.cert.X509Certificate, java.util.Set, java.lang.String):java.security.cert.TrustAnchor");
    }

    /* renamed from: a */
    static List<PKIXCertStore> m28150a(byte[] bArr, Map<GeneralName, PKIXCertStore> map) {
        if (bArr == null) {
            return Collections.EMPTY_LIST;
        }
        bArr = GeneralNames.m40346a(ASN1OctetString.m42990a((Object) bArr).mo6859c()).m40348a();
        List<PKIXCertStore> arrayList = new ArrayList();
        for (int i = 0; i != bArr.length; i++) {
            PKIXCertStore pKIXCertStore = (PKIXCertStore) map.get(bArr[i]);
            if (pKIXCertStore != null) {
                arrayList.add(pKIXCertStore);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    protected static Date m28147a(PKIXExtendedParameters pKIXExtendedParameters) {
        pKIXExtendedParameters = pKIXExtendedParameters.m27943e();
        return pKIXExtendedParameters == null ? new Date() : pKIXExtendedParameters;
    }

    /* renamed from: a */
    protected static boolean m28165a(X509Certificate x509Certificate) {
        return x509Certificate.getSubjectDN().equals(x509Certificate.getIssuerDN());
    }

    /* renamed from: a */
    protected static ASN1Primitive m28155a(X509Extension x509Extension, String str) {
        byte[] extensionValue = x509Extension.getExtensionValue(str);
        if (extensionValue == null) {
            return null;
        }
        return m28154a(str, extensionValue);
    }

    /* renamed from: a */
    private static ASN1Primitive m28154a(String str, byte[] bArr) {
        try {
            return new ASN1InputStream(((ASN1OctetString) new ASN1InputStream(bArr).m34595d()).mo6859c()).m34595d();
        } catch (byte[] bArr2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("exception processing extension ");
            stringBuilder.append(str);
            throw new AnnotatedException(stringBuilder.toString(), bArr2);
        }
    }

    /* renamed from: a */
    protected static AlgorithmIdentifier m28156a(PublicKey publicKey) {
        try {
            return SubjectPublicKeyInfo.m40409a(new ASN1InputStream(publicKey.getEncoded()).m34595d()).m40410a();
        } catch (PublicKey publicKey2) {
            throw new ExtCertPathValidatorException("Subject public key cannot be decoded.", publicKey2);
        }
    }

    /* renamed from: a */
    protected static final Set m28152a(ASN1Sequence aSN1Sequence) {
        Set hashSet = new HashSet();
        if (aSN1Sequence == null) {
            return hashSet;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
        aSN1Sequence = aSN1Sequence.mo6861c();
        while (aSN1Sequence.hasMoreElements()) {
            try {
                aSN1OutputStream.mo5713a((ASN1Encodable) aSN1Sequence.nextElement());
                hashSet.add(new PolicyQualifierInfo(byteArrayOutputStream.toByteArray()));
                byteArrayOutputStream.reset();
            } catch (ASN1Sequence aSN1Sequence2) {
                throw new ExtCertPathValidatorException("Policy qualifier info cannot be decoded.", aSN1Sequence2);
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    protected static PKIXPolicyNode m28157a(PKIXPolicyNode pKIXPolicyNode, List[] listArr, PKIXPolicyNode pKIXPolicyNode2) {
        PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) pKIXPolicyNode2.getParent();
        if (pKIXPolicyNode == null) {
            return null;
        }
        if (pKIXPolicyNode3 == null) {
            for (pKIXPolicyNode = null; pKIXPolicyNode < listArr.length; pKIXPolicyNode++) {
                listArr[pKIXPolicyNode] = new ArrayList();
            }
            return null;
        }
        pKIXPolicyNode3.m28237b(pKIXPolicyNode2);
        m28162a(listArr, pKIXPolicyNode2);
        return pKIXPolicyNode;
    }

    /* renamed from: a */
    private static void m28162a(List[] listArr, PKIXPolicyNode pKIXPolicyNode) {
        listArr[pKIXPolicyNode.getDepth()].remove(pKIXPolicyNode);
        if (pKIXPolicyNode.m28235a()) {
            pKIXPolicyNode = pKIXPolicyNode.getChildren();
            while (pKIXPolicyNode.hasNext()) {
                m28162a(listArr, (PKIXPolicyNode) pKIXPolicyNode.next());
            }
        }
    }

    /* renamed from: a */
    protected static boolean m28163a(int i, List[] listArr, ASN1ObjectIdentifier aSN1ObjectIdentifier, Set set) {
        List list = listArr[i - 1];
        for (int i2 = 0; i2 < list.size(); i2++) {
            PKIXPolicyNode pKIXPolicyNode = (PKIXPolicyNode) list.get(i2);
            if (pKIXPolicyNode.getExpectedPolicies().contains(aSN1ObjectIdentifier.m42986b())) {
                Set hashSet = new HashSet();
                hashSet.add(aSN1ObjectIdentifier.m42986b());
                PKIXPolicyNode pKIXPolicyNode2 = new PKIXPolicyNode(new ArrayList(), i, hashSet, pKIXPolicyNode, set, aSN1ObjectIdentifier.m42986b(), false);
                pKIXPolicyNode.m28233a(pKIXPolicyNode2);
                listArr[i].add(pKIXPolicyNode2);
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    protected static void m28167b(int i, List[] listArr, ASN1ObjectIdentifier aSN1ObjectIdentifier, Set set) {
        List list = listArr[i - 1];
        for (int i2 = 0; i2 < list.size(); i2++) {
            PKIXPolicyNode pKIXPolicyNode = (PKIXPolicyNode) list.get(i2);
            if ("2.5.29.32.0".equals(pKIXPolicyNode.getValidPolicy())) {
                Set hashSet = new HashSet();
                hashSet.add(aSN1ObjectIdentifier.m42986b());
                PKIXPolicyNode pKIXPolicyNode2 = new PKIXPolicyNode(new ArrayList(), i, hashSet, pKIXPolicyNode, set, aSN1ObjectIdentifier.m42986b(), false);
                pKIXPolicyNode.m28233a(pKIXPolicyNode2);
                listArr[i].add(pKIXPolicyNode2);
                return;
            }
        }
    }

    /* renamed from: a */
    protected static boolean m28166a(Set set) {
        if (!(set == null || set.contains("2.5.29.32.0"))) {
            if (set.isEmpty() == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    protected static Collection m28146a(PKIXCertStoreSelector pKIXCertStoreSelector, List list) {
        Collection linkedHashSet = new LinkedHashSet();
        for (Object next : list) {
            if (next instanceof Store) {
                try {
                    linkedHashSet.addAll(((Store) next).mo5936a(pKIXCertStoreSelector));
                } catch (PKIXCertStoreSelector pKIXCertStoreSelector2) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", pKIXCertStoreSelector2);
                }
            }
            try {
                linkedHashSet.addAll(PKIXCertStoreSelector.m35978a(pKIXCertStoreSelector2, (CertStore) next));
            } catch (PKIXCertStoreSelector pKIXCertStoreSelector22) {
                throw new AnnotatedException("Problem while picking certificates from certificate store.", pKIXCertStoreSelector22);
            }
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    static List<PKIXCRLStore> m28149a(CRLDistPoint cRLDistPoint, Map<GeneralName, PKIXCRLStore> map) {
        if (cRLDistPoint == null) {
            return Collections.EMPTY_LIST;
        }
        try {
            cRLDistPoint = cRLDistPoint.m40263a();
            List<PKIXCRLStore> arrayList = new ArrayList();
            for (DistributionPoint a : cRLDistPoint) {
                DistributionPointName a2 = a.m40312a();
                if (a2 != null && a2.m40319a() == 0) {
                    GeneralName[] a3 = GeneralNames.m40346a(a2.m40320b()).m40348a();
                    for (Object obj : a3) {
                        PKIXCRLStore pKIXCRLStore = (PKIXCRLStore) map.get(obj);
                        if (pKIXCRLStore != null) {
                            arrayList.add(pKIXCRLStore);
                        }
                    }
                }
            }
            return arrayList;
        } catch (CRLDistPoint cRLDistPoint2) {
            throw new AnnotatedException("Distribution points could not be read.", cRLDistPoint2);
        }
    }

    /* renamed from: a */
    protected static void m28161a(DistributionPoint distributionPoint, Collection collection, X509CRLSelector x509CRLSelector) {
        List<X500Name> arrayList = new ArrayList();
        if (distributionPoint.m40314c() != null) {
            distributionPoint = distributionPoint.m40314c().m40348a();
            for (collection = null; collection < distributionPoint.length; collection++) {
                if (distributionPoint[collection].m40343a() == 4) {
                    try {
                        arrayList.add(X500Name.m40212a(distributionPoint[collection].m40344b().mo5709e().mo6822f()));
                    } catch (DistributionPoint distributionPoint2) {
                        throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", distributionPoint2);
                    }
                }
            }
        } else if (distributionPoint2.m40312a() != null) {
            for (Collection collection2 : collection2) {
                arrayList.add(collection2);
            }
        } else {
            throw new AnnotatedException("CRL issuer is omitted from distribution point but no distributionPoint field present.");
        }
        for (X500Name f : arrayList) {
            try {
                x509CRLSelector.addIssuerName(f.mo6822f());
            } catch (DistributionPoint distributionPoint22) {
                throw new AnnotatedException("Cannot decode CRL issuer information.", distributionPoint22);
            }
        }
    }

    /* renamed from: a */
    private static BigInteger m28142a(Object obj) {
        return ((X509Certificate) obj).getSerialNumber();
    }

    /* renamed from: a */
    protected static void m28159a(Date date, X509CRL x509crl, Object obj, CertStatus certStatus) {
        try {
            X509Extension revokedCertificate;
            if (X509CRLObject.m28298a(x509crl)) {
                revokedCertificate = x509crl.getRevokedCertificate(m28142a(obj));
                if (revokedCertificate != null) {
                    X500Principal certificateIssuer = revokedCertificate.getCertificateIssuer();
                    if (certificateIssuer == null) {
                        x509crl = PrincipalUtils.m28241a(x509crl);
                    } else {
                        x509crl = X500Name.m40212a(certificateIssuer.getEncoded());
                    }
                    if (PrincipalUtils.m28239a(obj).equals(x509crl) == null) {
                        return;
                    }
                }
                return;
            } else if (PrincipalUtils.m28239a(obj).equals(PrincipalUtils.m28241a(x509crl))) {
                revokedCertificate = x509crl.getRevokedCertificate(m28142a(obj));
                if (revokedCertificate == null) {
                    return;
                }
            } else {
                return;
            }
            x509crl = null;
            if (revokedCertificate.hasExtensions() != null) {
                try {
                    x509crl = ASN1Enumerated.m42946a(m28155a(revokedCertificate, Extension.f31285i.m42986b()));
                } catch (Date date2) {
                    throw new AnnotatedException("Reason code CRL entry extension could not be decoded.", date2);
                }
            }
            if (date2.getTime() >= revokedCertificate.getRevocationDate().getTime() || x509crl == null || x509crl.m42951b().intValue() == null || x509crl.m42951b().intValue() == 1 || x509crl.m42951b().intValue() == 2 || x509crl.m42951b().intValue() == 8) {
                if (x509crl != null) {
                    certStatus.m28169a(x509crl.m42951b().intValue());
                } else {
                    certStatus.m28169a((int) null);
                }
                certStatus.m28170a(revokedCertificate.getRevocationDate());
            }
        } catch (Date date22) {
            throw new AnnotatedException("Failed check for indirect CRL.", date22);
        }
    }

    /* renamed from: a */
    protected static Set m28151a(Date date, X509CRL x509crl, List<CertStore> list, List<PKIXCRLStore> list2) {
        CRLSelector x509CRLSelector = new X509CRLSelector();
        try {
            x509CRLSelector.addIssuerName(PrincipalUtils.m28241a(x509crl).mo6822f());
            try {
                Object a = m28155a((X509Extension) x509crl, f22966o);
                BigInteger bigInteger = null;
                BigInteger c = a != null ? ASN1Integer.m42963a(a).m42969c() : null;
                try {
                    byte[] extensionValue = x509crl.getExtensionValue(f22960i);
                    if (c != null) {
                        bigInteger = c.add(BigInteger.valueOf(1));
                    }
                    x509CRLSelector.setMinCRLNumber(bigInteger);
                    Builder builder = new Builder(x509CRLSelector);
                    builder.m27899a(extensionValue);
                    builder.m27900b(true);
                    builder.m27898a(c);
                    Date<X509CRL> a2 = f22952a.m28179a(builder.m27897a(), date, list, list2);
                    x509crl = new HashSet();
                    for (X509CRL x509crl2 : a2) {
                        if (m28164a(x509crl2) != null) {
                            x509crl.add(x509crl2);
                        }
                    }
                    return x509crl;
                } catch (Date date2) {
                    throw new AnnotatedException("Issuing distribution point extension value could not be read.", date2);
                }
            } catch (Date date22) {
                throw new AnnotatedException("CRL number extension could not be extracted from CRL.", date22);
            }
        } catch (Date date222) {
            throw new AnnotatedException("Cannot extract issuer from CRL.", date222);
        }
    }

    /* renamed from: a */
    private static boolean m28164a(X509CRL x509crl) {
        x509crl = x509crl.getCriticalExtensionOIDs();
        if (x509crl == null) {
            return null;
        }
        return x509crl.contains(RFC3280CertPathUtilities.f23013f);
    }

    /* renamed from: a */
    protected static Set m28153a(DistributionPoint distributionPoint, Object obj, Date date, PKIXExtendedParameters pKIXExtendedParameters) {
        X509CRLSelector x509CRLSelector = new X509CRLSelector();
        try {
            Collection hashSet = new HashSet();
            hashSet.add(PrincipalUtils.m28239a(obj));
            m28161a(distributionPoint, hashSet, x509CRLSelector);
            if ((obj instanceof X509Certificate) != null) {
                x509CRLSelector.setCertificateChecking((X509Certificate) obj);
            }
            distributionPoint = new Builder(x509CRLSelector).m27896a(true).m27897a();
            if (pKIXExtendedParameters.m27943e() != null) {
                date = pKIXExtendedParameters.m27943e();
            }
            Set a = f22952a.m28179a(distributionPoint, date, pKIXExtendedParameters.m27954p(), pKIXExtendedParameters.m27941c());
            m28160a(a, obj);
            return a;
        } catch (DistributionPoint distributionPoint2) {
            throw new AnnotatedException("Could not get issuer information from distribution point.", distributionPoint2);
        }
    }

    /* renamed from: a */
    protected static java.util.Date m28148a(org.spongycastle.jcajce.PKIXExtendedParameters r2, java.security.cert.CertPath r3, int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r2.m27945g();
        r1 = 1;
        if (r0 != r1) goto L_0x006e;
    L_0x0007:
        if (r4 > 0) goto L_0x000e;
    L_0x0009:
        r2 = m28147a(r2);
        return r2;
    L_0x000e:
        r4 = r4 - r1;
        if (r4 != 0) goto L_0x005f;
    L_0x0011:
        r2 = 0;
        r0 = r3.getCertificates();	 Catch:{ IOException -> 0x0057, IllegalArgumentException -> 0x004f }
        r0 = r0.get(r4);	 Catch:{ IOException -> 0x0057, IllegalArgumentException -> 0x004f }
        r0 = (java.security.cert.X509Certificate) r0;	 Catch:{ IOException -> 0x0057, IllegalArgumentException -> 0x004f }
        r1 = org.spongycastle.asn1.isismtt.ISISMTTObjectIdentifiers.f21699e;	 Catch:{ IOException -> 0x0057, IllegalArgumentException -> 0x004f }
        r1 = r1.m42986b();	 Catch:{ IOException -> 0x0057, IllegalArgumentException -> 0x004f }
        r0 = r0.getExtensionValue(r1);	 Catch:{ IOException -> 0x0057, IllegalArgumentException -> 0x004f }
        if (r0 == 0) goto L_0x0030;	 Catch:{ IOException -> 0x0057, IllegalArgumentException -> 0x004f }
    L_0x0028:
        r2 = org.spongycastle.asn1.ASN1Primitive.m39798b(r0);	 Catch:{ IOException -> 0x0057, IllegalArgumentException -> 0x004f }
        r2 = org.spongycastle.asn1.ASN1GeneralizedTime.m42954a(r2);	 Catch:{ IOException -> 0x0057, IllegalArgumentException -> 0x004f }
    L_0x0030:
        if (r2 == 0) goto L_0x0040;
    L_0x0032:
        r2 = r2.m42961c();	 Catch:{ ParseException -> 0x0037 }
        return r2;
    L_0x0037:
        r2 = move-exception;
        r3 = new org.spongycastle.jce.provider.AnnotatedException;
        r4 = "Date from date of cert gen extension could not be parsed.";
        r3.<init>(r4, r2);
        throw r3;
    L_0x0040:
        r2 = r3.getCertificates();
        r2 = r2.get(r4);
        r2 = (java.security.cert.X509Certificate) r2;
        r2 = r2.getNotBefore();
        return r2;
    L_0x004f:
        r2 = new org.spongycastle.jce.provider.AnnotatedException;
        r3 = "Date of cert gen extension could not be read.";
        r2.<init>(r3);
        throw r2;
    L_0x0057:
        r2 = new org.spongycastle.jce.provider.AnnotatedException;
        r3 = "Date of cert gen extension could not be read.";
        r2.<init>(r3);
        throw r2;
    L_0x005f:
        r2 = r3.getCertificates();
        r2 = r2.get(r4);
        r2 = (java.security.cert.X509Certificate) r2;
        r2 = r2.getNotBefore();
        return r2;
    L_0x006e:
        r2 = m28147a(r2);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.CertPathValidatorUtilities.a(org.spongycastle.jcajce.PKIXExtendedParameters, java.security.cert.CertPath, int):java.util.Date");
    }

    /* renamed from: a */
    protected static PublicKey m28143a(List list, int i, JcaJceHelper jcaJceHelper) {
        PublicKey publicKey = ((Certificate) list.get(i)).getPublicKey();
        if (!(publicKey instanceof DSAPublicKey)) {
            return publicKey;
        }
        DSAPublicKey dSAPublicKey = (DSAPublicKey) publicKey;
        if (dSAPublicKey.getParams() != null) {
            return dSAPublicKey;
        }
        while (true) {
            i++;
            if (i < list.size()) {
                PublicKey publicKey2 = ((X509Certificate) list.get(i)).getPublicKey();
                if (publicKey2 instanceof DSAPublicKey) {
                    DSAPublicKey dSAPublicKey2 = (DSAPublicKey) publicKey2;
                    if (dSAPublicKey2.getParams() != null) {
                        list = dSAPublicKey2.getParams();
                        try {
                            return jcaJceHelper.mo5879d("DSA").generatePublic(new DSAPublicKeySpec(dSAPublicKey.getY(), list.getP(), list.getQ(), list.getG()));
                        } catch (List list2) {
                            throw new RuntimeException(list2.getMessage());
                        }
                    }
                } else {
                    throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
                }
            }
            throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
        }
    }

    /* renamed from: a */
    static java.util.Collection m28145a(java.security.cert.X509Certificate r2, java.util.List<java.security.cert.CertStore> r3, java.util.List<org.spongycastle.jcajce.PKIXCertStore> r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.security.cert.X509CertSelector;
        r0.<init>();
        r1 = org.spongycastle.jce.provider.PrincipalUtils.m28243b(r2);	 Catch:{ IOException -> 0x0075 }
        r1 = r1.mo6822f();	 Catch:{ IOException -> 0x0075 }
        r0.setSubject(r1);	 Catch:{ IOException -> 0x0075 }
        r1 = f22965n;	 Catch:{ Exception -> 0x0036 }
        r2 = r2.getExtensionValue(r1);	 Catch:{ Exception -> 0x0036 }
        if (r2 == 0) goto L_0x0036;	 Catch:{ Exception -> 0x0036 }
    L_0x0018:
        r2 = org.spongycastle.asn1.ASN1OctetString.m42990a(r2);	 Catch:{ Exception -> 0x0036 }
        r2 = r2.mo6859c();	 Catch:{ Exception -> 0x0036 }
        r2 = org.spongycastle.asn1.x509.AuthorityKeyIdentifier.m40255a(r2);	 Catch:{ Exception -> 0x0036 }
        r2 = r2.m40256a();	 Catch:{ Exception -> 0x0036 }
        if (r2 == 0) goto L_0x0036;	 Catch:{ Exception -> 0x0036 }
    L_0x002a:
        r1 = new org.spongycastle.asn1.DEROctetString;	 Catch:{ Exception -> 0x0036 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0036 }
        r2 = r1.mo6822f();	 Catch:{ Exception -> 0x0036 }
        r0.setSubjectKeyIdentifier(r2);	 Catch:{ Exception -> 0x0036 }
    L_0x0036:
        r2 = new org.spongycastle.jcajce.PKIXCertStoreSelector$Builder;
        r2.<init>(r0);
        r2 = r2.m27901a();
        r0 = new java.util.LinkedHashSet;
        r0.<init>();
        r1 = new java.util.ArrayList;	 Catch:{ AnnotatedException -> 0x006c }
        r1.<init>();	 Catch:{ AnnotatedException -> 0x006c }
        r3 = m28146a(r2, r3);	 Catch:{ AnnotatedException -> 0x006c }
        r1.addAll(r3);	 Catch:{ AnnotatedException -> 0x006c }
        r2 = m28146a(r2, r4);	 Catch:{ AnnotatedException -> 0x006c }
        r1.addAll(r2);	 Catch:{ AnnotatedException -> 0x006c }
        r2 = r1.iterator();	 Catch:{ AnnotatedException -> 0x006c }
    L_0x005b:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x006b;
    L_0x0061:
        r3 = r2.next();
        r3 = (java.security.cert.X509Certificate) r3;
        r0.add(r3);
        goto L_0x005b;
    L_0x006b:
        return r0;
    L_0x006c:
        r2 = move-exception;
        r3 = new org.spongycastle.jce.provider.AnnotatedException;
        r4 = "Issuer certificate cannot be searched.";
        r3.<init>(r4, r2);
        throw r3;
    L_0x0075:
        r2 = move-exception;
        r3 = new org.spongycastle.jce.provider.AnnotatedException;
        r4 = "Subject criteria for certificate selector to find issuer certificate could not be set.";
        r3.<init>(r4, r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.CertPathValidatorUtilities.a(java.security.cert.X509Certificate, java.util.List, java.util.List):java.util.Collection");
    }

    /* renamed from: a */
    protected static void m28158a(X509Certificate x509Certificate, PublicKey publicKey, String str) {
        if (str == null) {
            x509Certificate.verify(publicKey);
        } else {
            x509Certificate.verify(publicKey, str);
        }
    }

    /* renamed from: a */
    static void m28160a(Set set, Object obj) {
        if (set.isEmpty() == null) {
            return;
        }
        if ((obj instanceof X509AttributeCertificate) != null) {
            X509AttributeCertificate x509AttributeCertificate = (X509AttributeCertificate) obj;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No CRLs found for issuer \"");
            stringBuilder.append(x509AttributeCertificate.mo5947d().m36618a()[0]);
            stringBuilder.append("\"");
            throw new AnnotatedException(stringBuilder.toString());
        }
        X509Certificate x509Certificate = (X509Certificate) obj;
        stringBuilder = new StringBuilder();
        stringBuilder.append("No CRLs found for issuer \"");
        stringBuilder.append(RFC4519Style.f31181R.mo6442b(PrincipalUtils.m28243b(x509Certificate)));
        stringBuilder.append("\"");
        throw new AnnotatedException(stringBuilder.toString());
    }
}
