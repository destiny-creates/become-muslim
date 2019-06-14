package io.p347a.p348a.p349a.p350a.p353c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DependencyPriorityBlockingQueue */
/* renamed from: io.a.a.a.a.c.c */
public class C6458c<E extends C6457b & C6465l & C6462i> extends PriorityBlockingQueue<E> {
    /* renamed from: a */
    final Queue<E> f20853a = new LinkedList();
    /* renamed from: b */
    private final ReentrantLock f20854b = new ReentrantLock();

    public /* synthetic */ Object peek() {
        return m26479b();
    }

    public /* synthetic */ Object poll() {
        return m26481c();
    }

    public /* synthetic */ Object poll(long j, TimeUnit timeUnit) {
        return m26475a(j, timeUnit);
    }

    public /* synthetic */ Object take() {
        return m26473a();
    }

    /* renamed from: a */
    public E m26473a() {
        return m26480b(0, null, null);
    }

    /* renamed from: b */
    public E m26479b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 1;
        r1 = 0;
        r0 = r2.m26480b(r0, r1, r1);	 Catch:{ InterruptedException -> 0x0007 }
        return r0;
    L_0x0007:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.c.c.b():E");
    }

    /* renamed from: a */
    public E m26475a(long j, TimeUnit timeUnit) {
        return m26480b(3, Long.valueOf(j), timeUnit);
    }

    /* renamed from: c */
    public E m26481c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 2;
        r1 = 0;
        r0 = r2.m26480b(r0, r1, r1);	 Catch:{ InterruptedException -> 0x0007 }
        return r0;
    L_0x0007:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.c.c.c():E");
    }

    public int size() {
        try {
            this.f20854b.lock();
            int size = this.f20853a.size() + super.size();
            return size;
        } finally {
            this.f20854b.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        try {
            this.f20854b.lock();
            tArr = m26478a(super.toArray(tArr), this.f20853a.toArray(tArr));
            return tArr;
        } finally {
            this.f20854b.unlock();
        }
    }

    public Object[] toArray() {
        try {
            this.f20854b.lock();
            Object[] a = m26478a(super.toArray(), this.f20853a.toArray());
            return a;
        } finally {
            this.f20854b.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        int drainTo;
        try {
            this.f20854b.lock();
            drainTo = super.drainTo(collection) + this.f20853a.size();
            while (!this.f20853a.isEmpty()) {
                collection.add(this.f20853a.poll());
            }
            return drainTo;
        } finally {
            drainTo = this.f20854b;
            drainTo.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.f20854b.lock();
            int drainTo = super.drainTo(collection, i);
            while (!this.f20853a.isEmpty() && drainTo <= i) {
                collection.add(this.f20853a.poll());
                drainTo++;
            }
            this.f20854b.unlock();
            return drainTo;
        } catch (Throwable th) {
            this.f20854b.unlock();
        }
    }

    public boolean contains(Object obj) {
        try {
            this.f20854b.lock();
            if (!super.contains(obj)) {
                if (this.f20853a.contains(obj) == null) {
                    obj = null;
                    this.f20854b.unlock();
                    return obj;
                }
            }
            obj = true;
            this.f20854b.unlock();
            return obj;
        } catch (Throwable th) {
            this.f20854b.unlock();
        }
    }

    public void clear() {
        try {
            this.f20854b.lock();
            this.f20853a.clear();
            super.clear();
        } finally {
            this.f20854b.unlock();
        }
    }

    public boolean remove(Object obj) {
        try {
            this.f20854b.lock();
            if (!super.remove(obj)) {
                if (this.f20853a.remove(obj) == null) {
                    obj = null;
                    this.f20854b.unlock();
                    return obj;
                }
            }
            obj = true;
            this.f20854b.unlock();
            return obj;
        } catch (Throwable th) {
            this.f20854b.unlock();
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            this.f20854b.lock();
            collection = this.f20853a.removeAll(collection) | super.removeAll(collection);
            return collection;
        } finally {
            this.f20854b.unlock();
        }
    }

    /* renamed from: a */
    E m26474a(int i, Long l, TimeUnit timeUnit) {
        switch (i) {
            case 0:
                i = (C6457b) super.take();
                break;
            case 1:
                i = (C6457b) super.peek();
                break;
            case 2:
                i = (C6457b) super.poll();
                break;
            case 3:
                i = (C6457b) super.poll(l.longValue(), timeUnit);
                break;
            default:
                return null;
        }
        return i;
    }

    /* renamed from: a */
    boolean m26476a(int i, E e) {
        try {
            this.f20854b.lock();
            if (i == 1) {
                super.remove(e);
            }
            i = this.f20853a.offer(e);
            return i;
        } finally {
            this.f20854b.unlock();
        }
    }

    /* renamed from: b */
    E m26480b(int i, Long l, TimeUnit timeUnit) {
        C6457b a;
        while (true) {
            a = m26474a(i, l, timeUnit);
            if (a == null) {
                break;
            } else if (m26477a(a)) {
                break;
            } else {
                m26476a(i, a);
            }
        }
        return a;
    }

    /* renamed from: a */
    boolean m26477a(E e) {
        return e.mo5445d();
    }

    /* renamed from: d */
    public void m26482d() {
        try {
            this.f20854b.lock();
            Iterator it = this.f20853a.iterator();
            while (it.hasNext()) {
                C6457b c6457b = (C6457b) it.next();
                if (m26477a(c6457b)) {
                    super.offer(c6457b);
                    it.remove();
                }
            }
        } finally {
            this.f20854b.unlock();
        }
    }

    /* renamed from: a */
    <T> T[] m26478a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2);
        System.arraycopy(tArr, 0, objArr, 0, length);
        System.arraycopy(tArr2, 0, objArr, length, length2);
        return objArr;
    }
}
