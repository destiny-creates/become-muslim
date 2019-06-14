package org.spongycastle.jce.provider;

import java.io.BufferedInputStream;
import java.io.InputStream;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.SignedData;
import org.spongycastle.x509.X509AttributeCertificate;
import org.spongycastle.x509.X509StreamParserSpi;
import org.spongycastle.x509.X509V2AttributeCertificate;
import org.spongycastle.x509.util.StreamParsingException;

public class X509AttrCertParser extends X509StreamParserSpi {
    /* renamed from: a */
    private static final PEMUtil f27594a = new PEMUtil("ATTRIBUTE CERTIFICATE");
    /* renamed from: b */
    private ASN1Set f27595b = null;
    /* renamed from: c */
    private int f27596c = 0;
    /* renamed from: d */
    private InputStream f27597d = null;

    /* renamed from: b */
    private X509AttributeCertificate m36216b(InputStream inputStream) {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(inputStream).m34595d();
        if (aSN1Sequence.mo6862g() <= 1 || !(aSN1Sequence.mo6860a(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.mo6860a(0).equals(PKCSObjectIdentifiers.f21849P)) {
            return new X509V2AttributeCertificate(aSN1Sequence.mo6822f());
        }
        this.f27595b = new SignedData(ASN1Sequence.m43001a((ASN1TaggedObject) aSN1Sequence.mo6860a(1), true)).m40160a();
        return m36215b();
    }

    /* renamed from: b */
    private X509AttributeCertificate m36215b() {
        if (this.f27595b != null) {
            while (this.f27596c < this.f27595b.m43021c()) {
                ASN1Set aSN1Set = this.f27595b;
                int i = this.f27596c;
                this.f27596c = i + 1;
                ASN1Encodable a = aSN1Set.m43016a(i);
                if (a instanceof ASN1TaggedObject) {
                    ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) a;
                    if (aSN1TaggedObject.m43030b() == 2) {
                        return new X509V2AttributeCertificate(ASN1Sequence.m43001a(aSN1TaggedObject, false).mo6822f());
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    private X509AttributeCertificate m36217c(InputStream inputStream) {
        inputStream = f27594a.m28175a(inputStream);
        return inputStream != null ? new X509V2AttributeCertificate(inputStream.mo6822f()) : null;
    }

    /* renamed from: a */
    public void m36219a(InputStream inputStream) {
        this.f27597d = inputStream;
        this.f27595b = null;
        this.f27596c = null;
        if (this.f27597d.markSupported() == null) {
            this.f27597d = new BufferedInputStream(this.f27597d);
        }
    }

    /* renamed from: a */
    public Object m36218a() {
        try {
            if (this.f27595b == null) {
                this.f27597d.mark(10);
                int read = this.f27597d.read();
                if (read == -1) {
                    return null;
                }
                if (read != 48) {
                    this.f27597d.reset();
                    return m36217c(this.f27597d);
                }
                this.f27597d.reset();
                return m36216b(this.f27597d);
            } else if (this.f27596c != this.f27595b.m43021c()) {
                return m36215b();
            } else {
                this.f27595b = null;
                this.f27596c = 0;
                return null;
            }
        } catch (Throwable e) {
            throw new StreamParsingException(e.toString(), e);
        }
    }
}
