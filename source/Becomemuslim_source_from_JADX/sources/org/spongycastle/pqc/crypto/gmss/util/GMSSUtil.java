package org.spongycastle.pqc.crypto.gmss.util;

import com.facebook.imageutils.JfifUtil;

public class GMSSUtil {
    /* renamed from: a */
    public byte[] m29080a(int i) {
        return new byte[]{(byte) (i & JfifUtil.MARKER_FIRST_BYTE), (byte) ((i >> 8) & JfifUtil.MARKER_FIRST_BYTE), (byte) ((i >> 16) & JfifUtil.MARKER_FIRST_BYTE), (byte) ((i >> 24) & JfifUtil.MARKER_FIRST_BYTE)};
    }

    /* renamed from: a */
    public int m29079a(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        i = (bArr[i] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i2] & JfifUtil.MARKER_FIRST_BYTE) << 8);
        return ((bArr[i3 + 1] & JfifUtil.MARKER_FIRST_BYTE) << 24) | (i | ((bArr[i3] & JfifUtil.MARKER_FIRST_BYTE) << 16));
    }

    /* renamed from: a */
    public byte[] m29081a(byte[][] bArr) {
        Object obj = new byte[(bArr.length * bArr[0].length)];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            System.arraycopy(bArr[i2], 0, obj, i, bArr[i2].length);
            i += bArr[i2].length;
        }
        return obj;
    }
}
