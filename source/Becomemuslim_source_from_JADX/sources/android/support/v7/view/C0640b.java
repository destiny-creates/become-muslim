package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* compiled from: ActionMode */
/* renamed from: android.support.v7.view.b */
public abstract class C0640b {
    /* renamed from: a */
    private Object f1623a;
    /* renamed from: b */
    private boolean f1624b;

    /* compiled from: ActionMode */
    /* renamed from: android.support.v7.view.b$a */
    public interface C0639a {
        /* renamed from: a */
        void mo380a(C0640b c0640b);

        /* renamed from: a */
        boolean mo381a(C0640b c0640b, Menu menu);

        /* renamed from: a */
        boolean mo382a(C0640b c0640b, MenuItem menuItem);

        /* renamed from: b */
        boolean mo383b(C0640b c0640b, Menu menu);
    }

    /* renamed from: a */
    public abstract MenuInflater mo411a();

    /* renamed from: a */
    public abstract void mo412a(int i);

    /* renamed from: a */
    public abstract void mo413a(View view);

    /* renamed from: a */
    public abstract void mo414a(CharSequence charSequence);

    /* renamed from: b */
    public abstract Menu mo416b();

    /* renamed from: b */
    public abstract void mo417b(int i);

    /* renamed from: b */
    public abstract void mo418b(CharSequence charSequence);

    /* renamed from: c */
    public abstract void mo419c();

    /* renamed from: d */
    public abstract void mo420d();

    /* renamed from: f */
    public abstract CharSequence mo421f();

    /* renamed from: g */
    public abstract CharSequence mo422g();

    /* renamed from: h */
    public boolean mo423h() {
        return false;
    }

    /* renamed from: i */
    public abstract View mo424i();

    /* renamed from: a */
    public void m2137a(Object obj) {
        this.f1623a = obj;
    }

    /* renamed from: j */
    public Object m2148j() {
        return this.f1623a;
    }

    /* renamed from: a */
    public void mo415a(boolean z) {
        this.f1624b = z;
    }

    /* renamed from: k */
    public boolean m2149k() {
        return this.f1624b;
    }
}
