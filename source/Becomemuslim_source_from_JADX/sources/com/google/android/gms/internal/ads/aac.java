package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class aac<E> extends AbstractList<E> implements abv<E> {
    /* renamed from: a */
    private boolean f23517a = true;

    aac() {
    }

    /* renamed from: a */
    public boolean mo3614a() {
        return this.f23517a;
    }

    public void add(int i, E e) {
        m29505c();
        super.add(i, e);
    }

    public boolean add(E e) {
        m29505c();
        return super.add(e);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        m29505c();
        return super.addAll(i, collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        m29505c();
        return super.addAll(collection);
    }

    /* renamed from: b */
    public final void mo3615b() {
        this.f23517a = false;
    }

    /* renamed from: c */
    protected final void m29505c() {
        if (!this.f23517a) {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        m29505c();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < size(); i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public E remove(int i) {
        m29505c();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        m29505c();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        m29505c();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        m29505c();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        m29505c();
        return super.set(i, e);
    }
}
