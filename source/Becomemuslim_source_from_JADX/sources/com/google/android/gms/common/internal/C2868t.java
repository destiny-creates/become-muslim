package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.t */
public final class C2868t {

    /* renamed from: com.google.android.gms.common.internal.t$a */
    public static final class C2867a {
        /* renamed from: a */
        private final List<String> f7333a;
        /* renamed from: b */
        private final Object f7334b;

        private C2867a(Object obj) {
            this.f7334b = C2872v.m8380a(obj);
            this.f7333a = new ArrayList();
        }

        /* renamed from: a */
        public final C2867a m8371a(String str, Object obj) {
            List list = this.f7333a;
            str = (String) C2872v.m8380a((Object) str);
            obj = String.valueOf(obj);
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(obj).length());
            stringBuilder.append(str);
            stringBuilder.append("=");
            stringBuilder.append(obj);
            list.add(stringBuilder.toString());
            return this;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(100);
            stringBuilder.append(this.f7334b.getClass().getSimpleName());
            stringBuilder.append('{');
            int size = this.f7333a.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append((String) this.f7333a.get(i));
                if (i < size - 1) {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    /* renamed from: a */
    public static boolean m8374a(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static int m8372a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    /* renamed from: a */
    public static C2867a m8373a(Object obj) {
        return new C2867a(obj);
    }
}
