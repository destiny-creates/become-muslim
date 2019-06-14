package io.p347a.p348a.p349a.p350a.p352b;

/* compiled from: AdvertisingInfo */
/* renamed from: io.a.a.a.a.b.b */
class C6418b {
    /* renamed from: a */
    public final String f20748a;
    /* renamed from: b */
    public final boolean f20749b;

    C6418b(String str, boolean z) {
        this.f20748a = str;
        this.f20749b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C6418b c6418b = (C6418b) obj;
                if (this.f20749b != c6418b.f20749b) {
                    return false;
                }
                if (this.f20748a == null) {
                    return c6418b.f20748a == null;
                } else {
                    if (this.f20748a.equals(c6418b.f20748a) == null) {
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f20748a != null ? this.f20748a.hashCode() : 0) * 31) + this.f20749b;
    }
}
