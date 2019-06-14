package p289e.p290a;

/* compiled from: UnsubscribeFailedException */
/* renamed from: e.a.h */
public final class C5911h extends RuntimeException {
    private static final long serialVersionUID = 4594672310593167598L;

    public C5911h(String str, Throwable th) {
        if (th == null) {
            th = new NullPointerException();
        }
        super(str, th);
    }
}
