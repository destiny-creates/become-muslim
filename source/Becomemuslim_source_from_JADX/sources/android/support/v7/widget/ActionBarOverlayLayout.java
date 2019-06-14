package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.C0510m;
import android.support.v4.view.C0511o;
import android.support.v4.view.C0517s;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p035a.C0591a.C0586f;
import android.support.v7.view.menu.C0662o.C0661a;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.OverScroller;

public class ActionBarOverlayLayout extends ViewGroup implements C0510m, ai {
    /* renamed from: e */
    static final int[] f8567e = new int[]{C0581a.actionBarSize, 16842841};
    /* renamed from: A */
    private final Runnable f8568A;
    /* renamed from: B */
    private final Runnable f8569B;
    /* renamed from: C */
    private final C0511o f8570C;
    /* renamed from: a */
    ActionBarContainer f8571a;
    /* renamed from: b */
    boolean f8572b;
    /* renamed from: c */
    ViewPropertyAnimator f8573c;
    /* renamed from: d */
    final AnimatorListenerAdapter f8574d;
    /* renamed from: f */
    private int f8575f;
    /* renamed from: g */
    private int f8576g;
    /* renamed from: h */
    private ContentFrameLayout f8577h;
    /* renamed from: i */
    private aj f8578i;
    /* renamed from: j */
    private Drawable f8579j;
    /* renamed from: k */
    private boolean f8580k;
    /* renamed from: l */
    private boolean f8581l;
    /* renamed from: m */
    private boolean f8582m;
    /* renamed from: n */
    private boolean f8583n;
    /* renamed from: o */
    private int f8584o;
    /* renamed from: p */
    private int f8585p;
    /* renamed from: q */
    private final Rect f8586q;
    /* renamed from: r */
    private final Rect f8587r;
    /* renamed from: s */
    private final Rect f8588s;
    /* renamed from: t */
    private final Rect f8589t;
    /* renamed from: u */
    private final Rect f8590u;
    /* renamed from: v */
    private final Rect f8591v;
    /* renamed from: w */
    private final Rect f8592w;
    /* renamed from: x */
    private C0673a f8593x;
    /* renamed from: y */
    private final int f8594y;
    /* renamed from: z */
    private OverScroller f8595z;

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$1 */
    class C06701 extends AnimatorListenerAdapter {
        /* renamed from: a */
        final /* synthetic */ ActionBarOverlayLayout f1725a;

        C06701(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1725a = actionBarOverlayLayout;
        }

        public void onAnimationEnd(Animator animator) {
            this.f1725a.f8573c = null;
            this.f1725a.f8572b = false;
        }

        public void onAnimationCancel(Animator animator) {
            this.f1725a.f8573c = null;
            this.f1725a.f8572b = false;
        }
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$2 */
    class C06712 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ ActionBarOverlayLayout f1726a;

        C06712(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1726a = actionBarOverlayLayout;
        }

        public void run() {
            this.f1726a.m10179d();
            this.f1726a.f8573c = this.f1726a.f8571a.animate().translationY(0.0f).setListener(this.f1726a.f8574d);
        }
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$3 */
    class C06723 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ ActionBarOverlayLayout f1727a;

        C06723(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1727a = actionBarOverlayLayout;
        }

        public void run() {
            this.f1727a.m10179d();
            this.f1727a.f8573c = this.f1727a.f8571a.animate().translationY((float) (-this.f1727a.f8571a.getHeight())).setListener(this.f1727a.f8574d);
        }
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$a */
    public interface C0673a {
        /* renamed from: a */
        void mo426a(int i);

        /* renamed from: h */
        void mo428h(boolean z);

        /* renamed from: j */
        void mo429j();

        /* renamed from: k */
        void mo430k();

        /* renamed from: l */
        void mo431l();

        /* renamed from: m */
        void mo432m();
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$b */
    public static class C0674b extends MarginLayoutParams {
        public C0674b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0674b(int i, int i2) {
            super(i, i2);
        }

        public C0674b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m10177b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m10173a(attributeSet);
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8576g = null;
        this.f8586q = new Rect();
        this.f8587r = new Rect();
        this.f8588s = new Rect();
        this.f8589t = new Rect();
        this.f8590u = new Rect();
        this.f8591v = new Rect();
        this.f8592w = new Rect();
        this.f8594y = 600;
        this.f8574d = new C06701(this);
        this.f8568A = new C06712(this);
        this.f8569B = new C06723(this);
        m10166a(context);
        this.f8570C = new C0511o(this);
    }

