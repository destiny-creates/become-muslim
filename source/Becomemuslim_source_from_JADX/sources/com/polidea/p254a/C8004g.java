package com.polidea.p254a;

import com.polidea.p254a.C5550a.C5547b;
import java.util.concurrent.ExecutorService;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;
import p289e.C5986h;

/* compiled from: ClientComponent_ClientModule_ProvideBluetoothInteractionSchedulerFactory */
/* renamed from: com.polidea.a.g */
public final class C8004g implements C3086c<C5986h> {
    /* renamed from: a */
    private final C0003a<ExecutorService> f29757a;

    /* renamed from: a */
    public /* synthetic */ Object m38813a() {
        return m38814b();
    }

    public C8004g(C0003a<ExecutorService> c0003a) {
        this.f29757a = c0003a;
    }

    /* renamed from: b */
    public C5986h m38814b() {
        return (C5986h) C0000d.a(C5547b.m23596a((ExecutorService) this.f29757a.a()), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C8004g m38812a(C0003a<ExecutorService> c0003a) {
        return new C8004g(c0003a);
    }
}
