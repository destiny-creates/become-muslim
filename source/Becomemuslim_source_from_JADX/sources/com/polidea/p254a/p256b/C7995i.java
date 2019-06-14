package com.polidea.p254a.p256b;

import com.polidea.p254a.p256b.p259c.C5583t;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;
import p289e.C5986h;

/* compiled from: DeviceModule_ProvidesDisconnectTimeoutConfFactory */
/* renamed from: com.polidea.a.b.i */
public final class C7995i implements C3086c<C5583t> {
    /* renamed from: a */
    private final C0003a<C5986h> f29742a;

    /* renamed from: a */
    public /* synthetic */ Object m38783a() {
        return m38784b();
    }

    public C7995i(C0003a<C5986h> c0003a) {
        this.f29742a = c0003a;
    }

    /* renamed from: b */
    public C5583t m38784b() {
        return (C5583t) C0000d.a(C5584c.m23768b((C5986h) this.f29742a.a()), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C7995i m38782a(C0003a<C5986h> c0003a) {
        return new C7995i(c0003a);
    }
}
