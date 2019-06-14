package com.facebook.imagepipeline.animated.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import java.util.Arrays;

public class AnimatedDrawableUtil {
    private static final int FRAME_DURATION_MS_FOR_MIN = 100;
    private static final int MIN_FRAME_DURATION_MS = 11;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isOutsideRange(int r2, int r3, int r4) {
        /*
        r0 = -1;
        r1 = 1;
        if (r2 == r0) goto L_0x0016;
    L_0x0004:
        if (r3 != r0) goto L_0x0007;
    L_0x0006:
        goto L_0x0016;
    L_0x0007:
        r0 = 0;
        if (r2 > r3) goto L_0x0010;
    L_0x000a:
        if (r4 < r2) goto L_0x000e;
    L_0x000c:
        if (r4 <= r3) goto L_0x0015;
    L_0x000e:
        r0 = 1;
        goto L_0x0015;
    L_0x0010:
        if (r4 >= r2) goto L_0x0015;
    L_0x0012:
        if (r4 <= r3) goto L_0x0015;
    L_0x0014:
        goto L_0x000e;
    L_0x0015:
        return r0;
    L_0x0016:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil.isOutsideRange(int, int, int):boolean");
    }

    public void fixFrameDurations(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] < 11) {
                iArr[i] = 100;
            }
        }
    }

    public int getTotalDurationFromFrameDurations(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    public int[] getFrameTimeStampsFromDurations(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = i;
            i += iArr[i2];
        }
        return iArr2;
    }

    public int getFrameForTimestampMs(int[] iArr, int i) {
        iArr = Arrays.binarySearch(iArr, i);
        return iArr < null ? ((-iArr) - 1) - 1 : iArr;
    }

    @SuppressLint({"NewApi"})
    public int getSizeOfBitmap(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 19) {
            return bitmap.getAllocationByteCount();
        }
        if (VERSION.SDK_INT >= 12) {
            return bitmap.getByteCount();
        }
        return (bitmap.getWidth() * bitmap.getHeight()) * 4;
    }
}
