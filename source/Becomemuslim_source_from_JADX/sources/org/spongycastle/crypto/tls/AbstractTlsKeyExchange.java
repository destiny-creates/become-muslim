package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.util.Vector;

public abstract class AbstractTlsKeyExchange implements TlsKeyExchange {
    /* renamed from: a */
    protected int f27298a;
    /* renamed from: b */
    protected Vector f27299b;
    /* renamed from: c */
    protected TlsContext f27300c;

    /* renamed from: a */
    public boolean mo6490a() {
        return false;
    }

    /* renamed from: b */
    public void mo5818b(Certificate certificate) {
    }

    /* renamed from: d */
    public void mo5821d() {
    }

    protected AbstractTlsKeyExchange(int i, Vector vector) {
        this.f27298a = i;
        this.f27299b = vector;
    }

    /* renamed from: a */
    public void mo5815a(TlsContext tlsContext) {
        this.f27300c = tlsContext;
        ProtocolVersion d = tlsContext.mo5811d();
        if (TlsUtils.m27824a(d)) {
            if (this.f27299b == null) {
                tlsContext = this.f27298a;
                if (tlsContext != 1) {
                    if (tlsContext != 3) {
                        if (tlsContext != 5) {
                            if (tlsContext != 7) {
                                if (tlsContext != 9) {
                                    switch (tlsContext) {
                                        case 13:
                                        case 14:
                                            return;
                                        case 15:
                                        case 18:
                                        case 19:
                                            break;
                                        case 16:
                                        case 17:
                                            this.f27299b = TlsUtils.m27839b();
                                            return;
                                        default:
                                            switch (tlsContext) {
                                                case 21:
                                                case 24:
                                                    return;
                                                case 22:
                                                    break;
                                                case 23:
                                                    break;
                                                default:
                                                    throw new IllegalStateException("unsupported key exchange algorithm");
                                            }
                                    }
                                }
                            }
                        }
                    }
                    this.f27299b = TlsUtils.m27795a();
                    return;
                }
                this.f27299b = TlsUtils.m27853c();
            }
        } else if (this.f27299b != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("supported_signature_algorithms not allowed for ");
            stringBuilder.append(d);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public void mo5814a(Certificate certificate) {
        certificate = this.f27299b;
    }

    /* renamed from: a */
    public void mo5816a(TlsCredentials tlsCredentials) {
        mo5814a(tlsCredentials.mo6811a());
    }

    /* renamed from: b */
    public byte[] mo5819b() {
        if (!mo6490a()) {
            return null;
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: c */
    public void mo5820c() {
        if (mo6490a()) {
            throw new TlsFatalAlert((short) 10);
        }
    }

    /* renamed from: a */
    public void mo5813a(InputStream inputStream) {
        if (mo6490a() == null) {
            throw new TlsFatalAlert((short) 10);
        }
    }

    /* renamed from: b */
    public void mo5817b(InputStream inputStream) {
        throw new TlsFatalAlert((short) 80);
    }
}
