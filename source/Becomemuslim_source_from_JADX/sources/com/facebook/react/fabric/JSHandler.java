package com.facebook.react.fabric;

import com.facebook.react.bridge.WritableMap;

public interface JSHandler {
    void invoke(long j, String str, WritableMap writableMap);
}
