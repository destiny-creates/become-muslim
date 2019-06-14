package p289e.p292c.p294c;

import java.util.concurrent.ThreadFactory;
import p289e.C5986h;
import p289e.C5986h.C7353a;

/* compiled from: NewThreadScheduler */
/* renamed from: e.c.c.g */
public final class C7297g extends C5986h {
    /* renamed from: a */
    private final ThreadFactory f25671a;

    public C7297g(ThreadFactory threadFactory) {
        this.f25671a = threadFactory;
    }

    /* renamed from: a */
    public C7353a mo5127a() {
        return new C8134h(this.f25671a);
    }
}
