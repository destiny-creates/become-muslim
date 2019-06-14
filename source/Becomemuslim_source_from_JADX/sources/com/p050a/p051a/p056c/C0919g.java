package com.p050a.p051a.p056c;

import android.support.v4.util.C0461j;

/* compiled from: MutablePair */
/* renamed from: com.a.a.c.g */
public class C0919g<T> {
    /* renamed from: a */
    T f2613a;
    /* renamed from: b */
    T f2614b;

    /* renamed from: a */
    public void m3229a(T t, T t2) {
        this.f2613a = t;
        this.f2614b = t2;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C0461j)) {
            return false;
        }
        C0461j c0461j = (C0461j) obj;
        if (C0919g.m3228b(c0461j.f1189a, this.f2613a) && C0919g.m3228b(c0461j.f1190b, this.f2614b) != null) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private static boolean m3228b(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f2613a == null ? 0 : this.f2613a.hashCode();
        if (this.f2614b != null) {
            i = this.f2614b.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pair{");
        stringBuilder.append(String.valueOf(this.f2613a));
        stringBuilder.append(" ");
        stringBuilder.append(String.valueOf(this.f2614b));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
