package com.p050a.p051a.p052a.p053a;

import android.graphics.Path;
import android.graphics.PointF;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.C0959i;
import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p056c.C0917e;
import com.p050a.p051a.p056c.p058b.C3371a;
import com.p050a.p051a.p056c.p058b.C3382q.C0906a;
import com.p050a.p051a.p056c.p059c.C4529a;
import com.p050a.p051a.p061e.C0947e;
import com.p050a.p051a.p061e.C0948f;
import com.p050a.p051a.p062f.C0952c;
import java.util.List;

/* compiled from: EllipseContent */
/* renamed from: com.a.a.a.a.e */
public class C4505e implements C3359j, C3360l, C0884a {
    /* renamed from: a */
    private final Path f12128a = new Path();
    /* renamed from: b */
    private final String f12129b;
    /* renamed from: c */
    private final C0957g f12130c;
    /* renamed from: d */
    private final C0885a<?, PointF> f12131d;
    /* renamed from: e */
    private final C0885a<?, PointF> f12132e;
    /* renamed from: f */
    private final C3371a f12133f;
    /* renamed from: g */
    private C3361r f12134g;
    /* renamed from: h */
    private boolean f12135h;

    public C4505e(C0957g c0957g, C4529a c4529a, C3371a c3371a) {
        this.f12129b = c3371a.m10697a();
        this.f12130c = c0957g;
        this.f12131d = c3371a.m10699c().mo737a();
        this.f12132e = c3371a.m10698b().mo737a();
        this.f12133f = c3371a;
        c4529a.m15378a(this.f12131d);
        c4529a.m15378a(this.f12132e);
        this.f12131d.m3133a((C0884a) this);
        this.f12132e.m3133a((C0884a) this);
    }

    /* renamed from: a */
    public void mo728a() {
        m15277c();
    }

    /* renamed from: c */
    private void m15277c() {
        this.f12135h = false;
        this.f12130c.invalidateSelf();
    }

    /* renamed from: a */
    public void mo729a(List<C0880b> list, List<C0880b> list2) {
        for (list2 = null; list2 < list.size(); list2++) {
            C0880b c0880b = (C0880b) list.get(list2);
            if (c0880b instanceof C3361r) {
                C3361r c3361r = (C3361r) c0880b;
                if (c3361r.m10669c() == C0906a.Simultaneously) {
                    this.f12134g = c3361r;
                    this.f12134g.m10666a(this);
                }
            }
        }
    }

    /* renamed from: b */
    public String mo730b() {
        return this.f12129b;
    }

    /* renamed from: e */
    public Path mo2793e() {
        if (this.f12135h) {
            return r0.f12128a;
        }
        r0.f12128a.reset();
        PointF pointF = (PointF) r0.f12131d.mo733e();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        r0.f12128a.reset();
        float f5;
        if (r0.f12133f.m10700d()) {
            float f6 = -f2;
            r0.f12128a.moveTo(0.0f, f6);
            float f7 = 0.0f - f3;
            float f8 = -f;
            float f9 = 0.0f - f4;
            r0.f12128a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            f4 += 0.0f;
            f5 = f6;
            r0.f12128a.cubicTo(f8, f4, f7, f2, 0.0f, f2);
            f3 += 0.0f;
            r0.f12128a.cubicTo(f3, f2, f, f4, f, 0.0f);
            r0.f12128a.cubicTo(f, f9, f3, f5, 0.0f, f5);
        } else {
            float f10 = -f2;
            r0.f12128a.moveTo(0.0f, f10);
            f5 = f3 + 0.0f;
            float f11 = 0.0f - f4;
            r0.f12128a.cubicTo(f5, f10, f, f11, f, 0.0f);
            f4 += 0.0f;
            r0.f12128a.cubicTo(f, f4, f5, f2, 0.0f, f2);
            f3 = 0.0f - f3;
            float f12 = -f;
            r0.f12128a.cubicTo(f3, f2, f12, f4, f12, 0.0f);
            f2 = f10;
            r0.f12128a.cubicTo(f12, f11, f3, f2, 0.0f, f2);
        }
        pointF = (PointF) r0.f12132e.mo733e();
        r0.f12128a.offset(pointF.x, pointF.y);
        r0.f12128a.close();
        C0948f.m3318a(r0.f12128a, r0.f12134g);
        r0.f12135h = true;
        return r0.f12128a;
    }

    /* renamed from: a */
    public void mo2791a(C0917e c0917e, int i, List<C0917e> list, C0917e c0917e2) {
        C0947e.m3309a(c0917e, i, list, c0917e2, this);
    }

    /* renamed from: a */
    public <T> void mo2792a(T t, C0952c<T> c0952c) {
        if (t == C0959i.f2707g) {
            this.f12131d.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2708h) {
            this.f12132e.m3134a((C0952c) c0952c);
        }
    }
}
