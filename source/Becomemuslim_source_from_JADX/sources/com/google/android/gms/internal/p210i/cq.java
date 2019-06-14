package com.google.android.gms.internal.p210i;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.internal.p210i.bc.C8327a;
import com.google.android.gms.internal.p210i.bc.C8327a.C8326a;
import com.google.android.gms.internal.p210i.bc.C8329b;
import com.google.android.gms.internal.p210i.bc.C8333d;
import com.google.android.gms.internal.p210i.bc.C8335e;

/* renamed from: com.google.android.gms.internal.i.cq */
public final class cq extends jb<cq> {
    /* renamed from: a */
    public String[] f28832a;
    /* renamed from: b */
    public ct[] f28833b;
    /* renamed from: c */
    public C8333d[] f28834c;
    /* renamed from: d */
    public C8329b[] f28835d;
    /* renamed from: e */
    public C8329b[] f28836e;
    /* renamed from: f */
    public C8329b[] f28837f;
    /* renamed from: g */
    public C8335e[] f28838g;
    /* renamed from: h */
    public String f28839h;
    /* renamed from: i */
    public int f28840i;
    /* renamed from: j */
    private String[] f28841j;
    /* renamed from: k */
    private String f28842k;
    /* renamed from: l */
    private String f28843l;
    /* renamed from: o */
    private String f28844o;
    /* renamed from: p */
    private C8327a f28845p;
    /* renamed from: q */
    private float f28846q;
    /* renamed from: r */
    private boolean f28847r;
    /* renamed from: s */
    private String[] f28848s;

