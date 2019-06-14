package com.polidea.p254a.p256b.p261e;

import com.polidea.p254a.p256b.C5615p;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: QueueSemaphore */
/* renamed from: com.polidea.a.b.e.j */
class C7066j implements C5598i {
    /* renamed from: a */
    private final AtomicBoolean f25040a = new AtomicBoolean(false);

    C7066j() {
    }

    /* renamed from: b */
    public synchronized void m32954b() {
        while (!this.f25040a.get()) {
            try {
                wait();
            } catch (Throwable e) {
                if (!this.f25040a.get()) {
                    C5615p.m23866b(e, "Queue's awaitRelease() has been interrupted abruptly while it wasn't released by the release() method.", new Object[0]);
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo5017a() {
        if (this.f25040a.compareAndSet(false, true)) {
            notify();
        }
    }
}
