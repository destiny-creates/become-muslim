package com.polidea.p254a.p256b.p261e;

import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

/* compiled from: OperationPriorityFifoBlockingQueue */
/* renamed from: com.polidea.a.b.e.h */
class C5597h {
    /* renamed from: a */
    private final PriorityBlockingQueue<C5596g> f18720a = new PriorityBlockingQueue();

    C5597h() {
    }

    /* renamed from: a */
    public void m23804a(C5596g c5596g) {
        this.f18720a.add(c5596g);
    }

    /* renamed from: a */
    public C5596g<?> m23803a() {
        return (C5596g) this.f18720a.take();
    }

    /* renamed from: b */
    public C5596g<?> m23805b() {
        return (C5596g) this.f18720a.poll();
    }

    /* renamed from: c */
    public boolean m23807c() {
        return this.f18720a.isEmpty();
    }

    /* renamed from: b */
    public boolean m23806b(C5596g c5596g) {
        Iterator it = this.f18720a.iterator();
        while (it.hasNext()) {
            C5596g c5596g2 = (C5596g) it.next();
            if (c5596g2 == c5596g) {
                return this.f18720a.remove(c5596g2);
            }
        }
        return null;
    }
}
