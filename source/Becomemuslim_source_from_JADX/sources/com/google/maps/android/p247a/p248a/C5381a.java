package com.google.maps.android.p247a.p248a;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BiMultiMap */
/* renamed from: com.google.maps.android.a.a.a */
public class C5381a<K> extends HashMap<K, Object> {
    /* renamed from: a */
    private final Map<Object, K> f18146a = new HashMap();

    public /* synthetic */ Object clone() {
        return m22833a();
    }

    public void putAll(Map<? extends K, ?> map) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            put(entry.getKey(), entry.getValue());
        }
    }

    public Object put(K k, Object obj) {
        this.f18146a.put(obj, k);
        return super.put(k, obj);
    }

    public Object remove(Object obj) {
        obj = super.remove(obj);
        if (obj instanceof Collection) {
            for (Object remove : (Collection) obj) {
                this.f18146a.remove(remove);
            }
        } else {
            this.f18146a.remove(obj);
        }
        return obj;
    }

    public void clear() {
        super.clear();
        this.f18146a.clear();
    }

    /* renamed from: a */
    public C5381a<K> m22833a() {
        C5381a<K> c5381a = new C5381a();
        c5381a.putAll((Map) super.clone());
        return c5381a;
    }
}
