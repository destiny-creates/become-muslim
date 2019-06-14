package org.apache.p378b.p379a.p380a;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ParameterizedMessage */
/* renamed from: org.apache.b.a.a.d */
public class C7682d implements C6647b {
    private static final long serialVersionUID = -665975803997290697L;
    /* renamed from: a */
    private final String f26425a;
    /* renamed from: b */
    private final String[] f26426b;
    /* renamed from: c */
    private transient Object[] f26427c;
    /* renamed from: d */
    private transient String f26428d;
    /* renamed from: e */
    private transient Throwable f26429e;

    public C7682d(String str, Object[] objArr) {
        this.f26425a = str;
        this.f26426b = m34562a(objArr);
    }

    /* renamed from: a */
    private String[] m34562a(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        String[] strArr;
        int a = C7682d.m34558a(this.f26425a);
        int length = objArr.length;
        if (a < objArr.length && this.f26429e == null && (objArr[objArr.length - 1] instanceof Throwable)) {
            this.f26429e = (Throwable) objArr[objArr.length - 1];
            length--;
        }
        this.f26427c = new Object[length];
        int i = 0;
        System.arraycopy(objArr, 0, this.f26427c, 0, length);
        if (a == 1 && this.f26429e == null && objArr.length > 1) {
            strArr = new String[]{C7682d.m34559a((Object) objArr)};
        } else {
            strArr = new String[length];
            while (i < strArr.length) {
                strArr[i] = C7682d.m34559a(objArr[i]);
                i++;
            }
        }
        return strArr;
    }

    /* renamed from: a */
    public String mo5699a() {
        if (this.f26428d == null) {
            this.f26428d = m34565a(this.f26425a, this.f26426b);
        }
        return this.f26428d;
    }

    /* renamed from: b */
    public Object[] mo5700b() {
        if (this.f26427c != null) {
            return this.f26427c;
        }
        return this.f26426b;
    }

    /* renamed from: c */
    public Throwable mo5701c() {
        return this.f26429e;
    }

