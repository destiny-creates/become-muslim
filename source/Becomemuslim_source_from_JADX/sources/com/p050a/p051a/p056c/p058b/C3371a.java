package com.p050a.p051a.p056c.p058b;

import android.graphics.PointF;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.p052a.p053a.C0880b;
import com.p050a.p051a.p052a.p053a.C4505e;
import com.p050a.p051a.p056c.p057a.C0893m;
import com.p050a.p051a.p056c.p057a.C4525f;
import com.p050a.p051a.p056c.p059c.C4529a;

/* compiled from: CircleShape */
/* renamed from: com.a.a.c.b.a */
public class C3371a implements C0895b {
    /* renamed from: a */
    private final String f8946a;
    /* renamed from: b */
    private final C0893m<PointF, PointF> f8947b;
    /* renamed from: c */
    private final C4525f f8948c;
    /* renamed from: d */
    private final boolean f8949d;

    public C3371a(String str, C0893m<PointF, PointF> c0893m, C4525f c4525f, boolean z) {
        this.f8946a = str;
        this.f8947b = c0893m;
        this.f8948c = c4525f;
        this.f8949d = z;
    }

    /* renamed from: a */
    public C0880b mo738a(C0957g c0957g, C4529a c4529a) {
        return new C4505e(c0957g, c4529a, this);
    }

    /* renamed from: a */
    public String m10697a() {
        return this.f8946a;
    }

    /* renamed from: b */
    public C0893m<PointF, PointF> m10698b() {
        return this.f8947b;
    }

    /* renamed from: c */
    public C4525f m10699c() {
        return this.f8948c;
    }

    /* renamed from: d */
    public boolean m10700d() {
        return this.f8949d;
    }
}
