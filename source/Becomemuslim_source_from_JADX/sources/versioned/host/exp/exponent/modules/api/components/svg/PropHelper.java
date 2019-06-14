package versioned.host.exp.exponent.modules.api.components.svg;

import android.graphics.Path;
import android.graphics.RectF;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PropHelper {
    private static final int inputMatrixDataSize = 6;

    static class PathParser {
        private static final Pattern DECIMAL_REG_EXP = Pattern.compile("(\\.\\d+)(?=-?\\.)");
        private static final Pattern PATH_REG_EXP = Pattern.compile("[a-df-z]|[\\-+]?(?:[\\d.]e[\\-+]?|[^\\s\\-+,a-z])+", 2);
        private WritableArray mBezierCurves;
        private String mLastCommand;
        private WritableMap mLastStartPoint;
        private String mLastValue;
        private Matcher mMatcher;
        private Path mPath;
        private float mPenDownX;
        private float mPenDownY;
        private float mPenX = 0.0f;
        private float mPenY = 0.0f;
        private boolean mPendDownSet = false;
        private float mPivotX = 0.0f;
        private float mPivotY = 0.0f;
        private final float mScale;
        private final String mString;
        private boolean mValid = true;

        PathParser(String str, float f) {
            this.mScale = f;
            this.mString = str;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void executeCommand(java.lang.String r9) {
            /*
            r8 = this;
            r0 = r9.hashCode();
            switch(r0) {
                case 65: goto L_0x00dc;
                case 67: goto L_0x00d1;
                case 72: goto L_0x00c7;
                case 76: goto L_0x00bd;
                case 77: goto L_0x00b3;
                case 81: goto L_0x00a8;
                case 83: goto L_0x009d;
                case 84: goto L_0x0092;
                case 86: goto L_0x0088;
                case 90: goto L_0x007d;
                case 97: goto L_0x0071;
                case 99: goto L_0x0065;
                case 104: goto L_0x005a;
                case 108: goto L_0x004f;
                case 109: goto L_0x0044;
                case 113: goto L_0x0038;
                case 115: goto L_0x002c;
                case 116: goto L_0x0020;
                case 118: goto L_0x0015;
                case 122: goto L_0x0009;
                default: goto L_0x0007;
            };
        L_0x0007:
            goto L_0x00e7;
        L_0x0009:
            r0 = "z";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x0011:
            r0 = 19;
            goto L_0x00e8;
        L_0x0015:
            r0 = "v";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x001d:
            r0 = 6;
            goto L_0x00e8;
        L_0x0020:
            r0 = "t";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x0028:
            r0 = 14;
            goto L_0x00e8;
        L_0x002c:
            r0 = "s";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x0034:
            r0 = 10;
            goto L_0x00e8;
        L_0x0038:
            r0 = "q";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x0040:
            r0 = 12;
            goto L_0x00e8;
        L_0x0044:
            r0 = "m";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x004c:
            r0 = 0;
            goto L_0x00e8;
        L_0x004f:
            r0 = "l";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x0057:
            r0 = 2;
            goto L_0x00e8;
        L_0x005a:
            r0 = "h";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x0062:
            r0 = 4;
            goto L_0x00e8;
        L_0x0065:
            r0 = "c";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x006d:
            r0 = 8;
            goto L_0x00e8;
        L_0x0071:
            r0 = "a";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x0079:
            r0 = 16;
            goto L_0x00e8;
        L_0x007d:
            r0 = "Z";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x0085:
            r0 = 18;
            goto L_0x00e8;
        L_0x0088:
            r0 = "V";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x0090:
            r0 = 7;
            goto L_0x00e8;
        L_0x0092:
            r0 = "T";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x009a:
            r0 = 15;
            goto L_0x00e8;
        L_0x009d:
            r0 = "S";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x00a5:
            r0 = 11;
            goto L_0x00e8;
        L_0x00a8:
            r0 = "Q";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x00b0:
            r0 = 13;
            goto L_0x00e8;
        L_0x00b3:
            r0 = "M";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x00bb:
            r0 = 1;
            goto L_0x00e8;
        L_0x00bd:
            r0 = "L";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x00c5:
            r0 = 3;
            goto L_0x00e8;
        L_0x00c7:
            r0 = "H";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x00cf:
            r0 = 5;
            goto L_0x00e8;
        L_0x00d1:
            r0 = "C";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x00d9:
            r0 = 9;
            goto L_0x00e8;
        L_0x00dc:
            r0 = "A";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x00e7;
        L_0x00e4:
            r0 = 17;
            goto L_0x00e8;
        L_0x00e7:
            r0 = -1;
        L_0x00e8:
            r1 = 0;
            switch(r0) {
                case 0: goto L_0x022e;
                case 1: goto L_0x0222;
                case 2: goto L_0x0216;
                case 3: goto L_0x020a;
                case 4: goto L_0x0202;
                case 5: goto L_0x01f8;
                case 6: goto L_0x01f0;
                case 7: goto L_0x01e6;
                case 8: goto L_0x01c9;
                case 9: goto L_0x01ab;
                case 10: goto L_0x0196;
                case 11: goto L_0x0181;
                case 12: goto L_0x016c;
                case 13: goto L_0x0157;
                case 14: goto L_0x014a;
                case 15: goto L_0x013d;
                case 16: goto L_0x011b;
                case 17: goto L_0x00f9;
                case 18: goto L_0x00f4;
                case 19: goto L_0x00f4;
                default: goto L_0x00ec;
            };
        L_0x00ec:
            r8.mLastValue = r9;
            r0 = r8.mLastCommand;
            r8.executeCommand(r0);
            return;
        L_0x00f4:
            r8.close();
            goto L_0x0239;
        L_0x00f9:
            r1 = r8.getNextFloat();
            r2 = r8.getNextFloat();
            r3 = r8.getNextFloat();
            r4 = r8.getNextBoolean();
            r5 = r8.getNextBoolean();
            r6 = r8.getNextFloat();
            r7 = r8.getNextFloat();
            r0 = r8;
            r0.arcTo(r1, r2, r3, r4, r5, r6, r7);
            goto L_0x0239;
        L_0x011b:
            r1 = r8.getNextFloat();
            r2 = r8.getNextFloat();
            r3 = r8.getNextFloat();
            r4 = r8.getNextBoolean();
            r5 = r8.getNextBoolean();
            r6 = r8.getNextFloat();
            r7 = r8.getNextFloat();
            r0 = r8;
            r0.arc(r1, r2, r3, r4, r5, r6, r7);
            goto L_0x0239;
        L_0x013d:
            r0 = r8.getNextFloat();
            r1 = r8.getNextFloat();
            r8.smoothQuadraticBezierCurveTo(r0, r1);
            goto L_0x0239;
        L_0x014a:
            r0 = r8.getNextFloat();
            r1 = r8.getNextFloat();
            r8.smoothQuadraticBezierCurve(r0, r1);
            goto L_0x0239;
        L_0x0157:
            r0 = r8.getNextFloat();
            r1 = r8.getNextFloat();
            r2 = r8.getNextFloat();
            r3 = r8.getNextFloat();
            r8.quadraticBezierCurveTo(r0, r1, r2, r3);
            goto L_0x0239;
        L_0x016c:
            r0 = r8.getNextFloat();
            r1 = r8.getNextFloat();
            r2 = r8.getNextFloat();
            r3 = r8.getNextFloat();
            r8.quadraticBezierCurve(r0, r1, r2, r3);
            goto L_0x0239;
        L_0x0181:
            r0 = r8.getNextFloat();
            r1 = r8.getNextFloat();
            r2 = r8.getNextFloat();
            r3 = r8.getNextFloat();
            r8.smoothCurveTo(r0, r1, r2, r3);
            goto L_0x0239;
        L_0x0196:
            r0 = r8.getNextFloat();
            r1 = r8.getNextFloat();
            r2 = r8.getNextFloat();
            r3 = r8.getNextFloat();
            r8.smoothCurve(r0, r1, r2, r3);
            goto L_0x0239;
        L_0x01ab:
            r1 = r8.getNextFloat();
            r2 = r8.getNextFloat();
            r3 = r8.getNextFloat();
            r4 = r8.getNextFloat();
            r5 = r8.getNextFloat();
            r6 = r8.getNextFloat();
            r0 = r8;
            r0.curveTo(r1, r2, r3, r4, r5, r6);
            goto L_0x0239;
        L_0x01c9:
            r1 = r8.getNextFloat();
            r2 = r8.getNextFloat();
            r3 = r8.getNextFloat();
            r4 = r8.getNextFloat();
            r5 = r8.getNextFloat();
            r6 = r8.getNextFloat();
            r0 = r8;
            r0.curve(r1, r2, r3, r4, r5, r6);
            goto L_0x0239;
        L_0x01e6:
            r0 = r8.mPenX;
            r1 = r8.getNextFloat();
            r8.lineTo(r0, r1);
            goto L_0x0239;
        L_0x01f0:
            r0 = r8.getNextFloat();
            r8.line(r1, r0);
            goto L_0x0239;
        L_0x01f8:
            r0 = r8.getNextFloat();
            r1 = r8.mPenY;
            r8.lineTo(r0, r1);
            goto L_0x0239;
        L_0x0202:
            r0 = r8.getNextFloat();
            r8.line(r0, r1);
            goto L_0x0239;
        L_0x020a:
            r0 = r8.getNextFloat();
            r1 = r8.getNextFloat();
            r8.lineTo(r0, r1);
            goto L_0x0239;
        L_0x0216:
            r0 = r8.getNextFloat();
            r1 = r8.getNextFloat();
            r8.line(r0, r1);
            goto L_0x0239;
        L_0x0222:
            r0 = r8.getNextFloat();
            r1 = r8.getNextFloat();
            r8.moveTo(r0, r1);
            goto L_0x0239;
        L_0x022e:
            r0 = r8.getNextFloat();
            r1 = r8.getNextFloat();
            r8.move(r0, r1);
        L_0x0239:
            r8.mLastCommand = r9;
            r0 = "m";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x0248;
        L_0x0243:
            r0 = "l";
            r8.mLastCommand = r0;
            goto L_0x0254;
        L_0x0248:
            r0 = "M";
            r0 = r9.equals(r0);
            if (r0 == 0) goto L_0x0254;
        L_0x0250:
            r0 = "L";
            r8.mLastCommand = r0;
        L_0x0254:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.components.svg.PropHelper.PathParser.executeCommand(java.lang.String):void");
        }

        Path getPath() {
            this.mPath = new Path();
            this.mBezierCurves = Arguments.createArray();
            this.mMatcher = PATH_REG_EXP.matcher(DECIMAL_REG_EXP.matcher(this.mString).replaceAll("$1,"));
            while (this.mMatcher.find() && this.mValid) {
                executeCommand(this.mMatcher.group());
            }
            return this.mPath;
        }

        private WritableMap getPointMap(float f, float f2) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("x", (double) (f * this.mScale));
            createMap.putDouble("y", (double) (f2 * this.mScale));
            return createMap;
        }

        private WritableMap clonePointMap(WritableMap writableMap) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("x", writableMap.getDouble("x"));
            createMap.putDouble("y", writableMap.getDouble("y"));
            return createMap;
        }

        private boolean getNextBoolean() {
            if (this.mMatcher.find()) {
                return this.mMatcher.group().equals(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
            this.mValid = false;
            this.mPath = new Path();
            return false;
        }

        private float getNextFloat() {
            if (this.mLastValue != null) {
                String str = this.mLastValue;
                this.mLastValue = null;
                return Float.parseFloat(str);
            } else if (this.mMatcher.find()) {
                return Float.parseFloat(this.mMatcher.group());
            } else {
                this.mValid = false;
                this.mPath = new Path();
                return 0.0f;
            }
        }

        private void move(float f, float f2) {
            moveTo(f + this.mPenX, f2 + this.mPenY);
        }

        private void moveTo(float f, float f2) {
            this.mPenX = f;
            this.mPivotX = f;
            this.mPenDownX = f;
            this.mPenY = f2;
            this.mPivotY = f2;
            this.mPenDownY = f2;
            this.mPath.moveTo(this.mScale * f, this.mScale * f2);
            this.mLastStartPoint = getPointMap(f, f2);
            WritableArray createArray = Arguments.createArray();
            createArray.pushMap(getPointMap(f, f2));
            this.mBezierCurves.pushArray(createArray);
        }

        private void line(float f, float f2) {
            lineTo(f + this.mPenX, f2 + this.mPenY);
        }

        private void lineTo(float f, float f2) {
            setPenDown();
            this.mPenX = f;
            this.mPivotX = f;
            this.mPenY = f2;
            this.mPivotY = f2;
            this.mPath.lineTo(this.mScale * f, this.mScale * f2);
            WritableArray createArray = Arguments.createArray();
            createArray.pushMap(getPointMap(f, f2));
            createArray.pushMap(getPointMap(f, f2));
            createArray.pushMap(getPointMap(f, f2));
            this.mBezierCurves.pushArray(createArray);
        }

        private void curve(float f, float f2, float f3, float f4, float f5, float f6) {
            curveTo(f + this.mPenX, f2 + this.mPenY, f3 + this.mPenX, f4 + this.mPenY, f5 + this.mPenX, f6 + this.mPenY);
        }

        private void curveTo(float f, float f2, float f3, float f4, float f5, float f6) {
            this.mPivotX = f3;
            this.mPivotY = f4;
            cubicTo(f, f2, f3, f4, f5, f6);
        }

        private void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            setPenDown();
            this.mPenX = f5;
            this.mPenY = f6;
            this.mPath.cubicTo(this.mScale * f, this.mScale * f2, this.mScale * f3, this.mScale * f4, this.mScale * f5, this.mScale * f6);
            WritableArray createArray = Arguments.createArray();
            createArray.pushMap(getPointMap(f, f2));
            createArray.pushMap(getPointMap(f3, f4));
            createArray.pushMap(getPointMap(f5, f6));
            this.mBezierCurves.pushArray(createArray);
        }

        private void smoothCurve(float f, float f2, float f3, float f4) {
            smoothCurveTo(f + this.mPenX, f2 + this.mPenY, f3 + this.mPenX, f4 + this.mPenY);
        }

        private void smoothCurveTo(float f, float f2, float f3, float f4) {
            float f5 = (this.mPenX * 2.0f) - this.mPivotX;
            float f6 = (this.mPenY * 2.0f) - this.mPivotY;
            this.mPivotX = f;
            this.mPivotY = f2;
            cubicTo(f5, f6, f, f2, f3, f4);
        }

        private void quadraticBezierCurve(float f, float f2, float f3, float f4) {
            quadraticBezierCurveTo(f + this.mPenX, f2 + this.mPenY, f3 + this.mPenX, f4 + this.mPenY);
        }

        private void quadraticBezierCurveTo(float f, float f2, float f3, float f4) {
            this.mPivotX = f;
            this.mPivotY = f2;
            f *= 2.0f;
            f2 *= 2.0f;
            cubicTo((this.mPenX + f) / 3.0f, (this.mPenY + f2) / 3.0f, (f3 + f) / 3.0f, (f4 + f2) / 3.0f, f3, f4);
        }

        private void smoothQuadraticBezierCurve(float f, float f2) {
            smoothQuadraticBezierCurveTo(f + this.mPenX, f2 + this.mPenY);
        }

        private void smoothQuadraticBezierCurveTo(float f, float f2) {
            quadraticBezierCurveTo((this.mPenX * 2.0f) - this.mPivotX, (this.mPenY * 2.0f) - this.mPivotY, f, f2);
        }

        private void arc(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            arcTo(f, f2, f3, z, z2, f4 + this.mPenX, f5 + this.mPenY);
        }

        private void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            boolean z3 = z;
            boolean z4 = z2;
            float f6 = f4;
            float f7 = f5;
            float f8 = this.mPenX;
            float f9 = this.mPenY;
            float f10 = f2 == 0.0f ? f == 0.0f ? f7 - f9 : f : f2;
            f10 = Math.abs(f10);
            float abs = Math.abs(f == 0.0f ? f6 - f8 : f);
            if (!(abs == 0.0f || f10 == 0.0f)) {
                if (f6 != f8 || f7 != f9) {
                    float sqrt;
                    float f11;
                    float toRadians = (float) Math.toRadians((double) f3);
                    double d = (double) toRadians;
                    float cos = (float) Math.cos(d);
                    float sin = (float) Math.sin(d);
                    f6 -= f8;
                    f7 -= f9;
                    float f12 = ((cos * f6) / 2.0f) + ((sin * f7) / 2.0f);
                    float f13 = -sin;
                    float f14 = ((f13 * f6) / 2.0f) + ((cos * f7) / 2.0f);
                    float f15 = abs * abs;
                    float f16 = (f15 * f10) * f10;
                    float f17 = ((f10 * f10) * f12) * f12;
                    f15 = (f15 * f14) * f14;
                    float f18 = (f16 - f15) - f17;
                    if (f18 < 0.0f) {
                        sqrt = (float) Math.sqrt((double) (1.0f - (f18 / f16)));
                        f10 *= sqrt;
                        f12 = f6 / 2.0f;
                        sqrt = abs * sqrt;
                        abs = f7 / 2.0f;
                        z4 = z2;
                    } else {
                        sqrt = (float) Math.sqrt((double) (f18 / (f15 + f17)));
                        if (z3 == z2) {
                            sqrt = -sqrt;
                        }
                        f11 = (((-sqrt) * f14) * abs) / f10;
                        sqrt = ((sqrt * f12) * f10) / abs;
                        f12 = ((cos * f11) - (sin * sqrt)) + (f6 / 2.0f);
                        sqrt = abs;
                        abs = (f7 / 2.0f) + ((f11 * sin) + (sqrt * cos));
                    }
                    f11 = cos / sqrt;
                    sin /= sqrt;
                    f13 /= f10;
                    cos /= f10;
                    float f19 = -f12;
                    float f20 = -abs;
                    float f21 = toRadians;
                    float f22 = f10;
                    float f23 = sqrt;
                    sqrt = (float) Math.atan2((double) ((f13 * f19) + (cos * f20)), (double) ((f19 * f11) + (f20 * sin)));
                    f20 = f6 - f12;
                    f19 = f7 - abs;
                    f19 = (float) Math.atan2((double) ((f13 * f20) + (cos * f19)), (double) ((f11 * f20) + (sin * f19)));
                    f20 = f12 + f8;
                    f10 = abs + f9;
                    f6 += f8;
                    f7 += f9;
                    setPenDown();
                    this.mPivotX = f6;
                    this.mPenX = f6;
                    this.mPivotY = f7;
                    this.mPenY = f7;
                    if (f23 == f22) {
                        if (f21 == 0.0f) {
                            abs = (float) Math.toDegrees((double) sqrt);
                            f6 = Math.abs((abs - ((float) Math.toDegrees((double) f19))) % 360.0f);
                            if (z) {
                                if (f6 < 180.0f) {
                                    f6 = 360.0f - f6;
                                }
                            } else if (f6 > 180.0f) {
                                f6 = 360.0f - f6;
                            }
                            if (!z2) {
                                f6 = -f6;
                            }
                            r9.mPath.arcTo(new RectF((f20 - f23) * r9.mScale, (f10 - f23) * r9.mScale, (f20 + f23) * r9.mScale, (f10 + f23) * r9.mScale), abs, f6);
                            return;
                        }
                    }
                    boolean z5 = z2;
                    arcToBezier(f20, f10, f23, f22, sqrt, f19, z2, f21);
                    return;
                }
            }
            lineTo(f6, f7);
        }

        private void close() {
            if (this.mPendDownSet) {
                this.mPenX = this.mPenDownX;
                this.mPenY = this.mPenDownY;
                this.mPendDownSet = false;
                this.mPath.close();
                WritableArray createArray = Arguments.createArray();
                createArray.pushMap(clonePointMap(this.mLastStartPoint));
                createArray.pushMap(clonePointMap(this.mLastStartPoint));
                createArray.pushMap(clonePointMap(this.mLastStartPoint));
                this.mBezierCurves.pushArray(createArray);
            }
        }

        private void arcToBezier(float f, float f2, float f3, float f4, float f5, float f6, boolean z, float f7) {
            PathParser pathParser = this;
            float f8 = f5;
            double d = (double) f7;
            float cos = (float) Math.cos(d);
            float sin = (float) Math.sin(d);
            float f9 = cos * f3;
            float f10 = (-sin) * f4;
            sin *= f3;
            cos *= f4;
            float f11 = f6 - f8;
            if (f11 < 0.0f && z) {
                f11 = (float) (((double) f11) + 6.283185307179586d);
            } else if (f11 > 0.0f && !z) {
                f11 = (float) (((double) f11) - 6.283185307179586d);
            }
            int ceil = (int) Math.ceil(Math.abs(round(((double) f11) / 1.5707963267948966d)));
            f11 /= (float) ceil;
            float tan = (float) (Math.tan((double) (f11 / 4.0f)) * 1.3333333333333333d);
            double d2 = (double) f8;
            float cos2 = (float) Math.cos(d2);
            float sin2 = (float) Math.sin(d2);
            int i = 0;
            while (i < ceil) {
                float f12 = cos2 - (tan * sin2);
                sin2 += cos2 * tan;
                f8 += f11;
                float f13 = f11;
                int i2 = ceil;
                double d3 = (double) f8;
                int i3 = i;
                cos2 = (float) Math.cos(d3);
                f11 = (float) Math.sin(d3);
                float f14 = (tan * f11) + cos2;
                float f15 = f11 - (tan * cos2);
                float f16 = (f + (f9 * f12)) + (f10 * sin2);
                f12 = (f2 + (f12 * sin)) + (sin2 * cos);
                sin2 = (f + (f9 * f14)) + (f10 * f15);
                f14 = (f2 + (f14 * sin)) + (f15 * cos);
                f15 = (f + (f9 * cos2)) + (f10 * f11);
                float f17 = (f2 + (sin * cos2)) + (cos * f11);
                pathParser.mPath.cubicTo(f16 * pathParser.mScale, f12 * pathParser.mScale, sin2 * pathParser.mScale, f14 * pathParser.mScale, f15 * pathParser.mScale, f17 * pathParser.mScale);
                i = i3 + 1;
                sin2 = f11;
                ceil = i2;
                f11 = f13;
            }
        }

        private void setPenDown() {
            if (!this.mPendDownSet) {
                this.mPenDownX = this.mPenX;
                this.mPenDownY = this.mPenY;
                this.mPendDownSet = true;
            }
        }

        private double round(double d) {
            double pow = Math.pow(10.0d, 4.0d);
            return ((double) Math.round(d * pow)) / pow;
        }
    }

    PropHelper() {
    }

    static int toMatrixData(ReadableArray readableArray, float[] fArr, float f) {
        int size = readableArray.size();
        if (size != 6) {
            return size;
        }
        fArr[0] = (float) readableArray.getDouble(0);
        fArr[1] = (float) readableArray.getDouble(2);
        fArr[2] = ((float) readableArray.getDouble(4)) * f;
        fArr[3] = (float) readableArray.getDouble(1);
        fArr[4] = (float) readableArray.getDouble(3);
        fArr[5] = ((float) readableArray.getDouble(5)) * f;
        return 6;
    }

    static double fromRelative(String str, double d, double d2, double d3, double d4) {
        str = str.trim();
        int length = str.length();
        int i = length - 1;
        if (length != 0) {
            if (!str.equals("normal")) {
                if (str.codePointAt(i) == 37) {
                    return ((Double.valueOf(str.substring(0, i)).doubleValue() / 100.0d) * d) + d2;
                }
                d = length - 2;
                if (d <= null) {
                    return (Double.valueOf(str).doubleValue() * d3) + d2;
                }
                Object obj;
                String substring = str.substring(d);
                int hashCode = substring.hashCode();
                if (hashCode != 3178) {
                    if (hashCode != 3240) {
                        if (hashCode != 3365) {
                            if (hashCode != 3488) {
                                if (hashCode != 3571) {
                                    if (hashCode != 3588) {
                                        if (hashCode == 3592) {
                                            if (substring.equals("px")) {
                                                obj = null;
                                                switch (obj) {
                                                    case null:
                                                        break;
                                                    case 1:
                                                        break;
                                                    case 2:
                                                        d4 = 1.25d;
                                                        break;
                                                    case 3:
                                                        d4 = 15.0d;
                                                        break;
                                                    case 4:
                                                        d4 = 3.543307d;
                                                        break;
                                                    case 5:
                                                        d4 = 35.43307d;
                                                        break;
                                                    case 6:
                                                        d4 = 90.0d;
                                                        break;
                                                    default:
                                                        d = length;
                                                        break;
                                                }
                                                d4 = 1.0d;
                                                return ((Double.valueOf(str.substring(0, d)).doubleValue() * d4) * d3) + d2;
                                            }
                                        }
                                    } else if (substring.equals("pt")) {
                                        obj = 2;
                                        switch (obj) {
                                            case null:
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                d4 = 1.25d;
                                                break;
                                            case 3:
                                                d4 = 15.0d;
                                                break;
                                            case 4:
                                                d4 = 3.543307d;
                                                break;
                                            case 5:
                                                d4 = 35.43307d;
                                                break;
                                            case 6:
                                                d4 = 90.0d;
                                                break;
                                            default:
                                                d = length;
                                                break;
                                        }
                                        d4 = 1.0d;
                                        return ((Double.valueOf(str.substring(0, d)).doubleValue() * d4) * d3) + d2;
                                    }
                                } else if (substring.equals("pc")) {
                                    obj = 3;
                                    switch (obj) {
                                        case null:
                                            break;
                                        case 1:
                                            break;
                                        case 2:
                                            d4 = 1.25d;
                                            break;
                                        case 3:
                                            d4 = 15.0d;
                                            break;
                                        case 4:
                                            d4 = 3.543307d;
                                            break;
                                        case 5:
                                            d4 = 35.43307d;
                                            break;
                                        case 6:
                                            d4 = 90.0d;
                                            break;
                                        default:
                                            d = length;
                                            break;
                                    }
                                    d4 = 1.0d;
                                    return ((Double.valueOf(str.substring(0, d)).doubleValue() * d4) * d3) + d2;
                                }
                            } else if (substring.equals("mm")) {
                                obj = 4;
                                switch (obj) {
                                    case null:
                                        break;
                                    case 1:
                                        break;
                                    case 2:
                                        d4 = 1.25d;
                                        break;
                                    case 3:
                                        d4 = 15.0d;
                                        break;
                                    case 4:
                                        d4 = 3.543307d;
                                        break;
                                    case 5:
                                        d4 = 35.43307d;
                                        break;
                                    case 6:
                                        d4 = 90.0d;
                                        break;
                                    default:
                                        d = length;
                                        break;
                                }
                                d4 = 1.0d;
                                return ((Double.valueOf(str.substring(0, d)).doubleValue() * d4) * d3) + d2;
                            }
                        } else if (substring.equals("in")) {
                            obj = 6;
                            switch (obj) {
                                case null:
                                    break;
                                case 1:
                                    break;
                                case 2:
                                    d4 = 1.25d;
                                    break;
                                case 3:
                                    d4 = 15.0d;
                                    break;
                                case 4:
                                    d4 = 3.543307d;
                                    break;
                                case 5:
                                    d4 = 35.43307d;
                                    break;
                                case 6:
                                    d4 = 90.0d;
                                    break;
                                default:
                                    d = length;
                                    break;
                            }
                            d4 = 1.0d;
                            return ((Double.valueOf(str.substring(0, d)).doubleValue() * d4) * d3) + d2;
                        }
                    } else if (substring.equals(UserDataStore.EMAIL)) {
                        obj = 1;
                        switch (obj) {
                            case null:
                                break;
                            case 1:
                                break;
                            case 2:
                                d4 = 1.25d;
                                break;
                            case 3:
                                d4 = 15.0d;
                                break;
                            case 4:
                                d4 = 3.543307d;
                                break;
                            case 5:
                                d4 = 35.43307d;
                                break;
                            case 6:
                                d4 = 90.0d;
                                break;
                            default:
                                d = length;
                                break;
                        }
                        d4 = 1.0d;
                        return ((Double.valueOf(str.substring(0, d)).doubleValue() * d4) * d3) + d2;
                    }
                } else if (substring.equals("cm")) {
                    obj = 5;
                    switch (obj) {
                        case null:
                            break;
                        case 1:
                            break;
                        case 2:
                            d4 = 1.25d;
                            break;
                        case 3:
                            d4 = 15.0d;
                            break;
                        case 4:
                            d4 = 3.543307d;
                            break;
                        case 5:
                            d4 = 35.43307d;
                            break;
                        case 6:
                            d4 = 90.0d;
                            break;
                        default:
                            d = length;
                            break;
                    }
                    d4 = 1.0d;
                    return ((Double.valueOf(str.substring(0, d)).doubleValue() * d4) * d3) + d2;
                }
                obj = -1;
                switch (obj) {
                    case null:
                        break;
                    case 1:
                        break;
                    case 2:
                        d4 = 1.25d;
                        break;
                    case 3:
                        d4 = 15.0d;
                        break;
                    case 4:
                        d4 = 3.543307d;
                        break;
                    case 5:
                        d4 = 35.43307d;
                        break;
                    case 6:
                        d4 = 90.0d;
                        break;
                    default:
                        d = length;
                        break;
                }
                d4 = 1.0d;
                return ((Double.valueOf(str.substring(0, d)).doubleValue() * d4) * d3) + d2;
            }
        }
        return d2;
    }

    static double fromRelative(SVGLength sVGLength, double d, double d2, double d3, double d4) {
        SVGLengthUnitType sVGLengthUnitType = sVGLength.unit;
        double d5 = sVGLength.value;
        switch (sVGLengthUnitType) {
            case SVG_LENGTHTYPE_NUMBER:
            case SVG_LENGTHTYPE_PX:
                d4 = 1.0d;
                break;
            case SVG_LENGTHTYPE_PERCENTAGE:
                return ((d5 / 100.0d) * d) + d2;
            case SVG_LENGTHTYPE_EMS:
                break;
            case SVG_LENGTHTYPE_EXS:
                d4 /= 0;
                break;
            case SVG_LENGTHTYPE_CM:
                d4 = 35.43307d;
                break;
            case SVG_LENGTHTYPE_MM:
                d4 = 3.543307d;
                break;
            case SVG_LENGTHTYPE_IN:
                d4 = 90.0d;
                break;
            case SVG_LENGTHTYPE_PT:
                d4 = 1.25d;
                break;
            case SVG_LENGTHTYPE_PC:
                d4 = 15.0d;
                break;
            default:
                return (d5 * d3) + d2;
        }
        return ((d5 * d4) * d3) + d2;
    }
}
