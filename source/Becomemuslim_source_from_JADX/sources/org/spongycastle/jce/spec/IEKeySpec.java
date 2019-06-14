package org.spongycastle.jce.spec;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import org.spongycastle.jce.interfaces.IESKey;

public class IEKeySpec implements KeySpec, IESKey {
    /* renamed from: a */
    private PublicKey f27630a;
    /* renamed from: b */
    private PrivateKey f27631b;

    public String getAlgorithm() {
        return "IES";
    }

    public byte[] getEncoded() {
        return null;
    }

    public String getFormat() {
        return null;
    }

    /* renamed from: a */
    public PublicKey mo5894a() {
        return this.f27630a;
    }

    /* renamed from: b */
    public PrivateKey mo5895b() {
        return this.f27631b;
    }
}
