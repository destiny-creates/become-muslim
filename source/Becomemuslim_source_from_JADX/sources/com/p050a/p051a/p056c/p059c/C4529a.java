package com.p050a.p051a.p056c.p059c;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.Log;
import com.p050a.p051a.C0940d;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.p052a.p053a.C0880b;
import com.p050a.p051a.p052a.p053a.C3358d;
import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p052a.p054b.C0886g;
import com.p050a.p051a.p052a.p054b.C0887o;
import com.p050a.p051a.p052a.p054b.C4514c;
import com.p050a.p051a.p056c.C0917e;
import com.p050a.p051a.p056c.C0918f;
import com.p050a.p051a.p056c.p058b.C0899g;
import com.p050a.p051a.p056c.p058b.C0899g.C0898a;
import com.p050a.p051a.p056c.p059c.C0912d.C0911b;
import com.p050a.p051a.p062f.C0952c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseLayer */
/* renamed from: com.a.a.c.c.a */
public abstract class C4529a implements C3358d, C0884a, C0918f {
    /* renamed from: e */
    private static boolean f12211e = false;
    /* renamed from: a */
    final Matrix f12212a = new Matrix();
    /* renamed from: b */
    final C0957g f12213b;
    /* renamed from: c */
    final C0912d f12214c;
    /* renamed from: d */
    final C0887o f12215d;
    /* renamed from: f */
    private final Path f12216f = new Path();
    /* renamed from: g */
    private final Matrix f12217g = new Matrix();
    /* renamed from: h */
    private final Paint f12218h = new Paint(1);
    /* renamed from: i */
    private final Paint f12219i = new Paint(1);
    /* renamed from: j */
    private final Paint f12220j = new Paint(1);
    /* renamed from: k */
    private final Paint f12221k = new Paint(1);
    /* renamed from: l */
    private final Paint f12222l = new Paint();
    /* renamed from: m */
    private final RectF f12223m = new RectF();
    /* renamed from: n */
    private final RectF f12224n = new RectF();
    /* renamed from: o */
    private final RectF f12225o = new RectF();
    /* renamed from: p */
    private final RectF f12226p = new RectF();
    /* renamed from: q */
    private final String f12227q;
    /* renamed from: r */
    private C0886g f12228r;
    /* renamed from: s */
    private C4529a f12229s;
    /* renamed from: t */
    private C4529a f12230t;
    /* renamed from: u */
    private List<C4529a> f12231u;
    /* renamed from: v */
    private final List<C0885a<?, ?>> f12232v = new ArrayList();
    /* renamed from: w */
    private boolean f12233w = true;

    /* renamed from: a */
    public void mo729a(List<C0880b> list, List<C0880b> list2) {
    }

    /* renamed from: b */
    abstract void mo3346b(Canvas canvas, Matrix matrix, int i);

    /* renamed from: b */
    void mo3347b(C0917e c0917e, int i, List<C0917e> list, C0917e c0917e2) {
    }

    /* renamed from: a */
    static C4529a m15362a(C0912d c0912d, C0957g c0957g, C0954f c0954f) {
        switch (c0912d.m3200k()) {
            case Shape:
                return new C4840f(c0957g, c0912d);
            case PreComp:
                return new C4837b(c0957g, c0912d, c0954f.m3341b(c0912d.m3196g()), c0954f);
            case Solid:
                return new C4841g(c0957g, c0912d);
            case Image:
                return new C4838c(c0957g, c0912d);
            case Null:
                return new C4839e(c0957g, c0912d);
            case Text:
                return new C4842h(c0957g, c0912d);
            default:
                c0957g = new StringBuilder();
                c0957g.append("Unknown layer type ");
                c0957g.append(c0912d.m3200k());
                C0940d.m3287a(c0957g.toString());
                return null;
        }
    }

    C4529a(C0957g c0957g, C0912d c0912d) {
        this.f12213b = c0957g;
        this.f12214c = c0912d;
        c0957g = new StringBuilder();
        c0957g.append(c0912d.m3195f());
        c0957g.append("#draw");
        this.f12227q = c0957g.toString();
        this.f12222l.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.f12219i.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        this.f12220j.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        if (c0912d.m3201l() == C0911b.Invert) {
            this.f12221k.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        } else {
            this.f12221k.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        }
        this.f12215d = c0912d.m3204o().m10695h();
        this.f12215d.m3145a((C0884a) this);
        if (c0912d.m3199j() != null && c0912d.m3199j().isEmpty() == null) {
            this.f12228r = new C0886g(c0912d.m3199j());
            for (C0885a c0885a : this.f12228r.m3141b()) {
                m15378a(c0885a);
                c0885a.m3133a((C0884a) this);
            }
            for (C0885a c0885a2 : this.f12228r.m3142c()) {
                m15378a(c0885a2);
                c0885a2.m3133a((C0884a) this);
            }
        }
        m15371f();
    }

