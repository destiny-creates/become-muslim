package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.util.Arrays;

public class TlsClientProtocol extends TlsProtocol {
    /* renamed from: a */
    protected TlsClient f27334a;
    /* renamed from: b */
    TlsClientContextImpl f27335b;
    /* renamed from: c */
    protected byte[] f27336c;
    /* renamed from: d */
    protected TlsKeyExchange f27337d;
    /* renamed from: e */
    protected TlsAuthentication f27338e;
    /* renamed from: f */
    protected CertificateStatus f27339f;
    /* renamed from: g */
    protected CertificateRequest f27340g;

    /* renamed from: a */
    protected TlsContext mo5835a() {
        return this.f27335b;
    }

    /* renamed from: b */
    AbstractTlsContext mo5837b() {
        return this.f27335b;
    }

    /* renamed from: c */
    protected TlsPeer mo5838c() {
        return this.f27334a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    protected void mo5836a(short r9, byte[] r10) {
        /*
        r8 = this;
        r0 = new java.io.ByteArrayInputStream;
        r0.<init>(r10);
        r10 = r8.t;
        r1 = 15;
        r2 = 20;
        r3 = 13;
        r4 = 16;
        r5 = 2;
        r6 = 10;
        if (r10 == 0) goto L_0x002d;
    L_0x0014:
        if (r9 != r2) goto L_0x0027;
    L_0x0016:
        r9 = r8.s;
        if (r9 != r5) goto L_0x0027;
    L_0x001a:
        r8.m27762c(r0);
        r8.s = r1;
        r8.m27771k();
        r8.s = r3;
        r8.s = r4;
        return;
    L_0x0027:
        r9 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r9.<init>(r6);
        throw r9;
    L_0x002d:
        if (r9 == 0) goto L_0x0289;
    L_0x002f:
        r10 = 0;
        if (r9 == r5) goto L_0x0234;
    L_0x0032:
        r7 = 4;
        if (r9 == r7) goto L_0x0215;
    L_0x0035:
        if (r9 == r2) goto L_0x01f7;
    L_0x0037:
        r1 = 40;
        switch(r9) {
            case 11: goto L_0x01b7;
            case 12: goto L_0x0195;
            case 13: goto L_0x0153;
            case 14: goto L_0x007a;
            default: goto L_0x003c;
        };
    L_0x003c:
        switch(r9) {
            case 22: goto L_0x0058;
            case 23: goto L_0x0045;
            default: goto L_0x003f;
        };
    L_0x003f:
        r9 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r9.<init>(r6);
        throw r9;
    L_0x0045:
        r9 = r8.s;
        if (r9 != r5) goto L_0x0052;
    L_0x0049:
        r9 = org.spongycastle.crypto.tls.TlsProtocol.m27742f(r0);
        r8.m35913a(r9);
        goto L_0x0293;
    L_0x0052:
        r9 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r9.<init>(r6);
        throw r9;
    L_0x0058:
        r9 = r8.s;
        if (r9 != r7) goto L_0x0074;
    L_0x005c:
        r9 = r8.w;
        if (r9 == 0) goto L_0x006e;
    L_0x0060:
        r9 = org.spongycastle.crypto.tls.CertificateStatus.m27550a(r0);
        r8.f27339f = r9;
        org.spongycastle.crypto.tls.TlsProtocol.m27739d(r0);
        r9 = 5;
        r8.s = r9;
        goto L_0x0293;
    L_0x006e:
        r9 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r9.<init>(r6);
        throw r9;
    L_0x0074:
        r9 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r9.<init>(r6);
        throw r9;
    L_0x007a:
        r9 = r8.s;
        switch(r9) {
            case 2: goto L_0x0085;
            case 3: goto L_0x0088;
            case 4: goto L_0x008f;
            case 5: goto L_0x008f;
            case 6: goto L_0x0094;
            case 7: goto L_0x0094;
            default: goto L_0x007f;
        };
    L_0x007f:
        r9 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r9.<init>(r1);
        throw r9;
    L_0x0085:
        r8.m35913a(r10);
    L_0x0088:
        r9 = r8.f27337d;
        r9.mo6492e();
        r8.f27338e = r10;
    L_0x008f:
        r9 = r8.f27337d;
        r9.mo5820c();
    L_0x0094:
        org.spongycastle.crypto.tls.TlsProtocol.m27739d(r0);
        r9 = 8;
        r8.s = r9;
        r9 = r8.j;
        r9 = r9.m27592g();
        r9.mo6484e();
        r9 = r8.f27334a;
        r9 = r9.mo6462b();
        if (r9 == 0) goto L_0x00af;
    L_0x00ac:
        r8.m27756b(r9);
    L_0x00af:
        r9 = 9;
        r8.s = r9;
        r9 = r8.f27340g;
        if (r9 != 0) goto L_0x00be;
    L_0x00b7:
        r9 = r8.f27337d;
        r9.mo5821d();
        r9 = r10;
        goto L_0x00df;
    L_0x00be:
        r9 = r8.f27338e;
        r0 = r8.f27340g;
        r9 = r9.m27624a(r0);
        if (r9 != 0) goto L_0x00d3;
    L_0x00c8:
        r0 = r8.f27337d;
        r0.mo5821d();
        r0 = org.spongycastle.crypto.tls.Certificate.f22464a;
        r8.m27748a(r0);
        goto L_0x00df;
    L_0x00d3:
        r0 = r8.f27337d;
        r0.mo6491b(r9);
        r0 = r9.mo6811a();
        r8.m27748a(r0);
    L_0x00df:
        r8.s = r6;
        r8.mo5839d();
        r0 = 11;
        r8.s = r0;
        r0 = r8.j;
        r0 = r0.m27593h();
        r1 = r8.m;
        r2 = r8.mo5835a();
        r10 = org.spongycastle.crypto.tls.TlsProtocol.m27736a(r2, r0, r10);
        r1.f22547i = r10;
        r10 = r8.mo5835a();
        r1 = r8.f27337d;
        org.spongycastle.crypto.tls.TlsProtocol.m27735a(r10, r1);
        r10 = r8.j;
        r1 = r8.mo5838c();
        r1 = r1.mo6463c();
        r2 = r8.mo5838c();
        r2 = r2.mo6464d();
        r10.m27581a(r1, r2);
        if (r9 == 0) goto L_0x0149;
    L_0x011a:
        r10 = r9 instanceof org.spongycastle.crypto.tls.TlsSignerCredentials;
        if (r10 == 0) goto L_0x0149;
    L_0x011e:
        r9 = (org.spongycastle.crypto.tls.TlsSignerCredentials) r9;
        r10 = r8.mo5835a();
        r10 = org.spongycastle.crypto.tls.TlsUtils.m27801a(r10, r9);
        if (r10 != 0) goto L_0x0131;
    L_0x012a:
        r0 = r8.m;
        r0 = r0.m27602g();
        goto L_0x0139;
    L_0x0131:
        r1 = r10.m27618a();
        r0 = r0.mo6482b(r1);
    L_0x0139:
        r9 = r9.mo6814a(r0);
        r0 = new org.spongycastle.crypto.tls.DigitallySigned;
        r0.<init>(r10, r9);
        r8.m35914a(r0);
        r9 = 12;
        r8.s = r9;
    L_0x0149:
        r8.m27770j();
        r8.m27771k();
        r8.s = r3;
        goto L_0x0293;
    L_0x0153:
        r9 = r8.s;
        switch(r9) {
            case 4: goto L_0x015e;
            case 5: goto L_0x015e;
            case 6: goto L_0x0163;
            default: goto L_0x0158;
        };
    L_0x0158:
        r9 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r9.<init>(r6);
        throw r9;
    L_0x015e:
        r9 = r8.f27337d;
        r9.mo5820c();
    L_0x0163:
        r9 = r8.f27338e;
        if (r9 == 0) goto L_0x018f;
    L_0x0167:
        r9 = r8.mo5835a();
        r9 = org.spongycastle.crypto.tls.CertificateRequest.m27546a(r9, r0);
        r8.f27340g = r9;
        org.spongycastle.crypto.tls.TlsProtocol.m27739d(r0);
        r9 = r8.f27337d;
        r10 = r8.f27340g;
        r9.mo6489a(r10);
        r9 = r8.j;
        r9 = r9.m27592g();
        r10 = r8.f27340g;
        r10 = r10.m27549b();
        org.spongycastle.crypto.tls.TlsUtils.m27815a(r9, r10);
        r9 = 7;
        r8.s = r9;
        goto L_0x0293;
    L_0x018f:
        r9 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r9.<init>(r1);
        throw r9;
    L_0x0195:
        r9 = r8.s;
        switch(r9) {
            case 2: goto L_0x01a0;
            case 3: goto L_0x01a3;
            case 4: goto L_0x01aa;
            case 5: goto L_0x01aa;
            default: goto L_0x019a;
        };
    L_0x019a:
        r9 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r9.<init>(r6);
        throw r9;
    L_0x01a0:
        r8.m35913a(r10);
    L_0x01a3:
        r9 = r8.f27337d;
        r9.mo6492e();
        r8.f27338e = r10;
    L_0x01aa:
        r9 = r8.f27337d;
        r9.mo5813a(r0);
        org.spongycastle.crypto.tls.TlsProtocol.m27739d(r0);
        r9 = 6;
        r8.s = r9;
        goto L_0x0293;
    L_0x01b7:
        r9 = r8.s;
        switch(r9) {
            case 2: goto L_0x01c2;
            case 3: goto L_0x01c5;
            default: goto L_0x01bc;
        };
    L_0x01bc:
        r9 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r9.<init>(r6);
        throw r9;
    L_0x01c2:
        r8.m35913a(r10);
    L_0x01c5:
        r9 = org.spongycastle.crypto.tls.Certificate.m27542a(r0);
        r8.n = r9;
        org.spongycastle.crypto.tls.TlsProtocol.m27739d(r0);
        r9 = r8.n;
        if (r9 == 0) goto L_0x01da;
    L_0x01d2:
        r9 = r8.n;
        r9 = r9.m27545a();
        if (r9 == 0) goto L_0x01dd;
    L_0x01da:
        r9 = 0;
        r8.w = r9;
    L_0x01dd:
        r9 = r8.f27337d;
        r10 = r8.n;
        r9.mo5814a(r10);
        r9 = r8.f27334a;
        r9 = r9.mo6816f();
        r8.f27338e = r9;
        r9 = r8.f27338e;
        r10 = r8.n;
        r9.m27625a(r10);
        r8.s = r7;
        goto L_0x0293;
    L_0x01f7:
        r9 = r8.s;
        switch(r9) {
            case 13: goto L_0x0202;
            case 14: goto L_0x0206;
            default: goto L_0x01fc;
        };
    L_0x01fc:
        r9 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r9.<init>(r6);
        throw r9;
    L_0x0202:
        r9 = r8.x;
        if (r9 != 0) goto L_0x020f;
    L_0x0206:
        r8.m27762c(r0);
        r8.s = r1;
        r8.s = r4;
        goto L_0x0293;
    L_0x020f:
        r9 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r9.<init>(r6);
        throw r9;
    L_0x0215:
        r9 = r8.s;
        if (r9 != r3) goto L_0x022e;
    L_0x0219:
        r9 = r8.x;
        if (r9 == 0) goto L_0x0228;
    L_0x021d:
        r8.m27769i();
        r8.m35912a(r0);
        r9 = 14;
        r8.s = r9;
        goto L_0x0293;
    L_0x0228:
        r9 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r9.<init>(r6);
        throw r9;
    L_0x022e:
        r9 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r9.<init>(r6);
        throw r9;
    L_0x0234:
        r9 = r8.s;
        r1 = 1;
        if (r9 != r1) goto L_0x0283;
    L_0x0239:
        r8.m35917b(r0);
        r8.s = r5;
        r9 = r8.j;
        r9.m27591f();
        r8.m27766f();
        r9 = r8.t;
        if (r9 == 0) goto L_0x0271;
    L_0x024a:
        r9 = r8.m;
        r10 = r8.l;
        r10 = r10.m27615d();
        r10 = org.spongycastle.util.Arrays.m29373b(r10);
        r9.f22544f = r10;
        r9 = r8.j;
        r10 = r8.mo5838c();
        r10 = r10.mo6463c();
        r0 = r8.mo5838c();
        r0 = r0.mo6464d();
        r9.m27581a(r10, r0);
        r8.m27770j();
        goto L_0x0293;
    L_0x0271:
        r8.m27769i();
        r9 = r8.f27336c;
        r9 = r9.length;
        if (r9 <= 0) goto L_0x0293;
    L_0x0279:
        r9 = new org.spongycastle.crypto.tls.TlsSessionImpl;
        r0 = r8.f27336c;
        r9.<init>(r0, r10);
        r8.k = r9;
        goto L_0x0293;
    L_0x0283:
        r9 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r9.<init>(r6);
        throw r9;
    L_0x0289:
        org.spongycastle.crypto.tls.TlsProtocol.m27739d(r0);
        r9 = r8.s;
        if (r9 != r4) goto L_0x0293;
    L_0x0290:
        r8.m27774n();
    L_0x0293:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsClientProtocol.a(short, byte[]):void");
    }

    /* renamed from: a */
    protected void m35913a(Vector vector) {
        this.f27334a.mo6457a(vector);
        this.s = (short) 3;
        this.f27337d = this.f27334a.mo6815e();
        this.f27337d.mo5815a(mo5835a());
    }

    /* renamed from: a */
    protected void m35912a(ByteArrayInputStream byteArrayInputStream) {
        NewSessionTicket a = NewSessionTicket.m27563a((InputStream) byteArrayInputStream);
        TlsProtocol.m27739d(byteArrayInputStream);
        this.f27334a.mo6458a(a);
    }

    /* renamed from: b */
    protected void m35917b(ByteArrayInputStream byteArrayInputStream) {
        ProtocolVersion h = TlsUtils.m27878h((InputStream) byteArrayInputStream);
        if (h.m27571c()) {
            throw new TlsFatalAlert((short) 47);
        } else if (!h.m27572c(this.j.m27586b())) {
            throw new TlsFatalAlert((short) 47);
        } else if (h.m27568a(mo5835a().mo5811d())) {
            this.j.m27587b(h);
            mo5837b().m35849b(h);
            this.f27334a.mo6459a(h);
            this.m.f22546h = TlsUtils.m27849b(32, (InputStream) byteArrayInputStream);
            this.f27336c = TlsUtils.m27872e((InputStream) byteArrayInputStream);
            if (this.f27336c.length <= 32) {
                this.f27334a.mo6461a(this.f27336c);
                boolean z = false;
                boolean z2 = this.f27336c.length > 0 && this.k != null && Arrays.m29353a(this.f27336c, this.k.mo5845a());
                this.t = z2;
                int b = TlsUtils.m27837b((InputStream) byteArrayInputStream);
                if (!Arrays.m29355a(this.o, b) || b == 0 || CipherSuite.m27553a(b) || !TlsUtils.m27822a(b, mo5835a().mo5812e())) {
                    throw new TlsFatalAlert((short) 47);
                }
                this.f27334a.mo6455a(b);
                short a = TlsUtils.m27802a((InputStream) byteArrayInputStream);
                if (Arrays.m29359a(this.p, a)) {
                    this.f27334a.mo6460a(a);
                    this.r = TlsProtocol.m27741e(byteArrayInputStream);
                    if (this.r != null) {
                        byteArrayInputStream = this.r.keys();
                        while (byteArrayInputStream.hasMoreElements()) {
                            Integer num = (Integer) byteArrayInputStream.nextElement();
                            if (!num.equals(h)) {
                                if (TlsUtils.m27827a(this.q, num) != null) {
                                    boolean z3 = this.t;
                                } else {
                                    throw new TlsFatalAlert((short) 110);
                                }
                            }
                        }
                    }
                    byte[] a2 = TlsUtils.m27827a(this.r, h);
                    if (a2 != null) {
                        this.v = true;
                        if (Arrays.m29372b(a2, TlsProtocol.m27737a(TlsUtils.f22634a)) == null) {
                            throw new TlsFatalAlert((short) 40);
                        }
                    }
                    this.f27334a.mo5824a(this.v);
                    byteArrayInputStream = this.q;
                    Hashtable hashtable = this.r;
                    if (this.t) {
                        if (b == this.l.m27613b() && a == this.l.m27614c()) {
                            byteArrayInputStream = null;
                            hashtable = this.l.m27616e();
                        } else {
                            throw new TlsFatalAlert((short) 47);
                        }
                    }
                    this.m.f22540b = b;
                    this.m.f22541c = a;
                    if (hashtable != null) {
                        boolean f = TlsExtensionsUtils.m27697f(hashtable);
                        if (f) {
                            if (!TlsUtils.m27885n(b)) {
                                throw new TlsFatalAlert((short) 47);
                            }
                        }
                        this.m.f22552n = f;
                        this.m.f22553o = TlsExtensionsUtils.m27698g(hashtable);
                        this.m.f22550l = m27747a((Hashtable) byteArrayInputStream, hashtable, (short) 47);
                        this.m.f22551m = TlsExtensionsUtils.m27699h(hashtable);
                        z2 = !this.t && TlsUtils.m27823a(hashtable, TlsExtensionsUtils.f22589f, (short) 47);
                        this.w = z2;
                        if (!this.t && TlsUtils.m27823a(hashtable, TlsProtocol.f22605i, (short) 47)) {
                            z = true;
                        }
                        this.x = z;
                    }
                    if (byteArrayInputStream != null) {
                        this.f27334a.mo6456a(hashtable);
                    }
                    this.m.f22542d = TlsProtocol.m27732a(mo5835a(), this.m.m27596a());
                    this.m.f22543e = 12;
                    return;
                }
                throw new TlsFatalAlert((short) 47);
            }
            throw new TlsFatalAlert((short) 47);
        } else {
            throw new TlsFatalAlert((short) 47);
        }
    }

    /* renamed from: a */
    protected void m35914a(DigitallySigned digitallySigned) {
        OutputStream handshakeMessage = new HandshakeMessage(this, (short) 15);
        digitallySigned.m27557a(handshakeMessage);
        handshakeMessage.m27731a();
    }

    /* renamed from: d */
    protected void mo5839d() {
        OutputStream handshakeMessage = new HandshakeMessage(this, (short) 16);
        this.f27337d.mo6488a(handshakeMessage);
        handshakeMessage.m27731a();
    }
}
