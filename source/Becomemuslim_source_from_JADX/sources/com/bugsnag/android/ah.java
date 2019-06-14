package com.bugsnag.android;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ObjectJsonStreamer */
class ah {
    /* renamed from: a */
    String[] f3014a = new String[]{"password"};

    ah() {
    }

    /* renamed from: a */
    void m3739a(Object obj, ab abVar) {
        if (obj == null) {
            abVar.mo765a();
        } else if (obj instanceof String) {
            abVar.mo771b((String) obj);
        } else if (obj instanceof Number) {
            abVar.mo768a((Number) obj);
        } else if (obj instanceof Boolean) {
            abVar.mo767a((Boolean) obj);
        } else if (obj instanceof Map) {
            abVar.mo772c();
            for (Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    String str = (String) key;
                    abVar.mo764a(str);
                    if (m3738a(str)) {
                        abVar.mo771b("[FILTERED]");
                    } else {
                        m3739a(entry.getValue(), abVar);
                    }
                }
            }
            abVar.mo770b();
        } else if (obj instanceof Collection) {
            abVar.mo776e();
            for (Object a : (Collection) obj) {
                m3739a(a, abVar);
            }
            abVar.mo775d();
        } else if (obj.getClass().isArray()) {
            abVar.mo776e();
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                m3739a(Array.get(obj, i), abVar);
            }
            abVar.mo775d();
        } else {
            abVar.mo771b("[OBJECT]");
        }
    }

    /* renamed from: a */
    private boolean m3738a(String str) {
        if (this.f3014a != null) {
            if (str != null) {
                for (CharSequence contains : this.f3014a) {
                    if (str.contains(contains)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
