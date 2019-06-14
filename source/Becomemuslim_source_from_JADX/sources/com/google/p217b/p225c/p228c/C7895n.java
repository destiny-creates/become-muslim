package com.google.p217b.p225c.p228c;

/* compiled from: X12Encoder */
/* renamed from: com.google.b.c.c.n */
final class C7895n extends C6862c {
    /* renamed from: a */
    public int mo6256a() {
        return 3;
    }

    C7895n() {
    }

    /* renamed from: a */
    public void mo4866a(C5227h c5227h) {
        StringBuilder stringBuilder = new StringBuilder();
        while (c5227h.m22126g()) {
            char b = c5227h.m22119b();
            c5227h.f17641a++;
            mo6257a(b, stringBuilder);
            if (stringBuilder.length() % 3 == 0) {
                C6862c.m32263a(c5227h, stringBuilder);
                if (C5229j.m22136a(c5227h.m22113a(), c5227h.f17641a, mo6256a()) != mo6256a()) {
                    c5227h.m22120b(0);
                    break;
                }
            }
        }
        mo6258b(c5227h, stringBuilder);
    }

    /* renamed from: a */
    int mo6257a(char c, StringBuilder stringBuilder) {
        if (c == '\r') {
            stringBuilder.append('\u0000');
        } else if (c == ' ') {
            stringBuilder.append('\u0003');
        } else if (c == '*') {
            stringBuilder.append('\u0001');
        } else if (c == '>') {
            stringBuilder.append('\u0002');
        } else if (c >= '0' && c <= '9') {
            stringBuilder.append((char) ((c - '0') + 4));
        } else if (c < 'A' || c > 'Z') {
            C5229j.m22142c(c);
        } else {
            stringBuilder.append((char) ((c - 'A') + 14));
        }
        return 1;
    }

    /* renamed from: b */
    void mo6258b(C5227h c5227h, StringBuilder stringBuilder) {
        c5227h.m22129j();
        int f = c5227h.m22128i().m22159f() - c5227h.m22123d();
        c5227h.f17641a -= stringBuilder.length();
        if (c5227h.m22127h() > 1 || f > 1 || c5227h.m22127h() != f) {
            c5227h.m22114a('þ');
        }
        if (c5227h.m22124e() < null) {
            c5227h.m22120b(null);
        }
    }
}
