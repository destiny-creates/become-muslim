package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;

@DoNotStrip
public class NativeBlurFilter {
    @DoNotStrip
    private static native void nativeIterativeBoxBlur(Bitmap bitmap, int i, int i2);

    static {
        ImagePipelineNativeLoader.load();
    }

    public static void iterativeBoxBlur(Bitmap bitmap, int i, int i2) {
        Preconditions.checkNotNull(bitmap);
        boolean z = false;
        Preconditions.checkArgument(i > 0);
        if (i2 > 0) {
            z = true;
        }
        Preconditions.checkArgument(z);
        nativeIterativeBoxBlur(bitmap, i, i2);
    }
}
