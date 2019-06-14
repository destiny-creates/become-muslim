package org.spongycastle.asn1.misc;

import org.spongycastle.asn1.DERIA5String;

public class VerisignCzagExtension extends DERIA5String {
    public VerisignCzagExtension(DERIA5String dERIA5String) {
        super(dERIA5String.mo6440b());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VerisignCzagExtension: ");
        stringBuilder.append(mo6440b());
        return stringBuilder.toString();
    }
}
