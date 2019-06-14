package expolib_v1.p321a.p322a.p324b;

import com.facebook.soloader.MinElf;
import expolib_v1.p321a.C6207a;
import expolib_v1.p321a.C6237r;
import expolib_v1.p321a.ad;
import expolib_v1.p321a.p322a.C6165c;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: RouteSelector */
/* renamed from: expolib_v1.a.a.b.f */
public final class C6152f {
    /* renamed from: a */
    private final C6207a f19876a;
    /* renamed from: b */
    private final C6150d f19877b;
    /* renamed from: c */
    private Proxy f19878c;
    /* renamed from: d */
    private InetSocketAddress f19879d;
    /* renamed from: e */
    private List<Proxy> f19880e = Collections.emptyList();
    /* renamed from: f */
    private int f19881f;
    /* renamed from: g */
    private List<InetSocketAddress> f19882g = Collections.emptyList();
    /* renamed from: h */
    private int f19883h;
    /* renamed from: i */
    private final List<ad> f19884i = new ArrayList();

    public C6152f(C6207a c6207a, C6150d c6150d) {
        this.f19876a = c6207a;
        this.f19877b = c6150d;
        m25240a(c6207a.m25547a(), c6207a.m25554h());
    }

    /* renamed from: a */
    public boolean m25249a() {
        if (!(m25244e() || m25242c())) {
            if (!m25246g()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public ad m25250b() {
        if (!m25244e()) {
            if (m25242c()) {
                this.f19878c = m25243d();
            } else if (m25246g()) {
                return m25247h();
            } else {
                throw new NoSuchElementException();
            }
        }
        this.f19879d = m25245f();
        ad adVar = new ad(this.f19876a, this.f19878c, this.f19879d);
        if (!this.f19877b.m25235c(adVar)) {
            return adVar;
        }
        this.f19884i.add(adVar);
        return m25250b();
    }

    /* renamed from: a */
    public void m25248a(ad adVar, IOException iOException) {
        if (!(adVar.m25592b().type() == Type.DIRECT || this.f19876a.m25553g() == null)) {
            this.f19876a.m25553g().connectFailed(this.f19876a.m25547a().m25762a(), adVar.m25592b().address(), iOException);
        }
        this.f19877b.m25233a(adVar);
    }

    /* renamed from: a */
    private void m25240a(C6237r c6237r, Proxy proxy) {
        if (proxy != null) {
            this.f19880e = Collections.singletonList(proxy);
        } else {
            List select = this.f19876a.m25553g().select(c6237r.m25762a());
            if (select == null || select.isEmpty() != null) {
                c6237r = C6165c.m25311a(Proxy.NO_PROXY);
            } else {
                c6237r = C6165c.m25310a(select);
            }
            this.f19880e = c6237r;
        }
        this.f19881f = 0;
    }

    /* renamed from: c */
    private boolean m25242c() {
        return this.f19881f < this.f19880e.size();
    }

    /* renamed from: d */
    private Proxy m25243d() {
        if (m25242c()) {
            List list = this.f19880e;
            int i = this.f19881f;
            this.f19881f = i + 1;
            Proxy proxy = (Proxy) list.get(i);
            m25241a(proxy);
            return proxy;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No route to ");
        stringBuilder.append(this.f19876a.m25547a().m25769f());
        stringBuilder.append("; exhausted proxy configurations: ");
        stringBuilder.append(this.f19880e);
        throw new SocketException(stringBuilder.toString());
    }

    /* renamed from: a */
    private void m25241a(Proxy proxy) {
        String a;
        int port;
        StringBuilder stringBuilder;
        this.f19882g = new ArrayList();
        if (proxy.type() != Type.DIRECT) {
            if (proxy.type() != Type.SOCKS) {
                SocketAddress address = proxy.address();
                if (address instanceof InetSocketAddress) {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                    a = C6152f.m25239a(inetSocketAddress);
                    port = inetSocketAddress.getPort();
                    if (port >= 1 || port > MinElf.PN_XNUM) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("No route to ");
                        stringBuilder.append(a);
                        stringBuilder.append(":");
                        stringBuilder.append(port);
                        stringBuilder.append("; port is out of range");
                        throw new SocketException(stringBuilder.toString());
                    }
                    if (proxy.type() == Type.SOCKS) {
                        this.f19882g.add(InetSocketAddress.createUnresolved(a, port));
                    } else {
                        proxy = this.f19876a.m25548b().mo5327a(a);
                        int size = proxy.size();
                        for (int i = 0; i < size; i++) {
                            this.f19882g.add(new InetSocketAddress((InetAddress) proxy.get(i), port));
                        }
                    }
                    this.f19883h = 0;
                    return;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Proxy.address() is not an InetSocketAddress: ");
                stringBuilder2.append(address.getClass());
                throw new IllegalArgumentException(stringBuilder2.toString());
            }
        }
        a = this.f19876a.m25547a().m25769f();
        port = this.f19876a.m25547a().m25770g();
        if (port >= 1) {
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("No route to ");
        stringBuilder.append(a);
        stringBuilder.append(":");
        stringBuilder.append(port);
        stringBuilder.append("; port is out of range");
        throw new SocketException(stringBuilder.toString());
    }

    /* renamed from: a */
    static String m25239a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    /* renamed from: e */
    private boolean m25244e() {
        return this.f19883h < this.f19882g.size();
    }

    /* renamed from: f */
    private InetSocketAddress m25245f() {
        if (m25244e()) {
            List list = this.f19882g;
            int i = this.f19883h;
            this.f19883h = i + 1;
            return (InetSocketAddress) list.get(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No route to ");
        stringBuilder.append(this.f19876a.m25547a().m25769f());
        stringBuilder.append("; exhausted inet socket addresses: ");
        stringBuilder.append(this.f19882g);
        throw new SocketException(stringBuilder.toString());
    }

    /* renamed from: g */
    private boolean m25246g() {
        return this.f19884i.isEmpty() ^ 1;
    }

    /* renamed from: h */
    private ad m25247h() {
        return (ad) this.f19884i.remove(0);
    }
}
