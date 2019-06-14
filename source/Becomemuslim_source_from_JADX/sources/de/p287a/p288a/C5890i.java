package de.p287a.p288a;

/* compiled from: PendingPostQueue */
/* renamed from: de.a.a.i */
final class C5890i {
    /* renamed from: a */
    private C5889h f19600a;
    /* renamed from: b */
    private C5889h f19601b;

    C5890i() {
    }

    /* renamed from: a */
    synchronized void m24776a(C5889h c5889h) {
        if (c5889h != null) {
            if (this.f19601b != null) {
                this.f19601b.f19599c = c5889h;
                this.f19601b = c5889h;
            } else if (this.f19600a == null) {
                this.f19601b = c5889h;
                this.f19600a = c5889h;
            } else {
                throw new IllegalStateException("Head present, but no tail");
            }
            notifyAll();
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    /* renamed from: a */
    synchronized C5889h m24774a() {
        C5889h c5889h;
        c5889h = this.f19600a;
        if (this.f19600a != null) {
            this.f19600a = this.f19600a.f19599c;
            if (this.f19600a == null) {
                this.f19601b = null;
            }
        }
        return c5889h;
    }

    /* renamed from: a */
    synchronized C5889h m24775a(int i) {
        if (this.f19600a == null) {
            wait((long) i);
        }
        return m24774a();
    }
}
