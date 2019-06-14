package com.facebook.ads.internal.protocol;

import java.io.Serializable;

/* renamed from: com.facebook.ads.internal.protocol.e */
public enum C1486e implements Serializable {
    BANNER_320_50(320, 50),
    INTERSTITIAL(0, 0),
    BANNER_HEIGHT_50(-1, 50),
    BANNER_HEIGHT_90(-1, 90),
    RECTANGLE_HEIGHT_250(-1, 250);
    
    /* renamed from: f */
    private final int f4382f;
    /* renamed from: g */
    private final int f4383g;

    private C1486e(int i, int i2) {
        this.f4382f = i;
        this.f4383g = i2;
    }

    /* renamed from: a */
    public static C1486e m5250a(int i, int i2) {
        return (INTERSTITIAL.f4383g == i2 && INTERSTITIAL.f4382f == i) ? INTERSTITIAL : (BANNER_320_50.f4383g == i2 && BANNER_320_50.f4382f == i) ? BANNER_320_50 : (BANNER_HEIGHT_50.f4383g == i2 && BANNER_HEIGHT_50.f4382f == i) ? BANNER_HEIGHT_50 : (BANNER_HEIGHT_90.f4383g == i2 && BANNER_HEIGHT_90.f4382f == i) ? BANNER_HEIGHT_90 : (RECTANGLE_HEIGHT_250.f4383g == i2 && RECTANGLE_HEIGHT_250.f4382f == i) ? RECTANGLE_HEIGHT_250 : null;
    }

    /* renamed from: a */
    public int m5251a() {
        return this.f4382f;
    }

    /* renamed from: b */
    public int m5252b() {
        return this.f4383g;
    }
}
