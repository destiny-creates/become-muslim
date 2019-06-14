package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.C0517s;
import android.support.v7.widget.RecyclerView.C0698h;
import android.support.v7.widget.RecyclerView.C0705m;
import android.support.v7.widget.RecyclerView.C0706n;
import android.support.v7.widget.RecyclerView.C0715u;
import android.view.MotionEvent;
import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.server.http.HttpStatus;

/* compiled from: FastScroller */
class an extends C0698h implements C0705m {
    /* renamed from: g */
    private static final int[] f8719g = new int[]{16842919};
    /* renamed from: h */
    private static final int[] f8720h = new int[0];
    /* renamed from: A */
    private final int[] f8721A = new int[2];
    /* renamed from: B */
    private final ValueAnimator f8722B = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    /* renamed from: C */
    private int f8723C = 0;
    /* renamed from: D */
    private final Runnable f8724D = new C07541(this);
    /* renamed from: E */
    private final C0706n f8725E = new C33062(this);
    /* renamed from: a */
    int f8726a;
    /* renamed from: b */
    int f8727b;
    /* renamed from: c */
    float f8728c;
    /* renamed from: d */
    int f8729d;
    /* renamed from: e */
    int f8730e;
    /* renamed from: f */
    float f8731f;
    /* renamed from: i */
    private final int f8732i;
    /* renamed from: j */
    private final int f8733j;
    /* renamed from: k */
    private final StateListDrawable f8734k;
    /* renamed from: l */
    private final Drawable f8735l;
    /* renamed from: m */
    private final int f8736m;
    /* renamed from: n */
    private final int f8737n;
    /* renamed from: o */
    private final StateListDrawable f8738o;
    /* renamed from: p */
    private final Drawable f8739p;
    /* renamed from: q */
    private final int f8740q;
    /* renamed from: r */
    private final int f8741r;
    /* renamed from: s */
    private int f8742s = 0;
    /* renamed from: t */
    private int f8743t = 0;
    /* renamed from: u */
    private RecyclerView f8744u;
    /* renamed from: v */
    private boolean f8745v = false;
    /* renamed from: w */
    private boolean f8746w = false;
    /* renamed from: x */
    private int f8747x = 0;
    /* renamed from: y */
    private int f8748y = 0;
    /* renamed from: z */
    private final int[] f8749z = new int[2];

    /* compiled from: FastScroller */
    /* renamed from: android.support.v7.widget.an$1 */
    class C07541 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ an f1992a;

        C07541(an anVar) {
            this.f1992a = anVar;
        }

        public void run() {
            this.f1992a.m10428a((int) HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
        }
    }

    /* compiled from: FastScroller */
    /* renamed from: android.support.v7.widget.an$a */
    private class C0755a extends AnimatorListenerAdapter {
        /* renamed from: a */
        final /* synthetic */ an f1993a;
        /* renamed from: b */
        private boolean f1994b;

        private C0755a(an anVar) {
            this.f1993a = anVar;
            this.f1994b = null;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f1994b != null) {
                this.f1994b = false;
                return;
            }
            if (((Float) this.f1993a.f8722B.getAnimatedValue()).floatValue() == 0.0f) {
                this.f1993a.f8723C = 0;
                this.f1993a.m10414b(0);
            } else {
                this.f1993a.f8723C = 2;
                this.f1993a.m10422d();
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f1994b = true;
        }
    }

    /* compiled from: FastScroller */
    /* renamed from: android.support.v7.widget.an$b */
    private class C0756b implements AnimatorUpdateListener {
        /* renamed from: a */
        final /* synthetic */ an f1995a;

        private C0756b(an anVar) {
            this.f1995a = anVar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            valueAnimator = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            this.f1995a.f8734k.setAlpha(valueAnimator);
            this.f1995a.f8735l.setAlpha(valueAnimator);
            this.f1995a.m10422d();
        }
    }

    /* compiled from: FastScroller */
    /* renamed from: android.support.v7.widget.an$2 */
    class C33062 extends C0706n {
        /* renamed from: a */
        final /* synthetic */ an f8718a;

