package com.polidea.p254a;

import com.polidea.p254a.C5550a.C5547b;
import java.util.concurrent.ExecutorService;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;

/* compiled from: ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory */
/* renamed from: com.polidea.a.f */
public final class C8003f implements C3086c<ExecutorService> {
    /* renamed from: a */
    private static final C8003f f29756a = new C8003f();

    /* renamed from: a */
    public /* synthetic */ Object m38810a() {
        return m38811b();
    }

    /* renamed from: b */
    public ExecutorService m38811b() {
        return (ExecutorService) C0000d.a(C5547b.m23603h(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: c */
    public static C8003f m38809c() {
        return f29756a;
    }
}
