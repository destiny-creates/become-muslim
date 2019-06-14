package com.facebook.ads;

import com.facebook.ads.internal.protocol.C1486e;
import java.io.Serializable;

public class AdSize implements Serializable {
    @Deprecated
    public static final AdSize BANNER_320_50 = new AdSize(C1486e.BANNER_320_50);
    public static final AdSize BANNER_HEIGHT_50 = new AdSize(C1486e.BANNER_HEIGHT_50);
    public static final AdSize BANNER_HEIGHT_90 = new AdSize(C1486e.BANNER_HEIGHT_90);
    public static final AdSize INTERSTITIAL = new AdSize(C1486e.INTERSTITIAL);
    public static final AdSize RECTANGLE_HEIGHT_250 = new AdSize(C1486e.RECTANGLE_HEIGHT_250);
    /* renamed from: a */
    private final int f3655a;
    /* renamed from: b */
    private final int f3656b;

    public AdSize(int i, int i2) {
        this.f3655a = i;
        this.f3656b = i2;
    }

    private AdSize(C1486e c1486e) {
        this.f3655a = c1486e.m5251a();
        this.f3656b = c1486e.m5252b();
    }

    public static AdSize fromWidthAndHeight(int i, int i2) {
        return (INTERSTITIAL.f3656b == i2 && INTERSTITIAL.f3655a == i) ? INTERSTITIAL : (BANNER_320_50.f3656b == i2 && BANNER_320_50.f3655a == i) ? BANNER_320_50 : (BANNER_HEIGHT_50.f3656b == i2 && BANNER_HEIGHT_50.f3655a == i) ? BANNER_HEIGHT_50 : (BANNER_HEIGHT_90.f3656b == i2 && BANNER_HEIGHT_90.f3655a == i) ? BANNER_HEIGHT_90 : (RECTANGLE_HEIGHT_250.f3656b == i2 && RECTANGLE_HEIGHT_250.f3655a == i) ? RECTANGLE_HEIGHT_250 : null;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                AdSize adSize = (AdSize) obj;
                if (this.f3655a != adSize.f3655a) {
                    return false;
                }
                if (this.f3656b != adSize.f3656b) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int getHeight() {
        return this.f3656b;
    }

    public int getWidth() {
        return this.f3655a;
    }

    public int hashCode() {
        return (this.f3655a * 31) + this.f3656b;
    }

    public C1486e toInternalAdSize() {
        return C1486e.m5250a(this.f3655a, this.f3656b);
    }
}
