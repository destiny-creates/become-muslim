package android.support.v4.widget;

import android.support.v4.util.C0463l;
import android.support.v4.util.Pools.C0447a;
import android.support.v4.util.Pools.SimplePool;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: DirectedAcyclicGraph */
/* renamed from: android.support.v4.widget.h */
public final class C0547h<T> {
    /* renamed from: a */
    private final C0447a<ArrayList<T>> f1385a = new SimplePool(10);
    /* renamed from: b */
    private final C0463l<T, ArrayList<T>> f1386b = new C0463l();
    /* renamed from: c */
    private final ArrayList<T> f1387c = new ArrayList();
    /* renamed from: d */
    private final HashSet<T> f1388d = new HashSet();

    /* renamed from: a */
    public void m1869a(T t) {
        if (!this.f1386b.containsKey(t)) {
            this.f1386b.put(t, null);
        }
    }

    /* renamed from: b */
    public boolean m1872b(T t) {
        return this.f1386b.containsKey(t);
    }

    /* renamed from: a */
    public void m1870a(T t, T t2) {
        if (this.f1386b.containsKey(t) && this.f1386b.containsKey(t2)) {
            ArrayList arrayList = (ArrayList) this.f1386b.get(t);
            if (arrayList == null) {
                arrayList = m1867c();
                this.f1386b.put(t, arrayList);
            }
            arrayList.add(t2);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    /* renamed from: c */
    public List m1873c(T t) {
        return (List) this.f1386b.get(t);
    }

    /* renamed from: d */
    public List<T> m1874d(T t) {
        int size = this.f1386b.size();
        List<T> list = null;
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.f1386b.m1463c(i);
            if (arrayList != null && arrayList.contains(t)) {
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(this.f1386b.m1462b(i));
            }
        }
        return list;
    }

    /* renamed from: e */
    public boolean m1875e(T t) {
        int size = this.f1386b.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.f1386b.m1463c(i);
            if (arrayList != null && arrayList.contains(t)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m1868a() {
        int size = this.f1386b.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.f1386b.m1463c(i);
            if (arrayList != null) {
                m1866a(arrayList);
            }
        }
        this.f1386b.clear();
    }

    /* renamed from: b */
    public ArrayList<T> m1871b() {
        this.f1387c.clear();
        this.f1388d.clear();
        int size = this.f1386b.size();
        for (int i = 0; i < size; i++) {
            m1865a(this.f1386b.m1462b(i), this.f1387c, this.f1388d);
        }
        return this.f1387c;
    }

    /* renamed from: a */
    private void m1865a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (hashSet.contains(t)) {
                throw new RuntimeException("This graph contains cyclic dependencies");
            }
            hashSet.add(t);
            ArrayList arrayList2 = (ArrayList) this.f1386b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    m1865a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
        }
    }

    /* renamed from: c */
    private ArrayList<T> m1867c() {
        ArrayList<T> arrayList = (ArrayList) this.f1385a.acquire();
        return arrayList == null ? new ArrayList() : arrayList;
    }

    /* renamed from: a */
    private void m1866a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f1385a.release(arrayList);
    }
}
