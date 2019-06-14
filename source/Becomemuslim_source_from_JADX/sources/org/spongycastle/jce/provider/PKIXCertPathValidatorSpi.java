package org.spongycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.jcajce.PKIXExtendedBuilderParameters;
import org.spongycastle.jcajce.PKIXExtendedParameters;
import org.spongycastle.jcajce.PKIXExtendedParameters.Builder;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.x509.ExtendedPKIXParameters;

public class PKIXCertPathValidatorSpi extends CertPathValidatorSpi {
    /* renamed from: a */
    private final JcaJceHelper f22990a = new BCJcaJceHelper();

    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) {
        PKIXExtendedParameters a;
        Throwable e;
        PKIXCertPathValidatorSpi pKIXCertPathValidatorSpi = this;
        CertPath certPath2 = certPath;
        CertPathParameters certPathParameters2 = certPathParameters;
        if (certPathParameters2 instanceof PKIXParameters) {
            Builder builder = new Builder((PKIXParameters) certPathParameters2);
            if (certPathParameters2 instanceof ExtendedPKIXParameters) {
                ExtendedPKIXParameters extendedPKIXParameters = (ExtendedPKIXParameters) certPathParameters2;
                builder.m27927a(extendedPKIXParameters.m29455c());
                builder.m27922a(extendedPKIXParameters.m29456d());
            }
            a = builder.m27928a();
        } else if (certPathParameters2 instanceof PKIXExtendedBuilderParameters) {
            a = ((PKIXExtendedBuilderParameters) certPathParameters2).m27908a();
        } else if (certPathParameters2 instanceof PKIXExtendedParameters) {
            a = (PKIXExtendedParameters) certPathParameters2;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Parameters must be a ");
            stringBuilder.append(PKIXParameters.class.getName());
            stringBuilder.append(" instance.");
            throw new InvalidAlgorithmParameterException(stringBuilder.toString());
        }
        int i;
        if (a.m27947i() != null) {
            List certificates = certPath.getCertificates();
            int size = certificates.size();
            if (certificates.isEmpty()) {
                throw new CertPathValidatorException("Certification path is empty.", null, certPath2, -1);
            }
            Set j = a.m27948j();
            try {
                TrustAnchor a2 = CertPathValidatorUtilities.m28144a((X509Certificate) certificates.get(certificates.size() - 1), a.m27947i(), a.m27949k());
                if (a2 != null) {
                    int i2;
                    X500Name a3;
                    PublicKey publicKey;
                    a = new Builder(a).m27923a(a2).m27928a();
                    int i3 = size + 1;
                    ArrayList[] arrayListArr = new ArrayList[i3];
                    for (i2 = 0; i2 < arrayListArr.length; i2++) {
                        arrayListArr[i2] = new ArrayList();
                    }
                    Set hashSet = new HashSet();
                    hashSet.add("2.5.29.32.0");
                    PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), 0, hashSet, null, new HashSet(), "2.5.29.32.0", false);
                    arrayListArr[0].add(pKIXPolicyNode);
                    PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
                    HashSet hashSet2 = new HashSet();
                    i2 = a.m27950l() ? 0 : i3;
                    int i4 = a.m27951m() ? 0 : i3;
                    if (a.m27952n()) {
                        i3 = 0;
                    }
                    X509Certificate trustedCert = a2.getTrustedCert();
                    if (trustedCert != null) {
                        try {
                            a3 = PrincipalUtils.m28242a(trustedCert);
                            publicKey = trustedCert.getPublicKey();
                        } catch (Throwable e2) {
                            throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", e2, certPath2, -1);
                        }
                    }
                    a3 = PrincipalUtils.m28240a(a2);
                    publicKey = a2.getCAPublicKey();
                    try {
                        X509Certificate x509Certificate;
                        Set set;
                        PKIXExtendedParameters pKIXExtendedParameters;
                        TrustAnchor trustAnchor;
                        List[] listArr;
                        AlgorithmIdentifier a4 = CertPathValidatorUtilities.m28156a(publicKey);
                        a4.m40230a();
                        a4.m40231b();
                        if (a.m27946h() != null) {
                            if (!a.m27946h().m35980a((X509Certificate) certificates.get(0))) {
                                throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", null, certPath2, 0);
                            }
                        }
                        List<PKIXCertPathChecker> o = a.m27953o();
                        for (PKIXCertPathChecker init : o) {
                            init.init(false);
                        }
                        int i5 = i3;
                        int i6 = size;
                        i3 = i4;
                        PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNode;
                        int size2 = certificates.size() - 1;
                        X509Certificate x509Certificate2 = null;
                        while (size2 >= 0) {
                            int i7 = size - size2;
                            x509Certificate = (X509Certificate) certificates.get(size2);
                            boolean z = size2 == certificates.size() + -1;
                            JcaJceHelper jcaJceHelper = pKIXCertPathValidatorSpi.f22990a;
                            int i8 = i3;
                            CertPath certPath3 = certPath;
                            List list = certificates;
                            int i9 = i7;
                            set = j;
                            int i10 = i2;
                            int i11 = size2;
                            pKIXExtendedParameters = a;
                            PKIXNameConstraintValidator pKIXNameConstraintValidator2 = pKIXNameConstraintValidator;
                            ArrayList[] arrayListArr2 = arrayListArr;
                            trustAnchor = a2;
                            RFC3280CertPathUtilities.m28259a(certPath3, a, size2, publicKey, z, a3, trustedCert, jcaJceHelper);
                            RFC3280CertPathUtilities.m28257a(certPath2, i11, pKIXNameConstraintValidator2);
                            PKIXPolicyNode a5 = RFC3280CertPathUtilities.m28250a(certPath2, i11, RFC3280CertPathUtilities.m28249a(certPath3, i11, hashSet2, pKIXPolicyNode2, arrayListArr2, i8));
                            RFC3280CertPathUtilities.m28258a(certPath2, i11, a5, i10);
                            int e3;
                            if (i9 != size) {
                                Set hashSet3;
                                if (x509Certificate != null) {
                                    if (x509Certificate.getVersion() == 1) {
                                        throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", null, certPath2, i11);
                                    }
                                }
                                RFC3280CertPathUtilities.m28254a(certPath2, i11);
                                i7 = i5;
                                listArr = arrayListArr2;
                                a5 = RFC3280CertPathUtilities.m28251a(certPath2, i11, listArr, a5, i7);
                                RFC3280CertPathUtilities.m28268b(certPath2, i11, pKIXNameConstraintValidator2);
                                i2 = RFC3280CertPathUtilities.m28274f(certPath2, i11, i10);
                                i7 = RFC3280CertPathUtilities.m28275g(certPath2, i11, i7);
                                size2 = RFC3280CertPathUtilities.m28276h(certPath2, i11, i8);
                                i2 = RFC3280CertPathUtilities.m28245a(certPath2, i11, i2);
                                i7 = RFC3280CertPathUtilities.m28266b(certPath2, i11, i7);
                                size2 = RFC3280CertPathUtilities.m28270c(certPath2, i11, size2);
                                RFC3280CertPathUtilities.m28267b(certPath2, i11);
                                e3 = RFC3280CertPathUtilities.m28273e(certPath2, i11, RFC3280CertPathUtilities.m28272d(certPath2, i11, i6));
                                RFC3280CertPathUtilities.m28271c(certPath2, i11);
                                Collection criticalExtensionOIDs = x509Certificate.getCriticalExtensionOIDs();
                                if (criticalExtensionOIDs != null) {
                                    hashSet3 = new HashSet(criticalExtensionOIDs);
                                    hashSet3.remove(RFC3280CertPathUtilities.f23020m);
                                    hashSet3.remove(RFC3280CertPathUtilities.f23008a);
                                    hashSet3.remove(RFC3280CertPathUtilities.f23009b);
                                    hashSet3.remove(RFC3280CertPathUtilities.f23010c);
                                    hashSet3.remove(RFC3280CertPathUtilities.f23011d);
                                    hashSet3.remove(RFC3280CertPathUtilities.f23013f);
                                    hashSet3.remove(RFC3280CertPathUtilities.f23014g);
                                    hashSet3.remove(RFC3280CertPathUtilities.f23015h);
                                    hashSet3.remove(RFC3280CertPathUtilities.f23017j);
                                    hashSet3.remove(RFC3280CertPathUtilities.f23018k);
                                } else {
                                    hashSet3 = new HashSet();
                                }
                                RFC3280CertPathUtilities.m28256a(certPath2, i11, hashSet3, (List) o);
                                a3 = PrincipalUtils.m28242a(x509Certificate);
                                try {
                                    i = i11;
                                    try {
                                        publicKey = CertPathValidatorUtilities.m28143a(certPath.getCertificates(), i, this.f22990a);
                                        AlgorithmIdentifier a6 = CertPathValidatorUtilities.m28156a(publicKey);
                                        a6.m40230a();
                                        a6.m40231b();
                                        pKIXPolicyNode2 = a5;
                                        i5 = i7;
                                        i3 = size2;
                                        i6 = e3;
                                        trustedCert = x509Certificate;
                                    } catch (CertPathValidatorException e4) {
                                        e2 = e4;
                                    }
                                } catch (CertPathValidatorException e5) {
                                    e2 = e5;
                                    i = i11;
                                    pKIXCertPathValidatorSpi = this;
                                }
                            } else {
                                i = i11;
                                i7 = i5;
                                e3 = i6;
                                listArr = arrayListArr2;
                                pKIXCertPathValidatorSpi = this;
                                pKIXPolicyNode2 = a5;
                                i3 = i8;
                                i2 = i10;
                            }
                            size2 = i - 1;
                            List[] listArr2 = listArr;
                            x509Certificate2 = x509Certificate;
                            certificates = list;
                            j = set;
                            a2 = trustAnchor;
                            pKIXNameConstraintValidator = pKIXNameConstraintValidator2;
                            a = pKIXExtendedParameters;
                        }
                        pKIXExtendedParameters = a;
                        listArr = arrayListArr;
                        trustAnchor = a2;
                        set = j;
                        i = size2;
                        size2 = i + 1;
                        int i12 = RFC3280CertPathUtilities.m28277i(certPath2, size2, RFC3280CertPathUtilities.m28244a(i2, x509Certificate2));
                        Collection criticalExtensionOIDs2 = x509Certificate2.getCriticalExtensionOIDs();
                        if (criticalExtensionOIDs2 != null) {
                            hashSet = new HashSet(criticalExtensionOIDs2);
                            hashSet.remove(RFC3280CertPathUtilities.f23020m);
                            hashSet.remove(RFC3280CertPathUtilities.f23008a);
                            hashSet.remove(RFC3280CertPathUtilities.f23009b);
                            hashSet.remove(RFC3280CertPathUtilities.f23010c);
                            hashSet.remove(RFC3280CertPathUtilities.f23011d);
                            hashSet.remove(RFC3280CertPathUtilities.f23013f);
                            hashSet.remove(RFC3280CertPathUtilities.f23014g);
                            hashSet.remove(RFC3280CertPathUtilities.f23015h);
                            hashSet.remove(RFC3280CertPathUtilities.f23017j);
                            hashSet.remove(RFC3280CertPathUtilities.f23018k);
                            hashSet.remove(RFC3280CertPathUtilities.f23016i);
                            hashSet.remove(Extension.f31297u.m42986b());
                        } else {
                            hashSet = new HashSet();
                        }
                        RFC3280CertPathUtilities.m28255a(certPath2, size2, (List) o, hashSet);
                        x509Certificate = x509Certificate2;
                        PolicyNode a7 = RFC3280CertPathUtilities.m28252a(certPath, pKIXExtendedParameters, set, size2, listArr, pKIXPolicyNode2, (Set) hashSet2);
                        if (i12 <= 0) {
                            if (a7 == null) {
                                throw new CertPathValidatorException("Path processing failed on policy.", null, certPath2, i);
                            }
                        }
                        return new PKIXCertPathValidatorResult(trustAnchor, a7, x509Certificate.getPublicKey());
                    } catch (Throwable e22) {
                        throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", e22, certPath2, -1);
                    }
                }
                throw new CertPathValidatorException("Trust anchor for certification path not found.", null, certPath2, -1);
            } catch (Throwable e222) {
                throw new CertPathValidatorException(e222.getMessage(), e222, certPath2, certificates.size() - 1);
            }
        }
        throw new InvalidAlgorithmParameterException("trustAnchors is null, this is not allowed for certification path validation.");
        throw new CertPathValidatorException("Next working key could not be retrieved.", e222, certPath2, i);
    }
}
