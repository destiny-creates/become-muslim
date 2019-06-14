package com.google.android.gms.maps.p216a;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.react.uimanager.ViewProps;

/* renamed from: com.google.android.gms.maps.a.aj */
public final class aj {
    private aj() {
    }

    /* renamed from: a */
    private static <T extends Parcelable> T m21591a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(aj.class.getClassLoader());
        bundle = bundle.getBundle("map_state");
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(aj.class.getClassLoader());
        return bundle.getParcelable(str);
    }

    /* renamed from: a */
    public static void m21592a(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            return;
        }
        if (bundle2 != null) {
            Parcelable a = aj.m21591a(bundle, "MapOptions");
            if (a != null) {
                aj.m21593a(bundle2, "MapOptions", a);
            }
            a = aj.m21591a(bundle, "StreetViewPanoramaOptions");
            if (a != null) {
                aj.m21593a(bundle2, "StreetViewPanoramaOptions", a);
            }
            a = aj.m21591a(bundle, "camera");
            if (a != null) {
                aj.m21593a(bundle2, "camera", a);
            }
            if (bundle.containsKey(ViewProps.POSITION)) {
                bundle2.putString(ViewProps.POSITION, bundle.getString(ViewProps.POSITION));
            }
            if (bundle.containsKey("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT")) {
                bundle2.putBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", bundle.getBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", false));
            }
        }
    }

    /* renamed from: a */
    public static void m21593a(Bundle bundle, String str, Parcelable parcelable) {
        bundle.setClassLoader(aj.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(aj.class.getClassLoader());
        bundle2.putParcelable(str, parcelable);
        bundle.putBundle("map_state", bundle2);
    }
}
