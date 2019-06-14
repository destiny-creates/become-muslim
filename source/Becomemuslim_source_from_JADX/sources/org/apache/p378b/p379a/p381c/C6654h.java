package org.apache.p378b.p379a.p381c;

import java.net.URL;
import java.util.Properties;
import org.apache.p378b.p379a.C6657c;
import org.apache.p378b.p379a.p382d.C8277c;

/* compiled from: Provider */
/* renamed from: org.apache.b.a.c.h */
public class C6654h {
    /* renamed from: a */
    private static final Integer f21380a = Integer.valueOf(-1);
    /* renamed from: b */
    private static final C6657c f21381b = C8277c.m42922c();
    /* renamed from: c */
    private final Integer f21382c;
    /* renamed from: d */
    private final String f21383d;
    /* renamed from: e */
    private final String f21384e;
    /* renamed from: f */
    private final URL f21385f;
    /* renamed from: g */
    private final ClassLoader f21386g;

    public C6654h(Properties properties, URL url, ClassLoader classLoader) {
        this.f21385f = url;
        this.f21386g = classLoader;
        url = properties.getProperty("FactoryPriority");
        this.f21382c = url == null ? f21380a : Integer.valueOf(url);
        this.f21383d = properties.getProperty("LoggerContextFactory");
        this.f21384e = properties.getProperty("ThreadContextMap");
    }

    /* renamed from: a */
    public Integer m27081a() {
        return this.f21382c;
    }

    /* renamed from: b */
    public String m27082b() {
        return this.f21383d;
    }

    /* renamed from: c */
    public Class<? extends C6653f> m27083c() {
        if (this.f21383d == null) {
            return null;
        }
        try {
            Class loadClass = this.f21386g.loadClass(this.f21383d);
            if (C6653f.class.isAssignableFrom(loadClass)) {
                return loadClass.asSubclass(C6653f.class);
            }
        } catch (Exception e) {
            f21381b.mo6431b("Unable to create class {} specified in {}", this.f21383d, this.f21385f.toString(), e);
        }
        return null;
    }

    /* renamed from: d */
    public String m27084d() {
        return this.f21384e;
    }

    /* renamed from: e */
    public Class<? extends C6656j> m27085e() {
        if (this.f21384e == null) {
            return null;
        }
        try {
            Class loadClass = this.f21386g.loadClass(this.f21384e);
            if (C6656j.class.isAssignableFrom(loadClass)) {
                return loadClass.asSubclass(C6656j.class);
            }
        } catch (Exception e) {
            f21381b.mo6431b("Unable to create class {} specified in {}", this.f21384e, this.f21385f.toString(), e);
        }
        return null;
    }

    /* renamed from: f */
    public URL m27086f() {
        return this.f21385f;
    }
}
