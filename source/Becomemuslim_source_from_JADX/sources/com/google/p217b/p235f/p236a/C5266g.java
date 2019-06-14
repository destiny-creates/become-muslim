package com.google.p217b.p235f.p236a;

/* compiled from: DetectionResultColumn */
/* renamed from: com.google.b.f.a.g */
class C5266g {
    /* renamed from: a */
    private final C5260c f17777a;
    /* renamed from: b */
    private final C5261d[] f17778b;

    C5266g(C5260c c5260c) {
        this.f17777a = new C5260c(c5260c);
        this.f17778b = new C5261d[((c5260c.m22280d() - c5260c.m22279c()) + 1)];
    }

    /* renamed from: a */
    final C5261d m22320a(int i) {
        C5261d c = m22324c(i);
        if (c != null) {
            return c;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            C5261d c5261d;
            int b = m22322b(i) - i2;
            if (b >= 0) {
                c5261d = this.f17778b[b];
                if (c5261d != null) {
                    return c5261d;
                }
            }
            b = m22322b(i) + i2;
            if (b < this.f17778b.length) {
                c5261d = this.f17778b[b];
                if (c5261d != null) {
                    return c5261d;
                }
            }
        }
        return 0;
    }

    /* renamed from: b */
    final int m22322b(int i) {
        return i - this.f17777a.m22279c();
    }

    /* renamed from: a */
    final void m22321a(int i, C5261d c5261d) {
        this.f17778b[m22322b(i)] = c5261d;
    }

    /* renamed from: c */
    final C5261d m22324c(int i) {
        return this.f17778b[m22322b(i)];
    }

    /* renamed from: a */
    final C5260c m22319a() {
        return this.f17777a;
    }

    /* renamed from: b */
    final C5261d[] m22323b() {
        return this.f17778b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
        r12 = this;
        r0 = new java.util.Formatter;
        r0.<init>();
        r1 = 0;
        r2 = r12.f17778b;	 Catch:{ Throwable -> 0x0057 }
        r3 = r2.length;	 Catch:{ Throwable -> 0x0057 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
    L_0x000c:
        if (r5 >= r3) goto L_0x004d;
    L_0x000e:
        r7 = r2[r5];	 Catch:{ Throwable -> 0x0057 }
        r8 = 1;
        if (r7 != 0) goto L_0x0024;
    L_0x0013:
        r7 = "%3d:    |   %n";
        r8 = new java.lang.Object[r8];	 Catch:{ Throwable -> 0x0057 }
        r9 = r6 + 1;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x0057 }
        r8[r4] = r6;	 Catch:{ Throwable -> 0x0057 }
        r0.format(r7, r8);	 Catch:{ Throwable -> 0x0057 }
        r6 = r9;
        goto L_0x004a;
    L_0x0024:
        r9 = "%3d: %3d|%3d%n";
        r10 = 3;
        r10 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x0057 }
        r11 = r6 + 1;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x0057 }
        r10[r4] = r6;	 Catch:{ Throwable -> 0x0057 }
        r6 = r7.m22294h();	 Catch:{ Throwable -> 0x0057 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x0057 }
        r10[r8] = r6;	 Catch:{ Throwable -> 0x0057 }
        r6 = 2;
        r7 = r7.m22293g();	 Catch:{ Throwable -> 0x0057 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Throwable -> 0x0057 }
        r10[r6] = r7;	 Catch:{ Throwable -> 0x0057 }
        r0.format(r9, r10);	 Catch:{ Throwable -> 0x0057 }
        r6 = r11;
    L_0x004a:
        r5 = r5 + 1;
        goto L_0x000c;
    L_0x004d:
        r2 = r0.toString();	 Catch:{ Throwable -> 0x0057 }
        r0.close();
        return r2;
    L_0x0055:
        r2 = move-exception;
        goto L_0x0059;
    L_0x0057:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0055 }
    L_0x0059:
        if (r1 == 0) goto L_0x0064;
    L_0x005b:
        r0.close();	 Catch:{ Throwable -> 0x005f }
        goto L_0x0067;
    L_0x005f:
        r0 = move-exception;
        r1.addSuppressed(r0);
        goto L_0x0067;
    L_0x0064:
        r0.close();
    L_0x0067:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.f.a.g.toString():java.lang.String");
    }
}
