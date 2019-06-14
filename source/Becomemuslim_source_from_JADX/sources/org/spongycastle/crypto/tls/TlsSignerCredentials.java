package org.spongycastle.crypto.tls;

public interface TlsSignerCredentials extends TlsCredentials {
    SignatureAndHashAlgorithm S_();

    /* renamed from: a */
    byte[] mo6814a(byte[] bArr);
}
