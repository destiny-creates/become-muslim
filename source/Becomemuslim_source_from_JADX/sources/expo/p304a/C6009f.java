package expo.p304a;

/* compiled from: Promise */
/* renamed from: expo.a.f */
public abstract class C6009f {
    /* renamed from: a */
    private static String f19797a = "E_UNKNOWN_ERROR";

    /* renamed from: a */
    public abstract void mo5137a(Object obj);

    /* renamed from: a */
    public abstract void mo5138a(String str, String str2, Throwable th);

    /* renamed from: a */
    public void m25155a(Throwable th) {
        m25154a(f19797a, th);
    }

    /* renamed from: a */
    public void m25152a(String str, String str2) {
        mo5138a(str, str2, null);
    }

    /* renamed from: a */
    public void m25154a(String str, Throwable th) {
        mo5138a(str, th.getMessage(), th);
    }
}
