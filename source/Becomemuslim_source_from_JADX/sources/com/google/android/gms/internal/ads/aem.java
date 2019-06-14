package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class aem extends AbstractList<String> implements acg, RandomAccess {
    /* renamed from: a */
    private final acg f23568a;

    public aem(acg acg) {
        this.f23568a = acg;
    }

    /* renamed from: a */
    public final void mo3789a(aai aai) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    public final Object mo3790b(int i) {
        return this.f23568a.mo3790b(i);
    }

    /* renamed from: d */
    public final List<?> mo3791d() {
        return this.f23568a.mo3791d();
    }

    /* renamed from: e */
    public final acg mo3792e() {
        return this;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.f23568a.get(i);
    }

    public final Iterator<String> iterator() {
        return new aeo(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new aen(this, i);
    }

    public final int size() {
        return this.f23568a.size();
    }
}
