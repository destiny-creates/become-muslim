package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.C0517s;
import android.support.v7.widget.RecyclerView.C0718x;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DefaultItemAnimator */
public class ak extends bh {
    /* renamed from: i */
    private static TimeInterpolator f12057i;
    /* renamed from: a */
    ArrayList<ArrayList<C0718x>> f12058a = new ArrayList();
    /* renamed from: b */
    ArrayList<ArrayList<C0751b>> f12059b = new ArrayList();
    /* renamed from: c */
    ArrayList<ArrayList<C0750a>> f12060c = new ArrayList();
    /* renamed from: d */
    ArrayList<C0718x> f12061d = new ArrayList();
    /* renamed from: e */
    ArrayList<C0718x> f12062e = new ArrayList();
    /* renamed from: f */
    ArrayList<C0718x> f12063f = new ArrayList();
    /* renamed from: g */
    ArrayList<C0718x> f12064g = new ArrayList();
    /* renamed from: j */
    private ArrayList<C0718x> f12065j = new ArrayList();
    /* renamed from: k */
    private ArrayList<C0718x> f12066k = new ArrayList();
    /* renamed from: l */
    private ArrayList<C0751b> f12067l = new ArrayList();
    /* renamed from: m */
    private ArrayList<C0750a> f12068m = new ArrayList();

    /* compiled from: DefaultItemAnimator */
    /* renamed from: android.support.v7.widget.ak$a */
    private static class C0750a {
        /* renamed from: a */
        public C0718x f1964a;
        /* renamed from: b */
        public C0718x f1965b;
        /* renamed from: c */
        public int f1966c;
        /* renamed from: d */
        public int f1967d;
        /* renamed from: e */
        public int f1968e;
        /* renamed from: f */
        public int f1969f;

        private C0750a(C0718x c0718x, C0718x c0718x2) {
            this.f1964a = c0718x;
            this.f1965b = c0718x2;
        }

