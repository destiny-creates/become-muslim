package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;

class StreamProcessor {
    StreamProcessor() {
    }

    public static int readPackedInt(InputStream inputStream, int i, boolean z) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int read = inputStream.read();
            if (read != -1) {
                i3 = z ? i3 | ((read & JfifUtil.MARKER_FIRST_BYTE) << (i2 * 8)) : (i3 << 8) | (read & JfifUtil.MARKER_FIRST_BYTE);
                i2++;
            } else {
                throw new IOException("no more bytes");
            }
        }
        return i3;
    }
}
