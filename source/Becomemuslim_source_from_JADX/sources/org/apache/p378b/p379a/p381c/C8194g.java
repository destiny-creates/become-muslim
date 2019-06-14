package org.apache.p378b.p379a.p381c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: MutableThreadContextStack */
/* renamed from: org.apache.b.a.c.g */
public class C8194g implements C7688k {
    private static final long serialVersionUID = 50505011;
    /* renamed from: a */
    private final List<String> f30416a;
    /* renamed from: b */
    private boolean f30417b;

    public /* synthetic */ boolean add(Object obj) {
        return m39793a((String) obj);
    }

    public C8194g() {
        this(new ArrayList());
    }

    public C8194g(List<String> list) {
        this.f30416a = new ArrayList(list);
    }

    private C8194g(C8194g c8194g) {
        this.f30416a = new ArrayList(c8194g.f30416a);
    }

    /* renamed from: d */
    private void m39791d() {
        if (this.f30417b) {
            throw new UnsupportedOperationException("context stack has been frozen");
        }
    }

    /* renamed from: a */
    public List<String> mo6436a() {
        return this.f30416a;
    }

    /* renamed from: b */
    public C7688k m39794b() {
        return new C8194g(this);
    }

    public void clear() {
        m39791d();
        this.f30416a.clear();
    }

    public int size() {
        return this.f30416a.size();
    }

    public boolean isEmpty() {
        return this.f30416a.isEmpty();
    }

    public boolean contains(Object obj) {
        return this.f30416a.contains(obj);
    }

    public Iterator<String> iterator() {
        return this.f30416a.iterator();
    }

    public Object[] toArray() {
        return this.f30416a.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f30416a.toArray(tArr);
    }

    /* renamed from: a */
    public boolean m39793a(String str) {
        m39791d();
        return this.f30416a.add(str);
    }

    public boolean remove(Object obj) {
        m39791d();
        return this.f30416a.remove(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.f30416a.containsAll(collection);
    }

    public boolean addAll(Collection<? extends String> collection) {
        m39791d();
        return this.f30416a.addAll(collection);
    }

    public boolean removeAll(Collection<?> collection) {
        m39791d();
        return this.f30416a.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        m39791d();
        return this.f30416a.retainAll(collection);
    }

    public String toString() {
        return String.valueOf(this.f30416a);
    }

    public int hashCode() {
        return 31 + (this.f30416a == null ? 0 : this.f30416a.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C7688k)) {
            return false;
        }
        obj = ((C7688k) obj).mo6436a();
        if (this.f30416a == null) {
            if (obj != null) {
                return false;
            }
        } else if (this.f30416a.equals(obj) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public void m39795c() {
        this.f30417b = true;
    }
}
