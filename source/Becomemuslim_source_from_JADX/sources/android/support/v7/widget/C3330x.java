package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p020a.p021a.C0259a;
import android.support.v4.view.C0517s;
import android.support.v7.p035a.C0591a.C0590j;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* compiled from: AppCompatSeekBarHelper */
/* renamed from: android.support.v7.widget.x */
class C3330x extends C0803t {
    /* renamed from: a */
    private final SeekBar f8849a;
    /* renamed from: b */
    private Drawable f8850b;
    /* renamed from: c */
    private ColorStateList f8851c = null;
    /* renamed from: d */
    private Mode f8852d = null;
    /* renamed from: e */
    private boolean f8853e = false;
    /* renamed from: f */
    private boolean f8854f = false;

    C3330x(SeekBar seekBar) {
        super(seekBar);
        this.f8849a = seekBar;
    }

    /* renamed from: a */
    void mo709a(AttributeSet attributeSet, int i) {
        super.mo709a(attributeSet, i);
        attributeSet = bq.m2769a(this.f8849a.getContext(), attributeSet, C0590j.AppCompatSeekBar, i, 0);
        i = attributeSet.m2777b(C0590j.AppCompatSeekBar_android_thumb);
        if (i != 0) {
            this.f8849a.setThumb(i);
        }
        mo708a(attributeSet.m2773a(C0590j.AppCompatSeekBar_tickMark));
        if (attributeSet.m2787g(C0590j.AppCompatSeekBar_tickMarkTintMode) != 0) {
            this.f8852d = al.m2612a(attributeSet.m2771a(C0590j.AppCompatSeekBar_tickMarkTintMode, -1), this.f8852d);
            this.f8854f = true;
        }
        if (attributeSet.m2787g(C0590j.AppCompatSeekBar_tickMarkTint) != 0) {
            this.f8851c = attributeSet.m2783e(C0590j.AppCompatSeekBar_tickMarkTint);
            this.f8853e = true;
        }
        attributeSet.m2774a();
        m10626d();
    }

    /* renamed from: a */
    void mo708a(Drawable drawable) {
        if (this.f8850b != null) {
            this.f8850b.setCallback(null);
        }
        this.f8850b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f8849a);
            C0259a.m698b(drawable, C0517s.m1711e(this.f8849a));
            if (drawable.isStateful()) {
                drawable.setState(this.f8849a.getDrawableState());
            }
            m10626d();
        }
        this.f8849a.invalidate();
    }

    /* renamed from: d */
    private void m10626d() {
        if (this.f8850b == null) {
            return;
        }
        if (this.f8853e || this.f8854f) {
            this.f8850b = C0259a.m703g(this.f8850b.mutate());
            if (this.f8853e) {
                C0259a.m692a(this.f8850b, this.f8851c);
            }
            if (this.f8854f) {
                C0259a.m695a(this.f8850b, this.f8852d);
            }
            if (this.f8850b.isStateful()) {
                this.f8850b.setState(this.f8849a.getDrawableState());
            }
        }
    }

    /* renamed from: b */
    void mo710b() {
        if (this.f8850b != null) {
            this.f8850b.jumpToCurrentState();
        }
    }

    /* renamed from: c */
    void m10631c() {
        Drawable drawable = this.f8850b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f8849a.getDrawableState())) {
            this.f8849a.invalidateDrawable(drawable);
        }
    }

    /* renamed from: a */
    void m10627a(Canvas canvas) {
        if (this.f8850b != null) {
            int max = this.f8849a.getMax();
            int i = 1;
            if (max > 1) {
                int intrinsicWidth = this.f8850b.getIntrinsicWidth();
                int intrinsicHeight = this.f8850b.getIntrinsicHeight();
                intrinsicWidth = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.f8850b.setBounds(-intrinsicWidth, -i, intrinsicWidth, i);
                float width = ((float) ((this.f8849a.getWidth() - this.f8849a.getPaddingLeft()) - this.f8849a.getPaddingRight())) / ((float) max);
                intrinsicWidth = canvas.save();
                canvas.translate((float) this.f8849a.getPaddingLeft(), (float) (this.f8849a.getHeight() / 2));
                for (intrinsicHeight = 0; intrinsicHeight <= max; intrinsicHeight++) {
                    this.f8850b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(intrinsicWidth);
            }
        }
    }
}
