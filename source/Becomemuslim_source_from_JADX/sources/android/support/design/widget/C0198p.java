package android.support.design.widget;

import android.support.v4.view.C0517s;
import android.view.View;

/* compiled from: ViewOffsetHelper */
/* renamed from: android.support.design.widget.p */
class C0198p {
    /* renamed from: a */
    private final View f454a;
    /* renamed from: b */
    private int f455b;
    /* renamed from: c */
    private int f456c;
    /* renamed from: d */
    private int f457d;
    /* renamed from: e */
    private int f458e;

    public C0198p(View view) {
        this.f454a = view;
    }

    /* renamed from: a */
    public void m456a() {
        this.f455b = this.f454a.getTop();
        this.f456c = this.f454a.getLeft();
        m455c();
    }

    /* renamed from: c */
    private void m455c() {
        C0517s.m1707c(this.f454a, this.f457d - (this.f454a.getTop() - this.f455b));
        C0517s.m1710d(this.f454a, this.f458e - (this.f454a.getLeft() - this.f456c));
    }

    /* renamed from: a */
    public boolean m457a(int i) {
        if (this.f457d == i) {
            return false;
        }
        this.f457d = i;
        m455c();
        return true;
    }

    /* renamed from: b */
    public boolean m459b(int i) {
        if (this.f458e == i) {
            return false;
        }
        this.f458e = i;
        m455c();
        return true;
    }

    /* renamed from: b */
    public int m458b() {
        return this.f457d;
    }
}
