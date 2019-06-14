package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.cv */
public final class cv extends jb<cv> {
    /* renamed from: a */
    public long f28869a;
    /* renamed from: b */
    public cq f28870b;
    /* renamed from: c */
    public cs f28871c;

    public cv() {
        this.f28869a = 0;
        this.f28870b = null;
        this.f28871c = null;
        this.m = null;
        this.n = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cv)) {
            return false;
        }
        cv cvVar = (cv) obj;
        if (this.f28869a != cvVar.f28869a) {
            return false;
        }
        if (this.f28870b == null) {
            if (cvVar.f28870b != null) {
                return false;
            }
        } else if (!this.f28870b.equals(cvVar.f28870b)) {
            return false;
        }
        if (this.f28871c == null) {
            if (cvVar.f28871c != null) {
                return false;
            }
        } else if (!this.f28871c.equals(cvVar.f28871c)) {
            return false;
        }
        if (this.m != null) {
            if (!this.m.m20993b()) {
                return this.m.equals(cvVar.m);
            }
        }
        if (cvVar.m != null) {
            if (cvVar.m.m20993b() == null) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int hashCode = ((getClass().getName().hashCode() + 527) * 31) + ((int) (this.f28869a ^ (this.f28869a >>> 32)));
        cq cqVar = this.f28870b;
        hashCode *= 31;
        int i2 = 0;
        if (cqVar == null) {
            i = 0;
        } else {
            i = cqVar.hashCode();
        }
        hashCode += i;
        cs csVar = this.f28871c;
        hashCode *= 31;
        if (csVar == null) {
            i = 0;
        } else {
            i = csVar.hashCode();
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
        izVar.m20972a(1, this.f28869a);
        if (this.f28870b != null) {
            izVar.m20974a(2, this.f28870b);
        }
        if (this.f28871c != null) {
            izVar.m20974a(3, this.f28871c);
        }
        super.mo4622a(izVar);
    }

    /* renamed from: a */
    protected final int mo4621a() {
        int a = super.mo4621a() + iz.m20964b(1, this.f28869a);
        if (this.f28870b != null) {
            a += iz.m20965b(2, this.f28870b);
        }
        return this.f28871c != null ? a + iz.m20965b(3, this.f28871c) : a;
    }

    /* renamed from: a */
    public final /* synthetic */ jh mo6147a(iy iyVar) {
        while (true) {
            int a = iyVar.m20937a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f28869a = iyVar.m20950e();
            } else if (a == 18) {
                if (this.f28870b == null) {
                    this.f28870b = new cq();
                }
                iyVar.m20940a(this.f28870b);
            } else if (a == 26) {
                if (this.f28871c == null) {
                    this.f28871c = new cs();
                }
                iyVar.m20940a(this.f28871c);
            } else if (!super.m31766a(iyVar, a)) {
                return this;
            }
        }
    }
}
