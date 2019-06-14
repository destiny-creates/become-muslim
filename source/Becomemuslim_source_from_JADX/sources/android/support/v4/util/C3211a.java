package android.support.v4.util;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ArrayMap */
/* renamed from: android.support.v4.util.a */
public class C3211a<K, V> extends C0463l<K, V> implements Map<K, V> {
    /* renamed from: a */
    C0459h<K, V> f8266a;

    /* compiled from: ArrayMap */
    /* renamed from: android.support.v4.util.a$1 */
    class C32101 extends C0459h<K, V> {
        /* renamed from: a */
        final /* synthetic */ C3211a f8265a;

        C32101(C3211a c3211a) {
            this.f8265a = c3211a;
        }

        /* renamed from: a */
        protected int mo303a() {
            return this.f8265a.h;
        }

        /* renamed from: a */
        protected Object mo305a(int i, int i2) {
            return this.f8265a.g[(i << 1) + i2];
        }

        /* renamed from: a */
        protected int mo304a(Object obj) {
            return this.f8265a.m1456a(obj);
        }

        /* renamed from: b */
        protected int mo309b(Object obj) {
            return this.f8265a.m1461b(obj);
        }

        /* renamed from: b */
        protected Map<K, V> mo310b() {
            return this.f8265a;
        }

        /* renamed from: a */
        protected void mo308a(K k, V v) {
            this.f8265a.put(k, v);
        }

        /* renamed from: a */
        protected V mo306a(int i, V v) {
            return this.f8265a.m1458a(i, (Object) v);
        }

        /* renamed from: a */
        protected void mo307a(int i) {
            this.f8265a.m1464d(i);
        }

        /* renamed from: c */
        protected void mo311c() {
            this.f8265a.clear();
        }
    }

    public C3211a(int i) {
        super(i);
    }

    public C3211a(C0463l c0463l) {
        super(c0463l);
    }

    /* renamed from: b */
    private C0459h<K, V> m9767b() {
        if (this.f8266a == null) {
            this.f8266a = new C32101(this);
        }
        return this.f8266a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m1459a(this.h + map.size());
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            put(entry.getKey(), entry.getValue());
        }
    }

    /* renamed from: a */
    public boolean m9768a(Collection<?> collection) {
        return C0459h.m1434c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return m9767b().m1446d();
    }

    public Set<K> keySet() {
        return m9767b().m1447e();
    }

    public Collection<V> values() {
        return m9767b().m1448f();
    }
}
