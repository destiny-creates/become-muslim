package com.facebook.ads.internal.p105q.p106a;

import org.json.JSONArray;

/* renamed from: com.facebook.ads.internal.q.a.c */
public enum C1495c {
    APP_AD(0),
    LINK_AD(1),
    APP_AD_V2(2),
    LINK_AD_V2(3),
    APP_ENGAGEMENT_AD(4),
    AD_CHOICES(5),
    JS_TRIGGER(6),
    JS_TRIGGER_NO_AUTO_IMP_LOGGING(7),
    VIDEO_AD(8),
    INLINE_VIDEO_AD(9),
    BANNER_TO_INTERSTITIAL(10),
    NATIVE_CLOSE_BUTTON(11),
    UNIFIED_LOGGING(16),
    HTTP_LINKS(17);
    
    /* renamed from: o */
    public static final C1495c[] f4426o = null;
    /* renamed from: q */
    private static final String f4427q = null;
    /* renamed from: p */
    private final int f4429p;

    static {
        f4426o = new C1495c[]{LINK_AD_V2, APP_ENGAGEMENT_AD, AD_CHOICES, JS_TRIGGER_NO_AUTO_IMP_LOGGING, NATIVE_CLOSE_BUTTON, UNIFIED_LOGGING, HTTP_LINKS};
        JSONArray jSONArray = new JSONArray();
        C1495c[] c1495cArr = f4426o;
        int length = c1495cArr.length;
        int i;
        while (i < length) {
            jSONArray.put(c1495cArr[i].m5268a());
            i++;
        }
        f4427q = jSONArray.toString();
    }

    private C1495c(int i) {
        this.f4429p = i;
    }

    /* renamed from: b */
    public static String m5267b() {
        return f4427q;
    }

    /* renamed from: a */
    public int m5268a() {
        return this.f4429p;
    }

    public String toString() {
        return String.valueOf(this.f4429p);
    }
}
