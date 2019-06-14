package org.apache.p378b.p379a;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: MarkerManager */
/* renamed from: org.apache.b.a.e */
public final class C6670e {
    /* renamed from: a */
    private static final ConcurrentMap<String, C6661d> f21424a = new ConcurrentHashMap();

    /* compiled from: MarkerManager */
    /* renamed from: org.apache.b.a.e$a */
    public static class C7689a implements C6661d {
        private static final long serialVersionUID = 100;
        /* renamed from: a */
        private final String f26443a;
        /* renamed from: b */
        private volatile C6661d[] f26444b;

        private C7689a() {
            this.f26443a = null;
            this.f26444b = null;
        }

        public C7689a(String str) {
            if (str != null) {
                this.f26443a = str;
                this.f26444b = null;
                return;
            }
            throw new IllegalArgumentException("Marker name cannot be null.");
        }

        /* renamed from: a */
        public C6661d mo5707a(C6661d... c6661dArr) {
            if (c6661dArr != null) {
                if (c6661dArr.length != 0) {
                    Object obj = new C6661d[c6661dArr.length];
                    System.arraycopy(c6661dArr, 0, obj, 0, c6661dArr.length);
                    this.f26444b = obj;
                    return this;
                }
            }
            this.f26444b = null;
            return this;
        }

        /* renamed from: a */
        public String mo5706a() {
            return this.f26443a;
        }

        /* renamed from: b */
        public C6661d[] mo5708b() {
            if (this.f26444b == null) {
                return null;
            }
            return (C6661d[]) Arrays.copyOf(this.f26444b, this.f26444b.length);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (obj instanceof C6661d) {
                    return this.f26443a.equals(((C6661d) obj).mo5706a());
                }
            }
            return null;
        }

        public int hashCode() {
            return this.f26443a.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(this.f26443a);
            C6661d[] c6661dArr = this.f26444b;
            if (c6661dArr != null) {
                C7689a.m34581a(stringBuilder, c6661dArr);
            }
            return stringBuilder.toString();
        }

        /* renamed from: a */
        private static void m34581a(StringBuilder stringBuilder, C6661d... c6661dArr) {
            stringBuilder.append("[ ");
            int length = c6661dArr.length;
            int i = 0;
            Object obj = 1;
            while (i < length) {
                C6661d c6661d = c6661dArr[i];
                if (obj == null) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(c6661d.mo5706a());
                C6661d[] b = c6661d instanceof C7689a ? ((C7689a) c6661d).f26444b : c6661d.mo5708b();
                if (b != null) {
                    C7689a.m34581a(stringBuilder, b);
                }
                i++;
                obj = null;
            }
            stringBuilder.append(" ]");
        }
    }

    /* renamed from: a */
    public static C6661d m27134a(String str) {
        f21424a.putIfAbsent(str, new C7689a(str));
        return (C6661d) f21424a.get(str);
    }
}
