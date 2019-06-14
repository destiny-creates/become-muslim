package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.agreement.srp.SRP6Client;
import org.spongycastle.crypto.agreement.srp.SRP6Server;
import org.spongycastle.crypto.agreement.srp.SRP6Util;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.SRP6GroupParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.io.TeeInputStream;

public class TlsSRPKeyExchange extends AbstractTlsKeyExchange {
    /* renamed from: d */
    protected TlsSigner f31855d;
    /* renamed from: e */
    protected TlsSRPGroupVerifier f31856e;
    /* renamed from: f */
    protected byte[] f31857f;
    /* renamed from: g */
    protected byte[] f31858g;
    /* renamed from: h */
    protected AsymmetricKeyParameter f31859h = null;
    /* renamed from: i */
    protected SRP6GroupParameters f31860i = null;
    /* renamed from: j */
    protected SRP6Client f31861j = null;
    /* renamed from: k */
    protected SRP6Server f31862k = null;
    /* renamed from: l */
    protected BigInteger f31863l = null;
    /* renamed from: m */
    protected BigInteger f31864m = null;
    /* renamed from: n */
    protected byte[] f31865n = null;
    /* renamed from: o */
    protected TlsSignerCredentials f31866o = null;

    /* renamed from: a */
    public boolean mo6490a() {
        return true;
    }

    /* renamed from: a */
    protected static TlsSigner m40972a(int i) {
        switch (i) {
            case 21:
                return 0;
            case 22:
                return new TlsDSSSigner();
            case 23:
                return new TlsRSASigner();
            default:
                throw new IllegalArgumentException("unsupported key exchange algorithm");
        }
    }

    public TlsSRPKeyExchange(int i, Vector vector, TlsSRPGroupVerifier tlsSRPGroupVerifier, byte[] bArr, byte[] bArr2) {
        super(i, vector);
        this.f31855d = m40972a(i);
        this.f31856e = tlsSRPGroupVerifier;
        this.f31857f = bArr;
        this.f31858g = bArr2;
        this.f31861j = new SRP6Client();
    }

    public TlsSRPKeyExchange(int i, Vector vector, byte[] bArr, TlsSRPLoginParameters tlsSRPLoginParameters) {
        super(i, vector);
        this.f31855d = m40972a(i);
        this.f31857f = bArr;
        this.f31862k = new SRP6Server();
        this.f31860i = tlsSRPLoginParameters.m27779a();
        this.f31864m = tlsSRPLoginParameters.m27781c();
        this.f31865n = tlsSRPLoginParameters.m27780b();
    }

    /* renamed from: a */
    public void mo5815a(TlsContext tlsContext) {
        super.mo5815a(tlsContext);
        if (this.f31855d != null) {
            this.f31855d.mo5825a(tlsContext);
        }
    }

    /* renamed from: e */
    public void mo6492e() {
        if (this.f31855d != null) {
            throw new TlsFatalAlert((short) 10);
        }
    }

    /* renamed from: a */
    public void mo5814a(Certificate certificate) {
        if (this.f31855d == null) {
            throw new TlsFatalAlert((short) 10);
        } else if (certificate.m27545a()) {
            throw new TlsFatalAlert((short) 42);
        } else {
            Certificate a = certificate.m27543a(0);
            try {
                this.f31859h = PublicKeyFactory.m27886a(a.m40282j());
                if (this.f31855d.mo6497a(this.f31859h)) {
                    TlsUtils.m27811a(a, 128);
                    super.mo5814a(certificate);
                    return;
                }
                throw new TlsFatalAlert((short) 46);
            } catch (Certificate certificate2) {
                throw new TlsFatalAlert((short) 43, certificate2);
            }
        }
    }

    /* renamed from: a */
    public void mo5816a(TlsCredentials tlsCredentials) {
        if (this.a == 21 || !(tlsCredentials instanceof TlsSignerCredentials)) {
            throw new TlsFatalAlert((short) 80);
        }
        mo5814a(tlsCredentials.mo6811a());
        this.f31866o = (TlsSignerCredentials) tlsCredentials;
    }

