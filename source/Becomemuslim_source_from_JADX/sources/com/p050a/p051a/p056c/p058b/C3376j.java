package com.p050a.p051a.p056c.p058b;

import android.graphics.PointF;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.p052a.p053a.C0880b;
import com.p050a.p051a.p052a.p053a.C4510n;
import com.p050a.p051a.p056c.p057a.C0893m;
import com.p050a.p051a.p056c.p057a.C4522b;
import com.p050a.p051a.p056c.p057a.C4525f;
import com.p050a.p051a.p056c.p059c.C4529a;

/* compiled from: RectangleShape */
/* renamed from: com.a.a.c.b.j */
public class C3376j implements C0895b {
    /* renamed from: a */
    private final String f8981a;
    /* renamed from: b */
    private final C0893m<PointF, PointF> f8982b;
    /* renamed from: c */
    private final C4525f f8983c;
    /* renamed from: d */
    private final C4522b f8984d;

    public C3376j(String str, C0893m<PointF, PointF> c0893m, C4525f c4525f, C4522b c4522b) {
        this.f8981a = str;
        this.f8982b = c0893m;
        this.f8983c = c4525f;
        this.f8984d = c4522b;
    }

    /* renamed from: a */
    public String m10735a() {
        return this.f8981a;
    }

    /* renamed from: b */
    public C4522b m10736b() {
        return this.f8984d;
    }

    /* renamed from: c */
    public C4525f m10737c() {
        return this.f8983c;
    }

    /* renamed from: d */
    public C0893m<PointF, PointF> m10738d() {
        return this.f8982b;
    }

    /* renamed from: a */
    public C0880b mo738a(C0957g c0957g, C4529a c4529a) {
        return new C4510n(c0957g, c4529a, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RectangleShape{position=");
        stringBuilder.append(this.f8982b);
        stringBuilder.append(", size=");
        stringBuilder.append(this.f8983c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