    /* renamed from: a */
    private void m10166a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f8567e);
        boolean z = false;
        this.f8575f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f8579j = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f8579j == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z = true;
        }
        this.f8580k = z;
        this.f8595z = new OverScroller(context);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m10179d();
    }

    public void setActionBarVisibilityCallback(C0673a c0673a) {
        this.f8593x = c0673a;
        if (getWindowToken() != null) {
            this.f8593x.mo426a(this.f8576g);
            if (this.f8585p != null) {
                onWindowSystemUiVisibilityChanged(this.f8585p);
                C0517s.m1721o(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.f8581l = z;
        z = z && getContext().getApplicationInfo().targetSdkVersion < true;
        this.f8580k = z;
    }

    /* renamed from: a */
    public boolean m10176a() {
        return this.f8581l;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f8582m = z;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m10166a(getContext());
        C0517s.m1721o(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m10178c();
        int i2 = this.f8585p ^ i;
        this.f8585p = i;
        int i3 = 0;
        Object obj = (i & 4) == 0 ? 1 : null;
        if ((i & 256) != 0) {
            i3 = 1;
        }
        if (this.f8593x != 0) {
            this.f8593x.mo428h(i3 ^ 1);
            if (obj == null) {
                if (i3 != 0) {
                    this.f8593x.mo430k();
                }
            }
            this.f8593x.mo429j();
        }
        if ((i2 & 256) != 0 && this.f8593x != 0) {
            C0517s.m1721o(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f8576g = i;
        if (this.f8593x != null) {
            this.f8593x.mo426a(i);
        }
    }

    /* renamed from: a */
    private boolean m10168a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        C0674b c0674b = (C0674b) view.getLayoutParams();
        if (!z || c0674b.leftMargin == rect.left) {
            z = false;
        } else {
            c0674b.leftMargin = rect.left;
            z = true;
        }
        if (z2 && c0674b.topMargin != rect.top) {
            c0674b.topMargin = rect.top;
            z = true;
        }
        if (z4 && c0674b.rightMargin != rect.right) {
            c0674b.rightMargin = rect.right;
            z = true;
        }
        if (!z3 || c0674b.bottomMargin == rect.bottom) {
            return z;
        }
        c0674b.bottomMargin = rect.bottom;
        return true;
    }

    protected boolean fitSystemWindows(Rect rect) {
        m10178c();
        int n = C0517s.m1720n(this) & 256;
        boolean a = m10168a(this.f8571a, rect, true, true, false, true);
        this.f8589t.set(rect);
        by.m2840a(this, this.f8589t, this.f8586q);
        if (this.f8590u.equals(this.f8589t) == null) {
            this.f8590u.set(this.f8589t);
            a = true;
        }
        if (this.f8587r.equals(this.f8586q) == null) {
            this.f8587r.set(this.f8586q);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    /* renamed from: b */
    protected C0674b m10177b() {
        return new C0674b(-1, -1);
    }

    /* renamed from: a */
    public C0674b m10173a(AttributeSet attributeSet) {
        return new C0674b(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0674b(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0674b;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        m10178c();
        measureChildWithMargins(this.f8571a, i, 0, i2, 0);
        C0674b c0674b = (C0674b) this.f8571a.getLayoutParams();
        int max = Math.max(0, (this.f8571a.getMeasuredWidth() + c0674b.leftMargin) + c0674b.rightMargin);
        int max2 = Math.max(0, (this.f8571a.getMeasuredHeight() + c0674b.topMargin) + c0674b.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f8571a.getMeasuredState());
        Object obj = (C0517s.m1720n(this) & 256) != 0 ? 1 : null;
        if (obj != null) {
            i3 = this.f8575f;
            if (this.f8582m && this.f8571a.getTabContainer() != null) {
                i3 += this.f8575f;
            }
        } else {
            i3 = this.f8571a.getVisibility() != 8 ? this.f8571a.getMeasuredHeight() : 0;
        }
        this.f8588s.set(this.f8586q);
        this.f8591v.set(this.f8589t);
        Rect rect;
        if (this.f8581l || obj != null) {
            rect = this.f8591v;
            rect.top += i3;
            rect = this.f8591v;
            rect.bottom += 0;
        } else {
            rect = this.f8588s;
            rect.top += i3;
            rect = this.f8588s;
            rect.bottom += 0;
        }
        m10168a(this.f8577h, this.f8588s, true, true, true, true);
        if (!this.f8592w.equals(this.f8591v)) {
            this.f8592w.set(this.f8591v);
            this.f8577h.m2254a(this.f8591v);
        }
        measureChildWithMargins(this.f8577h, i, 0, i2, 0);
        C0674b c0674b2 = (C0674b) this.f8577h.getLayoutParams();
        max = Math.max(max, (this.f8577h.getMeasuredWidth() + c0674b2.leftMargin) + c0674b2.rightMargin);
        max2 = Math.max(max2, (this.f8577h.getMeasuredHeight() + c0674b2.topMargin) + c0674b2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f8577h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max2 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = getChildCount();
        i = getPaddingLeft();
        getPaddingRight();
        i2 = getPaddingTop();
        getPaddingBottom();
        for (boolean z2 = false; z2 < z; z2++) {
            i4 = getChildAt(z2);
            if (i4.getVisibility() != 8) {
                C0674b c0674b = (C0674b) i4.getLayoutParams();
                int i5 = c0674b.leftMargin + i;
                int i6 = c0674b.topMargin + i2;
                i4.layout(i5, i6, i4.getMeasuredWidth() + i5, i4.getMeasuredHeight() + i6);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f8579j != null && !this.f8580k) {
            int bottom = this.f8571a.getVisibility() == 0 ? (int) ((((float) this.f8571a.getBottom()) + this.f8571a.getTranslationY()) + 0.5f) : 0;
            this.f8579j.setBounds(0, bottom, getWidth(), this.f8579j.getIntrinsicHeight() + bottom);
            this.f8579j.draw(canvas);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) != null) {
            if (this.f8571a.getVisibility() == null) {
                return this.f8583n;
            }
        }
        return null;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f8570C.m1628a(view, view2, i);
        this.f8584o = getActionBarHideOffset();
        m10179d();
        if (this.f8593x != null) {
            this.f8593x.mo431l();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f8584o += i2;
        setActionBarHideOffset(this.f8584o);
    }

    public void onStopNestedScroll(View view) {
        if (this.f8583n != null && this.f8572b == null) {
            if (this.f8584o <= this.f8571a.getHeight()) {
                m10169l();
            } else {
                m10170m();
            }
        }
        if (this.f8593x != null) {
            this.f8593x.mo432m();
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (this.f8583n != null) {
            if (z) {
                if (m10167a(f, f2) != null) {
                    m10172o();
                } else {
                    m10171n();
                }
                this.f8572b = true;
                return true;
            }
        }
        return null;
    }

    public int getNestedScrollAxes() {
        return this.f8570C.m1625a();
    }

    /* renamed from: c */
    void m10178c() {
        if (this.f8577h == null) {
            this.f8577h = (ContentFrameLayout) findViewById(C0586f.action_bar_activity_content);
            this.f8571a = (ActionBarContainer) findViewById(C0586f.action_bar_container);
            this.f8578i = m10165a(findViewById(C0586f.action_bar));
        }
    }

    /* renamed from: a */
    private aj m10165a(View view) {
        if (view instanceof aj) {
            return (aj) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't make a decor toolbar out of ");
        stringBuilder.append(view.getClass().getSimpleName());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f8583n) {
            this.f8583n = z;
            if (!z) {
                m10179d();
                setActionBarHideOffset(false);
            }
        }
    }

    public int getActionBarHideOffset() {
        return this.f8571a != null ? -((int) this.f8571a.getTranslationY()) : 0;
    }

    public void setActionBarHideOffset(int i) {
        m10179d();
        this.f8571a.setTranslationY((float) (-Math.max(0, Math.min(i, this.f8571a.getHeight()))));
    }

    /* renamed from: d */
    void m10179d() {
        removeCallbacks(this.f8568A);
        removeCallbacks(this.f8569B);
        if (this.f8573c != null) {
            this.f8573c.cancel();
        }
    }

    /* renamed from: l */
    private void m10169l() {
        m10179d();
        postDelayed(this.f8568A, 600);
    }

    /* renamed from: m */
    private void m10170m() {
        m10179d();
        postDelayed(this.f8569B, 600);
    }

    /* renamed from: n */
    private void m10171n() {
        m10179d();
        this.f8568A.run();
    }

    /* renamed from: o */
    private void m10172o() {
        m10179d();
        this.f8569B.run();
    }

    /* renamed from: a */
    private boolean m10167a(float f, float f2) {
        this.f8595z.fling(0, 0, 0, (int) f2, 0, 0, LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE);
        return this.f8595z.getFinalY() > this.f8571a.getHeight();
    }

    public void setWindowCallback(Callback callback) {
        m10178c();
        this.f8578i.mo676a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        m10178c();
        this.f8578i.mo677a(charSequence);
    }

    public CharSequence getTitle() {
        m10178c();
        return this.f8578i.mo687e();
    }

    /* renamed from: a */
    public void mo488a(int i) {
        m10178c();
        if (i == 2) {
            this.f8578i.mo688f();
        } else if (i == 5) {
            this.f8578i.mo689g();
        } else if (i == 109) {
            setOverlayMode(1);
        }
    }

    public void setIcon(int i) {
        m10178c();
        this.f8578i.mo671a(i);
    }

    public void setIcon(Drawable drawable) {
        m10178c();
        this.f8578i.mo672a(drawable);
    }

    public void setLogo(int i) {
        m10178c();
        this.f8578i.mo680b(i);
    }

    /* renamed from: e */
    public boolean mo490e() {
        m10178c();
        return this.f8578i.mo690h();
    }

    /* renamed from: f */
    public boolean mo491f() {
        m10178c();
        return this.f8578i.mo691i();
    }

    /* renamed from: g */
    public boolean mo492g() {
        m10178c();
        return this.f8578i.mo692j();
    }

    /* renamed from: h */
    public boolean mo493h() {
        m10178c();
        return this.f8578i.mo693k();
    }

    /* renamed from: i */
    public boolean mo494i() {
        m10178c();
        return this.f8578i.mo694l();
    }

    /* renamed from: j */
    public void mo495j() {
        m10178c();
        this.f8578i.mo695m();
    }

    /* renamed from: a */
    public void mo489a(Menu menu, C0661a c0661a) {
        m10178c();
        this.f8578i.mo675a(menu, c0661a);
    }

    /* renamed from: k */
    public void mo496k() {
        m10178c();
        this.f8578i.mo696n();
    }
}
