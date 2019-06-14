package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.C0517s;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

/* compiled from: CircleImageView */
/* renamed from: android.support.v4.widget.c */
class C0536c extends ImageView {
    /* renamed from: a */
    int f1343a;
    /* renamed from: b */
    private AnimationListener f1344b;

    /* compiled from: CircleImageView */
    /* renamed from: android.support.v4.widget.c$a */
    private class C0535a extends OvalShape {
        /* renamed from: a */
        final /* synthetic */ C0536c f1340a;
        /* renamed from: b */
        private RadialGradient f1341b;
        /* renamed from: c */
        private Paint f1342c = new Paint();

        C0535a(C0536c c0536c, int i) {
            this.f1340a = c0536c;
            c0536c.f1343a = i;
            m1805a((int) rect().width());
        }

        protected void onResize(float f, float f2) {
            super.onResize(f, f2);
            m1805a((int) f);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = this.f1340a.getWidth() / 2;
            float f = (float) width;
            float height = (float) (this.f1340a.getHeight() / 2);
            canvas.drawCircle(f, height, f, this.f1342c);
            canvas.drawCircle(f, height, (float) (width - this.f1340a.f1343a), paint);
        }

        /* renamed from: a */
        private void m1805a(int i) {
            float f = (float) (i / 2);
            this.f1341b = new RadialGradient(f, f, (float) this.f1340a.f1343a, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.f1342c.setShader(this.f1341b);
        }
    }

    C0536c(Context context, int i) {
        Drawable shapeDrawable;
        super(context);
        context = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * context);
        int i3 = (int) (0.0f * context);
        this.f1343a = (int) (3.5f * context);
        if (m1806a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            C0517s.m1687a((View) this, context * 4.0f);
        } else {
            Drawable shapeDrawable2 = new ShapeDrawable(new C0535a(this, this.f1343a));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.f1343a, (float) i3, (float) i2, 503316480);
            context = this.f1343a;
            setPadding(context, context, context, context);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        C0517s.m1694a((View) this, shapeDrawable);
    }

    /* renamed from: a */
    private boolean m1806a() {
        return VERSION.SDK_INT >= 21;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (m1806a() == 0) {
            setMeasuredDimension(getMeasuredWidth() + (this.f1343a * 2), getMeasuredHeight() + (this.f1343a * 2));
        }
    }

    /* renamed from: a */
    public void m1807a(AnimationListener animationListener) {
        this.f1344b = animationListener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.f1344b != null) {
            this.f1344b.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f1344b != null) {
            this.f1344b.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
