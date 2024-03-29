package com.google.android.gms.internal.p210i;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.i.du */
abstract class du<E> extends AbstractList<E> implements fr<E> {
    /* renamed from: a */
    private boolean f24468a = true;

    du() {
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

    public boolean add(E e) {
        m31336c();
        return super.add(e);
    }

    public void add(int i, E e) {
        m31336c();
        super.add(i, e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        m31336c();
        return super.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        m31336c();
        return super.addAll(i, collection);
    }

    public void clear() {
        m31336c();
        super.clear();
    }

    /* renamed from: a */
    public boolean mo4429a() {
        return this.f24468a;
    }

    /* renamed from: b */
    public final void mo4430b() {
        this.f24468a = false;
    }

    public E remove(int i) {
        m31336c();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        m31336c();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        m31336c();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        m31336c();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        m31336c();
        return super.set(i, e);
    }

    /* renamed from: c */
    protected final void m31336c() {
        if (!this.f24468a) {
            throw new UnsupportedOperationException();
        }
    }
}
