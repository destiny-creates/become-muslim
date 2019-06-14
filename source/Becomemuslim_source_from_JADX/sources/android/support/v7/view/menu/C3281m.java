package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

/* compiled from: MenuPopup */
/* renamed from: android.support.v7.view.menu.m */
abstract class C3281m implements C0662o, C0666s, OnItemClickListener {
    /* renamed from: a */
    private Rect f8555a;

    /* renamed from: a */
    public abstract void mo2735a(int i);

    /* renamed from: a */
    public void mo463a(Context context, C3273h c3273h) {
    }

    /* renamed from: a */
    public abstract void mo2736a(C3273h c3273h);

    /* renamed from: a */
    public abstract void mo2737a(View view);

    /* renamed from: a */
    public abstract void mo2738a(OnDismissListener onDismissListener);

    /* renamed from: a */
    public abstract void mo2739a(boolean z);

    /* renamed from: a */
    public boolean mo466a(C3273h c3273h, C3276j c3276j) {
        return false;
    }

    /* renamed from: b */
    public abstract void mo2740b(int i);

    /* renamed from: b */
    public boolean mo470b(C3273h c3273h, C3276j c3276j) {
        return false;
    }

    /* renamed from: c */
    public abstract void mo2741c(int i);

    /* renamed from: c */
    public abstract void mo2742c(boolean z);

    /* renamed from: f */
    protected boolean mo2743f() {
        return true;
    }

    C3281m() {
    }

    /* renamed from: a */
    public void m10146a(Rect rect) {
        this.f8555a = rect;
    }

    /* renamed from: g */
    public Rect m10157g() {
        return this.f8555a;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        C3281m.m10142a(listAdapter).f1693b.m10071a((MenuItem) listAdapter.getItem(i), (C0662o) this, mo2743f() != 0 ? 0 : 4);
    }

    /* renamed from: a */
    protected static int m10141a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int i2 = 0;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        ViewGroup viewGroup2 = viewGroup;
        View view = null;
        viewGroup = null;
        int i3 = 0;
        while (i2 < count) {
            int itemViewType = listAdapter.getItemViewType(i2);
            if (itemViewType != viewGroup) {
                view = null;
                viewGroup = itemViewType;
            }
            if (viewGroup2 == null) {
                viewGroup2 = new FrameLayout(context);
            }
            view = listAdapter.getView(i2, view, viewGroup2);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            itemViewType = view.getMeasuredWidth();
            if (itemViewType >= i) {
                return i;
            }
            if (itemViewType > i3) {
                i3 = itemViewType;
            }
            i2++;
        }
        return i3;
    }

    /* renamed from: a */
    protected static C0656g m10142a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (C0656g) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (C0656g) listAdapter;
    }

    /* renamed from: b */
    protected static boolean m10143b(C3273h c3273h) {
        int size = c3273h.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c3273h.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }
}
