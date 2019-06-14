package com.p050a.p051a.p056c.p058b;

import com.p050a.p051a.C0957g;
import com.p050a.p051a.p052a.p053a.C0880b;
import com.p050a.p051a.p052a.p053a.C4512p;
import com.p050a.p051a.p056c.p057a.C4527h;
import com.p050a.p051a.p056c.p059c.C4529a;

/* compiled from: ShapePath */
/* renamed from: com.a.a.c.b.o */
public class C3380o implements C0895b {
    /* renamed from: a */
    private final String f8996a;
    /* renamed from: b */
    private final int f8997b;
    /* renamed from: c */
    private final C4527h f8998c;

    public C3380o(String str, int i, C4527h c4527h) {
        this.f8996a = str;
        this.f8997b = i;
        this.f8998c = c4527h;
    }

    /* renamed from: a */
    public String m10753a() {
        return this.f8996a;
    }

    /* renamed from: b */
    public C4527h m10754b() {
        return this.f8998c;
    }

    /* renamed from: a */
    public C0880b mo738a(C0957g c0957g, C4529a c4529a) {
        return new C4512p(c0957g, c4529a, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShapePath{name=");
        stringBuilder.append(this.f8996a);
        stringBuilder.append(", index=");
        stringBuilder.append(this.f8997b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
