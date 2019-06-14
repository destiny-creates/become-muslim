package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.common.RotationOptions;
import java.io.InputStream;

class TiffUtil {
    private static final Class<?> TAG = TiffUtil.class;
    public static final int TIFF_BYTE_ORDER_BIG_END = 1296891946;
    public static final int TIFF_BYTE_ORDER_LITTLE_END = 1229531648;
    public static final int TIFF_TAG_ORIENTATION = 274;
    public static final int TIFF_TYPE_SHORT = 3;

    private static class TiffHeader {
        int byteOrder;
        int firstIfdOffset;
        boolean isLittleEndian;

        private TiffHeader() {
        }
    }

    public static int getAutoRotateAngleFromOrientation(int i) {
        if (i == 3) {
            return RotationOptions.ROTATE_180;
        }
        if (i == 6) {
            return 90;
        }
        if (i == 8) {
            return RotationOptions.ROTATE_270;
        }
        switch (i) {
            case 0:
            case 1:
                return 0;
            default:
                return 0;
        }
    }

    TiffUtil() {
    }

    public static int readOrientationFromTIFF(InputStream inputStream, int i) {
        TiffHeader tiffHeader = new TiffHeader();
        i = readTiffHeader(inputStream, i, tiffHeader);
        int i2 = tiffHeader.firstIfdOffset - 8;
        if (i != 0) {
            if (i2 <= i) {
                inputStream.skip((long) i2);
                return getOrientationFromTiffEntry(inputStream, moveToTiffEntryWithTag(inputStream, i - i2, tiffHeader.isLittleEndian, TIFF_TAG_ORIENTATION), tiffHeader.isLittleEndian);
            }
        }
        return null;
    }

    private static int readTiffHeader(InputStream inputStream, int i, TiffHeader tiffHeader) {
        if (i <= 8) {
            return 0;
        }
        tiffHeader.byteOrder = StreamProcessor.readPackedInt(inputStream, 4, false);
        i -= 4;
        if (tiffHeader.byteOrder == TIFF_BYTE_ORDER_LITTLE_END || tiffHeader.byteOrder == TIFF_BYTE_ORDER_BIG_END) {
            tiffHeader.isLittleEndian = tiffHeader.byteOrder == TIFF_BYTE_ORDER_LITTLE_END;
            tiffHeader.firstIfdOffset = StreamProcessor.readPackedInt(inputStream, 4, tiffHeader.isLittleEndian);
            i -= 4;
            if (tiffHeader.firstIfdOffset >= 8) {
                if (tiffHeader.firstIfdOffset - 8 <= i) {
                    return i;
                }
            }
            FLog.m5670e(TAG, "Invalid offset");
            return 0;
        }
        FLog.m5670e(TAG, "Invalid TIFF header");
        return 0;
    }

    private static int moveToTiffEntryWithTag(InputStream inputStream, int i, boolean z, int i2) {
        if (i < 14) {
            return 0;
        }
        int readPackedInt = StreamProcessor.readPackedInt(inputStream, 2, z);
        i -= 2;
        while (true) {
            int i3 = readPackedInt - 1;
            if (readPackedInt <= 0 || i < 12) {
                return 0;
            }
            i -= 2;
            if (StreamProcessor.readPackedInt(inputStream, 2, z) == i2) {
                return i;
            }
            inputStream.skip(10);
            i -= 10;
            readPackedInt = i3;
        }
        return 0;
    }

    private static int getOrientationFromTiffEntry(InputStream inputStream, int i, boolean z) {
        if (i < 10 || StreamProcessor.readPackedInt(inputStream, 2, z) != 3 || StreamProcessor.readPackedInt(inputStream, 4, z) != 1) {
            return 0;
        }
        int readPackedInt = StreamProcessor.readPackedInt(inputStream, 2, z);
        StreamProcessor.readPackedInt(inputStream, 2, z);
        return readPackedInt;
    }
}
