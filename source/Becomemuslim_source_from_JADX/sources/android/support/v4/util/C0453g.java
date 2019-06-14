package android.support.v4.util;

import java.util.LinkedHashMap;
import java.util.Locale;

/* compiled from: LruCache */
/* renamed from: android.support.v4.util.g */
public class C0453g<K, V> {
    /* renamed from: a */
    private final LinkedHashMap<K, V> f1166a;
    /* renamed from: b */
    private int f1167b;
    /* renamed from: c */
    private int f1168c;
    /* renamed from: d */
    private int f1169d;
    /* renamed from: e */
    private int f1170e;
    /* renamed from: f */
    private int f1171f;
    /* renamed from: g */
    private int f1172g;
    /* renamed from: h */
    private int f1173h;

    /* renamed from: a */
    protected void m1426a(boolean z, K k, V v, V v2) {
    }

    /* renamed from: b */
    protected int m1427b(K k, V v) {
        return 1;
    }

    /* renamed from: b */
    protected V m1428b(K k) {
        return null;
    }

    public C0453g(int i) {
        if (i > 0) {
            this.f1168c = i;
            this.f1166a = new LinkedHashMap(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final V m1423a(K r5) {
        /*
        r4 = this;
        if (r5 == 0) goto L_0x0054;
    L_0x0002:
        monitor-enter(r4);
        r0 = r4.f1166a;	 Catch:{ all -> 0x0051 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0051 }
        if (r0 == 0) goto L_0x0013;
    L_0x000b:
        r5 = r4.f1172g;	 Catch:{ all -> 0x0051 }
        r5 = r5 + 1;
        r4.f1172g = r5;	 Catch:{ all -> 0x0051 }
        monitor-exit(r4);	 Catch:{ all -> 0x0051 }
        return r0;
    L_0x0013:
        r0 = r4.f1173h;	 Catch:{ all -> 0x0051 }
        r0 = r0 + 1;
        r4.f1173h = r0;	 Catch:{ all -> 0x0051 }
        monitor-exit(r4);	 Catch:{ all -> 0x0051 }
        r0 = r4.m1428b(r5);
        if (r0 != 0) goto L_0x0022;
    L_0x0020:
        r5 = 0;
        return r5;
    L_0x0022:
        monitor-enter(r4);
        r1 = r4.f1170e;	 Catch:{ all -> 0x004e }
        r1 = r1 + 1;
        r4.f1170e = r1;	 Catch:{ all -> 0x004e }
        r1 = r4.f1166a;	 Catch:{ all -> 0x004e }
        r1 = r1.put(r5, r0);	 Catch:{ all -> 0x004e }
        if (r1 == 0) goto L_0x0037;
    L_0x0031:
        r2 = r4.f1166a;	 Catch:{ all -> 0x004e }
        r2.put(r5, r1);	 Catch:{ all -> 0x004e }
        goto L_0x0040;
    L_0x0037:
        r2 = r4.f1167b;	 Catch:{ all -> 0x004e }
        r3 = r4.m1422c(r5, r0);	 Catch:{ all -> 0x004e }
        r2 = r2 + r3;
        r4.f1167b = r2;	 Catch:{ all -> 0x004e }
    L_0x0040:
        monitor-exit(r4);	 Catch:{ all -> 0x004e }
        if (r1 == 0) goto L_0x0048;
    L_0x0043:
        r2 = 0;
        r4.m1426a(r2, r5, r0, r1);
        return r1;
    L_0x0048:
        r5 = r4.f1168c;
        r4.m1425a(r5);
        return r0;
    L_0x004e:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x004e }
        throw r5;
    L_0x0051:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0051 }
        throw r5;
    L_0x0054:
        r5 = new java.lang.NullPointerException;
        r0 = "key == null";
        r5.<init>(r0);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.g.a(java.lang.Object):V");
    }

    /* renamed from: a */
    public final V m1424a(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.f1169d++;
            this.f1167b += m1422c(k, v);
            put = this.f1166a.put(k, v);
            if (put != null) {
                this.f1167b -= m1422c(k, put);
            }
        }
        if (put != null) {
            m1426a(false, k, put, v);
        }
        m1425a(this.f1168c);
        return put;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m1425a(int r5) {
        /*
        r4 = this;
    L_0x0000:
        monitor-enter(r4);
        r0 = r4.f1167b;	 Catch:{ all -> 0x0071 }
        if (r0 < 0) goto L_0x0052;
    L_0x0005:
        r0 = r4.f1166a;	 Catch:{ all -> 0x0071 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0071 }
        if (r0 == 0) goto L_0x0011;
    L_0x000d:
        r0 = r4.f1167b;	 Catch:{ all -> 0x0071 }
        if (r0 != 0) goto L_0x0052;
    L_0x0011:
        r0 = r4.f1167b;	 Catch:{ all -> 0x0071 }
        if (r0 <= r5) goto L_0x0050;
    L_0x0015:
        r0 = r4.f1166a;	 Catch:{ all -> 0x0071 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0071 }
        if (r0 == 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0050;
    L_0x001e:
        r0 = r4.f1166a;	 Catch:{ all -> 0x0071 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0071 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0071 }
        r0 = r0.next();	 Catch:{ all -> 0x0071 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0071 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0071 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0071 }
        r2 = r4.f1166a;	 Catch:{ all -> 0x0071 }
        r2.remove(r1);	 Catch:{ all -> 0x0071 }
        r2 = r4.f1167b;	 Catch:{ all -> 0x0071 }
        r3 = r4.m1422c(r1, r0);	 Catch:{ all -> 0x0071 }
        r2 = r2 - r3;
        r4.f1167b = r2;	 Catch:{ all -> 0x0071 }
        r2 = r4.f1171f;	 Catch:{ all -> 0x0071 }
        r3 = 1;
        r2 = r2 + r3;
        r4.f1171f = r2;	 Catch:{ all -> 0x0071 }
        monitor-exit(r4);	 Catch:{ all -> 0x0071 }
        r2 = 0;
        r4.m1426a(r3, r1, r0, r2);
        goto L_0x0000;
    L_0x0050:
        monitor-exit(r4);	 Catch:{ all -> 0x0071 }
        return;
    L_0x0052:
        r5 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0071 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0071 }
        r0.<init>();	 Catch:{ all -> 0x0071 }
        r1 = r4.getClass();	 Catch:{ all -> 0x0071 }
        r1 = r1.getName();	 Catch:{ all -> 0x0071 }
        r0.append(r1);	 Catch:{ all -> 0x0071 }
        r1 = ".sizeOf() is reporting inconsistent results!";
        r0.append(r1);	 Catch:{ all -> 0x0071 }
        r0 = r0.toString();	 Catch:{ all -> 0x0071 }
        r5.<init>(r0);	 Catch:{ all -> 0x0071 }
        throw r5;	 Catch:{ all -> 0x0071 }
    L_0x0071:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0071 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.g.a(int):void");
    }

    /* renamed from: c */
    private int m1422c(K k, V v) {
        int b = m1427b(k, v);
        if (b >= 0) {
            return b;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative size: ");
        stringBuilder.append(k);
        stringBuilder.append("=");
        stringBuilder.append(v);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final synchronized String toString() {
        int i;
        i = this.f1172g + this.f1173h;
        i = i != 0 ? (this.f1172g * 100) / i : 0;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f1168c), Integer.valueOf(this.f1172g), Integer.valueOf(this.f1173h), Integer.valueOf(i)});
    }
}
