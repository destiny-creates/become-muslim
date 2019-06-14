package p289e.p290a;

/* compiled from: OnErrorNotImplementedException */
/* renamed from: e.a.f */
public class C5907f extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public C5907f(String str, Throwable th) {
        if (th == null) {
            th = new NullPointerException();
        }
        super(str, th);
    }

    public C5907f(Throwable th) {
        String message = th != null ? th.getMessage() : null;
        if (th == null) {
            th = new NullPointerException();
        }
        super(message, th);
    }
}
