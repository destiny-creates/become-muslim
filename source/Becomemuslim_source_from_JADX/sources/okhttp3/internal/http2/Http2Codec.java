package okhttp3.internal.http2;

import com.facebook.stetho.server.http.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import p286d.C5869f;
import p286d.C5870l;
import p286d.C5875s;
import p286d.C5876t;
import p286d.C7206h;
import p286d.C8037c;

public final class Http2Codec implements HttpCodec {
    private static final C5869f CONNECTION = C5869f.m24697a("connection");
    private static final C5869f ENCODING = C5869f.m24697a("encoding");
    private static final C5869f HOST = C5869f.m24697a("host");
    private static final List<C5869f> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY);
    private static final List<C5869f> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE);
    private static final C5869f KEEP_ALIVE = C5869f.m24697a("keep-alive");
    private static final C5869f PROXY_CONNECTION = C5869f.m24697a("proxy-connection");
    private static final C5869f TE = C5869f.m24697a("te");
    private static final C5869f TRANSFER_ENCODING = C5869f.m24697a("transfer-encoding");
    private static final C5869f UPGRADE = C5869f.m24697a("upgrade");
    private final Chain chain;
    private final OkHttpClient client;
    private final Http2Connection connection;
    private Http2Stream stream;
    final StreamAllocation streamAllocation;

    class StreamFinishingSource extends C7206h {
        long bytesRead = null;
        boolean completed = null;

        StreamFinishingSource(C5876t c5876t) {
            super(c5876t);
        }

        public long read(C8037c c8037c, long j) {
            try {
                c8037c = delegate().read(c8037c, j);
                if (c8037c > 0) {
                    this.bytesRead += c8037c;
                }
                return c8037c;
            } catch (C8037c c8037c2) {
                endOfInput(c8037c2);
                throw c8037c2;
            }
        }

        public void close() {
            super.close();
            endOfInput(null);
        }

        private void endOfInput(IOException iOException) {
            if (!this.completed) {
                this.completed = true;
                Http2Codec.this.streamAllocation.streamFinished(false, Http2Codec.this, this.bytesRead, iOException);
            }
        }
    }

    public Http2Codec(OkHttpClient okHttpClient, Chain chain, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        this.client = okHttpClient;
        this.chain = chain;
        this.streamAllocation = streamAllocation;
        this.connection = http2Connection;
    }

    public C5875s createRequestBody(Request request, long j) {
        return this.stream.getSink();
    }

    public void writeRequestHeaders(Request request) {
        if (this.stream == null) {
            this.stream = this.connection.newStream(http2HeadersList(request), request.body() != null);
            this.stream.readTimeout().timeout((long) this.chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.stream.writeTimeout().timeout((long) this.chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public void flushRequest() {
        this.connection.flush();
    }

    public void finishRequest() {
        this.stream.getSink().close();
    }

    public Builder readResponseHeaders(boolean z) {
        Builder readHttp2HeadersList = readHttp2HeadersList(this.stream.takeResponseHeaders());
        return (z && Internal.instance.code(readHttp2HeadersList)) ? false : readHttp2HeadersList;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        List<Header> arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        String header = request.header("Host");
        if (header != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (request = null; request < size; request++) {
            C5869f a = C5869f.m24697a(headers.name(request).toLowerCase(Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(a)) {
                arrayList.add(new Header(a, headers.value(request)));
            }
        }
        return arrayList;
    }

    public static Builder readHttp2HeadersList(List<Header> list) {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        Headers.Builder builder2 = builder;
        StatusLine statusLine = null;
        for (int i = 0; i < size; i++) {
            Header header = (Header) list.get(i);
            if (header != null) {
                C5869f c5869f = header.name;
                String a = header.value.mo5099a();
                if (c5869f.equals(Header.RESPONSE_STATUS)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("HTTP/1.1 ");
                    stringBuilder.append(a);
                    statusLine = StatusLine.parse(stringBuilder.toString());
                } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(c5869f)) {
                    Internal.instance.addLenient(builder2, c5869f.mo5099a(), a);
                }
            } else if (statusLine != null && statusLine.code == 100) {
                builder2 = new Headers.Builder();
                statusLine = null;
            }
        }
        if (statusLine != null) {
            return new Builder().protocol(Protocol.HTTP_2).code(statusLine.code).message(statusLine.message).headers(builder2.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public ResponseBody openResponseBody(Response response) {
        this.streamAllocation.eventListener.responseBodyStart(this.streamAllocation.call);
        return new RealResponseBody(response.header(HttpHeaders.CONTENT_TYPE), okhttp3.internal.http.HttpHeaders.contentLength(response), C5870l.m24720a(new StreamFinishingSource(this.stream.getSource())));
    }

    public void cancel() {
        if (this.stream != null) {
            this.stream.closeLater(ErrorCode.CANCEL);
        }
    }
}
