package com.google.p217b.p231e.p232a.p233a.p234a;

import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5196a;

/* compiled from: AI013x0x1xDecoder */
/* renamed from: com.google.b.e.a.a.a.e */
final class C8230e extends C7899i {
    /* renamed from: a */
    private final String f32379a;
    /* renamed from: b */
    private final String f32380b;

    C8230e(C5196a c5196a, String str, String str2) {
        super(c5196a);
        this.f32379a = str2;
        this.f32380b = str;
    }

    /* renamed from: a */
    public String mo4869a() {
        if (m22181b().m21954a() == 84) {
            StringBuilder stringBuilder = new StringBuilder();
            m32280b(stringBuilder, 8);
            m38438b(stringBuilder, 48, 20);
            m42743c(stringBuilder, 68);
            return stringBuilder.toString();
        }
        throw C6894l.m32349a();
    }

    /* renamed from: c */
    private void m42743c(StringBuilder stringBuilder, int i) {
        i = m22182c().m22211a(i, 16);
        if (i != 38400) {
            stringBuilder.append('(');
            stringBuilder.append(this.f32379a);
            stringBuilder.append(')');
            int i2 = i % 32;
            i /= 32;
            int i3 = (i % 12) + 1;
            i /= 12;
            if (i / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(i);
            if (i3 / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(i3);
            if (i2 / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(i2);
        }
    }

    /* renamed from: a */
    protected void mo6259a(StringBuilder stringBuilder, int i) {
        stringBuilder.append('(');
        stringBuilder.append(this.f32380b);
        stringBuilder.append(i / 100000);
        stringBuilder.append(41);
    }

    /* renamed from: a */
    protected int mo6749a(int i) {
        return i % 100000;
    }
}
