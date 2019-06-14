package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.C0140a.C0130a;
import android.support.design.C0140a.C0139j;
import android.support.design.widget.C0193k.C0191a;
import android.support.design.widget.CoordinatorLayout.C0150b;
import android.support.design.widget.CoordinatorLayout.C0153e;
import android.support.design.widget.SwipeDismissBehavior.C0158a;
import android.support.v4.view.C0517s;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.facebook.imagepipeline.common.RotationOptions;
import java.util.List;

/* compiled from: BaseTransientBottomBar */
/* renamed from: android.support.design.widget.b */
public abstract class C0179b<B extends C0179b<B>> {
    /* renamed from: a */
    static final Handler f381a = new Handler(Looper.getMainLooper(), new C01671());
    /* renamed from: d */
    private static final boolean f382d;
    /* renamed from: b */
    final C0178f f383b;
    /* renamed from: c */
    final C0191a f384c;
    /* renamed from: e */
    private final ViewGroup f385e;
    /* renamed from: f */
    private final C0175c f386f;
    /* renamed from: g */
    private List<C0174a<B>> f387g;
    /* renamed from: h */
    private final AccessibilityManager f388h;

    /* compiled from: BaseTransientBottomBar */
    /* renamed from: android.support.design.widget.b$1 */
    static class C01671 implements Callback {
        C01671() {
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    ((C0179b) message.obj).m389b();
                    return true;
                case 1:
                    ((C0179b) message.obj).m390b(message.arg1);
                    return true;
                default:
                    return null;
            }
        }
    }

    /* compiled from: BaseTransientBottomBar */
    /* renamed from: android.support.design.widget.b$3 */
    class C01693 implements AnimatorUpdateListener {
        /* renamed from: a */
        final /* synthetic */ C0179b f370a;
        /* renamed from: b */
        private int f371b = null;

        C01693(C0179b c0179b) {
            this.f370a = c0179b;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            valueAnimator = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (C0179b.f382d) {
                C0517s.m1707c(this.f370a.f383b, valueAnimator - this.f371b);
            } else {
                this.f370a.f383b.setTranslationY((float) valueAnimator);
            }
            this.f371b = valueAnimator;
        }
    }

    /* compiled from: BaseTransientBottomBar */
    /* renamed from: android.support.design.widget.b$8 */
    class C01728 extends AnimatorListenerAdapter {
        /* renamed from: a */
        final /* synthetic */ C0179b f375a;

        C01728(C0179b c0179b) {
            this.f375a = c0179b;
        }

        public void onAnimationStart(Animator animator) {
            this.f375a.f386f.mo42a(70, RotationOptions.ROTATE_180);
        }

        public void onAnimationEnd(Animator animator) {
            this.f375a.m393d();
        }
    }

    /* compiled from: BaseTransientBottomBar */
    /* renamed from: android.support.design.widget.b$a */
    public static abstract class C0174a<B> {
        /* renamed from: a */
        public void m377a(B b) {
        }

        /* renamed from: a */
        public void m378a(B b, int i) {
        }
    }

    /* compiled from: BaseTransientBottomBar */
    /* renamed from: android.support.design.widget.b$c */
    public interface C0175c {
        /* renamed from: a */
        void mo42a(int i, int i2);

        /* renamed from: b */
        void mo43b(int i, int i2);
    }

    /* compiled from: BaseTransientBottomBar */
    /* renamed from: android.support.design.widget.b$d */
    interface C0176d {
        /* renamed from: a */
        void mo80a(View view);

        /* renamed from: b */
        void mo81b(View view);
    }

    /* compiled from: BaseTransientBottomBar */
    /* renamed from: android.support.design.widget.b$e */
    interface C0177e {
        /* renamed from: a */
        void mo82a(View view, int i, int i2, int i3, int i4);
    }

    /* compiled from: BaseTransientBottomBar */
    /* renamed from: android.support.design.widget.b$f */
    static class C0178f extends FrameLayout {
        /* renamed from: a */
        private C0177e f379a;
        /* renamed from: b */
        private C0176d f380b;

        C0178f(Context context) {
            this(context, null);
        }

        C0178f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, C0139j.SnackbarLayout);
            if (context.hasValue(C0139j.SnackbarLayout_elevation) != null) {
                C0517s.m1687a((View) this, (float) context.getDimensionPixelSize(C0139j.SnackbarLayout_elevation, 0));
            }
            context.recycle();
            setClickable(true);
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f379a) {
                this.f379a.mo82a(this, i, i2, i3, i4);
            }
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f380b != null) {
                this.f380b.mo80a(this);
            }
            C0517s.m1721o(this);
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f380b != null) {
                this.f380b.mo81b(this);
            }
        }

        void setOnLayoutChangeListener(C0177e c0177e) {
            this.f379a = c0177e;
        }

        void setOnAttachStateChangeListener(C0176d c0176d) {
            this.f380b = c0176d;
        }
    }

    /* compiled from: BaseTransientBottomBar */
    /* renamed from: android.support.design.widget.b$5 */
    class C31315 implements C0158a {
        /* renamed from: a */
        final /* synthetic */ C0179b f8031a;

        C31315(C0179b c0179b) {
            this.f8031a = c0179b;
        }

        /* renamed from: a */
        public void mo79a(View view) {
            view.setVisibility(8);
            this.f8031a.m387a(0);
        }

        /* renamed from: a */
        public void mo78a(int i) {
            switch (i) {
                case 0:
                    C0193k.m436a().m447d(this.f8031a.f384c);
                    return;
                case 1:
                case 2:
                    C0193k.m436a().m446c(this.f8031a.f384c);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: BaseTransientBottomBar */
    /* renamed from: android.support.design.widget.b$6 */
    class C31326 implements C0176d {
        /* renamed from: a */
        final /* synthetic */ C0179b f8032a;

        /* compiled from: BaseTransientBottomBar */
        /* renamed from: android.support.design.widget.b$6$1 */
        class C01711 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C31326 f374a;

            C01711(C31326 c31326) {
                this.f374a = c31326;
            }

            public void run() {
                this.f374a.f8032a.m392c(3);
            }
        }

        /* renamed from: a */
        public void mo80a(View view) {
        }

        C31326(C0179b c0179b) {
            this.f8032a = c0179b;
        }

        /* renamed from: b */
        public void mo81b(View view) {
            if (this.f8032a.m388a() != null) {
                C0179b.f381a.post(new C01711(this));
            }
        }
    }

    /* compiled from: BaseTransientBottomBar */
    /* renamed from: android.support.design.widget.b$7 */
    class C31337 implements C0177e {
        /* renamed from: a */
        final /* synthetic */ C0179b f8033a;

        C31337(C0179b c0179b) {
            this.f8033a = c0179b;
        }

        /* renamed from: a */
        public void mo82a(View view, int i, int i2, int i3, int i4) {
            this.f8033a.f383b.setOnLayoutChangeListener(0);
            if (this.f8033a.m394e() != null) {
                this.f8033a.m391c();
            } else {
                this.f8033a.m393d();
            }
        }
    }

    /* compiled from: BaseTransientBottomBar */
    /* renamed from: android.support.design.widget.b$b */
    final class C4442b extends SwipeDismissBehavior<C0178f> {
        /* renamed from: a */
        final /* synthetic */ C0179b f11874a;

        C4442b(C0179b c0179b) {
            this.f11874a = c0179b;
        }

        /* renamed from: a */
        public boolean mo2647a(View view) {
            return view instanceof C0178f;
        }

        /* renamed from: a */
        public boolean m14816a(CoordinatorLayout coordinatorLayout, C0178f c0178f, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 3) {
                switch (actionMasked) {
                    case 0:
                        if (coordinatorLayout.m14803a((View) c0178f, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                            C0193k.m436a().m446c(this.f11874a.f384c);
                            break;
                        }
                        break;
                    case 1:
                        break;
                    default:
                        break;
                }
            }
            C0193k.m436a().m447d(this.f11874a.f384c);
            return super.mo56a(coordinatorLayout, (View) c0178f, motionEvent);
        }
    }

    static {
        boolean z = VERSION.SDK_INT >= 16 && VERSION.SDK_INT <= 19;
        f382d = z;
    }

    /* renamed from: a */
    void m387a(int i) {
        C0193k.m436a().m443a(this.f384c, i);
    }

    /* renamed from: a */
    public boolean m388a() {
        return C0193k.m436a().m448e(this.f384c);
    }

    /* renamed from: b */
    final void m389b() {
        if (this.f383b.getParent() == null) {
            LayoutParams layoutParams = this.f383b.getLayoutParams();
            if (layoutParams instanceof C0153e) {
                C0153e c0153e = (C0153e) layoutParams;
                C0150b c4442b = new C4442b(this);
                c4442b.m9231a(0.1f);
                c4442b.m9236b(0.6f);
                c4442b.m9232a(0);
                c4442b.m9233a(new C31315(this));
                c0153e.m352a(c4442b);
                c0153e.f340g = 80;
            }
            this.f385e.addView(this.f383b);
        }
        this.f383b.setOnAttachStateChangeListener(new C31326(this));
        if (!C0517s.m1730x(this.f383b)) {
            this.f383b.setOnLayoutChangeListener(new C31337(this));
        } else if (m394e()) {
            m391c();
        } else {
            m393d();
        }
    }

    /* renamed from: c */
    void m391c() {
        if (VERSION.SDK_INT >= 12) {
            final int height = this.f383b.getHeight();
            if (f382d) {
                C0517s.m1707c(this.f383b, height);
            } else {
                this.f383b.setTranslationY((float) height);
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(new int[]{height, 0});
            valueAnimator.setInterpolator(C0166a.f363b);
            valueAnimator.setDuration(250);
            valueAnimator.addListener(new C01728(this));
            valueAnimator.addUpdateListener(new AnimatorUpdateListener(this) {
                /* renamed from: b */
                final /* synthetic */ C0179b f377b;
                /* renamed from: c */
                private int f378c = height;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    valueAnimator = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (C0179b.f382d) {
                        C0517s.m1707c(this.f377b.f383b, valueAnimator - this.f378c);
                    } else {
                        this.f377b.f383b.setTranslationY((float) valueAnimator);
                    }
                    this.f378c = valueAnimator;
                }
            });
            valueAnimator.start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f383b.getContext(), C0130a.design_snackbar_in);
        loadAnimation.setInterpolator(C0166a.f363b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            /* renamed from: a */
            final /* synthetic */ C0179b f367a;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            {
                this.f367a = r1;
            }

            public void onAnimationEnd(Animation animation) {
                this.f367a.m393d();
            }
        });
        this.f383b.startAnimation(loadAnimation);
    }

    /* renamed from: d */
    private void m385d(final int i) {
        if (VERSION.SDK_INT >= 12) {
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(new int[]{0, this.f383b.getHeight()});
            valueAnimator.setInterpolator(C0166a.f363b);
            valueAnimator.setDuration(250);
            valueAnimator.addListener(new AnimatorListenerAdapter(this) {
                /* renamed from: b */
                final /* synthetic */ C0179b f369b;

                public void onAnimationStart(Animator animator) {
                    this.f369b.f386f.mo43b(0, RotationOptions.ROTATE_180);
                }

                public void onAnimationEnd(Animator animator) {
                    this.f369b.m392c(i);
                }
            });
            valueAnimator.addUpdateListener(new C01693(this));
            valueAnimator.start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f383b.getContext(), C0130a.design_snackbar_out);
        loadAnimation.setInterpolator(C0166a.f363b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            /* renamed from: b */
            final /* synthetic */ C0179b f373b;

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                this.f373b.m392c(i);
            }
        });
        this.f383b.startAnimation(loadAnimation);
    }

    /* renamed from: b */
    final void m390b(int i) {
        if (m394e() && this.f383b.getVisibility() == 0) {
            m385d(i);
        } else {
            m392c(i);
        }
    }

    /* renamed from: d */
    void m393d() {
        C0193k.m436a().m445b(this.f384c);
        if (this.f387g != null) {
            for (int size = this.f387g.size() - 1; size >= 0; size--) {
                ((C0174a) this.f387g.get(size)).m377a(this);
            }
        }
    }

    /* renamed from: c */
    void m392c(int i) {
        C0193k.m436a().m442a(this.f384c);
        if (this.f387g != null) {
            for (int size = this.f387g.size() - 1; size >= 0; size--) {
                ((C0174a) this.f387g.get(size)).m378a(this, i);
            }
        }
        if (VERSION.SDK_INT < 11) {
            this.f383b.setVisibility(8);
        }
        i = this.f383b.getParent();
        if (i instanceof ViewGroup) {
            ((ViewGroup) i).removeView(this.f383b);
        }
    }

    /* renamed from: e */
    boolean m394e() {
        return this.f388h.isEnabled() ^ 1;
    }
}
