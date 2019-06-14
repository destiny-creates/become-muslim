package org.spongycastle.jce.provider;

import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertSelector;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.TargetInformation;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.jcajce.PKIXCRLStore;
import org.spongycastle.jcajce.PKIXCertStoreSelector;
import org.spongycastle.jcajce.PKIXExtendedBuilderParameters;
import org.spongycastle.jcajce.PKIXExtendedParameters;
import org.spongycastle.jcajce.PKIXExtendedParameters.Builder;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.x509.PKIXAttrCertChecker;
import org.spongycastle.x509.X509AttributeCertificate;
import org.spongycastle.x509.X509CertStoreSelector;

class RFC3281CertPathUtilities {
    /* renamed from: a */
    private static final String f23024a = X509Extensions.f31415E.m42986b();
    /* renamed from: b */
    private static final String f23025b = X509Extensions.f31414D.m42986b();
    /* renamed from: c */
    private static final String f23026c = X509Extensions.f31431p.m42986b();
    /* renamed from: d */
    private static final String f23027d = X509Extensions.f31439x.m42986b();

    RFC3281CertPathUtilities() {
    }

    /* renamed from: a */
    protected static void m28282a(X509AttributeCertificate x509AttributeCertificate, CertPath certPath, CertPath certPath2, PKIXExtendedParameters pKIXExtendedParameters, Set set) {
        pKIXExtendedParameters = x509AttributeCertificate.getCriticalExtensionOIDs();
        if (pKIXExtendedParameters.contains(f23024a)) {
            try {
                TargetInformation.m40451a(CertPathValidatorUtilities.m28155a((X509Extension) x509AttributeCertificate, f23024a));
            } catch (X509AttributeCertificate x509AttributeCertificate2) {
                throw new ExtCertPathValidatorException("Target information extension could not be read.", x509AttributeCertificate2);
            } catch (X509AttributeCertificate x509AttributeCertificate22) {
                throw new ExtCertPathValidatorException("Target information extension could not be read.", x509AttributeCertificate22);
            }
        }
        pKIXExtendedParameters.remove(f23024a);
        for (PKIXAttrCertChecker a : set) {
            a.m29463a(x509AttributeCertificate22, certPath, certPath2, pKIXExtendedParameters);
        }
        if (pKIXExtendedParameters.isEmpty() == null) {
            certPath = new StringBuilder();
            certPath.append("Attribute certificate contains unsupported critical extensions: ");
            certPath.append(pKIXExtendedParameters);
            throw new CertPathValidatorException(certPath.toString());
        }
    }

