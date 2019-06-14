package com.facebook.ads.internal.view.hscroll;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0701i;
import android.support.v7.widget.RecyclerView.C0702j;
import android.support.v7.widget.RecyclerView.C0709p;
import android.support.v7.widget.RecyclerView.C0715u;
import android.support.v7.widget.at;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

public class HScrollLinearLayoutManager extends LinearLayoutManager {
    /* renamed from: a */
    private final C1664c f12603a;
    /* renamed from: b */
    private final C1662a f12604b;
    /* renamed from: c */
    private final Context f12605c;
    /* renamed from: d */
    private int[] f12606d;
    /* renamed from: e */
    private int f12607e = 0;
    /* renamed from: f */
    private float f12608f = 50.0f;
    /* renamed from: g */
    private C4626a f12609g;
    /* renamed from: h */
    private int f12610h;

    /* renamed from: com.facebook.ads.internal.view.hscroll.HScrollLinearLayoutManager$a */
    private class C4626a extends at {
        /* renamed from: a */
        final /* synthetic */ HScrollLinearLayoutManager f12602a;

        public C4626a(HScrollLinearLayoutManager hScrollLinearLayoutManager, Context context) {
            this.f12602a = hScrollLinearLayoutManager;
            super(context);
        }

        public int calculateDxToMakeVisible(View view, int i) {
            C0701i layoutManager = getLayoutManager();
            if (!layoutManager.canScrollHorizontally()) {
                return 0;
            }
            C0702j c0702j = (C0702j) view.getLayoutParams();
            return calculateDtToFit(layoutManager.getDecoratedLeft(view) - c0702j.leftMargin, layoutManager.getDecoratedRight(view) + c0702j.rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i) + this.f12602a.f12607e;
        }

        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return this.f12602a.f12608f / ((float) displayMetrics.densityDpi);
        }

        public PointF computeScrollVectorForPosition(int i) {
            return this.f12602a.computeScrollVectorForPosition(i);
        }

        protected int getHorizontalSnapPreference() {
            return -1;
        }
    }

    public HScrollLinearLayoutManager(Context context, C1664c c1664c, C1662a c1662a) {
        super(context);
        this.f12605c = context;
        this.f12603a = c1664c;
        this.f12604b = c1662a;
        this.f12610h = -1;
        this.f12609g = new C4626a(this, this.f12605c);
    }

    /* renamed from: a */
    public void m15956a(double d) {
        if (d <= 0.0d) {
            d = 1.0d;
        }
        this.f12608f = (float) (50.0d / d);
        this.f12609g = new C4626a(this, this.f12605c);
    }

    /* renamed from: a */
    void m15957a(int i) {
        this.f12610h = i;
    }

    /* renamed from: b */
    public void m15958b(int i) {
        this.f12607e = i;
    }

    public void onMeasure(C0709p c0709p, C0715u c0715u, int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if ((mode == 1073741824 && getOrientation() == 1) || (mode2 == 1073741824 && getOrientation() == 0)) {
            super.onMeasure(c0709p, c0715u, i, i2);
            return;
        }
        int[] a;
        int size = MeasureSpec.getSize(i);
        i = MeasureSpec.getSize(i2);
        if (this.f12604b.m5638b(this.f12610h)) {
            a = this.f12604b.m5637a(this.f12610h);
        } else {
            int[] iArr = new int[]{0, 0};
            if (c0715u.m2402e() >= 1) {
                int childCount = getChildCount() > 0 ? 1 : getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    this.f12606d = this.f12603a.m5640a(findViewByPosition(i3), MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    if (getOrientation() == 0) {
                        iArr[0] = iArr[0] + this.f12606d[0];
                        if (i3 == 0) {
                            iArr[1] = (this.f12606d[1] + getPaddingTop()) + getPaddingBottom();
                        }
                    } else {
                        iArr[1] = iArr[1] + this.f12606d[1];
                        if (i3 == 0) {
                            iArr[0] = (this.f12606d[0] + getPaddingLeft()) + getPaddingRight();
                        }
                    }
                }
                if (this.f12610h != -1) {
                    this.f12604b.m5636a(this.f12610h, iArr);
                }
            }
            a = iArr;
        }
        if (mode == 1073741824) {
            a[0] = size;
        }
        if (mode2 == 1073741824) {
            a[1] = i;
        }
        setMeasuredDimension(a[0], a[1]);
    }

    public void scrollToPosition(int i) {
        super.scrollToPositionWithOffset(i, this.f12607e);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, C0715u c0715u, int i) {
        this.f12609g.setTargetPosition(i);
        startSmoothScroll(this.f12609g);
    }
}
