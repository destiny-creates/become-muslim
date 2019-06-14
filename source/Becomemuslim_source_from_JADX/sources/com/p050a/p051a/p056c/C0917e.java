package com.p050a.p051a.p056c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: KeyPath */
/* renamed from: com.a.a.c.e */
public class C0917e {
    /* renamed from: a */
    private final List<String> f2611a;
    /* renamed from: b */
    private C0918f f2612b;

    public C0917e(String... strArr) {
        this.f2611a = Arrays.asList(strArr);
    }

    private C0917e(C0917e c0917e) {
        this.f2611a = new ArrayList(c0917e.f2611a);
        this.f2612b = c0917e.f2612b;
    }

    /* renamed from: a */
    public C0917e m3220a(String str) {
        C0917e c0917e = new C0917e(this);
        c0917e.f2611a.add(str);
        return c0917e;
    }

    /* renamed from: a */
    public C0917e m3219a(C0918f c0918f) {
        C0917e c0917e = new C0917e(this);
        c0917e.f2612b = c0918f;
        return c0917e;
    }

    /* renamed from: a */
    public C0918f m3221a() {
        return this.f2612b;
    }

    /* renamed from: a */
    public boolean m3222a(String str, int i) {
        if (m3218b(str)) {
            return true;
        }
        if (i >= this.f2611a.size()) {
            return false;
        }
        if (((String) this.f2611a.get(i)).equals(str) == null && ((String) this.f2611a.get(i)).equals("**") == null) {
            if (((String) this.f2611a.get(i)).equals("*") == null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public int m3223b(String str, int i) {
        if (m3218b(str)) {
            return 0;
        }
        if (!((String) this.f2611a.get(i)).equals("**")) {
            return 1;
        }
        if (i == this.f2611a.size() - 1 || ((String) this.f2611a.get(i + 1)).equals(str) == null) {
            return 0;
        }
        return 2;
    }

    /* renamed from: c */
    public boolean m3224c(String str, int i) {
        boolean z = false;
        if (i >= this.f2611a.size()) {
            return false;
        }
        Object obj = i == this.f2611a.size() - 1 ? 1 : null;
        String str2 = (String) this.f2611a.get(i);
        if (str2.equals("**")) {
            Object obj2 = (obj == null && ((String) this.f2611a.get(i + 1)).equals(str)) ? 1 : null;
            if (obj2 != null) {
                if (i == this.f2611a.size() - 2 || (i == this.f2611a.size() - 3 && m3217b() != null)) {
                    z = true;
                }
                return z;
            } else if (obj != null) {
                return true;
            } else {
                i++;
                if (i < this.f2611a.size() - 1) {
                    return false;
                }
                return ((String) this.f2611a.get(i)).equals(str);
            }
        }
        if (str2.equals(str) == null) {
            if (str2.equals("*") == null) {
                str = null;
                if ((obj != null || (i == this.f2611a.size() - 2 && m3217b() != 0)) && r6 != null) {
                    z = true;
                }
                return z;
            }
        }
        str = true;
        z = true;
        return z;
    }

    /* renamed from: d */
    public boolean m3225d(String str, int i) {
        boolean z = true;
        if (str.equals("__container") != null) {
            return true;
        }
        if (i >= this.f2611a.size() - 1) {
            if (((String) this.f2611a.get(i)).equals("**") == null) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: b */
    private boolean m3218b(String str) {
        return str.equals("__container");
    }

    /* renamed from: b */
    private boolean m3217b() {
        return ((String) this.f2611a.get(this.f2611a.size() - 1)).equals("**");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KeyPath{keys=");
        stringBuilder.append(this.f2611a);
        stringBuilder.append(",resolved=");
        stringBuilder.append(this.f2612b != null);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
