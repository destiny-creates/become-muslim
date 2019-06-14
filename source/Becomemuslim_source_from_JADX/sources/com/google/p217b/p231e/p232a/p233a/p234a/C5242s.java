package com.google.p217b.p231e.p232a.p233a.p234a;

import com.google.p217b.C6891h;
import com.google.p217b.p222b.C5196a;

/* compiled from: GeneralAppIdDecoder */
/* renamed from: com.google.b.e.a.a.a.s */
final class C5242s {
    /* renamed from: a */
    private final C5196a f17690a;
    /* renamed from: b */
    private final C5239m f17691b = new C5239m();
    /* renamed from: c */
    private final StringBuilder f17692c = new StringBuilder();

    C5242s(C5196a c5196a) {
        this.f17690a = c5196a;
    }

    /* renamed from: a */
    String m22213a(StringBuilder stringBuilder, int i) {
        String str = null;
        while (true) {
            C6870o a = m22212a(i, str);
            String a2 = C5241r.m22195a(a.m32284a());
            if (a2 != null) {
                stringBuilder.append(a2);
            }
            a2 = a.m32285b() ? String.valueOf(a.m32286c()) : null;
            if (i == a.m22193e()) {
                return stringBuilder.toString();
            }
            i = a.m22193e();
            str = a2;
        }
    }

