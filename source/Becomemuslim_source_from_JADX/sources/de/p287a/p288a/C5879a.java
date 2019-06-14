package de.p287a.p288a;

/* compiled from: AsyncPoster */
/* renamed from: de.a.a.a */
class C5879a implements Runnable {
    /* renamed from: a */
    private final C5890i f19549a = new C5890i();
    /* renamed from: b */
    private final C5884c f19550b;

    C5879a(C5884c c5884c) {
        this.f19550b = c5884c;
    }

    /* renamed from: a */
    public void m24750a(C5894m c5894m, Object obj) {
        this.f19549a.m24776a(C5889h.m24772a(c5894m, obj));
        this.f19550b.m24766b().execute(this);
    }

    public void run() {
        C5889h a = this.f19549a.m24774a();
        if (a != null) {
            this.f19550b.m24763a(a);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
