package com.google.android.gms.internal.ads;

import java.util.ListIterator;

final class aen implements ListIterator<String> {
    /* renamed from: a */
    private ListIterator<String> f14343a = this.f14345c.f23568a.listIterator(this.f14344b);
    /* renamed from: b */
    private final /* synthetic */ int f14344b;
    /* renamed from: c */
    private final /* synthetic */ aem f14345c;

    aen(aem aem, int i) {
        this.f14345c = aem;
        this.f14344b = i;
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.f14343a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f14343a.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return (String) this.f14343a.next();
    }

    public final int nextIndex() {
        return this.f14343a.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return (String) this.f14343a.previous();
    }

    public final int previousIndex() {
        return this.f14343a.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
