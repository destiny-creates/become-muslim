package com.facebook.ads.internal.view.hscroll;

import android.support.v7.widget.RecyclerView.C0702j;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.facebook.ads.internal.view.hscroll.c */
public class C1664c {
    /* renamed from: a */
    public int[] m5640a(View view, int i, int i2) {
        C0702j c0702j = (C0702j) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, view.getPaddingLeft() + view.getPaddingRight(), c0702j.width), ViewGroup.getChildMeasureSpec(i2, view.getPaddingTop() + view.getPaddingBottom(), c0702j.height));
        return new int[]{(view.getMeasuredWidth() + c0702j.leftMargin) + c0702j.rightMargin, (view.getMeasuredHeight() + c0702j.bottomMargin) + c0702j.topMargin};
    }
}
