package host.exp.exponent.p337d;

/* compiled from: ExponentException */
/* renamed from: host.exp.exponent.d.b */
public abstract class C6300b extends Exception {
    /* renamed from: a */
    private final Exception f20494a;

    public abstract String toString();

    public C6300b(Exception exception) {
        this.f20494a = exception;
    }

    /* renamed from: a */
    public Exception m25997a() {
        return this.f20494a;
    }

    /* renamed from: b */
    public String m25998b() {
        if (this.f20494a != null) {
            return this.f20494a.toString();
        }
        return toString();
    }
}
