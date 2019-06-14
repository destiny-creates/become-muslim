package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.Signer;

class SignerInputBuffer extends ByteArrayOutputStream {
    SignerInputBuffer() {
    }

    /* renamed from: a */
    void m27621a(Signer signer) {
        signer.mo5797a(this.buf, 0, this.count);
    }
}
