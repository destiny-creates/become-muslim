package org.spongycastle.jce.spec;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import org.spongycastle.jce.interfaces.MQVPrivateKey;

public class MQVPrivateKeySpec implements KeySpec, MQVPrivateKey {
    /* renamed from: a */
    private PrivateKey f27632a;
    /* renamed from: b */
    private PrivateKey f27633b;
    /* renamed from: c */
    private PublicKey f27634c;

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
    public PrivateKey mo5896a() {
        return this.f27632a;
    }

    /* renamed from: b */
    public PrivateKey mo5897b() {
        return this.f27633b;
    }

    /* renamed from: c */
    public PublicKey mo5898c() {
        return this.f27634c;
    }
}