    public cq() {
        this.f28841j = jk.f16797b;
        this.f28832a = jk.f16797b;
        this.f28833b = ct.m37803b();
        this.f28834c = new C8333d[0];
        this.f28835d = new C8329b[0];
        this.f28836e = new C8329b[0];
        this.f28837f = new C8329b[0];
        this.f28838g = new C8335e[0];
        this.f28842k = "";
        this.f28843l = "";
        this.f28844o = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.f28839h = "";
        this.f28845p = null;
        this.f28846q = 0.0f;
        this.f28847r = false;
        this.f28848s = jk.f16797b;
        this.f28840i = 0;
        this.m = null;
        this.n = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cq)) {
            return false;
        }
        cq cqVar = (cq) obj;
        if (!jf.m21004a(this.f28841j, cqVar.f28841j) || !jf.m21004a(this.f28832a, cqVar.f28832a) || !jf.m21004a(this.f28833b, cqVar.f28833b) || !jf.m21004a(this.f28834c, cqVar.f28834c) || !jf.m21004a(this.f28835d, cqVar.f28835d) || !jf.m21004a(this.f28836e, cqVar.f28836e) || !jf.m21004a(this.f28837f, cqVar.f28837f) || !jf.m21004a(this.f28838g, cqVar.f28838g)) {
            return false;
        }
        if (this.f28842k == null) {
            if (cqVar.f28842k != null) {
                return false;
            }
        } else if (!this.f28842k.equals(cqVar.f28842k)) {
            return false;
        }
        if (this.f28843l == null) {
            if (cqVar.f28843l != null) {
                return false;
            }
        } else if (!this.f28843l.equals(cqVar.f28843l)) {
            return false;
        }
        if (this.f28844o == null) {
            if (cqVar.f28844o != null) {
                return false;
            }
        } else if (!this.f28844o.equals(cqVar.f28844o)) {
            return false;
        }
        if (this.f28839h == null) {
            if (cqVar.f28839h != null) {
                return false;
            }
        } else if (!this.f28839h.equals(cqVar.f28839h)) {
            return false;
        }
        if (this.f28845p == null) {
            if (cqVar.f28845p != null) {
                return false;
            }
        } else if (!this.f28845p.equals(cqVar.f28845p)) {
            return false;
        }
        if (Float.floatToIntBits(this.f28846q) != Float.floatToIntBits(cqVar.f28846q) || this.f28847r != cqVar.f28847r || !jf.m21004a(this.f28848s, cqVar.f28848s) || this.f28840i != cqVar.f28840i) {
            return false;
        }
        if (this.m != null) {
            if (!this.m.m20993b()) {
                return this.m.equals(cqVar.m);
            }
        }
        if (cqVar.m != null) {
            if (cqVar.m.m20993b() == null) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + jf.m21001a(this.f28841j)) * 31) + jf.m21001a(this.f28832a)) * 31) + jf.m21001a(this.f28833b)) * 31) + jf.m21001a(this.f28834c)) * 31) + jf.m21001a(this.f28835d)) * 31) + jf.m21001a(this.f28836e)) * 31) + jf.m21001a(this.f28837f)) * 31) + jf.m21001a(this.f28838g)) * 31) + (this.f28842k == null ? 0 : this.f28842k.hashCode())) * 31) + (this.f28843l == null ? 0 : this.f28843l.hashCode())) * 31) + (this.f28844o == null ? 0 : this.f28844o.hashCode())) * 31) + (this.f28839h == null ? 0 : this.f28839h.hashCode());
        fk fkVar = this.f28845p;
        hashCode *= 31;
        if (fkVar == null) {
            i = 0;
        } else {
            i = fkVar.hashCode();
        }
        hashCode = (((((((((hashCode + i) * 31) + Float.floatToIntBits(this.f28846q)) * 31) + (this.f28847r ? 1231 : 1237)) * 31) + jf.m21001a(this.f28848s)) * 31) + this.f28840i) * 31;
        if (this.m != null) {
            if (!this.m.m20993b()) {
                i2 = this.m.hashCode();
            }
        }
        return hashCode + i2;
    }

    /* renamed from: a */
    public final void mo4622a(iz izVar) {
        if (this.f28832a != null && this.f28832a.length > 0) {
            for (String str : this.f28832a) {
                if (str != null) {
                    izVar.m20975a(1, str);
                }
            }
        }
        if (this.f28833b != null && this.f28833b.length > 0) {
            for (jh jhVar : this.f28833b) {
                if (jhVar != null) {
                    izVar.m20974a(2, jhVar);
                }
            }
        }
        if (this.f28834c != null && this.f28834c.length > 0) {
            for (gt gtVar : this.f28834c) {
                if (gtVar != null) {
                    izVar.m20973a(3, gtVar);
                }
            }
        }
        if (this.f28835d != null && this.f28835d.length > 0) {
            for (gt gtVar2 : this.f28835d) {
                if (gtVar2 != null) {
                    izVar.m20973a(4, gtVar2);
                }
            }
        }
        if (this.f28836e != null && this.f28836e.length > 0) {
            for (gt gtVar3 : this.f28836e) {
                if (gtVar3 != null) {
                    izVar.m20973a(5, gtVar3);
                }
            }
        }
        if (this.f28837f != null && this.f28837f.length > 0) {
            for (gt gtVar32 : this.f28837f) {
                if (gtVar32 != null) {
                    izVar.m20973a(6, gtVar32);
                }
            }
        }
        if (this.f28838g != null && this.f28838g.length > 0) {
            for (gt gtVar322 : this.f28838g) {
                if (gtVar322 != null) {
                    izVar.m20973a(7, gtVar322);
                }
            }
        }
        if (!(this.f28842k == null || this.f28842k.equals(""))) {
            izVar.m20975a(9, this.f28842k);
        }
        if (!(this.f28843l == null || this.f28843l.equals(""))) {
            izVar.m20975a(10, this.f28843l);
        }
        if (!(this.f28844o == null || this.f28844o.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
            izVar.m20975a(12, this.f28844o);
        }
        if (!(this.f28839h == null || this.f28839h.equals(""))) {
            izVar.m20975a(13, this.f28839h);
        }
        if (this.f28845p != null) {
            izVar.m20973a(14, this.f28845p);
        }
        if (Float.floatToIntBits(this.f28846q) != Float.floatToIntBits(0.0f)) {
            float f = this.f28846q;
            izVar.m20980c(15, 5);
            izVar.m20981e(Float.floatToIntBits(f));
        }
        if (this.f28848s != null && this.f28848s.length > 0) {
            for (String str2 : this.f28848s) {
                if (str2 != null) {
                    izVar.m20975a(16, str2);
                }
            }
        }
        if (this.f28840i != 0) {
            izVar.m20971a(17, this.f28840i);
        }
        if (this.f28847r) {
            izVar.m20976a(18, this.f28847r);
        }
        if (this.f28841j != null && this.f28841j.length > 0) {
            for (String str3 : this.f28841j) {
                if (str3 != null) {
                    izVar.m20975a(19, str3);
                }
            }
        }
        super.mo4622a(izVar);
    }

    /* renamed from: a */
    protected final int mo4621a() {
        int i;
        int i2;
        int a = super.mo4621a();
        if (this.f28832a != null && this.f28832a.length > 0) {
            int i3 = 0;
            i = 0;
            for (String str : this.f28832a) {
                if (str != null) {
                    i++;
                    i3 += iz.m20957a(str);
                }
            }
            a = (a + i3) + (i * 1);
        }
        if (this.f28833b != null && this.f28833b.length > 0) {
            i2 = a;
            for (jh jhVar : this.f28833b) {
                if (jhVar != null) {
                    i2 += iz.m20965b(2, jhVar);
                }
            }
            a = i2;
        }
        if (this.f28834c != null && this.f28834c.length > 0) {
            i2 = a;
            for (gt gtVar : this.f28834c) {
                if (gtVar != null) {
                    i2 += eq.m31453c(3, gtVar);
                }
            }
            a = i2;
        }
        if (this.f28835d != null && this.f28835d.length > 0) {
            i2 = a;
            for (gt gtVar2 : this.f28835d) {
                if (gtVar2 != null) {
                    i2 += eq.m31453c(4, gtVar2);
                }
            }
            a = i2;
        }
        if (this.f28836e != null && this.f28836e.length > 0) {
            i2 = a;
            for (gt gtVar22 : this.f28836e) {
                if (gtVar22 != null) {
                    i2 += eq.m31453c(5, gtVar22);
                }
            }
            a = i2;
        }
        if (this.f28837f != null && this.f28837f.length > 0) {
            i2 = a;
            for (gt gtVar222 : this.f28837f) {
                if (gtVar222 != null) {
                    i2 += eq.m31453c(6, gtVar222);
                }
            }
            a = i2;
        }
        if (this.f28838g != null && this.f28838g.length > 0) {
            i2 = a;
            for (gt gtVar2222 : this.f28838g) {
                if (gtVar2222 != null) {
                    i2 += eq.m31453c(7, gtVar2222);
                }
            }
            a = i2;
        }
        if (!(this.f28842k == null || this.f28842k.equals(""))) {
            a += iz.m20966b(9, this.f28842k);
        }
        if (!(this.f28843l == null || this.f28843l.equals(""))) {
            a += iz.m20966b(10, this.f28843l);
        }
        if (!(this.f28844o == null || this.f28844o.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
            a += iz.m20966b(12, this.f28844o);
        }
        if (!(this.f28839h == null || this.f28839h.equals(""))) {
            a += iz.m20966b(13, this.f28839h);
        }
        if (this.f28845p != null) {
            a += eq.m31453c(14, this.f28845p);
        }
        if (Float.floatToIntBits(this.f28846q) != Float.floatToIntBits(0.0f)) {
            a += iz.m20962b(15) + 4;
        }
        if (this.f28848s != null && this.f28848s.length > 0) {
            i = 0;
            int i4 = 0;
            for (String str2 : this.f28848s) {
                if (str2 != null) {
                    i4++;
                    i += iz.m20957a(str2);
                }
            }
            a = (a + i) + (i4 * 2);
        }
        if (this.f28840i != 0) {
            a += iz.m20963b(17, this.f28840i);
        }
        if (this.f28847r) {
            a += iz.m20962b(18) + 1;
        }
        if (this.f28841j == null || this.f28841j.length <= 0) {
            return a;
        }
        i2 = 0;
        i = 0;
        for (String str3 : this.f28841j) {
            if (str3 != null) {
                i++;
                i2 += iz.m20957a(str3);
            }
        }
        return (a + i2) + (i * 2);
    }

    /* renamed from: a */
    public final /* synthetic */ jh mo6147a(iy iyVar) {
        while (true) {
            int a = iyVar.m20937a();
            int length;
            Object obj;
            switch (a) {
                case 0:
                    return this;
                case 10:
                    a = jk.m21021a(iyVar, 10);
                    length = this.f28832a == null ? 0 : this.f28832a.length;
                    obj = new String[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f28832a, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = iyVar.m20947c();
                        iyVar.m20937a();
                        length++;
                    }
                    obj[length] = iyVar.m20947c();
                    this.f28832a = obj;
                    break;
                case 18:
                    a = jk.m21021a(iyVar, 18);
                    length = this.f28833b == null ? 0 : this.f28833b.length;
                    obj = new ct[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f28833b, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = new ct();
                        iyVar.m20940a(obj[length]);
                        iyVar.m20937a();
                        length++;
                    }
                    obj[length] = new ct();
                    iyVar.m20940a(obj[length]);
                    this.f28833b = obj;
                    break;
                case 26:
                    a = jk.m21021a(iyVar, 26);
                    length = this.f28834c == null ? 0 : this.f28834c.length;
                    obj = new C8333d[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f28834c, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = (C8333d) iyVar.m20938a(C8333d.m43863c());
                        iyVar.m20937a();
                        length++;
                    }
                    obj[length] = (C8333d) iyVar.m20938a(C8333d.m43863c());
                    this.f28834c = obj;
                    break;
                case 34:
                    a = jk.m21021a(iyVar, 34);
                    length = this.f28835d == null ? 0 : this.f28835d.length;
                    obj = new C8329b[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f28835d, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = (C8329b) iyVar.m20938a(C8329b.m43850b());
                        iyVar.m20937a();
                        length++;
                    }
                    obj[length] = (C8329b) iyVar.m20938a(C8329b.m43850b());
                    this.f28835d = obj;
                    break;
                case 42:
                    a = jk.m21021a(iyVar, 42);
                    length = this.f28836e == null ? 0 : this.f28836e.length;
                    obj = new C8329b[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f28836e, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = (C8329b) iyVar.m20938a(C8329b.m43850b());
                        iyVar.m20937a();
                        length++;
                    }
                    obj[length] = (C8329b) iyVar.m20938a(C8329b.m43850b());
                    this.f28836e = obj;
                    break;
                case 50:
                    a = jk.m21021a(iyVar, 50);
                    length = this.f28837f == null ? 0 : this.f28837f.length;
                    obj = new C8329b[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f28837f, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = (C8329b) iyVar.m20938a(C8329b.m43850b());
                        iyVar.m20937a();
                        length++;
                    }
                    obj[length] = (C8329b) iyVar.m20938a(C8329b.m43850b());
                    this.f28837f = obj;
                    break;
                case 58:
                    a = jk.m21021a(iyVar, 58);
                    length = this.f28838g == null ? 0 : this.f28838g.length;
                    obj = new C8335e[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f28838g, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = (C8335e) iyVar.m20938a(C8335e.m43868k());
                        iyVar.m20937a();
                        length++;
                    }
                    obj[length] = (C8335e) iyVar.m20938a(C8335e.m43868k());
                    this.f28838g = obj;
                    break;
                case 74:
                    this.f28842k = iyVar.m20947c();
                    break;
                case 82:
                    this.f28843l = iyVar.m20947c();
                    break;
                case 98:
                    this.f28844o = iyVar.m20947c();
                    break;
                case 106:
                    this.f28839h = iyVar.m20947c();
                    break;
                case 114:
                    C8327a c8327a = (C8327a) iyVar.m20938a(C8327a.m43847a());
                    if (this.f28845p != null) {
                        c8327a = (C8327a) ((fk) ((C8326a) ((C8326a) this.f28845p.m42495q()).m42475a((fk) c8327a)).mo6730e());
                    }
                    this.f28845p = c8327a;
                    break;
                case 125:
                    this.f28846q = Float.intBitsToFloat(iyVar.m20952f());
                    break;
                case 130:
                    a = jk.m21021a(iyVar, 130);
                    length = this.f28848s == null ? 0 : this.f28848s.length;
                    obj = new String[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f28848s, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = iyVar.m20947c();
                        iyVar.m20937a();
                        length++;
                    }
                    obj[length] = iyVar.m20947c();
                    this.f28848s = obj;
                    break;
                case 136:
                    this.f28840i = iyVar.m20948d();
                    break;
                case 144:
                    this.f28847r = iyVar.m20944b();
                    break;
                case 154:
                    a = jk.m21021a(iyVar, 154);
                    length = this.f28841j == null ? 0 : this.f28841j.length;
                    obj = new String[(a + length)];
                    if (length != 0) {
                        System.arraycopy(this.f28841j, 0, obj, 0, length);
                    }
                    while (length < obj.length - 1) {
                        obj[length] = iyVar.m20947c();
                        iyVar.m20937a();
                        length++;
                    }
                    obj[length] = iyVar.m20947c();
                    this.f28841j = obj;
                    break;
                default:
                    if (super.m31766a(iyVar, a)) {
                        break;
                    }
                    return this;
            }
        }
    }
}
