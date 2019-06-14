package okhttp3.internal.http2;

import android.support.v7.widget.LinearLayoutManager;
import com.facebook.imageutils.JfifUtil;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import p286d.C7203d;
import p286d.C8037c;

final class Http2Writer implements Closeable {
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final C8037c hpackBuffer = new C8037c();
    final Writer hpackWriter = new Writer(this.hpackBuffer);
    private int maxFrameSize = 16384;
    private final C7203d sink;

    Http2Writer(C7203d c7203d, boolean z) {
        this.sink = c7203d;
        this.client = z;
    }

    public synchronized void connectionPreface() {
        if (this.closed) {
            throw new IOException("closed");
        } else if (this.client) {
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.mo5108f()));
            }
            this.sink.mo6296c(Http2.CONNECTION_PREFACE.mo5112i());
            this.sink.flush();
        }
    }

    public synchronized void applyAndAckSettings(Settings settings) {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
        if (settings.getHeaderTableSize() != -1) {
            this.hpackWriter.setHeaderTableSizeSetting(settings.getHeaderTableSize());
        }
        frameHeader(0, 0, (byte) 4, (byte) 1);
        this.sink.flush();
    }

    public synchronized void pushPromise(int i, int i2, List<Header> list) {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long a = this.hpackBuffer.m38961a();
        list = (int) Math.min((long) (this.maxFrameSize - 4), a);
        long j = (long) list;
        int i3 = (a > j ? 1 : (a == j ? 0 : -1));
        frameHeader(i, list + 4, (byte) 5, i3 == 0 ? (byte) 4 : (byte) 0);
        this.sink.mo6303g(i2 & Integer.MAX_VALUE);
        this.sink.write(this.hpackBuffer, j);
        if (i3 > 0) {
            writeContinuationFrames(i, a - j);
        }
    }

    public synchronized void flush() {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public synchronized void synStream(boolean z, int i, int i2, List<Header> list) {
        if (this.closed == 0) {
            headers(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void synReply(boolean z, int i, List<Header> list) {
        if (this.closed) {
            throw new IOException("closed");
        }
        headers(z, i, list);
    }

    public synchronized void headers(int i, List<Header> list) {
        if (this.closed) {
            throw new IOException("closed");
        }
        headers(false, i, list);
    }

    public synchronized void rstStream(int i, ErrorCode errorCode) {
        if (this.closed) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            frameHeader(i, 4, (byte) 3, (byte) 0);
            this.sink.mo6303g(errorCode.httpCode);
            this.sink.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int maxDataLength() {
        return this.maxFrameSize;
    }

    public synchronized void data(boolean z, int i, C8037c c8037c, int i2) {
        if (this.closed) {
            throw new IOException("closed");
        }
        byte b = (byte) 0;
        if (z) {
            b = (byte) true;
        }
        dataFrame(i, b, c8037c, i2);
    }

    void dataFrame(int i, byte b, C8037c c8037c, int i2) {
        frameHeader(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.sink.write(c8037c, (long) i2);
        }
    }

    public synchronized void settings(Settings settings) {
        if (this.closed) {
            throw new IOException("closed");
        }
        int i = 0;
        frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (settings.isSet(i)) {
                int i2 = i == 4 ? 3 : i == 7 ? 4 : i;
                this.sink.mo6305h(i2);
                this.sink.mo6303g(settings.get(i));
            }
            i++;
        }
        this.sink.flush();
    }

    public synchronized void ping(boolean z, int i, int i2) {
        if (this.closed) {
            throw new IOException("closed");
        }
        frameHeader(0, 8, (byte) 6, z);
        this.sink.mo6303g(i);
        this.sink.mo6303g(i2);
        this.sink.flush();
    }

    public synchronized void goAway(int i, ErrorCode errorCode, byte[] bArr) {
        if (this.closed) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.sink.mo6303g(i);
            this.sink.mo6303g(errorCode.httpCode);
            if (bArr.length > 0) {
                this.sink.mo6296c(bArr);
            }
            this.sink.flush();
        } else {
            throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
        }
    }

    public synchronized void windowUpdate(int i, long j) {
        if (this.closed) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        } else {
            frameHeader(i, 4, (byte) 8, (byte) 0);
            this.sink.mo6303g((int) j);
            this.sink.flush();
        }
    }

    public void frameHeader(int i, int i2, byte b, byte b2) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.frameLog(false, i, i2, b, b2));
        }
        if (i2 > this.maxFrameSize) {
            throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(this.maxFrameSize), Integer.valueOf(i2)});
        } else if ((LinearLayoutManager.INVALID_OFFSET & i) == 0) {
            writeMedium(this.sink, i2);
            this.sink.mo6307i(b & JfifUtil.MARKER_FIRST_BYTE);
            this.sink.mo6307i(b2 & JfifUtil.MARKER_FIRST_BYTE);
            this.sink.mo6303g(i & (byte) -1);
        } else {
            throw Http2.illegalArgument("reserved bit set: %s", new Object[]{Integer.valueOf(i)});
        }
    }

    public synchronized void close() {
        this.closed = true;
        this.sink.close();
    }

    private static void writeMedium(C7203d c7203d, int i) {
        c7203d.mo6307i((i >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
        c7203d.mo6307i((i >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
        c7203d.mo6307i(i & JfifUtil.MARKER_FIRST_BYTE);
    }

    private void writeContinuationFrames(int i, long j) {
        while (j > 0) {
            int min = (int) Math.min((long) this.maxFrameSize, j);
            long j2 = (long) min;
            j -= j2;
            frameHeader(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.sink.write(this.hpackBuffer, j2);
        }
    }

    void headers(boolean z, int i, List<Header> list) {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long a = this.hpackBuffer.m38961a();
        list = (int) Math.min((long) this.maxFrameSize, a);
        long j = (long) list;
        int i2 = (a > j ? 1 : (a == j ? 0 : -1));
        byte b = i2 == 0 ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        frameHeader(i, list, true, b);
        this.sink.write(this.hpackBuffer, j);
        if (i2 > 0) {
            writeContinuationFrames(i, a - j);
        }
    }
}
