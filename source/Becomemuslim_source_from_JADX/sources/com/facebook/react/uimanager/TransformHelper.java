package com.facebook.react.uimanager;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

public class TransformHelper {
    private static ThreadLocal<double[]> sHelperMatrix = new C19661();

    /* renamed from: com.facebook.react.uimanager.TransformHelper$1 */
    static class C19661 extends ThreadLocal<double[]> {
        C19661() {
        }

        protected double[] initialValue() {
            return new double[16];
        }
    }

    private static double convertToRadians(ReadableMap readableMap, String str) {
        Object obj = 1;
        if (readableMap.getType(str) == ReadableType.String) {
            readableMap = readableMap.getString(str);
            if (readableMap.endsWith("rad") != null) {
                readableMap = readableMap.substring(0, readableMap.length() - 3);
            } else if (readableMap.endsWith("deg") != null) {
                readableMap = readableMap.substring(0, readableMap.length() - 3);
                obj = null;
            }
            readableMap = (double) Float.parseFloat(readableMap);
        } else {
            readableMap = readableMap.getDouble(str);
        }
        return obj != null ? readableMap : MatrixMathHelper.degreesToRadians(readableMap);
    }

    public static void processTransform(ReadableArray readableArray, double[] dArr) {
        double[] dArr2 = (double[]) sHelperMatrix.get();
        MatrixMathHelper.resetIdentityMatrix(dArr);
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            ReadableMap map = readableArray.getMap(i);
            String nextKey = map.keySetIterator().nextKey();
            MatrixMathHelper.resetIdentityMatrix(dArr2);
            ReadableArray array;
            if ("matrix".equals(nextKey)) {
                array = map.getArray(nextKey);
                for (int i2 = 0; i2 < 16; i2++) {
                    dArr2[i2] = array.getDouble(i2);
                }
            } else if ("perspective".equals(nextKey)) {
                MatrixMathHelper.applyPerspective(dArr2, map.getDouble(nextKey));
            } else if ("rotateX".equals(nextKey)) {
                MatrixMathHelper.applyRotateX(dArr2, convertToRadians(map, nextKey));
            } else if ("rotateY".equals(nextKey)) {
                MatrixMathHelper.applyRotateY(dArr2, convertToRadians(map, nextKey));
            } else {
                if (!"rotate".equals(nextKey)) {
                    if (!"rotateZ".equals(nextKey)) {
                        if ("scale".equals(nextKey)) {
                            double d = map.getDouble(nextKey);
                            MatrixMathHelper.applyScaleX(dArr2, d);
                            MatrixMathHelper.applyScaleY(dArr2, d);
                        } else if ("scaleX".equals(nextKey)) {
                            MatrixMathHelper.applyScaleX(dArr2, map.getDouble(nextKey));
                        } else if ("scaleY".equals(nextKey)) {
                            MatrixMathHelper.applyScaleY(dArr2, map.getDouble(nextKey));
                        } else {
                            double d2 = 0.0d;
                            if ("translate".equals(nextKey)) {
                                array = map.getArray(nextKey);
                                double d3 = array.getDouble(0);
                                double d4 = array.getDouble(1);
                                if (array.size() > 2) {
                                    d2 = array.getDouble(2);
                                }
                                MatrixMathHelper.applyTranslate3D(dArr2, d3, d4, d2);
                            } else if ("translateX".equals(nextKey)) {
                                MatrixMathHelper.applyTranslate2D(dArr2, map.getDouble(nextKey), 0.0d);
                            } else if ("translateY".equals(nextKey)) {
                                MatrixMathHelper.applyTranslate2D(dArr2, 0.0d, map.getDouble(nextKey));
                            } else if ("skewX".equals(nextKey)) {
                                MatrixMathHelper.applySkewX(dArr2, convertToRadians(map, nextKey));
                            } else if ("skewY".equals(nextKey)) {
                                MatrixMathHelper.applySkewY(dArr2, convertToRadians(map, nextKey));
                            } else {
                                dArr = new StringBuilder();
                                dArr.append("Unsupported transform type: ");
                                dArr.append(nextKey);
                                throw new JSApplicationIllegalArgumentException(dArr.toString());
                            }
                        }
                    }
                }
                MatrixMathHelper.applyRotateZ(dArr2, convertToRadians(map, nextKey));
            }
            MatrixMathHelper.multiplyInto(dArr, dArr, dArr2);
        }
    }
}