        C0750a(C0718x c0718x, C0718x c0718x2, int i, int i2, int i3, int i4) {
            this(c0718x, c0718x2);
            this.f1966c = i;
            this.f1967d = i2;
            this.f1968e = i3;
            this.f1969f = i4;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ChangeInfo{oldHolder=");
            stringBuilder.append(this.f1964a);
            stringBuilder.append(", newHolder=");
            stringBuilder.append(this.f1965b);
            stringBuilder.append(", fromX=");
            stringBuilder.append(this.f1966c);
            stringBuilder.append(", fromY=");
            stringBuilder.append(this.f1967d);
            stringBuilder.append(", toX=");
            stringBuilder.append(this.f1968e);
            stringBuilder.append(", toY=");
            stringBuilder.append(this.f1969f);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    /* compiled from: DefaultItemAnimator */
    /* renamed from: android.support.v7.widget.ak$b */
    private static class C0751b {
        /* renamed from: a */
        public C0718x f1970a;
        /* renamed from: b */
        public int f1971b;
        /* renamed from: c */
        public int f1972c;
        /* renamed from: d */
        public int f1973d;
        /* renamed from: e */
        public int f1974e;

        C0751b(C0718x c0718x, int i, int i2, int i3, int i4) {
            this.f1970a = c0718x;
            this.f1971b = i;
            this.f1972c = i2;
            this.f1973d = i3;
            this.f1974e = i4;
        }
    }

    /* renamed from: a */
    public void mo2763a() {
        int isEmpty = this.f12065j.isEmpty() ^ 1;
        int isEmpty2 = this.f12067l.isEmpty() ^ 1;
        int isEmpty3 = this.f12068m.isEmpty() ^ 1;
        int isEmpty4 = this.f12066k.isEmpty() ^ 1;
        if (isEmpty != 0 || isEmpty2 != 0 || isEmpty4 != 0 || isEmpty3 != 0) {
            final ArrayList arrayList;
            Runnable c07421;
            Iterator it = this.f12065j.iterator();
            while (it.hasNext()) {
                m15151u((C0718x) it.next());
            }
            this.f12065j.clear();
            if (isEmpty2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f12067l);
                this.f12059b.add(arrayList);
                this.f12067l.clear();
                c07421 = new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ ak f1937b;

                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            C0751b c0751b = (C0751b) it.next();
                            this.f1937b.m15160b(c0751b.f1970a, c0751b.f1971b, c0751b.f1972c, c0751b.f1973d, c0751b.f1974e);
                        }
                        arrayList.clear();
                        this.f1937b.f12059b.remove(arrayList);
                    }
                };
                if (isEmpty != 0) {
                    C0517s.m1698a(((C0751b) arrayList.get(0)).f1970a.itemView, c07421, m2312g());
                } else {
                    c07421.run();
                }
            }
            if (isEmpty3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f12068m);
                this.f12060c.add(arrayList);
                this.f12068m.clear();
                c07421 = new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ ak f1939b;

                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            this.f1939b.m15154a((C0750a) it.next());
                        }
                        arrayList.clear();
                        this.f1939b.f12060c.remove(arrayList);
                    }
                };
                if (isEmpty != 0) {
                    C0517s.m1698a(((C0750a) arrayList.get(0)).f1964a.itemView, c07421, m2312g());
                } else {
                    c07421.run();
                }
            }
            if (isEmpty4 != 0) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f12066k);
                this.f12058a.add(arrayList2);
                this.f12066k.clear();
                Runnable c07443 = new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ ak f1941b;

                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            this.f1941b.m15164c((C0718x) it.next());
                        }
                        arrayList2.clear();
                        this.f1941b.f12058a.remove(arrayList2);
                    }
                };
                if (isEmpty == 0 && isEmpty2 == 0) {
                    if (isEmpty3 == 0) {
                        c07443.run();
                    }
                }
                long j = 0;
                long g = isEmpty != 0 ? m2312g() : 0;
                long e = isEmpty2 != 0 ? m2309e() : 0;
                if (isEmpty3 != 0) {
                    j = m2314h();
                }
                C0517s.m1698a(((C0718x) arrayList2.get(0)).itemView, c07443, g + Math.max(e, j));
            }
        }
    }

    /* renamed from: a */
    public boolean mo2764a(C0718x c0718x) {
        m15152v(c0718x);
        this.f12065j.add(c0718x);
        return true;
    }

    /* renamed from: u */
    private void m15151u(final C0718x c0718x) {
        final View view = c0718x.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f12063f.add(c0718x);
        animate.setDuration(m2312g()).alpha(0.0f).setListener(new AnimatorListenerAdapter(this) {
            /* renamed from: d */
            final /* synthetic */ ak f1945d;

            public void onAnimationStart(Animator animator) {
                this.f1945d.m10524l(c0718x);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                view.setAlpha(1.0f);
                this.f1945d.m10521i(c0718x);
                this.f1945d.f12063f.remove(c0718x);
                this.f1945d.m15163c();
            }
        }).start();
    }

    /* renamed from: b */
    public boolean mo2769b(C0718x c0718x) {
        m15152v(c0718x);
        c0718x.itemView.setAlpha(0.0f);
        this.f12066k.add(c0718x);
        return true;
    }

    /* renamed from: c */
    void m15164c(final C0718x c0718x) {
        final View view = c0718x.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f12061d.add(c0718x);
        animate.alpha(1.0f).setDuration(m2310f()).setListener(new AnimatorListenerAdapter(this) {
            /* renamed from: d */
            final /* synthetic */ ak f1949d;

            public void onAnimationStart(Animator animator) {
                this.f1949d.m10526n(c0718x);
            }

            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                this.f1949d.m10523k(c0718x);
                this.f1949d.f12061d.remove(c0718x);
                this.f1949d.m15163c();
            }
        }).start();
    }

    /* renamed from: a */
    public boolean mo2765a(C0718x c0718x, int i, int i2, int i3, int i4) {
        View view = c0718x.itemView;
        int translationX = i + ((int) c0718x.itemView.getTranslationX());
        int translationY = i2 + ((int) c0718x.itemView.getTranslationY());
        m15152v(c0718x);
        i = i3 - translationX;
        i2 = i4 - translationY;
        if (i == 0 && i2 == 0) {
            m10522j(c0718x);
            return null;
        }
        if (i != 0) {
            view.setTranslationX((float) (-i));
        }
        if (i2 != 0) {
            view.setTranslationY((float) (-i2));
        }
        this.f12067l.add(new C0751b(c0718x, translationX, translationY, i3, i4));
        return true;
    }

    /* renamed from: b */
    void m15160b(C0718x c0718x, int i, int i2, int i3, int i4) {
        final View view = c0718x.itemView;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.f12062e.add(c0718x);
        final C0718x c0718x2 = c0718x;
        animate.setDuration(m2309e()).setListener(new AnimatorListenerAdapter(this) {
            /* renamed from: f */
            final /* synthetic */ ak f1955f;

            public void onAnimationStart(Animator animator) {
                this.f1955f.m10525m(c0718x2);
            }

            public void onAnimationCancel(Animator animator) {
                if (i5 != null) {
                    view.setTranslationX(0.0f);
                }
                if (i6 != null) {
                    view.setTranslationY(0.0f);
                }
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                this.f1955f.m10522j(c0718x2);
                this.f1955f.f12062e.remove(c0718x2);
                this.f1955f.m15163c();
            }
        }).start();
    }

    /* renamed from: a */
    public boolean mo2766a(C0718x c0718x, C0718x c0718x2, int i, int i2, int i3, int i4) {
        if (c0718x == c0718x2) {
            return mo2765a(c0718x, i, i2, i3, i4);
        }
        float translationX = c0718x.itemView.getTranslationX();
        float translationY = c0718x.itemView.getTranslationY();
        float alpha = c0718x.itemView.getAlpha();
        m15152v(c0718x);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        c0718x.itemView.setTranslationX(translationX);
        c0718x.itemView.setTranslationY(translationY);
        c0718x.itemView.setAlpha(alpha);
        if (c0718x2 != null) {
            m15152v(c0718x2);
            c0718x2.itemView.setTranslationX((float) (-i5));
            c0718x2.itemView.setTranslationY((float) (-i6));
            c0718x2.itemView.setAlpha(0.0f);
        }
        this.f12068m.add(new C0750a(c0718x, c0718x2, i, i2, i3, i4));
        return true;
    }

    /* renamed from: a */
    void m15154a(final C0750a c0750a) {
        View view;
        C0718x c0718x = c0750a.f1964a;
        View view2 = null;
        if (c0718x == null) {
            view = null;
        } else {
            view = c0718x.itemView;
        }
        C0718x c0718x2 = c0750a.f1965b;
        if (c0718x2 != null) {
            view2 = c0718x2.itemView;
        }
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(m2314h());
            this.f12064g.add(c0750a.f1964a);
            duration.translationX((float) (c0750a.f1968e - c0750a.f1966c));
            duration.translationY((float) (c0750a.f1969f - c0750a.f1967d));
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter(this) {
                /* renamed from: d */
                final /* synthetic */ ak f1959d;

                public void onAnimationStart(Animator animator) {
                    this.f1959d.m10514b(c0750a.f1964a, true);
                }

                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    this.f1959d.m10508a(c0750a.f1964a, true);
                    this.f1959d.f12064g.remove(c0750a.f1964a);
                    this.f1959d.m15163c();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator animate = view2.animate();
            this.f12064g.add(c0750a.f1965b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(m2314h()).alpha(1.0f).setListener(new AnimatorListenerAdapter(this) {
                /* renamed from: d */
                final /* synthetic */ ak f1963d;

                public void onAnimationStart(Animator animator) {
                    this.f1963d.m10514b(c0750a.f1965b, false);
                }

                public void onAnimationEnd(Animator animator) {
                    animate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    this.f1963d.m10508a(c0750a.f1965b, false);
                    this.f1963d.f12064g.remove(c0750a.f1965b);
                    this.f1963d.m15163c();
                }
            }).start();
        }
    }

    /* renamed from: a */
    private void m15148a(List<C0750a> list, C0718x c0718x) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0750a c0750a = (C0750a) list.get(size);
            if (m15149a(c0750a, c0718x) && c0750a.f1964a == null && c0750a.f1965b == null) {
                list.remove(c0750a);
            }
        }
    }

    /* renamed from: b */
    private void m15150b(C0750a c0750a) {
        if (c0750a.f1964a != null) {
            m15149a(c0750a, c0750a.f1964a);
        }
        if (c0750a.f1965b != null) {
            m15149a(c0750a, c0750a.f1965b);
        }
    }

    /* renamed from: a */
    private boolean m15149a(C0750a c0750a, C0718x c0718x) {
        boolean z = false;
        if (c0750a.f1965b == c0718x) {
            c0750a.f1965b = null;
        } else if (c0750a.f1964a != c0718x) {
            return false;
        } else {
            c0750a.f1964a = null;
            z = true;
        }
        c0718x.itemView.setAlpha(1.0f);
        c0718x.itemView.setTranslationX(0.0f);
        c0718x.itemView.setTranslationY(0.0f);
        m10508a(c0718x, z);
        return true;
    }

    /* renamed from: d */
    public void mo2771d(C0718x c0718x) {
        int size;
        View view = c0718x.itemView;
        view.animate().cancel();
        for (size = this.f12067l.size() - 1; size >= 0; size--) {
            if (((C0751b) this.f12067l.get(size)).f1970a == c0718x) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                m10522j(c0718x);
                this.f12067l.remove(size);
            }
        }
        m15148a(this.f12068m, c0718x);
        if (this.f12065j.remove(c0718x)) {
            view.setAlpha(1.0f);
            m10521i(c0718x);
        }
        if (this.f12066k.remove(c0718x)) {
            view.setAlpha(1.0f);
            m10523k(c0718x);
        }
        for (size = this.f12060c.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.f12060c.get(size);
            m15148a(list, c0718x);
            if (list.isEmpty()) {
                this.f12060c.remove(size);
            }
        }
        for (size = this.f12059b.size() - 1; size >= 0; size--) {
            ArrayList arrayList = (ArrayList) this.f12059b.get(size);
            int size2 = arrayList.size() - 1;
            while (size2 >= 0) {
                if (((C0751b) arrayList.get(size2)).f1970a == c0718x) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    m10522j(c0718x);
                    arrayList.remove(size2);
                    if (arrayList.isEmpty()) {
                        this.f12059b.remove(size);
                    }
                } else {
                    size2--;
                }
            }
        }
        for (size = this.f12058a.size() - 1; size >= 0; size--) {
            ArrayList arrayList2 = (ArrayList) this.f12058a.get(size);
            if (arrayList2.remove(c0718x)) {
                view.setAlpha(1.0f);
                m10523k(c0718x);
                if (arrayList2.isEmpty()) {
                    this.f12058a.remove(size);
                }
            }
        }
        this.f12063f.remove(c0718x);
        this.f12061d.remove(c0718x);
        this.f12064g.remove(c0718x);
        this.f12062e.remove(c0718x);
        m15163c();
    }

    /* renamed from: v */
    private void m15152v(C0718x c0718x) {
        if (f12057i == null) {
            f12057i = new ValueAnimator().getInterpolator();
        }
        c0718x.itemView.animate().setInterpolator(f12057i);
        mo2771d(c0718x);
    }

    /* renamed from: b */
    public boolean mo2768b() {
        if (this.f12066k.isEmpty() && this.f12068m.isEmpty() && this.f12067l.isEmpty() && this.f12065j.isEmpty() && this.f12062e.isEmpty() && this.f12063f.isEmpty() && this.f12061d.isEmpty() && this.f12064g.isEmpty() && this.f12059b.isEmpty() && this.f12058a.isEmpty()) {
            if (this.f12060c.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    void m15163c() {
        if (!mo2768b()) {
            m2316i();
        }
    }

    /* renamed from: d */
    public void mo2770d() {
        int size;
        for (size = this.f12067l.size() - 1; size >= 0; size--) {
            C0751b c0751b = (C0751b) this.f12067l.get(size);
            View view = c0751b.f1970a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            m10522j(c0751b.f1970a);
            this.f12067l.remove(size);
        }
        for (size = this.f12065j.size() - 1; size >= 0; size--) {
            m10521i((C0718x) this.f12065j.get(size));
            this.f12065j.remove(size);
        }
        for (size = this.f12066k.size() - 1; size >= 0; size--) {
            C0718x c0718x = (C0718x) this.f12066k.get(size);
            c0718x.itemView.setAlpha(1.0f);
            m10523k(c0718x);
            this.f12066k.remove(size);
        }
        for (size = this.f12068m.size() - 1; size >= 0; size--) {
            m15150b((C0750a) this.f12068m.get(size));
        }
        this.f12068m.clear();
        if (mo2768b()) {
            ArrayList arrayList;
            for (size = this.f12059b.size() - 1; size >= 0; size--) {
                ArrayList arrayList2 = (ArrayList) this.f12059b.get(size);
                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                    C0751b c0751b2 = (C0751b) arrayList2.get(size2);
                    View view2 = c0751b2.f1970a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    m10522j(c0751b2.f1970a);
                    arrayList2.remove(size2);
                    if (arrayList2.isEmpty()) {
                        this.f12059b.remove(arrayList2);
                    }
                }
            }
            for (size = this.f12058a.size() - 1; size >= 0; size--) {
                arrayList = (ArrayList) this.f12058a.get(size);
                for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C0718x c0718x2 = (C0718x) arrayList.get(size3);
                    c0718x2.itemView.setAlpha(1.0f);
                    m10523k(c0718x2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f12058a.remove(arrayList);
                    }
                }
            }
            for (size = this.f12060c.size() - 1; size >= 0; size--) {
                arrayList = (ArrayList) this.f12060c.get(size);
                for (int size4 = arrayList.size() - 1; size4 >= 0; size4--) {
                    m15150b((C0750a) arrayList.get(size4));
                    if (arrayList.isEmpty()) {
                        this.f12060c.remove(arrayList);
                    }
                }
            }
            m15155a(this.f12063f);
            m15155a(this.f12062e);
            m15155a(this.f12061d);
            m15155a(this.f12064g);
            m2316i();
        }
    }

    /* renamed from: a */
    void m15155a(List<C0718x> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((C0718x) list.get(size)).itemView.animate().cancel();
        }
    }

    /* renamed from: a */
    public boolean mo2767a(C0718x c0718x, List<Object> list) {
        if (list.isEmpty()) {
            if (super.mo2767a(c0718x, (List) list) == null) {
                return null;
            }
        }
        return true;
    }
}
