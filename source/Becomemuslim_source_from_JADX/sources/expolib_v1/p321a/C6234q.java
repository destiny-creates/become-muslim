package expolib_v1.p321a;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import expolib_v1.p321a.p322a.C6165c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: Headers */
/* renamed from: expolib_v1.a.q */
public final class C6234q {
    /* renamed from: a */
    private final String[] f20294a;

    /* compiled from: Headers */
    /* renamed from: expolib_v1.a.q$a */
    public static final class C6233a {
        /* renamed from: a */
        final List<String> f20293a = new ArrayList(20);

        /* renamed from: a */
        C6233a m25707a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return m25711b(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return m25711b("", str.substring(1));
            }
            return m25711b("", str);
        }

        /* renamed from: a */
        public C6233a m25708a(String str, String str2) {
            m25706d(str, str2);
            return m25711b(str, str2);
        }

        /* renamed from: b */
        C6233a m25711b(String str, String str2) {
            this.f20293a.add(str);
            this.f20293a.add(str2.trim());
            return this;
        }

        /* renamed from: b */
        public C6233a m25710b(String str) {
            int i = 0;
            while (i < this.f20293a.size()) {
                if (str.equalsIgnoreCase((String) this.f20293a.get(i))) {
                    this.f20293a.remove(i);
                    this.f20293a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* renamed from: c */
        public C6233a m25712c(String str, String str2) {
            m25706d(str, str2);
            m25710b(str);
            m25711b(str, str2);
            return this;
        }

        /* renamed from: d */
        private void m25706d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            } else {
                int i;
                char charAt;
                int length = str.length();
                for (i = 0; i < length; i++) {
                    charAt = str.charAt(i);
                    if (charAt <= ' ' || charAt >= '') {
                        throw new IllegalArgumentException(C6165c.m25308a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                if (str2 != null) {
                    length = str2.length();
                    i = 0;
                    while (i < length) {
                        charAt = str2.charAt(i);
                        if ((charAt > '\u001f' || charAt == '\t') && charAt < '') {
                            i++;
                        } else {
                            throw new IllegalArgumentException(C6165c.m25308a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str, str2));
                        }
                    }
                    return;
                }
                throw new NullPointerException("value == null");
            }
        }

        /* renamed from: c */
        public String m25713c(String str) {
            for (int size = this.f20293a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase((String) this.f20293a.get(size))) {
                    return (String) this.f20293a.get(size + 1);
                }
            }
            return null;
        }

        /* renamed from: a */
        public C6234q m25709a() {
            return new C6234q(this);
        }
    }

    C6234q(C6233a c6233a) {
        this.f20294a = (String[]) c6233a.f20293a.toArray(new String[c6233a.f20293a.size()]);
    }

    private C6234q(String[] strArr) {
        this.f20294a = strArr;
    }

    /* renamed from: a */
    public String m25718a(String str) {
        return C6234q.m25715a(this.f20294a, str);
    }

    /* renamed from: a */
    public int m25716a() {
        return this.f20294a.length / 2;
    }

    /* renamed from: a */
    public String m25717a(int i) {
        return this.f20294a[i * 2];
    }

    /* renamed from: b */
    public String m25720b(int i) {
        return this.f20294a[(i * 2) + 1];
    }

    /* renamed from: b */
    public List<String> m25721b(String str) {
        int a = m25716a();
        List list = null;
        for (int i = 0; i < a; i++) {
            if (str.equalsIgnoreCase(m25717a(i))) {
                if (list == null) {
                    list = new ArrayList(2);
                }
                list.add(m25720b(i));
            }
        }
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    /* renamed from: b */
    public C6233a m25719b() {
        C6233a c6233a = new C6233a();
        Collections.addAll(c6233a.f20293a, this.f20294a);
        return c6233a;
    }

    public boolean equals(Object obj) {
        return (!(obj instanceof C6234q) || Arrays.equals(((C6234q) obj).f20294a, this.f20294a) == null) ? null : true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f20294a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int a = m25716a();
        for (int i = 0; i < a; i++) {
            stringBuilder.append(m25717a(i));
            stringBuilder.append(": ");
            stringBuilder.append(m25720b(i));
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        }
        return stringBuilder.toString();
    }

    /* renamed from: c */
    public Map<String, List<String>> m25722c() {
        Map<String, List<String>> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int a = m25716a();
        for (int i = 0; i < a; i++) {
            String toLowerCase = m25717a(i).toLowerCase(Locale.US);
            List list = (List) treeMap.get(toLowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(toLowerCase, list);
            }
            list.add(m25720b(i));
        }
        return treeMap;
    }

    /* renamed from: a */
    private static String m25715a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C6234q m25714a(Map<String, String> map) {
        if (map != null) {
            String[] strArr = new String[(map.size() * 2)];
            map = map.entrySet().iterator();
            int i = 0;
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                String trim = ((String) entry.getKey()).trim();
                String trim2 = ((String) entry.getValue()).trim();
                if (trim.length() != 0 && trim.indexOf(0) == -1 && trim2.indexOf(0) == -1) {
                    strArr[i] = trim;
                    strArr[i + 1] = trim2;
                    i += 2;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected header: ");
                    stringBuilder.append(trim);
                    stringBuilder.append(": ");
                    stringBuilder.append(trim2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            return new C6234q(strArr);
        }
        throw new NullPointerException("headers == null");
    }
}
