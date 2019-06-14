package android.support.v7.widget;

import android.support.v4.util.Pools.C0447a;
import android.support.v4.util.Pools.SimplePool;
import android.support.v7.widget.RecyclerView.C0718x;
import android.support.v7.widget.ax.C0770a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AdapterHelper */
/* renamed from: android.support.v7.widget.f */
class C3319f implements C0770a {
    /* renamed from: a */
    final ArrayList<C0794b> f8827a;
    /* renamed from: b */
    final ArrayList<C0794b> f8828b;
    /* renamed from: c */
    final C0793a f8829c;
    /* renamed from: d */
    Runnable f8830d;
    /* renamed from: e */
    final boolean f8831e;
    /* renamed from: f */
    final ax f8832f;
    /* renamed from: g */
    private C0447a<C0794b> f8833g;
    /* renamed from: h */
    private int f8834h;

    /* compiled from: AdapterHelper */
    /* renamed from: android.support.v7.widget.f$a */
    interface C0793a {
        /* renamed from: a */
        C0718x mo568a(int i);

        /* renamed from: a */
        void mo569a(int i, int i2);

        /* renamed from: a */
        void mo570a(int i, int i2, Object obj);

        /* renamed from: a */
        void mo571a(C0794b c0794b);

        /* renamed from: b */
        void mo572b(int i, int i2);

        /* renamed from: b */
        void mo573b(C0794b c0794b);

        /* renamed from: c */
        void mo574c(int i, int i2);

        /* renamed from: d */
        void mo575d(int i, int i2);
    }

    /* compiled from: AdapterHelper */
    /* renamed from: android.support.v7.widget.f$b */
    static class C0794b {
        /* renamed from: a */
        int f2200a;
        /* renamed from: b */
        int f2201b;
        /* renamed from: c */
        Object f2202c;
        /* renamed from: d */
        int f2203d;

        C0794b(int i, int i2, int i3, Object obj) {
            this.f2200a = i;
            this.f2201b = i2;
            this.f2203d = i3;
            this.f2202c = obj;
        }

