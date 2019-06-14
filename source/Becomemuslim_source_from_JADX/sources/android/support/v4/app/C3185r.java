package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.C0513q;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: FragmentPagerAdapter */
/* renamed from: android.support.v4.app.r */
public abstract class C3185r extends C0513q {
    /* renamed from: a */
    private final C0309n f8223a;
    /* renamed from: b */
    private C0326t f8224b = null;
    /* renamed from: c */
    private C3178i f8225c = null;

    /* renamed from: a */
    public abstract C3178i m9625a(int i);

    /* renamed from: b */
    public long m9626b(int i) {
        return (long) i;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public C3185r(C0309n c0309n) {
        this.f8223a = c0309n;
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ViewPager with adapter ");
            stringBuilder.append(this);
            stringBuilder.append(" requires a view id");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.f8224b == null) {
            this.f8224b = this.f8223a.mo201a();
        }
        long b = m9626b(i);
        C3178i a = this.f8223a.mo200a(C3185r.m9624a(viewGroup.getId(), b));
        if (a != null) {
            this.f8224b.mo190c(a);
        } else {
            a = m9625a(i);
            this.f8224b.mo183a(viewGroup.getId(), a, C3185r.m9624a(viewGroup.getId(), b));
        }
        if (a != this.f8225c) {
            a.setMenuVisibility(false);
            a.setUserVisibleHint(false);
        }
        return a;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.f8224b == null) {
            this.f8224b = this.f8223a.mo201a();
        }
        this.f8224b.mo188b((C3178i) obj);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        C3178i c3178i = (C3178i) obj;
        if (c3178i != this.f8225c) {
            if (this.f8225c != null) {
                this.f8225c.setMenuVisibility(false);
                this.f8225c.setUserVisibleHint(false);
            }
            if (c3178i != null) {
                c3178i.setMenuVisibility(true);
                c3178i.setUserVisibleHint(true);
            }
            this.f8225c = c3178i;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        if (this.f8224b != null) {
            this.f8224b.mo193f();
            this.f8224b = null;
        }
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((C3178i) obj).getView() == view ? true : null;
    }

    /* renamed from: a */
    private static String m9624a(int i, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("android:switcher:");
        stringBuilder.append(i);
        stringBuilder.append(":");
        stringBuilder.append(j);
        return stringBuilder.toString();
    }
}
