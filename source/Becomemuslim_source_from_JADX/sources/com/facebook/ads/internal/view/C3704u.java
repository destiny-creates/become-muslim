package com.facebook.ads.internal.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.C1566a.C1551a;
import com.facebook.ads.internal.view.p114c.C1585b;
import com.facebook.ads.internal.view.p120f.C3640a;
import com.facebook.ads.internal.view.p120f.C4584b;
import com.facebook.ads.internal.view.p120f.p121a.C1624a;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3649c;
import com.facebook.ads.internal.view.p120f.p122b.C3650d;
import com.facebook.ads.internal.view.p120f.p122b.C3651e;
import com.facebook.ads.internal.view.p120f.p122b.C3652f;
import com.facebook.ads.internal.view.p120f.p122b.C3653g;
import com.facebook.ads.internal.view.p120f.p122b.C3654h;
import com.facebook.ads.internal.view.p120f.p122b.C3655i;
import com.facebook.ads.internal.view.p120f.p122b.C3656j;
import com.facebook.ads.internal.view.p120f.p122b.C3657k;
import com.facebook.ads.internal.view.p120f.p122b.C3662p;
import com.facebook.ads.internal.view.p120f.p123c.C4589b;

/* renamed from: com.facebook.ads.internal.view.u */
public class C3704u implements C1566a {
    /* renamed from: a */
    private final C3657k f9970a = new C46371(this);
    /* renamed from: b */
    private final C3655i f9971b = new C46382(this);
    /* renamed from: c */
    private final C3649c f9972c = new C46393(this);
    /* renamed from: d */
    private final C3651e f9973d = new C46404(this);
    /* renamed from: e */
    private final AudienceNetworkActivity f9974e;
    /* renamed from: f */
    private final C1412c f9975f;
    /* renamed from: g */
    private final C3640a f9976g;
    /* renamed from: h */
    private final C1551a f9977h;
    /* renamed from: i */
    private C4584b f9978i;
    /* renamed from: j */
    private int f9979j;

    /* renamed from: com.facebook.ads.internal.view.u$6 */
    class C16786 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C3704u f4979a;

        C16786(C3704u c3704u) {
            this.f4979a = c3704u;
        }

        public void onClick(View view) {
            this.f4979a.f9977h.mo854a("performCtaClick");
        }
    }

    /* renamed from: com.facebook.ads.internal.view.u$1 */
    class C46371 extends C3657k {
        /* renamed from: a */
        final /* synthetic */ C3704u f12633a;

        C46371(C3704u c3704u) {
            this.f12633a = c3704u;
        }

        /* renamed from: a */
        public void m15982a(C3656j c3656j) {
            this.f12633a.f9977h.mo855a("videoInterstitalEvent", c3656j);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.u$2 */
    class C46382 extends C3655i {
        /* renamed from: a */
        final /* synthetic */ C3704u f12634a;

        C46382(C3704u c3704u) {
            this.f12634a = c3704u;
        }

        /* renamed from: a */
        public void m15984a(C3654h c3654h) {
            this.f12634a.f9977h.mo855a("videoInterstitalEvent", c3654h);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.u$3 */
    class C46393 extends C3649c {
        /* renamed from: a */
        final /* synthetic */ C3704u f12635a;

        C46393(C3704u c3704u) {
            this.f12635a = c3704u;
        }

        /* renamed from: a */
        public void m15986a(C3648b c3648b) {
            this.f12635a.f9977h.mo855a("videoInterstitalEvent", c3648b);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.u$4 */
    class C46404 extends C3651e {
        /* renamed from: a */
        final /* synthetic */ C3704u f12636a;

        C46404(C3704u c3704u) {
            this.f12636a = c3704u;
        }

        /* renamed from: a */
        public void m15988a(C3650d c3650d) {
            this.f12636a.f9974e.finish();
        }
    }

    public C3704u(final AudienceNetworkActivity audienceNetworkActivity, C1412c c1412c, C1551a c1551a) {
        this.f9974e = audienceNetworkActivity;
        this.f9975f = c1412c;
        this.f9976g = new C3640a(audienceNetworkActivity);
        this.f9976g.m11915a(new C4589b(audienceNetworkActivity));
        this.f9976g.getEventBus().m4804a(this.f9970a, this.f9971b, this.f9972c, this.f9973d);
        this.f9977h = c1551a;
        this.f9976g.setIsFullScreen(true);
        this.f9976g.setVolume(1.0f);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        this.f9976g.setLayoutParams(layoutParams);
        c1551a.mo853a(this.f9976g);
        View c1608d = new C1608d(audienceNetworkActivity);
        c1608d.setOnClickListener(new OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ C3704u f4978b;

            public void onClick(View view) {
                audienceNetworkActivity.finish();
            }
        });
        c1551a.mo853a(c1608d);
    }

    /* renamed from: a */
    public void m12163a(int i) {
        this.f9976g.setVideoProgressReportIntervalMs(i);
    }

    /* renamed from: a */
    public void mo1010a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        String stringExtra = intent.getStringExtra("useNativeCtaButton");
        if (!(stringExtra == null || stringExtra.isEmpty())) {
            View c1585b = new C1585b(audienceNetworkActivity, stringExtra);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int i = (int) (C1523w.f4503b * 16.0f);
            layoutParams.setMargins(i, i, i, i);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            c1585b.setLayoutParams(layoutParams);
            c1585b.setOnClickListener(new C16786(this));
            this.f9977h.mo853a(c1585b);
        }
        this.f9979j = intent.getIntExtra(AudienceNetworkActivity.VIDEO_SEEK_TIME, 0);
        this.f9978i = new C4584b((Context) audienceNetworkActivity, this.f9975f, this.f9976g, intent.getStringExtra(AudienceNetworkActivity.CLIENT_TOKEN), intent.getBundleExtra(AudienceNetworkActivity.VIDEO_LOGGER));
        this.f9976g.setVideoMPD(intent.getStringExtra(AudienceNetworkActivity.VIDEO_MPD));
        this.f9976g.setVideoURI(intent.getStringExtra(AudienceNetworkActivity.VIDEO_URL));
        if (this.f9979j > 0) {
            this.f9976g.m11912a(this.f9979j);
        }
        if (intent.getBooleanExtra(AudienceNetworkActivity.AUTOPLAY, false)) {
            this.f9976g.m11914a(C1624a.USER_STARTED);
        }
    }

    /* renamed from: a */
    public void mo1011a(Bundle bundle) {
    }

    /* renamed from: a */
    public void m12166a(View view) {
        this.f9976g.setControlsAnchorView(view);
    }

    /* renamed from: i */
    public void mo1012i() {
        this.f9977h.mo855a("videoInterstitalEvent", new C3652f());
        this.f9976g.m11917a(false);
    }

    /* renamed from: j */
    public void mo1013j() {
        this.f9977h.mo855a("videoInterstitalEvent", new C3653g());
        this.f9976g.m11914a(C1624a.USER_STARTED);
    }

    public void onDestroy() {
        this.f9977h.mo855a("videoInterstitalEvent", new C3662p(this.f9979j, this.f9976g.getCurrentPositionInMillis()));
        this.f9978i.m12054b(this.f9976g.getCurrentPositionInMillis());
        this.f9976g.m11921f();
        this.f9976g.m11926k();
    }

    public void setListener(C1551a c1551a) {
    }
}
