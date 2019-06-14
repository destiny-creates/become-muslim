package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* compiled from: NestedScrollingChildHelper */
/* renamed from: android.support.v4.view.l */
public class C0509l {
    /* renamed from: a */
    private ViewParent f1276a;
    /* renamed from: b */
    private ViewParent f1277b;
    /* renamed from: c */
    private final View f1278c;
    /* renamed from: d */
    private boolean f1279d;
    /* renamed from: e */
    private int[] f1280e;

    public C0509l(View view) {
        this.f1278c = view;
    }

    /* renamed from: a */
    public void m1611a(boolean z) {
        if (this.f1279d) {
            C0517s.m1728v(this.f1278c);
        }
        this.f1279d = z;
    }

    /* renamed from: a */
    public boolean m1612a() {
        return this.f1279d;
    }

    /* renamed from: b */
    public boolean m1621b() {
        return m1615a(0);
    }

    /* renamed from: a */
    public boolean m1615a(int i) {
        return m1610d(i) != 0;
    }

    /* renamed from: b */
    public boolean m1622b(int i) {
        return m1616a(i, 0);
    }

    /* renamed from: a */
    public boolean m1616a(int i, int i2) {
        if (m1615a(i2)) {
            return true;
        }
        if (m1612a()) {
            View view = this.f1278c;
            for (ViewParent parent = this.f1278c.getParent(); parent != null; parent = parent.getParent()) {
                if (C0522v.m1750a(parent, view, this.f1278c, i, i2)) {
                    m1609a(i2, parent);
                    C0522v.m1751b(parent, view, this.f1278c, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public void m1623c() {
        m1624c(0);
    }

    /* renamed from: c */
    public void m1624c(int i) {
        ViewParent d = m1610d(i);
        if (d != null) {
            C0522v.m1745a(d, this.f1278c, i);
            m1609a(i, null);
        }
    }

    /* renamed from: a */
    public boolean m1617a(int i, int i2, int i3, int i4, int[] iArr) {
        return m1618a(i, i2, i3, i4, iArr, 0);
    }

    /* renamed from: a */
    public boolean m1618a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        C0509l c0509l = this;
        int[] iArr2 = iArr;
        if (m1612a()) {
            ViewParent d = m1610d(i5);
            if (d == null) {
                return false;
            }
            int i6;
            int i7;
            if (i == 0 && i2 == 0 && i3 == 0) {
                if (i4 == 0) {
                    if (iArr2 != null) {
                        iArr2[0] = 0;
                        iArr2[1] = 0;
                    }
                }
            }
            if (iArr2 != null) {
                c0509l.f1278c.getLocationInWindow(iArr2);
                i6 = iArr2[0];
                i7 = iArr2[1];
            } else {
                i6 = 0;
                i7 = 0;
            }
            C0522v.m1746a(d, c0509l.f1278c, i, i2, i3, i4, i5);
            if (iArr2 != null) {
                c0509l.f1278c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i6;
                iArr2[1] = iArr2[1] - i7;
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public boolean m1619a(int i, int i2, int[] iArr, int[] iArr2) {
        return m1620a(i, i2, iArr, iArr2, 0);
    }

    /* renamed from: a */
    public boolean m1620a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        if (m1612a()) {
            ViewParent d = m1610d(i3);
            if (d == null) {
                return false;
            }
            int i4;
            int i5;
            boolean z = true;
            if (i == 0) {
                if (i2 == 0) {
                    if (iArr2 != null) {
                        iArr2[0] = 0;
                        iArr2[1] = 0;
                    }
                }
            }
            if (iArr2 != null) {
                this.f1278c.getLocationInWindow(iArr2);
                i4 = iArr2[0];
                i5 = iArr2[1];
            } else {
                i4 = 0;
                i5 = 0;
            }
            if (iArr == null) {
                if (this.f1280e == null) {
                    this.f1280e = new int[2];
                }
                iArr = this.f1280e;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            C0522v.m1747a(d, this.f1278c, i, i2, iArr, i3);
            if (iArr2 != null) {
                this.f1278c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i4;
                iArr2[1] = iArr2[1] - i5;
            }
            if (iArr[0] == 0) {
                if (iArr[1] == 0) {
                    z = false;
                }
            }
            return z;
        }
        return false;
    }

    /* renamed from: a */
    public boolean m1614a(float f, float f2, boolean z) {
        if (m1612a()) {
            ViewParent d = m1610d(0);
            if (d != null) {
                return C0522v.m1749a(d, this.f1278c, f, f2, z);
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m1613a(float f, float f2) {
        if (m1612a()) {
            ViewParent d = m1610d(0);
            if (d != null) {
                return C0522v.m1748a(d, this.f1278c, f, f2);
            }
        }
        return false;
    }

    /* renamed from: d */
    private ViewParent m1610d(int i) {
        switch (i) {
            case 0:
                return this.f1276a;
            case 1:
                return this.f1277b;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    private void m1609a(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.f1276a = viewParent;
                return;
            case 1:
                this.f1277b = viewParent;
                return;
            default:
                return;
        }
    }
}
