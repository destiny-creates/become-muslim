package com.bugsnag.android;

/* compiled from: BugsnagException */
/* renamed from: com.bugsnag.android.g */
public class C1081g extends Throwable {
    private static final long serialVersionUID = 5068182621179433346L;
    /* renamed from: a */
    private final String f3037a;
    /* renamed from: b */
    private String f3038b;

    public C1081g(String str, String str2, StackTraceElement[] stackTraceElementArr) {
        super(str2);
        super.setStackTrace(stackTraceElementArr);
        this.f3037a = str;
    }

    /* renamed from: a */
    public String m3781a() {
        return this.f3037a;
    }

    /* renamed from: b */
    String m3783b() {
        return this.f3038b;
    }

    /* renamed from: a */
    void m3782a(String str) {
        this.f3038b = str;
    }
}
