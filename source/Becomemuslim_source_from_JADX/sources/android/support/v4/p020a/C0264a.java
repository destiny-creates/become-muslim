package android.support.v4.p020a;

import android.graphics.Color;
import com.facebook.imageutils.JfifUtil;

/* compiled from: ColorUtils */
/* renamed from: android.support.v4.a.a */
public final class C0264a {
    /* renamed from: a */
    private static final ThreadLocal<double[]> f666a = new ThreadLocal();

    /* renamed from: a */
    public static int m714a(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int c = C0264a.m718c(alpha2, alpha);
        return Color.argb(c, C0264a.m716a(Color.red(i), alpha2, Color.red(i2), alpha, c), C0264a.m716a(Color.green(i), alpha2, Color.green(i2), alpha, c), C0264a.m716a(Color.blue(i), alpha2, Color.blue(i2), alpha, c));
    }

    /* renamed from: c */
    private static int m718c(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / JfifUtil.MARKER_FIRST_BYTE);
    }

    /* renamed from: a */
    private static int m716a(int i, int i2, int i3, int i4, int i5) {
        return i5 == 0 ? 0 : (((i * JfifUtil.MARKER_FIRST_BYTE) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * JfifUtil.MARKER_FIRST_BYTE);
    }

    /* renamed from: b */
    public static int m717b(int i, int i2) {
        if (i2 >= 0 && i2 <= JfifUtil.MARKER_FIRST_BYTE) {
            return (i & 16777215) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    /* renamed from: a */
    public static int m715a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((((float) Color.blue(i)) * f2) + (((float) Color.blue(i2)) * f)));
    }
}
