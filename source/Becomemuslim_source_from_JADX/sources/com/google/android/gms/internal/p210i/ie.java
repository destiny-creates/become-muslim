package com.google.android.gms.internal.p210i;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.i.ie */
public final class ie extends AbstractList<String> implements gb, RandomAccess {
    /* renamed from: a */
    private final gb f24535a;

    public ie(gb gbVar) {
        this.f24535a = gbVar;
    }

    /* renamed from: e */
    public final gb mo4606e() {
        return this;
    }

    /* renamed from: b */
    public final Object mo4604b(int i) {
        return this.f24535a.mo4604b(i);
    }

    public final int size() {
        return this.f24535a.size();
    }

    /* renamed from: a */
    public final void mo4603a(dy dyVar) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new C5000if(this, i);
    }

    public final Iterator<String> iterator() {
        return new ig(this);
    }

    /* renamed from: d */
    public final List<?> mo4605d() {
        return this.f24535a.mo4605d();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.f24535a.get(i);
    }
}
