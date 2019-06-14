package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.util.io.TeeInputStream;

public class TlsECDHEKeyExchange extends TlsECDHKeyExchange {
    /* renamed from: d */
    protected TlsSignerCredentials f32669d;

    /* renamed from: a */
    public void mo5816a(TlsCredentials tlsCredentials) {
        if (tlsCredentials instanceof TlsSignerCredentials) {
            mo5814a(tlsCredentials.mo6811a());
            this.f32669d = (TlsSignerCredentials) tlsCredentials;
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: b */
    public byte[] mo5819b() {
        OutputStream digestInputBuffer = new DigestInputBuffer();
        this.k = TlsECCUtils.m27654a(this.c.mo5809b(), this.f, this.g, digestInputBuffer);
        SignatureAndHashAlgorithm a = TlsUtils.m27801a(this.c, this.f32669d);
        Digest a2 = TlsUtils.m27799a(a);
        SecurityParameters c = this.c.mo5810c();
        a2.mo5731a(c.f22545g, 0, c.f22545g.length);
        a2.mo5731a(c.f22546h, 0, c.f22546h.length);
        digestInputBuffer.m27554a(a2);
        byte[] bArr = new byte[a2.mo5732b()];
        a2.mo5728a(bArr, 0);
        new DigitallySigned(a, this.f32669d.mo6814a(bArr)).m27557a(digestInputBuffer);
        return digestInputBuffer.toByteArray();
    }

    /* renamed from: a */
    public void mo5813a(InputStream inputStream) {
        SecurityParameters c = this.c.mo5810c();
        OutputStream signerInputBuffer = new SignerInputBuffer();
        InputStream teeInputStream = new TeeInputStream(inputStream, signerInputBuffer);
        ECDomainParameters a = TlsECCUtils.m27653a(this.f, this.g, teeInputStream);
        byte[] e = TlsUtils.m27872e(teeInputStream);
        inputStream = DigitallySigned.m27555a(this.c, inputStream);
        Signer a2 = m43418a(this.e, inputStream.m27556a(), c);
        signerInputBuffer.m27621a(a2);
        if (a2.mo5798a(inputStream.m27558b()) != null) {
            this.l = TlsECCUtils.m27656a(TlsECCUtils.m27657a(this.g, a, e));
            return;
        }
        throw new TlsFatalAlert((short) 51);
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
    protected Signer m43418a(TlsSigner tlsSigner, SignatureAndHashAlgorithm signatureAndHashAlgorithm, SecurityParameters securityParameters) {
        tlsSigner = tlsSigner.mo6494a(signatureAndHashAlgorithm, this.i);
        tlsSigner.mo5797a(securityParameters.f22545g, 0, securityParameters.f22545g.length);
        tlsSigner.mo5797a(securityParameters.f22546h, 0, securityParameters.f22546h.length);
        return tlsSigner;
    }
}
