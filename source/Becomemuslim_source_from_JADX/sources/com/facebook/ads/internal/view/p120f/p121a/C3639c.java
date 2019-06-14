package com.facebook.ads.internal.view.p120f.p121a;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.view.p120f.C3640a;

/* renamed from: com.facebook.ads.internal.view.f.a.c */
public abstract class C3639c extends RelativeLayout implements C1625b {
    /* renamed from: a */
    private C3640a f9747a;

    public C3639c(Context context) {
        super(context);
    }

    public C3639c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutParams(new LayoutParams(-1, -1));
    }

    /* renamed from: a */
    protected void mo2877a() {
    }

    /* renamed from: a */
    public void mo1029a(C3640a c3640a) {
        this.f9747a = c3640a;
        mo2877a();
    }

    /* renamed from: b */
    protected void mo2878b() {
    }

    /* renamed from: b */
    public void mo1030b(C3640a c3640a) {
        mo2878b();
        this.f9747a = null;
    }

    protected C3640a getVideoView() {
        return this.f9747a;
    }
}
