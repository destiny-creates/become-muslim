package okhttp3.internal.http1;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import p286d.C5870l;
import p286d.C5875s;
import p286d.C5876t;
import p286d.C5877u;
import p286d.C7203d;
import p286d.C7204e;
import p286d.C7207i;
import p286d.C8037c;

public final class Http1Codec implements HttpCodec {
    private static final int HEADER_LIMIT = 262144;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    final OkHttpClient client;
    private long headerLimit = 262144;
    final C7203d sink;
    final C7204e source;
    int state = 0;
    final StreamAllocation streamAllocation;

    private abstract class AbstractSource implements C5876t {
        protected long bytesRead;
        protected boolean closed;
        protected final C7207i timeout;

        private AbstractSource() {
            this.timeout = new C7207i(Http1Codec.this.source.timeout());
            this.bytesRead = 0;
        }

        public C5877u timeout() {
            return this.timeout;
        }

        public long read(C8037c c8037c, long j) {
            try {
                c8037c = Http1Codec.this.source.read(c8037c, j);
                if (c8037c > 0) {
                    this.bytesRead += c8037c;
                }
                return c8037c;
            } catch (C8037c c8037c2) {
                endOfInput(0, c8037c2);
                throw c8037c2;
            }
        }

        protected final void endOfInput(boolean z, IOException iOException) {
            if (Http1Codec.this.state != 6) {
                if (Http1Codec.this.state == 5) {
                    Http1Codec.this.detachTimeout(this.timeout);
                    Http1Codec.this.state = 6;
                    if (Http1Codec.this.streamAllocation != null) {
                        Http1Codec.this.streamAllocation.streamFinished(z ^ 1, Http1Codec.this, this.bytesRead, iOException);
                    }
                    return;
                }
                iOException = new StringBuilder();
                iOException.append("state: ");
                iOException.append(Http1Codec.this.state);
                throw new IllegalStateException(iOException.toString());
            }
        }
    }

    private final class ChunkedSink implements C5875s {
        private boolean closed;
        private final C7207i timeout = new C7207i(Http1Codec.this.sink.timeout());

        ChunkedSink() {
        }

        public C5877u timeout() {
            return this.timeout;
        }

        public void write(C8037c c8037c, long j) {
            if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                Http1Codec.this.sink.mo6314m(j);
                Http1Codec.this.sink.mo6294b("\r\n");
                Http1Codec.this.sink.write(c8037c, j);
                Http1Codec.this.sink.mo6294b("\r\n");
            }
        }

        public synchronized void flush() {
            if (!this.closed) {
                Http1Codec.this.sink.flush();
            }
        }

