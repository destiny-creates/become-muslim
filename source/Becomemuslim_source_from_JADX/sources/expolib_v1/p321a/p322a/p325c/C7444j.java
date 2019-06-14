package expolib_v1.p321a.p322a.p325c;

import com.facebook.stetho.server.http.HttpHeaders;
import expolib_v1.p321a.C6207a;
import expolib_v1.p321a.C6220g;
import expolib_v1.p321a.C6222i;
import expolib_v1.p321a.C6237r;
import expolib_v1.p321a.C6239s;
import expolib_v1.p321a.C6239s.C6238a;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.aa;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.ad;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p324b.C6151e;
import expolib_v1.p321a.p322a.p324b.C6154g;
import expolib_v1.p321a.p322a.p327e.C6168a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: RetryAndFollowUpInterceptor */
/* renamed from: expolib_v1.a.a.c.j */
public final class C7444j implements C6239s {
    /* renamed from: a */
    private final C7490w f25823a;
    /* renamed from: b */
    private final boolean f25824b;
    /* renamed from: c */
    private C6154g f25825c;
    /* renamed from: d */
    private Object f25826d;
    /* renamed from: e */
    private volatile boolean f25827e;

    public C7444j(C7490w c7490w, boolean z) {
        this.f25823a = c7490w;
        this.f25824b = z;
    }

    /* renamed from: a */
    public void m33828a() {
        this.f25827e = true;
        C6154g c6154g = this.f25825c;
        if (c6154g != null) {
            c6154g.m25265e();
        }
    }

    /* renamed from: b */
    public boolean m33830b() {
        return this.f25827e;
    }

    /* renamed from: a */
    public void m33829a(Object obj) {
        this.f25826d = obj;
    }

    /* renamed from: c */
    public C6154g m33831c() {
        return this.f25825c;
    }

    public ab intercept(C6238a c6238a) {
        C6246z a = c6238a.mo5253a();
        this.f25825c = new C6154g(this.f25823a.m33986p(), m33823a(a.m25821a()), this.f25826d);
        ab abVar = null;
        int i = 0;
        while (!this.f25827e) {
            try {
                ab a2 = ((C7442g) c6238a).m33819a(a, this.f25825c, null, null);
                abVar = abVar != null ? a2.m25586i().m25575c(abVar.m25586i().m25563a(null).m25570a()).m25570a() : a2;
                a = m33824a(abVar);
                if (a == null) {
                    if (this.f25824b == null) {
                        this.f25825c.m25263c();
                    }
                    return abVar;
                }
                C6165c.m25315a(abVar.m25585h());
                i++;
                StringBuilder stringBuilder;
                if (i > 20) {
                    this.f25825c.m25263c();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Too many follow-up requests: ");
                    stringBuilder.append(i);
                    throw new ProtocolException(stringBuilder.toString());
                } else if (a.m25826d() instanceof C6164l) {
                    this.f25825c.m25263c();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", abVar.m25580c());
                } else if (!m33825a(abVar, a.m25821a())) {
                    this.f25825c.m25263c();
                    this.f25825c = new C6154g(this.f25823a.m33986p(), m33823a(a.m25821a()), this.f25826d);
                } else if (this.f25825c.m25256a() != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Closing the body of ");
                    stringBuilder.append(abVar);
                    stringBuilder.append(" didn't close its backing stream. Bad interceptor?");
                    throw new IllegalStateException(stringBuilder.toString());
                }
            } catch (C6151e e) {
                if (!m33827a(e.m25237a(), false, a)) {
                    throw e.m25237a();
                }
            } catch (IOException e2) {
                if (!m33827a(e2, !(e2 instanceof C6168a), a)) {
                    throw e2;
                }
            } catch (Throwable th) {
                this.f25825c.m25259a(null);
                this.f25825c.m25263c();
            }
        }
        this.f25825c.m25263c();
        throw new IOException("Canceled");
    }

