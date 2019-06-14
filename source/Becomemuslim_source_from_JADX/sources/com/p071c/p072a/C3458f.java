package com.p071c.p072a;

import p289e.p291b.C5914b;

/* compiled from: SerializedAction1 */
/* renamed from: com.c.a.f */
final class C3458f<T> implements C5914b<T> {
    /* renamed from: a */
    private final C5914b<? super T> f9243a;
    /* renamed from: b */
    private boolean f9244b;
    /* renamed from: c */
    private C1112a<T> f9245c;

    /* compiled from: SerializedAction1 */
    /* renamed from: com.c.a.f$a */
    private static final class C1112a<T> {
        /* renamed from: a */
        T[] f3128a;
        /* renamed from: b */
        int f3129b;

        C1112a() {
        }

        /* renamed from: a */
        void m3941a(T t) {
            int i = this.f3129b;
            Object[] objArr = this.f3128a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f3128a = objArr;
            } else if (i == objArr.length) {
                Object[] objArr2 = new Object[((i >> 2) + i)];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                this.f3128a = objArr2;
                objArr = objArr2;
            }
            objArr[i] = t;
            this.f3129b = i + 1;
        }
    }

    C3458f(C5914b<? super T> c5914b) {
        this.f9243a = c5914b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public void m11110b(T r7) {
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r6.f9244b;	 Catch:{ all -> 0x004a }
        if (r0 == 0) goto L_0x0015;
    L_0x0005:
        r0 = r6.f9245c;	 Catch:{ all -> 0x004a }
        if (r0 != 0) goto L_0x0010;
    L_0x0009:
        r0 = new com.c.a.f$a;	 Catch:{ all -> 0x004a }
        r0.<init>();	 Catch:{ all -> 0x004a }
        r6.f9245c = r0;	 Catch:{ all -> 0x004a }
    L_0x0010:
        r0.m3941a(r7);	 Catch:{ all -> 0x004a }
        monitor-exit(r6);	 Catch:{ all -> 0x004a }
        return;
    L_0x0015:
        r0 = 1;
        r6.f9244b = r0;	 Catch:{ all -> 0x004a }
        monitor-exit(r6);	 Catch:{ all -> 0x004a }
        r0 = r6.f9243a;
        r0.b(r7);
    L_0x001e:
        r7 = 0;
        r0 = 0;
    L_0x0020:
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        if (r0 >= r1) goto L_0x001e;
    L_0x0024:
        monitor-enter(r6);
        r1 = r6.f9245c;	 Catch:{ all -> 0x0047 }
        if (r1 != 0) goto L_0x002d;
    L_0x0029:
        r6.f9244b = r7;	 Catch:{ all -> 0x0047 }
        monitor-exit(r6);	 Catch:{ all -> 0x0047 }
        return;
    L_0x002d:
        r2 = 0;
        r6.f9245c = r2;	 Catch:{ all -> 0x0047 }
        monitor-exit(r6);	 Catch:{ all -> 0x0047 }
        r1 = r1.f3128a;
        r2 = r1.length;
        r3 = 0;
    L_0x0035:
        if (r3 >= r2) goto L_0x0044;
    L_0x0037:
        r4 = r1[r3];
        if (r4 != 0) goto L_0x003c;
    L_0x003b:
        goto L_0x0044;
    L_0x003c:
        r5 = r6.f9243a;
        r5.b(r4);
        r3 = r3 + 1;
        goto L_0x0035;
    L_0x0044:
        r0 = r0 + 1;
        goto L_0x0020;
    L_0x0047:
        r7 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0047 }
        throw r7;
    L_0x004a:
        r7 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x004a }
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.f.b(java.lang.Object):void");
    }
}
