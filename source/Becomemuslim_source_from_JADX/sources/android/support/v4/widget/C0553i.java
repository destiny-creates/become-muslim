package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.content.C0366b;
import android.support.v4.p020a.p021a.C0259a;
import android.support.v4.view.C0487a;
import android.support.v4.view.C0494b;
import android.support.v4.view.C0501e;
import android.support.v4.view.C0517s;
import android.support.v4.view.p033a.C0483b;
import android.support.v4.view.p033a.C0483b.C0480a;
import android.support.v4.widget.C0579u.C0578a;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.imageutils.JfifUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DrawerLayout */
/* renamed from: android.support.v4.widget.i */
public class C0553i extends ViewGroup {
    private static final boolean ALLOW_EDGE_LOCK = false;
    static final boolean CAN_HIDE_DESCENDANTS = (VERSION.SDK_INT >= 19 ? CHILDREN_DISALLOW_INTERCEPT : false);
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    private static final int DRAWER_ELEVATION = 10;
    static final int[] LAYOUT_ATTRS = new int[]{16842931};
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final int[] THEME_ATTRS = new int[]{16843828};
    private static final float TOUCH_SLOP_SENSITIVITY = 1.0f;
    private final C3237b mChildAccessibilityDelegate;
    private boolean mChildrenCanceledTouch;
    private boolean mDisallowInterceptRequested;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final C3239f mLeftCallback;
    private final C0579u mLeftDragger;
    private C0549c mListener;
    private List<C0549c> mListeners;
    private int mLockModeEnd;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mLockModeStart;
    private int mMinDrawerMargin;
    private final ArrayList<View> mNonDrawerViews;
    private final C3239f mRightCallback;
    private final C0579u mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowEnd;
    private Drawable mShadowLeft;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;

    /* compiled from: DrawerLayout */
    /* renamed from: android.support.v4.widget.i$1 */
    class C05481 implements OnApplyWindowInsetsListener {
        /* renamed from: a */
        final /* synthetic */ C0553i f1389a;

        C05481(C0553i c0553i) {
            this.f1389a = c0553i;
        }

        @TargetApi(21)
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((C0553i) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0 ? C0553i.CHILDREN_DISALLOW_INTERCEPT : false);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    /* compiled from: DrawerLayout */
    /* renamed from: android.support.v4.widget.i$c */
    public interface C0549c {
        void onDrawerClosed(View view);

        void onDrawerOpened(View view);

        void onDrawerSlide(View view, float f);

        void onDrawerStateChanged(int i);
    }

    /* compiled from: DrawerLayout */
    /* renamed from: android.support.v4.widget.i$d */
    public static class C0550d extends MarginLayoutParams {
        /* renamed from: a */
        public int f1390a = 0;
        /* renamed from: b */
        float f1391b;
        /* renamed from: c */
        boolean f1392c;
        /* renamed from: d */
        int f1393d;

        public C0550d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, C0553i.LAYOUT_ATTRS);
            this.f1390a = context.getInt(0, 0);
            context.recycle();
        }

        public C0550d(int i, int i2) {
            super(i, i2);
        }

        public C0550d(C0550d c0550d) {
            super(c0550d);
            this.f1390a = c0550d.f1390a;
        }

        public C0550d(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0550d(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* compiled from: DrawerLayout */
    /* renamed from: android.support.v4.widget.i$a */
    class C3236a extends C0494b {
        /* renamed from: a */
        final /* synthetic */ C0553i f8313a;
        /* renamed from: b */
        private final Rect f8314b = new Rect();

        C3236a(C0553i c0553i) {
            this.f8313a = c0553i;
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0483b c0483b) {
            if (C0553i.CAN_HIDE_DESCENDANTS) {
                super.onInitializeAccessibilityNodeInfo(view, c0483b);
            } else {
                C0483b a = C0483b.m1498a(c0483b);
                super.onInitializeAccessibilityNodeInfo(view, a);
                c0483b.m1504a(view);
                ViewParent f = C0517s.m1712f(view);
                if (f instanceof View) {
                    c0483b.m1516c((View) f);
                }
                m9822a(c0483b, a);
                a.m1549s();
                m9823a(c0483b, (ViewGroup) view);
            }
            c0483b.m1512b(C0553i.class.getName());
            c0483b.m1518c(false);
            c0483b.m1523d(false);
            c0483b.m1508a(C0480a.f1222a);
            c0483b.m1508a(C0480a.f1223b);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(C0553i.class.getName());
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            view = accessibilityEvent.getText();
            accessibilityEvent = this.f8313a.findVisibleDrawer();
            if (accessibilityEvent != null) {
                accessibilityEvent = this.f8313a.getDrawerTitle(this.f8313a.getDrawerViewAbsoluteGravity(accessibilityEvent));
                if (accessibilityEvent != null) {
                    view.add(accessibilityEvent);
                }
            }
            return C0553i.CHILDREN_DISALLOW_INTERCEPT;
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!C0553i.CAN_HIDE_DESCENDANTS) {
                if (!C0553i.includeChildForAccessibility(view)) {
                    return null;
                }
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        /* renamed from: a */
        private void m9823a(C0483b c0483b, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (C0553i.includeChildForAccessibility(childAt)) {
                    c0483b.m1511b(childAt);
                }
            }
        }

        /* renamed from: a */
        private void m9822a(C0483b c0483b, C0483b c0483b2) {
            Rect rect = this.f8314b;
            c0483b2.m1503a(rect);
            c0483b.m1510b(rect);
            c0483b2.m1515c(rect);
            c0483b.m1520d(rect);
            c0483b.m1526e(c0483b2.m1532g());
            c0483b.m1505a(c0483b2.m1545o());
            c0483b.m1512b(c0483b2.m1546p());
            c0483b.m1522d(c0483b2.m1548r());
            c0483b.m1537j(c0483b2.m1542l());
            c0483b.m1533h(c0483b2.m1538j());
            c0483b.m1518c(c0483b2.m1527e());
            c0483b.m1523d(c0483b2.m1530f());
            c0483b.m1529f(c0483b2.m1534h());
            c0483b.m1531g(c0483b2.m1536i());
            c0483b.m1535i(c0483b2.m1540k());
            c0483b.m1502a(c0483b2.m1509b());
        }
    }

    /* compiled from: DrawerLayout */
    /* renamed from: android.support.v4.widget.i$b */
    static final class C3237b extends C0494b {
        C3237b() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0483b c0483b) {
            super.onInitializeAccessibilityNodeInfo(view, c0483b);
            if (C0553i.includeChildForAccessibility(view) == null) {
                c0483b.m1516c(null);
            }
        }
    }

    /* compiled from: DrawerLayout */
    /* renamed from: android.support.v4.widget.i$e */
    protected static class C3238e extends C0487a {
        public static final Creator<C3238e> CREATOR = new C05511();
        /* renamed from: a */
        int f8315a = null;
        /* renamed from: b */
        int f8316b;
        /* renamed from: c */
        int f8317c;
        /* renamed from: e */
        int f8318e;
        /* renamed from: f */
        int f8319f;

        /* compiled from: DrawerLayout */
        /* renamed from: android.support.v4.widget.i$e$1 */
        static class C05511 implements ClassLoaderCreator<C3238e> {
            C05511() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1876a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m1877a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1878a(i);
            }

            /* renamed from: a */
            public C3238e m1877a(Parcel parcel, ClassLoader classLoader) {
                return new C3238e(parcel, classLoader);
            }

            /* renamed from: a */
            public C3238e m1876a(Parcel parcel) {
                return new C3238e(parcel, null);
            }

            /* renamed from: a */
            public C3238e[] m1878a(int i) {
                return new C3238e[i];
            }
        }

        public C3238e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8315a = parcel.readInt();
            this.f8316b = parcel.readInt();
            this.f8317c = parcel.readInt();
            this.f8318e = parcel.readInt();
            this.f8319f = parcel.readInt();
        }

