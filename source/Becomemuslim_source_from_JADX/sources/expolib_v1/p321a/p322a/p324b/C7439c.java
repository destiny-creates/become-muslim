package expolib_v1.p321a.p322a.p324b;

import com.facebook.common.time.Clock;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.stetho.server.http.HttpStatus;
import expolib_v1.p321a.C6207a;
import expolib_v1.p321a.C6220g;
import expolib_v1.p321a.C6222i;
import expolib_v1.p321a.C6224j;
import expolib_v1.p321a.C6232p;
import expolib_v1.p321a.C6237r;
import expolib_v1.p321a.C6244x;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.ad;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.C6167d;
import expolib_v1.p321a.p322a.p325c.C6157c;
import expolib_v1.p321a.p322a.p325c.C6160e;
import expolib_v1.p321a.p322a.p326d.C7448a;
import expolib_v1.p321a.p322a.p327e.C6169b;
import expolib_v1.p321a.p322a.p327e.C6177g;
import expolib_v1.p321a.p322a.p327e.C6177g.C6175a;
import expolib_v1.p321a.p322a.p327e.C6177g.C6176b;
import expolib_v1.p321a.p322a.p327e.C6180i;
import expolib_v1.p321a.p322a.p327e.C7449f;
import expolib_v1.p321a.p322a.p329g.C6192e;
import expolib_v1.p321a.p322a.p330h.C6195d;
import expolib_v1.p321a.p322a.p331i.C7475a.C6202e;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C6258s;
import expolib_v1.p332b.C7496d;
import expolib_v1.p332b.C7497e;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* compiled from: RealConnection */
/* renamed from: expolib_v1.a.a.b.c */
public final class C7439c extends C6176b implements C6222i {
    /* renamed from: a */
    public boolean f25798a;
    /* renamed from: b */
    public int f25799b;
    /* renamed from: c */
    public int f25800c = 1;
    /* renamed from: d */
    public final List<Reference<C6154g>> f25801d = new ArrayList();
    /* renamed from: e */
    public long f25802e = Clock.MAX_TIME;
    /* renamed from: g */
    private final C6224j f25803g;
    /* renamed from: h */
    private final ad f25804h;
    /* renamed from: i */
    private Socket f25805i;
    /* renamed from: j */
    private Socket f25806j;
    /* renamed from: k */
    private C6232p f25807k;
    /* renamed from: l */
    private C6244x f25808l;
    /* renamed from: m */
    private C6177g f25809m;
    /* renamed from: n */
    private C7497e f25810n;
    /* renamed from: o */
    private C7496d f25811o;

