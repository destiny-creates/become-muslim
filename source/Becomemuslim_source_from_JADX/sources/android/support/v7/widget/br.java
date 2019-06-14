package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0517s;
import android.support.v4.view.C0525w;
import android.support.v4.view.C3232y;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p035a.C0591a.C0585e;
import android.support.v7.p035a.C0591a.C0586f;
import android.support.v7.p035a.C0591a.C0588h;
import android.support.v7.p035a.C0591a.C0590j;
import android.support.v7.p037c.p038a.C0631b;
import android.support.v7.view.menu.C0662o.C0661a;
import android.support.v7.view.menu.C3268a;
import android.support.v7.view.menu.C3273h;
import android.support.v7.view.menu.C3273h.C0657a;
import android.support.v7.widget.Toolbar.C3300b;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

/* compiled from: ToolbarWidgetWrapper */
public class br implements aj {
    /* renamed from: a */
    Toolbar f8804a;
    /* renamed from: b */
    CharSequence f8805b;
    /* renamed from: c */
    Callback f8806c;
    /* renamed from: d */
    boolean f8807d;
    /* renamed from: e */
    private int f8808e;
    /* renamed from: f */
    private View f8809f;
    /* renamed from: g */
    private View f8810g;
    /* renamed from: h */
    private Drawable f8811h;
    /* renamed from: i */
    private Drawable f8812i;
    /* renamed from: j */
    private Drawable f8813j;
    /* renamed from: k */
    private boolean f8814k;
    /* renamed from: l */
    private CharSequence f8815l;
    /* renamed from: m */
    private CharSequence f8816m;
    /* renamed from: n */
    private C4492d f8817n;
    /* renamed from: o */
    private int f8818o;
    /* renamed from: p */
    private int f8819p;
    /* renamed from: q */
    private Drawable f8820q;

    /* compiled from: ToolbarWidgetWrapper */
    /* renamed from: android.support.v7.widget.br$1 */
    class C07791 implements OnClickListener {
        /* renamed from: a */
        final C3268a f2140a = new C3268a(this.f2141b.f8804a.getContext(), 0, 16908332, 0, 0, this.f2141b.f8805b);
        /* renamed from: b */
        final /* synthetic */ br f2141b;

        C07791(br brVar) {
            this.f2141b = brVar;
        }

        public void onClick(View view) {
            if (this.f2141b.f8806c != null && this.f2141b.f8807d != null) {
                this.f2141b.f8806c.onMenuItemSelected(0, this.f2140a);
            }
        }
    }

    /* renamed from: b */
    public void mo682b(boolean z) {
    }

