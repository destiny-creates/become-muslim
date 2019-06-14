package com.facebook.imagepipeline.common;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import java.util.Locale;

public class ResizeOptions {
    public static final float DEFAULT_ROUNDUP_FRACTION = 0.6666667f;
    public final int height;
    public final float maxBitmapSize;
    public final float roundUpFraction;
    public final int width;

    public static ResizeOptions forDimensions(int i, int i2) {
        if (i > 0) {
            if (i2 > 0) {
                return new ResizeOptions(i, i2);
            }
        }
        return 0;
    }

    public static ResizeOptions forSquareSize(int i) {
        return i <= 0 ? 0 : new ResizeOptions(i, i);
    }

    public ResizeOptions(int i, int i2) {
        this(i, i2, 2048.0f);
    }

    public ResizeOptions(int i, int i2, float f) {
        this(i, i2, f, 0.6666667f);
    }

    public ResizeOptions(int i, int i2, float f, float f2) {
        boolean z = false;
        Preconditions.checkArgument(i > 0);
        if (i2 > 0) {
            z = true;
        }
        Preconditions.checkArgument(z);
        this.width = i;
        this.height = i2;
        this.maxBitmapSize = f;
        this.roundUpFraction = f2;
    }

    public int hashCode() {
        return HashCodeUtil.hashCode(this.width, this.height);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResizeOptions)) {
            return false;
        }
        ResizeOptions resizeOptions = (ResizeOptions) obj;
        if (this.width != resizeOptions.width || this.height != resizeOptions.height) {
            z = false;
        }
        return z;
    }

    public String toString() {
        return String.format((Locale) null, "%dx%d", new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)});
    }
}
