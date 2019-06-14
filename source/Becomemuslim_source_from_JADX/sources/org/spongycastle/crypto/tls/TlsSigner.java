package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public interface TlsSigner {
    /* renamed from: a */
    Signer mo6494a(SignatureAndHashAlgorithm signatureAndHashAlgorithm, AsymmetricKeyParameter asymmetricKeyParameter);

    /* renamed from: a */
    void mo5825a(TlsContext tlsContext);

    /* renamed from: a */
    boolean mo6497a(AsymmetricKeyParameter asymmetricKeyParameter);

    /* renamed from: a */
    boolean mo6495a(SignatureAndHashAlgorithm signatureAndHashAlgorithm, byte[] bArr, AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr2);

    /* renamed from: a */
    byte[] mo5826a(AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr);

    /* renamed from: a */
    byte[] mo6496a(SignatureAndHashAlgorithm signatureAndHashAlgorithm, AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr);
}
