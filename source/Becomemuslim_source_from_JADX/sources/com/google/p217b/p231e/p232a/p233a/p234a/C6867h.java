package com.google.p217b.p231e.p232a.p233a.p234a;

import com.google.p217b.p222b.C5196a;

/* compiled from: AI01decoder */
/* renamed from: com.google.b.e.a.a.a.h */
abstract class C6867h extends C5236j {
    C6867h(C5196a c5196a) {
        super(c5196a);
    }

    /* renamed from: b */
    final void m32280b(StringBuilder stringBuilder, int i) {
        stringBuilder.append("(01)");
        int length = stringBuilder.length();
        stringBuilder.append('9');
        m32279a(stringBuilder, i, length);
    }

    /* renamed from: a */
    final void m32279a(StringBuilder stringBuilder, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int a = m22182c().m22211a((i3 * 10) + i, 10);
            if (a / 100 == 0) {
                stringBuilder.append('0');
            }
            if (a / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(a);
        }
        C6867h.mo6259a(stringBuilder, i2);
    }

    /* renamed from: a */
    private static void mo6259a(StringBuilder stringBuilder, int i) {
        int i2;
        int i3 = 0;
        int i4 = 0;
        for (i2 = 0; i2 < 13; i2++) {
            int charAt = stringBuilder.charAt(i2 + i) - 48;
            if ((i2 & 1) == 0) {
                charAt *= 3;
            }
            i4 += charAt;
        }
        i2 = 10 - (i4 % 10);
        if (i2 != 10) {
            i3 = i2;
        }
        stringBuilder.append(i3);
    }
}
