package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.p085a.C1297b;
import com.facebook.ads.internal.p085a.C1298c;
import com.facebook.ads.internal.p085a.C1301e;
import com.facebook.ads.internal.p093h.C1389d;
import com.facebook.ads.internal.p095j.C1397a;
import com.facebook.ads.internal.p095j.C1397a.C1395a;
import com.facebook.ads.internal.p095j.C1398b;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p108c.C1532b;
import com.facebook.ads.internal.protocol.C1486e;
import com.facebook.ads.internal.view.p113b.C3616a;
import com.facebook.ads.internal.view.p113b.C3616a.C1568b;
import com.facebook.ads.internal.view.p113b.C3616a.C3615c;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.i */
public class C4560i extends BannerAdapter {
    /* renamed from: a */
    private static final String f12306a = "i";
    /* renamed from: b */
    private C1568b f12307b;
    /* renamed from: c */
    private C3616a f12308c;
    /* renamed from: d */
    private C3569q f12309d;
    /* renamed from: e */
    private BannerAdapterListener f12310e;
    /* renamed from: f */
    private Map<String, Object> f12311f;
    /* renamed from: g */
    private C1412c f12312g;
    /* renamed from: h */
    private Context f12313h;
    /* renamed from: i */
    private long f12314i;
    /* renamed from: j */
    private C1395a f12315j;

    /* renamed from: com.facebook.ads.internal.adapters.i$2 */
    class C35552 extends C1324c {
        /* renamed from: a */
        final /* synthetic */ C4560i f9503a;

        C35552(C4560i c4560i) {
            this.f9503a = c4560i;
        }

        /* renamed from: a */
        public void mo929a() {
            if (this.f9503a.f12310e != null) {
                this.f9503a.f12310e.onBannerLoggingImpression(this.f9503a);
            }
        }
    }

    /* renamed from: a */
    private void m15558a(C1389d c1389d) {
        this.f12314i = 0;
        this.f12315j = null;
        final C3568p a = C3568p.m11559a((JSONObject) this.f12311f.get("data"));
        if (C1301e.m4451a(this.f12313h, a, this.f12312g)) {
            this.f12310e.onBannerError(this, AdError.NO_FILL);
            return;
        }
        this.f12307b = new C3615c(this) {
            /* renamed from: b */
            final /* synthetic */ C4560i f12305b;

            /* renamed from: a */
            public void mo1005a() {
                this.f12305b.f12309d.m11577b();
            }

            /* renamed from: a */
            public void mo1006a(int i) {
                if (i == 0 && this.f12305b.f12314i > 0 && this.f12305b.f12315j != null) {
                    C1398b.m4797a(C1397a.m4792a(this.f12305b.f12314i, this.f12305b.f12315j, a.m11568g()));
                    this.f12305b.f12314i = 0;
                    this.f12305b.f12315j = null;
                }
            }

            /* renamed from: a */
            public void mo1008a(String str, Map<String, String> map) {
                Uri parse = Uri.parse(str);
                if ("fbad".equals(parse.getScheme()) && C1298c.m4445a(parse.getAuthority()) && this.f12305b.f12310e != null) {
                    this.f12305b.f12310e.onBannerAdClicked(this.f12305b);
                }
                C1297b a = C1298c.m4444a(this.f12305b.f12313h, this.f12305b.f12312g, a.mo936c(), parse, map);
                if (a != null) {
                    try {
                        this.f12305b.f12315j = a.mo918a();
                        this.f12305b.f12314i = System.currentTimeMillis();
                        a.mo917b();
                    } catch (Throwable e) {
                        Log.e(C4560i.f12306a, "Error executing action", e);
                    }
                }
            }

            /* renamed from: b */
            public void mo1009b() {
                if (this.f12305b.f12309d != null) {
                    this.f12305b.f12309d.m4591a();
                }
            }
        };
        this.f12308c = new C3616a(this.f12313h, new WeakReference(this.f12307b), c1389d.m4771f());
        this.f12308c.m11795a(c1389d.m4773h(), c1389d.m4774i());
        this.f12309d = new C3569q(this.f12313h, this.f12312g, this.f12308c, this.f12308c.getViewabilityChecker(), new C35552(this));
        this.f12309d.m11575a(a);
        this.f12308c.loadDataWithBaseURL(C1532b.m5365a(), a.m11565d(), AudienceNetworkActivity.WEBVIEW_MIME_TYPE, AudienceNetworkActivity.WEBVIEW_ENCODING, null);
        if (this.f12310e != null) {
            this.f12310e.onBannerAdLoaded(this, this.f12308c);
        }
    }

    public void loadBannerAd(Context context, C1412c c1412c, C1486e c1486e, BannerAdapterListener bannerAdapterListener, Map<String, Object> map) {
        this.f12313h = context;
        this.f12312g = c1412c;
        this.f12310e = bannerAdapterListener;
        this.f12311f = map;
        m15558a((C1389d) this.f12311f.get("definition"));
    }

    public void onDestroy() {
        if (this.f12308c != null) {
            this.f12308c.destroy();
            this.f12308c = null;
            this.f12307b = null;
        }
    }
}
