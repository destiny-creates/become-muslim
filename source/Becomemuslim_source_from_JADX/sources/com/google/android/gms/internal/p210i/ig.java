package com.google.android.gms.internal.p210i;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.i.ig */
final class ig implements Iterator<String> {
    /* renamed from: a */
    private Iterator<String> f16699a = this.f16700b.f24535a.iterator();
    /* renamed from: b */
    private final /* synthetic */ ie f16700b;

    ig(ie ieVar) {
        this.f16700b = ieVar;
    }

    public final boolean hasNext() {
        return this.f16699a.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return (String) this.f16699a.next();
    }
}
