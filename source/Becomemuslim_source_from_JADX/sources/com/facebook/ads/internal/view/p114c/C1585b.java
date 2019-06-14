package com.facebook.ads.internal.view.p114c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.p105q.p106a.C1523w;

/* renamed from: com.facebook.ads.internal.view.c.b */
public class C1585b extends RelativeLayout {
    /* renamed from: a */
    private final Paint f4741a = new Paint();
    /* renamed from: b */
    private final RectF f4742b;

    public C1585b(Context context, String str) {
        super(context);
        float f = context.getResources().getDisplayMetrics().density;
        View textView = new TextView(context);
        textView.setTextColor(-16777216);
        textView.setTextSize(16.0f);
        textView.setText(str);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        setGravity(17);
        int i = (int) (f * 6.0f);
        textView.setPadding(i, i, i, i);
        addView(textView);
        this.f4741a.setStyle(Style.FILL);
        this.f4741a.setColor(-1);
        this.f4742b = new RectF();
        C1523w.m5342a((View) this, 0);
    }

    protected void onDraw(Canvas canvas) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f4742b.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        f *= 10.0f;
        canvas.drawRoundRect(this.f4742b, f, f, this.f4741a);
        super.onDraw(canvas);
    }
}