    /* renamed from: a */
    public void mo728a() {
        m15372g();
    }

    /* renamed from: c */
    C0912d m15387c() {
        return this.f12214c;
    }

    /* renamed from: a */
    void m15379a(C4529a c4529a) {
        this.f12229s = c4529a;
    }

    /* renamed from: d */
    boolean m15388d() {
        return this.f12229s != null;
    }

    /* renamed from: b */
    void m15385b(C4529a c4529a) {
        this.f12230t = c4529a;
    }

    /* renamed from: f */
    private void m15371f() {
        boolean z = true;
        if (this.f12214c.m3193d().isEmpty()) {
            m15367a(true);
            return;
        }
        final C0885a c4514c = new C4514c(this.f12214c.m3193d());
        c4514c.m3131a();
        c4514c.m3133a(new C0884a(this) {
            /* renamed from: b */
            final /* synthetic */ C4529a f9013b;

            /* renamed from: a */
            public void mo728a() {
                this.f9013b.m15367a(((Float) c4514c.mo733e()).floatValue() == 1.0f);
            }
        });
        if (((Float) c4514c.mo733e()).floatValue() != 1.0f) {
            z = false;
        }
        m15367a(z);
        m15378a(c4514c);
    }

    /* renamed from: g */
    private void m15372g() {
        this.f12213b.invalidateSelf();
    }

    /* renamed from: a */
    public void m15378a(C0885a<?, ?> c0885a) {
        this.f12232v.add(c0885a);
    }

