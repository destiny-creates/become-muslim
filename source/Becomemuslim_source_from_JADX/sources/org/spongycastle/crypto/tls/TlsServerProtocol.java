package org.spongycastle.crypto.tls;

import com.facebook.imageutils.JfifUtil;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.Arrays;

public class TlsServerProtocol extends TlsProtocol {
    /* renamed from: a */
    protected TlsServer f27344a;
    /* renamed from: b */
    TlsServerContextImpl f27345b;
    /* renamed from: c */
    protected TlsKeyExchange f27346c;
    /* renamed from: d */
    protected TlsCredentials f27347d;
    /* renamed from: e */
    protected CertificateRequest f27348e;
    /* renamed from: f */
    protected short f27349f;
    /* renamed from: g */
    protected TlsHandshakeHash f27350g;

    /* renamed from: a */
    protected TlsContext mo5835a() {
        return this.f27345b;
    }

    /* renamed from: b */
    AbstractTlsContext mo5837b() {
        return this.f27345b;
    }

    /* renamed from: c */
    protected TlsPeer mo5838c() {
        return this.f27344a;
    }

    /* renamed from: a */
    protected void mo5836a(short s, byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        Certificate certificate = null;
        if (s == (short) 1) {
            s = this.s;
            if (s == (short) 0) {
                m35961g(byteArrayInputStream);
                this.s = (short) 1;
                mo5839d();
                this.s = (short) 2;
                this.j.m27591f();
                s = this.f27344a.mo6476n();
                if (s != (short) 0) {
                    m27756b((Vector) s);
                }
                this.s = (short) 3;
                this.f27346c = this.f27344a.mo6819u();
                this.f27346c.mo5815a(mo5835a());
                this.f27347d = this.f27344a.mo6818t();
                if (this.f27347d == (short) 0) {
                    this.f27346c.mo6492e();
                } else {
                    this.f27346c.mo5816a(this.f27347d);
                    certificate = this.f27347d.mo6811a();
                    m27748a(certificate);
                }
                this.s = (short) 4;
                if (certificate == null || certificate.m27545a() != (short) 0) {
                    this.w = false;
                }
                if (this.w != (short) 0) {
                    CertificateStatus o = this.f27344a.mo6477o();
                    if (o != (short) 0) {
                        m35951a(o);
                    }
                }
                this.s = (short) 5;
                byte[] b = this.f27346c.mo5819b();
                if (b != (short) 0) {
                    m35958b(b);
                }
                this.s = (short) 6;
                if (this.f27347d != (short) 0) {
                    this.f27348e = this.f27344a.mo6478p();
                    if (this.f27348e != (short) 0) {
                        this.f27346c.mo6489a(this.f27348e);
                        m35950a(this.f27348e);
                        TlsUtils.m27815a(this.j.m27592g(), this.f27348e.m27549b());
                    }
                }
                this.s = (short) 7;
                mo5843o();
                this.s = (short) 8;
                this.j.m27592g().mo6484e();
            } else if (s == (short) 16) {
                m27774n();
            } else {
                throw new TlsFatalAlert((short) 10);
            }
        } else if (s == (short) 11) {
            switch (this.s) {
                case (short) 8:
                    this.f27344a.mo6466a(null);
                    break;
                case (short) 9:
                    break;
                default:
                    throw new TlsFatalAlert((short) 10);
            }
            if (this.f27348e != (short) 0) {
                m35949a(byteArrayInputStream);
                this.s = (short) 10;
                return;
            }
            throw new TlsFatalAlert((short) 10);
        } else if (s == (short) 20) {
            switch (this.s) {
                case (short) 11:
                    if (mo5844p() != (short) 0) {
                        throw new TlsFatalAlert((short) 10);
                    }
                    break;
                case (short) 12:
                    break;
                default:
                    throw new TlsFatalAlert((short) 10);
            }
            m27762c(byteArrayInputStream);
            this.s = (short) 13;
            if (this.x != (short) 0) {
                m35952a(this.f27344a.mo6479q());
                m27770j();
            }
            this.s = (short) 14;
            m27771k();
            this.s = (short) 15;
            this.s = (short) 16;
        } else if (s != (short) 23) {
            switch (s) {
                case (short) 15:
                    if (this.s != (short) 11) {
                        throw new TlsFatalAlert((short) 10);
                    } else if (mo5844p() != (short) 0) {
                        m35956b(byteArrayInputStream);
                        this.s = (short) 12;
                        return;
                    } else {
                        throw new TlsFatalAlert((short) 10);
                    }
                case (short) 16:
                    switch (this.s) {
                        case (short) 8:
                            this.f27344a.mo6466a(null);
                            break;
                        case (short) 9:
                            break;
                        case (short) 10:
                            break;
                        default:
                            throw new TlsFatalAlert((short) 10);
                    }
                    if (this.f27348e == (short) 0) {
                        this.f27346c.mo5821d();
                    } else if (TlsUtils.m27860c(mo5835a()) != (short) 0) {
                        throw new TlsFatalAlert((short) 10);
                    } else if (TlsUtils.m27825a(mo5835a()) == (short) 0) {
                        m35957b(Certificate.f22464a);
                    } else if (this.n == (short) 0) {
                        throw new TlsFatalAlert((short) 10);
                    }
                    m35962h(byteArrayInputStream);
                    this.s = (short) 11;
                    return;
                default:
                    throw new TlsFatalAlert((short) 10);
            }
        } else if (this.s == (short) 8) {
            this.f27344a.mo6466a(TlsProtocol.m27742f(byteArrayInputStream));
            this.s = (short) 9;
        } else {
            throw new TlsFatalAlert((short) 10);
        }
    }

