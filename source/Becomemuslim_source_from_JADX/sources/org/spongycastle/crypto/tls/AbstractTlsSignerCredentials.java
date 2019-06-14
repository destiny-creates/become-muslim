package org.spongycastle.crypto.tls;

public abstract class AbstractTlsSignerCredentials extends AbstractTlsCredentials implements TlsSignerCredentials {
    public SignatureAndHashAlgorithm S_() {
        throw new IllegalStateException("TlsSignerCredentials implementation does not support (D)TLS 1.2+");
    }
}
