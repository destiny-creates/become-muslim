package com.google.p217b.p231e.p232a.p233a;

import com.google.p217b.p231e.p232a.C5246b;
import com.google.p217b.p231e.p232a.C5247c;

/* compiled from: ExpandedPair */
/* renamed from: com.google.b.e.a.a.b */
final class C5244b {
    /* renamed from: a */
    private final boolean f17693a;
    /* renamed from: b */
    private final C5246b f17694b;
    /* renamed from: c */
    private final C5246b f17695c;
    /* renamed from: d */
    private final C5247c f17696d;

    C5244b(C5246b c5246b, C5246b c5246b2, C5247c c5247c, boolean z) {
        this.f17694b = c5246b;
        this.f17695c = c5246b2;
        this.f17696d = c5247c;
        this.f17693a = z;
    }

    /* renamed from: a */
    C5246b m22217a() {
        return this.f17694b;
    }

    /* renamed from: b */
    C5246b m22218b() {
        return this.f17695c;
    }

    /* renamed from: c */
    C5247c m22219c() {
        return this.f17696d;
    }

    /* renamed from: d */
    public boolean m22220d() {
        return this.f17695c == null;
    }

    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("[ ");
        stringBuilder.append(this.f17694b);
        stringBuilder.append(" , ");
        stringBuilder.append(this.f17695c);
        stringBuilder.append(" : ");
        if (this.f17696d == null) {
            obj = "null";
        } else {
            obj = Integer.valueOf(this.f17696d.m22226a());
        }
        stringBuilder.append(obj);
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5244b)) {
            return false;
        }
        C5244b c5244b = (C5244b) obj;
        if (C5244b.m22216a(this.f17694b, c5244b.f17694b) && C5244b.m22216a(this.f17695c, c5244b.f17695c) && C5244b.m22216a(this.f17696d, c5244b.f17696d) != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m22216a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null ? true : null;
        } else {
            return obj.equals(obj2);
        }
    }

    public int hashCode() {
        return (C5244b.m22215a(this.f17694b) ^ C5244b.m22215a(this.f17695c)) ^ C5244b.m22215a(this.f17696d);
    }

    /* renamed from: a */
    private static int m22215a(Object obj) {
        return obj == null ? null : obj.hashCode();
    }
}
