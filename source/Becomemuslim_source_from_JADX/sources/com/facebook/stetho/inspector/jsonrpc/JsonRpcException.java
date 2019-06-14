package com.facebook.stetho.inspector.jsonrpc;

import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;

public class JsonRpcException extends Exception {
    private final JsonRpcError mErrorMessage;

    public JsonRpcException(JsonRpcError jsonRpcError) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(jsonRpcError.code);
        stringBuilder.append(": ");
        stringBuilder.append(jsonRpcError.message);
        super(stringBuilder.toString());
        this.mErrorMessage = (JsonRpcError) Util.throwIfNull(jsonRpcError);
    }

    public JsonRpcError getErrorMessage() {
        return this.mErrorMessage;
    }
}
