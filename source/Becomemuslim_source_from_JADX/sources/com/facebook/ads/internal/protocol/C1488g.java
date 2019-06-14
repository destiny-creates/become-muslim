package com.facebook.ads.internal.protocol;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.p105q.p106a.C1505h;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.protocol.g */
public class C1488g {
    /* renamed from: a */
    private static final Map<C1486e, C1487f> f4400a = new HashMap();

    static {
        f4400a.put(C1486e.RECTANGLE_HEIGHT_250, C1487f.WEBVIEW_BANNER_250);
        f4400a.put(C1486e.BANNER_HEIGHT_90, C1487f.WEBVIEW_BANNER_90);
        f4400a.put(C1486e.BANNER_HEIGHT_50, C1487f.WEBVIEW_BANNER_50);
    }

    /* renamed from: a */
    public static C1487f m5254a(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
        int i2 = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return C1505h.m5297a(i, i2) ? C1487f.WEBVIEW_INTERSTITIAL_TABLET : i2 > i ? C1487f.WEBVIEW_INTERSTITIAL_VERTICAL : C1487f.WEBVIEW_INTERSTITIAL_HORIZONTAL;
    }

    /* renamed from: a */
    public static C1487f m5255a(C1486e c1486e) {
        C1487f c1487f = (C1487f) f4400a.get(c1486e);
        return c1487f == null ? C1487f.WEBVIEW_BANNER_LEGACY : c1487f;
    }

    /* renamed from: a */
    public static void m5256a(DisplayMetrics displayMetrics, View view, C1486e c1486e) {
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(((int) (((float) displayMetrics.widthPixels) / displayMetrics.density)) >= c1486e.m5251a() ? displayMetrics.widthPixels : (int) Math.ceil((double) (((float) c1486e.m5251a()) * displayMetrics.density)), (int) Math.ceil((double) (((float) c1486e.m5252b()) * displayMetrics.density)));
        layoutParams.addRule(14, -1);
        view.setLayoutParams(layoutParams);
    }
}
