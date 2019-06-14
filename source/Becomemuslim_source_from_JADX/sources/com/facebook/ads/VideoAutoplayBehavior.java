package com.facebook.ads;

import com.facebook.ads.internal.p099n.C1431m;

public enum VideoAutoplayBehavior {
    DEFAULT,
    ON,
    OFF;

    public static VideoAutoplayBehavior fromInternalAutoplayBehavior(C1431m c1431m) {
        if (c1431m == null) {
            return DEFAULT;
        }
        switch (c1431m) {
            case DEFAULT:
                return DEFAULT;
            case ON:
                return ON;
            case OFF:
                return OFF;
            default:
                return DEFAULT;
        }
    }
}
