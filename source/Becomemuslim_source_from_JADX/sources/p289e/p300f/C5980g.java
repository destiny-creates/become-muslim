package p289e.p300f;

import java.util.concurrent.ThreadFactory;
import p289e.C5986h;
import p289e.p291b.C5913a;
import p289e.p292c.p294c.C7288a;
import p289e.p292c.p294c.C7291b;
import p289e.p292c.p294c.C7297g;
import p289e.p292c.p295e.C5966k;

/* compiled from: RxJavaSchedulersHook */
/* renamed from: e.f.g */
public class C5980g {
    /* renamed from: a */
    private static final C5980g f19775a = new C5980g();

    @Deprecated
    /* renamed from: a */
    public C5913a m25096a(C5913a c5913a) {
        return c5913a;
    }

    /* renamed from: d */
    public C5986h m25097d() {
        return null;
    }

    /* renamed from: e */
    public C5986h m25098e() {
        return null;
    }

    /* renamed from: f */
    public C5986h m25099f() {
        return null;
    }

    /* renamed from: a */
    public static C5986h m25089a() {
        return C5980g.m25090a(new C5966k("RxComputationScheduler-"));
    }

    /* renamed from: a */
    public static C5986h m25090a(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new C7291b(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    /* renamed from: b */
    public static C5986h m25091b() {
        return C5980g.m25092b(new C5966k("RxIoScheduler-"));
    }

    /* renamed from: b */
    public static C5986h m25092b(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new C7288a(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    /* renamed from: c */
    public static C5986h m25093c() {
        return C5980g.m25094c(new C5966k("RxNewThreadScheduler-"));
    }

    /* renamed from: c */
    public static C5986h m25094c(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new C7297g(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    /* renamed from: g */
    public static C5980g m25095g() {
        return f19775a;
    }
}
