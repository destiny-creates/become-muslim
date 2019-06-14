package com.facebook.react.modules.network;

import expolib_v1.p321a.C6240u;
import expolib_v1.p321a.aa;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C6257r;
import expolib_v1.p332b.C7496d;

public class ProgressRequestBody extends aa {
    private long mContentLength = 0;
    private final ProgressListener mProgressListener;
    private final aa mRequestBody;

    public ProgressRequestBody(aa aaVar, ProgressListener progressListener) {
        this.mRequestBody = aaVar;
        this.mProgressListener = progressListener;
    }

    public C6240u contentType() {
        return this.mRequestBody.contentType();
    }

    public long contentLength() {
        if (this.mContentLength == 0) {
            this.mContentLength = this.mRequestBody.contentLength();
        }
        return this.mContentLength;
    }

    public void writeTo(C7496d c7496d) {
        c7496d = C6252l.a(outputStreamSink(c7496d));
        contentLength();
        this.mRequestBody.writeTo(c7496d);
        c7496d.flush();
    }

    private C6257r outputStreamSink(C7496d c7496d) {
        return C6252l.a(new CountingOutputStream(c7496d.c()) {
            public void write(byte[] bArr, int i, int i2) {
                super.write(bArr, i, i2);
                sendProgressUpdate();
            }

            public void write(int i) {
                super.write(i);
                sendProgressUpdate();
            }

            private void sendProgressUpdate() {
                long count = getCount();
                long contentLength = ProgressRequestBody.this.contentLength();
                ProgressRequestBody.this.mProgressListener.onProgress(count, contentLength, count == contentLength);
            }
        });
    }
}
