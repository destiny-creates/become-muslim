package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p020a.p021a.C0259a;
import android.support.v4.view.C0517s;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;

/* compiled from: FloatingActionButtonImpl */
/* renamed from: android.support.design.widget.e */
class C0187e {
    /* renamed from: a */
    static final Interpolator f415a = C0166a.f364c;
    /* renamed from: j */
    static final int[] f416j = new int[]{16842919, 16842910};
    /* renamed from: k */
    static final int[] f417k = new int[]{16842908, 16842910};
    /* renamed from: l */
    static final int[] f418l = new int[]{16842910};
    /* renamed from: m */
    static final int[] f419m = new int[0];
    /* renamed from: b */
    int f420b = 0;
    /* renamed from: c */
    C3138i f421c;
    /* renamed from: d */
    Drawable f422d;
    /* renamed from: e */
    Drawable f423e;
    /* renamed from: f */
    C0180c f424f;
    /* renamed from: g */
    Drawable f425g;
    /* renamed from: h */
    float f426h;
    /* renamed from: i */
    float f427i;
    /* renamed from: n */
    final C0201s f428n;
    /* renamed from: o */
    final C0189j f429o;
    /* renamed from: p */
    private final C0196l f430p;
    /* renamed from: q */
    private float f431q;
    /* renamed from: r */
    private final Rect f432r = new Rect();
    /* renamed from: s */
    private OnPreDrawListener f433s;

    /* compiled from: FloatingActionButtonImpl */
    /* renamed from: android.support.design.widget.e$3 */
    class C01843 implements OnPreDrawListener {
        /* renamed from: a */
        final /* synthetic */ C0187e f410a;

        C01843(C0187e c0187e) {
            this.f410a = c0187e;
        }

