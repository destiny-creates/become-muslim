package okhttp3.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.Headers;

public final class JavaNetHeaders {
    private static final Comparator<String> FIELD_NAME_COMPARATOR = new C66171();

    /* renamed from: okhttp3.internal.JavaNetHeaders$1 */
    class C66171 implements Comparator<String> {
        C66171() {
        }

        public int compare(String str, String str2) {
            if (str == str2) {
                return null;
            }
            if (str == null) {
                return -1;
            }
            return str2 == null ? 1 : String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    }

    private JavaNetHeaders() {
    }

    public static Map<String, List<String>> toMultimap(Headers headers, String str) {
        Map treeMap = new TreeMap(FIELD_NAME_COMPARATOR);
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            List arrayList = new ArrayList();
            List list = (List) treeMap.get(name);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(value);
            treeMap.put(name, Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str)));
        }
        return Collections.unmodifiableMap(treeMap);
    }
}
