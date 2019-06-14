package android.support.v7.view;

import android.content.Context;
import android.support.v4.p024c.p025a.C0350a;
import android.support.v4.p024c.p025a.C0351b;
import android.support.v4.util.C0463l;
import android.support.v7.view.C0640b.C0639a;
import android.support.v7.view.menu.C0665q;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

/* compiled from: SupportActionModeWrapper */
/* renamed from: android.support.v7.view.f */
public class C0643f extends ActionMode {
    /* renamed from: a */
    final Context f1630a;
    /* renamed from: b */
    final C0640b f1631b;

    /* compiled from: SupportActionModeWrapper */
    /* renamed from: android.support.v7.view.f$a */
    public static class C3266a implements C0639a {
        /* renamed from: a */
        final Callback f8416a;
        /* renamed from: b */
        final Context f8417b;
        /* renamed from: c */
        final ArrayList<C0643f> f8418c = new ArrayList();
        /* renamed from: d */
        final C0463l<Menu, Menu> f8419d = new C0463l();

        public C3266a(Context context, Callback callback) {
            this.f8417b = context;
            this.f8416a = callback;
        }

        /* renamed from: a */
        public boolean mo381a(C0640b c0640b, Menu menu) {
            return this.f8416a.onCreateActionMode(m9991b(c0640b), m9987a(menu));
        }

        /* renamed from: b */
        public boolean mo383b(C0640b c0640b, Menu menu) {
            return this.f8416a.onPrepareActionMode(m9991b(c0640b), m9987a(menu));
        }

        /* renamed from: a */
        public boolean mo382a(C0640b c0640b, MenuItem menuItem) {
            return this.f8416a.onActionItemClicked(m9991b(c0640b), C0665q.m2215a(this.f8417b, (C0351b) menuItem));
        }

        /* renamed from: a */
        public void mo380a(C0640b c0640b) {
            this.f8416a.onDestroyActionMode(m9991b(c0640b));
        }

        /* renamed from: a */
        private Menu m9987a(Menu menu) {
            Menu menu2 = (Menu) this.f8419d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = C0665q.m2214a(this.f8417b, (C0350a) menu);
            this.f8419d.put(menu, menu2);
            return menu2;
        }

        /* renamed from: b */
        public ActionMode m9991b(C0640b c0640b) {
            int size = this.f8418c.size();
            for (int i = 0; i < size; i++) {
                C0643f c0643f = (C0643f) this.f8418c.get(i);
                if (c0643f != null && c0643f.f1631b == c0640b) {
                    return c0643f;
                }
            }
            ActionMode c0643f2 = new C0643f(this.f8417b, c0640b);
            this.f8418c.add(c0643f2);
            return c0643f2;
        }
    }

    public C0643f(Context context, C0640b c0640b) {
        this.f1630a = context;
        this.f1631b = c0640b;
    }

    public Object getTag() {
        return this.f1631b.m2148j();
    }

    public void setTag(Object obj) {
        this.f1631b.m2137a(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1631b.mo418b(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1631b.mo414a(charSequence);
    }

    public void invalidate() {
        this.f1631b.mo420d();
    }

    public void finish() {
        this.f1631b.mo419c();
    }

    public Menu getMenu() {
        return C0665q.m2214a(this.f1630a, (C0350a) this.f1631b.mo416b());
    }

    public CharSequence getTitle() {
        return this.f1631b.mo421f();
    }

    public void setTitle(int i) {
        this.f1631b.mo412a(i);
    }

    public CharSequence getSubtitle() {
        return this.f1631b.mo422g();
    }

    public void setSubtitle(int i) {
        this.f1631b.mo417b(i);
    }

    public View getCustomView() {
        return this.f1631b.mo424i();
    }

    public void setCustomView(View view) {
        this.f1631b.mo413a(view);
    }

    public MenuInflater getMenuInflater() {
        return this.f1631b.mo411a();
    }

    public boolean getTitleOptionalHint() {
        return this.f1631b.m2149k();
    }

    public void setTitleOptionalHint(boolean z) {
        this.f1631b.mo415a(z);
    }

    public boolean isTitleOptional() {
        return this.f1631b.mo423h();
    }
}
