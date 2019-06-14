package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionProvider */
/* renamed from: android.support.v4.view.c */
public abstract class C0497c {
    /* renamed from: a */
    private final Context f1267a;
    /* renamed from: b */
    private C0495a f1268b;
    /* renamed from: c */
    private C0496b f1269c;

    /* compiled from: ActionProvider */
    /* renamed from: android.support.v4.view.c$a */
    public interface C0495a {
        /* renamed from: a */
        void mo2783a(boolean z);
    }

    /* compiled from: ActionProvider */
    /* renamed from: android.support.v4.view.c$b */
    public interface C0496b {
        /* renamed from: a */
        void mo473a(boolean z);
    }

    /* renamed from: a */
    public abstract View mo474a();

    /* renamed from: a */
    public void mo475a(SubMenu subMenu) {
    }

    /* renamed from: b */
    public boolean mo2746b() {
        return false;
    }

    /* renamed from: c */
    public boolean mo2747c() {
        return true;
    }

    /* renamed from: d */
    public boolean mo476d() {
        return false;
    }

    /* renamed from: e */
    public boolean mo477e() {
        return false;
    }

    public C0497c(Context context) {
        this.f1267a = context;
    }

    /* renamed from: a */
    public View mo2744a(MenuItem menuItem) {
        return mo474a();
    }

    /* renamed from: a */
    public void m1579a(boolean z) {
        if (this.f1268b != null) {
            this.f1268b.mo2783a(z);
        }
    }

    /* renamed from: a */
    public void m1576a(C0495a c0495a) {
        this.f1268b = c0495a;
    }

    /* renamed from: a */
    public void mo2745a(C0496b c0496b) {
        if (!(this.f1269c == null || c0496b == null)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append(" instance while it is still in use somewhere else?");
            Log.w("ActionProvider(support)", stringBuilder.toString());
        }
        this.f1269c = c0496b;
    }

    /* renamed from: f */
    public void m1584f() {
        this.f1269c = null;
        this.f1268b = null;
    }
}
