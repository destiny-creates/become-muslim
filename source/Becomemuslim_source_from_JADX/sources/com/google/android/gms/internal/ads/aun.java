package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;

final class aun implements ae<Object> {
    /* renamed from: a */
    final /* synthetic */ aum f23813a;
    /* renamed from: b */
    private final /* synthetic */ bq f23814b;

    aun(aum aum, bq bqVar) {
        this.f23813a = aum;
        this.f23814b = bqVar;
    }

    public final void zza(Object obj, Map<String, String> map) {
        qo qoVar = (qo) this.f23813a.f15010a.get();
        if (qoVar == null) {
            this.f23814b.mo4225b("/loadHtml", this);
            return;
        }
        qoVar.mo6718v().mo4343a(new auo(this, map, this.f23814b));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            qoVar.loadData(str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, Utf8Charset.NAME);
        } else {
            qoVar.loadDataWithBaseURL(str2, str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, Utf8Charset.NAME, null);
        }
    }
}
