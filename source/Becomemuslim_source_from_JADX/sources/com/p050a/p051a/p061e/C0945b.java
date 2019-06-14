package com.p050a.p051a.p061e;

import com.facebook.imageutils.JfifUtil;

/* compiled from: GammaEvaluator */
/* renamed from: com.a.a.e.b */
public class C0945b {
    /* renamed from: a */
    private static float m3297a(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow((double) f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    /* renamed from: b */
    private static float m3299b(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((double) ((f + 0.055f) / 1.055f), 2.4000000953674316d);
    }

    /* renamed from: a */
    public static int m3298a(float f, int i, int i2) {
        float f2 = ((float) ((i >> 24) & JfifUtil.MARKER_FIRST_BYTE)) / 255.0f;
        float f3 = ((float) ((i >> 8) & JfifUtil.MARKER_FIRST_BYTE)) / 255.0f;
        i = ((float) (i & JfifUtil.MARKER_FIRST_BYTE)) / 1132396544;
        float f4 = ((float) ((i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE)) / 255.0f;
        float f5 = ((float) ((i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE)) / 255.0f;
        float f6 = ((float) ((i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE)) / 255.0f;
        i2 = ((float) (i2 & JfifUtil.MARKER_FIRST_BYTE)) / 1132396544;
        float b = C0945b.m3299b(((float) ((i >> 16) & JfifUtil.MARKER_FIRST_BYTE)) / 255.0f);
        f3 = C0945b.m3299b(f3);
        i = C0945b.m3299b(i);
        f5 = C0945b.m3299b(f5);
        f3 += (C0945b.m3299b(f6) - f3) * f;
        i += f * (C0945b.m3299b(i2) - i);
        f2 = (f2 + ((f4 - f2) * f)) * 255.0f;
        return (((Math.round(C0945b.m3297a(b + ((f5 - b) * f)) * 255.0f) << 16) | (Math.round(f2) << 24)) | (Math.round(C0945b.m3297a(f3) * 1132396544) << 8)) | Math.round(C0945b.m3297a(i) * 1132396544);
    }
}
