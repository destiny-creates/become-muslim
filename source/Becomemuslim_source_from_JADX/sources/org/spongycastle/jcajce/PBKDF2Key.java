package org.spongycastle.jcajce;

import org.spongycastle.crypto.CharToByteConverter;

public class PBKDF2Key implements PBKDFKey {
    /* renamed from: a */
    private final char[] f27361a;
    /* renamed from: b */
    private final CharToByteConverter f27362b;

    public String getAlgorithm() {
        return "PBKDF2";
    }

    public char[] getPassword() {
        return this.f27361a;
    }

    public String getFormat() {
        return this.f27362b.m27306a();
    }

    public byte[] getEncoded() {
        return this.f27362b.m27307a(this.f27361a);
    }
}
