package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LimitedInputStream extends FilterInputStream {
    private int mBytesToRead;
    private int mBytesToReadWhenMarked;

    public LimitedInputStream(InputStream inputStream, int i) {
        super(inputStream);
        if (inputStream == null) {
            throw new NullPointerException();
        } else if (i >= 0) {
            this.mBytesToRead = i;
            this.mBytesToReadWhenMarked = -1;
        } else {
            throw new IllegalArgumentException("limit must be >= 0");
        }
    }

    public int read() {
        if (this.mBytesToRead == 0) {
            return -1;
        }
        int read = this.in.read();
        if (read != -1) {
            this.mBytesToRead--;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.mBytesToRead == 0) {
            return -1;
        }
        bArr = this.in.read(bArr, i, Math.min(i2, this.mBytesToRead));
        if (bArr > null) {
            this.mBytesToRead -= bArr;
        }
        return bArr;
    }

    public long skip(long j) {
        j = this.in.skip(Math.min(j, (long) this.mBytesToRead));
        this.mBytesToRead = (int) (((long) this.mBytesToRead) - j);
        return j;
    }

    public int available() {
        return Math.min(this.in.available(), this.mBytesToRead);
    }

    public void mark(int i) {
        if (this.in.markSupported()) {
            this.in.mark(i);
            this.mBytesToReadWhenMarked = this.mBytesToRead;
        }
    }

    public void reset() {
        if (!this.in.markSupported()) {
            throw new IOException("mark is not supported");
        } else if (this.mBytesToReadWhenMarked != -1) {
            this.in.reset();
            this.mBytesToRead = this.mBytesToReadWhenMarked;
        } else {
            throw new IOException("mark not set");
        }
    }
}
