package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.p035a.C0591a.C0581a;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* compiled from: AppCompatSeekBar */
/* renamed from: android.support.v7.widget.w */
public class C0805w extends SeekBar {
    /* renamed from: a */
    private final C3330x f2244a;

    public C0805w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0581a.seekBarStyle);
    }

    public C0805w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2244a = new C3330x(this);
        this.f2244a.mo709a(attributeSet, i);
    }

    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f2244a.m10627a(canvas);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f2244a.m10631c();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f2244a.mo710b();
    }
}
