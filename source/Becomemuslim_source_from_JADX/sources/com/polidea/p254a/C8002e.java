package com.polidea.p254a;

import com.polidea.p254a.C5550a.C5547b;
import java.util.concurrent.ExecutorService;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;
import p289e.C5986h;

/* compiled from: ClientComponent_ClientModule_ProvideBluetoothCallbacksSchedulerFactory */
/* renamed from: com.polidea.a.e */
public final class C8002e implements C3086c<C5986h> {
    /* renamed from: a */
    private final C0003a<ExecutorService> f29755a;

    /* renamed from: a */
    public /* synthetic */ Object m38807a() {
        return m38808b();
    }

    public C8002e(C0003a<ExecutorService> c0003a) {
        this.f29755a = c0003a;
    }

    /* renamed from: b */
    public C5986h m38808b() {
        return (C5986h) C0000d.a(C5547b.m23598b((ExecutorService) this.f29755a.a()), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C8002e m38806a(C0003a<ExecutorService> c0003a) {
        return new C8002e(c0003a);
    }
}
