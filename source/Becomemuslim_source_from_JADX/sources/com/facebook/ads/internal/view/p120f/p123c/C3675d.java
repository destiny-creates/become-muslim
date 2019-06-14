package com.facebook.ads.internal.view.p120f.p123c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Handler;
import android.view.View;
import com.facebook.ads.internal.view.p120f.C3640a;
import com.facebook.ads.internal.view.p120f.p121a.C1625b;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3649c;
import com.facebook.ads.internal.view.p120f.p122b.C3654h;
import com.facebook.ads.internal.view.p120f.p122b.C3655i;
import com.facebook.ads.internal.view.p120f.p122b.C3656j;
import com.facebook.ads.internal.view.p120f.p122b.C3657k;
import com.facebook.ads.internal.view.p120f.p122b.C3666t;
import com.facebook.ads.internal.view.p120f.p122b.C3667u;

@TargetApi(12)
/* renamed from: com.facebook.ads.internal.view.f.c.d */
public class C3675d implements C1625b {
    /* renamed from: a */
    private final C3655i f9791a;
    /* renamed from: b */
    private final C3657k f9792b;
    /* renamed from: c */
    private final C3649c f9793c;
    /* renamed from: d */
    private final C3667u f9794d;
    /* renamed from: e */
    private final Handler f9795e;
    /* renamed from: f */
    private final boolean f9796f;
    /* renamed from: g */
    private final boolean f9797g;
    /* renamed from: h */
    private View f9798h;
    /* renamed from: i */
    private C1640a f9799i;
    /* renamed from: j */
    private C3640a f9800j;
    /* renamed from: k */
    private boolean f9801k;

    /* renamed from: com.facebook.ads.internal.view.f.c.d$5 */
    class C16395 extends AnimatorListenerAdapter {
        /* renamed from: a */
        final /* synthetic */ C3675d f4919a;

        C16395(C3675d c3675d) {
            this.f4919a = c3675d;
        }

        public void onAnimationEnd(Animator animator) {
            this.f4919a.f9798h.setVisibility(8);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.d$a */
    public enum C1640a {
        VISIBLE,
        INVSIBLE,
        FADE_OUT_ON_PLAY
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.d$1 */
    class C45911 extends C3655i {
        /* renamed from: a */
        final /* synthetic */ C3675d f12498a;

        C45911(C3675d c3675d) {
            this.f12498a = c3675d;
        }

        /* renamed from: a */
        public void m15835a(C3654h c3654h) {
            this.f12498a.m11977a(1, 0);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.d$2 */
    class C45922 extends C3657k {
        /* renamed from: a */
        final /* synthetic */ C3675d f12499a;

        C45922(C3675d c3675d) {
            this.f12499a = c3675d;
        }

        /* renamed from: a */
        public void m15837a(C3656j c3656j) {
            if (this.f12499a.f9801k) {
                if (this.f12499a.f9799i != C1640a.FADE_OUT_ON_PLAY) {
                    if (!this.f12499a.f9796f) {
                        this.f12499a.m11977a(0, 8);
                        return;
                    }
                }
                this.f12499a.f9799i = null;
                this.f12499a.m11983c();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.d$3 */
    class C45933 extends C3649c {
        /* renamed from: a */
        final /* synthetic */ C3675d f12500a;

        C45933(C3675d c3675d) {
            this.f12500a = c3675d;
        }

        /* renamed from: a */
        public void m15839a(C3648b c3648b) {
            if (this.f12500a.f9799i != C1640a.INVSIBLE) {
                this.f12500a.f9798h.setAlpha(1.0f);
                this.f12500a.f9798h.setVisibility(0);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.d$4 */
    class C45944 extends C3667u {
        /* renamed from: a */
        final /* synthetic */ C3675d f12501a;

        /* renamed from: com.facebook.ads.internal.view.f.c.d$4$1 */
        class C16381 extends AnimatorListenerAdapter {
            /* renamed from: a */
            final /* synthetic */ C45944 f4918a;

            /* renamed from: com.facebook.ads.internal.view.f.c.d$4$1$1 */
            class C16371 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ C16381 f4917a;

                C16371(C16381 c16381) {
                    this.f4917a = c16381;
                }

                public void run() {
                    if (!this.f4917a.f4918a.f12501a.f9797g && this.f4917a.f4918a.f12501a.f9801k) {
                        this.f4917a.f4918a.f12501a.m11983c();
                    }
                }
            }

            C16381(C45944 c45944) {
                this.f4918a = c45944;
            }

            public void onAnimationEnd(Animator animator) {
                this.f4918a.f12501a.f9795e.postDelayed(new C16371(this), 2000);
            }
        }

        C45944(C3675d c3675d) {
            this.f12501a = c3675d;
        }

        /* renamed from: a */
        public void m15841a(C3666t c3666t) {
            if (this.f12501a.f9800j != null && c3666t.m11968a().getAction() == 0) {
                this.f12501a.f9795e.removeCallbacksAndMessages(null);
                this.f12501a.m11978a(new C16381(this));
            }
        }
    }

    public C3675d(View view, C1640a c1640a) {
        this(view, c1640a, false);
    }

    public C3675d(View view, C1640a c1640a, boolean z) {
        this(view, c1640a, z, false);
    }

    public C3675d(View view, C1640a c1640a, boolean z, boolean z2) {
        this.f9791a = new C45911(this);
        this.f9792b = new C45922(this);
        this.f9793c = new C45933(this);
        this.f9794d = new C45944(this);
        this.f9801k = true;
        this.f9795e = new Handler();
        this.f9796f = z;
        this.f9797g = z2;
        m11990a(view, c1640a);
    }

    /* renamed from: a */
    private void m11977a(int i, int i2) {
        this.f9795e.removeCallbacksAndMessages(null);
        this.f9798h.clearAnimation();
        this.f9798h.setAlpha((float) i);
        this.f9798h.setVisibility(i2);
    }

    /* renamed from: a */
    private void m11978a(AnimatorListenerAdapter animatorListenerAdapter) {
        this.f9798h.setVisibility(0);
        this.f9798h.animate().alpha(1.0f).setDuration(500).setListener(animatorListenerAdapter);
    }

    /* renamed from: c */
    private void m11983c() {
        this.f9798h.animate().alpha(0.0f).setDuration(500).setListener(new C16395(this));
    }

    /* renamed from: a */
    public void m11990a(View view, C1640a c1640a) {
        int i;
        this.f9799i = c1640a;
        this.f9798h = view;
        this.f9798h.clearAnimation();
        if (c1640a == C1640a.INVSIBLE) {
            this.f9798h.setAlpha(0.0f);
            view = this.f9798h;
            i = 8;
        } else {
            this.f9798h.setAlpha(1.0f);
            view = this.f9798h;
            i = 0;
        }
        view.setVisibility(i);
    }

    /* renamed from: a */
    public void mo1029a(C3640a c3640a) {
        this.f9800j = c3640a;
        c3640a.getEventBus().m4804a(this.f9791a, this.f9792b, this.f9794d, this.f9793c);
    }

    /* renamed from: a */
    public boolean m11992a() {
        return this.f9801k;
    }

    /* renamed from: b */
    public void m11993b() {
        this.f9801k = false;
        m11978a(null);
    }

    /* renamed from: b */
    public void mo1030b(C3640a c3640a) {
        m11977a(1, 0);
        c3640a.getEventBus().m4806b(this.f9793c, this.f9794d, this.f9792b, this.f9791a);
        this.f9800j = null;
    }
}
