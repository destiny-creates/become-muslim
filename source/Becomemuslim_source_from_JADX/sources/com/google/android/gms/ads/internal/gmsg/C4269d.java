package com.google.android.gms.ads.internal.gmsg;

import com.facebook.ads.internal.p088c.C1354a;
import com.google.android.gms.ads.internal.bv;
import com.google.android.gms.common.util.C2896f;
import com.google.android.gms.internal.ads.C4926f;
import com.google.android.gms.internal.ads.C4934o;
import com.google.android.gms.internal.ads.C6763d;
import com.google.android.gms.internal.ads.C6764g;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.bfb;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.qo;
import java.util.Map;

@cm
/* renamed from: com.google.android.gms.ads.internal.gmsg.d */
public final class C4269d implements ae<qo> {
    /* renamed from: d */
    private static final Map<String, Integer> f11285d = C2896f.m8434a(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7)});
    /* renamed from: a */
    private final bv f11286a;
    /* renamed from: b */
    private final C6763d f11287b;
    /* renamed from: c */
    private final C4934o f11288c;

    public C4269d(bv bvVar, C6763d c6763d, C4934o c4934o) {
        this.f11286a = bvVar;
        this.f11287b = c6763d;
        this.f11288c = c4934o;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        qo qoVar = (qo) obj;
        int intValue = ((Integer) f11285d.get((String) map.get(C1354a.f3934a))).intValue();
        if (intValue != 5 && intValue != 7 && this.f11286a != null && !this.f11286a.m7508b()) {
            this.f11286a.m7507a(null);
        } else if (intValue != 1) {
            switch (intValue) {
                case 3:
                    new C6764g(qoVar, map).a();
                    return;
                case 4:
                    new bfb(qoVar, map).a();
                    return;
                case 5:
                    new C4926f(qoVar, map).a();
                    return;
                case 6:
                    this.f11287b.a(true);
                    return;
                case 7:
                    if (((Boolean) aph.f().a(asp.f14922M)).booleanValue()) {
                        this.f11288c.K();
                        break;
                    }
                    break;
                default:
                    jn.d("Unknown MRAID command called.");
                    break;
            }
        } else {
            this.f11287b.a(map);
        }
    }
}
