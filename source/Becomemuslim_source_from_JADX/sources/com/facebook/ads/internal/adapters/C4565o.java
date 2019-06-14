package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p099n.C1418c;
import com.facebook.ads.internal.p099n.C1425f;
import com.facebook.ads.internal.p099n.C1425f.C1424c;
import com.facebook.ads.internal.p099n.C1427h;
import com.facebook.ads.internal.p099n.C1428j;
import com.facebook.ads.internal.p099n.C1429k;
import com.facebook.ads.internal.p099n.C1431m;
import com.facebook.ads.internal.p105q.p106a.C1496d;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.C1481a;
import com.facebook.share.internal.ShareConstants;
import com.flurry.android.FlurryAgent;
import com.flurry.android.ads.FlurryAdErrorType;
import com.flurry.android.ads.FlurryAdNative;
import com.flurry.android.ads.FlurryAdNativeAsset;
import com.flurry.android.ads.FlurryAdNativeListener;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.o */
public class C4565o extends C3572y implements C1340u {
    /* renamed from: a */
    private static volatile boolean f12405a;
    /* renamed from: b */
    private C1346z f12406b;
    /* renamed from: c */
    private FlurryAdNative f12407c;
    /* renamed from: d */
    private boolean f12408d;
    /* renamed from: e */
    private String f12409e;
    /* renamed from: f */
    private String f12410f;
    /* renamed from: g */
    private String f12411g;
    /* renamed from: h */
    private String f12412h;
    /* renamed from: i */
    private String f12413i;
    /* renamed from: j */
    private C1427h f12414j;
    /* renamed from: k */
    private C1427h f12415k;
    /* renamed from: l */
    private C1427h f12416l;

    /* renamed from: A */
    public String mo2816A() {
        return null;
    }

    /* renamed from: B */
    public String mo2817B() {
        return null;
    }

    /* renamed from: C */
    public C1431m mo2818C() {
        return C1431m.DEFAULT;
    }

    /* renamed from: D */
    public int mo2819D() {
        return 0;
    }

    /* renamed from: E */
    public String mo2820E() {
        return null;
    }

    /* renamed from: F */
    public List<C1425f> mo2821F() {
        return null;
    }

    /* renamed from: G */
    public int mo2822G() {
        return 0;
    }

    /* renamed from: H */
    public int mo2823H() {
        return 0;
    }

    /* renamed from: I */
    public C1418c mo2824I() {
        return C1418c.FLURRY;
    }

    /* renamed from: J */
    public C1328f mo2825J() {
        return C1328f.YAHOO;
    }

    /* renamed from: a */
    public void mo2826a(int i) {
    }