    public C7439c(C6224j c6224j, ad adVar) {
        this.f25803g = c6224j;
        this.f25804h = adVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m33807a(int r6, int r7, int r8, boolean r9) {
        /*
        r5 = this;
        r0 = r5.f25808l;
        if (r0 != 0) goto L_0x00c5;
    L_0x0004:
        r0 = r5.f25804h;
        r0 = r0.m25591a();
        r0 = r0.m25552f();
        r1 = new expolib_v1.a.a.b.b;
        r1.<init>(r0);
        r2 = r5.f25804h;
        r2 = r2.m25591a();
        r2 = r2.m25555i();
        if (r2 != 0) goto L_0x006e;
    L_0x001f:
        r2 = expolib_v1.p321a.C6226k.f20252c;
        r0 = r0.contains(r2);
        if (r0 == 0) goto L_0x0061;
    L_0x0027:
        r0 = r5.f25804h;
        r0 = r0.m25591a();
        r0 = r0.m25547a();
        r0 = r0.m25769f();
        r2 = expolib_v1.p321a.p322a.p329g.C6192e.m25495b();
        r2 = r2.mo5300b(r0);
        if (r2 == 0) goto L_0x0040;
    L_0x003f:
        goto L_0x006e;
    L_0x0040:
        r6 = new expolib_v1.a.a.b.e;
        r7 = new java.net.UnknownServiceException;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "CLEARTEXT communication to ";
        r8.append(r9);
        r8.append(r0);
        r9 = " not permitted by network security policy";
        r8.append(r9);
        r8 = r8.toString();
        r7.<init>(r8);
        r6.<init>(r7);
        throw r6;
    L_0x0061:
        r6 = new expolib_v1.a.a.b.e;
        r7 = new java.net.UnknownServiceException;
        r8 = "CLEARTEXT communication not enabled for client";
        r7.<init>(r8);
        r6.<init>(r7);
        throw r6;
    L_0x006e:
        r0 = 0;
        r2 = r0;
    L_0x0070:
        r3 = r5.f25804h;	 Catch:{ IOException -> 0x0097 }
        r3 = r3.m25594d();	 Catch:{ IOException -> 0x0097 }
        if (r3 == 0) goto L_0x007c;
    L_0x0078:
        r5.m33800a(r6, r7, r8);	 Catch:{ IOException -> 0x0097 }
        goto L_0x007f;
    L_0x007c:
        r5.m33799a(r6, r7);	 Catch:{ IOException -> 0x0097 }
    L_0x007f:
        r5.m33801a(r1);	 Catch:{ IOException -> 0x0097 }
        r6 = r5.f25809m;
        if (r6 == 0) goto L_0x0096;
    L_0x0086:
        r6 = r5.f25803g;
        monitor-enter(r6);
        r7 = r5.f25809m;	 Catch:{ all -> 0x0093 }
        r7 = r7.m25367a();	 Catch:{ all -> 0x0093 }
        r5.f25800c = r7;	 Catch:{ all -> 0x0093 }
        monitor-exit(r6);	 Catch:{ all -> 0x0093 }
        goto L_0x0096;
    L_0x0093:
        r7 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0093 }
        throw r7;
    L_0x0096:
        return;
    L_0x0097:
        r3 = move-exception;
        r4 = r5.f25806j;
        expolib_v1.p321a.p322a.C6165c.m25316a(r4);
        r4 = r5.f25805i;
        expolib_v1.p321a.p322a.C6165c.m25316a(r4);
        r5.f25806j = r0;
        r5.f25805i = r0;
        r5.f25810n = r0;
        r5.f25811o = r0;
        r5.f25807k = r0;
        r5.f25808l = r0;
        r5.f25809m = r0;
        if (r2 != 0) goto L_0x00b8;
    L_0x00b2:
        r2 = new expolib_v1.a.a.b.e;
        r2.<init>(r3);
        goto L_0x00bb;
    L_0x00b8:
        r2.m25238a(r3);
    L_0x00bb:
        if (r9 == 0) goto L_0x00c4;
    L_0x00bd:
        r3 = r1.m25232a(r3);
        if (r3 == 0) goto L_0x00c4;
    L_0x00c3:
        goto L_0x0070;
    L_0x00c4:
        throw r2;
    L_0x00c5:
        r6 = new java.lang.IllegalStateException;
        r7 = "already connected";
        r6.<init>(r7);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.b.c.a(int, int, int, boolean):void");
    }

    /* renamed from: a */
    private void m33800a(int i, int i2, int i3) {
        C6246z f = m33803f();
        C6237r a = f.m25821a();
        int i4 = 0;
        while (true) {
            i4++;
            if (i4 <= 21) {
                m33799a(i, i2);
                f = m33798a(i2, i3, f, a);
                if (f != null) {
                    C6165c.m25316a(this.f25805i);
                    this.f25805i = null;
                    this.f25811o = null;
                    this.f25810n = null;
                } else {
                    return;
                }
            }
            i2 = new StringBuilder();
            i2.append("Too many tunnel connections attempted: ");
            i2.append(21);
            throw new ProtocolException(i2.toString());
        }
    }

    /* renamed from: a */
    private void m33799a(int i, int i2) {
        Socket socket;
        Proxy b = this.f25804h.m25592b();
        C6207a a = this.f25804h.m25591a();
        if (b.type() != Type.DIRECT) {
            if (b.type() != Type.HTTP) {
                socket = new Socket(b);
                this.f25805i = socket;
                this.f25805i.setSoTimeout(i2);
                C6192e.m25495b().mo5298a(this.f25805i, this.f25804h.m25593c(), i);
                this.f25810n = C6252l.m25859a(C6252l.m25869b(this.f25805i));
                this.f25811o = C6252l.m25858a(C6252l.m25863a(this.f25805i));
            }
        }
        socket = a.m25549c().createSocket();
        this.f25805i = socket;
        this.f25805i.setSoTimeout(i2);
        try {
            C6192e.m25495b().mo5298a(this.f25805i, this.f25804h.m25593c(), i);
            this.f25810n = C6252l.m25859a(C6252l.m25869b(this.f25805i));
            this.f25811o = C6252l.m25858a(C6252l.m25863a(this.f25805i));
        } catch (int i3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to connect to ");
            stringBuilder.append(this.f25804h.m25593c());
            i2 = new ConnectException(stringBuilder.toString());
            i2.initCause(i3);
            throw i2;
        }
    }

    /* renamed from: a */
    private void m33801a(C6149b c6149b) {
        if (this.f25804h.m25591a().m25555i() == null) {
            this.f25808l = C6244x.HTTP_1_1;
            this.f25806j = this.f25805i;
            return;
        }
        m33802b(c6149b);
        if (this.f25808l == C6244x.HTTP_2) {
            this.f25806j.setSoTimeout(0);
            this.f25809m = new C6175a(true).m25362a(this.f25806j, this.f25804h.m25591a().m25547a().m25769f(), this.f25810n, this.f25811o).m25361a(this).m25363a();
            this.f25809m.m25386c();
        }
    }

    /* renamed from: b */
    private void m33802b(C6149b c6149b) {
        AssertionError e;
        C6207a a = this.f25804h.m25591a();
        String str = null;
        try {
            Socket socket = (SSLSocket) a.m25555i().createSocket(this.f25805i, a.m25547a().m25769f(), a.m25547a().m25770g(), true);
            try {
                c6149b = c6149b.m25231a((SSLSocket) socket);
                if (c6149b.m25669d()) {
                    C6192e.m25495b().mo5299a((SSLSocket) socket, a.m25547a().m25769f(), a.m25551e());
                }
                socket.startHandshake();
                C6232p a2 = C6232p.m25701a(socket.getSession());
                if (a.m25556j().verify(a.m25547a().m25769f(), socket.getSession())) {
                    a.m25557k().m25645a(a.m25547a().m25769f(), a2.m25704c());
                    if (c6149b.m25669d() != null) {
                        str = C6192e.m25495b().mo5294a((SSLSocket) socket);
                    }
                    this.f25806j = socket;
                    this.f25810n = C6252l.m25859a(C6252l.m25869b(this.f25806j));
                    this.f25811o = C6252l.m25858a(C6252l.m25863a(this.f25806j));
                    this.f25807k = a2;
                    this.f25808l = str != null ? C6244x.m25807a(str) : C6244x.HTTP_1_1;
                    if (socket != null) {
                        C6192e.m25495b().mo5301b((SSLSocket) socket);
                        return;
                    }
                    return;
                }
                Certificate certificate = (X509Certificate) a2.m25704c().get(0);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Hostname ");
                stringBuilder.append(a.m25547a().m25769f());
                stringBuilder.append(" not verified:\n    certificate: ");
                stringBuilder.append(C6220g.m25641a(certificate));
                stringBuilder.append("\n    DN: ");
                stringBuilder.append(certificate.getSubjectDN().getName());
                stringBuilder.append("\n    subjectAltNames: ");
                stringBuilder.append(C6195d.m25518a(certificate));
                throw new SSLPeerUnverifiedException(stringBuilder.toString());
            } catch (AssertionError e2) {
                e = e2;
                str = socket;
                try {
                    if (C6165c.m25318a(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                } catch (Throwable th) {
                    c6149b = th;
                    socket = str;
                    if (socket != null) {
                        C6192e.m25495b().mo5301b((SSLSocket) socket);
                    }
                    C6165c.m25316a(socket);
                    throw c6149b;
                }
            } catch (Throwable th2) {
                c6149b = th2;
                if (socket != null) {
                    C6192e.m25495b().mo5301b((SSLSocket) socket);
                }
                C6165c.m25316a(socket);
                throw c6149b;
            }
        } catch (AssertionError e3) {
            e = e3;
            if (C6165c.m25318a(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    /* renamed from: a */
    private C6246z m33798a(int i, int i2, C6246z c6246z, C6237r c6237r) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CONNECT ");
        stringBuilder.append(C6165c.m25306a(c6237r, true));
        stringBuilder.append(" HTTP/1.1");
        String stringBuilder2 = stringBuilder.toString();
        while (true) {
            C7448a c7448a = new C7448a(null, null, this.f25810n, this.f25811o);
            this.f25810n.timeout().mo5349a((long) i, TimeUnit.MILLISECONDS);
            this.f25811o.timeout().mo5349a((long) i2, TimeUnit.MILLISECONDS);
            c7448a.m33842a(c6246z.m25825c(), stringBuilder2);
            c7448a.mo5266b();
            ab a = c7448a.mo5261a(false).m25567a(c6246z).m25570a();
            long a2 = C6160e.m25280a(a);
            if (a2 == -1) {
                a2 = 0;
            }
            C6258s b = c7448a.m33845b(a2);
            C6165c.m25324b(b, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            b.close();
            int c = a.m25580c();
            if (c == HttpStatus.HTTP_OK) {
                break;
            } else if (c == 407) {
                C6246z a3 = this.f25804h.m25591a().m25550d().mo5316a(this.f25804h, a);
                if (a3 == null) {
                    throw new IOException("Failed to authenticate with proxy");
                } else if ("close".equalsIgnoreCase(a.m25577a("Connection")) != null) {
                    return a3;
                } else {
                    c6246z = a3;
                }
            } else {
                i2 = new StringBuilder();
                i2.append("Unexpected response code for CONNECT: ");
                i2.append(a.m25580c());
                throw new IOException(i2.toString());
            }
        }
        if (this.f25810n.mo6372b().mo6382f() != 0 && this.f25811o.mo6372b().mo6382f() != 0) {
            return null;
        }
        throw new IOException("TLS tunnel buffered too many bytes!");
    }

    /* renamed from: f */
    private C6246z m33803f() {
        return new C6245a().m25812a(this.f25804h.m25591a().m25547a()).m25816a("Host", C6165c.m25306a(this.f25804h.m25591a().m25547a(), true)).m25816a("Proxy-Connection", "Keep-Alive").m25816a("User-Agent", C6167d.m25328a()).m25820b();
    }

    /* renamed from: a */
    public boolean m33810a(C6207a c6207a) {
        return (this.f25801d.size() >= this.f25800c || c6207a.equals(mo5249a().m25591a()) == null || this.f25798a != null) ? null : true;
    }

    /* renamed from: a */
    public C6157c m33804a(C7490w c7490w, C6154g c6154g) {
        if (this.f25809m != null) {
            return new C7449f(c7490w, c6154g, this.f25809m);
        }
        this.f25806j.setSoTimeout(c7490w.m33972b());
        this.f25810n.timeout().mo5349a((long) c7490w.m33972b(), TimeUnit.MILLISECONDS);
        this.f25811o.timeout().mo5349a((long) c7490w.m33973c(), TimeUnit.MILLISECONDS);
        return new C7448a(c7490w, c6154g, this.f25810n, this.f25811o);
    }

    /* renamed from: a */
    public C6202e m33805a(C6154g c6154g) {
        final C6154g c6154g2 = c6154g;
        return new C6202e(this, true, this.f25810n, this.f25811o) {
            /* renamed from: b */
            final /* synthetic */ C7439c f25797b;

            public void close() {
                c6154g2.m25260a(true, c6154g2.m25256a());
            }
        };
    }

    /* renamed from: a */
    public ad mo5249a() {
        return this.f25804h;
    }

    /* renamed from: b */
    public void m33812b() {
        C6165c.m25316a(this.f25805i);
    }

    /* renamed from: c */
    public Socket m33813c() {
        return this.f25806j;
    }

    /* renamed from: a */
    public boolean m33811a(boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.f25806j;
        r0 = r0.isClosed();
        r1 = 0;
        if (r0 != 0) goto L_0x0051;
    L_0x0009:
        r0 = r4.f25806j;
        r0 = r0.isInputShutdown();
        if (r0 != 0) goto L_0x0051;
    L_0x0011:
        r0 = r4.f25806j;
        r0 = r0.isOutputShutdown();
        if (r0 == 0) goto L_0x001a;
    L_0x0019:
        goto L_0x0051;
    L_0x001a:
        r0 = r4.f25809m;
        r2 = 1;
        if (r0 == 0) goto L_0x0027;
    L_0x001f:
        r5 = r4.f25809m;
        r5 = r5.m25388d();
        r5 = r5 ^ r2;
        return r5;
    L_0x0027:
        if (r5 == 0) goto L_0x0050;
    L_0x0029:
        r5 = r4.f25806j;	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        r5 = r5.getSoTimeout();	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        r0 = r4.f25806j;	 Catch:{ all -> 0x0048 }
        r0.setSoTimeout(r2);	 Catch:{ all -> 0x0048 }
        r0 = r4.f25810n;	 Catch:{ all -> 0x0048 }
        r0 = r0.mo6382f();	 Catch:{ all -> 0x0048 }
        if (r0 == 0) goto L_0x0042;
    L_0x003c:
        r0 = r4.f25806j;	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        r0.setSoTimeout(r5);	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        return r1;	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
    L_0x0042:
        r0 = r4.f25806j;	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        r0.setSoTimeout(r5);	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        return r2;	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
    L_0x0048:
        r0 = move-exception;	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        r3 = r4.f25806j;	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        r3.setSoTimeout(r5);	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x0050, IOException -> 0x004f }
    L_0x004f:
        return r1;
    L_0x0050:
        return r2;
    L_0x0051:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.b.c.a(boolean):boolean");
    }

    /* renamed from: a */
    public void mo5251a(C6180i c6180i) {
        c6180i.m25418a(C6169b.REFUSED_STREAM);
    }

    /* renamed from: a */
    public void mo5250a(C6177g c6177g) {
        synchronized (this.f25803g) {
            this.f25800c = c6177g.m25367a();
        }
    }

    /* renamed from: d */
    public C6232p m33814d() {
        return this.f25807k;
    }

    /* renamed from: e */
    public boolean m33815e() {
        return this.f25809m != null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Connection{");
        stringBuilder.append(this.f25804h.m25591a().m25547a().m25769f());
        stringBuilder.append(":");
        stringBuilder.append(this.f25804h.m25591a().m25547a().m25770g());
        stringBuilder.append(", proxy=");
        stringBuilder.append(this.f25804h.m25592b());
        stringBuilder.append(" hostAddress=");
        stringBuilder.append(this.f25804h.m25593c());
        stringBuilder.append(" cipherSuite=");
        stringBuilder.append(this.f25807k != null ? this.f25807k.m25703b() : ViewProps.NONE);
        stringBuilder.append(" protocol=");
        stringBuilder.append(this.f25808l);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
