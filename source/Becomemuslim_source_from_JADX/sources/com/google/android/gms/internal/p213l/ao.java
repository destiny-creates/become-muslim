package com.google.android.gms.internal.p213l;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.l.ao */
final class ao implements Iterator<String> {
    /* renamed from: a */
    private Iterator<String> f16900a = this.f16901b.f28969a.keySet().iterator();
    /* renamed from: b */
    private final /* synthetic */ an f16901b;

    ao(an anVar) {
        this.f16901b = anVar;
    }

    public final boolean hasNext() {
        return this.f16900a.hasNext();
    }

    public final /* synthetic */ Object next() {
        return (String) this.f16900a.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
