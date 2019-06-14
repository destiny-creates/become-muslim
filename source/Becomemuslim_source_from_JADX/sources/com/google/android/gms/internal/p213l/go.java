package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.go */
public final class go extends C6823d<go> {
    /* renamed from: c */
    public long[] f29093c;
    /* renamed from: d */
    public long[] f29094d;
    /* renamed from: e */
    public gj[] f29095e;
    /* renamed from: f */
    private gp[] f29096f;

    public go() {
        this.f29093c = C5046m.f17298b;
        this.f29094d = C5046m.f17298b;
        this.f29095e = gj.m38145e();
        this.f29096f = gp.m38167e();
        this.a = null;
        this.b = -1;
    }

    /* renamed from: a */
    protected final int mo4756a() {
        int i;
        int i2;
        int a = super.mo4756a();
        if (this.f29093c != null && this.f29093c.length > 0) {
            i = 0;
            for (long a2 : this.f29093c) {
                i += C5035b.m21280a(a2);
            }
            a = (a + i) + (this.f29093c.length * 1);
        }
        if (this.f29094d != null && this.f29094d.length > 0) {
            i = 0;
            for (long a22 : this.f29094d) {
                i += C5035b.m21280a(a22);
            }
            a = (a + i) + (this.f29094d.length * 1);
        }
        if (this.f29095e != null && this.f29095e.length > 0) {
            i2 = a;
            for (C5043j c5043j : this.f29095e) {
                if (c5043j != null) {
                    i2 += C5035b.m21288b(3, c5043j);
                }
            }
            a = i2;
        }
        if (this.f29096f != null && this.f29096f.length > 0) {
            for (C5043j c5043j2 : this.f29096f) {
                if (c5043j2 != null) {
                    a += C5035b.m21288b(4, c5043j2);
                }
            }
        }
        return a;
    }

    /* renamed from: a */
    public final /* synthetic */ C5043j mo6216a(C5033a c5033a) {
        while (true) {
            int a = c5033a.m21214a();
            if (a == 0) {
                return this;
            }
            int i;
            Object obj;
            if (a != 8) {
                int i2;
                Object obj2;
                if (a == 10) {
                    a = c5033a.m21222c(c5033a.m21224d());
                    i = c5033a.m21231i();
                    i2 = 0;
                    while (c5033a.m21230h() > 0) {
                        c5033a.m21226e();
                        i2++;
                    }
                    c5033a.m21227e(i);
                    i = this.f29093c == null ? 0 : this.f29093c.length;
                    obj2 = new long[(i2 + i)];
                    if (i != 0) {
                        System.arraycopy(this.f29093c, 0, obj2, 0, i);
                    }
                    while (i < obj2.length) {
                        obj2[i] = c5033a.m21226e();
                        i++;
                    }
                    this.f29093c = obj2;
                } else if (a == 16) {
                    a = C5046m.m21448a(c5033a, 16);
                    i = this.f29094d == null ? 0 : this.f29094d.length;
                    obj = new long[(a + i)];
                    if (i != 0) {
                        System.arraycopy(this.f29094d, 0, obj, 0, i);
                    }
                    while (i < obj.length - 1) {
                        obj[i] = c5033a.m21226e();
                        c5033a.m21214a();
                        i++;
                    }
                    obj[i] = c5033a.m21226e();
                    this.f29094d = obj;
                } else if (a == 18) {
                    a = c5033a.m21222c(c5033a.m21224d());
                    i = c5033a.m21231i();
                    i2 = 0;
                    while (c5033a.m21230h() > 0) {
                        c5033a.m21226e();
                        i2++;
                    }
                    c5033a.m21227e(i);
                    i = this.f29094d == null ? 0 : this.f29094d.length;
                    obj2 = new long[(i2 + i)];
                    if (i != 0) {
                        System.arraycopy(this.f29094d, 0, obj2, 0, i);
                    }
                    while (i < obj2.length) {
                        obj2[i] = c5033a.m21226e();
                        i++;
                    }
                    this.f29094d = obj2;
                } else if (a == 26) {
                    a = C5046m.m21448a(c5033a, 26);
                    i = this.f29095e == null ? 0 : this.f29095e.length;
                    obj = new gj[(a + i)];
                    if (i != 0) {
                        System.arraycopy(this.f29095e, 0, obj, 0, i);
                    }
                    while (i < obj.length - 1) {
                        obj[i] = new gj();
                        c5033a.m21216a(obj[i]);
                        c5033a.m21214a();
                        i++;
                    }
                    obj[i] = new gj();
                    c5033a.m21216a(obj[i]);
                    this.f29095e = obj;
                } else if (a == 34) {
                    a = C5046m.m21448a(c5033a, 34);
                    i = this.f29096f == null ? 0 : this.f29096f.length;
                    obj = new gp[(a + i)];
                    if (i != 0) {
                        System.arraycopy(this.f29096f, 0, obj, 0, i);
                    }
                    while (i < obj.length - 1) {
                        obj[i] = new gp();
                        c5033a.m21216a(obj[i]);
                        c5033a.m21214a();
                        i++;
                    }
                    obj[i] = new gp();
                    c5033a.m21216a(obj[i]);
                    this.f29096f = obj;
                } else if (!super.m31987a(c5033a, a)) {
                    return this;
                }
                c5033a.m21225d(a);
            } else {
                a = C5046m.m21448a(c5033a, 8);
                i = this.f29093c == null ? 0 : this.f29093c.length;
                obj = new long[(a + i)];
                if (i != 0) {
                    System.arraycopy(this.f29093c, 0, obj, 0, i);
                }
                while (i < obj.length - 1) {
                    obj[i] = c5033a.m21226e();
                    c5033a.m21214a();
                    i++;
                }
                obj[i] = c5033a.m21226e();
                this.f29093c = obj;
            }
        }
    }

