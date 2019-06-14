package com.facebook.ads.internal.p105q.p109d;

import android.content.Context;
import com.facebook.ads.internal.p091f.C1380e;
import com.facebook.ads.internal.p094i.C1394c;
import com.facebook.ads.internal.p097l.C1405a;
import java.util.Map;
import java.util.Set;

/* renamed from: com.facebook.ads.internal.q.d.a */
public class C1540a {
    /* renamed from: a */
    public static void m5396a(Context context, String str, int i, Exception exception) {
        if (C1540a.m5397a(context, str, i, Math.random())) {
            C1540a.m5398b(context, str, i, exception);
        }
    }

    /* renamed from: a */
    static boolean m5397a(Context context, String str, int i, double d) {
        double k;
        double d2;
        Set i2 = C1405a.m4828i(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(i);
        if (i2.contains(stringBuilder.toString())) {
            k = (double) (C1405a.m4830k(context) * C1405a.m4829j(context));
            d2 = 10000.0d;
        } else {
            k = (double) C1405a.m4830k(context);
            d2 = 100.0d;
        }
        return d >= 1.0d - (k / d2);
    }

    /* renamed from: b */
    private static void m5398b(Context context, String str, int i, Exception exception) {
        Map b = new C1394c(context, false).m4791b();
        b.put("subtype", str);
        b.put("subtype_code", String.valueOf(i));
        C1380e.m4718a(exception, context, b);
    }
}
