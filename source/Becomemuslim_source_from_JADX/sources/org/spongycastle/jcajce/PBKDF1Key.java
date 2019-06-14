package org.spongycastle.jcajce;

import org.spongycastle.crypto.CharToByteConverter;

public class PBKDF1Key implements PBKDFKey {
    /* renamed from: a */
    private final char[] f27359a;
    /* renamed from: b */
    private final CharToByteConverter f27360b;

    public String getAlgorithm() {
        return "PBKDF1";
    }

    public char[] getPassword() {
        return this.f27359a;
    }

    public String getFormat() {
        return this.f27360b.m27306a();
    }

    public byte[] getEncoded() {
        return this.f27360b.m27307a(this.f27359a);
    }
}
