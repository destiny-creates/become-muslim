package org.apache.p378b.p379a.p381c;

import java.io.Serializable;
import org.apache.p378b.p379a.C6649a;
import org.apache.p378b.p379a.C6661d;
import org.apache.p378b.p379a.C6670e;
import org.apache.p378b.p379a.p380a.C6647b;
import org.apache.p378b.p379a.p380a.C6648c;
import org.apache.p378b.p379a.p380a.C8191e;
import org.apache.p378b.p379a.p382d.C8277c;

/* compiled from: AbstractLogger */
/* renamed from: org.apache.b.a.c.a */
public abstract class C8192a implements Serializable, C7687d {
    /* renamed from: a */
    public static final C6661d f30404a = C6670e.m27134a("FLOW");
    /* renamed from: b */
    public static final C6661d f30405b = C6670e.m27134a("ENTRY").mo5707a(f30404a);
    /* renamed from: c */
    public static final C6661d f30406c = C6670e.m27134a("EXIT").mo5707a(f30404a);
    /* renamed from: d */
    public static final C6661d f30407d = C6670e.m27134a("EXCEPTION");
    /* renamed from: e */
    public static final C6661d f30408e = C6670e.m27134a("THROWING").mo5707a(f30407d);
    /* renamed from: f */
    public static final C6661d f30409f = C6670e.m27134a("CATCHING").mo5707a(f30407d);
    /* renamed from: g */
    public static final Class<? extends C6648c> f30410g = C8191e.class;
    /* renamed from: h */
    private static final String f30411h = C8192a.class.getName();
    private static final long serialVersionUID = 2;
    /* renamed from: i */
    private final String f30412i;
    /* renamed from: j */
    private final C6648c f30413j;

    /* renamed from: a */
    public static void m39769a(C7687d c7687d, C6648c c6648c) {
        String b = c7687d.mo6428b();
        c7687d = c7687d.mo6424a();
        if (c6648c != null && !c7687d.equals(c6648c)) {
            C8277c.m42922c().mo6434c("The Logger {} was created with the message factory {} and is now requested with the message factory {}, which may create log events with unexpected formatting.", b, c7687d, c6648c);
        } else if (c6648c == null && c7687d.getClass().equals(f30410g) == null) {
            C8277c.m42922c().mo6434c("The Logger {} was created with the message factory {} and is now requested with a null message factory (defaults to {}), which may create log events with unexpected formatting.", b, c7687d, f30410g.getName());
        }
    }

    public C8192a() {
        this.f30412i = getClass().getName();
        this.f30413j = m39770c();
    }

    public C8192a(String str, C6648c c6648c) {
        this.f30412i = str;
        if (c6648c == null) {
            c6648c = m39770c();
        }
        this.f30413j = c6648c;
    }

    /* renamed from: c */
    private C6648c m39770c() {
        try {
            return (C6648c) f30410g.newInstance();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        } catch (Throwable e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* renamed from: a */
    public void mo6425a(String str) {
        m39774a(f30411h, C6649a.f21369f, null, str, (Throwable) null);
    }

    /* renamed from: a */
    public void mo6427a(String str, Object... objArr) {
        m39775a(f30411h, C6649a.f21369f, null, str, objArr);
    }

    /* renamed from: b */
    public void mo6429b(String str) {
        m39774a(f30411h, C6649a.f21366c, null, str, (Throwable) null);
    }

    /* renamed from: b */
    public void mo6431b(String str, Object... objArr) {
        m39775a(f30411h, C6649a.f21366c, null, str, objArr);
    }

    /* renamed from: a */
    public void mo6426a(String str, Throwable th) {
        m39774a(f30411h, C6649a.f21366c, null, str, th);
    }

    /* renamed from: b */
    public void mo6430b(String str, Throwable th) {
        m39774a(f30411h, C6649a.f21365b, null, str, th);
    }

    /* renamed from: a */
    public C6648c mo6424a() {
        return this.f30413j;
    }

    /* renamed from: b */
    public String mo6428b() {
        return this.f30412i;
    }

    /* renamed from: c */
    public void mo6433c(String str, Throwable th) {
        m39774a(f30411h, C6649a.f21368e, null, str, th);
    }

    /* renamed from: a */
    public boolean mo6786a(C6649a c6649a, C6661d c6661d) {
        return mo6783a(c6649a, c6661d, (Object) null, null);
    }

    /* renamed from: a */
    public void m39775a(String str, C6649a c6649a, C6661d c6661d, String str2, Object... objArr) {
        if (mo6785a(c6649a, c6661d, str2, objArr)) {
            m39782b(str, c6649a, c6661d, str2, objArr);
        }
    }

    /* renamed from: a */
    public void m39774a(String str, C6649a c6649a, C6661d c6661d, String str2, Throwable th) {
        if (mo6784a(c6649a, c6661d, str2, th)) {
            m39781b(str, c6649a, c6661d, str2, th);
        }
    }

    /* renamed from: b */
    protected void m39781b(String str, C6649a c6649a, C6661d c6661d, String str2, Throwable th) {
        mo6782a(str, c6649a, c6661d, this.f30413j.mo5698a(str2), th);
    }

    /* renamed from: b */
    protected void m39782b(String str, C6649a c6649a, C6661d c6661d, String str2, Object... objArr) {
        C6647b a = this.f30413j.mo6423a(str2, objArr);
        mo6782a(str, c6649a, c6661d, a, a.mo5701c());
    }

    /* renamed from: c */
    public void mo6432c(String str) {
        m39774a(f30411h, C6649a.f21367d, null, str, (Throwable) null);
    }

    /* renamed from: c */
    public void mo6434c(String str, Object... objArr) {
        m39775a(f30411h, C6649a.f21367d, null, str, objArr);
    }

    /* renamed from: d */
    public void mo6435d(String str, Throwable th) {
        m39774a(f30411h, C6649a.f21367d, null, str, th);
    }
}
