package org.spongycastle.jce.provider;

import java.io.BufferedInputStream;
import java.io.InputStream;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.CertificatePair;
import org.spongycastle.x509.X509CertificatePair;
import org.spongycastle.x509.X509StreamParserSpi;
import org.spongycastle.x509.util.StreamParsingException;

public class X509CertPairParser extends X509StreamParserSpi {
    /* renamed from: a */
    private InputStream f27602a = null;

    /* renamed from: b */
    private X509CertificatePair m36225b(InputStream inputStream) {
        return new X509CertificatePair(CertificatePair.m40295a((ASN1Sequence) new ASN1InputStream(inputStream).m34595d()));
    }

    /* renamed from: a */
    public void m36227a(InputStream inputStream) {
        this.f27602a = inputStream;
        if (this.f27602a.markSupported() == null) {
            this.f27602a = new BufferedInputStream(this.f27602a);
        }
    }

    /* renamed from: a */
    public Object m36226a() {
        try {
            this.f27602a.mark(10);
            if (this.f27602a.read() == -1) {
                return null;
            }
            this.f27602a.reset();
            return m36225b(this.f27602a);
        } catch (Throwable e) {
            throw new StreamParsingException(e.toString(), e);
        }
    }
}
