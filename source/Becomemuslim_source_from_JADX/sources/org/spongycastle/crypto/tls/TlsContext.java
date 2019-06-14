package org.spongycastle.crypto.tls;

import java.security.SecureRandom;
import org.spongycastle.crypto.prng.RandomGenerator;

public interface TlsContext {
    /* renamed from: a */
    RandomGenerator mo5808a();

    /* renamed from: b */
    SecureRandom mo5809b();

    /* renamed from: c */
    SecurityParameters mo5810c();

    /* renamed from: d */
    ProtocolVersion mo5811d();

    /* renamed from: e */
    ProtocolVersion mo5812e();

    /* renamed from: f */
    boolean mo6487f();
}
