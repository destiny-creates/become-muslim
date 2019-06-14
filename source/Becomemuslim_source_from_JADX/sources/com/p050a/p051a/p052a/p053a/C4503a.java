package com.p050a.p051a.p052a.p053a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.facebook.imageutils.JfifUtil;
import com.p050a.p051a.C0940d;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.C0959i;
import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p052a.p054b.C3366p;
import com.p050a.p051a.p056c.C0917e;
import com.p050a.p051a.p056c.p057a.C4522b;
import com.p050a.p051a.p056c.p057a.C4524d;
import com.p050a.p051a.p056c.p058b.C3382q.C0906a;
import com.p050a.p051a.p056c.p059c.C4529a;
import com.p050a.p051a.p061e.C0947e;
import com.p050a.p051a.p061e.C0948f;
import com.p050a.p051a.p062f.C0952c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseStrokeContent */
/* renamed from: com.a.a.a.a.a */
public abstract class C4503a implements C3358d, C3359j, C0884a {
    /* renamed from: a */
    final Paint f12106a = new Paint(1);
    /* renamed from: b */
    private final PathMeasure f12107b = new PathMeasure();
    /* renamed from: c */
    private final Path f12108c = new Path();
    /* renamed from: d */
    private final Path f12109d = new Path();
    /* renamed from: e */
    private final RectF f12110e = new RectF();
    /* renamed from: f */
    private final C0957g f12111f;
    /* renamed from: g */
    private final C4529a f12112g;
    /* renamed from: h */
    private final List<C0879a> f12113h = new ArrayList();
    /* renamed from: i */
    private final float[] f12114i;
    /* renamed from: j */
    private final C0885a<?, Float> f12115j;
    /* renamed from: k */
    private final C0885a<?, Integer> f12116k;
    /* renamed from: l */
    private final List<C0885a<?, Float>> f12117l;
    /* renamed from: m */
    private final C0885a<?, Float> f12118m;
    /* renamed from: n */
    private C0885a<ColorFilter, ColorFilter> f12119n;

    /* compiled from: BaseStrokeContent */
    /* renamed from: com.a.a.a.a.a$a */
    private static final class C0879a {
        /* renamed from: a */
        private final List<C3360l> f2473a;
        /* renamed from: b */
        private final C3361r f2474b;

        private C0879a(C3361r c3361r) {
            this.f2473a = new ArrayList();
            this.f2474b = c3361r;
        }
    }

    C4503a(C0957g c0957g, C4529a c4529a, Cap cap, Join join, C4524d c4524d, C4522b c4522b, List<C4522b> list, C4522b c4522b2) {
        Enum enumR;
        this.f12111f = c0957g;
        this.f12112g = c4529a;
        this.f12106a.setStyle(Style.STROKE);
        this.f12106a.setStrokeCap(cap);
        this.f12106a.setStrokeJoin(join);
        this.f12116k = c4524d.mo737a();
        this.f12115j = c4522b.mo737a();
        if (c4522b2 == null) {
            this.f12118m = null;
        } else {
            this.f12118m = c4522b2.mo737a();
        }
        this.f12117l = new ArrayList(list.size());
        this.f12114i = new float[list.size()];
        for (enumR = null; enumR < list.size(); enumR++) {
            this.f12117l.add(((C4522b) list.get(enumR)).mo737a());
        }
        c4529a.m15378a(this.f12116k);
        c4529a.m15378a(this.f12115j);
        for (enumR = null; enumR < this.f12117l.size(); enumR++) {
            c4529a.m15378a((C0885a) this.f12117l.get(enumR));
        }
        if (this.f12118m != null) {
            c4529a.m15378a(this.f12118m);
        }
        this.f12116k.m3133a((C0884a) this);
        this.f12115j.m3133a((C0884a) this);
        for (c0957g = null; c0957g < list.size(); c0957g++) {
            ((C0885a) this.f12117l.get(c0957g)).m3133a((C0884a) this);
        }
        if (this.f12118m != null) {
            this.f12118m.m3133a((C0884a) this);
        }
    }

    /* renamed from: a */
    public void mo728a() {
        this.f12111f.invalidateSelf();
    }

