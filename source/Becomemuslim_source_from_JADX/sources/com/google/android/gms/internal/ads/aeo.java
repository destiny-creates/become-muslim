package com.google.android.gms.internal.ads;

import java.util.Iterator;

final class aeo implements Iterator<String> {
    /* renamed from: a */
    private Iterator<String> f14346a = this.f14347b.f23568a.iterator();
    /* renamed from: b */
    private final /* synthetic */ aem f14347b;

    aeo(aem aem) {
        this.f14347b = aem;
    }

    public final boolean hasNext() {
        return this.f14346a.hasNext();
    }

    public final /* synthetic */ Object next() {
        return (String) this.f14346a.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
