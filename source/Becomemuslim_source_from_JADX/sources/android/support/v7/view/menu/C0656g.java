package android.support.v7.view.menu;

import android.support.v7.p035a.C0591a.C0587g;
import android.support.v7.view.menu.C0664p.C0663a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* compiled from: MenuAdapter */
/* renamed from: android.support.v7.view.menu.g */
public class C0656g extends BaseAdapter {
    /* renamed from: a */
    static final int f1692a = C0587g.abc_popup_menu_item_layout;
    /* renamed from: b */
    C3273h f1693b;
    /* renamed from: c */
    private int f1694c = -1;
    /* renamed from: d */
    private boolean f1695d;
    /* renamed from: e */
    private final boolean f1696e;
    /* renamed from: f */
    private final LayoutInflater f1697f;

    public long getItemId(int i) {
        return (long) i;
    }

    public /* synthetic */ Object getItem(int i) {
        return m2181a(i);
    }

    public C0656g(C3273h c3273h, LayoutInflater layoutInflater, boolean z) {
        this.f1696e = z;
        this.f1697f = layoutInflater;
        this.f1693b = c3273h;
        m2183b();
    }

    /* renamed from: a */
    public void m2182a(boolean z) {
        this.f1695d = z;
    }

    public int getCount() {
        ArrayList l = this.f1696e ? this.f1693b.m10093l() : this.f1693b.m10090i();
        if (this.f1694c < 0) {
            return l.size();
        }
        return l.size() - 1;
    }

    /* renamed from: a */
    public C3273h m2180a() {
        return this.f1693b;
    }

    /* renamed from: a */
    public C3276j m2181a(int i) {
        ArrayList l = this.f1696e ? this.f1693b.m10093l() : this.f1693b.m10090i();
        if (this.f1694c >= 0 && i >= this.f1694c) {
            i++;
        }
        return (C3276j) l.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1697f.inflate(f1692a, viewGroup, false);
        }
        C0663a c0663a = (C0663a) view;
        if (this.f1695d) {
            ((ListMenuItemView) view).setForceShowIcon(true);
        }
        c0663a.mo437a(m2181a(i), 0);
        return view;
    }

    /* renamed from: b */
    void m2183b() {
        C3276j r = this.f1693b.m10099r();
        if (r != null) {
            ArrayList l = this.f1693b.m10093l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((C3276j) l.get(i)) == r) {
                    this.f1694c = i;
                    return;
                }
            }
        }
        this.f1694c = -1;
    }

    public void notifyDataSetChanged() {
        m2183b();
        super.notifyDataSetChanged();
    }
}
