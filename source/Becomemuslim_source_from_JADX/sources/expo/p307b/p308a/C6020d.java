package expo.p307b.p308a;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BarCodeScannerSettings */
/* renamed from: expo.b.a.d */
public class C6020d extends HashMap<C6021e, Object> {
    public C6020d(Map<String, Object> map) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            C6021e a = C6021e.m25165a((String) entry.getKey());
            if (a != null) {
                put(a, entry.getValue());
            }
        }
    }

    public void putTypes(Object obj) {
        put(C6021e.TYPES, obj);
    }

    public Object getTypes() {
        return get(C6021e.TYPES);
    }
}
