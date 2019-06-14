package com.polidea.p254a.p256b.p258b;

import com.polidea.p254a.C5629x;
import com.polidea.p254a.aj;
import com.polidea.p254a.p256b.p259c.C5583t;
import com.polidea.p254a.p256b.p262f.C5603f;
import p000a.p003b.p004a.C0003a;
import p289e.C5986h;

/* compiled from: ConnectionModule */
/* renamed from: com.polidea.a.b.b.d */
public class C5568d {
    /* renamed from: a */
    final boolean f18681a;
    /* renamed from: b */
    final boolean f18682b;
    /* renamed from: c */
    private final aj f18683c;

    C5568d(C5629x c5629x) {
        this.f18681a = c5629x.f18805a;
        this.f18682b = c5629x.f18806b;
        this.f18683c = c5629x.f18807c;
    }

    /* renamed from: a */
    boolean m23740a() {
        return this.f18681a;
    }

    /* renamed from: a */
    C5583t m23739a(C5986h c5986h) {
        return new C5583t(this.f18683c.f18630b, this.f18683c.f18629a, c5986h);
    }

    /* renamed from: a */
    aa m23738a(C0003a<ae> c0003a, C0003a<az> c0003a2) {
        if (this.f18682b) {
            return (aa) c0003a.a();
        }
        return (aa) c0003a2.a();
    }

    /* renamed from: b */
    C5603f m23741b() {
        return new C5603f(1, 2, 4, 8, 16, 32, 64);
    }
}
