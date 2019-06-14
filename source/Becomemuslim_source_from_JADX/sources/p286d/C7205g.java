package p286d;

/* compiled from: ForwardingSink */
/* renamed from: d.g */
public abstract class C7205g implements C5875s {
    private final C5875s delegate;

    public C7205g(C5875s c5875s) {
        if (c5875s != null) {
            this.delegate = c5875s;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final C5875s delegate() {
        return this.delegate;
    }

    public void write(C8037c c8037c, long j) {
        this.delegate.write(c8037c, j);
    }

    public void flush() {
        this.delegate.flush();
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
