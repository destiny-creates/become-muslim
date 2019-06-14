package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.p035a.C0591a.C0587g;
import android.support.v7.view.menu.C0662o.C0661a;
import android.support.v7.view.menu.C0664p.C0663a;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* compiled from: ListMenuPresenter */
/* renamed from: android.support.v7.view.menu.f */
public class C3272f implements C0662o, OnItemClickListener {
    /* renamed from: a */
    Context f8475a;
    /* renamed from: b */
    LayoutInflater f8476b;
    /* renamed from: c */
    C3273h f8477c;
    /* renamed from: d */
    ExpandedMenuView f8478d;
    /* renamed from: e */
    int f8479e;
    /* renamed from: f */
    int f8480f;
    /* renamed from: g */
    int f8481g;
    /* renamed from: h */
    C0655a f8482h;
    /* renamed from: i */
    private C0661a f8483i;

    /* compiled from: ListMenuPresenter */
    /* renamed from: android.support.v7.view.menu.f$a */
    private class C0655a extends BaseAdapter {
        /* renamed from: a */
        final /* synthetic */ C3272f f1690a;
        /* renamed from: b */
        private int f1691b = -1;

        public long getItemId(int i) {
            return (long) i;
        }

        public /* synthetic */ Object getItem(int i) {
            return m2178a(i);
        }

        public C0655a(C3272f c3272f) {
            this.f1690a = c3272f;
            m2179a();
        }

        public int getCount() {
            int size = this.f1690a.f8477c.m10093l().size() - this.f1690a.f8479e;
            return this.f1691b < 0 ? size : size - 1;
        }

        /* renamed from: a */
        public C3276j m2178a(int i) {
            ArrayList l = this.f1690a.f8477c.m10093l();
            i += this.f1690a.f8479e;
            if (this.f1691b >= 0 && i >= this.f1691b) {
                i++;
            }
            return (C3276j) l.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f1690a.f8476b.inflate(this.f1690a.f8481g, viewGroup, false);
            }
            ((C0663a) view).mo437a(m2178a(i), 0);
            return view;
        }

        /* renamed from: a */
        void m2179a() {
            C3276j r = this.f1690a.f8477c.m10099r();
            if (r != null) {
                ArrayList l = this.f1690a.f8477c.m10093l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (((C3276j) l.get(i)) == r) {
                        this.f1691b = i;
                        return;
                    }
                }
            }
            this.f1691b = -1;
        }

        public void notifyDataSetChanged() {
            m2179a();
            super.notifyDataSetChanged();
        }
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

    public C3272f(Context context, int i) {
        this(i, 0);
        this.f8475a = context;
        this.f8476b = LayoutInflater.from(this.f8475a);
    }

    public C3272f(int i, int i2) {
        this.f8481g = i;
        this.f8480f = i2;
    }

    /* renamed from: a */
    public void mo463a(Context context, C3273h c3273h) {
        if (this.f8480f != 0) {
            this.f8475a = new ContextThemeWrapper(context, this.f8480f);
            this.f8476b = LayoutInflater.from(this.f8475a);
        } else if (this.f8475a != null) {
            this.f8475a = context;
            if (this.f8476b == null) {
                this.f8476b = LayoutInflater.from(this.f8475a);
            }
        }
        this.f8477c = c3273h;
        if (this.f8482h != null) {
            this.f8482h.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public C0664p m10035a(ViewGroup viewGroup) {
        if (this.f8478d == null) {
            this.f8478d = (ExpandedMenuView) this.f8476b.inflate(C0587g.abc_expanded_menu_layout, viewGroup, false);
            if (this.f8482h == null) {
                this.f8482h = new C0655a(this);
            }
            this.f8478d.setAdapter(this.f8482h);
            this.f8478d.setOnItemClickListener(this);
        }
        return this.f8478d;
    }

    /* renamed from: a */
    public ListAdapter m10036a() {
        if (this.f8482h == null) {
            this.f8482h = new C0655a(this);
        }
        return this.f8482h;
    }

    /* renamed from: b */
    public void mo468b(boolean z) {
        if (this.f8482h) {
            this.f8482h.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void mo465a(C0661a c0661a) {
        this.f8483i = c0661a;
    }

    /* renamed from: a */
    public boolean mo467a(C4487u c4487u) {
        if (!c4487u.hasVisibleItems()) {
            return null;
        }
        new C3274i(c4487u).m10101a(null);
        if (this.f8483i != null) {
            this.f8483i.mo379a(c4487u);
        }
        return true;
    }

    /* renamed from: a */
    public void mo464a(C3273h c3273h, boolean z) {
        if (this.f8483i != null) {
            this.f8483i.mo378a(c3273h, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f8477c.m10071a(this.f8482h.m2178a(i), (C0662o) this, 0);
    }
}
