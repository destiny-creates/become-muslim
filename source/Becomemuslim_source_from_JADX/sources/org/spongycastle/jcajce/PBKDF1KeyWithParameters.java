package org.spongycastle.jcajce;

import javax.crypto.interfaces.PBEKey;

public class PBKDF1KeyWithParameters extends PBKDF1Key implements PBEKey {
    /* renamed from: a */
    private final byte[] f31867a;
    /* renamed from: b */
    private final int f31868b;

    public byte[] getSalt() {
        return this.f31867a;
    }

    public int getIterationCount() {
        return this.f31868b;
    }
}
