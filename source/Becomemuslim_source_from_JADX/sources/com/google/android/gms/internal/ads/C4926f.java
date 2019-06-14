package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;
import java.util.Map;

@cm
/* renamed from: com.google.android.gms.internal.ads.f */
public final class C4926f {
    /* renamed from: a */
    private final qo f15372a;
    /* renamed from: b */
    private final boolean f15373b;
    /* renamed from: c */
    private final String f15374c;

    public C4926f(qo qoVar, Map<String, String> map) {
        this.f15372a = qoVar;
        this.f15374c = (String) map.get("forceOrientation");
        this.f15373b = map.containsKey("allowOrientationChange") ? Boolean.parseBoolean((String) map.get("allowOrientationChange")) : true;
    }

    /* renamed from: a */
    public final void m19403a() {
        if (this.f15372a == null) {
            mt.m19924e("AdWebView is null");
            return;
        }
        int b = "portrait".equalsIgnoreCase(this.f15374c) ? ax.g().mo4309b() : "landscape".equalsIgnoreCase(this.f15374c) ? ax.g().mo4307a() : this.f15373b ? -1 : ax.g().mo6878c();
        this.f15372a.setRequestedOrientation(b);
    }
}
