package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;

public final class tt extends ByteArrayOutputStream {
    /* renamed from: a */
    private final jl f16040a;

    public tt(jl jlVar, int i) {
        this.f16040a = jlVar;
        this.buf = this.f16040a.m19607a(Math.max(i, 256));
    }

    /* renamed from: a */
    private final void m20123a(int i) {
        if (this.count + i > this.buf.length) {
            Object a = this.f16040a.m19607a((this.count + i) << 1);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.f16040a.m19606a(this.buf);
            this.buf = a;
        }
    }

    public final void close() {
        this.f16040a.m19606a(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.f16040a.m19606a(this.buf);
    }

    public final synchronized void write(int i) {
        m20123a(1);
        super.write(i);
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        m20123a(i2);
        super.write(bArr, i, i2);
    }
}
