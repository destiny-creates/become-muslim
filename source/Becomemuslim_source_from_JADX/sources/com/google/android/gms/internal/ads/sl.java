package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;

final class sl implements ae<qo> {
    /* renamed from: a */
    private final /* synthetic */ sk f24315a;

    sl(sk skVar) {
        this.f24315a = skVar;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.f24315a) {
                        if (this.f24315a.f32290v != parseInt) {
                            this.f24315a.f32290v = parseInt;
                            this.f24315a.requestLayout();
                        }
                    }
                } catch (Throwable e) {
                    mt.m19921c("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
