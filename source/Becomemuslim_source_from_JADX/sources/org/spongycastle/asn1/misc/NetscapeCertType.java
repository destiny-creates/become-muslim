package org.spongycastle.asn1.misc;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.asn1.DERBitString;

public class NetscapeCertType extends DERBitString {
    public NetscapeCertType(DERBitString dERBitString) {
        super(dERBitString.m43059c(), dERBitString.m43061g());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NetscapeCertType: 0x");
        stringBuilder.append(Integer.toHexString(this.a[0] & JfifUtil.MARKER_FIRST_BYTE));
        return stringBuilder.toString();
    }
}
