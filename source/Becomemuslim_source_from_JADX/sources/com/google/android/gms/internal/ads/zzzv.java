package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.p015c.C0107c;
import android.support.p015c.C0107c.C0106a;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.C4739c;
import com.google.android.gms.ads.mediation.C2681a;
import com.google.android.gms.ads.mediation.C2689d;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.common.util.C2904o;

@cm
public final class zzzv implements MediationInterstitialAdapter {
    /* renamed from: a */
    private Activity f28779a;
    /* renamed from: b */
    private C2689d f28780b;
    /* renamed from: c */
    private Uri f28781c;

    public final void onDestroy() {
        mt.m19918b("Destroying AdMobCustomTabsAdapter adapter.");
    }

    public final void onPause() {
        mt.m19918b("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public final void onResume() {
        mt.m19918b("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public final void requestInterstitialAd(Context context, C2689d c2689d, Bundle bundle, C2681a c2681a, Bundle bundle2) {
        this.f28780b = c2689d;
        if (this.f28780b == null) {
            mt.m19924e("Listener not set for mediation. Returning.");
        } else if (context instanceof Activity) {
            Object obj = (C2904o.c() && atn.m30191a(context)) ? 1 : null;
            if (obj == null) {
                mt.m19924e("Default browser does not support custom tabs. Bailing out.");
                this.f28780b.a(this, 0);
                return;
            }
            obj = bundle.getString("tab_url");
            if (TextUtils.isEmpty(obj)) {
                mt.m19924e("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.f28780b.a(this, 0);
                return;
            }
            this.f28779a = (Activity) context;
            this.f28781c = Uri.parse(obj);
            this.f28780b.a(this);
        } else {
            mt.m19924e("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.f28780b.a(this, 0);
        }
    }

    public final void showInterstitial() {
        C0107c a = new C0106a().a();
        a.f240a.setData(this.f28781c);
        jw.f15691a.post(new bfa(this, new AdOverlayInfoParcel(new C4739c(a.f240a), null, new bez(this), null, new mv(0, 0, false))));
        ax.i().m30841f();
    }
}
