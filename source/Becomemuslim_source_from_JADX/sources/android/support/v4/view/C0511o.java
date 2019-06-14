package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper */
/* renamed from: android.support.v4.view.o */
public class C0511o {
    /* renamed from: a */
    private final ViewGroup f1281a;
    /* renamed from: b */
    private int f1282b;

    public C0511o(ViewGroup viewGroup) {
        this.f1281a = viewGroup;
    }

    /* renamed from: a */
    public void m1628a(View view, View view2, int i) {
        m1629a(view, view2, i, 0);
    }

    /* renamed from: a */
    public void m1629a(View view, View view2, int i, int i2) {
        this.f1282b = i;
    }

    /* renamed from: a */
    public int m1625a() {
        return this.f1282b;
    }

    /* renamed from: a */
    public void m1626a(View view) {
        m1627a(view, 0);
    }

    /* renamed from: a */
    public void m1627a(View view, int i) {
        this.f1282b = null;
    }
}
