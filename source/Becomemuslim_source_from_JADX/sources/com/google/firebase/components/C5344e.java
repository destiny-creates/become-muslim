package com.google.firebase.components;

import com.google.android.gms.common.internal.C2872v;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
/* renamed from: com.google.firebase.components.e */
public final class C5344e {
    /* renamed from: a */
    private final Class<?> f18019a;
    /* renamed from: b */
    private final int f18020b;
    /* renamed from: c */
    private final int f18021c;

    private C5344e(Class<?> cls, int i, int i2) {
        this.f18019a = (Class) C2872v.a(cls, "Null dependency anInterface.");
        this.f18020b = i;
        this.f18021c = i2;
    }

    /* renamed from: a */
    public static C5344e m22648a(Class<?> cls) {
        return new C5344e(cls, 1, 0);
    }

    /* renamed from: a */
    public final Class<?> m22649a() {
        return this.f18019a;
    }

    /* renamed from: b */
    public final boolean m22650b() {
        return this.f18020b == 1;
    }

    /* renamed from: c */
    public final boolean m22651c() {
        return this.f18021c == 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C5344e)) {
            return false;
        }
        C5344e c5344e = (C5344e) obj;
        if (this.f18019a == c5344e.f18019a && this.f18020b == c5344e.f18020b && this.f18021c == c5344e.f18021c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f18019a.hashCode() ^ 1000003) * 1000003) ^ this.f18020b) * 1000003) ^ this.f18021c;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Dependency{anInterface=");
        stringBuilder.append(this.f18019a);
        stringBuilder.append(", required=");
        boolean z = false;
        stringBuilder.append(this.f18020b == 1);
        stringBuilder.append(", direct=");
        if (this.f18021c == 0) {
            z = true;
        }
        stringBuilder.append(z);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
