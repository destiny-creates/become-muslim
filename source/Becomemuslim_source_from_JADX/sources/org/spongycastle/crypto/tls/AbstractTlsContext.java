package org.spongycastle.crypto.tls;

import java.security.SecureRandom;
import org.spongycastle.crypto.prng.RandomGenerator;
import org.spongycastle.util.Times;

abstract class AbstractTlsContext implements TlsContext {
    /* renamed from: a */
    private static long f27292a = Times.m29430a();
    /* renamed from: b */
    private RandomGenerator f27293b;
    /* renamed from: c */
    private SecureRandom f27294c;
    /* renamed from: d */
    private SecurityParameters f27295d;
    /* renamed from: e */
    private ProtocolVersion f27296e;
    /* renamed from: f */
    private ProtocolVersion f27297f;

    /* renamed from: a */
    public RandomGenerator mo5808a() {
        return this.f27293b;
    }

    /* renamed from: b */
    public SecureRandom mo5809b() {
        return this.f27294c;
    }

    /* renamed from: c */
    public SecurityParameters mo5810c() {
        return this.f27295d;
    }

    /* renamed from: d */
    public ProtocolVersion mo5811d() {
        return this.f27296e;
    }

    /* renamed from: a */
    void m35847a(ProtocolVersion protocolVersion) {
        this.f27296e = protocolVersion;
    }

    /* renamed from: e */
    public ProtocolVersion mo5812e() {
        return this.f27297f;
    }

    /* renamed from: b */
    void m35849b(ProtocolVersion protocolVersion) {
        this.f27297f = protocolVersion;
    }
}
