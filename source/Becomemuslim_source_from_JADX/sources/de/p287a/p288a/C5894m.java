package de.p287a.p288a;

/* compiled from: Subscription */
/* renamed from: de.a.a.m */
final class C5894m {
    /* renamed from: a */
    final Object f19612a;
    /* renamed from: b */
    final C5892k f19613b;
    /* renamed from: c */
    final int f19614c;
    /* renamed from: d */
    volatile boolean f19615d = true;

    C5894m(Object obj, C5892k c5892k, int i) {
        this.f19612a = obj;
        this.f19613b = c5892k;
        this.f19614c = i;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C5894m)) {
            return false;
        }
        C5894m c5894m = (C5894m) obj;
        if (this.f19612a == c5894m.f19612a && this.f19613b.equals(c5894m.f19613b) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return this.f19612a.hashCode() + this.f19613b.f19609d.hashCode();
    }
}
