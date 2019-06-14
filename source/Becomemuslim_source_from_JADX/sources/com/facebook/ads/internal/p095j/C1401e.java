package com.facebook.ads.internal.p095j;

import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.facebook.ads.internal.j.e */
public class C1401e<T extends C1402f, E extends C1400d> {
    /* renamed from: a */
    private final Map<Class<E>, List<WeakReference<T>>> f4092a = new HashMap();
    /* renamed from: b */
    private final Queue<E> f4093b = new ArrayDeque();

    /* renamed from: a */
    private void m4801a(List<WeakReference<T>> list) {
        if (list != null) {
            int i;
            int i2 = 0;
            for (i = 0; i < list.size(); i++) {
                WeakReference weakReference = (WeakReference) list.get(i);
                if (weakReference.get() != null) {
                    int i3 = i2 + 1;
                    list.set(i2, weakReference);
                    i2 = i3;
                }
            }
            for (i = list.size() - 1; i >= i2; i--) {
                list.remove(i);
            }
        }
    }

    /* renamed from: b */
    private void m4802b(E e) {
        if (this.f4092a != null) {
            List list = (List) this.f4092a.get(e.getClass());
            if (list != null) {
                m4801a(list);
                if (!list.isEmpty()) {
                    for (WeakReference weakReference : new ArrayList(list)) {
                        C1402f c1402f = (C1402f) weakReference.get();
                        if (c1402f != null && c1402f.m4810b(e)) {
                            c1402f.mo931a(e);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized void m4803a(E e) {
        if (this.f4093b.isEmpty()) {
            this.f4093b.add(e);
            while (!this.f4093b.isEmpty()) {
                m4802b((C1400d) this.f4093b.peek());
                this.f4093b.remove();
            }
        } else {
            this.f4093b.add(e);
        }
    }

    /* renamed from: a */
    public synchronized void m4804a(T... tArr) {
        if (tArr != null) {
            for (C1402f a : tArr) {
                m4805a(a);
            }
        }
    }

    /* renamed from: a */
    public synchronized boolean m4805a(T t) {
        if (t == null) {
            return false;
        }
        Class a = t.mo930a();
        if (this.f4092a.get(a) == null) {
            this.f4092a.put(a, new ArrayList());
        }
        List list = (List) this.f4092a.get(a);
        m4801a(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((WeakReference) list.get(i)).get() == t) {
                return false;
            }
        }
        return list.add(new WeakReference(t));
    }

    /* renamed from: b */
    public synchronized void m4806b(T... tArr) {
        if (tArr != null) {
            for (C1402f b : tArr) {
                m4807b(b);
            }
        }
    }

    /* renamed from: b */
    public synchronized boolean m4807b(T t) {
        if (t == null) {
            return false;
        }
        List list = (List) this.f4092a.get(t.mo930a());
        if (list == null) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((WeakReference) list.get(i)).get() == t) {
                ((WeakReference) list.get(i)).clear();
                return true;
            }
        }
        return false;
    }
}
