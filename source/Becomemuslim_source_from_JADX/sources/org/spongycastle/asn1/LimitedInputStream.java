package org.spongycastle.asn1;

import java.io.InputStream;

abstract class LimitedInputStream extends InputStream {
    /* renamed from: a */
    protected final InputStream f21459a;
    /* renamed from: b */
    private int f21460b;

    LimitedInputStream(InputStream inputStream, int i) {
        this.f21459a = inputStream;
        this.f21460b = i;
    }

    /* renamed from: a */
    int mo5715a() {
        return this.f21460b;
    }

    /* renamed from: b */
    protected void m27165b(boolean z) {
        if (this.f21459a instanceof IndefiniteLengthInputStream) {
            ((IndefiniteLengthInputStream) this.f21459a).m34611a(z);
        }
    }
}
