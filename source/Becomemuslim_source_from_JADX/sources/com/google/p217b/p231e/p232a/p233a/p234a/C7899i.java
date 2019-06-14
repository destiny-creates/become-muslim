package com.google.p217b.p231e.p232a.p233a.p234a;

import com.google.p217b.p222b.C5196a;

/* compiled from: AI01weightDecoder */
/* renamed from: com.google.b.e.a.a.a.i */
abstract class C7899i extends C6867h {
    /* renamed from: a */
    protected abstract int mo6749a(int i);

    /* renamed from: a */
    protected abstract void mo6259a(StringBuilder stringBuilder, int i);

    C7899i(C5196a c5196a) {
        super(c5196a);
    }

    /* renamed from: b */
    final void m38438b(StringBuilder stringBuilder, int i, int i2) {
        i = m22182c().m22211a(i, i2);
        mo6259a(stringBuilder, i);
        i = mo6749a(i);
        i2 = 100000;
        for (int i3 = 0; i3 < 5; i3++) {
            if (i / i2 == 0) {
                stringBuilder.append('0');
            }
            i2 /= 10;
        }
        stringBuilder.append(i);
    }
}
