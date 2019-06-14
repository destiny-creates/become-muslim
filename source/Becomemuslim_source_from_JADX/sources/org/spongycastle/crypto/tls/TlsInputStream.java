package org.spongycastle.crypto.tls;

import com.facebook.imageutils.JfifUtil;
import java.io.InputStream;

class TlsInputStream extends InputStream {
    /* renamed from: a */
    private byte[] f22593a;
    /* renamed from: b */
    private TlsProtocol f22594b;

    public int available() {
        return this.f22594b.m27767g();
    }

    public int read(byte[] bArr, int i, int i2) {
        return this.f22594b.m27745a(bArr, i, i2);
    }

    public int read() {
        if (read(this.f22593a) < 0) {
            return -1;
        }
        return this.f22593a[0] & JfifUtil.MARKER_FIRST_BYTE;
    }

    public void close() {
        this.f22594b.m27772l();
    }
}
