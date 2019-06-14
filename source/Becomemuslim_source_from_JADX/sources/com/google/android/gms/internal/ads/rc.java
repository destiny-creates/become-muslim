package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;

final class rc implements ae<qo> {
    /* renamed from: a */
    private final /* synthetic */ rb f24285a;

    rc(rb rbVar) {
        this.f24285a = rbVar;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.f24285a) {
                        if (this.f24285a.f32218B != parseInt) {
                            this.f24285a.f32218B = parseInt;
                            this.f24285a.requestLayout();
                        }
                    }
                } catch (Throwable e) {
                    mt.m19921c("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
