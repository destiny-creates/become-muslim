package com.google.p217b.p225c.p228c;

/* compiled from: ASCIIEncoder */
/* renamed from: com.google.b.c.c.a */
final class C6860a implements C5226g {
    /* renamed from: a */
    public int m32256a() {
        return 0;
    }

    C6860a() {
    }

    /* renamed from: a */
    public void mo4866a(C5227h c5227h) {
        if (C5229j.m22135a(c5227h.m22113a(), c5227h.f17641a) >= 2) {
            c5227h.m22114a(C6860a.m32255a(c5227h.m22113a().charAt(c5227h.f17641a), c5227h.m22113a().charAt(c5227h.f17641a + 1)));
            c5227h.f17641a += 2;
            return;
        }
        char b = c5227h.m22119b();
        int a = C5229j.m22136a(c5227h.m22113a(), c5227h.f17641a, m32256a());
        if (a != m32256a()) {
            switch (a) {
                case 1:
                    c5227h.m22114a('æ');
                    c5227h.m22120b(1);
                    return;
                case 2:
                    c5227h.m22114a('ï');
                    c5227h.m22120b(2);
                    return;
                case 3:
                    c5227h.m22114a('î');
                    c5227h.m22120b(3);
                    return;
                case 4:
                    c5227h.m22114a('ð');
                    c5227h.m22120b(4);
                    return;
                case 5:
                    c5227h.m22114a('ç');
                    c5227h.m22120b(5);
                    return;
                default:
                    throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(a)));
            }
        } else if (C5229j.m22141b(b)) {
            c5227h.m22114a('ë');
            c5227h.m22114a((char) ((b - 128) + 1));
            c5227h.f17641a++;
        } else {
            c5227h.m22114a((char) (b + 1));
            c5227h.f17641a++;
        }
    }

    /* renamed from: a */
    private static char m32255a(char c, char c2) {
        if (C5229j.m22140a(c) && C5229j.m22140a(c2)) {
            return (char) ((((c - 48) * 10) + (c2 - 48)) + 130);
        }
        StringBuilder stringBuilder = new StringBuilder("not digits: ");
        stringBuilder.append(c);
        stringBuilder.append(c2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
