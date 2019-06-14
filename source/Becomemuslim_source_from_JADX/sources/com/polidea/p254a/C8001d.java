package com.polidea.p254a;

import com.polidea.p254a.C5550a.C5547b;
import java.util.concurrent.ExecutorService;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;

/* compiled from: ClientComponent_ClientModule_ProvideBluetoothCallbacksExecutorServiceFactory */
/* renamed from: com.polidea.a.d */
public final class C8001d implements C3086c<ExecutorService> {
    /* renamed from: a */
    private static final C8001d f29754a = new C8001d();

    /* renamed from: a */
    public /* synthetic */ Object m38804a() {
        return m38805b();
    }

    /* renamed from: b */
    public ExecutorService m38805b() {
        return (ExecutorService) C0000d.a(C5547b.m23604i(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: c */
    public static C8001d m38803c() {
        return f29754a;
    }
}
