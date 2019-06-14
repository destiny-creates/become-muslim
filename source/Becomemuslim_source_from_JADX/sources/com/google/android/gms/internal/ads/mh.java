package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import com.google.android.gms.ads.internal.ax;

@cm
public final class mh {
    /* renamed from: a */
    private final View f15789a;
    /* renamed from: b */
    private Activity f15790b;
    /* renamed from: c */
    private boolean f15791c;
    /* renamed from: d */
    private boolean f15792d;
    /* renamed from: e */
    private boolean f15793e;
    /* renamed from: f */
    private OnGlobalLayoutListener f15794f;
    /* renamed from: g */
    private OnScrollChangedListener f15795g;

    public mh(Activity activity, View view, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        this.f15790b = activity;
        this.f15789a = view;
        this.f15794f = onGlobalLayoutListener;
        this.f15795g = onScrollChangedListener;
    }

    /* renamed from: b */
    private static ViewTreeObserver m19856b(Activity activity) {
        if (activity == null) {
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            return null;
        }
        View decorView = window.getDecorView();
        return decorView == null ? null : decorView.getViewTreeObserver();
    }

    /* renamed from: e */
    private final void m19857e() {
        if (!this.f15791c) {
            Activity activity;
            ViewTreeObserver b;
            if (this.f15794f != null) {
                if (this.f15790b != null) {
                    activity = this.f15790b;
                    OnGlobalLayoutListener onGlobalLayoutListener = this.f15794f;
                    b = m19856b(activity);
                    if (b != null) {
                        b.addOnGlobalLayoutListener(onGlobalLayoutListener);
                    }
                }
                ax.A();
                oh.m19964a(this.f15789a, this.f15794f);
            }
            if (this.f15795g != null) {
                if (this.f15790b != null) {
                    activity = this.f15790b;
                    OnScrollChangedListener onScrollChangedListener = this.f15795g;
                    b = m19856b(activity);
                    if (b != null) {
                        b.addOnScrollChangedListener(onScrollChangedListener);
                    }
                }
                ax.A();
                oh.m19965a(this.f15789a, this.f15795g);
            }
            this.f15791c = true;
        }
    }

    /* renamed from: f */
    private final void m19858f() {
        if (this.f15790b != null && this.f15791c) {
            Activity activity;
            ViewTreeObserver b;
            if (this.f15794f != null) {
                activity = this.f15790b;
                OnGlobalLayoutListener onGlobalLayoutListener = this.f15794f;
                b = m19856b(activity);
                if (b != null) {
                    ax.g().mo6844a(b, onGlobalLayoutListener);
                }
            }
            if (this.f15795g != null) {
                activity = this.f15790b;
                OnScrollChangedListener onScrollChangedListener = this.f15795g;
                b = m19856b(activity);
                if (b != null) {
                    b.removeOnScrollChangedListener(onScrollChangedListener);
                }
            }
            this.f15791c = false;
        }
    }

    /* renamed from: a */
    public final void m19859a() {
        this.f15793e = true;
        if (this.f15792d) {
            m19857e();
        }
    }

    /* renamed from: a */
    public final void m19860a(Activity activity) {
        this.f15790b = activity;
    }

    /* renamed from: b */
    public final void m19861b() {
        this.f15793e = false;
        m19858f();
    }

    /* renamed from: c */
    public final void m19862c() {
        this.f15792d = true;
        if (this.f15793e) {
            m19857e();
        }
    }

    /* renamed from: d */
    public final void m19863d() {
        this.f15792d = false;
        m19858f();
    }
}
