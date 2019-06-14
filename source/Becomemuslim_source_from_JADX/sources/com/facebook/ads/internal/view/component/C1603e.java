package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.widget.ImageView;
import com.facebook.ads.internal.p105q.p106a.C1523w;

/* renamed from: com.facebook.ads.internal.view.component.e */
public class C1603e extends ImageView {
    /* renamed from: a */
    private static final int f4807a = ((int) (C1523w.f4503b * 8.0f));
    /* renamed from: b */
    private final Path f4808b = new Path();
    /* renamed from: c */
    private final RectF f4809c = new RectF();
    /* renamed from: d */
    private int f4810d = f4807a;
    /* renamed from: e */
    private boolean f4811e = false;

    public C1603e(Context context) {
        super(context);
        if (VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    protected void onDraw(Canvas canvas) {
        this.f4809c.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        this.f4808b.reset();
        float min = (float) (this.f4811e ? Math.min(getWidth(), getHeight()) / 2 : this.f4810d);
        this.f4808b.addRoundRect(this.f4809c, min, min, Direction.CW);
        canvas.clipPath(this.f4808b);
        super.onDraw(canvas);
    }

    public void setFullCircleCorners(boolean z) {
        this.f4811e = z;
    }

    public void setRadius(int i) {
        this.f4810d = (int) (((float) i) * C1523w.f4503b);
    }
}
