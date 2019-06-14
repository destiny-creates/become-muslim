package org.spongycastle.x509;

import java.security.cert.CRLException;
import org.spongycastle.asn1.x509.V2TBSCertListGenerator;
import org.spongycastle.asn1.x509.X509ExtensionsGenerator;

public class X509V2CRLGenerator {
    /* renamed from: a */
    private V2TBSCertListGenerator f23494a = new V2TBSCertListGenerator();
    /* renamed from: b */
    private X509ExtensionsGenerator f23495b = new X509ExtensionsGenerator();

    private static class ExtCRLException extends CRLException {
        /* renamed from: a */
        Throwable f23493a;

        public Throwable getCause() {
            return this.f23493a;
        }
    }
}
