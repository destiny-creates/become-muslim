package net.openid.appauth.p370c;

import android.util.Log;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import net.openid.appauth.C6605p;

/* compiled from: Logger */
/* renamed from: net.openid.appauth.c.a */
public final class C6578a {
    /* renamed from: a */
    private static C6578a f21117a;
    /* renamed from: b */
    private final C6577b f21118b;
    /* renamed from: c */
    private final int f21119c;

    /* compiled from: Logger */
    /* renamed from: net.openid.appauth.c.a$b */
    public interface C6577b {
        /* renamed from: a */
        String mo5510a(Throwable th);

        /* renamed from: a */
        void mo5511a(int i, String str, String str2);

        /* renamed from: a */
        boolean mo5512a(String str, int i);
    }

    /* compiled from: Logger */
    /* renamed from: net.openid.appauth.c.a$a */
    private static final class C7640a implements C6577b {
        /* renamed from: a */
        private static final C7640a f26412a = new C7640a();

        private C7640a() {
        }

        /* renamed from: a */
        public void mo5511a(int i, String str, String str2) {
            Log.println(i, str, str2);
        }

        /* renamed from: a */
        public boolean mo5512a(String str, int i) {
            return Log.isLoggable(str, i);
        }

        /* renamed from: a */
        public String mo5510a(Throwable th) {
            return Log.getStackTraceString(th);
        }
    }

    /* renamed from: a */
    public static synchronized C6578a m26802a() {
        C6578a c6578a;
        synchronized (C6578a.class) {
            if (f21117a == null) {
                f21117a = new C6578a(C7640a.f26412a);
            }
            c6578a = f21117a;
        }
        return c6578a;
    }

    C6578a(C6577b c6577b) {
        this.f21118b = (C6577b) C6605p.m26932a(c6577b);
        c6577b = 7;
        while (c6577b >= 2 && this.f21118b.mo5512a("AppAuth", c6577b)) {
            c6577b--;
        }
        this.f21119c = c6577b + 1;
    }

    /* renamed from: a */
    public static void m26803a(String str, Object... objArr) {
        C6578a.m26802a().m26809a(3, null, str, objArr);
    }

    /* renamed from: a */
    public static void m26804a(Throwable th, String str, Object... objArr) {
        C6578a.m26802a().m26809a(3, th, str, objArr);
    }

    /* renamed from: b */
    public static void m26805b(String str, Object... objArr) {
        C6578a.m26802a().m26809a(4, null, str, objArr);
    }

    /* renamed from: c */
    public static void m26807c(String str, Object... objArr) {
        C6578a.m26802a().m26809a(5, null, str, objArr);
    }

    /* renamed from: d */
    public static void m26808d(String str, Object... objArr) {
        C6578a.m26802a().m26809a(6, null, str, objArr);
    }

    /* renamed from: b */
    public static void m26806b(Throwable th, String str, Object... objArr) {
        C6578a.m26802a().m26809a(6, th, str, objArr);
    }

    /* renamed from: a */
    public void m26809a(int i, Throwable th, String str, Object... objArr) {
        if (this.f21119c <= i) {
            if (objArr != null) {
                if (objArr.length >= 1) {
                    str = String.format(str, objArr);
                }
            }
            if (th != null) {
                objArr = new StringBuilder();
                objArr.append(str);
                objArr.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                objArr.append(this.f21118b.mo5510a(th));
                str = objArr.toString();
            }
            this.f21118b.mo5511a(i, "AppAuth", str);
        }
    }
}
