package p289e.p290a;

/* compiled from: OnCompletedFailedException */
/* renamed from: e.a.d */
public final class C5905d extends RuntimeException {
    private static final long serialVersionUID = 8622579378868820554L;

    public C5905d(String str, Throwable th) {
        if (th == null) {
            th = new NullPointerException();
        }
        super(str, th);
    }
}
