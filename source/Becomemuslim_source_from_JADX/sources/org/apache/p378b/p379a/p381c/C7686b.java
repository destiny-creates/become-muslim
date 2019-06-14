package org.apache.p378b.p379a.p381c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.p378b.p379a.p383e.C6666b;

/* compiled from: DefaultThreadContextMap */
/* renamed from: org.apache.b.a.c.b */
public class C7686b implements C6656j {
    /* renamed from: a */
    private final boolean f26441a;
    /* renamed from: b */
    private final ThreadLocal<Map<String, String>> f26442b;

    public C7686b(boolean z) {
        this.f26441a = z;
        this.f26442b = C7686b.m34574a(z);
    }

    /* renamed from: a */
    static ThreadLocal<Map<String, String>> m34574a(final boolean z) {
        if (C6666b.m27118a().m27123b("isThreadContextMapInheritable")) {
            return new InheritableThreadLocal<Map<String, String>>() {
                protected /* synthetic */ Object childValue(Object obj) {
                    return m27078a((Map) obj);
                }

                /* renamed from: a */
                protected Map<String, String> m27078a(Map<String, String> map) {
                    return (map == null || !z) ? null : Collections.unmodifiableMap(new HashMap(map));
                }
            };
        }
        return new ThreadLocal();
    }

    /* renamed from: a */
    public Map<String, String> mo5704a() {
        Map map = (Map) this.f26442b.get();
        return map == null ? new HashMap() : new HashMap(map);
    }

    /* renamed from: b */
    public Map<String, String> mo5705b() {
        return (Map) this.f26442b.get();
    }

    public String toString() {
        Map map = (Map) this.f26442b.get();
        if (map == null) {
            return "{}";
        }
        return map.toString();
    }

    public int hashCode() {
        int i;
        Map map = (Map) this.f26442b.get();
        if (map == null) {
            i = 0;
        } else {
            i = map.hashCode();
        }
        return ((i + 31) * 31) + (this.f26441a ? 1231 : 1237);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof C7686b) {
            if (this.f26441a != ((C7686b) obj).f26441a) {
                return false;
            }
        }
        if (!(obj instanceof C6656j)) {
            return false;
        }
        Map map = (Map) this.f26442b.get();
        obj = ((C6656j) obj).mo5705b();
        if (map == null) {
            if (obj != null) {
                return false;
            }
        } else if (map.equals(obj) == null) {
            return false;
        }
        return true;
    }
}
