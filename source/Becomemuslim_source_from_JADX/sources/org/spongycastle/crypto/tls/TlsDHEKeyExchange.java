package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.util.io.TeeInputStream;

public class TlsDHEKeyExchange extends TlsDHKeyExchange {
    /* renamed from: d */
    protected TlsSignerCredentials f32668d;

    /* renamed from: a */
    public void mo5816a(TlsCredentials tlsCredentials) {
        if (tlsCredentials instanceof TlsSignerCredentials) {
            mo5814a(tlsCredentials.mo6811a());
            this.f32668d = (TlsSignerCredentials) tlsCredentials;
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: b */
    public byte[] mo5819b() {
        if (this.f != null) {
            OutputStream digestInputBuffer = new DigestInputBuffer();
            this.i = TlsDHUtils.m27647b(this.c.mo5809b(), this.f, digestInputBuffer);
            SignatureAndHashAlgorithm a = TlsUtils.m27801a(this.c, this.f32668d);
            Digest a2 = TlsUtils.m27799a(a);
            SecurityParameters c = this.c.mo5810c();
            a2.mo5731a(c.f22545g, 0, c.f22545g.length);
            a2.mo5731a(c.f22546h, 0, c.f22546h.length);
            digestInputBuffer.m27554a(a2);
            byte[] bArr = new byte[a2.mo5732b()];
            a2.mo5728a(bArr, 0);
            new DigitallySigned(a, this.f32668d.mo6814a(bArr)).m27557a(digestInputBuffer);
            return digestInputBuffer.toByteArray();
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: a */
    public void mo5813a(InputStream inputStream) {
        SecurityParameters c = this.c.mo5810c();
        OutputStream signerInputBuffer = new SignerInputBuffer();
        ServerDHParams a = ServerDHParams.m27603a(new TeeInputStream(inputStream, signerInputBuffer));
        inputStream = DigitallySigned.m27555a(this.c, inputStream);
        Signer a2 = m43411a(this.e, inputStream.m27556a(), c);
        signerInputBuffer.m27621a(a2);
        if (a2.mo5798a(inputStream.m27558b()) != null) {
            this.j = TlsDHUtils.m27643a(a.m27604a());
            this.f = m40915a((DHParameters) this.j.m40790b());
            return;
        }
        throw new TlsFatalAlert((short) 51);
    }

    /* renamed from: a */
    protected Signer m43411a(TlsSigner tlsSigner, SignatureAndHashAlgorithm signatureAndHashAlgorithm, SecurityParameters securityParameters) {
        tlsSigner = tlsSigner.mo6494a(signatureAndHashAlgorithm, this.g);
        tlsSigner.mo5797a(securityParameters.f22545g, 0, securityParameters.f22545g.length);
        tlsSigner.mo5797a(securityParameters.f22546h, 0, securityParameters.f22546h.length);
        return tlsSigner;
    }
}
