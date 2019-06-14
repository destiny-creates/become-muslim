package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.infer.annotation.ReturnsOwnership;

public class GenericDraweeHierarchyInflater {
    public static GenericDraweeHierarchy inflateHierarchy(Context context, AttributeSet attributeSet) {
        return inflateBuilder(context, attributeSet).build();
    }

    public static GenericDraweeHierarchyBuilder inflateBuilder(Context context, AttributeSet attributeSet) {
        return updateBuilder(new GenericDraweeHierarchyBuilder(context.getResources()), context, attributeSet);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.drawee.generic.GenericDraweeHierarchyBuilder updateBuilder(com.facebook.drawee.generic.GenericDraweeHierarchyBuilder r18, android.content.Context r19, android.util.AttributeSet r20) {
        /*
        r0 = r18;
        r1 = r19;
        r2 = r20;
        if (r2 == 0) goto L_0x021c;
    L_0x0008:
        r6 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy;
        r2 = r1.obtainStyledAttributes(r2, r6);
        r7 = r2.getIndexCount();	 Catch:{ all -> 0x01fc }
        r5 = 1;
        r6 = 0;
        r8 = 0;
        r9 = 1;
        r10 = 1;
        r11 = 1;
        r12 = 1;
        r13 = 1;
        r14 = 1;
        r15 = 1;
        r16 = 0;
    L_0x001e:
        if (r8 >= r7) goto L_0x01a8;
    L_0x0020:
        r3 = r2.getIndex(r8);	 Catch:{ all -> 0x01a5 }
        r4 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_actualImageScaleType;	 Catch:{ all -> 0x01a5 }
        if (r3 != r4) goto L_0x0034;
    L_0x0028:
        r3 = getScaleTypeFromXml(r2, r3);	 Catch:{ all -> 0x01a5 }
        r0.setActualImageScaleType(r3);	 Catch:{ all -> 0x01a5 }
    L_0x002f:
        r17 = r16;
    L_0x0031:
        r4 = 0;
        goto L_0x019d;
    L_0x0034:
        r4 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_placeholderImage;	 Catch:{ all -> 0x01a5 }
        if (r3 != r4) goto L_0x0040;
    L_0x0038:
        r3 = getDrawable(r1, r2, r3);	 Catch:{ all -> 0x01a5 }
        r0.setPlaceholderImage(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x002f;
    L_0x0040:
        r4 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_pressedStateOverlayImage;	 Catch:{ all -> 0x01a5 }
        if (r3 != r4) goto L_0x004c;
    L_0x0044:
        r3 = getDrawable(r1, r2, r3);	 Catch:{ all -> 0x01a5 }
        r0.setPressedStateOverlay(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x002f;
    L_0x004c:
        r4 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_progressBarImage;	 Catch:{ all -> 0x01a5 }
        if (r3 != r4) goto L_0x0058;
    L_0x0050:
        r3 = getDrawable(r1, r2, r3);	 Catch:{ all -> 0x01a5 }
        r0.setProgressBarImage(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x002f;
    L_0x0058:
        r4 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_fadeDuration;	 Catch:{ all -> 0x01a5 }
        if (r3 != r4) goto L_0x0065;
    L_0x005c:
        r4 = 0;
        r3 = r2.getInt(r3, r4);	 Catch:{ all -> 0x01a5 }
        r0.setFadeDuration(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x002f;
    L_0x0065:
        r4 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_viewAspectRatio;	 Catch:{ all -> 0x01a5 }
        if (r3 != r4) goto L_0x0072;
    L_0x0069:
        r4 = 0;
        r3 = r2.getFloat(r3, r4);	 Catch:{ all -> 0x01a5 }
        r0.setDesiredAspectRatio(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x002f;
    L_0x0072:
        r4 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_placeholderImageScaleType;	 Catch:{ all -> 0x01a5 }
        if (r3 != r4) goto L_0x007e;
    L_0x0076:
        r3 = getScaleTypeFromXml(r2, r3);	 Catch:{ all -> 0x01a5 }
        r0.setPlaceholderImageScaleType(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x002f;
    L_0x007e:
        r4 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_retryImage;	 Catch:{ all -> 0x01a5 }
        if (r3 != r4) goto L_0x008a;
    L_0x0082:
        r3 = getDrawable(r1, r2, r3);	 Catch:{ all -> 0x01a5 }
        r0.setRetryImage(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x002f;
    L_0x008a:
        r4 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_retryImageScaleType;	 Catch:{ all -> 0x01a5 }
        if (r3 != r4) goto L_0x0096;
    L_0x008e:
        r3 = getScaleTypeFromXml(r2, r3);	 Catch:{ all -> 0x01a5 }
        r0.setRetryImageScaleType(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x002f;
    L_0x0096:
        r4 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_failureImage;	 Catch:{ all -> 0x01a5 }
        if (r3 != r4) goto L_0x00a2;
    L_0x009a:
        r3 = getDrawable(r1, r2, r3);	 Catch:{ all -> 0x01a5 }
        r0.setFailureImage(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x002f;
    L_0x00a2:
        r4 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_failureImageScaleType;	 Catch:{ all -> 0x01a5 }
        if (r3 != r4) goto L_0x00ae;
    L_0x00a6:
        r3 = getScaleTypeFromXml(r2, r3);	 Catch:{ all -> 0x01a5 }
        r0.setFailureImageScaleType(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x002f;
    L_0x00ae:
        r4 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_progressBarImageScaleType;	 Catch:{ all -> 0x01a5 }
        if (r3 != r4) goto L_0x00bb;
    L_0x00b2:
        r3 = getScaleTypeFromXml(r2, r3);	 Catch:{ all -> 0x01a5 }
        r0.setProgressBarImageScaleType(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x002f;
    L_0x00bb:
        r4 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_progressBarAutoRotateInterval;	 Catch:{ all -> 0x01a5 }
        if (r3 != r4) goto L_0x00c6;
    L_0x00bf:
        r6 = r2.getInteger(r3, r6);	 Catch:{ all -> 0x01a5 }
    L_0x00c3:
        r4 = 0;
        goto L_0x019f;
    L_0x00c6:
        r4 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_backgroundImage;	 Catch:{ all -> 0x01a5 }
        if (r3 != r4) goto L_0x00d3;
    L_0x00ca:
        r3 = getDrawable(r1, r2, r3);	 Catch:{ all -> 0x01a5 }
        r0.setBackground(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x002f;
    L_0x00d3:
        r4 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_overlayImage;	 Catch:{ all -> 0x01a5 }
        if (r3 != r4) goto L_0x00e0;
    L_0x00d7:
        r3 = getDrawable(r1, r2, r3);	 Catch:{ all -> 0x01a5 }
        r0.setOverlay(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x002f;
    L_0x00e0:
        r4 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_roundAsCircle;	 Catch:{ all -> 0x01a5 }
        if (r3 != r4) goto L_0x00f2;
    L_0x00e4:
        r4 = getRoundingParams(r18);	 Catch:{ all -> 0x01a5 }
        r1 = 0;
        r3 = r2.getBoolean(r3, r1);	 Catch:{ all -> 0x01a5 }
        r4.setRoundAsCircle(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x002f;
    L_0x00f2:
        r1 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_roundedCornerRadius;	 Catch:{ all -> 0x01a5 }
        if (r3 != r1) goto L_0x00fd;
    L_0x00f6:
        r4 = r16;
        r16 = r2.getDimensionPixelSize(r3, r4);	 Catch:{ all -> 0x01a5 }
        goto L_0x00c3;
    L_0x00fd:
        r4 = r16;
        r1 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_roundTopLeft;	 Catch:{ all -> 0x01a5 }
        if (r3 != r1) goto L_0x010b;
    L_0x0103:
        r1 = r2.getBoolean(r3, r9);	 Catch:{ all -> 0x01a5 }
        r9 = r1;
    L_0x0108:
        r16 = r4;
        goto L_0x00c3;
    L_0x010b:
        r1 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_roundTopRight;	 Catch:{ all -> 0x01a5 }
        if (r3 != r1) goto L_0x0115;
    L_0x010f:
        r1 = r2.getBoolean(r3, r12);	 Catch:{ all -> 0x01a5 }
        r12 = r1;
        goto L_0x0108;
    L_0x0115:
        r1 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_roundBottomLeft;	 Catch:{ all -> 0x01a5 }
        if (r3 != r1) goto L_0x011f;
    L_0x0119:
        r1 = r2.getBoolean(r3, r5);	 Catch:{ all -> 0x01a5 }
        r5 = r1;
        goto L_0x0108;
    L_0x011f:
        r1 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_roundBottomRight;	 Catch:{ all -> 0x01a5 }
        if (r3 != r1) goto L_0x0129;
    L_0x0123:
        r1 = r2.getBoolean(r3, r13);	 Catch:{ all -> 0x01a5 }
        r13 = r1;
        goto L_0x0108;
    L_0x0129:
        r1 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_roundTopStart;	 Catch:{ all -> 0x01a5 }
        if (r3 != r1) goto L_0x0133;
    L_0x012d:
        r1 = r2.getBoolean(r3, r10);	 Catch:{ all -> 0x01a5 }
        r10 = r1;
        goto L_0x0108;
    L_0x0133:
        r1 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_roundTopEnd;	 Catch:{ all -> 0x01a5 }
        if (r3 != r1) goto L_0x013d;
    L_0x0137:
        r1 = r2.getBoolean(r3, r11);	 Catch:{ all -> 0x01a5 }
        r11 = r1;
        goto L_0x0108;
    L_0x013d:
        r1 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_roundBottomStart;	 Catch:{ all -> 0x01a5 }
        if (r3 != r1) goto L_0x0147;
    L_0x0141:
        r1 = r2.getBoolean(r3, r15);	 Catch:{ all -> 0x01a5 }
        r15 = r1;
        goto L_0x0108;
    L_0x0147:
        r1 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_roundBottomEnd;	 Catch:{ all -> 0x01a5 }
        if (r3 != r1) goto L_0x0151;
    L_0x014b:
        r1 = r2.getBoolean(r3, r14);	 Catch:{ all -> 0x01a5 }
        r14 = r1;
        goto L_0x0108;
    L_0x0151:
        r1 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_roundWithOverlayColor;	 Catch:{ all -> 0x01a5 }
        if (r3 != r1) goto L_0x0165;
    L_0x0155:
        r1 = getRoundingParams(r18);	 Catch:{ all -> 0x01a5 }
        r17 = r4;
        r4 = 0;
        r3 = r2.getColor(r3, r4);	 Catch:{ all -> 0x01a5 }
        r1.setOverlayColor(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x0031;
    L_0x0165:
        r17 = r4;
        r1 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_roundingBorderWidth;	 Catch:{ all -> 0x01a5 }
        if (r3 != r1) goto L_0x017a;
    L_0x016b:
        r1 = getRoundingParams(r18);	 Catch:{ all -> 0x01a5 }
        r4 = 0;
        r3 = r2.getDimensionPixelSize(r3, r4);	 Catch:{ all -> 0x01a5 }
        r3 = (float) r3;	 Catch:{ all -> 0x01a5 }
        r1.setBorderWidth(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x0031;
    L_0x017a:
        r1 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_roundingBorderColor;	 Catch:{ all -> 0x01a5 }
        if (r3 != r1) goto L_0x018c;
    L_0x017e:
        r1 = getRoundingParams(r18);	 Catch:{ all -> 0x01a5 }
        r4 = 0;
        r3 = r2.getColor(r3, r4);	 Catch:{ all -> 0x01a5 }
        r1.setBorderColor(r3);	 Catch:{ all -> 0x01a5 }
        goto L_0x0031;
    L_0x018c:
        r1 = com.facebook.drawee.C1743R.styleable.GenericDraweeHierarchy_roundingBorderPadding;	 Catch:{ all -> 0x01a5 }
        if (r3 != r1) goto L_0x0031;
    L_0x0190:
        r1 = getRoundingParams(r18);	 Catch:{ all -> 0x01a5 }
        r4 = 0;
        r3 = r2.getDimensionPixelSize(r3, r4);	 Catch:{ all -> 0x01a5 }
        r3 = (float) r3;	 Catch:{ all -> 0x01a5 }
        r1.setPadding(r3);	 Catch:{ all -> 0x01a5 }
    L_0x019d:
        r16 = r17;
    L_0x019f:
        r8 = r8 + 1;
        r1 = r19;
        goto L_0x001e;
    L_0x01a5:
        r0 = move-exception;
        goto L_0x0205;
    L_0x01a8:
        r17 = r16;
        r4 = 0;
        r2.recycle();
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 17;
        if (r1 < r2) goto L_0x01dd;
    L_0x01b4:
        r1 = r19.getResources();
        r1 = r1.getConfiguration();
        r1 = r1.getLayoutDirection();
        r2 = 1;
        if (r1 != r2) goto L_0x01dd;
    L_0x01c3:
        if (r9 == 0) goto L_0x01c9;
    L_0x01c5:
        if (r11 == 0) goto L_0x01c9;
    L_0x01c7:
        r1 = 1;
        goto L_0x01ca;
    L_0x01c9:
        r1 = 0;
    L_0x01ca:
        if (r12 == 0) goto L_0x01d0;
    L_0x01cc:
        if (r10 == 0) goto L_0x01d0;
    L_0x01ce:
        r2 = 1;
        goto L_0x01d1;
    L_0x01d0:
        r2 = 0;
    L_0x01d1:
        if (r13 == 0) goto L_0x01d7;
    L_0x01d3:
        if (r15 == 0) goto L_0x01d7;
    L_0x01d5:
        r3 = 1;
        goto L_0x01d8;
    L_0x01d7:
        r3 = 0;
    L_0x01d8:
        if (r5 == 0) goto L_0x01f8;
    L_0x01da:
        if (r14 == 0) goto L_0x01f8;
    L_0x01dc:
        goto L_0x01f6;
    L_0x01dd:
        if (r9 == 0) goto L_0x01e3;
    L_0x01df:
        if (r10 == 0) goto L_0x01e3;
    L_0x01e1:
        r1 = 1;
        goto L_0x01e4;
    L_0x01e3:
        r1 = 0;
    L_0x01e4:
        if (r12 == 0) goto L_0x01ea;
    L_0x01e6:
        if (r11 == 0) goto L_0x01ea;
    L_0x01e8:
        r2 = 1;
        goto L_0x01eb;
    L_0x01ea:
        r2 = 0;
    L_0x01eb:
        if (r13 == 0) goto L_0x01f1;
    L_0x01ed:
        if (r14 == 0) goto L_0x01f1;
    L_0x01ef:
        r3 = 1;
        goto L_0x01f2;
    L_0x01f1:
        r3 = 0;
    L_0x01f2:
        if (r5 == 0) goto L_0x01f8;
    L_0x01f4:
        if (r15 == 0) goto L_0x01f8;
    L_0x01f6:
        r5 = 1;
        goto L_0x01f9;
    L_0x01f8:
        r5 = 0;
    L_0x01f9:
        r4 = r17;
        goto L_0x0222;
    L_0x01fc:
        r0 = move-exception;
        r5 = 1;
        r9 = 1;
        r10 = 1;
        r11 = 1;
        r12 = 1;
        r13 = 1;
        r14 = 1;
        r15 = 1;
    L_0x0205:
        r2.recycle();
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 17;
        if (r1 < r2) goto L_0x021b;
    L_0x020e:
        r1 = r19.getResources();
        r1 = r1.getConfiguration();
        r1 = r1.getLayoutDirection();
        r2 = 1;
    L_0x021b:
        throw r0;
    L_0x021c:
        r2 = 1;
        r4 = 0;
        r1 = 1;
        r3 = 1;
        r5 = 1;
        r6 = 0;
    L_0x0222:
        r7 = r18.getProgressBarImage();
        if (r7 == 0) goto L_0x0236;
    L_0x0228:
        if (r6 <= 0) goto L_0x0236;
    L_0x022a:
        r7 = new com.facebook.drawee.drawable.AutoRotateDrawable;
        r8 = r18.getProgressBarImage();
        r7.<init>(r8, r6);
        r0.setProgressBarImage(r7);
    L_0x0236:
        if (r4 <= 0) goto L_0x0253;
    L_0x0238:
        r6 = getRoundingParams(r18);
        if (r1 == 0) goto L_0x0240;
    L_0x023e:
        r1 = (float) r4;
        goto L_0x0241;
    L_0x0240:
        r1 = 0;
    L_0x0241:
        if (r2 == 0) goto L_0x0245;
    L_0x0243:
        r2 = (float) r4;
        goto L_0x0246;
    L_0x0245:
        r2 = 0;
    L_0x0246:
        if (r3 == 0) goto L_0x024a;
    L_0x0248:
        r3 = (float) r4;
        goto L_0x024b;
    L_0x024a:
        r3 = 0;
    L_0x024b:
        if (r5 == 0) goto L_0x024f;
    L_0x024d:
        r4 = (float) r4;
        goto L_0x0250;
    L_0x024f:
        r4 = 0;
    L_0x0250:
        r6.setCornersRadii(r1, r2, r3, r4);
    L_0x0253:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.generic.GenericDraweeHierarchyInflater.updateBuilder(com.facebook.drawee.generic.GenericDraweeHierarchyBuilder, android.content.Context, android.util.AttributeSet):com.facebook.drawee.generic.GenericDraweeHierarchyBuilder");
    }

    @ReturnsOwnership
    private static RoundingParams getRoundingParams(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        if (genericDraweeHierarchyBuilder.getRoundingParams() == null) {
            genericDraweeHierarchyBuilder.setRoundingParams(new RoundingParams());
        }
        return genericDraweeHierarchyBuilder.getRoundingParams();
    }

    private static Drawable getDrawable(Context context, TypedArray typedArray, int i) {
        typedArray = typedArray.getResourceId(i, 0);
        if (typedArray == null) {
            return null;
        }
        return context.getResources().getDrawable(typedArray);
    }

    private static ScaleType getScaleTypeFromXml(TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case null:
                return ScaleType.FIT_XY;
            case 1:
                return ScaleType.FIT_START;
            case 2:
                return ScaleType.FIT_CENTER;
            case 3:
                return ScaleType.FIT_END;
            case 4:
                return ScaleType.CENTER;
            case 5:
                return ScaleType.CENTER_INSIDE;
            case 6:
                return ScaleType.CENTER_CROP;
            case 7:
                return ScaleType.FOCUS_CROP;
            case 8:
                return ScaleType.FIT_BOTTOM_START;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }
}