        public synchronized void close() {
            if (!this.closed) {
                this.closed = true;
                Http1Codec.this.sink.mo6294b("0\r\n\r\n");
                Http1Codec.this.detachTimeout(this.timeout);
                Http1Codec.this.state = 3;
            }
        }
    }

    private final class FixedLengthSink implements C5875s {
        private long bytesRemaining;
        private boolean closed;
        private final C7207i timeout = new C7207i(Http1Codec.this.sink.timeout());

        FixedLengthSink(long j) {
            this.bytesRemaining = j;
        }

        public C5877u timeout() {
            return this.timeout;
        }

        public void write(C8037c c8037c, long j) {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(c8037c.m38961a(), 0, j);
            if (j <= this.bytesRemaining) {
                Http1Codec.this.sink.write(c8037c, j);
                this.bytesRemaining -= j;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected ");
            stringBuilder.append(this.bytesRemaining);
            stringBuilder.append(" bytes but received ");
            stringBuilder.append(j);
            throw new ProtocolException(stringBuilder.toString());
        }

        public void flush() {
            if (!this.closed) {
                Http1Codec.this.sink.flush();
            }
        }

        public void close() {
            if (!this.closed) {
                this.closed = true;
                if (this.bytesRemaining <= 0) {
                    Http1Codec.this.detachTimeout(this.timeout);
                    Http1Codec.this.state = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    private class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk = -1;
        private boolean hasMoreChunks = true;
        private final HttpUrl url;

        ChunkedSource(HttpUrl httpUrl) {
            super();
            this.url = httpUrl;
        }

        public long read(C8037c c8037c, long j) {
            if (j < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (!this.hasMoreChunks) {
                return -1;
            } else {
                if (this.bytesRemainingInChunk == 0 || this.bytesRemainingInChunk == -1) {
                    readChunkSize();
                    if (!this.hasMoreChunks) {
                        return -1;
                    }
                }
                c8037c = super.read(c8037c, Math.min(j, this.bytesRemainingInChunk));
                if (c8037c != -1) {
                    this.bytesRemainingInChunk -= c8037c;
                    return c8037c;
                }
                c8037c = new ProtocolException("unexpected end of stream");
                endOfInput(0, c8037c);
                throw c8037c;
            }
        }

        private void readChunkSize() {
            if (this.bytesRemainingInChunk != -1) {
                Http1Codec.this.source.mo6318r();
            }
            try {
                this.bytesRemainingInChunk = Http1Codec.this.source.mo6317o();
                String trim = Http1Codec.this.source.mo6318r().trim();
                if (this.bytesRemainingInChunk < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("expected chunk size and optional extensions but was \"");
                    stringBuilder.append(this.bytesRemainingInChunk);
                    stringBuilder.append(trim);
                    stringBuilder.append("\"");
                    throw new ProtocolException(stringBuilder.toString());
                } else if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    HttpHeaders.receiveHeaders(Http1Codec.this.client.cookieJar(), this.url, Http1Codec.this.readHeaders());
                    endOfInput(true, null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() {
            if (!this.closed) {
                if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    endOfInput(false, null);
                }
                this.closed = true;
            }
        }
    }

    private class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        FixedLengthSource(long j) {
            super();
            this.bytesRemaining = j;
            if (this.bytesRemaining == 0) {
                endOfInput(true, null);
            }
        }

        public long read(C8037c c8037c, long j) {
            if (j < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.bytesRemaining == 0) {
                return -1;
            } else {
                c8037c = super.read(c8037c, Math.min(this.bytesRemaining, j));
                if (c8037c != -1) {
                    this.bytesRemaining -= c8037c;
                    if (this.bytesRemaining == 0) {
                        endOfInput(true, null);
                    }
                    return c8037c;
                }
                c8037c = new ProtocolException("unexpected end of stream");
                endOfInput(0, c8037c);
                throw c8037c;
            }
        }

        public void close() {
            if (!this.closed) {
                if (!(this.bytesRemaining == 0 || Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
                    endOfInput(false, null);
                }
                this.closed = true;
            }
        }
    }

    private class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        UnknownLengthSource() {
            super();
        }

        public long read(C8037c c8037c, long j) {
            if (j < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.inputExhausted) {
                return -1;
            } else {
                c8037c = super.read(c8037c, j);
                if (c8037c != -1) {
                    return c8037c;
                }
                this.inputExhausted = true;
                endOfInput(true, 0);
                return -1;
            }
        }

        public void close() {
            if (!this.closed) {
                if (!this.inputExhausted) {
                    endOfInput(false, null);
                }
                this.closed = true;
            }
        }
    }

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, C7204e c7204e, C7203d c7203d) {
        this.client = okHttpClient;
        this.streamAllocation = streamAllocation;
        this.source = c7204e;
        this.sink = c7203d;
    }

    public C5875s createRequestBody(Request request, long j) {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding")) != null) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newFixedLengthSink(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void cancel() {
        RealConnection connection = this.streamAllocation.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    public void writeRequestHeaders(Request request) {
        writeRequest(request.headers(), RequestLine.get(request, this.streamAllocation.connection().route().proxy().type()));
    }

    public ResponseBody openResponseBody(Response response) {
        this.streamAllocation.eventListener.responseBodyStart(this.streamAllocation.call);
        String header = response.header(com.facebook.stetho.server.http.HttpHeaders.CONTENT_TYPE);
        if (!HttpHeaders.hasBody(response)) {
            return new RealResponseBody(header, 0, C5870l.m24720a(newFixedLengthSource(0)));
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return new RealResponseBody(header, -1, C5870l.m24720a(newChunkedSource(response.request().url())));
        }
        long contentLength = HttpHeaders.contentLength(response);
        if (contentLength != -1) {
            return new RealResponseBody(header, contentLength, C5870l.m24720a(newFixedLengthSource(contentLength)));
        }
        return new RealResponseBody(header, -1, C5870l.m24720a(newUnknownLengthSource()));
    }

    public boolean isClosed() {
        return this.state == 6;
    }

    public void flushRequest() {
        this.sink.flush();
    }

    public void finishRequest() {
        this.sink.flush();
    }

    public void writeRequest(Headers headers, String str) {
        if (this.state == 0) {
            this.sink.mo6294b(str).mo6294b("\r\n");
            int size = headers.size();
            for (str = null; str < size; str++) {
                this.sink.mo6294b(headers.name(str)).mo6294b(": ").mo6294b(headers.value(str)).mo6294b("\r\n");
            }
            this.sink.mo6294b("\r\n");
            this.state = 1;
            return;
        }
        str = new StringBuilder();
        str.append("state: ");
        str.append(this.state);
        throw new IllegalStateException(str.toString());
    }

    public Builder readResponseHeaders(boolean z) {
        if (this.state != 1) {
            if (this.state != 3) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("state: ");
                stringBuilder.append(this.state);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        try {
            StatusLine parse = StatusLine.parse(readHeaderLine());
            Builder headers = new Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
            if (z && parse.code) {
                return false;
            }
            if (parse.code) {
                this.state = 3;
                return headers;
            }
            this.state = true;
            return headers;
        } catch (boolean z2) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("unexpected end of stream on ");
            stringBuilder2.append(this.streamAllocation);
            IOException iOException = new IOException(stringBuilder2.toString());
            iOException.initCause(z2);
            throw iOException;
        }
    }

    private String readHeaderLine() {
        String f = this.source.mo6302f(this.headerLimit);
        this.headerLimit -= (long) f.length();
        return f;
    }

    public Headers readHeaders() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readHeaderLine = readHeaderLine();
            if (readHeaderLine.length() == 0) {
                return builder.build();
            }
            Internal.instance.addLenient(builder, readHeaderLine);
        }
    }

    public C5875s newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.state);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public C5875s newFixedLengthSink(long j) {
        if (this.state == 1) {
            this.state = 2;
            return new FixedLengthSink(j);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.state);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public C5876t newFixedLengthSource(long j) {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(j);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.state);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public C5876t newChunkedSource(HttpUrl httpUrl) {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(httpUrl);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.state);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public C5876t newUnknownLengthSource() {
        if (this.state != 4) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("state: ");
            stringBuilder.append(this.state);
            throw new IllegalStateException(stringBuilder.toString());
        } else if (this.streamAllocation != null) {
            this.state = 5;
            this.streamAllocation.noNewStreams();
            return new UnknownLengthSource();
        } else {
            throw new IllegalStateException("streamAllocation == null");
        }
    }

    void detachTimeout(C7207i c7207i) {
        C5877u a = c7207i.m33456a();
        c7207i.m33455a(C5877u.NONE);
        a.clearDeadline();
        a.clearTimeout();
    }
}
