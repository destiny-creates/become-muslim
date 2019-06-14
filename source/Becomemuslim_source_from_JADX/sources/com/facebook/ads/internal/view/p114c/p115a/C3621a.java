package com.facebook.ads.internal.view.p114c.p115a;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0706n;
import android.support.v7.widget.RecyclerView.C0714t;
import android.support.v7.widget.at;
import android.view.View;
import com.facebook.ads.internal.p111r.C1545a;
import com.facebook.ads.internal.view.component.p116a.p117a.C3630b;
import com.facebook.ads.internal.view.component.p116a.p117a.C3630b.C1589c;
import com.facebook.ads.internal.view.component.p116a.p117a.C3630b.C1590d;
import com.facebook.ads.internal.view.component.p116a.p117a.C3630b.C1591e;
import com.facebook.ads.internal.view.p114c.p115a.C3622d.C1581a;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.facebook.ads.internal.view.c.a.a */
public class C3621a extends C0706n {
    /* renamed from: a */
    private final LinearLayoutManager f9662a;
    /* renamed from: b */
    private final int f9663b;
    /* renamed from: c */
    private final C0714t f9664c;
    /* renamed from: d */
    private final Set<Integer> f9665d = new HashSet();
    /* renamed from: e */
    private List<C1580b> f9666e;
    /* renamed from: f */
    private final C1545a f9667f;
    /* renamed from: g */
    private boolean f9668g = true;
    /* renamed from: h */
    private C1581a f9669h;
    /* renamed from: i */
    private boolean f9670i = true;
    /* renamed from: j */
    private boolean f9671j = true;
    /* renamed from: k */
    private boolean f9672k;
    /* renamed from: l */
    private final C1591e f9673l = new C36181(this);
    /* renamed from: m */
    private final C1589c f9674m = new C36192(this);
    /* renamed from: n */
    private final C1590d f9675n = new C36203(this);

    /* renamed from: com.facebook.ads.internal.view.c.a.a$1 */
    class C36181 implements C1591e {
        /* renamed from: a */
        final /* synthetic */ C3621a f9658a;
        /* renamed from: b */
        private float f9659b = 0.0f;

        C36181(C3621a c3621a) {
            this.f9658a = c3621a;
        }

        /* renamed from: a */
        public float mo1016a() {
            return this.f9659b;
        }

