package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.ax;
import java.io.InputStream;
import java.util.Map;

@TargetApi(21)
public final class kn extends kl {
    /* renamed from: a */
    public final WebResourceResponse mo6907a(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }

    /* renamed from: a */
    public final qp mo6101a(qo qoVar, boolean z) {
        return new ro(qoVar, z);
    }

    /* renamed from: c */
    public final CookieManager mo6908c(Context context) {
        if (kc.m19754e()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            mt.m19919b("Failed to obtain CookieManager.", th);
            ax.i().m30834a(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    /* renamed from: f */
    public final int mo6659f() {
        return 16974374;
    }
}
