package com.google.android.gms.ads.internal.gmsg;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.jw;
import com.google.android.gms.internal.ads.qo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.ads.internal.gmsg.v */
final class C4281v implements ae<qo> {
    C4281v() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        qo qoVar = (qo) obj;
        WindowManager windowManager = (WindowManager) qoVar.getContext().getSystemService("window");
        ax.m7464e();
        View view = (View) qoVar;
        DisplayMetrics a = jw.a(windowManager);
        int i = a.widthPixels;
        int i2 = a.heightPixels;
        int[] iArr = new int[2];
        Map hashMap = new HashMap();
        view.getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i2));
        qoVar.a("locationReady", hashMap);
        jn.e("GET LOCATION COMPILED");
    }
}
