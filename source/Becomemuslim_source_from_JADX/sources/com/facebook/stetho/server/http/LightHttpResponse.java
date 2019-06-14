package com.facebook.stetho.server.http;

public class LightHttpResponse extends LightHttpMessage {
    public LightHttpBody body;
    public int code;
    public String reasonPhrase;

    public void prepare() {
        if (this.body != null) {
            addHeader(HttpHeaders.CONTENT_TYPE, this.body.contentType());
            addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(this.body.contentLength()));
        }
    }

    public void reset() {
        super.reset();
        this.code = -1;
        this.reasonPhrase = null;
        this.body = null;
    }
}
