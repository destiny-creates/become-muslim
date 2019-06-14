package com.p050a.p051a;

import android.support.v4.p030f.C0397h;
import android.util.Log;

/* compiled from: L */
/* renamed from: com.a.a.d */
public class C0940d {
    /* renamed from: a */
    private static boolean f2618a = false;
    /* renamed from: b */
    private static String[] f2619b;
    /* renamed from: c */
    private static long[] f2620c;
    /* renamed from: d */
    private static int f2621d;
    /* renamed from: e */
    private static int f2622e;

    /* renamed from: a */
    public static void m3287a(String str) {
        Log.w("LOTTIE", str);
    }

    /* renamed from: b */
    public static void m3288b(String str) {
        if (!f2618a) {
            return;
        }
        if (f2621d == 20) {
            f2622e++;
            return;
        }
        f2619b[f2621d] = str;
        f2620c[f2621d] = System.nanoTime();
        C0397h.m1177a(str);
        f2621d++;
    }

    /* renamed from: c */
    public static float m3289c(String str) {
        if (f2622e > 0) {
            f2622e--;
            return 0.0f;
        } else if (!f2618a) {
            return 0.0f;
        } else {
            f2621d--;
            if (f2621d == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(f2619b[f2621d])) {
                C0397h.m1176a();
                return ((float) (System.nanoTime() - f2620c[f2621d])) / 1000000.0f;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unbalanced trace call ");
                stringBuilder.append(str);
                stringBuilder.append(". Expected ");
                stringBuilder.append(f2619b[f2621d]);
                stringBuilder.append(".");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }
}
