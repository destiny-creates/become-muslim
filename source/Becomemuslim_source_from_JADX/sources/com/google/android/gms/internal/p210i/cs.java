package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.cs */
public final class cs extends jb<cs> {
    /* renamed from: a */
    public cr[] f28853a;
    /* renamed from: b */
    public cq f28854b;
    /* renamed from: c */
    public String f28855c;

    public cs() {
        this.f28853a = cr.m37794b();
        this.f28854b = null;
        this.f28855c = "";
        this.m = null;
        this.n = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cs)) {
            return false;
        }
        cs csVar = (cs) obj;
        if (!jf.m21004a(this.f28853a, csVar.f28853a)) {
            return false;
        }
        if (this.f28854b == null) {
            if (csVar.f28854b != null) {
                return false;
            }
        } else if (!this.f28854b.equals(csVar.f28854b)) {
            return false;
        }
        if (this.f28855c == null) {
            if (csVar.f28855c != null) {
                return false;
            }
        } else if (!this.f28855c.equals(csVar.f28855c)) {
            return false;
        }
        if (this.m != null) {
            if (!this.m.m20993b()) {
                return this.m.equals(csVar.m);
            }
        }
        if (csVar.m != null) {
            if (csVar.m.m20993b() == null) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int hashCode = ((getClass().getName().hashCode() + 527) * 31) + jf.m21001a(this.f28853a);
        cq cqVar = this.f28854b;
        hashCode *= 31;
        int i2 = 0;
        if (cqVar == null) {
            i = 0;
        } else {
            i = cqVar.hashCode();
        }
        hashCode = (((hashCode + i) * 31) + (this.f28855c == null ? 0 : this.f28855c.hashCode())) * 31;
        if (this.m != null) {
            if (!this.m.m20993b()) {
                i2 = this.m.hashCode();
            }
        }
        return hashCode + i2;
    }

    /* renamed from: a */
    public final void mo4622a(iz izVar) {
        if (this.f28853a != null && this.f28853a.length > 0) {
            for (jh jhVar : this.f28853a) {
                if (jhVar != null) {
                    izVar.m20974a(1, jhVar);
                }
            }
        }
        if (this.f28854b != null) {
            izVar.m20974a(2, this.f28854b);
        }
        if (!(this.f28855c == null || this.f28855c.equals(""))) {
            izVar.m20975a(3, this.f28855c);
        }
        super.mo4622a(izVar);
    }

    /* renamed from: a */
    protected final int mo4621a() {
        int a = super.mo4621a();
        if (this.f28853a != null && this.f28853a.length > 0) {
            for (jh jhVar : this.f28853a) {
                if (jhVar != null) {
                    a += iz.m20965b(1, jhVar);
                }
            }
        }
        if (this.f28854b != null) {
            a += iz.m20965b(2, this.f28854b);
        }
        return (this.f28855c == null || this.f28855c.equals("")) ? a : a + iz.m20966b(3, this.f28855c);
    }

    /* renamed from: a */
    public final /* synthetic */ jh mo6147a(iy iyVar) {
        while (true) {
            int a = iyVar.m20937a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                a = jk.m21021a(iyVar, 10);
                int length = this.f28853a == null ? 0 : this.f28853a.length;
                Object obj = new cr[(a + length)];
                if (length != 0) {
                    System.arraycopy(this.f28853a, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = new cr();
                    iyVar.m20940a(obj[length]);
                    iyVar.m20937a();
                    length++;
                }
                obj[length] = new cr();
                iyVar.m20940a(obj[length]);
                this.f28853a = obj;
            } else if (a == 18) {
                if (this.f28854b == null) {
                    this.f28854b = new cq();
                }
                iyVar.m20940a(this.f28854b);
            } else if (a == 26) {
                this.f28855c = iyVar.m20947c();
            } else if (!super.m31766a(iyVar, a)) {
                return this;
            }
        }
    }
}
