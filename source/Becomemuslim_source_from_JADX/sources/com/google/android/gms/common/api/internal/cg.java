package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.api.C2781a.C2779d;
import com.google.android.gms.common.internal.C2868t;

public final class cg<O extends C2779d> {
    /* renamed from: a */
    private final boolean f7156a = true;
    /* renamed from: b */
    private final int f7157b;
    /* renamed from: c */
    private final C2781a<O> f7158c;
    /* renamed from: d */
    private final O f7159d;

    private cg(C2781a<O> c2781a, O o) {
        this.f7158c = c2781a;
        this.f7159d = o;
        this.f7157b = C2868t.m8372a(this.f7158c, this.f7159d);
    }

    private cg(C2781a<O> c2781a) {
        this.f7158c = c2781a;
        this.f7159d = null;
        this.f7157b = System.identityHashCode(this);
    }

    /* renamed from: a */
    public static <O extends C2779d> cg<O> m8030a(C2781a<O> c2781a, O o) {
        return new cg(c2781a, o);
    }

    /* renamed from: a */
    public static <O extends C2779d> cg<O> m8029a(C2781a<O> c2781a) {
        return new cg(c2781a);
    }

    /* renamed from: a */
    public final String m8031a() {
        return this.f7158c.m7934d();
    }

    public final int hashCode() {
        return this.f7157b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cg)) {
            return false;
        }
        cg cgVar = (cg) obj;
        return (this.f7156a || cgVar.f7156a || !C2868t.m8374a(this.f7158c, cgVar.f7158c) || C2868t.m8374a(this.f7159d, cgVar.f7159d) == null) ? false : true;
    }
}
