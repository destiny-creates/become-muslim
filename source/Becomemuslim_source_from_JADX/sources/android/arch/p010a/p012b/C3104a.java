package android.arch.p010a.p012b;

import android.arch.p010a.p012b.C0064b.C0062c;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: FastSafeIterableMap */
/* renamed from: android.arch.a.b.a */
public class C3104a<K, V> extends C0064b<K, V> {
    /* renamed from: a */
    private HashMap<K, C0062c<K, V>> f7926a = new HashMap();

    /* renamed from: a */
    protected C0062c<K, V> mo18a(K k) {
        return (C0062c) this.f7926a.get(k);
    }

    /* renamed from: a */
    public V mo19a(K k, V v) {
        C0062c a = mo18a(k);
        if (a != null) {
            return a.f170b;
        }
        this.f7926a.put(k, m141b(k, v));
        return null;
    }

    /* renamed from: b */
    public V mo20b(K k) {
        V b = super.mo20b(k);
        this.f7926a.remove(k);
        return b;
    }

    /* renamed from: c */
    public boolean m9106c(K k) {
        return this.f7926a.containsKey(k);
    }

    /* renamed from: d */
    public Entry<K, V> m9107d(K k) {
        return m9106c(k) ? ((C0062c) this.f7926a.get(k)).f172d : null;
    }
}
