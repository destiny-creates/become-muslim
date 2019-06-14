package com.facebook.stetho.okhttp3;

import com.facebook.stetho.inspector.network.DefaultResponseHandler;
import com.facebook.stetho.inspector.network.NetworkEventReporter;
import com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorRequest;
import com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorResponse;
import com.facebook.stetho.inspector.network.NetworkEventReporterImpl;
import com.facebook.stetho.inspector.network.RequestBodyHelper;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p286d.C5870l;
import p286d.C7203d;
import p286d.C7204e;

public class StethoInterceptor implements Interceptor {
    private final NetworkEventReporter mEventReporter = NetworkEventReporterImpl.get();
    private final AtomicInteger mNextRequestId = new AtomicInteger(0);

    private static class ForwardingResponseBody extends ResponseBody {
        private final ResponseBody mBody;
        private final C7204e mInterceptedSource;

        public ForwardingResponseBody(ResponseBody responseBody, InputStream inputStream) {
            this.mBody = responseBody;
            this.mInterceptedSource = C5870l.a(C5870l.a(inputStream));
        }

        public MediaType contentType() {
            return this.mBody.contentType();
        }

        public long contentLength() {
            return this.mBody.contentLength();
        }

        public C7204e source() {
            return this.mInterceptedSource;
        }
    }

    private static class OkHttpInspectorRequest implements InspectorRequest {
        private final Request mRequest;
        private RequestBodyHelper mRequestBodyHelper;
        private final String mRequestId;

        public String friendlyName() {
            return null;
        }

        public Integer friendlyNameExtra() {
            return null;
        }

        public OkHttpInspectorRequest(String str, Request request, RequestBodyHelper requestBodyHelper) {
            this.mRequestId = str;
            this.mRequest = request;
            this.mRequestBodyHelper = requestBodyHelper;
        }

        public String id() {
            return this.mRequestId;
        }

        public String url() {
            return this.mRequest.url().toString();
        }

        public String method() {
            return this.mRequest.method();
        }

        public byte[] body() {
            RequestBody body = this.mRequest.body();
            if (body == null) {
                return null;
            }
            C7203d a = C5870l.a(C5870l.a(this.mRequestBodyHelper.createBodySink(firstHeaderValue("Content-Encoding"))));
            try {
                body.writeTo(a);
                return this.mRequestBodyHelper.getDisplayBody();
            } finally {
                a.close();
            }
        }

        public int headerCount() {
            return this.mRequest.headers().size();
        }

        public String headerName(int i) {
            return this.mRequest.headers().name(i);
        }

        public String headerValue(int i) {
            return this.mRequest.headers().value(i);
        }

        public String firstHeaderValue(String str) {
            return this.mRequest.header(str);
        }
    }

    private static class OkHttpInspectorResponse implements InspectorResponse {
        private final Connection mConnection;
        private final Request mRequest;
        private final String mRequestId;
        private final Response mResponse;

        public boolean connectionReused() {
            return false;
        }

        public OkHttpInspectorResponse(String str, Request request, Response response, Connection connection) {
            this.mRequestId = str;
            this.mRequest = request;
            this.mResponse = response;
            this.mConnection = connection;
        }

        public String requestId() {
            return this.mRequestId;
        }

        public String url() {
            return this.mRequest.url().toString();
        }

        public int statusCode() {
            return this.mResponse.code();
        }

        public String reasonPhrase() {
            return this.mResponse.message();
        }

        public int connectionId() {
            return this.mConnection.hashCode();
        }

        public boolean fromDiskCache() {
            return this.mResponse.cacheResponse() != null;
        }

        public int headerCount() {
            return this.mResponse.headers().size();
        }

        public String headerName(int i) {
            return this.mResponse.headers().name(i);
        }

        public String headerValue(int i) {
            return this.mResponse.headers().value(i);
        }

        public String firstHeaderValue(String str) {
            return this.mResponse.header(str);
        }
    }

    public Response intercept(Chain chain) {
        RequestBodyHelper requestBodyHelper;
        String valueOf = String.valueOf(this.mNextRequestId.getAndIncrement());
        Request request = chain.request();
        String str = null;
        if (this.mEventReporter.isEnabled()) {
            requestBodyHelper = new RequestBodyHelper(this.mEventReporter, valueOf);
            this.mEventReporter.requestWillBeSent(new OkHttpInspectorRequest(valueOf, request, requestBodyHelper));
        } else {
            requestBodyHelper = null;
        }
        try {
            Response proceed = chain.proceed(request);
            if (!this.mEventReporter.isEnabled()) {
                return proceed;
            }
            MediaType contentType;
            InputStream byteStream;
            if (requestBodyHelper != null && requestBodyHelper.hasBody()) {
                requestBodyHelper.reportDataSent();
            }
            this.mEventReporter.responseHeadersReceived(new OkHttpInspectorResponse(valueOf, request, proceed, chain.connection()));
            chain = proceed.body();
            if (chain != null) {
                contentType = chain.contentType();
                byteStream = chain.byteStream();
            } else {
                contentType = null;
                byteStream = contentType;
            }
            NetworkEventReporter networkEventReporter = this.mEventReporter;
            if (contentType != null) {
                str = contentType.toString();
            }
            InputStream interpretResponseStream = networkEventReporter.interpretResponseStream(valueOf, str, proceed.header("Content-Encoding"), byteStream, new DefaultResponseHandler(this.mEventReporter, valueOf));
            if (interpretResponseStream != null) {
                return proceed.newBuilder().body(new ForwardingResponseBody(chain, interpretResponseStream)).build();
            }
            return proceed;
        } catch (Chain chain2) {
            if (this.mEventReporter.isEnabled()) {
                this.mEventReporter.httpExchangeFailed(valueOf, chain2.toString());
            }
            throw chain2;
        }
    }
}
