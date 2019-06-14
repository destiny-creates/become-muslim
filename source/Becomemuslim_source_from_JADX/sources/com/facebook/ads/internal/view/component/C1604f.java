package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.p105q.p106a.C1523w;

/* renamed from: com.facebook.ads.internal.view.component.f */
public class C1604f extends RelativeLayout {
    /* renamed from: a */
    private static final int f4812a = ((int) (C1523w.f4503b * 4.0f));
    /* renamed from: b */
    private final Path f4813b = new Path();
    /* renamed from: c */
    private final RectF f4814c = new RectF();

    public C1604f(Context context) {
        super(context);
        C1523w.m5342a((View) this, 0);
        if (VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    protected void onDraw(Canvas canvas) {
        this.f4814c.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        this.f4813b.reset();
        this.f4813b.addRoundRect(this.f4814c, (float) f4812a, (float) f4812a, Direction.CW);
        canvas.clipPath(this.f4813b);
        super.onDraw(canvas);
    }
}
