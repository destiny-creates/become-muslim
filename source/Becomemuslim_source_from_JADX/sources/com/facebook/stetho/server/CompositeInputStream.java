package com.facebook.stetho.server;

import com.facebook.stetho.common.LogUtil;
import java.io.IOException;
import java.io.InputStream;

public class CompositeInputStream extends InputStream {
    private int mCurrentIndex;
    private final InputStream[] mStreams;

    public boolean markSupported() {
        return false;
    }

    public CompositeInputStream(InputStream[] inputStreamArr) {
        if (inputStreamArr == null || inputStreamArr.length < 2) {
            throw new IllegalArgumentException("Streams must be non-null and have more than 1 entry");
        }
        this.mStreams = inputStreamArr;
        this.mCurrentIndex = null;
    }

    public int available() {
        return this.mStreams[this.mCurrentIndex].available();
    }

    public void close() {
        closeAll(this.mCurrentIndex);
    }

    private void closeAll(int i) {
        Throwable th = null;
        for (int i2 = 0; i2 < this.mStreams.length; i2++) {
            try {
                this.mStreams[i2].close();
            } catch (IOException e) {
                Throwable e2 = e;
                if (i2 != i) {
                    if (th != null) {
                        e2 = th;
                    }
                }
                if (!(th == null || th == e2)) {
                    LogUtil.m5756w(th, "Suppressing exception");
                }
                th = e2;
            }
        }
    }

    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    public void reset() {
        throw new UnsupportedOperationException();
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        int read;
        do {
            read = this.mStreams[this.mCurrentIndex].read(bArr, i, i2);
            if (read != -1) {
                break;
            }
        } while (tryMoveToNextStream());
        return read;
    }

    public int read() {
        int read;
        do {
            read = this.mStreams[this.mCurrentIndex].read();
            if (read != -1) {
                break;
            }
        } while (tryMoveToNextStream());
        return read;
    }

    private boolean tryMoveToNextStream() {
        if (this.mCurrentIndex + 1 >= this.mStreams.length) {
            return false;
        }
        this.mCurrentIndex++;
        return true;
    }

    public long skip(long j) {
        j = read(new byte[((int) j)]);
        return j >= null ? (long) j : -1;
    }
}
