package org.spongycastle.jce.provider;

import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertSelector;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.style.BCStyle;
import org.spongycastle.asn1.x509.BasicConstraints;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.GeneralSubtree;
import org.spongycastle.asn1.x509.IssuingDistributionPoint;
import org.spongycastle.asn1.x509.NameConstraints;
import org.spongycastle.asn1.x509.PolicyInformation;
import org.spongycastle.jcajce.PKIXCRLStore;
import org.spongycastle.jcajce.PKIXCertStoreSelector;
import org.spongycastle.jcajce.PKIXCertStoreSelector.Builder;
import org.spongycastle.jcajce.PKIXExtendedBuilderParameters;
import org.spongycastle.jcajce.PKIXExtendedParameters;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.util.Arrays;

class RFC3280CertPathUtilities {
    /* renamed from: a */
    public static final String f23008a = Extension.f31293q.m42986b();
    /* renamed from: b */
    public static final String f23009b = Extension.f31294r.m42986b();
    /* renamed from: c */
    public static final String f23010c = Extension.f31299w.m42986b();
    /* renamed from: d */
    public static final String f23011d = Extension.f31289m.m42986b();
    /* renamed from: e */
    public static final String f23012e = Extension.f31298v.m42986b();
    /* renamed from: f */
    public static final String f23013f = Extension.f31288l.m42986b();
    /* renamed from: g */
    public static final String f23014g = Extension.f31296t.m42986b();
    /* renamed from: h */
    public static final String f23015h = Extension.f31283g.m42986b();
    /* renamed from: i */
    public static final String f23016i = Extension.f31292p.m42986b();
    /* renamed from: j */
    public static final String f23017j = Extension.f31281e.m42986b();
    /* renamed from: k */
    public static final String f23018k = Extension.f31291o.m42986b();
    /* renamed from: l */
    public static final String f23019l = Extension.f31295s.m42986b();
    /* renamed from: m */
    public static final String f23020m = Extension.f31279c.m42986b();
    /* renamed from: n */
    public static final String f23021n = Extension.f31284h.m42986b();
    /* renamed from: o */
    protected static final String[] f23022o = new String[]{"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};
    /* renamed from: p */
    private static final PKIXCRLUtil f23023p = new PKIXCRLUtil();

    RFC3280CertPathUtilities() {
    }

    /* renamed from: a */
    protected static void m28263a(DistributionPoint distributionPoint, Object obj, X509CRL x509crl) {
        try {
            Object a = IssuingDistributionPoint.m40365a(CertPathValidatorUtilities.m28155a((X509Extension) x509crl, f23011d));
            if (a != null) {
                if (a.m40372g() != null) {
                    DistributionPointName g = IssuingDistributionPoint.m40365a(a).m40372g();
                    List arrayList = new ArrayList();
                    int i = 0;
                    if (g.m40319a() == 0) {
                        GeneralName[] a2 = GeneralNames.m40346a(g.m40320b()).m40348a();
                        for (Object add : a2) {
                            arrayList.add(add);
                        }
                    }
                    if (g.m40319a() == 1) {
                        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                        try {
                            x509crl = ASN1Sequence.m43000a(PrincipalUtils.m28241a(x509crl)).mo6861c();
                            while (x509crl.hasMoreElements()) {
                                aSN1EncodableVector.m27141a((ASN1Encodable) x509crl.nextElement());
                            }
                            aSN1EncodableVector.m27141a(g.m40320b());
                            arrayList.add(new GeneralName(X500Name.m40212a(new DERSequence(aSN1EncodableVector))));
                        } catch (DistributionPoint distributionPoint2) {
                            throw new AnnotatedException("Could not read CRL issuer.", distributionPoint2);
                        }
                    }
                    if (distributionPoint2.m40312a() != null) {
                        x509crl = distributionPoint2.m40312a();
                        GeneralName[] generalNameArr = null;
                        if (x509crl.m40319a() == 0) {
                            generalNameArr = GeneralNames.m40346a(x509crl.m40320b()).m40348a();
                        }
                        if (x509crl.m40319a() == 1) {
                            if (distributionPoint2.m40314c() != null) {
                                distributionPoint2 = distributionPoint2.m40314c().m40348a();
                            } else {
                                distributionPoint2 = new GeneralName[1];
                                try {
                                    distributionPoint2[0] = new GeneralName(X500Name.m40212a(PrincipalUtils.m28239a(obj).mo6822f()));
                                } catch (DistributionPoint distributionPoint22) {
                                    throw new AnnotatedException("Could not read certificate issuer.", distributionPoint22);
                                }
                            }
                            generalNameArr = distributionPoint22;
                            for (distributionPoint22 = null; distributionPoint22 < generalNameArr.length; distributionPoint22++) {
                                Enumeration c = ASN1Sequence.m43000a(generalNameArr[distributionPoint22].m40344b().mo5709e()).mo6861c();
                                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                                while (c.hasMoreElements()) {
                                    aSN1EncodableVector2.m27141a((ASN1Encodable) c.nextElement());
                                }
                                aSN1EncodableVector2.m27141a(x509crl.m40320b());
                                generalNameArr[distributionPoint22] = new GeneralName(X500Name.m40212a(new DERSequence(aSN1EncodableVector2)));
                            }
                        }
                        if (generalNameArr != null) {
                            for (X509CRL x509crl2 : generalNameArr) {
                                if (arrayList.contains(x509crl2) != null) {
                                    i = 1;
                                    break;
                                }
                            }
                        }
                        if (i == 0) {
                            throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                        }
                    } else if (distributionPoint22.m40314c() != null) {
                        distributionPoint22 = distributionPoint22.m40314c().m40348a();
                        for (Object contains : distributionPoint22) {
                            if (arrayList.contains(contains)) {
                                i = 1;
                                break;
                            }
                        }
                        if (i == 0) {
                            throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                        }
                    } else {
                        throw new AnnotatedException("Either the cRLIssuer or the distributionPoint field must be contained in DistributionPoint.");
                    }
                }
                try {
                    distributionPoint22 = BasicConstraints.m40258a(CertPathValidatorUtilities.m28155a((X509Extension) obj, f23015h));
                    if ((obj instanceof X509Certificate) != null) {
                        if (!(a.m40367a() == null || distributionPoint22 == null)) {
                            if (distributionPoint22.m40259a() != null) {
                                throw new AnnotatedException("CA Cert CRL only contains user certificates.");
                            }
                        }
                        if (a.m40368b() != null) {
                            if (distributionPoint22 == null || distributionPoint22.m40259a() == null) {
                                throw new AnnotatedException("End CRL only contains CA certificates.");
                            }
                        }
                    }
                    if (a.m40370d() != null) {
                        throw new AnnotatedException("onlyContainsAttributeCerts boolean is asserted.");
                    }
                } catch (DistributionPoint distributionPoint222) {
                    throw new AnnotatedException("Basic constraints extension could not be decoded.", distributionPoint222);
                }
            }
        } catch (DistributionPoint distributionPoint2222) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", distributionPoint2222);
        }
    }

    /* renamed from: b */
    protected static void m28269b(DistributionPoint distributionPoint, Object obj, X509CRL x509crl) {
        Object a = CertPathValidatorUtilities.m28155a((X509Extension) x509crl, f23011d);
        a = (a == null || !IssuingDistributionPoint.m40365a(a).m40369c()) ? null : 1;
        try {
            byte[] f = PrincipalUtils.m28241a(x509crl).mo6822f();
            if (distributionPoint.m40314c() != null) {
                distributionPoint = distributionPoint.m40314c().m40348a();
                obj = null;
                for (int i = 0; i < distributionPoint.length; i++) {
                    if (distributionPoint[i].m40343a() == 4) {
                        try {
                            if (Arrays.m29353a(distributionPoint[i].m40344b().mo5709e().mo6822f(), f) != null) {
                                obj = true;
                            }
                        } catch (DistributionPoint distributionPoint2) {
                            throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", distributionPoint2);
                        }
                    }
                }
                if (obj != null) {
                    if (a == null) {
                        throw new AnnotatedException("Distribution point contains cRLIssuer field but CRL is not indirect.");
                    }
                }
                if (obj == null) {
                    throw new AnnotatedException("CRL issuer of CRL does not match CRL issuer of distribution point.");
                }
            } else {
                obj = PrincipalUtils.m28241a(x509crl).equals(PrincipalUtils.m28239a(obj)) != null ? true : null;
            }
            if (obj == null) {
                throw new AnnotatedException("Cannot find matching CRL issuer for certificate.");
            }
        } catch (DistributionPoint distributionPoint22) {
            x509crl = new StringBuilder();
            x509crl.append("Exception encoding CRL issuer: ");
            x509crl.append(distributionPoint22.getMessage());
            throw new AnnotatedException(x509crl.toString(), distributionPoint22);
        }
    }

