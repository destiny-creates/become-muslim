package com.facebook.react.common;

import java.util.Arrays;
import java.util.List;

public class ArrayUtils {
    public static float[] copyArray(float[] fArr) {
        return fArr == null ? null : Arrays.copyOf(fArr, fArr.length);
    }

    public static int[] copyListToArray(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = ((Integer) list.get(i)).intValue();
        }
        return iArr;
    }
}
