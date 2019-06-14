package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.C0662o.C0661a;
import android.support.v7.view.menu.C0664p.C0663a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: BaseMenuPresenter */
/* renamed from: android.support.v7.view.menu.b */
public abstract class C3269b implements C0662o {
    /* renamed from: a */
    protected Context f8461a;
    /* renamed from: b */
    protected Context f8462b;
    /* renamed from: c */
    protected C3273h f8463c;
    /* renamed from: d */
    protected LayoutInflater f8464d;
    /* renamed from: e */
    protected LayoutInflater f8465e;
    /* renamed from: f */
    protected C0664p f8466f;
    /* renamed from: g */
    private C0661a f8467g;
    /* renamed from: h */
    private int f8468h;
    /* renamed from: i */
    private int f8469i;
    /* renamed from: j */
    private int f8470j;

    /* renamed from: a */
    public abstract void mo2782a(C3276j c3276j, C0663a c0663a);

    /* renamed from: a */
    public boolean mo2784a(int i, C3276j c3276j) {
        return true;
    }

    /* renamed from: a */
    public boolean mo466a(C3273h c3273h, C3276j c3276j) {
        return false;
    }

    /* renamed from: b */
    public boolean mo469b() {
        return false;
    }

    /* renamed from: b */
    public boolean mo470b(C3273h c3273h, C3276j c3276j) {
        return false;
    }

    public C3269b(Context context, int i, int i2) {
        this.f8461a = context;
        this.f8464d = LayoutInflater.from(context);
        this.f8468h = i;
        this.f8469i = i2;
    }

    /* renamed from: a */
    public void mo463a(Context context, C3273h c3273h) {
        this.f8462b = context;
        this.f8465e = LayoutInflater.from(this.f8462b);
        this.f8463c = c3273h;
    }

    /* renamed from: a */
    public C0664p mo2780a(ViewGroup viewGroup) {
        if (this.f8466f == null) {
            this.f8466f = (C0664p) this.f8464d.inflate(this.f8468h, viewGroup, false);
            this.f8466f.mo435a(this.f8463c);
            mo468b(true);
        }
        return this.f8466f;
    }

    /* renamed from: b */
    public void mo468b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f8466f;
        if (viewGroup != null) {
            int i = 0;
            if (this.f8463c != null) {
                this.f8463c.m10091j();
                ArrayList i2 = this.f8463c.m10090i();
                int size = i2.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    C3276j c3276j = (C3276j) i2.get(i4);
                    if (mo2784a(i3, c3276j)) {
                        View childAt = viewGroup.getChildAt(i3);
                        C3276j itemData = childAt instanceof C0663a ? ((C0663a) childAt).getItemData() : null;
                        View a = mo2781a(c3276j, childAt, viewGroup);
                        if (c3276j != itemData) {
                            a.setPressed(false);
                            a.jumpDrawablesToCurrentState();
                        }
                        if (a != childAt) {
                            m10019a(a, i3);
                        }
                        i3++;
                    }
                }
                i = i3;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo2785a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    protected void m10019a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f8466f).addView(view, i);
    }

    /* renamed from: a */
    protected boolean mo2785a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    /* renamed from: a */
    public void mo465a(C0661a c0661a) {
        this.f8467g = c0661a;
    }

    /* renamed from: a */
    public C0661a m10011a() {
        return this.f8467g;
    }

    /* renamed from: b */
    public C0663a m10024b(ViewGroup viewGroup) {
        return (C0663a) this.f8464d.inflate(this.f8469i, viewGroup, false);
    }

    /* renamed from: a */
    public View mo2781a(C3276j c3276j, View view, ViewGroup viewGroup) {
        C0663a c0663a;
        if (view instanceof C0663a) {
            c0663a = (C0663a) view;
        } else {
            c0663a = m10024b(viewGroup);
        }
        mo2782a(c3276j, c0663a);
        return (View) c0663a;
    }

    /* renamed from: a */
    public void mo464a(C3273h c3273h, boolean z) {
        if (this.f8467g != null) {
            this.f8467g.mo378a(c3273h, z);
        }
    }

    /* renamed from: a */
    public boolean mo467a(C4487u c4487u) {
        return this.f8467g != null ? this.f8467g.mo379a(c4487u) : null;
    }

    /* renamed from: a */
    public void m10014a(int i) {
        this.f8470j = i;
    }
}