    /* renamed from: a */
    protected String m34565a(String str, String[] strArr) {
        return C7682d.m34560a(str, (Object[]) strArr);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        if (r5 == 0) goto L_0x0034;
    L_0x0007:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 == r3) goto L_0x0012;
    L_0x0011:
        goto L_0x0034;
    L_0x0012:
        r5 = (org.apache.p378b.p379a.p380a.C7682d) r5;
        r2 = r4.f26425a;
        if (r2 == 0) goto L_0x0023;
    L_0x0018:
        r2 = r4.f26425a;
        r3 = r5.f26425a;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0028;
    L_0x0022:
        goto L_0x0027;
    L_0x0023:
        r2 = r5.f26425a;
        if (r2 == 0) goto L_0x0028;
    L_0x0027:
        return r1;
    L_0x0028:
        r2 = r4.f26426b;
        r5 = r5.f26426b;
        r5 = java.util.Arrays.equals(r2, r5);
        if (r5 != 0) goto L_0x0033;
    L_0x0032:
        return r1;
    L_0x0033:
        return r0;
    L_0x0034:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.b.a.a.d.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f26425a != null ? this.f26425a.hashCode() : 0) * 31;
        if (this.f26426b != null) {
            i = Arrays.hashCode(this.f26426b);
        }
        return hashCode + i;
    }

    /* renamed from: a */
    public static String m34560a(String str, Object[] objArr) {
        if (!(str == null || objArr == null)) {
            if (objArr.length != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    if (charAt == '\\') {
                        i2++;
                    } else {
                        if (charAt == '{' && i < str.length() - 1) {
                            int i4 = i + 1;
                            if (str.charAt(i4) == '}') {
                                i = i2 / 2;
                                for (int i5 = 0; i5 < i; i5++) {
                                    stringBuilder.append('\\');
                                }
                                if (i2 % 2 == 1) {
                                    stringBuilder.append('{');
                                    stringBuilder.append('}');
                                } else {
                                    if (i3 < objArr.length) {
                                        stringBuilder.append(objArr[i3]);
                                    } else {
                                        stringBuilder.append('{');
                                        stringBuilder.append('}');
                                    }
                                    i3++;
                                }
                                i = i4;
                                i2 = 0;
                            }
                        }
                        if (i2 > 0) {
                            for (int i6 = 0; i6 < i2; i6++) {
                                stringBuilder.append('\\');
                            }
                            i2 = 0;
                        }
                        stringBuilder.append(charAt);
                    }
                    i++;
                }
                return stringBuilder.toString();
            }
        }
        return str;
    }

    /* renamed from: a */
    public static int m34558a(String str) {
        if (str == null || str.indexOf(123) == -1) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                i3 ^= 1;
            } else {
                if (charAt == '{' && i3 == 0 && i < str.length() - 1) {
                    i3 = i + 1;
                    if (str.charAt(i3) == '}') {
                        i2++;
                        i = i3;
                    }
                }
                i3 = 0;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static String m34559a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        StringBuilder stringBuilder = new StringBuilder();
        C7682d.m34561a(obj, stringBuilder, new HashSet());
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static void m34561a(Object obj, StringBuilder stringBuilder, Set<String> set) {
        if (obj == null) {
            stringBuilder.append("null");
        } else if (obj instanceof String) {
            stringBuilder.append(obj);
        } else {
            Class cls = obj.getClass();
            Object obj2 = 1;
            String b;
            if (cls.isArray()) {
                if (cls == byte[].class) {
                    stringBuilder.append(Arrays.toString((byte[]) obj));
                } else if (cls == short[].class) {
                    stringBuilder.append(Arrays.toString((short[]) obj));
                } else if (cls == int[].class) {
                    stringBuilder.append(Arrays.toString((int[]) obj));
                } else if (cls == long[].class) {
                    stringBuilder.append(Arrays.toString((long[]) obj));
                } else if (cls == float[].class) {
                    stringBuilder.append(Arrays.toString((float[]) obj));
                } else if (cls == double[].class) {
                    stringBuilder.append(Arrays.toString((double[]) obj));
                } else if (cls == boolean[].class) {
                    stringBuilder.append(Arrays.toString((boolean[]) obj));
                } else if (cls == char[].class) {
                    stringBuilder.append(Arrays.toString((char[]) obj));
                } else {
                    b = C7682d.m34563b(obj);
                    if (set.contains(b)) {
                        stringBuilder.append("[...");
                        stringBuilder.append(b);
                        stringBuilder.append("...]");
                    } else {
                        set.add(b);
                        Object[] objArr = (Object[]) obj;
                        stringBuilder.append('[');
                        for (Object obj3 : objArr) {
                            if (obj2 != null) {
                                obj2 = null;
                            } else {
                                stringBuilder.append(", ");
                            }
                            C7682d.m34561a(obj3, stringBuilder, new HashSet(set));
                        }
                        stringBuilder.append(']');
                    }
                }
            } else if (obj instanceof Map) {
                b = C7682d.m34563b(obj);
                if (set.contains(b)) {
                    stringBuilder.append("[...");
                    stringBuilder.append(b);
                    stringBuilder.append("...]");
                } else {
                    set.add(b);
                    Map map = (Map) obj;
                    stringBuilder.append('{');
                    for (Entry entry : map.entrySet()) {
                        if (obj2 != null) {
                            obj2 = null;
                        } else {
                            stringBuilder.append(", ");
                        }
                        Object key = entry.getKey();
                        r0 = entry.getValue();
                        C7682d.m34561a(key, stringBuilder, new HashSet(set));
                        stringBuilder.append('=');
                        C7682d.m34561a(r0, stringBuilder, new HashSet(set));
                    }
                    stringBuilder.append('}');
                }
            } else if (obj instanceof Collection) {
                b = C7682d.m34563b(obj);
                if (set.contains(b)) {
                    stringBuilder.append("[...");
                    stringBuilder.append(b);
                    stringBuilder.append("...]");
                } else {
                    set.add(b);
                    Collection collection = (Collection) obj;
                    stringBuilder.append('[');
                    for (Object next : collection) {
                        if (obj2 != null) {
                            obj2 = null;
                        } else {
                            stringBuilder.append(", ");
                        }
                        C7682d.m34561a(next, stringBuilder, new HashSet(set));
                    }
                    stringBuilder.append(']');
                }
            } else if ((obj instanceof Date) != null) {
                stringBuilder.append(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format((Date) obj));
            } else {
                try {
                    stringBuilder.append(obj.toString());
                } catch (Set<String> set2) {
                    stringBuilder.append("[!!!");
                    stringBuilder.append(C7682d.m34563b(obj));
                    stringBuilder.append("=>");
                    obj = set2.getMessage();
                    set2 = set2.getClass().getName();
                    stringBuilder.append(set2);
                    if (set2.equals(obj) == null) {
                        stringBuilder.append(":");
                        stringBuilder.append(obj);
                    }
                    stringBuilder.append("!!!]");
                }
            }
        }
    }

    /* renamed from: b */
    public static String m34563b(Object obj) {
        if (obj == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(obj.getClass().getName());
        stringBuilder.append('@');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(obj)));
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ParameterizedMessage[messagePattern=");
        stringBuilder.append(this.f26425a);
        stringBuilder.append(", stringArgs=");
        stringBuilder.append(Arrays.toString(this.f26426b));
        stringBuilder.append(", throwable=");
        stringBuilder.append(this.f26429e);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
