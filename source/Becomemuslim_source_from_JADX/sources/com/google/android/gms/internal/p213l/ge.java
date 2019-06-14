package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.ge */
public final class ge extends C6823d<ge> {
    /* renamed from: c */
    public Integer f29015c;
    /* renamed from: d */
    public String f29016d;
    /* renamed from: e */
    public Boolean f29017e;
    /* renamed from: f */
    public String[] f29018f;

    public ge() {
        this.f29015c = null;
        this.f29016d = null;
        this.f29017e = null;
        this.f29018f = C5046m.f17299c;
        this.a = null;
        this.b = -1;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.p213l.ge m38126b(com.google.android.gms.internal.p213l.C5033a r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
    L_0x0000:
        r0 = r7.m21214a();
        if (r0 == 0) goto L_0x0096;
    L_0x0006:
        r1 = 8;
        if (r0 == r1) goto L_0x0061;
    L_0x000a:
        r1 = 18;
        if (r0 == r1) goto L_0x005a;
    L_0x000e:
        r1 = 24;
        if (r0 == r1) goto L_0x004f;
    L_0x0012:
        r1 = 34;
        if (r0 == r1) goto L_0x001d;
    L_0x0016:
        r0 = super.m31987a(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x001c:
        return r6;
    L_0x001d:
        r0 = com.google.android.gms.internal.p213l.C5046m.m21448a(r7, r1);
        r1 = r6.f29018f;
        r2 = 0;
        if (r1 != 0) goto L_0x0028;
    L_0x0026:
        r1 = 0;
        goto L_0x002b;
    L_0x0028:
        r1 = r6.f29018f;
        r1 = r1.length;
    L_0x002b:
        r0 = r0 + r1;
        r0 = new java.lang.String[r0];
        if (r1 == 0) goto L_0x0035;
    L_0x0030:
        r3 = r6.f29018f;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x0035:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x0046;
    L_0x003a:
        r2 = r7.m21223c();
        r0[r1] = r2;
        r7.m21214a();
        r1 = r1 + 1;
        goto L_0x0035;
    L_0x0046:
        r2 = r7.m21223c();
        r0[r1] = r2;
        r6.f29018f = r0;
        goto L_0x0000;
    L_0x004f:
        r0 = r7.m21220b();
        r0 = java.lang.Boolean.valueOf(r0);
        r6.f29017e = r0;
        goto L_0x0000;
    L_0x005a:
        r0 = r7.m21223c();
        r6.f29016d = r0;
        goto L_0x0000;
    L_0x0061:
        r1 = r7.m21231i();
        r2 = r7.m21224d();	 Catch:{ IllegalArgumentException -> 0x008e }
        if (r2 < 0) goto L_0x0075;	 Catch:{ IllegalArgumentException -> 0x008e }
    L_0x006b:
        r3 = 6;	 Catch:{ IllegalArgumentException -> 0x008e }
        if (r2 > r3) goto L_0x0075;	 Catch:{ IllegalArgumentException -> 0x008e }
    L_0x006e:
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x008e }
        r6.f29015c = r2;	 Catch:{ IllegalArgumentException -> 0x008e }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x008e }
    L_0x0075:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x008e }
        r4 = 41;	 Catch:{ IllegalArgumentException -> 0x008e }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x008e }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x008e }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x008e }
        r2 = " is not a valid enum MatchType";	 Catch:{ IllegalArgumentException -> 0x008e }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x008e }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x008e }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x008e }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x008e }
    L_0x008e:
        r7.m21227e(r1);
        r6.m31987a(r7, r0);
        goto L_0x0000;
    L_0x0096:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.ge.b(com.google.android.gms.internal.l.a):com.google.android.gms.internal.l.ge");
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int a = super.mo4756a();
        if (this.f29015c != null) {
            a += C5035b.m21287b(1, this.f29015c.intValue());
        }
        if (this.f29016d != null) {
            a += C5035b.m21289b(2, this.f29016d);
        }
        if (this.f29017e != null) {
            this.f29017e.booleanValue();
            a += C5035b.m21286b(3) + 1;
        }
        if (this.f29018f == null || this.f29018f.length <= 0) {
            return a;
        }
        int i = 0;
        int i2 = 0;
        for (String str : this.f29018f) {
            if (str != null) {
                i2++;
                i += C5035b.m21282a(str);
            }
        }
        return (a + i) + (i2 * 1);
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        return m38126b(c5033a);
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f29015c != null) {
            c5035b.m21297a(1, this.f29015c.intValue());
        }
        if (this.f29016d != null) {
            c5035b.m21300a(2, this.f29016d);
        }
        if (this.f29017e != null) {
            c5035b.m21301a(3, this.f29017e.booleanValue());
        }
        if (this.f29018f != null && this.f29018f.length > 0) {
            for (String str : this.f29018f) {
                if (str != null) {
                    c5035b.m21300a(4, str);
                }
            }
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ge)) {
            return false;
        }
        ge geVar = (ge) obj;
        if (this.f29015c == null) {
            if (geVar.f29015c != null) {
                return false;
            }
        } else if (!this.f29015c.equals(geVar.f29015c)) {
            return false;
        }
        if (this.f29016d == null) {
            if (geVar.f29016d != null) {
                return false;
            }
        } else if (!this.f29016d.equals(geVar.f29016d)) {
            return false;
        }
        if (this.f29017e == null) {
            if (geVar.f29017e != null) {
                return false;
            }
        } else if (!this.f29017e.equals(geVar.f29017e)) {
            return false;
        }
        if (!C5041h.m21398a(this.f29018f, geVar.f29018f)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(geVar.a);
            }
        }
        if (geVar.a != null) {
            if (!geVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + (this.f29015c == null ? 0 : this.f29015c.intValue())) * 31) + (this.f29016d == null ? 0 : this.f29016d.hashCode())) * 31) + (this.f29017e == null ? 0 : this.f29017e.hashCode())) * 31) + C5041h.m21395a(this.f29018f)) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                i = this.a.hashCode();
            }
        }
        return hashCode + i;
    }
}
