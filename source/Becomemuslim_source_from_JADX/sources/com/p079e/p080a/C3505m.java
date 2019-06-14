package com.p079e.p080a;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedHashMap;

/* compiled from: LruCache */
/* renamed from: com.e.a.m */
public class C3505m implements C1211d {
    /* renamed from: b */
    final LinkedHashMap<String, Bitmap> f9337b;
    /* renamed from: c */
    private final int f9338c;
    /* renamed from: d */
    private int f9339d;
    /* renamed from: e */
    private int f9340e;
    /* renamed from: f */
    private int f9341f;
    /* renamed from: g */
    private int f9342g;
    /* renamed from: h */
    private int f9343h;

    public C3505m(Context context) {
        this(ae.m4227c(context));
    }

    public C3505m(int i) {
        if (i > 0) {
            this.f9338c = i;
            this.f9337b = new LinkedHashMap(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("Max size must be positive.");
    }

    /* renamed from: a */
    public Bitmap mo823a(String str) {
        if (str != null) {
            synchronized (this) {
                Bitmap bitmap = (Bitmap) this.f9337b.get(str);
                if (bitmap != null) {
                    this.f9342g++;
                    return bitmap;
                }
                this.f9343h++;
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    /* renamed from: a */
    public void mo824a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        synchronized (this) {
            this.f9340e++;
            this.f9339d += ae.m4207a(bitmap);
            Bitmap bitmap2 = (Bitmap) this.f9337b.put(str, bitmap);
            if (bitmap2 != null) {
                this.f9339d -= ae.m4207a(bitmap2);
            }
        }
        m11300a(this.f9338c);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m11300a(int r4) {
        /*
        r3 = this;
    L_0x0000:
        monitor-enter(r3);
        r0 = r3.f9339d;	 Catch:{ all -> 0x0071 }
        if (r0 < 0) goto L_0x0052;
    L_0x0005:
        r0 = r3.f9337b;	 Catch:{ all -> 0x0071 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0071 }
        if (r0 == 0) goto L_0x0011;
    L_0x000d:
        r0 = r3.f9339d;	 Catch:{ all -> 0x0071 }
        if (r0 != 0) goto L_0x0052;
    L_0x0011:
        r0 = r3.f9339d;	 Catch:{ all -> 0x0071 }
        if (r0 <= r4) goto L_0x0050;
    L_0x0015:
        r0 = r3.f9337b;	 Catch:{ all -> 0x0071 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0071 }
        if (r0 == 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0050;
    L_0x001e:
        r0 = r3.f9337b;	 Catch:{ all -> 0x0071 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0071 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0071 }
        r0 = r0.next();	 Catch:{ all -> 0x0071 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0071 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0071 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0071 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0071 }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ all -> 0x0071 }
        r2 = r3.f9337b;	 Catch:{ all -> 0x0071 }
        r2.remove(r1);	 Catch:{ all -> 0x0071 }
        r1 = r3.f9339d;	 Catch:{ all -> 0x0071 }
        r0 = com.p079e.p080a.ae.m4207a(r0);	 Catch:{ all -> 0x0071 }
        r1 = r1 - r0;
        r3.f9339d = r1;	 Catch:{ all -> 0x0071 }
        r0 = r3.f9341f;	 Catch:{ all -> 0x0071 }
        r0 = r0 + 1;
        r3.f9341f = r0;	 Catch:{ all -> 0x0071 }
        monitor-exit(r3);	 Catch:{ all -> 0x0071 }
        goto L_0x0000;
    L_0x0050:
        monitor-exit(r3);	 Catch:{ all -> 0x0071 }
        return;
    L_0x0052:
        r4 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0071 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0071 }
        r0.<init>();	 Catch:{ all -> 0x0071 }
        r1 = r3.getClass();	 Catch:{ all -> 0x0071 }
        r1 = r1.getName();	 Catch:{ all -> 0x0071 }
        r0.append(r1);	 Catch:{ all -> 0x0071 }
        r1 = ".sizeOf() is reporting inconsistent results!";
        r0.append(r1);	 Catch:{ all -> 0x0071 }
        r0 = r0.toString();	 Catch:{ all -> 0x0071 }
        r4.<init>(r0);	 Catch:{ all -> 0x0071 }
        throw r4;	 Catch:{ all -> 0x0071 }
    L_0x0071:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0071 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.a.m.a(int):void");
    }

    /* renamed from: a */
    public final synchronized int mo822a() {
        return this.f9339d;
    }

    /* renamed from: b */
    public final synchronized int mo825b() {
        return this.f9338c;
    }
}
