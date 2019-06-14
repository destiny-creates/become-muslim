package com.facebook.react.uimanager;

import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.lang.reflect.Array;

public class MatrixMathHelper {
    private static final double EPSILON = 1.0E-5d;

    public static class MatrixDecompositionContext {
        double[] perspective = new double[4];
        double[] rotationDegrees = new double[3];
        double[] scale = new double[3];
        double[] skew = new double[3];
        double[] translation = new double[3];
    }

    public static double degreesToRadians(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    private static boolean isZero(double d) {
        boolean z = false;
        if (Double.isNaN(d)) {
            return false;
        }
        if (Math.abs(d) < EPSILON) {
            z = true;
        }
        return z;
    }

    public static void multiplyInto(double[] dArr, double[] dArr2, double[] dArr3) {
        double d = dArr2[0];
        double d2 = dArr2[1];
        double d3 = dArr2[2];
        double d4 = dArr2[3];
        double d5 = dArr2[4];
        double d6 = dArr2[5];
        double d7 = dArr2[6];
        double d8 = dArr2[7];
        double d9 = dArr2[8];
        double d10 = dArr2[9];
        double d11 = dArr2[10];
        double d12 = dArr2[11];
        double d13 = dArr2[12];
        double d14 = dArr2[13];
        double d15 = dArr2[14];
        double d16 = dArr2[15];
        double d17 = dArr3[0];
        double d18 = dArr3[1];
        double d19 = dArr3[2];
        double d20 = dArr3[3];
        dArr[0] = (((d17 * d) + (d18 * d5)) + (d19 * d9)) + (d20 * d13);
        dArr[1] = (((d17 * d2) + (d18 * d6)) + (d19 * d10)) + (d20 * d14);
        dArr[2] = (((d17 * d3) + (d18 * d7)) + (d19 * d11)) + (d20 * d15);
        dArr[3] = (((d17 * d4) + (d18 * d8)) + (d19 * d12)) + (d20 * d16);
        d17 = dArr3[4];
        d18 = dArr3[5];
        d19 = dArr3[6];
        d20 = dArr3[7];
        dArr[4] = (((d17 * d) + (d18 * d5)) + (d19 * d9)) + (d20 * d13);
        dArr[5] = (((d17 * d2) + (d18 * d6)) + (d19 * d10)) + (d20 * d14);
        dArr[6] = (((d17 * d3) + (d18 * d7)) + (d19 * d11)) + (d20 * d15);
        dArr[7] = (((d17 * d4) + (d18 * d8)) + (d19 * d12)) + (d20 * d16);
        d17 = dArr3[8];
        d18 = dArr3[9];
        d19 = dArr3[10];
        d20 = dArr3[11];
        dArr[8] = (((d17 * d) + (d18 * d5)) + (d19 * d9)) + (d20 * d13);
        dArr[9] = (((d17 * d2) + (d18 * d6)) + (d19 * d10)) + (d20 * d14);
        dArr[10] = (((d17 * d3) + (d18 * d7)) + (d19 * d11)) + (d20 * d15);
        dArr[11] = (((d17 * d4) + (d18 * d8)) + (d19 * d12)) + (d20 * d16);
        d17 = dArr3[12];
        d18 = dArr3[13];
        d19 = dArr3[14];
        double d21 = dArr3[15];
        dArr[12] = (((d * d17) + (d5 * d18)) + (d9 * d19)) + (d13 * d21);
        dArr[13] = (((d2 * d17) + (d6 * d18)) + (d10 * d19)) + (d14 * d21);
        dArr[14] = (((d3 * d17) + (d7 * d18)) + (d11 * d19)) + (d15 * d21);
        dArr[15] = (((d17 * d4) + (d18 * d8)) + (d19 * d12)) + (d21 * d16);
    }

    public static void decomposeMatrix(double[] dArr, MatrixDecompositionContext matrixDecompositionContext) {
        double[] dArr2 = dArr;
        MatrixDecompositionContext matrixDecompositionContext2 = matrixDecompositionContext;
        Assertions.assertCondition(dArr2.length == 16);
        double[] dArr3 = matrixDecompositionContext2.perspective;
        double[] dArr4 = matrixDecompositionContext2.scale;
        double[] dArr5 = matrixDecompositionContext2.skew;
        double[] dArr6 = matrixDecompositionContext2.translation;
        double[] dArr7 = matrixDecompositionContext2.rotationDegrees;
        if (!isZero(dArr2[15])) {
            double[][] dArr8 = (double[][]) Array.newInstance(double.class, new int[]{4, 4});
            double[] dArr9 = new double[16];
            for (int i = 0; i < 4; i++) {
                for (int i2 = 0; i2 < 4; i2++) {
                    int i3 = (i * 4) + i2;
                    double d = dArr2[i3] / dArr2[15];
                    dArr8[i][i2] = d;
                    if (i2 == 3) {
                        d = 0.0d;
                    }
                    dArr9[i3] = d;
                }
            }
            dArr9[15] = 1.0d;
            if (!isZero(determinant(dArr9))) {
                int i4;
                double[][] dArr10;
                int i5;
                if (isZero(dArr8[0][3]) && isZero(dArr8[1][3])) {
                    if (isZero(dArr8[2][3])) {
                        dArr3[2] = 0.0d;
                        dArr3[1] = 0.0d;
                        dArr3[0] = 0.0d;
                        dArr3[3] = 1.0d;
                        for (i4 = 0; i4 < 3; i4++) {
                            dArr6[i4] = dArr8[3][i4];
                        }
                        dArr10 = (double[][]) Array.newInstance(double.class, new int[]{3, 3});
                        for (i5 = 0; i5 < 3; i5++) {
                            dArr10[i5][0] = dArr8[i5][0];
                            dArr10[i5][1] = dArr8[i5][1];
                            dArr10[i5][2] = dArr8[i5][2];
                        }
                        dArr4[0] = v3Length(dArr10[0]);
                        dArr10[0] = v3Normalize(dArr10[0], dArr4[0]);
                        dArr5[0] = v3Dot(dArr10[0], dArr10[1]);
                        dArr10[1] = v3Combine(dArr10[1], dArr10[0], 1.0d, -dArr5[0]);
                        dArr5[0] = v3Dot(dArr10[0], dArr10[1]);
                        dArr10[1] = v3Combine(dArr10[1], dArr10[0], 1.0d, -dArr5[0]);
                        dArr4[1] = v3Length(dArr10[1]);
                        dArr10[1] = v3Normalize(dArr10[1], dArr4[1]);
                        dArr5[0] = dArr5[0] / dArr4[1];
                        dArr5[1] = v3Dot(dArr10[0], dArr10[2]);
                        dArr10[2] = v3Combine(dArr10[2], dArr10[0], 1.0d, -dArr5[1]);
                        dArr5[2] = v3Dot(dArr10[1], dArr10[2]);
                        dArr10[2] = v3Combine(dArr10[2], dArr10[1], 1.0d, -dArr5[2]);
                        dArr4[2] = v3Length(dArr10[2]);
                        dArr10[2] = v3Normalize(dArr10[2], dArr4[2]);
                        dArr5[1] = dArr5[1] / dArr4[2];
                        dArr5[2] = dArr5[2] / dArr4[2];
                        if (v3Dot(dArr10[0], v3Cross(dArr10[1], dArr10[2])) < 0.0d) {
                            for (i5 = 0; i5 < 3; i5++) {
                                dArr4[i5] = dArr4[i5] * -1.0d;
                                dArr9 = dArr10[i5];
                                dArr9[0] = dArr9[0] * -1.0d;
                                dArr9 = dArr10[i5];
                                dArr9[1] = dArr9[1] * -1.0d;
                                dArr9 = dArr10[i5];
                                dArr9[2] = dArr9[2] * -1.0d;
                            }
                        }
                        dArr7[0] = roundTo3Places((-Math.atan2(dArr10[2][1], dArr10[2][2])) * 57.29577951308232d);
                        dArr7[1] = roundTo3Places((-Math.atan2(-dArr10[2][0], Math.sqrt((dArr10[2][1] * dArr10[2][1]) + (dArr10[2][2] * dArr10[2][2])))) * 57.29577951308232d);
                        dArr7[2] = roundTo3Places((-Math.atan2(dArr10[1][0], dArr10[0][0])) * 57.29577951308232d);
                    }
                }
                multiplyVectorByMatrix(new double[]{dArr8[0][3], dArr8[1][3], dArr8[2][3], dArr8[3][3]}, transpose(inverse(dArr9)), dArr3);
                for (i4 = 0; i4 < 3; i4++) {
                    dArr6[i4] = dArr8[3][i4];
                }
                dArr10 = (double[][]) Array.newInstance(double.class, new int[]{3, 3});
                for (i5 = 0; i5 < 3; i5++) {
                    dArr10[i5][0] = dArr8[i5][0];
                    dArr10[i5][1] = dArr8[i5][1];
                    dArr10[i5][2] = dArr8[i5][2];
                }
                dArr4[0] = v3Length(dArr10[0]);
                dArr10[0] = v3Normalize(dArr10[0], dArr4[0]);
                dArr5[0] = v3Dot(dArr10[0], dArr10[1]);
                dArr10[1] = v3Combine(dArr10[1], dArr10[0], 1.0d, -dArr5[0]);
                dArr5[0] = v3Dot(dArr10[0], dArr10[1]);
                dArr10[1] = v3Combine(dArr10[1], dArr10[0], 1.0d, -dArr5[0]);
                dArr4[1] = v3Length(dArr10[1]);
                dArr10[1] = v3Normalize(dArr10[1], dArr4[1]);
                dArr5[0] = dArr5[0] / dArr4[1];
                dArr5[1] = v3Dot(dArr10[0], dArr10[2]);
                dArr10[2] = v3Combine(dArr10[2], dArr10[0], 1.0d, -dArr5[1]);
                dArr5[2] = v3Dot(dArr10[1], dArr10[2]);
                dArr10[2] = v3Combine(dArr10[2], dArr10[1], 1.0d, -dArr5[2]);
                dArr4[2] = v3Length(dArr10[2]);
                dArr10[2] = v3Normalize(dArr10[2], dArr4[2]);
                dArr5[1] = dArr5[1] / dArr4[2];
                dArr5[2] = dArr5[2] / dArr4[2];
                if (v3Dot(dArr10[0], v3Cross(dArr10[1], dArr10[2])) < 0.0d) {
                    for (i5 = 0; i5 < 3; i5++) {
                        dArr4[i5] = dArr4[i5] * -1.0d;
                        dArr9 = dArr10[i5];
                        dArr9[0] = dArr9[0] * -1.0d;
                        dArr9 = dArr10[i5];
                        dArr9[1] = dArr9[1] * -1.0d;
                        dArr9 = dArr10[i5];
                        dArr9[2] = dArr9[2] * -1.0d;
                    }
                }
                dArr7[0] = roundTo3Places((-Math.atan2(dArr10[2][1], dArr10[2][2])) * 57.29577951308232d);
                dArr7[1] = roundTo3Places((-Math.atan2(-dArr10[2][0], Math.sqrt((dArr10[2][1] * dArr10[2][1]) + (dArr10[2][2] * dArr10[2][2])))) * 57.29577951308232d);
                dArr7[2] = roundTo3Places((-Math.atan2(dArr10[1][0], dArr10[0][0])) * 57.29577951308232d);
            }
        }
    }

    public static double determinant(double[] dArr) {
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        double d5 = dArr[4];
        double d6 = dArr[5];
        double d7 = dArr[6];
        double d8 = dArr[7];
        double d9 = dArr[8];
        double d10 = dArr[9];
        double d11 = dArr[10];
        double d12 = dArr[11];
        double d13 = dArr[12];
        double d14 = dArr[13];
        double d15 = dArr[14];
        double d16 = dArr[15];
        double d17 = d4 * d7;
        double d18 = d3 * d8;
        double d19 = d4 * d6;
        double d20 = d2 * d8;
        double d21 = d3 * d6;
        double d22 = d2 * d7;
        d4 *= d5;
        d8 *= d;
        d3 *= d5;
        d7 *= d;
        d2 *= d5;
        d *= d6;
        return ((((((((((((((((((((((((d17 * d10) * d13) - ((d18 * d10) * d13)) - ((d19 * d11) * d13)) + ((d20 * d11) * d13)) + ((d21 * d12) * d13)) - ((d22 * d12) * d13)) - ((d17 * d9) * d14)) + ((d18 * d9) * d14)) + ((d4 * d11) * d14)) - ((d8 * d11) * d14)) - ((d3 * d12) * d14)) + ((d7 * d12) * d14)) + ((d19 * d9) * d15)) - ((d20 * d9) * d15)) - ((d4 * d10) * d15)) + ((d8 * d10) * d15)) + ((d2 * d12) * d15)) - ((d12 * d) * d15)) - ((d21 * d9) * d16)) + ((d22 * d9) * d16)) + ((d3 * d10) * d16)) - ((d7 * d10) * d16)) - ((d2 * d11) * d16)) + ((d * d11) * d16);
    }

    public static double[] inverse(double[] dArr) {
        double determinant = determinant(dArr);
        if (isZero(determinant)) {
            return dArr;
        }
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        double d5 = dArr[4];
        double d6 = dArr[5];
        double d7 = dArr[6];
        double d8 = dArr[7];
        double d9 = dArr[8];
        double d10 = dArr[9];
        double d11 = dArr[10];
        double d12 = dArr[11];
        double d13 = dArr[12];
        double d14 = dArr[13];
        double d15 = dArr[14];
        double d16 = dArr[15];
        double[] dArr2 = new double[16];
        double d17 = d7 * d12;
        double d18 = d8 * d11;
        double d19 = d8 * d10;
        double d20 = d6 * d12;
        double d21 = d7 * d10;
        double d22 = d6 * d11;
        dArr2[0] = ((((((d17 * d14) - (d18 * d14)) + (d19 * d15)) - (d20 * d15)) - (d21 * d16)) + (d22 * d16)) / determinant;
        double d23 = d4 * d11;
        double d24 = d3 * d12;
        double d25 = d4 * d10;
        double d26 = d2 * d12;
        double d27 = d3 * d10;
        double d28 = d2 * d11;
        dArr2[1] = ((((((d23 * d14) - (d24 * d14)) - (d25 * d15)) + (d26 * d15)) + (d27 * d16)) - (d28 * d16)) / determinant;
        double d29 = d3 * d8;
        double d30 = d4 * d7;
        double d31 = d4 * d6;
        double d32 = d2 * d8;
        double d33 = d3 * d6;
        double d34 = d2 * d7;
        dArr2[2] = ((((((d29 * d14) - (d30 * d14)) + (d31 * d15)) - (d32 * d15)) - (d33 * d16)) + (d34 * d16)) / determinant;
        dArr2[3] = ((((((d30 * d10) - (d29 * d10)) - (d31 * d11)) + (d32 * d11)) + (d33 * d12)) - (d34 * d12)) / determinant;
        d18 = (d18 * d13) - (d17 * d13);
        d17 = d8 * d9;
        double d35 = d5 * d12;
        double d36 = d7 * d9;
        double d37 = d5 * d11;
        dArr2[4] = ((((d18 - (d17 * d15)) + (d35 * d15)) + (d36 * d16)) - (d37 * d16)) / determinant;
        d24 = (d24 * d13) - (d23 * d13);
        d23 = d4 * d9;
        d18 = d * d12;
        double d38 = d3 * d9;
        double d39 = d * d11;
        dArr2[5] = ((((d24 + (d23 * d15)) - (d18 * d15)) - (d38 * d16)) + (d39 * d16)) / determinant;
        d4 *= d5;
        d8 *= d;
        d3 *= d5;
        d7 *= d;
        dArr2[6] = ((((((d30 * d13) - (d29 * d13)) - (d4 * d15)) + (d8 * d15)) + (d3 * d16)) - (d7 * d16)) / determinant;
        dArr2[7] = ((((((d29 * d9) - (d30 * d9)) + (d4 * d11)) - (d8 * d11)) - (d3 * d12)) + (d7 * d12)) / determinant;
        d17 = d6 * d9;
        d20 = ((((d20 * d13) - (d19 * d13)) + (d17 * d14)) - (d35 * d14)) - (d17 * d16);
        d19 = d5 * d10;
        dArr2[8] = (d20 + (d19 * d16)) / determinant;
        d23 = d2 * d9;
        d25 = ((((d25 * d13) - (d26 * d13)) - (d23 * d14)) + (d18 * d14)) + (d23 * d16);
        d18 = d * d10;
        dArr2[9] = (d25 - (d18 * d16)) / determinant;
        d2 *= d5;
        d *= d6;
        dArr2[10] = ((((((d32 * d13) - (d31 * d13)) + (d4 * d14)) - (d8 * d14)) - (d2 * d16)) + (d16 * d)) / determinant;
        dArr2[11] = ((((((d31 * d9) - (d32 * d9)) - (d4 * d10)) + (d8 * d10)) + (d2 * d12)) - (d12 * d)) / determinant;
        dArr2[12] = ((((((d21 * d13) - (d22 * d13)) - (d36 * d14)) + (d37 * d14)) + (d17 * d15)) - (d19 * d15)) / determinant;
        dArr2[13] = ((((((d28 * d13) - (d27 * d13)) + (d38 * d14)) - (d39 * d14)) - (d23 * d15)) + (d18 * d15)) / determinant;
        dArr2[14] = ((((((d33 * d13) - (d13 * d34)) - (d3 * d14)) + (d14 * d7)) + (d2 * d15)) - (d15 * d)) / determinant;
        dArr2[15] = ((((((d34 * d9) - (d33 * d9)) + (d3 * d10)) - (d7 * d10)) - (d2 * d11)) + (d * d11)) / determinant;
        return dArr2;
    }

    public static double[] transpose(double[] dArr) {
        return new double[]{dArr[0], dArr[4], dArr[8], dArr[12], dArr[1], dArr[5], dArr[9], dArr[13], dArr[2], dArr[6], dArr[10], dArr[14], dArr[3], dArr[7], dArr[11], dArr[15]};
    }

    public static void multiplyVectorByMatrix(double[] dArr, double[] dArr2, double[] dArr3) {
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        dArr3[0] = (((dArr2[0] * d) + (dArr2[4] * d2)) + (dArr2[8] * d3)) + (dArr2[12] * d4);
        dArr3[1] = (((dArr2[1] * d) + (dArr2[5] * d2)) + (dArr2[9] * d3)) + (dArr2[13] * d4);
        dArr3[2] = (((dArr2[2] * d) + (dArr2[6] * d2)) + (dArr2[10] * d3)) + (dArr2[14] * d4);
        dArr3[3] = (((d * dArr2[3]) + (d2 * dArr2[7])) + (d3 * dArr2[11])) + (d4 * dArr2[15]);
    }

    public static double v3Length(double[] dArr) {
        return Math.sqrt(((dArr[0] * dArr[0]) + (dArr[1] * dArr[1])) + (dArr[2] * dArr[2]));
    }

    public static double[] v3Normalize(double[] dArr, double d) {
        if (isZero(d)) {
            d = v3Length(dArr);
        }
        double d2 = 1.0d / d;
        return new double[]{dArr[0] * d2, dArr[1] * d2, dArr[2] * d2};
    }

    public static double v3Dot(double[] dArr, double[] dArr2) {
        return ((dArr[0] * dArr2[0]) + (dArr[1] * dArr2[1])) + (dArr[2] * dArr2[2]);
    }

    public static double[] v3Combine(double[] dArr, double[] dArr2, double d, double d2) {
        return new double[]{(dArr[0] * d) + (dArr2[0] * d2), (dArr[1] * d) + (dArr2[1] * d2), (d * dArr[2]) + (d2 * dArr2[2])};
    }

    public static double[] v3Cross(double[] dArr, double[] dArr2) {
        return new double[]{(dArr[1] * dArr2[2]) - (dArr[2] * dArr2[1]), (dArr[2] * dArr2[0]) - (dArr[0] * dArr2[2]), (dArr[0] * dArr2[1]) - (dArr[1] * dArr2[0])};
    }

    public static double roundTo3Places(double d) {
        return ((double) Math.round(d * 1000.0d)) * 0.001d;
    }

    public static double[] createIdentityMatrix() {
        double[] dArr = new double[16];
        resetIdentityMatrix(dArr);
        return dArr;
    }

    public static void resetIdentityMatrix(double[] dArr) {
        dArr[14] = 0.0d;
        dArr[13] = 0.0d;
        dArr[12] = 0.0d;
        dArr[11] = 0.0d;
        dArr[9] = 0.0d;
        dArr[8] = 0.0d;
        dArr[7] = 0.0d;
        dArr[6] = 0.0d;
        dArr[4] = 0.0d;
        dArr[3] = 0.0d;
        dArr[2] = 0.0d;
        dArr[1] = 0.0d;
        dArr[15] = 1.0d;
        dArr[10] = 1.0d;
        dArr[5] = 1.0d;
        dArr[0] = 1.0d;
    }

    public static void applyPerspective(double[] dArr, double d) {
        dArr[5.4E-323d] = -1.0d / d;
    }

    public static void applyScaleX(double[] dArr, double d) {
        dArr[0] = d;
    }

    public static void applyScaleY(double[] dArr, double d) {
        dArr[5] = d;
    }

    public static void applyScaleZ(double[] dArr, double d) {
        dArr[10] = d;
    }

    public static void applyTranslate2D(double[] dArr, double d, double d2) {
        dArr[12] = d;
        dArr[6.4E-323d] = d2;
    }

    public static void applyTranslate3D(double[] dArr, double d, double d2, double d3) {
        dArr[12] = d;
        dArr[6.4E-323d] = d2;
        dArr[6.9E-323d] = d3;
    }

    public static void applySkewX(double[] dArr, double d) {
        dArr[4] = Math.tan(d);
    }

    public static void applySkewY(double[] dArr, double d) {
        dArr[1] = Math.tan(d);
    }

    public static void applyRotateX(double[] dArr, double d) {
        dArr[5] = Math.cos(d);
        dArr[6] = Math.sin(d);
        dArr[9] = -Math.sin(d);
        dArr[10] = Math.cos(d);
    }

    public static void applyRotateY(double[] dArr, double d) {
        dArr[0] = Math.cos(d);
        dArr[2] = -Math.sin(d);
        dArr[8] = Math.sin(d);
        dArr[10] = Math.cos(d);
    }

    public static void applyRotateZ(double[] dArr, double d) {
        dArr[0] = Math.cos(d);
        dArr[1] = Math.sin(d);
        dArr[4] = -Math.sin(d);
        dArr[5] = Math.cos(d);
    }
}
