package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.p033a.C0483b;
import android.support.v4.view.p033a.C0483b.C0482c;
import android.support.v7.widget.LinearLayoutManager.C0681a;
import android.support.v7.widget.LinearLayoutManager.C0682b;
import android.support.v7.widget.LinearLayoutManager.C0683c;
import android.support.v7.widget.RecyclerView.C0701i;
import android.support.v7.widget.RecyclerView.C0701i.C0699a;
import android.support.v7.widget.RecyclerView.C0702j;
import android.support.v7.widget.RecyclerView.C0709p;
import android.support.v7.widget.RecyclerView.C0715u;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    /* renamed from: a */
    boolean f12045a = null;
    /* renamed from: b */
    int f12046b = -1;
    /* renamed from: c */
    int[] f12047c;
    /* renamed from: d */
    View[] f12048d;
    /* renamed from: e */
    final SparseIntArray f12049e = new SparseIntArray();
    /* renamed from: f */
    final SparseIntArray f12050f = new SparseIntArray();
    /* renamed from: g */
    C0680c f12051g = new C3286a();
    /* renamed from: h */
    final Rect f12052h = new Rect();

    /* renamed from: android.support.v7.widget.GridLayoutManager$c */
    public static abstract class C0680c {
        /* renamed from: a */
        final SparseIntArray f1772a = new SparseIntArray();
        /* renamed from: b */
        private boolean f1773b = false;

        /* renamed from: a */
        public abstract int mo523a(int i);

        /* renamed from: a */
        public void m2257a() {
            this.f1772a.clear();
        }

        /* renamed from: b */
        int m2259b(int i, int i2) {
            if (!this.f1773b) {
                return mo524a(i, i2);
            }
            int i3 = this.f1772a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i2 = mo524a(i, i2);
            this.f1772a.put(i, i2);
            return i2;
        }

        /* renamed from: a */
        public int mo524a(int i, int i2) {
            int a = mo523a(i);
            if (a == i2) {
                return 0;
            }
            int b;
            int a2;
            int a3;
            if (this.f1773b && this.f1772a.size() > 0) {
                b = m2258b(i);
                if (b >= 0) {
                    a2 = this.f1772a.get(b) + mo523a(b);
                    b++;
                    while (b < i) {
                        a3 = mo523a(b);
                        a2 += a3;
                        if (a2 == i2) {
                            a2 = 0;
                        } else if (a2 > i2) {
                            a2 = a3;
                        }
                        b++;
                    }
                    if (a + a2 > i2) {
                        return a2;
                    }
                    return 0;
                }
            }
            b = 0;
            a2 = 0;
            while (b < i) {
                a3 = mo523a(b);
                a2 += a3;
                if (a2 == i2) {
                    a2 = 0;
                } else if (a2 > i2) {
                    a2 = a3;
                }
                b++;
            }
            if (a + a2 > i2) {
                return 0;
            }
            return a2;
        }

        /* renamed from: b */
        int m2258b(int i) {
            int size = this.f1772a.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f1772a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            i2--;
            return (i2 < 0 || i2 >= this.f1772a.size()) ? -1 : this.f1772a.keyAt(i2);
        }

        /* renamed from: c */
        public int m2260c(int i, int i2) {
            int a = mo523a(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int a2 = mo523a(i5);
                i3 += a2;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = a2;
                }
            }
            return i3 + a > i2 ? i4 + 1 : i4;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayoutManager$a */
    public static final class C3286a extends C0680c {
        /* renamed from: a */
        public int mo523a(int i) {
            return 1;
        }

        /* renamed from: a */
        public int mo524a(int i, int i2) {
            return i % i2;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayoutManager$b */
    public static class C3287b extends C0702j {
        /* renamed from: a */
        int f8623a = -1;
        /* renamed from: b */
        int f8624b = 0;

        public C3287b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C3287b(int i, int i2) {
            super(i, i2);
        }

        public C3287b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C3287b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* renamed from: a */
        public int m10224a() {
            return this.f8623a;
        }

        /* renamed from: b */
        public int m10225b() {
            return this.f8624b;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m15143a(C0701i.getProperties(context, attributeSet, i, i2).f1811b);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        m15143a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        m15143a(i);
    }

    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    public int getRowCountForAccessibility(C0709p c0709p, C0715u c0715u) {
        if (this.mOrientation == 0) {
            return this.f12046b;
        }
        if (c0715u.m2402e() < 1) {
            return null;
        }
        return m15128a(c0709p, c0715u, c0715u.m2402e() - 1) + 1;
    }

    public int getColumnCountForAccessibility(C0709p c0709p, C0715u c0715u) {
        if (this.mOrientation == 1) {
            return this.f12046b;
        }
        if (c0715u.m2402e() < 1) {
            return null;
        }
        return m15128a(c0709p, c0715u, c0715u.m2402e() - 1) + 1;
    }

    public void onInitializeAccessibilityNodeInfoForItem(C0709p c0709p, C0715u c0715u, View view, C0483b c0483b) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof C3287b) {
            C3287b c3287b = (C3287b) layoutParams;
            c0709p = m15128a(c0709p, c0715u, c3287b.m2328f());
            boolean z;
            if (this.mOrientation == null) {
                c0715u = c3287b.m10224a();
                int b = c3287b.m10225b();
                z = this.f12046b > 1 && c3287b.m10225b() == this.f12046b;
                c0483b.m1513b(C0482c.m1497a(c0715u, b, c0709p, 1, z, false));
            } else {
                int a = c3287b.m10224a();
                int b2 = c3287b.m10225b();
                z = this.f12046b > 1 && c3287b.m10225b() == this.f12046b;
                c0483b.m1513b(C0482c.m1497a(c0709p, 1, a, b2, z, false));
            }
            return;
        }
        super.onInitializeAccessibilityNodeInfoForItem(view, c0483b);
    }

    public void onLayoutChildren(C0709p c0709p, C0715u c0715u) {
        if (c0715u.m2398a()) {
            m15137b();
        }
        super.onLayoutChildren(c0709p, c0715u);
        m15129a();
    }

    public void onLayoutCompleted(C0715u c0715u) {
        super.onLayoutCompleted(c0715u);
        this.f12045a = null;
    }

    /* renamed from: a */
    private void m15129a() {
        this.f12049e.clear();
        this.f12050f.clear();
    }

    /* renamed from: b */
    private void m15137b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            C3287b c3287b = (C3287b) getChildAt(i).getLayoutParams();
            int f = c3287b.m2328f();
            this.f12049e.put(f, c3287b.m10225b());
            this.f12050f.put(f, c3287b.m10224a());
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.f12051g.m2257a();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f12051g.m2257a();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.f12051g.m2257a();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f12051g.m2257a();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f12051g.m2257a();
    }

    public C0702j generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new C3287b(-2, -1);
        }
        return new C3287b(-1, -2);
    }

    public C0702j generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new C3287b(context, attributeSet);
    }

    public C0702j generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new C3287b((MarginLayoutParams) layoutParams);
        }
        return new C3287b(layoutParams);
    }

    public boolean checkLayoutParams(C0702j c0702j) {
        return c0702j instanceof C3287b;
    }

    /* renamed from: c */
    private void m15140c() {
        int width;
        if (getOrientation() == 1) {
            width = (getWidth() - getPaddingRight()) - getPaddingLeft();
        } else {
            width = (getHeight() - getPaddingBottom()) - getPaddingTop();
        }
        m15138b(width);
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        if (this.f12047c == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            rect = C0701i.chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            i = C0701i.chooseSize(i, this.f12047c[this.f12047c.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            i = C0701i.chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            rect = C0701i.chooseSize(i2, this.f12047c[this.f12047c.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i, rect);
    }

    /* renamed from: b */
    private void m15138b(int i) {
        this.f12047c = m15135a(this.f12047c, this.f12046b, i);
    }

    /* renamed from: a */
    static int[] m15135a(int[] iArr, int i, int i2) {
        int i3 = 1;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        i2 %= i;
        int i6 = 0;
        while (i3 <= i) {
            int i7;
            i4 += i2;
            if (i4 <= 0 || i - i4 >= i2) {
                i7 = i5;
            } else {
                i7 = i5 + 1;
                i4 -= i;
            }
            i6 += i7;
            iArr[i3] = i6;
            i3++;
        }
        return iArr;
    }

    /* renamed from: a */
    int m15142a(int i, int i2) {
        if (this.mOrientation == 1 && isLayoutRTL()) {
            return this.f12047c[this.f12046b - i] - this.f12047c[(this.f12046b - i) - i2];
        }
        return this.f12047c[i2 + i] - this.f12047c[i];
    }

    void onAnchorReady(C0709p c0709p, C0715u c0715u, C0681a c0681a, int i) {
        super.onAnchorReady(c0709p, c0715u, c0681a, i);
        m15140c();
        if (c0715u.m2402e() > 0 && !c0715u.m2398a()) {
            m15132a(c0709p, c0715u, c0681a, i);
        }
        m15141d();
    }

    /* renamed from: d */
    private void m15141d() {
        if (this.f12048d == null || this.f12048d.length != this.f12046b) {
            this.f12048d = new View[this.f12046b];
        }
    }

    public int scrollHorizontallyBy(int i, C0709p c0709p, C0715u c0715u) {
        m15140c();
        m15141d();
        return super.scrollHorizontallyBy(i, c0709p, c0715u);
    }

    public int scrollVerticallyBy(int i, C0709p c0709p, C0715u c0715u) {
        m15140c();
        m15141d();
        return super.scrollVerticallyBy(i, c0709p, c0715u);
    }

    /* renamed from: a */
    private void m15132a(C0709p c0709p, C0715u c0715u, C0681a c0681a, int i) {
        i = i == 1 ? 1 : 0;
        int b = m15136b(c0709p, c0715u, c0681a.f1775b);
        if (i != 0) {
            while (b > 0 && c0681a.f1775b > 0) {
                c0681a.f1775b--;
                b = m15136b(c0709p, c0715u, c0681a.f1775b);
            }
            return;
        }
        i = c0715u.m2402e() - 1;
        int i2 = c0681a.f1775b;
        while (i2 < i) {
            int i3 = i2 + 1;
            int b2 = m15136b(c0709p, c0715u, i3);
            if (b2 <= b) {
                break;
            }
            i2 = i3;
            b = b2;
        }
        c0681a.f1775b = i2;
    }

    View findReferenceChild(C0709p c0709p, C0715u c0715u, int i, int i2, int i3) {
        ensureLayoutState();
        int c = this.mOrientationHelper.mo650c();
        int d = this.mOrientationHelper.mo652d();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (m15136b(c0709p, c0715u, position) == 0) {
                    if (!((C0702j) childAt.getLayoutParams()).m2326d()) {
                        if (this.mOrientationHelper.mo647a(childAt) < d) {
                            if (this.mOrientationHelper.mo649b(childAt) >= c) {
                                return childAt;
                            }
                        }
                        if (view == null) {
                            view = childAt;
                        }
                    } else if (view2 == null) {
                        view2 = childAt;
                    }
                }
            }
            i += i4;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    /* renamed from: a */
    private int m15128a(C0709p c0709p, C0715u c0715u, int i) {
        if (c0715u.m2398a() == null) {
            return this.f12051g.m2260c(i, this.f12046b);
        }
        c0709p = c0709p.m2364b(i);
        if (c0709p != -1) {
            return this.f12051g.m2260c(c0709p, this.f12046b);
        }
        c0715u = new StringBuilder();
        c0715u.append("Cannot find span size for pre layout position. ");
        c0715u.append(i);
        Log.w("GridLayoutManager", c0715u.toString());
        return null;
    }

    /* renamed from: b */
    private int m15136b(C0709p c0709p, C0715u c0715u, int i) {
        if (c0715u.m2398a() == null) {
            return this.f12051g.m2259b(i, this.f12046b);
        }
        c0715u = this.f12050f.get(i, -1);
        if (c0715u != -1) {
            return c0715u;
        }
        c0709p = c0709p.m2364b(i);
        if (c0709p != -1) {
            return this.f12051g.m2259b(c0709p, this.f12046b);
        }
        c0715u = new StringBuilder();
        c0715u.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        c0715u.append(i);
        Log.w("GridLayoutManager", c0715u.toString());
        return null;
    }

    /* renamed from: c */
    private int m15139c(C0709p c0709p, C0715u c0715u, int i) {
        if (c0715u.m2398a() == null) {
            return this.f12051g.mo523a(i);
        }
        c0715u = this.f12049e.get(i, -1);
        if (c0715u != -1) {
            return c0715u;
        }
        c0709p = c0709p.m2364b(i);
        if (c0709p != -1) {
            return this.f12051g.mo523a(c0709p);
        }
        c0715u = new StringBuilder();
        c0715u.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        c0715u.append(i);
        Log.w("GridLayoutManager", c0715u.toString());
        return 1;
    }

    void collectPrefetchPositionsForLayoutState(C0715u c0715u, C0683c c0683c, C0699a c0699a) {
        int i = this.f12046b;
        for (int i2 = 0; i2 < this.f12046b && c0683c.m2271a(c0715u) && i > 0; i2++) {
            int i3 = c0683c.f1786d;
            c0699a.mo629b(i3, Math.max(0, c0683c.f1789g));
            i -= this.f12051g.mo523a(i3);
            c0683c.f1786d += c0683c.f1787e;
        }
    }

    void layoutChunk(C0709p c0709p, C0715u c0715u, C0683c c0683c, C0682b c0682b) {
        C0709p c0709p2 = c0709p;
        C0715u c0715u2 = c0715u;
        C0683c c0683c2 = c0683c;
        C0682b c0682b2 = c0682b;
        int i = this.mOrientationHelper.mo660i();
        Object obj = i != 1073741824 ? 1 : null;
        int i2 = getChildCount() > 0 ? r6.f12047c[r6.f12046b] : 0;
        if (obj != null) {
            m15140c();
        }
        boolean z = c0683c2.f1787e == 1;
        int i3 = r6.f12046b;
        if (!z) {
            i3 = m15136b(c0709p2, c0715u2, c0683c2.f1786d) + m15139c(c0709p2, c0715u2, c0683c2.f1786d);
        }
        int i4 = 0;
        int i5 = 0;
        while (i5 < r6.f12046b && c0683c2.m2271a(c0715u2) && i3 > 0) {
            int i6 = c0683c2.f1786d;
            int c = m15139c(c0709p2, c0715u2, i6);
            if (c <= r6.f12046b) {
                i3 -= c;
                if (i3 < 0) {
                    break;
                }
                View a = c0683c2.m2268a(c0709p2);
                if (a == null) {
                    break;
                }
                i4 += c;
                r6.f12048d[i5] = a;
                i5++;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Item at position ");
                stringBuilder.append(i6);
                stringBuilder.append(" requires ");
                stringBuilder.append(c);
                stringBuilder.append(" spans but GridLayoutManager has only ");
                stringBuilder.append(r6.f12046b);
                stringBuilder.append(" spans.");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        if (i5 == 0) {
            c0682b2.f1780b = true;
            return;
        }
        int e;
        float f = 0.0f;
        int i7 = i5;
        m15131a(c0709p, c0715u, i5, i4, z);
        int i8 = 0;
        for (i3 = 0; i3 < i7; i3++) {
            boolean z2;
            View view = r6.f12048d[i3];
            if (c0683c2.f1793k != null) {
                z2 = false;
                if (z) {
                    addDisappearingView(view);
                } else {
                    addDisappearingView(view, 0);
                }
            } else if (z) {
                addView(view);
                z2 = false;
            } else {
                z2 = false;
                addView(view, 0);
            }
            calculateItemDecorationsForChild(view, r6.f12052h);
            m15134a(view, i, z2);
            i6 = r6.mOrientationHelper.mo655e(view);
            if (i6 > i8) {
                i8 = i6;
            }
            float f2 = (((float) r6.mOrientationHelper.mo657f(view)) * 1.0f) / ((float) ((C3287b) view.getLayoutParams()).f8624b);
            if (f2 > f) {
                f = f2;
            }
        }
        if (obj != null) {
            m15130a(f, i2);
            i8 = 0;
            for (i3 = 0; i3 < i7; i3++) {
                view = r6.f12048d[i3];
                m15134a(view, 1073741824, true);
                e = r6.mOrientationHelper.mo655e(view);
                if (e > i8) {
                    i8 = e;
                }
            }
        }
        for (i3 = 0; i3 < i7; i3++) {
            view = r6.f12048d[i3];
            if (r6.mOrientationHelper.mo655e(view) != i8) {
                C3287b c3287b = (C3287b) view.getLayoutParams();
                Rect rect = c3287b.d;
                i5 = ((rect.top + rect.bottom) + c3287b.topMargin) + c3287b.bottomMargin;
                i = ((rect.left + rect.right) + c3287b.leftMargin) + c3287b.rightMargin;
                i4 = m15142a(c3287b.f8623a, c3287b.f8624b);
                if (r6.mOrientation == 1) {
                    i6 = C0701i.getChildMeasureSpec(i4, 1073741824, i, c3287b.width, false);
                    i4 = MeasureSpec.makeMeasureSpec(i8 - i5, 1073741824);
                } else {
                    i = MeasureSpec.makeMeasureSpec(i8 - i, 1073741824);
                    i4 = C0701i.getChildMeasureSpec(i4, 1073741824, i5, c3287b.height, false);
                    i6 = i;
                }
                m15133a(view, i6, i4, true);
            }
        }
        c = 0;
        c0682b2.f1779a = i8;
        if (r6.mOrientation == 1) {
            if (c0683c2.f1788f == -1) {
                i3 = c0683c2.f1784b;
                i6 = i3;
                e = i3 - i8;
            } else {
                i3 = c0683c2.f1784b;
                e = i3;
                i6 = i8 + i3;
            }
            i3 = 0;
            i8 = 0;
        } else if (c0683c2.f1788f == -1) {
            i3 = c0683c2.f1784b;
            e = 0;
            i6 = 0;
            int i9 = i3 - i8;
            i8 = i3;
            i3 = i9;
        } else {
            i3 = c0683c2.f1784b;
            i8 += i3;
            e = 0;
            i6 = 0;
        }
        while (c < i7) {
            int i10;
            int f3;
            int i11;
            View view2 = r6.f12048d[c];
            C3287b c3287b2 = (C3287b) view2.getLayoutParams();
            if (r6.mOrientation != 1) {
                e = getPaddingTop() + r6.f12047c[c3287b2.f8623a];
                i6 = r6.mOrientationHelper.mo657f(view2) + e;
            } else if (isLayoutRTL()) {
                i3 = getPaddingLeft() + r6.f12047c[r6.f12046b - c3287b2.f8623a];
                i10 = i3;
                f3 = i3 - r6.mOrientationHelper.mo657f(view2);
                i2 = e;
                i11 = i6;
                layoutDecoratedWithMargins(view2, f3, i2, i10, i11);
                if (!c3287b2.m2326d() || c3287b2.m2327e()) {
                    c0682b2.f1781c = true;
                }
                c0682b2.f1782d |= view2.hasFocusable();
                c++;
                i3 = f3;
                e = i2;
                i8 = i10;
                i6 = i11;
            } else {
                i3 = getPaddingLeft() + r6.f12047c[c3287b2.f8623a];
                i8 = r6.mOrientationHelper.mo657f(view2) + i3;
            }
            f3 = i3;
            i10 = i8;
            i2 = e;
            i11 = i6;
            layoutDecoratedWithMargins(view2, f3, i2, i10, i11);
            if (c3287b2.m2326d()) {
            }
            c0682b2.f1781c = true;
            c0682b2.f1782d |= view2.hasFocusable();
            c++;
            i3 = f3;
            e = i2;
            i8 = i10;
            i6 = i11;
        }
        Arrays.fill(r6.f12048d, null);
    }

    /* renamed from: a */
    private void m15134a(View view, int i, boolean z) {
        int childMeasureSpec;
        C3287b c3287b = (C3287b) view.getLayoutParams();
        Rect rect = c3287b.d;
        int i2 = ((rect.top + rect.bottom) + c3287b.topMargin) + c3287b.bottomMargin;
        int i3 = ((rect.left + rect.right) + c3287b.leftMargin) + c3287b.rightMargin;
        int a = m15142a(c3287b.f8623a, c3287b.f8624b);
        if (this.mOrientation == 1) {
            i = C0701i.getChildMeasureSpec(a, i, i3, c3287b.width, false);
            childMeasureSpec = C0701i.getChildMeasureSpec(this.mOrientationHelper.mo656f(), getHeightMode(), i2, c3287b.height, true);
        } else {
            i = C0701i.getChildMeasureSpec(a, i, i2, c3287b.height, false);
            int childMeasureSpec2 = C0701i.getChildMeasureSpec(this.mOrientationHelper.mo656f(), getWidthMode(), i3, c3287b.width, true);
            childMeasureSpec = i;
            i = childMeasureSpec2;
        }
        m15133a(view, i, childMeasureSpec, z);
    }

    /* renamed from: a */
    private void m15130a(float f, int i) {
        m15138b(Math.max(Math.round(f * ((float) this.f12046b)), i));
    }

    /* renamed from: a */
    private void m15133a(View view, int i, int i2, boolean z) {
        C0702j c0702j = (C0702j) view.getLayoutParams();
        if (z) {
            z = shouldReMeasureChild(view, i, i2, c0702j);
        } else {
            z = shouldMeasureChild(view, i, i2, c0702j);
        }
        if (z) {
            view.measure(i, i2);
        }
    }

    /* renamed from: a */
    private void m15131a(C0709p c0709p, C0715u c0715u, int i, int i2, boolean z) {
        i2 = -1;
        int i3 = 0;
        if (z) {
            i2 = i;
            i = 0;
            z = true;
        } else {
            i--;
            z = true;
        }
        while (i != i2) {
            View view = this.f12048d[i];
            C3287b c3287b = (C3287b) view.getLayoutParams();
            c3287b.f8624b = m15139c(c0709p, c0715u, getPosition(view));
            c3287b.f8623a = i3;
            i3 += c3287b.f8624b;
            i += z;
        }
    }

    /* renamed from: a */
    public void m15143a(int i) {
        if (i != this.f12046b) {
            this.f12045a = true;
            if (i >= 1) {
                this.f12046b = i;
                this.f12051g.m2257a();
                requestLayout();
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Span count should be at least 1. Provided ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public View onFocusSearchFailed(View view, int i, C0709p c0709p, C0715u c0715u) {
        GridLayoutManager gridLayoutManager = this;
        C0709p c0709p2 = c0709p;
        C0715u c0715u2 = c0715u;
        View findContainingItemView = findContainingItemView(view);
        View view2 = null;
        if (findContainingItemView == null) {
            return null;
        }
        C3287b c3287b = (C3287b) findContainingItemView.getLayoutParams();
        int i2 = c3287b.f8623a;
        int i3 = c3287b.f8623a + c3287b.f8624b;
        if (super.onFocusSearchFailed(view, i, c0709p, c0715u) == null) {
            return null;
        }
        int childCount;
        int i4;
        int i5;
        View view3;
        if (((convertFocusDirectionToLayoutDirection(i) == 1) != gridLayoutManager.mShouldReverseLayout ? 1 : null) != null) {
            childCount = getChildCount() - 1;
            i4 = -1;
            i5 = -1;
        } else {
            i4 = getChildCount();
            childCount = 0;
            i5 = 1;
        }
        boolean z = gridLayoutManager.mOrientation == 1 && isLayoutRTL();
        int a = m15128a(c0709p2, c0715u2, childCount);
        View view4 = null;
        int i6 = -1;
        int i7 = 0;
        int i8 = 0;
        int i9 = -1;
        while (childCount != i4) {
            int a2 = m15128a(c0709p2, c0715u2, childCount);
            View childAt = getChildAt(childCount);
            if (childAt == findContainingItemView) {
                break;
            }
            View view5;
            int i10;
            int i11;
            if (!childAt.hasFocusable() || a2 == a) {
                C3287b c3287b2 = (C3287b) childAt.getLayoutParams();
                int i12 = c3287b2.f8623a;
                view5 = findContainingItemView;
                i10 = i4;
                int i13 = c3287b2.f8623a + c3287b2.f8624b;
                if (childAt.hasFocusable() && i12 == i2 && i13 == i3) {
                    return childAt;
                }
                Object obj;
                if (!(childAt.hasFocusable() && view2 == null) && (childAt.hasFocusable() || view4 != null)) {
                    i4 = Math.min(i13, i3) - Math.max(i12, i2);
                    if (childAt.hasFocusable()) {
                        if (i4 <= i7) {
                            if (i4 == i7) {
                                if (z == (i12 > i6)) {
                                }
                            }
                        }
                    } else if (view2 == null) {
                        i11 = i6;
                        view3 = view4;
                        boolean z2 = false;
                        if (isViewPartiallyVisible(childAt, false, true)) {
                            i6 = i8;
                            if (i4 > i6) {
                                i4 = i9;
                                obj = 1;
                                if (obj != null) {
                                    if (childAt.hasFocusable()) {
                                        i7 = Math.min(i13, i3) - Math.max(i12, i2);
                                        i8 = i6;
                                        i9 = i4;
                                        view4 = view3;
                                        i6 = c3287b2.f8623a;
                                        view2 = childAt;
                                    } else {
                                        view4 = childAt;
                                        i8 = Math.min(i13, i3) - Math.max(i12, i2);
                                        i9 = c3287b2.f8623a;
                                        i6 = i11;
                                    }
                                    childCount += i5;
                                    findContainingItemView = view5;
                                    i4 = i10;
                                    c0709p2 = c0709p;
                                    c0715u2 = c0715u;
                                }
                            } else {
                                if (i4 == i6) {
                                    i4 = i9;
                                    if (i12 > i4) {
                                        z2 = true;
                                    }
                                    if (z == z2) {
                                        obj = 1;
                                        if (obj != null) {
                                            if (childAt.hasFocusable()) {
                                                view4 = childAt;
                                                i8 = Math.min(i13, i3) - Math.max(i12, i2);
                                                i9 = c3287b2.f8623a;
                                                i6 = i11;
                                            } else {
                                                i7 = Math.min(i13, i3) - Math.max(i12, i2);
                                                i8 = i6;
                                                i9 = i4;
                                                view4 = view3;
                                                i6 = c3287b2.f8623a;
                                                view2 = childAt;
                                            }
                                            childCount += i5;
                                            findContainingItemView = view5;
                                            i4 = i10;
                                            c0709p2 = c0709p;
                                            c0715u2 = c0715u;
                                        }
                                    }
                                    obj = null;
                                    if (obj != null) {
                                        if (childAt.hasFocusable()) {
                                            i7 = Math.min(i13, i3) - Math.max(i12, i2);
                                            i8 = i6;
                                            i9 = i4;
                                            view4 = view3;
                                            i6 = c3287b2.f8623a;
                                            view2 = childAt;
                                        } else {
                                            view4 = childAt;
                                            i8 = Math.min(i13, i3) - Math.max(i12, i2);
                                            i9 = c3287b2.f8623a;
                                            i6 = i11;
                                        }
                                        childCount += i5;
                                        findContainingItemView = view5;
                                        i4 = i10;
                                        c0709p2 = c0709p;
                                        c0715u2 = c0715u;
                                    }
                                }
                                i4 = i9;
                                obj = null;
                                if (obj != null) {
                                    if (childAt.hasFocusable()) {
                                        view4 = childAt;
                                        i8 = Math.min(i13, i3) - Math.max(i12, i2);
                                        i9 = c3287b2.f8623a;
                                        i6 = i11;
                                    } else {
                                        i7 = Math.min(i13, i3) - Math.max(i12, i2);
                                        i8 = i6;
                                        i9 = i4;
                                        view4 = view3;
                                        i6 = c3287b2.f8623a;
                                        view2 = childAt;
                                    }
                                    childCount += i5;
                                    findContainingItemView = view5;
                                    i4 = i10;
                                    c0709p2 = c0709p;
                                    c0715u2 = c0715u;
                                }
                            }
                        }
                        i6 = i8;
                        i4 = i9;
                        obj = null;
                        if (obj != null) {
                            if (childAt.hasFocusable()) {
                                i7 = Math.min(i13, i3) - Math.max(i12, i2);
                                i8 = i6;
                                i9 = i4;
                                view4 = view3;
                                i6 = c3287b2.f8623a;
                                view2 = childAt;
                            } else {
                                view4 = childAt;
                                i8 = Math.min(i13, i3) - Math.max(i12, i2);
                                i9 = c3287b2.f8623a;
                                i6 = i11;
                            }
                            childCount += i5;
                            findContainingItemView = view5;
                            i4 = i10;
                            c0709p2 = c0709p;
                            c0715u2 = c0715u;
                        }
                    }
                    i11 = i6;
                    view3 = view4;
                    i6 = i8;
                    i4 = i9;
                    obj = null;
                    if (obj != null) {
                        if (childAt.hasFocusable()) {
                            view4 = childAt;
                            i8 = Math.min(i13, i3) - Math.max(i12, i2);
                            i9 = c3287b2.f8623a;
                            i6 = i11;
                        } else {
                            i7 = Math.min(i13, i3) - Math.max(i12, i2);
                            i8 = i6;
                            i9 = i4;
                            view4 = view3;
                            i6 = c3287b2.f8623a;
                            view2 = childAt;
                        }
                        childCount += i5;
                        findContainingItemView = view5;
                        i4 = i10;
                        c0709p2 = c0709p;
                        c0715u2 = c0715u;
                    }
                }
                i11 = i6;
                view3 = view4;
                i6 = i8;
                i4 = i9;
                obj = 1;
                if (obj != null) {
                    if (childAt.hasFocusable()) {
                        i7 = Math.min(i13, i3) - Math.max(i12, i2);
                        i8 = i6;
                        i9 = i4;
                        view4 = view3;
                        i6 = c3287b2.f8623a;
                        view2 = childAt;
                    } else {
                        view4 = childAt;
                        i8 = Math.min(i13, i3) - Math.max(i12, i2);
                        i9 = c3287b2.f8623a;
                        i6 = i11;
                    }
                    childCount += i5;
                    findContainingItemView = view5;
                    i4 = i10;
                    c0709p2 = c0709p;
                    c0715u2 = c0715u;
                }
            } else if (view2 != null) {
                break;
            } else {
                view5 = findContainingItemView;
                i11 = i6;
                view3 = view4;
                i10 = i4;
                i6 = i8;
                i4 = i9;
            }
            i8 = i6;
            i9 = i4;
            i6 = i11;
            view4 = view3;
            childCount += i5;
            findContainingItemView = view5;
            i4 = i10;
            c0709p2 = c0709p;
            c0715u2 = c0715u;
        }
        view3 = view4;
        if (view2 == null) {
            view2 = view3;
        }
        return view2;
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f12045a;
    }
}
