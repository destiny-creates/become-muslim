package com.google.maps.android.p247a;

import com.google.maps.android.p247a.p249b.C5384b;
import com.google.maps.android.p247a.p249b.C6924m;

/* compiled from: Layer */
/* renamed from: com.google.maps.android.a.d */
public abstract class C5394d {
    /* renamed from: a */
    private C5395h f18171a;

    /* renamed from: a */
    protected void m22897a() {
        if (this.f18171a instanceof C6924m) {
            ((C6924m) this.f18171a).mo4900j();
            return;
        }
        throw new UnsupportedOperationException("Stored renderer is not a KmlRenderer");
    }

    /* renamed from: a */
    protected void m22898a(C5395h c5395h) {
        this.f18171a = c5395h;
    }

    /* renamed from: b */
    protected Iterable<C5384b> mo4899b() {
        return this.f18171a instanceof C6924m ? ((C6924m) this.f18171a).m32489k() : null;
    }
}
