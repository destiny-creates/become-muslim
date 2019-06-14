package com.facebook.ads.internal.view.p114c.p115a;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0701i;

/* renamed from: com.facebook.ads.internal.view.c.a.c */
public final class C4845c extends RecyclerView {
    public C4845c(Context context) {
        super(context);
        C0701i linearLayoutManager = new LinearLayoutManager(context, 0, false);
        linearLayoutManager.setAutoMeasureEnabled(true);
        super.setLayoutManager(linearLayoutManager);
    }

    public LinearLayoutManager getLayoutManager() {
        return (LinearLayoutManager) super.getLayoutManager();
    }

    public void setLayoutManager(C0701i c0701i) {
    }
}
