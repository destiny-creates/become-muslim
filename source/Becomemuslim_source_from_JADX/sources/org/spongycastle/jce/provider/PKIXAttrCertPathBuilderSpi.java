package org.spongycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.Principal;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.CertSelector;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.jcajce.PKIXCertStoreSelector;
import org.spongycastle.jcajce.PKIXExtendedBuilderParameters;
import org.spongycastle.jcajce.PKIXExtendedBuilderParameters.Builder;
import org.spongycastle.jce.exception.ExtCertPathBuilderException;
import org.spongycastle.util.Store;
import org.spongycastle.x509.ExtendedPKIXBuilderParameters;
import org.spongycastle.x509.ExtendedPKIXParameters;
import org.spongycastle.x509.X509AttributeCertStoreSelector;
import org.spongycastle.x509.X509AttributeCertificate;
import org.spongycastle.x509.X509CertStoreSelector;

public class PKIXAttrCertPathBuilderSpi extends CertPathBuilderSpi {
    /* renamed from: a */
    private Exception f22987a;

    public CertPathBuilderResult engineBuild(CertPathParameters certPathParameters) {
        boolean z = certPathParameters instanceof PKIXBuilderParameters;
        if (!(z || (certPathParameters instanceof ExtendedPKIXBuilderParameters))) {
            if (!(certPathParameters instanceof PKIXExtendedBuilderParameters)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Parameters must be an instance of ");
                stringBuilder.append(PKIXBuilderParameters.class.getName());
                stringBuilder.append(" or ");
                stringBuilder.append(PKIXExtendedBuilderParameters.class.getName());
                stringBuilder.append(".");
                throw new InvalidAlgorithmParameterException(stringBuilder.toString());
            }
        }
        List arrayList = new ArrayList();
        if (z) {
            Builder builder = new Builder((PKIXBuilderParameters) certPathParameters);
            if (certPathParameters instanceof ExtendedPKIXParameters) {
                ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) certPathParameters;
                builder.m27906a(extendedPKIXBuilderParameters.m36619a());
                builder.m27905a(extendedPKIXBuilderParameters.m36621b());
                arrayList = extendedPKIXBuilderParameters.m29458f();
            }
            certPathParameters = builder.m27907a();
        } else {
            certPathParameters = (PKIXExtendedBuilderParameters) certPathParameters;
        }
        List arrayList2 = new ArrayList();
        PKIXCertStoreSelector h = certPathParameters.m27908a().m27946h();
        if (h instanceof X509AttributeCertStoreSelector) {
            try {
                Collection a = m28177a((X509AttributeCertStoreSelector) h, arrayList);
                if (a.isEmpty()) {
                    throw new CertPathBuilderException("No attribute certificate found matching targetContraints.");
                }
                CertPathBuilderResult certPathBuilderResult = null;
                Iterator it = a.iterator();
                while (it.hasNext() && certPathBuilderResult == null) {
                    X509AttributeCertificate x509AttributeCertificate = (X509AttributeCertificate) it.next();
                    CertSelector x509CertStoreSelector = new X509CertStoreSelector();
                    Principal[] a2 = x509AttributeCertificate.mo5947d().m36618a();
                    Set hashSet = new HashSet();
                    int i = 0;
                    while (i < a2.length) {
                        try {
                            if (a2[i] instanceof X500Principal) {
                                x509CertStoreSelector.setSubject(((X500Principal) a2[i]).getEncoded());
                            }
                            PKIXCertStoreSelector a3 = new PKIXCertStoreSelector.Builder(x509CertStoreSelector).m27901a();
                            hashSet.addAll(CertPathValidatorUtilities.m28146a(a3, certPathParameters.m27908a().m27954p()));
                            hashSet.addAll(CertPathValidatorUtilities.m28146a(a3, certPathParameters.m27908a().m27939a()));
                            i++;
                        } catch (CertPathParameters certPathParameters2) {
                            throw new ExtCertPathBuilderException("Public key certificate for attribute certificate cannot be searched.", certPathParameters2);
                        } catch (CertPathParameters certPathParameters22) {
                            throw new ExtCertPathBuilderException("cannot encode X500Principal.", certPathParameters22);
                        }
                    }
                    if (hashSet.isEmpty()) {
                        throw new CertPathBuilderException("Public key certificate for attribute certificate cannot be found.");
                    }
                    Iterator it2 = hashSet.iterator();
                    while (it2.hasNext() && r2 == null) {
                        certPathBuilderResult = m28176a(x509AttributeCertificate, (X509Certificate) it2.next(), certPathParameters22, arrayList2);
                    }
                }
                if (certPathBuilderResult == null) {
                    if (this.f22987a != null) {
                        throw new ExtCertPathBuilderException("Possible certificate chain could not be validated.", this.f22987a);
                    }
                }
                if (certPathBuilderResult == null) {
                    if (this.f22987a == null) {
                        throw new CertPathBuilderException("Unable to find certificate chain.");
                    }
                }
                return certPathBuilderResult;
            } catch (CertPathParameters certPathParameters222) {
                throw new ExtCertPathBuilderException("Error finding target attribute certificate.", certPathParameters222);
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("TargetConstraints must be an instance of ");
        stringBuilder.append(X509AttributeCertStoreSelector.class.getName());
        stringBuilder.append(" for ");
        stringBuilder.append(getClass().getName());
        stringBuilder.append(" class.");
        throw new CertPathBuilderException(stringBuilder.toString());
    }

    /* renamed from: a */
    private java.security.cert.CertPathBuilderResult m28176a(org.spongycastle.x509.X509AttributeCertificate r6, java.security.cert.X509Certificate r7, org.spongycastle.jcajce.PKIXExtendedBuilderParameters r8, java.util.List r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r9.contains(r7);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = r8.m27909b();
        r0 = r0.contains(r7);
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return r1;
    L_0x0013:
        r0 = r8.m27910c();
        r2 = -1;
        if (r0 == r2) goto L_0x0027;
    L_0x001a:
        r0 = r9.size();
        r0 = r0 + -1;
        r2 = r8.m27910c();
        if (r0 <= r2) goto L_0x0027;
    L_0x0026:
        return r1;
    L_0x0027:
        r9.add(r7);
        r0 = "X.509";	 Catch:{ Exception -> 0x0112 }
        r2 = "SC";	 Catch:{ Exception -> 0x0112 }
        r0 = java.security.cert.CertificateFactory.getInstance(r0, r2);	 Catch:{ Exception -> 0x0112 }
        r2 = "RFC3281";	 Catch:{ Exception -> 0x0112 }
        r3 = "SC";	 Catch:{ Exception -> 0x0112 }
        r2 = java.security.cert.CertPathValidator.getInstance(r2, r3);	 Catch:{ Exception -> 0x0112 }
        r3 = r8.m27908a();	 Catch:{ AnnotatedException -> 0x0102 }
        r3 = r3.m27947i();	 Catch:{ AnnotatedException -> 0x0102 }
        r4 = r8.m27908a();	 Catch:{ AnnotatedException -> 0x0102 }
        r4 = r4.m27949k();	 Catch:{ AnnotatedException -> 0x0102 }
        r3 = org.spongycastle.jce.provider.CertPathValidatorUtilities.m28144a(r7, r3, r4);	 Catch:{ AnnotatedException -> 0x0102 }
        if (r3 == 0) goto L_0x007e;
    L_0x0050:
        r6 = r0.generateCertPath(r9);	 Catch:{ Exception -> 0x0075 }
        r8 = r2.validate(r6, r8);	 Catch:{ Exception -> 0x006c }
        r8 = (java.security.cert.PKIXCertPathValidatorResult) r8;	 Catch:{ Exception -> 0x006c }
        r0 = new java.security.cert.PKIXCertPathBuilderResult;	 Catch:{ AnnotatedException -> 0x0102 }
        r2 = r8.getTrustAnchor();	 Catch:{ AnnotatedException -> 0x0102 }
        r3 = r8.getPolicyTree();	 Catch:{ AnnotatedException -> 0x0102 }
        r8 = r8.getPublicKey();	 Catch:{ AnnotatedException -> 0x0102 }
        r0.<init>(r6, r2, r3, r8);	 Catch:{ AnnotatedException -> 0x0102 }
        return r0;	 Catch:{ AnnotatedException -> 0x0102 }
    L_0x006c:
        r6 = move-exception;	 Catch:{ AnnotatedException -> 0x0102 }
        r8 = new org.spongycastle.jce.provider.AnnotatedException;	 Catch:{ AnnotatedException -> 0x0102 }
        r0 = "Certification path could not be validated.";	 Catch:{ AnnotatedException -> 0x0102 }
        r8.<init>(r0, r6);	 Catch:{ AnnotatedException -> 0x0102 }
        throw r8;	 Catch:{ AnnotatedException -> 0x0102 }
    L_0x0075:
        r6 = move-exception;	 Catch:{ AnnotatedException -> 0x0102 }
        r8 = new org.spongycastle.jce.provider.AnnotatedException;	 Catch:{ AnnotatedException -> 0x0102 }
        r0 = "Certification path could not be constructed from certificate list.";	 Catch:{ AnnotatedException -> 0x0102 }
        r8.<init>(r0, r6);	 Catch:{ AnnotatedException -> 0x0102 }
        throw r8;	 Catch:{ AnnotatedException -> 0x0102 }
    L_0x007e:
        r0 = new java.util.ArrayList;	 Catch:{ AnnotatedException -> 0x0102 }
        r0.<init>();	 Catch:{ AnnotatedException -> 0x0102 }
        r2 = r8.m27908a();	 Catch:{ AnnotatedException -> 0x0102 }
        r2 = r2.m27939a();	 Catch:{ AnnotatedException -> 0x0102 }
        r0.addAll(r2);	 Catch:{ AnnotatedException -> 0x0102 }
        r2 = org.spongycastle.asn1.x509.Extension.f31282f;	 Catch:{ CertificateParsingException -> 0x00f9 }
        r2 = r2.m42986b();	 Catch:{ CertificateParsingException -> 0x00f9 }
        r2 = r7.getExtensionValue(r2);	 Catch:{ CertificateParsingException -> 0x00f9 }
        r3 = r8.m27908a();	 Catch:{ CertificateParsingException -> 0x00f9 }
        r3 = r3.m27940b();	 Catch:{ CertificateParsingException -> 0x00f9 }
        r2 = org.spongycastle.jce.provider.CertPathValidatorUtilities.m28150a(r2, r3);	 Catch:{ CertificateParsingException -> 0x00f9 }
        r0.addAll(r2);	 Catch:{ CertificateParsingException -> 0x00f9 }
        r2 = new java.util.HashSet;	 Catch:{ AnnotatedException -> 0x0102 }
        r2.<init>();	 Catch:{ AnnotatedException -> 0x0102 }
        r3 = r8.m27908a();	 Catch:{ AnnotatedException -> 0x00f0 }
        r3 = r3.m27954p();	 Catch:{ AnnotatedException -> 0x00f0 }
        r0 = org.spongycastle.jce.provider.CertPathValidatorUtilities.m28145a(r7, r3, r0);	 Catch:{ AnnotatedException -> 0x00f0 }
        r2.addAll(r0);	 Catch:{ AnnotatedException -> 0x00f0 }
        r0 = r2.isEmpty();	 Catch:{ AnnotatedException -> 0x0102 }
        if (r0 != 0) goto L_0x00e8;	 Catch:{ AnnotatedException -> 0x0102 }
    L_0x00c1:
        r0 = r2.iterator();	 Catch:{ AnnotatedException -> 0x0102 }
    L_0x00c5:
        r2 = r0.hasNext();	 Catch:{ AnnotatedException -> 0x0102 }
        if (r2 == 0) goto L_0x010c;	 Catch:{ AnnotatedException -> 0x0102 }
    L_0x00cb:
        if (r1 != 0) goto L_0x010c;	 Catch:{ AnnotatedException -> 0x0102 }
    L_0x00cd:
        r2 = r0.next();	 Catch:{ AnnotatedException -> 0x0102 }
        r2 = (java.security.cert.X509Certificate) r2;	 Catch:{ AnnotatedException -> 0x0102 }
        r3 = r2.getIssuerX500Principal();	 Catch:{ AnnotatedException -> 0x0102 }
        r4 = r2.getSubjectX500Principal();	 Catch:{ AnnotatedException -> 0x0102 }
        r3 = r3.equals(r4);	 Catch:{ AnnotatedException -> 0x0102 }
        if (r3 == 0) goto L_0x00e2;	 Catch:{ AnnotatedException -> 0x0102 }
    L_0x00e1:
        goto L_0x00c5;	 Catch:{ AnnotatedException -> 0x0102 }
    L_0x00e2:
        r2 = r5.m28176a(r6, r2, r8, r9);	 Catch:{ AnnotatedException -> 0x0102 }
        r1 = r2;	 Catch:{ AnnotatedException -> 0x0102 }
        goto L_0x00c5;	 Catch:{ AnnotatedException -> 0x0102 }
    L_0x00e8:
        r6 = new org.spongycastle.jce.provider.AnnotatedException;	 Catch:{ AnnotatedException -> 0x0102 }
        r8 = "No issuer certificate for certificate in certification path found.";	 Catch:{ AnnotatedException -> 0x0102 }
        r6.<init>(r8);	 Catch:{ AnnotatedException -> 0x0102 }
        throw r6;	 Catch:{ AnnotatedException -> 0x0102 }
    L_0x00f0:
        r6 = move-exception;	 Catch:{ AnnotatedException -> 0x0102 }
        r8 = new org.spongycastle.jce.provider.AnnotatedException;	 Catch:{ AnnotatedException -> 0x0102 }
        r0 = "Cannot find issuer certificate for certificate in certification path.";	 Catch:{ AnnotatedException -> 0x0102 }
        r8.<init>(r0, r6);	 Catch:{ AnnotatedException -> 0x0102 }
        throw r8;	 Catch:{ AnnotatedException -> 0x0102 }
    L_0x00f9:
        r6 = move-exception;	 Catch:{ AnnotatedException -> 0x0102 }
        r8 = new org.spongycastle.jce.provider.AnnotatedException;	 Catch:{ AnnotatedException -> 0x0102 }
        r0 = "No additional X.509 stores can be added from certificate locations.";	 Catch:{ AnnotatedException -> 0x0102 }
        r8.<init>(r0, r6);	 Catch:{ AnnotatedException -> 0x0102 }
        throw r8;	 Catch:{ AnnotatedException -> 0x0102 }
    L_0x0102:
        r6 = move-exception;
        r8 = new org.spongycastle.jce.provider.AnnotatedException;
        r0 = "No valid certification path could be build.";
        r8.<init>(r0, r6);
        r5.f22987a = r8;
    L_0x010c:
        if (r1 != 0) goto L_0x0111;
    L_0x010e:
        r9.remove(r7);
    L_0x0111:
        return r1;
    L_0x0112:
        r6 = new java.lang.RuntimeException;
        r7 = "Exception creating support classes.";
        r6.<init>(r7);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXAttrCertPathBuilderSpi.a(org.spongycastle.x509.X509AttributeCertificate, java.security.cert.X509Certificate, org.spongycastle.jcajce.PKIXExtendedBuilderParameters, java.util.List):java.security.cert.CertPathBuilderResult");
    }

    /* renamed from: a */
    protected static Collection m28177a(X509AttributeCertStoreSelector x509AttributeCertStoreSelector, List list) {
        Collection hashSet = new HashSet();
        for (Object next : list) {
            if (next instanceof Store) {
                try {
                    hashSet.addAll(((Store) next).mo5936a(x509AttributeCertStoreSelector));
                } catch (X509AttributeCertStoreSelector x509AttributeCertStoreSelector2) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", x509AttributeCertStoreSelector2);
                }
            }
        }
        return hashSet;
    }
}
