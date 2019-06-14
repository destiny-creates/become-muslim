package com.facebook.ads.internal.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkActivity.BackButtonInterceptor;
import com.facebook.ads.internal.adapters.p086a.C1315g;
import com.facebook.ads.internal.adapters.p086a.C1316h;
import com.facebook.ads.internal.p089d.C1364b;
import com.facebook.ads.internal.p095j.C1397a;
import com.facebook.ads.internal.p095j.C1397a.C1395a;
import com.facebook.ads.internal.p095j.C1398b;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1508k;
import com.facebook.ads.internal.p105q.p106a.C1520t;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p111r.C1545a;
import com.facebook.ads.internal.p111r.C1545a.C1544a;
import com.facebook.ads.internal.view.component.p116a.C1594c;
import com.facebook.ads.internal.view.component.p116a.C1597d.C1596a;
import com.facebook.ads.internal.view.p120f.C3640a;
import com.facebook.ads.internal.view.p120f.C3684c;
import com.facebook.ads.internal.view.p120f.C4584b;
import com.facebook.ads.internal.view.p120f.p121a.C1624a;
import com.facebook.ads.internal.view.p120f.p121a.C1625b;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3649c;
import com.facebook.ads.internal.view.p120f.p122b.C3650d;
import com.facebook.ads.internal.view.p120f.p122b.C3651e;
import com.facebook.ads.internal.view.p120f.p122b.C3654h;
import com.facebook.ads.internal.view.p120f.p122b.C3655i;
import com.facebook.ads.internal.view.p120f.p122b.C3656j;
import com.facebook.ads.internal.view.p120f.p122b.C3657k;
import com.facebook.ads.internal.view.p120f.p122b.C3658l;
import com.facebook.ads.internal.view.p120f.p122b.C3659m;
import com.facebook.ads.internal.view.p120f.p123c.C3675d;
import com.facebook.ads.internal.view.p120f.p123c.C3675d.C1640a;
import com.facebook.ads.internal.view.p120f.p123c.C3676f;
import com.facebook.ads.internal.view.p120f.p123c.C3683o;
import com.facebook.ads.internal.view.p120f.p123c.C4597g;
import com.facebook.ads.internal.view.p120f.p123c.C4607k;
import com.facebook.ads.internal.view.p120f.p123c.C4611l;
import com.facebook.ads.internal.view.p120f.p124d.C1658d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.internal.view.h */
public class C4625h extends C3692i {
    /* renamed from: e */
    private final BackButtonInterceptor f12580e = new C36891(this);
    /* renamed from: f */
    private final C3651e f12581f = new C46202(this);
    /* renamed from: g */
    private final C3657k f12582g = new C46213(this);
    /* renamed from: h */
    private final C3655i f12583h = new C46224(this);
    /* renamed from: i */
    private final C3649c f12584i = new C46235(this);
    /* renamed from: j */
    private final C3659m f12585j = new C46246(this);
    /* renamed from: k */
    private final C3640a f12586k = new C3640a(getContext());
    /* renamed from: l */
    private final C3683o f12587l;
    /* renamed from: m */
    private final C3676f f12588m;
    /* renamed from: n */
    private final C1315g f12589n;
    /* renamed from: o */
    private final C1316h f12590o;
    /* renamed from: p */
    private final C1545a f12591p;
    /* renamed from: q */
    private final C1544a f12592q;
    /* renamed from: r */
    private final C1520t f12593r = new C1520t();
    /* renamed from: s */
    private final C1364b f12594s;
    /* renamed from: t */
    private final AtomicBoolean f12595t = new AtomicBoolean(false);
    /* renamed from: u */
    private final AtomicBoolean f12596u = new AtomicBoolean(false);
    /* renamed from: v */
    private final C3684c f12597v;
    /* renamed from: w */
    private AudienceNetworkActivity f12598w;
    /* renamed from: x */
    private C1624a f12599x;
    /* renamed from: y */
    private long f12600y;
    /* renamed from: z */
    private boolean f12601z = false;

    /* renamed from: com.facebook.ads.internal.view.h$1 */
    class C36891 implements BackButtonInterceptor {
        /* renamed from: a */
        final /* synthetic */ C4625h f9895a;

        C36891(C4625h c4625h) {
            this.f9895a = c4625h;
        }

