package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.p035a.C0591a.C0590j;
import android.support.v7.view.menu.C0664p.C0663a;
import android.support.v7.view.menu.C3273h.C0658b;
import android.support.v7.widget.ActionMenuView.C0675a;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ap;
import android.support.v7.widget.bs;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;

public class ActionMenuItemView extends AppCompatTextView implements C0663a, C0675a, OnClickListener {
    /* renamed from: b */
    C3276j f11983b;
    /* renamed from: c */
    C0658b f11984c;
    /* renamed from: d */
    C0649b f11985d;
    /* renamed from: e */
    private CharSequence f11986e;
    /* renamed from: f */
    private Drawable f11987f;
    /* renamed from: g */
    private ap f11988g;
    /* renamed from: h */
    private boolean f11989h;
    /* renamed from: i */
    private boolean f11990i;
    /* renamed from: j */
    private int f11991j;
    /* renamed from: k */
    private int f11992k;
    /* renamed from: l */
    private int f11993l;

    /* renamed from: android.support.v7.view.menu.ActionMenuItemView$b */
    public static abstract class C0649b {
        /* renamed from: a */
        public abstract C0666s mo701a();
    }

    /* renamed from: android.support.v7.view.menu.ActionMenuItemView$a */
    private class C3267a extends ap {
        /* renamed from: a */
        final /* synthetic */ ActionMenuItemView f8420a;

        public C3267a(ActionMenuItemView actionMenuItemView) {
            this.f8420a = actionMenuItemView;
            super(actionMenuItemView);
        }

        /* renamed from: a */
        public C0666s mo433a() {
            return this.f8420a.f11985d != null ? this.f8420a.f11985d.mo701a() : null;
        }

        /* renamed from: b */
        protected boolean mo434b() {
            boolean z = false;
            if (this.f8420a.f11984c == null || !this.f8420a.f11984c.mo436a(this.f8420a.f11983b)) {
                return false;
            }
            C0666s a = mo433a();
            if (a != null && a.mo636d()) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: a */
    public boolean mo438a() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f11989h = m15057e();
        context = context.obtainStyledAttributes(attributeSet, C0590j.ActionMenuItemView, i, 0);
        this.f11991j = context.getDimensionPixelSize(C0590j.ActionMenuItemView_android_minWidth, 0);
        context.recycle();
        this.f11993l = (int) ((resources.getDisplayMetrics().density * 1107296256) + 1056964608);
        setOnClickListener(this);
        this.f11992k = -1;
        setSaveEnabled(false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f11989h = m15057e();
        m15058f();
    }

    /* renamed from: e */
    private boolean m15057e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (i < 480 && (i < 640 || i2 < 480)) {
            if (configuration.orientation != 2) {
                return false;
            }
        }
        return true;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f11992k = i;
        super.setPadding(i, i2, i3, i4);
    }

    public C3276j getItemData() {
        return this.f11983b;
    }

    /* renamed from: a */
    public void mo437a(C3276j c3276j, int i) {
        this.f11983b = c3276j;
        setIcon(c3276j.getIcon());
        setTitle(c3276j.m10111a((C0663a) this));
        setId(c3276j.getItemId());
        setVisibility(c3276j.isVisible() != 0 ? 0 : 8);
        setEnabled(c3276j.isEnabled());
        if (c3276j.hasSubMenu() != null && this.f11988g == null) {
            this.f11988g = new C3267a(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f11983b.hasSubMenu() && this.f11988g != null && this.f11988g.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.f11984c != null) {
            this.f11984c.mo436a(this.f11983b);
        }
    }

    public void setItemInvoker(C0658b c0658b) {
        this.f11984c = c0658b;
    }

    public void setPopupCallback(C0649b c0649b) {
        this.f11985d = c0649b;
    }

    public void setExpandedFormat(boolean z) {
        if (this.f11990i != z) {
            this.f11990i = z;
            if (this.f11983b) {
                this.f11983b.m10127h();
            }
        }
    }

    /* renamed from: f */
    private void m15058f() {
        int i = 1;
        int isEmpty = TextUtils.isEmpty(this.f11986e) ^ 1;
        if (this.f11987f != null) {
            if (this.f11983b.m10132m()) {
                if (!this.f11989h) {
                    if (this.f11990i) {
                    }
                }
            }
            i = 0;
        }
        isEmpty &= i;
        CharSequence charSequence = null;
        setText(isEmpty != 0 ? this.f11986e : null);
        CharSequence contentDescription = this.f11983b.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (isEmpty != 0) {
                contentDescription = null;
            } else {
                contentDescription = this.f11983b.getTitle();
            }
            setContentDescription(contentDescription);
        } else {
            setContentDescription(contentDescription);
        }
        contentDescription = this.f11983b.getTooltipText();
        if (TextUtils.isEmpty(contentDescription)) {
            if (isEmpty == 0) {
                charSequence = this.f11983b.getTitle();
            }
            bs.m2788a(this, charSequence);
            return;
        }
        bs.m2788a(this, contentDescription);
    }

    public void setIcon(Drawable drawable) {
        this.f11987f = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f11993l) {
                f = ((float) this.f11993l) / ((float) intrinsicWidth);
                intrinsicWidth = this.f11993l;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f11993l) {
                f = ((float) this.f11993l) / ((float) intrinsicHeight);
                intrinsicHeight = this.f11993l;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m15058f();
    }

    /* renamed from: b */
    public boolean m15061b() {
        return TextUtils.isEmpty(getText()) ^ 1;
    }

    public void setTitle(CharSequence charSequence) {
        this.f11986e = charSequence;
        m15058f();
    }

    /* renamed from: c */
    public boolean mo2733c() {
        return m15061b() && this.f11983b.getIcon() == null;
    }

    /* renamed from: d */
    public boolean mo2734d() {
        return m15061b();
    }

    protected void onMeasure(int i, int i2) {
        boolean b = m15061b();
        if (b && this.f11992k >= 0) {
            super.setPadding(this.f11992k, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        i = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        i = mode == LinearLayoutManager.INVALID_OFFSET ? Math.min(i, this.f11991j) : this.f11991j;
        if (mode != 1073741824 && this.f11991j > 0 && measuredWidth < i) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(i, 1073741824), i2);
        }
        if (!b && this.f11987f != 0) {
            super.setPadding((getMeasuredWidth() - this.f11987f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
