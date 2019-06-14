package org.apache.p378b.p379a.p381c;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: DefaultThreadContextStack */
/* renamed from: org.apache.b.a.c.c */
public class C8193c implements C7688k {
    /* renamed from: a */
    private static final ThreadLocal<C8194g> f30414a = new ThreadLocal();
    private static final long serialVersionUID = 5050501;
    /* renamed from: b */
    private final boolean f30415b;

    public /* synthetic */ boolean add(Object obj) {
        return m39790a((String) obj);
    }

    public C8193c(boolean z) {
        this.f30415b = z;
    }

    /* renamed from: b */
    private C8194g m39788b() {
        C8194g c8194g = (C8194g) f30414a.get();
        return c8194g == null ? new C8194g() : c8194g.m39794b();
    }

    /* renamed from: a */
    public boolean m39790a(String str) {
        if (!this.f30415b) {
            return null;
        }
        C8194g b = m39788b();
        b.m39793a(str);
        b.m39795c();
        f30414a.set(b);
        return true;
    }

    public boolean addAll(Collection<? extends String> collection) {
        if (this.f30415b) {
            if (!collection.isEmpty()) {
                C8194g b = m39788b();
                b.addAll(collection);
                b.m39795c();
                f30414a.set(b);
                return true;
            }
        }
        return null;
    }

    /* renamed from: a */
    public List<String> mo6436a() {
        C8194g c8194g = (C8194g) f30414a.get();
        if (c8194g == null) {
            return Collections.emptyList();
        }
        return c8194g.mo6436a();
    }

    public void clear() {
        f30414a.remove();
    }

    public boolean contains(Object obj) {
        C8194g c8194g = (C8194g) f30414a.get();
        return (c8194g == null || c8194g.contains(obj) == null) ? null : true;
    }

    public boolean containsAll(Collection<?> collection) {
        boolean z = true;
        if (collection.isEmpty()) {
            return true;
        }
        C8194g c8194g = (C8194g) f30414a.get();
        if (c8194g == null || c8194g.containsAll(collection) == null) {
            z = false;
        }
        return z;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof C8193c) {
            if (this.f30415b != ((C8193c) obj).f30415b) {
                return false;
            }
        }
        if (!(obj instanceof C7688k)) {
            return false;
        }
        C7688k c7688k = (C7688k) obj;
        C8194g c8194g = (C8194g) f30414a.get();
        if (c8194g != null) {
            return c8194g.equals(c7688k);
        }
        if (c7688k != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i;
        C8194g c8194g = (C8194g) f30414a.get();
        if (c8194g == null) {
            i = 0;
        } else {
            i = c8194g.hashCode();
        }
        return 31 + i;
    }

    public boolean isEmpty() {
        C8194g c8194g = (C8194g) f30414a.get();
        if (c8194g != null) {
            if (!c8194g.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public Iterator<String> iterator() {
        C8194g c8194g = (C8194g) f30414a.get();
        if (c8194g == null) {
            return Collections.emptyList().iterator();
        }
        return c8194g.iterator();
    }

    public boolean remove(Object obj) {
        if (!this.f30415b) {
            return false;
        }
        C8194g c8194g = (C8194g) f30414a.get();
        if (c8194g != null) {
            if (c8194g.size() != 0) {
                c8194g = (C8194g) c8194g.m39794b();
                obj = c8194g.remove(obj);
                c8194g.m39795c();
                f30414a.set(c8194g);
                return obj;
            }
        }
        return false;
    }

    public boolean removeAll(Collection<?> collection) {
        if (this.f30415b) {
            if (!collection.isEmpty()) {
                C8194g c8194g = (C8194g) f30414a.get();
                if (c8194g != null) {
                    if (!c8194g.isEmpty()) {
                        c8194g = (C8194g) c8194g.m39794b();
                        collection = c8194g.removeAll(collection);
                        c8194g.m39795c();
                        f30414a.set(c8194g);
                        return collection;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public boolean retainAll(Collection<?> collection) {
        if (this.f30415b) {
            if (!collection.isEmpty()) {
                C8194g c8194g = (C8194g) f30414a.get();
                if (c8194g != null) {
                    if (!c8194g.isEmpty()) {
                        c8194g = (C8194g) c8194g.m39794b();
                        collection = c8194g.retainAll(collection);
                        c8194g.m39795c();
                        f30414a.set(c8194g);
                        return collection;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public int size() {
        C8194g c8194g = (C8194g) f30414a.get();
        if (c8194g == null) {
            return 0;
        }
        return c8194g.size();
    }

    public Object[] toArray() {
        C8194g c8194g = (C8194g) f30414a.get();
        if (c8194g == null) {
            return new String[0];
        }
        return c8194g.toArray(new Object[c8194g.size()]);
    }

    public <T> T[] toArray(T[] tArr) {
        C8194g c8194g = (C8194g) f30414a.get();
        if (c8194g != null) {
            return c8194g.toArray(tArr);
        }
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    public String toString() {
        C8194g c8194g = (C8194g) f30414a.get();
        if (c8194g == null) {
            return "[]";
        }
        return c8194g.toString();
    }
}
