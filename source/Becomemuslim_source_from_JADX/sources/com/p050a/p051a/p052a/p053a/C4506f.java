package com.p050a.p051a.p052a.p053a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.facebook.imageutils.JfifUtil;
import com.p050a.p051a.C0940d;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.C0959i;
import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p052a.p054b.C3366p;
import com.p050a.p051a.p056c.C0917e;
import com.p050a.p051a.p056c.p058b.C3378m;
import com.p050a.p051a.p056c.p059c.C4529a;
import com.p050a.p051a.p061e.C0947e;
import com.p050a.p051a.p062f.C0952c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FillContent */
/* renamed from: com.a.a.a.a.f */
public class C4506f implements C3358d, C3359j, C0884a {
    /* renamed from: a */
    private final Path f12136a = new Path();
    /* renamed from: b */
    private final Paint f12137b = new Paint(1);
    /* renamed from: c */
    private final C4529a f12138c;
    /* renamed from: d */
    private final String f12139d;
    /* renamed from: e */
    private final List<C3360l> f12140e = new ArrayList();
    /* renamed from: f */
    private final C0885a<Integer, Integer> f12141f;
    /* renamed from: g */
    private final C0885a<Integer, Integer> f12142g;
    /* renamed from: h */
    private C0885a<ColorFilter, ColorFilter> f12143h;
    /* renamed from: i */
    private final C0957g f12144i;

    public C4506f(C0957g c0957g, C4529a c4529a, C3378m c3378m) {
        this.f12138c = c4529a;
        this.f12139d = c3378m.m10745a();
        this.f12144i = c0957g;
        if (c3378m.m10746b() != null) {
            if (c3378m.m10747c() != null) {
                this.f12136a.setFillType(c3378m.m10748d());
                this.f12141f = c3378m.m10746b().mo737a();
                this.f12141f.m3133a((C0884a) this);
                c4529a.m15378a(this.f12141f);
                this.f12142g = c3378m.m10747c().mo737a();
                this.f12142g.m3133a((C0884a) this);
                c4529a.m15378a(this.f12142g);
                return;
            }
        }
        this.f12141f = null;
        this.f12142g = null;
    }

    /* renamed from: a */
    public void mo728a() {
        this.f12144i.invalidateSelf();
    }

    /* renamed from: a */
    public void mo729a(List<C0880b> list, List<C0880b> list2) {
        for (list = null; list < list2.size(); list++) {
            C0880b c0880b = (C0880b) list2.get(list);
            if (c0880b instanceof C3360l) {
                this.f12140e.add((C3360l) c0880b);
            }
        }
    }

    /* renamed from: b */
    public String mo730b() {
        return this.f12139d;
    }

    /* renamed from: a */
    public void mo2789a(Canvas canvas, Matrix matrix, int i) {
        C0940d.m3288b("FillContent#draw");
        this.f12137b.setColor(((Integer) this.f12141f.mo733e()).intValue());
        int i2 = 0;
        this.f12137b.setAlpha(C0947e.m3306a((int) ((((((float) i) / 1132396544) * ((float) ((Integer) this.f12142g.mo733e()).intValue())) / 1120403456) * 1132396544), 0, (int) JfifUtil.MARKER_FIRST_BYTE));
        if (this.f12143h != 0) {
            this.f12137b.setColorFilter((ColorFilter) this.f12143h.mo733e());
        }
        this.f12136a.reset();
        while (i2 < this.f12140e.size()) {
            this.f12136a.addPath(((C3360l) this.f12140e.get(i2)).mo2793e(), matrix);
            i2++;
        }
        canvas.drawPath(this.f12136a, this.f12137b);
        C0940d.m3289c("FillContent#draw");
    }

    /* renamed from: a */
    public void mo2790a(RectF rectF, Matrix matrix) {
        this.f12136a.reset();
        for (int i = 0; i < this.f12140e.size(); i++) {
            this.f12136a.addPath(((C3360l) this.f12140e.get(i)).mo2793e(), matrix);
        }
        this.f12136a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1065353216, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    /* renamed from: a */
    public void mo2791a(C0917e c0917e, int i, List<C0917e> list, C0917e c0917e2) {
        C0947e.m3309a(c0917e, i, list, c0917e2, this);
    }

    /* renamed from: a */
    public <T> void mo2792a(T t, C0952c<T> c0952c) {
        if (t == C0959i.f2701a) {
            this.f12141f.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2704d) {
            this.f12142g.m3134a((C0952c) c0952c);
        } else if (t != C0959i.f2724x) {
        } else {
            if (c0952c == null) {
                this.f12143h = null;
                return;
            }
            this.f12143h = new C3366p(c0952c);
            this.f12143h.m3133a((C0884a) this);
            this.f12138c.m15378a(this.f12143h);
        }
    }
}
