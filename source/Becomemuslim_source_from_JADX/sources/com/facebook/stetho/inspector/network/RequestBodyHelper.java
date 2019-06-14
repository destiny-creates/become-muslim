package com.facebook.stetho.inspector.network;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.InflaterOutputStream;

public class RequestBodyHelper {
    private ByteArrayOutputStream mDeflatedOutput;
    private CountingOutputStream mDeflatingOutput;
    private final NetworkEventReporter mEventReporter;
    private final String mRequestId;

    public RequestBodyHelper(NetworkEventReporter networkEventReporter, String str) {
        this.mEventReporter = networkEventReporter;
        this.mRequestId = str;
    }

    public OutputStream createBodySink(String str) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        str = "gzip".equals(str) ? GunzippingOutputStream.create(byteArrayOutputStream) : "deflate".equals(str) != null ? new InflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream;
        this.mDeflatingOutput = new CountingOutputStream(str);
        this.mDeflatedOutput = byteArrayOutputStream;
        return this.mDeflatingOutput;
    }

    public byte[] getDisplayBody() {
        throwIfNoBody();
        return this.mDeflatedOutput.toByteArray();
    }

    public boolean hasBody() {
        return this.mDeflatedOutput != null;
    }

    public void reportDataSent() {
        throwIfNoBody();
        this.mEventReporter.dataSent(this.mRequestId, this.mDeflatedOutput.size(), (int) this.mDeflatingOutput.getCount());
    }

    private void throwIfNoBody() {
        if (!hasBody()) {
            throw new IllegalStateException("No body found; has createBodySink been called?");
        }
    }
}