    /* renamed from: a */
    public void mo729a(List<C0880b> list, List<C0880b> list2) {
        C3361r c3361r = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            C0880b c0880b = (C0880b) list.get(size);
            if (c0880b instanceof C3361r) {
                C3361r c3361r2 = (C3361r) c0880b;
                if (c3361r2.m10669c() == C0906a.Individually) {
                    c3361r = c3361r2;
                }
            }
        }
        if (c3361r != null) {
            c3361r.m10666a(this);
        }
        Object obj = null;
        for (list = list2.size() - 1; list >= null; list--) {
            c0880b = (C0880b) list2.get(list);
            if (c0880b instanceof C3361r) {
                C3361r c3361r3 = (C3361r) c0880b;
                if (c3361r3.m10669c() == C0906a.Individually) {
                    if (obj != null) {
                        this.f12113h.add(obj);
                    }
                    obj = new C0879a(c3361r3);
                    c3361r3.m10666a(this);
                }
            }
            if (c0880b instanceof C3360l) {
                if (obj == null) {
                    obj = new C0879a(c3361r);
                }
                obj.f2473a.add((C3360l) c0880b);
            }
        }
        if (obj != null) {
            this.f12113h.add(obj);
        }
    }

    /* renamed from: a */
    public void mo2789a(Canvas canvas, Matrix matrix, int i) {
        C0940d.m3288b("StrokeContent#draw");
        int i2 = 0;
        this.f12106a.setAlpha(C0947e.m3306a((int) ((((((float) i) / 1132396544) * ((float) ((Integer) this.f12116k.mo733e()).intValue())) / 1120403456) * 1132396544), 0, (int) JfifUtil.MARKER_FIRST_BYTE));
        this.f12106a.setStrokeWidth(((Float) this.f12115j.mo733e()).floatValue() * C0948f.m3314a(matrix));
        if (this.f12106a.getStrokeWidth() <= 0) {
            C0940d.m3289c("StrokeContent#draw");
            return;
        }
        m15258a(matrix);
        if (this.f12119n != 0) {
            this.f12106a.setColorFilter((ColorFilter) this.f12119n.mo733e());
        }
        while (i2 < this.f12113h.size()) {
            C0879a c0879a = (C0879a) this.f12113h.get(i2);
            if (c0879a.f2474b != null) {
                m15257a(canvas, c0879a, matrix);
            } else {
                C0940d.m3288b("StrokeContent#buildPath");
                this.f12108c.reset();
                for (int size = c0879a.f2473a.size() - 1; size >= 0; size--) {
                    this.f12108c.addPath(((C3360l) c0879a.f2473a.get(size)).mo2793e(), matrix);
                }
                C0940d.m3289c("StrokeContent#buildPath");
                C0940d.m3288b("StrokeContent#drawPath");
                canvas.drawPath(this.f12108c, this.f12106a);
                C0940d.m3289c("StrokeContent#drawPath");
            }
            i2++;
        }
        C0940d.m3289c("StrokeContent#draw");
    }

    /* renamed from: a */
    private void m15257a(Canvas canvas, C0879a c0879a, Matrix matrix) {
        C0940d.m3288b("StrokeContent#applyTrimPath");
        if (c0879a.f2474b == null) {
            C0940d.m3289c("StrokeContent#applyTrimPath");
            return;
        }
        this.f12108c.reset();
        for (int size = c0879a.f2473a.size() - 1; size >= 0; size--) {
            this.f12108c.addPath(((C3360l) c0879a.f2473a.get(size)).mo2793e(), matrix);
        }
        this.f12107b.setPath(this.f12108c, false);
        float length = this.f12107b.getLength();
        while (this.f12107b.nextContour()) {
            length += this.f12107b.getLength();
        }
        float floatValue = (((Float) c0879a.f2474b.m10672f().mo733e()).floatValue() * length) / 360.0f;
        float floatValue2 = ((((Float) c0879a.f2474b.m10670d().mo733e()).floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((((Float) c0879a.f2474b.m10671e().mo733e()).floatValue() * length) / 100.0f) + floatValue;
        float f = 0.0f;
        for (int size2 = c0879a.f2473a.size() - 1; size2 >= 0; size2--) {
            float f2;
            this.f12109d.set(((C3360l) c0879a.f2473a.get(size2)).mo2793e());
            this.f12109d.transform(matrix);
            this.f12107b.setPath(this.f12109d, false);
            float length2 = this.f12107b.getLength();
            float f3 = 1.0f;
            if (floatValue3 > length) {
                f2 = floatValue3 - length;
                if (f2 < f + length2 && f < f2) {
                    C0948f.m3317a(this.f12109d, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f2 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f12109d, this.f12106a);
                    f += length2;
                }
            }
            f2 = f + length2;
            if (f2 >= floatValue2) {
                if (f <= floatValue3) {
                    if (f2 > floatValue3 || floatValue2 >= f) {
                        float f4 = floatValue2 < f ? 0.0f : (floatValue2 - f) / length2;
                        if (floatValue3 <= f2) {
                            f3 = (floatValue3 - f) / length2;
                        }
                        C0948f.m3317a(this.f12109d, f4, f3, 0.0f);
                        canvas.drawPath(this.f12109d, this.f12106a);
                    } else {
                        canvas.drawPath(this.f12109d, this.f12106a);
                    }
                }
            }
            f += length2;
        }
        C0940d.m3289c("StrokeContent#applyTrimPath");
    }

    /* renamed from: a */
    public void mo2790a(RectF rectF, Matrix matrix) {
        C0940d.m3288b("StrokeContent#getBounds");
        this.f12108c.reset();
        for (int i = 0; i < this.f12113h.size(); i++) {
            C0879a c0879a = (C0879a) this.f12113h.get(i);
            for (int i2 = 0; i2 < c0879a.f2473a.size(); i2++) {
                this.f12108c.addPath(((C3360l) c0879a.f2473a.get(i2)).mo2793e(), matrix);
            }
        }
        this.f12108c.computeBounds(this.f12110e, false);
        matrix = ((Float) this.f12115j.mo733e()).floatValue() / 2.0f;
        this.f12110e.set(this.f12110e.left - matrix, this.f12110e.top - matrix, this.f12110e.right + matrix, this.f12110e.bottom + matrix);
        rectF.set(this.f12110e);
        rectF.set(rectF.left - 1065353216, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        C0940d.m3289c("StrokeContent#getBounds");
    }

    /* renamed from: a */
    private void m15258a(Matrix matrix) {
        C0940d.m3288b("StrokeContent#applyDashPattern");
        if (this.f12117l.isEmpty()) {
            C0940d.m3289c("StrokeContent#applyDashPattern");
            return;
        }
        matrix = C0948f.m3314a(matrix);
        for (int i = 0; i < this.f12117l.size(); i++) {
            this.f12114i[i] = ((Float) ((C0885a) this.f12117l.get(i)).mo733e()).floatValue();
            if (i % 2 == 0) {
                if (this.f12114i[i] < 1.0f) {
                    this.f12114i[i] = 1.0f;
                }
            } else if (this.f12114i[i] < 0.1f) {
                this.f12114i[i] = 0.1f;
            }
            float[] fArr = this.f12114i;
            fArr[i] = fArr[i] * matrix;
        }
        this.f12106a.setPathEffect(new DashPathEffect(this.f12114i, this.f12118m == null ? null : ((Float) this.f12118m.mo733e()).floatValue()));
        C0940d.m3289c("StrokeContent#applyDashPattern");
    }

    /* renamed from: a */
    public void mo2791a(C0917e c0917e, int i, List<C0917e> list, C0917e c0917e2) {
        C0947e.m3309a(c0917e, i, list, c0917e2, this);
    }

    /* renamed from: a */
    public <T> void mo2792a(T t, C0952c<T> c0952c) {
        if (t == C0959i.f2704d) {
            this.f12116k.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2711k) {
            this.f12115j.m3134a((C0952c) c0952c);
        } else if (t != C0959i.f2724x) {
        } else {
            if (c0952c == null) {
                this.f12119n = null;
                return;
            }
            this.f12119n = new C3366p(c0952c);
            this.f12119n.m3133a((C0884a) this);
            this.f12112g.m15378a(this.f12119n);
        }
    }
}
