package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.p035a.C0591a.C0590j;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    /* renamed from: a */
    private int f1906a;
    /* renamed from: b */
    private int f1907b;
    /* renamed from: c */
    private WeakReference<View> f1908c;
    /* renamed from: d */
    private LayoutInflater f1909d;
    /* renamed from: e */
    private C0738a f1910e;

    /* renamed from: android.support.v7.widget.ViewStubCompat$a */
    public interface C0738a {
        /* renamed from: a */
        void m2477a(ViewStubCompat viewStubCompat, View view);
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1906a = 0;
        context = context.obtainStyledAttributes(attributeSet, C0590j.ViewStubCompat, i, 0);
        this.f1907b = context.getResourceId(C0590j.ViewStubCompat_android_inflatedId, -1);
        this.f1906a = context.getResourceId(C0590j.ViewStubCompat_android_layout, 0);
        setId(context.getResourceId(C0590j.ViewStubCompat_android_id, -1));
        context.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.f1907b;
    }

    public void setInflatedId(int i) {
        this.f1907b = i;
    }

    public int getLayoutResource() {
        return this.f1906a;
    }

    public void setLayoutResource(int i) {
        this.f1906a = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1909d = layoutInflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1909d;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setVisibility(int i) {
        if (this.f1908c != null) {
            View view = (View) this.f1908c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m2478a();
        }
    }

    /* renamed from: a */
    public View m2478a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f1906a != 0) {
            LayoutInflater layoutInflater;
            ViewGroup viewGroup = (ViewGroup) parent;
            if (this.f1909d != null) {
                layoutInflater = this.f1909d;
            } else {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f1906a, viewGroup, false);
            if (this.f1907b != -1) {
                inflate.setId(this.f1907b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f1908c = new WeakReference(inflate);
            if (this.f1910e != null) {
                this.f1910e.m2477a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public void setOnInflateListener(C0738a c0738a) {
        this.f1910e = c0738a;
    }
}
