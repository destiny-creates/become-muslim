package io.p347a.p348a.p349a.p350a.p356e;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* compiled from: NetworkUtils */
/* renamed from: io.a.a.a.a.e.f */
public final class C6485f {
    /* renamed from: a */
    public static final SSLSocketFactory m26585a(C6486g c6486g) {
        SSLContext instance = SSLContext.getInstance("TLS");
        C6487h c6487h = new C6487h(new C6488i(c6486g.m26586a(), c6486g.m26587b()), c6486g);
        instance.init(null, new TrustManager[]{c6487h}, null);
        return instance.getSocketFactory();
    }
}
