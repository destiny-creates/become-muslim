package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.util.C2904o;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.jw;

@cm
/* renamed from: com.google.android.gms.ads.internal.overlay.l */
public final class C2663l {
    /* renamed from: a */
    public static void m7543a(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.f13031k == 4 && adOverlayInfoParcel.f13023c == null) {
            if (adOverlayInfoParcel.f13022b != null) {
                adOverlayInfoParcel.f13022b.onAdClicked();
            }
            ax.m7461b();
            C2656a.m7542a(context, adOverlayInfoParcel.f13021a, adOverlayInfoParcel.f13029i);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.f13033m.f28712d);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.m16554a(intent, adOverlayInfoParcel);
        if (!C2904o.m8463i()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        ax.m7464e();
        jw.a(context, intent);
    }
}
