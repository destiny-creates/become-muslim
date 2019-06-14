package p000a.p001a.p002a;

/* compiled from: Preconditions */
/* renamed from: a.a.a.d */
public final class C0000d {
    /* renamed from: a */
    public static <T> T m0a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static <T> T m1a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
