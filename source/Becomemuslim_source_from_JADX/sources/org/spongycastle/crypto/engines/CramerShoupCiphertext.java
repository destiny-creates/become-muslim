package org.spongycastle.crypto.engines;

import java.math.BigInteger;

public class CramerShoupCiphertext {
    /* renamed from: a */
    BigInteger f22312a;
    /* renamed from: b */
    BigInteger f22313b;
    /* renamed from: c */
    BigInteger f22314c;
    /* renamed from: d */
    BigInteger f22315d;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("u1: ");
        stringBuilder.append(this.f22312a.toString());
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("\nu2: ");
        stringBuilder.append(this.f22313b.toString());
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("\ne: ");
        stringBuilder.append(this.f22314c.toString());
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("\nv: ");
        stringBuilder.append(this.f22315d.toString());
        stringBuffer.append(stringBuilder.toString());
        return stringBuffer.toString();
    }
}
