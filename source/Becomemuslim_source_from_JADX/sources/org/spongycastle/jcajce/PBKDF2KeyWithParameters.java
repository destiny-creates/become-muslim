package org.spongycastle.jcajce;

import javax.crypto.interfaces.PBEKey;

public class PBKDF2KeyWithParameters extends PBKDF2Key implements PBEKey {
    /* renamed from: a */
    private final byte[] f31869a;
    /* renamed from: b */
    private final int f31870b;

    public byte[] getSalt() {
        return this.f31869a;
    }

    public int getIterationCount() {
        return this.f31870b;
    }
}
