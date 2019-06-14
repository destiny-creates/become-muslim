package okhttp3.internal.http;

import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import p286d.C5875s;

public interface HttpCodec {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    C5875s createRequestBody(Request request, long j);

    void finishRequest();

    void flushRequest();

    ResponseBody openResponseBody(Response response);

    Builder readResponseHeaders(boolean z);

    void writeRequestHeaders(Request request);
}
