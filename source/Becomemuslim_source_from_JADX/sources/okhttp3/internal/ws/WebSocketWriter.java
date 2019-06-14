package okhttp3.internal.ws;

import java.io.IOException;
import java.util.Random;
import p286d.C5869f;
import p286d.C5875s;
import p286d.C5877u;
import p286d.C7203d;
import p286d.C8037c;
import p286d.C8037c.C5868a;

final class WebSocketWriter {
    boolean activeWriter;
    final C8037c buffer = new C8037c();
    final FrameSink frameSink = new FrameSink();
    final boolean isClient;
    private final C5868a maskCursor;
    private final byte[] maskKey;
    final Random random;
    final C7203d sink;
    final C8037c sinkBuffer;
    boolean writerClosed;

    final class FrameSink implements C5875s {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        FrameSink() {
        }

        public void write(C8037c c8037c, long j) {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter.this.buffer.write(c8037c, j);
            c8037c = (this.isFirstFrame == null || this.contentLength == -1 || WebSocketWriter.this.buffer.m38961a() <= this.contentLength - 8192) ? null : true;
            long g = WebSocketWriter.this.buffer.m39001g();
            if (g > 0 && c8037c == null) {
                WebSocketWriter.this.writeMessageFrame(this.formatOpcode, g, this.isFirstFrame, false);
                this.isFirstFrame = 0;
            }
        }

        public void flush() {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter.this.writeMessageFrame(this.formatOpcode, WebSocketWriter.this.buffer.m38961a(), this.isFirstFrame, false);
            this.isFirstFrame = false;
        }

        public C5877u timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        public void close() {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter.this.writeMessageFrame(this.formatOpcode, WebSocketWriter.this.buffer.m38961a(), this.isFirstFrame, true);
            this.closed = true;
            WebSocketWriter.this.activeWriter = false;
        }
    }

    WebSocketWriter(boolean z, C7203d c7203d, Random random) {
        if (c7203d == null) {
            throw new NullPointerException("sink == null");
        } else if (random != null) {
            this.isClient = z;
            this.sink = c7203d;
            this.sinkBuffer = c7203d.mo6292b();
            this.random = random;
            c7203d = null;
            this.maskKey = z ? new byte[4] : null;
            if (z) {
                c7203d = new C5868a();
            }
            this.maskCursor = c7203d;
        } else {
            throw new NullPointerException("random == null");
        }
    }

    void writePing(C5869f c5869f) {
        writeControlFrame(9, c5869f);
    }

    void writePong(C5869f c5869f) {
        writeControlFrame(10, c5869f);
    }

    void writeClose(int i, C5869f c5869f) {
        C5869f c5869f2 = C5869f.f19527b;
        if (!(i == 0 && c5869f == null)) {
            if (i != 0) {
                WebSocketProtocol.validateCloseCode(i);
            }
            C8037c c8037c = new C8037c();
            c8037c.m38989c(i);
            if (c5869f != null) {
                c8037c.m38968a(c5869f);
            }
            c5869f2 = c8037c.m39021p();
        }
        try {
            writeControlFrame(8, c5869f2);
        } finally {
            this.writerClosed = true;
        }
    }

    private void writeControlFrame(int i, C5869f c5869f) {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int h = c5869f.mo5110h();
        if (((long) h) <= 125) {
            this.sinkBuffer.m38981b(i | 128);
            if (this.isClient != 0) {
                this.sinkBuffer.m38981b(h | 128);
                this.random.nextBytes(this.maskKey);
                this.sinkBuffer.m38982b(this.maskKey);
                if (h > 0) {
                    long a = this.sinkBuffer.m38961a();
                    this.sinkBuffer.m38968a(c5869f);
                    this.sinkBuffer.m38965a(this.maskCursor);
                    this.maskCursor.m24693a(a);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            } else {
                this.sinkBuffer.m38981b(h);
                this.sinkBuffer.m38968a(c5869f);
            }
            this.sink.flush();
            return;
        }
        throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    }

    C5875s newMessageSink(int i, long j) {
        if (this.activeWriter) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.activeWriter = true;
        this.frameSink.formatOpcode = i;
        this.frameSink.contentLength = j;
        this.frameSink.isFirstFrame = true;
        this.frameSink.closed = 0;
        return this.frameSink;
    }

    void writeMessageFrame(int i, long j, boolean z, boolean z2) {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int i2 = 0;
        if (!z) {
            i = 0;
        }
        if (z2) {
            i |= 128;
        }
        this.sinkBuffer.m38981b(i);
        if (this.isClient != 0) {
            i2 = 128;
        }
        if (j <= true) {
            this.sinkBuffer.m38981b(((int) j) | i2);
        } else if (j <= true) {
            this.sinkBuffer.m38981b(i2 | 126);
            this.sinkBuffer.m38989c((int) j);
        } else {
            this.sinkBuffer.m38981b(i2 | 127);
            this.sinkBuffer.m39011j(j);
        }
        if (this.isClient != 0) {
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.m38982b(this.maskKey);
            if (j > false) {
                z = this.sinkBuffer.m38961a();
                this.sinkBuffer.write(this.buffer, j);
                this.sinkBuffer.m38965a(this.maskCursor);
                this.maskCursor.m24693a(z);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.write(this.buffer, j);
        }
        this.sink.mo6298d();
    }
}
