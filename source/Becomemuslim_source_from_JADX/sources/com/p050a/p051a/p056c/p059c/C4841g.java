package com.p050a.p051a.p056c.p059c;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.C0959i;
import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C3366p;
import com.p050a.p051a.p062f.C0952c;

/* compiled from: SolidLayer */
/* renamed from: com.a.a.c.c.g */
public class C4841g extends C4529a {
    /* renamed from: e */
    private final RectF f13726e = new RectF();
    /* renamed from: f */
    private final Paint f13727f = new Paint();
    /* renamed from: g */
    private final float[] f13728g = new float[8];
    /* renamed from: h */
    private final Path f13729h = new Path();
    /* renamed from: i */
    private final C0912d f13730i;
    /* renamed from: j */
    private C0885a<ColorFilter, ColorFilter> f13731j;

    C4841g(C0957g c0957g, C0912d c0912d) {
        super(c0957g, c0912d);
        this.f13730i = c0912d;
        this.f13727f.setAlpha(0);
        this.f13727f.setStyle(Style.FILL);
        this.f13727f.setColor(c0912d.m3205p());
    }

    /* renamed from: b */
    public void mo3346b(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.f13730i.m3205p());
        if (alpha != 0) {
            i = (int) (((((float) i) / 1132396544) * (((((float) alpha) / 255.0f) * ((float) ((Integer) this.d.m3143a().mo733e()).intValue())) / 100.0f)) * 1132396544);
            this.f13727f.setAlpha(i);
            if (this.f13731j != null) {
                this.f13727f.setColorFilter((ColorFilter) this.f13731j.mo733e());
            }
            if (i > 0) {
                this.f13728g[0] = null;
                this.f13728g[1] = null;
                this.f13728g[2] = (float) this.f13730i.m3207r();
                this.f13728g[3] = null;
                this.f13728g[4] = (float) this.f13730i.m3207r();
                this.f13728g[5] = (float) this.f13730i.m3206q();
                this.f13728g[6] = null;
                this.f13728g[7] = (float) this.f13730i.m3206q();
                matrix.mapPoints(this.f13728g);
                this.f13729h.reset();
                this.f13729h.moveTo(this.f13728g[0], this.f13728g[1]);
                this.f13729h.lineTo(this.f13728g[2], this.f13728g[3]);
                this.f13729h.lineTo(this.f13728g[4], this.f13728g[5]);
                this.f13729h.lineTo(this.f13728g[6], this.f13728g[7]);
                this.f13729h.lineTo(this.f13728g[0], this.f13728g[1]);
                this.f13729h.close();
                canvas.drawPath(this.f13729h, this.f13727f);
            }
        }
    }

    /* renamed from: a */
    public void mo2790a(RectF rectF, Matrix matrix) {
        super.mo2790a(rectF, matrix);
        this.f13726e.set(0.0f, 0.0f, (float) this.f13730i.m3207r(), (float) this.f13730i.m3206q());
        this.a.mapRect(this.f13726e);
        rectF.set(this.f13726e);
    }

    /* renamed from: a */
    public <T> void mo2792a(T t, C0952c<T> c0952c) {
        super.mo2792a((Object) t, (C0952c) c0952c);
        if (t != C0959i.f2724x) {
            return;
        }
        if (c0952c == null) {
            this.f13731j = null;
        } else {
            this.f13731j = new C3366p(c0952c);
        }
    }
}
