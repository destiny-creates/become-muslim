package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.gc */
public final class gc extends C6823d<gc> {
    /* renamed from: c */
    public Integer f29006c;
    /* renamed from: d */
    public Boolean f29007d;
    /* renamed from: e */
    public String f29008e;
    /* renamed from: f */
    public String f29009f;
    /* renamed from: g */
    public String f29010g;

    public gc() {
        this.f29006c = null;
        this.f29007d = null;
        this.f29008e = null;
        this.f29009f = null;
        this.f29010g = null;
        this.a = null;
        this.b = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.p213l.gc m38118b(com.google.android.gms.internal.p213l.C5033a r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
    L_0x0000:
        r0 = r7.m21214a();
        if (r0 == 0) goto L_0x0075;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0041;
    L_0x000a:
        r1 = 16;
        if (r0 == r1) goto L_0x0036;
    L_0x000e:
        r1 = 26;
        if (r0 == r1) goto L_0x002f;
    L_0x0012:
        r1 = 34;
        if (r0 == r1) goto L_0x0028;
    L_0x0016:
        r1 = 42;
        if (r0 == r1) goto L_0x0021;
    L_0x001a:
        r0 = super.m31987a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0020:
        return r6;
    L_0x0021:
        r0 = r7.m21223c();
        r6.f29010g = r0;
        goto L_0x0000;
    L_0x0028:
        r0 = r7.m21223c();
        r6.f29009f = r0;
        goto L_0x0000;
    L_0x002f:
        r0 = r7.m21223c();
        r6.f29008e = r0;
        goto L_0x0000;
    L_0x0036:
        r0 = r7.m21220b();
        r0 = java.lang.Boolean.valueOf(r0);
        r6.f29007d = r0;
        goto L_0x0000;
    L_0x0041:
        r1 = r7.m21231i();
        r2 = r7.m21224d();	 Catch:{ IllegalArgumentException -> 0x006e }
        if (r2 < 0) goto L_0x0055;	 Catch:{ IllegalArgumentException -> 0x006e }
    L_0x004b:
        r3 = 4;	 Catch:{ IllegalArgumentException -> 0x006e }
        if (r2 > r3) goto L_0x0055;	 Catch:{ IllegalArgumentException -> 0x006e }
    L_0x004e:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x006e }
        r6.f29006c = r2;	 Catch:{ IllegalArgumentException -> 0x006e }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x006e }
    L_0x0055:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x006e }
        r4 = 46;	 Catch:{ IllegalArgumentException -> 0x006e }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x006e }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x006e }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x006e }
        r2 = " is not a valid enum ComparisonType";	 Catch:{ IllegalArgumentException -> 0x006e }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x006e }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x006e }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x006e }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x006e }
    L_0x006e:
        r7.m21227e(r1);
        r6.m31987a(r7, r0);
        goto L_0x0000;
    L_0x0075:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.gc.b(com.google.android.gms.internal.l.a):com.google.android.gms.internal.l.gc");
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int a = super.mo4756a();
        if (this.f29006c != null) {
            a += C5035b.m21287b(1, this.f29006c.intValue());
        }
        if (this.f29007d != null) {
            this.f29007d.booleanValue();
            a += C5035b.m21286b(2) + 1;
        }
        if (this.f29008e != null) {
            a += C5035b.m21289b(3, this.f29008e);
        }
        if (this.f29009f != null) {
            a += C5035b.m21289b(4, this.f29009f);
        }
        return this.f29010g != null ? a + C5035b.m21289b(5, this.f29010g) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        return m38118b(c5033a);
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f29006c != null) {
            c5035b.m21297a(1, this.f29006c.intValue());
        }
        if (this.f29007d != null) {
            c5035b.m21301a(2, this.f29007d.booleanValue());
        }
        if (this.f29008e != null) {
            c5035b.m21300a(3, this.f29008e);
        }
        if (this.f29009f != null) {
            c5035b.m21300a(4, this.f29009f);
        }
        if (this.f29010g != null) {
            c5035b.m21300a(5, this.f29010g);
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gc)) {
            return false;
        }
        gc gcVar = (gc) obj;
        if (this.f29006c == null) {
            if (gcVar.f29006c != null) {
                return false;
            }
        } else if (!this.f29006c.equals(gcVar.f29006c)) {
            return false;
        }
        if (this.f29007d == null) {
            if (gcVar.f29007d != null) {
                return false;
            }
        } else if (!this.f29007d.equals(gcVar.f29007d)) {
            return false;
        }
        if (this.f29008e == null) {
            if (gcVar.f29008e != null) {
                return false;
            }
        } else if (!this.f29008e.equals(gcVar.f29008e)) {
            return false;
        }
        if (this.f29009f == null) {
            if (gcVar.f29009f != null) {
                return false;
            }
        } else if (!this.f29009f.equals(gcVar.f29009f)) {
            return false;
        }
        if (this.f29010g == null) {
            if (gcVar.f29010g != null) {
                return false;
            }
        } else if (!this.f29010g.equals(gcVar.f29010g)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(gcVar.a);
            }
        }
        if (gcVar.a != null) {
            if (!gcVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + (this.f29006c == null ? 0 : this.f29006c.intValue())) * 31) + (this.f29007d == null ? 0 : this.f29007d.hashCode())) * 31) + (this.f29008e == null ? 0 : this.f29008e.hashCode())) * 31) + (this.f29009f == null ? 0 : this.f29009f.hashCode())) * 31) + (this.f29010g == null ? 0 : this.f29010g.hashCode())) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                i = this.a.hashCode();
            }
        }
        return hashCode + i;
    }
}
