package com.p050a.p051a.p056c.p058b;

import android.graphics.Path.FillType;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.p052a.p053a.C0880b;
import com.p050a.p051a.p052a.p053a.C4506f;
import com.p050a.p051a.p056c.p057a.C4521a;
import com.p050a.p051a.p056c.p057a.C4524d;
import com.p050a.p051a.p056c.p059c.C4529a;

/* compiled from: ShapeFill */
/* renamed from: com.a.a.c.b.m */
public class C3378m implements C0895b {
    /* renamed from: a */
    private final boolean f8989a;
    /* renamed from: b */
    private final FillType f8990b;
    /* renamed from: c */
    private final String f8991c;
    /* renamed from: d */
    private final C4521a f8992d;
    /* renamed from: e */
    private final C4524d f8993e;

    public C3378m(String str, boolean z, FillType fillType, C4521a c4521a, C4524d c4524d) {
        this.f8991c = str;
        this.f8989a = z;
        this.f8990b = fillType;
        this.f8992d = c4521a;
        this.f8993e = c4524d;
    }

    /* renamed from: a */
    public String m10745a() {
        return this.f8991c;
    }

    /* renamed from: b */
    public C4521a m10746b() {
        return this.f8992d;
    }

    /* renamed from: c */
    public C4524d m10747c() {
        return this.f8993e;
    }

    /* renamed from: d */
    public FillType m10748d() {
        return this.f8990b;
    }

    /* renamed from: a */
    public C0880b mo738a(C0957g c0957g, C4529a c4529a) {
        return new C4506f(c0957g, c4529a, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShapeFill{color=, fillEnabled=");
        stringBuilder.append(this.f8989a);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
