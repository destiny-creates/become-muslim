package com.polidea.p254a.p256b.p261e;

import com.polidea.p254a.p256b.p259c.C5578j;
import java.util.concurrent.atomic.AtomicLong;
import p289e.C5986h;
import p289e.C5989l;
import p289e.C7332c;

/* compiled from: FIFORunnableEntry */
/* renamed from: com.polidea.a.b.e.g */
class C5596g<T> implements Comparable<C5596g> {
    /* renamed from: c */
    private static final AtomicLong f18716c = new AtomicLong(0);
    /* renamed from: a */
    final C5578j<T> f18717a;
    /* renamed from: b */
    final C7332c<T> f18718b;
    /* renamed from: d */
    private final long f18719d = f18716c.getAndIncrement();

    public /* synthetic */ int compareTo(Object obj) {
        return m23801a((C5596g) obj);
    }

    C5596g(C5578j<T> c5578j, C7332c<T> c7332c) {
        this.f18717a = c5578j;
        this.f18718b = c7332c;
    }

    /* renamed from: a */
    public int m23801a(C5596g c5596g) {
        int compareTo = this.f18717a.compareTo(c5596g.f18717a);
        if (compareTo != 0 || c5596g.f18717a == this.f18717a) {
            return compareTo;
        }
        return this.f18719d < c5596g.f18719d ? -1 : 1;
    }

    /* renamed from: a */
    public C5989l m23802a(C7066j c7066j, C5986h c5986h) {
        return this.f18717a.mo5022a(c7066j).m25014b(c5986h).m25020c(c5986h).m25006a(this.f18718b);
    }
}
