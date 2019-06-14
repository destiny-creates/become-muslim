package com.google.p217b.p225c.p228c;

import com.facebook.imageutils.JfifUtil;

/* compiled from: EdifactEncoder */
/* renamed from: com.google.b.c.c.f */
final class C6864f implements C5226g {
    /* renamed from: a */
    public int m32273a() {
        return 4;
    }

    C6864f() {
    }

    /* renamed from: a */
    public void mo4866a(C5227h c5227h) {
        CharSequence stringBuilder = new StringBuilder();
        while (c5227h.m22126g()) {
            C6864f.m32271a(c5227h.m22119b(), (StringBuilder) stringBuilder);
            c5227h.f17641a++;
            if (stringBuilder.length() >= 4) {
                c5227h.m22118a(C6864f.m32270a(stringBuilder, 0));
                stringBuilder.delete(0, 4);
                if (C5229j.m22136a(c5227h.m22113a(), c5227h.f17641a, m32273a()) != m32273a()) {
                    c5227h.m22120b(0);
                    break;
                }
            }
        }
        stringBuilder.append('\u001f');
        C6864f.m32272a(c5227h, stringBuilder);
    }

    /* renamed from: a */
    private static void m32272a(C5227h c5227h, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length != 0) {
                int i = 1;
                if (length == 1) {
                    c5227h.m22129j();
                    int f = c5227h.m22128i().m22159f() - c5227h.m22123d();
                    int h = c5227h.m22127h();
                    if (h > f) {
                        c5227h.m22122c(c5227h.m22123d() + 1);
                        f = c5227h.m22128i().m22159f() - c5227h.m22123d();
                    }
                    if (h <= f && f <= 2) {
                        c5227h.m22120b(0);
                        return;
                    }
                }
                if (length <= 4) {
                    length--;
                    String a = C6864f.m32270a(charSequence, 0);
                    if ((c5227h.m22126g() ^ 1) == 0 || length > 2) {
                        i = 0;
                    }
                    if (length <= 2) {
                        c5227h.m22122c(c5227h.m22123d() + length);
                        if (c5227h.m22128i().m22159f() - c5227h.m22123d() >= 3) {
                            c5227h.m22122c(c5227h.m22123d() + a.length());
                            i = 0;
                        }
                    }
                    if (i != 0) {
                        c5227h.m22130k();
                        c5227h.f17641a -= length;
                    } else {
                        c5227h.m22118a(a);
                    }
                    c5227h.m22120b(0);
                    return;
                }
                throw new IllegalStateException("Count must not exceed 4");
            }
        } finally {
            c5227h.m22120b(0);
        }
    }

    /* renamed from: a */
    private static void m32271a(char c, StringBuilder stringBuilder) {
        if (c >= ' ' && c <= '?') {
            stringBuilder.append(c);
        } else if (c < '@' || c > '^') {
            C5229j.m22142c(c);
        } else {
            stringBuilder.append((char) (c - '@'));
        }
    }

    /* renamed from: a */
    private static String m32270a(CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length != 0) {
            char charAt = charSequence.charAt(i);
            int i2 = 0;
            int charAt2 = length >= 2 ? charSequence.charAt(i + 1) : 0;
            int charAt3 = length >= 3 ? charSequence.charAt(i + 2) : 0;
            if (length >= 4) {
                i2 = charSequence.charAt(i + 3);
            }
            charSequence = (((charAt << 18) + (charAt2 << 12)) + (charAt3 << 6)) + i2;
            i = (char) ((charSequence >> 16) & JfifUtil.MARKER_FIRST_BYTE);
            charAt = (char) ((charSequence >> 8) & JfifUtil.MARKER_FIRST_BYTE);
            charSequence = (char) (charSequence & JfifUtil.MARKER_FIRST_BYTE);
            StringBuilder stringBuilder = new StringBuilder(3);
            stringBuilder.append(i);
            if (length >= 2) {
                stringBuilder.append(charAt);
            }
            if (length >= 3) {
                stringBuilder.append(charSequence);
            }
            return stringBuilder.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }
}
