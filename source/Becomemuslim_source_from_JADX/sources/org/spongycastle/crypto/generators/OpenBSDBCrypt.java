package org.spongycastle.crypto.generators;

import com.facebook.stetho.dumpapp.Framer;

public class OpenBSDBCrypt {
    /* renamed from: a */
    private static final byte[] f22377a = new byte[]{(byte) 46, (byte) 47, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, Framer.EXIT_FRAME_PREFIX, (byte) 121, (byte) 122, (byte) 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57};
    /* renamed from: b */
    private static final byte[] f22378b = new byte[128];

    static {
        for (int i = 0; i < f22378b.length; i++) {
            f22378b[i] = (byte) -1;
        }
        for (int i2 = 0; i2 < f22377a.length; i2++) {
            f22378b[f22377a[i2]] = (byte) i2;
        }
    }
}
