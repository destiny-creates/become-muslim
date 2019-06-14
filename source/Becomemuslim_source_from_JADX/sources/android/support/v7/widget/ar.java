package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0709p;
import android.support.v7.widget.RecyclerView.C0715u;
import android.view.View;

/* compiled from: LayoutState */
class ar {
    /* renamed from: a */
    boolean f2018a = true;
    /* renamed from: b */
    int f2019b;
    /* renamed from: c */
    int f2020c;
    /* renamed from: d */
    int f2021d;
    /* renamed from: e */
    int f2022e;
    /* renamed from: f */
    int f2023f = 0;
    /* renamed from: g */
    int f2024g = 0;
    /* renamed from: h */
    boolean f2025h;
    /* renamed from: i */
    boolean f2026i;

    ar() {
    }

    /* renamed from: a */
    boolean m2655a(C0715u c0715u) {
        return (this.f2020c < 0 || this.f2020c >= c0715u.m2402e()) ? null : true;
    }

    /* renamed from: a */
    View m2654a(C0709p c0709p) {
        c0709p = c0709p.m2370c(this.f2020c);
        this.f2020c += this.f2021d;
        return c0709p;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LayoutState{mAvailable=");
        stringBuilder.append(this.f2019b);
        stringBuilder.append(", mCurrentPosition=");
        stringBuilder.append(this.f2020c);
        stringBuilder.append(", mItemDirection=");
        stringBuilder.append(this.f2021d);
        stringBuilder.append(", mLayoutDirection=");
        stringBuilder.append(this.f2022e);
        stringBuilder.append(", mStartLine=");
        stringBuilder.append(this.f2023f);
        stringBuilder.append(", mEndLine=");
        stringBuilder.append(this.f2024g);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
