package com.p050a.p051a.p056c.p058b;

import com.p050a.p051a.C0957g;
import com.p050a.p051a.p052a.p053a.C0880b;
import com.p050a.p051a.p052a.p053a.C4504c;
import com.p050a.p051a.p056c.p059c.C4529a;
import java.util.Arrays;
import java.util.List;

/* compiled from: ShapeGroup */
/* renamed from: com.a.a.c.b.n */
public class C3379n implements C0895b {
    /* renamed from: a */
    private final String f8994a;
    /* renamed from: b */
    private final List<C0895b> f8995b;

    public C3379n(String str, List<C0895b> list) {
        this.f8994a = str;
        this.f8995b = list;
    }

    /* renamed from: a */
    public String m10750a() {
        return this.f8994a;
    }

    /* renamed from: b */
    public List<C0895b> m10751b() {
        return this.f8995b;
    }

    /* renamed from: a */
    public C0880b mo738a(C0957g c0957g, C4529a c4529a) {
        return new C4504c(c0957g, c4529a, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShapeGroup{name='");
        stringBuilder.append(this.f8994a);
        stringBuilder.append("' Shapes: ");
        stringBuilder.append(Arrays.toString(this.f8995b.toArray()));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
