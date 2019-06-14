package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.C3273h.C0658b;
import android.support.v7.widget.bq;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements C0658b, C0664p, OnItemClickListener {
    /* renamed from: a */
    private static final int[] f8421a = new int[]{16842964, 16843049};
    /* renamed from: b */
    private C3273h f8422b;
    /* renamed from: c */
    private int f8423c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        context = bq.m2769a(context, attributeSet, f8421a, i, 0);
        if (context.m2787g(0) != null) {
            setBackgroundDrawable(context.m2773a(0));
        }
        if (context.m2787g(1) != 0) {
            setDivider(context.m2773a(1));
        }
        context.m2774a();
    }

    /* renamed from: a */
    public void mo435a(C3273h c3273h) {
        this.f8422b = c3273h;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    /* renamed from: a */
    public boolean mo436a(C3276j c3276j) {
        return this.f8422b.m10070a((MenuItem) c3276j, 0);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo436a((C3276j) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.f8423c;
    }
}
