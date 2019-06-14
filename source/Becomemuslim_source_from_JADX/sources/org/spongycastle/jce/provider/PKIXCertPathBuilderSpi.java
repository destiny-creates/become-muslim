package org.spongycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.jcajce.PKIXCertStore;
import org.spongycastle.jcajce.PKIXCertStoreSelector;
import org.spongycastle.jcajce.PKIXExtendedBuilderParameters;
import org.spongycastle.jcajce.PKIXExtendedParameters.Builder;
import org.spongycastle.jce.exception.ExtCertPathBuilderException;
import org.spongycastle.x509.ExtendedPKIXBuilderParameters;
import org.spongycastle.x509.ExtendedPKIXParameters;

public class PKIXCertPathBuilderSpi extends CertPathBuilderSpi {
    /* renamed from: a */
    private Exception f22989a;

    public CertPathBuilderResult engineBuild(CertPathParameters certPathParameters) {
        if (certPathParameters instanceof PKIXBuilderParameters) {
            PKIXBuilderParameters pKIXBuilderParameters = (PKIXBuilderParameters) certPathParameters;
            Builder builder = new Builder((PKIXParameters) pKIXBuilderParameters);
            if (certPathParameters instanceof ExtendedPKIXParameters) {
                ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) certPathParameters;
                for (PKIXCertStore a : extendedPKIXBuilderParameters.m29457e()) {
                    builder.m27925a(a);
                }
                PKIXExtendedBuilderParameters.Builder builder2 = new PKIXExtendedBuilderParameters.Builder(builder.m27928a());
                builder2.m27906a(extendedPKIXBuilderParameters.m36619a());
                builder2.m27905a(extendedPKIXBuilderParameters.m36621b());
                certPathParameters = builder2;
            } else {
                certPathParameters = new PKIXExtendedBuilderParameters.Builder(pKIXBuilderParameters);
            }
            certPathParameters = certPathParameters.m27907a();
        } else if (certPathParameters instanceof PKIXExtendedBuilderParameters) {
            certPathParameters = (PKIXExtendedBuilderParameters) certPathParameters;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Parameters must be an instance of ");
            stringBuilder.append(PKIXBuilderParameters.class.getName());
            stringBuilder.append(" or ");
            stringBuilder.append(PKIXExtendedBuilderParameters.class.getName());
            stringBuilder.append(".");
            throw new InvalidAlgorithmParameterException(stringBuilder.toString());
        }
        List arrayList = new ArrayList();
        PKIXCertStoreSelector h = certPathParameters.m27908a().m27946h();
        try {
            Collection a2 = CertPathValidatorUtilities.m28146a(h, certPathParameters.m27908a().m27939a());
            a2.addAll(CertPathValidatorUtilities.m28146a(h, certPathParameters.m27908a().m27954p()));
            if (a2.isEmpty()) {
                throw new CertPathBuilderException("No certificate found matching targetContraints.");
            }
            CertPathBuilderResult certPathBuilderResult = null;
            Iterator it = a2.iterator();
            while (it.hasNext() && certPathBuilderResult == null) {
                certPathBuilderResult = m28180a((X509Certificate) it.next(), certPathParameters, arrayList);
            }
            if (certPathBuilderResult != null || this.f22989a == null) {
                if (certPathBuilderResult == null) {
                    if (this.f22989a == null) {
                        throw new CertPathBuilderException("Unable to find certificate chain.");
                    }
                }
                return certPathBuilderResult;
            } else if ((this.f22989a instanceof AnnotatedException) != null) {
                throw new CertPathBuilderException(this.f22989a.getMessage(), this.f22989a.getCause());
            } else {
                throw new CertPathBuilderException("Possible certificate chain could not be validated.", this.f22989a);
            }
        } catch (CertPathParameters certPathParameters2) {
            throw new ExtCertPathBuilderException("Error finding target certificate.", certPathParameters2);
        }
    }

    /* renamed from: a */
    protected java.security.cert.CertPathBuilderResult m28180a(java.security.cert.X509Certificate r6, org.spongycastle.jcajce.PKIXExtendedBuilderParameters r7, java.util.List r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r8.contains(r6);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = r7.m27909b();
        r0 = r0.contains(r6);
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return r1;
    L_0x0013:
        r0 = r7.m27910c();
        r2 = -1;
        if (r0 == r2) goto L_0x0027;
    L_0x001a:
        r0 = r8.size();
        r0 = r0 + -1;
        r2 = r7.m27910c();
        if (r0 <= r2) goto L_0x0027;
    L_0x0026:
        return r1;
    L_0x0027:
        r8.add(r6);
        r0 = new org.spongycastle.jcajce.provider.asymmetric.x509.CertificateFactory;	 Catch:{ Exception -> 0x00f6 }
        r0.<init>();	 Catch:{ Exception -> 0x00f6 }
        r2 = new org.spongycastle.jce.provider.PKIXCertPathValidatorSpi;	 Catch:{ Exception -> 0x00f6 }
        r2.<init>();	 Catch:{ Exception -> 0x00f6 }
        r3 = r7.m27908a();	 Catch:{ AnnotatedException -> 0x00ed }
        r3 = r3.m27947i();	 Catch:{ AnnotatedException -> 0x00ed }
        r4 = r7.m27908a();	 Catch:{ AnnotatedException -> 0x00ed }
        r4 = r4.m27949k();	 Catch:{ AnnotatedException -> 0x00ed }
        r3 = org.spongycastle.jce.provider.CertPathValidatorUtilities.m28144a(r6, r3, r4);	 Catch:{ AnnotatedException -> 0x00ed }
        if (r3 == 0) goto L_0x0078;
    L_0x004a:
        r0 = r0.engineGenerateCertPath(r8);	 Catch:{ Exception -> 0x006f }
        r7 = r2.engineValidate(r0, r7);	 Catch:{ Exception -> 0x0066 }
        r7 = (java.security.cert.PKIXCertPathValidatorResult) r7;	 Catch:{ Exception -> 0x0066 }
        r2 = new java.security.cert.PKIXCertPathBuilderResult;	 Catch:{ AnnotatedException -> 0x00ed }
        r3 = r7.getTrustAnchor();	 Catch:{ AnnotatedException -> 0x00ed }
        r4 = r7.getPolicyTree();	 Catch:{ AnnotatedException -> 0x00ed }
        r7 = r7.getPublicKey();	 Catch:{ AnnotatedException -> 0x00ed }
        r2.<init>(r0, r3, r4, r7);	 Catch:{ AnnotatedException -> 0x00ed }
        return r2;	 Catch:{ AnnotatedException -> 0x00ed }
    L_0x0066:
        r7 = move-exception;	 Catch:{ AnnotatedException -> 0x00ed }
        r0 = new org.spongycastle.jce.provider.AnnotatedException;	 Catch:{ AnnotatedException -> 0x00ed }
        r2 = "Certification path could not be validated.";	 Catch:{ AnnotatedException -> 0x00ed }
        r0.<init>(r2, r7);	 Catch:{ AnnotatedException -> 0x00ed }
        throw r0;	 Catch:{ AnnotatedException -> 0x00ed }
    L_0x006f:
        r7 = move-exception;	 Catch:{ AnnotatedException -> 0x00ed }
        r0 = new org.spongycastle.jce.provider.AnnotatedException;	 Catch:{ AnnotatedException -> 0x00ed }
        r2 = "Certification path could not be constructed from certificate list.";	 Catch:{ AnnotatedException -> 0x00ed }
        r0.<init>(r2, r7);	 Catch:{ AnnotatedException -> 0x00ed }
        throw r0;	 Catch:{ AnnotatedException -> 0x00ed }
    L_0x0078:
        r0 = new java.util.ArrayList;	 Catch:{ AnnotatedException -> 0x00ed }
        r0.<init>();	 Catch:{ AnnotatedException -> 0x00ed }
        r2 = r7.m27908a();	 Catch:{ AnnotatedException -> 0x00ed }
        r2 = r2.m27939a();	 Catch:{ AnnotatedException -> 0x00ed }
        r0.addAll(r2);	 Catch:{ AnnotatedException -> 0x00ed }
        r2 = org.spongycastle.asn1.x509.Extension.f31282f;	 Catch:{ CertificateParsingException -> 0x00e4 }
        r2 = r2.m42986b();	 Catch:{ CertificateParsingException -> 0x00e4 }
        r2 = r6.getExtensionValue(r2);	 Catch:{ CertificateParsingException -> 0x00e4 }
        r3 = r7.m27908a();	 Catch:{ CertificateParsingException -> 0x00e4 }
        r3 = r3.m27940b();	 Catch:{ CertificateParsingException -> 0x00e4 }
        r2 = org.spongycastle.jce.provider.CertPathValidatorUtilities.m28150a(r2, r3);	 Catch:{ CertificateParsingException -> 0x00e4 }
        r0.addAll(r2);	 Catch:{ CertificateParsingException -> 0x00e4 }
        r2 = new java.util.HashSet;	 Catch:{ AnnotatedException -> 0x00ed }
        r2.<init>();	 Catch:{ AnnotatedException -> 0x00ed }
        r3 = r7.m27908a();	 Catch:{ AnnotatedException -> 0x00db }
        r3 = r3.m27954p();	 Catch:{ AnnotatedException -> 0x00db }
        r0 = org.spongycastle.jce.provider.CertPathValidatorUtilities.m28145a(r6, r3, r0);	 Catch:{ AnnotatedException -> 0x00db }
        r2.addAll(r0);	 Catch:{ AnnotatedException -> 0x00db }
        r0 = r2.isEmpty();	 Catch:{ AnnotatedException -> 0x00ed }
        if (r0 != 0) goto L_0x00d3;	 Catch:{ AnnotatedException -> 0x00ed }
    L_0x00bb:
        r0 = r2.iterator();	 Catch:{ AnnotatedException -> 0x00ed }
    L_0x00bf:
        r2 = r0.hasNext();	 Catch:{ AnnotatedException -> 0x00ed }
        if (r2 == 0) goto L_0x00f0;	 Catch:{ AnnotatedException -> 0x00ed }
    L_0x00c5:
        if (r1 != 0) goto L_0x00f0;	 Catch:{ AnnotatedException -> 0x00ed }
    L_0x00c7:
        r2 = r0.next();	 Catch:{ AnnotatedException -> 0x00ed }
        r2 = (java.security.cert.X509Certificate) r2;	 Catch:{ AnnotatedException -> 0x00ed }
        r2 = r5.m28180a(r2, r7, r8);	 Catch:{ AnnotatedException -> 0x00ed }
        r1 = r2;	 Catch:{ AnnotatedException -> 0x00ed }
        goto L_0x00bf;	 Catch:{ AnnotatedException -> 0x00ed }
    L_0x00d3:
        r7 = new org.spongycastle.jce.provider.AnnotatedException;	 Catch:{ AnnotatedException -> 0x00ed }
        r0 = "No issuer certificate for certificate in certification path found.";	 Catch:{ AnnotatedException -> 0x00ed }
        r7.<init>(r0);	 Catch:{ AnnotatedException -> 0x00ed }
        throw r7;	 Catch:{ AnnotatedException -> 0x00ed }
    L_0x00db:
        r7 = move-exception;	 Catch:{ AnnotatedException -> 0x00ed }
        r0 = new org.spongycastle.jce.provider.AnnotatedException;	 Catch:{ AnnotatedException -> 0x00ed }
        r2 = "Cannot find issuer certificate for certificate in certification path.";	 Catch:{ AnnotatedException -> 0x00ed }
        r0.<init>(r2, r7);	 Catch:{ AnnotatedException -> 0x00ed }
        throw r0;	 Catch:{ AnnotatedException -> 0x00ed }
    L_0x00e4:
        r7 = move-exception;	 Catch:{ AnnotatedException -> 0x00ed }
        r0 = new org.spongycastle.jce.provider.AnnotatedException;	 Catch:{ AnnotatedException -> 0x00ed }
        r2 = "No additional X.509 stores can be added from certificate locations.";	 Catch:{ AnnotatedException -> 0x00ed }
        r0.<init>(r2, r7);	 Catch:{ AnnotatedException -> 0x00ed }
        throw r0;	 Catch:{ AnnotatedException -> 0x00ed }
    L_0x00ed:
        r7 = move-exception;
        r5.f22989a = r7;
    L_0x00f0:
        if (r1 != 0) goto L_0x00f5;
    L_0x00f2:
        r8.remove(r6);
    L_0x00f5:
        return r1;
    L_0x00f6:
        r6 = new java.lang.RuntimeException;
        r7 = "Exception creating support classes.";
        r6.<init>(r7);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXCertPathBuilderSpi.a(java.security.cert.X509Certificate, org.spongycastle.jcajce.PKIXExtendedBuilderParameters, java.util.List):java.security.cert.CertPathBuilderResult");
    }
}