    public br(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0588h.abc_action_bar_up_description, C0585e.abc_ic_ab_back_material);
    }

    public br(Toolbar toolbar, boolean z, int i, int i2) {
        this.f8818o = 0;
        this.f8819p = 0;
        this.f8804a = toolbar;
        this.f8805b = toolbar.getTitle();
        this.f8815l = toolbar.getSubtitle();
        this.f8814k = this.f8805b != null;
        this.f8813j = toolbar.getNavigationIcon();
        toolbar = bq.m2769a(toolbar.getContext(), null, C0590j.ActionBar, C0581a.actionBarStyle, 0);
        this.f8820q = toolbar.m2773a(C0590j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence c = toolbar.m2779c(C0590j.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                mo681b(c);
            }
            c = toolbar.m2779c(C0590j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c)) {
                m10567c(c);
            }
            Drawable a = toolbar.m2773a(C0590j.ActionBar_logo);
            if (a == true) {
                m10562b(a);
            }
            a = toolbar.m2773a(C0590j.ActionBar_icon);
            if (a == true) {
                mo672a(a);
            }
            if (!this.f8813j && this.f8820q) {
                m10566c(this.f8820q);
            }
            mo683c(toolbar.m2771a(C0590j.ActionBar_displayOptions, 0));
            z = toolbar.m2786g(C0590j.ActionBar_customNavigationLayout, 0);
            if (z) {
                m10556a(LayoutInflater.from(this.f8804a.getContext()).inflate(z, this.f8804a, false));
                mo683c(this.f8808e | 16);
            }
            z = toolbar.m2784f(C0590j.ActionBar_height, 0);
            if (z <= false) {
                LayoutParams layoutParams = this.f8804a.getLayoutParams();
                layoutParams.height = z;
                this.f8804a.setLayoutParams(layoutParams);
            }
            z = toolbar.m2780d(C0590j.ActionBar_contentInsetStart, -1);
            int d = toolbar.m2780d(C0590j.ActionBar_contentInsetEnd, -1);
            if (z < false || d >= 0) {
                this.f8804a.setContentInsetsRelative(Math.max(z, 0), Math.max(d, 0));
            }
            z = toolbar.m2786g(C0590j.ActionBar_titleTextStyle, 0);
            if (z) {
                this.f8804a.setTitleTextAppearance(this.f8804a.getContext(), z);
            }
            z = toolbar.m2786g(C0590j.ActionBar_subtitleTextStyle, 0);
            if (z) {
                this.f8804a.setSubtitleTextAppearance(this.f8804a.getContext(), z);
            }
            z = toolbar.m2786g(C0590j.ActionBar_popupTheme, 0);
            if (z) {
                this.f8804a.setPopupTheme(z);
            }
        } else {
            this.f8808e = m10545r();
        }
        toolbar.m2774a();
        m10573e(i);
        this.f8816m = this.f8804a.getNavigationContentDescription();
        this.f8804a.setNavigationOnClickListener(new C07791(this));
    }

    /* renamed from: e */
    public void m10573e(int i) {
        if (i != this.f8819p) {
            this.f8819p = i;
            if (TextUtils.isEmpty(this.f8804a.getNavigationContentDescription()) != 0) {
                m10575f(this.f8819p);
            }
        }
    }

    /* renamed from: r */
    private int m10545r() {
        if (this.f8804a.getNavigationIcon() == null) {
            return 11;
        }
        this.f8820q = this.f8804a.getNavigationIcon();
        return 15;
    }

    /* renamed from: a */
    public ViewGroup mo670a() {
        return this.f8804a;
    }

    /* renamed from: b */
    public Context mo679b() {
        return this.f8804a.getContext();
    }

    /* renamed from: c */
    public boolean mo684c() {
        return this.f8804a.hasExpandedActionView();
    }

    /* renamed from: d */
    public void mo685d() {
        this.f8804a.collapseActionView();
    }

    /* renamed from: a */
    public void mo676a(Callback callback) {
        this.f8806c = callback;
    }

    /* renamed from: a */
    public void mo677a(CharSequence charSequence) {
        if (!this.f8814k) {
            m10544e(charSequence);
        }
    }

    /* renamed from: e */
    public CharSequence mo687e() {
        return this.f8804a.getTitle();
    }

    /* renamed from: b */
    public void mo681b(CharSequence charSequence) {
        this.f8814k = true;
        m10544e(charSequence);
    }

    /* renamed from: e */
    private void m10544e(CharSequence charSequence) {
        this.f8805b = charSequence;
        if ((this.f8808e & 8) != 0) {
            this.f8804a.setTitle(charSequence);
        }
    }

    /* renamed from: c */
    public void m10567c(CharSequence charSequence) {
        this.f8815l = charSequence;
        if ((this.f8808e & 8) != 0) {
            this.f8804a.setSubtitle(charSequence);
        }
    }

    /* renamed from: f */
    public void mo688f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    /* renamed from: g */
    public void mo689g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    /* renamed from: a */
    public void mo671a(int i) {
        mo672a(i != 0 ? C0631b.m2112b(mo679b(), i) : 0);
    }

    /* renamed from: a */
    public void mo672a(Drawable drawable) {
        this.f8811h = drawable;
        m10546s();
    }

    /* renamed from: b */
    public void mo680b(int i) {
        m10562b(i != 0 ? C0631b.m2112b(mo679b(), i) : 0);
    }

    /* renamed from: b */
    public void m10562b(Drawable drawable) {
        this.f8812i = drawable;
        m10546s();
    }

    /* renamed from: s */
    private void m10546s() {
        Drawable drawable = (this.f8808e & 2) != 0 ? (this.f8808e & 1) != 0 ? this.f8812i != null ? this.f8812i : this.f8811h : this.f8811h : null;
        this.f8804a.setLogo(drawable);
    }

    /* renamed from: h */
    public boolean mo690h() {
        return this.f8804a.canShowOverflowMenu();
    }

    /* renamed from: i */
    public boolean mo691i() {
        return this.f8804a.isOverflowMenuShowing();
    }

    /* renamed from: j */
    public boolean mo692j() {
        return this.f8804a.isOverflowMenuShowPending();
    }

    /* renamed from: k */
    public boolean mo693k() {
        return this.f8804a.showOverflowMenu();
    }

    /* renamed from: l */
    public boolean mo694l() {
        return this.f8804a.hideOverflowMenu();
    }

    /* renamed from: m */
    public void mo695m() {
        this.f8807d = true;
    }

    /* renamed from: a */
    public void mo675a(Menu menu, C0661a c0661a) {
        if (this.f8817n == null) {
            this.f8817n = new C4492d(this.f8804a.getContext());
            this.f8817n.m10014a(C0586f.action_menu_presenter);
        }
        this.f8817n.mo465a(c0661a);
        this.f8804a.setMenu((C3273h) menu, this.f8817n);
    }

    /* renamed from: n */
    public void mo696n() {
        this.f8804a.dismissPopupMenus();
    }

    /* renamed from: o */
    public int mo697o() {
        return this.f8808e;
    }

    /* renamed from: c */
    public void mo683c(int i) {
        int i2 = this.f8808e ^ i;
        this.f8808e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m10548u();
                }
                m10547t();
            }
            if ((i2 & 3) != 0) {
                m10546s();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f8804a.setTitle(this.f8805b);
                    this.f8804a.setSubtitle(this.f8815l);
                } else {
                    this.f8804a.setTitle(null);
                    this.f8804a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.f8810g != null) {
                if ((i & 16) != 0) {
                    this.f8804a.addView(this.f8810g);
                } else {
                    this.f8804a.removeView(this.f8810g);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo674a(bg bgVar) {
        if (this.f8809f != null && this.f8809f.getParent() == this.f8804a) {
            this.f8804a.removeView(this.f8809f);
        }
        this.f8809f = bgVar;
        if (bgVar != null && this.f8818o == 2) {
            this.f8804a.addView(this.f8809f, 0);
            C3300b c3300b = (C3300b) this.f8809f.getLayoutParams();
            c3300b.width = -2;
            c3300b.height = -2;
            c3300b.a = 8388691;
            bgVar.setAllowCollapse(true);
        }
    }

    /* renamed from: a */
    public void mo678a(boolean z) {
        this.f8804a.setCollapsible(z);
    }

    /* renamed from: p */
    public int mo698p() {
        return this.f8818o;
    }

    /* renamed from: a */
    public void m10556a(View view) {
        if (!(this.f8810g == null || (this.f8808e & 16) == 0)) {
            this.f8804a.removeView(this.f8810g);
        }
        this.f8810g = view;
        if (view != null && (this.f8808e & 16) != null) {
            this.f8804a.addView(this.f8810g);
        }
    }

    /* renamed from: a */
    public C0525w mo669a(final int i, long j) {
        return C0517s.m1717k(this.f8804a).m1754a(i == 0 ? 1.0f : 0.0f).m1755a(j).m1756a(new C3232y(this) {
            /* renamed from: b */
            final /* synthetic */ br f12076b;
            /* renamed from: c */
            private boolean f12077c = null;

            /* renamed from: a */
            public void mo326a(View view) {
                this.f12076b.f8804a.setVisibility(0);
            }

            /* renamed from: b */
            public void mo327b(View view) {
                if (this.f12077c == null) {
                    this.f12076b.f8804a.setVisibility(i);
                }
            }

            /* renamed from: c */
            public void mo328c(View view) {
                this.f12077c = true;
            }
        });
    }

    /* renamed from: c */
    public void m10566c(Drawable drawable) {
        this.f8813j = drawable;
        m10547t();
    }

    /* renamed from: t */
    private void m10547t() {
        if ((this.f8808e & 4) != 0) {
            this.f8804a.setNavigationIcon(this.f8813j != null ? this.f8813j : this.f8820q);
        } else {
            this.f8804a.setNavigationIcon(null);
        }
    }

    /* renamed from: d */
    public void m10571d(CharSequence charSequence) {
        this.f8816m = charSequence;
        m10548u();
    }

    /* renamed from: f */
    public void m10575f(int i) {
        m10571d(i == 0 ? 0 : mo679b().getString(i));
    }

    /* renamed from: u */
    private void m10548u() {
        if ((this.f8808e & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f8816m)) {
            this.f8804a.setNavigationContentDescription(this.f8819p);
        } else {
            this.f8804a.setNavigationContentDescription(this.f8816m);
        }
    }

    /* renamed from: d */
    public void mo686d(int i) {
        this.f8804a.setVisibility(i);
    }

    /* renamed from: a */
    public void mo673a(C0661a c0661a, C0657a c0657a) {
        this.f8804a.setMenuCallbacks(c0661a, c0657a);
    }

    /* renamed from: q */
    public Menu mo699q() {
        return this.f8804a.getMenu();
    }
}
