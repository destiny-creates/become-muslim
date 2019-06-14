package p289e.p292c.p295e.p296a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p289e.p292c.p295e.p297b.C5958h;

/* compiled from: SpscExactAtomicArrayQueue */
/* renamed from: e.c.e.a.e */
public final class C5953e<T> extends AtomicReferenceArray<T> implements Queue<T> {
    private static final long serialVersionUID = 6210984603741293445L;
    /* renamed from: a */
    final int f19683a;
    /* renamed from: b */
    final int f19684b;
    /* renamed from: c */
    final AtomicLong f19685c = new AtomicLong();
    /* renamed from: d */
    final AtomicLong f19686d = new AtomicLong();

    public C5953e(int i) {
        super(C5958h.m24924a(i));
        int length = length();
        this.f19683a = length - 1;
        this.f19684b = length - i;
    }

    public boolean offer(T t) {
        if (t != null) {
            long j = this.f19685c.get();
            int i = this.f19683a;
            if (get(((int) (((long) this.f19684b) + j)) & i) != null) {
                return null;
            }
            i &= (int) j;
            this.f19685c.lazySet(j + 1);
            lazySet(i, t);
            return true;
        }
        throw new NullPointerException();
    }

    public T poll() {
        long j = this.f19686d.get();
        int i = ((int) j) & this.f19683a;
        T t = get(i);
        if (t == null) {
            return null;
        }
        this.f19686d.lazySet(j + 1);
        lazySet(i, null);
        return t;
    }

    public T peek() {
        return get(((int) this.f19686d.get()) & this.f19683a);
    }

    public void clear() {
        while (true) {
            if (poll() == null) {
                if (isEmpty()) {
                    return;
                }
            }
        }
    }

    public boolean isEmpty() {
        return this.f19685c == this.f19686d;
    }

    public int size() {
        long j = this.f19686d.get();
        while (true) {
            long j2 = this.f19685c.get();
            long j3 = this.f19686d.get();
            if (j == j3) {
                return (int) (j2 - j3);
            }
            j = j3;
        }
    }

    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    public T remove() {
        throw new UnsupportedOperationException();
    }

    public T element() {
        throw new UnsupportedOperationException();
    }
}
