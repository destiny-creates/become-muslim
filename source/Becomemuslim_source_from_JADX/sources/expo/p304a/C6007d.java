package expo.p304a;

import expo.p304a.p305a.C5998e;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.C6003j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ModuleRegistry */
/* renamed from: expo.a.d */
public class C6007d {
    /* renamed from: a */
    private volatile boolean f19789a = false;
    /* renamed from: b */
    private final Map<Class, C5998e> f19790b = new HashMap();
    /* renamed from: c */
    private final Map<String, C6012g> f19791c = new HashMap();
    /* renamed from: d */
    private final Map<String, C6006c> f19792d = new HashMap();
    /* renamed from: e */
    private final Map<Class, C6006c> f19793e = new HashMap();
    /* renamed from: f */
    private final Map<String, C6003j> f19794f = new HashMap();
    /* renamed from: g */
    private List<WeakReference<C6001h>> f19795g = new ArrayList();

    public C6007d(Collection<C5998e> collection, Collection<C6006c> collection2, Collection<C6012g> collection3, Collection<C6003j> collection4) {
        for (C5998e a : collection) {
            m25136a(a);
        }
        for (C6006c a2 : collection2) {
            m25139a(a2);
        }
        for (C6012g a3 : collection3) {
            m25140a(a3);
        }
        for (C6003j a4 : collection4) {
            m25138a(a4);
        }
    }

    /* renamed from: a */
    public <T> T m25133a(Class<T> cls) {
        return this.f19790b.get(cls);
    }

    /* renamed from: a */
    public C6006c m25132a(String str) {
        return (C6006c) this.f19792d.get(str);
    }

    /* renamed from: b */
    public C6006c m25141b(Class cls) {
        return (C6006c) this.f19793e.get(cls);
    }

    /* renamed from: a */
    public Collection<C6012g> m25135a() {
        return this.f19791c.values();
    }

    /* renamed from: b */
    public Collection<C6006c> m25142b() {
        return this.f19792d.values();
    }

    /* renamed from: a */
    public <T> T m25134a(String str, Class<T> cls) {
        return this.f19794f.get(str);
    }

    /* renamed from: a */
    public void m25136a(C5998e c5998e) {
        for (Class put : c5998e.getExportedInterfaces()) {
            this.f19790b.put(put, c5998e);
            m25131a((Object) c5998e);
        }
    }

    /* renamed from: a */
    public void m25139a(C6006c c6006c) {
        this.f19792d.put(c6006c.getName(), c6006c);
        this.f19793e.put(c6006c.getClass(), c6006c);
        m25131a((Object) c6006c);
    }

    /* renamed from: a */
    public void m25140a(C6012g c6012g) {
        this.f19791c.put(c6012g.getName(), c6012g);
        m25131a((Object) c6012g);
    }

    /* renamed from: a */
    public void m25138a(C6003j c6003j) {
        this.f19794f.put(c6003j.getName(), c6003j);
    }

    /* renamed from: a */
    public void m25137a(C6001h c6001h) {
        this.f19795g.add(new WeakReference(c6001h));
    }

    /* renamed from: a */
    private void m25131a(Object obj) {
        if (obj instanceof C6001h) {
            m25137a((C6001h) obj);
        }
    }

    /* renamed from: c */
    public synchronized void m25143c() {
        if (!this.f19789a) {
            m25144d();
            this.f19789a = true;
        }
    }

    /* renamed from: d */
    public void m25144d() {
        Collection arrayList = new ArrayList();
        for (WeakReference weakReference : this.f19795g) {
            C6001h c6001h = (C6001h) weakReference.get();
            if (c6001h != null) {
                c6001h.setModuleRegistry(this);
            } else {
                arrayList.add(weakReference);
            }
        }
        this.f19795g.removeAll(arrayList);
    }
}
