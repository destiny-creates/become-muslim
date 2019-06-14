package com.facebook.ads.internal.view.hscroll;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0701i;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: com.facebook.ads.internal.view.hscroll.d */
public class C4846d extends RecyclerView implements OnTouchListener {
    /* renamed from: a */
    protected final int f13770a = m17232a();
    /* renamed from: b */
    protected int f13771b = 0;
    /* renamed from: c */
    private int f13772c = 0;
    /* renamed from: d */
    private boolean f13773d = true;
    /* renamed from: e */
    private boolean f13774e = false;
    /* renamed from: f */
    private LinearLayoutManager f13775f;
    /* renamed from: g */
    private C1665a f13776g;

    /* renamed from: com.facebook.ads.internal.view.hscroll.d$a */
    public interface C1665a {
        /* renamed from: a */
        int mo3485a(int i);
    }

    public C4846d(Context context) {
        super(context);
        setOnTouchListener(this);
    }

    public C4846d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnTouchListener(this);
    }

    public C4846d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOnTouchListener(this);
    }

    /* renamed from: a */
    private int m17232a() {
        return ((int) getContext().getResources().getDisplayMetrics().density) * 10;
    }

    /* renamed from: a */
    private int mo3485a(int i) {
        int i2 = this.f13772c - i;
        i = this.f13776g.mo3485a(i2);
        return i2 > this.f13770a ? m17234a(this.f13771b, i) : i2 < (-this.f13770a) ? m17235b(this.f13771b, i) : this.f13771b;
    }

    /* renamed from: a */
    private int m17234a(int i, int i2) {
        return Math.min(i + i2, getItemCount() - 1);
    }

    /* renamed from: b */
    private int m17235b(int i, int i2) {
        return Math.max(i - i2, 0);
    }

    private int getItemCount() {
        return getAdapter() == null ? 0 : getAdapter().getItemCount();
    }

    /* renamed from: a */
    protected void mo3486a(int i, boolean z) {
        if (getAdapter() != null) {
            this.f13771b = i;
            if (z) {
                smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public int getCurrentPosition() {
        return this.f13771b;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int actionMasked = motionEvent.getActionMasked();
        if (!(actionMasked == 1 || actionMasked == 6 || actionMasked == 3)) {
            if (actionMasked != 4) {
                if (actionMasked == 0 || actionMasked == 5 || (this.f13773d && actionMasked == 2)) {
                    this.f13772c = rawX;
                    if (this.f13773d) {
                        this.f13773d = false;
                    }
                    this.f13774e = true;
                }
                return false;
            }
        }
        if (this.f13774e) {
            mo3486a(mo3485a(rawX), true);
        }
        this.f13773d = true;
        this.f13774e = false;
        return true;
    }

    public void setLayoutManager(C0701i c0701i) {
        if (c0701i instanceof LinearLayoutManager) {
            super.setLayoutManager(c0701i);
            this.f13775f = (LinearLayoutManager) c0701i;
            return;
        }
        throw new IllegalArgumentException("SnapRecyclerView only supports LinearLayoutManager");
    }

    public void setSnapDelegate(C1665a c1665a) {
        this.f13776g = c1665a;
    }
}
