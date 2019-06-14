package com.google.p217b.p225c.p228c;

import com.facebook.imageutils.JfifUtil;

/* compiled from: Base256Encoder */
/* renamed from: com.google.b.c.c.b */
final class C6861b implements C5226g {
    /* renamed from: a */
    public int m32259a() {
        return 5;
    }

    C6861b() {
    }

    /* renamed from: a */
    public void mo4866a(C5227h c5227h) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        stringBuilder.append('\u0000');
        while (c5227h.m22126g()) {
            stringBuilder.append(c5227h.m22119b());
            c5227h.f17641a++;
            if (C5229j.m22136a(c5227h.m22113a(), c5227h.f17641a, m32259a()) != m32259a()) {
                c5227h.m22120b(0);
                break;
            }
        }
        int length = stringBuilder.length() - 1;
        int d = (c5227h.m22123d() + length) + 1;
        c5227h.m22122c(d);
        Object obj = c5227h.m22128i().m22159f() - d > 0 ? 1 : null;
        if (c5227h.m22126g() || obj != null) {
            if (length <= 249) {
                stringBuilder.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                stringBuilder.setCharAt(0, (char) ((length / 250) + 249));
                stringBuilder.insert(1, (char) (length % 250));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
            }
        }
        length = stringBuilder.length();
        while (i < length) {
            c5227h.m22114a(C6861b.m32258a(stringBuilder.charAt(i), c5227h.m22123d() + 1));
            i++;
        }
    }

    /* renamed from: a */
    private static char m32258a(char c, int i) {
        c += ((i * 149) % JfifUtil.MARKER_FIRST_BYTE) + 1;
        return c <= 'ÿ' ? (char) c : (char) (c - 256);
    }
}
