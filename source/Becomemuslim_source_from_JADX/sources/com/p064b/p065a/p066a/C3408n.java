package com.p064b.p065a.p066a;

import com.p064b.p065a.p066a.C0999s.C0998b;
import java.util.HashSet;
import java.util.Set;

/* compiled from: SamplingEventFilter */
/* renamed from: com.b.a.a.n */
class C3408n implements C0993j {
    /* renamed from: b */
    static final Set<C0998b> f9068b = new C09951();
    /* renamed from: a */
    final int f9069a;

    /* compiled from: SamplingEventFilter */
    /* renamed from: com.b.a.a.n$1 */
    static class C09951 extends HashSet<C0998b> {
        C09951() {
            add(C0998b.START);
            add(C0998b.RESUME);
            add(C0998b.PAUSE);
            add(C0998b.STOP);
        }
    }

    public C3408n(int i) {
        this.f9069a = i;
    }

    /* renamed from: a */
    public boolean mo744a(C0999s c0999s) {
        Object obj = (f9068b.contains(c0999s.f2782c) && c0999s.f2780a.f2795g == null) ? 1 : null;
        c0999s = Math.abs(c0999s.f2780a.f2791c.hashCode() % this.f9069a) != null ? true : null;
        if (obj == null || c0999s == null) {
            return false;
        }
        return true;
    }
}
