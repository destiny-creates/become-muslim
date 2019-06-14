package com.facebook.imageformat;

import com.facebook.common.internal.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public final class DefaultImageFormats {
    public static final ImageFormat BMP = new ImageFormat("BMP", "bmp");
    public static final ImageFormat GIF = new ImageFormat("GIF", "gif");
    public static final ImageFormat HEIF = new ImageFormat("HEIF", "heif");
    public static final ImageFormat JPEG = new ImageFormat("JPEG", "jpeg");
    public static final ImageFormat PNG = new ImageFormat("PNG", "png");
    public static final ImageFormat WEBP_ANIMATED = new ImageFormat("WEBP_ANIMATED", "webp");
    public static final ImageFormat WEBP_EXTENDED = new ImageFormat("WEBP_EXTENDED", "webp");
    public static final ImageFormat WEBP_EXTENDED_WITH_ALPHA = new ImageFormat("WEBP_EXTENDED_WITH_ALPHA", "webp");
    public static final ImageFormat WEBP_LOSSLESS = new ImageFormat("WEBP_LOSSLESS", "webp");
    public static final ImageFormat WEBP_SIMPLE = new ImageFormat("WEBP_SIMPLE", "webp");
    private static ImmutableList<ImageFormat> sAllDefaultFormats;

    public static boolean isWebpFormat(ImageFormat imageFormat) {
        if (!isStaticWebpFormat(imageFormat)) {
            if (imageFormat != WEBP_ANIMATED) {
                return null;
            }
        }
        return true;
    }

    public static boolean isStaticWebpFormat(ImageFormat imageFormat) {
        if (!(imageFormat == WEBP_SIMPLE || imageFormat == WEBP_LOSSLESS || imageFormat == WEBP_EXTENDED)) {
            if (imageFormat != WEBP_EXTENDED_WITH_ALPHA) {
                return null;
            }
        }
        return true;
    }

    public static List<ImageFormat> getDefaultFormats() {
        if (sAllDefaultFormats == null) {
            List arrayList = new ArrayList(9);
            arrayList.add(JPEG);
            arrayList.add(PNG);
            arrayList.add(GIF);
            arrayList.add(BMP);
            arrayList.add(WEBP_SIMPLE);
            arrayList.add(WEBP_LOSSLESS);
            arrayList.add(WEBP_EXTENDED);
            arrayList.add(WEBP_EXTENDED_WITH_ALPHA);
            arrayList.add(WEBP_ANIMATED);
            arrayList.add(HEIF);
            sAllDefaultFormats = ImmutableList.copyOf(arrayList);
        }
        return sAllDefaultFormats;
    }

    private DefaultImageFormats() {
    }
}
