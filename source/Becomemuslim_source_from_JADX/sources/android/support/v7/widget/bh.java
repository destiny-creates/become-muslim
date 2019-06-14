package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0697f;
import android.support.v7.widget.RecyclerView.C0697f.C0696c;
import android.support.v7.widget.RecyclerView.C0718x;

/* compiled from: SimpleItemAnimator */
public abstract class bh extends C0697f {
    /* renamed from: h */
    boolean f8797h = true;

    /* renamed from: a */
    public abstract boolean mo2764a(C0718x c0718x);

    /* renamed from: a */
    public abstract boolean mo2765a(C0718x c0718x, int i, int i2, int i3, int i4);

    /* renamed from: a */
    public abstract boolean mo2766a(C0718x c0718x, C0718x c0718x2, int i, int i2, int i3, int i4);

    /* renamed from: b */
    public abstract boolean mo2769b(C0718x c0718x);

    /* renamed from: c */
    public void m10517c(C0718x c0718x, boolean z) {
    }

    /* renamed from: d */
    public void m10519d(C0718x c0718x, boolean z) {
    }

    /* renamed from: o */
    public void m10527o(C0718x c0718x) {
    }

    /* renamed from: p */
    public void m10528p(C0718x c0718x) {
    }

    /* renamed from: q */
    public void m10529q(C0718x c0718x) {
    }

    /* renamed from: r */
    public void m10530r(C0718x c0718x) {
    }

    /* renamed from: s */
    public void m10531s(C0718x c0718x) {
    }

    /* renamed from: t */
    public void m10532t(C0718x c0718x) {
    }

    /* renamed from: h */
    public boolean mo665h(C0718x c0718x) {
        if (this.f8797h) {
            if (c0718x.isInvalid() == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo661a(C0718x c0718x, C0696c c0696c, C0696c c0696c2) {
        int i = c0696c.f1800a;
        int i2 = c0696c.f1801b;
        c0696c = c0718x.itemView;
        int left = c0696c2 == null ? c0696c.getLeft() : c0696c2.f1800a;
        int top = c0696c2 == null ? c0696c.getTop() : c0696c2.f1801b;
        if (c0718x.isRemoved() != null || (i == left && i2 == top)) {
            return mo2764a(c0718x);
        }
        c0696c.layout(left, top, c0696c.getWidth() + left, c0696c.getHeight() + top);
        return mo2765a(c0718x, i, i2, left, top);
    }

    /* renamed from: b */
    public boolean mo663b(C0718x c0718x, C0696c c0696c, C0696c c0696c2) {
        if (c0696c == null || (c0696c.f1800a == c0696c2.f1800a && c0696c.f1801b == c0696c2.f1801b)) {
            return mo2769b(c0718x);
        }
        return mo2765a(c0718x, c0696c.f1800a, c0696c.f1801b, c0696c2.f1800a, c0696c2.f1801b);
    }

    /* renamed from: c */
    public boolean mo664c(C0718x c0718x, C0696c c0696c, C0696c c0696c2) {
        if (c0696c.f1800a == c0696c2.f1800a) {
            if (c0696c.f1801b == c0696c2.f1801b) {
                m10522j(c0718x);
                return null;
            }
        }
        return mo2765a(c0718x, c0696c.f1800a, c0696c.f1801b, c0696c2.f1800a, c0696c2.f1801b);
    }

    /* renamed from: a */
    public boolean mo662a(C0718x c0718x, C0718x c0718x2, C0696c c0696c, C0696c c0696c2) {
        int i;
        int i2;
        int i3 = c0696c.f1800a;
        int i4 = c0696c.f1801b;
        if (c0718x2.shouldIgnore()) {
            c0696c2 = c0696c.f1800a;
            i = c0696c.f1801b;
            i2 = c0696c2;
        } else {
            i2 = c0696c2.f1800a;
            i = c0696c2.f1801b;
        }
        return mo2766a(c0718x, c0718x2, i3, i4, i2, i);
    }

    /* renamed from: i */
    public final void m10521i(C0718x c0718x) {
        m10528p(c0718x);
        m2311f(c0718x);
    }

    /* renamed from: j */
    public final void m10522j(C0718x c0718x) {
        m10532t(c0718x);
        m2311f(c0718x);
    }

    /* renamed from: k */
    public final void m10523k(C0718x c0718x) {
        m10530r(c0718x);
        m2311f(c0718x);
    }

    /* renamed from: a */
    public final void m10508a(C0718x c0718x, boolean z) {
        m10519d(c0718x, z);
        m2311f(c0718x);
    }

    /* renamed from: l */
    public final void m10524l(C0718x c0718x) {
        m10527o(c0718x);
    }

    /* renamed from: m */
    public final void m10525m(C0718x c0718x) {
        m10531s(c0718x);
    }

    /* renamed from: n */
    public final void m10526n(C0718x c0718x) {
        m10529q(c0718x);
    }

    /* renamed from: b */
    public final void m10514b(C0718x c0718x, boolean z) {
        m10517c(c0718x, z);
    }
}
