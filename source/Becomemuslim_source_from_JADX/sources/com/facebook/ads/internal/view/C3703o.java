package com.facebook.ads.internal.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkActivity.BackButtonInterceptor;
import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.adapters.p086a.C1321k;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1508k;
import com.facebook.ads.internal.p105q.p106a.C1520t;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p111r.C1545a;
import com.facebook.ads.internal.p111r.C1545a.C1544a;
import com.facebook.ads.internal.view.C1566a.C1551a;
import com.facebook.ads.internal.view.C3686f.C1618a;
import com.facebook.ads.internal.view.p113b.C1577d;
import com.facebook.ads.internal.view.p119e.C1609a;
import com.facebook.ads.internal.view.p119e.C1613b;
import com.facebook.ads.internal.view.p119e.C1613b.C1612a;
import com.facebook.ads.internal.view.p120f.C3640a;
import com.facebook.ads.internal.view.p120f.C4584b;
import com.facebook.ads.internal.view.p120f.p121a.C1624a;
import com.facebook.ads.internal.view.p120f.p121a.C1625b;
import com.facebook.ads.internal.view.p120f.p122b.C1627z;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3649c;
import com.facebook.ads.internal.view.p120f.p122b.C3650d;
import com.facebook.ads.internal.view.p120f.p122b.C3651e;
import com.facebook.ads.internal.view.p120f.p122b.C3658l;
import com.facebook.ads.internal.view.p120f.p122b.C3659m;
import com.facebook.ads.internal.view.p120f.p122b.C3660n;
import com.facebook.ads.internal.view.p120f.p122b.C3661o;
import com.facebook.ads.internal.view.p120f.p123c.C3675d;
import com.facebook.ads.internal.view.p120f.p123c.C3675d.C1640a;
import com.facebook.ads.internal.view.p120f.p123c.C3676f;
import com.facebook.ads.internal.view.p120f.p123c.C3680j;
import com.facebook.ads.internal.view.p120f.p123c.C3680j.C1645a;
import com.facebook.ads.internal.view.p120f.p123c.C3683o;
import com.facebook.ads.internal.view.p120f.p123c.C4607k;
import com.facebook.ads.internal.view.p120f.p123c.C4611l;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.internal.view.o */
public class C3703o extends RelativeLayout implements C1566a {
    /* renamed from: a */
    static final /* synthetic */ boolean f9934a = (C3703o.class.desiredAssertionStatus() ^ 1);
    /* renamed from: b */
    private static final int f9935b = ((int) (C1523w.f4503b * 12.0f));
    /* renamed from: c */
    private static final int f9936c = ((int) (C1523w.f4503b * 18.0f));
    /* renamed from: d */
    private static final int f9937d = ((int) (C1523w.f4503b * 16.0f));
    /* renamed from: e */
    private static final int f9938e = ((int) (C1523w.f4503b * 72.0f));
    /* renamed from: f */
    private static final int f9939f = ((int) (C1523w.f4503b * 56.0f));
    /* renamed from: g */
    private static final int f9940g = ((int) (C1523w.f4503b * 56.0f));
    /* renamed from: h */
    private static final int f9941h = ((int) (C1523w.f4503b * 28.0f));
    /* renamed from: i */
    private static final int f9942i = ((int) (C1523w.f4503b * 20.0f));
    /* renamed from: j */
    private static final LayoutParams f9943j = new LayoutParams(-1, -1);
    /* renamed from: A */
    private Context f9944A;
    /* renamed from: B */
    private C3640a f9945B;
    /* renamed from: C */
    private C1551a f9946C;
    /* renamed from: D */
    private C1609a f9947D;
    /* renamed from: E */
    private C3675d f9948E;
    /* renamed from: F */
    private C4611l f9949F;
    /* renamed from: G */
    private C3680j f9950G;
    /* renamed from: H */
    private C3686f f9951H;
    /* renamed from: I */
    private C1613b f9952I;
    /* renamed from: J */
    private boolean f9953J = false;
    /* renamed from: k */
    private final BackButtonInterceptor f9954k = new C37001(this);
    /* renamed from: l */
    private final C3649c f9955l = new C46322(this);
    /* renamed from: m */
    private final C3651e f9956m = new C46333(this);
    /* renamed from: n */
    private final C3659m f9957n = new C46344(this);
    /* renamed from: o */
    private final C3661o f9958o = new C46355(this);
    /* renamed from: p */
    private final C1321k f9959p;
    /* renamed from: q */
    private final C1412c f9960q;
    /* renamed from: r */
    private final C1545a f9961r;
    /* renamed from: s */
    private final C1544a f9962s;
    /* renamed from: t */
    private final C1520t f9963t = new C1520t();
    /* renamed from: u */
    private final C3683o f9964u;
    /* renamed from: v */
    private final C4584b f9965v;
    /* renamed from: w */
    private final RelativeLayout f9966w;
    /* renamed from: x */
    private final C3676f f9967x;
    /* renamed from: y */
    private final C1312d f9968y;
    /* renamed from: z */
    private final AtomicBoolean f9969z = new AtomicBoolean(false);

