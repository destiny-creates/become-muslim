package com.google.android.gms.p174b;

import com.google.android.gms.p174b.C2757a.C2756a;

/* renamed from: com.google.android.gms.b.g */
final class C4326g implements C2760e<T> {
    /* renamed from: a */
    private final /* synthetic */ C2757a f11375a;

    C4326g(C2757a c2757a) {
        this.f11375a = c2757a;
    }

    /* renamed from: a */
    public final void mo2369a(T t) {
        this.f11375a.f7049a = t;
        t = this.f11375a.f7051c.iterator();
        while (t.hasNext()) {
            ((C2756a) t.next()).mo2371a(this.f11375a.f7049a);
        }
        this.f11375a.f7051c.clear();
        this.f11375a.f7050b = null;
    }
}
