package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.C0664p;
import android.support.v7.view.menu.C3273h;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class NavigationMenuView extends RecyclerView implements C0664p {
    /* renamed from: a */
    public void mo435a(C3273h c3273h) {
    }

    public int getWindowAnimations() {
        return 0;
    }

    public NavigationMenuView(Context context) {
        this(context, null);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutManager(new LinearLayoutManager(context, 1, false));
    }
}
