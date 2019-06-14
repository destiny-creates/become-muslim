package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.C0640b.C0639a;
import android.support.v7.view.menu.C3273h;
import android.support.v7.view.menu.C3273h.C0657a;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode */
/* renamed from: android.support.v7.view.e */
public class C3265e extends C0640b implements C0657a {
    /* renamed from: a */
    private Context f8409a;
    /* renamed from: b */
    private ActionBarContextView f8410b;
    /* renamed from: c */
    private C0639a f8411c;
    /* renamed from: d */
    private WeakReference<View> f8412d;
    /* renamed from: e */
    private boolean f8413e;
    /* renamed from: f */
    private boolean f8414f;
    /* renamed from: g */
    private C3273h f8415g;

    public C3265e(Context context, ActionBarContextView actionBarContextView, C0639a c0639a, boolean z) {
        this.f8409a = context;
        this.f8410b = actionBarContextView;
        this.f8411c = c0639a;
        this.f8415g = new C3273h(actionBarContextView.getContext()).m10054a(1);
        this.f8415g.mo2749a((C0657a) this);
        this.f8414f = z;
    }

    /* renamed from: b */
    public void mo418b(CharSequence charSequence) {
        this.f8410b.setTitle(charSequence);
    }

    /* renamed from: a */
    public void mo414a(CharSequence charSequence) {
        this.f8410b.setSubtitle(charSequence);
    }

    /* renamed from: a */
    public void mo412a(int i) {
        mo418b(this.f8409a.getString(i));
    }

    /* renamed from: b */
    public void mo417b(int i) {
        mo414a(this.f8409a.getString(i));
    }

    /* renamed from: a */
    public void mo415a(boolean z) {
        super.mo415a(z);
        this.f8410b.setTitleOptional(z);
    }

    /* renamed from: h */
    public boolean mo423h() {
        return this.f8410b.m10164d();
    }

    /* renamed from: a */
    public void mo413a(View view) {
        this.f8410b.setCustomView(view);
        this.f8412d = view != null ? new WeakReference(view) : null;
    }

    /* renamed from: d */
    public void mo420d() {
        this.f8411c.mo383b(this, this.f8415g);
    }

    /* renamed from: c */
    public void mo419c() {
        if (!this.f8413e) {
            this.f8413e = true;
            this.f8410b.sendAccessibilityEvent(32);
            this.f8411c.mo380a(this);
        }
    }

    /* renamed from: b */
    public Menu mo416b() {
        return this.f8415g;
    }

    /* renamed from: f */
    public CharSequence mo421f() {
        return this.f8410b.getTitle();
    }

    /* renamed from: g */
    public CharSequence mo422g() {
        return this.f8410b.getSubtitle();
    }

    /* renamed from: i */
    public View mo424i() {
        return this.f8412d != null ? (View) this.f8412d.get() : null;
    }

    /* renamed from: a */
    public MenuInflater mo411a() {
        return new C0646g(this.f8410b.getContext());
    }

    /* renamed from: a */
    public boolean mo389a(C3273h c3273h, MenuItem menuItem) {
        return this.f8411c.mo382a((C0640b) this, menuItem);
    }

    /* renamed from: a */
    public void mo388a(C3273h c3273h) {
        mo420d();
        this.f8410b.mo481a();
    }
}
