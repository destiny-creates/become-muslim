package okhttp3.internal.huc;

import com.facebook.stetho.server.http.HttpHeaders;
import okhttp3.Request;
import p286d.C7203d;
import p286d.C8037c;

final class BufferedRequestBody extends OutputStreamRequestBody {
    final C8037c buffer = new C8037c();
    long contentLength = -1;

    BufferedRequestBody(long j) {
        initOutputStream(this.buffer, j);
    }

    public long contentLength() {
        return this.contentLength;
    }

    public Request prepareToSendRequest(Request request) {
        if (request.header(HttpHeaders.CONTENT_LENGTH) != null) {
            return request;
        }
        outputStream().close();
        this.contentLength = this.buffer.m38961a();
        return request.newBuilder().removeHeader("Transfer-Encoding").header(HttpHeaders.CONTENT_LENGTH, Long.toString(this.buffer.m38961a())).build();
    }

    public void writeTo(C7203d c7203d) {
        this.buffer.m38967a(c7203d.mo6292b(), 0, this.buffer.m38961a());
    }
}
