package com.facebook.stetho.inspector;

public class MismatchedResponseException extends MessageHandlingException {
    public long mRequestId;

    public MismatchedResponseException(long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Response for request id ");
        stringBuilder.append(j);
        stringBuilder.append(", but no such request is pending");
        super(stringBuilder.toString());
        this.mRequestId = j;
    }

    public long getRequestId() {
        return this.mRequestId;
    }
}
