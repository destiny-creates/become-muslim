package org.spongycastle.jce.provider;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.security.cert.CRL;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.SignedData;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.x509.X509StreamParserSpi;
import org.spongycastle.x509.util.StreamParsingException;

public class X509CRLParser extends X509StreamParserSpi {
    /* renamed from: a */
    private static final PEMUtil f27598a = new PEMUtil("CRL");
    /* renamed from: b */
    private ASN1Set f27599b = null;
    /* renamed from: c */
    private int f27600c = 0;
    /* renamed from: d */
    private InputStream f27601d = null;

    /* renamed from: b */
    private CRL m36221b(InputStream inputStream) {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(inputStream).m34595d();
        if (aSN1Sequence.mo6862g() <= 1 || !(aSN1Sequence.mo6860a(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.mo6860a(0).equals(PKCSObjectIdentifiers.f21849P)) {
            return new X509CRLObject(CertificateList.m40285a(aSN1Sequence));
        }
        this.f27599b = new SignedData(ASN1Sequence.m43001a((ASN1TaggedObject) aSN1Sequence.mo6860a(1), true)).m40161b();
        return m36220b();
    }

    /* renamed from: b */
    private CRL m36220b() {
        if (this.f27599b != null) {
            if (this.f27600c < this.f27599b.m43021c()) {
                ASN1Set aSN1Set = this.f27599b;
                int i = this.f27600c;
                this.f27600c = i + 1;
                return new X509CRLObject(CertificateList.m40285a(aSN1Set.m43016a(i)));
            }
        }
        return null;
    }

    /* renamed from: c */
    private CRL m36222c(InputStream inputStream) {
        inputStream = f27598a.m28175a(inputStream);
        return inputStream != null ? new X509CRLObject(CertificateList.m40285a(inputStream)) : null;
    }

    /* renamed from: a */
    public void m36224a(InputStream inputStream) {
        this.f27601d = inputStream;
        this.f27599b = null;
        this.f27600c = null;
        if (this.f27601d.markSupported() == null) {
            this.f27601d = new BufferedInputStream(this.f27601d);
        }
    }

    /* renamed from: a */
    public Object m36223a() {
        try {
            if (this.f27599b == null) {
                this.f27601d.mark(10);
                int read = this.f27601d.read();
                if (read == -1) {
                    return null;
                }
                if (read != 48) {
                    this.f27601d.reset();
                    return m36222c(this.f27601d);
                }
                this.f27601d.reset();
                return m36221b(this.f27601d);
            } else if (this.f27600c != this.f27599b.m43021c()) {
                return m36220b();
            } else {
                this.f27599b = null;
                this.f27600c = 0;
                return null;
            }
        } catch (Throwable e) {
            throw new StreamParsingException(e.toString(), e);
        }
    }
}
