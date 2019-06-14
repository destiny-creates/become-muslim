package com.polidea.p254a.p256b.p258b;

import com.polidea.p254a.p256b.p259c.C5583t;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;
import p289e.C5986h;

/* compiled from: ConnectionModule_ProvidesOperationTimeoutConfFactory */
/* renamed from: com.polidea.a.b.b.l */
public final class C7946l implements C3086c<C5583t> {
    /* renamed from: a */
    private final C5568d f29613a;
    /* renamed from: b */
    private final C0003a<C5986h> f29614b;

    /* renamed from: a */
    public /* synthetic */ Object m38619a() {
        return m38620b();
    }

    public C7946l(C5568d c5568d, C0003a<C5986h> c0003a) {
        this.f29613a = c5568d;
        this.f29614b = c0003a;
    }

    /* renamed from: b */
    public C5583t m38620b() {
        return (C5583t) C0000d.a(this.f29613a.m23739a((C5986h) this.f29614b.a()), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C7946l m38618a(C5568d c5568d, C0003a<C5986h> c0003a) {
        return new C7946l(c5568d, c0003a);
    }
}
