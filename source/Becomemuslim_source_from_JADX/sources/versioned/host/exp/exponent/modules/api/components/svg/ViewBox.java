package versioned.host.exp.exponent.modules.api.components.svg;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.facebook.react.uimanager.ViewProps;

class ViewBox {
    private static final int MOS_MEET = 0;
    private static final int MOS_NONE = 2;
    private static final int MOS_SLICE = 1;

    ViewBox() {
    }

    static Matrix getTransform(RectF rectF, RectF rectF2, String str, int i) {
        RectF rectF3 = rectF;
        RectF rectF4 = rectF2;
        String str2 = str;
        int i2 = i;
        double d = (double) rectF3.left;
        double d2 = (double) rectF3.top;
        double width = (double) rectF.width();
        double height = (double) rectF.height();
        double width2 = (double) rectF2.width();
        double height2 = (double) rectF2.height();
        double d3 = (double) rectF4.top;
        double d4 = width2 / width;
        double d5 = width;
        width = height2 / height;
        double d6 = ((double) rectF4.left) - (d * d4);
        d = d3 - (d2 * width);
        d3 = height2;
        int i3 = i;
        if (i3 == 2) {
            height2 = Math.min(d4, width);
            if (height2 > 1.0d) {
                d6 -= ((width2 / height2) - d5) / 2.0d;
                d -= ((d3 / height2) - height) / 2.0d;
            } else {
                d6 -= (width2 - (d5 * height2)) / 2.0d;
                d -= (d3 - (height * height2)) / 2.0d;
            }
            d4 = height2;
        } else {
            String str3 = str;
            if (!str3.equals(ViewProps.NONE) && i3 == 0) {
                d4 = Math.min(d4, width);
            } else if (str3.equals(ViewProps.NONE) || i3 != 1) {
                height2 = d4;
                d4 = width;
                if (str3.contains("xMid")) {
                    d6 += (width2 - (d5 * height2)) / 2.0d;
                }
                if (str3.contains("xMax")) {
                    d6 += width2 - (d5 * height2);
                }
                if (str3.contains("YMid")) {
                    d += (d3 - (height * d4)) / 2.0d;
                }
                if (str3.contains("YMax")) {
                    d += d3 - (height * d4);
                }
            } else {
                d4 = Math.max(d4, width);
            }
            height2 = d4;
            if (str3.contains("xMid")) {
                d6 += (width2 - (d5 * height2)) / 2.0d;
            }
            if (str3.contains("xMax")) {
                d6 += width2 - (d5 * height2);
            }
            if (str3.contains("YMid")) {
                d += (d3 - (height * d4)) / 2.0d;
            }
            if (str3.contains("YMax")) {
                d += d3 - (height * d4);
            }
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((float) d6, (float) d);
        matrix.preScale((float) height2, (float) d4);
        return matrix;
    }
}