    /* renamed from: b */
    public byte[] mo5819b() {
        this.f31862k.m27372a(this.f31860i, this.f31864m, TlsUtils.m27855c((short) 2), this.c.mo5809b());
        ServerSRPParams serverSRPParams = new ServerSRPParams(this.f31860i.m27501b(), this.f31860i.m27500a(), this.f31865n, this.f31862k.m27369a());
        OutputStream digestInputBuffer = new DigestInputBuffer();
        serverSRPParams.m27608a(digestInputBuffer);
        if (this.f31866o != null) {
            SignatureAndHashAlgorithm a = TlsUtils.m27801a(this.c, this.f31866o);
            Digest a2 = TlsUtils.m27799a(a);
            SecurityParameters c = this.c.mo5810c();
            a2.mo5731a(c.f22545g, 0, c.f22545g.length);
            a2.mo5731a(c.f22546h, 0, c.f22546h.length);
            digestInputBuffer.m27554a(a2);
            byte[] bArr = new byte[a2.mo5732b()];
            a2.mo5728a(bArr, 0);
            new DigitallySigned(a, this.f31866o.mo6814a(bArr)).m27557a(digestInputBuffer);
        }
        return digestInputBuffer.toByteArray();
    }

    /* renamed from: a */
    public void mo5813a(InputStream inputStream) {
        SignerInputBuffer signerInputBuffer;
        InputStream teeInputStream;
        SecurityParameters c = this.c.mo5810c();
        if (this.f31855d != null) {
            signerInputBuffer = new SignerInputBuffer();
            teeInputStream = new TeeInputStream(inputStream, signerInputBuffer);
        } else {
            signerInputBuffer = null;
            teeInputStream = inputStream;
        }
        ServerSRPParams a = ServerSRPParams.m27606a(teeInputStream);
        if (signerInputBuffer != null) {
            inputStream = DigitallySigned.m27555a(this.c, inputStream);
            Signer a2 = m40973a(this.f31855d, inputStream.m27556a(), c);
            signerInputBuffer.m27621a(a2);
            if (a2.mo5798a(inputStream.m27558b()) == null) {
                throw new TlsFatalAlert((short) 51);
            }
        }
        this.f31860i = new SRP6GroupParameters(a.m27610c(), a.m27609b());
        if (this.f31856e.mo5833a(this.f31860i) != null) {
            this.f31865n = a.m27611d();
            try {
                this.f31863l = SRP6Util.m27376a(this.f31860i.m27501b(), a.m27607a());
                this.f31861j.m27367a(this.f31860i, TlsUtils.m27855c((short) 2), this.c.mo5809b());
                return;
            } catch (InputStream inputStream2) {
                throw new TlsFatalAlert((short) 47, inputStream2);
            }
        }
        throw new TlsFatalAlert((short) 71);
    }

    /* renamed from: a */
    public void mo6489a(CertificateRequest certificateRequest) {
        throw new TlsFatalAlert((short) 10);
    }

    /* renamed from: b */
    public void mo6491b(TlsCredentials tlsCredentials) {
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: a */
    public void mo6488a(OutputStream outputStream) {
        TlsSRPUtils.m27783a(this.f31861j.m27365a(this.f31865n, this.f31857f, this.f31858g), outputStream);
        this.c.mo5810c().f22549k = Arrays.m29373b(this.f31857f);
    }

    /* renamed from: b */
    public void mo5817b(InputStream inputStream) {
        try {
            this.f31863l = SRP6Util.m27376a(this.f31860i.m27501b(), TlsSRPUtils.m27782a(inputStream));
            this.c.mo5810c().f22549k = Arrays.m29373b(this.f31857f);
        } catch (InputStream inputStream2) {
            throw new TlsFatalAlert((short) 47, inputStream2);
        }
    }

    /* renamed from: f */
    public byte[] mo6493f() {
        try {
            BigInteger a;
            if (this.f31862k != null) {
                a = this.f31862k.m27370a(this.f31863l);
            } else {
                a = this.f31861j.m27364a(this.f31863l);
            }
            return BigIntegers.m29389a(a);
        } catch (Throwable e) {
            throw new TlsFatalAlert((short) 47, e);
        }
    }

    /* renamed from: a */
    protected Signer m40973a(TlsSigner tlsSigner, SignatureAndHashAlgorithm signatureAndHashAlgorithm, SecurityParameters securityParameters) {
        tlsSigner = tlsSigner.mo6494a(signatureAndHashAlgorithm, this.f31859h);
        tlsSigner.mo5797a(securityParameters.f22545g, 0, securityParameters.f22545g.length);
        tlsSigner.mo5797a(securityParameters.f22546h, 0, securityParameters.f22546h.length);
        return tlsSigner;
    }
}
