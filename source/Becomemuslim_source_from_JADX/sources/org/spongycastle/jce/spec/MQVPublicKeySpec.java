package org.spongycastle.jce.spec;

import java.security.PublicKey;
import java.security.spec.KeySpec;
import org.spongycastle.jce.interfaces.MQVPublicKey;

public class MQVPublicKeySpec implements KeySpec, MQVPublicKey {
    /* renamed from: a */
    private PublicKey f27635a;
    /* renamed from: b */
    private PublicKey f27636b;

    public String getAlgorithm() {
        return "ECMQV";
    }

    public byte[] getEncoded() {
        return null;
    }

    public String getFormat() {
        return null;
    }

    /* renamed from: a */
    public PublicKey mo5899a() {
        return this.f27635a;
    }

    /* renamed from: b */
    public PublicKey mo5900b() {
        return this.f27636b;
    }
}
