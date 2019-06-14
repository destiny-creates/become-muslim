package com.p079e.p080a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.widget.ImageView;
import com.facebook.imageutils.JfifUtil;
import com.p079e.p080a.C1236t.C1233d;

/* compiled from: PicassoDrawable */
/* renamed from: com.e.a.u */
final class C1237u extends BitmapDrawable {
    /* renamed from: e */
    private static final Paint f3512e = new Paint();
    /* renamed from: a */
    Drawable f3513a;
    /* renamed from: b */
    long f3514b;
    /* renamed from: c */
    boolean f3515c;
    /* renamed from: d */
    int f3516d = JfifUtil.MARKER_FIRST_BYTE;
    /* renamed from: f */
    private final boolean f3517f;
    /* renamed from: g */
    private final float f3518g;
    /* renamed from: h */
    private final C1233d f3519h;

    /* renamed from: a */
    static void m4320a(ImageView imageView, Context context, Bitmap bitmap, C1233d c1233d, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new C1237u(context, bitmap, drawable, c1233d, z, z2));
    }

    /* renamed from: a */
    static void m4321a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if ((imageView.getDrawable() instanceof AnimationDrawable) != null) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    C1237u(Context context, Bitmap bitmap, Drawable drawable, C1233d c1233d, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f3517f = z2;
        this.f3518g = context.getResources().getDisplayMetrics().density;
        this.f3519h = c1233d;
        context = (c1233d == C1233d.MEMORY || z) ? null : true;
        if (context != null) {
            this.f3513a = drawable;
            this.f3515c = true;
            this.f3514b = SystemClock.uptimeMillis();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f3515c) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f3514b)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f3515c = false;
                this.f3513a = null;
                super.draw(canvas);
            } else {
                if (this.f3513a != null) {
                    this.f3513a.draw(canvas);
                }
                super.setAlpha((int) (((float) this.f3516d) * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f3516d);
                if (VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        } else {
            super.draw(canvas);
        }
        if (this.f3517f) {
            m4319a(canvas);
        }
    }

    public void setAlpha(int i) {
        this.f3516d = i;
        if (this.f3513a != null) {
            this.f3513a.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f3513a != null) {
            this.f3513a.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f3513a != null) {
            this.f3513a.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    /* renamed from: a */
    private void m4319a(Canvas canvas) {
        f3512e.setColor(-1);
        canvas.drawPath(C1237u.m4318a(new Point(0, 0), (int) (this.f3518g * 16.0f)), f3512e);
        f3512e.setColor(this.f3519h.f3489d);
        canvas.drawPath(C1237u.m4318a(new Point(0, 0), (int) (this.f3518g * 15.0f)), f3512e);
    }

    /* renamed from: a */
    private static Path m4318a(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        i = new Path();
        i.moveTo((float) point.x, (float) point.y);
        i.lineTo((float) point2.x, (float) point2.y);
        i.lineTo((float) point3.x, (float) point3.y);
        return i;
    }
}
