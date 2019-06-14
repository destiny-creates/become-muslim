package com.p050a.p051a.p056c.p059c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.C0959i;
import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C3366p;
import com.p050a.p051a.p061e.C0948f;
import com.p050a.p051a.p062f.C0952c;

/* compiled from: ImageLayer */
/* renamed from: com.a.a.c.c.c */
public class C4838c extends C4529a {
    /* renamed from: e */
    private final Paint f13721e = new Paint(3);
    /* renamed from: f */
    private final Rect f13722f = new Rect();
    /* renamed from: g */
    private final Rect f13723g = new Rect();
    /* renamed from: h */
    private C0885a<ColorFilter, ColorFilter> f13724h;

    C4838c(C0957g c0957g, C0912d c0912d) {
        super(c0957g, c0912d);
    }

    /* renamed from: b */
    public void mo3346b(Canvas canvas, Matrix matrix, int i) {
        Bitmap f = m17190f();
        if (f != null) {
            float a = C0948f.m3313a();
            this.f13721e.setAlpha(i);
            if (this.f13724h != 0) {
                this.f13721e.setColorFilter((ColorFilter) this.f13724h.mo733e());
            }
            canvas.save();
            canvas.concat(matrix);
            this.f13722f.set(0, 0, f.getWidth(), f.getHeight());
            this.f13723g.set(0, 0, (int) (((float) f.getWidth()) * a), (int) (((float) f.getHeight()) * a));
            canvas.drawBitmap(f, this.f13722f, this.f13723g, this.f13721e);
            canvas.restore();
        }
    }

    /* renamed from: a */
    public void mo2790a(RectF rectF, Matrix matrix) {
        super.mo2790a(rectF, matrix);
        matrix = m17190f();
        if (matrix != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, (float) matrix.getWidth()), Math.min(rectF.bottom, (float) matrix.getHeight()));
            this.a.mapRect(rectF);
        }
    }

    /* renamed from: f */
    private Bitmap m17190f() {
        return this.b.m3373b(this.c.m3196g());
    }

    /* renamed from: a */
    public <T> void mo2792a(T t, C0952c<T> c0952c) {
        super.mo2792a((Object) t, (C0952c) c0952c);
        if (t != C0959i.f2724x) {
            return;
        }
        if (c0952c == null) {
            this.f13724h = null;
        } else {
            this.f13724h = new C3366p(c0952c);
        }
    }
}
