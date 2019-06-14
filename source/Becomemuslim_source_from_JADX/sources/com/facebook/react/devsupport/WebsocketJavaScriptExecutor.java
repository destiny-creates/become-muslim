package com.facebook.react.devsupport;

import android.os.Handler;
import android.os.Looper;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.JavaJSExecutor.ProxyExecutorException;
import com.facebook.react.devsupport.JSDebuggerWebSocketClient.JSDebuggerCallback;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class WebsocketJavaScriptExecutor implements JavaJSExecutor {
    private static final int CONNECT_RETRY_COUNT = 3;
    private static final long CONNECT_TIMEOUT_MS = 5000;
    private final HashMap<String, String> mInjectedObjects = new HashMap();
    private JSDebuggerWebSocketClient mWebSocketClient;

    public interface JSExecutorConnectCallback {
        void onFailure(Throwable th);

        void onSuccess();
    }

    public static class WebsocketExecutorTimeoutException extends Exception {
        public WebsocketExecutorTimeoutException(String str) {
            super(str);
        }
    }

    private static class JSExecutorCallbackFuture implements JSDebuggerCallback {
        private Throwable mCause;
        private String mResponse;
        private final Semaphore mSemaphore;

        private JSExecutorCallbackFuture() {
            this.mSemaphore = new Semaphore(0);
        }

        public void onSuccess(String str) {
            this.mResponse = str;
            this.mSemaphore.release();
        }

        public void onFailure(Throwable th) {
            this.mCause = th;
            this.mSemaphore.release();
        }

        public String get() {
            this.mSemaphore.acquire();
            if (this.mCause == null) {
                return this.mResponse;
            }
            throw this.mCause;
        }
    }

    public void connect(final String str, final JSExecutorConnectCallback jSExecutorConnectCallback) {
        final AtomicInteger atomicInteger = new AtomicInteger(3);
        connectInternal(str, new JSExecutorConnectCallback() {
            public void onSuccess() {
                jSExecutorConnectCallback.onSuccess();
            }

            public void onFailure(Throwable th) {
                if (atomicInteger.decrementAndGet() <= 0) {
                    jSExecutorConnectCallback.onFailure(th);
                } else {
                    WebsocketJavaScriptExecutor.this.connectInternal(str, this);
                }
            }
        });
    }

    private void connectInternal(String str, final JSExecutorConnectCallback jSExecutorConnectCallback) {
        final JSDebuggerWebSocketClient jSDebuggerWebSocketClient = new JSDebuggerWebSocketClient();
        final Handler handler = new Handler(Looper.getMainLooper());
        jSDebuggerWebSocketClient.connect(str, new JSDebuggerCallback() {
            private boolean didSendResult = null;

            /* renamed from: com.facebook.react.devsupport.WebsocketJavaScriptExecutor$2$1 */
            class C38441 implements JSDebuggerCallback {
                C38441() {
                }

                public void onSuccess(String str) {
                    handler.removeCallbacksAndMessages(null);
                    WebsocketJavaScriptExecutor.this.mWebSocketClient = jSDebuggerWebSocketClient;
                    if (C38452.this.didSendResult == null) {
                        jSExecutorConnectCallback.onSuccess();
                        C38452.this.didSendResult = true;
                    }
                }

                public void onFailure(Throwable th) {
                    handler.removeCallbacksAndMessages(null);
                    if (!C38452.this.didSendResult) {
                        jSExecutorConnectCallback.onFailure(th);
                        C38452.this.didSendResult = true;
                    }
                }
            }

            public void onSuccess(String str) {
                jSDebuggerWebSocketClient.prepareJSRuntime(new C38441());
            }

            public void onFailure(Throwable th) {
                handler.removeCallbacksAndMessages(null);
                if (!this.didSendResult) {
                    jSExecutorConnectCallback.onFailure(th);
                    this.didSendResult = true;
                }
            }
        });
        handler.postDelayed(new Runnable() {
            public void run() {
                jSDebuggerWebSocketClient.closeQuietly();
                jSExecutorConnectCallback.onFailure(new WebsocketExecutorTimeoutException("Timeout while connecting to remote debugger"));
            }
        }, CONNECT_TIMEOUT_MS);
    }

    public void close() {
        if (this.mWebSocketClient != null) {
            this.mWebSocketClient.closeQuietly();
        }
    }

    public void loadApplicationScript(String str) {
        Object jSExecutorCallbackFuture = new JSExecutorCallbackFuture();
        ((JSDebuggerWebSocketClient) Assertions.assertNotNull(this.mWebSocketClient)).loadApplicationScript(str, this.mInjectedObjects, jSExecutorCallbackFuture);
        try {
            jSExecutorCallbackFuture.get();
        } catch (String str2) {
            ProxyExecutorException proxyExecutorException = new ProxyExecutorException(str2);
        }
    }

    public String executeJSCall(String str, String str2) {
        Object jSExecutorCallbackFuture = new JSExecutorCallbackFuture();
        ((JSDebuggerWebSocketClient) Assertions.assertNotNull(this.mWebSocketClient)).executeJSCall(str, str2, jSExecutorCallbackFuture);
        try {
            return jSExecutorCallbackFuture.get();
        } catch (String str3) {
            str2 = new ProxyExecutorException(str3);
        }
    }

    public void setGlobalVariable(String str, String str2) {
        this.mInjectedObjects.put(str, str2);
    }
}