        /* renamed from: a */
        public void mo1017a(float f) {
            this.f9659b = f;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.a.a$2 */
    class C36192 implements C1589c {
        /* renamed from: a */
        final /* synthetic */ C3621a f9660a;

        C36192(C3621a c3621a) {
            this.f9660a = c3621a;
        }

        /* renamed from: a */
        public void mo1018a(int i) {
            this.f9660a.m11815a(i, true);
            if (this.f9660a.m11835f()) {
                this.f9660a.m11832d();
            } else {
                this.f9660a.m11813a(i);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.a.a$3 */
    class C36203 implements C1590d {
        /* renamed from: a */
        final /* synthetic */ C3621a f9661a;

        C36203(C3621a c3621a) {
            this.f9661a = c3621a;
        }

        /* renamed from: a */
        public void mo1019a(View view) {
            C3630b c3630b = (C3630b) view;
            c3630b.m11869j();
            if (this.f9661a.f9672k) {
                this.f9661a.f9671j = true;
            }
            if (this.f9661a.f9667f.m5435b() && ((Integer) c3630b.getTag(-1593835536)).intValue() == 0) {
                this.f9661a.f9667f.m5431a();
            }
        }

        /* renamed from: b */
        public void mo1020b(View view) {
            if (this.f9661a.f9672k) {
                this.f9661a.f9671j = false;
            }
        }
    }

    C3621a(C4845c c4845c, int i, List<C1580b> list, C1545a c1545a) {
        this.f9662a = c4845c.getLayoutManager();
        this.f9663b = i;
        this.f9666e = list;
        this.f9667f = c1545a;
        this.f9664c = new at(c4845c.getContext());
        c4845c.addOnScrollListener(this);
    }

    /* renamed from: a */
    private C3630b m11811a(int i, int i2) {
        return m11812a(i, i2, true);
    }

    /* renamed from: a */
    private C3630b m11812a(int i, int i2, boolean z) {
        C3630b c3630b = null;
        while (i <= i2) {
            C3630b c3630b2 = (C3630b) this.f9662a.findViewByPosition(i);
            if (c3630b2.m11866g()) {
                return null;
            }
            boolean a = C3621a.m11820a((View) c3630b2);
            if (c3630b == null && c3630b2.m11865f() && a && !this.f9665d.contains(Integer.valueOf(i)) && (!z || C3621a.m11827b(c3630b2))) {
                c3630b = c3630b2;
            }
            if (c3630b2.m11865f() && !a) {
                m11815a(i, false);
            }
            i++;
        }
        return c3630b;
    }

    /* renamed from: a */
    private void m11813a(int i) {
        C3630b a = m11812a(i + 1, this.f9662a.findLastVisibleItemPosition(), false);
        if (a != null) {
            a.m11867h();
            m11824b(((Integer) a.getTag(-1593835536)).intValue());
        }
    }

    /* renamed from: a */
    private void m11814a(int i, int i2, int i3) {
        if (!m11835f()) {
            return;
        }
        if (this.f9669h != null) {
            int findFirstCompletelyVisibleItemPosition = this.f9662a.findFirstCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition != -1) {
                i = findFirstCompletelyVisibleItemPosition;
            } else if (i3 >= 0) {
                i = i2;
            }
            this.f9669h.mo1021a(i);
        }
    }

    /* renamed from: a */
    private void m11815a(int i, boolean z) {
        if (z) {
            this.f9665d.add(Integer.valueOf(i));
        } else {
            this.f9665d.remove(Integer.valueOf(i));
        }
    }

    /* renamed from: a */
    private static void m11816a(View view, boolean z) {
        view.setAlpha(z ? 1.0f : 0.5f);
    }

    /* renamed from: a */
    private void m11819a(C3630b c3630b, boolean z) {
        if (m11835f()) {
            C3621a.m11816a((View) c3630b, z);
        }
        if (!z && c3630b.m11866g()) {
            c3630b.m11868i();
        }
    }

    /* renamed from: a */
    private static boolean m11820a(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return ((float) rect.width()) / ((float) view.getWidth()) >= 0.15f;
    }

    /* renamed from: a */
    private boolean m11823a(C3630b c3630b) {
        if (!this.f9668g || !c3630b.m11865f()) {
            return false;
        }
        this.f9668g = false;
        return true;
    }

    /* renamed from: b */
    private void m11824b(int i) {
        this.f9664c.setTargetPosition(i);
        this.f9662a.startSmoothScroll(this.f9664c);
    }

    /* renamed from: b */
    private void m11825b(int i, int i2) {
        while (i <= i2) {
            m11828c(i);
            i++;
        }
    }

    /* renamed from: b */
    private static boolean m11827b(C3630b c3630b) {
        return ((int) (c3630b.getX() + ((float) c3630b.getWidth()))) <= ((int) (((float) c3630b.getWidth()) * 1.3f));
    }

    /* renamed from: c */
    private void m11828c(int i) {
        C3630b c3630b = (C3630b) this.f9662a.findViewByPosition(i);
        if (C3621a.m11820a((View) c3630b)) {
            m11819a(c3630b, true);
        }
        if (m11823a(c3630b)) {
            this.f9673l.mo1017a(((C1580b) this.f9666e.get(((Integer) c3630b.getTag(-1593835536)).intValue())).m5514c().m4535c().m4490f() ? 1.0f : 0.0f);
        }
    }

    /* renamed from: c */
    private void m11829c(int i, int i2) {
        m11833d(i);
        m11833d(i2);
    }

    /* renamed from: d */
    private void m11832d() {
        int findFirstCompletelyVisibleItemPosition = this.f9662a.findFirstCompletelyVisibleItemPosition();
        if (findFirstCompletelyVisibleItemPosition != -1 && findFirstCompletelyVisibleItemPosition < this.f9666e.size() - 1) {
            m11824b(findFirstCompletelyVisibleItemPosition + 1);
        }
    }

    /* renamed from: d */
    private void m11833d(int i) {
        C3630b c3630b = (C3630b) this.f9662a.findViewByPosition(i);
        if (!C3621a.m11820a((View) c3630b)) {
            m11819a(c3630b, false);
        }
    }

    /* renamed from: e */
    private void m11834e() {
        if (this.f9671j) {
            C3630b a = m11811a(this.f9662a.findFirstVisibleItemPosition(), this.f9662a.findLastVisibleItemPosition());
            if (a != null) {
                a.m11867h();
            }
        }
    }

    /* renamed from: f */
    private boolean m11835f() {
        return this.f9663b == 1;
    }

    /* renamed from: a */
    public C1591e m11836a() {
        return this.f9673l;
    }

    /* renamed from: a */
    void m11837a(C1581a c1581a) {
        this.f9669h = c1581a;
    }

    /* renamed from: b */
    public C1589c m11838b() {
        return this.f9674m;
    }

    /* renamed from: c */
    public C1590d m11839c() {
        return this.f9675n;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0) {
            this.f9672k = true;
            m11834e();
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        this.f9672k = false;
        if (this.f9670i) {
            this.f9672k = true;
            m11834e();
            this.f9670i = false;
        }
        int findFirstVisibleItemPosition = this.f9662a.findFirstVisibleItemPosition();
        i2 = this.f9662a.findLastVisibleItemPosition();
        m11829c(findFirstVisibleItemPosition, i2);
        m11825b(findFirstVisibleItemPosition, i2);
        m11814a(findFirstVisibleItemPosition, i2, i);
    }
}
