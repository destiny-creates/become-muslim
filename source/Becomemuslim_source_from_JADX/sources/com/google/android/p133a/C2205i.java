package com.google.android.p133a;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;

/* compiled from: PreviewImpl */
/* renamed from: com.google.android.a.i */
abstract class C2205i {
    /* renamed from: a */
    private C2204a f5255a;
    /* renamed from: b */
    private int f5256b;
    /* renamed from: c */
    private int f5257c;

    /* compiled from: PreviewImpl */
    /* renamed from: com.google.android.a.i$a */
    interface C2204a {
        /* renamed from: a */
        void mo2057a();

        /* renamed from: b */
        void mo2058b();
    }

    /* renamed from: a */
    abstract Surface mo2100a();

    /* renamed from: a */
    abstract void mo2101a(int i);

    /* renamed from: a */
    void mo2106a(int i, int i2) {
    }

    /* renamed from: b */
    abstract View mo2102b();

    /* renamed from: c */
    abstract Class mo2103c();

    /* renamed from: d */
    abstract boolean mo2104d();

    /* renamed from: g */
    SurfaceHolder mo2105g() {
        return null;
    }

    /* renamed from: h */
    Object mo2107h() {
        return null;
    }

    C2205i() {
    }

    /* renamed from: a */
    void m6084a(C2204a c2204a) {
        this.f5255a = c2204a;
    }

    /* renamed from: e */
    protected void m6089e() {
        this.f5255a.mo2057a();
    }

    /* renamed from: f */
    protected void m6090f() {
        this.f5255a.mo2058b();
    }

    /* renamed from: b */
    void m6086b(int i, int i2) {
        this.f5256b = i;
        this.f5257c = i2;
    }

    /* renamed from: i */
    int m6093i() {
        return this.f5256b;
    }

    /* renamed from: j */
    int m6094j() {
        return this.f5257c;
    }
}