        public boolean interceptBackButton() {
            return this.f9895a.c.m12092a() ^ 1;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.h$7 */
    class C36907 extends C1544a {
        /* renamed from: a */
        final /* synthetic */ C4625h f9896a;

        C36907(C4625h c4625h) {
            this.f9896a = c4625h;
        }

        /* renamed from: a */
        public void mo925a() {
            if (!this.f9896a.f12593r.m5332b()) {
                this.f9896a.f12593r.m5330a();
                Map hashMap = new HashMap();
                if (!TextUtils.isEmpty(this.f9896a.f12589n.m4526c())) {
                    this.f9896a.f12591p.m5433a(hashMap);
                    hashMap.put("touch", C1508k.m5306a(this.f9896a.f12593r.m5335e()));
                    this.f9896a.b.mo945a(this.f9896a.f12589n.m4526c(), hashMap);
                    if (this.f9896a.getAudienceNetworkListener() != null) {
                        this.f9896a.getAudienceNetworkListener().mo854a("com.facebook.ads.interstitial.impression.logged");
                    }
                }
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.h$2 */
    class C46202 extends C3651e {
        /* renamed from: a */
        final /* synthetic */ C4625h f12575a;

        C46202(C4625h c4625h) {
            this.f12575a = c4625h;
        }

        /* renamed from: a */
        public void m15929a(C3650d c3650d) {
            if (this.f12575a.getAudienceNetworkListener() != null) {
                this.f12575a.getAudienceNetworkListener().mo855a("videoInterstitalEvent", c3650d);
            }
            if (!this.f12575a.f12601z) {
                this.f12575a.f12586k.m11921f();
                this.f12575a.f12586k.m11926k();
                this.f12575a.f12601z = true;
            }
            if (this.f12575a.f12598w != null) {
                this.f12575a.f12598w.finish();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.h$3 */
    class C46213 extends C3657k {
        /* renamed from: a */
        final /* synthetic */ C4625h f12576a;

        C46213(C4625h c4625h) {
            this.f12576a = c4625h;
        }

        /* renamed from: a */
        public void m15931a(C3656j c3656j) {
            if (this.f12576a.getAudienceNetworkListener() != null) {
                this.f12576a.getAudienceNetworkListener().mo855a("videoInterstitalEvent", c3656j);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.h$4 */
    class C46224 extends C3655i {
        /* renamed from: a */
        final /* synthetic */ C4625h f12577a;

        C46224(C4625h c4625h) {
            this.f12577a = c4625h;
        }

        /* renamed from: a */
        public void m15933a(C3654h c3654h) {
            if (this.f12577a.getAudienceNetworkListener() != null) {
                this.f12577a.getAudienceNetworkListener().mo855a("videoInterstitalEvent", c3654h);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.h$5 */
    class C46235 extends C3649c {
        /* renamed from: a */
        final /* synthetic */ C4625h f12578a;

        C46235(C4625h c4625h) {
            this.f12578a = c4625h;
        }

        /* renamed from: a */
        public void m15935a(C3648b c3648b) {
            this.f12578a.f12595t.set(true);
            if (this.f12578a.getAudienceNetworkListener() != null) {
                this.f12578a.getAudienceNetworkListener().mo855a("videoInterstitalEvent", c3648b);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.h$6 */
    class C46246 extends C3659m {
        /* renamed from: a */
        final /* synthetic */ C4625h f12579a;

        C46246(C4625h c4625h) {
            this.f12579a = c4625h;
        }

        /* renamed from: a */
        public void m15937a(C3658l c3658l) {
            if (!this.f12579a.f12601z) {
                this.f12579a.f12596u.set(this.f12579a.f12586k.m11925j());
                this.f12579a.m15939a();
            }
            if (this.f12579a.getAudienceNetworkListener() != null) {
                this.f12579a.getAudienceNetworkListener().mo855a("videoInterstitalEvent", c3658l);
            }
            this.f12579a.f12591p.m5431a();
        }
    }

    public C4625h(Context context, C1412c c1412c, C1315g c1315g, C1364b c1364b) {
        super(context, c1412c);
        this.f12586k.setVideoProgressReportIntervalMs(c1315g.m4531h());
        C1523w.m5341a(this.f12586k);
        C1523w.m5342a(this.f12586k, 0);
        this.f12589n = c1315g;
        this.f12590o = (C1316h) this.f12589n.m4527d().get(0);
        this.f12594s = c1364b;
        this.f12587l = new C3683o(getContext());
        this.f12588m = new C3676f(context);
        this.f12586k.getEventBus().m4804a(this.f12582g, this.f12583h, this.f12584i, this.f12581f, this.f12585j);
        setupPlugins(this.f12590o);
        this.f12592q = new C36907(this);
        this.f12591p = new C1545a(this, 1, this.f12592q);
        this.f12591p.m5432a(c1315g.m4529f());
        this.f12591p.m5434b(c1315g.m4530g());
        this.f12597v = new C4584b(getContext(), this.b, this.f12586k, this.f12589n.m4526c());
        this.f12586k.setVideoURI(m15938a(this.f12590o.m4535c().m4484a()));
    }

    /* renamed from: a */
    private String m15938a(String str) {
        CharSequence charSequence = "";
        if (!(this.f12594s == null || str == null)) {
            charSequence = this.f12594s.m4660b(str);
        }
        return TextUtils.isEmpty(charSequence) ? str : charSequence;
    }

    /* renamed from: a */
    private void m15939a() {
        this.f12588m.setVisibility(this.f12596u.get() ? 0 : 8);
    }

    private void setUpContent(int i) {
        View a = C1594c.m5543a(new C1596a(getContext(), this.b, getAudienceNetworkListener(), this.f12589n, this.f12586k, this.f12591p, this.f12593r).m5559a(a).m5563b(i).m5561a(this.f12587l).m5560a(this.f12588m).m5562a());
        m15939a();
        m12103a(a, a.mo1023a(), i);
    }

    private void setupPlugins(C1316h c1316h) {
        C1625b c4597g;
        this.f12586k.m11919d();
        this.f12586k.m11915a(this.f12587l);
        this.f12586k.m11915a(this.f12588m);
        if (!TextUtils.isEmpty(c1316h.m4535c().m4491g())) {
            c4597g = new C4597g(getContext());
            this.f12586k.m11915a(c4597g);
            c4597g.setImage(c1316h.m4535c().m4491g());
        }
        c4597g = new C4611l(getContext(), true);
        this.f12586k.m11915a(c4597g);
        this.f12586k.m11915a(new C3675d(c4597g, c1316h.m4535c().m4489e() ? C1640a.FADE_OUT_ON_PLAY : C1640a.VISIBLE, true));
        this.f12586k.m11915a(new C4607k(getContext()));
        this.f12586k.m11915a(this.c);
    }

    /* renamed from: a */
    public void mo1010a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        super.m12104a(audienceNetworkActivity, this.f12589n);
        this.f12598w = audienceNetworkActivity;
        setUpContent(audienceNetworkActivity.getResources().getConfiguration().orientation);
        this.f12598w.addBackButtonInterceptor(this.f12580e);
        C1316h c1316h = (C1316h) this.f12589n.m4527d().get(0);
        if (c1316h.m4535c().m4489e()) {
            this.f12586k.setVolume(c1316h.m4535c().m4490f() ? 1.0f : 0.0f);
            this.f12586k.m11914a(C1624a.AUTO_STARTED);
        }
        this.f12600y = System.currentTimeMillis();
    }

    /* renamed from: a */
    public void mo1011a(Bundle bundle) {
    }

    /* renamed from: i */
    public void mo1012i() {
        if (!this.f12601z && this.f12586k.getState() == C1658d.STARTED) {
            this.f12599x = this.f12586k.getVideoStartReason();
            this.f12586k.m11917a(false);
        }
    }

    /* renamed from: j */
    public void mo1013j() {
        if (!this.f12601z && this.f12599x != null) {
            this.f12586k.m11914a(this.f12599x);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        removeAllViews();
        C1523w.m5346b(this.f12586k);
        C1523w.m5346b(this.f12587l);
        C1523w.m5346b(this.f12588m);
        setUpContent(configuration.orientation);
        super.onConfigurationChanged(configuration);
    }

    public void onDestroy() {
        if (!this.f12601z) {
            if (!this.f12595t.get()) {
                this.f12586k.m11920e();
            }
            if (this.f12589n != null) {
                C1398b.m4797a(C1397a.m4792a(this.f12600y, C1395a.XOUT, this.f12589n.m4528e()));
                if (!TextUtils.isEmpty(this.f12589n.m4526c())) {
                    Map hashMap = new HashMap();
                    this.f12591p.m5433a(hashMap);
                    hashMap.put("touch", C1508k.m5306a(this.f12593r.m5335e()));
                    this.b.mo954i(this.f12589n.m4526c(), hashMap);
                }
            }
            this.f12586k.m11921f();
            this.f12586k.m11926k();
            this.f12601z = true;
        }
        this.f12591p.m5436c();
        this.f12598w = null;
        super.onDestroy();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f12593r.m5331a(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
