package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.C0140a.C0131b;
import android.support.design.C0140a.C0139j;
import android.support.design.widget.CoordinatorLayout.C0150b;
import android.support.design.widget.CoordinatorLayout.C0151c;
import android.support.design.widget.CoordinatorLayout.C0153e;
import android.support.v4.p028d.C0384a;
import android.support.v4.view.C0487a;
import android.support.v4.view.C0517s;
import android.support.v4.view.aa;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.List;

@C0151c(a = Behavior.class)
public class AppBarLayout extends LinearLayout {
    /* renamed from: a */
    private int f320a;
    /* renamed from: b */
    private int f321b;
    /* renamed from: c */
    private int f322c;
    /* renamed from: d */
    private boolean f323d;
    /* renamed from: e */
    private int f324e;
    /* renamed from: f */
    private aa f325f;
    /* renamed from: g */
    private List<C0145b> f326g;
    /* renamed from: h */
    private boolean f327h;
    /* renamed from: i */
    private boolean f328i;
    /* renamed from: j */
    private int[] f329j;

    /* renamed from: android.support.design.widget.AppBarLayout$a */
    public static class C0144a extends LayoutParams {
        /* renamed from: a */
        int f318a = 1;
        /* renamed from: b */
        Interpolator f319b;

        public C0144a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            attributeSet = context.obtainStyledAttributes(attributeSet, C0139j.AppBarLayout_Layout);
            this.f318a = attributeSet.getInt(C0139j.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (attributeSet.hasValue(C0139j.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f319b = AnimationUtils.loadInterpolator(context, attributeSet.getResourceId(C0139j.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            attributeSet.recycle();
        }

        public C0144a(int i, int i2) {
            super(i, i2);
        }

        public C0144a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0144a(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0144a(LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* renamed from: a */
        public int m292a() {
            return this.f318a;
        }

        /* renamed from: b */
        public Interpolator m293b() {
            return this.f319b;
        }

        /* renamed from: c */
        boolean m294c() {
            return (this.f318a & 1) == 1 && (this.f318a & 10) != 0;
        }
    }

    /* renamed from: android.support.design.widget.AppBarLayout$b */
    public interface C0145b {
        /* renamed from: a */
        void m295a(AppBarLayout appBarLayout, int i);
    }

    public static class Behavior extends C4443g<AppBarLayout> {
        /* renamed from: b */
        private int f13665b;
        /* renamed from: c */
        private ValueAnimator f13666c;
        /* renamed from: d */
        private int f13667d = -1;
        /* renamed from: e */
        private boolean f13668e;
        /* renamed from: f */
        private float f13669f;
        /* renamed from: g */
        private WeakReference<View> f13670g;
        /* renamed from: h */
        private C0142a f13671h;

        /* renamed from: android.support.design.widget.AppBarLayout$Behavior$a */
        public static abstract class C0142a {
            /* renamed from: a */
            public abstract boolean m288a(AppBarLayout appBarLayout);
        }

        /* renamed from: android.support.design.widget.AppBarLayout$Behavior$b */
        protected static class C3120b extends C0487a {
            public static final Creator<C3120b> CREATOR = new C01431();
            /* renamed from: a */
            int f7967a;
            /* renamed from: b */
            float f7968b;
            /* renamed from: c */
            boolean f7969c;

            /* renamed from: android.support.design.widget.AppBarLayout$Behavior$b$1 */
            static class C01431 implements ClassLoaderCreator<C3120b> {
                C01431() {
                }

                public /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return m289a(parcel);
                }

                public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return m290a(parcel, classLoader);
                }

                public /* synthetic */ Object[] newArray(int i) {
                    return m291a(i);
                }

                /* renamed from: a */
                public C3120b m290a(Parcel parcel, ClassLoader classLoader) {
                    return new C3120b(parcel, classLoader);
                }

                /* renamed from: a */
                public C3120b m289a(Parcel parcel) {
                    return new C3120b(parcel, null);
                }

                /* renamed from: a */
                public C3120b[] m291a(int i) {
                    return new C3120b[i];
                }
            }

            public C3120b(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f7967a = parcel.readInt();
                this.f7968b = parcel.readFloat();
                this.f7969c = parcel.readByte() != null ? true : null;
            }

            public C3120b(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f7967a);
                parcel.writeFloat(this.f7968b);
                parcel.writeByte((byte) this.f7969c);
            }
        }

        /* renamed from: a */
        private static boolean m17055a(int i, int i2) {
            return (i & i2) == i2;
        }

        /* renamed from: a */
        /* synthetic */ int mo3310a(View view) {
            return m17087c((AppBarLayout) view);
        }

        /* renamed from: b */
        public /* bridge */ /* synthetic */ int mo3317b() {
            return super.mo3317b();
        }

        /* renamed from: c */
        /* synthetic */ boolean mo3319c(View view) {
            return m17075a((AppBarLayout) view);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* renamed from: a */
        public boolean m17078a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            coordinatorLayout = ((i & 2) == null || appBarLayout.m307c() == null || coordinatorLayout.getHeight() - view.getHeight() > appBarLayout.getHeight()) ? null : true;
            if (!(coordinatorLayout == null || this.f13666c == null)) {
                this.f13666c.cancel();
            }
            this.f13670g = null;
            return coordinatorLayout;
        }

        /* renamed from: a */
        public void m17068a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            if (i2 != 0) {
                int i4;
                int downNestedPreScrollRange;
                if (i2 < 0) {
                    view = -appBarLayout.getTotalScrollRange();
                    i4 = view;
                    downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange() + view;
                } else {
                    i4 = -appBarLayout.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                if (i4 != downNestedPreScrollRange) {
                    iArr[1] = m14826b(coordinatorLayout, appBarLayout, i2, i4, downNestedPreScrollRange);
                }
            }
        }

        /* renamed from: a */
        public void m17067a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                m14826b(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
            }
        }

        /* renamed from: a */
        public void m17066a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            if (i == 0) {
                m17058c(coordinatorLayout, appBarLayout);
            }
            this.f13670g = new WeakReference(view);
        }

        /* renamed from: a */
        private void m17052a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f) {
            int round;
            int abs = Math.abs(mo3308a() - i);
            f = Math.abs(f);
            if (f > 0.0f) {
                round = Math.round((((float) abs) / f) * 1000.0f) * 3;
            } else {
                round = (int) (((((float) abs) / ((float) appBarLayout.getHeight())) + 1.0f) * 150.0f);
            }
            m17053a(coordinatorLayout, appBarLayout, i, round);
        }

