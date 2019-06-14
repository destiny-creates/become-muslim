package com.facebook.ads.internal.view.p120f.p123c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.Button;
import com.facebook.ads.internal.p105q.p106a.C1523w;

/* renamed from: com.facebook.ads.internal.view.f.c.m */
public class C1649m extends Button {
    /* renamed from: a */
    private final Path f4937a;
    /* renamed from: b */
    private final Path f4938b;
    /* renamed from: c */
    private final Paint f4939c;
    /* renamed from: d */
    private final Path f4940d;
    /* renamed from: e */
    private boolean f4941e;

    public C1649m(Context context) {
        this(context, false);
    }

    public C1649m(Context context, final boolean z) {
        super(context);
        this.f4941e = false;
        this.f4937a = new Path();
        this.f4938b = new Path();
        this.f4940d = new Path();
        this.f4939c = new Paint(this) {
            /* renamed from: b */
            final /* synthetic */ C1649m f4936b;
        };
        setClickable(true);
        C1523w.m5342a((View) this, 0);
    }

    protected void onDraw(Canvas canvas) {
        Path path;
        if (canvas.isHardwareAccelerated() && VERSION.SDK_INT < 17) {
            setLayerType(1, null);
        }
        float max = ((float) Math.max(canvas.getWidth(), canvas.getHeight())) / 100.0f;
        float f;
        float f2;
        if (this.f4941e) {
            this.f4940d.rewind();
            f = 26.5f * max;
            f2 = 15.5f * max;
            this.f4940d.moveTo(f, f2);
            this.f4940d.lineTo(f, 84.5f * max);
            this.f4940d.lineTo(90.0f * max, max * 50.0f);
            this.f4940d.lineTo(f, f2);
            this.f4940d.close();
            path = this.f4940d;
        } else {
            this.f4937a.rewind();
            f = 29.0f * max;
            f2 = 21.0f * max;
            this.f4937a.moveTo(f, f2);
            float f3 = 79.0f * max;
            this.f4937a.lineTo(f, f3);
            float f4 = 45.0f * max;
            this.f4937a.lineTo(f4, f3);
            this.f4937a.lineTo(f4, f2);
            this.f4937a.lineTo(f, f2);
            this.f4937a.close();
            this.f4938b.rewind();
            f = 55.0f * max;
            this.f4938b.moveTo(f, f2);
            this.f4938b.lineTo(f, f3);
            max *= 71.0f;
            this.f4938b.lineTo(max, f3);
            this.f4938b.lineTo(max, f2);
            this.f4938b.lineTo(f, f2);
            this.f4938b.close();
            canvas.drawPath(this.f4937a, this.f4939c);
            path = this.f4938b;
        }
        canvas.drawPath(path, this.f4939c);
        super.onDraw(canvas);
    }

    public void setChecked(boolean z) {
        this.f4941e = z;
        refreshDrawableState();
        invalidate();
    }
}
