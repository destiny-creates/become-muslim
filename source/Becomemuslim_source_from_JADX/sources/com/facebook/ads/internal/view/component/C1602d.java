package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.p020a.C0264a;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.internal.view.component.d */
public class C1602d extends LinearLayout {
    /* renamed from: a */
    private final int f4802a;
    /* renamed from: b */
    private final int f4803b;
    /* renamed from: c */
    private final int f4804c;
    /* renamed from: d */
    private int f4805d = -1;
    /* renamed from: e */
    private List<GradientDrawable> f4806e;

    public C1602d(Context context, C1312d c1312d, int i) {
        super(context);
        setOrientation(0);
        setGravity(17);
        float f = C1523w.f4503b;
        int i2 = (int) (8.0f * f);
        int i3 = (int) (6.0f * f);
        this.f4804c = (int) (f * 1.0f);
        this.f4802a = c1312d.m4506a(false);
        this.f4803b = C0264a.m717b(this.f4802a, 128);
        this.f4806e = new ArrayList();
        for (int i4 = 0; i4 < i; i4++) {
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setSize(i2, i2);
            gradientDrawable.setStroke(this.f4804c, 0);
            View imageView = new ImageView(context);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, i3, 0);
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(gradientDrawable);
            this.f4806e.add(gradientDrawable);
            addView(imageView);
        }
        m5585a(0);
    }

    /* renamed from: a */
    public void m5585a(int i) {
        if (this.f4805d != i) {
            this.f4805d = i;
            for (int i2 = 0; i2 < this.f4806e.size(); i2++) {
                int i3;
                int i4;
                if (i2 == i) {
                    i3 = this.f4802a;
                    i4 = this.f4802a;
                } else {
                    i3 = this.f4803b;
                    i4 = 0;
                }
                ((GradientDrawable) this.f4806e.get(i2)).setStroke(this.f4804c, i4);
                ((GradientDrawable) this.f4806e.get(i2)).setColor(i3);
                ((GradientDrawable) this.f4806e.get(i2)).invalidateSelf();
            }
        }
    }
}