        /* renamed from: a */
        String m2869a() {
            int i = this.f2200a;
            if (i == 4) {
                return "up";
            }
            if (i == 8) {
                return "mv";
            }
            switch (i) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                default:
                    return "??";
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append("[");
            stringBuilder.append(m2869a());
            stringBuilder.append(",s:");
            stringBuilder.append(this.f2201b);
            stringBuilder.append("c:");
            stringBuilder.append(this.f2203d);
            stringBuilder.append(",p:");
            stringBuilder.append(this.f2202c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    C0794b c0794b = (C0794b) obj;
                    if (this.f2200a != c0794b.f2200a) {
                        return false;
                    }
                    if (this.f2200a == 8 && Math.abs(this.f2203d - this.f2201b) == 1 && this.f2203d == c0794b.f2201b && this.f2201b == c0794b.f2203d) {
                        return true;
                    }
                    if (this.f2203d != c0794b.f2203d || this.f2201b != c0794b.f2201b) {
                        return false;
                    }
                    if (this.f2202c != null) {
                        if (this.f2202c.equals(c0794b.f2202c) == null) {
                            return false;
                        }
                    } else if (c0794b.f2202c != null) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.f2200a * 31) + this.f2201b) * 31) + this.f2203d;
        }
    }

    C3319f(C0793a c0793a) {
        this(c0793a, false);
    }

    C3319f(C0793a c0793a, boolean z) {
        this.f8833g = new SimplePool(30);
        this.f8827a = new ArrayList();
        this.f8828b = new ArrayList();
        this.f8834h = 0;
        this.f8829c = c0793a;
        this.f8831e = z;
        this.f8832f = new ax(this);
    }

    /* renamed from: a */
    void m10605a() {
        m10608a(this.f8827a);
        m10608a(this.f8828b);
        this.f8834h = 0;
    }

    /* renamed from: b */
    void m10613b() {
        this.f8832f.m2684a(this.f8827a);
        int size = this.f8827a.size();
        for (int i = 0; i < size; i++) {
            C0794b c0794b = (C0794b) this.f8827a.get(i);
            int i2 = c0794b.f2200a;
            if (i2 == 4) {
                m10598d(c0794b);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        m10601f(c0794b);
                        break;
                    case 2:
                        m10596c(c0794b);
                        break;
                    default:
                        break;
                }
            } else {
                m10595b(c0794b);
            }
            if (this.f8830d != null) {
                this.f8830d.run();
            }
        }
        this.f8827a.clear();
    }

    /* renamed from: c */
    void m10616c() {
        int size = this.f8828b.size();
        for (int i = 0; i < size; i++) {
            this.f8829c.mo573b((C0794b) this.f8828b.get(i));
        }
        m10608a(this.f8828b);
        this.f8834h = 0;
    }

    /* renamed from: b */
    private void m10595b(C0794b c0794b) {
        m10602g(c0794b);
    }

    /* renamed from: c */
    private void m10596c(C0794b c0794b) {
        int i = c0794b.f2201b;
        int i2 = c0794b.f2201b + c0794b.f2203d;
        int i3 = c0794b.f2201b;
        int i4 = 0;
        Object obj = -1;
        while (i3 < i2) {
            Object obj2;
            if (this.f8829c.mo568a(i3) == null) {
                if (!m10599d(i3)) {
                    if (obj == 1) {
                        m10602g(mo703a(2, i, i4, null));
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    obj2 = null;
                    if (obj == null) {
                        i3 -= i4;
                        i2 -= i4;
                        i4 = 1;
                    } else {
                        i4++;
                    }
                    i3++;
                    obj = obj2;
                }
            }
            if (obj == null) {
                m10600e(mo703a(2, i, i4, null));
                obj = 1;
            } else {
                obj = null;
            }
            obj2 = 1;
            if (obj == null) {
                i4++;
            } else {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            }
            i3++;
            obj = obj2;
        }
        if (i4 != c0794b.f2203d) {
            mo704a(c0794b);
            c0794b = mo703a(2, i, i4, null);
        }
        if (obj == null) {
            m10600e(c0794b);
        } else {
            m10602g(c0794b);
        }
    }

    /* renamed from: d */
    private void m10598d(C0794b c0794b) {
        int i = c0794b.f2201b;
        int i2 = c0794b.f2201b + c0794b.f2203d;
        Object obj = -1;
        int i3 = i;
        i = 0;
        for (int i4 = c0794b.f2201b; i4 < i2; i4++) {
            if (this.f8829c.mo568a(i4) == null) {
                if (!m10599d(i4)) {
                    if (obj == 1) {
                        m10602g(mo703a(4, i3, i, c0794b.f2202c));
                        i3 = i4;
                        i = 0;
                    }
                    obj = null;
                    i++;
                }
            }
            if (obj == null) {
                m10600e(mo703a(4, i3, i, c0794b.f2202c));
                i3 = i4;
                i = 0;
            }
            obj = 1;
            i++;
        }
        if (i != c0794b.f2203d) {
            Object obj2 = c0794b.f2202c;
            mo704a(c0794b);
            c0794b = mo703a(4, i3, i, obj2);
        }
        if (obj == null) {
            m10600e(c0794b);
        } else {
            m10602g(c0794b);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    private void m10600e(android.support.v7.widget.C3319f.C0794b r13) {
        /*
        r12 = this;
        r0 = r13.f2200a;
        r1 = 1;
        if (r0 == r1) goto L_0x008d;
    L_0x0005:
        r0 = r13.f2200a;
        r2 = 8;
        if (r0 == r2) goto L_0x008d;
    L_0x000b:
        r0 = r13.f2201b;
        r2 = r13.f2200a;
        r0 = r12.m10597d(r0, r2);
        r2 = r13.f2201b;
        r3 = r13.f2200a;
        r4 = 2;
        r5 = 4;
        r6 = 0;
        if (r3 == r4) goto L_0x0037;
    L_0x001c:
        if (r3 != r5) goto L_0x0020;
    L_0x001e:
        r3 = 1;
        goto L_0x0038;
    L_0x0020:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "op should be remove or update.";
        r1.append(r2);
        r1.append(r13);
        r13 = r1.toString();
        r0.<init>(r13);
        throw r0;
    L_0x0037:
        r3 = 0;
    L_0x0038:
        r7 = r0;
        r8 = r2;
        r0 = 1;
        r2 = 1;
    L_0x003c:
        r9 = r13.f2203d;
        if (r0 >= r9) goto L_0x0079;
    L_0x0040:
        r9 = r13.f2201b;
        r10 = r3 * r0;
        r9 = r9 + r10;
        r10 = r13.f2200a;
        r9 = r12.m10597d(r9, r10);
        r10 = r13.f2200a;
        if (r10 == r4) goto L_0x0059;
    L_0x004f:
        if (r10 == r5) goto L_0x0053;
    L_0x0051:
        r10 = 0;
        goto L_0x005c;
    L_0x0053:
        r10 = r7 + 1;
        if (r9 != r10) goto L_0x0051;
    L_0x0057:
        r10 = 1;
        goto L_0x005c;
    L_0x0059:
        if (r9 != r7) goto L_0x0051;
    L_0x005b:
        goto L_0x0057;
    L_0x005c:
        if (r10 == 0) goto L_0x0061;
    L_0x005e:
        r2 = r2 + 1;
        goto L_0x0076;
    L_0x0061:
        r10 = r13.f2200a;
        r11 = r13.f2202c;
        r7 = r12.mo703a(r10, r7, r2, r11);
        r12.m10607a(r7, r8);
        r12.mo704a(r7);
        r7 = r13.f2200a;
        if (r7 != r5) goto L_0x0074;
    L_0x0073:
        r8 = r8 + r2;
    L_0x0074:
        r7 = r9;
        r2 = 1;
    L_0x0076:
        r0 = r0 + 1;
        goto L_0x003c;
    L_0x0079:
        r0 = r13.f2202c;
        r12.mo704a(r13);
        if (r2 <= 0) goto L_0x008c;
    L_0x0080:
        r13 = r13.f2200a;
        r13 = r12.mo703a(r13, r7, r2, r0);
        r12.m10607a(r13, r8);
        r12.mo704a(r13);
    L_0x008c:
        return;
    L_0x008d:
        r13 = new java.lang.IllegalArgumentException;
        r0 = "should not dispatch add or move for pre layout";
        r13.<init>(r0);
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.f.e(android.support.v7.widget.f$b):void");
    }

    /* renamed from: a */
    void m10607a(C0794b c0794b, int i) {
        this.f8829c.mo571a(c0794b);
        int i2 = c0794b.f2200a;
        if (i2 == 2) {
            this.f8829c.mo569a(i, c0794b.f2203d);
        } else if (i2 == 4) {
            this.f8829c.mo570a(i, c0794b.f2203d, c0794b.f2202c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* renamed from: d */
    private int m10597d(int i, int i2) {
        for (int size = this.f8828b.size() - 1; size >= 0; size--) {
            C0794b c0794b = (C0794b) this.f8828b.get(size);
            if (c0794b.f2200a == 8) {
                int i3;
                int i4;
                if (c0794b.f2201b < c0794b.f2203d) {
                    i3 = c0794b.f2201b;
                    i4 = c0794b.f2203d;
                } else {
                    i3 = c0794b.f2203d;
                    i4 = c0794b.f2201b;
                }
                if (i < i3 || i > r4) {
                    if (i < c0794b.f2201b) {
                        if (i2 == 1) {
                            c0794b.f2201b++;
                            c0794b.f2203d++;
                        } else if (i2 == 2) {
                            c0794b.f2201b--;
                            c0794b.f2203d--;
                        }
                    }
                } else if (i3 == c0794b.f2201b) {
                    if (i2 == 1) {
                        c0794b.f2203d++;
                    } else if (i2 == 2) {
                        c0794b.f2203d--;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        c0794b.f2201b++;
                    } else if (i2 == 2) {
                        c0794b.f2201b--;
                    }
                    i--;
                }
            } else if (c0794b.f2201b <= i) {
                if (c0794b.f2200a == 1) {
                    i -= c0794b.f2203d;
                } else if (c0794b.f2200a == 2) {
                    i += c0794b.f2203d;
                }
            } else if (i2 == 1) {
                c0794b.f2201b++;
            } else if (i2 == 2) {
                c0794b.f2201b--;
            }
        }
        for (i2 = this.f8828b.size() - 1; i2 >= 0; i2--) {
            C0794b c0794b2 = (C0794b) this.f8828b.get(i2);
            if (c0794b2.f2200a == 8) {
                if (c0794b2.f2203d == c0794b2.f2201b || c0794b2.f2203d < 0) {
                    this.f8828b.remove(i2);
                    mo704a(c0794b2);
                }
            } else if (c0794b2.f2203d <= 0) {
                this.f8828b.remove(i2);
                mo704a(c0794b2);
            }
        }
        return i;
    }

    /* renamed from: d */
    private boolean m10599d(int i) {
        int size = this.f8828b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0794b c0794b = (C0794b) this.f8828b.get(i2);
            if (c0794b.f2200a == 8) {
                if (m10603a(c0794b.f2203d, i2 + 1) == i) {
                    return true;
                }
            } else if (c0794b.f2200a == 1) {
                int i3 = c0794b.f2201b + c0794b.f2203d;
                for (int i4 = c0794b.f2201b; i4 < i3; i4++) {
                    if (m10603a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    /* renamed from: f */
    private void m10601f(C0794b c0794b) {
        m10602g(c0794b);
    }

    /* renamed from: g */
    private void m10602g(C0794b c0794b) {
        this.f8828b.add(c0794b);
        int i = c0794b.f2200a;
        if (i == 4) {
            this.f8829c.mo570a(c0794b.f2201b, c0794b.f2203d, c0794b.f2202c);
        } else if (i != 8) {
            switch (i) {
                case 1:
                    this.f8829c.mo574c(c0794b.f2201b, c0794b.f2203d);
                    return;
                case 2:
                    this.f8829c.mo572b(c0794b.f2201b, c0794b.f2203d);
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown update op type for ");
                    stringBuilder.append(c0794b);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        } else {
            this.f8829c.mo575d(c0794b.f2201b, c0794b.f2203d);
        }
    }

    /* renamed from: d */
    boolean m10618d() {
        return this.f8827a.size() > 0;
    }

    /* renamed from: a */
    boolean m10609a(int i) {
        return (i & this.f8834h) != 0;
    }

    /* renamed from: b */
    int m10612b(int i) {
        return m10603a(i, 0);
    }

    /* renamed from: a */
    int m10603a(int i, int i2) {
        int size = this.f8828b.size();
        while (i2 < size) {
            C0794b c0794b = (C0794b) this.f8828b.get(i2);
            if (c0794b.f2200a == 8) {
                if (c0794b.f2201b == i) {
                    i = c0794b.f2203d;
                } else {
                    if (c0794b.f2201b < i) {
                        i--;
                    }
                    if (c0794b.f2203d <= i) {
                        i++;
                    }
                }
            } else if (c0794b.f2201b > i) {
                continue;
            } else if (c0794b.f2200a == 2) {
                if (i < c0794b.f2201b + c0794b.f2203d) {
                    return -1;
                }
                i -= c0794b.f2203d;
            } else if (c0794b.f2200a == 1) {
                i += c0794b.f2203d;
            }
            i2++;
        }
        return i;
    }

    /* renamed from: a */
    boolean m10611a(int i, int i2, Object obj) {
        boolean z = false;
        if (i2 < 1) {
            return false;
        }
        this.f8827a.add(mo703a(4, i, i2, obj));
        this.f8834h |= 4;
        if (this.f8827a.size() == 1) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    boolean m10614b(int i, int i2) {
        boolean z = false;
        if (i2 < 1) {
            return false;
        }
        this.f8827a.add(mo703a(1, i, i2, null));
        this.f8834h |= 1;
        if (this.f8827a.size() == 1) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    boolean m10617c(int i, int i2) {
        boolean z = false;
        if (i2 < 1) {
            return false;
        }
        this.f8827a.add(mo703a(2, i, i2, null));
        this.f8834h |= 2;
        if (this.f8827a.size() == 1) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    boolean m10610a(int i, int i2, int i3) {
        boolean z = false;
        if (i == i2) {
            return false;
        }
        if (i3 == 1) {
            this.f8827a.add(mo703a(8, i, i2, null));
            this.f8834h |= 8;
            if (this.f8827a.size() == 1) {
                z = true;
            }
            return z;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* renamed from: e */
    void m10619e() {
        m10616c();
        int size = this.f8827a.size();
        for (int i = 0; i < size; i++) {
            C0794b c0794b = (C0794b) this.f8827a.get(i);
            int i2 = c0794b.f2200a;
            if (i2 == 4) {
                this.f8829c.mo573b(c0794b);
                this.f8829c.mo570a(c0794b.f2201b, c0794b.f2203d, c0794b.f2202c);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        this.f8829c.mo573b(c0794b);
                        this.f8829c.mo574c(c0794b.f2201b, c0794b.f2203d);
                        break;
                    case 2:
                        this.f8829c.mo573b(c0794b);
                        this.f8829c.mo569a(c0794b.f2201b, c0794b.f2203d);
                        break;
                    default:
                        break;
                }
            } else {
                this.f8829c.mo573b(c0794b);
                this.f8829c.mo575d(c0794b.f2201b, c0794b.f2203d);
            }
            if (this.f8830d != null) {
                this.f8830d.run();
            }
        }
        m10608a(this.f8827a);
        this.f8834h = 0;
    }

    /* renamed from: c */
    public int m10615c(int i) {
        int size = this.f8827a.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0794b c0794b = (C0794b) this.f8827a.get(i2);
            int i3 = c0794b.f2200a;
            if (i3 != 8) {
                switch (i3) {
                    case 1:
                        if (c0794b.f2201b > i) {
                            break;
                        }
                        i += c0794b.f2203d;
                        break;
                    case 2:
                        if (c0794b.f2201b <= i) {
                            if (c0794b.f2201b + c0794b.f2203d <= i) {
                                i -= c0794b.f2203d;
                                break;
                            }
                            return -1;
                        }
                        continue;
                    default:
                        break;
                }
            } else if (c0794b.f2201b == i) {
                i = c0794b.f2203d;
            } else {
                if (c0794b.f2201b < i) {
                    i--;
                }
                if (c0794b.f2203d <= i) {
                    i++;
                }
            }
        }
        return i;
    }

    /* renamed from: f */
    boolean m10620f() {
        return (this.f8828b.isEmpty() || this.f8827a.isEmpty()) ? false : true;
    }

    /* renamed from: a */
    public C0794b mo703a(int i, int i2, int i3, Object obj) {
        C0794b c0794b = (C0794b) this.f8833g.acquire();
        if (c0794b == null) {
            return new C0794b(i, i2, i3, obj);
        }
        c0794b.f2200a = i;
        c0794b.f2201b = i2;
        c0794b.f2203d = i3;
        c0794b.f2202c = obj;
        return c0794b;
    }

    /* renamed from: a */
    public void mo704a(C0794b c0794b) {
        if (!this.f8831e) {
            c0794b.f2202c = null;
            this.f8833g.release(c0794b);
        }
    }

    /* renamed from: a */
    void m10608a(List<C0794b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo704a((C0794b) list.get(i));
        }
        list.clear();
    }
}
