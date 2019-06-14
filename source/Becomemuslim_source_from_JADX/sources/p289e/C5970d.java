package p289e;

/* compiled from: Notification */
/* renamed from: e.d */
public final class C5970d<T> {
    /* renamed from: d */
    private static final C5970d<Void> f19742d = new C5970d(C5968a.OnCompleted, null, null);
    /* renamed from: a */
    private final C5968a f19743a;
    /* renamed from: b */
    private final Throwable f19744b;
    /* renamed from: c */
    private final T f19745c;

    /* compiled from: Notification */
    /* renamed from: e.d$a */
    public enum C5968a {
        OnNext,
        OnError,
        OnCompleted
    }

    /* renamed from: a */
    public static <T> C5970d<T> m24952a(T t) {
        return new C5970d(C5968a.OnNext, t, null);
    }

    /* renamed from: a */
    public static <T> C5970d<T> m24953a(Throwable th) {
        return new C5970d(C5968a.OnError, null, th);
    }

    /* renamed from: a */
    public static <T> C5970d<T> m24951a() {
        return f19742d;
    }

    private C5970d(C5968a c5968a, T t, Throwable th) {
        this.f19745c = t;
        this.f19744b = th;
        this.f19743a = c5968a;
    }

    /* renamed from: b */
    public Throwable m24954b() {
        return this.f19744b;
    }

    /* renamed from: c */
    public T m24955c() {
        return this.f19745c;
    }

    /* renamed from: d */
    public boolean m24956d() {
        return m24961i() && this.f19745c != null;
    }

    /* renamed from: e */
    public boolean m24957e() {
        return m24959g() && this.f19744b != null;
    }

    /* renamed from: f */
    public C5968a m24958f() {
        return this.f19743a;
    }

    /* renamed from: g */
    public boolean m24959g() {
        return m24958f() == C5968a.OnError;
    }

    /* renamed from: h */
    public boolean m24960h() {
        return m24958f() == C5968a.OnCompleted;
    }

    /* renamed from: i */
    public boolean m24961i() {
        return m24958f() == C5968a.OnNext;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append('[');
        stringBuilder.append(super.toString());
        stringBuilder.append(' ');
        stringBuilder.append(m24958f());
        if (m24956d()) {
            stringBuilder.append(' ');
            stringBuilder.append(m24955c());
        }
        if (m24957e()) {
            stringBuilder.append(' ');
            stringBuilder.append(m24954b().getMessage());
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public int hashCode() {
        int hashCode = m24958f().hashCode();
        if (m24956d()) {
            hashCode = (hashCode * 31) + m24955c().hashCode();
        }
        return m24957e() ? (hashCode * 31) + m24954b().hashCode() : hashCode;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        C5970d c5970d = (C5970d) obj;
        if (c5970d.m24958f() == m24958f() && ((this.f19745c == c5970d.f19745c || (this.f19745c != null && this.f19745c.equals(c5970d.f19745c))) && (this.f19744b == c5970d.f19744b || !(this.f19744b == null || this.f19744b.equals(c5970d.f19744b) == null)))) {
            z = true;
        }
        return z;
    }
}