    /* renamed from: com.facebook.ads.internal.view.o$7 */
    class C16717 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C3703o f4968a;

        C16717(C3703o c3703o) {
            this.f4968a = c3703o;
        }

        public void onClick(View view) {
            if (this.f4968a.f9950G == null) {
                return;
            }
            if (!this.f4968a.f9950G.m12018a()) {
                return;
            }
            if (this.f4968a.f9950G.getSkipSeconds() != 0 && this.f4968a.f9945B != null) {
                this.f4968a.f9945B.m11920e();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.o$1 */
    class C37001 implements BackButtonInterceptor {
        /* renamed from: a */
        final /* synthetic */ C3703o f9931a;

        C37001(C3703o c3703o) {
            this.f9931a = c3703o;
        }

        public boolean interceptBackButton() {
            return this.f9931a.f9953J ^ 1;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.o$6 */
    class C37016 extends C1544a {
        /* renamed from: a */
        final /* synthetic */ C3703o f9932a;

        C37016(C3703o c3703o) {
            this.f9932a = c3703o;
        }

        /* renamed from: a */
        public void mo925a() {
            if (!this.f9932a.f9963t.m5332b()) {
                this.f9932a.f9963t.m5330a();
                Map hashMap = new HashMap();
                if (!TextUtils.isEmpty(this.f9932a.f9959p.m4565g())) {
                    this.f9932a.f9961r.m5433a(hashMap);
                    hashMap.put("touch", C1508k.m5306a(this.f9932a.f9963t.m5335e()));
                    this.f9932a.f9960q.mo945a(this.f9932a.f9959p.m4565g(), hashMap);
                }
                if (this.f9932a.f9946C != null) {
                    this.f9932a.f9946C.mo854a(C1627z.REWARDED_VIDEO_IMPRESSION.m5610a());
                }
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.o$8 */
    class C37028 implements C1618a {
        /* renamed from: a */
        final /* synthetic */ C3703o f9933a;

        C37028(C3703o c3703o) {
            this.f9933a = c3703o;
        }

        /* renamed from: a */
        public void mo1062a() {
            if (!this.f9933a.f9953J && this.f9933a.f9945B != null) {
                this.f9933a.f9953J = true;
                this.f9933a.f9945B.m11920e();
            } else if (this.f9933a.f9953J && this.f9933a.f9946C != null) {
                this.f9933a.f9946C.mo854a(C1627z.REWARDED_VIDEO_END_ACTIVITY.m5610a());
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.o$2 */
    class C46322 extends C3649c {
        /* renamed from: a */
        final /* synthetic */ C3703o f12629a;

        C46322(C3703o c3703o) {
            this.f12629a = c3703o;
        }

        /* renamed from: a */
        public void m15974a(C3648b c3648b) {
            if (this.f12629a.f9946C != null) {
                this.f12629a.f9952I.m5605d();
                this.f12629a.m12142c();
                this.f12629a.f9946C.mo855a(C1627z.REWARDED_VIDEO_COMPLETE.m5610a(), c3648b);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.o$3 */
    class C46333 extends C3651e {
        /* renamed from: a */
        final /* synthetic */ C3703o f12630a;

        C46333(C3703o c3703o) {
            this.f12630a = c3703o;
        }

        /* renamed from: a */
        public void m15976a(C3650d c3650d) {
            if (this.f12630a.f9946C != null) {
                this.f12630a.f9946C.mo854a(C1627z.REWARDED_VIDEO_ERROR.m5610a());
            }
            this.f12630a.m12156a();
        }
    }

    /* renamed from: com.facebook.ads.internal.view.o$4 */
    class C46344 extends C3659m {
        /* renamed from: a */
        final /* synthetic */ C3703o f12631a;

        C46344(C3703o c3703o) {
            this.f12631a = c3703o;
        }

        /* renamed from: a */
        public void m15978a(C3658l c3658l) {
            if (this.f12631a.f9945B != null) {
                this.f12631a.f9945B.m11914a(C1624a.USER_STARTED);
                this.f12631a.f9961r.m5431a();
                this.f12631a.f9969z.set(this.f12631a.f9945B.m11925j());
                this.f12631a.m12148f();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.o$5 */
    class C46355 extends C3661o {
        /* renamed from: a */
        final /* synthetic */ C3703o f12632a;

        C46355(C3703o c3703o) {
            this.f12632a = c3703o;
        }

        /* renamed from: a */
        public void m15980a(C3660n c3660n) {
            if (this.f12632a.f9945B == null) {
                return;
            }
            if (this.f12632a.f9948E != null) {
                if (this.f12632a.f9945B.getDuration() - this.f12632a.f9945B.getCurrentPositionInMillis() <= 3000 && this.f12632a.f9948E.m11992a()) {
                    this.f12632a.f9948E.m11993b();
                }
            }
        }
    }

    public C3703o(Context context, C1412c c1412c, C3640a c3640a, C1551a c1551a, C1321k c1321k) {
        super(context);
        this.f9944A = context;
        this.f9946C = c1551a;
        this.f9945B = c3640a;
        this.f9960q = c1412c;
        this.f9959p = c1321k;
        this.f9968y = this.f9959p.m4562d().m4463a();
        this.f9966w = new RelativeLayout(context);
        this.f9964u = new C3683o(this.f9944A);
        this.f9967x = new C3676f(this.f9944A);
        new C1577d(this.f9966w, f9942i).m5504a().m5507a(C1405a.m4824e(this.f9944A)).m5508a(this.f9959p.m4563e().m4491g());
        this.f9962s = new C37016(this);
        this.f9961r = new C1545a(this, 1, this.f9962s);
        this.f9961r.m5432a(250);
        this.f9965v = new C4584b(this.f9944A, this.f9960q, this.f9945B, this.f9959p.m4565g());
        this.f9952I = new C1613b(this.f9944A, this.f9960q, this.f9959p, this.f9946C, this.f9961r, this.f9963t);
        if (!f9934a) {
            if (this.f9945B == null) {
                throw new AssertionError();
            }
        }
        this.f9945B.setVideoProgressReportIntervalMs(c1321k.m4566h());
        C1523w.m5342a(this.f9945B, -16777216);
        this.f9945B.getEventBus().m4804a(this.f9955l, this.f9956m, this.f9957n, this.f9958o);
    }

    /* renamed from: b */
    private void m12140b() {
        if (this.f9945B != null) {
            C3640a c3640a;
            C1625b c1625b;
            this.f9945B.m11919d();
            this.f9945B.m11915a(new C4607k(this.f9944A));
            this.f9945B.m11915a(this.f9967x);
            this.f9945B.m11915a(this.f9964u);
            this.f9949F = new C4611l(this.f9944A, true);
            C1625b c3675d = new C3675d(this.f9949F, C1640a.FADE_OUT_ON_PLAY, true);
            this.f9945B.m11915a(this.f9949F);
            this.f9945B.m11915a(c3675d);
            this.f9947D = new C1609a(this.f9944A, f9938e, this.f9968y, this.f9960q, this.f9946C, this.f9952I.m5603b() == C1612a.INFO, this.f9952I.m5603b() == C1612a.INFO, this.f9961r, this.f9963t);
            this.f9947D.setInfo(this.f9959p);
            this.f9948E = new C3675d(this.f9947D, C1640a.FADE_OUT_ON_PLAY, true);
            this.f9945B.m11915a(this.f9948E);
            if (!this.f9952I.m5602a() || this.f9959p.m4563e().m4487c() <= 0) {
                if (!this.f9952I.m5602a()) {
                    this.f9951H = new C3686f(this.f9944A);
                    this.f9951H.m12089a(this.f9959p.m4556a(), this.f9959p.m4565g(), this.f9959p.m4563e().m4487c());
                    if (this.f9959p.m4563e().m4487c() <= 0) {
                        this.f9951H.m12093b();
                    }
                    if (this.f9952I.m5603b() != C1612a.INFO) {
                        this.f9951H.m12095c();
                    }
                    this.f9951H.setToolbarListener(new C37028(this));
                    c3640a = this.f9945B;
                    c1625b = this.f9951H;
                }
            }
            this.f9950G = new C3680j(this.f9944A, this.f9959p.m4563e().m4487c(), -12286980);
            this.f9950G.setButtonMode(C1645a.SKIP_BUTTON_MODE);
            this.f9950G.setOnClickListener(new C16717(this));
            c3640a = this.f9945B;
            c1625b = this.f9950G;
            c3640a.m11915a(c1625b);
        }
    }

    /* renamed from: c */
    private void m12142c() {
        ViewGroup.LayoutParams layoutParams;
        this.f9953J = true;
        m12146e();
        m12143d();
        if (this.f9945B != null) {
            this.f9945B.m11919d();
            this.f9945B.setVisibility(4);
        }
        if (this.f9951H != null) {
            this.f9951H.m12091a(true);
            this.f9951H.m12095c();
        }
        C1523w.m5345a(this.f9945B, this.f9950G, this.f9967x, this.f9964u);
        Pair c = this.f9952I.m5604c();
        switch ((C1612a) c.first) {
            case MARKUP:
                C1523w.m5345a(this.f9947D);
                this.f9966w.addView((View) c.second, f9943j);
                return;
            case SCREENSHOTS:
                if (this.f9947D != null) {
                    this.f9947D.setVisibility(0);
                    this.f9947D.m5589a();
                }
                layoutParams = new LayoutParams(-1, -1);
                layoutParams.setMargins(0, f9940g, 0, 0);
                layoutParams.addRule(2, this.f9947D.getId());
                break;
            case INFO:
                C1523w.m5345a(this.f9947D);
                layoutParams = new LayoutParams(-1, -2);
                layoutParams.addRule(15);
                layoutParams.setMargins(f9937d, f9937d, f9937d, f9937d);
                break;
            default:
                return;
        }
        this.f9966w.addView((View) c.second, layoutParams);
        this.f9963t.m5330a();
    }

    /* renamed from: d */
    private void m12143d() {
        if (VERSION.SDK_INT > 19) {
            Transition autoTransition = new AutoTransition();
            autoTransition.setDuration(200);
            autoTransition.setInterpolator(new AccelerateDecelerateInterpolator());
            TransitionManager.beginDelayedTransition(this.f9966w, autoTransition);
        }
    }

    /* renamed from: e */
    private void m12146e() {
        if (this.f9944A != null) {
            View frameLayout = new FrameLayout(this.f9944A);
            frameLayout.setLayoutParams(f9943j);
            C1523w.m5342a(frameLayout, -1509949440);
            this.f9966w.addView(frameLayout, 0);
        }
    }

    /* renamed from: f */
    private void m12148f() {
        this.f9967x.setVisibility(this.f9969z.get() ? 0 : 8);
    }

    private void setUpContentLayoutForVideo(int i) {
        ViewGroup.LayoutParams layoutParams;
        this.f9966w.removeAllViews();
        this.f9966w.addView(this.f9945B, f9943j);
        if (this.f9947D != null) {
            C1523w.m5341a(this.f9947D);
            this.f9947D.m5590a(i);
            layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.f9947D.setPadding(f9937d, f9937d, f9937d, f9937d);
            this.f9966w.addView(this.f9947D, layoutParams);
        }
        if (this.f9950G != null) {
            layoutParams = new LayoutParams(f9939f, f9939f);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            this.f9950G.setPadding(f9937d, f9937d, f9937d, f9937d);
            this.f9966w.addView(this.f9950G, layoutParams);
        }
        layoutParams = new LayoutParams(f9941h, f9941h);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.setMargins(f9935b, f9935b + f9940g, f9935b, f9936c);
        this.f9966w.addView(this.f9967x, layoutParams);
        m12148f();
        layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f9966w.addView(this.f9964u, layoutParams);
    }

    /* renamed from: a */
    public void m12156a() {
        if (this.f9945B != null) {
            this.f9945B.m11921f();
            this.f9945B.m11926k();
        }
        if (this.f9961r != null) {
            this.f9961r.m5436c();
        }
    }

    /* renamed from: a */
    public void mo1010a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        if (this.f9945B == null) {
            return;
        }
        if (this.f9946C != null) {
            m12140b();
            audienceNetworkActivity.addBackButtonInterceptor(this.f9954k);
            this.f9945B.setVideoURI(!TextUtils.isEmpty(this.f9959p.m4563e().m4486b()) ? this.f9959p.m4563e().m4486b() : this.f9959p.m4563e().m4484a());
            setUpContentLayoutForVideo(audienceNetworkActivity.getResources().getConfiguration().orientation);
            addView(this.f9966w, f9943j);
            if (this.f9951H != null) {
                C1523w.m5341a(this.f9951H);
                this.f9951H.m12088a(this.f9968y, true);
                addView(this.f9951H, new LayoutParams(-1, f9940g));
            }
            setLayoutParams(f9943j);
            this.f9946C.mo853a((View) this);
        }
    }

    /* renamed from: a */
    public void mo1011a(Bundle bundle) {
    }

    public int getCurrentPosition() {
        return this.f9945B != null ? this.f9945B.getCurrentPositionInMillis() : 0;
    }

    /* renamed from: i */
    public void mo1012i() {
        if (this.f9945B != null) {
            this.f9945B.m11917a(false);
        }
    }

    /* renamed from: j */
    public void mo1013j() {
        if (this.f9945B == null) {
            return;
        }
        if (this.f9946C != null) {
            if (this.f9945B.m11927l() && !this.f9945B.m11928m()) {
                this.f9945B.m11914a(C1624a.USER_STARTED);
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.f9947D != null) {
            this.f9947D.m5590a(configuration.orientation);
        }
    }

    public void onDestroy() {
        m12156a();
        if (this.f9945B != null) {
            this.f9945B.getEventBus().m4806b(this.f9955l, this.f9956m, this.f9957n, this.f9958o);
        }
        if (!TextUtils.isEmpty(this.f9959p.m4565g())) {
            Map hashMap = new HashMap();
            this.f9961r.m5433a(hashMap);
            hashMap.put("touch", C1508k.m5306a(this.f9963t.m5335e()));
            this.f9960q.mo954i(this.f9959p.m4565g(), hashMap);
        }
        if (this.f9951H != null) {
            this.f9951H.setToolbarListener(null);
        }
        this.f9965v.mo2876a();
        this.f9945B = null;
        this.f9952I.m5606e();
        this.f9950G = null;
        this.f9947D = null;
        this.f9948E = null;
        this.f9946C = null;
        this.f9944A = null;
        this.f9964u.m12034a();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f9963t.m5331a(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    void setEndCardController(C1613b c1613b) {
        this.f9952I = c1613b;
    }

    public void setListener(C1551a c1551a) {
    }
}