    /* renamed from: a */
    protected void mo5842a(short s) {
        if (s != (short) 41) {
            super.mo5842a(s);
        } else if (TlsUtils.m27825a(mo5835a()) != (short) 0 && this.f27348e != (short) 0) {
            m35957b(Certificate.f22464a);
        }
    }

    /* renamed from: b */
    protected void m35957b(Certificate certificate) {
        if (this.f27348e == null) {
            throw new IllegalStateException();
        } else if (this.n == null) {
            this.n = certificate;
            if (certificate.m27545a()) {
                this.f27346c.mo5821d();
            } else {
                this.f27349f = TlsUtils.m27803a(certificate, this.f27347d.mo6811a());
                this.f27346c.mo5818b(certificate);
            }
            this.f27344a.mo6467a(certificate);
        } else {
            throw new TlsFatalAlert((short) 10);
        }
    }

    /* renamed from: a */
    protected void m35949a(ByteArrayInputStream byteArrayInputStream) {
        Certificate a = Certificate.m27542a((InputStream) byteArrayInputStream);
        TlsProtocol.m27739d(byteArrayInputStream);
        m35957b(a);
    }

    /* renamed from: b */
    protected void m35956b(ByteArrayInputStream byteArrayInputStream) {
        DigitallySigned a = DigitallySigned.m27555a(mo5835a(), byteArrayInputStream);
        TlsProtocol.m27739d(byteArrayInputStream);
        try {
            byte[] b;
            if (TlsUtils.m27860c(mo5835a())) {
                b = this.f27350g.mo6482b(a.m27556a().m27618a());
            } else {
                b = this.m.m27602g();
            }
            AsymmetricKeyParameter a2 = PublicKeyFactory.m27886a(this.n.m27543a(0).m40282j());
            TlsSigner f = TlsUtils.m27873f(this.f27349f);
            f.mo5825a(mo5835a());
            if (!f.mo6495a(a.m27556a(), a.m27558b(), a2, b)) {
                throw new TlsFatalAlert((short) 51);
            }
        } catch (Throwable e) {
            throw new TlsFatalAlert((short) 51, e);
        }
    }

    /* renamed from: g */
    protected void m35961g(ByteArrayInputStream byteArrayInputStream) {
        ProtocolVersion h = TlsUtils.m27878h((InputStream) byteArrayInputStream);
        this.j.m27587b(h);
        if (h.m27571c()) {
            throw new TlsFatalAlert((short) 47);
        }
        byte[] b = TlsUtils.m27849b(32, (InputStream) byteArrayInputStream);
        if (TlsUtils.m27872e((InputStream) byteArrayInputStream).length <= 32) {
            int b2 = TlsUtils.m27837b((InputStream) byteArrayInputStream);
            if (b2 < 2 || (b2 & 1) != 0) {
                throw new TlsFatalAlert((short) 50);
            }
            this.o = TlsUtils.m27867d(b2 / 2, (InputStream) byteArrayInputStream);
            b2 = TlsUtils.m27802a((InputStream) byteArrayInputStream);
            if (b2 >= (short) 1) {
                this.p = TlsUtils.m27861c(b2, (InputStream) byteArrayInputStream);
                this.q = TlsProtocol.m27741e(byteArrayInputStream);
                this.m.f22553o = TlsExtensionsUtils.m27698g(this.q);
                mo5837b().m35847a(h);
                this.f27344a.mo6468a(h);
                this.f27344a.mo6471b(Arrays.m29355a(this.o, 22016));
                this.m.f22545g = b;
                this.f27344a.mo6469a(this.o);
                this.f27344a.mo6470a(this.p);
                if (Arrays.m29355a(this.o, (int) JfifUtil.MARKER_FIRST_BYTE) != null) {
                    this.v = true;
                }
                byte[] a = TlsUtils.m27827a(this.q, h);
                if (a != null) {
                    this.v = true;
                    if (Arrays.m29372b(a, TlsProtocol.m27737a(TlsUtils.f22634a)) == null) {
                        throw new TlsFatalAlert((short) 40);
                    }
                }
                this.f27344a.mo5824a(this.v);
                if (this.q != null) {
                    this.f27344a.mo6465a(this.q);
                    return;
                }
                return;
            }
            throw new TlsFatalAlert((short) 47);
        }
        throw new TlsFatalAlert((short) 47);
    }

