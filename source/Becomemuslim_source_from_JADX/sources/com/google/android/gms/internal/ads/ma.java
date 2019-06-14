package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;

@cm
public final class ma {
    /* renamed from: a */
    public static boolean m19847a(aoq aoq) {
        Bundle bundle = aoq.f28273m != null ? aoq.f28273m : new Bundle();
        return (bundle.getBundle(AdMobAdapter.class.getName()) != null ? bundle.getBundle(AdMobAdapter.class.getName()) : new Bundle()).getBoolean("render_test_label", false);
    }
}