    /* renamed from: a */
    public void mo2827a(final Context context, C1346z c1346z, C1412c c1412c, Map<String, Object> map, C1424c c1424c) {
        JSONObject jSONObject = (JSONObject) map.get("data");
        String optString = jSONObject.optString("api_key");
        String optString2 = jSONObject.optString("placement_id");
        synchronized (C4565o.class) {
            if (!f12405a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(C1342v.m4609a(mo2825J()));
                stringBuilder.append(" Initializing");
                C1496d.m5271a(context, stringBuilder.toString());
                FlurryAgent.setLogEnabled(true);
                FlurryAgent.init(context, optString);
                f12405a = true;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(C1342v.m4609a(mo2825J()));
        stringBuilder2.append(" Loading");
        C1496d.m5271a(context, stringBuilder2.toString());
        this.f12406b = c1346z;
        this.f12407c = new FlurryAdNative(context, optString2);
        this.f12407c.setListener(new FlurryAdNativeListener(this) {
            /* renamed from: b */
            final /* synthetic */ C4565o f3890b;

            public void onAppExit(FlurryAdNative flurryAdNative) {
            }

            public void onClicked(FlurryAdNative flurryAdNative) {
                if (this.f3890b.f12406b != null) {
                    this.f3890b.f12406b.mo900c(this.f3890b);
                }
            }

            public void onCloseFullscreen(FlurryAdNative flurryAdNative) {
            }

            public void onCollapsed(FlurryAdNative flurryAdNative) {
            }

            public void onError(FlurryAdNative flurryAdNative, FlurryAdErrorType flurryAdErrorType, int i) {
                Context context = context;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(C1342v.m4609a(this.f3890b.mo2825J()));
                stringBuilder.append(" Failed with FlurryError: ");
                stringBuilder.append(flurryAdErrorType.toString());
                C1496d.m5271a(context, stringBuilder.toString());
                if (this.f3890b.f12406b != null) {
                    this.f3890b.f12406b.mo898a(this.f3890b, C1481a.m5241a(AdErrorType.MEDIATION_ERROR, flurryAdErrorType.toString()));
                }
            }

            public void onExpanded(FlurryAdNative flurryAdNative) {
            }

            public void onFetched(FlurryAdNative flurryAdNative) {
                if (this.f3890b.f12406b != null) {
                    Context context;
                    StringBuilder stringBuilder;
                    if (flurryAdNative.isVideoAd()) {
                        context = context;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(C1342v.m4609a(this.f3890b.mo2825J()));
                        stringBuilder.append(" Failed. AN does not support Flurry video ads");
                        C1496d.m5271a(context, stringBuilder.toString());
                        this.f3890b.f12406b.mo898a(this.f3890b, new C1481a(AdErrorType.MEDIATION_ERROR, "video ad"));
                        return;
                    }
                    this.f3890b.f12408d = true;
                    FlurryAdNativeAsset asset = flurryAdNative.getAsset("headline");
                    if (asset != null) {
                        this.f3890b.f12409e = asset.getValue();
                    }
                    asset = flurryAdNative.getAsset("summary");
                    if (asset != null) {
                        this.f3890b.f12410f = asset.getValue();
                    }
                    asset = flurryAdNative.getAsset(ShareConstants.FEED_SOURCE_PARAM);
                    if (asset != null) {
                        this.f3890b.f12411g = asset.getValue();
                    }
                    asset = flurryAdNative.getAsset("appCategory");
                    if (asset != null) {
                        this.f3890b.f12413i = asset.getValue();
                    }
                    asset = flurryAdNative.getAsset("callToAction");
                    if (asset != null) {
                        this.f3890b.f12412h = asset.getValue();
                    } else {
                        C4565o c4565o;
                        String str;
                        if (flurryAdNative.getAsset("appRating") != null) {
                            c4565o = this.f3890b;
                            str = "Install Now";
                        } else {
                            c4565o = this.f3890b;
                            str = "Learn More";
                        }
                        c4565o.f12412h = str;
                    }
                    asset = flurryAdNative.getAsset("secImage");
                    if (asset != null) {
                        this.f3890b.f12414j = new C1427h(asset.getValue(), 82, 82);
                    }
                    asset = flurryAdNative.getAsset("secHqImage");
                    if (asset != null) {
                        this.f3890b.f12415k = new C1427h(asset.getValue(), 1200, 627);
                    }
                    FlurryAdNativeAsset asset2 = flurryAdNative.getAsset("secBrandingLogo");
                    if (asset2 != null) {
                        this.f3890b.f12416l = new C1427h(asset2.getValue(), 20, 20);
                    }
                    context = context;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(C1342v.m4609a(this.f3890b.mo2825J()));
                    stringBuilder.append(" Loaded");
                    C1496d.m5271a(context, stringBuilder.toString());
                    this.f3890b.f12406b.mo897a(this.f3890b);
                }
            }

            public void onImpressionLogged(FlurryAdNative flurryAdNative) {
                if (this.f3890b.f12406b != null) {
                    this.f3890b.f12406b.mo899b(this.f3890b);
                }
            }

            public void onShowFullscreen(FlurryAdNative flurryAdNative) {
            }
        });
        this.f12407c.fetchAd();
    }

    /* renamed from: a */
    public void mo2828a(View view, List<View> list) {
        if (this.f12407c != null) {
            this.f12407c.setTrackingView(view);
        }
    }

    /* renamed from: a */
    public void mo2829a(C1346z c1346z) {
        this.f12406b = c1346z;
    }

    /* renamed from: a */
    public void mo2830a(Map<String, String> map) {
    }

    /* renamed from: b */
    public void mo2831b(Map<String, String> map) {
    }

    public void b_() {
        if (this.f12407c != null) {
            this.f12407c.removeTrackingView();
        }
    }

    /* renamed from: c */
    public String mo2833c() {
        return null;
    }

    public boolean c_() {
        return this.f12408d;
    }

    /* renamed from: d */
    public boolean mo2835d() {
        return false;
    }

    /* renamed from: e */
    public boolean mo2836e() {
        return false;
    }

    /* renamed from: f */
    public boolean mo2837f() {
        return false;
    }

    /* renamed from: g */
    public boolean mo2838g() {
        return true;
    }

    /* renamed from: h */
    public int mo2839h() {
        return 0;
    }

    /* renamed from: i */
    public int mo2840i() {
        return 0;
    }

    /* renamed from: j */
    public int mo2841j() {
        return 0;
    }

    /* renamed from: k */
    public C1427h mo2842k() {
        return this.f12414j;
    }

    /* renamed from: l */
    public C1427h mo2843l() {
        return this.f12415k;
    }

    /* renamed from: m */
    public C1429k mo2844m() {
        return null;
    }

    /* renamed from: n */
    public String mo2845n() {
        return null;
    }

    /* renamed from: o */
    public String mo2846o() {
        return null;
    }

    public void onDestroy() {
        b_();
        this.f12406b = null;
        if (this.f12407c != null) {
            this.f12407c.destroy();
            this.f12407c = null;
        }
    }

    /* renamed from: p */
    public String mo2848p() {
        return this.f12410f;
    }

    /* renamed from: q */
    public String mo2849q() {
        return this.f12412h;
    }

    /* renamed from: r */
    public String mo2850r() {
        return this.f12413i;
    }

    /* renamed from: s */
    public String mo2851s() {
        return null;
    }

    /* renamed from: t */
    public String mo2852t() {
        return null;
    }

    /* renamed from: u */
    public String mo2853u() {
        return null;
    }

    /* renamed from: v */
    public String mo2854v() {
        return null;
    }

    /* renamed from: w */
    public C1428j mo2855w() {
        return null;
    }

    /* renamed from: x */
    public C1427h mo2856x() {
        return this.f12416l;
    }

    /* renamed from: y */
    public String mo2857y() {
        return null;
    }

    /* renamed from: z */
    public String mo2858z() {
        return "Ad";
    }
}
