package org.spongycastle.jce.interfaces;

import java.math.BigInteger;
import java.security.PrivateKey;

public interface GOST3410PrivateKey extends PrivateKey, GOST3410Key {
    /* renamed from: c */
    BigInteger mo6510c();
}
