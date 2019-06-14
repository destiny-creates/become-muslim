package com.facebook.yoga;

public class YogaMeasureOutput {
    public static long make(float f, float f2) {
        f = Float.floatToRawIntBits(f);
        return ((long) Float.floatToRawIntBits(f2)) | (((long) f) << 4.5E-44f);
    }

    public static long make(int i, int i2) {
        return make((float) i, (float) i2);
    }

    public static float getWidth(long j) {
        return Float.intBitsToFloat((int) ((j >> 32) & -1));
    }

    public static float getHeight(long j) {
        return Float.intBitsToFloat((int) (j & -1));
    }
}