    /* renamed from: a */
    private boolean m22199a(int i) {
        if (i + 7 <= this.f17690a.m21954a()) {
            int i2 = i;
            while (true) {
                int i3 = i + 3;
                if (i2 >= i3) {
                    return this.f17690a.m21959a(i3);
                }
                if (this.f17690a.m21959a(i2)) {
                    return true;
                }
                i2++;
            }
        } else if (i + 4 <= this.f17690a.m21954a()) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: b */
    private C6871p m22201b(int i) {
        int i2 = i + 7;
        if (i2 > this.f17690a.m21954a()) {
            i = m22211a(i, 4);
            if (i == 0) {
                return new C6871p(this.f17690a.m21954a(), 10, 10);
            }
            return new C6871p(this.f17690a.m21954a(), i - 1, 10);
        }
        i = m22211a(i, 7) - 8;
        return new C6871p(i2, i / 11, i % 11);
    }

    /* renamed from: a */
    int m22211a(int i, int i2) {
        return C5242s.m22197a(this.f17690a, i, i2);
    }

    /* renamed from: a */
    static int m22197a(C5196a c5196a, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (c5196a.m21959a(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    /* renamed from: a */
    C6870o m22212a(int i, String str) {
        this.f17692c.setLength(0);
        if (str != null) {
            this.f17692c.append(str);
        }
        this.f17691b.m22186a(i);
        i = m22198a();
        if (i == 0 || i.m32285b() == null) {
            return new C6870o(this.f17691b.m22185a(), this.f17692c.toString());
        }
        return new C6870o(this.f17691b.m22185a(), this.f17692c.toString(), i.m32286c());
    }

    /* renamed from: a */
    private C6870o m22198a() {
        C5237l d;
        boolean b;
        do {
            int a = this.f17691b.m22185a();
            if (this.f17691b.m22188b()) {
                d = m22204d();
                b = d.m22184b();
            } else if (this.f17691b.m22189c()) {
                d = m22202c();
                b = d.m22184b();
            } else {
                d = m22200b();
                b = d.m22184b();
            }
            if ((a != this.f17691b.m22185a() ? 1 : null) == null && !b) {
                break;
            }
        } while (!b);
        return d.m22183a();
    }

    /* renamed from: b */
    private C5237l m22200b() {
        while (m22199a(this.f17691b.m22185a())) {
            C6871p b = m22201b(this.f17691b.m22185a());
            this.f17691b.m22186a(b.m22193e());
            if (b.m32289c()) {
                C6870o c6870o;
                if (b.m32290d()) {
                    c6870o = new C6870o(this.f17691b.m22185a(), this.f17692c.toString());
                } else {
                    c6870o = new C6870o(this.f17691b.m22185a(), this.f17692c.toString(), b.m32288b());
                }
                return new C5237l(c6870o, true);
            }
            this.f17692c.append(b.m32287a());
            if (b.m32290d()) {
                return new C5237l(new C6870o(this.f17691b.m22185a(), this.f17692c.toString()), true);
            }
            this.f17692c.append(b.m32288b());
        }
        if (m22210i(this.f17691b.m22185a())) {
            this.f17691b.m22191e();
            this.f17691b.m22187b(4);
        }
        return new C5237l(false);
    }

    /* renamed from: c */
    private C5237l m22202c() {
        while (m22203c(this.f17691b.m22185a())) {
            C6869n d = m22205d(this.f17691b.m22185a());
            this.f17691b.m22186a(d.m22193e());
            if (d.m32283b()) {
                return new C5237l(new C6870o(this.f17691b.m22185a(), this.f17692c.toString()), true);
            }
            this.f17692c.append(d.m32282a());
        }
        if (m22209h(this.f17691b.m22185a())) {
            this.f17691b.m22187b(3);
            this.f17691b.m22190d();
        } else if (m22208g(this.f17691b.m22185a())) {
            if (this.f17691b.m22185a() + 5 < this.f17690a.m21954a()) {
                this.f17691b.m22187b(5);
            } else {
                this.f17691b.m22186a(this.f17690a.m21954a());
            }
            this.f17691b.m22191e();
        }
        return new C5237l(false);
    }

    /* renamed from: d */
    private C5237l m22204d() {
        while (m22206e(this.f17691b.m22185a())) {
            C6869n f = m22207f(this.f17691b.m22185a());
            this.f17691b.m22186a(f.m22193e());
            if (f.m32283b()) {
                return new C5237l(new C6870o(this.f17691b.m22185a(), this.f17692c.toString()), true);
            }
            this.f17692c.append(f.m32282a());
        }
        if (m22209h(this.f17691b.m22185a())) {
            this.f17691b.m22187b(3);
            this.f17691b.m22190d();
        } else if (m22208g(this.f17691b.m22185a())) {
            if (this.f17691b.m22185a() + 5 < this.f17690a.m21954a()) {
                this.f17691b.m22187b(5);
            } else {
                this.f17691b.m22186a(this.f17690a.m21954a());
            }
            this.f17691b.m22192f();
        }
        return new C5237l(false);
    }

    /* renamed from: c */
    private boolean m22203c(int i) {
        if (i + 5 > this.f17690a.m21954a()) {
            return false;
        }
        int a = m22211a(i, 5);
        if (a >= 5 && a < 16) {
            return true;
        }
        if (i + 7 > this.f17690a.m21954a()) {
            return false;
        }
        int a2 = m22211a(i, 7);
        if (a2 >= 64 && a2 < 116) {
            return true;
        }
        if (i + 8 > this.f17690a.m21954a()) {
            return false;
        }
        i = m22211a(i, 8);
        if (i < 232 || i >= 253) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    private C6869n m22205d(int i) {
        int a = m22211a(i, 5);
        if (a == 15) {
            return new C6869n(i + 5, '$');
        }
        if (a >= 5 && a < 15) {
            return new C6869n(i + 5, (char) ((a + 48) - 5));
        }
        a = m22211a(i, 7);
        if (a >= 64 && a < 90) {
            return new C6869n(i + 7, (char) (a + 1));
        }
        if (a >= 90 && a < 116) {
            return new C6869n(i + 7, (char) (a + 7));
        }
        char c;
        switch (m22211a(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = '\"';
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = '&';
                break;
            case 236:
                c = '\'';
                break;
            case 237:
                c = '(';
                break;
            case 238:
                c = ')';
                break;
            case 239:
                c = '*';
                break;
            case 240:
                c = '+';
                break;
            case 241:
                c = ',';
                break;
            case 242:
                c = '-';
                break;
            case 243:
                c = '.';
                break;
            case 244:
                c = '/';
                break;
            case 245:
                c = ':';
                break;
            case 246:
                c = ';';
                break;
            case 247:
                c = '<';
                break;
            case 248:
                c = '=';
                break;
            case 249:
                c = '>';
                break;
            case 250:
                c = '?';
                break;
            case 251:
                c = '_';
                break;
            case 252:
                c = ' ';
                break;
            default:
                throw C6891h.m32342a();
        }
        return new C6869n(i + 8, c);
    }

    /* renamed from: e */
    private boolean m22206e(int i) {
        if (i + 5 > this.f17690a.m21954a()) {
            return false;
        }
        int a = m22211a(i, 5);
        if (a >= 5 && a < 16) {
            return true;
        }
        if (i + 6 > this.f17690a.m21954a()) {
            return false;
        }
        i = m22211a(i, 6);
        if (i < 16 || i >= 63) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    private C6869n m22207f(int i) {
        int a = m22211a(i, 5);
        if (a == 15) {
            return new C6869n(i + 5, '$');
        }
        if (a >= 5 && a < 15) {
            return new C6869n(i + 5, (char) ((a + 48) - 5));
        }
        a = m22211a(i, 6);
        if (a >= 32 && a < 58) {
            return new C6869n(i + 6, (char) (a + 33));
        }
        char c;
        switch (a) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(a)));
        }
        return new C6869n(i + 6, c);
    }

    /* renamed from: g */
    private boolean m22208g(int i) {
        if (i + 1 > this.f17690a.m21954a()) {
            return false;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = i2 + i;
            if (i3 >= this.f17690a.m21954a()) {
                break;
            }
            if (i2 == 2) {
                if (!this.f17690a.m21959a(i + 2)) {
                    return false;
                }
            } else if (this.f17690a.m21959a(i3)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: h */
    private boolean m22209h(int i) {
        int i2 = i + 3;
        if (i2 > this.f17690a.m21954a()) {
            return false;
        }
        while (i < i2) {
            if (this.f17690a.m21959a(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* renamed from: i */
    private boolean m22210i(int i) {
        if (i + 1 > this.f17690a.m21954a()) {
            return false;
        }
        int i2 = 0;
        while (i2 < 4) {
            int i3 = i2 + i;
            if (i3 >= this.f17690a.m21954a()) {
                break;
            } else if (this.f17690a.m21959a(i3)) {
                return false;
            } else {
                i2++;
            }
        }
        return true;
    }
}
