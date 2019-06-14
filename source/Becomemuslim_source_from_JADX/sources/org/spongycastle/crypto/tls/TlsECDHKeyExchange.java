package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;

public class TlsECDHKeyExchange extends AbstractTlsKeyExchange {
    /* renamed from: e */
    protected TlsSigner f31827e;
    /* renamed from: f */
    protected int[] f31828f;
    /* renamed from: g */
    protected short[] f31829g;
    /* renamed from: h */
    protected short[] f31830h;
    /* renamed from: i */
    protected AsymmetricKeyParameter f31831i;
    /* renamed from: j */
    protected TlsAgreementCredentials f31832j;
    /* renamed from: k */
    protected ECPrivateKeyParameters f31833k;
    /* renamed from: l */
    protected ECPublicKeyParameters f31834l;

    /* renamed from: b */
    public void mo5818b(Certificate certificate) {
    }

    /* renamed from: a */
    public void mo5815a(TlsContext tlsContext) {
        super.mo5815a(tlsContext);
        if (this.f31827e != null) {
            this.f31827e.mo5825a(tlsContext);
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
            this.f31831i = PublicKeyFactory.m27886a(a.m40282j());
            if (this.f31827e == null) {
                try {
                    this.f31834l = TlsECCUtils.m27656a((ECPublicKeyParameters) this.f31831i);
                    TlsUtils.m27811a(a, 8);
                } catch (Certificate certificate2) {
                    throw new TlsFatalAlert((short) 46, certificate2);
                }
            } else if (this.f31827e.mo6497a(this.f31831i)) {
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
        switch (this.a) {
            case 17:
            case 19:
            case 20:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public void mo6489a(CertificateRequest certificateRequest) {
        certificateRequest = certificateRequest.m27548a();
        for (short s : certificateRequest) {
            switch (s) {
                case (short) 1:
                case (short) 2:
                    break;
                default:
                    switch (s) {
                        case (short) 64:
                        case (short) 65:
                        case (short) 66:
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
            this.f31832j = (TlsAgreementCredentials) tlsCredentials;
        } else if ((tlsCredentials instanceof TlsSignerCredentials) == null) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    /* renamed from: a */
    public void mo6488a(OutputStream outputStream) {
        if (this.f31832j == null) {
            this.f31833k = TlsECCUtils.m27655a(this.c.mo5809b(), this.f31830h, this.f31834l.m40792b(), outputStream);
        }
    }

    /* renamed from: b */
    public void mo5817b(InputStream inputStream) {
        if (this.f31834l == null) {
            byte[] e = TlsUtils.m27872e(inputStream);
            this.f31834l = TlsECCUtils.m27656a(TlsECCUtils.m27657a(this.f31830h, this.f31833k.m40792b(), e));
        }
    }

    /* renamed from: f */
    public byte[] mo6493f() {
        if (this.f31832j != null) {
            return this.f31832j.mo6812a(this.f31834l);
        }
        if (this.f31833k != null) {
            return TlsECCUtils.m27669a(this.f31834l, this.f31833k);
        }
        throw new TlsFatalAlert((short) 80);
    }
}
