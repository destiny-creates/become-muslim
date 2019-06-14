package com.facebook.ads.internal.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.provider.Settings.System;
import android.support.v4.content.C0373d;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.adapters.p086a.C1321k;
import com.facebook.ads.internal.p089d.C1359a;
import com.facebook.ads.internal.p089d.C1364b;
import com.facebook.ads.internal.p093h.C1389d;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.settings.C1550a.C1549a;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.n */
public class C4564n extends ab {
    /* renamed from: c */
    private static final String f12394c = "n";
    /* renamed from: d */
    private static final int[] f12395d = new int[]{-1, -6, -7, -8};
    /* renamed from: e */
    private final String f12396e = UUID.randomUUID().toString();
    /* renamed from: f */
    private Context f12397f;
    /* renamed from: g */
    private ac f12398g;
    /* renamed from: h */
    private boolean f12399h = false;
    /* renamed from: i */
    private String f12400i;
    /* renamed from: j */
    private String f12401j;
    /* renamed from: k */
    private long f12402k;
    /* renamed from: l */
    private C1321k f12403l;
    /* renamed from: m */
    private ad f12404m;

    /* renamed from: a */
    private void m15640a(Context context, final boolean z) {
        if (C1405a.m4825f(context)) {
            Log.d(f12394c, "Playable Ads pre-caching is disabled.");
            this.f12399h = true;
            this.f12398g.mo902a(this);
            return;
        }
        WebView webView = new WebView(context);
        webView.getSettings().setCacheMode(1);
        webView.setWebViewClient(new WebViewClient(this) {
            /* renamed from: a */
            boolean f3886a = false;
            /* renamed from: c */
            final /* synthetic */ C4564n f3888c;

            /* renamed from: com.facebook.ads.internal.adapters.n$1$1 */
            class C13341 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ C13351 f3885a;

                C13341(C13351 c13351) {
                    this.f3885a = c13351;
                }

                public void run() {
                    if (!this.f3885a.f3886a) {
                        this.f3885a.m4604a(null);
                    }
                }
            }

            /* renamed from: a */
            private void m4603a() {
                this.f3888c.f12399h = true;
                this.f3888c.f12398g.mo902a(this.f3888c);
            }

            /* renamed from: a */
            private void m4604a(WebResourceError webResourceError) {
                if (!z) {
                    if (this.f3888c.m15641a(webResourceError)) {
                        m4603a();
                        return;
                    }
                }
                this.f3888c.f12398g.mo903a(this.f3888c, AdError.CACHE_ERROR);
            }

            public void onPageFinished(WebView webView, String str) {
                this.f3886a = true;
                m4603a();
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                new Handler().postDelayed(new C13341(this), 10000);
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                this.f3886a = true;
                m4604a(webResourceError);
            }
        });
        webView.loadUrl(this.f12403l.m4563e().m4494j().m4549a());
    }

    /* renamed from: a */
    private boolean m15641a(WebResourceError webResourceError) {
        if (webResourceError != null) {
            if (VERSION.SDK_INT >= 23) {
                for (int i : f12395d) {
                    if (webResourceError.getErrorCode() == i) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private void m15645b(Context context, final boolean z) {
        final C1364b c1364b = new C1364b(context);
        c1364b.m4658a(this.f12403l.m4563e().m4484a());
        c1364b.m4659a(this.f12403l.m4563e().m4491g(), this.f12403l.m4563e().m4493i(), this.f12403l.m4563e().m4492h());
        c1364b.m4659a(this.f12403l.m4556a().m4546b(), -1, -1);
        for (String a : this.f12403l.m4564f().m4520d()) {
            c1364b.m4659a(a, -1, -1);
        }
        c1364b.m4657a(new C1359a(this) {
            /* renamed from: c */
            final /* synthetic */ C4564n f9520c;

            /* renamed from: c */
            private void m11555c() {
                this.f9520c.f12399h = true;
                this.f9520c.f12398g.mo902a(this.f9520c);
                this.f9520c.f12403l.m4560b(c1364b.m4660b(this.f9520c.f12403l.m4563e().m4484a()));
            }

            /* renamed from: a */
            public void mo882a() {
                m11555c();
            }

            /* renamed from: b */
            public void mo883b() {
                if (z) {
                    this.f9520c.f12398g.mo903a(this.f9520c, AdError.CACHE_ERROR);
                } else {
                    m11555c();
                }
            }
        });
    }

    /* renamed from: c */
    private boolean m15646c() {
        return this.f12403l.m4563e().m4494j() != null;
    }

    /* renamed from: d */
    private void m15647d() {
        C0373d.m1138a(this.f12397f).m1142a(this.f12404m, this.f12404m.m4588a());
    }

    /* renamed from: e */
    private void m15648e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = r2.f12404m;
        if (r0 == 0) goto L_0x000f;
    L_0x0004:
        r0 = r2.f12397f;	 Catch:{ Exception -> 0x000f }
        r0 = android.support.v4.content.C0373d.m1138a(r0);	 Catch:{ Exception -> 0x000f }
        r1 = r2.f12404m;	 Catch:{ Exception -> 0x000f }
        r0.m1141a(r1);	 Catch:{ Exception -> 0x000f }
    L_0x000f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.n.e():void");
    }

    /* renamed from: f */
    private String m15649f() {
        if (this.a == null) {
            return null;
        }
        Uri parse;
        Builder builder;
        String urlPrefix = AdSettings.getUrlPrefix();
        if (urlPrefix != null) {
            if (!urlPrefix.isEmpty()) {
                urlPrefix = String.format("https://www.%s.facebook.com/audience_network/server_side_reward", new Object[]{urlPrefix});
                parse = Uri.parse(urlPrefix);
                builder = new Builder();
                builder.scheme(parse.getScheme());
                builder.authority(parse.getAuthority());
                builder.path(parse.getPath());
                builder.query(parse.getQuery());
                builder.fragment(parse.getFragment());
                builder.appendQueryParameter("puid", this.a.getUserID());
                builder.appendQueryParameter("pc", this.a.getCurrency());
                builder.appendQueryParameter("ptid", this.f12396e);
                builder.appendQueryParameter("appid", this.f12400i);
                return builder.build().toString();
            }
        }
        urlPrefix = "https://www.facebook.com/audience_network/server_side_reward";
        parse = Uri.parse(urlPrefix);
        builder = new Builder();
        builder.scheme(parse.getScheme());
        builder.authority(parse.getAuthority());
        builder.path(parse.getPath());
        builder.query(parse.getQuery());
        builder.fragment(parse.getFragment());
        builder.appendQueryParameter("puid", this.a.getUserID());
        builder.appendQueryParameter("pc", this.a.getCurrency());
        builder.appendQueryParameter("ptid", this.f12396e);
        builder.appendQueryParameter("appid", this.f12400i);
        return builder.build().toString();
    }

    /* renamed from: a */
    public int mo2866a() {
        return this.f12403l == null ? -1 : this.f12403l.m4563e().m4488d();
    }

    /* renamed from: a */
    public void mo2867a(Context context, ac acVar, Map<String, Object> map, boolean z) {
        this.f12397f = context;
        this.f12398g = acVar;
        this.f12399h = false;
        this.f12401j = (String) map.get(AudienceNetworkActivity.PLACEMENT_ID);
        this.f12402k = ((Long) map.get(AudienceNetworkActivity.REQUEST_TIME)).longValue();
        int k = ((C1389d) map.get("definition")).m4776k();
        this.f12400i = this.f12401j != null ? this.f12401j.split("_")[0] : "";
        this.f12403l = C1321k.m4552a((JSONObject) map.get("data"));
        this.f12403l.m4557a(k);
        if (!TextUtils.isEmpty(this.f12403l.m4563e().m4484a()) || m15646c()) {
            this.f12404m = new ad(this.f12396e, this, acVar);
            m15647d();
            if (m15646c()) {
                m15640a(context, z);
            } else {
                m15645b(context, z);
            }
            return;
        }
        this.f12398g.mo903a(this, AdError.INTERNAL_ERROR);
    }

    /* renamed from: b */
    public boolean mo2868b() {
        if (!this.f12399h) {
            return false;
        }
        int i;
        String f = m15649f();
        this.f12403l.m4558a(f);
        Intent intent = new Intent(this.f12397f, AudienceNetworkActivity.class);
        intent.putExtra(AudienceNetworkActivity.VIEW_TYPE, C1549a.REWARDED_VIDEO);
        intent.putExtra("rewardedVideoAdDataBundle", this.f12403l);
        intent.putExtra(AudienceNetworkActivity.AUDIENCE_NETWORK_UNIQUE_ID_EXTRA, this.f12396e);
        intent.putExtra(AudienceNetworkActivity.REWARD_SERVER_URL, f);
        intent.putExtra(AudienceNetworkActivity.PLACEMENT_ID, this.f12401j);
        intent.putExtra(AudienceNetworkActivity.REQUEST_TIME, this.f12402k);
        if (this.b == -1 || System.getInt(this.f12397f.getContentResolver(), "accelerometer_rotation", 0) == 1) {
            if (!C1405a.m4835p(this.f12397f)) {
                f = AudienceNetworkActivity.PREDEFINED_ORIENTATION_KEY;
                i = 6;
            }
            if (!(this.f12397f instanceof Activity)) {
                intent.setFlags(intent.getFlags() | 268435456);
            }
            this.f12397f.startActivity(intent);
            return true;
        }
        f = AudienceNetworkActivity.PREDEFINED_ORIENTATION_KEY;
        i = this.b;
        intent.putExtra(f, i);
        if (this.f12397f instanceof Activity) {
            intent.setFlags(intent.getFlags() | 268435456);
        }
        this.f12397f.startActivity(intent);
        return true;
    }

    public void onDestroy() {
        m15648e();
    }
}
