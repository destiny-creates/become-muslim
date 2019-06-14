package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat */
/* renamed from: android.support.v4.view.w */
public final class C0525w {
    /* renamed from: a */
    Runnable f1304a = null;
    /* renamed from: b */
    Runnable f1305b = null;
    /* renamed from: c */
    int f1306c = -1;
    /* renamed from: d */
    private WeakReference<View> f1307d;

    /* compiled from: ViewPropertyAnimatorCompat */
    /* renamed from: android.support.v4.view.w$a */
    static class C3231a implements C0526x {
        /* renamed from: a */
        C0525w f8302a;
        /* renamed from: b */
        boolean f8303b;

        C3231a(C0525w c0525w) {
            this.f8302a = c0525w;
        }

        /* renamed from: a */
        public void mo326a(View view) {
            this.f8303b = false;
            C0526x c0526x = null;
            if (this.f8302a.f1306c > -1) {
                view.setLayerType(2, null);
            }
            if (this.f8302a.f1304a != null) {
                Runnable runnable = this.f8302a.f1304a;
                this.f8302a.f1304a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof C0526x) {
                c0526x = (C0526x) tag;
            }
            if (c0526x != null) {
                c0526x.mo326a(view);
            }
        }

        /* renamed from: b */
        public void mo327b(View view) {
            C0526x c0526x = null;
            if (this.f8302a.f1306c > -1) {
                view.setLayerType(this.f8302a.f1306c, null);
                this.f8302a.f1306c = -1;
            }
            if (VERSION.SDK_INT >= 16 || !this.f8303b) {
                if (this.f8302a.f1305b != null) {
                    Runnable runnable = this.f8302a.f1305b;
                    this.f8302a.f1305b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof C0526x) {
                    c0526x = (C0526x) tag;
                }
                if (c0526x != null) {
                    c0526x.mo327b(view);
                }
                this.f8303b = true;
            }
        }

        /* renamed from: c */
        public void mo328c(View view) {
            Object tag = view.getTag(2113929216);
            C0526x c0526x = tag instanceof C0526x ? (C0526x) tag : null;
            if (c0526x != null) {
                c0526x.mo328c(view);
            }
        }
    }

    C0525w(View view) {
        this.f1307d = new WeakReference(view);
    }

    /* renamed from: a */
    public C0525w m1755a(long j) {
        View view = (View) this.f1307d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    /* renamed from: a */
    public C0525w m1754a(float f) {
        View view = (View) this.f1307d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    /* renamed from: b */
    public C0525w m1759b(float f) {
        View view = (View) this.f1307d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    /* renamed from: a */
    public long m1753a() {
        View view = (View) this.f1307d.get();
        return view != null ? view.animate().getDuration() : 0;
    }

    /* renamed from: a */
    public C0525w m1758a(Interpolator interpolator) {
        View view = (View) this.f1307d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    /* renamed from: b */
    public C0525w m1760b(long j) {
        View view = (View) this.f1307d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    /* renamed from: b */
    public void m1761b() {
        View view = (View) this.f1307d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    /* renamed from: c */
    public void m1762c() {
        View view = (View) this.f1307d.get();
        if (view != null) {
            view.animate().start();
        }
    }

    /* renamed from: a */
    public C0525w m1756a(C0526x c0526x) {
        View view = (View) this.f1307d.get();
        if (view != null) {
            if (VERSION.SDK_INT >= 16) {
                m1752a(view, c0526x);
            } else {
                view.setTag(2113929216, c0526x);
                m1752a(view, new C3231a(this));
            }
        }
        return this;
    }

    /* renamed from: a */
    private void m1752a(final View view, final C0526x c0526x) {
        if (c0526x != null) {
            view.animate().setListener(new AnimatorListenerAdapter(this) {
                /* renamed from: c */
                final /* synthetic */ C0525w f1300c;

                public void onAnimationCancel(Animator animator) {
                    c0526x.mo328c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    c0526x.mo327b(view);
                }

                public void onAnimationStart(Animator animator) {
                    c0526x.mo326a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    /* renamed from: a */
    public C0525w m1757a(final C0527z c0527z) {
        final View view = (View) this.f1307d.get();
        if (view != null && VERSION.SDK_INT >= 19) {
            AnimatorUpdateListener animatorUpdateListener = null;
            if (c0527z != null) {
                animatorUpdateListener = new AnimatorUpdateListener(this) {
                    /* renamed from: c */
                    final /* synthetic */ C0525w f1303c;

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c0527z.mo410a(view);
                    }
                };
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }
}
