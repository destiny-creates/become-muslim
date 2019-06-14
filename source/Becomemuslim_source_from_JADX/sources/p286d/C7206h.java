package p286d;

/* compiled from: ForwardingSource */
/* renamed from: d.h */
public abstract class C7206h implements C5876t {
    private final C5876t delegate;

    public C7206h(C5876t c5876t) {
        if (c5876t != null) {
            this.delegate = c5876t;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final C5876t delegate() {
        return this.delegate;
    }

    public long read(C8037c c8037c, long j) {
        return this.delegate.read(c8037c, j);
    }

    public C5877u timeout() {
        return this.delegate.timeout();
    }

    public void close() {
        this.delegate.close();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("(");
        stringBuilder.append(this.delegate.toString());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
