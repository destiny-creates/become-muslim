package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.InputStream;

final class np extends FilterInputStream {
    /* renamed from: a */
    private final long f15839a;
    /* renamed from: b */
    private long f15840b;

    np(InputStream inputStream, long j) {
        super(inputStream);
        this.f15839a = j;
    }

    /* renamed from: a */
    final long m19951a() {
        return this.f15839a - this.f15840b;
    }

    public final int read() {
        int read = super.read();
        if (read != -1) {
            this.f15840b++;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.f15840b += (long) read;
        }
        return read;
    }
}
