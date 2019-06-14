package com.google.android.gms.internal.p210i;

import java.util.ListIterator;

/* renamed from: com.google.android.gms.internal.i.if */
final class C5000if implements ListIterator<String> {
    /* renamed from: a */
    private ListIterator<String> f16696a = this.f16698c.f24535a.listIterator(this.f16697b);
    /* renamed from: b */
    private final /* synthetic */ int f16697b;
    /* renamed from: c */
    private final /* synthetic */ ie f16698c;

    C5000if(ie ieVar, int i) {
        this.f16698c = ieVar;
        this.f16697b = i;
    }

    public final boolean hasNext() {
        return this.f16696a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f16696a.hasPrevious();
    }

    public final int nextIndex() {
        return this.f16696a.nextIndex();
    }

    public final int previousIndex() {
        return this.f16696a.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return (String) this.f16696a.previous();
    }

    public final /* synthetic */ Object next() {
        return (String) this.f16696a.next();
    }
}
