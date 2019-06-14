package com.facebook.ads;

import com.facebook.ads.internal.p099n.C1418c;

public enum AdNetwork {
    AN(C1418c.AN),
    ADMOB(C1418c.ADMOB),
    FLURRY(C1418c.FLURRY),
    INMOBI(C1418c.INMOBI);
    
    /* renamed from: a */
    private final C1418c f3649a;

    private AdNetwork(C1418c c1418c) {
        this.f3649a = c1418c;
    }

    public static AdNetwork fromInternalAdNetwork(C1418c c1418c) {
        if (c1418c == null) {
            return AN;
        }
        switch (c1418c) {
            case AN:
                return AN;
            case ADMOB:
                return ADMOB;
            case FLURRY:
                return FLURRY;
            case INMOBI:
                return INMOBI;
            default:
                return AN;
        }
    }
}
