package org.spongycastle.jcajce.spec;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.util.Arrays;

public class MQVParameterSpec implements AlgorithmParameterSpec {
    /* renamed from: a */
    private final PublicKey f22902a;
    /* renamed from: b */
    private final PrivateKey f22903b;
    /* renamed from: c */
    private final PublicKey f22904c;
    /* renamed from: d */
    private final byte[] f22905d;

    /* renamed from: a */
    public PrivateKey m28106a() {
        return this.f22903b;
    }

    /* renamed from: b */
    public PublicKey m28107b() {
        return this.f22902a;
    }

    /* renamed from: c */
    public PublicKey m28108c() {
        return this.f22904c;
    }

    /* renamed from: d */
    public byte[] m28109d() {
        return Arrays.m29373b(this.f22905d);
    }
}