    /* renamed from: a */
    protected static ReasonsMask m28253a(X509CRL x509crl, DistributionPoint distributionPoint) {
        try {
            x509crl = IssuingDistributionPoint.m40365a(CertPathValidatorUtilities.m28155a((X509Extension) x509crl, f23011d));
            if (x509crl != null && x509crl.m40373h() != null && distributionPoint.m40313b() != null) {
                return new ReasonsMask(distributionPoint.m40313b()).m28290b(new ReasonsMask(x509crl.m40373h()));
            }
            if ((x509crl == null || x509crl.m40373h() == null) && distributionPoint.m40313b() == null) {
                return ReasonsMask.f23028a;
            }
            if (distributionPoint.m40313b() == null) {
                distributionPoint = ReasonsMask.f23028a;
            } else {
                distributionPoint = new ReasonsMask(distributionPoint.m40313b());
            }
            if (x509crl == null) {
                x509crl = ReasonsMask.f23028a;
            } else {
                x509crl = new ReasonsMask(x509crl.m40373h());
            }
            return distributionPoint.m28290b(x509crl);
        } catch (X509CRL x509crl2) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", x509crl2);
        }
    }

    /* renamed from: a */
    protected static Set m28248a(X509CRL x509crl, Object obj, X509Certificate x509Certificate, PublicKey publicKey, PKIXExtendedParameters pKIXExtendedParameters, List list, JcaJceHelper jcaJceHelper) {
        obj = new X509CertSelector();
        try {
            obj.setSubject(PrincipalUtils.m28241a(x509crl).mo6822f());
            PKIXCertStoreSelector a = new Builder(obj).m27901a();
            try {
                int i;
                obj = CertPathValidatorUtilities.m28146a(a, pKIXExtendedParameters.m27939a());
                obj.addAll(CertPathValidatorUtilities.m28146a(a, pKIXExtendedParameters.m27954p()));
                obj.add(x509Certificate);
                x509crl = obj.iterator();
                obj = new ArrayList();
                List arrayList = new ArrayList();
                while (true) {
                    i = 0;
                    if (!x509crl.hasNext()) {
                        break;
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) x509crl.next();
                    if (x509Certificate2.equals(x509Certificate)) {
                        obj.add(x509Certificate2);
                        arrayList.add(publicKey);
                    } else {
                        try {
                            PKIXCertPathBuilderSpi pKIXCertPathBuilderSpi = new PKIXCertPathBuilderSpi();
                            CertSelector x509CertSelector = new X509CertSelector();
                            x509CertSelector.setCertificate(x509Certificate2);
                            PKIXExtendedParameters.Builder a2 = new PKIXExtendedParameters.Builder(pKIXExtendedParameters).m27926a(new Builder(x509CertSelector).m27901a());
                            if (list.contains(x509Certificate2)) {
                                a2.m27929b(false);
                            } else {
                                a2.m27929b(true);
                            }
                            List certificates = pKIXCertPathBuilderSpi.engineBuild(new PKIXExtendedBuilderParameters.Builder(a2.m27928a()).m27907a()).getCertPath().getCertificates();
                            obj.add(x509Certificate2);
                            arrayList.add(CertPathValidatorUtilities.m28143a(certificates, 0, jcaJceHelper));
                        } catch (X509CRL x509crl2) {
                            throw new AnnotatedException("CertPath for CRL signer failed to validate.", x509crl2);
                        } catch (X509CRL x509crl22) {
                            throw new AnnotatedException("Public key of issuer certificate of CRL could not be retrieved.", x509crl22);
                        } catch (X509CRL x509crl222) {
                            throw new AnnotatedException(x509crl222.getMessage());
                        }
                    }
                }
                x509crl222 = new HashSet();
                x509Certificate = null;
                while (i < obj.size()) {
                    publicKey = ((X509Certificate) obj.get(i)).getKeyUsage();
                    if (publicKey == null || (publicKey.length >= 7 && publicKey[6] != null)) {
                        x509crl222.add(arrayList.get(i));
                    } else {
                        x509Certificate = new AnnotatedException("Issuer certificate key usage extension does not permit CRL signing.");
                    }
                    i++;
                }
                if (x509crl222.isEmpty() != null) {
                    if (x509Certificate == null) {
                        throw new AnnotatedException("Cannot find a valid issuer certificate.");
                    }
                }
                if (x509crl222.isEmpty() != null) {
                    if (x509Certificate != null) {
                        throw x509Certificate;
                    }
                }
                return x509crl222;
            } catch (X509CRL x509crl2222) {
                throw new AnnotatedException("Issuer certificate for CRL cannot be searched.", x509crl2222);
            }
        } catch (X509CRL x509crl22222) {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate for CRL could not be set.", x509crl22222);
        }
    }

    /* renamed from: a */
    protected static PublicKey m28246a(X509CRL x509crl, Set set) {
        Throwable th = null;
        for (PublicKey publicKey : set) {
            try {
                x509crl.verify(publicKey);
                return publicKey;
            } catch (Exception e) {
                th = e;
            }
        }
        throw new AnnotatedException("Cannot verify CRL.", th);
    }

    /* renamed from: a */
    protected static X509CRL m28247a(Set set, PublicKey publicKey) {
        Throwable th = null;
        for (X509CRL x509crl : set) {
            try {
                x509crl.verify(publicKey);
                return x509crl;
            } catch (Exception e) {
                th = e;
            }
        }
        if (th == null) {
            return null;
        }
        throw new AnnotatedException("Cannot verify delta CRL.", th);
    }

    /* renamed from: a */
    protected static void m28260a(X509CRL x509crl, X509CRL x509crl2, PKIXExtendedParameters pKIXExtendedParameters) {
        if (x509crl != null) {
            try {
                IssuingDistributionPoint a = IssuingDistributionPoint.m40365a(CertPathValidatorUtilities.m28155a((X509Extension) x509crl2, f23011d));
                if (pKIXExtendedParameters.m27944f() != null) {
                    if (PrincipalUtils.m28241a(x509crl).equals(PrincipalUtils.m28241a(x509crl2)) != null) {
                        try {
                            pKIXExtendedParameters = IssuingDistributionPoint.m40365a(CertPathValidatorUtilities.m28155a((X509Extension) x509crl, f23011d));
                            Object obj = 1;
                            if (a == null) {
                                if (pKIXExtendedParameters == null) {
                                    if (obj != null) {
                                        try {
                                            x509crl2 = CertPathValidatorUtilities.m28155a((X509Extension) x509crl2, f23019l);
                                            try {
                                                x509crl = CertPathValidatorUtilities.m28155a((X509Extension) x509crl, f23019l);
                                                if (x509crl2 != null) {
                                                    throw new AnnotatedException("CRL authority key identifier is null.");
                                                } else if (x509crl != null) {
                                                    throw new AnnotatedException("Delta CRL authority key identifier is null.");
                                                } else if (x509crl2.equals(x509crl) != null) {
                                                    throw new AnnotatedException("Delta CRL authority key identifier does not match complete CRL authority key identifier.");
                                                }
                                            } catch (X509CRL x509crl3) {
                                                throw new AnnotatedException("Authority key identifier extension could not be extracted from delta CRL.", x509crl3);
                                            }
                                        } catch (X509CRL x509crl32) {
                                            throw new AnnotatedException("Authority key identifier extension could not be extracted from complete CRL.", x509crl32);
                                        }
                                    }
                                    throw new AnnotatedException("Issuing distribution point extension from delta CRL and complete CRL does not match.");
                                }
                            } else if (a.equals(pKIXExtendedParameters) != null) {
                                if (obj != null) {
                                    throw new AnnotatedException("Issuing distribution point extension from delta CRL and complete CRL does not match.");
                                }
                                x509crl2 = CertPathValidatorUtilities.m28155a((X509Extension) x509crl2, f23019l);
                                x509crl32 = CertPathValidatorUtilities.m28155a((X509Extension) x509crl32, f23019l);
                                if (x509crl2 != null) {
                                    throw new AnnotatedException("CRL authority key identifier is null.");
                                } else if (x509crl32 != null) {
                                    throw new AnnotatedException("Delta CRL authority key identifier is null.");
                                } else if (x509crl2.equals(x509crl32) != null) {
                                    throw new AnnotatedException("Delta CRL authority key identifier does not match complete CRL authority key identifier.");
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                x509crl2 = CertPathValidatorUtilities.m28155a((X509Extension) x509crl2, f23019l);
                                x509crl32 = CertPathValidatorUtilities.m28155a((X509Extension) x509crl32, f23019l);
                                if (x509crl2 != null) {
                                    throw new AnnotatedException("CRL authority key identifier is null.");
                                } else if (x509crl32 != null) {
                                    throw new AnnotatedException("Delta CRL authority key identifier is null.");
                                } else if (x509crl2.equals(x509crl32) != null) {
                                    throw new AnnotatedException("Delta CRL authority key identifier does not match complete CRL authority key identifier.");
                                }
                            } else {
                                throw new AnnotatedException("Issuing distribution point extension from delta CRL and complete CRL does not match.");
                            }
                        } catch (X509CRL x509crl322) {
                            throw new AnnotatedException("Issuing distribution point extension from delta CRL could not be decoded.", x509crl322);
                        }
                    }
                    throw new AnnotatedException("Complete CRL issuer does not match delta CRL issuer.");
                }
            } catch (X509CRL x509crl3222) {
                throw new AnnotatedException("Issuing distribution point extension could not be decoded.", x509crl3222);
            }
        }
    }

    /* renamed from: a */
    protected static void m28262a(Date date, X509CRL x509crl, Object obj, CertStatus certStatus, PKIXExtendedParameters pKIXExtendedParameters) {
        if (pKIXExtendedParameters.m27944f() != null && x509crl != null) {
            CertPathValidatorUtilities.m28159a(date, x509crl, obj, certStatus);
        }
    }

    /* renamed from: a */
    protected static void m28261a(Date date, X509CRL x509crl, Object obj, CertStatus certStatus) {
        if (certStatus.m28171b() == 11) {
            CertPathValidatorUtilities.m28159a(date, x509crl, obj, certStatus);
        }
    }

    /* renamed from: a */
    protected static PKIXPolicyNode m28251a(CertPath certPath, int i, List[] listArr, PKIXPolicyNode pKIXPolicyNode, int i2) {
        CertPath certPath2 = certPath;
        int i3 = i;
        List[] listArr2 = listArr;
        List certificates = certPath.getCertificates();
        X509Extension x509Extension = (X509Certificate) certificates.get(i3);
        int size = certificates.size() - i3;
        try {
            ASN1Sequence a = ASN1Sequence.m43000a((Object) CertPathValidatorUtilities.m28155a(x509Extension, f23009b));
            if (a == null) {
                return pKIXPolicyNode;
            }
            Set hashSet;
            Map hashMap = new HashMap();
            Set<String> hashSet2 = new HashSet();
            for (int i4 = 0; i4 < a.mo6862g(); i4++) {
                ASN1Sequence aSN1Sequence = (ASN1Sequence) a.mo6860a(i4);
                String b = ((ASN1ObjectIdentifier) aSN1Sequence.mo6860a(0)).m42986b();
                String b2 = ((ASN1ObjectIdentifier) aSN1Sequence.mo6860a(1)).m42986b();
                if (hashMap.containsKey(b)) {
                    ((Set) hashMap.get(b)).add(b2);
                } else {
                    hashSet = new HashSet();
                    hashSet.add(b2);
                    hashMap.put(b, hashSet);
                    hashSet2.add(b);
                }
            }
            PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNode;
            for (String str : hashSet2) {
                Iterator it;
                PKIXPolicyNode pKIXPolicyNode3;
                PKIXPolicyNode pKIXPolicyNode4;
                if (i2 > 0) {
                    Object obj;
                    for (PKIXPolicyNode pKIXPolicyNode32 : listArr2[size]) {
                        if (pKIXPolicyNode32.getValidPolicy().equals(str)) {
                            pKIXPolicyNode32.f23003c = (Set) hashMap.get(str);
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        for (PKIXPolicyNode pKIXPolicyNode322 : listArr2[size]) {
                            if ("2.5.29.32.0".equals(pKIXPolicyNode322.getValidPolicy())) {
                                Set set = null;
                                try {
                                    Enumeration c = ((ASN1Sequence) CertPathValidatorUtilities.m28155a(x509Extension, f23008a)).mo6861c();
                                    while (c.hasMoreElements()) {
                                        try {
                                            PolicyInformation a2 = PolicyInformation.m40392a(c.nextElement());
                                            if ("2.5.29.32.0".equals(a2.m40393a().m42986b())) {
                                                try {
                                                    set = CertPathValidatorUtilities.m28152a(a2.m40394b());
                                                    break;
                                                } catch (Throwable e) {
                                                    throw new ExtCertPathValidatorException("Policy qualifier info set could not be decoded.", e, certPath2, i3);
                                                }
                                            }
                                        } catch (Throwable e2) {
                                            throw new CertPathValidatorException("Policy information could not be decoded.", e2, certPath2, i3);
                                        }
                                    }
                                    hashSet = set;
                                    boolean contains = x509Extension.getCriticalExtensionOIDs() != null ? x509Extension.getCriticalExtensionOIDs().contains(f23008a) : false;
                                    pKIXPolicyNode4 = (PKIXPolicyNode) pKIXPolicyNode322.getParent();
                                    if ("2.5.29.32.0".equals(pKIXPolicyNode4.getValidPolicy())) {
                                        PKIXPolicyNode pKIXPolicyNode5 = r6;
                                        PKIXPolicyNode pKIXPolicyNode6 = pKIXPolicyNode4;
                                        PKIXPolicyNode pKIXPolicyNode7 = new PKIXPolicyNode(new ArrayList(), size, (Set) hashMap.get(str), pKIXPolicyNode4, hashSet, str, contains);
                                        pKIXPolicyNode6.m28233a(pKIXPolicyNode5);
                                        listArr2[size].add(pKIXPolicyNode5);
                                    }
                                } catch (Throwable e22) {
                                    throw new ExtCertPathValidatorException("Certificate policies extension could not be decoded.", e22, certPath2, i3);
                                }
                            }
                        }
                    }
                } else if (i2 <= 0) {
                    it = listArr2[size].iterator();
                    while (it.hasNext()) {
                        pKIXPolicyNode322 = (PKIXPolicyNode) it.next();
                        if (pKIXPolicyNode322.getValidPolicy().equals(str)) {
                            ((PKIXPolicyNode) pKIXPolicyNode322.getParent()).m28237b(pKIXPolicyNode322);
                            it.remove();
                            for (int i5 = size - 1; i5 >= 0; i5--) {
                                List list = listArr2[i5];
                                pKIXPolicyNode4 = pKIXPolicyNode2;
                                for (int i6 = 0; i6 < list.size(); i6++) {
                                    PKIXPolicyNode pKIXPolicyNode8 = (PKIXPolicyNode) list.get(i6);
                                    if (!pKIXPolicyNode8.m28235a()) {
                                        pKIXPolicyNode4 = CertPathValidatorUtilities.m28157a(pKIXPolicyNode4, listArr2, pKIXPolicyNode8);
                                        if (pKIXPolicyNode4 == null) {
                                            break;
                                        }
                                    }
                                }
                                pKIXPolicyNode2 = pKIXPolicyNode4;
                            }
                        }
                    }
                }
            }
            return pKIXPolicyNode2;
        } catch (Throwable e222) {
            throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", e222, certPath2, i3);
        }
    }

    /* renamed from: a */
    protected static void m28254a(CertPath certPath, int i) {
        try {
            ASN1Sequence a = ASN1Sequence.m43000a((Object) CertPathValidatorUtilities.m28155a((X509Certificate) certPath.getCertificates().get(i), f23009b));
            if (a != null) {
                int i2 = 0;
                while (i2 < a.mo6862g()) {
                    try {
                        ASN1Sequence a2 = ASN1Sequence.m43000a((Object) a.mo6860a(i2));
                        ASN1ObjectIdentifier a3 = ASN1ObjectIdentifier.m42973a(a2.mo6860a(0));
                        ASN1ObjectIdentifier a4 = ASN1ObjectIdentifier.m42973a(a2.mo6860a(1));
                        if ("2.5.29.32.0".equals(a3.m42986b())) {
                            throw new CertPathValidatorException("IssuerDomainPolicy is anyPolicy", null, certPath, i);
                        } else if ("2.5.29.32.0".equals(a4.m42986b())) {
                            throw new CertPathValidatorException("SubjectDomainPolicy is anyPolicy,", null, certPath, i);
                        } else {
                            i2++;
                        }
                    } catch (Throwable e) {
                        throw new ExtCertPathValidatorException("Policy mappings extension contents could not be decoded.", e, certPath, i);
                    }
                }
            }
        } catch (Throwable e2) {
            throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", e2, certPath, i);
        }
    }

    /* renamed from: a */
    protected static void m28258a(CertPath certPath, int i, PKIXPolicyNode pKIXPolicyNode, int i2) {
        if (i2 > 0) {
            return;
        }
        if (pKIXPolicyNode == null) {
            throw new ExtCertPathValidatorException("No valid policy tree found when one expected.", 0, certPath, i);
        }
    }

    /* renamed from: a */
    protected static PKIXPolicyNode m28250a(CertPath certPath, int i, PKIXPolicyNode pKIXPolicyNode) {
        try {
            return ASN1Sequence.m43000a((Object) CertPathValidatorUtilities.m28155a((X509Certificate) certPath.getCertificates().get(i), f23008a)) == null ? null : pKIXPolicyNode;
        } catch (PKIXPolicyNode pKIXPolicyNode2) {
            throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", pKIXPolicyNode2, certPath, i);
        }
    }

    /* renamed from: a */
    protected static void m28257a(CertPath certPath, int i, PKIXNameConstraintValidator pKIXNameConstraintValidator) {
        List certificates = certPath.getCertificates();
        X509Extension x509Extension = (X509Certificate) certificates.get(i);
        int size = certificates.size();
        int i2 = size - i;
        if (!CertPathValidatorUtilities.m28165a((X509Certificate) x509Extension) || i2 >= size) {
            try {
                Object a = ASN1Sequence.m43000a(PrincipalUtils.m28242a((X509Certificate) x509Extension).mo6822f());
                try {
                    pKIXNameConstraintValidator.m28226a((ASN1Sequence) a);
                    pKIXNameConstraintValidator.m28230b((ASN1Sequence) a);
                    try {
                        GeneralNames a2 = GeneralNames.m40346a(CertPathValidatorUtilities.m28155a(x509Extension, f23017j));
                        RDN[] a3 = X500Name.m40212a(a).m40216a(BCStyle.f31128E);
                        i2 = 0;
                        int i3 = 0;
                        while (i3 != a3.length) {
                            GeneralName generalName = new GeneralName(1, ((ASN1String) a3[i3].m40209b().m40203b()).mo6440b());
                            try {
                                pKIXNameConstraintValidator.m28227a(generalName);
                                pKIXNameConstraintValidator.m28231b(generalName);
                                i3++;
                            } catch (PKIXNameConstraintValidator pKIXNameConstraintValidator2) {
                                throw new CertPathValidatorException("Subtree check for certificate subject alternative email failed.", pKIXNameConstraintValidator2, certPath, i);
                            }
                        }
                        if (a2 != null) {
                            try {
                                GeneralName[] a4 = a2.m40348a();
                                while (i2 < a4.length) {
                                    try {
                                        pKIXNameConstraintValidator2.m28227a(a4[i2]);
                                        pKIXNameConstraintValidator2.m28231b(a4[i2]);
                                        i2++;
                                    } catch (PKIXNameConstraintValidator pKIXNameConstraintValidator22) {
                                        throw new CertPathValidatorException("Subtree check for certificate subject alternative name failed.", pKIXNameConstraintValidator22, certPath, i);
                                    }
                                }
                            } catch (PKIXNameConstraintValidator pKIXNameConstraintValidator222) {
                                throw new CertPathValidatorException("Subject alternative name contents could not be decoded.", pKIXNameConstraintValidator222, certPath, i);
                            }
                        }
                    } catch (PKIXNameConstraintValidator pKIXNameConstraintValidator2222) {
                        throw new CertPathValidatorException("Subject alternative name extension could not be decoded.", pKIXNameConstraintValidator2222, certPath, i);
                    }
                } catch (PKIXNameConstraintValidator pKIXNameConstraintValidator22222) {
                    throw new CertPathValidatorException("Subtree check for certificate subject failed.", pKIXNameConstraintValidator22222, certPath, i);
                }
            } catch (PKIXNameConstraintValidator pKIXNameConstraintValidator222222) {
                throw new CertPathValidatorException("Exception extracting subject name when checking subtrees.", pKIXNameConstraintValidator222222, certPath, i);
            }
        }
    }

    /* renamed from: a */
    protected static PKIXPolicyNode m28249a(CertPath certPath, int i, Set set, PKIXPolicyNode pKIXPolicyNode, List[] listArr, int i2) {
        CertPath certPath2 = certPath;
        int i3 = i;
        Set set2 = set;
        List[] listArr2 = listArr;
        List certificates = certPath.getCertificates();
        X509Certificate x509Certificate = (X509Certificate) certificates.get(i3);
        int size = certificates.size();
        int i4 = size - i3;
        try {
            ASN1Sequence a = ASN1Sequence.m43000a((Object) CertPathValidatorUtilities.m28155a((X509Extension) x509Certificate, f23008a));
            if (a == null || pKIXPolicyNode == null) {
                return null;
            }
            Set a2;
            Object obj;
            Enumeration c;
            PolicyInformation a3;
            Set a4;
            List list;
            PKIXPolicyNode pKIXPolicyNode2;
            String str;
            Set set3;
            String str2;
            Iterator children;
            PKIXPolicyNode pKIXPolicyNode3;
            PKIXPolicyNode pKIXPolicyNode4;
            Set set4;
            PKIXPolicyNode pKIXPolicyNode5;
            PKIXPolicyNode pKIXPolicyNode6;
            int i5;
            List list2;
            PKIXPolicyNode pKIXPolicyNode7;
            boolean contains;
            Enumeration c2 = a.mo6861c();
            Collection hashSet = new HashSet();
            while (c2.hasMoreElements()) {
                PolicyInformation a5 = PolicyInformation.m40392a(c2.nextElement());
                ASN1ObjectIdentifier a6 = a5.m40393a();
                hashSet.add(a6.m42986b());
                if (!"2.5.29.32.0".equals(a6.m42986b())) {
                    try {
                        a2 = CertPathValidatorUtilities.m28152a(a5.m40394b());
                        if (!CertPathValidatorUtilities.m28163a(i4, listArr2, a6, a2)) {
                            CertPathValidatorUtilities.m28167b(i4, listArr2, a6, a2);
                        }
                    } catch (Throwable e) {
                        throw new ExtCertPathValidatorException("Policy qualifier info set could not be build.", e, certPath2, i3);
                    }
                }
            }
            if (!set.isEmpty()) {
                if (!set2.contains("2.5.29.32.0")) {
                    Collection hashSet2 = new HashSet();
                    for (Object obj2 : set) {
                        if (hashSet.contains(obj2)) {
                            hashSet2.add(obj2);
                        }
                    }
                    set.clear();
                    set2.addAll(hashSet2);
                    if (i2 > 0 || (i4 < size && CertPathValidatorUtilities.m28165a(x509Certificate))) {
                        c = a.mo6861c();
                        while (c.hasMoreElements()) {
                            a3 = PolicyInformation.m40392a(c.nextElement());
                            if ("2.5.29.32.0".equals(a3.m40393a().m42986b())) {
                                a4 = CertPathValidatorUtilities.m28152a(a3.m40394b());
                                list = listArr2[i4 - 1];
                                for (size = 0; size < list.size(); size++) {
                                    pKIXPolicyNode2 = (PKIXPolicyNode) list.get(size);
                                    for (Object next : pKIXPolicyNode2.getExpectedPolicies()) {
                                        if (next instanceof String) {
                                            str = (String) next;
                                        } else if (next instanceof ASN1ObjectIdentifier) {
                                            set3 = a4;
                                        } else {
                                            str = ((ASN1ObjectIdentifier) next).m42986b();
                                        }
                                        str2 = str;
                                        children = pKIXPolicyNode2.getChildren();
                                        obj2 = null;
                                        while (children.hasNext()) {
                                            if (str2.equals(((PKIXPolicyNode) children.next()).getValidPolicy())) {
                                                obj2 = 1;
                                            }
                                        }
                                        if (obj2 != null) {
                                            a2 = new HashSet();
                                            a2.add(str2);
                                            pKIXPolicyNode3 = pKIXPolicyNode4;
                                            set4 = a4;
                                            set3 = a4;
                                            pKIXPolicyNode5 = pKIXPolicyNode2;
                                            pKIXPolicyNode4 = new PKIXPolicyNode(new ArrayList(), i4, a2, pKIXPolicyNode2, set4, str2, false);
                                            pKIXPolicyNode5.m28233a(pKIXPolicyNode3);
                                            listArr2[i4].add(pKIXPolicyNode3);
                                        } else {
                                            set3 = a4;
                                            pKIXPolicyNode5 = pKIXPolicyNode2;
                                        }
                                        pKIXPolicyNode2 = pKIXPolicyNode5;
                                        a4 = set3;
                                    }
                                    set3 = a4;
                                }
                            }
                        }
                    }
                    pKIXPolicyNode6 = pKIXPolicyNode;
                    for (i5 = i4 - 1; i5 >= 0; i5--) {
                        list2 = listArr2[i5];
                        for (i3 = 0; i3 < list2.size(); i3++) {
                            pKIXPolicyNode7 = (PKIXPolicyNode) list2.get(i3);
                            if (pKIXPolicyNode7.m28235a()) {
                                pKIXPolicyNode7 = CertPathValidatorUtilities.m28157a(pKIXPolicyNode6, listArr2, pKIXPolicyNode7);
                                if (pKIXPolicyNode7 != null) {
                                    pKIXPolicyNode6 = pKIXPolicyNode7;
                                    break;
                                }
                                pKIXPolicyNode6 = pKIXPolicyNode7;
                            }
                        }
                    }
                    set2 = x509Certificate.getCriticalExtensionOIDs();
                    if (set2 != null) {
                        contains = set2.contains(f23008a);
                        list2 = listArr2[i4];
                        for (i3 = 0; i3 < list2.size(); i3++) {
                            ((PKIXPolicyNode) list2.get(i3)).m28234a(contains);
                        }
                    }
                    return pKIXPolicyNode6;
                }
            }
            set.clear();
            set2.addAll(hashSet);
            c = a.mo6861c();
            while (c.hasMoreElements()) {
                a3 = PolicyInformation.m40392a(c.nextElement());
                if ("2.5.29.32.0".equals(a3.m40393a().m42986b())) {
                    a4 = CertPathValidatorUtilities.m28152a(a3.m40394b());
                    list = listArr2[i4 - 1];
                    for (size = 0; size < list.size(); size++) {
                        pKIXPolicyNode2 = (PKIXPolicyNode) list.get(size);
                        for (Object next2 : pKIXPolicyNode2.getExpectedPolicies()) {
                            if (next2 instanceof String) {
                                str = (String) next2;
                            } else if (next2 instanceof ASN1ObjectIdentifier) {
                                set3 = a4;
                            } else {
                                str = ((ASN1ObjectIdentifier) next2).m42986b();
                            }
                            str2 = str;
                            children = pKIXPolicyNode2.getChildren();
                            obj2 = null;
                            while (children.hasNext()) {
                                if (str2.equals(((PKIXPolicyNode) children.next()).getValidPolicy())) {
                                    obj2 = 1;
                                }
                            }
                            if (obj2 != null) {
                                set3 = a4;
                                pKIXPolicyNode5 = pKIXPolicyNode2;
                            } else {
                                a2 = new HashSet();
                                a2.add(str2);
                                pKIXPolicyNode3 = pKIXPolicyNode4;
                                set4 = a4;
                                set3 = a4;
                                pKIXPolicyNode5 = pKIXPolicyNode2;
                                pKIXPolicyNode4 = new PKIXPolicyNode(new ArrayList(), i4, a2, pKIXPolicyNode2, set4, str2, false);
                                pKIXPolicyNode5.m28233a(pKIXPolicyNode3);
                                listArr2[i4].add(pKIXPolicyNode3);
                            }
                            pKIXPolicyNode2 = pKIXPolicyNode5;
                            a4 = set3;
                        }
                        set3 = a4;
                    }
                    pKIXPolicyNode6 = pKIXPolicyNode;
                    for (i5 = i4 - 1; i5 >= 0; i5--) {
                        list2 = listArr2[i5];
                        for (i3 = 0; i3 < list2.size(); i3++) {
                            pKIXPolicyNode7 = (PKIXPolicyNode) list2.get(i3);
                            if (pKIXPolicyNode7.m28235a()) {
                                pKIXPolicyNode7 = CertPathValidatorUtilities.m28157a(pKIXPolicyNode6, listArr2, pKIXPolicyNode7);
                                if (pKIXPolicyNode7 != null) {
                                    pKIXPolicyNode6 = pKIXPolicyNode7;
                                    break;
                                }
                                pKIXPolicyNode6 = pKIXPolicyNode7;
                            }
                        }
                    }
                    set2 = x509Certificate.getCriticalExtensionOIDs();
                    if (set2 != null) {
                        contains = set2.contains(f23008a);
                        list2 = listArr2[i4];
                        for (i3 = 0; i3 < list2.size(); i3++) {
                            ((PKIXPolicyNode) list2.get(i3)).m28234a(contains);
                        }
                    }
                    return pKIXPolicyNode6;
                }
            }
            pKIXPolicyNode6 = pKIXPolicyNode;
            for (i5 = i4 - 1; i5 >= 0; i5--) {
                list2 = listArr2[i5];
                for (i3 = 0; i3 < list2.size(); i3++) {
                    pKIXPolicyNode7 = (PKIXPolicyNode) list2.get(i3);
                    if (pKIXPolicyNode7.m28235a()) {
                        pKIXPolicyNode7 = CertPathValidatorUtilities.m28157a(pKIXPolicyNode6, listArr2, pKIXPolicyNode7);
                        if (pKIXPolicyNode7 != null) {
                            pKIXPolicyNode6 = pKIXPolicyNode7;
                            break;
                        }
                        pKIXPolicyNode6 = pKIXPolicyNode7;
                    }
                }
            }
            set2 = x509Certificate.getCriticalExtensionOIDs();
            if (set2 != null) {
                contains = set2.contains(f23008a);
                list2 = listArr2[i4];
                for (i3 = 0; i3 < list2.size(); i3++) {
                    ((PKIXPolicyNode) list2.get(i3)).m28234a(contains);
                }
            }
            return pKIXPolicyNode6;
        } catch (Throwable e2) {
            throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", e2, certPath2, i3);
        }
    }

    /* renamed from: a */
    protected static void m28259a(CertPath certPath, PKIXExtendedParameters pKIXExtendedParameters, int i, PublicKey publicKey, boolean z, X500Name x500Name, X509Certificate x509Certificate, JcaJceHelper jcaJceHelper) {
        List certificates = certPath.getCertificates();
        Object obj = (X509Certificate) certificates.get(i);
        if (!z) {
            try {
                CertPathValidatorUtilities.m28158a((X509Certificate) obj, publicKey, pKIXExtendedParameters.m27949k());
            } catch (PKIXExtendedParameters pKIXExtendedParameters2) {
                throw new ExtCertPathValidatorException("Could not validate certificate signature.", pKIXExtendedParameters2, certPath, i);
            }
        }
        try {
            obj.checkValidity(CertPathValidatorUtilities.m28148a(pKIXExtendedParameters2, certPath, i));
            if (pKIXExtendedParameters2.m27955q()) {
                try {
                    m28265a(pKIXExtendedParameters2, (X509Certificate) obj, CertPathValidatorUtilities.m28148a(pKIXExtendedParameters2, certPath, i), x509Certificate, publicKey, certificates, jcaJceHelper);
                } catch (PKIXExtendedParameters pKIXExtendedParameters22) {
                    throw new ExtCertPathValidatorException(pKIXExtendedParameters22.getMessage(), pKIXExtendedParameters22.getCause() != null ? pKIXExtendedParameters22.getCause() : pKIXExtendedParameters22, certPath, i);
                }
            }
            if (PrincipalUtils.m28239a(obj).equals(x500Name) == null) {
                publicKey = new StringBuilder();
                publicKey.append("IssuerName(");
                publicKey.append(PrincipalUtils.m28239a(obj));
                publicKey.append(") does not match SubjectName(");
                publicKey.append(x500Name);
                publicKey.append(") of signing certificate.");
                throw new ExtCertPathValidatorException(publicKey.toString(), false, certPath, i);
            }
        } catch (PKIXExtendedParameters pKIXExtendedParameters222) {
            z = new StringBuilder();
            z.append("Could not validate certificate: ");
            z.append(pKIXExtendedParameters222.getMessage());
            throw new ExtCertPathValidatorException(z.toString(), pKIXExtendedParameters222, certPath, i);
        } catch (PKIXExtendedParameters pKIXExtendedParameters2222) {
            z = new StringBuilder();
            z.append("Could not validate certificate: ");
            z.append(pKIXExtendedParameters2222.getMessage());
            throw new ExtCertPathValidatorException(z.toString(), pKIXExtendedParameters2222, certPath, i);
        } catch (PKIXExtendedParameters pKIXExtendedParameters22222) {
            throw new ExtCertPathValidatorException("Could not validate time of certificate.", pKIXExtendedParameters22222, certPath, i);
        }
    }

    /* renamed from: a */
    protected static int m28245a(CertPath certPath, int i, int i2) {
        try {
            ASN1Sequence a = ASN1Sequence.m43000a((Object) CertPathValidatorUtilities.m28155a((X509Certificate) certPath.getCertificates().get(i), f23014g));
            if (a != null) {
                Enumeration c = a.mo6861c();
                while (c.hasMoreElements()) {
                    try {
                        ASN1TaggedObject a2 = ASN1TaggedObject.m43026a(c.nextElement());
                        if (a2.m43030b() == 0) {
                            int intValue = ASN1Integer.m42964a(a2, false).m42968b().intValue();
                            if (intValue < i2) {
                                return intValue;
                            }
                        }
                    } catch (int i22) {
                        throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", i22, certPath, i);
                    }
                }
            }
            return i22;
        } catch (int i222) {
            throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", i222, certPath, i);
        }
    }

    /* renamed from: b */
    protected static int m28266b(CertPath certPath, int i, int i2) {
        try {
            ASN1Sequence a = ASN1Sequence.m43000a((Object) CertPathValidatorUtilities.m28155a((X509Certificate) certPath.getCertificates().get(i), f23014g));
            if (a != null) {
                Enumeration c = a.mo6861c();
                while (c.hasMoreElements()) {
                    try {
                        ASN1TaggedObject a2 = ASN1TaggedObject.m43026a(c.nextElement());
                        if (a2.m43030b() == 1) {
                            int intValue = ASN1Integer.m42964a(a2, false).m42968b().intValue();
                            if (intValue < i2) {
                                return intValue;
                            }
                        }
                    } catch (int i22) {
                        throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", i22, certPath, i);
                    }
                }
            }
            return i22;
        } catch (int i222) {
            throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", i222, certPath, i);
        }
    }

    /* renamed from: b */
    protected static void m28268b(CertPath certPath, int i, PKIXNameConstraintValidator pKIXNameConstraintValidator) {
        try {
            NameConstraints a;
            Object a2 = ASN1Sequence.m43000a((Object) CertPathValidatorUtilities.m28155a((X509Certificate) certPath.getCertificates().get(i), f23018k));
            if (a2 != null) {
                a = NameConstraints.m40379a(a2);
            } else {
                a = null;
            }
            if (a != null) {
                GeneralSubtree[] a3 = a.m40381a();
                if (a3 != null) {
                    try {
                        pKIXNameConstraintValidator.m28229a(a3);
                    } catch (PKIXNameConstraintValidator pKIXNameConstraintValidator2) {
                        throw new ExtCertPathValidatorException("Permitted subtrees cannot be build from name constraints extension.", pKIXNameConstraintValidator2, certPath, i);
                    }
                }
                GeneralSubtree[] b = a.m40382b();
                if (b != null) {
                    int i2 = 0;
                    while (i2 != b.length) {
                        try {
                            pKIXNameConstraintValidator2.m28228a(b[i2]);
                            i2++;
                        } catch (PKIXNameConstraintValidator pKIXNameConstraintValidator22) {
                            throw new ExtCertPathValidatorException("Excluded subtrees cannot be build from name constraints extension.", pKIXNameConstraintValidator22, certPath, i);
                        }
                    }
                }
            }
        } catch (PKIXNameConstraintValidator pKIXNameConstraintValidator222) {
            throw new ExtCertPathValidatorException("Name constraints extension could not be decoded.", pKIXNameConstraintValidator222, certPath, i);
        }
    }

    /* renamed from: a */
    private static void m28264a(DistributionPoint distributionPoint, PKIXExtendedParameters pKIXExtendedParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, CertStatus certStatus, ReasonsMask reasonsMask, List list, JcaJceHelper jcaJceHelper) {
        Date date2;
        Iterator it;
        ReasonsMask reasonsMask2;
        DistributionPoint distributionPoint2 = distributionPoint;
        PKIXExtendedParameters pKIXExtendedParameters2 = pKIXExtendedParameters;
        Object obj = x509Certificate;
        Date date3 = date;
        CertStatus certStatus2 = certStatus;
        ReasonsMask reasonsMask3 = reasonsMask;
        Date date4 = new Date(System.currentTimeMillis());
        if (date.getTime() <= date4.getTime()) {
            AnnotatedException annotatedException;
            Iterator it2 = CertPathValidatorUtilities.m28153a(distributionPoint2, obj, date4, pKIXExtendedParameters2).iterator();
            AnnotatedException annotatedException2 = null;
            Object obj2 = null;
            while (it2.hasNext() && certStatus.m28171b() == 11 && !reasonsMask.m28288a()) {
                try {
                    X509CRL x509crl = (X509CRL) it2.next();
                    ReasonsMask a = m28253a(x509crl, distributionPoint2);
                    if (a.m28291c(reasonsMask3)) {
                        X509CRL a2;
                        date2 = date4;
                        ReasonsMask reasonsMask4 = a;
                        it = it2;
                        X509CRL x509crl2 = x509crl;
                        annotatedException = annotatedException2;
                        try {
                            PublicKey a3 = m28246a(x509crl2, m28248a(x509crl, (Object) x509Certificate, x509Certificate2, publicKey, pKIXExtendedParameters, list, jcaJceHelper));
                            Date e = pKIXExtendedParameters.m27943e() != null ? pKIXExtendedParameters.m27943e() : date2;
                            if (pKIXExtendedParameters.m27944f()) {
                                a2 = m28247a(CertPathValidatorUtilities.m28151a(e, x509crl2, pKIXExtendedParameters.m27954p(), pKIXExtendedParameters.m27941c()), a3);
                            } else {
                                a2 = null;
                            }
                            if (pKIXExtendedParameters.m27945g() != 1) {
                                if (x509Certificate.getNotAfter().getTime() < x509crl2.getThisUpdate().getTime()) {
                                    throw new AnnotatedException("No valid CRL for current time found.");
                                }
                            }
                            m28269b(distributionPoint2, obj, x509crl2);
                            m28263a(distributionPoint2, obj, x509crl2);
                            m28260a(a2, x509crl2, pKIXExtendedParameters2);
                            m28262a(date3, a2, obj, certStatus2, pKIXExtendedParameters2);
                            m28261a(date3, x509crl2, obj, certStatus2);
                            if (certStatus.m28171b() == 8) {
                                certStatus2.m28169a(11);
                            }
                            reasonsMask2 = reasonsMask;
                        } catch (AnnotatedException e2) {
                            annotatedException2 = e2;
                            reasonsMask2 = reasonsMask;
                            reasonsMask3 = reasonsMask2;
                            date4 = date2;
                            it2 = it;
                        }
                        try {
                            reasonsMask2.m28287a(reasonsMask4);
                            Collection criticalExtensionOIDs = x509crl2.getCriticalExtensionOIDs();
                            if (criticalExtensionOIDs != null) {
                                Set hashSet = new HashSet(criticalExtensionOIDs);
                                hashSet.remove(Extension.f31289m.m42986b());
                                hashSet.remove(Extension.f31288l.m42986b());
                                if (!hashSet.isEmpty()) {
                                    throw new AnnotatedException("CRL contains unsupported critical extensions.");
                                }
                            }
                            if (a2 != null) {
                                criticalExtensionOIDs = a2.getCriticalExtensionOIDs();
                                if (criticalExtensionOIDs != null) {
                                    Set hashSet2 = new HashSet(criticalExtensionOIDs);
                                    hashSet2.remove(Extension.f31289m.m42986b());
                                    hashSet2.remove(Extension.f31288l.m42986b());
                                    if (!hashSet2.isEmpty()) {
                                        throw new AnnotatedException("Delta CRL contains unsupported critical extension.");
                                    }
                                }
                            }
                            reasonsMask3 = reasonsMask2;
                            date4 = date2;
                            it2 = it;
                            annotatedException2 = annotatedException;
                            obj2 = 1;
                        } catch (AnnotatedException e3) {
                            annotatedException2 = e3;
                            reasonsMask3 = reasonsMask2;
                            date4 = date2;
                            it2 = it;
                        }
                    }
                } catch (AnnotatedException e4) {
                    annotatedException2 = e4;
                    reasonsMask2 = reasonsMask3;
                    date2 = date4;
                    it = it2;
                    reasonsMask3 = reasonsMask2;
                    date4 = date2;
                    it2 = it;
                }
            }
            annotatedException = annotatedException2;
            if (obj2 == null) {
                throw annotatedException;
            }
            return;
        }
        throw new AnnotatedException("Validation time is in future.");
    }

    /* renamed from: a */
    protected static void m28265a(PKIXExtendedParameters pKIXExtendedParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, List list, JcaJceHelper jcaJceHelper) {
        Throwable th;
        try {
            CRLDistPoint a = CRLDistPoint.m40262a(CertPathValidatorUtilities.m28155a((X509Extension) x509Certificate, f23016i));
            PKIXExtendedParameters.Builder builder = new PKIXExtendedParameters.Builder(pKIXExtendedParameters);
            try {
                Object obj;
                int i;
                SimpleDateFormat simpleDateFormat;
                StringBuilder stringBuilder;
                String stringBuilder2;
                for (PKIXCRLStore a2 : CertPathValidatorUtilities.m28149a(a, pKIXExtendedParameters.m27942d())) {
                    builder.m27924a(a2);
                }
                CertStatus certStatus = new CertStatus();
                ReasonsMask reasonsMask = new ReasonsMask();
                PKIXExtendedParameters a3 = builder.m27928a();
                int i2 = 11;
                if (a != null) {
                    try {
                        DistributionPoint[] a4 = a.m40263a();
                        if (a4 != null) {
                            th = null;
                            int i3 = 0;
                            obj = null;
                            while (i3 < a4.length && certStatus.m28171b() == r8 && !reasonsMask.m28288a()) {
                                int i4;
                                DistributionPoint[] distributionPointArr;
                                try {
                                    i4 = i3;
                                    distributionPointArr = a4;
                                    try {
                                        m28264a(a4[i3], a3, x509Certificate, date, x509Certificate2, publicKey, certStatus, reasonsMask, list, jcaJceHelper);
                                        obj = 1;
                                    } catch (AnnotatedException e) {
                                        th = e;
                                    }
                                } catch (AnnotatedException e2) {
                                    th = e2;
                                    i4 = i3;
                                    distributionPointArr = a4;
                                }
                                i3 = i4 + 1;
                                a4 = distributionPointArr;
                                i2 = 11;
                                X509Certificate x509Certificate3 = x509Certificate;
                            }
                            i = 11;
                            if (certStatus.m28171b() == i && !reasonsMask.m28288a()) {
                                m28264a(new DistributionPoint(new DistributionPointName(0, new GeneralNames(new GeneralName(4, new ASN1InputStream(PrincipalUtils.m28239a((Object) x509Certificate).mo6822f()).m34595d()))), null, null), (PKIXExtendedParameters) pKIXExtendedParameters.clone(), x509Certificate, date, x509Certificate2, publicKey, certStatus, reasonsMask, list, jcaJceHelper);
                                obj = 1;
                            }
                            if (obj != null) {
                                if (th instanceof AnnotatedException) {
                                    throw new AnnotatedException("No valid CRL found.", th);
                                }
                                throw th;
                            } else if (certStatus.m28171b() != i) {
                                if (!reasonsMask.m28288a() && certStatus.m28171b() == i) {
                                    certStatus.m28169a(12);
                                }
                                if (certStatus.m28171b() != 12) {
                                    throw new AnnotatedException("Certificate status could not be determined.");
                                }
                            } else {
                                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
                                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("Certificate revocation after ");
                                stringBuilder.append(simpleDateFormat.format(certStatus.m28168a()));
                                stringBuilder2 = stringBuilder.toString();
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(stringBuilder2);
                                stringBuilder.append(", reason: ");
                                stringBuilder.append(f23022o[certStatus.m28171b()]);
                                throw new AnnotatedException(stringBuilder.toString());
                            }
                        }
                    } catch (Throwable th2) {
                        throw new AnnotatedException("Distribution points could not be read.", th2);
                    }
                }
                i = 11;
                th2 = null;
                obj = null;
                try {
                    m28264a(new DistributionPoint(new DistributionPointName(0, new GeneralNames(new GeneralName(4, new ASN1InputStream(PrincipalUtils.m28239a((Object) x509Certificate).mo6822f()).m34595d()))), null, null), (PKIXExtendedParameters) pKIXExtendedParameters.clone(), x509Certificate, date, x509Certificate2, publicKey, certStatus, reasonsMask, list, jcaJceHelper);
                    obj = 1;
                } catch (Throwable th22) {
                    throw new AnnotatedException("Issuer from certificate for CRL could not be reencoded.", th22);
                } catch (AnnotatedException e3) {
                    th22 = e3;
                }
                if (obj != null) {
                    if (certStatus.m28171b() != i) {
                        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Certificate revocation after ");
                        stringBuilder.append(simpleDateFormat.format(certStatus.m28168a()));
                        stringBuilder2 = stringBuilder.toString();
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(stringBuilder2);
                        stringBuilder.append(", reason: ");
                        stringBuilder.append(f23022o[certStatus.m28171b()]);
                        throw new AnnotatedException(stringBuilder.toString());
                    }
                    certStatus.m28169a(12);
                    if (certStatus.m28171b() != 12) {
                        throw new AnnotatedException("Certificate status could not be determined.");
                    }
                } else if (th22 instanceof AnnotatedException) {
                    throw new AnnotatedException("No valid CRL found.", th22);
                } else {
                    throw th22;
                }
            } catch (Throwable th222) {
                throw new AnnotatedException("No additional CRL locations could be decoded from CRL distribution point extension.", th222);
            }
        } catch (Throwable th2222) {
            throw new AnnotatedException("CRL distribution point extension could not be read.", th2222);
        }
    }

    /* renamed from: c */
    protected static int m28270c(CertPath certPath, int i, int i2) {
        try {
            ASN1Integer a = ASN1Integer.m42963a(CertPathValidatorUtilities.m28155a((X509Certificate) certPath.getCertificates().get(i), f23010c));
            if (a != null) {
                certPath = a.m42968b().intValue();
                if (certPath < i2) {
                    return certPath;
                }
            }
            return i2;
        } catch (int i22) {
            throw new ExtCertPathValidatorException("Inhibit any-policy extension cannot be decoded.", i22, certPath, i);
        }
    }

    /* renamed from: b */
    protected static void m28267b(CertPath certPath, int i) {
        try {
            BasicConstraints a = BasicConstraints.m40258a(CertPathValidatorUtilities.m28155a((X509Certificate) certPath.getCertificates().get(i), f23015h));
            if (a == null) {
                throw new CertPathValidatorException("Intermediate certificate lacks BasicConstraints");
            } else if (a.m40259a() == null) {
                throw new CertPathValidatorException("Not a CA certificate");
            }
        } catch (Throwable e) {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e, certPath, i);
        }
    }

    /* renamed from: d */
    protected static int m28272d(CertPath certPath, int i, int i2) {
        if (CertPathValidatorUtilities.m28165a((X509Certificate) certPath.getCertificates().get(i))) {
            return i2;
        }
        if (i2 > 0) {
            return i2 - 1;
        }
        throw new ExtCertPathValidatorException("Max path length not greater than zero", null, certPath, i);
    }

    /* renamed from: e */
    protected static int m28273e(CertPath certPath, int i, int i2) {
        try {
            BasicConstraints a = BasicConstraints.m40258a(CertPathValidatorUtilities.m28155a((X509Certificate) certPath.getCertificates().get(i), f23015h));
            if (a != null) {
                certPath = a.m40260b();
                if (certPath != null) {
                    certPath = certPath.intValue();
                    if (certPath < i2) {
                        return certPath;
                    }
                }
            }
            return i2;
        } catch (int i22) {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", i22, certPath, i);
        }
    }

    /* renamed from: c */
    protected static void m28271c(CertPath certPath, int i) {
        boolean[] keyUsage = ((X509Certificate) certPath.getCertificates().get(i)).getKeyUsage();
        if (keyUsage == null) {
            return;
        }
        if (!keyUsage[5]) {
            throw new ExtCertPathValidatorException("Issuer certificate keyusage extension is critical and does not permit key signing.", null, certPath, i);
        }
    }

    /* renamed from: a */
    protected static void m28256a(CertPath certPath, int i, Set set, List list) {
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(i);
        for (PKIXCertPathChecker check : list) {
            try {
                check.check(x509Certificate, set);
            } catch (Set set2) {
                throw new CertPathValidatorException(set2.getMessage(), set2.getCause(), certPath, i);
            }
        }
        if (set2.isEmpty() == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Certificate has unsupported critical extension: ");
            stringBuilder.append(set2);
            throw new ExtCertPathValidatorException(stringBuilder.toString(), null, certPath, i);
        }
    }

    /* renamed from: f */
    protected static int m28274f(CertPath certPath, int i, int i2) {
        return (CertPathValidatorUtilities.m28165a((X509Certificate) certPath.getCertificates().get(i)) != null || i2 == 0) ? i2 : i2 - 1;
    }

    /* renamed from: g */
    protected static int m28275g(CertPath certPath, int i, int i2) {
        return (CertPathValidatorUtilities.m28165a((X509Certificate) certPath.getCertificates().get(i)) != null || i2 == 0) ? i2 : i2 - 1;
    }

    /* renamed from: h */
    protected static int m28276h(CertPath certPath, int i, int i2) {
        return (CertPathValidatorUtilities.m28165a((X509Certificate) certPath.getCertificates().get(i)) != null || i2 == 0) ? i2 : i2 - 1;
    }

    /* renamed from: a */
    protected static int m28244a(int i, X509Certificate x509Certificate) {
        return (CertPathValidatorUtilities.m28165a(x509Certificate) != null || i == 0) ? i : i - 1;
    }

    /* renamed from: i */
    protected static int m28277i(CertPath certPath, int i, int i2) {
        try {
            ASN1Sequence a = ASN1Sequence.m43000a((Object) CertPathValidatorUtilities.m28155a((X509Certificate) certPath.getCertificates().get(i), f23014g));
            if (a != null) {
                Enumeration c = a.mo6861c();
                while (c.hasMoreElements()) {
                    ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) c.nextElement();
                    if (aSN1TaggedObject.m43030b() == 0) {
                        try {
                            if (ASN1Integer.m42964a(aSN1TaggedObject, false).m42968b().intValue() == 0) {
                                return 0;
                            }
                        } catch (int i22) {
                            throw new ExtCertPathValidatorException("Policy constraints requireExplicitPolicy field could not be decoded.", i22, certPath, i);
                        }
                    }
                }
            }
            return i22;
        } catch (int i222) {
            throw new ExtCertPathValidatorException("Policy constraints could not be decoded.", i222, certPath, i);
        }
    }

    /* renamed from: a */
    protected static void m28255a(CertPath certPath, int i, List list, Set set) {
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(i);
        for (PKIXCertPathChecker check : list) {
            try {
                check.check(x509Certificate, set);
            } catch (List list2) {
                throw new ExtCertPathValidatorException("Additional certificate path checker failed.", list2, certPath, i);
            }
        }
        if (set.isEmpty() == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Certificate has unsupported critical extension: ");
            stringBuilder.append(set);
            throw new ExtCertPathValidatorException(stringBuilder.toString(), null, certPath, i);
        }
    }

    /* renamed from: a */
    protected static PKIXPolicyNode m28252a(CertPath certPath, PKIXExtendedParameters pKIXExtendedParameters, Set set, int i, List[] listArr, PKIXPolicyNode pKIXPolicyNode, Set set2) {
        int size = certPath.getCertificates().size();
        if (pKIXPolicyNode != null) {
            CertPath<PKIXPolicyNode> hashSet;
            PKIXPolicyNode pKIXPolicyNode2;
            Iterator children;
            PKIXPolicyNode pKIXPolicyNode3;
            if (!CertPathValidatorUtilities.m28166a(set)) {
                hashSet = new HashSet();
                for (int i2 : listArr) {
                    for (set2 = null; set2 < i2.size(); set2++) {
                        pKIXPolicyNode2 = (PKIXPolicyNode) i2.get(set2);
                        if ("2.5.29.32.0".equals(pKIXPolicyNode2.getValidPolicy())) {
                            children = pKIXPolicyNode2.getChildren();
                            while (children.hasNext()) {
                                PKIXPolicyNode pKIXPolicyNode4 = (PKIXPolicyNode) children.next();
                                if (!"2.5.29.32.0".equals(pKIXPolicyNode4.getValidPolicy())) {
                                    hashSet.add(pKIXPolicyNode4);
                                }
                            }
                        }
                    }
                }
                for (PKIXPolicyNode pKIXPolicyNode5 : hashSet) {
                    if (set.contains(pKIXPolicyNode5.getValidPolicy()) == 0) {
                        pKIXPolicyNode = CertPathValidatorUtilities.m28157a(pKIXPolicyNode, listArr, pKIXPolicyNode5);
                    }
                }
                if (pKIXPolicyNode != null) {
                    for (size--; size >= 0; size--) {
                        certPath = listArr[size];
                        for (pKIXExtendedParameters = null; pKIXExtendedParameters < certPath.size(); pKIXExtendedParameters++) {
                            pKIXPolicyNode3 = (PKIXPolicyNode) certPath.get(pKIXExtendedParameters);
                            if (pKIXPolicyNode3.m28235a() == 0) {
                                pKIXPolicyNode = CertPathValidatorUtilities.m28157a(pKIXPolicyNode, listArr, pKIXPolicyNode3);
                            }
                        }
                    }
                }
            } else if (pKIXExtendedParameters.m27950l() != null) {
                if (set2.isEmpty() == null) {
                    hashSet = new HashSet();
                    for (Set set3 : listArr) {
                        for (i2 = 0; i2 < set3.size(); i2++) {
                            pKIXPolicyNode2 = (PKIXPolicyNode) set3.get(i2);
                            if ("2.5.29.32.0".equals(pKIXPolicyNode2.getValidPolicy())) {
                                children = pKIXPolicyNode2.getChildren();
                                while (children.hasNext()) {
                                    hashSet.add(children.next());
                                }
                            }
                        }
                    }
                    for (PKIXPolicyNode pKIXPolicyNode52 : hashSet) {
                        set2.contains(pKIXPolicyNode52.getValidPolicy());
                    }
                    if (pKIXPolicyNode != null) {
                        for (size--; size >= 0; size--) {
                            certPath = listArr[size];
                            for (pKIXExtendedParameters = null; pKIXExtendedParameters < certPath.size(); pKIXExtendedParameters++) {
                                pKIXPolicyNode3 = (PKIXPolicyNode) certPath.get(pKIXExtendedParameters);
                                if (pKIXPolicyNode3.m28235a() == 0) {
                                    pKIXPolicyNode = CertPathValidatorUtilities.m28157a(pKIXPolicyNode, listArr, pKIXPolicyNode3);
                                }
                            }
                        }
                    }
                } else {
                    throw new ExtCertPathValidatorException("Explicit policy requested but none available.", null, certPath, i2);
                }
            }
            return pKIXPolicyNode;
        } else if (pKIXExtendedParameters.m27950l() == null) {
            return null;
        } else {
            throw new ExtCertPathValidatorException("Explicit policy requested but none available.", null, certPath, i2);
        }
    }
}
