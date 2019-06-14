package expolib_v1.p321a;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

/* compiled from: Route */
/* renamed from: expolib_v1.a.ad */
public final class ad {
    /* renamed from: a */
    final C6207a f20126a;
    /* renamed from: b */
    final Proxy f20127b;
    /* renamed from: c */
    final InetSocketAddress f20128c;

    public ad(C6207a c6207a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c6207a == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f20126a = c6207a;
            this.f20127b = proxy;
            this.f20128c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    /* renamed from: a */
    public C6207a m25591a() {
        return this.f20126a;
    }

    /* renamed from: b */
    public Proxy m25592b() {
        return this.f20127b;
    }

    /* renamed from: c */
    public InetSocketAddress m25593c() {
        return this.f20128c;
    }

    /* renamed from: d */
    public boolean m25594d() {
        return this.f20126a.f20094i != null && this.f20127b.type() == Type.HTTP;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        if (this.f20126a.equals(adVar.f20126a) && this.f20127b.equals(adVar.f20127b) && this.f20128c.equals(adVar.f20128c) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((((527 + this.f20126a.hashCode()) * 31) + this.f20127b.hashCode()) * 31) + this.f20128c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Route{");
        stringBuilder.append(this.f20128c);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
