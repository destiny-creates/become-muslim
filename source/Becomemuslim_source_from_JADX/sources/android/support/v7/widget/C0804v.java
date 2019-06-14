package android.support.v7.widget;

import android.content.Context;
import android.support.v7.p035a.C0591a.C0581a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* compiled from: AppCompatRatingBar */
/* renamed from: android.support.v7.widget.v */
public class C0804v extends RatingBar {
    /* renamed from: a */
    private final C0803t f2243a;

    public C0804v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0581a.ratingBarStyle);
    }

    public C0804v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2243a = new C0803t(this);
        this.f2243a.mo709a(attributeSet, i);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        i2 = this.f2243a.m2936a();
        if (i2 != 0) {
            setMeasuredDimension(View.resolveSizeAndState(i2.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
