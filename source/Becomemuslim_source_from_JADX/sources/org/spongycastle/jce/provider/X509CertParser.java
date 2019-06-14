package org.spongycastle.jce.provider;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.security.cert.Certificate;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.SignedData;
import org.spongycastle.x509.X509StreamParserSpi;
import org.spongycastle.x509.util.StreamParsingException;

public class X509CertParser extends X509StreamParserSpi {
    /* renamed from: a */
    private static final PEMUtil f27603a = new PEMUtil("CERTIFICATE");
    /* renamed from: b */
    private ASN1Set f27604b = null;
    /* renamed from: c */
    private int f27605c = 0;
    /* renamed from: d */
    private InputStream f27606d = null;

    /* renamed from: b */
    private Certificate m36229b(InputStream inputStream) {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(inputStream).m34595d();
        if (aSN1Sequence.mo6862g() <= 1 || !(aSN1Sequence.mo6860a(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.mo6860a(0).equals(PKCSObjectIdentifiers.f21849P)) {
            return new X509CertificateObject(org.spongycastle.asn1.x509.Certificate.m40272a(aSN1Sequence));
        }
        this.f27604b = new SignedData(ASN1Sequence.m43001a((ASN1TaggedObject) aSN1Sequence.mo6860a(1), true)).m40160a();
        return m36228b();
    }

    /* renamed from: b */
    private Certificate m36228b() {
        if (this.f27604b != null) {
            while (this.f27605c < this.f27604b.m43021c()) {
                ASN1Set aSN1Set = this.f27604b;
                int i = this.f27605c;
                this.f27605c = i + 1;
                ASN1Encodable a = aSN1Set.m43016a(i);
                if (a instanceof ASN1Sequence) {
                    return new X509CertificateObject(org.spongycastle.asn1.x509.Certificate.m40272a(a));
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    private Certificate m36230c(InputStream inputStream) {
        inputStream = f27603a.m28175a(inputStream);
        return inputStream != null ? new X509CertificateObject(org.spongycastle.asn1.x509.Certificate.m40272a(inputStream)) : null;
    }

    /* renamed from: a */
    public void m36232a(InputStream inputStream) {
        this.f27606d = inputStream;
        this.f27604b = null;
        this.f27605c = null;
        if (this.f27606d.markSupported() == null) {
            this.f27606d = new BufferedInputStream(this.f27606d);
        }
    }

    /* renamed from: a */
    public Object m36231a() {
        try {
            if (this.f27604b == null) {
                this.f27606d.mark(10);
                int read = this.f27606d.read();
                if (read == -1) {
                    return null;
                }
                if (read != 48) {
                    this.f27606d.reset();
                    return m36230c(this.f27606d);
                }
                this.f27606d.reset();
                return m36229b(this.f27606d);
            } else if (this.f27605c != this.f27604b.m43021c()) {
                return m36228b();
            } else {
                this.f27604b = null;
                this.f27605c = 0;
                return null;
            }
        } catch (Throwable e) {
            throw new StreamParsingException(e.toString(), e);
        }
    }
}
