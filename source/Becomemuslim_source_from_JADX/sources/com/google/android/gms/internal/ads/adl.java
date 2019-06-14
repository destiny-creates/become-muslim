package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

final class adl<E> extends aac<E> {
    /* renamed from: a */
    private static final adl<Object> f28033a;
    /* renamed from: b */
    private final List<E> f28034b;

    static {
        aac adl = new adl();
        f28033a = adl;
        adl.mo3615b();
    }

    adl() {
        this(new ArrayList(10));
    }

    private adl(List<E> list) {
        this.f28034b = list;
    }

    /* renamed from: d */
    public static <E> adl<E> m36738d() {
        return f28033a;
    }

    /* renamed from: a */
    public final /* synthetic */ abv mo6027a(int i) {
        if (i >= size()) {
            List arrayList = new ArrayList(i);
            arrayList.addAll(this.f28034b);
            return new adl(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final void add(int i, E e) {
        m29505c();
        this.f28034b.add(i, e);
        this.modCount++;
    }

    public final E get(int i) {
        return this.f28034b.get(i);
    }

    public final E remove(int i) {
        m29505c();
        E remove = this.f28034b.remove(i);
        this.modCount++;
        return remove;
    }

    public final E set(int i, E e) {
        m29505c();
        E e2 = this.f28034b.set(i, e);
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.f28034b.size();
    }
}
