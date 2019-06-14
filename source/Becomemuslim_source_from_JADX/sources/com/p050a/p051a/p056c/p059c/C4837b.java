package com.p050a.p051a.p056c.p059c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.v4.util.C0452f;
import com.p050a.p051a.C0940d;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.C0959i;
import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p052a.p054b.C3366p;
import com.p050a.p051a.p056c.C0917e;
import com.p050a.p051a.p062f.C0952c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompositionLayer */
/* renamed from: com.a.a.c.c.b */
public class C4837b extends C4529a {
    /* renamed from: e */
    private C0885a<Float, Float> f13717e;
    /* renamed from: f */
    private final List<C4529a> f13718f = new ArrayList();
    /* renamed from: g */
    private final RectF f13719g = new RectF();
    /* renamed from: h */
    private final RectF f13720h = new RectF();

    public C4837b(C0957g c0957g, C0912d c0912d, List<C0912d> list, C0954f c0954f) {
        super(c0957g, c0912d);
        c0912d = c0912d.m3210u();
        if (c0912d != null) {
            this.f13717e = c0912d.mo737a();
            m15378a((C0885a) this.f13717e);
            this.f13717e.m3133a((C0884a) this);
        } else {
            this.f13717e = null;
        }
        c0912d = new C0452f(c0954f.m3346g().size());
        int size = list.size() - 1;
        C4529a c4529a = null;
        while (true) {
            int i = 0;
            if (size >= 0) {
                C0912d c0912d2 = (C0912d) list.get(size);
                C4529a a = C4529a.m15362a(c0912d2, c0957g, c0954f);
                if (a != null) {
                    c0912d.m1418b(a.m15387c().m3194e(), a);
                    if (c4529a == null) {
                        this.f13718f.add(0, a);
                        switch (c0912d2.m3201l()) {
                            case Add:
                            case Invert:
                                c4529a = a;
                                break;
                            default:
                                break;
                        }
                    }
                    c4529a.m15379a(a);
                    c4529a = null;
                }
                size--;
            } else {
                while (i < c0912d.m1415b()) {
                    C4529a c4529a2 = (C4529a) c0912d.m1412a(c0912d.m1416b(i));
                    if (c4529a2 != null) {
                        C4529a c4529a3 = (C4529a) c0912d.m1412a(c4529a2.m15387c().m3202m());
                        if (c4529a3 != null) {
                            c4529a2.m15385b(c4529a3);
                        }
                    }
                    i++;
                }
                return;
            }
        }
    }

    /* renamed from: b */
    void mo3346b(Canvas canvas, Matrix matrix, int i) {
        C0940d.m3288b("CompositionLayer#draw");
        canvas.save();
        this.f13720h.set(0.0f, 0.0f, (float) this.c.m3197h(), (float) this.c.m3198i());
        matrix.mapRect(this.f13720h);
        for (int size = this.f13718f.size() - 1; size >= 0; size--) {
            if (!this.f13720h.isEmpty() ? canvas.clipRect(this.f13720h) : true) {
                ((C4529a) this.f13718f.get(size)).mo2789a(canvas, matrix, i);
            }
        }
        canvas.restore();
        C0940d.m3289c("CompositionLayer#draw");
    }

    /* renamed from: a */
    public void mo2790a(RectF rectF, Matrix matrix) {
        super.mo2790a(rectF, matrix);
        this.f13719g.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (matrix = this.f13718f.size() - 1; matrix >= null; matrix--) {
            ((C4529a) this.f13718f.get(matrix)).mo2790a(this.f13719g, this.a);
            if (rectF.isEmpty()) {
                rectF.set(this.f13719g);
            } else {
                rectF.set(Math.min(rectF.left, this.f13719g.left), Math.min(rectF.top, this.f13719g.top), Math.max(rectF.right, this.f13719g.right), Math.max(rectF.bottom, this.f13719g.bottom));
            }
        }
    }

    /* renamed from: a */
    public void mo3345a(float f) {
        super.mo3345a(f);
        if (this.f13717e != null) {
            f = ((float) ((long) (((Float) this.f13717e.mo733e()).floatValue() * 1000.0f))) / this.b.m3399r().m3342c();
        }
        if (this.c.m3191b() != 0.0f) {
            f /= this.c.m3191b();
        }
        f -= this.c.m3192c();
        for (int size = this.f13718f.size() - 1; size >= 0; size--) {
            ((C4529a) this.f13718f.get(size)).mo3345a(f);
        }
    }

    /* renamed from: b */
    protected void mo3347b(C0917e c0917e, int i, List<C0917e> list, C0917e c0917e2) {
        for (int i2 = 0; i2 < this.f13718f.size(); i2++) {
            ((C4529a) this.f13718f.get(i2)).mo2791a(c0917e, i, list, c0917e2);
        }
    }

    /* renamed from: a */
    public <T> void mo2792a(T t, C0952c<T> c0952c) {
        super.mo2792a((Object) t, (C0952c) c0952c);
        if (t != C0959i.f2723w) {
            return;
        }
        if (c0952c == null) {
            this.f13717e = null;
            return;
        }
        this.f13717e = new C3366p(c0952c);
        m15378a((C0885a) this.f13717e);
    }
}
