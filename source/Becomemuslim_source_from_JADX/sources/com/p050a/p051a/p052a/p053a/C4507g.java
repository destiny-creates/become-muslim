package com.p050a.p051a.p052a.p053a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.v4.util.C0452f;
import com.facebook.imageutils.JfifUtil;
import com.p050a.p051a.C0940d;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.C0959i;
import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p052a.p054b.C3366p;
import com.p050a.p051a.p056c.C0917e;
import com.p050a.p051a.p056c.p058b.C0896c;
import com.p050a.p051a.p056c.p058b.C0897f;
import com.p050a.p051a.p056c.p058b.C3372d;
import com.p050a.p051a.p056c.p059c.C4529a;
import com.p050a.p051a.p061e.C0947e;
import com.p050a.p051a.p062f.C0952c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientFillContent */
/* renamed from: com.a.a.a.a.g */
public class C4507g implements C3358d, C3359j, C0884a {
    /* renamed from: a */
    private final String f12145a;
    /* renamed from: b */
    private final C4529a f12146b;
    /* renamed from: c */
    private final C0452f<LinearGradient> f12147c = new C0452f();
    /* renamed from: d */
    private final C0452f<RadialGradient> f12148d = new C0452f();
    /* renamed from: e */
    private final Matrix f12149e = new Matrix();
    /* renamed from: f */
    private final Path f12150f = new Path();
    /* renamed from: g */
    private final Paint f12151g = new Paint(1);
    /* renamed from: h */
    private final RectF f12152h = new RectF();
    /* renamed from: i */
    private final List<C3360l> f12153i = new ArrayList();
    /* renamed from: j */
    private final C0897f f12154j;
    /* renamed from: k */
    private final C0885a<C0896c, C0896c> f12155k;
    /* renamed from: l */
    private final C0885a<Integer, Integer> f12156l;
    /* renamed from: m */
    private final C0885a<PointF, PointF> f12157m;
    /* renamed from: n */
    private final C0885a<PointF, PointF> f12158n;
    /* renamed from: o */
    private C0885a<ColorFilter, ColorFilter> f12159o;
    /* renamed from: p */
    private final C0957g f12160p;
    /* renamed from: q */
    private final int f12161q;

    public C4507g(C0957g c0957g, C4529a c4529a, C3372d c3372d) {
        this.f12146b = c4529a;
        this.f12145a = c3372d.m10702a();
        this.f12160p = c0957g;
        this.f12154j = c3372d.m10703b();
        this.f12150f.setFillType(c3372d.m10704c());
        this.f12161q = (int) (c0957g.m3399r().m3342c() / 32.0f);
        this.f12155k = c3372d.m10705d().mo737a();
        this.f12155k.m3133a((C0884a) this);
        c4529a.m15378a(this.f12155k);
        this.f12156l = c3372d.m10706e().mo737a();
        this.f12156l.m3133a((C0884a) this);
        c4529a.m15378a(this.f12156l);
        this.f12157m = c3372d.m10707f().mo737a();
        this.f12157m.m3133a((C0884a) this);
        c4529a.m15378a(this.f12157m);
        this.f12158n = c3372d.m10708g().mo737a();
        this.f12158n.m3133a((C0884a) this);
        c4529a.m15378a(this.f12158n);
    }

    /* renamed from: a */
    public void mo728a() {
        this.f12160p.invalidateSelf();
    }

    /* renamed from: a */
    public void mo729a(List<C0880b> list, List<C0880b> list2) {
        for (list = null; list < list2.size(); list++) {
            C0880b c0880b = (C0880b) list2.get(list);
            if (c0880b instanceof C3360l) {
                this.f12153i.add((C3360l) c0880b);
            }
        }
    }

    /* renamed from: a */
    public void mo2789a(Canvas canvas, Matrix matrix, int i) {
        Shader c;
        C0940d.m3288b("GradientFillContent#draw");
        this.f12150f.reset();
        for (int i2 = 0; i2 < this.f12153i.size(); i2++) {
            this.f12150f.addPath(((C3360l) this.f12153i.get(i2)).mo2793e(), matrix);
        }
        this.f12150f.computeBounds(this.f12152h, false);
        if (this.f12154j == C0897f.Linear) {
            c = m15291c();
        } else {
            c = m15292d();
        }
        this.f12149e.set(matrix);
        c.setLocalMatrix(this.f12149e);
        this.f12151g.setShader(c);
        if (this.f12159o != null) {
            this.f12151g.setColorFilter((ColorFilter) this.f12159o.mo733e());
        }
        this.f12151g.setAlpha(C0947e.m3306a((int) ((((((float) i) / 1132396544) * ((float) ((Integer) this.f12156l.mo733e()).intValue())) / 100.0f) * 1132396544), 0, (int) JfifUtil.MARKER_FIRST_BYTE));
        canvas.drawPath(this.f12150f, this.f12151g);
        C0940d.m3289c("GradientFillContent#draw");
    }

    /* renamed from: a */
    public void mo2790a(RectF rectF, Matrix matrix) {
        this.f12150f.reset();
        for (int i = 0; i < this.f12153i.size(); i++) {
            this.f12150f.addPath(((C3360l) this.f12153i.get(i)).mo2793e(), matrix);
        }
        this.f12150f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1065353216, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    /* renamed from: b */
    public String mo730b() {
        return this.f12145a;
    }

    /* renamed from: c */
    private LinearGradient m15291c() {
        long e = (long) m15293e();
        LinearGradient linearGradient = (LinearGradient) this.f12147c.m1412a(e);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f12157m.mo733e();
        PointF pointF2 = (PointF) this.f12158n.mo733e();
        C0896c c0896c = (C0896c) this.f12155k.mo733e();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, c0896c.m3174b(), c0896c.m3173a(), TileMode.CLAMP);
        this.f12147c.m1418b(e, linearGradient2);
        return linearGradient2;
    }

    /* renamed from: d */
    private RadialGradient m15292d() {
        long e = (long) m15293e();
        RadialGradient radialGradient = (RadialGradient) this.f12148d.m1412a(e);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f12157m.mo733e();
        PointF pointF2 = (PointF) this.f12158n.mo733e();
        C0896c c0896c = (C0896c) this.f12155k.mo733e();
        int[] b = c0896c.m3174b();
        float[] a = c0896c.m3173a();
        float f = pointF.x;
        float f2 = pointF.y;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot((double) (pointF2.x - f), (double) (pointF2.y - f2)), b, a, TileMode.CLAMP);
        this.f12148d.m1418b(e, radialGradient2);
        return radialGradient2;
    }

    /* renamed from: e */
    private int m15293e() {
        int round = Math.round(this.f12157m.m3139f() * ((float) this.f12161q));
        int round2 = Math.round(this.f12158n.m3139f() * ((float) this.f12161q));
        int round3 = Math.round(this.f12155k.m3139f() * ((float) this.f12161q));
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = (i * 31) * round2;
        }
        return round3 != 0 ? (i * 31) * round3 : i;
    }

    /* renamed from: a */
    public void mo2791a(C0917e c0917e, int i, List<C0917e> list, C0917e c0917e2) {
        C0947e.m3309a(c0917e, i, list, c0917e2, this);
    }

    /* renamed from: a */
    public <T> void mo2792a(T t, C0952c<T> c0952c) {
        if (t != C0959i.f2724x) {
            return;
        }
        if (c0952c == null) {
            this.f12159o = null;
            return;
        }
        this.f12159o = new C3366p(c0952c);
        this.f12159o.m3133a((C0884a) this);
        this.f12146b.m15378a(this.f12159o);
    }
}
