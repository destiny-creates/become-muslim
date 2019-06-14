package com.polidea.p254a.p256b.p257a;

import com.polidea.p254a.p256b.C5577b;
import com.polidea.p254a.p256b.p257a.C5559d.C5558a;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import p289e.C5974e;
import p289e.p291b.C5915c;
import p289e.p291b.C5918f;
import p289e.p291b.C5919g;

/* compiled from: DeviceComponentCache */
/* renamed from: com.polidea.a.b.a.b */
public class C5557b implements Map<String, C5577b> {
    /* renamed from: a */
    private final HashMap<String, C5559d> f18633a;
    /* renamed from: b */
    private final C5558a f18634b;

    /* compiled from: DeviceComponentCache */
    /* renamed from: com.polidea.a.b.a.b$1 */
    class C69821 implements C5558a {
        C69821() {
        }

        /* renamed from: a */
        public C5559d mo4979a(C5577b c5577b) {
            return new C5559d(c5577b);
        }
    }

    /* compiled from: DeviceComponentCache */
    /* renamed from: com.polidea.a.b.a.b$2 */
    class C69832 implements C5918f<HashSet<Entry<String, C5577b>>> {
        /* renamed from: a */
        final /* synthetic */ C5557b f24889a;

        C69832(C5557b c5557b) {
            this.f24889a = c5557b;
        }

        public /* synthetic */ Object call() {
            return m32781a();
        }

        /* renamed from: a */
        public HashSet<Entry<String, C5577b>> m32781a() {
            return new HashSet();
        }
    }

    /* compiled from: DeviceComponentCache */
    /* renamed from: com.polidea.a.b.a.b$3 */
    class C69843 implements C5915c<HashSet<Entry<String, C5577b>>, C5556a> {
        /* renamed from: a */
        final /* synthetic */ C5557b f24890a;

        C69843(C5557b c5557b) {
            this.f24890a = c5557b;
        }

        /* renamed from: a */
        public void m32783a(HashSet<Entry<String, C5577b>> hashSet, C5556a c5556a) {
            hashSet.add(c5556a);
        }
    }

    /* compiled from: DeviceComponentCache */
    /* renamed from: com.polidea.a.b.a.b$4 */
    class C69854 implements C5919g<Entry<String, C5559d>, C5556a> {
        /* renamed from: a */
        final /* synthetic */ C5557b f24891a;

        C69854(C5557b c5557b) {
            this.f24891a = c5557b;
        }

        /* renamed from: a */
        public C5556a m32784a(Entry<String, C5559d> entry) {
            return new C5556a((String) entry.getKey(), this.f24891a.f18634b.mo4979a((C5577b) ((C5559d) entry.getValue()).get()));
        }
    }

    /* compiled from: DeviceComponentCache */
    /* renamed from: com.polidea.a.b.a.b$5 */
    class C69865 implements C5919g<Entry<String, C5559d>, Boolean> {
        /* renamed from: a */
        final /* synthetic */ C5557b f24892a;

        C69865(C5557b c5557b) {
            this.f24892a = c5557b;
        }

        /* renamed from: a */
        public Boolean m32786a(Entry<String, C5559d> entry) {
            return Boolean.valueOf(((C5559d) entry.getValue()).m23648a() ^ 1);
        }
    }

    /* compiled from: DeviceComponentCache */
    /* renamed from: com.polidea.a.b.a.b$6 */
    class C69876 implements C5919g<C5559d, C5577b> {
        /* renamed from: a */
        final /* synthetic */ C5557b f24893a;

        C69876(C5557b c5557b) {
            this.f24893a = c5557b;
        }

        /* renamed from: a */
        public C5577b m32788a(C5559d c5559d) {
            return (C5577b) c5559d.get();
        }
    }

    /* compiled from: DeviceComponentCache */
    /* renamed from: com.polidea.a.b.a.b$7 */
    class C69887 implements C5919g<C5559d, Boolean> {
        /* renamed from: a */
        final /* synthetic */ C5557b f24894a;

        C69887(C5557b c5557b) {
            this.f24894a = c5557b;
        }

        /* renamed from: a */
        public Boolean m32790a(C5559d c5559d) {
            return Boolean.valueOf(c5559d.m23648a() ^ 1);
        }
    }

    public /* synthetic */ Object get(Object obj) {
        return m23644a(obj);
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m23645a((String) obj, (C5577b) obj2);
    }

    public /* synthetic */ Object remove(Object obj) {
        return m23646b(obj);
    }

    public C5557b() {
        this(new C69821());
    }

    C5557b(C5558a c5558a) {
        this.f18633a = new HashMap();
        this.f18634b = c5558a;
    }

    public void clear() {
        this.f18633a.clear();
    }

    public boolean containsKey(Object obj) {
        return (!this.f18633a.containsKey(obj) || m23644a(obj) == null) ? null : true;
    }

    public boolean containsValue(Object obj) {
        for (C5559d a : this.f18633a.values()) {
            if (a.m23649a(obj)) {
                return true;
            }
        }
        return null;
    }

    public Set<Entry<String, C5577b>> entrySet() {
        return (Set) C5974e.m24976a(this.f18633a.entrySet()).m25013b(new C69865(this)).m25030e(new C69854(this)).m24993a(new C69832(this), new C69843(this)).m25048p().m24950a();
    }

    /* renamed from: a */
    public C5577b m23644a(Object obj) {
        C5559d c5559d = (C5559d) this.f18633a.get(obj);
        return c5559d != null ? (C5577b) c5559d.get() : null;
    }

    public boolean isEmpty() {
        m23643a();
        return this.f18633a.isEmpty();
    }

    public Set<String> keySet() {
        return this.f18633a.keySet();
    }

    /* renamed from: a */
    public C5577b m23645a(String str, C5577b c5577b) {
        this.f18633a.put(str, this.f18634b.mo4979a(c5577b));
        m23643a();
        return c5577b;
    }

    public void putAll(Map<? extends String, ? extends C5577b> map) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            m23645a((String) entry.getKey(), (C5577b) entry.getValue());
        }
    }

    /* renamed from: b */
    public C5577b m23646b(Object obj) {
        C5559d c5559d = (C5559d) this.f18633a.remove(obj);
        m23643a();
        return c5559d != null ? (C5577b) c5559d.get() : null;
    }

    public int size() {
        m23643a();
        return this.f18633a.size();
    }

    public Collection<C5577b> values() {
        return (Collection) C5974e.m24976a(this.f18633a.values()).m25013b(new C69887(this)).m25030e(new C69876(this)).m25049q().m25048p().m24950a();
    }

    /* renamed from: a */
    private void m23643a() {
        Iterator it = this.f18633a.entrySet().iterator();
        while (it.hasNext()) {
            if (((C5559d) ((Entry) it.next()).getValue()).m23648a()) {
                it.remove();
            }
        }
    }
}
