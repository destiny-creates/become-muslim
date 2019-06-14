package host.exp.exponent.p339f;

/* compiled from: ExponentErrorMessage */
/* renamed from: host.exp.exponent.f.f */
public class C6333f {
    /* renamed from: a */
    private String f20576a;
    /* renamed from: b */
    private final String f20577b;

    public C6333f(String str, String str2) {
        this.f20576a = str;
        this.f20577b = str2;
    }

    /* renamed from: a */
    public String m26053a() {
        return this.f20576a != null ? m26052c(this.f20576a) : "";
    }

    /* renamed from: b */
    public String m26055b() {
        return this.f20577b != null ? m26052c(this.f20577b) : "";
    }

    /* renamed from: a */
    public static C6333f m26051a(String str) {
        return new C6333f(null, str);
    }

    /* renamed from: b */
    public C6333f m26054b(String str) {
        this.f20576a = str;
        return this;
    }

    /* renamed from: c */
    private String m26052c(String str) {
        if (str.length() < 300) {
            return str;
        }
        return str.substring(0, 300);
    }
}
