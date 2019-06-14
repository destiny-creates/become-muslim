package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.io.Streams;

public class TlsPSKKeyExchange extends AbstractTlsKeyExchange {
    /* renamed from: d */
    protected TlsPSKIdentity f31835d;
    /* renamed from: e */
    protected TlsPSKIdentityManager f31836e;
    /* renamed from: f */
    protected DHParameters f31837f;
    /* renamed from: g */
    protected int[] f31838g;
    /* renamed from: h */
    protected short[] f31839h;
    /* renamed from: i */
    protected short[] f31840i;
    /* renamed from: j */
    protected byte[] f31841j = null;
    /* renamed from: k */
    protected byte[] f31842k = null;
    /* renamed from: l */
    protected DHPrivateKeyParameters f31843l = null;
    /* renamed from: m */
    protected DHPublicKeyParameters f31844m = null;
    /* renamed from: n */
    protected ECPrivateKeyParameters f31845n = null;
    /* renamed from: o */
    protected ECPublicKeyParameters f31846o = null;
    /* renamed from: p */
    protected AsymmetricKeyParameter f31847p = null;
    /* renamed from: q */
    protected RSAKeyParameters f31848q = null;
    /* renamed from: r */
    protected TlsEncryptionCredentials f31849r = null;
    /* renamed from: s */
    protected byte[] f31850s;

    public TlsPSKKeyExchange(int i, Vector vector, TlsPSKIdentity tlsPSKIdentity, TlsPSKIdentityManager tlsPSKIdentityManager, DHParameters dHParameters, int[] iArr, short[] sArr, short[] sArr2) {
        super(i, vector);
        if (i != 24) {
            switch (i) {
                case 13:
                case 14:
                case 15:
                    break;
                default:
                    throw new IllegalArgumentException("unsupported key exchange algorithm");
            }
        }
        this.f31835d = tlsPSKIdentity;
        this.f31836e = tlsPSKIdentityManager;
        this.f31837f = dHParameters;
        this.f31838g = iArr;
        this.f31839h = sArr;
        this.f31840i = sArr2;
    }

    /* renamed from: e */
    public void mo6492e() {
        if (this.a == 15) {
            throw new TlsFatalAlert((short) 10);
        }
    }