    /* renamed from: a */
    protected static void m28285a(X509AttributeCertificate x509AttributeCertificate, PKIXExtendedParameters pKIXExtendedParameters, X509Certificate x509Certificate, Date date, List list, JcaJceHelper jcaJceHelper) {
        ReasonsMask reasonsMask;
        Throwable e;
        X509Extension x509Extension = x509AttributeCertificate;
        if (!pKIXExtendedParameters.m27955q()) {
            return;
        }
        PKIXExtendedParameters a;
        CertStatus certStatus;
        Object obj;
        int i;
        int i2;
        if (x509Extension.getExtensionValue(f23025b) == null) {
            try {
                CRLDistPoint a2 = CRLDistPoint.m40262a(CertPathValidatorUtilities.m28155a(x509Extension, f23026c));
                List arrayList = new ArrayList();
                try {
                    arrayList.addAll(CertPathValidatorUtilities.m28149a(a2, pKIXExtendedParameters.m27942d()));
                    Builder builder = new Builder(pKIXExtendedParameters);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        builder.m27924a((PKIXCRLStore) arrayList);
                    }
                    a = builder.m27928a();
                    certStatus = new CertStatus();
                    reasonsMask = new ReasonsMask();
                    int i3 = 11;
                    if (a2 != null) {
                        try {
                            DistributionPoint[] a3 = a2.m40263a();
                            int i4 = 0;
                            obj = null;
                            while (i4 < a3.length && certStatus.m28171b() == r9 && !reasonsMask.m28288a()) {
                                try {
                                    int i5 = i4;
                                    i = 0;
                                    i2 = 11;
                                    try {
                                        m28281a(a3[i4], x509AttributeCertificate, (PKIXExtendedParameters) a.clone(), date, x509Certificate, certStatus, reasonsMask, list, jcaJceHelper);
                                        i4 = i5 + 1;
                                        i3 = 11;
                                        obj = 1;
                                    } catch (AnnotatedException e2) {
                                        e = e2;
                                    }
                                } catch (AnnotatedException e3) {
                                    e = e3;
                                    i = 0;
                                    i2 = 11;
                                }
                            }
                            i = 0;
                            i2 = 11;
                            e = null;
                        } catch (Throwable e4) {
                            throw new ExtCertPathValidatorException("Distribution points could not be read.", e4);
                        }
                    }
                    i = 0;
                    i2 = 11;
                    e4 = null;
                    obj = null;
                    if (certStatus.m28171b() == i2 && !reasonsMask.m28288a()) {
                        try {
                            m28281a(new DistributionPoint(new DistributionPointName(i, new GeneralNames(new GeneralName(4, new ASN1InputStream(((X500Principal) x509AttributeCertificate.mo5947d().m36618a()[i]).getEncoded()).m34595d()))), null, null), x509AttributeCertificate, (PKIXExtendedParameters) a.clone(), date, x509Certificate, certStatus, reasonsMask, list, jcaJceHelper);
                            obj = 1;
                        } catch (Throwable e42) {
                            throw new AnnotatedException("Issuer from certificate for CRL could not be reencoded.", e42);
                        } catch (Throwable e422) {
                            e422 = new AnnotatedException("No valid CRL for distribution point found.", e422);
                        }
                    }
                    if (obj != null) {
                        throw new ExtCertPathValidatorException("No valid CRL found.", e422);
                    } else if (certStatus.m28171b() != i2) {
                        if (!reasonsMask.m28288a() && certStatus.m28171b() == i2) {
                            certStatus.m28169a(12);
                        }
                        if (certStatus.m28171b() != 12) {
                            throw new CertPathValidatorException("Attribute certificate status could not be determined.");
                        }
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Attribute certificate revocation after ");
                        stringBuilder.append(certStatus.m28168a());
                        String stringBuilder2 = stringBuilder.toString();
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(stringBuilder2);
                        stringBuilder3.append(", reason: ");
                        stringBuilder3.append(RFC3280CertPathUtilities.f23022o[certStatus.m28171b()]);
                        throw new CertPathValidatorException(stringBuilder3.toString());
                    }
                } catch (Throwable e4222) {
                    throw new CertPathValidatorException("No additional CRL locations could be decoded from CRL distribution point extension.", e4222);
                }
            } catch (Throwable e42222) {
                throw new CertPathValidatorException("CRL distribution point extension could not be read.", e42222);
            }
        } else if (x509Extension.getExtensionValue(f23026c) != null || x509Extension.getExtensionValue(f23027d) != null) {
            throw new CertPathValidatorException("No rev avail extension is set, but also an AC revocation pointer.");
        } else {
            return;
        }
        e42222 = new AnnotatedException("No valid CRL for distribution point found.", e42222);
        m28281a(new DistributionPoint(new DistributionPointName(i, new GeneralNames(new GeneralName(4, new ASN1InputStream(((X500Principal) x509AttributeCertificate.mo5947d().m36618a()[i]).getEncoded()).m34595d()))), null, null), x509AttributeCertificate, (PKIXExtendedParameters) a.clone(), date, x509Certificate, certStatus, reasonsMask, list, jcaJceHelper);
        obj = 1;
        if (obj != null) {
            throw new ExtCertPathValidatorException("No valid CRL found.", e42222);
        } else if (certStatus.m28171b() != i2) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Attribute certificate revocation after ");
            stringBuilder4.append(certStatus.m28168a());
            String stringBuilder22 = stringBuilder4.toString();
            StringBuilder stringBuilder32 = new StringBuilder();
            stringBuilder32.append(stringBuilder22);
            stringBuilder32.append(", reason: ");
            stringBuilder32.append(RFC3280CertPathUtilities.f23022o[certStatus.m28171b()]);
            throw new CertPathValidatorException(stringBuilder32.toString());
        } else {
            certStatus.m28169a(12);
            if (certStatus.m28171b() != 12) {
                throw new CertPathValidatorException("Attribute certificate status could not be determined.");
            }
        }
    }

    /* renamed from: a */
    protected static void m28283a(X509AttributeCertificate x509AttributeCertificate, Set set, Set set2) {
        for (String str : set) {
            if (x509AttributeCertificate.mo5944a(str) != null) {
                set = new StringBuilder();
                set.append("Attribute certificate contains prohibited attribute: ");
                set.append(str);
                set.append(".");
                throw new CertPathValidatorException(set.toString());
            }
        }
        for (String str2 : set2) {
            if (x509AttributeCertificate.mo5944a(str2) == null) {
                set = new StringBuilder();
                set.append("Attribute certificate does not contain necessary attribute: ");
                set.append(str2);
                set.append(".");
                throw new CertPathValidatorException(set.toString());
            }
        }
    }

    /* renamed from: a */
    protected static void m28284a(X509AttributeCertificate x509AttributeCertificate, PKIXExtendedParameters pKIXExtendedParameters) {
        try {
            x509AttributeCertificate.mo5943a(CertPathValidatorUtilities.m28147a(pKIXExtendedParameters));
        } catch (X509AttributeCertificate x509AttributeCertificate2) {
            throw new ExtCertPathValidatorException("Attribute certificate is not valid.", x509AttributeCertificate2);
        } catch (X509AttributeCertificate x509AttributeCertificate22) {
            throw new ExtCertPathValidatorException("Attribute certificate is not valid.", x509AttributeCertificate22);
        }
    }

    /* renamed from: a */
    protected static void m28279a(X509Certificate x509Certificate, Set set) {
        Object obj = null;
        for (TrustAnchor trustAnchor : set) {
            if (x509Certificate.getSubjectX500Principal().getName("RFC2253").equals(trustAnchor.getCAName()) || x509Certificate.equals(trustAnchor.getTrustedCert())) {
                obj = 1;
            }
        }
        if (obj == null) {
            throw new CertPathValidatorException("Attribute certificate issuer is not directly trusted.");
        }
    }

    /* renamed from: a */
    protected static void m28280a(X509Certificate x509Certificate, PKIXExtendedParameters pKIXExtendedParameters) {
        if (x509Certificate.getKeyUsage() != null && x509Certificate.getKeyUsage()[0] == null) {
            if (x509Certificate.getKeyUsage()[1] == null) {
                throw new CertPathValidatorException("Attribute certificate issuer public key cannot be used to validate digital signatures.");
            }
        }
        if (x509Certificate.getBasicConstraints() != -1) {
            throw new CertPathValidatorException("Attribute certificate issuer is also a public key certificate issuer.");
        }
    }

    /* renamed from: a */
    protected static CertPathValidatorResult m28278a(CertPath certPath, PKIXExtendedParameters pKIXExtendedParameters) {
        try {
            try {
                return CertPathValidator.getInstance("PKIX", "SC").validate(certPath, pKIXExtendedParameters);
            } catch (CertPath certPath2) {
                throw new ExtCertPathValidatorException("Certification path for issuer certificate of attribute certificate could not be validated.", certPath2);
            } catch (CertPath certPath22) {
                throw new RuntimeException(certPath22.getMessage());
            }
        } catch (CertPath certPath222) {
            throw new ExtCertPathValidatorException("Support class could not be created.", certPath222);
        } catch (CertPath certPath2222) {
            throw new ExtCertPathValidatorException("Support class could not be created.", certPath2222);
        }
    }

    /* renamed from: b */
    protected static CertPath m28286b(X509AttributeCertificate x509AttributeCertificate, PKIXExtendedParameters pKIXExtendedParameters) {
        CertSelector x509CertSelector;
        Set<X509Certificate> hashSet = new HashSet();
        int i = 0;
        if (x509AttributeCertificate.mo5946c().m36613e() != null) {
            x509CertSelector = new X509CertSelector();
            x509CertSelector.setSerialNumber(x509AttributeCertificate.mo5946c().m36614f());
            Principal[] e = x509AttributeCertificate.mo5946c().m36613e();
            int i2 = 0;
            while (i2 < e.length) {
                try {
                    if (e[i2] instanceof X500Principal) {
                        x509CertSelector.setIssuer(((X500Principal) e[i2]).getEncoded());
                    }
                    hashSet.addAll(CertPathValidatorUtilities.m28146a(new PKIXCertStoreSelector.Builder(x509CertSelector).m27901a(), pKIXExtendedParameters.m27954p()));
                    i2++;
                } catch (X509AttributeCertificate x509AttributeCertificate2) {
                    throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", x509AttributeCertificate2);
                } catch (X509AttributeCertificate x509AttributeCertificate22) {
                    throw new ExtCertPathValidatorException("Unable to encode X500 principal.", x509AttributeCertificate22);
                }
            }
            if (hashSet.isEmpty()) {
                throw new CertPathValidatorException("Public key certificate specified in base certificate ID for attribute certificate cannot be found.");
            }
        }
        if (x509AttributeCertificate22.mo5946c().m36612d() != null) {
            x509CertSelector = new X509CertStoreSelector();
            x509AttributeCertificate22 = x509AttributeCertificate22.mo5946c().m36612d();
            while (i < x509AttributeCertificate22.length) {
                try {
                    if (x509AttributeCertificate22[i] instanceof X500Principal) {
                        x509CertSelector.setIssuer(((X500Principal) x509AttributeCertificate22[i]).getEncoded());
                    }
                    hashSet.addAll(CertPathValidatorUtilities.m28146a(new PKIXCertStoreSelector.Builder(x509CertSelector).m27901a(), pKIXExtendedParameters.m27954p()));
                    i++;
                } catch (X509AttributeCertificate x509AttributeCertificate222) {
                    throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", x509AttributeCertificate222);
                } catch (X509AttributeCertificate x509AttributeCertificate2222) {
                    throw new ExtCertPathValidatorException("Unable to encode X500 principal.", x509AttributeCertificate2222);
                }
            }
            if (hashSet.isEmpty() != null) {
                throw new CertPathValidatorException("Public key certificate specified in entity name for attribute certificate cannot be found.");
            }
        }
        x509AttributeCertificate2222 = new Builder(pKIXExtendedParameters);
        ExtCertPathValidatorException extCertPathValidatorException = null;
        CertPathBuilderResult certPathBuilderResult = null;
        for (X509Certificate certificate : hashSet) {
            CertSelector x509CertStoreSelector = new X509CertStoreSelector();
            x509CertStoreSelector.setCertificate(certificate);
            x509AttributeCertificate2222.m27926a(new PKIXCertStoreSelector.Builder(x509CertStoreSelector).m27901a());
            try {
                try {
                    certPathBuilderResult = CertPathBuilder.getInstance("PKIX", "SC").build(new PKIXExtendedBuilderParameters.Builder(x509AttributeCertificate2222.m27928a()).m27907a());
                } catch (Throwable e2) {
                    extCertPathValidatorException = new ExtCertPathValidatorException("Certification path for public key certificate of attribute certificate could not be build.", e2);
                } catch (X509AttributeCertificate x509AttributeCertificate22222) {
                    throw new RuntimeException(x509AttributeCertificate22222.getMessage());
                }
            } catch (X509AttributeCertificate x509AttributeCertificate222222) {
                throw new ExtCertPathValidatorException("Support class could not be created.", x509AttributeCertificate222222);
            } catch (X509AttributeCertificate x509AttributeCertificate2222222) {
                throw new ExtCertPathValidatorException("Support class could not be created.", x509AttributeCertificate2222222);
            }
        }
        if (extCertPathValidatorException == null) {
            return certPathBuilderResult.getCertPath();
        }
        throw extCertPathValidatorException;
    }

    /* renamed from: a */
    private static void m28281a(DistributionPoint distributionPoint, X509AttributeCertificate x509AttributeCertificate, PKIXExtendedParameters pKIXExtendedParameters, Date date, X509Certificate x509Certificate, CertStatus certStatus, ReasonsMask reasonsMask, List list, JcaJceHelper jcaJceHelper) {
        Iterator it;
        DistributionPoint distributionPoint2 = distributionPoint;
        Object obj = x509AttributeCertificate;
        PKIXExtendedParameters pKIXExtendedParameters2 = pKIXExtendedParameters;
        Date date2 = date;
        CertStatus certStatus2 = certStatus;
        ReasonsMask reasonsMask2 = reasonsMask;
        if (obj.getExtensionValue(X509Extensions.f31414D.m42986b()) == null) {
            Date date3 = new Date(System.currentTimeMillis());
            if (date.getTime() <= date3.getTime()) {
                Iterator it2 = CertPathValidatorUtilities.m28153a(distributionPoint2, obj, date3, pKIXExtendedParameters2).iterator();
                AnnotatedException annotatedException = null;
                Object obj2 = null;
                while (it2.hasNext() && certStatus.m28171b() == 11 && !reasonsMask.m28288a()) {
                    try {
                        X509CRL x509crl = (X509CRL) it2.next();
                        ReasonsMask a = RFC3280CertPathUtilities.m28253a(x509crl, distributionPoint2);
                        if (a.m28291c(reasonsMask2)) {
                            ReasonsMask reasonsMask3 = a;
                            X509CRL x509crl2 = x509crl;
                            it = it2;
                            try {
                                X509CRL a2;
                                X509CRL x509crl3 = x509crl2;
                                PublicKey a3 = RFC3280CertPathUtilities.m28246a(x509crl3, RFC3280CertPathUtilities.m28248a(x509crl, (Object) x509AttributeCertificate, null, null, pKIXExtendedParameters, list, jcaJceHelper));
                                if (pKIXExtendedParameters.m27944f()) {
                                    a2 = RFC3280CertPathUtilities.m28247a(CertPathValidatorUtilities.m28151a(date3, x509crl3, pKIXExtendedParameters.m27954p(), pKIXExtendedParameters.m27941c()), a3);
                                } else {
                                    a2 = null;
                                }
                                if (pKIXExtendedParameters.m27945g() != 1) {
                                    if (x509AttributeCertificate.mo5945b().getTime() < x509crl3.getThisUpdate().getTime()) {
                                        throw new AnnotatedException("No valid CRL for current time found.");
                                    }
                                }
                                RFC3280CertPathUtilities.m28269b(distributionPoint2, obj, x509crl3);
                                RFC3280CertPathUtilities.m28263a(distributionPoint2, obj, x509crl3);
                                RFC3280CertPathUtilities.m28260a(a2, x509crl3, pKIXExtendedParameters2);
                                RFC3280CertPathUtilities.m28262a(date2, a2, obj, certStatus2, pKIXExtendedParameters2);
                                RFC3280CertPathUtilities.m28261a(date2, x509crl3, obj, certStatus2);
                                if (certStatus.m28171b() == 8) {
                                    certStatus2.m28169a(11);
                                }
                                reasonsMask2.m28287a(reasonsMask3);
                                it2 = it;
                                obj2 = 1;
                            } catch (AnnotatedException e) {
                                annotatedException = e;
                                it2 = it;
                            }
                        }
                    } catch (AnnotatedException e2) {
                        annotatedException = e2;
                        it = it2;
                        it2 = it;
                    }
                }
                if (obj2 == null) {
                    throw annotatedException;
                }
                return;
            }
            throw new AnnotatedException("Validation time is in future.");
        }
    }
}
