package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p024c.p025a.C0351b;
import android.support.v4.view.C0497c.C0496b;
import android.support.v7.view.menu.C4483k.C3277a;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

/* compiled from: MenuItemWrapperJB */
/* renamed from: android.support.v7.view.menu.l */
class C4833l extends C4483k {

    /* compiled from: MenuItemWrapperJB */
    /* renamed from: android.support.v7.view.menu.l$a */
    class C4484a extends C3277a implements VisibilityListener {
        /* renamed from: c */
        C0496b f12021c;
        /* renamed from: d */
        final /* synthetic */ C4833l f12022d;

        public C4484a(C4833l c4833l, Context context, ActionProvider actionProvider) {
            this.f12022d = c4833l;
            super(c4833l, context, actionProvider);
        }

        /* renamed from: a */
        public View mo2744a(MenuItem menuItem) {
            return this.a.onCreateActionView(menuItem);
        }

        /* renamed from: b */
        public boolean mo2746b() {
            return this.a.overridesItemVisibility();
        }

        /* renamed from: c */
        public boolean mo2747c() {
            return this.a.isVisible();
        }

        /* renamed from: a */
        public void mo2745a(C0496b c0496b) {
            this.f12021c = c0496b;
            this.a.setVisibilityListener(c0496b != null ? this : null);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f12021c != null) {
                this.f12021c.mo473a(z);
            }
        }
    }

    C4833l(Context context, C0351b c0351b) {
        super(context, c0351b);
    }

    /* renamed from: a */
    C3277a mo3340a(ActionProvider actionProvider) {
        return new C4484a(this, this.a, actionProvider);
    }
}
