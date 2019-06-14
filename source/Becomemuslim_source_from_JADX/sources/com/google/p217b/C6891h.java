package com.google.p217b;

/* compiled from: FormatException */
/* renamed from: com.google.b.h */
public final class C6891h extends C5313p {
    /* renamed from: c */
    private static final C6891h f24700c;

    static {
        C6891h c6891h = new C6891h();
        f24700c = c6891h;
        c6891h.setStackTrace(b);
    }

    private C6891h() {
    }

    private C6891h(Throwable th) {
        super(th);
    }

    /* renamed from: a */
    public static C6891h m32342a() {
        return a ? new C6891h() : f24700c;
    }

    /* renamed from: a */
    public static C6891h m32343a(Throwable th) {
        return a ? new C6891h(th) : f24700c;
    }
}
