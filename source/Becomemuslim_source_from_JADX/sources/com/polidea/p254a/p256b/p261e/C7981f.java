package com.polidea.p254a.p256b.p261e;

import com.polidea.p254a.p256b.p258b.C5575w;
import java.util.concurrent.ExecutorService;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;
import p289e.C5986h;

/* compiled from: ConnectionOperationQueueImpl_Factory */
/* renamed from: com.polidea.a.b.e.f */
public final class C7981f implements C3086c<C7980e> {
    /* renamed from: a */
    private final C0003a<String> f29716a;
    /* renamed from: b */
    private final C0003a<C5575w> f29717b;
    /* renamed from: c */
    private final C0003a<ExecutorService> f29718c;
    /* renamed from: d */
    private final C0003a<C5986h> f29719d;

    /* renamed from: a */
    public /* synthetic */ Object m38739a() {
        return m38740b();
    }

    public C7981f(C0003a<String> c0003a, C0003a<C5575w> c0003a2, C0003a<ExecutorService> c0003a3, C0003a<C5986h> c0003a4) {
        this.f29716a = c0003a;
        this.f29717b = c0003a2;
        this.f29718c = c0003a3;
        this.f29719d = c0003a4;
    }

    /* renamed from: b */
    public C7980e m38740b() {
        return new C7980e((String) this.f29716a.a(), (C5575w) this.f29717b.a(), (ExecutorService) this.f29718c.a(), (C5986h) this.f29719d.a());
    }

    /* renamed from: a */
    public static C7981f m38738a(C0003a<String> c0003a, C0003a<C5575w> c0003a2, C0003a<ExecutorService> c0003a3, C0003a<C5986h> c0003a4) {
        return new C7981f(c0003a, c0003a2, c0003a3, c0003a4);
    }
}
