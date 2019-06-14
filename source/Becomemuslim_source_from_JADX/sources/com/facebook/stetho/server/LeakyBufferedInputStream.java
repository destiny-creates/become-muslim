package com.facebook.stetho.server;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class LeakyBufferedInputStream extends BufferedInputStream {
    private boolean mLeaked;
    private boolean mMarked;

    public boolean markSupported() {
        return true;
    }

    public LeakyBufferedInputStream(InputStream inputStream, int i) {
        super(inputStream, i);
    }

    public synchronized void mark(int i) {
        throwIfLeaked();
        this.mMarked = true;
        super.mark(i);
    }

    public synchronized void reset() {
        throwIfLeaked();
        this.mMarked = false;
        super.reset();
    }

    public synchronized InputStream leakBufferAndStream() {
        throwIfLeaked();
        throwIfMarked();
        this.mLeaked = true;
        return new CompositeInputStream(new InputStream[]{new ByteArrayInputStream(clearBufferLocked()), this.in});
    }

    private byte[] clearBufferLocked() {
        Object obj = new byte[(this.count - this.pos)];
        System.arraycopy(this.buf, this.pos, obj, 0, obj.length);
        this.pos = 0;
        this.count = 0;
        return obj;
    }

    private void throwIfLeaked() {
        if (this.mLeaked) {
            throw new IllegalStateException();
        }
    }

    private void throwIfMarked() {
        if (this.mMarked) {
            throw new IllegalStateException();
        }
    }
}
