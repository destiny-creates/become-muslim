package com.facebook.ads.internal.view.p113b;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.ads.internal.p105q.p106a.C1507j;
import com.facebook.ads.internal.p105q.p106a.C1523w;

/* renamed from: com.facebook.ads.internal.view.b.b */
public class C1574b extends FrameLayout {
    /* renamed from: a */
    private final ImageView f4693a;
    /* renamed from: b */
    private int f4694b;
    /* renamed from: c */
    private int f4695c;

    public C1574b(Context context) {
        super(context);
        this.f4693a = new ImageView(context);
        m5489a();
    }

    public C1574b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4693a = new ImageView(context, attributeSet);
        m5489a();
    }

    public C1574b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4693a = new ImageView(context, attributeSet, i);
        m5489a();
    }

    @TargetApi(21)
    public C1574b(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f4693a = new ImageView(context, attributeSet, i, i2);
        m5489a();
    }

    /* renamed from: a */
    private void m5489a() {
        this.f4693a.setScaleType(ScaleType.FIT_XY);
        addView(this.f4693a, new LayoutParams(-2, -2));
        C1507j.m5304a(this.f4693a, C1507j.INTERNAL_AD_MEDIA);
    }

    /* renamed from: a */
    public void m5490a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            C1523w.m5343a((View) this, new BitmapDrawable(getContext().getResources(), bitmap2));
        } else {
            C1523w.m5342a((View) this, 0);
        }
        if (bitmap != null) {
            this.f4694b = bitmap.getWidth();
            this.f4695c = bitmap.getHeight();
            this.f4693a.setImageBitmap(Bitmap.createBitmap(bitmap));
            return;
        }
        this.f4693a.setImageDrawable(null);
    }

    public ImageView getBodyImageView() {
        return this.f4693a;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (this.f4694b > 0) {
            if (this.f4695c > 0) {
                float min = Math.min(((float) i5) / ((float) this.f4694b), ((float) i6) / ((float) this.f4695c));
                i3 = (int) (((float) this.f4694b) * min);
                i += i5 / 2;
                i2 += i6 / 2;
                i3 /= 2;
                int i7 = ((int) (min * ((float) this.f4695c))) / 2;
                this.f4693a.layout(i - i3, i2 - i7, i + i3, i2 + i7);
                return;
            }
        }
        super.onLayout(z, i, i2, i3, i4);
    }
}
