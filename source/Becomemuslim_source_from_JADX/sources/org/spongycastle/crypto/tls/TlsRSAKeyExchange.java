package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.io.Streams;

public class TlsRSAKeyExchange extends AbstractTlsKeyExchange {
    /* renamed from: d */
    protected AsymmetricKeyParameter f31851d;
    /* renamed from: e */
    protected RSAKeyParameters f31852e;
    /* renamed from: f */
    protected TlsEncryptionCredentials f31853f;
    /* renamed from: g */
    protected byte[] f31854g;

    /* renamed from: e */
    public void mo6492e() {
        throw new TlsFatalAlert((short) 10);
    }

    /* renamed from: a */
    public void mo5816a(TlsCredentials tlsCredentials) {
        if (tlsCredentials instanceof TlsEncryptionCredentials) {
            mo5814a(tlsCredentials.mo6811a());
            this.f31853f = (TlsEncryptionCredentials) tlsCredentials;
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: a */
    public void mo5814a(Certificate certificate) {
        if (certificate.m27545a()) {
            throw new TlsFatalAlert((short) 42);
        }
        Certificate a = certificate.m27543a(0);
        try {
            this.f31851d = PublicKeyFactory.m27886a(a.m40282j());
            if (this.f31851d.m35630a()) {
                throw new TlsFatalAlert((short) 80);
            }
            this.f31852e = m40957a((RSAKeyParameters) this.f31851d);
            TlsUtils.m27811a(a, 32);
            super.mo5814a(certificate);
        } catch (Certificate certificate2) {
            throw new TlsFatalAlert((short) 43, certificate2);
        }
    }

    /* renamed from: a */
    public void mo6489a(CertificateRequest certificateRequest) {
        certificateRequest = certificateRequest.m27548a();
        for (short s : certificateRequest) {
            if (s != (short) 64) {
                switch (s) {
                    case (short) 1:
                    case (short) 2:
                        break;
                    default:
                        throw new TlsFatalAlert((short) 47);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo6491b(TlsCredentials tlsCredentials) {
        if ((tlsCredentials instanceof TlsSignerCredentials) == null) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    /* renamed from: a */
    public void mo6488a(OutputStream outputStream) {
        this.f31854g = TlsRSAUtils.m27775a(this.c, this.f31852e, outputStream);
    }

    /* renamed from: b */
    public void mo5817b(InputStream inputStream) {
        if (TlsUtils.m27825a(this.c)) {
            inputStream = Streams.m29442a(inputStream);
        } else {
            inputStream = TlsUtils.m27875f(inputStream);
        }
        this.f31854g = this.f31853f.mo6813a(inputStream);
    }

    /* renamed from: f */
    public byte[] mo6493f() {
        if (this.f31854g != null) {
            byte[] bArr = this.f31854g;
            this.f31854g = null;
            return bArr;
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: a */
    protected RSAKeyParameters m40957a(RSAKeyParameters rSAKeyParameters) {
        if (rSAKeyParameters.m40801c().isProbablePrime(2)) {
            return rSAKeyParameters;
        }
        throw new TlsFatalAlert((short) 47);
    }
}