    /* renamed from: a */
    public final void mo4757a(C5035b c5035b) {
        if (this.f29093c != null && this.f29093c.length > 0) {
            for (long a : this.f29093c) {
                c5035b.m21298a(1, a);
            }
        }
        if (this.f29094d != null && this.f29094d.length > 0) {
            for (long a2 : this.f29094d) {
                c5035b.m21298a(2, a2);
            }
        }
        if (this.f29095e != null && this.f29095e.length > 0) {
            for (C5043j c5043j : this.f29095e) {
                if (c5043j != null) {
                    c5035b.m21299a(3, c5043j);
                }
            }
        }
        if (this.f29096f != null && this.f29096f.length > 0) {
            for (C5043j c5043j2 : this.f29096f) {
                if (c5043j2 != null) {
                    c5035b.m21299a(4, c5043j2);
                }
            }
        }
        super.mo4757a(c5035b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof go)) {
            return false;
        }
        go goVar = (go) obj;
        if (!C5041h.m21397a(this.f29093c, goVar.f29093c) || !C5041h.m21397a(this.f29094d, goVar.f29094d) || !C5041h.m21398a(this.f29095e, goVar.f29095e) || !C5041h.m21398a(this.f29096f, goVar.f29096f)) {
            return false;
        }
        if (this.a != null) {
            if (!this.a.m21363b()) {
                return this.a.equals(goVar.a);
            }
        }
        if (goVar.a != null) {
            if (!goVar.a.m21363b()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (((((((((getClass().getName().hashCode() + 527) * 31) + C5041h.m21394a(this.f29093c)) * 31) + C5041h.m21394a(this.f29094d)) * 31) + C5041h.m21395a(this.f29095e)) * 31) + C5041h.m21395a(this.f29096f)) * 31;
        if (this.a != null) {
            if (!this.a.m21363b()) {
                hashCode = this.a.hashCode();
                return hashCode2 + hashCode;
            }
        }
        hashCode = 0;
        return hashCode2 + hashCode;
    }
}
