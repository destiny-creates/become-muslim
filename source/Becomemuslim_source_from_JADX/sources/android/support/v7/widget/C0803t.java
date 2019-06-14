package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.p020a.p021a.C0262d;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* compiled from: AppCompatProgressBarHelper */
/* renamed from: android.support.v7.widget.t */
class C0803t {
    /* renamed from: a */
    private static final int[] f2240a = new int[]{16843067, 16843068};
    /* renamed from: b */
    private final ProgressBar f2241b;
    /* renamed from: c */
    private Bitmap f2242c;

    C0803t(ProgressBar progressBar) {
        this.f2241b = progressBar;
    }

    /* renamed from: a */
    void mo709a(AttributeSet attributeSet, int i) {
        attributeSet = bq.m2769a(this.f2241b.getContext(), attributeSet, f2240a, i, 0);
        i = attributeSet.m2777b(0);
        if (i != 0) {
            this.f2241b.setIndeterminateDrawable(mo708a(i));
        }
        Drawable b = attributeSet.m2777b(1);
        if (b != null) {
            this.f2241b.setProgressDrawable(m2934a(b, false));
        }
        attributeSet.m2774a();
    }

    /* renamed from: a */
    private Drawable m2934a(Drawable drawable, boolean z) {
        Drawable a;
        if (drawable instanceof C0262d) {
            C0262d c0262d = (C0262d) drawable;
            a = c0262d.mo162a();
            if (a != null) {
                c0262d.mo163a(m2934a(a, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            z = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[z];
            for (boolean z2 = false; z2 < z; z2++) {
                boolean z3;
                int id = layerDrawable.getId(z2);
                Drawable drawable2 = layerDrawable.getDrawable(z2);
                if (id != 16908301) {
                    if (id != 16908303) {
                        z3 = false;
                        drawableArr[z2] = m2934a(drawable2, z3);
                    }
                }
                z3 = true;
                drawableArr[z2] = m2934a(drawable2, z3);
            }
            a = new LayerDrawable(drawableArr);
            for (boolean z4 = false; z4 < z; z4++) {
                a.setId(z4, layerDrawable.getId(z4));
            }
            return a;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f2242c == null) {
                this.f2242c = bitmap;
            }
            Drawable shapeDrawable = new ShapeDrawable(mo710b());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, true, 1) : shapeDrawable;
        }
        return drawable;
    }

    /* renamed from: a */
    private Drawable mo708a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        Drawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable a = m2934a(animationDrawable.getFrame(i), true);
            a.setLevel(10000);
            animationDrawable2.addFrame(a, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    /* renamed from: b */
    private Shape mo710b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    /* renamed from: a */
    Bitmap m2936a() {
        return this.f2242c;
    }
}
