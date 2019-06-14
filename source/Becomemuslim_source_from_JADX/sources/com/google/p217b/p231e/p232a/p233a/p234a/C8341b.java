package com.google.p217b.p231e.p232a.p233a.p234a;

import com.google.p217b.p222b.C5196a;

/* compiled from: AI01320xDecoder */
/* renamed from: com.google.b.e.a.a.a.b */
final class C8341b extends C8231f {
    /* renamed from: a */
    protected int mo6749a(int i) {
        return i < 10000 ? i : i - 10000;
    }

    C8341b(C5196a c5196a) {
        super(c5196a);
    }

    /* renamed from: a */
    protected void mo6259a(StringBuilder stringBuilder, int i) {
        if (i < 10000) {
            stringBuilder.append("(3202)");
        } else {
            stringBuilder.append("(3203)");
        }
    }
}
