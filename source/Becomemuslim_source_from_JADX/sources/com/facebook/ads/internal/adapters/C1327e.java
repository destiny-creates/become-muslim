package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.p105q.p106a.C1521u;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.facebook.ads.internal.adapters.e */
public class C1327e {
    /* renamed from: a */
    private static final Set<C1329g> f3854a = new HashSet();
    /* renamed from: b */
    private static final Map<AdPlacementType, String> f3855b = new ConcurrentHashMap();

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = new java.util.HashSet;
        r0.<init>();
        f3854a = r0;
        r0 = new java.util.concurrent.ConcurrentHashMap;
        r0.<init>();
        f3855b = r0;
        r0 = com.facebook.ads.internal.adapters.C1329g.m4600a();
        r0 = r0.iterator();
    L_0x0016:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x005a;
    L_0x001c:
        r1 = r0.next();
        r1 = (com.facebook.ads.internal.adapters.C1329g) r1;
        r2 = 0;
        r3 = com.facebook.ads.internal.adapters.C1327e.C13261.f3853a;
        r4 = r1.f3876m;
        r4 = r4.ordinal();
        r3 = r3[r4];
        switch(r3) {
            case 1: goto L_0x003d;
            case 2: goto L_0x003a;
            case 3: goto L_0x0037;
            case 4: goto L_0x0037;
            case 5: goto L_0x0034;
            case 6: goto L_0x0031;
            default: goto L_0x0030;
        };
    L_0x0030:
        goto L_0x003f;
    L_0x0031:
        r2 = com.facebook.ads.internal.adapters.ab.class;
        goto L_0x003f;
    L_0x0034:
        r2 = com.facebook.ads.internal.adapters.C3570s.class;
        goto L_0x003f;
    L_0x0037:
        r2 = com.facebook.ads.internal.adapters.C3572y.class;
        goto L_0x003f;
    L_0x003a:
        r2 = com.facebook.ads.internal.adapters.InterstitialAdapter.class;
        goto L_0x003f;
    L_0x003d:
        r2 = com.facebook.ads.internal.adapters.BannerAdapter.class;
    L_0x003f:
        if (r2 == 0) goto L_0x0016;
    L_0x0041:
        r3 = r1.f3873j;
        if (r3 != 0) goto L_0x004c;
    L_0x0045:
        r4 = r1.f3874k;	 Catch:{ ClassNotFoundException -> 0x004c }
        r4 = java.lang.Class.forName(r4);	 Catch:{ ClassNotFoundException -> 0x004c }
        r3 = r4;
    L_0x004c:
        if (r3 == 0) goto L_0x0016;
    L_0x004e:
        r2 = r2.isAssignableFrom(r3);
        if (r2 == 0) goto L_0x0016;
    L_0x0054:
        r2 = f3854a;
        r2.add(r1);
        goto L_0x0016;
    L_0x005a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.e.<clinit>():void");
    }

    /* renamed from: a */
    public static AdAdapter m4595a(C1328f c1328f, AdPlacementType adPlacementType) {
        Exception exception;
        AdAdapter adAdapter = null;
        try {
            C1329g b = C1327e.m4598b(c1328f, adPlacementType);
            if (b != null && f3854a.contains(b)) {
                Class cls = b.f3873j;
                if (cls == null) {
                    cls = Class.forName(b.f3874k);
                }
                AdAdapter adAdapter2 = (AdAdapter) cls.newInstance();
                try {
                    if (!(adAdapter2 instanceof C4563m)) {
                        return adAdapter2;
                    }
                    ((C4563m) adAdapter2).m11607a(adPlacementType);
                    return adAdapter2;
                } catch (Exception e) {
                    adAdapter = adAdapter2;
                    exception = e;
                    exception.printStackTrace();
                    return adAdapter;
                }
            }
        } catch (Exception e2) {
            exception = e2;
            exception.printStackTrace();
            return adAdapter;
        }
        return adAdapter;
    }

    /* renamed from: a */
    public static AdAdapter m4596a(String str, AdPlacementType adPlacementType) {
        return C1327e.m4595a(C1328f.m4599a(str), adPlacementType);
    }

    /* renamed from: a */
    public static String m4597a(AdPlacementType adPlacementType) {
        if (f3855b.containsKey(adPlacementType)) {
            return (String) f3855b.get(adPlacementType);
        }
        Set hashSet = new HashSet();
        for (C1329g c1329g : f3854a) {
            if (c1329g.f3876m == adPlacementType) {
                hashSet.add(c1329g.f3875l.toString());
            }
        }
        String a = C1521u.m5336a(hashSet, ",");
        f3855b.put(adPlacementType, a);
        return a;
    }

    /* renamed from: b */
    private static C1329g m4598b(C1328f c1328f, AdPlacementType adPlacementType) {
        for (C1329g c1329g : f3854a) {
            if (c1329g.f3875l == c1328f && c1329g.f3876m == adPlacementType) {
                return c1329g;
            }
        }
        return null;
    }
}
