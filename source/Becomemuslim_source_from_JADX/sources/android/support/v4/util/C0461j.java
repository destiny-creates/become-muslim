package android.support.v4.util;

/* compiled from: Pair */
/* renamed from: android.support.v4.util.j */
public class C0461j<F, S> {
    /* renamed from: a */
    public final F f1189a;
    /* renamed from: b */
    public final S f1190b;

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C0461j)) {
            return false;
        }
        C0461j c0461j = (C0461j) obj;
        if (C0461j.m1450a(c0461j.f1189a, this.f1189a) && C0461j.m1450a(c0461j.f1190b, this.f1190b) != null) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m1450a(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f1189a == null ? 0 : this.f1189a.hashCode();
        if (this.f1190b != null) {
            i = this.f1190b.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pair{");
        stringBuilder.append(String.valueOf(this.f1189a));
        stringBuilder.append(" ");
        stringBuilder.append(String.valueOf(this.f1190b));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
