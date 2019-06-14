package expolib_v1.p332b;

/* compiled from: ForwardingSource */
/* renamed from: expolib_v1.b.h */
public abstract class C7499h implements C6258s {
    private final C6258s delegate;

    public C7499h(C6258s c6258s) {
        if (c6258s != null) {
            this.delegate = c6258s;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final C6258s delegate() {
        return this.delegate;
    }

    public long read(C8170c c8170c, long j) {
        return this.delegate.read(c8170c, j);
    }

    public C6259t timeout() {
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
