package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.p035a.C0591a.C0590j;
import android.support.v7.view.C0640b;
import android.support.v7.view.C0640b.C0639a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: ActionBar */
/* renamed from: android.support.v7.app.a */
public abstract class C0608a {

    /* compiled from: ActionBar */
    /* renamed from: android.support.v7.app.a$a */
    public static class C0605a extends MarginLayoutParams {
        /* renamed from: a */
        public int f1558a;

        public C0605a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1558a = 0;
            context = context.obtainStyledAttributes(attributeSet, C0590j.ActionBarLayout);
            this.f1558a = context.getInt(C0590j.ActionBarLayout_android_layout_gravity, 0);
            context.recycle();
        }

        public C0605a(int i, int i2) {
            super(i, i2);
            this.f1558a = 0;
            this.f1558a = 8388627;
        }

        public C0605a(C0605a c0605a) {
            super(c0605a);
            this.f1558a = 0;
            this.f1558a = c0605a.f1558a;
        }

        public C0605a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1558a = null;
        }
    }

    /* compiled from: ActionBar */
    /* renamed from: android.support.v7.app.a$b */
    public interface C0606b {
        /* renamed from: a */
        void m2013a(boolean z);
    }

    @Deprecated
    /* compiled from: ActionBar */
    /* renamed from: android.support.v7.app.a$c */
    public static abstract class C0607c {
        /* renamed from: a */
        public abstract Drawable m2014a();

        /* renamed from: b */
        public abstract CharSequence m2015b();

        /* renamed from: c */
        public abstract View m2016c();

        /* renamed from: d */
        public abstract void m2017d();

        /* renamed from: e */
        public abstract CharSequence m2018e();
    }

    /* renamed from: a */
    public abstract int mo391a();

    /* renamed from: a */
    public C0640b mo425a(C0639a c0639a) {
        return null;
    }

    /* renamed from: a */
    public void mo393a(Configuration configuration) {
    }

    /* renamed from: a */
    public abstract void mo394a(CharSequence charSequence);

    /* renamed from: a */
    public abstract void mo395a(boolean z);

    /* renamed from: a */
    public boolean mo396a(int i, KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: a */
    public boolean mo397a(KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: b */
    public Context mo398b() {
        return null;
    }

    /* renamed from: b */
    public void mo399b(CharSequence charSequence) {
    }

    /* renamed from: b */
    public abstract void mo400b(boolean z);

    /* renamed from: c */
    public void mo401c(boolean z) {
    }

    /* renamed from: c */
    public boolean mo402c() {
        return false;
    }

    /* renamed from: d */
    public boolean mo403d() {
        return false;
    }

    /* renamed from: e */
    public void mo404e(boolean z) {
    }

    /* renamed from: e */
    public boolean mo405e() {
        return false;
    }

    /* renamed from: f */
    public void mo406f(boolean z) {
    }

    /* renamed from: f */
    public boolean mo407f() {
        return false;
    }

    /* renamed from: g */
    void mo408g() {
    }

    /* renamed from: g */
    public void mo409g(boolean z) {
    }

    /* renamed from: d */
    public void mo427d(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    /* renamed from: a */
    public void mo392a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }
}