        /* renamed from: a */
        private void m17053a(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i, int i2) {
            if (mo3308a() == i) {
                if (!(this.f13666c == null || this.f13666c.isRunning() == null)) {
                    this.f13666c.cancel();
                }
                return;
            }
            if (this.f13666c == null) {
                this.f13666c = new ValueAnimator();
                this.f13666c.setInterpolator(C0166a.f366e);
                this.f13666c.addUpdateListener(new AnimatorUpdateListener(this) {
                    /* renamed from: c */
                    final /* synthetic */ Behavior f317c;

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f317c.a_(coordinatorLayout, appBarLayout, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                this.f13666c.cancel();
            }
            this.f13666c.setDuration((long) Math.min(i2, 600));
            this.f13666c.setIntValues(new int[]{r0, i});
            this.f13666c.start();
        }

        /* renamed from: a */
        private int m17051a(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                int i3 = -i;
                if (childAt.getTop() <= i3 && childAt.getBottom() >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        /* renamed from: c */
        private void m17058c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int a = mo3308a();
            int a2 = m17051a(appBarLayout, a);
            if (a2 >= 0) {
                View childAt = appBarLayout.getChildAt(a2);
                int a3 = ((C0144a) childAt.getLayoutParams()).m292a();
                if ((a3 & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (a2 == appBarLayout.getChildCount() - 1) {
                        i2 += appBarLayout.getTopInset();
                    }
                    if (m17055a(a3, 2)) {
                        i2 += C0517s.m1716j(childAt);
                    } else if (m17055a(a3, 5)) {
                        int j = C0517s.m1716j(childAt) + i2;
                        if (a < j) {
                            i = j;
                        } else {
                            i2 = j;
                        }
                    }
                    if (a < (i2 + i) / 2) {
                        i = i2;
                    }
                    m17052a(coordinatorLayout, appBarLayout, C0384a.m1163a(i, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        /* renamed from: a */
        public boolean m17077a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((C0153e) appBarLayout.getLayoutParams()).height != -2) {
                return super.mo2648a(coordinatorLayout, (View) appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.m14797a((View) appBarLayout, i, i2, MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        /* renamed from: a */
        public boolean m17076a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            i = super.mo55a(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            if (this.f13667d >= 0 && (pendingAction & 8) == 0) {
                View childAt = appBarLayout.getChildAt(this.f13667d);
                int i2 = -childAt.getBottom();
                if (this.f13668e) {
                    i2 += C0517s.m1716j(childAt) + appBarLayout.getTopInset();
                } else {
                    i2 += Math.round(((float) childAt.getHeight()) * this.f13669f);
                }
                a_(coordinatorLayout, appBarLayout, i2);
            } else if (pendingAction != 0) {
                Object obj = (pendingAction & 4) != 0 ? 1 : null;
                if ((pendingAction & 2) != 0) {
                    pendingAction = -appBarLayout.getUpNestedPreScrollRange();
                    if (obj != null) {
                        m17052a(coordinatorLayout, appBarLayout, pendingAction, 0.0f);
                    } else {
                        a_(coordinatorLayout, appBarLayout, pendingAction);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (obj != null) {
                        m17052a(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        a_(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.m308d();
            this.f13667d = -1;
            mo3315a(C0384a.m1163a(mo3317b(), -appBarLayout.getTotalScrollRange(), 0));
            m17054a(coordinatorLayout, appBarLayout, mo3317b(), 0, true);
            appBarLayout.m303a(mo3317b());
            return i;
        }

        /* renamed from: a */
        boolean m17075a(AppBarLayout appBarLayout) {
            if (this.f13671h != null) {
                return this.f13671h.m288a(appBarLayout);
            }
            boolean z = true;
            if (this.f13670g == null) {
                return true;
            }
            View view = (View) this.f13670g.get();
            if (view == null || !view.isShown() || view.canScrollVertically(-1) != null) {
                z = false;
            }
            return z;
        }

        /* renamed from: a */
        void m17064a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            m17058c(coordinatorLayout, appBarLayout);
        }

        /* renamed from: b */
        int m17083b(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        /* renamed from: c */
        int m17087c(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* renamed from: a */
        int m17061a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int a = mo3308a();
            int i4 = 0;
            if (i2 == 0 || a < i2 || a > i3) {
                this.f13665b = 0;
            } else {
                int a2 = C0384a.m1163a(i, i2, i3);
                if (a != a2) {
                    i = appBarLayout.m306b() != 0 ? m17056b(appBarLayout, a2) : a2;
                    i2 = mo3315a(i);
                    i4 = a - a2;
                    this.f13665b = a2 - i;
                    if (i2 == 0 && appBarLayout.m306b() != 0) {
                        coordinatorLayout.m14806b((View) appBarLayout);
                    }
                    appBarLayout.m303a(mo3317b());
                    m17054a(coordinatorLayout, appBarLayout, a2, a2 < a ? -1 : 1, false);
                }
            }
            return i4;
        }

        /* renamed from: b */
        private int m17056b(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = appBarLayout.getChildAt(i3);
                C0144a c0144a = (C0144a) childAt.getLayoutParams();
                Interpolator b = c0144a.m293b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i3++;
                } else {
                    if (b != null) {
                        childCount = c0144a.m292a();
                        if ((childCount & 1) != 0) {
                            i2 = 0 + ((childAt.getHeight() + c0144a.topMargin) + c0144a.bottomMargin);
                            if ((childCount & 2) != 0) {
                                i2 -= C0517s.m1716j(childAt);
                            }
                        }
                        if (C0517s.m1722p(childAt)) {
                            i2 -= appBarLayout.getTopInset();
                        }
                        if (i2 > 0) {
                            appBarLayout = (float) i2;
                            return Integer.signum(i) * (childAt.getTop() + Math.round(appBarLayout * b.getInterpolation(((float) (abs - childAt.getTop())) / appBarLayout)));
                        }
                    }
                    return i;
                }
            }
            return i;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        private void m17054a(android.support.design.widget.CoordinatorLayout r6, android.support.design.widget.AppBarLayout r7, int r8, int r9, boolean r10) {
            /*
            r5 = this;
            r0 = m17057c(r7, r8);
            if (r0 == 0) goto L_0x0058;
        L_0x0006:
            r1 = r0.getLayoutParams();
            r1 = (android.support.design.widget.AppBarLayout.C0144a) r1;
            r1 = r1.m292a();
            r2 = r1 & 1;
            r3 = 0;
            if (r2 == 0) goto L_0x0041;
        L_0x0015:
            r2 = android.support.v4.view.C0517s.m1716j(r0);
            r4 = 1;
            if (r9 <= 0) goto L_0x002f;
        L_0x001c:
            r9 = r1 & 12;
            if (r9 == 0) goto L_0x002f;
        L_0x0020:
            r8 = -r8;
            r9 = r0.getBottom();
            r9 = r9 - r2;
            r0 = r7.getTopInset();
            r9 = r9 - r0;
            if (r8 < r9) goto L_0x0041;
        L_0x002d:
            r3 = 1;
            goto L_0x0041;
        L_0x002f:
            r9 = r1 & 2;
            if (r9 == 0) goto L_0x0041;
        L_0x0033:
            r8 = -r8;
            r9 = r0.getBottom();
            r9 = r9 - r2;
            r0 = r7.getTopInset();
            r9 = r9 - r0;
            if (r8 < r9) goto L_0x0041;
        L_0x0040:
            goto L_0x002d;
        L_0x0041:
            r8 = r7.m305a(r3);
            r9 = android.os.Build.VERSION.SDK_INT;
            r0 = 11;
            if (r9 < r0) goto L_0x0058;
        L_0x004b:
            if (r10 != 0) goto L_0x0055;
        L_0x004d:
            if (r8 == 0) goto L_0x0058;
        L_0x004f:
            r6 = r5.m17059d(r6, r7);
            if (r6 == 0) goto L_0x0058;
        L_0x0055:
            r7.jumpDrawablesToCurrentState();
        L_0x0058:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.AppBarLayout.Behavior.a(android.support.design.widget.CoordinatorLayout, android.support.design.widget.AppBarLayout, int, int, boolean):void");
        }

        /* renamed from: d */
        private boolean m17059d(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            coordinatorLayout = coordinatorLayout.m14815d((View) appBarLayout);
            appBarLayout = coordinatorLayout.size();
            boolean z = false;
            for (int i = 0; i < appBarLayout; i++) {
                C0150b b = ((C0153e) ((View) coordinatorLayout.get(i)).getLayoutParams()).m356b();
                if (b instanceof ScrollingViewBehavior) {
                    if (((ScrollingViewBehavior) b).m14839d() != null) {
                        z = true;
                    }
                    return z;
                }
            }
            return false;
        }

        /* renamed from: c */
        private static View m17057c(AppBarLayout appBarLayout, int i) {
            i = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (i >= childAt.getTop() && i <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        /* renamed from: a */
        int mo3308a() {
            return mo3317b() + this.f13665b;
        }

        /* renamed from: b */
        public Parcelable m17085b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            coordinatorLayout = super.mo59b(coordinatorLayout, appBarLayout);
            int b = mo3317b();
            int childCount = appBarLayout.getChildCount();
            boolean z = false;
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + b;
                if (childAt.getTop() + b > 0 || bottom < 0) {
                    i++;
                } else {
                    Parcelable c3120b = new C3120b(coordinatorLayout);
                    c3120b.f7967a = i;
                    if (bottom == C0517s.m1716j(childAt) + appBarLayout.getTopInset()) {
                        z = true;
                    }
                    c3120b.f7969c = z;
                    c3120b.f7968b = ((float) bottom) / ((float) childAt.getHeight());
                    return c3120b;
                }
            }
            return coordinatorLayout;
        }

        /* renamed from: a */
        public void m17065a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof C3120b) {
                C3120b c3120b = (C3120b) parcelable;
                super.mo53a(coordinatorLayout, (View) appBarLayout, c3120b.m1558a());
                this.f13667d = c3120b.f7967a;
                this.f13669f = c3120b.f7968b;
                this.f13668e = c3120b.f7969c;
                return;
            }
            super.mo53a(coordinatorLayout, (View) appBarLayout, parcelable);
            this.f13667d = -1;
        }
    }

    public static class ScrollingViewBehavior extends C4444h {
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo2648a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.mo2648a(coordinatorLayout, view, i, i2, i3, i4);
        }

        /* renamed from: b */
        public /* bridge */ /* synthetic */ int mo3317b() {
            return super.mo3317b();
        }

        /* renamed from: b */
        /* synthetic */ View mo3324b(List list) {
            return m17092a(list);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, C0139j.ScrollingViewBehavior_Layout);
            m14836b((int) context.getDimensionPixelSize(C0139j.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            context.recycle();
        }

        /* renamed from: a */
        public boolean mo3322a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        /* renamed from: b */
        public boolean mo68b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            m17090e(coordinatorLayout, view, view2);
            return null;
        }

        /* renamed from: a */
        public boolean mo3321a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout a = m17092a(coordinatorLayout.m14810c(view));
            if (a != null) {
                rect.offset(view.getLeft(), view.getTop());
                view = this.a;
                view.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (view.contains(rect) == null) {
                    a.m304a(false, z ^ 1);
                    return true;
                }
            }
            return false;
        }

        /* renamed from: e */
        private void m17090e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            coordinatorLayout = ((C0153e) view2.getLayoutParams()).m356b();
            if (coordinatorLayout instanceof Behavior) {
                C0517s.m1707c(view, (((view2.getBottom() - view.getTop()) + ((Behavior) coordinatorLayout).f13665b) + m14832a()) - m14838c(view2));
            }
        }

        /* renamed from: a */
        float mo3320a(View view) {
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                view = m17089a(appBarLayout);
                if (downNestedPreScrollRange != 0 && totalScrollRange + view <= downNestedPreScrollRange) {
                    return 0.0f;
                }
                totalScrollRange -= downNestedPreScrollRange;
                if (totalScrollRange != 0) {
                    return (((float) view) / ((float) totalScrollRange)) + 1.0f;
                }
            }
            return 0.0f;
        }

        /* renamed from: a */
        private static int m17089a(AppBarLayout appBarLayout) {
            appBarLayout = ((C0153e) appBarLayout.getLayoutParams()).m356b();
            return appBarLayout instanceof Behavior ? ((Behavior) appBarLayout).mo3308a() : null;
        }

        /* renamed from: a */
        AppBarLayout m17092a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        /* renamed from: b */
        int mo3323b(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.mo3323b(view);
        }
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m300a();
    }

    /* renamed from: generateDefaultLayoutParams */
    protected /* synthetic */ LayoutParams m44624generateDefaultLayoutParams() {
        return m300a();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m301a(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m302a(layoutParams);
    }

    /* renamed from: generateLayoutParams */
    public /* synthetic */ LayoutParams m44625generateLayoutParams(AttributeSet attributeSet) {
        return m301a(attributeSet);
    }

    /* renamed from: generateLayoutParams */
    protected /* synthetic */ LayoutParams m44626generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m302a(layoutParams);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m299f();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m299f();
        z = false;
        this.f323d = false;
        boolean childCount = getChildCount();
        while (z < childCount) {
            if (((C0144a) getChildAt(z).getLayoutParams()).m293b() != 0) {
                this.f323d = true;
                break;
            }
            z++;
        }
        m298e();
    }

    /* renamed from: e */
    private void m298e() {
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            if (((C0144a) getChildAt(i).getLayoutParams()).m294c()) {
                z = true;
                break;
            }
        }
        m297b(z);
    }

    /* renamed from: f */
    private void m299f() {
        this.f320a = -1;
        this.f321b = -1;
        this.f322c = -1;
    }

    public void setOrientation(int i) {
        if (i == 1) {
            super.setOrientation(i);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setExpanded(boolean z) {
        m304a(z, C0517s.m1730x(this));
    }

    /* renamed from: a */
    public void m304a(boolean z, boolean z2) {
        m296a(z, z2, true);
    }

    /* renamed from: a */
    private void m296a(boolean z, boolean z2, boolean z3) {
        int i = 0;
        z = (z ? true : true) | (z2 ? true : false);
        if (z3) {
            i = 8;
        }
        this.f324e = z | i;
        requestLayout();
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0144a;
    }

    /* renamed from: a */
    protected C0144a m300a() {
        return new C0144a(-1, -2);
    }

    /* renamed from: a */
    public C0144a m301a(AttributeSet attributeSet) {
        return new C0144a(getContext(), attributeSet);
    }

    /* renamed from: a */
    protected C0144a m302a(ViewGroup.LayoutParams layoutParams) {
        if (VERSION.SDK_INT >= 19 && (layoutParams instanceof LayoutParams)) {
            return new C0144a((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new C0144a((MarginLayoutParams) layoutParams);
        }
        return new C0144a(layoutParams);
    }

    /* renamed from: b */
    boolean m306b() {
        return this.f323d;
    }

    public final int getTotalScrollRange() {
        if (this.f320a != -1) {
            return this.f320a;
        }
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0144a c0144a = (C0144a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = c0144a.f318a;
            if ((i3 & 1) == 0) {
                break;
            }
            i += (measuredHeight + c0144a.topMargin) + c0144a.bottomMargin;
            if ((i3 & 2) != 0) {
                i -= C0517s.m1716j(childAt);
                break;
            }
        }
        childCount = Math.max(0, i - getTopInset());
        this.f320a = childCount;
        return childCount;
    }

    /* renamed from: c */
    boolean m307c() {
        return getTotalScrollRange() != 0;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    int getDownNestedPreScrollRange() {
        if (this.f321b != -1) {
            return this.f321b;
        }
        int childCount;
        int i = 0;
        for (childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            C0144a c0144a = (C0144a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i2 = c0144a.f318a;
            if ((i2 & 5) == 5) {
                i += c0144a.topMargin + c0144a.bottomMargin;
                if ((i2 & 8) != 0) {
                    i += C0517s.m1716j(childAt);
                } else if ((i2 & 2) != 0) {
                    i += measuredHeight - C0517s.m1716j(childAt);
                } else {
                    i += measuredHeight - getTopInset();
                }
            } else if (i > 0) {
                break;
            }
        }
        childCount = Math.max(0, i);
        this.f321b = childCount;
        return childCount;
    }

    int getDownNestedScrollRange() {
        if (this.f322c != -1) {
            return this.f322c;
        }
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0144a c0144a = (C0144a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (c0144a.topMargin + c0144a.bottomMargin);
            int i3 = c0144a.f318a;
            if ((i3 & 1) == 0) {
                break;
            }
            i += measuredHeight;
            if ((i3 & 2) != 0) {
                i -= C0517s.m1716j(childAt) + getTopInset();
                break;
            }
        }
        childCount = Math.max(0, i);
        this.f322c = childCount;
        return childCount;
    }

    /* renamed from: a */
    void m303a(int i) {
        if (this.f326g != null) {
            int size = this.f326g.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0145b c0145b = (C0145b) this.f326g.get(i2);
                if (c0145b != null) {
                    c0145b.m295a(this, i);
                }
            }
        }
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int j = C0517s.m1716j(this);
        if (j != 0) {
            return (j * 2) + topInset;
        }
        j = getChildCount();
        j = j >= 1 ? C0517s.m1716j(getChildAt(j - 1)) : 0;
        if (j != 0) {
            return (j * 2) + topInset;
        }
        return getHeight() / 3;
    }

    protected int[] onCreateDrawableState(int i) {
        if (this.f329j == null) {
            this.f329j = new int[2];
        }
        int[] iArr = this.f329j;
        i = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.f327h ? C0131b.state_collapsible : -C0131b.state_collapsible;
        int i2 = (this.f327h && this.f328i) ? C0131b.state_collapsed : -C0131b.state_collapsed;
        iArr[1] = i2;
        return mergeDrawableStates(i, iArr);
    }

    /* renamed from: b */
    private boolean m297b(boolean z) {
        if (this.f327h == z) {
            return false;
        }
        this.f327h = z;
        refreshDrawableState();
        return true;
    }

    /* renamed from: a */
    boolean m305a(boolean z) {
        if (this.f328i == z) {
            return false;
        }
        this.f328i = z;
        refreshDrawableState();
        return true;
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (VERSION.SDK_INT >= 21) {
            C0200r.m461a(this, f);
        }
    }

    int getPendingAction() {
        return this.f324e;
    }

    /* renamed from: d */
    void m308d() {
        this.f324e = 0;
    }

    final int getTopInset() {
        return this.f325f != null ? this.f325f.m1563b() : 0;
    }
}
