package com.google.android.gms.internal.p210i;

import com.google.android.gms.internal.p210i.bc.C8331c;

/* renamed from: com.google.android.gms.internal.i.cp */
public final class cp extends jb<cp> {
    /* renamed from: a */
    public ct[] f28829a;
    /* renamed from: b */
    public ct[] f28830b;
    /* renamed from: c */
    public C8331c[] f28831c;

    public cp() {
        this.f28829a = ct.m37803b();
        this.f28830b = ct.m37803b();
        this.f28831c = new C8331c[0];
        this.m = null;
        this.n = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cp)) {
            return false;
        }
        cp cpVar = (cp) obj;
        if (!jf.m21004a(this.f28829a, cpVar.f28829a) || !jf.m21004a(this.f28830b, cpVar.f28830b) || !jf.m21004a(this.f28831c, cpVar.f28831c)) {
            return false;
        }
        if (this.m != null) {
            if (!this.m.m20993b()) {
                return this.m.equals(cpVar.m);
            }
        }
        if (cpVar.m != null) {
            if (cpVar.m.m20993b() == null) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (((((((getClass().getName().hashCode() + 527) * 31) + jf.m21001a(this.f28829a)) * 31) + jf.m21001a(this.f28830b)) * 31) + jf.m21001a(this.f28831c)) * 31;
        if (this.m != null) {
            if (!this.m.m20993b()) {
                hashCode = this.m.hashCode();
                return hashCode2 + hashCode;
            }
        }
        hashCode = 0;
        return hashCode2 + hashCode;
    }

    /* renamed from: a */
    public final void mo4622a(iz izVar) {
        if (this.f28829a != null && this.f28829a.length > 0) {
            for (jh jhVar : this.f28829a) {
                if (jhVar != null) {
                    izVar.m20974a(1, jhVar);
                }
            }
        }
        if (this.f28830b != null && this.f28830b.length > 0) {
            for (jh jhVar2 : this.f28830b) {
                if (jhVar2 != null) {
                    izVar.m20974a(2, jhVar2);
                }
            }
        }
        if (this.f28831c != null && this.f28831c.length > 0) {
            for (gt gtVar : this.f28831c) {
                if (gtVar != null) {
                    izVar.m20973a(3, gtVar);
                }
            }
        }
        super.mo4622a(izVar);
    }

    /* renamed from: a */
    protected final int mo4621a() {
        int i;
        int a = super.mo4621a();
        if (this.f28829a != null && this.f28829a.length > 0) {
            i = a;
            for (jh jhVar : this.f28829a) {
                if (jhVar != null) {
                    i += iz.m20965b(1, jhVar);
                }
            }
            a = i;
        }
        if (this.f28830b != null && this.f28830b.length > 0) {
            i = a;
            for (jh jhVar2 : this.f28830b) {
                if (jhVar2 != null) {
                    i += iz.m20965b(2, jhVar2);
                }
            }
            a = i;
        }
        if (this.f28831c != null && this.f28831c.length > 0) {
            for (gt gtVar : this.f28831c) {
                if (gtVar != null) {
                    a += eq.m31453c(3, gtVar);
                }
            }
        }
        return a;
    }

    /* renamed from: a */
    public final /* synthetic */ jh mo6147a(iy iyVar) {
        while (true) {
            int a = iyVar.m20937a();
            if (a == 0) {
                return this;
            }
            int length;
            Object obj;
            if (a == 10) {
                a = jk.m21021a(iyVar, 10);
                length = this.f28829a == null ? 0 : this.f28829a.length;
                obj = new ct[(a + length)];
                if (length != 0) {
                    System.arraycopy(this.f28829a, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = new ct();
                    iyVar.m20940a(obj[length]);
                    iyVar.m20937a();
                    length++;
                }
                obj[length] = new ct();
                iyVar.m20940a(obj[length]);
                this.f28829a = obj;
            } else if (a == 18) {
                a = jk.m21021a(iyVar, 18);
                length = this.f28830b == null ? 0 : this.f28830b.length;
                obj = new ct[(a + length)];
                if (length != 0) {
                    System.arraycopy(this.f28830b, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = new ct();
                    iyVar.m20940a(obj[length]);
                    iyVar.m20937a();
                    length++;
                }
                obj[length] = new ct();
                iyVar.m20940a(obj[length]);
                this.f28830b = obj;
            } else if (a == 26) {
                a = jk.m21021a(iyVar, 26);
                length = this.f28831c == null ? 0 : this.f28831c.length;
                obj = new C8331c[(a + length)];
                if (length != 0) {
                    System.arraycopy(this.f28831c, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = (C8331c) iyVar.m20938a(C8331c.m43854g());
                    iyVar.m20937a();
                    length++;
                }
                obj[length] = (C8331c) iyVar.m20938a(C8331c.m43854g());
                this.f28831c = obj;
            } else if (!super.m31766a(iyVar, a)) {
                return this;
            }
        }
    }
}
