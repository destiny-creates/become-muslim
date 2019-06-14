package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.C0517s;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

/* compiled from: ViewDragHelper */
/* renamed from: android.support.v4.widget.u */
public class C0579u {
    /* renamed from: v */
    private static final Interpolator f1412v = new C05761();
    /* renamed from: a */
    private int f1413a;
    /* renamed from: b */
    private int f1414b;
    /* renamed from: c */
    private int f1415c = -1;
    /* renamed from: d */
    private float[] f1416d;
    /* renamed from: e */
    private float[] f1417e;
    /* renamed from: f */
    private float[] f1418f;
    /* renamed from: g */
    private float[] f1419g;
    /* renamed from: h */
    private int[] f1420h;
    /* renamed from: i */
    private int[] f1421i;
    /* renamed from: j */
    private int[] f1422j;
    /* renamed from: k */
    private int f1423k;
    /* renamed from: l */
    private VelocityTracker f1424l;
    /* renamed from: m */
    private float f1425m;
    /* renamed from: n */
    private float f1426n;
    /* renamed from: o */
    private int f1427o;
    /* renamed from: p */
    private int f1428p;
    /* renamed from: q */
    private OverScroller f1429q;
    /* renamed from: r */
    private final C0578a f1430r;
    /* renamed from: s */
    private View f1431s;
    /* renamed from: t */
    private boolean f1432t;
    /* renamed from: u */
    private final ViewGroup f1433u;
    /* renamed from: w */
    private final Runnable f1434w = new C05772(this);

    /* compiled from: ViewDragHelper */
    /* renamed from: android.support.v4.widget.u$1 */
    static class C05761 implements Interpolator {
        public float getInterpolation(float f) {
            f -= 1.0f;
            return ((((f * f) * f) * f) * f) + 1.0f;
        }

        C05761() {
        }
    }

    /* compiled from: ViewDragHelper */
    /* renamed from: android.support.v4.widget.u$2 */
    class C05772 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C0579u f1411a;

        C05772(C0579u c0579u) {
            this.f1411a = c0579u;
        }