    /* renamed from: h */
    protected void m35962h(ByteArrayInputStream byteArrayInputStream) {
        this.f27346c.mo5817b((InputStream) byteArrayInputStream);
        TlsProtocol.m27739d(byteArrayInputStream);
        this.f27350g = this.j.m27593h();
        this.m.f22547i = TlsProtocol.m27736a(mo5835a(), this.f27350g, null);
        TlsProtocol.m27735a((TlsContext) mo5835a(), this.f27346c);
        this.j.m27581a(mo5838c().mo6463c(), mo5838c().mo6464d());
        if (this.x == null) {
            m27770j();
        }
    }

    /* renamed from: a */
    protected void m35950a(CertificateRequest certificateRequest) {
        OutputStream handshakeMessage = new HandshakeMessage(this, (short) 13);
        certificateRequest.m27547a(handshakeMessage);
        handshakeMessage.m27731a();
    }

    /* renamed from: a */
    protected void m35951a(CertificateStatus certificateStatus) {
        OutputStream handshakeMessage = new HandshakeMessage(this, (short) 22);
        certificateStatus.m27552a(handshakeMessage);
        handshakeMessage.m27731a();
    }

    /* renamed from: a */
    protected void m35952a(NewSessionTicket newSessionTicket) {
        if (newSessionTicket != null) {
            OutputStream handshakeMessage = new HandshakeMessage(this, (short) 4);
            newSessionTicket.m27564a(handshakeMessage);
            handshakeMessage.m27731a();
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: d */
    protected void mo5839d() {
        OutputStream handshakeMessage = new HandshakeMessage(this, (short) 2);
        ProtocolVersion j = this.f27344a.mo6472j();
        if (j.m27568a(mo5835a().mo5811d())) {
            this.j.m27580a(j);
            this.j.m27587b(j);
            this.j.m27583a(true);
            mo5837b().m35849b(j);
            TlsUtils.m27813a(j, handshakeMessage);
            handshakeMessage.write(this.m.f22546h);
            TlsUtils.m27819a(TlsUtils.f22634a, handshakeMessage);
            int k = this.f27344a.mo6473k();
            if (!Arrays.m29355a(this.o, k) || k == 0 || CipherSuite.m27553a(k) || !TlsUtils.m27822a(k, mo5835a().mo5812e())) {
                throw new TlsFatalAlert((short) 80);
            }
            this.m.f22540b = k;
            short l = this.f27344a.mo6474l();
            if (Arrays.m29359a(this.p, l)) {
                this.m.f22541c = l;
                TlsUtils.m27842b(k, handshakeMessage);
                TlsUtils.m27817a(l, handshakeMessage);
                this.r = this.f27344a.mo6475m();
                boolean z = false;
                if (this.v) {
                    if ((TlsUtils.m27827a(this.r, h) == null ? 1 : null) != null) {
                        this.r = TlsExtensionsUtils.m27681a(this.r);
                        this.r.put(h, TlsProtocol.m27737a(TlsUtils.f22634a));
                    }
                }
                if (this.m.f22553o) {
                    this.r = TlsExtensionsUtils.m27681a(this.r);
                    TlsExtensionsUtils.m27690c(this.r);
                }
                if (this.r != null) {
                    this.m.f22552n = TlsExtensionsUtils.m27697f(this.r);
                    this.m.f22550l = m27747a(this.q, this.r, (short) 80);
                    this.m.f22551m = TlsExtensionsUtils.m27699h(this.r);
                    boolean z2 = !this.t && TlsUtils.m27823a(this.r, TlsExtensionsUtils.f22589f, (short) 80);
                    this.w = z2;
                    if (!this.t && TlsUtils.m27823a(this.r, TlsProtocol.f22605i, (short) 80)) {
                        z = true;
                    }
                    this.x = z;
                    TlsProtocol.m27733a(handshakeMessage, this.r);
                }
                this.m.f22542d = TlsProtocol.m27732a(mo5835a(), this.m.m27596a());
                this.m.f22543e = 12;
                m27766f();
                handshakeMessage.m27731a();
                return;
            }
            throw new TlsFatalAlert((short) 80);
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: o */
    protected void mo5843o() {
        byte[] bArr = new byte[4];
        TlsUtils.m27818a((short) 14, bArr, 0);
        TlsUtils.m27858c(0, bArr, 1);
        m27764c(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    protected void m35958b(byte[] bArr) {
        HandshakeMessage handshakeMessage = new HandshakeMessage(this, (short) 12, bArr.length);
        handshakeMessage.write(bArr);
        handshakeMessage.m27731a();
    }

    /* renamed from: p */
    protected boolean mo5844p() {
        return this.f27349f >= (short) 0 && TlsUtils.m27871e(this.f27349f);
    }
}
