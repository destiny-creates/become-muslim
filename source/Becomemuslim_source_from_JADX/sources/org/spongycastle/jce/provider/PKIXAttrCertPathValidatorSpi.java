package org.spongycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.PKIXParameters;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.jcajce.PKIXExtendedParameters;
import org.spongycastle.jcajce.PKIXExtendedParameters.Builder;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.x509.ExtendedPKIXParameters;
import org.spongycastle.x509.X509AttributeCertStoreSelector;
import org.spongycastle.x509.X509AttributeCertificate;

public class PKIXAttrCertPathValidatorSpi extends CertPathValidatorSpi {
    /* renamed from: a */
    private final JcaJceHelper f22988a = new BCJcaJceHelper();

    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) {
        boolean z = certPathParameters instanceof ExtendedPKIXParameters;
        if (!z) {
            if (!(certPathParameters instanceof PKIXExtendedParameters)) {
                certPathParameters = new StringBuilder();
                certPathParameters.append("Parameters must be a ");
                certPathParameters.append(ExtendedPKIXParameters.class.getName());
                certPathParameters.append(" instance.");
                throw new InvalidAlgorithmParameterException(certPathParameters.toString());
            }
        }
        Set hashSet = new HashSet();
        Set hashSet2 = new HashSet();
        Set hashSet3 = new HashSet();
        Set hashSet4 = new HashSet();
        if (certPathParameters instanceof PKIXParameters) {
            Builder builder = new Builder((PKIXParameters) certPathParameters);
            if (z) {
                ExtendedPKIXParameters extendedPKIXParameters = (ExtendedPKIXParameters) certPathParameters;
                builder.m27927a(extendedPKIXParameters.m29455c());
                builder.m27922a(extendedPKIXParameters.m29456d());
                Set j = extendedPKIXParameters.m29462j();
                hashSet = extendedPKIXParameters.m29461i();
                hashSet3 = extendedPKIXParameters.m29460h();
                hashSet2 = hashSet;
                hashSet = j;
            }
            certPathParameters = builder.m27928a();
        } else {
            certPathParameters = (PKIXExtendedParameters) certPathParameters;
        }
        PKIXExtendedParameters pKIXExtendedParameters = certPathParameters;
        certPathParameters = pKIXExtendedParameters.m27946h();
        if (certPathParameters instanceof X509AttributeCertStoreSelector) {
            X509AttributeCertificate a = ((X509AttributeCertStoreSelector) certPathParameters).m36622a();
            certPathParameters = RFC3281CertPathUtilities.m28286b(a, pKIXExtendedParameters);
            CertPathValidatorResult a2 = RFC3281CertPathUtilities.m28278a(certPath, pKIXExtendedParameters);
            X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(0);
            RFC3281CertPathUtilities.m28280a(x509Certificate, pKIXExtendedParameters);
            RFC3281CertPathUtilities.m28279a(x509Certificate, hashSet4);
            RFC3281CertPathUtilities.m28284a(a, pKIXExtendedParameters);
            RFC3281CertPathUtilities.m28282a(a, certPath, certPathParameters, pKIXExtendedParameters, hashSet);
            RFC3281CertPathUtilities.m28283a(a, hashSet2, hashSet3);
            try {
                RFC3281CertPathUtilities.m28285a(a, pKIXExtendedParameters, x509Certificate, CertPathValidatorUtilities.m28148a(pKIXExtendedParameters, (CertPath) null, -1), certPath.getCertificates(), this.f22988a);
                return a2;
            } catch (CertPath certPath2) {
                throw new ExtCertPathValidatorException("Could not get validity date from attribute certificate.", certPath2);
            }
        }
        certPathParameters = new StringBuilder();
        certPathParameters.append("TargetConstraints must be an instance of ");
        certPathParameters.append(X509AttributeCertStoreSelector.class.getName());
        certPathParameters.append(" for ");
        certPathParameters.append(getClass().getName());
        certPathParameters.append(" class.");
        throw new InvalidAlgorithmParameterException(certPathParameters.toString());
    }
}