        public void run() {
            this.f1411a.m1954c(0);
        }
    }

    /* compiled from: ViewDragHelper */
    /* renamed from: android.support.v4.widget.u$a */
    public static abstract class C0578a {
        /* renamed from: a */
        public int mo46a(View view) {
            return 0;
        }

        /* renamed from: a */
        public int mo47a(View view, int i, int i2) {
            return 0;
        }

        /* renamed from: a */
        public void mo48a(int i) {
        }

        /* renamed from: a */
        public void mo337a(int i, int i2) {
        }

        /* renamed from: a */
        public void mo49a(View view, float f, float f2) {
        }

        /* renamed from: a */
        public void mo50a(View view, int i, int i2, int i3, int i4) {
        }

        /* renamed from: a */
        public abstract boolean mo51a(View view, int i);

        /* renamed from: b */
        public int mo74b(View view) {
            return 0;
        }

        /* renamed from: b */
        public int mo52b(View view, int i, int i2) {
            return 0;
        }

        /* renamed from: b */
        public void mo338b(int i, int i2) {
        }

        /* renamed from: b */
        public void mo75b(View view, int i) {
        }

        /* renamed from: b */
        public boolean mo339b(int i) {
            return false;
        }

        /* renamed from: c */
        public int m1917c(int i) {
            return i;
        }
    }

    /* renamed from: a */
    public static C0579u m1922a(ViewGroup viewGroup, C0578a c0578a) {
        return new C0579u(viewGroup.getContext(), viewGroup, c0578a);
    }

    /* renamed from: a */
    public static C0579u m1921a(ViewGroup viewGroup, float f, C0578a c0578a) {
        viewGroup = C0579u.m1922a(viewGroup, c0578a);
        viewGroup.f1414b = (int) (((float) viewGroup.f1414b) * (1.0f / f));
        return viewGroup;
    }

    private C0579u(Context context, ViewGroup viewGroup, C0578a c0578a) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (c0578a != null) {
            this.f1433u = viewGroup;
            this.f1430r = c0578a;
            viewGroup = ViewConfiguration.get(context);
            this.f1427o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f1414b = viewGroup.getScaledTouchSlop();
            this.f1425m = (float) viewGroup.getScaledMaximumFlingVelocity();
            this.f1426n = (float) viewGroup.getScaledMinimumFlingVelocity();
            this.f1429q = new OverScroller(context, f1412v);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    /* renamed from: a */
    public void m1940a(float f) {
        this.f1426n = f;
    }

    /* renamed from: a */
    public int m1939a() {
        return this.f1413a;
    }

    /* renamed from: a */
    public void m1941a(int i) {
        this.f1428p = i;
    }

    /* renamed from: b */
    public int m1947b() {
        return this.f1427o;
    }

    /* renamed from: a */
    public void m1942a(View view, int i) {
        if (view.getParent() == this.f1433u) {
            this.f1431s = view;
            this.f1415c = i;
            this.f1430r.mo75b(view, i);
            m1954c(1);
            return;
        }
        i = new StringBuilder();
        i.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        i.append(this.f1433u);
        i.append(")");
        throw new IllegalArgumentException(i.toString());
    }

    /* renamed from: c */
    public View m1953c() {
        return this.f1431s;
    }

    /* renamed from: d */
    public int m1956d() {
        return this.f1414b;
    }

    /* renamed from: e */
    public void m1959e() {
        this.f1415c = -1;
        m1935f();
        if (this.f1424l != null) {
            this.f1424l.recycle();
            this.f1424l = null;
        }
    }

    /* renamed from: a */
    public boolean m1945a(View view, int i, int i2) {
        this.f1431s = view;
        this.f1415c = -1;
        view = m1926a(i, i2, 0, 0);
        if (view == null && this.f1413a == 0 && this.f1431s != 0) {
            this.f1431s = 0;
        }
        return view;
    }

    /* renamed from: a */
    public boolean m1943a(int i, int i2) {
        if (this.f1432t) {
            return m1926a(i, i2, (int) this.f1424l.getXVelocity(this.f1415c), (int) this.f1424l.getYVelocity(this.f1415c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* renamed from: a */
    private boolean m1926a(int i, int i2, int i3, int i4) {
        int left = this.f1431s.getLeft();
        int top = this.f1431s.getTop();
        i -= left;
        i2 -= top;
        if (i == 0 && i2 == 0) {
            this.f1429q.abortAnimation();
            m1954c(0);
            return false;
        }
        this.f1429q.startScroll(left, top, i, i2, m1920a(this.f1431s, i, i2, i3, i4));
        m1954c(2);
        return true;
    }

    /* renamed from: a */
    private int m1920a(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        i3 = m1929b(i3, (int) this.f1426n, (int) this.f1425m);
        i4 = m1929b(i4, (int) this.f1426n, (int) this.f1425m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(i3);
        int abs4 = Math.abs(i4);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (i3 != 0) {
            f = (float) abs3;
            f2 = (float) i5;
        } else {
            f = (float) abs;
            f2 = (float) i6;
        }
        f /= f2;
        if (i4 != 0) {
            f3 = (float) abs4;
            f2 = (float) i5;
        } else {
            f3 = (float) abs2;
            f2 = (float) i6;
        }
        f3 /= f2;
        return (int) ((((float) m1919a(i, i3, this.f1430r.mo74b(view))) * f) + (((float) m1919a(i2, i4, this.f1430r.mo46a(view))) * f3));
    }

    /* renamed from: a */
    private int m1919a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f1433u.getWidth();
        float f = (float) (width / 2);
        f += m1928b(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * f;
        i2 = Math.abs(i2);
        if (i2 > 0) {
            i = Math.round(Math.abs(f / ((float) i2)) * 1148846080) * 4;
        } else {
            i = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1065353216) * 1132462080);
        }
        return Math.min(i, 600);
    }

    /* renamed from: b */
    private int m1929b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            i3 = -i3;
        }
        return i3;
    }

    /* renamed from: a */
    private float m1918a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            f3 = -f3;
        }
        return f3;
    }

    /* renamed from: b */
    private float m1928b(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    /* renamed from: a */
    public boolean m1946a(boolean z) {
        if (this.f1413a == 2) {
            boolean computeScrollOffset = this.f1429q.computeScrollOffset();
            int currX = this.f1429q.getCurrX();
            int currY = this.f1429q.getCurrY();
            int left = currX - this.f1431s.getLeft();
            int top = currY - this.f1431s.getTop();
            if (left != 0) {
                C0517s.m1710d(this.f1431s, left);
            }
            if (top != 0) {
                C0517s.m1707c(this.f1431s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f1430r.mo50a(this.f1431s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f1429q.getFinalX() && currY == this.f1429q.getFinalY()) {
                this.f1429q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.f1433u.post(this.f1434w);
                } else {
                    m1954c(0);
                }
            }
        }
        if (this.f1413a) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m1923a(float f, float f2) {
        this.f1432t = true;
        this.f1430r.mo49a(this.f1431s, f, f2);
        this.f1432t = false;
        if (this.f1413a == Float.MIN_VALUE) {
            m1954c(0);
        }
    }

    /* renamed from: f */
    private void m1935f() {
        if (this.f1416d != null) {
            Arrays.fill(this.f1416d, 0.0f);
            Arrays.fill(this.f1417e, 0.0f);
            Arrays.fill(this.f1418f, 0.0f);
            Arrays.fill(this.f1419g, 0.0f);
            Arrays.fill(this.f1420h, 0);
            Arrays.fill(this.f1421i, 0);
            Arrays.fill(this.f1422j, 0);
            this.f1423k = 0;
        }
    }

    /* renamed from: e */
    private void m1934e(int i) {
        if (this.f1416d != null) {
            if (m1949b(i)) {
                this.f1416d[i] = 0.0f;
                this.f1417e[i] = 0.0f;
                this.f1418f[i] = 0.0f;
                this.f1419g[i] = 0.0f;
                this.f1420h[i] = 0;
                this.f1421i[i] = 0;
                this.f1422j[i] = 0;
                this.f1423k = (~(1 << i)) & this.f1423k;
            }
        }
    }

    /* renamed from: f */
    private void m1936f(int i) {
        if (this.f1416d == null || this.f1416d.length <= i) {
            i++;
            Object obj = new float[i];
            Object obj2 = new float[i];
            Object obj3 = new float[i];
            Object obj4 = new float[i];
            Object obj5 = new int[i];
            Object obj6 = new int[i];
            i = new int[i];
            if (this.f1416d != null) {
                System.arraycopy(this.f1416d, 0, obj, 0, this.f1416d.length);
                System.arraycopy(this.f1417e, 0, obj2, 0, this.f1417e.length);
                System.arraycopy(this.f1418f, 0, obj3, 0, this.f1418f.length);
                System.arraycopy(this.f1419g, 0, obj4, 0, this.f1419g.length);
                System.arraycopy(this.f1420h, 0, obj5, 0, this.f1420h.length);
                System.arraycopy(this.f1421i, 0, obj6, 0, this.f1421i.length);
                System.arraycopy(this.f1422j, 0, i, 0, this.f1422j.length);
            }
            this.f1416d = obj;
            this.f1417e = obj2;
            this.f1418f = obj3;
            this.f1419g = obj4;
            this.f1420h = obj5;
            this.f1421i = obj6;
            this.f1422j = i;
        }
    }

    /* renamed from: a */
    private void m1924a(float f, float f2, int i) {
        m1936f(i);
        float[] fArr = this.f1416d;
        this.f1418f[i] = f;
        fArr[i] = f;
        fArr = this.f1417e;
        this.f1419g[i] = f2;
        fArr[i] = f2;
        this.f1420h[i] = m1933e((int) f, (int) f2);
        this.f1423k |= Float.MIN_VALUE << i;
    }

    /* renamed from: c */
    private void m1932c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (m1938g(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f1418f[pointerId] = x;
                this.f1419g[pointerId] = y;
            }
        }
    }

    /* renamed from: b */
    public boolean m1949b(int i) {
        return ((1 << i) & this.f1423k) != 0;
    }

    /* renamed from: c */
    void m1954c(int i) {
        this.f1433u.removeCallbacks(this.f1434w);
        if (this.f1413a != i) {
            this.f1413a = i;
            this.f1430r.mo48a(i);
            if (this.f1413a == 0) {
                this.f1431s = 0;
            }
        }
    }

    /* renamed from: b */
    boolean m1951b(View view, int i) {
        if (view == this.f1431s && this.f1415c == i) {
            return true;
        }
        if (view == null || !this.f1430r.mo51a(view, i)) {
            return null;
        }
        this.f1415c = i;
        m1942a(view, i);
        return true;
    }

    /* renamed from: a */
    public boolean m1944a(MotionEvent motionEvent) {
        boolean z;
        C0579u c0579u = this;
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m1959e();
        }
        if (c0579u.f1424l == null) {
            c0579u.f1424l = VelocityTracker.obtain();
        }
        c0579u.f1424l.addMovement(motionEvent2);
        int pointerId;
        float x;
        switch (actionMasked) {
            case 0:
                float x2 = motionEvent.getX();
                float y = motionEvent.getY();
                z = false;
                pointerId = motionEvent2.getPointerId(0);
                m1924a(x2, y, pointerId);
                View d = m1957d((int) x2, (int) y);
                if (d == c0579u.f1431s && c0579u.f1413a == 2) {
                    m1951b(d, pointerId);
                }
                actionMasked = c0579u.f1420h[pointerId];
                if ((c0579u.f1428p & actionMasked) != 0) {
                    c0579u.f1430r.mo337a(actionMasked & c0579u.f1428p, pointerId);
                    break;
                }
                break;
            case 1:
            case 3:
                m1959e();
                break;
            case 2:
                if (c0579u.f1416d != null) {
                    if (c0579u.f1417e == null) {
                        break;
                    }
                    actionMasked = motionEvent.getPointerCount();
                    for (actionIndex = 0; actionIndex < actionMasked; actionIndex++) {
                        int pointerId2 = motionEvent2.getPointerId(actionIndex);
                        if (m1938g(pointerId2)) {
                            x = motionEvent2.getX(actionIndex);
                            float y2 = motionEvent2.getY(actionIndex);
                            float f = x - c0579u.f1416d[pointerId2];
                            float f2 = y2 - c0579u.f1417e[pointerId2];
                            View d2 = m1957d((int) x, (int) y2);
                            Object obj = (d2 == null || !m1927a(d2, f, f2)) ? null : 1;
                            if (obj != null) {
                                int left = d2.getLeft();
                                int i = (int) f;
                                i = c0579u.f1430r.mo52b(d2, left + i, i);
                                int top = d2.getTop();
                                int i2 = (int) f2;
                                int a = c0579u.f1430r.mo47a(d2, top + i2, i2);
                                i2 = c0579u.f1430r.mo74b(d2);
                                int a2 = c0579u.f1430r.mo46a(d2);
                                if (i2 == 0 || (i2 > 0 && i == left)) {
                                    if (a2 != 0) {
                                        if (a2 > 0 && a == top) {
                                        }
                                    }
                                    m1932c(motionEvent);
                                    break;
                                }
                            }
                            m1930b(f, f2, pointerId2);
                            if (c0579u.f1413a != 1) {
                                if (obj != null && m1951b(d2, pointerId2)) {
                                }
                            }
                            m1932c(motionEvent);
                        }
                    }
                    m1932c(motionEvent);
                }
                break;
            case 5:
                actionMasked = motionEvent2.getPointerId(actionIndex);
                x = motionEvent2.getX(actionIndex);
                float y3 = motionEvent2.getY(actionIndex);
                m1924a(x, y3, actionMasked);
                if (c0579u.f1413a != 0) {
                    if (c0579u.f1413a == 2) {
                        View d3 = m1957d((int) x, (int) y3);
                        if (d3 == c0579u.f1431s) {
                            m1951b(d3, actionMasked);
                            break;
                        }
                    }
                }
                pointerId = c0579u.f1420h[actionMasked];
                if ((c0579u.f1428p & pointerId) != 0) {
                    c0579u.f1430r.mo337a(pointerId & c0579u.f1428p, actionMasked);
                    break;
                }
                break;
            case 6:
                m1934e(motionEvent2.getPointerId(actionIndex));
                break;
        }
        z = false;
        return c0579u.f1413a == 1 ? true : z;
    }

    /* renamed from: b */
    public void m1948b(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m1959e();
        }
        if (this.f1424l == null) {
            this.f1424l = VelocityTracker.obtain();
        }
        this.f1424l.addMovement(motionEvent);
        int i = 0;
        float y;
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                y = motionEvent.getY();
                int pointerId = motionEvent.getPointerId(0);
                View d = m1957d((int) x, (int) y);
                m1924a(x, y, pointerId);
                m1951b(d, pointerId);
                actionMasked = this.f1420h[pointerId];
                if ((this.f1428p & actionMasked) != 0) {
                    this.f1430r.mo337a(actionMasked & this.f1428p, pointerId);
                    return;
                }
                return;
            case 1:
                if (this.f1413a == 1) {
                    m1937g();
                }
                m1959e();
                return;
            case 2:
                if (this.f1413a != 1) {
                    actionMasked = motionEvent.getPointerCount();
                    while (i < actionMasked) {
                        actionIndex = motionEvent.getPointerId(i);
                        if (m1938g(actionIndex)) {
                            float x2 = motionEvent.getX(i);
                            float y2 = motionEvent.getY(i);
                            float f = x2 - this.f1416d[actionIndex];
                            float f2 = y2 - this.f1417e[actionIndex];
                            m1930b(f, f2, actionIndex);
                            if (this.f1413a != 1) {
                                View d2 = m1957d((int) x2, (int) y2);
                                if (m1927a(d2, f, f2) && m1951b(d2, actionIndex)) {
                                }
                            }
                            m1932c(motionEvent);
                            return;
                        }
                        i++;
                    }
                    m1932c(motionEvent);
                    return;
                } else if (m1938g(this.f1415c)) {
                    actionMasked = motionEvent.findPointerIndex(this.f1415c);
                    y = motionEvent.getX(actionMasked);
                    actionIndex = (int) (y - this.f1418f[this.f1415c]);
                    actionMasked = (int) (motionEvent.getY(actionMasked) - this.f1419g[this.f1415c]);
                    m1931b(this.f1431s.getLeft() + actionIndex, this.f1431s.getTop() + actionMasked, actionIndex, actionMasked);
                    m1932c(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.f1413a == 1) {
                    m1923a(0.0f, 0.0f);
                }
                m1959e();
                return;
            case 5:
                actionMasked = motionEvent.getPointerId(actionIndex);
                float x3 = motionEvent.getX(actionIndex);
                float y3 = motionEvent.getY(actionIndex);
                m1924a(x3, y3, actionMasked);
                if (this.f1413a == 0) {
                    m1951b(m1957d((int) x3, (int) y3), actionMasked);
                    motionEvent = this.f1420h[actionMasked];
                    if ((this.f1428p & motionEvent) != 0) {
                        this.f1430r.mo337a(motionEvent & this.f1428p, actionMasked);
                        return;
                    }
                    return;
                } else if (m1955c((int) x3, (int) y3) != null) {
                    m1951b(this.f1431s, actionMasked);
                    return;
                } else {
                    return;
                }
            case 6:
                actionMasked = motionEvent.getPointerId(actionIndex);
                if (this.f1413a == 1 && actionMasked == this.f1415c) {
                    actionIndex = motionEvent.getPointerCount();
                    while (i < actionIndex) {
                        int pointerId2 = motionEvent.getPointerId(i);
                        if (pointerId2 != this.f1415c) {
                            if (m1957d((int) motionEvent.getX(i), (int) motionEvent.getY(i)) == this.f1431s && m1951b(this.f1431s, pointerId2)) {
                                motionEvent = this.f1415c;
                                if (motionEvent == -1) {
                                    m1937g();
                                }
                            }
                        }
                        i++;
                    }
                    motionEvent = -1;
                    if (motionEvent == -1) {
                        m1937g();
                    }
                }
                m1934e(actionMasked);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private void m1930b(float f, float f2, int i) {
        int i2 = 1;
        if (!m1925a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m1925a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m1925a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m1925a(f2, f, i, 8) != null) {
            i2 |= 8;
        }
        if (i2 != 0) {
            f = this.f1421i;
            f[i] = f[i] | i2;
            this.f1430r.mo338b(i2, i);
        }
    }

    /* renamed from: a */
    private boolean m1925a(float f, float f2, int i, int i2) {
        f = Math.abs(f);
        f2 = Math.abs(f2);
        boolean z = false;
        if (!((this.f1420h[i] & i2) != i2 || (this.f1428p & i2) == 0 || (this.f1422j[i] & i2) == i2 || (this.f1421i[i] & i2) == i2)) {
            if (f > ((float) this.f1414b) || f2 > ((float) this.f1414b)) {
                if (f >= f2 * 0.5f || this.f1430r.mo339b(i2) == null) {
                    if ((this.f1421i[i] & i2) == null && f > ((float) this.f1414b)) {
                        z = true;
                    }
                    return z;
                }
                f = this.f1422j;
                f[i] = f[i] | i2;
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m1927a(View view, float f, float f2) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        Object obj = this.f1430r.mo74b(view) > 0 ? 1 : null;
        view = this.f1430r.mo46a(view) > null ? true : null;
        if (obj != null && view != null) {
            if ((f * f) + (f2 * f2) > ((float) (this.f1414b * this.f1414b))) {
                z = true;
            }
            return z;
        } else if (obj != null) {
            if (Math.abs(f) > ((float) this.f1414b)) {
                z = true;
            }
            return z;
        } else if (view == null) {
            return false;
        } else {
            if (Math.abs(f2) > ((float) this.f1414b)) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: d */
    public boolean m1958d(int i) {
        int length = this.f1416d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m1950b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean m1950b(int i, int i2) {
        boolean z = false;
        if (!m1949b(i2)) {
            return false;
        }
        Object obj = (i & 1) == 1 ? 1 : null;
        i = (i & 2) == 2 ? 1 : 0;
        float f = this.f1418f[i2] - this.f1416d[i2];
        float f2 = this.f1419g[i2] - this.f1417e[i2];
        if (obj != null && i != 0) {
            if ((f * f) + (f2 * f2) > ((float) (this.f1414b * this.f1414b))) {
                z = true;
            }
            return z;
        } else if (obj != null) {
            if (Math.abs(f) > ((float) this.f1414b)) {
                z = true;
            }
            return z;
        } else if (i == 0) {
            return false;
        } else {
            if (Math.abs(f2) > ((float) this.f1414b)) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: g */
    private void m1937g() {
        this.f1424l.computeCurrentVelocity(1000, this.f1425m);
        m1923a(m1918a(this.f1424l.getXVelocity(this.f1415c), this.f1426n, this.f1425m), m1918a(this.f1424l.getYVelocity(this.f1415c), this.f1426n, this.f1425m));
    }

    /* renamed from: b */
    private void m1931b(int i, int i2, int i3, int i4) {
        int left = this.f1431s.getLeft();
        int top = this.f1431s.getTop();
        if (i3 != 0) {
            i = this.f1430r.mo52b(this.f1431s, i, i3);
            C0517s.m1710d(this.f1431s, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.f1430r.mo47a(this.f1431s, i2, i4);
            C0517s.m1707c(this.f1431s, i2 - top);
        }
        int i6 = i2;
        if (i3 != 0 || i4 != 0) {
            this.f1430r.mo50a(this.f1431s, i5, i6, i5 - left, i6 - top);
        }
    }

    /* renamed from: c */
    public boolean m1955c(int i, int i2) {
        return m1952b(this.f1431s, i, i2);
    }

    /* renamed from: b */
    public boolean m1952b(View view, int i, int i2) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        if (i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            z = true;
        }
        return z;
    }

    /* renamed from: d */
    public View m1957d(int i, int i2) {
        for (int childCount = this.f1433u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f1433u.getChildAt(this.f1430r.m1917c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return 0;
    }

    /* renamed from: e */
    private int m1933e(int i, int i2) {
        int i3 = i < this.f1433u.getLeft() + this.f1427o ? 1 : 0;
        if (i2 < this.f1433u.getTop() + this.f1427o) {
            i3 |= 4;
        }
        if (i > this.f1433u.getRight() - this.f1427o) {
            i3 |= 2;
        }
        return i2 > this.f1433u.getBottom() - this.f1427o ? i3 | 8 : i3;
    }

    /* renamed from: g */
    private boolean m1938g(int i) {
        if (m1949b(i)) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ignoring pointerId=");
        stringBuilder.append(i);
        stringBuilder.append(" because ACTION_DOWN was not received ");
        stringBuilder.append("for this pointer before ACTION_MOVE. It likely happened because ");
        stringBuilder.append(" ViewDragHelper did not receive all the events in the event stream.");
        Log.e("ViewDragHelper", stringBuilder.toString());
        return false;
    }
}
