package com.facebook.ads.internal.view;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkActivity.BackButtonInterceptor;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p105q.p108c.C1532b;
import com.facebook.ads.internal.view.C1566a.C1551a;
import com.facebook.ads.internal.view.p112a.C1556a;
import com.facebook.ads.internal.view.p112a.C1556a.C1555a;
import com.facebook.ads.internal.view.p112a.C1557b;
import com.facebook.ads.internal.view.p112a.C1560c.C1559a;
import com.facebook.ads.internal.view.p112a.C3610f;
import com.facebook.ads.internal.view.p112a.C3610f.C1563a;

@TargetApi(19)
/* renamed from: com.facebook.ads.internal.view.b */
public class C3617b implements C1566a {
    /* renamed from: a */
    private static final String f9645a = "b";
    /* renamed from: b */
    private final AudienceNetworkActivity f9646b;
    /* renamed from: c */
    private final C1556a f9647c;
    /* renamed from: d */
    private final C3610f f9648d;
    /* renamed from: e */
    private final C1557b f9649e;
    /* renamed from: f */
    private final C1412c f9650f;
    /* renamed from: g */
    private final BackButtonInterceptor f9651g = new C36111(this);
    /* renamed from: h */
    private String f9652h;
    /* renamed from: i */
    private String f9653i;
    /* renamed from: j */
    private long f9654j;
    /* renamed from: k */
    private boolean f9655k = true;
    /* renamed from: l */
    private long f9656l = -1;
    /* renamed from: m */
    private boolean f9657m = true;

    /* renamed from: com.facebook.ads.internal.view.b$1 */
    class C36111 implements BackButtonInterceptor {
        /* renamed from: a */
        final /* synthetic */ C3617b f9630a;

        C36111(C3617b c3617b) {
            this.f9630a = c3617b;
        }

        public boolean interceptBackButton() {
            if (!this.f9630a.f9648d.canGoBack()) {
                return false;
            }
            this.f9630a.f9648d.goBack();
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.b$3 */
    class C36133 implements C1563a {
        /* renamed from: a */
        final /* synthetic */ C3617b f9633a;

        C36133(C3617b c3617b) {
            this.f9633a = c3617b;
        }

        /* renamed from: a */
        public void mo1001a(int i) {
            if (this.f9633a.f9655k) {
                this.f9633a.f9649e.setProgress(i);
            }
        }

        /* renamed from: a */
        public void mo1002a(String str) {
            this.f9633a.f9655k = true;
            this.f9633a.f9647c.setUrl(str);
        }

        /* renamed from: b */
        public void mo1003b(String str) {
            this.f9633a.f9647c.setTitle(str);
        }

        /* renamed from: c */
        public void mo1004c(String str) {
            this.f9633a.f9649e.setProgress(100);
            this.f9633a.f9655k = false;
        }
    }

    public C3617b(final AudienceNetworkActivity audienceNetworkActivity, C1412c c1412c, C1551a c1551a) {
        this.f9646b = audienceNetworkActivity;
        this.f9650f = c1412c;
        int i = (int) (C1523w.f4503b * 2.0f);
        this.f9647c = new C1556a(audienceNetworkActivity);
        this.f9647c.setId(View.generateViewId());
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        this.f9647c.setLayoutParams(layoutParams);
        this.f9647c.setListener(new C1555a(this) {
            /* renamed from: b */
            final /* synthetic */ C3617b f9632b;

            /* renamed from: a */
            public void mo1000a() {
                audienceNetworkActivity.finish();
            }
        });
        c1551a.mo853a(this.f9647c);
        this.f9648d = new C3610f(audienceNetworkActivity);
        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.f9647c.getId());
        layoutParams.addRule(12);
        this.f9648d.setLayoutParams(layoutParams);
        this.f9648d.setListener(new C36133(this));
        c1551a.mo853a(this.f9648d);
        this.f9649e = new C1557b(audienceNetworkActivity, null, 16842872);
        layoutParams = new RelativeLayout.LayoutParams(-1, i);
        layoutParams.addRule(3, this.f9647c.getId());
        this.f9649e.setLayoutParams(layoutParams);
        this.f9649e.setProgress(0);
        c1551a.mo853a(this.f9649e);
        audienceNetworkActivity.addBackButtonInterceptor(this.f9651g);
    }

    /* renamed from: a */
    public void mo1010a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        long longExtra;
        if (this.f9656l < 0) {
            this.f9656l = System.currentTimeMillis();
        }
        if (bundle == null) {
            this.f9652h = intent.getStringExtra(AudienceNetworkActivity.BROWSER_URL);
            this.f9653i = intent.getStringExtra(AudienceNetworkActivity.CLIENT_TOKEN);
            longExtra = intent.getLongExtra(AudienceNetworkActivity.HANDLER_TIME, -1);
        } else {
            this.f9652h = bundle.getString(AudienceNetworkActivity.BROWSER_URL);
            this.f9653i = bundle.getString(AudienceNetworkActivity.CLIENT_TOKEN);
            longExtra = bundle.getLong(AudienceNetworkActivity.HANDLER_TIME, -1);
        }
        this.f9654j = longExtra;
        String str = this.f9652h != null ? this.f9652h : "about:blank";
        this.f9647c.setUrl(str);
        this.f9648d.loadUrl(str);
    }

    /* renamed from: a */
    public void mo1011a(Bundle bundle) {
        bundle.putString(AudienceNetworkActivity.BROWSER_URL, this.f9652h);
    }

    /* renamed from: i */
    public void mo1012i() {
        this.f9648d.onPause();
        if (this.f9657m) {
            this.f9657m = false;
            this.f9650f.mo952g(this.f9653i, new C1559a(this.f9648d.getFirstUrl()).m5458a(this.f9654j).m5460b(this.f9656l).m5461c(this.f9648d.getResponseEndMs()).m5462d(this.f9648d.getDomContentLoadedMs()).m5463e(this.f9648d.getScrollReadyMs()).m5464f(this.f9648d.getLoadFinishMs()).m5465g(System.currentTimeMillis()).m5459a().m5466a());
        }
    }

    /* renamed from: j */
    public void mo1013j() {
        this.f9648d.onResume();
    }

    public void onDestroy() {
        this.f9646b.removeBackButtonInterceptor(this.f9651g);
        C1532b.m5366a(this.f9648d);
        this.f9648d.destroy();
    }

    public void setListener(C1551a c1551a) {
    }
}
