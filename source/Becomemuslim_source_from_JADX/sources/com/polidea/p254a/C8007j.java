package com.polidea.p254a;

import com.polidea.p254a.C5550a.C5547b;
import java.util.concurrent.ExecutorService;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;

/* compiled from: ClientComponent_ClientModule_ProvideConnectionQueueExecutorServiceFactory */
/* renamed from: com.polidea.a.j */
public final class C8007j implements C3086c<ExecutorService> {
    /* renamed from: a */
    private static final C8007j f29760a = new C8007j();

    /* renamed from: a */
    public /* synthetic */ Object m38823a() {
        return m38824b();
    }

    /* renamed from: b */
    public ExecutorService m38824b() {
        return (ExecutorService) C0000d.a(C5547b.m23602g(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: c */
    public static C8007j m38822c() {
        return f29760a;
    }
}
