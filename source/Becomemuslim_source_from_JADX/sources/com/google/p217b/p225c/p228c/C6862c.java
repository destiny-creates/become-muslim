package com.google.p217b.p225c.p228c;

/* compiled from: C40Encoder */
/* renamed from: com.google.b.c.c.c */
class C6862c implements C5226g {
    /* renamed from: a */
    public int mo6256a() {
        return 1;
    }

    C6862c() {
    }

    /* renamed from: a */
    public void mo4866a(C5227h c5227h) {
        StringBuilder stringBuilder = new StringBuilder();
        while (c5227h.m22126g()) {
            char b = c5227h.m22119b();
            c5227h.f17641a++;
            int a = mo6257a(b, stringBuilder);
            int d = c5227h.m22123d() + ((stringBuilder.length() / 3) << 1);
            c5227h.m22122c(d);
            int f = c5227h.m22128i().m22159f() - d;
            if (c5227h.m22126g()) {
                if (stringBuilder.length() % 3 == 0 && C5229j.m22136a(c5227h.m22113a(), c5227h.f17641a, mo6256a()) != mo6256a()) {
                    c5227h.m22120b(0);
                    break;
                }
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                if (stringBuilder.length() % 3 == 2 && (f < 2 || f > 2)) {
                    a = m32261a(c5227h, stringBuilder, stringBuilder2, a);
                }
                while (stringBuilder.length() % 3 == 1 && ((a <= 3 && f != 1) || a > 3)) {
                    a = m32261a(c5227h, stringBuilder, stringBuilder2, a);
                }
            }
        }
        mo6258b(c5227h, stringBuilder);
    }

    /* renamed from: a */
    private int m32261a(C5227h c5227h, StringBuilder stringBuilder, StringBuilder stringBuilder2, int i) {
        int length = stringBuilder.length();
        stringBuilder.delete(length - i, length);
        c5227h.f17641a--;
        stringBuilder = mo6257a(c5227h.m22119b(), stringBuilder2);
        c5227h.m22130k();
        return stringBuilder;
    }

    /* renamed from: a */
    static void m32263a(C5227h c5227h, StringBuilder stringBuilder) {
        c5227h.m22118a(C6862c.m32262a((CharSequence) stringBuilder, 0));
        stringBuilder.delete(0, 3);
    }

    /* renamed from: b */
    void mo6258b(C5227h c5227h, StringBuilder stringBuilder) {
        int length = stringBuilder.length() % 3;
        int d = c5227h.m22123d() + ((stringBuilder.length() / 3) << 1);
        c5227h.m22122c(d);
        int f = c5227h.m22128i().m22159f() - d;
        if (length == 2) {
            stringBuilder.append('\u0000');
            while (stringBuilder.length() >= 3) {
                C6862c.m32263a(c5227h, stringBuilder);
            }
            if (c5227h.m22126g() != null) {
                c5227h.m22114a('þ');
            }
        } else if (f == 1 && length == 1) {
            while (stringBuilder.length() >= 3) {
                C6862c.m32263a(c5227h, stringBuilder);
            }
            if (c5227h.m22126g() != null) {
                c5227h.m22114a('þ');
            }
            c5227h.f17641a -= 1;
        } else if (length == 0) {
            while (stringBuilder.length() >= 3) {
                C6862c.m32263a(c5227h, stringBuilder);
            }
            if (f > 0 || c5227h.m22126g() != null) {
                c5227h.m22114a('þ');
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        c5227h.m22120b(0);
    }

    /* renamed from: a */
    int mo6257a(char c, StringBuilder stringBuilder) {
        if (c == ' ') {
            stringBuilder.append('\u0003');
            return 1;
        } else if (c >= '0' && c <= '9') {
            stringBuilder.append((char) ((c - '0') + 4));
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            stringBuilder.append((char) ((c - 'A') + 14));
            return 1;
        } else if (c < ' ') {
            stringBuilder.append('\u0000');
            stringBuilder.append(c);
            return 2;
        } else if (c >= '!' && c <= '/') {
            stringBuilder.append('\u0001');
            stringBuilder.append((char) (c - '!'));
            return 2;
        } else if (c >= ':' && c <= '@') {
            stringBuilder.append('\u0001');
            stringBuilder.append((char) ((c - ':') + 15));
            return 2;
        } else if (c >= '[' && c <= '_') {
            stringBuilder.append('\u0001');
            stringBuilder.append((char) ((c - '[') + 22));
            return 2;
        } else if (c < '`' || c > '') {
            stringBuilder.append("\u0001\u001e");
            return mo6257a((char) (c - 128), stringBuilder) + '\u0002';
        } else {
            stringBuilder.append('\u0002');
            stringBuilder.append((char) (c - '`'));
            return 2;
        }
    }

    /* renamed from: a */
    private static String m32262a(CharSequence charSequence, int i) {
        char charAt = (char) (((((charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * 40)) + charSequence.charAt(i + 2)) + 1) % 256);
        return new String(new char[]{(char) (r0 / 256), charAt});
    }
}
