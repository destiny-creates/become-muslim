package android.support.v4.view;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ViewCompat */
/* renamed from: android.support.v4.view.s */
public class C0517s {
    /* renamed from: a */
    static final C0516j f1294a;

    /* compiled from: ViewCompat */
    /* renamed from: android.support.v4.view.s$j */
    static class C0516j {
        /* renamed from: b */
        static Field f1285b;
        /* renamed from: c */
        static boolean f1286c = false;
        /* renamed from: d */
        private static Field f1287d;
        /* renamed from: e */
        private static boolean f1288e;
        /* renamed from: f */
        private static Field f1289f;
        /* renamed from: g */
        private static boolean f1290g;
        /* renamed from: h */
        private static WeakHashMap<View, String> f1291h;
        /* renamed from: i */
        private static final AtomicInteger f1292i = new AtomicInteger(1);
        /* renamed from: a */
        WeakHashMap<View, C0525w> f1293a = null;

        /* renamed from: a */
        public aa mo3597a(View view, aa aaVar) {
            return aaVar;
        }

        /* renamed from: a */
        public void mo3598a(View view, float f) {
        }

        /* renamed from: a */
        public void mo2682a(View view, int i) {
        }

        /* renamed from: a */
        public void mo3613a(View view, int i, int i2) {
        }

        /* renamed from: a */
        public void mo3480a(View view, Rect rect) {
        }

        /* renamed from: a */
        public void mo3601a(View view, C0512p c0512p) {
        }

        /* renamed from: a */
        public void mo2686a(View view, boolean z) {
        }

        /* renamed from: a */
        public boolean mo325a(View view) {
            return false;
        }

        /* renamed from: b */
        public aa mo3603b(View view, aa aaVar) {
            return aaVar;
        }

        /* renamed from: b */
        public void mo3555b(View view, int i) {
        }

        /* renamed from: b */
        public boolean mo2687b(View view) {
            return false;
        }

        /* renamed from: d */
        public int mo2689d(View view) {
            return 0;
        }

        /* renamed from: h */
        public void mo2693h(View view) {
        }

        /* renamed from: i */
        public boolean mo2694i(View view) {
            return false;
        }

        /* renamed from: j */
        public boolean mo2695j(View view) {
            return true;
        }

        /* renamed from: k */
        public int mo3328k(View view) {
            return 0;
        }

        /* renamed from: n */
        public int mo3331n(View view) {
            return 0;
        }

        /* renamed from: o */
        public boolean mo3332o(View view) {
            return false;
        }

        /* renamed from: q */
        public Rect mo3481q(View view) {
            return null;
        }

        /* renamed from: r */
        public boolean mo3482r(View view) {
            return false;
        }

        /* renamed from: v */
        public float mo3608v(View view) {
            return 0.0f;
        }

        /* renamed from: w */
        public float mo3609w(View view) {
            return 0.0f;
        }

        C0516j() {
        }

        /* renamed from: a */
        public void m1646a(View view, C0494b c0494b) {
            view.setAccessibilityDelegate(c0494b == null ? null : c0494b.getBridge());
        }

        /* renamed from: C */
        public boolean m1634C(android.view.View r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r4 = this;
            r0 = f1286c;
            r1 = 0;
            if (r0 == 0) goto L_0x0006;
        L_0x0005:
            return r1;
        L_0x0006:
            r0 = f1285b;
            r2 = 1;
            if (r0 != 0) goto L_0x001e;
        L_0x000b:
            r0 = android.view.View.class;	 Catch:{ Throwable -> 0x001b }
            r3 = "mAccessibilityDelegate";	 Catch:{ Throwable -> 0x001b }
            r0 = r0.getDeclaredField(r3);	 Catch:{ Throwable -> 0x001b }
            f1285b = r0;	 Catch:{ Throwable -> 0x001b }
            r0 = f1285b;	 Catch:{ Throwable -> 0x001b }
            r0.setAccessible(r2);	 Catch:{ Throwable -> 0x001b }
            goto L_0x001e;
        L_0x001b:
            f1286c = r2;
            return r1;
        L_0x001e:
            r0 = f1285b;	 Catch:{ Throwable -> 0x0028 }
            r5 = r0.get(r5);	 Catch:{ Throwable -> 0x0028 }
            if (r5 == 0) goto L_0x0027;
        L_0x0026:
            r1 = 1;
        L_0x0027:
            return r1;
        L_0x0028:
            f1286c = r2;
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.s.j.C(android.view.View):boolean");
        }