    /* renamed from: a */
    public void mo5816a(TlsCredentials tlsCredentials) {
        if (tlsCredentials instanceof TlsEncryptionCredentials) {
            mo5814a(tlsCredentials.mo6811a());
            this.f31849r = (TlsEncryptionCredentials) tlsCredentials;
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: b */
    public byte[] mo5819b() {
        this.f31841j = this.f31836e.m27724a();
        if (this.f31841j == null && !mo6490a()) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.f31841j == null) {
            TlsUtils.m27844b(TlsUtils.f22634a, byteArrayOutputStream);
        } else {
            TlsUtils.m27844b(this.f31841j, byteArrayOutputStream);
        }
        if (this.a == 14) {
            if (this.f31837f != null) {
                this.f31843l = TlsDHUtils.m27647b(this.c.mo5809b(), this.f31837f, byteArrayOutputStream);
            } else {
                throw new TlsFatalAlert((short) 80);
            }
        } else if (this.a == 24) {
            this.f31845n = TlsECCUtils.m27654a(this.c.mo5809b(), this.f31838g, this.f31839h, byteArrayOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public void mo5814a(Certificate certificate) {
        if (this.a != 15) {
            throw new TlsFatalAlert((short) 10);
        } else if (certificate.m27545a()) {
            throw new TlsFatalAlert((short) 42);
        } else {
            Certificate a = certificate.m27543a(0);
            try {
                this.f31847p = PublicKeyFactory.m27886a(a.m40282j());
                if (this.f31847p.m35630a()) {
                    throw new TlsFatalAlert((short) 80);
                }
                this.f31848q = m40944a((RSAKeyParameters) this.f31847p);
                TlsUtils.m27811a(a, 32);
                super.mo5814a(certificate);
            } catch (Certificate certificate2) {
                throw new TlsFatalAlert((short) 43, certificate2);
            }
        }
    }

    /* renamed from: a */
    public boolean mo6490a() {
        int i = this.a;
        return i == 14 || i == 24;
    }

    /* renamed from: a */
    public void mo5813a(InputStream inputStream) {
        this.f31841j = TlsUtils.m27875f(inputStream);
        if (this.a == 14) {
            this.f31844m = TlsDHUtils.m27643a(ServerDHParams.m27603a(inputStream).m27604a());
            this.f31837f = this.f31844m.m40790b();
        } else if (this.a == 24) {
            this.f31846o = TlsECCUtils.m27656a(TlsECCUtils.m27657a(this.f31839h, TlsECCUtils.m27653a(this.f31838g, this.f31839h, inputStream), TlsUtils.m27872e(inputStream)));
        }
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
        if (this.f31841j == null) {
            this.f31835d.mo5827a();
        } else {
            this.f31835d.mo5828a(this.f31841j);
        }
        byte[] b = this.f31835d.mo5829b();
        if (b != null) {
            this.f31842k = this.f31835d.mo5830c();
            if (this.f31842k != null) {
                TlsUtils.m27844b(b, outputStream);
                this.c.mo5810c().f22548j = Arrays.m29373b(b);
                if (this.a == 14) {
                    this.f31843l = TlsDHUtils.m27642a(this.c.mo5809b(), this.f31837f, outputStream);
                    return;
                } else if (this.a == 24) {
                    this.f31845n = TlsECCUtils.m27655a(this.c.mo5809b(), this.f31840i, this.f31846o.m40792b(), outputStream);
                    return;
                } else if (this.a == 15) {
                    this.f31850s = TlsRSAUtils.m27775a(this.c, this.f31848q, outputStream);
                    return;
                } else {
                    return;
                }
            }
            throw new TlsFatalAlert((short) 80);
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: b */
    public void mo5817b(InputStream inputStream) {
        byte[] f = TlsUtils.m27875f(inputStream);
        this.f31842k = this.f31836e.m27725a(f);
        if (this.f31842k != null) {
            this.c.mo5810c().f22548j = f;
            if (this.a == 14) {
                this.f31844m = TlsDHUtils.m27643a(new DHPublicKeyParameters(TlsDHUtils.m27638a(inputStream), this.f31837f));
                return;
            } else if (this.a == 24) {
                byte[] e = TlsUtils.m27872e(inputStream);
                this.f31846o = TlsECCUtils.m27656a(TlsECCUtils.m27657a(this.f31840i, this.f31845n.m40792b(), e));
                return;
            } else if (this.a == 15) {
                if (TlsUtils.m27825a(this.c)) {
                    inputStream = Streams.m29442a(inputStream);
                } else {
                    inputStream = TlsUtils.m27875f(inputStream);
                }
                this.f31850s = this.f31849r.mo6813a(inputStream);
                return;
            } else {
                return;
            }
        }
        throw new TlsFatalAlert((short) 115);
    }

    /* renamed from: f */
    public byte[] mo6493f() {
        byte[] a = m40951a(this.f31842k.length);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream((a.length + 4) + this.f31842k.length);
        TlsUtils.m27844b(a, byteArrayOutputStream);
        TlsUtils.m27844b(this.f31842k, byteArrayOutputStream);
        Arrays.m29351a(this.f31842k, (byte) 0);
        this.f31842k = null;
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    protected byte[] m40951a(int i) {
        if (this.a == 14) {
            if (this.f31843l != 0) {
                return TlsDHUtils.m27645a(this.f31844m, this.f31843l);
            }
            throw new TlsFatalAlert((short) 80);
        } else if (this.a == 24) {
            if (this.f31845n != 0) {
                return TlsECCUtils.m27669a(this.f31846o, this.f31845n);
            }
            throw new TlsFatalAlert((short) 80);
        } else if (this.a == 15) {
            return this.f31850s;
        } else {
            return new byte[i];
        }
    }

    /* renamed from: a */
    protected RSAKeyParameters m40944a(RSAKeyParameters rSAKeyParameters) {
        if (rSAKeyParameters.m40801c().isProbablePrime(2)) {
            return rSAKeyParameters;
        }
        throw new TlsFatalAlert((short) 47);
    }
}
