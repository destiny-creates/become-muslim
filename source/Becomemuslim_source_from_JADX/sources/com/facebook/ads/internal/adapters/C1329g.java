package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.internal.adapters.g */
public enum C1329g {
    ANBANNER(C4560i.class, C1328f.AN, AdPlacementType.BANNER),
    ANINTERSTITIAL(C4562k.class, C1328f.AN, AdPlacementType.INTERSTITIAL),
    ADMOBNATIVE(C4558d.class, C1328f.ADMOB, AdPlacementType.NATIVE),
    ANNATIVE(C4563m.class, C1328f.AN, AdPlacementType.NATIVE),
    ANNATIVEBANNER(C4563m.class, C1328f.AN, AdPlacementType.NATIVE_BANNER),
    ANINSTREAMVIDEO(C4561j.class, C1328f.AN, AdPlacementType.INSTREAM),
    ANREWARDEDVIDEO(C4564n.class, C1328f.AN, AdPlacementType.REWARDED_VIDEO),
    INMOBINATIVE(C4566r.class, C1328f.INMOBI, AdPlacementType.NATIVE),
    YAHOONATIVE(C4565o.class, C1328f.YAHOO, AdPlacementType.NATIVE);
    
    /* renamed from: n */
    private static List<C1329g> f3871n;
    /* renamed from: j */
    public Class<?> f3873j;
    /* renamed from: k */
    public String f3874k;
    /* renamed from: l */
    public C1328f f3875l;
    /* renamed from: m */
    public AdPlacementType f3876m;

    private C1329g(Class<?> cls, C1328f c1328f, AdPlacementType adPlacementType) {
        this.f3873j = cls;
        this.f3875l = c1328f;
        this.f3876m = adPlacementType;
    }

    /* renamed from: a */
    public static List<C1329g> m4600a() {
        if (f3871n == null) {
            synchronized (C1329g.class) {
                f3871n = new ArrayList();
                f3871n.add(ANBANNER);
                f3871n.add(ANINTERSTITIAL);
                f3871n.add(ANNATIVE);
                f3871n.add(ANNATIVEBANNER);
                f3871n.add(ANINSTREAMVIDEO);
                f3871n.add(ANREWARDEDVIDEO);
                if (C1344w.m4610a(C1328f.YAHOO)) {
                    f3871n.add(YAHOONATIVE);
                }
                if (C1344w.m4610a(C1328f.INMOBI)) {
                    f3871n.add(INMOBINATIVE);
                }
                if (C1344w.m4610a(C1328f.ADMOB)) {
                    f3871n.add(ADMOBNATIVE);
                }
            }
        }
        return f3871n;
    }
}
