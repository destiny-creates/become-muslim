package expolib_v1.p321a.p322a.p327e;

import java.util.concurrent.CountDownLatch;

/* compiled from: Ping */
/* renamed from: expolib_v1.a.a.e.l */
final class C6184l {
    /* renamed from: a */
    private final CountDownLatch f20026a = new CountDownLatch(1);
    /* renamed from: b */
    private long f20027b = -1;
    /* renamed from: c */
    private long f20028c = -1;

    C6184l() {
    }

    /* renamed from: a */
    void m25457a() {
        if (this.f20027b == -1) {
            this.f20027b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    void m25458b() {
        if (this.f20028c != -1 || this.f20027b == -1) {
            throw new IllegalStateException();
        }
        this.f20028c = System.nanoTime();
        this.f20026a.countDown();
    }

    /* renamed from: c */
    void m25459c() {
        if (this.f20028c != -1 || this.f20027b == -1) {
            throw new IllegalStateException();
        }
        this.f20028c = this.f20027b - 1;
        this.f20026a.countDown();
    }
}
