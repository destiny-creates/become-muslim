package com.facebook.ads.internal.view.p119e;

import android.support.v7.widget.RecyclerView.C0689a;
import android.support.v7.widget.RecyclerView.C0718x;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.List;

/* renamed from: com.facebook.ads.internal.view.e.c */
public class C3635c extends C0689a<C3637e> {
    /* renamed from: a */
    private final List<String> f9733a;
    /* renamed from: b */
    private final int f9734b;

    C3635c(List<String> list, int i) {
        this.f9733a = list;
        this.f9734b = i;
    }

    /* renamed from: a */
    public C3637e m11878a(ViewGroup viewGroup, int i) {
        return new C3637e(new C3636d(viewGroup.getContext()));
    }

    /* renamed from: a */
    public void m11879a(C3637e c3637e, int i) {
        String str = (String) this.f9733a.get(i);
        LayoutParams marginLayoutParams = new MarginLayoutParams(-2, -1);
        marginLayoutParams.setMargins(i == 0 ? this.f9734b * 4 : this.f9734b, 0, i >= getItemCount() + -1 ? this.f9734b * 4 : this.f9734b, 0);
        c3637e.m11881a().setLayoutParams(marginLayoutParams);
        c3637e.m11881a().m11880a(str);
    }

    public int getItemCount() {
        return this.f9733a.size();
    }

    public /* synthetic */ void onBindViewHolder(C0718x c0718x, int i) {
        m11879a((C3637e) c0718x, i);
    }

    public /* synthetic */ C0718x onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m11878a(viewGroup, i);
    }
}
