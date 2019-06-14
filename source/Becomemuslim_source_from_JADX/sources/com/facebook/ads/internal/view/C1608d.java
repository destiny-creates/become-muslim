package com.facebook.ads.internal.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.p105q.p106a.C1523w;

/* renamed from: com.facebook.ads.internal.view.d */
public class C1608d extends View {
    /* renamed from: a */
    private Paint f4824a;
    /* renamed from: b */
    private Paint f4825b;
    /* renamed from: c */
    private Paint f4826c;
    /* renamed from: d */
    private int f4827d;
    /* renamed from: e */
    private boolean f4828e;

    public C1608d(Context context) {
        this(context, 60, true);
    }

    public C1608d(Context context, int i, boolean z) {
        super(context);
        this.f4827d = i;
        this.f4828e = z;
        if (z) {
            this.f4824a = new Paint();
            this.f4824a.setColor(-3355444);
            this.f4824a.setStyle(Style.STROKE);
            this.f4824a.setStrokeWidth(3.0f);
            this.f4824a.setAntiAlias(true);
            this.f4825b = new Paint();
            this.f4825b.setColor(-1287371708);
            this.f4825b.setStyle(Style.FILL);
            this.f4825b.setAntiAlias(true);
            this.f4826c = new Paint();
            this.f4826c.setColor(-1);
            this.f4826c.setStyle(Style.STROKE);
            this.f4826c.setStrokeWidth(6.0f);
            this.f4826c.setAntiAlias(true);
        }
        m5588a();
    }

    /* renamed from: a */
    private void m5588a() {
        float f = C1523w.f4503b;
        LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((float) this.f4827d) * f), (int) (((float) this.f4827d) * f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f4828e) {
            if (canvas.isHardwareAccelerated() && VERSION.SDK_INT < 17) {
                setLayerType(1, null);
            }
            int min = Math.min(canvas.getWidth(), canvas.getHeight());
            int i = min / 2;
            int i2 = (i * 2) / 3;
            float f = (float) i;
            canvas.drawCircle(f, f, (float) i2, this.f4824a);
            canvas.drawCircle(f, f, (float) (i2 - 2), this.f4825b);
            min /= 3;
            float f2 = (float) min;
            float f3 = (float) (min * 2);
            Canvas canvas2 = canvas;
            float f4 = f2;
            float f5 = f3;
            canvas2.drawLine(f2, f4, f3, f5, this.f4826c);
            canvas2.drawLine(f3, f4, f2, f5, this.f4826c);
        }
        super.onDraw(canvas);
    }
}
