package org.spongycastle.asn1.eac;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.util.Arrays;

public class PackedDate {
    /* renamed from: a */
    private byte[] f21624a;

    public int hashCode() {
        return Arrays.m29342a(this.f21624a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PackedDate)) {
            return null;
        }
        return Arrays.m29353a(this.f21624a, ((PackedDate) obj).f21624a);
    }

    public String toString() {
        char[] cArr = new char[this.f21624a.length];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) ((this.f21624a[i] & JfifUtil.MARKER_FIRST_BYTE) + 48);
        }
        return new String(cArr);
    }
}
