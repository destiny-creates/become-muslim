package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.co */
public final class co {

    /* renamed from: com.google.android.gms.internal.i.co$a */
    public static final class C7811a extends jb<C7811a> {
        /* renamed from: a */
        public static final jc<ct, C7811a> f28820a = jc.m20982a(11, C7811a.class, 810);
        /* renamed from: g */
        private static final C7811a[] f28821g = new C7811a[0];
        /* renamed from: b */
        public int[] f28822b;
        /* renamed from: c */
        public int[] f28823c;
        /* renamed from: d */
        public int[] f28824d;
        /* renamed from: e */
        public int[] f28825e;
        /* renamed from: f */
        public int f28826f;
        /* renamed from: h */
        private int f28827h;
        /* renamed from: i */
        private int f28828i;

        public C7811a() {
            this.f28822b = jk.f16796a;
            this.f28823c = jk.f16796a;
            this.f28824d = jk.f16796a;
            this.f28827h = 0;
            this.f28825e = jk.f16796a;
            this.f28826f = 0;
            this.f28828i = 0;
            this.m = null;
            this.n = -1;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C7811a)) {
                return false;
            }
            C7811a c7811a = (C7811a) obj;
            if (!jf.m21003a(this.f28822b, c7811a.f28822b) || !jf.m21003a(this.f28823c, c7811a.f28823c) || !jf.m21003a(this.f28824d, c7811a.f28824d) || this.f28827h != c7811a.f28827h || !jf.m21003a(this.f28825e, c7811a.f28825e) || this.f28826f != c7811a.f28826f || this.f28828i != c7811a.f28828i) {
                return false;
            }
            if (this.m != null) {
                if (!this.m.m20993b()) {
                    return this.m.equals(c7811a.m);
                }
            }
            if (c7811a.m != null) {
                if (c7811a.m.m20993b() == null) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            int hashCode;
            int hashCode2 = (((((((((((((((getClass().getName().hashCode() + 527) * 31) + jf.m21000a(this.f28822b)) * 31) + jf.m21000a(this.f28823c)) * 31) + jf.m21000a(this.f28824d)) * 31) + this.f28827h) * 31) + jf.m21000a(this.f28825e)) * 31) + this.f28826f) * 31) + this.f28828i) * 31;
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
            if (this.f28822b != null && this.f28822b.length > 0) {
                for (int a : this.f28822b) {
                    izVar.m20971a(1, a);
                }
            }
            if (this.f28823c != null && this.f28823c.length > 0) {
                for (int a2 : this.f28823c) {
                    izVar.m20971a(2, a2);
                }
            }
            if (this.f28824d != null && this.f28824d.length > 0) {
                for (int a22 : this.f28824d) {
                    izVar.m20971a(3, a22);
                }
            }
            if (this.f28827h != 0) {
                izVar.m20971a(4, this.f28827h);
            }
            if (this.f28825e != null && this.f28825e.length > 0) {
                for (int a3 : this.f28825e) {
                    izVar.m20971a(5, a3);
                }
            }
            if (this.f28826f != 0) {
                izVar.m20971a(6, this.f28826f);
            }
            if (this.f28828i != 0) {
                izVar.m20971a(7, this.f28828i);
            }
            super.mo4622a(izVar);
        }

        /* renamed from: a */
        protected final int mo4621a() {
            int i;
            int i2;
            int a = super.mo4621a();
            if (this.f28822b != null && this.f28822b.length > 0) {
                i = 0;
                for (int a2 : this.f28822b) {
                    i += iz.m20955a(a2);
                }
                a = (a + i) + (this.f28822b.length * 1);
            }
            if (this.f28823c != null && this.f28823c.length > 0) {
                i = 0;
                for (int a22 : this.f28823c) {
                    i += iz.m20955a(a22);
                }
                a = (a + i) + (this.f28823c.length * 1);
            }
            if (this.f28824d != null && this.f28824d.length > 0) {
                i = 0;
                for (int a222 : this.f28824d) {
                    i += iz.m20955a(a222);
                }
                a = (a + i) + (this.f28824d.length * 1);
            }
            if (this.f28827h != 0) {
                a += iz.m20963b(4, this.f28827h);
            }
            if (this.f28825e != null && this.f28825e.length > 0) {
                i2 = 0;
                for (int i3 : this.f28825e) {
                    i2 += iz.m20955a(i3);
                }
                a = (a + i2) + (this.f28825e.length * 1);
            }
            if (this.f28826f != 0) {
                a += iz.m20963b(6, this.f28826f);
            }
            return this.f28828i != 0 ? a + iz.m20963b(7, this.f28828i) : a;
        }