    /* renamed from: a */
    private C6207a m33823a(C6237r c6237r) {
        HostnameVerifier l;
        SSLSocketFactory sSLSocketFactory;
        C6220g m;
        C7444j c7444j = this;
        if (c6237r.m25765c()) {
            SSLSocketFactory k = c7444j.f25823a.m33981k();
            l = c7444j.f25823a.m33982l();
            sSLSocketFactory = k;
            m = c7444j.f25823a.m33983m();
        } else {
            sSLSocketFactory = null;
            l = sSLSocketFactory;
            m = l;
        }
        return new C6207a(c6237r.m25769f(), c6237r.m25770g(), c7444j.f25823a.m33979i(), c7444j.f25823a.m33980j(), sSLSocketFactory, l, m, c7444j.f25823a.m33985o(), c7444j.f25823a.m33975e(), c7444j.f25823a.m33991u(), c7444j.f25823a.m33992v(), c7444j.f25823a.m33976f());
    }

    /* renamed from: a */
    private boolean m33827a(IOException iOException, boolean z, C6246z c6246z) {
        this.f25825c.m25259a(iOException);
        if (!this.f25823a.m33989s()) {
            return false;
        }
        if ((z && (c6246z.m25826d() instanceof C6164l) != null) || m33826a(iOException, z) == null || this.f25825c.m25266f() == null) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m33826a(IOException iOException, boolean z) {
        boolean z2 = false;
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!((iOException instanceof SocketTimeoutException) == null || z)) {
                z2 = true;
            }
            return z2;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && (iOException instanceof SSLPeerUnverifiedException) == null) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    private C6246z m33824a(ab abVar) {
        if (abVar != null) {
            C6222i b = this.f25825c.m25261b();
            aa aaVar = null;
            ad a = b != null ? b.mo5249a() : null;
            int c = abVar.m25580c();
            String b2 = abVar.m25576a().m25823b();
            switch (c) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                case 307:
                case 308:
                    if (!(b2.equals("GET") || b2.equals("HEAD"))) {
                        return null;
                    }
                case 401:
                    return this.f25823a.m33984n().mo5316a(a, abVar);
                case 407:
                    Proxy b3;
                    if (a != null) {
                        b3 = a.m25592b();
                    } else {
                        b3 = this.f25823a.m33975e();
                    }
                    if (b3.type() == Type.HTTP) {
                        return this.f25823a.m33985o().mo5316a(a, abVar);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                case 408:
                    if (abVar.m25576a().m25826d() instanceof C6164l) {
                        return null;
                    }
                    return abVar.m25576a();
                default:
                    return null;
            }
            if (!this.f25823a.m33988r()) {
                return null;
            }
            String a2 = abVar.m25577a("Location");
            if (a2 == null) {
                return null;
            }
            C6237r c2 = abVar.m25576a().m25821a().m25764c(a2);
            if (c2 == null) {
                return null;
            }
            if (!c2.m25763b().equals(abVar.m25576a().m25821a().m25763b()) && !this.f25823a.m33987q()) {
                return null;
            }
            C6245a f = abVar.m25576a().m25828f();
            if (C6161f.m25295c(b2)) {
                boolean d = C6161f.m25296d(b2);
                if (C6161f.m25297e(b2)) {
                    f.m25815a("GET", null);
                } else {
                    if (d) {
                        aaVar = abVar.m25576a().m25826d();
                    }
                    f.m25815a(b2, aaVar);
                }
                if (!d) {
                    f.m25818b("Transfer-Encoding");
                    f.m25818b(HttpHeaders.CONTENT_LENGTH);
                    f.m25818b(HttpHeaders.CONTENT_TYPE);
                }
            }
            if (m33825a(abVar, c2) == null) {
                f.m25818b("Authorization");
            }
            return f.m25812a(c2).m25820b();
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    private boolean m33825a(ab abVar, C6237r c6237r) {
        abVar = abVar.m25576a().m25821a();
        return (abVar.m25769f().equals(c6237r.m25769f()) && abVar.m25770g() == c6237r.m25770g() && abVar.m25763b().equals(c6237r.m25763b()) != null) ? true : null;
    }
}
