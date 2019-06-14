package okhttp3.internal.http;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import p286d.C7204e;

public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final C7204e source;

    public RealResponseBody(String str, long j, C7204e c7204e) {
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = c7204e;
    }

    public MediaType contentType() {
        return this.contentTypeString != null ? MediaType.parse(this.contentTypeString) : null;
    }

    public long contentLength() {
        return this.contentLength;
    }

    public C7204e source() {
        return this.source;
    }
}
