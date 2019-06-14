package p289e.p298d;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p289e.C5974e;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p292c.p295e.C5959c;

/* compiled from: BlockingObservable */
/* renamed from: e.d.a */
public final class C5969a<T> {
    /* renamed from: a */
    static final Object f19738a = new Object();
    /* renamed from: b */
    static final Object f19739b = new Object();
    /* renamed from: c */
    static final Object f19740c = new Object();
    /* renamed from: d */
    private final C5974e<? extends T> f19741d;

    private C5969a(C5974e<? extends T> c5974e) {
        this.f19741d = c5974e;
    }

    /* renamed from: a */
    public static <T> C5969a<T> m24948a(C5974e<? extends T> c5974e) {
        return new C5969a(c5974e);
    }

    /* renamed from: a */
    public T m24950a() {
        return m24949b(this.f19741d.m25042k());
    }

    /* renamed from: b */
    private T m24949b(C5974e<? extends T> c5974e) {
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        C5959c.m24926a(countDownLatch, c5974e.m25015b(new C7367k<T>(this) {
            /* renamed from: d */
            final /* synthetic */ C5969a f30305d;

            public void L_() {
                countDownLatch.countDown();
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                atomicReference2.set(th);
                countDownLatch.countDown();
            }

            /* renamed from: a */
            public void mo5000a(T t) {
                atomicReference.set(t);
            }
        }));
        if (atomicReference2.get() != null) {
            C5903b.m24788a((Throwable) atomicReference2.get());
        }
        return atomicReference.get();
    }
}
