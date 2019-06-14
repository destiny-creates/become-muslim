package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.io.InputStream;
import java.io.PushbackInputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.SignedData;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;

public class CertificateFactory extends CertificateFactorySpi {
    /* renamed from: b */
    private static final PEMUtil f22825b = new PEMUtil("CERTIFICATE");
    /* renamed from: c */
    private static final PEMUtil f22826c = new PEMUtil("CRL");
    /* renamed from: a */
    private final JcaJceHelper f22827a = new BCJcaJceHelper();
    /* renamed from: d */
    private ASN1Set f22828d = null;
    /* renamed from: e */
    private int f22829e = 0;
    /* renamed from: f */
    private InputStream f22830f = null;
    /* renamed from: g */
    private ASN1Set f22831g = null;
    /* renamed from: h */
    private int f22832h = 0;
    /* renamed from: i */
    private InputStream f22833i = null;

    private class ExCertificateException extends CertificateException {
        /* renamed from: a */
        final /* synthetic */ CertificateFactory f22823a;
        /* renamed from: b */
        private Throwable f22824b;

        public ExCertificateException(CertificateFactory certificateFactory, Throwable th) {
            this.f22823a = certificateFactory;
            this.f22824b = th;
        }

        public Throwable getCause() {
            return this.f22824b;
        }
    }

