package com.google.android.exoplayer2.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.p157i.C2448a;
import com.google.android.exoplayer2.p157i.C2458b;
import com.google.android.exoplayer2.p157i.C2475k;
import java.util.ArrayList;
import java.util.List;

public final class SubtitleView extends View implements C2475k {
    /* renamed from: a */
    private final List<C2580b> f11265a;
    /* renamed from: b */
    private List<C2458b> f11266b;
    /* renamed from: c */
    private int f11267c;
    /* renamed from: d */
    private float f11268d;
    /* renamed from: e */
    private boolean f11269e;
    /* renamed from: f */
    private boolean f11270f;
    /* renamed from: g */
    private C2448a f11271g;
    /* renamed from: h */
    private float f11272h;

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11265a = new ArrayList();
        this.f11267c = null;
        this.f11268d = 0.0533f;
        this.f11269e = true;
        this.f11270f = true;
        this.f11271g = C2448a.f6144a;
        this.f11272h = 0.08f;
    }

    /* renamed from: a */
    public void mo2327a(List<C2458b> list) {
        setCues(list);
    }

    public void setCues(List<C2458b> list) {
        if (this.f11266b != list) {
            this.f11266b = list;
            if (list == null) {
                list = null;
            } else {
                list = list.size();
            }
            while (this.f11265a.size() < list) {
                this.f11265a.add(new C2580b(getContext()));
            }
            invalidate();
        }
    }

    public void setFractionalTextSize(float f) {
        m13855a(f, false);
    }

    /* renamed from: a */
    public void m13855a(float f, boolean z) {
        m13854a((int) z, f);
    }

    /* renamed from: a */
    private void m13854a(int i, float f) {
        if (this.f11267c != i || this.f11268d != f) {
            this.f11267c = i;
            this.f11268d = f;
            invalidate();
        }
    }

    public void setApplyEmbeddedStyles(boolean z) {
        if (this.f11269e != z || this.f11270f != z) {
            this.f11269e = z;
            this.f11270f = z;
            invalidate();
        }
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        if (this.f11270f != z) {
            this.f11270f = z;
            invalidate();
        }
    }

    public void setStyle(C2448a c2448a) {
        if (this.f11271g != c2448a) {
            this.f11271g = c2448a;
            invalidate();
        }
    }

    public void setBottomPaddingFraction(float f) {
        if (this.f11272h != f) {
            this.f11272h = f;
            invalidate();
        }
    }

    public void dispatchDraw(Canvas canvas) {
        int i = 0;
        int size = this.f11266b == null ? 0 : r0.f11266b.size();
        int top = getTop();
        int bottom = getBottom();
        int left = getLeft() + getPaddingLeft();
        int paddingTop = getPaddingTop() + top;
        int right = getRight() + getPaddingRight();
        int paddingBottom = bottom - getPaddingBottom();
        if (paddingBottom > paddingTop) {
            if (right > left) {
                float f;
                if (r0.f11267c == 2) {
                    f = r0.f11268d;
                } else {
                    f = r0.f11268d * ((float) (r0.f11267c == 0 ? paddingBottom - paddingTop : bottom - top));
                }
                if (f > 0.0f) {
                    while (i < size) {
                        bottom = paddingBottom;
                        int i2 = right;
                        ((C2580b) r0.f11265a.get(i)).m7297a((C2458b) r0.f11266b.get(i), r0.f11269e, r0.f11270f, r0.f11271g, f, r0.f11272h, canvas, left, paddingTop, i2, bottom);
                        i++;
                        paddingBottom = bottom;
                        right = i2;
                    }
                }
            }
        }
    }

    @TargetApi(19)
    private float getUserCaptionFontScaleV19() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    @TargetApi(19)
    private C2448a getUserCaptionStyleV19() {
        return C2448a.m6767a(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle());
    }
}
