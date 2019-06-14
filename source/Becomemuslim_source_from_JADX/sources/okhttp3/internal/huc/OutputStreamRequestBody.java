package okhttp3.internal.huc;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import p286d.C5877u;
import p286d.C7203d;

abstract class OutputStreamRequestBody extends RequestBody {
    boolean closed;
    private long expectedContentLength;
    private OutputStream outputStream;
    private C5877u timeout;

    public final MediaType contentType() {
        return null;
    }

    public Request prepareToSendRequest(Request request) {
        return request;
    }

    OutputStreamRequestBody() {
    }

    protected void initOutputStream(final C7203d c7203d, final long j) {
        this.timeout = c7203d.timeout();
        this.expectedContentLength = j;
        this.outputStream = new OutputStream() {
            private long bytesReceived;

            public void write(int i) {
                write(new byte[]{(byte) i}, 0, 1);
            }

            public void write(byte[] bArr, int i, int i2) {
                if (OutputStreamRequestBody.this.closed) {
                    throw new IOException("closed");
                }
                if (j != -1) {
                    if (this.bytesReceived + ((long) i2) > j) {
                        i = new StringBuilder();
                        i.append("expected ");
                        i.append(j);
                        i.append(" bytes but received ");
                        i.append(this.bytesReceived);
                        i.append(i2);
                        throw new ProtocolException(i.toString());
                    }
                }
                this.bytesReceived += (long) i2;
                try {
                    c7203d.mo6297c(bArr, i, i2);
                } catch (byte[] bArr2) {
                    throw new SocketTimeoutException(bArr2.getMessage());
                }
            }

            public void flush() {
                if (!OutputStreamRequestBody.this.closed) {
                    c7203d.flush();
                }
            }

            public void close() {
                OutputStreamRequestBody.this.closed = true;
                if (j != -1) {
                    if (this.bytesReceived < j) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("expected ");
                        stringBuilder.append(j);
                        stringBuilder.append(" bytes but received ");
                        stringBuilder.append(this.bytesReceived);
                        throw new ProtocolException(stringBuilder.toString());
                    }
                }
                c7203d.close();
            }
        };
    }

    public final OutputStream outputStream() {
        return this.outputStream;
    }

    public final C5877u timeout() {
        return this.timeout;
    }

    public final boolean isClosed() {
        return this.closed;
    }

    public long contentLength() {
        return this.expectedContentLength;
    }
}