        C33062(an anVar) {
            this.f8718a = anVar;
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            this.f8718a.m10429a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* renamed from: a */
    public void mo626a(boolean z) {
    }

    an(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.f8734k = stateListDrawable;
        this.f8735l = drawable;
        this.f8738o = stateListDrawable2;
        this.f8739p = drawable2;
        this.f8736m = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f8737n = Math.max(i, drawable.getIntrinsicWidth());
        this.f8740q = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f8741r = Math.max(i, drawable2.getIntrinsicWidth());
        this.f8732i = i2;
        this.f8733j = i3;
        this.f8734k.setAlpha(JfifUtil.MARKER_FIRST_BYTE);
        this.f8735l.setAlpha(JfifUtil.MARKER_FIRST_BYTE);
        this.f8722B.addListener(new C0755a());
        this.f8722B.addUpdateListener(new C0756b());
        m10431a(recyclerView);
    }

    /* renamed from: a */
    public void m10431a(RecyclerView recyclerView) {
        if (this.f8744u != recyclerView) {
            if (this.f8744u != null) {
                m10419c();
            }
            this.f8744u = recyclerView;
            if (this.f8744u != null) {
                m10412b();
            }
        }
    }

    /* renamed from: b */
    private void m10412b() {
        this.f8744u.addItemDecoration(this);
        this.f8744u.addOnItemTouchListener(this);
        this.f8744u.addOnScrollListener(this.f8725E);
    }

    /* renamed from: c */
    private void m10419c() {
        this.f8744u.removeItemDecoration(this);
        this.f8744u.removeOnItemTouchListener(this);
        this.f8744u.removeOnScrollListener(this.f8725E);
        m10424f();
    }

    /* renamed from: d */
    private void m10422d() {
        this.f8744u.invalidate();
    }

    /* renamed from: b */
    private void m10414b(int i) {
        if (i == 2 && this.f8747x != 2) {
            this.f8734k.setState(f8719g);
            m10424f();
        }
        if (i == 0) {
            m10422d();
        } else {
            m10427a();
        }
        if (this.f8747x == 2 && i != 2) {
            this.f8734k.setState(f8720h);
            m10420c(1200);
        } else if (i == 1) {
            m10420c(1500);
        }
        this.f8747x = i;
    }

    /* renamed from: e */
    private boolean m10423e() {
        return C0517s.m1711e(this.f8744u) == 1;
    }

    /* renamed from: a */
    public void m10427a() {
        int i = this.f8723C;
        if (i != 0) {
            if (i == 3) {
                this.f8722B.cancel();
            } else {
                return;
            }
        }
        this.f8723C = 1;
        this.f8722B.setFloatValues(new float[]{((Float) this.f8722B.getAnimatedValue()).floatValue(), 1.0f});
        this.f8722B.setDuration(500);
        this.f8722B.setStartDelay(0);
        this.f8722B.start();
    }

    /* renamed from: a */
    void m10428a(int i) {
        switch (this.f8723C) {
            case 1:
                this.f8722B.cancel();
                break;
            case 2:
                break;
            default:
                return;
        }
        this.f8723C = 3;
        this.f8722B.setFloatValues(new float[]{((Float) this.f8722B.getAnimatedValue()).floatValue(), 0.0f});
        this.f8722B.setDuration((long) i);
        this.f8722B.start();
    }

    /* renamed from: f */
    private void m10424f() {
        this.f8744u.removeCallbacks(this.f8724D);
    }

    /* renamed from: c */
    private void m10420c(int i) {
        m10424f();
        this.f8744u.postDelayed(this.f8724D, (long) i);
    }

    /* renamed from: a */
    public void mo625a(Canvas canvas, RecyclerView recyclerView, C0715u c0715u) {
        if (this.f8742s == this.f8744u.getWidth()) {
            if (this.f8743t == this.f8744u.getHeight()) {
                if (this.f8723C != null) {
                    if (this.f8745v != null) {
                        m10411a(canvas);
                    }
                    if (this.f8746w != null) {
                        m10415b(canvas);
                    }
                }
                return;
            }
        }
        this.f8742s = this.f8744u.getWidth();
        this.f8743t = this.f8744u.getHeight();
        m10414b((int) null);
    }

    /* renamed from: a */
    private void m10411a(Canvas canvas) {
        int i = this.f8742s - this.f8736m;
        int i2 = this.f8727b - (this.f8726a / 2);
        this.f8734k.setBounds(0, 0, this.f8736m, this.f8726a);
        this.f8735l.setBounds(0, 0, this.f8737n, this.f8743t);
        if (m10423e()) {
            this.f8735l.draw(canvas);
            canvas.translate((float) this.f8736m, (float) i2);
            canvas.scale(-1.0f, 1.0f);
            this.f8734k.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate((float) (-this.f8736m), (float) (-i2));
            return;
        }
        canvas.translate((float) i, 0.0f);
        this.f8735l.draw(canvas);
        canvas.translate(0.0f, (float) i2);
        this.f8734k.draw(canvas);
        canvas.translate((float) (-i), (float) (-i2));
    }

    /* renamed from: b */
    private void m10415b(Canvas canvas) {
        int i = this.f8743t - this.f8740q;
        int i2 = this.f8730e - (this.f8729d / 2);
        this.f8738o.setBounds(0, 0, this.f8729d, this.f8740q);
        this.f8739p.setBounds(0, 0, this.f8742s, this.f8741r);
        canvas.translate(0.0f, (float) i);
        this.f8739p.draw(canvas);
        canvas.translate((float) i2, 0.0f);
        this.f8738o.draw(canvas);
        canvas.translate((float) (-i2), (float) (-i));
    }

    /* renamed from: a */
    void m10429a(int i, int i2) {
        int computeVerticalScrollRange = this.f8744u.computeVerticalScrollRange();
        int i3 = this.f8743t;
        boolean z = computeVerticalScrollRange - i3 > 0 && this.f8743t >= this.f8732i;
        this.f8745v = z;
        int computeHorizontalScrollRange = this.f8744u.computeHorizontalScrollRange();
        int i4 = this.f8742s;
        boolean z2 = computeHorizontalScrollRange - i4 > 0 && this.f8742s >= this.f8732i;
        this.f8746w = z2;
        if (this.f8745v || this.f8746w) {
            if (this.f8745v) {
                float f = (float) i3;
                this.f8727b = (int) ((f * (((float) i2) + (f / 2.0f))) / ((float) computeVerticalScrollRange));
                this.f8726a = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
            }
            if (this.f8746w != 0) {
                i2 = (float) i4;
                this.f8730e = (int) ((i2 * (((float) i) + (i2 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.f8729d = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
            }
            if (this.f8747x == 0 || this.f8747x == 1) {
                m10414b(1);
            }
            return;
        }
        if (this.f8747x != 0) {
            m10414b(0);
        }
    }

    /* renamed from: a */
    public boolean mo627a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f8747x == 1) {
            recyclerView = m10433a(motionEvent.getX(), motionEvent.getY());
            boolean b = m10436b(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (recyclerView == null && !b) {
                return false;
            }
            if (b) {
                this.f8748y = 1;
                this.f8731f = (float) ((int) motionEvent.getX());
            } else if (recyclerView != null) {
                this.f8748y = 2;
                this.f8728c = (float) ((int) motionEvent.getY());
            }
            m10414b(2);
        } else if (this.f8747x != 2) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public void mo628b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f8747x != null) {
            if (motionEvent.getAction() == null) {
                recyclerView = m10433a(motionEvent.getX(), motionEvent.getY());
                boolean b = m10436b(motionEvent.getX(), motionEvent.getY());
                if (recyclerView != null || b) {
                    if (b) {
                        this.f8748y = 1;
                        this.f8731f = (float) ((int) motionEvent.getX());
                    } else if (recyclerView != null) {
                        this.f8748y = 2;
                        this.f8728c = (float) ((int) motionEvent.getY());
                    }
                    m10414b(2);
                }
            } else if (motionEvent.getAction() == 1 && this.f8747x == 2) {
                this.f8728c = 0.0f;
                this.f8731f = 0.0f;
                m10414b(1);
                this.f8748y = null;
            } else if (motionEvent.getAction() == 2 && this.f8747x == 2) {
                m10427a();
                if (this.f8748y == 1) {
                    m10413b(motionEvent.getX());
                }
                if (this.f8748y == 2) {
                    m10410a(motionEvent.getY());
                }
            }
        }
    }

    /* renamed from: a */
    private void m10410a(float f) {
        int[] g = m10425g();
        f = Math.max((float) g[0], Math.min((float) g[1], f));
        if (Math.abs(((float) this.f8727b) - f) >= 2.0f) {
            int a = m10407a(this.f8728c, f, g, this.f8744u.computeVerticalScrollRange(), this.f8744u.computeVerticalScrollOffset(), this.f8743t);
            if (a != 0) {
                this.f8744u.scrollBy(0, a);
            }
            this.f8728c = f;
        }
    }

    /* renamed from: b */
    private void m10413b(float f) {
        int[] h = m10426h();
        f = Math.max((float) h[0], Math.min((float) h[1], f));
        if (Math.abs(((float) this.f8730e) - f) >= 2.0f) {
            int a = m10407a(this.f8731f, f, h, this.f8744u.computeHorizontalScrollRange(), this.f8744u.computeHorizontalScrollOffset(), this.f8742s);
            if (a != 0) {
                this.f8744u.scrollBy(a, 0);
            }
            this.f8731f = f;
        }
    }

    /* renamed from: a */
    private int m10407a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        i -= i3;
        f = (int) (((f2 - f) / ((float) i4)) * ((float) i));
        i2 += f;
        return (i2 >= i || i2 < 0) ? 0 : f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    boolean m10433a(float r3, float r4) {
        /*
        r2 = this;
        r0 = r2.m10423e();
        if (r0 == 0) goto L_0x0010;
    L_0x0006:
        r0 = r2.f8736m;
        r0 = r0 / 2;
        r0 = (float) r0;
        r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r3 > 0) goto L_0x0034;
    L_0x000f:
        goto L_0x001a;
    L_0x0010:
        r0 = r2.f8742s;
        r1 = r2.f8736m;
        r0 = r0 - r1;
        r0 = (float) r0;
        r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r3 < 0) goto L_0x0034;
    L_0x001a:
        r3 = r2.f8727b;
        r0 = r2.f8726a;
        r0 = r0 / 2;
        r3 = r3 - r0;
        r3 = (float) r3;
        r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1));
        if (r3 < 0) goto L_0x0034;
    L_0x0026:
        r3 = r2.f8727b;
        r0 = r2.f8726a;
        r0 = r0 / 2;
        r3 = r3 + r0;
        r3 = (float) r3;
        r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1));
        if (r3 > 0) goto L_0x0034;
    L_0x0032:
        r3 = 1;
        goto L_0x0035;
    L_0x0034:
        r3 = 0;
    L_0x0035:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.an.a(float, float):boolean");
    }

    /* renamed from: b */
    boolean m10436b(float f, float f2) {
        return f2 >= ((float) (this.f8743t - this.f8740q)) && f >= ((float) (this.f8730e - (this.f8729d / 2))) && f <= ((float) (this.f8730e + (this.f8729d / 2)));
    }

    /* renamed from: g */
    private int[] m10425g() {
        this.f8749z[0] = this.f8733j;
        this.f8749z[1] = this.f8743t - this.f8733j;
        return this.f8749z;
    }

    /* renamed from: h */
    private int[] m10426h() {
        this.f8721A[0] = this.f8733j;
        this.f8721A[1] = this.f8742s - this.f8733j;
        return this.f8721A;
    }
}
