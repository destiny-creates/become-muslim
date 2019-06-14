package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.p014b.C0097a.C0094a;
import android.support.p014b.C0097a.C0095b;
import android.support.p014b.C0097a.C0096c;
import android.support.v4.content.C0366b;
import android.support.v4.p020a.p021a.C0259a;
import android.support.v4.p028d.C0384a;
import android.support.v4.util.C0460i;
import android.support.v4.util.Pools.C0447a;
import android.support.v4.util.Pools.C4463b;
import android.support.v4.view.C0487a;
import android.support.v4.view.C0501e;
import android.support.v4.view.C0511o;
import android.support.v4.view.C0512p;
import android.support.v4.view.C0517s;
import android.support.v4.view.C3227n;
import android.support.v4.view.aa;
import android.support.v4.widget.C0547h;
import android.support.v4.widget.C0580v;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.facebook.imageutils.JfifUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements C3227n {
    /* renamed from: a */
    static final String f11850a;
    /* renamed from: b */
    static final Class<?>[] f11851b = new Class[]{Context.class, AttributeSet.class};
    /* renamed from: c */
    static final ThreadLocal<Map<String, Constructor<C0150b>>> f11852c = new ThreadLocal();
    /* renamed from: d */
    static final Comparator<View> f11853d;
    /* renamed from: f */
    private static final C0447a<Rect> f11854f = new C4463b(12);
    /* renamed from: e */
    OnHierarchyChangeListener f11855e;
    /* renamed from: g */
    private final List<View> f11856g;
    /* renamed from: h */
    private final C0547h<View> f11857h;
    /* renamed from: i */
    private final List<View> f11858i;
    /* renamed from: j */
    private final List<View> f11859j;
    /* renamed from: k */
    private final int[] f11860k;
    /* renamed from: l */
    private Paint f11861l;
    /* renamed from: m */
    private boolean f11862m;
    /* renamed from: n */
    private boolean f11863n;
    /* renamed from: o */
    private int[] f11864o;
    /* renamed from: p */
    private View f11865p;
    /* renamed from: q */
    private View f11866q;
    /* renamed from: r */
    private C0154f f11867r;
    /* renamed from: s */
    private boolean f11868s;
    /* renamed from: t */
    private aa f11869t;
    /* renamed from: u */
    private boolean f11870u;
    /* renamed from: v */
    private Drawable f11871v;
    /* renamed from: w */
    private C0512p f11872w;
    /* renamed from: x */
    private final C0511o f11873x;

    /* renamed from: android.support.design.widget.CoordinatorLayout$a */
    public interface C0149a {
        /* renamed from: a */
        C0150b m314a();
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$b */
    public static abstract class C0150b<V extends View> {
        /* renamed from: a */
        public aa m315a(CoordinatorLayout coordinatorLayout, V v, aa aaVar) {
            return aaVar;
        }

        /* renamed from: a */
        public void mo66a(C0153e c0153e) {
        }

        /* renamed from: a */
        public void mo53a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        /* renamed from: a */
        public void m319a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        /* renamed from: a */
        public void mo54a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        /* renamed from: a */
        public boolean mo55a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        /* renamed from: a */
        public boolean mo2648a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        /* renamed from: a */
        public boolean mo67a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        /* renamed from: a */
        public boolean mo3321a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        /* renamed from: a */
        public boolean mo56a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        /* renamed from: a */
        public boolean mo3322a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        /* renamed from: a */
        public boolean mo57a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        /* renamed from: a */
        public boolean m330a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        @Deprecated
        /* renamed from: a */
        public boolean mo58a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        @Deprecated
        /* renamed from: b */
        public void m334b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        /* renamed from: b */
        public boolean mo60b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        /* renamed from: b */
        public boolean mo68b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        /* renamed from: c */
        public int m338c(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        /* renamed from: c */
        public void m339c() {
        }

        @Deprecated
        /* renamed from: c */
        public void mo61c(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        /* renamed from: d */
        public float m341d(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        /* renamed from: d */
        public void m342d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public C0150b(Context context, AttributeSet attributeSet) {
        }

        /* renamed from: e */
        public boolean m343e(CoordinatorLayout coordinatorLayout, V v) {
            return m341d(coordinatorLayout, v) > null ? true : null;
        }

        /* renamed from: a */
        public boolean mo3316a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            return i2 == 0 ? mo58a(coordinatorLayout, (View) v, view, view2, i) : null;
        }

        /* renamed from: b */
        public void m335b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                m334b(coordinatorLayout, v, view, view2, i);
            }
        }

        /* renamed from: a */
        public void mo3312a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                mo61c(coordinatorLayout, v, view);
            }
        }

        /* renamed from: a */
        public void mo3313a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                m319a(coordinatorLayout, (View) v, view, i, i2, i3, i4);
            }
        }

        /* renamed from: a */
        public void mo3314a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                mo54a(coordinatorLayout, (View) v, view, i, i2, iArr);
            }
        }

        /* renamed from: b */
        public Parcelable mo59b(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: android.support.design.widget.CoordinatorLayout$c */
    public @interface C0151c {
        /* renamed from: a */
        Class<? extends C0150b> m344a();
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$d */
    private class C0152d implements OnHierarchyChangeListener {
        /* renamed from: a */
        final /* synthetic */ CoordinatorLayout f333a;

        C0152d(CoordinatorLayout coordinatorLayout) {
            this.f333a = coordinatorLayout;
        }

        public void onChildViewAdded(View view, View view2) {
            if (this.f333a.f11855e != null) {
                this.f333a.f11855e.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            this.f333a.m14795a(2);
            if (this.f333a.f11855e != null) {
                this.f333a.f11855e.onChildViewRemoved(view, view2);
            }
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$e */
    public static class C0153e extends MarginLayoutParams {
        /* renamed from: a */
        C0150b f334a;
        /* renamed from: b */
        boolean f335b = false;
        /* renamed from: c */
        public int f336c = 0;
        /* renamed from: d */
        public int f337d = 0;
        /* renamed from: e */
        public int f338e = -1;
        /* renamed from: f */
        int f339f = -1;
        /* renamed from: g */
        public int f340g = 0;
        /* renamed from: h */
        public int f341h = 0;
        /* renamed from: i */
        int f342i;
        /* renamed from: j */
        int f343j;
        /* renamed from: k */
        View f344k;
        /* renamed from: l */
        View f345l;
        /* renamed from: m */
        final Rect f346m = new Rect();
        /* renamed from: n */
        Object f347n;
        /* renamed from: o */
        private boolean f348o;
        /* renamed from: p */
        private boolean f349p;
        /* renamed from: q */
        private boolean f350q;
        /* renamed from: r */
        private boolean f351r;

        public C0153e(int i, int i2) {
            super(i, i2);
        }

        C0153e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0096c.CoordinatorLayout_Layout);
            this.f336c = obtainStyledAttributes.getInteger(C0096c.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f339f = obtainStyledAttributes.getResourceId(C0096c.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f337d = obtainStyledAttributes.getInteger(C0096c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f338e = obtainStyledAttributes.getInteger(C0096c.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f340g = obtainStyledAttributes.getInt(C0096c.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f341h = obtainStyledAttributes.getInt(C0096c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f335b = obtainStyledAttributes.hasValue(C0096c.CoordinatorLayout_Layout_layout_behavior);
            if (this.f335b) {
                this.f334a = CoordinatorLayout.m14768a(context, attributeSet, obtainStyledAttributes.getString(C0096c.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            if (this.f334a != null) {
                this.f334a.mo66a(this);
            }
        }

        public C0153e(C0153e c0153e) {
            super(c0153e);
        }

        public C0153e(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0153e(LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* renamed from: a */
        public int m348a() {
            return this.f339f;
        }

        /* renamed from: b */
        public C0150b m356b() {
            return this.f334a;
        }

        /* renamed from: a */
        public void m352a(C0150b c0150b) {
            if (this.f334a != c0150b) {
                if (this.f334a != null) {
                    this.f334a.m339c();
                }
                this.f334a = c0150b;
                this.f347n = null;
                this.f335b = true;
                if (c0150b != null) {
                    c0150b.mo66a(this);
                }
            }
        }

        /* renamed from: a */
        void m351a(Rect rect) {
            this.f346m.set(rect);
        }

        /* renamed from: c */
        Rect m359c() {
            return this.f346m;
        }

        /* renamed from: d */
        boolean m360d() {
            return this.f344k == null && this.f339f != -1;
        }

        /* renamed from: e */
        boolean m361e() {
            if (this.f334a == null) {
                this.f348o = false;
            }
            return this.f348o;
        }

        /* renamed from: a */
        boolean m354a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f348o) {
                return true;
            }
            coordinatorLayout = (this.f334a != null ? this.f334a.m343e(coordinatorLayout, view) : null) | this.f348o;
            this.f348o = coordinatorLayout;
            return coordinatorLayout;
        }

        /* renamed from: f */
        void m362f() {
            this.f348o = false;
        }

        /* renamed from: a */
        void m349a(int i) {
            m350a(i, false);
        }

        /* renamed from: a */
        void m350a(int i, boolean z) {
            switch (i) {
                case 0:
                    this.f349p = z;
                    return;
                case 1:
                    this.f350q = z;
                    return;
                default:
                    return;
            }
        }

        /* renamed from: b */
        boolean m358b(int i) {
            switch (i) {
                case 0:
                    return this.f349p;
                case 1:
                    return this.f350q;
                default:
                    return false;
            }
        }

        /* renamed from: g */
        boolean m363g() {
            return this.f351r;
        }

        /* renamed from: a */
        void m353a(boolean z) {
            this.f351r = z;
        }

        /* renamed from: h */
        void m364h() {
            this.f351r = false;
        }

        /* renamed from: a */
        boolean m355a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (!(view2 == this.f345l || m346a(view2, C0517s.m1711e(coordinatorLayout)))) {
                if (this.f334a == null || this.f334a.mo3322a(coordinatorLayout, view, view2) == null) {
                    return null;
                }
            }
            return true;
        }

        /* renamed from: b */
        View m357b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f339f == -1) {
                this.f345l = null;
                this.f344k = null;
                return null;
            }
            if (this.f344k == null || !m347b(view, coordinatorLayout)) {
                m345a(view, coordinatorLayout);
            }
            return this.f344k;
        }

        /* renamed from: a */
        private void m345a(View view, CoordinatorLayout coordinatorLayout) {
            this.f344k = coordinatorLayout.findViewById(this.f339f);
            if (this.f344k != null) {
                if (this.f344k != coordinatorLayout) {
                    View view2 = this.f344k;
                    View parent = this.f344k.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode() != null) {
                            this.f345l = null;
                            this.f344k = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f345l = view2;
                } else if (coordinatorLayout.isInEditMode() != null) {
                    this.f345l = null;
                    this.f344k = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.f345l = null;
                this.f344k = null;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not find CoordinatorLayout descendant view with id ");
                stringBuilder.append(coordinatorLayout.getResources().getResourceName(this.f339f));
                stringBuilder.append(" to anchor view ");
                stringBuilder.append(view);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        /* renamed from: b */
        private boolean m347b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f344k.getId() != this.f339f) {
                return false;
            }
            View view2 = this.f344k;
            View parent = this.f344k.getParent();
            while (parent != coordinatorLayout) {
                if (parent != null) {
                    if (parent != view) {
                        if (parent instanceof View) {
                            view2 = parent;
                        }
                        parent = parent.getParent();
                    }
                }
                this.f345l = null;
                this.f344k = null;
                return false;
            }
            this.f345l = view2;
            return true;
        }

        /* renamed from: a */
        private boolean m346a(View view, int i) {
            view = C0501e.m1587a(((C0153e) view.getLayoutParams()).f340g, i);
            return (view == null || (C0501e.m1587a(this.f341h, i) & view) != view) ? null : true;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$f */
    class C0154f implements OnPreDrawListener {
        /* renamed from: a */
        final /* synthetic */ CoordinatorLayout f352a;

        C0154f(CoordinatorLayout coordinatorLayout) {
            this.f352a = coordinatorLayout;
        }

        public boolean onPreDraw() {
            this.f352a.m14795a(0);
            return true;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$h */
    static class C0156h implements Comparator<View> {
        C0156h() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m368a((View) obj, (View) obj2);
        }

        /* renamed from: a */
        public int m368a(View view, View view2) {
            view = C0517s.m1731y(view);
            view2 = C0517s.m1731y(view2);
            if (view > view2) {
                return -1;
            }
            return view < view2 ? 1 : null;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$1 */
    class C31241 implements C0512p {
        /* renamed from: a */
        final /* synthetic */ CoordinatorLayout f7995a;

        C31241(CoordinatorLayout coordinatorLayout) {
            this.f7995a = coordinatorLayout;
        }

        /* renamed from: a */
        public aa mo63a(View view, aa aaVar) {
            return this.f7995a.m14793a(aaVar);
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$g */
    protected static class C3125g extends C0487a {
        public static final Creator<C3125g> CREATOR = new C01551();
        /* renamed from: a */
        SparseArray<Parcelable> f7996a;

        /* renamed from: android.support.design.widget.CoordinatorLayout$g$1 */
        static class C01551 implements ClassLoaderCreator<C3125g> {
            C01551() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m365a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m366a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m367a(i);
            }

            /* renamed from: a */
            public C3125g m366a(Parcel parcel, ClassLoader classLoader) {
                return new C3125g(parcel, classLoader);
            }

            /* renamed from: a */
            public C3125g m365a(Parcel parcel) {
                return new C3125g(parcel, null);
            }

            /* renamed from: a */
            public C3125g[] m367a(int i) {
                return new C3125g[i];
            }
        }

        public C3125g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            parcel = parcel.readParcelableArray(classLoader);
            this.f7996a = new SparseArray(readInt);
            for (classLoader = null; classLoader < readInt; classLoader++) {
                this.f7996a.append(iArr[classLoader], parcel[classLoader]);
            }
        }

        public C3125g(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int size = this.f7996a != null ? this.f7996a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f7996a.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.f7996a.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    /* renamed from: c */
    private static int m14780c(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    /* renamed from: d */
    private static int m14781d(int i) {
        return i == 0 ? 8388661 : i;
    }

    /* renamed from: e */
    private static int m14783e(int i) {
        return i == 0 ? 17 : i;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m14814d();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m14790a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m14792a(layoutParams);
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        f11850a = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            f11853d = new C0156h();
        } else {
            f11853d = null;
        }
    }

    /* renamed from: e */
    private static Rect m14784e() {
        Rect rect = (Rect) f11854f.acquire();
        return rect == null ? new Rect() : rect;
    }

    /* renamed from: a */
    private static void m14769a(Rect rect) {
        rect.setEmpty();
        f11854f.release(rect);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0094a.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11856g = new ArrayList();
        this.f11857h = new C0547h();
        this.f11858i = new ArrayList();
        this.f11859j = new ArrayList();
        this.f11860k = new int[2];
        this.f11873x = new C0511o(this);
        int i2 = 0;
        if (i == 0) {
            attributeSet = context.obtainStyledAttributes(attributeSet, C0096c.CoordinatorLayout, 0, C0095b.Widget_Support_CoordinatorLayout);
        } else {
            attributeSet = context.obtainStyledAttributes(attributeSet, C0096c.CoordinatorLayout, i, 0);
        }
        i = attributeSet.getResourceId(C0096c.CoordinatorLayout_keylines, 0);
        if (i != 0) {
            context = context.getResources();
            this.f11864o = context.getIntArray(i);
            context = context.getDisplayMetrics().density;
            i = this.f11864o.length;
            while (i2 < i) {
                this.f11864o[i2] = (int) (((float) this.f11864o[i2]) * context);
                i2++;
            }
        }
        this.f11871v = attributeSet.getDrawable(C0096c.CoordinatorLayout_statusBarBackground);
        attributeSet.recycle();
        m14789g();
        super.setOnHierarchyChangeListener(new C0152d(this));
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f11855e = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m14775a(false);
        if (this.f11868s) {
            if (this.f11867r == null) {
                this.f11867r = new C0154f(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f11867r);
        }
        if (this.f11869t == null && C0517s.m1722p(this)) {
            C0517s.m1721o(this);
        }
        this.f11863n = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m14775a(false);
        if (this.f11868s && this.f11867r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f11867r);
        }
        if (this.f11866q != null) {
            onStopNestedScroll(this.f11866q);
        }
        this.f11863n = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        if (this.f11871v != drawable) {
            Drawable drawable2 = null;
            if (this.f11871v != null) {
                this.f11871v.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f11871v = drawable2;
            if (this.f11871v != null) {
                if (this.f11871v.isStateful() != null) {
                    this.f11871v.setState(getDrawableState());
                }
                C0259a.m698b(this.f11871v, C0517s.m1711e(this));
                this.f11871v.setVisible(getVisibility() == 0, false);
                this.f11871v.setCallback(this);
            }
            C0517s.m1706c(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.f11871v;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f11871v;
        int i = 0;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable)) {
            if (drawable != this.f11871v) {
                return null;
            }
        }
        return true;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f11871v != null && this.f11871v.isVisible() != z) {
            this.f11871v.setVisible(z, false);
        }
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? C0366b.m1103a(getContext(), i) : 0);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    /* renamed from: a */
    final aa m14793a(aa aaVar) {
        if (C0460i.m1449a(this.f11869t, aaVar)) {
            return aaVar;
        }
        this.f11869t = aaVar;
        boolean z = true;
        boolean z2 = aaVar != null && aaVar.m1563b() > 0;
        this.f11870u = z2;
        if (this.f11870u || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        aaVar = m14778b(aaVar);
        requestLayout();
        return aaVar;
    }

    public final aa getLastWindowInsets() {
        return this.f11869t;
    }

    /* renamed from: a */
    private void m14775a(boolean z) {
        boolean childCount = getChildCount();
        for (boolean z2 = false; z2 < childCount; z2++) {
            View childAt = getChildAt(z2);
            C0150b b = ((C0153e) childAt.getLayoutParams()).m356b();
            if (b != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    b.mo56a(this, childAt, obtain);
                } else {
                    b.mo60b(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (z = false; z < childCount; z++) {
            ((C0153e) getChildAt(z).getLayoutParams()).m362f();
        }
        this.f11865p = false;
        this.f11862m = false;
    }

    /* renamed from: a */
    private void m14774a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i = childCount - 1;
        while (i >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
            i--;
        }
        if (f11853d != null) {
            Collections.sort(list, f11853d);
        }
    }

    /* renamed from: a */
    private boolean m14776a(MotionEvent motionEvent, int i) {
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        List list = this.f11858i;
        m14774a(list);
        int size = list.size();
        MotionEvent motionEvent3 = null;
        boolean z = false;
        Object obj = null;
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) list.get(i2);
            C0153e c0153e = (C0153e) view.getLayoutParams();
            C0150b b = c0153e.m356b();
            if ((z || r8 != null) && actionMasked != 0) {
                if (b != null) {
                    if (motionEvent3 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    switch (i) {
                        case 0:
                            b.mo56a(r0, view, motionEvent3);
                            break;
                        case 1:
                            b.mo60b(r0, view, motionEvent3);
                            break;
                        default:
                            break;
                    }
                }
            } else {
                if (!(z || b == null)) {
                    switch (i) {
                        case 0:
                            z = b.mo56a(r0, view, motionEvent2);
                            break;
                        case 1:
                            z = b.mo60b(r0, view, motionEvent2);
                            break;
                        default:
                            break;
                    }
                    if (z) {
                        r0.f11865p = view;
                    }
                }
                boolean e = c0153e.m361e();
                boolean a = c0153e.m354a(r0, view);
                obj = (!a || e) ? null : 1;
                if (a && obj == null) {
                    list.clear();
                    return z;
                }
            }
        }
        list.clear();
        return z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m14775a(true);
        }
        motionEvent = m14776a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            m14775a(true);
        }
        return motionEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean b;
        MotionEvent motionEvent2;
        MotionEvent motionEvent3 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        boolean a;
        C0150b b2;
        if (this.f11865p == null) {
            a = m14776a(motionEvent3, 1);
            if (a) {
                b2 = ((C0153e) r0.f11865p.getLayoutParams()).m356b();
                if (b2 != null) {
                    b = b2.mo60b(r0, r0.f11865p, motionEvent3);
                    motionEvent2 = null;
                    if (r0.f11865p != null) {
                        b |= super.onTouchEvent(motionEvent);
                    } else if (a) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        super.onTouchEvent(motionEvent2);
                    }
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    if (actionMasked == 1 || actionMasked == 3) {
                        m14775a(false);
                    }
                    return b;
                }
            }
        }
        a = false;
        b2 = ((C0153e) r0.f11865p.getLayoutParams()).m356b();
        if (b2 != null) {
            b = b2.mo60b(r0, r0.f11865p, motionEvent3);
            motionEvent2 = null;
            if (r0.f11865p != null) {
                b |= super.onTouchEvent(motionEvent);
            } else if (a) {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                motionEvent2 = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEvent2);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            m14775a(false);
            return b;
        }
        b = false;
        motionEvent2 = null;
        if (r0.f11865p != null) {
            b |= super.onTouchEvent(motionEvent);
        } else if (a) {
            long uptimeMillis22 = SystemClock.uptimeMillis();
            motionEvent2 = MotionEvent.obtain(uptimeMillis22, uptimeMillis22, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEvent2);
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        m14775a(false);
        return b;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.f11862m) {
            m14775a(false);
            this.f11862m = true;
        }
    }

    /* renamed from: b */
    private int m14777b(int i) {
        if (this.f11864o == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No keylines defined for ");
            stringBuilder.append(this);
            stringBuilder.append(" - attempted index lookup ");
            stringBuilder.append(i);
            Log.e("CoordinatorLayout", stringBuilder.toString());
            return 0;
        }
        if (i >= 0) {
            if (i < this.f11864o.length) {
                return this.f11864o[i];
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Keyline index ");
        stringBuilder.append(i);
        stringBuilder.append(" out of range for ");
        stringBuilder.append(this);
        Log.e("CoordinatorLayout", stringBuilder.toString());
        return 0;
    }

    /* renamed from: a */
    static C0150b m14768a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getPackageName());
            stringBuilder.append(str);
            str = stringBuilder.toString();
        } else if (str.indexOf(46) < 0) {
            if (!TextUtils.isEmpty(f11850a)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(f11850a);
                stringBuilder2.append('.');
                stringBuilder2.append(str);
                str = stringBuilder2.toString();
            }
        }
        try {
            Map map = (Map) f11852c.get();
            if (map == null) {
                map = new HashMap();
                f11852c.set(map);
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(f11851b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (C0150b) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Context context2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not inflate Behavior subclass ");
            stringBuilder.append(str);
            throw new RuntimeException(stringBuilder.toString(), context2);
        }
    }

    /* renamed from: a */
    C0153e m14791a(View view) {
        C0153e c0153e = (C0153e) view.getLayoutParams();
        if (!c0153e.f335b) {
            if (view instanceof C0149a) {
                C0150b a = ((C0149a) view).m314a();
                if (a == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                c0153e.m352a(a);
                c0153e.f335b = true;
            } else {
                C0151c c0151c = null;
                for (view = view.getClass(); view != null; view = view.getSuperclass()) {
                    c0151c = (C0151c) view.getAnnotation(C0151c.class);
                    if (c0151c != null) {
                        break;
                    }
                }
                if (c0151c != null) {
                    try {
                        c0153e.m352a((C0150b) c0151c.m344a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (View view2) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Default behavior class ");
                        stringBuilder.append(c0151c.m344a().getName());
                        stringBuilder.append(" could not be instantiated. Did you forget");
                        stringBuilder.append(" a default constructor?");
                        Log.e("CoordinatorLayout", stringBuilder.toString(), view2);
                    }
                }
                c0153e.f335b = true;
            }
        }
        return c0153e;
    }

    /* renamed from: f */
    private void m14787f() {
        this.f11856g.clear();
        this.f11857h.m1868a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            Object childAt = getChildAt(i);
            C0153e a = m14791a((View) childAt);
            a.m357b(this, (View) childAt);
            this.f11857h.m1869a(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    Object childAt2 = getChildAt(i2);
                    if (a.m355a(this, childAt, childAt2)) {
                        if (!this.f11857h.m1872b(childAt2)) {
                            this.f11857h.m1869a(childAt2);
                        }
                        this.f11857h.m1870a(childAt2, childAt);
                    }
                }
            }
        }
        this.f11856g.addAll(this.f11857h.m1871b());
        Collections.reverse(this.f11856g);
    }

    /* renamed from: a */
    void m14801a(View view, Rect rect) {
        C0580v.m1962b(this, view, rect);
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* renamed from: a */
    public void m14797a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        int a;
        CoordinatorLayout coordinatorLayout = this;
        m14787f();
        m14794a();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int e = C0517s.m1711e(this);
        Object obj = e == 1 ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = paddingLeft + paddingRight;
        int i4 = paddingTop + paddingBottom;
        paddingTop = getSuggestedMinimumWidth();
        paddingBottom = getSuggestedMinimumHeight();
        Object obj2 = (coordinatorLayout.f11869t == null || !C0517s.m1722p(this)) ? null : 1;
        int size3 = coordinatorLayout.f11856g.size();
        int i5 = paddingTop;
        int i6 = paddingBottom;
        int i7 = 0;
        int i8 = 0;
        while (i8 < size3) {
            int i9;
            int i10;
            View view = (View) coordinatorLayout.f11856g.get(i8);
            if (view.getVisibility() == 8) {
                i9 = i8;
                i10 = size3;
            } else {
                int max;
                int i11;
                C0150b b;
                C0153e c0153e;
                int i12;
                int i13;
                int i14;
                C0153e c0153e2 = (C0153e) view.getLayoutParams();
                if (c0153e2.f338e < 0 || mode == 0) {
                    i9 = i6;
                } else {
                    paddingTop = m14777b(c0153e2.f338e);
                    a = C0501e.m1587a(m14781d(c0153e2.f336c), e) & 7;
                    i9 = i6;
                    if ((a == 3 && obj == null) || (a == 5 && obj != null)) {
                        max = Math.max(0, (size - paddingRight) - paddingTop);
                        if (obj2 != null) {
                        }
                        a = i;
                        i11 = i2;
                        b = c0153e2.m356b();
                        if (b != null) {
                            c0153e = c0153e2;
                            i12 = i7;
                            i13 = i5;
                            i10 = size3;
                            i14 = i9;
                            i9 = i8;
                        } else {
                            c0153e = c0153e2;
                            i14 = i9;
                            i12 = i7;
                            i13 = i5;
                            i9 = i8;
                            i10 = size3;
                            if (!b.mo2648a(this, view, a, max, i11, 0)) {
                            }
                            c0153e2 = c0153e;
                            paddingTop = Math.max(i13, ((i3 + view.getMeasuredWidth()) + c0153e2.leftMargin) + c0153e2.rightMargin);
                            paddingBottom = Math.max(i14, ((i4 + view.getMeasuredHeight()) + c0153e2.topMargin) + c0153e2.bottomMargin);
                            i5 = paddingTop;
                            i7 = View.combineMeasuredStates(i12, view.getMeasuredState());
                            i6 = paddingBottom;
                        }
                        m14797a(view, a, max, i11, 0);
                        c0153e2 = c0153e;
                        paddingTop = Math.max(i13, ((i3 + view.getMeasuredWidth()) + c0153e2.leftMargin) + c0153e2.rightMargin);
                        paddingBottom = Math.max(i14, ((i4 + view.getMeasuredHeight()) + c0153e2.topMargin) + c0153e2.bottomMargin);
                        i5 = paddingTop;
                        i7 = View.combineMeasuredStates(i12, view.getMeasuredState());
                        i6 = paddingBottom;
                    } else if ((a == 5 && obj == null) || (a == 3 && obj != null)) {
                        max = Math.max(0, paddingTop - paddingLeft);
                        if (obj2 != null || C0517s.m1722p(view)) {
                            a = i;
                            i11 = i2;
                        } else {
                            i6 = coordinatorLayout.f11869t.m1563b() + coordinatorLayout.f11869t.m1565d();
                            a = MeasureSpec.makeMeasureSpec(size - (coordinatorLayout.f11869t.m1561a() + coordinatorLayout.f11869t.m1564c()), mode);
                            i11 = MeasureSpec.makeMeasureSpec(size2 - i6, mode2);
                        }
                        b = c0153e2.m356b();
                        if (b != null) {
                            c0153e = c0153e2;
                            i14 = i9;
                            i12 = i7;
                            i13 = i5;
                            i9 = i8;
                            i10 = size3;
                            if (b.mo2648a(this, view, a, max, i11, 0)) {
                            }
                            c0153e2 = c0153e;
                            paddingTop = Math.max(i13, ((i3 + view.getMeasuredWidth()) + c0153e2.leftMargin) + c0153e2.rightMargin);
                            paddingBottom = Math.max(i14, ((i4 + view.getMeasuredHeight()) + c0153e2.topMargin) + c0153e2.bottomMargin);
                            i5 = paddingTop;
                            i7 = View.combineMeasuredStates(i12, view.getMeasuredState());
                            i6 = paddingBottom;
                        } else {
                            c0153e = c0153e2;
                            i12 = i7;
                            i13 = i5;
                            i10 = size3;
                            i14 = i9;
                            i9 = i8;
                        }
                        m14797a(view, a, max, i11, 0);
                        c0153e2 = c0153e;
                        paddingTop = Math.max(i13, ((i3 + view.getMeasuredWidth()) + c0153e2.leftMargin) + c0153e2.rightMargin);
                        paddingBottom = Math.max(i14, ((i4 + view.getMeasuredHeight()) + c0153e2.topMargin) + c0153e2.bottomMargin);
                        i5 = paddingTop;
                        i7 = View.combineMeasuredStates(i12, view.getMeasuredState());
                        i6 = paddingBottom;
                    }
                }
                max = 0;
                if (obj2 != null) {
                }
                a = i;
                i11 = i2;
                b = c0153e2.m356b();
                if (b != null) {
                    c0153e = c0153e2;
                    i14 = i9;
                    i12 = i7;
                    i13 = i5;
                    i9 = i8;
                    i10 = size3;
                    if (b.mo2648a(this, view, a, max, i11, 0)) {
                    }
                    c0153e2 = c0153e;
                    paddingTop = Math.max(i13, ((i3 + view.getMeasuredWidth()) + c0153e2.leftMargin) + c0153e2.rightMargin);
                    paddingBottom = Math.max(i14, ((i4 + view.getMeasuredHeight()) + c0153e2.topMargin) + c0153e2.bottomMargin);
                    i5 = paddingTop;
                    i7 = View.combineMeasuredStates(i12, view.getMeasuredState());
                    i6 = paddingBottom;
                } else {
                    c0153e = c0153e2;
                    i12 = i7;
                    i13 = i5;
                    i10 = size3;
                    i14 = i9;
                    i9 = i8;
                }
                m14797a(view, a, max, i11, 0);
                c0153e2 = c0153e;
                paddingTop = Math.max(i13, ((i3 + view.getMeasuredWidth()) + c0153e2.leftMargin) + c0153e2.rightMargin);
                paddingBottom = Math.max(i14, ((i4 + view.getMeasuredHeight()) + c0153e2.topMargin) + c0153e2.bottomMargin);
                i5 = paddingTop;
                i7 = View.combineMeasuredStates(i12, view.getMeasuredState());
                i6 = paddingBottom;
            }
            i8 = i9 + 1;
            size3 = i10;
        }
        a = i7;
        setMeasuredDimension(View.resolveSizeAndState(i5, i, -16777216 & a), View.resolveSizeAndState(i6, i2, a << 16));
    }

    /* renamed from: b */
    private aa m14778b(aa aaVar) {
        if (aaVar.m1566e()) {
            return aaVar;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (C0517s.m1722p(childAt)) {
                C0150b b = ((C0153e) childAt.getLayoutParams()).m356b();
                if (b != null) {
                    aaVar = b.m315a(this, childAt, aaVar);
                    if (aaVar.m1566e()) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return aaVar;
    }

    /* renamed from: a */
    public void m14796a(View view, int i) {
        C0153e c0153e = (C0153e) view.getLayoutParams();
        if (c0153e.m360d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (c0153e.f344k != null) {
            m14773a(view, c0153e.f344k, i);
        } else if (c0153e.f338e >= 0) {
            m14779b(view, c0153e.f338e, i);
        } else {
            m14782d(view, i);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int e = C0517s.m1711e(this);
        i = this.f11856g.size();
        for (i2 = 0; i2 < i; i2++) {
            View view = (View) this.f11856g.get(i2);
            if (view.getVisibility() != 8) {
                i4 = ((C0153e) view.getLayoutParams()).m356b();
                if (i4 == 0 || i4.mo55a(this, view, e) == 0) {
                    m14796a(view, e);
                }
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f11870u && this.f11871v != null) {
            int b = this.f11869t != null ? this.f11869t.m1563b() : 0;
            if (b > 0) {
                this.f11871v.setBounds(0, 0, getWidth(), b);
                this.f11871v.draw(canvas);
            }
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        m14789g();
    }

    /* renamed from: b */
    void m14808b(View view, Rect rect) {
        ((C0153e) view.getLayoutParams()).m351a(rect);
    }

    /* renamed from: c */
    void m14813c(View view, Rect rect) {
        rect.set(((C0153e) view.getLayoutParams()).m359c());
    }

    /* renamed from: a */
    void m14802a(View view, boolean z, Rect rect) {
        if (!view.isLayoutRequested()) {
            if (view.getVisibility() != 8) {
                if (z) {
                    m14801a(view, rect);
                } else {
                    rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                }
                return;
            }
        }
        rect.setEmpty();
    }

    /* renamed from: a */
    private void m14771a(View view, int i, Rect rect, Rect rect2, C0153e c0153e, int i2, int i3) {
        view = C0501e.m1587a(m14783e(c0153e.f336c), i);
        i = C0501e.m1587a(m14780c(c0153e.f337d), i);
        c0153e = view & 7;
        view &= 112;
        int i4 = i & 7;
        i &= 112;
        if (i4 == 1) {
            i4 = rect.left + (rect.width() / 2);
        } else if (i4 != 5) {
            i4 = rect.left;
        } else {
            i4 = rect.right;
        }
        if (i == 16) {
            i = rect.top + (rect.height() / 2);
        } else if (i != 80) {
            i = rect.top;
        } else {
            i = rect.bottom;
        }
        if (c0153e == 1) {
            i4 -= i2 / 2;
        } else if (c0153e != 5) {
            i4 -= i2;
        }
        if (view == 16) {
            i -= i3 / 2;
        } else if (view != 80) {
            i -= i3;
        }
        rect2.set(i4, i, i2 + i4, i3 + i);
    }

    /* renamed from: a */
    private void m14770a(C0153e c0153e, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        width = Math.max(getPaddingLeft() + c0153e.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - c0153e.rightMargin));
        c0153e = Math.max(getPaddingTop() + c0153e.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - c0153e.bottomMargin));
        rect.set(width, c0153e, i + width, i2 + c0153e);
    }

    /* renamed from: a */
    void m14800a(View view, int i, Rect rect, Rect rect2) {
        C0153e c0153e = (C0153e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        m14771a(view, i, rect, rect2, c0153e, measuredWidth, measuredHeight);
        m14770a(c0153e, rect2, measuredWidth, measuredHeight);
    }

    /* renamed from: a */
    private void m14773a(View view, View view2, int i) {
        C0153e c0153e = (C0153e) view.getLayoutParams();
        Rect e = m14784e();
        Rect e2 = m14784e();
        try {
            m14801a(view2, e);
            m14800a(view, i, e, e2);
            view.layout(e2.left, e2.top, e2.right, e2.bottom);
        } finally {
            m14769a(e);
            m14769a(e2);
        }
    }

    /* renamed from: b */
    private void m14779b(View view, int i, int i2) {
        C0153e c0153e = (C0153e) view.getLayoutParams();
        int a = C0501e.m1587a(m14781d(c0153e.f336c), i2);
        int i3 = a & 7;
        a &= 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        i = m14777b(i) - measuredWidth;
        i2 = 0;
        if (i3 == 1) {
            i += measuredWidth / 2;
        } else if (i3 == 5) {
            i += measuredWidth;
        }
        if (a == 16) {
            i2 = 0 + (measuredHeight / 2);
        } else if (a == 80) {
            i2 = measuredHeight + 0;
        }
        i = Math.max(getPaddingLeft() + c0153e.leftMargin, Math.min(i, ((width - getPaddingRight()) - measuredWidth) - c0153e.rightMargin));
        i2 = Math.max(getPaddingTop() + c0153e.topMargin, Math.min(i2, ((height - getPaddingBottom()) - measuredHeight) - c0153e.bottomMargin));
        view.layout(i, i2, measuredWidth + i, measuredHeight + i2);
    }

    /* renamed from: d */
    private void m14782d(View view, int i) {
        C0153e c0153e = (C0153e) view.getLayoutParams();
        Rect e = m14784e();
        e.set(getPaddingLeft() + c0153e.leftMargin, getPaddingTop() + c0153e.topMargin, (getWidth() - getPaddingRight()) - c0153e.rightMargin, (getHeight() - getPaddingBottom()) - c0153e.bottomMargin);
        if (!(this.f11869t == null || !C0517s.m1722p(this) || C0517s.m1722p(view))) {
            e.left += this.f11869t.m1561a();
            e.top += this.f11869t.m1563b();
            e.right -= this.f11869t.m1564c();
            e.bottom -= this.f11869t.m1565d();
        }
        Rect e2 = m14784e();
        C0501e.m1588a(m14780c(c0153e.f336c), view.getMeasuredWidth(), view.getMeasuredHeight(), e, e2, i);
        view.layout(e2.left, e2.top, e2.right, e2.bottom);
        m14769a(e);
        m14769a(e2);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        C0153e c0153e = (C0153e) view.getLayoutParams();
        if (c0153e.f334a != null) {
            float d = c0153e.f334a.m341d(this, view);
            if (d > 0.0f) {
                if (this.f11861l == null) {
                    this.f11861l = new Paint();
                }
                this.f11861l.setColor(c0153e.f334a.m338c(this, view));
                this.f11861l.setAlpha(C0384a.m1163a(Math.round(d * 255.0f), 0, (int) JfifUtil.MARKER_FIRST_BYTE));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f11861l);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    /* renamed from: a */
    final void m14795a(int i) {
        int i2 = i;
        int e = C0517s.m1711e(this);
        int size = this.f11856g.size();
        Rect e2 = m14784e();
        Rect e3 = m14784e();
        Rect e4 = m14784e();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) r0.f11856g.get(i3);
            C0153e c0153e = (C0153e) view.getLayoutParams();
            if (i2 != 0 || view.getVisibility() != 8) {
                int a;
                for (int i4 = 0; i4 < i3; i4++) {
                    if (c0153e.f345l == ((View) r0.f11856g.get(i4))) {
                        m14807b(view, e);
                    }
                }
                m14802a(view, true, e3);
                if (!(c0153e.f340g == 0 || e3.isEmpty())) {
                    a = C0501e.m1587a(c0153e.f340g, e);
                    int i5 = a & 112;
                    if (i5 == 48) {
                        e2.top = Math.max(e2.top, e3.bottom);
                    } else if (i5 == 80) {
                        e2.bottom = Math.max(e2.bottom, getHeight() - e3.top);
                    }
                    a &= 7;
                    if (a == 3) {
                        e2.left = Math.max(e2.left, e3.right);
                    } else if (a == 5) {
                        e2.right = Math.max(e2.right, getWidth() - e3.left);
                    }
                }
                if (c0153e.f341h != 0 && view.getVisibility() == 0) {
                    m14772a(view, e2, e);
                }
                if (i2 != 2) {
                    m14813c(view, e4);
                    if (!e4.equals(e3)) {
                        m14808b(view, e3);
                    }
                }
                for (a = i3 + 1; a < size; a++) {
                    View view2 = (View) r0.f11856g.get(a);
                    C0153e c0153e2 = (C0153e) view2.getLayoutParams();
                    C0150b b = c0153e2.m356b();
                    if (b != null && b.mo3322a(r0, view2, view)) {
                        if (i2 == 0 && c0153e2.m363g()) {
                            c0153e2.m364h();
                        } else {
                            boolean b2;
                            if (i2 != 2) {
                                b2 = b.mo68b(r0, view2, view);
                            } else {
                                b.m342d(r0, view2, view);
                                b2 = true;
                            }
                            if (i2 == 1) {
                                c0153e2.m353a(b2);
                            }
                        }
                    }
                }
            }
        }
        m14769a(e2);
        m14769a(e3);
        m14769a(e4);
    }

    /* renamed from: a */
    private void m14772a(View view, Rect rect, int i) {
        if (C0517s.m1730x(view) && view.getWidth() > 0) {
            if (view.getHeight() > 0) {
                C0153e c0153e = (C0153e) view.getLayoutParams();
                C0150b b = c0153e.m356b();
                Rect e = m14784e();
                Rect e2 = m14784e();
                e2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                if (b == null || !b.mo67a(this, view, e)) {
                    e.set(e2);
                } else if (!e2.contains(e)) {
                    rect = new StringBuilder();
                    rect.append("Rect should be within the child's bounds. Rect:");
                    rect.append(e.toShortString());
                    rect.append(" | Bounds:");
                    rect.append(e2.toShortString());
                    throw new IllegalArgumentException(rect.toString());
                }
                m14769a(e2);
                if (e.isEmpty()) {
                    m14769a(e);
                    return;
                }
                int i2;
                Object obj;
                int height;
                i = C0501e.m1587a(c0153e.f341h, i);
                if ((i & 48) == 48) {
                    i2 = (e.top - c0153e.topMargin) - c0153e.f343j;
                    if (i2 < rect.top) {
                        m14788f(view, rect.top - i2);
                        obj = 1;
                        if ((i & 80) == 80) {
                            height = ((getHeight() - e.bottom) - c0153e.bottomMargin) + c0153e.f343j;
                            if (height < rect.bottom) {
                                m14788f(view, height - rect.bottom);
                                obj = 1;
                            }
                        }
                        if (obj == null) {
                            m14788f(view, 0);
                        }
                        if ((i & 3) == 3) {
                            i2 = (e.left - c0153e.leftMargin) - c0153e.f342i;
                            if (i2 < rect.left) {
                                m14785e(view, rect.left - i2);
                                obj = 1;
                                if ((i & 5) == 5) {
                                    i = ((getWidth() - e.right) - c0153e.rightMargin) + c0153e.f342i;
                                    if (i < rect.right) {
                                        m14785e(view, i - rect.right);
                                        obj = 1;
                                    }
                                }
                                if (obj == null) {
                                    m14785e(view, 0);
                                }
                                m14769a(e);
                            }
                        }
                        obj = null;
                        if ((i & 5) == 5) {
                            i = ((getWidth() - e.right) - c0153e.rightMargin) + c0153e.f342i;
                            if (i < rect.right) {
                                m14785e(view, i - rect.right);
                                obj = 1;
                            }
                        }
                        if (obj == null) {
                            m14785e(view, 0);
                        }
                        m14769a(e);
                    }
                }
                obj = null;
                if ((i & 80) == 80) {
                    height = ((getHeight() - e.bottom) - c0153e.bottomMargin) + c0153e.f343j;
                    if (height < rect.bottom) {
                        m14788f(view, height - rect.bottom);
                        obj = 1;
                    }
                }
                if (obj == null) {
                    m14788f(view, 0);
                }
                if ((i & 3) == 3) {
                    i2 = (e.left - c0153e.leftMargin) - c0153e.f342i;
                    if (i2 < rect.left) {
                        m14785e(view, rect.left - i2);
                        obj = 1;
                        if ((i & 5) == 5) {
                            i = ((getWidth() - e.right) - c0153e.rightMargin) + c0153e.f342i;
                            if (i < rect.right) {
                                m14785e(view, i - rect.right);
                                obj = 1;
                            }
                        }
                        if (obj == null) {
                            m14785e(view, 0);
                        }
                        m14769a(e);
                    }
                }
                obj = null;
                if ((i & 5) == 5) {
                    i = ((getWidth() - e.right) - c0153e.rightMargin) + c0153e.f342i;
                    if (i < rect.right) {
                        m14785e(view, i - rect.right);
                        obj = 1;
                    }
                }
                if (obj == null) {
                    m14785e(view, 0);
                }
                m14769a(e);
            }
        }
    }

    /* renamed from: e */
    private void m14785e(View view, int i) {
        C0153e c0153e = (C0153e) view.getLayoutParams();
        if (c0153e.f342i != i) {
            C0517s.m1710d(view, i - c0153e.f342i);
            c0153e.f342i = i;
        }
    }

    /* renamed from: f */
    private void m14788f(View view, int i) {
        C0153e c0153e = (C0153e) view.getLayoutParams();
        if (c0153e.f343j != i) {
            C0517s.m1707c(view, i - c0153e.f343j);
            c0153e.f343j = i;
        }
    }

    /* renamed from: b */
    public void m14806b(View view) {
        List c = this.f11857h.m1873c(view);
        if (c != null && !c.isEmpty()) {
            for (int i = 0; i < c.size(); i++) {
                View view2 = (View) c.get(i);
                C0150b b = ((C0153e) view2.getLayoutParams()).m356b();
                if (b != null) {
                    b.mo68b(this, view2, view);
                }
            }
        }
    }

    /* renamed from: c */
    public List<View> m14810c(View view) {
        view = this.f11857h.m1874d(view);
        this.f11859j.clear();
        if (view != null) {
            this.f11859j.addAll(view);
        }
        return this.f11859j;
    }

    /* renamed from: d */
    public List<View> m14815d(View view) {
        view = this.f11857h.m1873c(view);
        this.f11859j.clear();
        if (view != null) {
            this.f11859j.addAll(view);
        }
        return this.f11859j;
    }

    final List<View> getDependencySortedChildren() {
        m14787f();
        return Collections.unmodifiableList(this.f11856g);
    }

    /* renamed from: a */
    void m14794a() {
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            if (m14786e(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z == this.f11868s) {
            return;
        }
        if (z) {
            m14805b();
        } else {
            m14811c();
        }
    }

    /* renamed from: e */
    private boolean m14786e(View view) {
        return this.f11857h.m1875e(view);
    }

    /* renamed from: b */
    void m14805b() {
        if (this.f11863n) {
            if (this.f11867r == null) {
                this.f11867r = new C0154f(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f11867r);
        }
        this.f11868s = true;
    }

    /* renamed from: c */
    void m14811c() {
        if (this.f11863n && this.f11867r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f11867r);
        }
        this.f11868s = false;
    }

    /* renamed from: b */
    void m14807b(View view, int i) {
        CoordinatorLayout coordinatorLayout = this;
        View view2 = view;
        C0153e c0153e = (C0153e) view.getLayoutParams();
        if (c0153e.f344k != null) {
            Rect e = m14784e();
            Rect e2 = m14784e();
            Rect e3 = m14784e();
            m14801a(c0153e.f344k, e);
            boolean z = false;
            m14802a(view2, false, e2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i2 = measuredHeight;
            m14771a(view, i, e, e3, c0153e, measuredWidth, measuredHeight);
            if (!(e3.left == e2.left && e3.top == e2.top)) {
                z = true;
            }
            m14770a(c0153e, e3, measuredWidth, i2);
            int i3 = e3.left - e2.left;
            int i4 = e3.top - e2.top;
            if (i3 != 0) {
                C0517s.m1710d(view2, i3);
            }
            if (i4 != 0) {
                C0517s.m1707c(view2, i4);
            }
            if (z) {
                C0150b b = c0153e.m356b();
                if (b != null) {
                    b.mo68b(coordinatorLayout, view2, c0153e.f344k);
                }
            }
            m14769a(e);
            m14769a(e2);
            m14769a(e3);
        }
    }

    /* renamed from: a */
    public boolean m14803a(View view, int i, int i2) {
        Rect e = m14784e();
        m14801a(view, e);
        try {
            view = e.contains(i, i2);
            return view;
        } finally {
            m14769a(e);
        }
    }

    /* renamed from: a */
    public C0153e m14790a(AttributeSet attributeSet) {
        return new C0153e(getContext(), attributeSet);
    }

    /* renamed from: a */
    protected C0153e m14792a(LayoutParams layoutParams) {
        if (layoutParams instanceof C0153e) {
            return new C0153e((C0153e) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new C0153e((MarginLayoutParams) layoutParams);
        }
        return new C0153e(layoutParams);
    }

    /* renamed from: d */
    protected C0153e m14814d() {
        return new C0153e(-2, -2);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (!(layoutParams instanceof C0153e) || super.checkLayoutParams(layoutParams) == null) ? null : true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return mo2644a(view, view2, i, 0);
    }

    /* renamed from: a */
    public boolean mo2644a(View view, View view2, int i, int i2) {
        CoordinatorLayout coordinatorLayout;
        int i3 = i2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            coordinatorLayout = this;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                C0153e c0153e = (C0153e) childAt.getLayoutParams();
                C0150b b = c0153e.m356b();
                if (b != null) {
                    boolean a = b.mo3316a(this, childAt, view, view2, i, i2);
                    boolean z2 = z | a;
                    c0153e.m350a(i3, a);
                    z = z2;
                } else {
                    c0153e.m350a(i3, false);
                }
            }
        }
        coordinatorLayout = this;
        return z;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        mo2645b(view, view2, i, 0);
    }

    /* renamed from: b */
    public void mo2645b(View view, View view2, int i, int i2) {
        this.f11873x.m1629a(view, view2, i, i2);
        this.f11866q = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            C0153e c0153e = (C0153e) childAt.getLayoutParams();
            if (c0153e.m358b(i2)) {
                C0150b b = c0153e.m356b();
                if (b != null) {
                    b.m335b(this, childAt, view, view2, i, i2);
                }
            }
        }
    }

    public void onStopNestedScroll(View view) {
        mo2646c(view, 0);
    }

    /* renamed from: c */
    public void mo2646c(View view, int i) {
        this.f11873x.m1627a(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0153e c0153e = (C0153e) childAt.getLayoutParams();
            if (c0153e.m358b(i)) {
                C0150b b = c0153e.m356b();
                if (b != null) {
                    b.mo3312a(this, childAt, view, i);
                }
                c0153e.m349a(i);
                c0153e.m364h();
            }
        }
        this.f11866q = null;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        mo2642a(view, i, i2, i3, i4, 0);
    }

    /* renamed from: a */
    public void mo2642a(View view, int i, int i2, int i3, int i4, int i5) {
        CoordinatorLayout coordinatorLayout = this;
        int childCount = getChildCount();
        Object obj = null;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                int i7 = i5;
            } else {
                C0153e c0153e = (C0153e) childAt.getLayoutParams();
                if (c0153e.m358b(i5)) {
                    C0150b b = c0153e.m356b();
                    if (b != null) {
                        b.mo3313a(this, childAt, view, i, i2, i3, i4, i5);
                        obj = 1;
                    }
                }
            }
        }
        if (obj != null) {
            m14795a(1);
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        mo2643a(view, i, i2, iArr, 0);
    }

    /* renamed from: a */
    public void mo2643a(View view, int i, int i2, int[] iArr, int i3) {
        CoordinatorLayout coordinatorLayout = this;
        int childCount = getChildCount();
        Object obj = null;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0153e c0153e = (C0153e) childAt.getLayoutParams();
                if (c0153e.m358b(i3)) {
                    C0150b b = c0153e.m356b();
                    if (b != null) {
                        int max;
                        int max2;
                        int[] iArr2 = coordinatorLayout.f11860k;
                        coordinatorLayout.f11860k[1] = 0;
                        iArr2[0] = 0;
                        b.mo3314a(this, childAt, view, i, i2, coordinatorLayout.f11860k, i3);
                        if (i > 0) {
                            max = Math.max(i4, coordinatorLayout.f11860k[0]);
                        } else {
                            max = Math.min(i4, coordinatorLayout.f11860k[0]);
                        }
                        if (i2 > 0) {
                            max2 = Math.max(i5, coordinatorLayout.f11860k[1]);
                        } else {
                            max2 = Math.min(i5, coordinatorLayout.f11860k[1]);
                        }
                        i4 = max;
                        i5 = max2;
                        obj = 1;
                    }
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (obj != null) {
            m14795a(1);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0153e c0153e = (C0153e) childAt.getLayoutParams();
                if (c0153e.m358b(0)) {
                    C0150b b = c0153e.m356b();
                    if (b != null) {
                        z2 |= b.m330a(this, childAt, view, f, f2, z);
                    }
                }
            }
        }
        if (z2) {
            m14795a(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0153e c0153e = (C0153e) childAt.getLayoutParams();
                if (c0153e.m358b(0)) {
                    C0150b b = c0153e.m356b();
                    if (b != null) {
                        z |= b.mo57a(this, childAt, view, f, f2);
                    }
                }
            }
        }
        return z;
    }

    public int getNestedScrollAxes() {
        return this.f11873x.m1625a();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C3125g) {
            C3125g c3125g = (C3125g) parcelable;
            super.onRestoreInstanceState(c3125g.m1558a());
            parcelable = c3125g.f7996a;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                C0150b b = m14791a(childAt).m356b();
                if (!(id == -1 || b == null)) {
                    Parcelable parcelable2 = (Parcelable) parcelable.get(id);
                    if (parcelable2 != null) {
                        b.mo53a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c3125g = new C3125g(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0150b b = ((C0153e) childAt.getLayoutParams()).m356b();
            if (!(id == -1 || b == null)) {
                Parcelable b2 = b.mo59b(this, childAt);
                if (b2 != null) {
                    sparseArray.append(id, b2);
                }
            }
        }
        c3125g.f7996a = sparseArray;
        return c3125g;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        C0150b b = ((C0153e) view.getLayoutParams()).m356b();
        if (b == null || !b.mo3321a(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    /* renamed from: g */
    private void m14789g() {
        if (VERSION.SDK_INT >= 21) {
            if (C0517s.m1722p(this)) {
                if (this.f11872w == null) {
                    this.f11872w = new C31241(this);
                }
                C0517s.m1696a((View) this, this.f11872w);
                setSystemUiVisibility(1280);
            } else {
                C0517s.m1696a((View) this, null);
            }
        }
    }
}
