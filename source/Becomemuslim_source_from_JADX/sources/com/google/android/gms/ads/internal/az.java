package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ViewSwitcher;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.kq;
import com.google.android.gms.internal.ads.mh;
import com.google.android.gms.internal.ads.qo;
import java.util.ArrayList;
import java.util.List;

public final class az extends ViewSwitcher {
    /* renamed from: a */
    private final kq f6816a;
    /* renamed from: b */
    private final mh f6817b;
    /* renamed from: c */
    private boolean f6818c = true;

    public az(Context context, String str, String str2, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        super(context);
        this.f6816a = new kq(context);
        this.f6816a.a(str);
        this.f6816a.b(str2);
        if (context instanceof Activity) {
            this.f6817b = new mh((Activity) context, this, onGlobalLayoutListener, onScrollChangedListener);
        } else {
            this.f6817b = new mh(null, this, onGlobalLayoutListener, onScrollChangedListener);
        }
        this.f6817b.a();
    }

    /* renamed from: a */
    public final kq m7496a() {
        return this.f6816a;
    }

    /* renamed from: b */
    public final void m7497b() {
        jn.a("Disable position monitoring on adFrame.");
        if (this.f6817b != null) {
            this.f6817b.b();
        }
    }

    /* renamed from: c */
    public final void m7498c() {
        jn.a("Enable debug gesture detector on adFrame.");
        this.f6818c = true;
    }

    /* renamed from: d */
    public final void m7499d() {
        jn.a("Disable debug gesture detector on adFrame.");
        this.f6818c = false;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6817b != null) {
            this.f6817b.c();
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f6817b != null) {
            this.f6817b.d();
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f6818c) {
            this.f6816a.a(motionEvent);
        }
        return false;
    }

    public final void removeAllViews() {
        int i;
        List arrayList = new ArrayList();
        int i2 = 0;
        for (i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof qo)) {
                arrayList.add((qo) childAt);
            }
        }
        super.removeAllViews();
        ArrayList arrayList2 = (ArrayList) arrayList;
        i = arrayList2.size();
        while (i2 < i) {
            Object obj = arrayList2.get(i2);
            i2++;
            ((qo) obj).destroy();
        }
    }
}
