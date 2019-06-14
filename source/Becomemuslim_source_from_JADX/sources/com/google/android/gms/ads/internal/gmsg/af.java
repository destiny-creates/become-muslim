package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.azm;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.jw;
import java.util.Map;
import org.json.JSONObject;

final class af implements Runnable {
    /* renamed from: a */
    final /* synthetic */ azm f6869a;
    /* renamed from: b */
    private final /* synthetic */ Map f6870b;
    /* renamed from: c */
    private final /* synthetic */ HttpClient f6871c;

    af(HttpClient httpClient, Map map, azm azm) {
        this.f6871c = httpClient;
        this.f6870b = map;
        this.f6869a = azm;
    }

    public final void run() {
        jn.b("Received Http request.");
        try {
            JSONObject send = this.f6871c.send(new JSONObject((String) this.f6870b.get("http_request")));
            if (send == null) {
                jn.c("Response should not be null.");
            } else {
                jw.f15691a.post(new ag(this, send));
            }
        } catch (Throwable e) {
            jn.b("Error converting request to json.", e);
        }
    }
}
