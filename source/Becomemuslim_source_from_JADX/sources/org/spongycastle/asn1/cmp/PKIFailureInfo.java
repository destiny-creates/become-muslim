package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.DERBitString;

public class PKIFailureInfo extends DERBitString {
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PKIFailureInfo: 0x");
        stringBuilder.append(Integer.toHexString(m43062j()));
        return stringBuilder.toString();
    }
}
