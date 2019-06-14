package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

class InterpolationAnimatedNode extends ValueAnimatedNode {
    public static final String EXTRAPOLATE_TYPE_CLAMP = "clamp";
    public static final String EXTRAPOLATE_TYPE_EXTEND = "extend";
    public static final String EXTRAPOLATE_TYPE_IDENTITY = "identity";
    private final String mExtrapolateLeft;
    private final String mExtrapolateRight;
    private final double[] mInputRange;
    private final double[] mOutputRange;
    private ValueAnimatedNode mParent;

    private static double[] fromDoubleArray(ReadableArray readableArray) {
        double[] dArr = new double[readableArray.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = readableArray.getDouble(i);
        }
        return dArr;
    }

    private static double interpolate(double d, double d2, double d3, double d4, double d5, String str, String str2) {
        double d6;
        StringBuilder stringBuilder;
        String str3 = str;
        String str4 = str2;
        Object obj = null;
        if (d < d2) {
            Object obj2;
            int hashCode = str.hashCode();
            if (hashCode != -1289044198) {
                if (hashCode != -135761730) {
                    if (hashCode == 94742715) {
                        if (str3.equals(EXTRAPOLATE_TYPE_CLAMP)) {
                            obj2 = 1;
                            switch (obj2) {
                                case null:
                                    return d;
                                case 1:
                                    d6 = d2;
                                    break;
                                case 2:
                                    break;
                                default:
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Invalid extrapolation type ");
                                    stringBuilder.append(str3);
                                    stringBuilder.append("for left extrapolation");
                                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
                            }
                        }
                    }
                } else if (str3.equals(EXTRAPOLATE_TYPE_IDENTITY)) {
                    obj2 = null;
                    switch (obj2) {
                        case null:
                            return d;
                        case 1:
                            d6 = d2;
                            break;
                        case 2:
                            break;
                        default:
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Invalid extrapolation type ");
                            stringBuilder.append(str3);
                            stringBuilder.append("for left extrapolation");
                            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
                    }
                }
            } else if (str3.equals(EXTRAPOLATE_TYPE_EXTEND)) {
                obj2 = 2;
                switch (obj2) {
                    case null:
                        return d;
                    case 1:
                        d6 = d2;
                        break;
                    case 2:
                        break;
                    default:
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid extrapolation type ");
                        stringBuilder.append(str3);
                        stringBuilder.append("for left extrapolation");
                        throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
                }
            }
            obj2 = -1;
            switch (obj2) {
                case null:
                    return d;
                case 1:
                    d6 = d2;
                    break;
                case 2:
                    break;
                default:
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid extrapolation type ");
                    stringBuilder.append(str3);
                    stringBuilder.append("for left extrapolation");
                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
            }
        }
        d6 = d;
        if (d6 > d3) {
            int hashCode2 = str2.hashCode();
            if (hashCode2 != -1289044198) {
                if (hashCode2 != -135761730) {
                    if (hashCode2 == 94742715) {
                        if (str4.equals(EXTRAPOLATE_TYPE_CLAMP)) {
                            obj = 1;
                            switch (obj) {
                                case null:
                                    return d6;
                                case 1:
                                    d6 = d3;
                                    break;
                                case 2:
                                    break;
                                default:
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Invalid extrapolation type ");
                                    stringBuilder.append(str4);
                                    stringBuilder.append("for right extrapolation");
                                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
                            }
                        }
                    }
                } else if (str4.equals(EXTRAPOLATE_TYPE_IDENTITY)) {
                    switch (obj) {
                        case null:
                            return d6;
                        case 1:
                            d6 = d3;
                            break;
                        case 2:
                            break;
                        default:
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Invalid extrapolation type ");
                            stringBuilder.append(str4);
                            stringBuilder.append("for right extrapolation");
                            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
                    }
                }
            } else if (str4.equals(EXTRAPOLATE_TYPE_EXTEND)) {
                obj = 2;
                switch (obj) {
                    case null:
                        return d6;
                    case 1:
                        d6 = d3;
                        break;
                    case 2:
                        break;
                    default:
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid extrapolation type ");
                        stringBuilder.append(str4);
                        stringBuilder.append("for right extrapolation");
                        throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
                }
            }
            obj = -1;
            switch (obj) {
                case null:
                    return d6;
                case 1:
                    d6 = d3;
                    break;
                case 2:
                    break;
                default:
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid extrapolation type ");
                    stringBuilder.append(str4);
                    stringBuilder.append("for right extrapolation");
                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
            }
        }
        return d4 + (((d5 - d4) * (d6 - d2)) / (d3 - d2));
    }

    static double interpolate(double d, double[] dArr, double[] dArr2, String str, String str2) {
        int findRangeIndex = findRangeIndex(d, dArr);
        int i = findRangeIndex + 1;
        return interpolate(d, dArr[findRangeIndex], dArr[i], dArr2[findRangeIndex], dArr2[i], str, str2);
    }

    private static int findRangeIndex(double d, double[] dArr) {
        int i = 1;
        while (i < dArr.length - 1) {
            if (dArr[i] >= d) {
                break;
            }
            i++;
        }
        return i - 1;
    }

    public InterpolationAnimatedNode(ReadableMap readableMap) {
        this.mInputRange = fromDoubleArray(readableMap.getArray("inputRange"));
        this.mOutputRange = fromDoubleArray(readableMap.getArray("outputRange"));
        this.mExtrapolateLeft = readableMap.getString("extrapolateLeft");
        this.mExtrapolateRight = readableMap.getString("extrapolateRight");
    }

    public void onAttachedToNode(AnimatedNode animatedNode) {
        if (this.mParent != null) {
            throw new IllegalStateException("Parent already attached");
        } else if (animatedNode instanceof ValueAnimatedNode) {
            this.mParent = (ValueAnimatedNode) animatedNode;
        } else {
            throw new IllegalArgumentException("Parent is of an invalid type");
        }
    }

    public void onDetachedFromNode(AnimatedNode animatedNode) {
        if (animatedNode == this.mParent) {
            this.mParent = null;
            return;
        }
        throw new IllegalArgumentException("Invalid parent node provided");
    }

    public void update() {
        if (this.mParent != null) {
            this.mValue = interpolate(this.mParent.getValue(), this.mInputRange, this.mOutputRange, this.mExtrapolateLeft, this.mExtrapolateRight);
        }
    }
}
