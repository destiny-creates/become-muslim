package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.cr */
public final class cr extends jb<cr> {
    /* renamed from: c */
    private static volatile cr[] f28849c;
    /* renamed from: a */
    public String f28850a;
    /* renamed from: b */
    public cp f28851b;
    /* renamed from: d */
    private ct f28852d;

    /* renamed from: b */
    public static cr[] m37794b() {
        if (f28849c == null) {
            synchronized (jf.f16791b) {
                if (f28849c == null) {
                    f28849c = new cr[0];
                }
            }
        }
        return f28849c;
    }

    public cr() {
        this.f28850a = "";
        this.f28852d = null;
        this.f28851b = null;
        this.m = null;
        this.n = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cr)) {
            return false;
        }
        cr crVar = (cr) obj;
        if (this.f28850a == null) {
            if (crVar.f28850a != null) {
                return false;
            }
        } else if (!this.f28850a.equals(crVar.f28850a)) {
            return false;
        }
        if (this.f28852d == null) {
            if (crVar.f28852d != null) {
                return false;
            }
        } else if (!this.f28852d.equals(crVar.f28852d)) {
            return false;
        }
        if (this.f28851b == null) {
            if (crVar.f28851b != null) {
                return false;
            }
        } else if (!this.f28851b.equals(crVar.f28851b)) {
            return false;
        }
        if (this.m != null) {
            if (!this.m.m20993b()) {
                return this.m.equals(crVar.m);
            }
        }
        if (crVar.m != null) {
            if (crVar.m.m20993b() == null) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((getClass().getName().hashCode() + 527) * 31) + (this.f28850a == null ? 0 : this.f28850a.hashCode());
        ct ctVar = this.f28852d;
        hashCode *= 31;
        if (ctVar == null) {
            i = 0;
        } else {
            i = ctVar.hashCode();
        }
        hashCode += i;
        cp cpVar = this.f28851b;
        hashCode *= 31;
        if (cpVar == null) {
            i = 0;
        } else {
            i = cpVar.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        if (this.m != null) {
            if (!this.m.m20993b()) {
                i2 = this.m.hashCode();
            }
        }
        return hashCode + i2;
    }

    /* renamed from: a */
    public final void mo4622a(iz izVar) {
        if (!(this.f28850a == null || this.f28850a.equals(""))) {
            izVar.m20975a(1, this.f28850a);
        }
        if (this.f28852d != null) {
            izVar.m20974a(2, this.f28852d);
        }
        if (this.f28851b != null) {
            izVar.m20974a(3, this.f28851b);
        }
        super.mo4622a(izVar);
    }

    /* renamed from: a */
    protected final int mo4621a() {
        int a = super.mo4621a();
        if (!(this.f28850a == null || this.f28850a.equals(""))) {
            a += iz.m20966b(1, this.f28850a);
        }
        if (this.f28852d != null) {
            a += iz.m20965b(2, this.f28852d);
        }
        return this.f28851b != null ? a + iz.m20965b(3, this.f28851b) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ jh mo6147a(iy iyVar) {
        while (true) {
            int a = iyVar.m20937a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f28850a = iyVar.m20947c();
            } else if (a == 18) {
                if (this.f28852d == null) {
                    this.f28852d = new ct();
                }
                iyVar.m20940a(this.f28852d);
            } else if (a == 26) {
                if (this.f28851b == null) {
                    this.f28851b = new cp();
                }
                iyVar.m20940a(this.f28851b);
            } else if (!super.m31766a(iyVar, a)) {
                return this;
            }
        }
    }
}
