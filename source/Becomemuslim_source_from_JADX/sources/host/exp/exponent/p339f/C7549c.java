package host.exp.exponent.p339f;

import android.app.Application;
import android.content.Context;
import de.p287a.p288a.C5884c;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C6352l.C6351c;
import host.exp.p333a.C6263a;
import javax.inject.C6562a;

/* compiled from: ExpoViewKernel */
/* renamed from: host.exp.exponent.f.c */
public class C7549c extends C6353m {
    /* renamed from: c */
    private static final String f26152c = "c";
    /* renamed from: d */
    private static C7549c f26153d;
    /* renamed from: e */
    private static String f26154e;
    @C6562a
    /* renamed from: a */
    Context f26155a;
    @C6562a
    /* renamed from: b */
    Application f26156b;

    /* compiled from: ExpoViewKernel */
    /* renamed from: host.exp.exponent.f.c$a */
    public static class C6331a {
        /* renamed from: a */
        public final String f20570a;

        C6331a(String str) {
            this.f20570a = str;
        }
    }

    /* renamed from: a */
    public void mo5406a(C6351c c6351c) {
    }

    /* renamed from: a */
    public boolean mo5409a(String str, boolean z) {
        return false;
    }

    /* renamed from: a */
    public static C7549c m34188a() {
        if (f26153d == null) {
            f26153d = new C7549c();
        }
        return f26153d;
    }

    private C7549c() {
        C6294a.m25957a().m25961b(C7549c.class, this);
        try {
            f26154e = this.f26156b.getPackageManager().getPackageInfo(this.f26155a.getPackageName(), 0).versionName;
        } catch (Throwable e) {
            C6289b.m25950a(f26152c, e);
        } catch (Throwable e2) {
            C6289b.m25950a(f26152c, e2);
        }
    }

    /* renamed from: b */
    public String m34193b() {
        return f26154e;
    }

    /* renamed from: a */
    public void mo5408a(String str) {
        if (C6263a.f20400b) {
            C5884c.m24753a().m24769d(new C6331a(str));
            return;
        }
        throw new RuntimeException(str);
    }

    /* renamed from: a */
    public void mo5407a(Exception exception) {
        if (C6263a.f20400b) {
            C5884c.m24753a().m24769d(new C6331a(exception.toString()));
            return;
        }
        throw new RuntimeException(exception);
    }
}
