package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.app.C0608a.C0607c;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.view.C0638a;
import android.support.v7.widget.as.C0762a;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

/* compiled from: ScrollingTabContainerView */
public class bg extends HorizontalScrollView implements OnItemSelectedListener {
    /* renamed from: j */
    private static final Interpolator f2104j = new DecelerateInterpolator();
    /* renamed from: a */
    Runnable f2105a;
    /* renamed from: b */
    as f2106b;
    /* renamed from: c */
    int f2107c;
    /* renamed from: d */
    int f2108d;
    /* renamed from: e */
    private C0775b f2109e;
    /* renamed from: f */
    private Spinner f2110f;
    /* renamed from: g */
    private boolean f2111g;
    /* renamed from: h */
    private int f2112h;
    /* renamed from: i */
    private int f2113i;

    /* compiled from: ScrollingTabContainerView */
    /* renamed from: android.support.v7.widget.bg$a */
    private class C0774a extends BaseAdapter {
        /* renamed from: a */
        final /* synthetic */ bg f2096a;

        public long getItemId(int i) {
            return (long) i;
        }

        C0774a(bg bgVar) {
            this.f2096a = bgVar;
        }

        public int getCount() {
            return this.f2096a.f2106b.getChildCount();
        }

        public Object getItem(int i) {
            return ((C0776c) this.f2096a.f2106b.getChildAt(i)).m2748b();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return this.f2096a.m2753a((C0607c) getItem(i), true);
            }
            ((C0776c) view).m2747a((C0607c) getItem(i));
            return view;
        }
    }

    /* compiled from: ScrollingTabContainerView */
    /* renamed from: android.support.v7.widget.bg$b */
    private class C0775b implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ bg f2097a;

        C0775b(bg bgVar) {
            this.f2097a = bgVar;
        }

        public void onClick(View view) {
            ((C0776c) view).m2748b().m2017d();
            int childCount = this.f2097a.f2106b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f2097a.f2106b.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* compiled from: ScrollingTabContainerView */
    /* renamed from: android.support.v7.widget.bg$c */
    private class C0776c extends LinearLayout {
        /* renamed from: a */
        final /* synthetic */ bg f2098a;
        /* renamed from: b */
        private final int[] f2099b = new int[]{16842964};
        /* renamed from: c */
        private C0607c f2100c;
        /* renamed from: d */
        private TextView f2101d;
        /* renamed from: e */
        private ImageView f2102e;
        /* renamed from: f */
        private View f2103f;

        public C0776c(bg bgVar, Context context, C0607c c0607c, boolean z) {
            this.f2098a = bgVar;
            super(context, null, C0581a.actionBarTabStyle);
            this.f2100c = c0607c;
            bgVar = bq.m2769a(context, null, this.f2099b, C0581a.actionBarTabStyle, 0);
            if (bgVar.m2787g(0) != null) {
                setBackgroundDrawable(bgVar.m2773a(0));
            }
            bgVar.m2774a();
            if (z) {
                setGravity(8388627);
            }
            m2746a();
        }

        /* renamed from: a */
        public void m2747a(C0607c c0607c) {
            this.f2100c = c0607c;
            m2746a();
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(true);
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C0607c.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(C0607c.class.getName());
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f2098a.f2107c > 0 && getMeasuredWidth() > this.f2098a.f2107c) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.f2098a.f2107c, 1073741824), i2);
            }
        }

        /* renamed from: a */
        public void m2746a() {
            C0607c c0607c = this.f2100c;
            View c = c0607c.m2016c();
            CharSequence charSequence = null;
            if (c != null) {
                C0776c parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(c);
                    }
                    addView(c);
                }
                this.f2103f = c;
                if (this.f2101d != null) {
                    this.f2101d.setVisibility(8);
                }
                if (this.f2102e != null) {
                    this.f2102e.setVisibility(8);
                    this.f2102e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f2103f != null) {
                removeView(this.f2103f);
                this.f2103f = null;
            }
            Drawable a = c0607c.m2014a();
            CharSequence b = c0607c.m2015b();
            if (a != null) {
                if (this.f2102e == null) {
                    View appCompatImageView = new AppCompatImageView(getContext());
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f2102e = appCompatImageView;
                }
                this.f2102e.setImageDrawable(a);
                this.f2102e.setVisibility(0);
            } else if (this.f2102e != null) {
                this.f2102e.setVisibility(8);
                this.f2102e.setImageDrawable(null);
            }
            int isEmpty = TextUtils.isEmpty(b) ^ 1;
            if (isEmpty != 0) {
                if (this.f2101d == null) {
                    View appCompatTextView = new AppCompatTextView(getContext(), null, C0581a.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TruncateAt.END);
                    LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f2101d = appCompatTextView;
                }
                this.f2101d.setText(b);
                this.f2101d.setVisibility(0);
            } else if (this.f2101d != null) {
                this.f2101d.setVisibility(8);
                this.f2101d.setText(null);
            }
            if (this.f2102e != null) {
                this.f2102e.setContentDescription(c0607c.m2018e());
            }
            if (isEmpty == 0) {
                charSequence = c0607c.m2018e();
            }
            bs.m2788a(this, charSequence);
        }

        /* renamed from: b */
        public C0607c m2748b() {
            return this.f2100c;
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void onMeasure(int i, int i2) {
        i2 = MeasureSpec.getMode(i);
        Object obj = 1;
        boolean z = i2 == 1073741824;
        setFillViewport(z);
        int childCount = this.f2106b.getChildCount();
        if (childCount <= 1 || !(i2 == 1073741824 || i2 == LinearLayoutManager.INVALID_OFFSET)) {
            this.f2107c = -1;
        } else {
            if (childCount > 2) {
                this.f2107c = (int) (((float) MeasureSpec.getSize(i)) * 1053609165);
            } else {
                this.f2107c = MeasureSpec.getSize(i) / 2;
            }
            this.f2107c = Math.min(this.f2107c, this.f2108d);
        }
        i2 = MeasureSpec.makeMeasureSpec(this.f2112h, 1073741824);
        if (z || !this.f2111g) {
            obj = null;
        }
        if (obj != null) {
            this.f2106b.measure(0, i2);
            if (this.f2106b.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                m2750b();
            } else {
                m2751c();
            }
        } else {
            m2751c();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, i2);
        i = getMeasuredWidth();
        if (z && measuredWidth != i) {
            setTabSelected(this.f2113i);
        }
    }

    /* renamed from: a */
    private boolean m2749a() {
        return this.f2110f != null && this.f2110f.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.f2111g = z;
    }

    /* renamed from: b */
    private void m2750b() {
        if (!m2749a()) {
            if (this.f2110f == null) {
                this.f2110f = m2752d();
            }
            removeView(this.f2106b);
            addView(this.f2110f, new LayoutParams(-2, -1));
            if (this.f2110f.getAdapter() == null) {
                this.f2110f.setAdapter(new C0774a(this));
            }
            if (this.f2105a != null) {
                removeCallbacks(this.f2105a);
                this.f2105a = null;
            }
            this.f2110f.setSelection(this.f2113i);
        }
    }

    /* renamed from: c */
    private boolean m2751c() {
        if (!m2749a()) {
            return false;
        }
        removeView(this.f2110f);
        addView(this.f2106b, new LayoutParams(-2, -1));
        setTabSelected(this.f2110f.getSelectedItemPosition());
        return false;
    }

    public void setTabSelected(int i) {
        this.f2113i = i;
        int childCount = this.f2106b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f2106b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                m2754a(i);
            }
            i2++;
        }
        if (this.f2110f != null && i >= 0) {
            this.f2110f.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.f2112h = i;
        requestLayout();
    }

    /* renamed from: d */
    private Spinner m2752d() {
        Spinner c3332y = new C3332y(getContext(), null, C0581a.actionDropDownStyle);
        c3332y.setLayoutParams(new C0762a(-2, -1));
        c3332y.setOnItemSelectedListener(this);
        return c3332y;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        configuration = C0638a.m2121a(getContext());
        setContentHeight(configuration.m2126e());
        this.f2108d = configuration.m2128g();
    }

    /* renamed from: a */
    public void m2754a(int i) {
        i = this.f2106b.getChildAt(i);
        if (this.f2105a != null) {
            removeCallbacks(this.f2105a);
        }
        this.f2105a = new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ bg f2095b;

            public void run() {
                this.f2095b.smoothScrollTo(i.getLeft() - ((this.f2095b.getWidth() - i.getWidth()) / 2), 0);
                this.f2095b.f2105a = null;
            }
        };
        post(this.f2105a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2105a != null) {
            post(this.f2105a);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2105a != null) {
            removeCallbacks(this.f2105a);
        }
    }

    /* renamed from: a */
    C0776c m2753a(C0607c c0607c, boolean z) {
        C0776c c0776c = new C0776c(this, getContext(), c0607c, z);
        if (z) {
            c0776c.setBackgroundDrawable(null);
            c0776c.setLayoutParams(new AbsListView.LayoutParams(true, this.f2112h));
        } else {
            c0776c.setFocusable(true);
            if (this.f2109e == null) {
                this.f2109e = new C0775b(this);
            }
            c0776c.setOnClickListener(this.f2109e);
        }
        return c0776c;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((C0776c) view).m2748b().m2017d();
    }
}
