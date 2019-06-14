package org.apache.p378b.p379a.p383e;

import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.p378b.p379a.C6657c;
import org.apache.p378b.p379a.p381c.C6654h;
import org.apache.p378b.p379a.p382d.C8277c;
import org.apache.p378b.p379a.p383e.C6665a.C6664b;

/* compiled from: ProviderUtil */
/* renamed from: org.apache.b.a.e.c */
public final class C6667c {
    /* renamed from: a */
    protected static final Collection<C6654h> f21414a = new HashSet();
    /* renamed from: b */
    protected static final Lock f21415b = new ReentrantLock();
    /* renamed from: c */
    private static final String[] f21416c = new String[]{"2.0.0", "2.1.0"};
    /* renamed from: d */
    private static final C6657c f21417d = C8277c.m42922c();
    /* renamed from: e */
    private static volatile C6667c f21418e;

    private C6667c() {
        for (C6664b c6664b : C6665a.m27116c("META-INF/log4j-provider.properties")) {
            C6667c.m27125a(c6664b.m27111b(), c6664b.m27110a());
        }
    }

    /* renamed from: a */
    protected static void m27125a(URL url, ClassLoader classLoader) {
        try {
            Properties a = C6666b.m27117a(url.openStream(), (Object) url);
            if (C6667c.m27126a(a.getProperty("Log4jAPIVersion"))) {
                f21414a.add(new C6654h(a, url, classLoader));
            }
        } catch (ClassLoader classLoader2) {
            f21417d.mo6431b("Unable to open {}", url, classLoader2);
        }
    }

    /* renamed from: a */
    public static Iterable<C6654h> m27124a() {
        C6667c.m27128c();
        return f21414a;
    }

    /* renamed from: b */
    public static boolean m27127b() {
        C6667c.m27128c();
        return f21414a.isEmpty() ^ 1;
    }

    /* renamed from: c */
    protected static void m27128c() {
        if (f21418e == null) {
            try {
                f21415b.lockInterruptibly();
                if (f21418e == null) {
                    f21418e = new C6667c();
                }
            } catch (Throwable e) {
                f21417d.mo6430b("Interrupted before Log4j Providers could be loaded.", e);
                Thread.currentThread().interrupt();
            } catch (Throwable th) {
                f21415b.unlock();
            }
            f21415b.unlock();
        }
    }

    /* renamed from: d */
    public static ClassLoader m27129d() {
        return C6665a.m27113a();
    }

    /* renamed from: a */
    private static boolean m27126a(String str) {
        for (String startsWith : f21416c) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }
}