        public C3238e(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f8315a);
            parcel.writeInt(this.f8316b);
            parcel.writeInt(this.f8317c);
            parcel.writeInt(this.f8318e);
            parcel.writeInt(this.f8319f);
        }
    }

    /* compiled from: DrawerLayout */
    /* renamed from: android.support.v4.widget.i$f */
    private class C3239f extends C0578a {
        /* renamed from: a */
        final /* synthetic */ C0553i f8320a;
        /* renamed from: b */
        private final int f8321b;
        /* renamed from: c */
        private C0579u f8322c;
        /* renamed from: d */
        private final Runnable f8323d = new C05521(this);

        /* compiled from: DrawerLayout */
        /* renamed from: android.support.v4.widget.i$f$1 */
        class C05521 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C3239f f1394a;

            C05521(C3239f c3239f) {
                this.f1394a = c3239f;
            }

            public void run() {
                this.f1394a.m9835b();
            }
        }

        /* renamed from: b */
        public boolean mo339b(int i) {
            return false;
        }

        C3239f(C0553i c0553i, int i) {
            this.f8320a = c0553i;
            this.f8321b = i;
        }

        /* renamed from: a */
        public void m9829a(C0579u c0579u) {
            this.f8322c = c0579u;
        }

        /* renamed from: a */
        public void m9826a() {
            this.f8320a.removeCallbacks(this.f8323d);
        }

        /* renamed from: a */
        public boolean mo51a(View view, int i) {
            return (this.f8320a.isDrawerView(view) == 0 || this.f8320a.checkDrawerViewAbsoluteGravity(view, this.f8321b) == 0 || this.f8320a.getDrawerLockMode(view) != null) ? null : C0553i.CHILDREN_DISALLOW_INTERCEPT;
        }

        /* renamed from: a */
        public void mo48a(int i) {
            this.f8320a.updateDrawerState(this.f8321b, i, this.f8322c.m1953c());
        }

        /* renamed from: a */
        public void mo50a(View view, int i, int i2, int i3, int i4) {
            i2 = view.getWidth();
            if (this.f8320a.checkDrawerViewAbsoluteGravity(view, 3) != 0) {
                i = ((float) (i + i2)) / ((float) i2);
            } else {
                i = ((float) (this.f8320a.getWidth() - i)) / ((float) i2);
            }
            this.f8320a.setDrawerViewOffset(view, i);
            view.setVisibility(i == 0 ? 4 : 0);
            this.f8320a.invalidate();
        }

        /* renamed from: b */
        public void mo75b(View view, int i) {
            ((C0550d) view.getLayoutParams()).f1392c = false;
            m9824c();
        }

        /* renamed from: c */
        private void m9824c() {
            int i = 3;
            if (this.f8321b == 3) {
                i = 5;
            }
            View findDrawerWithGravity = this.f8320a.findDrawerWithGravity(i);
            if (findDrawerWithGravity != null) {
                this.f8320a.closeDrawer(findDrawerWithGravity);
            }
        }

        /* renamed from: a */
        public void mo49a(View view, float f, float f2) {
            int i;
            f2 = this.f8320a.getDrawerViewOffset(view);
            int width = view.getWidth();
            if (this.f8320a.checkDrawerViewAbsoluteGravity(view, 3)) {
                f = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (f <= null) {
                    if (f != null || f2 <= 0.5f) {
                        i = -width;
                    }
                }
                i = 0;
            } else {
                int width2 = this.f8320a.getWidth();
                if (f < 0.0f || (f == 0.0f && f2 > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.f8322c.m1943a(i, view.getTop());
            this.f8320a.invalidate();
        }

        /* renamed from: a */
        public void mo337a(int i, int i2) {
            this.f8320a.postDelayed(this.f8323d, 160);
        }

        /* renamed from: b */
        void m9835b() {
            View findDrawerWithGravity;
            int b = this.f8322c.m1947b();
            int i = 0;
            Object obj = this.f8321b == 3 ? 1 : null;
            if (obj != null) {
                findDrawerWithGravity = this.f8320a.findDrawerWithGravity(3);
                if (findDrawerWithGravity != null) {
                    i = -findDrawerWithGravity.getWidth();
                }
                i += b;
            } else {
                findDrawerWithGravity = this.f8320a.findDrawerWithGravity(5);
                i = this.f8320a.getWidth() - b;
            }
            if (findDrawerWithGravity == null) {
                return;
            }
            if (((obj != null && findDrawerWithGravity.getLeft() < i) || (obj == null && findDrawerWithGravity.getLeft() > i)) && this.f8320a.getDrawerLockMode(findDrawerWithGravity) == 0) {
                C0550d c0550d = (C0550d) findDrawerWithGravity.getLayoutParams();
                this.f8322c.m1945a(findDrawerWithGravity, i, findDrawerWithGravity.getTop());
                c0550d.f1392c = C0553i.CHILDREN_DISALLOW_INTERCEPT;
                this.f8320a.invalidate();
                m9824c();
                this.f8320a.cancelChildViewTouch();
            }
        }

        /* renamed from: b */
        public void mo338b(int i, int i2) {
            View findDrawerWithGravity;
            if ((i & 1) == 1) {
                findDrawerWithGravity = this.f8320a.findDrawerWithGravity(3);
            } else {
                findDrawerWithGravity = this.f8320a.findDrawerWithGravity(5);
            }
            if (findDrawerWithGravity != 0 && this.f8320a.getDrawerLockMode(findDrawerWithGravity) == 0) {
                this.f8322c.m1942a(findDrawerWithGravity, i2);
            }
        }

        /* renamed from: b */
        public int mo74b(View view) {
            return this.f8320a.isDrawerView(view) ? view.getWidth() : null;
        }

        /* renamed from: b */
        public int mo52b(View view, int i, int i2) {
            if (this.f8320a.checkDrawerViewAbsoluteGravity(view, 3) != 0) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            i2 = this.f8320a.getWidth();
            return Math.max(i2 - view.getWidth(), Math.min(i, i2));
        }

        /* renamed from: a */
        public int mo47a(View view, int i, int i2) {
            return view.getTop();
        }
    }

    static {
        boolean z = CHILDREN_DISALLOW_INTERCEPT;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        SET_DRAWER_SHADOW_FROM_ELEVATION = z;
    }

    public C0553i(Context context) {
        this(context, null);
    }

    public C0553i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0553i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChildAccessibilityDelegate = new C3237b();
        this.mScrimColor = DEFAULT_SCRIM_COLOR;
        this.mScrimPaint = new Paint();
        this.mFirstLayout = CHILDREN_DISALLOW_INTERCEPT;
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeStart = 3;
        this.mLockModeEnd = 3;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.mLeftCallback = new C3239f(this, 3);
        this.mRightCallback = new C3239f(this, 5);
        this.mLeftDragger = C0579u.m1921a((ViewGroup) this, (float) TOUCH_SLOP_SENSITIVITY, this.mLeftCallback);
        this.mLeftDragger.m1941a(1);
        this.mLeftDragger.m1940a(f2);
        this.mLeftCallback.m9829a(this.mLeftDragger);
        this.mRightDragger = C0579u.m1921a((ViewGroup) this, (float) TOUCH_SLOP_SENSITIVITY, this.mRightCallback);
        this.mRightDragger.m1941a(2);
        this.mRightDragger.m1940a(f2);
        this.mRightCallback.m9829a(this.mRightDragger);
        setFocusableInTouchMode(CHILDREN_DISALLOW_INTERCEPT);
        C0517s.m1688a((View) this, 1);
        C0517s.m1695a((View) this, new C3236a(this));
        setMotionEventSplittingEnabled(false);
        if (C0517s.m1722p(this) != 0) {
            if (VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new C05481(this));
                setSystemUiVisibility(1280);
                context = context.obtainStyledAttributes(THEME_ATTRS);
                try {
                    this.mStatusBarBackground = context.getDrawable(0);
                } finally {
                    context.recycle();
                }
            } else {
                this.mStatusBarBackground = null;
            }
        }
        this.mDrawerElevation = f * 10.0f;
        this.mNonDrawerViews = new ArrayList();
    }

    public void setDrawerElevation(float f) {
        this.mDrawerElevation = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (isDrawerView(childAt)) {
                C0517s.m1687a(childAt, this.mDrawerElevation);
            }
        }
    }

    public float getDrawerElevation() {
        return SET_DRAWER_SHADOW_FROM_ELEVATION ? this.mDrawerElevation : 0.0f;
    }

    public void setChildInsets(Object obj, boolean z) {
        this.mLastInsets = obj;
        this.mDrawStatusBarBackground = z;
        obj = (z || getBackground() != null) ? null : CHILDREN_DISALLOW_INTERCEPT;
        setWillNotDraw(obj);
        requestLayout();
    }

    public void setDrawerShadow(Drawable drawable, int i) {
        if (!SET_DRAWER_SHADOW_FROM_ELEVATION) {
            if ((i & 8388611) == 8388611) {
                this.mShadowStart = drawable;
            } else if ((i & 8388613) == 8388613) {
                this.mShadowEnd = drawable;
            } else if ((i & 3) == 3) {
                this.mShadowLeft = drawable;
            } else if ((i & 5) == 5) {
                this.mShadowRight = drawable;
            } else {
                return;
            }
            resolveShadowDrawables();
            invalidate();
        }
    }

    public void setDrawerShadow(int i, int i2) {
        setDrawerShadow(C0366b.m1103a(getContext(), i), i2);
    }

    public void setScrimColor(int i) {
        this.mScrimColor = i;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(C0549c c0549c) {
        if (this.mListener != null) {
            removeDrawerListener(this.mListener);
        }
        if (c0549c != null) {
            addDrawerListener(c0549c);
        }
        this.mListener = c0549c;
    }

    public void addDrawerListener(C0549c c0549c) {
        if (c0549c != null) {
            if (this.mListeners == null) {
                this.mListeners = new ArrayList();
            }
            this.mListeners.add(c0549c);
        }
    }

    public void removeDrawerListener(C0549c c0549c) {
        if (c0549c != null && this.mListeners != null) {
            this.mListeners.remove(c0549c);
        }
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerLockMode(int i, int i2) {
        int a = C0501e.m1587a(i2, C0517s.m1711e(this));
        if (i2 == 3) {
            this.mLockModeLeft = i;
        } else if (i2 == 5) {
            this.mLockModeRight = i;
        } else if (i2 == 8388611) {
            this.mLockModeStart = i;
        } else if (i2 == 8388613) {
            this.mLockModeEnd = i;
        }
        if (i != 0) {
            (a == 3 ? this.mLeftDragger : this.mRightDragger).m1959e();
        }
        View findDrawerWithGravity;
        switch (i) {
            case 1:
                findDrawerWithGravity = findDrawerWithGravity(a);
                if (findDrawerWithGravity != 0) {
                    closeDrawer(findDrawerWithGravity);
                    return;
                }
                return;
            case 2:
                findDrawerWithGravity = findDrawerWithGravity(a);
                if (findDrawerWithGravity != 0) {
                    openDrawer(findDrawerWithGravity);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setDrawerLockMode(int i, View view) {
        if (isDrawerView(view)) {
            setDrawerLockMode(i, ((C0550d) view.getLayoutParams()).f1390a);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View ");
        stringBuilder.append(view);
        stringBuilder.append(" is not a ");
        stringBuilder.append("drawer with appropriate layout_gravity");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public int getDrawerLockMode(int i) {
        int e = C0517s.m1711e(this);
        if (i != 3) {
            if (i != 5) {
                if (i != 8388611) {
                    if (i == 8388613) {
                        if (this.mLockModeEnd != 3) {
                            return this.mLockModeEnd;
                        }
                        if (e == 0) {
                            i = this.mLockModeRight;
                        } else {
                            i = this.mLockModeLeft;
                        }
                        if (i != 3) {
                            return i;
                        }
                    }
                } else if (this.mLockModeStart != 3) {
                    return this.mLockModeStart;
                } else {
                    if (e == 0) {
                        i = this.mLockModeLeft;
                    } else {
                        i = this.mLockModeRight;
                    }
                    if (i != 3) {
                        return i;
                    }
                }
            } else if (this.mLockModeRight != 3) {
                return this.mLockModeRight;
            } else {
                if (e == 0) {
                    i = this.mLockModeEnd;
                } else {
                    i = this.mLockModeStart;
                }
                if (i != 3) {
                    return i;
                }
            }
        } else if (this.mLockModeLeft != 3) {
            return this.mLockModeLeft;
        } else {
            i = e == 0 ? this.mLockModeStart : this.mLockModeEnd;
            if (i != 3) {
                return i;
            }
        }
        return 0;
    }

    public int getDrawerLockMode(View view) {
        if (isDrawerView(view)) {
            return getDrawerLockMode(((C0550d) view.getLayoutParams()).f1390a);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View ");
        stringBuilder.append(view);
        stringBuilder.append(" is not a drawer");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setDrawerTitle(int i, CharSequence charSequence) {
        i = C0501e.m1587a(i, C0517s.m1711e(this));
        if (i == 3) {
            this.mTitleLeft = charSequence;
        } else if (i == 5) {
            this.mTitleRight = charSequence;
        }
    }

    public CharSequence getDrawerTitle(int i) {
        i = C0501e.m1587a(i, C0517s.m1711e(this));
        if (i == 3) {
            return this.mTitleLeft;
        }
        return i == 5 ? this.mTitleRight : 0;
    }

    void updateDrawerState(int i, int i2, View view) {
        C0550d c0550d;
        i = this.mLeftDragger.m1939a();
        int a = this.mRightDragger.m1939a();
        int i3 = 2;
        if (i != 1) {
            if (a != 1) {
                if (i != 2) {
                    if (a != 2) {
                        i3 = 0;
                    }
                }
                if (view != null && i2 == 0) {
                    c0550d = (C0550d) view.getLayoutParams();
                    if (c0550d.f1391b == 0) {
                        dispatchOnDrawerClosed(view);
                    } else if (c0550d.f1391b == 1065353216) {
                        dispatchOnDrawerOpened(view);
                    }
                }
                if (i3 != this.mDrawerState) {
                    this.mDrawerState = i3;
                    if (this.mListeners != 0) {
                        for (i = this.mListeners.size() - 1; i >= 0; i--) {
                            ((C0549c) this.mListeners.get(i)).onDrawerStateChanged(i3);
                        }
                    }
                }
            }
        }
        i3 = 1;
        c0550d = (C0550d) view.getLayoutParams();
        if (c0550d.f1391b == 0) {
            dispatchOnDrawerClosed(view);
        } else if (c0550d.f1391b == 1065353216) {
            dispatchOnDrawerOpened(view);
        }
        if (i3 != this.mDrawerState) {
            this.mDrawerState = i3;
            if (this.mListeners != 0) {
                for (i = this.mListeners.size() - 1; i >= 0; i--) {
                    ((C0549c) this.mListeners.get(i)).onDrawerStateChanged(i3);
                }
            }
        }
    }

    void dispatchOnDrawerClosed(View view) {
        C0550d c0550d = (C0550d) view.getLayoutParams();
        if ((c0550d.f1393d & 1) == 1) {
            c0550d.f1393d = 0;
            if (this.mListeners != null) {
                for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                    ((C0549c) this.mListeners.get(size)).onDrawerClosed(view);
                }
            }
            updateChildrenImportantForAccessibility(view, false);
            if (hasWindowFocus() != null) {
                view = getRootView();
                if (view != null) {
                    view.sendAccessibilityEvent(32);
                }
            }
        }
    }

    void dispatchOnDrawerOpened(View view) {
        C0550d c0550d = (C0550d) view.getLayoutParams();
        if ((c0550d.f1393d & 1) == 0) {
            c0550d.f1393d = 1;
            if (this.mListeners != null) {
                for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                    ((C0549c) this.mListeners.get(size)).onDrawerOpened(view);
                }
            }
            updateChildrenImportantForAccessibility(view, CHILDREN_DISALLOW_INTERCEPT);
            if (hasWindowFocus() != null) {
                sendAccessibilityEvent(32);
            }
        }
    }

    private void updateChildrenImportantForAccessibility(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || isDrawerView(childAt)) && !(z && childAt == view)) {
                C0517s.m1688a(childAt, 4);
            } else {
                C0517s.m1688a(childAt, 1);
            }
        }
    }

    void dispatchOnDrawerSlide(View view, float f) {
        if (this.mListeners != null) {
            for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                ((C0549c) this.mListeners.get(size)).onDrawerSlide(view, f);
            }
        }
    }

    void setDrawerViewOffset(View view, float f) {
        C0550d c0550d = (C0550d) view.getLayoutParams();
        if (f != c0550d.f1391b) {
            c0550d.f1391b = f;
            dispatchOnDrawerSlide(view, f);
        }
    }

    float getDrawerViewOffset(View view) {
        return ((C0550d) view.getLayoutParams()).f1391b;
    }

    int getDrawerViewAbsoluteGravity(View view) {
        return C0501e.m1587a(((C0550d) view.getLayoutParams()).f1390a, C0517s.m1711e(this));
    }

    boolean checkDrawerViewAbsoluteGravity(View view, int i) {
        return (getDrawerViewAbsoluteGravity(view) & i) == i ? CHILDREN_DISALLOW_INTERCEPT : null;
    }

    View findOpenDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((C0550d) childAt.getLayoutParams()).f1393d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    void moveDrawerToOffset(View view, float f) {
        float width = (float) view.getWidth();
        int i = (int) (width * f);
        i -= (int) (getDrawerViewOffset(view) * width);
        if (!checkDrawerViewAbsoluteGravity(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        setDrawerViewOffset(view, f);
    }

    View findDrawerWithGravity(int i) {
        i = C0501e.m1587a(i, C0517s.m1711e(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((getDrawerViewAbsoluteGravity(childAt) & 7) == i) {
                return childAt;
            }
        }
        return 0;
    }

    static String gravityToString(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        return (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = CHILDREN_DISALLOW_INTERCEPT;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = CHILDREN_DISALLOW_INTERCEPT;
    }

    protected void onMeasure(int i, int i2) {
        C0553i c0553i = this;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != LinearLayoutManager.INVALID_OFFSET) {
                    if (mode == 0) {
                        size = 300;
                    }
                }
                if (mode2 != LinearLayoutManager.INVALID_OFFSET) {
                    if (mode2 == 0) {
                        size2 = 300;
                    }
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        int i3 = 0;
        Object obj = (c0553i.mLastInsets == null || !C0517s.m1722p(this)) ? null : 1;
        int e = C0517s.m1711e(this);
        int childCount = getChildCount();
        int i4 = 0;
        Object obj2 = null;
        Object obj3 = null;
        while (i4 < childCount) {
            int a;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                C0550d c0550d = (C0550d) childAt.getLayoutParams();
                if (obj != null) {
                    a = C0501e.m1587a(c0550d.f1390a, e);
                    WindowInsets windowInsets;
                    if (C0517s.m1722p(childAt)) {
                        if (VERSION.SDK_INT >= 21) {
                            windowInsets = (WindowInsets) c0553i.mLastInsets;
                            if (a == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i3, windowInsets.getSystemWindowInsetBottom());
                            } else if (a == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i3, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (VERSION.SDK_INT >= 21) {
                        windowInsets = (WindowInsets) c0553i.mLastInsets;
                        if (a == 3) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i3, windowInsets.getSystemWindowInsetBottom());
                        } else if (a == 5) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(i3, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                        }
                        c0550d.leftMargin = windowInsets.getSystemWindowInsetLeft();
                        c0550d.topMargin = windowInsets.getSystemWindowInsetTop();
                        c0550d.rightMargin = windowInsets.getSystemWindowInsetRight();
                        c0550d.bottomMargin = windowInsets.getSystemWindowInsetBottom();
                    }
                }
                if (isContentView(childAt)) {
                    childAt.measure(MeasureSpec.makeMeasureSpec((size - c0550d.leftMargin) - c0550d.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((size2 - c0550d.topMargin) - c0550d.bottomMargin, 1073741824));
                } else if (isDrawerView(childAt)) {
                    if (SET_DRAWER_SHADOW_FROM_ELEVATION && C0517s.m1718l(childAt) != c0553i.mDrawerElevation) {
                        C0517s.m1687a(childAt, c0553i.mDrawerElevation);
                    }
                    mode2 = getDrawerViewAbsoluteGravity(childAt) & 7;
                    Object obj4 = mode2 == 3 ? 1 : null;
                    if (obj4 == null || r10 == null) {
                        if (obj4 == null) {
                            if (obj3 == null) {
                            }
                        }
                        if (obj4 != null) {
                            obj2 = 1;
                        } else {
                            obj3 = 1;
                        }
                        childAt.measure(C0553i.getChildMeasureSpec(i, (c0553i.mMinDrawerMargin + c0550d.leftMargin) + c0550d.rightMargin, c0550d.width), C0553i.getChildMeasureSpec(i2, c0550d.topMargin + c0550d.bottomMargin, c0550d.height));
                        i4++;
                        i3 = 0;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Child drawer has absolute gravity ");
                    stringBuilder.append(C0553i.gravityToString(mode2));
                    stringBuilder.append(" but this ");
                    stringBuilder.append(TAG);
                    stringBuilder.append(" already has a ");
                    stringBuilder.append("drawer view along that edge");
                    throw new IllegalStateException(stringBuilder.toString());
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Child ");
                    stringBuilder2.append(childAt);
                    stringBuilder2.append(" at index ");
                    stringBuilder2.append(i4);
                    stringBuilder2.append(" does not have a valid layout_gravity - must be Gravity.LEFT, ");
                    stringBuilder2.append("Gravity.RIGHT or Gravity.NO_GRAVITY");
                    throw new IllegalStateException(stringBuilder2.toString());
                }
            }
            a = i;
            int i5 = i2;
            i4++;
            i3 = 0;
        }
    }

    private void resolveShadowDrawables() {
        if (!SET_DRAWER_SHADOW_FROM_ELEVATION) {
            this.mShadowLeftResolved = resolveLeftShadow();
            this.mShadowRightResolved = resolveRightShadow();
        }
    }

    private Drawable resolveLeftShadow() {
        int e = C0517s.m1711e(this);
        if (e == 0) {
            if (this.mShadowStart != null) {
                mirror(this.mShadowStart, e);
                return this.mShadowStart;
            }
        } else if (this.mShadowEnd != null) {
            mirror(this.mShadowEnd, e);
            return this.mShadowEnd;
        }
        return this.mShadowLeft;
    }

    private Drawable resolveRightShadow() {
        int e = C0517s.m1711e(this);
        if (e == 0) {
            if (this.mShadowEnd != null) {
                mirror(this.mShadowEnd, e);
                return this.mShadowEnd;
            }
        } else if (this.mShadowStart != null) {
            mirror(this.mShadowStart, e);
            return this.mShadowStart;
        }
        return this.mShadowRight;
    }

    private boolean mirror(Drawable drawable, int i) {
        if (drawable != null) {
            if (C0259a.m697b(drawable)) {
                C0259a.m698b(drawable, i);
                return CHILDREN_DISALLOW_INTERCEPT;
            }
        }
        return null;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = CHILDREN_DISALLOW_INTERCEPT;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0550d c0550d = (C0550d) childAt.getLayoutParams();
                if (isContentView(childAt)) {
                    childAt.layout(c0550d.leftMargin, c0550d.topMargin, c0550d.leftMargin + childAt.getMeasuredWidth(), c0550d.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        float f2 = (float) measuredWidth;
                        i7 = (-measuredWidth) + ((int) (c0550d.f1391b * f2));
                        f = ((float) (measuredWidth + i7)) / f2;
                    } else {
                        float f3 = (float) measuredWidth;
                        int i8 = i5 - ((int) (c0550d.f1391b * f3));
                        f = ((float) (i5 - i8)) / f3;
                        i7 = i8;
                    }
                    Object obj = f != c0550d.f1391b ? 1 : null;
                    int i9 = c0550d.f1390a & 112;
                    int i10;
                    if (i9 == 16) {
                        i10 = i4 - i2;
                        i9 = (i10 - measuredHeight) / 2;
                        if (i9 < c0550d.topMargin) {
                            i9 = c0550d.topMargin;
                        } else if (i9 + measuredHeight > i10 - c0550d.bottomMargin) {
                            i9 = (i10 - c0550d.bottomMargin) - measuredHeight;
                        }
                        childAt.layout(i7, i9, measuredWidth + i7, measuredHeight + i9);
                    } else if (i9 != 80) {
                        childAt.layout(i7, c0550d.topMargin, measuredWidth + i7, c0550d.topMargin + measuredHeight);
                    } else {
                        i10 = i4 - i2;
                        childAt.layout(i7, (i10 - c0550d.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i10 - c0550d.bottomMargin);
                    }
                    if (obj != null) {
                        setDrawerViewOffset(childAt, f);
                    }
                    int i11 = c0550d.f1391b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i11) {
                        childAt.setVisibility(i11);
                    }
                }
            }
        }
        r0.mInLayout = false;
        r0.mFirstLayout = false;
    }

    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((C0550d) getChildAt(i).getLayoutParams()).f1391b);
        }
        this.mScrimOpacity = f;
        boolean a = this.mLeftDragger.m1946a((boolean) CHILDREN_DISALLOW_INTERCEPT);
        boolean a2 = this.mRightDragger.m1946a((boolean) CHILDREN_DISALLOW_INTERCEPT);
        if (a || a2) {
            C0517s.m1706c(this);
        }
    }

    private static boolean hasOpaqueBackground(View view) {
        view = view.getBackground();
        boolean z = false;
        if (view == null) {
            return false;
        }
        if (view.getOpacity() == -1) {
            z = CHILDREN_DISALLOW_INTERCEPT;
        }
        return z;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.mStatusBarBackground = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    public void setStatusBarBackground(int i) {
        this.mStatusBarBackground = i != 0 ? C0366b.m1103a(getContext(), i) : 0;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.mStatusBarBackground = new ColorDrawable(i);
        invalidate();
    }

    public void onRtlPropertiesChanged(int i) {
        resolveShadowDrawables();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            int systemWindowInsetTop = (VERSION.SDK_INT < 21 || this.mLastInsets == null) ? 0 : ((WindowInsets) this.mLastInsets).getSystemWindowInsetTop();
            if (systemWindowInsetTop > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        C0553i c0553i = this;
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean isContentView = isContentView(view2);
        int width = getWidth();
        int save = canvas.save();
        int i2 = 0;
        if (isContentView) {
            int childCount = getChildCount();
            i = width;
            int i3 = 0;
            for (width = 0; width < childCount; width++) {
                View childAt = getChildAt(width);
                if (childAt != view2 && childAt.getVisibility() == 0 && C0553i.hasOpaqueBackground(childAt) && isDrawerView(childAt)) {
                    if (childAt.getHeight() >= height) {
                        int right;
                        if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                            right = childAt.getRight();
                            if (right > i3) {
                                i3 = right;
                            }
                        } else {
                            right = childAt.getLeft();
                            if (right < i) {
                                i = right;
                            }
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, i, getHeight());
            i2 = i3;
        } else {
            i = width;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (c0553i.mScrimOpacity > 0.0f && isContentView) {
            c0553i.mScrimPaint.setColor((((int) (((float) ((c0553i.mScrimColor & -16777216) >>> 24)) * c0553i.mScrimOpacity)) << 24) | (c0553i.mScrimColor & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), c0553i.mScrimPaint);
        } else if (c0553i.mShadowLeftResolved != null && checkDrawerViewAbsoluteGravity(view2, 3)) {
            height = c0553i.mShadowLeftResolved.getIntrinsicWidth();
            r7 = view.getRight();
            r5 = Math.max(0.0f, Math.min(((float) r7) / ((float) c0553i.mLeftDragger.m1947b()), TOUCH_SLOP_SENSITIVITY));
            c0553i.mShadowLeftResolved.setBounds(r7, view.getTop(), height + r7, view.getBottom());
            c0553i.mShadowLeftResolved.setAlpha((int) (r5 * 255.0f));
            c0553i.mShadowLeftResolved.draw(canvas);
        } else if (c0553i.mShadowRightResolved != null && checkDrawerViewAbsoluteGravity(view2, 5)) {
            height = c0553i.mShadowRightResolved.getIntrinsicWidth();
            r7 = view.getLeft();
            r5 = Math.max(0.0f, Math.min(((float) (getWidth() - r7)) / ((float) c0553i.mRightDragger.m1947b()), TOUCH_SLOP_SENSITIVITY));
            c0553i.mShadowRightResolved.setBounds(r7 - height, view.getTop(), r7, view.getBottom());
            c0553i.mShadowRightResolved.setAlpha((int) (r5 * 255.0f));
            c0553i.mShadowRightResolved.draw(canvas);
        }
        return drawChild;
    }

    boolean isContentView(View view) {
        return ((C0550d) view.getLayoutParams()).f1390a == null ? CHILDREN_DISALLOW_INTERCEPT : null;
    }

    boolean isDrawerView(View view) {
        view = C0501e.m1587a(((C0550d) view.getLayoutParams()).f1390a, C0517s.m1711e(view));
        return ((view & 3) == 0 && (view & 5) == null) ? null : CHILDREN_DISALLOW_INTERCEPT;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int a = this.mLeftDragger.m1944a(motionEvent) | this.mRightDragger.m1944a(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                motionEvent = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = motionEvent;
                if (this.mScrimOpacity > 0.0f) {
                    motionEvent = this.mLeftDragger.m1957d((int) x, (int) motionEvent);
                    if (!(motionEvent == null || isContentView(motionEvent) == null)) {
                        motionEvent = CHILDREN_DISALLOW_INTERCEPT;
                        this.mDisallowInterceptRequested = false;
                        this.mChildrenCanceledTouch = false;
                        break;
                    }
                }
                motionEvent = null;
                this.mDisallowInterceptRequested = false;
                this.mChildrenCanceledTouch = false;
            case 1:
            case 3:
                closeDrawers(CHILDREN_DISALLOW_INTERCEPT);
                this.mDisallowInterceptRequested = false;
                this.mChildrenCanceledTouch = false;
                break;
            case 2:
                if (this.mLeftDragger.m1958d(3) != null) {
                    this.mLeftCallback.m9826a();
                    this.mRightCallback.m9826a();
                    break;
                }
                break;
            default:
                break;
        }
        motionEvent = null;
        if (a != 0 || r7 != null || hasPeekingDrawer() != null) {
            return CHILDREN_DISALLOW_INTERCEPT;
        }
        if (this.mChildrenCanceledTouch != null) {
            return CHILDREN_DISALLOW_INTERCEPT;
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mLeftDragger.m1948b(motionEvent);
        this.mRightDragger.m1948b(motionEvent);
        int action = motionEvent.getAction() & JfifUtil.MARKER_FIRST_BYTE;
        if (action != 3) {
            float x;
            switch (action) {
                case 0:
                    x = motionEvent.getX();
                    motionEvent = motionEvent.getY();
                    this.mInitialMotionX = x;
                    this.mInitialMotionY = motionEvent;
                    this.mDisallowInterceptRequested = false;
                    this.mChildrenCanceledTouch = false;
                    break;
                case 1:
                    x = motionEvent.getX();
                    motionEvent = motionEvent.getY();
                    View d = this.mLeftDragger.m1957d((int) x, (int) motionEvent);
                    if (d != null && isContentView(d)) {
                        x -= this.mInitialMotionX;
                        motionEvent -= this.mInitialMotionY;
                        int d2 = this.mLeftDragger.m1956d();
                        if ((x * x) + (motionEvent * motionEvent) < ((float) (d2 * d2))) {
                            View findOpenDrawer = findOpenDrawer();
                            if (findOpenDrawer != null) {
                                if (getDrawerLockMode(findOpenDrawer) != 2) {
                                    motionEvent = null;
                                    closeDrawers(motionEvent);
                                    this.mDisallowInterceptRequested = false;
                                    break;
                                }
                            }
                        }
                    }
                    motionEvent = CHILDREN_DISALLOW_INTERCEPT;
                    closeDrawers(motionEvent);
                    this.mDisallowInterceptRequested = false;
                default:
                    break;
            }
        }
        closeDrawers(CHILDREN_DISALLOW_INTERCEPT);
        this.mDisallowInterceptRequested = false;
        this.mChildrenCanceledTouch = false;
        return CHILDREN_DISALLOW_INTERCEPT;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.mDisallowInterceptRequested = z;
        if (z) {
            closeDrawers(CHILDREN_DISALLOW_INTERCEPT);
        }
    }

    public void closeDrawers() {
        closeDrawers(false);
    }

    void closeDrawers(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0550d c0550d = (C0550d) childAt.getLayoutParams();
            if (isDrawerView(childAt)) {
                if (!z || c0550d.f1392c) {
                    int width = childAt.getWidth();
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        i |= this.mLeftDragger.m1945a(childAt, -width, childAt.getTop());
                    } else {
                        i |= this.mRightDragger.m1945a(childAt, getWidth(), childAt.getTop());
                    }
                    c0550d.f1392c = false;
                }
            }
        }
        this.mLeftCallback.m9826a();
        this.mRightCallback.m9826a();
        if (i != 0) {
            invalidate();
        }
    }

    public void openDrawer(View view) {
        openDrawer(view, (boolean) CHILDREN_DISALLOW_INTERCEPT);
    }

    public void openDrawer(View view, boolean z) {
        if (isDrawerView(view)) {
            C0550d c0550d = (C0550d) view.getLayoutParams();
            if (this.mFirstLayout) {
                c0550d.f1391b = TOUCH_SLOP_SENSITIVITY;
                c0550d.f1393d = 1;
                updateChildrenImportantForAccessibility(view, CHILDREN_DISALLOW_INTERCEPT);
            } else if (z) {
                c0550d.f1393d |= 2;
                if (checkDrawerViewAbsoluteGravity(view, true)) {
                    this.mLeftDragger.m1945a(view, 0, view.getTop());
                } else {
                    this.mRightDragger.m1945a(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                moveDrawerToOffset(view, TOUCH_SLOP_SENSITIVITY);
                updateDrawerState(c0550d.f1390a, 0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View ");
        stringBuilder.append(view);
        stringBuilder.append(" is not a sliding drawer");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void openDrawer(int i) {
        openDrawer(i, (boolean) CHILDREN_DISALLOW_INTERCEPT);
    }

    public void openDrawer(int i, boolean z) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        if (findDrawerWithGravity != null) {
            openDrawer(findDrawerWithGravity, z);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No drawer view found with gravity ");
        stringBuilder.append(C0553i.gravityToString(i));
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void closeDrawer(View view) {
        closeDrawer(view, (boolean) CHILDREN_DISALLOW_INTERCEPT);
    }

    public void closeDrawer(View view, boolean z) {
        if (isDrawerView(view)) {
            C0550d c0550d = (C0550d) view.getLayoutParams();
            if (this.mFirstLayout) {
                c0550d.f1391b = 0.0f;
                c0550d.f1393d = 0;
            } else if (z) {
                c0550d.f1393d |= true;
                if (checkDrawerViewAbsoluteGravity(view, true)) {
                    this.mLeftDragger.m1945a(view, -view.getWidth(), view.getTop());
                } else {
                    this.mRightDragger.m1945a(view, getWidth(), view.getTop());
                }
            } else {
                moveDrawerToOffset(view, 0.0f);
                updateDrawerState(c0550d.f1390a, 0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View ");
        stringBuilder.append(view);
        stringBuilder.append(" is not a sliding drawer");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void closeDrawer(int i) {
        closeDrawer(i, (boolean) CHILDREN_DISALLOW_INTERCEPT);
    }

    public void closeDrawer(int i, boolean z) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        if (findDrawerWithGravity != null) {
            closeDrawer(findDrawerWithGravity, z);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No drawer view found with gravity ");
        stringBuilder.append(C0553i.gravityToString(i));
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean isDrawerOpen(View view) {
        if (isDrawerView(view)) {
            return (((C0550d) view.getLayoutParams()).f1393d & 1) == 1 ? CHILDREN_DISALLOW_INTERCEPT : false;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("View ");
            stringBuilder.append(view);
            stringBuilder.append(" is not a drawer");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public boolean isDrawerOpen(int i) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        return findDrawerWithGravity != 0 ? isDrawerOpen(findDrawerWithGravity) : false;
    }

    public boolean isDrawerVisible(View view) {
        if (isDrawerView(view)) {
            return ((C0550d) view.getLayoutParams()).f1391b > 0.0f ? CHILDREN_DISALLOW_INTERCEPT : null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("View ");
            stringBuilder.append(view);
            stringBuilder.append(" is not a drawer");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public boolean isDrawerVisible(int i) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        return findDrawerWithGravity != 0 ? isDrawerVisible(findDrawerWithGravity) : false;
    }

    private boolean hasPeekingDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((C0550d) getChildAt(i).getLayoutParams()).f1392c) {
                return CHILDREN_DISALLOW_INTERCEPT;
            }
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0550d(-1, -1);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams instanceof C0550d) {
            return new C0550d((C0550d) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new C0550d((MarginLayoutParams) layoutParams) : new C0550d(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (!(layoutParams instanceof C0550d) || super.checkLayoutParams(layoutParams) == null) ? null : CHILDREN_DISALLOW_INTERCEPT;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0550d(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            Object obj = null;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (!isDrawerView(childAt)) {
                    this.mNonDrawerViews.add(childAt);
                } else if (isDrawerOpen(childAt)) {
                    childAt.addFocusables(arrayList, i, i2);
                    obj = 1;
                }
            }
            if (obj == null) {
                childCount = this.mNonDrawerViews.size();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View view = (View) this.mNonDrawerViews.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.mNonDrawerViews.clear();
        }
    }

    private boolean hasVisibleDrawer() {
        return findVisibleDrawer() != null ? CHILDREN_DISALLOW_INTERCEPT : false;
    }

    View findVisibleDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (isDrawerView(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    void cancelChildViewTouch() {
        if (!this.mChildrenCanceledTouch) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.mChildrenCanceledTouch = CHILDREN_DISALLOW_INTERCEPT;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !hasVisibleDrawer()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return CHILDREN_DISALLOW_INTERCEPT;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View findVisibleDrawer = findVisibleDrawer();
        if (findVisibleDrawer != 0 && getDrawerLockMode(findVisibleDrawer) == null) {
            closeDrawers();
        }
        return findVisibleDrawer != null ? 1 : 0;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C3238e) {
            C3238e c3238e = (C3238e) parcelable;
            super.onRestoreInstanceState(c3238e.m1558a());
            if (c3238e.f8315a != 0) {
                View findDrawerWithGravity = findDrawerWithGravity(c3238e.f8315a);
                if (findDrawerWithGravity != null) {
                    openDrawer(findDrawerWithGravity);
                }
            }
            if (c3238e.f8316b != 3) {
                setDrawerLockMode(c3238e.f8316b, 3);
            }
            if (c3238e.f8317c != 3) {
                setDrawerLockMode(c3238e.f8317c, 5);
            }
            if (c3238e.f8318e != 3) {
                setDrawerLockMode(c3238e.f8318e, 8388611);
            }
            if (c3238e.f8319f != 3) {
                setDrawerLockMode(c3238e.f8319f, 8388613);
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c3238e = new C3238e(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount) {
            C0550d c0550d = (C0550d) getChildAt(i).getLayoutParams();
            Object obj = 1;
            Object obj2 = c0550d.f1393d == 1 ? 1 : null;
            if (c0550d.f1393d != 2) {
                obj = null;
            }
            if (obj2 == null) {
                if (obj == null) {
                    i++;
                }
            }
            c3238e.f8315a = c0550d.f1390a;
            break;
        }
        c3238e.f8316b = this.mLockModeLeft;
        c3238e.f8317c = this.mLockModeRight;
        c3238e.f8318e = this.mLockModeStart;
        c3238e.f8319f = this.mLockModeEnd;
        return c3238e;
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (findOpenDrawer() == 0) {
            if (isDrawerView(view) == 0) {
                C0517s.m1688a(view, 1);
                if (CAN_HIDE_DESCENDANTS == 0) {
                    C0517s.m1695a(view, this.mChildAccessibilityDelegate);
                }
            }
        }
        C0517s.m1688a(view, 4);
        if (CAN_HIDE_DESCENDANTS == 0) {
            C0517s.m1695a(view, this.mChildAccessibilityDelegate);
        }
    }

    static boolean includeChildForAccessibility(View view) {
        return (C0517s.m1709d(view) == 4 || C0517s.m1709d(view) == 2) ? null : CHILDREN_DISALLOW_INTERCEPT;
    }
}
