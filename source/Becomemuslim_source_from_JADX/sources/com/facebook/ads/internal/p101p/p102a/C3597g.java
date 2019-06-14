package com.facebook.ads.internal.p101p.p102a;

import com.facebook.ads.internal.settings.AdInternalSettings;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.p.a.g */
public class C3597g implements C1454r {
    /* renamed from: a */
    private void m11725a(Map<String, List<String>> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                for (String str2 : (List) map.get(str)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(":");
                    stringBuilder.append(str2);
                    mo978a(stringBuilder.toString());
                }
            }
        }
    }

    /* renamed from: a */
    public void mo977a(C1450n c1450n) {
        if (c1450n != null) {
            mo978a("=== HTTP Response ===");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Receive url: ");
            stringBuilder.append(c1450n.m5134b());
            mo978a(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("Status: ");
            stringBuilder.append(c1450n.m5133a());
            mo978a(stringBuilder.toString());
            m11725a(c1450n.m5135c());
            stringBuilder = new StringBuilder();
            stringBuilder.append("Content:\n");
            stringBuilder.append(c1450n.m5137e());
            mo978a(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public void mo978a(String str) {
        System.out.println(str);
    }

    /* renamed from: a */
    public void mo979a(HttpURLConnection httpURLConnection, Object obj) {
        mo978a("=== HTTP Request ===");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(httpURLConnection.getRequestMethod());
        stringBuilder.append(" ");
        stringBuilder.append(httpURLConnection.getURL().toString());
        mo978a(stringBuilder.toString());
        if (obj instanceof String) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Content: ");
            stringBuilder.append((String) obj);
            mo978a(stringBuilder.toString());
        }
        m11725a(httpURLConnection.getRequestProperties());
    }

    /* renamed from: a */
    public boolean mo980a() {
        return AdInternalSettings.isDebugBuild();
    }
}
