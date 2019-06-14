package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public interface JavaJSExecutor {

    public interface Factory {
        JavaJSExecutor create();
    }

    public static class ProxyExecutorException extends Exception {
        public ProxyExecutorException(Throwable th) {
            super(th);
        }
    }

    void close();

    @DoNotStrip
    String executeJSCall(String str, String str2);

    @DoNotStrip
    void loadApplicationScript(String str);

    @DoNotStrip
    void setGlobalVariable(String str, String str2);
}
