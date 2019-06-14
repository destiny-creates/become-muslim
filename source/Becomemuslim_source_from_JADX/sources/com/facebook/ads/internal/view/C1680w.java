package com.facebook.ads.internal.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* renamed from: com.facebook.ads.internal.view.w */
public class C1680w extends View {
    /* renamed from: a */
    private C1679v f4980a;

    public C1680w(Context context, C1679v c1679v) {
        super(context);
        this.f4980a = c1679v;
        setLayoutParams(new LayoutParams(0, 0));
    }

    public void onWindowVisibilityChanged(int i) {
        if (this.f4980a != null) {
            this.f4980a.mo964a(i);
        }
    }
}