        /* renamed from: a */
        public final /* synthetic */ jh mo6147a(iy iyVar) {
            while (true) {
                int a = iyVar.m20937a();
                int length;
                Object obj;
                int i;
                Object obj2;
                switch (a) {
                    case 0:
                        return this;
                    case 8:
                        a = jk.m21021a(iyVar, 8);
                        length = this.f28822b == null ? 0 : this.f28822b.length;
                        obj = new int[(a + length)];
                        if (length != 0) {
                            System.arraycopy(this.f28822b, 0, obj, 0, length);
                        }
                        while (length < obj.length - 1) {
                            obj[length] = iyVar.m20948d();
                            iyVar.m20937a();
                            length++;
                        }
                        obj[length] = iyVar.m20948d();
                        this.f28822b = obj;
                        break;
                    case 10:
                        a = iyVar.m20946c(iyVar.m20948d());
                        length = iyVar.m20954h();
                        i = 0;
                        while (iyVar.m20953g() > 0) {
                            iyVar.m20948d();
                            i++;
                        }
                        iyVar.m20951e(length);
                        length = this.f28822b == null ? 0 : this.f28822b.length;
                        obj2 = new int[(i + length)];
                        if (length != 0) {
                            System.arraycopy(this.f28822b, 0, obj2, 0, length);
                        }
                        while (length < obj2.length) {
                            obj2[length] = iyVar.m20948d();
                            length++;
                        }
                        this.f28822b = obj2;
                        iyVar.m20949d(a);
                        break;
                    case 16:
                        a = jk.m21021a(iyVar, 16);
                        length = this.f28823c == null ? 0 : this.f28823c.length;
                        obj = new int[(a + length)];
                        if (length != 0) {
                            System.arraycopy(this.f28823c, 0, obj, 0, length);
                        }
                        while (length < obj.length - 1) {
                            obj[length] = iyVar.m20948d();
                            iyVar.m20937a();
                            length++;
                        }
                        obj[length] = iyVar.m20948d();
                        this.f28823c = obj;
                        break;
                    case 18:
                        a = iyVar.m20946c(iyVar.m20948d());
                        length = iyVar.m20954h();
                        i = 0;
                        while (iyVar.m20953g() > 0) {
                            iyVar.m20948d();
                            i++;
                        }
                        iyVar.m20951e(length);
                        length = this.f28823c == null ? 0 : this.f28823c.length;
                        obj2 = new int[(i + length)];
                        if (length != 0) {
                            System.arraycopy(this.f28823c, 0, obj2, 0, length);
                        }
                        while (length < obj2.length) {
                            obj2[length] = iyVar.m20948d();
                            length++;
                        }
                        this.f28823c = obj2;
                        iyVar.m20949d(a);
                        break;
                    case 24:
                        a = jk.m21021a(iyVar, 24);
                        length = this.f28824d == null ? 0 : this.f28824d.length;
                        obj = new int[(a + length)];
                        if (length != 0) {
                            System.arraycopy(this.f28824d, 0, obj, 0, length);
                        }
                        while (length < obj.length - 1) {
                            obj[length] = iyVar.m20948d();
                            iyVar.m20937a();
                            length++;
                        }
                        obj[length] = iyVar.m20948d();
                        this.f28824d = obj;
                        break;
                    case 26:
                        a = iyVar.m20946c(iyVar.m20948d());
                        length = iyVar.m20954h();
                        i = 0;
                        while (iyVar.m20953g() > 0) {
                            iyVar.m20948d();
                            i++;
                        }
                        iyVar.m20951e(length);
                        length = this.f28824d == null ? 0 : this.f28824d.length;
                        obj2 = new int[(i + length)];
                        if (length != 0) {
                            System.arraycopy(this.f28824d, 0, obj2, 0, length);
                        }
                        while (length < obj2.length) {
                            obj2[length] = iyVar.m20948d();
                            length++;
                        }
                        this.f28824d = obj2;
                        iyVar.m20949d(a);
                        break;
                    case 32:
                        this.f28827h = iyVar.m20948d();
                        break;
                    case 40:
                        a = jk.m21021a(iyVar, 40);
                        length = this.f28825e == null ? 0 : this.f28825e.length;
                        obj = new int[(a + length)];
                        if (length != 0) {
                            System.arraycopy(this.f28825e, 0, obj, 0, length);
                        }
                        while (length < obj.length - 1) {
                            obj[length] = iyVar.m20948d();
                            iyVar.m20937a();
                            length++;
                        }
                        obj[length] = iyVar.m20948d();
                        this.f28825e = obj;
                        break;
                    case 42:
                        a = iyVar.m20946c(iyVar.m20948d());
                        length = iyVar.m20954h();
                        i = 0;
                        while (iyVar.m20953g() > 0) {
                            iyVar.m20948d();
                            i++;
                        }
                        iyVar.m20951e(length);
                        length = this.f28825e == null ? 0 : this.f28825e.length;
                        obj2 = new int[(i + length)];
                        if (length != 0) {
                            System.arraycopy(this.f28825e, 0, obj2, 0, length);
                        }
                        while (length < obj2.length) {
                            obj2[length] = iyVar.m20948d();
                            length++;
                        }
                        this.f28825e = obj2;
                        iyVar.m20949d(a);
                        break;
                    case 48:
                        this.f28826f = iyVar.m20948d();
                        break;
                    case 56:
                        this.f28828i = iyVar.m20948d();
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
}
