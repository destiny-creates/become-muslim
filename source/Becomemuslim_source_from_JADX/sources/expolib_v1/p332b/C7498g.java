package expolib_v1.p332b;

/* compiled from: ForwardingSink */
/* renamed from: expolib_v1.b.g */
public abstract class C7498g implements C6257r {
    /* renamed from: a */
    private final C6257r f26037a;

    public C7498g(C6257r c6257r) {
        if (c6257r != null) {
            this.f26037a = c6257r;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public void mo5257a(C8170c c8170c, long j) {
        this.f26037a.mo5257a(c8170c, j);
    }

    public void flush() {
        this.f26037a.flush();
    }

    public C6259t timeout() {
        return this.f26037a.timeout();
    }

    public void close() {
        this.f26037a.close();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("(");
        stringBuilder.append(this.f26037a.toString());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
