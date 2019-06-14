package com.polidea.p254a;

import com.polidea.p254a.C5550a.C5546a;
import com.polidea.p254a.C5550a.C5547b;
import java.util.concurrent.ExecutorService;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;

/* compiled from: ClientComponent_ClientModule_ProvideFinalizationCloseableFactory */
/* renamed from: com.polidea.a.p */
public final class C8013p implements C3086c<C5546a> {
    /* renamed from: a */
    private final C0003a<ExecutorService> f29766a;
    /* renamed from: b */
    private final C0003a<ExecutorService> f29767b;
    /* renamed from: c */
    private final C0003a<ExecutorService> f29768c;

    /* renamed from: a */
    public /* synthetic */ Object m38841a() {
        return m38842b();
    }

    public C8013p(C0003a<ExecutorService> c0003a, C0003a<ExecutorService> c0003a2, C0003a<ExecutorService> c0003a3) {
        this.f29766a = c0003a;
        this.f29767b = c0003a2;
        this.f29768c = c0003a3;
    }

    /* renamed from: b */
    public C5546a m38842b() {
        return (C5546a) C0000d.a(C5547b.m23594a((ExecutorService) this.f29766a.a(), (ExecutorService) this.f29767b.a(), (ExecutorService) this.f29768c.a()), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C8013p m38840a(C0003a<ExecutorService> c0003a, C0003a<ExecutorService> c0003a2, C0003a<ExecutorService> c0003a3) {
        return new C8013p(c0003a, c0003a2, c0003a3);
    }
}
