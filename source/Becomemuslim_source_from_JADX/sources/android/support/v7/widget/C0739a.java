package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.view.C0517s;
import android.support.v4.view.C0525w;
import android.support.v4.view.C0526x;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p035a.C0591a.C0590j;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

/* compiled from: AbsActionBarView */
/* renamed from: android.support.v7.widget.a */
abstract class C0739a extends ViewGroup {
    /* renamed from: a */
    protected final C3302a f1911a;
    /* renamed from: b */
    protected final Context f1912b;
    /* renamed from: c */
    protected ActionMenuView f1913c;
    /* renamed from: d */
    protected C4492d f1914d;
    /* renamed from: e */
    protected int f1915e;
    /* renamed from: f */
    protected C0525w f1916f;
    /* renamed from: g */
    private boolean f1917g;
    /* renamed from: h */
    private boolean f1918h;

    /* compiled from: AbsActionBarView */
    /* renamed from: android.support.v7.widget.a$a */
    protected class C3302a implements C0526x {
        /* renamed from: a */
        int f8709a;
        /* renamed from: b */
        final /* synthetic */ C0739a f8710b;
        /* renamed from: c */
        private boolean f8711c = null;

        protected C3302a(C0739a c0739a) {
            this.f8710b = c0739a;
        }

        /* renamed from: a */
        public C3302a m10364a(C0525w c0525w, int i) {
            this.f8710b.f1916f = c0525w;
            this.f8709a = i;
            return this;
        }

        /* renamed from: a */
        public void mo326a(View view) {
            super.setVisibility(0);
            this.f8711c = false;
        }

        /* renamed from: b */
        public void mo327b(View view) {
            if (this.f8711c == null) {
                this.f8710b.f1916f = null;
                super.setVisibility(this.f8709a);
            }
        }

        /* renamed from: c */
        public void mo328c(View view) {
            this.f8711c = true;
        }
    }

    /* renamed from: a */
    protected static int m2479a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    C0739a(Context context) {
        this(context, null);
    }

    C0739a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    C0739a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1911a = new C3302a(this);
        attributeSet = new TypedValue();
        if (context.getTheme().resolveAttribute(C0581a.actionBarPopupTheme, attributeSet, true) == 0 || attributeSet.resourceId == 0) {
            this.f1912b = context;
        } else {
            this.f1912b = new ContextThemeWrapper(context, attributeSet.resourceId);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0590j.ActionBar, C0581a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C0590j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f1914d != null) {
            this.f1914d.m15198a(configuration);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1917g = false;
        }
        if (!this.f1917g) {
            motionEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && motionEvent == null) {
                this.f1917g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1917g = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1918h = false;
        }
        if (!this.f1918h) {
            motionEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && motionEvent == null) {
                this.f1918h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1918h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f1915e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f1915e;
    }

    public int getAnimatedVisibility() {
        if (this.f1916f != null) {
            return this.f1911a.f8709a;
        }
        return getVisibility();
    }

    /* renamed from: a */
    public C0525w mo480a(int i, long j) {
        if (this.f1916f != null) {
            this.f1916f.m1761b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            C0525w a = C0517s.m1717k(this).m1754a(1.0f);
            a.m1755a(j);
            a.m1756a(this.f1911a.m10364a(a, i));
            return a;
        }
        a = C0517s.m1717k(this).m1754a(0.0f);
        a.m1755a(j);
        a.m1756a(this.f1911a.m10364a(a, i));
        return a;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f1916f != null) {
                this.f1916f.m1761b();
            }
            super.setVisibility(i);
        }
    }

    /* renamed from: a */
    public boolean mo481a() {
        return this.f1914d != null ? this.f1914d.m15212d() : false;
    }

    /* renamed from: a */
    protected int m2482a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, LinearLayoutManager.INVALID_OFFSET), i2);
        return Math.max(null, (i - view.getMeasuredWidth()) - i3);
    }

    /* renamed from: a */
    protected int m2483a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        i2 += (i3 - measuredHeight) / 2;
        if (z) {
            view.layout(i - measuredWidth, i2, i, measuredHeight + i2);
        } else {
            view.layout(i, i2, i + measuredWidth, measuredHeight + i2);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
