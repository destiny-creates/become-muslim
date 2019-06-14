package p289e.p290a;

/* compiled from: OnErrorFailedException */
/* renamed from: e.a.e */
public class C5906e extends RuntimeException {
    private static final long serialVersionUID = -419289748403337611L;

    public C5906e(String str, Throwable th) {
        if (th == null) {
            th = new NullPointerException();
        }
        super(str, th);
    }

    public C5906e(Throwable th) {
        String message = th != null ? th.getMessage() : null;
        if (th == null) {
            th = new NullPointerException();
        }
        super(message, th);
    }
}
