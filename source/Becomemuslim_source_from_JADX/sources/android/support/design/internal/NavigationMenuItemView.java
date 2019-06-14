package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.C0140a.C0132c;
import android.support.design.C0140a.C0133d;
import android.support.design.C0140a.C0134e;
import android.support.design.C0140a.C0136g;
import android.support.v4.content.p027b.C0364b;
import android.support.v4.p020a.p021a.C0259a;
import android.support.v4.view.C0494b;
import android.support.v4.view.C0517s;
import android.support.v4.view.p033a.C0483b;
import android.support.v4.widget.C0573r;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.view.menu.C0664p.C0663a;
import android.support.v7.view.menu.C3276j;
import android.support.v7.widget.as.C0762a;
import android.support.v7.widget.bs;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends C3119a implements C0663a {
    /* renamed from: d */
    private static final int[] f11837d = new int[]{16842912};
    /* renamed from: c */
    boolean f11838c;
    /* renamed from: e */
    private final int f11839e;
    /* renamed from: f */
    private boolean f11840f;
    /* renamed from: g */
    private final CheckedTextView f11841g;
    /* renamed from: h */
    private FrameLayout f11842h;
    /* renamed from: i */
    private C3276j f11843i;
    /* renamed from: j */
    private ColorStateList f11844j;
    /* renamed from: k */
    private boolean f11845k;
    /* renamed from: l */
    private Drawable f11846l;
    /* renamed from: m */
    private final C0494b f11847m;

    /* renamed from: android.support.design.internal.NavigationMenuItemView$1 */
    class C31181 extends C0494b {
        /* renamed from: a */
        final /* synthetic */ NavigationMenuItemView f7956a;

        C31181(NavigationMenuItemView navigationMenuItemView) {
            this.f7956a = navigationMenuItemView;
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0483b c0483b) {
            super.onInitializeAccessibilityNodeInfo(view, c0483b);
            c0483b.m1507a(this.f7956a.f11838c);
        }
    }

    /* renamed from: a */
    public boolean mo438a() {
        return false;
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11847m = new C31181(this);
        setOrientation(null);
        LayoutInflater.from(context).inflate(C0136g.design_navigation_menu_item, this, true);
        this.f11839e = context.getResources().getDimensionPixelSize(C0132c.design_navigation_icon_size);
        this.f11841g = (CheckedTextView) findViewById(C0134e.design_menu_item_text);
        this.f11841g.setDuplicateParentStateEnabled(true);
        C0517s.m1695a(this.f11841g, this.f11847m);
    }

    /* renamed from: a */
    public void mo437a(C3276j c3276j, int i) {
        this.f11843i = c3276j;
        setVisibility(c3276j.isVisible() != 0 ? 0 : 8);
        if (getBackground() == 0) {
            C0517s.m1694a((View) this, m14765d());
        }
        setCheckable(c3276j.isCheckable());
        setChecked(c3276j.isChecked());
        setEnabled(c3276j.isEnabled());
        setTitle(c3276j.getTitle());
        setIcon(c3276j.getIcon());
        setActionView(c3276j.getActionView());
        setContentDescription(c3276j.getContentDescription());
        bs.m2788a(this, c3276j.getTooltipText());
        m14764c();
    }

    /* renamed from: b */
    private boolean m14763b() {
        return this.f11843i.getTitle() == null && this.f11843i.getIcon() == null && this.f11843i.getActionView() != null;
    }

    /* renamed from: c */
    private void m14764c() {
        if (m14763b()) {
            this.f11841g.setVisibility(8);
            if (this.f11842h != null) {
                C0762a c0762a = (C0762a) this.f11842h.getLayoutParams();
                c0762a.width = -1;
                this.f11842h.setLayoutParams(c0762a);
                return;
            }
            return;
        }
        this.f11841g.setVisibility(0);
        if (this.f11842h != null) {
            c0762a = (C0762a) this.f11842h.getLayoutParams();
            c0762a.width = -2;
            this.f11842h.setLayoutParams(c0762a);
        }
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f11842h == null) {
                this.f11842h = (FrameLayout) ((ViewStub) findViewById(C0134e.design_menu_item_action_area_stub)).inflate();
            }
            this.f11842h.removeAllViews();
            this.f11842h.addView(view);
        }
    }

    /* renamed from: d */
    private StateListDrawable m14765d() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(C0581a.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f11837d, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    public C3276j getItemData() {
        return this.f11843i;
    }

    public void setTitle(CharSequence charSequence) {
        this.f11841g.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.f11838c != z) {
            this.f11838c = z;
            this.f11847m.sendAccessibilityEvent(this.f11841g, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f11841g.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f11845k) {
                ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = C0259a.m703g(drawable).mutate();
                C0259a.m692a(drawable, this.f11844j);
            }
            drawable.setBounds(0, 0, this.f11839e, this.f11839e);
        } else if (this.f11840f) {
            if (this.f11846l == null) {
                this.f11846l = C0364b.m1093a(getResources(), C0133d.navigation_empty_icon, getContext().getTheme());
                if (this.f11846l != null) {
                    this.f11846l.setBounds(0, 0, this.f11839e, this.f11839e);
                }
            }
            drawable = this.f11846l;
        }
        C0573r.m1903a(this.f11841g, drawable, null, null, null);
    }

    protected int[] onCreateDrawableState(int i) {
        i = super.onCreateDrawableState(i + 1);
        if (this.f11843i != null && this.f11843i.isCheckable() && this.f11843i.isChecked()) {
            mergeDrawableStates(i, f11837d);
        }
        return i;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.f11844j = colorStateList;
        this.f11845k = this.f11844j != null ? true : null;
        if (this.f11843i != null) {
            setIcon(this.f11843i.getIcon());
        }
    }

    public void setTextAppearance(int i) {
        C0573r.m1902a(this.f11841g, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f11841g.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f11840f = z;
    }
}
