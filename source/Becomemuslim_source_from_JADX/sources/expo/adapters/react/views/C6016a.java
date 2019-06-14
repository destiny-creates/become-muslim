package expo.adapters.react.views;

import android.util.Log;
import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.MapBuilder.Builder;
import expo.adapters.react.C6014a;
import expo.p304a.C6007d;
import expo.p304a.C6012g;
import expo.p304a.C6012g.C6010a;
import expo.p304a.p305a.C6001h;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ViewManagerAdapterUtils */
/* renamed from: expo.adapters.react.views.a */
public class C6016a {
    /* renamed from: a */
    static String m25158a(C6012g c6012g) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ViewManagerAdapter_");
        stringBuilder.append(c6012g.getName());
        return stringBuilder.toString();
    }

    /* renamed from: b */
    static Map<String, Object> m25161b(C6012g c6012g) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("eventNames", c6012g.getExportedEventNames());
        return hashMap;
    }

    /* renamed from: c */
    static Map<String, Object> m25162c(C6012g c6012g) {
        Builder builder = MapBuilder.builder();
        for (Object next : c6012g.getExportedEventNames()) {
            if (next instanceof String) {
                builder.put((String) next, MapBuilder.of("registrationName", next));
            }
        }
        return builder.build();
    }

    /* renamed from: a */
    static <V extends View> void m25160a(String str, C6012g<V> c6012g, V v, ReadableMap readableMap) {
        StringBuilder stringBuilder;
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            try {
                C6010a c6010a = (C6010a) c6012g.getPropSetterInfos().get(nextKey);
                if (c6010a != null) {
                    c6012g.updateProp(v, nextKey, C6014a.m25157a(readableMap.getDynamic(nextKey), c6010a.m25156a()));
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("No setter found for prop ");
                    stringBuilder.append(nextKey);
                    stringBuilder.append(" in ");
                    stringBuilder.append(str);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            } catch (Exception e) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Error when setting prop ");
                stringBuilder.append(nextKey);
                stringBuilder.append(". ");
                stringBuilder.append(e.getMessage());
                Log.e(str, stringBuilder.toString());
            }
        }
    }

    /* renamed from: a */
    static void m25159a(C6012g c6012g, C6007d c6007d) {
        if (c6012g instanceof C6001h) {
            ((C6001h) c6012g).setModuleRegistry(c6007d);
        }
    }
}