        public boolean onPreDraw() {
            this.f410a.m426i();
            return true;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    /* renamed from: android.support.design.widget.e$c */
    interface C0185c {
        /* renamed from: a */
        void mo64a();

        /* renamed from: b */
        void mo65b();
    }

    /* compiled from: FloatingActionButtonImpl */
    /* renamed from: android.support.design.widget.e$e */
    private abstract class C0186e extends AnimatorListenerAdapter implements AnimatorUpdateListener {
        /* renamed from: a */
        private boolean f411a;
        /* renamed from: b */
        final /* synthetic */ C0187e f412b;
        /* renamed from: c */
        private float f413c;
        /* renamed from: d */
        private float f414d;

        /* renamed from: a */
        protected abstract float mo83a();

        private C0186e(C0187e c0187e) {
            this.f412b = c0187e;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f411a) {
                this.f413c = this.f412b.f421c.m9261a();
                this.f414d = mo83a();
                this.f411a = true;
            }
            this.f412b.f421c.m9264b(this.f413c + ((this.f414d - this.f413c) * valueAnimator.getAnimatedFraction()));
        }

        public void onAnimationEnd(Animator animator) {
            this.f412b.f421c.m9264b(this.f414d);
            this.f411a = null;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    /* renamed from: android.support.design.widget.e$a */
    private class C3134a extends C0186e {
        /* renamed from: a */
        final /* synthetic */ C0187e f8034a;

        /* renamed from: a */
        protected float mo83a() {
            return 0.0f;
        }

        C3134a(C0187e c0187e) {
            this.f8034a = c0187e;
            super();
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    /* renamed from: android.support.design.widget.e$b */
    private class C3135b extends C0186e {
        /* renamed from: a */
        final /* synthetic */ C0187e f8035a;

        C3135b(C0187e c0187e) {
            this.f8035a = c0187e;
            super();
        }

        /* renamed from: a */
        protected float mo83a() {
            return this.f8035a.f426h + this.f8035a.f427i;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    /* renamed from: android.support.design.widget.e$d */
    private class C3136d extends C0186e {
        /* renamed from: a */
        final /* synthetic */ C0187e f8036a;

        C3136d(C0187e c0187e) {
            this.f8036a = c0187e;
            super();
        }

        /* renamed from: a */
        protected float mo83a() {
            return this.f8036a.f426h;
        }
    }

    /* renamed from: b */
    void mo90b(Rect rect) {
    }

    /* renamed from: d */
    void mo91d() {
    }

    /* renamed from: h */
    boolean mo92h() {
        return true;
    }

    C0187e(C0201s c0201s, C0189j c0189j) {
        this.f428n = c0201s;
        this.f429o = c0189j;
        this.f430p = new C0196l();
        this.f430p.m453a(f416j, m403a(new C3135b(this)));
        this.f430p.m453a(f417k, m403a(new C3135b(this)));
        this.f430p.m453a(f418l, m403a(new C3136d(this)));
        this.f430p.m453a(f419m, m403a(new C3134a(this)));
        this.f431q = this.f428n.getRotation();
    }

    /* renamed from: a */
    void m412a(ColorStateList colorStateList) {
        if (this.f422d != null) {
            C0259a.m692a(this.f422d, colorStateList);
        }
        if (this.f424f != null) {
            this.f424f.m397a(colorStateList);
        }
    }

    /* renamed from: a */
    void m413a(Mode mode) {
        if (this.f422d != null) {
            C0259a.m695a(this.f422d, mode);
        }
    }

    /* renamed from: a */
    void mo86a(int i) {
        if (this.f423e != null) {
            C0259a.m692a(this.f423e, C0187e.m404b(i));
        }
    }

    /* renamed from: a */
    final void m409a(float f) {
        if (this.f426h != f) {
            this.f426h = f;
            mo85a(f, this.f427i);
        }
    }

    /* renamed from: a */
    float mo84a() {
        return this.f426h;
    }

    /* renamed from: a */
    void mo85a(float f, float f2) {
        if (this.f421c != null) {
            this.f421c.m9263a(f, this.f427i + f);
            m422e();
        }
    }

    /* renamed from: a */
    void mo88a(int[] iArr) {
        this.f430p.m452a(iArr);
    }

    /* renamed from: b */
    void mo89b() {
        this.f430p.m451a();
    }

    /* renamed from: a */
    void m415a(final C0185c c0185c, final boolean z) {
        if (!m428k()) {
            this.f428n.animate().cancel();
            if (m406m()) {
                this.f420b = 1;
                this.f428n.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(C0166a.f364c).setListener(new AnimatorListenerAdapter(this) {
                    /* renamed from: c */
                    final /* synthetic */ C0187e f405c;
                    /* renamed from: d */
                    private boolean f406d;

                    public void onAnimationStart(Animator animator) {
                        this.f405c.f428n.m462a(0, z);
                        this.f406d = false;
                    }

                    public void onAnimationCancel(Animator animator) {
                        this.f406d = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        this.f405c.f420b = 0;
                        if (this.f406d == null) {
                            this.f405c.f428n.m462a(z ? 8 : 4, z);
                            if (c0185c != null) {
                                c0185c.mo65b();
                            }
                        }
                    }
                });
            } else {
                this.f428n.m462a(z ? 8 : 4, z);
                if (c0185c != null) {
                    c0185c.mo65b();
                }
            }
        }
    }

    /* renamed from: b */
    void m419b(final C0185c c0185c, final boolean z) {
        if (!m427j()) {
            this.f428n.animate().cancel();
            if (m406m()) {
                this.f420b = 2;
                if (this.f428n.getVisibility() != 0) {
                    this.f428n.setAlpha(0.0f);
                    this.f428n.setScaleY(0.0f);
                    this.f428n.setScaleX(0.0f);
                }
                this.f428n.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(C0166a.f365d).setListener(new AnimatorListenerAdapter(this) {
                    /* renamed from: c */
                    final /* synthetic */ C0187e f409c;

                    public void onAnimationStart(Animator animator) {
                        this.f409c.f428n.m462a(0, z);
                    }

                    public void onAnimationEnd(Animator animator) {
                        this.f409c.f420b = 0;
                        if (c0185c != null) {
                            c0185c.mo64a();
                        }
                    }
                });
            } else {
                this.f428n.m462a(0, z);
                this.f428n.setAlpha(1.0f);
                this.f428n.setScaleY(1.0f);
                this.f428n.setScaleX(1.0f);
                if (c0185c != null) {
                    c0185c.mo64a();
                }
            }
        }
    }

    /* renamed from: c */
    final Drawable m420c() {
        return this.f425g;
    }

    /* renamed from: e */
    final void m422e() {
        Rect rect = this.f432r;
        mo87a(rect);
        mo90b(rect);
        this.f429o.mo70a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: a */
    void mo87a(Rect rect) {
        this.f421c.getPadding(rect);
    }

    /* renamed from: f */
    void m423f() {
        if (mo92h()) {
            m405l();
            this.f428n.getViewTreeObserver().addOnPreDrawListener(this.f433s);
        }
    }

    /* renamed from: g */
    void m424g() {
        if (this.f433s != null) {
            this.f428n.getViewTreeObserver().removeOnPreDrawListener(this.f433s);
            this.f433s = null;
        }
    }

    /* renamed from: i */
    void m426i() {
        float rotation = this.f428n.getRotation();
        if (this.f431q != rotation) {
            this.f431q = rotation;
            m407n();
        }
    }

    /* renamed from: l */
    private void m405l() {
        if (this.f433s == null) {
            this.f433s = new C01843(this);
        }
    }

    /* renamed from: j */
    boolean m427j() {
        boolean z = false;
        if (this.f428n.getVisibility() != 0) {
            if (this.f420b == 2) {
                z = true;
            }
            return z;
        }
        if (this.f420b != 1) {
            z = true;
        }
        return z;
    }

    /* renamed from: k */
    boolean m428k() {
        boolean z = false;
        if (this.f428n.getVisibility() == 0) {
            if (this.f420b == 1) {
                z = true;
            }
            return z;
        }
        if (this.f420b != 2) {
            z = true;
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private android.animation.ValueAnimator m403a(android.support.design.widget.C0187e.C0186e r4) {
        /*
        r3 = this;
        r0 = new android.animation.ValueAnimator;
        r0.<init>();
        r1 = f415a;
        r0.setInterpolator(r1);
        r1 = 100;
        r0.setDuration(r1);
        r0.addListener(r4);
        r0.addUpdateListener(r4);
        r4 = 2;
        r4 = new float[r4];
        r4 = {0, 1065353216};
        r0.setFloatValues(r4);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.e.a(android.support.design.widget.e$e):android.animation.ValueAnimator");
    }

    /* renamed from: b */
    private static ColorStateList m404b(int i) {
        r1 = new int[3][];
        int[] iArr = new int[]{f417k, i, f416j};
        iArr[1] = i;
        r1[2] = new int[0];
        iArr[2] = 0;
        return new ColorStateList(r1, iArr);
    }

    /* renamed from: m */
    private boolean m406m() {
        return C0517s.m1730x(this.f428n) && !this.f428n.isInEditMode();
    }

    /* renamed from: n */
    private void m407n() {
        if (VERSION.SDK_INT == 19) {
            if (this.f431q % 90.0f != 0.0f) {
                if (this.f428n.getLayerType() != 1) {
                    this.f428n.setLayerType(1, null);
                }
            } else if (this.f428n.getLayerType() != 0) {
                this.f428n.setLayerType(0, null);
            }
        }
        if (this.f421c != null) {
            this.f421c.m9262a(-this.f431q);
        }
        if (this.f424f != null) {
            this.f424f.m396a(-this.f431q);
        }
    }
}
