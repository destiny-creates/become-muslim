package android.support.v7.widget;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0497c;
import android.support.v7.p035a.C0591a.C0586f;
import android.support.v7.p035a.C0591a.C0587g;
import android.support.v7.p035a.C0591a.C0588h;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

public class ActivityChooserView extends ViewGroup {
    /* renamed from: a */
    final C0677a f1736a;
    /* renamed from: b */
    final FrameLayout f1737b;
    /* renamed from: c */
    final FrameLayout f1738c;
    /* renamed from: d */
    C0497c f1739d;
    /* renamed from: e */
    final DataSetObserver f1740e;
    /* renamed from: f */
    OnDismissListener f1741f;
    /* renamed from: g */
    boolean f1742g;
    /* renamed from: h */
    int f1743h;
    /* renamed from: i */
    private final C0678b f1744i;
    /* renamed from: j */
    private final View f1745j;
    /* renamed from: k */
    private final ImageView f1746k;
    /* renamed from: l */
    private final int f1747l;
    /* renamed from: m */
    private final OnGlobalLayoutListener f1748m;
    /* renamed from: n */
    private au f1749n;
    /* renamed from: o */
    private boolean f1750o;
    /* renamed from: p */
    private int f1751p;

    public static class InnerLayout extends LinearLayout {
        /* renamed from: a */
        private static final int[] f1728a = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = bq.m2768a(context, attributeSet, f1728a);
            setBackgroundDrawable(context.m2773a(null));
            context.m2774a();
        }
    }

    /* renamed from: android.support.v7.widget.ActivityChooserView$a */
    private class C0677a extends BaseAdapter {
        /* renamed from: a */
        final /* synthetic */ ActivityChooserView f1729a;
        /* renamed from: b */
        private C0792e f1730b;
        /* renamed from: c */
        private int f1731c;
        /* renamed from: d */
        private boolean f1732d;
        /* renamed from: e */
        private boolean f1733e;
        /* renamed from: f */
        private boolean f1734f;

        public long getItemId(int i) {
            return (long) i;
        }

        public int getViewTypeCount() {
            return 3;
        }

        /* renamed from: a */
        public void m2234a(C0792e c0792e) {
            C0792e d = this.f1729a.f1736a.m2239d();
            if (d != null && this.f1729a.isShown()) {
                d.unregisterObserver(this.f1729a.f1740e);
            }
            this.f1730b = c0792e;
            if (c0792e != null && this.f1729a.isShown()) {
                c0792e.registerObserver(this.f1729a.f1740e);
            }
            notifyDataSetChanged();
        }

        public int getItemViewType(int i) {
            return (this.f1734f && i == getCount() - 1) ? 1 : 0;
        }

        public int getCount() {
            int a = this.f1730b.m2855a();
            if (!(this.f1732d || this.f1730b.m2859b() == null)) {
                a--;
            }
            a = Math.min(a, this.f1731c);
            return this.f1734f ? a + 1 : a;
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!(this.f1732d || this.f1730b.m2859b() == null)) {
                        i++;
                    }
                    return this.f1730b.m2857a(i);
                case 1:
                    return 0;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != C0586f.list_item) {
                        view = LayoutInflater.from(this.f1729a.getContext()).inflate(C0587g.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    viewGroup = this.f1729a.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(C0586f.icon)).setImageDrawable(resolveInfo.loadIcon(viewGroup));
                    ((TextView) view.findViewById(C0586f.title)).setText(resolveInfo.loadLabel(viewGroup));
                    if (this.f1732d == null || i != 0 || this.f1733e == 0) {
                        view.setActivated(false);
                    } else {
                        view.setActivated(true);
                    }
                    return view;
                case 1:
                    if (view == null || view.getId() != 1) {
                        view = LayoutInflater.from(this.f1729a.getContext()).inflate(C0587g.abc_activity_chooser_view_list_item, viewGroup, false);
                        view.setId(1);
                        ((TextView) view.findViewById(C0586f.title)).setText(this.f1729a.getContext().getString(C0588h.abc_activity_chooser_view_see_all));
                    }
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        /* renamed from: a */
        public int m2232a() {
            int i = this.f1731c;
            this.f1731c = Integer.MAX_VALUE;
            int i2 = 0;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            while (i2 < count) {
                view = getView(i2, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
                i2++;
            }
            this.f1731c = i;
            return i3;
        }

        /* renamed from: a */
        public void m2233a(int i) {
            if (this.f1731c != i) {
                this.f1731c = i;
                notifyDataSetChanged();
            }
        }

        /* renamed from: b */
        public ResolveInfo m2237b() {
            return this.f1730b.m2859b();
        }

        /* renamed from: a */
        public void m2235a(boolean z) {
            if (this.f1734f != z) {
                this.f1734f = z;
                notifyDataSetChanged();
            }
        }

        /* renamed from: c */
        public int m2238c() {
            return this.f1730b.m2855a();
        }

        /* renamed from: d */
        public C0792e m2239d() {
            return this.f1730b;
        }

        /* renamed from: a */
        public void m2236a(boolean z, boolean z2) {
            if (this.f1732d != z || this.f1733e != z2) {
                this.f1732d = z;
                this.f1733e = z2;
                notifyDataSetChanged();
            }
        }

        /* renamed from: e */
        public boolean m2240e() {
            return this.f1732d;
        }
    }

    /* renamed from: android.support.v7.widget.ActivityChooserView$b */
    private class C0678b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        /* renamed from: a */
        final /* synthetic */ ActivityChooserView f1735a;

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((C0677a) adapterView.getAdapter()).getItemViewType(i)) {
                case null:
                    this.f1735a.m2244b();
                    if (this.f1735a.f1742g == null) {
                        if (this.f1735a.f1736a.m2240e() == null) {
                            i++;
                        }
                        adapterView = this.f1735a.f1736a.m2239d().m2858b(i);
                        if (adapterView != null) {
                            adapterView.addFlags(524288);
                            this.f1735a.getContext().startActivity(adapterView);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        this.f1735a.f1736a.m2239d().m2860c(i);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.f1735a.m2242a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void onClick(View view) {
            if (view == this.f1735a.f1738c) {
                this.f1735a.m2244b();
                view = this.f1735a.f1736a.m2239d().m2858b(this.f1735a.f1736a.m2239d().m2856a(this.f1735a.f1736a.m2237b()));
                if (view != null) {
                    view.addFlags(524288);
                    this.f1735a.getContext().startActivity(view);
                }
            } else if (view == this.f1735a.f1737b) {
                this.f1735a.f1742g = false;
                this.f1735a.m2242a(this.f1735a.f1743h);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.f1735a.f1738c) {
                if (this.f1735a.f1736a.getCount() > null) {
                    this.f1735a.f1742g = true;
                    this.f1735a.m2242a(this.f1735a.f1743h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public void onDismiss() {
            m2241a();
            if (this.f1735a.f1739d != null) {
                this.f1735a.f1739d.m1579a(false);
            }
        }

        /* renamed from: a */
        private void m2241a() {
            if (this.f1735a.f1741f != null) {
                this.f1735a.f1741f.onDismiss();
            }
        }
    }

    public void setActivityChooserModel(C0792e c0792e) {
        this.f1736a.m2234a(c0792e);
        if (m2245c() != null) {
            m2244b();
            m2243a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1746k.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1746k.setContentDescription(getContext().getString(i));
    }

    public void setProvider(C0497c c0497c) {
        this.f1739d = c0497c;
    }

    /* renamed from: a */
    public boolean m2243a() {
        if (!m2245c()) {
            if (this.f1750o) {
                this.f1742g = false;
                m2242a(this.f1743h);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    void m2242a(int i) {
        if (this.f1736a.m2239d() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.f1748m);
            boolean z = this.f1738c.getVisibility() == 0;
            int c = this.f1736a.m2238c();
            if (i == Integer.MAX_VALUE || c <= i + z) {
                this.f1736a.m2235a(false);
                this.f1736a.m2233a(i);
            } else {
                this.f1736a.m2235a(true);
                this.f1736a.m2233a(i - 1);
            }
            i = getListPopupWindow();
            if (!i.mo636d()) {
                if (!this.f1742g) {
                    if (z) {
                        this.f1736a.m2236a(false, false);
                        i.m10465g(Math.min(this.f1736a.m2232a(), this.f1747l));
                        i.mo634a();
                        if (this.f1739d != null) {
                            this.f1739d.m1579a(true);
                        }
                        i.mo637e().setContentDescription(getContext().getString(C0588h.abc_activitychooserview_choose_application));
                        i.mo637e().setSelector(new ColorDrawable(0));
                        return;
                    }
                }
                this.f1736a.m2236a(true, z);
                i.m10465g(Math.min(this.f1736a.m2232a(), this.f1747l));
                i.mo634a();
                if (this.f1739d != null) {
                    this.f1739d.m1579a(true);
                }
                i.mo637e().setContentDescription(getContext().getString(C0588h.abc_activitychooserview_choose_application));
                i.mo637e().setSelector(new ColorDrawable(0));
                return;
            }
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    /* renamed from: b */
    public boolean m2244b() {
        if (m2245c()) {
            getListPopupWindow().mo635c();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1748m);
            }
        }
        return true;
    }

    /* renamed from: c */
    public boolean m2245c() {
        return getListPopupWindow().mo636d();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0792e d = this.f1736a.m2239d();
        if (d != null) {
            d.registerObserver(this.f1740e);
        }
        this.f1750o = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0792e d = this.f1736a.m2239d();
        if (d != null) {
            d.unregisterObserver(this.f1740e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1748m);
        }
        if (m2245c()) {
            m2244b();
        }
        this.f1750o = false;
    }

    protected void onMeasure(int i, int i2) {
        View view = this.f1745j;
        if (this.f1738c.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1745j.layout(0, 0, i3 - i, i4 - i2);
        if (!m2245c()) {
            m2244b();
        }
    }

    public C0792e getDataModel() {
        return this.f1736a.m2239d();
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f1741f = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.f1743h = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1751p = i;
    }

    au getListPopupWindow() {
        if (this.f1749n == null) {
            this.f1749n = new au(getContext());
            this.f1749n.mo2786a(this.f1736a);
            this.f1749n.m10456b((View) this);
            this.f1749n.m10454a(true);
            this.f1749n.m10451a(this.f1744i);
            this.f1749n.m10453a(this.f1744i);
        }
        return this.f1749n;
    }
}
