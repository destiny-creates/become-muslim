package com.p050a.p051a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import com.facebook.imageutils.JfifUtil;
import com.p050a.p051a.p055b.C0889a;
import com.p050a.p051a.p055b.C0890b;
import com.p050a.p051a.p056c.C0917e;
import com.p050a.p051a.p056c.p059c.C4837b;
import com.p050a.p051a.p060d.C0935t;
import com.p050a.p051a.p061e.C0947e;
import com.p050a.p051a.p061e.C3395c;
import com.p050a.p051a.p062f.C0952c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: LottieDrawable */
/* renamed from: com.a.a.g */
public class C0957g extends Drawable implements Animatable, Callback {
    /* renamed from: c */
    private static final String f2679c = "g";
    /* renamed from: a */
    C0891b f2680a;
    /* renamed from: b */
    C0967n f2681b;
    /* renamed from: d */
    private final Matrix f2682d = new Matrix();
    /* renamed from: e */
    private C0954f f2683e;
    /* renamed from: f */
    private final C3395c f2684f = new C3395c();
    /* renamed from: g */
    private float f2685g = 1.0f;
    /* renamed from: h */
    private final Set<Object> f2686h = new HashSet();
    /* renamed from: i */
    private final ArrayList<C0956a> f2687i = new ArrayList();
    /* renamed from: j */
    private C0890b f2688j;
    /* renamed from: k */
    private String f2689k;
    /* renamed from: l */
    private C0920c f2690l;
    /* renamed from: m */
    private C0889a f2691m;
    /* renamed from: n */
    private boolean f2692n;
    /* renamed from: o */
    private C4837b f2693o;
    /* renamed from: p */
    private int f2694p = JfifUtil.MARKER_FIRST_BYTE;
    /* renamed from: q */
    private boolean f2695q;

    /* compiled from: LottieDrawable */
    /* renamed from: com.a.a.g$1 */
    class C09551 implements AnimatorUpdateListener {
        /* renamed from: a */
        final /* synthetic */ C0957g f2678a;

