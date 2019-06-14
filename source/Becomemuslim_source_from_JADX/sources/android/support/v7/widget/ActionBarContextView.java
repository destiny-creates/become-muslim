package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.C0517s;
import android.support.v4.view.C0525w;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p035a.C0591a.C0586f;
import android.support.v7.p035a.C0591a.C0587g;
import android.support.v7.p035a.C0591a.C0590j;
import android.support.v7.view.C0640b;
import android.support.v7.view.menu.C3273h;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends C0739a {
    /* renamed from: g */
    private CharSequence f8556g;
    /* renamed from: h */
    private CharSequence f8557h;
    /* renamed from: i */
    private View f8558i;
    /* renamed from: j */
    private View f8559j;
    /* renamed from: k */
    private LinearLayout f8560k;
    /* renamed from: l */
    private TextView f8561l;
    /* renamed from: m */
    private TextView f8562m;
    /* renamed from: n */
    private int f8563n;
    /* renamed from: o */
    private int f8564o;
    /* renamed from: p */
    private boolean f8565p;
    /* renamed from: q */
    private int f8566q;

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ C0525w mo480a(int i, long j) {
        return super.mo480a(i, j);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0581a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context = bq.m2769a(context, attributeSet, C0590j.ActionMode, i, 0);
        C0517s.m1694a((View) this, context.m2773a(C0590j.ActionMode_background));
        this.f8563n = context.m2786g(C0590j.ActionMode_titleTextStyle, 0);
        this.f8564o = context.m2786g(C0590j.ActionMode_subtitleTextStyle, 0);
        this.e = context.m2784f(C0590j.ActionMode_height, 0);
        this.f8566q = context.m2786g(C0590j.ActionMode_closeItemLayout, C0587g.abc_action_mode_close_item_material);
        context.m2774a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.m15213e();
            this.d.m15215g();
        }
    }

    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        if (this.f8559j != null) {
            removeView(this.f8559j);
        }
        this.f8559j = view;
        if (!(view == null || this.f8560k == null)) {
            removeView(this.f8560k);
            this.f8560k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f8556g = charSequence;
        m10158e();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f8557h = charSequence;
        m10158e();
    }

    public CharSequence getTitle() {
        return this.f8556g;
    }

    public CharSequence getSubtitle() {
        return this.f8557h;
    }

    /* renamed from: e */
    private void m10158e() {
        if (this.f8560k == null) {
            LayoutInflater.from(getContext()).inflate(C0587g.abc_action_bar_title_item, this);
            this.f8560k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f8561l = (TextView) this.f8560k.findViewById(C0586f.action_bar_title);
            this.f8562m = (TextView) this.f8560k.findViewById(C0586f.action_bar_subtitle);
            if (this.f8563n != 0) {
                this.f8561l.setTextAppearance(getContext(), this.f8563n);
            }
            if (this.f8564o != 0) {
                this.f8562m.setTextAppearance(getContext(), this.f8564o);
            }
        }
        this.f8561l.setText(this.f8556g);
        this.f8562m.setText(this.f8557h);
        int isEmpty = TextUtils.isEmpty(this.f8556g) ^ 1;
        int isEmpty2 = TextUtils.isEmpty(this.f8557h) ^ 1;
        int i = 8;
        this.f8562m.setVisibility(isEmpty2 != 0 ? 0 : 8);
        LinearLayout linearLayout = this.f8560k;
        if (!(isEmpty == 0 && isEmpty2 == 0)) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.f8560k.getParent() == null) {
            addView(this.f8560k);
        }
    }

    /* renamed from: a */
    public void m10160a(final C0640b c0640b) {
        if (this.f8558i == null) {
            this.f8558i = LayoutInflater.from(getContext()).inflate(this.f8566q, this, false);
            addView(this.f8558i);
        } else if (this.f8558i.getParent() == null) {
            addView(this.f8558i);
        }
        this.f8558i.findViewById(C0586f.action_mode_close_button).setOnClickListener(new OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ ActionBarContextView f1724b;

            public void onClick(View view) {
                c0640b.mo419c();
            }
        });
        C3273h c3273h = (C3273h) c0640b.mo416b();
        if (this.d != null) {
            this.d.m15214f();
        }
        this.d = new C4492d(getContext());
        this.d.m15210c(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        c3273h.m10065a(this.d, this.b);
        this.c = (ActionMenuView) this.d.mo2780a((ViewGroup) this);
        C0517s.m1694a(this.c, null);
        addView(this.c, layoutParams);
    }

    /* renamed from: b */
    public void m10162b() {
        if (this.f8558i == null) {
            m10163c();
        }
    }

    /* renamed from: c */
    public void m10163c() {
        removeAllViews();
        this.f8559j = null;
        this.c = null;
    }

    /* renamed from: a */
    public boolean mo481a() {
        return this.d != null ? this.d.m15212d() : false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        if (MeasureSpec.getMode(i) != 1073741824) {
            i2 = new StringBuilder();
            i2.append(getClass().getSimpleName());
            i2.append(" can only be used ");
            i2.append("with android:layout_width=\"match_parent\" (or fill_parent)");
            throw new IllegalStateException(i2.toString());
        } else if (MeasureSpec.getMode(i2) != 0) {
            i = MeasureSpec.getSize(i);
            if (this.e > 0) {
                i2 = this.e;
            } else {
                i2 = MeasureSpec.getSize(i2);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            int i4 = i2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i4, LinearLayoutManager.INVALID_OFFSET);
            int i5 = 0;
            if (this.f8558i != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f8558i.getLayoutParams();
                paddingLeft = m2482a(this.f8558i, paddingLeft, makeMeasureSpec, 0) - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = m2482a(this.c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f8560k != null && this.f8559j == null) {
                if (this.f8565p) {
                    this.f8560k.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    makeMeasureSpec = this.f8560k.getMeasuredWidth();
                    Object obj = makeMeasureSpec <= paddingLeft ? 1 : null;
                    if (obj != null) {
                        paddingLeft -= makeMeasureSpec;
                    }
                    this.f8560k.setVisibility(obj != null ? 0 : 8);
                } else {
                    paddingLeft = m2482a(this.f8560k, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f8559j != null) {
                LayoutParams layoutParams = this.f8559j.getLayoutParams();
                int i6 = layoutParams.width != -2 ? 1073741824 : LinearLayoutManager.INVALID_OFFSET;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = LinearLayoutManager.INVALID_OFFSET;
                }
                if (layoutParams.height >= 0) {
                    i4 = Math.min(layoutParams.height, i4);
                }
                this.f8559j.measure(MeasureSpec.makeMeasureSpec(paddingLeft, i6), MeasureSpec.makeMeasureSpec(i4, i3));
            }
            if (this.e <= 0) {
                i2 = getChildCount();
                i3 = 0;
                while (i5 < i2) {
                    paddingLeft = getChildAt(i5).getMeasuredHeight() + paddingTop;
                    if (paddingLeft > i3) {
                        i3 = paddingLeft;
                    }
                    i5++;
                }
                setMeasuredDimension(i, i3);
                return;
            }
            setMeasuredDimension(i, i2);
        } else {
            i2 = new StringBuilder();
            i2.append(getClass().getSimpleName());
            i2.append(" can only be used ");
            i2.append("with android:layout_height=\"wrap_content\"");
            throw new IllegalStateException(i2.toString());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = by.m2841a(this);
        int paddingRight = z ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        i2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f8558i == 0 || this.f8558i.getVisibility() == 8) {
            i4 = paddingRight;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f8558i.getLayoutParams();
            int i5 = z ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            i4 = z ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a = C0739a.m2479a(paddingRight, i5, z);
            i4 = C0739a.m2479a(a + m2483a(this.f8558i, a, paddingTop, i2, z), i4, z);
        }
        if (!(this.f8560k == null || this.f8559j != null || this.f8560k.getVisibility() == 8)) {
            i4 += m2483a(this.f8560k, i4, paddingTop, i2, z);
        }
        int i6 = i4;
        if (this.f8559j != 0) {
            m2483a(this.f8559j, i6, paddingTop, i2, z);
        }
        int paddingLeft = z ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != 0) {
            m2483a(this.c, paddingLeft, paddingTop, i2, z ^ 1);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f8556g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f8565p) {
            requestLayout();
        }
        this.f8565p = z;
    }

    /* renamed from: d */
    public boolean m10164d() {
        return this.f8565p;
    }
}
