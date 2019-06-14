package com.facebook.react.modules.network;

import expolib_v1.p321a.C6240u;
import expolib_v1.p321a.ac;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C6258s;
import expolib_v1.p332b.C7497e;
import expolib_v1.p332b.C7499h;
import expolib_v1.p332b.C8170c;

public class ProgressResponseBody extends ac {
    private C7497e mBufferedSource;
    private final ProgressListener mProgressListener;
    private final ac mResponseBody;
    private long mTotalBytesRead = null;

    public ProgressResponseBody(ac acVar, ProgressListener progressListener) {
        this.mResponseBody = acVar;
        this.mProgressListener = progressListener;
    }

    public C6240u contentType() {
        return this.mResponseBody.contentType();
    }

    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    public long totalBytesRead() {
        return this.mTotalBytesRead;
    }

    public C7497e source() {
        if (this.mBufferedSource == null) {
            this.mBufferedSource = C6252l.a(source(this.mResponseBody.source()));
        }
        return this.mBufferedSource;
    }

    private C6258s source(C6258s c6258s) {
        return new C7499h(c6258s) {
            public long read(C8170c c8170c, long j) {
                c8170c = super.read(c8170c, j);
                int i = (c8170c > -1 ? 1 : (c8170c == -1 ? 0 : -1));
                ProgressResponseBody.this.mTotalBytesRead = ProgressResponseBody.this.mTotalBytesRead + (i != 0 ? c8170c : 0);
                ProgressResponseBody.this.mProgressListener.onProgress(ProgressResponseBody.this.mTotalBytesRead, ProgressResponseBody.this.mResponseBody.contentLength(), i == 0);
                return c8170c;
            }
        };
    }
}
