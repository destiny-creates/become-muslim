package com.facebook.ads.internal.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.adapters.C1324c;
import com.facebook.ads.internal.adapters.C3568p;
import com.facebook.ads.internal.adapters.C3569q;
import com.facebook.ads.internal.p085a.C1297b;
import com.facebook.ads.internal.p085a.C1298c;
import com.facebook.ads.internal.p095j.C1397a;
import com.facebook.ads.internal.p095j.C1397a.C1395a;
import com.facebook.ads.internal.p095j.C1398b;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1508k;
import com.facebook.ads.internal.p105q.p108c.C1532b;
import com.facebook.ads.internal.view.C1566a.C1551a;
import com.facebook.ads.internal.view.p113b.C3616a;
import com.facebook.ads.internal.view.p113b.C3616a.C1568b;
import com.facebook.ads.internal.view.p113b.C3616a.C3615c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.view.e */
public class C3638e implements C1566a {
    /* renamed from: a */
    private static final String f9737a = "e";
    /* renamed from: b */
    private final C1551a f9738b;
    /* renamed from: c */
    private final C3616a f9739c;
    /* renamed from: d */
    private final C1568b f9740d;
    /* renamed from: e */
    private final C3569q f9741e;
    /* renamed from: f */
    private final C1412c f9742f;
    /* renamed from: g */
    private C3568p f9743g;
    /* renamed from: h */
    private long f9744h = System.currentTimeMillis();
    /* renamed from: i */
    private long f9745i;
    /* renamed from: j */
    private C1395a f9746j;

    /* renamed from: com.facebook.ads.internal.view.e$2 */
    class C36332 extends C1324c {
        /* renamed from: a */
        final /* synthetic */ C3638e f9731a;

        C36332(C3638e c3638e) {
            this.f9731a = c3638e;
        }

        /* renamed from: a */
        public void mo929a() {
            this.f9731a.f9738b.mo854a("com.facebook.ads.interstitial.impression.logged");
        }
    }

    public C3638e(final AudienceNetworkActivity audienceNetworkActivity, final C1412c c1412c, C1551a c1551a) {
        this.f9738b = c1551a;
        this.f9742f = c1412c;
        this.f9740d = new C3615c(this) {
            /* renamed from: c */
            final /* synthetic */ C3638e f12465c;
            /* renamed from: d */
            private long f12466d = 0;

            /* renamed from: a */
            public void mo1005a() {
                this.f12465c.f9741e.m11577b();
            }

            /* renamed from: a */
            public void mo1008a(String str, Map<String, String> map) {
                Uri parse = Uri.parse(str);
                if ("fbad".equals(parse.getScheme()) && "close".equals(parse.getAuthority())) {
                    audienceNetworkActivity.finish();
                    return;
                }
                long j = this.f12466d;
                this.f12466d = System.currentTimeMillis();
                if (this.f12466d - j >= 1000) {
                    if ("fbad".equals(parse.getScheme()) && C1298c.m4445a(parse.getAuthority())) {
                        this.f12465c.f9738b.mo854a("com.facebook.ads.interstitial.clicked");
                    }
                    C1297b a = C1298c.m4444a(audienceNetworkActivity, c1412c, this.f12465c.f9743g.mo936c(), parse, map);
                    if (a != null) {
                        try {
                            this.f12465c.f9746j = a.mo918a();
                            this.f12465c.f9745i = System.currentTimeMillis();
                            a.mo917b();
                        } catch (Throwable e) {
                            Log.e(C3638e.f9737a, "Error executing action", e);
                        }
                    }
                }
            }

            /* renamed from: b */
            public void mo1009b() {
                this.f12465c.f9741e.m4591a();
            }
        };
        this.f9739c = new C3616a(audienceNetworkActivity, new WeakReference(this.f9740d), 1);
        this.f9739c.setLayoutParams(new LayoutParams(-1, -1));
        Context context = audienceNetworkActivity;
        C1412c c1412c2 = c1412c;
        this.f9741e = new C3569q(context, c1412c2, this.f9739c, this.f9739c.getViewabilityChecker(), new C36332(this));
        c1551a.mo853a(this.f9739c);
    }

    /* renamed from: a */
    public void mo1010a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        if (bundle == null || !bundle.containsKey("dataModel")) {
            this.f9743g = C3568p.m11560b(intent);
            if (this.f9743g != null) {
                this.f9741e.m11575a(this.f9743g);
                this.f9739c.loadDataWithBaseURL(C1532b.m5365a(), this.f9743g.m11565d(), AudienceNetworkActivity.WEBVIEW_MIME_TYPE, AudienceNetworkActivity.WEBVIEW_ENCODING, null);
                this.f9739c.m11795a(this.f9743g.m11569h(), this.f9743g.m11570i());
            }
            return;
        }
        this.f9743g = C3568p.m11558a(bundle.getBundle("dataModel"));
        if (this.f9743g != null) {
            this.f9739c.loadDataWithBaseURL(C1532b.m5365a(), this.f9743g.m11565d(), AudienceNetworkActivity.WEBVIEW_MIME_TYPE, AudienceNetworkActivity.WEBVIEW_ENCODING, null);
            this.f9739c.m11795a(this.f9743g.m11569h(), this.f9743g.m11570i());
        }
    }

    /* renamed from: a */
    public void mo1011a(Bundle bundle) {
        if (this.f9743g != null) {
            bundle.putBundle("dataModel", this.f9743g.m11571j());
        }
    }

    /* renamed from: i */
    public void mo1012i() {
        this.f9739c.onPause();
    }

    /* renamed from: j */
    public void mo1013j() {
        if (!(this.f9745i <= 0 || this.f9746j == null || this.f9743g == null)) {
            C1398b.m4797a(C1397a.m4792a(this.f9745i, this.f9746j, this.f9743g.m11568g()));
        }
        this.f9739c.onResume();
    }

    public void onDestroy() {
        if (this.f9743g != null) {
            C1398b.m4797a(C1397a.m4792a(this.f9744h, C1395a.XOUT, this.f9743g.m11568g()));
            if (!TextUtils.isEmpty(this.f9743g.mo936c())) {
                Map hashMap = new HashMap();
                this.f9739c.getViewabilityChecker().m5433a(hashMap);
                hashMap.put("touch", C1508k.m5306a(this.f9739c.getTouchData()));
                this.f9742f.mo954i(this.f9743g.mo936c(), hashMap);
            }
        }
        C1532b.m5366a(this.f9739c);
        this.f9739c.destroy();
    }

    public void setListener(C1551a c1551a) {
    }
}
