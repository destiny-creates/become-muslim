package com.google.p217b.p231e.p232a.p233a.p234a;

import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5196a;

/* compiled from: AI01393xDecoder */
/* renamed from: com.google.b.e.a.a.a.d */
final class C7897d extends C6867h {
    C7897d(C5196a c5196a) {
        super(c5196a);
    }

    /* renamed from: a */
    public String mo4869a() {
        if (m22181b().m21954a() >= 48) {
            StringBuilder stringBuilder = new StringBuilder();
            m32280b(stringBuilder, 8);
            int a = m22182c().m22211a(48, 2);
            stringBuilder.append("(393");
            stringBuilder.append(a);
            stringBuilder.append(')');
            a = m22182c().m22211a(50, 10);
            if (a / 100 == 0) {
                stringBuilder.append('0');
            }
            if (a / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(a);
            stringBuilder.append(m22182c().m22212a(60, null).m32284a());
            return stringBuilder.toString();
        }
        throw C6894l.m32349a();
    }
}