    /* renamed from: a */
    private Certificate m28023a(ASN1InputStream aSN1InputStream) {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1InputStream.m34595d();
        if (aSN1Sequence.mo6862g() <= 1 || !(aSN1Sequence.mo6860a(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.mo6860a(0).equals(PKCSObjectIdentifiers.f21849P)) {
            return new X509CertificateObject(this.f22827a, org.spongycastle.asn1.x509.Certificate.m40272a(aSN1Sequence));
        }
        this.f22828d = SignedData.m40159a(ASN1Sequence.m43001a((ASN1TaggedObject) aSN1Sequence.mo6860a(1), true)).m40160a();
        return m28021a();
    }

    /* renamed from: a */
    private Certificate m28021a() {
        if (this.f22828d != null) {
            while (this.f22829e < this.f22828d.m43021c()) {
                ASN1Set aSN1Set = this.f22828d;
                int i = this.f22829e;
                this.f22829e = i + 1;
                ASN1Encodable a = aSN1Set.m43016a(i);
                if (a instanceof ASN1Sequence) {
                    return new X509CertificateObject(this.f22827a, org.spongycastle.asn1.x509.Certificate.m40272a(a));
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private Certificate m28022a(InputStream inputStream) {
        inputStream = f22825b.m28029a(inputStream);
        return inputStream != null ? new X509CertificateObject(this.f22827a, org.spongycastle.asn1.x509.Certificate.m40272a(inputStream)) : null;
    }

    /* renamed from: a */
    protected CRL m28027a(CertificateList certificateList) {
        return new X509CRLObject(this.f22827a, certificateList);
    }

    /* renamed from: b */
    private CRL m28025b(InputStream inputStream) {
        inputStream = f22826c.m28029a(inputStream);
        return inputStream != null ? m28027a(CertificateList.m40285a(inputStream)) : null;
    }

    /* renamed from: b */
    private CRL m28026b(ASN1InputStream aSN1InputStream) {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1InputStream.m34595d();
        if (aSN1Sequence.mo6862g() <= 1 || !(aSN1Sequence.mo6860a(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.mo6860a(0).equals(PKCSObjectIdentifiers.f21849P)) {
            return m28027a(CertificateList.m40285a(aSN1Sequence));
        }
        this.f22831g = SignedData.m40159a(ASN1Sequence.m43001a((ASN1TaggedObject) aSN1Sequence.mo6860a(1), true)).m40161b();
        return m28024b();
    }

    /* renamed from: b */
    private CRL m28024b() {
        if (this.f22831g != null) {
            if (this.f22832h < this.f22831g.m43021c()) {
                ASN1Set aSN1Set = this.f22831g;
                int i = this.f22832h;
                this.f22832h = i + 1;
                return m28027a(CertificateList.m40285a(aSN1Set.m43016a(i)));
            }
        }
        return null;
    }

    public Certificate engineGenerateCertificate(InputStream inputStream) {
        if (this.f22830f == null) {
            this.f22830f = inputStream;
            this.f22828d = null;
            this.f22829e = 0;
        } else if (this.f22830f != inputStream) {
            this.f22830f = inputStream;
            this.f22828d = null;
            this.f22829e = 0;
        }
        try {
            if (this.f22828d == null) {
                InputStream pushbackInputStream = new PushbackInputStream(inputStream);
                inputStream = pushbackInputStream.read();
                if (inputStream == -1) {
                    return null;
                }
                pushbackInputStream.unread(inputStream);
                if (inputStream != 48) {
                    return m28022a(pushbackInputStream);
                }
                return m28023a(new ASN1InputStream(pushbackInputStream));
            } else if (this.f22829e != this.f22828d.m43021c()) {
                return m28021a();
            } else {
                this.f22828d = null;
                this.f22829e = 0;
                return null;
            }
        } catch (InputStream inputStream2) {
            throw new ExCertificateException(this, inputStream2);
        }
    }

    public Collection engineGenerateCertificates(InputStream inputStream) {
        Collection arrayList = new ArrayList();
        while (true) {
            Certificate engineGenerateCertificate = engineGenerateCertificate(inputStream);
            if (engineGenerateCertificate == null) {
                return arrayList;
            }
            arrayList.add(engineGenerateCertificate);
        }
    }

    public CRL engineGenerateCRL(InputStream inputStream) {
        if (this.f22833i == null) {
            this.f22833i = inputStream;
            this.f22831g = null;
            this.f22832h = 0;
        } else if (this.f22833i != inputStream) {
            this.f22833i = inputStream;
            this.f22831g = null;
            this.f22832h = 0;
        }
        try {
            if (this.f22831g == null) {
                InputStream pushbackInputStream = new PushbackInputStream(inputStream);
                inputStream = pushbackInputStream.read();
                if (inputStream == -1) {
                    return null;
                }
                pushbackInputStream.unread(inputStream);
                if (inputStream != 48) {
                    return m28025b(pushbackInputStream);
                }
                return m28026b(new ASN1InputStream(pushbackInputStream, true));
            } else if (this.f22832h != this.f22831g.m43021c()) {
                return m28024b();
            } else {
                this.f22831g = null;
                this.f22832h = 0;
                return null;
            }
        } catch (InputStream inputStream2) {
            throw inputStream2;
        } catch (InputStream inputStream22) {
            throw new CRLException(inputStream22.toString());
        }
    }

    public Collection engineGenerateCRLs(InputStream inputStream) {
        Collection arrayList = new ArrayList();
        while (true) {
            CRL engineGenerateCRL = engineGenerateCRL(inputStream);
            if (engineGenerateCRL == null) {
                return arrayList;
            }
            arrayList.add(engineGenerateCRL);
        }
    }

    public Iterator engineGetCertPathEncodings() {
        return PKIXCertPath.f22839a.iterator();
    }

    public CertPath engineGenerateCertPath(InputStream inputStream) {
        return engineGenerateCertPath(inputStream, "PkiPath");
    }

    public CertPath engineGenerateCertPath(InputStream inputStream, String str) {
        return new PKIXCertPath(inputStream, str);
    }

    public CertPath engineGenerateCertPath(List list) {
        for (Object next : list) {
            if (next != null) {
                if (!(next instanceof X509Certificate)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("list contains non X509Certificate object while creating CertPath\n");
                    stringBuilder.append(next.toString());
                    throw new CertificateException(stringBuilder.toString());
                }
            }
        }
        return new PKIXCertPath(list);
    }
}
