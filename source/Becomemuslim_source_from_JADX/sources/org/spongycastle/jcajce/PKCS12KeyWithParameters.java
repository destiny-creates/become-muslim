package org.spongycastle.jcajce;

import javax.crypto.interfaces.PBEKey;

public class PKCS12KeyWithParameters extends PKCS12Key implements PBEKey {
    /* renamed from: a */
    private final byte[] f31871a;
    /* renamed from: b */
    private final int f31872b;

    public byte[] getSalt() {
        return this.f31871a;
    }

    public int getIterationCount() {
        return this.f31872b;
    }
}
