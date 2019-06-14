package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.Digest;

class DigestInputBuffer extends ByteArrayOutputStream {
    DigestInputBuffer() {
    }

    /* renamed from: a */
    void m27554a(Digest digest) {
        digest.mo5731a(this.buf, 0, this.count);
    }
}
