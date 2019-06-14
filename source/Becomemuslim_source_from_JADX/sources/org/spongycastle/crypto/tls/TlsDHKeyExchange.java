package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;

public class TlsDHKeyExchange extends AbstractTlsKeyExchange {
    /* renamed from: e */
    protected TlsSigner f31821e;
    /* renamed from: f */
    protected DHParameters f31822f;
    /* renamed from: g */
    protected AsymmetricKeyParameter f31823g;
    /* renamed from: h */
    protected TlsAgreementCredentials f31824h;
    /* renamed from: i */
    protected DHPrivateKeyParameters f31825i;
    /* renamed from: j */
    protected DHPublicKeyParameters f31826j;

    /* renamed from: b */
    public void mo5818b(Certificate certificate) {
    }

    /* renamed from: g */
    protected int m40926g() {
        return 1024;
    }

    /* renamed from: a */
    public void mo5815a(TlsContext tlsContext) {
        super.mo5815a(tlsContext);
        if (this.f31821e != null) {
            this.f31821e.mo5825a(tlsContext);
        }
    }

    /* renamed from: e */
    public void mo6492e() {
        throw new TlsFatalAlert((short) 10);
    }

    /* renamed from: a */
    public void mo5814a(Certificate certificate) {
        if (certificate.m27545a()) {
            throw new TlsFatalAlert((short) 42);
        }
        Certificate a = certificate.m27543a(0);
        try {
            this.f31823g = PublicKeyFactory.m27886a(a.m40282j());
            if (this.f31821e == null) {
                try {
                    this.f31826j = TlsDHUtils.m27643a((DHPublicKeyParameters) this.f31823g);
                    this.f31822f = m40915a(this.f31826j.m40790b());
                    TlsUtils.m27811a(a, 8);
                } catch (Certificate certificate2) {
                    throw new TlsFatalAlert((short) 46, certificate2);
                }
            } else if (this.f31821e.mo6497a(this.f31823g)) {
                TlsUtils.m27811a(a, 128);
            } else {
                throw new TlsFatalAlert((short) 46);
            }
            super.mo5814a(certificate2);
        } catch (Certificate certificate22) {
            throw new TlsFatalAlert((short) 43, certificate22);
        }
    }

    /* renamed from: a */
    public boolean mo6490a() {
        int i = this.a;
        return i == 3 || i == 5 || i == 11;
    }

    /* renamed from: a */
    public void mo6489a(CertificateRequest certificateRequest) {
        certificateRequest = certificateRequest.m27548a();
        for (short s : certificateRequest) {
            if (s != (short) 64) {
                switch (s) {
                    case (short) 1:
                    case (short) 2:
                    case (short) 3:
                    case (short) 4:
                        break;
                    default:
                        throw new TlsFatalAlert((short) 47);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo6491b(TlsCredentials tlsCredentials) {
        if (tlsCredentials instanceof TlsAgreementCredentials) {
            this.f31824h = (TlsAgreementCredentials) tlsCredentials;
        } else if ((tlsCredentials instanceof TlsSignerCredentials) == null) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    /* renamed from: a */
    public void mo6488a(OutputStream outputStream) {
        if (this.f31824h == null) {
            this.f31825i = TlsDHUtils.m27642a(this.c.mo5809b(), this.f31822f, outputStream);
        }
    }

    /* renamed from: b */
    public void mo5817b(InputStream inputStream) {
        if (this.f31826j == null) {
            this.f31826j = TlsDHUtils.m27643a(new DHPublicKeyParameters(TlsDHUtils.m27638a(inputStream), this.f31822f));
        }
    }

    /* renamed from: f */
    public byte[] mo6493f() {
        if (this.f31824h != null) {
            return this.f31824h.mo6812a(this.f31826j);
        }
        if (this.f31825i != null) {
            return TlsDHUtils.m27645a(this.f31826j, this.f31825i);
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: a */
    protected DHParameters m40915a(DHParameters dHParameters) {
        if (dHParameters.m35638a().bitLength() >= m40926g()) {
            return TlsDHUtils.m27641a(dHParameters);
        }
        throw new TlsFatalAlert((short) 71);
    }
}
