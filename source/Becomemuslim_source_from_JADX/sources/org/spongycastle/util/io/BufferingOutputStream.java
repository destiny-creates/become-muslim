package org.spongycastle.util.io;

import java.io.OutputStream;
import org.spongycastle.util.Arrays;

public class BufferingOutputStream extends OutputStream {
    /* renamed from: a */
    private final OutputStream f23442a;
    /* renamed from: b */
    private final byte[] f23443b;
    /* renamed from: c */
    private int f23444c;

    public void write(byte[] bArr, int i, int i2) {
        if (i2 < this.f23443b.length - this.f23444c) {
            System.arraycopy(bArr, i, this.f23443b, this.f23444c, i2);
            this.f23444c += i2;
            return;
        }
        int length = this.f23443b.length - this.f23444c;
        System.arraycopy(bArr, i, this.f23443b, this.f23444c, length);
        this.f23444c += length;
        flush();
        i += length;
        i2 -= length;
        while (i2 >= this.f23443b.length) {
            this.f23442a.write(bArr, i, this.f23443b.length);
            i += this.f23443b.length;
            i2 -= this.f23443b.length;
        }
        if (i2 > 0) {
            System.arraycopy(bArr, i, this.f23443b, this.f23444c, i2);
            this.f23444c += i2;
        }
    }

    public void write(int i) {
        byte[] bArr = this.f23443b;
        int i2 = this.f23444c;
        this.f23444c = i2 + 1;
        bArr[i2] = (byte) i;
        if (this.f23444c == this.f23443b.length) {
            flush();
        }
    }

    public void flush() {
        this.f23442a.write(this.f23443b, 0, this.f23444c);
        this.f23444c = 0;
        Arrays.m29351a(this.f23443b, (byte) 0);
    }

    public void close() {
        flush();
        this.f23442a.close();
    }
}
