package android.support.design.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.C0140a.C0132c;
import android.support.design.C0140a.C0139j;
import android.support.design.widget.CoordinatorLayout.C0150b;
import android.support.v4.p028d.C0384a;
import android.support.v4.view.C0487a;
import android.support.v4.view.C0517s;
import android.support.v4.widget.C0579u;
import android.support.v4.widget.C0579u.C0578a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends C0150b<V> {
    /* renamed from: a */
    int f7972a;
    /* renamed from: b */
    int f7973b;
    /* renamed from: c */
    boolean f7974c;
    /* renamed from: d */
    int f7975d = 4;
    /* renamed from: e */
    C0579u f7976e;
    /* renamed from: f */
    int f7977f;
    /* renamed from: g */
    WeakReference<V> f7978g;
    /* renamed from: h */
    WeakReference<View> f7979h;
    /* renamed from: i */
    int f7980i;
    /* renamed from: j */
    boolean f7981j;
    /* renamed from: k */
    private float f7982k;
    /* renamed from: l */
    private int f7983l;
    /* renamed from: m */
    private boolean f7984m;
    /* renamed from: n */
    private int f7985n;
    /* renamed from: o */
    private boolean f7986o;
    /* renamed from: p */
    private boolean f7987p;
    /* renamed from: q */
    private int f7988q;
    /* renamed from: r */
    private boolean f7989r;
    /* renamed from: s */
    private C0146a f7990s;
    /* renamed from: t */
    private VelocityTracker f7991t;
    /* renamed from: u */
    private int f7992u;
    /* renamed from: v */
    private final C0578a f7993v = new C31211(this);

    /* renamed from: android.support.design.widget.BottomSheetBehavior$a */
    public static abstract class C0146a {
        /* renamed from: a */
        public abstract void m309a(View view, float f);

        /* renamed from: a */
        public abstract void m310a(View view, int i);
    }

    /* renamed from: android.support.design.widget.BottomSheetBehavior$c */
    private class C0148c implements Runnable {
        /* renamed from: a */
        final /* synthetic */ BottomSheetBehavior f330a;
        /* renamed from: b */
        private final View f331b;
        /* renamed from: c */
        private final int f332c;

        C0148c(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
            this.f330a = bottomSheetBehavior;
            this.f331b = view;
            this.f332c = i;
        }

        public void run() {
            if (this.f330a.f7976e == null || !this.f330a.f7976e.m1946a(true)) {
                this.f330a.m9186b(this.f332c);
            } else {
                C0517s.m1697a(this.f331b, (Runnable) this);
            }
        }
    }

    /* renamed from: android.support.design.widget.BottomSheetBehavior$1 */
    class C31211 extends C0578a {
        /* renamed from: a */
        final /* synthetic */ BottomSheetBehavior f7970a;

        C31211(BottomSheetBehavior bottomSheetBehavior) {
            this.f7970a = bottomSheetBehavior;
        }

        /* renamed from: a */
        public boolean mo51a(View view, int i) {
            boolean z = true;
            if (this.f7970a.f7975d == 1 || this.f7970a.f7981j) {
                return false;
            }
            if (this.f7970a.f7975d == 3 && this.f7970a.f7980i == i) {
                View view2 = (View) this.f7970a.f7979h.get();
                if (!(view2 == null || view2.canScrollVertically(-1) == 0)) {
                    return false;
                }
            }
            if (this.f7970a.f7978g == 0 || this.f7970a.f7978g.get() != view) {
                z = false;
            }
            return z;
        }

        /* renamed from: a */
        public void mo50a(View view, int i, int i2, int i3, int i4) {
            this.f7970a.m9189c(i2);
        }

        /* renamed from: a */
        public void mo48a(int i) {
            if (i == 1) {
                this.f7970a.m9186b(1);
            }
        }

        /* renamed from: a */
        public void mo49a(View view, float f, float f2) {
            int i;
            int i2 = 3;
            if (f2 < 0.0f) {
                i = this.f7970a.f7972a;
            } else if (this.f7970a.f7974c && this.f7970a.m9184a(view, f2)) {
                i = this.f7970a.f7977f;
                i2 = 5;
            } else {
                int i3;
                if (f2 == 0.0f) {
                    f2 = view.getTop();
                    if (Math.abs(f2 - this.f7970a.f7972a) < Math.abs(f2 - this.f7970a.f7973b)) {
                        i = this.f7970a.f7972a;
                    } else {
                        i3 = this.f7970a.f7973b;
                    }
                } else {
                    i3 = this.f7970a.f7973b;
                }
                i = i3;
                i2 = 4;
            }
            if (this.f7970a.f7976e.m1943a(view.getLeft(), i) != null) {
                this.f7970a.m9186b((int) 2.8E-45f);
                C0517s.m1697a(view, new C0148c(this.f7970a, view, i2));
                return;
            }
            this.f7970a.m9186b(i2);
        }

        /* renamed from: a */
        public int mo47a(View view, int i, int i2) {
            return C0384a.m1163a(i, this.f7970a.f7972a, this.f7970a.f7974c != 0 ? this.f7970a.f7977f : this.f7970a.f7973b);
        }

        /* renamed from: b */
        public int mo52b(View view, int i, int i2) {
            return view.getLeft();
        }

        /* renamed from: a */
        public int mo46a(View view) {
            if (this.f7970a.f7974c != null) {
                return this.f7970a.f7977f - this.f7970a.f7972a;
            }
            return this.f7970a.f7973b - this.f7970a.f7972a;
        }
    }

    /* renamed from: android.support.design.widget.BottomSheetBehavior$b */
    protected static class C3122b extends C0487a {
        public static final Creator<C3122b> CREATOR = new C01471();
        /* renamed from: a */
        final int f7971a;

        /* renamed from: android.support.design.widget.BottomSheetBehavior$b$1 */
        static class C01471 implements ClassLoaderCreator<C3122b> {
            C01471() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m311a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m312a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m313a(i);
            }

            /* renamed from: a */
            public C3122b m312a(Parcel parcel, ClassLoader classLoader) {
                return new C3122b(parcel, classLoader);
            }

            /* renamed from: a */
            public C3122b m311a(Parcel parcel) {
                return new C3122b(parcel, null);
            }

            /* renamed from: a */
            public C3122b[] m313a(int i) {
                return new C3122b[i];
            }
        }

        public C3122b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f7971a = parcel.readInt();
        }

        public C3122b(Parcelable parcelable, int i) {
            super(parcelable);
            this.f7971a = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f7971a);
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        attributeSet = context.obtainStyledAttributes(attributeSet, C0139j.BottomSheetBehavior_Layout);
        TypedValue peekValue = attributeSet.peekValue(C0139j.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            m9176a(attributeSet.getDimensionPixelSize(C0139j.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            m9176a(peekValue.data);
        }
        m9179a(attributeSet.getBoolean(C0139j.BottomSheetBehavior_Layout_behavior_hideable, false));
        m9187b(attributeSet.getBoolean(C0139j.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        attributeSet.recycle();
        this.f7982k = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    /* renamed from: b */
    public Parcelable mo59b(CoordinatorLayout coordinatorLayout, V v) {
        return new C3122b(super.mo59b(coordinatorLayout, v), this.f7975d);
    }

    /* renamed from: a */
    public void mo53a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        C3122b c3122b = (C3122b) parcelable;
        super.mo53a(coordinatorLayout, (View) v, c3122b.m1558a());
        if (c3122b.f7971a != 1) {
            if (c3122b.f7971a != 2) {
                this.f7975d = c3122b.f7971a;
                return;
            }
        }
        this.f7975d = 4;
    }

    /* renamed from: a */
    public boolean mo55a(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (C0517s.m1722p(coordinatorLayout) && !C0517s.m1722p(v)) {
            C0517s.m1704b((View) v, true);
        }
        int top = v.getTop();
        coordinatorLayout.m14796a((View) v, i);
        this.f7977f = coordinatorLayout.getHeight();
        if (this.f7984m != 0) {
            if (this.f7985n == 0) {
                this.f7985n = coordinatorLayout.getResources().getDimensionPixelSize(C0132c.design_bottom_sheet_peek_height_min);
            }
            i = Math.max(this.f7985n, this.f7977f - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            i = this.f7983l;
        }
        this.f7972a = Math.max(0, this.f7977f - v.getHeight());
        this.f7973b = Math.max(this.f7977f - i, this.f7972a);
        if (this.f7975d == 3) {
            C0517s.m1707c((View) v, this.f7972a);
        } else if (this.f7974c != 0 && this.f7975d == 5) {
            C0517s.m1707c((View) v, this.f7977f);
        } else if (this.f7975d == 4) {
            C0517s.m1707c((View) v, this.f7973b);
        } else if (this.f7975d == 1 || this.f7975d == 2) {
            C0517s.m1707c((View) v, top - v.getTop());
        }
        if (this.f7976e == 0) {
            this.f7976e = C0579u.m1922a((ViewGroup) coordinatorLayout, this.f7993v);
        }
        this.f7978g = new WeakReference(v);
        this.f7979h = new WeakReference(m9175a((View) v));
        return true;
    }

    /* renamed from: a */
    public boolean mo56a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = false;
        if (v.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                m9173a();
            }
            if (this.f7991t == null) {
                this.f7991t = VelocityTracker.obtain();
            }
            this.f7991t.addMovement(motionEvent);
            if (actionMasked != 3) {
                switch (actionMasked) {
                    case 0:
                        int x = (int) motionEvent.getX();
                        this.f7992u = (int) motionEvent.getY();
                        View view = this.f7979h != null ? (View) this.f7979h.get() : null;
                        if (view != null && coordinatorLayout.m14803a(view, x, this.f7992u)) {
                            this.f7980i = motionEvent.getPointerId(motionEvent.getActionIndex());
                            this.f7981j = true;
                        }
                        v = (this.f7980i == -1 && coordinatorLayout.m14803a((View) v, x, this.f7992u) == null) ? true : null;
                        this.f7987p = v;
                        break;
                    case 1:
                        break;
                    default:
                        break;
                }
            }
            this.f7981j = false;
            this.f7980i = -1;
            if (this.f7987p != null) {
                this.f7987p = false;
                return false;
            }
            if (this.f7987p == null && this.f7976e.m1944a(motionEvent) != null) {
                return true;
            }
            View view2 = (View) this.f7979h.get();
            if (actionMasked == 2 && view2 != null && !this.f7987p && this.f7975d != 1 && coordinatorLayout.m14803a(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) == null && Math.abs(((float) this.f7992u) - motionEvent.getY()) > ((float) this.f7976e.m1956d())) {
                z = true;
            }
            return z;
        }
        this.f7987p = true;
        return false;
    }

    /* renamed from: b */
    public boolean mo60b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (v.isShown() == null) {
            return null;
        }
        coordinatorLayout = motionEvent.getActionMasked();
        if (this.f7975d == 1 && coordinatorLayout == null) {
            return true;
        }
        if (this.f7976e != null) {
            this.f7976e.m1948b(motionEvent);
        }
        if (coordinatorLayout == null) {
            m9173a();
        }
        if (this.f7991t == null) {
            this.f7991t = VelocityTracker.obtain();
        }
        this.f7991t.addMovement(motionEvent);
        if (coordinatorLayout == 2 && this.f7987p == null && Math.abs(((float) this.f7992u) - motionEvent.getY()) > ((float) this.f7976e.m1956d())) {
            this.f7976e.m1942a((View) v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return this.f7987p ^ 1;
    }

    /* renamed from: a */
    public boolean mo58a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.f7988q = 0;
        this.f7989r = false;
        if ((i & 2) != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo54a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view == ((View) this.f7979h.get())) {
            coordinatorLayout = v.getTop();
            i = coordinatorLayout - i2;
            if (i2 > 0) {
                if (i < this.f7972a) {
                    iArr[1] = coordinatorLayout - this.f7972a;
                    C0517s.m1707c((View) v, -iArr[1]);
                    m9186b(3);
                } else {
                    iArr[1] = i2;
                    C0517s.m1707c((View) v, -i2);
                    m9186b(1);
                }
            } else if (i2 < 0 && view.canScrollVertically(-1) == null) {
                if (i > this.f7973b) {
                    if (this.f7974c == null) {
                        iArr[1] = coordinatorLayout - this.f7973b;
                        C0517s.m1707c((View) v, -iArr[1]);
                        m9186b(4);
                    }
                }
                iArr[1] = i2;
                C0517s.m1707c((View) v, -i2);
                m9186b(1);
            }
            m9189c(v.getTop());
            this.f7988q = i2;
            this.f7989r = true;
        }
    }

    /* renamed from: c */
    public void mo61c(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.f7972a) {
            m9186b(3);
            return;
        }
        if (this.f7979h != null && view == this.f7979h.get()) {
            if (this.f7989r != null) {
                int i2;
                if (this.f7988q > null) {
                    i2 = this.f7972a;
                } else if (this.f7974c == null || m9184a(v, m9174b()) == null) {
                    if (this.f7988q == null) {
                        coordinatorLayout = v.getTop();
                        if (Math.abs(coordinatorLayout - this.f7972a) < Math.abs(coordinatorLayout - this.f7973b)) {
                            i2 = this.f7972a;
                        } else {
                            i2 = this.f7973b;
                        }
                    } else {
                        i2 = this.f7973b;
                    }
                    i = 4;
                } else {
                    i2 = this.f7977f;
                    i = 5;
                }
                if (this.f7976e.m1945a((View) v, v.getLeft(), i2) != null) {
                    m9186b(2);
                    C0517s.m1697a((View) v, new C0148c(this, v, i));
                } else {
                    m9186b(i);
                }
                this.f7989r = null;
            }
        }
    }

    /* renamed from: a */
    public boolean mo57a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return (view != this.f7979h.get() || (this.f7975d == 3 && super.mo57a(coordinatorLayout, (View) v, view, f, f2) == null)) ? null : true;
    }

    /* renamed from: a */
    public final void m9176a(int i) {
        boolean z = true;
        if (i != -1) {
            if (!this.f7984m) {
                if (this.f7983l != i) {
                }
            }
            this.f7984m = false;
            this.f7983l = Math.max(0, i);
            this.f7973b = this.f7977f - i;
            if (!z) {
            }
        } else if (this.f7984m == 0) {
            this.f7984m = true;
            if (!z && this.f7975d == 4 && this.f7978g != 0) {
                View view = (View) this.f7978g.get();
                if (view != null) {
                    view.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        z = false;
        if (!z) {
        }
    }

    /* renamed from: a */
    public void m9179a(boolean z) {
        this.f7974c = z;
    }

    /* renamed from: b */
    public void m9187b(boolean z) {
        this.f7986o = z;
    }

    /* renamed from: b */
    void m9186b(int i) {
        if (this.f7975d != i) {
            this.f7975d = i;
            View view = (View) this.f7978g.get();
            if (!(view == null || this.f7990s == null)) {
                this.f7990s.m310a(view, i);
            }
        }
    }

    /* renamed from: a */
    private void m9173a() {
        this.f7980i = -1;
        if (this.f7991t != null) {
            this.f7991t.recycle();
            this.f7991t = null;
        }
    }

    /* renamed from: a */
    boolean m9184a(View view, float f) {
        boolean z = true;
        if (this.f7986o) {
            return true;
        }
        if (view.getTop() < this.f7973b) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (f * 0.1f)) - ((float) this.f7973b)) / ((float) this.f7983l) <= 0.5f) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    View m9175a(View view) {
        if (C0517s.m1727u(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View a = m9175a(viewGroup.getChildAt(i));
                if (a != null) {
                    return a;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private float m9174b() {
        this.f7991t.computeCurrentVelocity(1000, this.f7982k);
        return this.f7991t.getYVelocity(this.f7980i);
    }

    /* renamed from: c */
    void m9189c(int i) {
        View view = (View) this.f7978g.get();
        if (view != null && this.f7990s != null) {
            if (i > this.f7973b) {
                this.f7990s.m309a(view, ((float) (this.f7973b - i)) / ((float) (this.f7977f - this.f7973b)));
            } else {
                this.f7990s.m309a(view, ((float) (this.f7973b - i)) / ((float) (this.f7973b - this.f7972a)));
            }
        }
    }
}