        /* renamed from: c */
        public void mo2688c(View view) {
            view.postInvalidate();
        }

        /* renamed from: a */
        public void mo2684a(View view, Runnable runnable) {
            view.postDelayed(runnable, m1636a());
        }

        /* renamed from: a */
        public void mo2685a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, m1636a() + j);
        }

        /* renamed from: a */
        long m1636a() {
            return ValueAnimator.getFrameDelay();
        }

        /* renamed from: e */
        public ViewParent mo2690e(View view) {
            return view.getParent();
        }

        /* renamed from: l */
        public int mo3329l(View view) {
            return view.getPaddingLeft();
        }

        /* renamed from: m */
        public int mo3330m(View view) {
            return view.getPaddingRight();
        }

        /* renamed from: a */
        public void mo3327a(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        /* renamed from: f */
        public int mo2691f(android.view.View r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r3 = this;
            r0 = f1288e;
            if (r0 != 0) goto L_0x0016;
        L_0x0004:
            r0 = 1;
            r1 = android.view.View.class;	 Catch:{ NoSuchFieldException -> 0x0014 }
            r2 = "mMinWidth";	 Catch:{ NoSuchFieldException -> 0x0014 }
            r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0014 }
            f1287d = r1;	 Catch:{ NoSuchFieldException -> 0x0014 }
            r1 = f1287d;	 Catch:{ NoSuchFieldException -> 0x0014 }
            r1.setAccessible(r0);	 Catch:{ NoSuchFieldException -> 0x0014 }
        L_0x0014:
            f1288e = r0;
        L_0x0016:
            r0 = f1287d;
            if (r0 == 0) goto L_0x0027;
        L_0x001a:
            r0 = f1287d;	 Catch:{ Exception -> 0x0027 }
            r4 = r0.get(r4);	 Catch:{ Exception -> 0x0027 }
            r4 = (java.lang.Integer) r4;	 Catch:{ Exception -> 0x0027 }
            r4 = r4.intValue();	 Catch:{ Exception -> 0x0027 }
            return r4;
        L_0x0027:
            r4 = 0;
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.s.j.f(android.view.View):int");
        }

        /* renamed from: g */
        public int mo2692g(android.view.View r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r3 = this;
            r0 = f1290g;
            if (r0 != 0) goto L_0x0016;
        L_0x0004:
            r0 = 1;
            r1 = android.view.View.class;	 Catch:{ NoSuchFieldException -> 0x0014 }
            r2 = "mMinHeight";	 Catch:{ NoSuchFieldException -> 0x0014 }
            r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0014 }
            f1289f = r1;	 Catch:{ NoSuchFieldException -> 0x0014 }
            r1 = f1289f;	 Catch:{ NoSuchFieldException -> 0x0014 }
            r1.setAccessible(r0);	 Catch:{ NoSuchFieldException -> 0x0014 }
        L_0x0014:
            f1290g = r0;
        L_0x0016:
            r0 = f1289f;
            if (r0 == 0) goto L_0x0027;
        L_0x001a:
            r0 = f1289f;	 Catch:{ Exception -> 0x0027 }
            r4 = r0.get(r4);	 Catch:{ Exception -> 0x0027 }
            r4 = (java.lang.Integer) r4;	 Catch:{ Exception -> 0x0027 }
            r4 = r4.intValue();	 Catch:{ Exception -> 0x0027 }
            return r4;
        L_0x0027:
            r4 = 0;
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.s.j.g(android.view.View):int");
        }

        /* renamed from: D */
        public C0525w m1635D(View view) {
            if (this.f1293a == null) {
                this.f1293a = new WeakHashMap();
            }
            C0525w c0525w = (C0525w) this.f1293a.get(view);
            if (c0525w != null) {
                return c0525w;
            }
            c0525w = new C0525w(view);
            this.f1293a.put(view, c0525w);
            return c0525w;
        }

        /* renamed from: a */
        public void mo3602a(View view, String str) {
            if (f1291h == null) {
                f1291h = new WeakHashMap();
            }
            f1291h.put(view, str);
        }

        /* renamed from: u */
        public String mo3607u(View view) {
            if (f1291h == null) {
                return null;
            }
            return (String) f1291h.get(view);
        }

        /* renamed from: b */
        public void mo3604b(View view, boolean z) {
            if (view instanceof C0508j) {
                ((C0508j) view).setNestedScrollingEnabled(z);
            }
        }

        /* renamed from: x */
        public boolean mo3610x(View view) {
            return view instanceof C0508j ? ((C0508j) view).isNestedScrollingEnabled() : null;
        }

        /* renamed from: a */
        public void mo2683a(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        /* renamed from: z */
        public ColorStateList mo3612z(View view) {
            return view instanceof C0514r ? ((C0514r) view).getSupportBackgroundTintList() : null;
        }

        /* renamed from: a */
        public void mo3599a(View view, ColorStateList colorStateList) {
            if (view instanceof C0514r) {
                ((C0514r) view).setSupportBackgroundTintList(colorStateList);
            }
        }

        /* renamed from: a */
        public void mo3600a(View view, Mode mode) {
            if (view instanceof C0514r) {
                ((C0514r) view).setSupportBackgroundTintMode(mode);
            }
        }

        /* renamed from: A */
        public Mode mo3595A(View view) {
            return view instanceof C0514r ? ((C0514r) view).getSupportBackgroundTintMode() : null;
        }

        /* renamed from: y */
        public void mo3611y(View view) {
            if (view instanceof C0508j) {
                ((C0508j) view).stopNestedScroll();
            }
        }

        /* renamed from: s */
        public boolean mo3556s(View view) {
            return (view.getWidth() <= 0 || view.getHeight() <= null) ? null : true;
        }

        /* renamed from: B */
        public float mo3596B(View view) {
            return mo3609w(view) + mo3608v(view);
        }

        /* renamed from: t */
        public boolean mo3557t(View view) {
            return view.getWindowToken() != null ? true : null;
        }

        /* renamed from: c */
        public void mo3605c(View view, int i) {
            view.offsetLeftAndRight(i);
            if (view.getVisibility() == 0) {
                C0516j.m1631E(view);
                view = view.getParent();
                if ((view instanceof View) != 0) {
                    C0516j.m1631E(view);
                }
            }
        }

        /* renamed from: d */
        public void mo3606d(View view, int i) {
            view.offsetTopAndBottom(i);
            if (view.getVisibility() == 0) {
                C0516j.m1631E(view);
                view = view.getParent();
                if ((view instanceof View) != 0) {
                    C0516j.m1631E(view);
                }
            }
        }

        /* renamed from: E */
        private static void m1631E(View view) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
        }

        /* renamed from: p */
        public Display mo3333p(View view) {
            return mo3557t(view) ? ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay() : null;
        }
    }

    /* compiled from: ViewCompat */
    /* renamed from: android.support.v4.view.s$a */
    static class C3228a extends C0516j {
        C3228a() {
        }

        /* renamed from: a */
        public boolean mo325a(View view) {
            return view.hasOnClickListeners();
        }
    }

    /* compiled from: ViewCompat */
    /* renamed from: android.support.v4.view.s$b */
    static class C4465b extends C3228a {
        C4465b() {
        }

        /* renamed from: b */
        public boolean mo2687b(View view) {
            return view.hasTransientState();
        }

        /* renamed from: a */
        public void mo2686a(View view, boolean z) {
            view.setHasTransientState(z);
        }

        /* renamed from: c */
        public void mo2688c(View view) {
            view.postInvalidateOnAnimation();
        }

        /* renamed from: a */
        public void mo2684a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        /* renamed from: a */
        public void mo2685a(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        /* renamed from: d */
        public int mo2689d(View view) {
            return view.getImportantForAccessibility();
        }

        /* renamed from: a */
        public void mo2682a(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }

        /* renamed from: e */
        public ViewParent mo2690e(View view) {
            return view.getParentForAccessibility();
        }

        /* renamed from: f */
        public int mo2691f(View view) {
            return view.getMinimumWidth();
        }

        /* renamed from: g */
        public int mo2692g(View view) {
            return view.getMinimumHeight();
        }

        /* renamed from: h */
        public void mo2693h(View view) {
            view.requestFitSystemWindows();
        }

        /* renamed from: i */
        public boolean mo2694i(View view) {
            return view.getFitsSystemWindows();
        }

        /* renamed from: j */
        public boolean mo2695j(View view) {
            return view.hasOverlappingRendering();
        }

        /* renamed from: a */
        public void mo2683a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }
    }

    /* compiled from: ViewCompat */
    /* renamed from: android.support.v4.view.s$c */
    static class C4828c extends C4465b {
        C4828c() {
        }

        /* renamed from: k */
        public int mo3328k(View view) {
            return view.getLayoutDirection();
        }

        /* renamed from: l */
        public int mo3329l(View view) {
            return view.getPaddingStart();
        }

        /* renamed from: m */
        public int mo3330m(View view) {
            return view.getPaddingEnd();
        }

        /* renamed from: a */
        public void mo3327a(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }

        /* renamed from: n */
        public int mo3331n(View view) {
            return view.getWindowSystemUiVisibility();
        }

        /* renamed from: o */
        public boolean mo3332o(View view) {
            return view.isPaddingRelative();
        }

        /* renamed from: p */
        public Display mo3333p(View view) {
            return view.getDisplay();
        }
    }

    /* compiled from: ViewCompat */
    /* renamed from: android.support.v4.view.s$d */
    static class C4891d extends C4828c {
        C4891d() {
        }

        /* renamed from: a */
        public void mo3480a(View view, Rect rect) {
            view.setClipBounds(rect);
        }

        /* renamed from: q */
        public Rect mo3481q(View view) {
            return view.getClipBounds();
        }

        /* renamed from: r */
        public boolean mo3482r(View view) {
            return view.isInLayout();
        }
    }

    /* compiled from: ViewCompat */
    /* renamed from: android.support.v4.view.s$e */
    static class C4906e extends C4891d {
        C4906e() {
        }

        /* renamed from: b */
        public void mo3555b(View view, int i) {
            view.setAccessibilityLiveRegion(i);
        }

        /* renamed from: a */
        public void mo2682a(View view, int i) {
            view.setImportantForAccessibility(i);
        }

        /* renamed from: s */
        public boolean mo3556s(View view) {
            return view.isLaidOut();
        }

        /* renamed from: t */
        public boolean mo3557t(View view) {
            return view.isAttachedToWindow();
        }
    }

    /* compiled from: ViewCompat */
    /* renamed from: android.support.v4.view.s$f */
    static class C4912f extends C4906e {
        /* renamed from: d */
        private static ThreadLocal<Rect> f14125d;

        C4912f() {
        }

        /* renamed from: a */
        public void mo3602a(View view, String str) {
            view.setTransitionName(str);
        }

        /* renamed from: u */
        public String mo3607u(View view) {
            return view.getTransitionName();
        }

        /* renamed from: h */
        public void mo2693h(View view) {
            view.requestApplyInsets();
        }

        /* renamed from: a */
        public void mo3598a(View view, float f) {
            view.setElevation(f);
        }

        /* renamed from: v */
        public float mo3608v(View view) {
            return view.getElevation();
        }

        /* renamed from: w */
        public float mo3609w(View view) {
            return view.getTranslationZ();
        }

        /* renamed from: a */
        public void mo3601a(View view, final C0512p c0512p) {
            if (c0512p == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
                    /* renamed from: b */
                    final /* synthetic */ C4912f f1284b;

                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        return (WindowInsets) aa.m1560a(c0512p.mo63a(view, aa.m1559a((Object) windowInsets)));
                    }
                });
            }
        }

        /* renamed from: b */
        public void mo3604b(View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        /* renamed from: x */
        public boolean mo3610x(View view) {
            return view.isNestedScrollingEnabled();
        }

        /* renamed from: y */
        public void mo3611y(View view) {
            view.stopNestedScroll();
        }

        /* renamed from: z */
        public ColorStateList mo3612z(View view) {
            return view.getBackgroundTintList();
        }

        /* renamed from: a */
        public void mo3599a(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                Object obj;
                colorStateList = view.getBackground();
                if (view.getBackgroundTintList() == null) {
                    if (view.getBackgroundTintMode() == null) {
                        obj = null;
                        if (colorStateList != null && r0 != null) {
                            if (colorStateList.isStateful()) {
                                colorStateList.setState(view.getDrawableState());
                            }
                            view.setBackground(colorStateList);
                            return;
                        }
                    }
                }
                obj = 1;
                if (colorStateList != null) {
                }
            }
        }

        /* renamed from: a */
        public void mo3600a(View view, Mode mode) {
            view.setBackgroundTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Object obj;
                mode = view.getBackground();
                if (view.getBackgroundTintList() == null) {
                    if (view.getBackgroundTintMode() == null) {
                        obj = null;
                        if (mode != null && r0 != null) {
                            if (mode.isStateful()) {
                                mode.setState(view.getDrawableState());
                            }
                            view.setBackground(mode);
                            return;
                        }
                    }
                }
                obj = 1;
                if (mode != null) {
                }
            }
        }

        /* renamed from: A */
        public Mode mo3595A(View view) {
            return view.getBackgroundTintMode();
        }

        /* renamed from: a */
        public aa mo3597a(View view, aa aaVar) {
            Object obj = (WindowInsets) aa.m1560a(aaVar);
            view = view.onApplyWindowInsets(obj);
            if (view != obj) {
                obj = new WindowInsets(view);
            }
            return aa.m1559a(obj);
        }

        /* renamed from: b */
        public aa mo3603b(View view, aa aaVar) {
            Object obj = (WindowInsets) aa.m1560a(aaVar);
            view = view.dispatchApplyWindowInsets(obj);
            if (view != obj) {
                obj = new WindowInsets(view);
            }
            return aa.m1559a(obj);
        }

        /* renamed from: B */
        public float mo3596B(View view) {
            return view.getZ();
        }

        /* renamed from: c */
        public void mo3605c(View view, int i) {
            int intersects;
            Rect b = C4912f.m17789b();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                intersects = b.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ^ 1;
            } else {
                intersects = 0;
            }
            super.mo3605c(view, i);
            if (intersects != 0 && b.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) != null) {
                ((View) parent).invalidate(b);
            }
        }

        /* renamed from: d */
        public void mo3606d(View view, int i) {
            int intersects;
            Rect b = C4912f.m17789b();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                intersects = b.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ^ 1;
            } else {
                intersects = 0;
            }
            super.mo3606d(view, i);
            if (intersects != 0 && b.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) != null) {
                ((View) parent).invalidate(b);
            }
        }

        /* renamed from: b */
        private static Rect m17789b() {
            if (f14125d == null) {
                f14125d = new ThreadLocal();
            }
            Rect rect = (Rect) f14125d.get();
            if (rect == null) {
                rect = new Rect();
                f14125d.set(rect);
            }
            rect.setEmpty();
            return rect;
        }
    }

    /* compiled from: ViewCompat */
    /* renamed from: android.support.v4.view.s$g */
    static class C4914g extends C4912f {
        C4914g() {
        }

        /* renamed from: a */
        public void mo3613a(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }

        /* renamed from: c */
        public void mo3605c(View view, int i) {
            view.offsetLeftAndRight(i);
        }

        /* renamed from: d */
        public void mo3606d(View view, int i) {
            view.offsetTopAndBottom(i);
        }
    }

    /* compiled from: ViewCompat */
    /* renamed from: android.support.v4.view.s$h */
    static class C4915h extends C4914g {
        C4915h() {
        }
    }

    /* compiled from: ViewCompat */
    /* renamed from: android.support.v4.view.s$i */
    static class C4916i extends C4915h {
        C4916i() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f1294a = new C4916i();
        } else if (VERSION.SDK_INT >= 24) {
            f1294a = new C4915h();
        } else if (VERSION.SDK_INT >= 23) {
            f1294a = new C4914g();
        } else if (VERSION.SDK_INT >= 21) {
            f1294a = new C4912f();
        } else if (VERSION.SDK_INT >= 19) {
            f1294a = new C4906e();
        } else if (VERSION.SDK_INT >= 18) {
            f1294a = new C4891d();
        } else if (VERSION.SDK_INT >= 17) {
            f1294a = new C4828c();
        } else if (VERSION.SDK_INT >= 16) {
            f1294a = new C4465b();
        } else if (VERSION.SDK_INT >= 15) {
            f1294a = new C3228a();
        } else {
            f1294a = new C0516j();
        }
    }

    /* renamed from: a */
    public static void m1695a(View view, C0494b c0494b) {
        f1294a.m1646a(view, c0494b);
    }

    /* renamed from: a */
    public static boolean m1701a(View view) {
        return f1294a.m1634C(view);
    }

    /* renamed from: b */
    public static boolean m1705b(View view) {
        return f1294a.mo2687b(view);
    }

    /* renamed from: a */
    public static void m1700a(View view, boolean z) {
        f1294a.mo2686a(view, z);
    }

    /* renamed from: c */
    public static void m1706c(View view) {
        f1294a.mo2688c(view);
    }

    /* renamed from: a */
    public static void m1697a(View view, Runnable runnable) {
        f1294a.mo2684a(view, runnable);
    }

    /* renamed from: a */
    public static void m1698a(View view, Runnable runnable, long j) {
        f1294a.mo2685a(view, runnable, j);
    }

    /* renamed from: d */
    public static int m1709d(View view) {
        return f1294a.mo2689d(view);
    }

    /* renamed from: a */
    public static void m1688a(View view, int i) {
        f1294a.mo2682a(view, i);
    }

    /* renamed from: e */
    public static int m1711e(View view) {
        return f1294a.mo3328k(view);
    }

    /* renamed from: f */
    public static ViewParent m1712f(View view) {
        return f1294a.mo2690e(view);
    }

    /* renamed from: b */
    public static void m1703b(View view, int i) {
        f1294a.mo3555b(view, i);
    }

    /* renamed from: g */
    public static int m1713g(View view) {
        return f1294a.mo3329l(view);
    }

    /* renamed from: h */
    public static int m1714h(View view) {
        return f1294a.mo3330m(view);
    }

    /* renamed from: a */
    public static void m1690a(View view, int i, int i2, int i3, int i4) {
        f1294a.mo3327a(view, i, i2, i3, i4);
    }

    /* renamed from: i */
    public static int m1715i(View view) {
        return f1294a.mo2691f(view);
    }

    /* renamed from: j */
    public static int m1716j(View view) {
        return f1294a.mo2692g(view);
    }

    /* renamed from: k */
    public static C0525w m1717k(View view) {
        return f1294a.m1635D(view);
    }

    /* renamed from: a */
    public static void m1687a(View view, float f) {
        f1294a.mo3598a(view, f);
    }

    /* renamed from: l */
    public static float m1718l(View view) {
        return f1294a.mo3608v(view);
    }

    /* renamed from: a */
    public static void m1699a(View view, String str) {
        f1294a.mo3602a(view, str);
    }

    /* renamed from: m */
    public static String m1719m(View view) {
        return f1294a.mo3607u(view);
    }

    /* renamed from: n */
    public static int m1720n(View view) {
        return f1294a.mo3331n(view);
    }

    /* renamed from: o */
    public static void m1721o(View view) {
        f1294a.mo2693h(view);
    }

    /* renamed from: p */
    public static boolean m1722p(View view) {
        return f1294a.mo2694i(view);
    }

    @Deprecated
    /* renamed from: b */
    public static void m1704b(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    /* renamed from: a */
    public static void m1696a(View view, C0512p c0512p) {
        f1294a.mo3601a(view, c0512p);
    }

    /* renamed from: a */
    public static aa m1686a(View view, aa aaVar) {
        return f1294a.mo3597a(view, aaVar);
    }

    /* renamed from: b */
    public static aa m1702b(View view, aa aaVar) {
        return f1294a.mo3603b(view, aaVar);
    }

    /* renamed from: q */
    public static boolean m1723q(View view) {
        return f1294a.mo2695j(view);
    }

    /* renamed from: r */
    public static boolean m1724r(View view) {
        return f1294a.mo3332o(view);
    }

    /* renamed from: a */
    public static void m1694a(View view, Drawable drawable) {
        f1294a.mo2683a(view, drawable);
    }

    /* renamed from: s */
    public static ColorStateList m1725s(View view) {
        return f1294a.mo3612z(view);
    }

    /* renamed from: a */
    public static void m1691a(View view, ColorStateList colorStateList) {
        f1294a.mo3599a(view, colorStateList);
    }

    /* renamed from: t */
    public static Mode m1726t(View view) {
        return f1294a.mo3595A(view);
    }

    /* renamed from: a */
    public static void m1692a(View view, Mode mode) {
        f1294a.mo3600a(view, mode);
    }

    /* renamed from: c */
    public static void m1708c(View view, boolean z) {
        f1294a.mo3604b(view, z);
    }

    /* renamed from: u */
    public static boolean m1727u(View view) {
        return f1294a.mo3610x(view);
    }

    /* renamed from: v */
    public static void m1728v(View view) {
        f1294a.mo3611y(view);
    }

    /* renamed from: w */
    public static boolean m1729w(View view) {
        return f1294a.mo3482r(view);
    }

    /* renamed from: x */
    public static boolean m1730x(View view) {
        return f1294a.mo3556s(view);
    }

    /* renamed from: y */
    public static float m1731y(View view) {
        return f1294a.mo3596B(view);
    }

    /* renamed from: c */
    public static void m1707c(View view, int i) {
        f1294a.mo3606d(view, i);
    }

    /* renamed from: d */
    public static void m1710d(View view, int i) {
        f1294a.mo3605c(view, i);
    }

    /* renamed from: a */
    public static void m1693a(View view, Rect rect) {
        f1294a.mo3480a(view, rect);
    }

    /* renamed from: z */
    public static Rect m1732z(View view) {
        return f1294a.mo3481q(view);
    }

    /* renamed from: A */
    public static boolean m1683A(View view) {
        return f1294a.mo3557t(view);
    }

    /* renamed from: B */
    public static boolean m1684B(View view) {
        return f1294a.mo325a(view);
    }

    /* renamed from: a */
    public static void m1689a(View view, int i, int i2) {
        f1294a.mo3613a(view, i, i2);
    }

    /* renamed from: C */
    public static Display m1685C(View view) {
        return f1294a.mo3333p(view);
    }
}
