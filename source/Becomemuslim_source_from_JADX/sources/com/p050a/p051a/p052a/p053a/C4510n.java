package com.p050a.p051a.p052a.p053a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p056c.C0917e;
import com.p050a.p051a.p056c.p058b.C3376j;
import com.p050a.p051a.p056c.p058b.C3382q.C0906a;
import com.p050a.p051a.p056c.p059c.C4529a;
import com.p050a.p051a.p061e.C0947e;
import com.p050a.p051a.p061e.C0948f;
import com.p050a.p051a.p062f.C0952c;
import java.util.List;

/* compiled from: RectangleContent */
/* renamed from: com.a.a.a.a.n */
public class C4510n implements C3359j, C3360l, C0884a {
    /* renamed from: a */
    private final Path f12181a = new Path();
    /* renamed from: b */
    private final RectF f12182b = new RectF();
    /* renamed from: c */
    private final String f12183c;
    /* renamed from: d */
    private final C0957g f12184d;
    /* renamed from: e */
    private final C0885a<?, PointF> f12185e;
    /* renamed from: f */
    private final C0885a<?, PointF> f12186f;
    /* renamed from: g */
    private final C0885a<?, Float> f12187g;
    /* renamed from: h */
    private C3361r f12188h;
    /* renamed from: i */
    private boolean f12189i;

    /* renamed from: a */
    public <T> void mo2792a(T t, C0952c<T> c0952c) {
    }

    public C4510n(C0957g c0957g, C4529a c4529a, C3376j c3376j) {
        this.f12183c = c3376j.m10735a();
        this.f12184d = c0957g;
        this.f12185e = c3376j.m10738d().mo737a();
        this.f12186f = c3376j.m10737c().mo737a();
        this.f12187g = c3376j.m10736b().mo737a();
        c4529a.m15378a(this.f12185e);
        c4529a.m15378a(this.f12186f);
        c4529a.m15378a(this.f12187g);
        this.f12185e.m3133a((C0884a) this);
        this.f12186f.m3133a((C0884a) this);
        this.f12187g.m3133a((C0884a) this);
    }

    /* renamed from: b */
    public String mo730b() {
        return this.f12183c;
    }

    /* renamed from: a */
    public void mo728a() {
        m15316c();
    }

    /* renamed from: c */
    private void m15316c() {
        this.f12189i = false;
        this.f12184d.invalidateSelf();
    }

    /* renamed from: a */
    public void mo729a(List<C0880b> list, List<C0880b> list2) {
        for (list2 = null; list2 < list.size(); list2++) {
            C0880b c0880b = (C0880b) list.get(list2);
            if (c0880b instanceof C3361r) {
                C3361r c3361r = (C3361r) c0880b;
                if (c3361r.m10669c() == C0906a.Simultaneously) {
                    this.f12188h = c3361r;
                    this.f12188h.m10666a(this);
                }
            }
        }
    }

    /* renamed from: e */
    public Path mo2793e() {
        if (this.f12189i) {
            return this.f12181a;
        }
        this.f12181a.reset();
        PointF pointF = (PointF) this.f12186f.mo733e();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        float floatValue = this.f12187g == null ? 0.0f : ((Float) this.f12187g.mo733e()).floatValue();
        float min = Math.min(f, f2);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF pointF2 = (PointF) this.f12185e.mo733e();
        this.f12181a.moveTo(pointF2.x + f, (pointF2.y - f2) + floatValue);
        this.f12181a.lineTo(pointF2.x + f, (pointF2.y + f2) - floatValue);
        int i = (floatValue > 0.0f ? 1 : (floatValue == 0.0f ? 0 : -1));
        if (i > 0) {
            float f3 = floatValue * 2.0f;
            this.f12182b.set((pointF2.x + f) - f3, (pointF2.y + f2) - f3, pointF2.x + f, pointF2.y + f2);
            this.f12181a.arcTo(this.f12182b, 0.0f, 90.0f, false);
        }
        this.f12181a.lineTo((pointF2.x - f) + floatValue, pointF2.y + f2);
        if (i > 0) {
            f3 = floatValue * 2.0f;
            this.f12182b.set(pointF2.x - f, (pointF2.y + f2) - f3, (pointF2.x - f) + f3, pointF2.y + f2);
            this.f12181a.arcTo(this.f12182b, 90.0f, 90.0f, false);
        }
        this.f12181a.lineTo(pointF2.x - f, (pointF2.y - f2) + floatValue);
        if (i > 0) {
            float f4 = floatValue * 2.0f;
            this.f12182b.set(pointF2.x - f, pointF2.y - f2, (pointF2.x - f) + f4, (pointF2.y - f2) + f4);
            this.f12181a.arcTo(this.f12182b, 180.0f, 90.0f, false);
        }
        this.f12181a.lineTo((pointF2.x + f) - floatValue, pointF2.y - f2);
        if (i > 0) {
            floatValue *= 2.0f;
            this.f12182b.set((pointF2.x + f) - floatValue, pointF2.y - f2, pointF2.x + f, (pointF2.y - f2) + floatValue);
            this.f12181a.arcTo(this.f12182b, 270.0f, 90.0f, false);
        }
        this.f12181a.close();
        C0948f.m3318a(this.f12181a, this.f12188h);
        this.f12189i = true;
        return this.f12181a;
    }

    /* renamed from: a */
    public void mo2791a(C0917e c0917e, int i, List<C0917e> list, C0917e c0917e2) {
        C0947e.m3309a(c0917e, i, list, c0917e2, this);
    }
}
