package com.facebook.react.uimanager;

import com.facebook.yoga.YogaConstants;
import java.util.Arrays;

public class Spacing {
    public static final int ALL = 8;
    public static final int BOTTOM = 3;
    public static final int END = 5;
    public static final int HORIZONTAL = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    public static final int START = 4;
    public static final int TOP = 1;
    public static final int VERTICAL = 7;
    private static final int[] sFlagsMap = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256};
    private final float mDefaultValue;
    private boolean mHasAliasesSet;
    private final float[] mSpacing;
    private int mValueFlags;

    public Spacing() {
        this(0.0f);
    }

    public Spacing(float f) {
        this.mValueFlags = 0;
        this.mDefaultValue = f;
        this.mSpacing = newFullSpacingArray();
    }

    public Spacing(Spacing spacing) {
        this.mValueFlags = 0;
        this.mDefaultValue = spacing.mDefaultValue;
        this.mSpacing = Arrays.copyOf(spacing.mSpacing, spacing.mSpacing.length);
        this.mValueFlags = spacing.mValueFlags;
        this.mHasAliasesSet = spacing.mHasAliasesSet;
    }

    public boolean set(int i, float f) {
        boolean z = false;
        if (FloatUtil.floatsEqual(this.mSpacing[i], f)) {
            return false;
        }
        this.mSpacing[i] = f;
        if (YogaConstants.isUndefined(f) != null) {
            this.mValueFlags = (~sFlagsMap[i]) & this.mValueFlags;
        } else {
            this.mValueFlags = sFlagsMap[i] | this.mValueFlags;
        }
        if (!((this.mValueFlags & sFlagsMap[8]) == 0 && (this.mValueFlags & sFlagsMap[7]) == 0 && (this.mValueFlags & sFlagsMap[6]) == 0)) {
            z = true;
        }
        this.mHasAliasesSet = z;
        return true;
    }

    public float get(int i) {
        float f;
        if (i != 4) {
            if (i != 5) {
                f = this.mDefaultValue;
                if (this.mValueFlags == 0) {
                    return f;
                }
                if ((this.mValueFlags & sFlagsMap[i]) != 0) {
                    return this.mSpacing[i];
                }
                if (this.mHasAliasesSet) {
                    if (i != 1) {
                        if (i == 3) {
                            i = 6;
                            if ((this.mValueFlags & sFlagsMap[i]) == 0) {
                                return this.mSpacing[i];
                            }
                            if ((this.mValueFlags & sFlagsMap[8]) != 0) {
                                return this.mSpacing[8];
                            }
                        }
                    }
                    i = 7;
                    if ((this.mValueFlags & sFlagsMap[i]) == 0) {
                        return this.mSpacing[i];
                    }
                    if ((this.mValueFlags & sFlagsMap[8]) != 0) {
                        return this.mSpacing[8];
                    }
                }
                return f;
            }
        }
        f = 1.0E21f;
        if (this.mValueFlags == 0) {
            return f;
        }
        if ((this.mValueFlags & sFlagsMap[i]) != 0) {
            return this.mSpacing[i];
        }
        if (this.mHasAliasesSet) {
            if (i != 1) {
                if (i == 3) {
                    i = 6;
                    if ((this.mValueFlags & sFlagsMap[i]) == 0) {
                        return this.mSpacing[i];
                    }
                    if ((this.mValueFlags & sFlagsMap[8]) != 0) {
                        return this.mSpacing[8];
                    }
                }
            }
            i = 7;
            if ((this.mValueFlags & sFlagsMap[i]) == 0) {
                return this.mSpacing[i];
            }
            if ((this.mValueFlags & sFlagsMap[8]) != 0) {
                return this.mSpacing[8];
            }
        }
        return f;
    }

    public float getRaw(int i) {
        return this.mSpacing[i];
    }

    public void reset() {
        Arrays.fill(this.mSpacing, 1.0E21f);
        this.mHasAliasesSet = false;
        this.mValueFlags = 0;
    }

    float getWithFallback(int i, int i2) {
        if ((this.mValueFlags & sFlagsMap[i]) != 0) {
            return this.mSpacing[i];
        }
        return get(i2);
    }

    private static float[] newFullSpacingArray() {
        return new float[]{1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f};
    }
}