    /* renamed from: a */
    public void mo2790a(RectF rectF, Matrix matrix) {
        this.f12212a.set(matrix);
        this.f12212a.preConcat(this.f12215d.m3151d());
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: a */
    public void mo2789a(Canvas canvas, Matrix matrix, int i) {
        C0940d.m3288b(this.f12227q);
        if (this.f12233w) {
            m15373h();
            C0940d.m3288b("Layer#parentMatrix");
            this.f12217g.reset();
            this.f12217g.set(matrix);
            for (int size = this.f12231u.size() - 1; size >= 0; size--) {
                this.f12217g.preConcat(((C4529a) this.f12231u.get(size)).f12215d.m3151d());
            }
            C0940d.m3289c("Layer#parentMatrix");
            i = (int) ((((((float) i) / 1132396544) * ((float) ((Integer) this.f12215d.m3143a().mo733e()).intValue())) / 1120403456) * 1132396544);
            if (m15388d() || m15389e()) {
                C0940d.m3288b("Layer#computeBounds");
                this.f12223m.set(0.0f, 0.0f, 0.0f, 0.0f);
                mo2790a(this.f12223m, this.f12217g);
                m15370c(this.f12223m, this.f12217g);
                this.f12217g.preConcat(this.f12215d.m3151d());
                m15369b(this.f12223m, this.f12217g);
                this.f12223m.set(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
                C0940d.m3289c("Layer#computeBounds");
                C0940d.m3288b("Layer#saveLayer");
                canvas.saveLayer(this.f12223m, this.f12218h, 31);
                C0940d.m3289c("Layer#saveLayer");
                m15363a(canvas);
                C0940d.m3288b("Layer#drawLayer");
                mo3346b(canvas, this.f12217g, i);
                C0940d.m3289c("Layer#drawLayer");
                if (m15389e()) {
                    m15364a(canvas, this.f12217g);
                }
                if (m15388d()) {
                    C0940d.m3288b("Layer#drawMatte");
                    C0940d.m3288b("Layer#saveLayer");
                    canvas.saveLayer(this.f12223m, this.f12221k, 19);
                    C0940d.m3289c("Layer#saveLayer");
                    m15363a(canvas);
                    this.f12229s.mo2789a(canvas, matrix, i);
                    C0940d.m3288b("Layer#restoreLayer");
                    canvas.restore();
                    C0940d.m3289c("Layer#restoreLayer");
                    C0940d.m3289c("Layer#drawMatte");
                }
                C0940d.m3288b("Layer#restoreLayer");
                canvas.restore();
                C0940d.m3289c("Layer#restoreLayer");
                m15368b(C0940d.m3289c(this.f12227q));
                return;
            }
            this.f12217g.preConcat(this.f12215d.m3151d());
            C0940d.m3288b("Layer#drawLayer");
            mo3346b(canvas, this.f12217g, i);
            C0940d.m3289c("Layer#drawLayer");
            m15368b(C0940d.m3289c(this.f12227q));
            return;
        }
        C0940d.m3289c(this.f12227q);
    }

    /* renamed from: b */
    private void m15368b(float f) {
        this.f12213b.m3399r().m3336a().m3407a(this.f12214c.m3195f(), f);
    }

    /* renamed from: a */
    private void m15363a(Canvas canvas) {
        C0940d.m3288b("Layer#clearLayer");
        canvas.drawRect(this.f12223m.left - 1.0f, this.f12223m.top - 1.0f, this.f12223m.right + 1.0f, this.f12223m.bottom + 1.0f, this.f12222l);
        C0940d.m3289c("Layer#clearLayer");
    }

    /* renamed from: b */
    private void m15369b(RectF rectF, Matrix matrix) {
        this.f12224n.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (m15389e()) {
            int size = this.f12228r.m3140a().size();
            int i = 0;
            while (i < size) {
                C0899g c0899g = (C0899g) this.f12228r.m3140a().get(i);
                this.f12216f.set((Path) ((C0885a) this.f12228r.m3141b().get(i)).mo733e());
                this.f12216f.transform(matrix);
                switch (c0899g.m3176a()) {
                    case MaskModeSubtract:
                        return;
                    case MaskModeIntersect:
                        return;
                    default:
                        this.f12216f.computeBounds(this.f12226p, false);
                        if (i == 0) {
                            this.f12224n.set(this.f12226p);
                        } else {
                            this.f12224n.set(Math.min(this.f12224n.left, this.f12226p.left), Math.min(this.f12224n.top, this.f12226p.top), Math.max(this.f12224n.right, this.f12226p.right), Math.max(this.f12224n.bottom, this.f12226p.bottom));
                        }
                        i++;
                }
            }
            rectF.set(Math.max(rectF.left, this.f12224n.left), Math.max(rectF.top, this.f12224n.top), Math.min(rectF.right, this.f12224n.right), Math.min(rectF.bottom, this.f12224n.bottom));
        }
    }

    /* renamed from: c */
    private void m15370c(RectF rectF, Matrix matrix) {
        if (m15388d() && this.f12214c.m3201l() != C0911b.Invert) {
            this.f12229s.mo2790a(this.f12225o, matrix);
            rectF.set(Math.max(rectF.left, this.f12225o.left), Math.max(rectF.top, this.f12225o.top), Math.min(rectF.right, this.f12225o.right), Math.min(rectF.bottom, this.f12225o.bottom));
        }
    }

    /* renamed from: a */
    private void m15364a(Canvas canvas, Matrix matrix) {
        m15365a(canvas, matrix, C0898a.MaskModeAdd);
        m15365a(canvas, matrix, C0898a.MaskModeIntersect);
        m15365a(canvas, matrix, C0898a.MaskModeSubtract);
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: a */
    private void m15365a(Canvas canvas, Matrix matrix, C0898a c0898a) {
        Paint paint;
        boolean z = true;
        switch (c0898a) {
            case MaskModeSubtract:
                paint = this.f12220j;
                break;
            case MaskModeIntersect:
                if (!f12211e) {
                    Log.w("LOTTIE", "Animation contains intersect masks. They are not supported but will be treated like add masks.");
                    f12211e = true;
                    break;
                }
                break;
            default:
                break;
        }
        paint = this.f12219i;
        int size = this.f12228r.m3140a().size();
        int i = 0;
        while (i < size) {
            int i2;
            if (((C0899g) this.f12228r.m3140a().get(i)).m3176a() != c0898a) {
                i++;
            } else if (!z) {
                C0940d.m3288b("Layer#drawMask");
                C0940d.m3288b("Layer#saveLayer");
                canvas.saveLayer(this.f12223m, paint, 19);
                C0940d.m3289c("Layer#saveLayer");
                m15363a(canvas);
                for (i2 = 0; i2 < size; i2++) {
                    if (((C0899g) this.f12228r.m3140a().get(i2)).m3176a() != c0898a) {
                        this.f12216f.set((Path) ((C0885a) this.f12228r.m3141b().get(i2)).mo733e());
                        this.f12216f.transform(matrix);
                        C0885a c0885a = (C0885a) this.f12228r.m3142c().get(i2);
                        int alpha = this.f12218h.getAlpha();
                        this.f12218h.setAlpha((int) (((float) ((Integer) c0885a.mo733e()).intValue()) * 2.55f));
                        canvas.drawPath(this.f12216f, this.f12218h);
                        this.f12218h.setAlpha(alpha);
                    }
                }
                C0940d.m3288b("Layer#restoreLayer");
                canvas.restore();
                C0940d.m3289c("Layer#restoreLayer");
                C0940d.m3289c("Layer#drawMask");
            }
        }
        z = false;
        if (!z) {
            C0940d.m3288b("Layer#drawMask");
            C0940d.m3288b("Layer#saveLayer");
            canvas.saveLayer(this.f12223m, paint, 19);
            C0940d.m3289c("Layer#saveLayer");
            m15363a(canvas);
            for (i2 = 0; i2 < size; i2++) {
                if (((C0899g) this.f12228r.m3140a().get(i2)).m3176a() != c0898a) {
                    this.f12216f.set((Path) ((C0885a) this.f12228r.m3141b().get(i2)).mo733e());
                    this.f12216f.transform(matrix);
                    C0885a c0885a2 = (C0885a) this.f12228r.m3142c().get(i2);
                    int alpha2 = this.f12218h.getAlpha();
                    this.f12218h.setAlpha((int) (((float) ((Integer) c0885a2.mo733e()).intValue()) * 2.55f));
                    canvas.drawPath(this.f12216f, this.f12218h);
                    this.f12218h.setAlpha(alpha2);
                }
            }
            C0940d.m3288b("Layer#restoreLayer");
            canvas.restore();
            C0940d.m3289c("Layer#restoreLayer");
            C0940d.m3289c("Layer#drawMask");
        }
    }

    /* renamed from: e */
    boolean m15389e() {
        return (this.f12228r == null || this.f12228r.m3141b().isEmpty()) ? false : true;
    }

    /* renamed from: a */
    private void m15367a(boolean z) {
        if (z != this.f12233w) {
            this.f12233w = z;
            m15372g();
        }
    }

    /* renamed from: a */
    void mo3345a(float f) {
        this.f12215d.m3144a(f);
        if (this.f12214c.m3191b() != 0.0f) {
            f /= this.f12214c.m3191b();
        }
        if (this.f12229s != null) {
            this.f12229s.mo3345a(this.f12229s.f12214c.m3191b() * f);
        }
        for (int i = 0; i < this.f12232v.size(); i++) {
            ((C0885a) this.f12232v.get(i)).mo732a(f);
        }
    }

    /* renamed from: h */
    private void m15373h() {
        if (this.f12231u == null) {
            if (this.f12230t == null) {
                this.f12231u = Collections.emptyList();
                return;
            }
            this.f12231u = new ArrayList();
            for (C4529a c4529a = this.f12230t; c4529a != null; c4529a = c4529a.f12230t) {
                this.f12231u.add(c4529a);
            }
        }
    }

    /* renamed from: b */
    public String mo730b() {
        return this.f12214c.m3195f();
    }

    /* renamed from: a */
    public void mo2791a(C0917e c0917e, int i, List<C0917e> list, C0917e c0917e2) {
        if (c0917e.m3222a(mo730b(), i)) {
            if (!"__container".equals(mo730b())) {
                c0917e2 = c0917e2.m3220a(mo730b());
                if (c0917e.m3224c(mo730b(), i)) {
                    list.add(c0917e2.m3219a((C0918f) this));
                }
            }
            if (c0917e.m3225d(mo730b(), i)) {
                mo3347b(c0917e, i + c0917e.m3223b(mo730b(), i), list, c0917e2);
            }
        }
    }

    /* renamed from: a */
    public <T> void mo2792a(T t, C0952c<T> c0952c) {
        this.f12215d.m3147a(t, c0952c);
    }
}
