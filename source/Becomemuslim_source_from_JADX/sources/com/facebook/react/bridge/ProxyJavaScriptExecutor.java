package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class ProxyJavaScriptExecutor extends JavaScriptExecutor {
    private JavaJSExecutor mJavaJSExecutor;

    public static class Factory implements JavaScriptExecutorFactory {
        private final com.facebook.react.bridge.JavaJSExecutor.Factory mJavaJSExecutorFactory;

        public Factory(com.facebook.react.bridge.JavaJSExecutor.Factory factory) {
            this.mJavaJSExecutorFactory = factory;
        }

        public JavaScriptExecutor create() {
            return new ProxyJavaScriptExecutor(this.mJavaJSExecutorFactory.create());
        }
    }

    private static native HybridData initHybrid(JavaJSExecutor javaJSExecutor);

    public String getName() {
        return "ProxyJavaScriptExecutor";
    }

    static {
        ReactBridge.staticInit();
    }

    public ProxyJavaScriptExecutor(JavaJSExecutor javaJSExecutor) {
        super(initHybrid(javaJSExecutor));
        this.mJavaJSExecutor = javaJSExecutor;
    }

    public void close() {
        if (this.mJavaJSExecutor != null) {
            this.mJavaJSExecutor.close();
            this.mJavaJSExecutor = null;
        }
    }
}
