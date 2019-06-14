package expolib_v1.p321a;

import com.facebook.common.util.UriUtil;
import expolib_v1.p321a.C6237r.C6236a;
import expolib_v1.p321a.p322a.C6165c;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Address */
/* renamed from: expolib_v1.a.a */
public final class C6207a {
    /* renamed from: a */
    final C6237r f20086a;
    /* renamed from: b */
    final C6231o f20087b;
    /* renamed from: c */
    final SocketFactory f20088c;
    /* renamed from: d */
    final C6210b f20089d;
    /* renamed from: e */
    final List<C6244x> f20090e;
    /* renamed from: f */
    final List<C6226k> f20091f;
    /* renamed from: g */
    final ProxySelector f20092g;
    /* renamed from: h */
    final Proxy f20093h;
    /* renamed from: i */
    final SSLSocketFactory f20094i;
    /* renamed from: j */
    final HostnameVerifier f20095j;
    /* renamed from: k */
    final C6220g f20096k;

    public C6207a(String str, int i, C6231o c6231o, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C6220g c6220g, C6210b c6210b, Proxy proxy, List<C6244x> list, List<C6226k> list2, ProxySelector proxySelector) {
        this.f20086a = new C6236a().m25739a(sSLSocketFactory != null ? UriUtil.HTTPS_SCHEME : UriUtil.HTTP_SCHEME).m25744d(str).m25738a(i).m25743c();
        if (c6231o != null) {
            this.f20087b = c6231o;
            if (socketFactory != null) {
                this.f20088c = socketFactory;
                if (c6210b != null) {
                    this.f20089d = c6210b;
                    if (list != null) {
                        this.f20090e = C6165c.m25310a((List) list);
                        if (list2 != null) {
                            this.f20091f = C6165c.m25310a((List) list2);
                            if (proxySelector != null) {
                                this.f20092g = proxySelector;
                                this.f20093h = proxy;
                                this.f20094i = sSLSocketFactory;
                                this.f20095j = hostnameVerifier;
                                this.f20096k = c6220g;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    /* renamed from: a */
    public C6237r m25547a() {
        return this.f20086a;
    }

    /* renamed from: b */
    public C6231o m25548b() {
        return this.f20087b;
    }

    /* renamed from: c */
    public SocketFactory m25549c() {
        return this.f20088c;
    }

    /* renamed from: d */
    public C6210b m25550d() {
        return this.f20089d;
    }

    /* renamed from: e */
    public List<C6244x> m25551e() {
        return this.f20090e;
    }

    /* renamed from: f */
    public List<C6226k> m25552f() {
        return this.f20091f;
    }

    /* renamed from: g */
    public ProxySelector m25553g() {
        return this.f20092g;
    }

    /* renamed from: h */
    public Proxy m25554h() {
        return this.f20093h;
    }

    /* renamed from: i */
    public SSLSocketFactory m25555i() {
        return this.f20094i;
    }

    /* renamed from: j */
    public HostnameVerifier m25556j() {
        return this.f20095j;
    }

    /* renamed from: k */
    public C6220g m25557k() {
        return this.f20096k;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C6207a)) {
            return false;
        }
        C6207a c6207a = (C6207a) obj;
        if (this.f20086a.equals(c6207a.f20086a) && this.f20087b.equals(c6207a.f20087b) && this.f20089d.equals(c6207a.f20089d) && this.f20090e.equals(c6207a.f20090e) && this.f20091f.equals(c6207a.f20091f) && this.f20092g.equals(c6207a.f20092g) && C6165c.m25319a(this.f20093h, c6207a.f20093h) && C6165c.m25319a(this.f20094i, c6207a.f20094i) && C6165c.m25319a(this.f20095j, c6207a.f20095j) && C6165c.m25319a(this.f20096k, c6207a.f20096k) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((527 + this.f20086a.hashCode()) * 31) + this.f20087b.hashCode()) * 31) + this.f20089d.hashCode()) * 31) + this.f20090e.hashCode()) * 31) + this.f20091f.hashCode()) * 31) + this.f20092g.hashCode()) * 31) + (this.f20093h != null ? this.f20093h.hashCode() : 0)) * 31) + (this.f20094i != null ? this.f20094i.hashCode() : 0)) * 31) + (this.f20095j != null ? this.f20095j.hashCode() : 0)) * 31;
        if (this.f20096k != null) {
            i = this.f20096k.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Address{");
        stringBuilder.append(this.f20086a.m25769f());
        stringBuilder.append(":");
        stringBuilder.append(this.f20086a.m25770g());
        if (this.f20093h != null) {
            stringBuilder.append(", proxy=");
            stringBuilder.append(this.f20093h);
        } else {
            stringBuilder.append(", proxySelector=");
            stringBuilder.append(this.f20092g);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
