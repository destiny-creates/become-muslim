package okhttp3.internal.ws;

import com.facebook.imageutils.JfifUtil;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import p286d.C5869f;
import p286d.C7204e;
import p286d.C8037c;
import p286d.C8037c.C5868a;

final class WebSocketReader {
    boolean closed;
    private final C8037c controlFrameBuffer = new C8037c();
    final FrameCallback frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final C5868a maskCursor;
    private final byte[] maskKey;
    private final C8037c messageFrameBuffer = new C8037c();
    int opcode;
    final C7204e source;

    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(C5869f c5869f);

        void onReadMessage(String str);

        void onReadPing(C5869f c5869f);

        void onReadPong(C5869f c5869f);
    }

    WebSocketReader(boolean z, C7204e c7204e, FrameCallback frameCallback) {
        if (c7204e == null) {
            throw new NullPointerException("source == null");
        } else if (frameCallback != null) {
            this.isClient = z;
            this.source = c7204e;
            this.frameCallback = frameCallback;
            c7204e = null;
            if (z) {
                frameCallback = null;
            } else {
                frameCallback = new byte[4];
            }
            this.maskKey = frameCallback;
            if (!z) {
                c7204e = new C5868a();
            }
            this.maskCursor = c7204e;
        } else {
            throw new NullPointerException("frameCallback == null");
        }
    }

    void processNextFrame() {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }

    private void readHeader() {
        if (this.closed) {
            throw new IOException("closed");
        }
        long timeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            int h = this.source.mo6304h() & JfifUtil.MARKER_FIRST_BYTE;
            this.isFinalFrame = timeoutNanos != null;
            this.isControlFrame = (h & 8) != 0;
            if (this.isControlFrame) {
                if (!this.isFinalFrame) {
                    throw new ProtocolException("Control frames must be final.");
                }
            }
            Object obj = (h & 64) != 0 ? 1 : null;
            Object obj2 = (h & 32) != 0 ? 1 : null;
            Object obj3 = (h & 16) != 0 ? 1 : null;
            if (obj == null && obj2 == null && obj3 == null) {
                int h2 = this.source.mo6304h() & JfifUtil.MARKER_FIRST_BYTE;
                if ((h2 & 128) != 0) {
                }
                if (true == this.isClient) {
                    throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                }
                this.frameLength = (long) (h2 & 127);
                if (this.frameLength == 126) {
                    this.frameLength = ((long) this.source.mo6308i()) & 65535;
                } else if (this.frameLength == 127) {
                    this.frameLength = this.source.mo6311k();
                    if (this.frameLength < 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Frame length 0x");
                        stringBuilder.append(Long.toHexString(this.frameLength));
                        stringBuilder.append(" > 0x7FFFFFFFFFFFFFFF");
                        throw new ProtocolException(stringBuilder.toString());
                    }
                }
                if (this.isControlFrame) {
                    if (this.frameLength > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    }
                }
                if (1 != null) {
                    this.source.mo6290a(this.maskKey);
                    return;
                }
                return;
            }
            throw new ProtocolException("Reserved flags are unsupported.");
        } finally {
            this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
        }
    }

    private void readControlFrame() {
        if (this.frameLength > 0) {
            this.source.mo6289a(this.controlFrameBuffer, this.frameLength);
            if (!this.isClient) {
                this.controlFrameBuffer.m38965a(this.maskCursor);
                this.maskCursor.m24693a(0);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                int i = 1005;
                String str = "";
                long a = this.controlFrameBuffer.m38961a();
                if (a != 1) {
                    if (a != 0) {
                        i = this.controlFrameBuffer.mo6308i();
                        str = this.controlFrameBuffer.m39022q();
                        String closeCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(i);
                        if (closeCodeExceptionMessage != null) {
                            throw new ProtocolException(closeCodeExceptionMessage);
                        }
                    }
                    this.frameCallback.onReadClose(i, str);
                    this.closed = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.m39021p());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.m39021p());
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown control opcode: ");
                stringBuilder.append(Integer.toHexString(this.opcode));
                throw new ProtocolException(stringBuilder.toString());
        }
    }

    private void readMessageFrame() {
        int i = this.opcode;
        if (i != 1) {
            if (i != 2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown opcode: ");
                stringBuilder.append(Integer.toHexString(i));
                throw new ProtocolException(stringBuilder.toString());
            }
        }
        readMessage();
        if (i == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.m39022q());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.m39021p());
        }
    }

    private void readUntilNonControlFrame() {
        while (!this.closed) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                return;
            }
        }
    }

    private void readMessage() {
        while (!this.closed) {
            if (this.frameLength > 0) {
                this.source.mo6289a(this.messageFrameBuffer, this.frameLength);
                if (!this.isClient) {
                    this.messageFrameBuffer.m38965a(this.maskCursor);
                    this.maskCursor.m24693a(this.messageFrameBuffer.m38961a() - this.frameLength);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (!this.isFinalFrame) {
                readUntilNonControlFrame();
                if (this.opcode != 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Expected continuation opcode. Got: ");
                    stringBuilder.append(Integer.toHexString(this.opcode));
                    throw new ProtocolException(stringBuilder.toString());
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }
}