        C09551(C0957g c0957g) {
            this.f2678a = c0957g;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.f2678a.f2693o != null) {
                this.f2678a.f2693o.mo3345a(this.f2678a.f2684f.m10806d());
            }
        }
    }

    /* compiled from: LottieDrawable */
    /* renamed from: com.a.a.g$a */
    private interface C0956a {
        /* renamed from: a */
        void mo742a(C0954f c0954f);
    }

    /* compiled from: LottieDrawable */
    /* renamed from: com.a.a.g$2 */
    class C33962 implements C0956a {
        /* renamed from: a */
        final /* synthetic */ C0957g f9040a;

        C33962(C0957g c0957g) {
            this.f9040a = c0957g;
        }

        /* renamed from: a */
        public void mo742a(C0954f c0954f) {
            this.f9040a.m3387f();
        }
    }

    public int getOpacity() {
        return -3;
    }

    public C0957g() {
        this.f2684f.addUpdateListener(new C09551(this));
    }

    /* renamed from: a */
    public boolean m3371a() {
        return this.f2692n;
    }

    /* renamed from: a */
    public void m3370a(boolean z) {
        if (VERSION.SDK_INT < 19) {
            Log.w(f2679c, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.f2692n = z;
        if (this.f2683e) {
            m3355u();
        }
    }

    /* renamed from: a */
    public void m3369a(String str) {
        this.f2689k = str;
    }

    /* renamed from: b */
    public String m3374b() {
        return this.f2689k;
    }

    /* renamed from: c */
    public void m3378c() {
        if (this.f2688j != null) {
            this.f2688j.m3159a();
        }
    }

    /* renamed from: a */
    public boolean m3372a(C0954f c0954f) {
        if (this.f2683e == c0954f) {
            return null;
        }
        m3384e();
        this.f2683e = c0954f;
        m3355u();
        this.f2684f.m10803a(c0954f);
        m3382d(this.f2684f.getAnimatedFraction());
        m3385e(this.f2685g);
        m3356v();
        Iterator it = new ArrayList(this.f2687i).iterator();
        while (it.hasNext()) {
            ((C0956a) it.next()).mo742a(c0954f);
            it.remove();
        }
        this.f2687i.clear();
        c0954f.m3339a(this.f2695q);
        return true;
    }

    /* renamed from: b */
    public void m3377b(boolean z) {
        this.f2695q = z;
        if (this.f2683e != null) {
            this.f2683e.m3339a(z);
        }
    }

    /* renamed from: d */
    public C0963k m3381d() {
        return this.f2683e != null ? this.f2683e.m3336a() : null;
    }

    /* renamed from: u */
    private void m3355u() {
        this.f2693o = new C4837b(this, C0935t.m3278a(this.f2683e), this.f2683e.m3346g(), this.f2683e);
    }

    /* renamed from: e */
    public void m3384e() {
        m3378c();
        if (this.f2684f.isRunning()) {
            this.f2684f.cancel();
        }
        this.f2683e = null;
        this.f2693o = null;
        this.f2688j = null;
        this.f2684f.m10808f();
        invalidateSelf();
    }

    public void invalidateSelf() {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void setAlpha(int i) {
        this.f2694p = i;
    }

    public int getAlpha() {
        return this.f2694p;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Log.w("LOTTIE", "Use addColorFilter instead.");
    }

    public void draw(Canvas canvas) {
        C0940d.m3288b("Drawable#draw");
        if (this.f2693o != null) {
            float f = this.f2685g;
            float a = m3352a(canvas);
            if (f > a) {
                f = this.f2685g / a;
            } else {
                a = f;
                f = 1.0f;
            }
            int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
            if (i > 0) {
                canvas.save();
                float width = ((float) this.f2683e.m3340b().width()) / 2.0f;
                float height = ((float) this.f2683e.m3340b().height()) / 2.0f;
                float f2 = width * a;
                float f3 = height * a;
                canvas.translate((m3398q() * width) - f2, (m3398q() * height) - f3);
                canvas.scale(f, f, f2, f3);
            }
            this.f2682d.reset();
            this.f2682d.preScale(a, a);
            this.f2693o.mo2789a(canvas, this.f2682d, this.f2694p);
            C0940d.m3289c("Drawable#draw");
            if (i > 0) {
                canvas.restore();
            }
        }
    }

    public void start() {
        m3387f();
    }

    public void stop() {
        m3388g();
    }

    public boolean isRunning() {
        return m3395n();
    }

    /* renamed from: f */
    public void m3387f() {
        if (this.f2693o == null) {
            this.f2687i.add(new C33962(this));
        } else {
            this.f2684f.m10811i();
        }
    }

    /* renamed from: g */
    public void m3388g() {
        this.f2687i.clear();
        this.f2684f.m10812j();
    }

    /* renamed from: a */
    public void m3363a(int i) {
        this.f2684f.m10804b(i);
    }

    /* renamed from: h */
    public float m3389h() {
        return this.f2684f.m10813k();
    }

    /* renamed from: a */
    public void m3362a(final float f) {
        if (this.f2683e == null) {
            this.f2687i.add(new C0956a(this) {
                /* renamed from: b */
                final /* synthetic */ C0957g f9042b;

                /* renamed from: a */
                public void mo742a(C0954f c0954f) {
                    this.f9042b.m3362a(f);
                }
            });
        } else {
            m3363a((int) C0947e.m3302a(this.f2683e.m3343d(), this.f2683e.m3344e(), f));
        }
    }

    /* renamed from: b */
    public void m3376b(int i) {
        this.f2684f.m10805c(i);
    }

    /* renamed from: i */
    public float m3390i() {
        return this.f2684f.m10814l();
    }

    /* renamed from: b */
    public void m3375b(final float f) {
        if (this.f2683e == null) {
            this.f2687i.add(new C0956a(this) {
                /* renamed from: b */
                final /* synthetic */ C0957g f9044b;

                /* renamed from: a */
                public void mo742a(C0954f c0954f) {
                    this.f9044b.m3375b(f);
                }
            });
        } else {
            m3376b((int) C0947e.m3302a(this.f2683e.m3343d(), this.f2683e.m3344e(), f));
        }
    }

    /* renamed from: a */
    public void m3364a(int i, int i2) {
        this.f2684f.m10802a(i, i2);
    }

    /* renamed from: c */
    public void m3379c(float f) {
        this.f2684f.m10800a(f);
    }

    /* renamed from: j */
    public float m3391j() {
        return this.f2684f.m10810h();
    }

    /* renamed from: c */
    public void m3380c(final int i) {
        if (this.f2683e == null) {
            this.f2687i.add(new C0956a(this) {
                /* renamed from: b */
                final /* synthetic */ C0957g f9046b;

                /* renamed from: a */
                public void mo742a(C0954f c0954f) {
                    this.f9046b.m3380c(i);
                }
            });
        } else {
            this.f2684f.m10801a(i);
        }
    }

    /* renamed from: k */
    public int m3392k() {
        return (int) this.f2684f.m10807e();
    }

    /* renamed from: d */
    public void m3382d(final float f) {
        if (this.f2683e == null) {
            this.f2687i.add(new C0956a(this) {
                /* renamed from: b */
                final /* synthetic */ C0957g f9048b;

                /* renamed from: a */
                public void mo742a(C0954f c0954f) {
                    this.f9048b.m3382d(f);
                }
            });
        } else {
            m3380c((int) C0947e.m3302a(this.f2683e.m3343d(), this.f2683e.m3344e(), f));
        }
    }

    /* renamed from: d */
    public void m3383d(int i) {
        this.f2684f.setRepeatMode(i);
    }

    /* renamed from: l */
    public int m3393l() {
        return this.f2684f.getRepeatMode();
    }

    /* renamed from: e */
    public void m3386e(int i) {
        this.f2684f.setRepeatCount(i);
    }

    /* renamed from: m */
    public int m3394m() {
        return this.f2684f.getRepeatCount();
    }

    /* renamed from: n */
    public boolean m3395n() {
        return this.f2684f.isRunning();
    }

    /* renamed from: e */
    public void m3385e(float f) {
        this.f2685g = f;
        m3356v();
    }

    /* renamed from: a */
    public void m3367a(C0920c c0920c) {
        this.f2690l = c0920c;
        if (this.f2688j != null) {
            this.f2688j.m3160a(c0920c);
        }
    }

    /* renamed from: a */
    public void m3365a(C0891b c0891b) {
        this.f2680a = c0891b;
        if (this.f2691m != null) {
            this.f2691m.m3156a(c0891b);
        }
    }

    /* renamed from: a */
    public void m3368a(C0967n c0967n) {
        this.f2681b = c0967n;
    }

    /* renamed from: o */
    public C0967n m3396o() {
        return this.f2681b;
    }

    /* renamed from: p */
    public boolean m3397p() {
        return this.f2681b == null && this.f2683e.m3347h().m1469b() > 0;
    }

    /* renamed from: q */
    public float m3398q() {
        return this.f2685g;
    }

    /* renamed from: r */
    public C0954f m3399r() {
        return this.f2683e;
    }

    /* renamed from: v */
    private void m3356v() {
        if (this.f2683e != null) {
            float q = m3398q();
            setBounds(0, 0, (int) (((float) this.f2683e.m3340b().width()) * q), (int) (((float) this.f2683e.m3340b().height()) * q));
        }
    }

    /* renamed from: s */
    public void m3400s() {
        this.f2687i.clear();
        this.f2684f.cancel();
    }

    /* renamed from: t */
    public float m3401t() {
        return this.f2684f.m10806d();
    }

    public int getIntrinsicWidth() {
        return this.f2683e == null ? -1 : (int) (((float) this.f2683e.m3340b().width()) * m3398q());
    }

    public int getIntrinsicHeight() {
        return this.f2683e == null ? -1 : (int) (((float) this.f2683e.m3340b().height()) * m3398q());
    }

    /* renamed from: a */
    public List<C0917e> m3361a(C0917e c0917e) {
        if (this.f2693o == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        List<C0917e> arrayList = new ArrayList();
        this.f2693o.mo2791a(c0917e, 0, arrayList, new C0917e(new String[0]));
        return arrayList;
    }

    /* renamed from: a */
    public <T> void m3366a(final C0917e c0917e, final T t, final C0952c<T> c0952c) {
        if (this.f2693o == null) {
            this.f2687i.add(new C0956a(this) {
                /* renamed from: d */
                final /* synthetic */ C0957g f9052d;

                /* renamed from: a */
                public void mo742a(C0954f c0954f) {
                    this.f9052d.m3366a(c0917e, t, c0952c);
                }
            });
            return;
        }
        int i = 1;
        if (c0917e.m3221a() != null) {
            c0917e.m3221a().mo2792a(t, c0952c);
        } else {
            c0917e = m3361a(c0917e);
            for (int i2 = 0; i2 < c0917e.size(); i2++) {
                ((C0917e) c0917e.get(i2)).m3221a().mo2792a(t, c0952c);
            }
            i = 1 ^ c0917e.isEmpty();
        }
        if (i != 0) {
            invalidateSelf();
            if (t == C0959i.f2723w) {
                m3382d(m3401t());
            }
        }
    }

    /* renamed from: b */
    public Bitmap m3373b(String str) {
        C0890b w = m3357w();
        return w != null ? w.m3158a(str) : null;
    }

    /* renamed from: w */
    private C0890b m3357w() {
        if (getCallback() == null) {
            return null;
        }
        if (!(this.f2688j == null || this.f2688j.m3161a(m3359y()))) {
            this.f2688j.m3159a();
            this.f2688j = null;
        }
        if (this.f2688j == null) {
            this.f2688j = new C0890b(getCallback(), this.f2689k, this.f2690l, this.f2683e.m3349j());
        }
        return this.f2688j;
    }

    /* renamed from: a */
    public Typeface m3360a(String str, String str2) {
        C0889a x = m3358x();
        return x != null ? x.m3155a(str, str2) : null;
    }

    /* renamed from: x */
    private C0889a m3358x() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f2691m == null) {
            this.f2691m = new C0889a(getCallback(), this.f2680a);
        }
        return this.f2691m;
    }

    /* renamed from: y */
    private Context m3359y() {
        Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public void invalidateDrawable(Drawable drawable) {
        drawable = getCallback();
        if (drawable != null) {
            drawable.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        drawable = getCallback();
        if (drawable != null) {
            drawable.scheduleDrawable(this, runnable, j);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        drawable = getCallback();
        if (drawable != null) {
            drawable.unscheduleDrawable(this, runnable);
        }
    }

    /* renamed from: a */
    private float m3352a(Canvas canvas) {
        return Math.min(((float) canvas.getWidth()) / ((float) this.f2683e.m3340b().width()), ((float) canvas.getHeight()) / ((float) this.f2683e.m3340b().height()));
    }
}
